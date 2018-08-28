package com.teamproject.plastikproject.plastik.modelloginfb;

import com.google.gson.annotations.SerializedName;


public class Responsefb{

	@SerializedName("id")
	private String id;

	@SerializedName("is_admin")
	private String isAdmin;

	@SerializedName("result")
	private String result;

	@SerializedName("password")
	private String password;

	@SerializedName("resulttext")
	private String resulttext;

	@SerializedName("name")
	private String name;

	@SerializedName("resultcode")
	private int resultcode;

	@SerializedName("email")
	private String email;

	public Responsefb(String uid, String name, String email) {
		id=uid;
		this.name=name;
		this.email=email;
	}

	public void setIsAdmin(String isAdmin){
		this.isAdmin = isAdmin;
	}

	public String getIsAdmin(){
		return isAdmin;
	}

	public void setResult(String result){
		this.result = result;
	}

	public String getResult(){
		return result;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setResulttext(String resulttext){
		this.resulttext = resulttext;
	}

	public String getResulttext(){
		return resulttext;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setResultcode(int resultcode){
		this.resultcode = resultcode;
	}

	public int getResultcode(){
		return resultcode;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}