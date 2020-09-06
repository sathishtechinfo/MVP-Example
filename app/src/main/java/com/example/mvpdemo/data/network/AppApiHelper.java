package com.example.mvpdemo.data.network;


import com.example.mvpdemo.data.network.model.MovieListResponse;
import com.example.mvpdemo.data.network.model.MovieResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AppApiHelper implements ApiHelper {

    @Inject
    public AppApiHelper() {
    }

    @Override
    public Single<List<MovieListResponse>> getPostApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_MOVIELIST).
                build().getObjectListSingle(MovieListResponse.class);
    }
}

