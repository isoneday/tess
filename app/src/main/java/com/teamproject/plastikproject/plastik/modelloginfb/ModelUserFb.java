package com.teamproject.plastikproject.plastik.modelloginfb;

import com.google.gson.annotations.SerializedName;


public class ModelUserFb{

	@SerializedName("response")
	private Responsefb response;

	public void setResponse(Responsefb response){
		this.response = response;
	}

	public Responsefb getResponse(){
		return response;
	}
}