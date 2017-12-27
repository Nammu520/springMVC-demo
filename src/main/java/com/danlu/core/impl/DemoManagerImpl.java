package com.danlu.core.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.danlu.core.DemoManager;
import com.danlu.persist.DemoDao;
import com.danlu.persist.entity.User;

public class DemoManagerImpl implements DemoManager {
	
	@Autowired
	DemoDao userDao;
	public boolean checkLogin(String username,String password)
	{
		return userDao.selectByUsername(username, password) > 0 ? true : false;
	}
	
	public User selectByPrimaryKey(int id){
	    return userDao.selectByPrimaryKey(id);
	}
}
