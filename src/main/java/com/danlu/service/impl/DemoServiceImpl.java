package com.danlu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danlu.core.DemoManager;
import com.danlu.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService{
	
	@Autowired
	DemoManager demoManager;
	public boolean checkLogin(String username,String password)
	{
		return demoManager.checkLogin(username, password);
	}
	public void test(){
		System.out.println("i am test");
	}
}