package webAppProject;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;


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
public class AssessChangeRequestSteps {
	
	@Autowired
    private WebApplicationContext wac;

    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private RequestRepository reqRepo;
    
    @Autowired
    private Filter springSecurityFilterChain;
    
    private MockMvc mockMvc;
    private ResultActions result, loginSess;
    private Authentication authentication;
    
    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders
        		.webAppContextSetup(this.wac)
        		.build();        
    }
   
    @After
    public void after(){
    	reqRepo.deleteAll();
    	userRepo.deleteAll();
    }

    private Request request;
    int size, oldSize;
    String probs;
   
	@Given("^the pending change request \"([^\"]*)\" in a list of pending requests$")
	public void the_pending_change_request_in_a_list_of_pending_requests(String arg1) throws Throwable {
		oldSize = reqRepo.findByStatus("pending").size();
		probs = arg1;
		request = new Request();
		request.setProblem(arg1);
		request.setSolution("solution");
		request.setReqType(arg1);
		reqRepo.save(request);
		size = reqRepo.findByStatus("pending").size();
	}

	@When("^I accept it with priority \"([^\"]*)\" for developer \"([^\"]*)\" with deadline \"([^\"]*)\"$")
	public void i_accept_it_with_priority_for_developer_with_deadline(String priority, String developer, String deadline) throws Throwable {
		result = mockMvc.perform(post("/evalRequest")
				.param("problem", probs)
				.param("status", "accepted")
				.param("priority", priority)
				.param("developer", developer)
				.param("deadline", deadline)
				.param("assessment",""));
	}

	@Then("^the change request \"([^\"]*)\" is accepted$")
	public void the_change_request_is_accepted(String arg1) throws Throwable {
		Request r = reqRepo.findByProblem(arg1);
		Assert.hasText("accepted", r.getStatus());
	}
	

	@Then("^removed from the list of pending requests$")
	public void removed_from_the_list_of_pending_requests() throws Throwable {
		Assert.isTrue(oldSize == (size-1));
	}

	@Then("^I should see the next pending request \\(if any\\)$")
	public void i_should_see_the_next_pending_request_if_any() throws Throwable {
		result.andExpect(redirectedUrl("/evaluate-request"));
	}

	@When("^I reject it with explanation \"([^\"]*)\"$")
	public void i_reject_it_with_explanation(String arg1) throws Throwable {
		//result = mockMvc.perform(post("/evalRequest").param("status", "rejected").param("assessment", arg1));
		result = mockMvc.perform(post("/evalRequest")
				.param("problem", probs)
				.param("status", "accepted")
				.param("priority", "")
				.param("developer", "")
				.param("deadline", "")
				.param("assessment",arg1));

	}

	@Then("^the change request \"([^\"]*)\" is rejected$")
	public void the_change_request_is_rejected(String arg1) throws Throwable {
		Request r = reqRepo.findByProblem(arg1);
		Assert.hasLength("rejected", r.getStatus());	
	}

	@Given("^I am assessing change requests$")
	public void i_am_assessing_change_requests() throws Throwable {
		result = mockMvc.perform(get("/evaluate-request"));
	}

	@When("^I request to cancel the assessment$")
	public void i_request_to_cancel_the_assessment() throws Throwable {
		result.andExpect(view().name("evaluate-request"));
		result = mockMvc.perform(get("/success-login"));

	}

	@Then("^I stop seeing change requests$")
	public void i_stop_seeing_change_requests() throws Throwable {
		result.andExpect(redirectedUrl("/"));
	}

}
