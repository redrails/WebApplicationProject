package webAppProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import webAppProject.domain.Request;
import webAppProject.domain.Version;
import webAppProject.persistence.repository.RequestRepository;
import webAppProject.persistence.repository.VersionRepository;

@Controller
public class RequestController {
	
	@Autowired
	RequestRepository reqRepository;
	
	@Autowired
	VersionRepository versRepository;
	
	/*
	@RequestMapping(method = RequestMethod.POST, value="sendReq")
	public String addRequest(@ModelAttribute("sendReq")Request request) {
		reqRepository.save(request);
		return "/success-login";
	}*/
	
	@RequestMapping(method = RequestMethod.POST, value="sendReq")
	public ModelAndView addRequest(
			@RequestParam("reqType")String type,
			@RequestParam("version")String version,
			@RequestParam("problem")String problem,
			@RequestParam("solution")String solution
			){
		
		Version v = versRepository.findByVersion(version);
		
		Request request = new Request();
		request.setReqType(type);
		request.setVersion(v);
		request.setProblem(problem);
		request.setSolution(solution);
		reqRepository.save(request);
		ModelAndView modelAndView = new ModelAndView("request-summary");
		modelAndView.addObject("request", request);
		return modelAndView;
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value="evalRequest")
	public String evaluateRequest(
			@RequestParam("problem")String problem,
			@RequestParam("deadline")String deadline,
			@RequestParam("priority")String priority,
			@RequestParam("status")String status,
			@RequestParam("developer")String developer,
			@RequestParam("assessment")String assessment
			){
		//Request r = reqRepository.findById(reqId);
		Request r = reqRepository.findByProblem(problem);
		r.setAssessment(assessment);
		r.setDeadline(deadline);
		r.setStatus(status);
		r.setDeveloper(developer);
		r.setPriority(priority);
		reqRepository.save(r);
		return "redirect:/evaluate-request";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="completeRequest")
	public String completeRequest(
			@RequestParam("problem")String problem,
			@RequestParam("completion")String reqComp			
			){
		Request r = reqRepository.findByProblem(problem);
		r.setCompletion(reqComp);
		reqRepository.save(r);
		return "/success-login";
	}
	
	@RequestMapping(value="/sendManaged",method=RequestMethod.POST)
	public @ResponseBody String 
	    updateRequest(@RequestBody Request request) {
	    reqRepository.save(request);        
	    return "/showSummary";
	} 
	
}
