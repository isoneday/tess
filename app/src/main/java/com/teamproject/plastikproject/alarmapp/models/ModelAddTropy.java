package com.teamproject.plastikproject.alarmapp.models;

import com.google.gson.annotations.SerializedName;
public class ModelAddTropy{

	@SerializedName("Thropy")
	private int thropy;

	@SerializedName("Result")
	private String result;

	@SerializedName("Result_Code")
	private int resultCode;

	public void setThropy(int thropy){
		this.thropy = thropy;
	}

	public int getThropy(){
		return thropy;
	}

	public void setResult(String result){
		this.result = result;
	}

	public String getResult(){
		return result;
	}

	public void setResultCode(int resultCode){
		this.resultCode = resultCode;
	}

	public int getResultCode(){
		return resultCode;
	}
}