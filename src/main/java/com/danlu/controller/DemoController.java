package com.danlu.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.danlu.persist.entity.User;
import com.danlu.service.DemoService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Api(value = "demo", description = "用户登录")
@Controller
@RequestMapping("/danlu")
public class DemoController {

	@Autowired 
	private DemoService demoService;
	
	@ApiOperation(value = "用户登录", notes = "用户列表", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@ApiOperation(value = "用户验证", notes = "用户列表", httpMethod = "POST")
    @ResponseBody
	@RequestMapping(value="/success",method=RequestMethod.POST)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "header", dataType = "User", name = "id", value = "信息id", required = false) }) 
	public ModelAndView helloWorld(@RequestHeader HttpServletRequest request) {
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
	
	@ResponseBody
	@RequestMapping(value="/getUser",method=RequestMethod.POST)
	@ApiOperation(value="获取用户信息",response=User.class,httpMethod="POST")
	public User getUser(@ApiParam(required = true, name = "id", value = "用户码")@RequestParam(required = true ,value="id") String id1){
	    int id=1;
	    if(!StringUtils.isBlank(id1)){
	        id=Integer.parseInt(id1);
	        System.out.println("================");
	    }
	    User user = demoService.selectByPrimaryKey(id);
	    if(user!=null){
	        return user;
	    }
	    return null;
	}
	
	@ResponseBody
    @RequestMapping(value="/test",method=RequestMethod.POST)
	@ApiOperation(value="Test",response=User.class,httpMethod="POST")
    public String test(@RequestBody User user){
	    System.out.println(user.getUsername()+"========="+user);
        return "hhhhhhh";
    }
}
