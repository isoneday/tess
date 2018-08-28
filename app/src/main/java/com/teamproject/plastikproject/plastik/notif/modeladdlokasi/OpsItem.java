package com.teamproject.plastikproject.plastik.notif.modeladdlokasi;

import com.google.gson.annotations.SerializedName;

public class OpsItem{

	@SerializedName("area")
	private Area area;

	@SerializedName("timeStamp")
	private String timeStamp;

	@SerializedName("id_increment")
	private int idIncrement;

	@SerializedName("description")
	private String description;

	@SerializedName("_id")
	private String id;

	public void setArea(Area area){
		this.area = area;
	}

	public Area getArea(){
		return area;
	}

	public void setTimeStamp(String timeStamp){
		this.timeStamp = timeStamp;
	}

	public String getTimeStamp(){
		return timeStamp;
	}

	public void setIdIncrement(int idIncrement){
		this.idIncrement = idIncrement;
	}

	public int getIdIncrement(){
		return idIncrement;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}
}