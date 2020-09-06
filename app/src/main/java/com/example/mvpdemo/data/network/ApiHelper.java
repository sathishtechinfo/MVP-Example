package com.example.mvpdemo.data.network;





import com.example.mvpdemo.data.network.model.MovieListResponse;
import com.example.mvpdemo.data.network.model.MovieResponse;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface ApiHelper {
    Single<List<MovieListResponse>> getPostApiCall();




}
