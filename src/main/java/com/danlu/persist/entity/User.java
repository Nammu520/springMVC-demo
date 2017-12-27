package com.danlu.persist.entity;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(description="�û�ʵ����")
public class User implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(hidden=true)
	 private Integer id;

    @ApiModelProperty("�û���")
	    private String username;

    @ApiModelProperty("����")
	    private String password;

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username == null ? null : username.trim();
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password == null ? null : password.trim();
	    }
}
