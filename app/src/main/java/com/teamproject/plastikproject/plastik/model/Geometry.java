package com.teamproject.plastikproject.plastik.model;

import android.location.Location;

import com.google.gson.annotations.SerializedName;

public class Geometry{

//	@SerializedName("viewport")
//	private Viewport viewport;

	@SerializedName("location")
	private Location location;

	@SerializedName("location_type")
	private String locationType;
//
//	public void setViewport(Viewport viewport){
//		this.viewport = viewport;
//	}
//
//	public Viewport getViewport(){
//		return viewport;
//	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setLocationType(String locationType){
		this.locationType = locationType;
	}

	public String getLocationType(){
		return locationType;
	}


}