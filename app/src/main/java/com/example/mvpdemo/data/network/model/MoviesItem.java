package com.example.mvpdemo.data.network.model;

import com.google.gson.annotations.SerializedName;

public class MoviesItem{

	@SerializedName("image")
	private String image;

	@SerializedName("ratting")
	private int ratting;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public String getImage(){
		return image;
	}

	public int getRatting(){
		return ratting;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}
}