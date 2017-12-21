package com.danlu.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.danlu.service.DemoService;


@Controller
@RequestMapping("/danlu")
public class DemoController {

	@Autowired 
	private DemoService demoService;
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping("/success")
	public ModelAndView helloWorld(HttpServletRequest request) {
		ModelAndView mav;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean flag = demoService.checkLogin(username, password);
		if(flag)
		{
		   mav = new ModelAndView("index");
		   mav.addObject("username", username);
		}
		else {
			mav = new ModelAndView("fail");
		}
		return mav;
	}
}
