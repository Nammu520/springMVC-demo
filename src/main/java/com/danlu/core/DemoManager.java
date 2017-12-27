package com.danlu.core;

import com.danlu.persist.entity.User;

public interface DemoManager {
	public boolean checkLogin(String username,String password);
	
	public User selectByPrimaryKey(int id);
}
