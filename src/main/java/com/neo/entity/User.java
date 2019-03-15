package com.neo.entity;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String userName;
	private String passWord;
	private String userSex;
	private String nickName;


	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id"+this.id+",userName " + this.userName + ", passWord " + this.passWord + "userSex " + this.userSex+",nickName"+this.nickName;
	}
}