package com.teamproject.plastikproject.alarmapp.models.modeladdlokasi;

import com.google.gson.annotations.SerializedName;

public class ModelAddlokasi{

	@SerializedName("response")
	private Response response;

	public void setResponse(Response response){
		this.response = response;
	}

	public Response getResponse(){
		return response;
	}
}