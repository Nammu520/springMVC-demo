package com.danlu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.danlu.service.DemoService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Api(value = "demo", description = "用户登录", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("/danlu")
public class DemoController {

	@Autowired 
	private DemoService demoService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(){
		return "login";
	}
	
	@ApiOperation(value = "用户验证", notes = "用户列表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	@RequestMapping(value="/success",method=RequestMethod.POST)
	public ModelAndView helloWorld(@ApiParam(value = "HttpServletRequest") @RequestParam(required = false)HttpServletRequest request) {
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
