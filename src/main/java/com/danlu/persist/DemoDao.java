package com.danlu.persist;

import org.apache.ibatis.annotations.Param;

import com.danlu.persist.entity.User;

public interface DemoDao {
	 int deleteByPrimaryKey(Integer id);

	 int insert(User record);

	    int insertSelective(User record);

	    User selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(User record);

	    int updateByPrimaryKey(User record);
	    
	    int selectByUsername(@Param("username")String username,@Param("password")String password);
	 }
