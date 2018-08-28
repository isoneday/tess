package com.teamproject.plastikproject.plastik.notif.modeladdlokasi;

import com.google.gson.annotations.SerializedName;

public class Result{

	@SerializedName("ok")
	private int ok;

	@SerializedName("n")
	private int N;

	public void setOk(int ok){
		this.ok = ok;
	}

	public int getOk(){
		return ok;
	}

	public void setN(int N){
		this.N = N;
	}

	public int getN(){
		return N;
	}
}