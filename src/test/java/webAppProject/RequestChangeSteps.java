package webAppProject;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


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
import webAppProject.domain.SCI;
import webAppProject.domain.User;
import webAppProject.domain.Version;
import webAppProject.persistence.repository.RequestRepository;
import webAppProject.persistence.repository.SCIRepository;
import webAppProject.persistence.repository.UserRepository;
import webAppProject.persistence.repository.VersionRepository;
import webAppProject.SecurityConfig;
import webAppProject.WebConfig;

@WebAppConfiguration
@ContextConfiguration(classes = {webAppProjectApplication.class,SecurityConfig.class,WebConfig.class})
public class RequestChangeSteps {
	
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private RequestRepository reqRepo;
    
    @Autowired
    private VersionRepository versRepo;
    
    @Autowired
    private SCIRepository sciRepo;
    
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
    	versRepo.deleteAll();
    	sciRepo.deleteAll();

    }

    SCI sci;
    Version version;
    String problem, solution;
    
    @Given("^a SCI \"([^\"]*)\"$")
    public void a_SCI(String arg1) throws Throwable {
    	sci = new SCI();
    	sci.setName(arg1);
    	sciRepo.save(sci);
    }

    @Given("^a head version \"([^\"]*)\"$")
    public void a_head_version(String arg1) throws Throwable {
    	version = new Version();
    	version.setVersion(arg1);
    	version.setsci(sci);
    	versRepo.save(version);
    }

    @Given("^a problem description \"([^\"]*)\"$")
    public void a_problem_description(String arg1) throws Throwable {
    	problem = arg1;
    }

    @Given("^a proposed solution \"([^\"]*)\"$")
    public void a_proposed_solution(String arg1) throws Throwable {
    	solution = arg1;
    }

    @When("^I request a change request for reporting a fault$")
    public void i_request_a_change_request_for_reporting_a_fault() throws Throwable {
    	result = mockMvc.perform(post("/sendReq")
				.param("reqType", "fault")
				.param("version", version.getVersion())
				.param("problem", problem)
				.param("solution", solution));
    }

    @Then("^the system stores the fault request \"([^\"]*)\" for the head version \"([^\"]*)\" of \"([^\"]*)\" with solution \"([^\"]*)\"$")
    public void the_system_stores_the_fault_request_for_the_head_version_of_with_solution(String arg1, String arg2, String arg3, String arg4) throws Throwable {
    	Request r = reqRepo.findByProblem(arg1);
    	Assert.isTrue(r.getProblem().equals(arg1));
    	Assert.isTrue(r.getVersion().getVersion().equals(arg2));
    	Assert.isTrue(r.getSolution().equals(arg4));
    }

    @When("^I request a new feature$")
    public void i_request_a_new_feature() throws Throwable {
    	result = mockMvc.perform(post("/sendReq")
				.param("reqType", "fault")
				.param("version", version.getVersion())
				.param("problem", problem)
				.param("solution", solution));
    }

    @Then("^the system stores the new feature request \"([^\"]*)\" for the head version \"([^\"]*)\" of \"([^\"]*)\" with solution \"([^\"]*)\"$")
    public void the_system_stores_the_new_feature_request_for_the_head_version_of_with_solution(String arg1, String arg2, String arg3, String arg4) throws Throwable {
    	Request r = reqRepo.findByProblem(arg1);
    	Assert.isTrue(r.getProblem().equals(arg1));
    	Assert.isTrue(r.getVersion().getVersion().equals(arg2));
    	Assert.isTrue(r.getSolution().equals(arg4));
    }

    @Then("^The system shows a summary of the change request$")
    public void the_system_shows_a_summary_of_the_change_request() throws Throwable {
		result.andExpect(view().name("request-summary"));

    }

    
}
