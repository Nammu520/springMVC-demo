package com.danlu.service;

import com.danlu.persist.entity.User;

public interface DemoService {
	public boolean checkLogin(String username,String password);
	
	public User selectByPrimaryKey(int id);
}
