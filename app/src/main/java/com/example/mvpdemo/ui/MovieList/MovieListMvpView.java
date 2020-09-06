package com.example.mvpdemo.ui.MovieList;


import com.example.mvpdemo.base.MvpView;
import com.example.mvpdemo.data.network.model.MovieListResponse;
import com.example.mvpdemo.data.network.model.MovieResponse;

import java.util.List;


public interface MovieListMvpView extends MvpView {


    void updatepost(List<MovieListResponse> movieResponse);
}
