package webAppProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorizationController {
	
	@RequestMapping(value="/user-login", method=RequestMethod.GET)
	public ModelAndView loginForm() {
		return new ModelAndView("login-form");
	}

	@RequestMapping(value="/error-login", method=RequestMethod.GET)
	public ModelAndView invalidLogin() {
		ModelAndView modelAndView = new ModelAndView("login-form");
		modelAndView.addObject("error", true);
		return modelAndView;
	}
	
	@RequestMapping(value="/success-login", method=RequestMethod.GET)
	public ModelAndView successLogin() {
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value="/user-logout", method=RequestMethod.GET)
	public ModelAndView logout() {
		ModelAndView modelAndView = new ModelAndView("login-form");
		modelAndView.addObject("logout", true);
		return modelAndView;
	}
	
	@RequestMapping(value="/user-error", method=RequestMethod.GET)
	public String error() {
		return "/error-message";
	}
}