package webAppProject;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import webAppProject.webAppProjectApplication;
import webAppProject.domain.Request;
import webAppProject.domain.Role;
import webAppProject.domain.User;
import webAppProject.persistence.repository.RequestRepository;
import webAppProject.persistence.repository.UserRepository;
import webAppProject.SecurityConfig;
import webAppProject.WebConfig;

@WebAppConfiguration
@ContextConfiguration(classes = {webAppProjectApplication.class,SecurityConfig.class,WebConfig.class})
public class CompleteRequestSteps {
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private RequestRepository reqRepo;
    
    @Autowired
    private Filter springSecurityFilterChain;
    
    private MockMvc mockMvc;
    private ResultActions result;
    private Authentication authentication;
    
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders
        		.webAppContextSetup(this.wac)
        		.build();
    }

    @After
    public void after(){
    	reqRepo.deleteAll();
    	userRepo.deleteAll();
    	reqRepo.deleteAll();
    }
    
    private User user;
    private Request req,req2;
    
    
	@Given("^I am logged in as \"([^\"]*)\"$")
	public void i_am_logged_in_as(String arg1) throws Throwable {
		user = new User();
		user.setLogin(arg1);
		userRepo.save(user);
	}

	@Given("^an approved change request \"([^\"]*)\"$")
	public void an_approved_change_request(String arg1) throws Throwable {
		req = new Request();
		req.setStatus("accepted");
		req.setReqType(arg1);
		req.setProblem("problem");
		req.setSolution("solution");	
		req.setDeveloper(user.getLogin());
		reqRepo.save(req);
	}

	@When("^I complete the task with data \"([^\"]*)\"$")
	public void i_complete_the_task_with_data(String arg1) throws Throwable {
		mockMvc.perform(post("/completeRequest").param("problem", "problem").param("completion", arg1));
		//req.setStatus("complete");
	}

	@Then("^the change request \"([^\"]*)\" is removed from my list$")
	public void the_change_request_is_removed_from_my_list(String arg1) throws Throwable {
		Request r = reqRepo.findByreqType(arg1);
		Assert.isTrue(r.getStatus().equals("complete"));
	}

	@Then("^I should get the next approved request allocated to me$")
	public void i_should_get_the_next_approved_request_allocated_to_me() throws Throwable {
		mockMvc.perform(get("/complete-request"));
	}
}
