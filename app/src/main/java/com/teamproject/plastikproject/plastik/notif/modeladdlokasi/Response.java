package com.teamproject.plastikproject.plastik.notif.modeladdlokasi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response{

	@SerializedName("result")
	private Result result;

	@SerializedName("ops")
	private List<OpsItem> ops;

	@SerializedName("insertedIds")
	private InsertedIds insertedIds;

	@SerializedName("insertedCount")
	private int insertedCount;

	public void setResult(Result result){
		this.result = result;
	}

	public Result getResult(){
		return result;
	}

	public void setOps(List<OpsItem> ops){
		this.ops = ops;
	}

	public List<OpsItem> getOps(){
		return ops;
	}

	public void setInsertedIds(InsertedIds insertedIds){
		this.insertedIds = insertedIds;
	}

	public InsertedIds getInsertedIds(){
		return insertedIds;
	}

	public void setInsertedCount(int insertedCount){
		this.insertedCount = insertedCount;
	}

	public int getInsertedCount(){
		return insertedCount;
	}
}