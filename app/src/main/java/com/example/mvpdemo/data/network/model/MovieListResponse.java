package com.example.mvpdemo.data.network.model;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class MovieListResponse {

	@SerializedName("id")
	private String id;

	@SerializedName("image")
	private String image;

	@SerializedName("title")
	private String title;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
 	public String toString(){
		return 
			"ProResponse{" + 

			",id = '" + id + '\'' + 
			",image = '" + image + '\'' +
			",title = '" + title + '\'' +

			"}";
		}
}