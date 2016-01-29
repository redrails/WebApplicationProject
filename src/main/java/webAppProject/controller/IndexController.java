package webAppProject.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webAppProject.domain.Request;
import webAppProject.domain.User;
import webAppProject.domain.Version;
import webAppProject.persistence.repository.RequestRepository;
import webAppProject.persistence.repository.UserRepository;
import webAppProject.persistence.repository.VersionRepository;
import webAppProject.persistence.services.CustomUserDetailsService;

@Controller
public class IndexController {
	private static final webAppProject.domain.Role Role = null;

	private String userRole;
	
	@Autowired RequestRepository requestRepository;
	@Autowired UserRepository userRepository;
	@Autowired VersionRepository versionRepository;
	
    @RequestMapping(value="/")
    
    public ModelAndView index(HttpSession session, HttpServletRequest request,  ModelMap   modelMap) {

        if (request.isUserInRole("PM")) {
        	ModelAndView modelAndView = new ModelAndView("portal");
        	org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        	modelAndView.addObject("username", user.getUsername());
        	modelAndView.addObject("user_pm", true);
        	this.userRole = "user_pm";        	
        	return modelAndView;
        } else if (request.isUserInRole("DEV")){
        	ModelAndView modelAndView = new ModelAndView("portal");
        	org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        	modelAndView.addObject("username", user.getUsername());
        	modelAndView.addObject("user_dev", true);
        	this.userRole = "user_dev";
        	return modelAndView;
        } else {
        	return new ModelAndView("error-message");
        }
    }
    
    @RequestMapping(value="/showSummary")
    public ModelAndView summary(){

    		ModelAndView modelAndView = new ModelAndView("showSummary");
    		List<Request> allRequests = (List<Request>) requestRepository.findAll();
    		modelAndView.addObject("listRequests", allRequests);
    		return modelAndView;
	}
    
    @RequestMapping(value="/evaluate-request")
    public ModelAndView evaluate(){

    		ModelAndView modelAndView = new ModelAndView("evaluate-request", "reqEval", new Request());
    		List<Request> nextPending = requestRepository.findByStatus("pending");
    		List<User> allUsers = (List<User>) userRepository.findAll();
    		List<User> allDevs = new ArrayList<>();
    		for(User usr:allUsers){
    			if(usr.getRole().getRole().equals("DEV")){
    				allDevs.add(usr);
    			}
    		}
    		try{
    			Request nextOne = nextPending.get(0);
        		modelAndView.addObject("nextReq", nextOne);
        		modelAndView.addObject("userList", allDevs);
        		return modelAndView;
    		} catch(Exception e){
    			modelAndView.addObject("nomore", true);
    			return modelAndView;
    		}
    }
    
    @RequestMapping(value="/complete-request")
    public ModelAndView complete(){

			ModelAndView modelAndView = new ModelAndView("complete-request", "reqComp", new Request());
			try{
				org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				List<Request> allAssigned = requestRepository.findByDeveloper(user.getUsername());
				List<Request> allPending = new ArrayList<>();
				for(Request requests: allAssigned){
					if(requests.getStatus().equals("accepted")){
						allPending.add(requests);
					}
				}
				if(allPending.size() == 0){
					modelAndView.addObject("nomore", true);
				} else {
					modelAndView.addObject("nextAss", allPending);
				}
			} catch(Exception r){}
			return modelAndView;
	}
    
    @RequestMapping(value="/new-request")
    public ModelAndView newRequest(){

    		ModelAndView modelAndView = new ModelAndView("new-request", "reqModel", new Request());
    		List<Version> allVersions = (List<Version>) versionRepository.findAll();
    		modelAndView.addObject("verList", allVersions);
    		return modelAndView;
	}
    
    @RequestMapping(value = "/manage-requests")
    public ModelAndView showTable() {
    	ModelAndView model = new ModelAndView("/manage-requests");
        Iterable<Request> request = requestRepository.findAll();
        model.addObject("request", request);
        Gson gson = new Gson();
        String json = gson.toJson(request);
        model.addObject("jsonProducts", json);
        return model;
    }
    
}