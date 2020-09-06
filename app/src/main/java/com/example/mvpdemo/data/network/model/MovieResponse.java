package com.example.mvpdemo.data.network.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MovieResponse{

	@SerializedName("movies")
	private List<MoviesItem> movies;

	@SerializedName("total_records")
	private int totalRecords;

	@SerializedName("status")
	private boolean status;

	public List<MoviesItem> getMovies(){
		return movies;
	}

	public int getTotalRecords(){
		return totalRecords;
	}

	public boolean isStatus(){
		return status;
	}
}