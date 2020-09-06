package com.example.mvpdemo.ui.MovieList;

import androidx.annotation.NonNull;

import com.androidnetworking.error.ANError;
import com.example.mvpdemo.base.BasePresenter;
import com.example.mvpdemo.data.DataManager;
import com.example.mvpdemo.data.network.model.MovieListResponse;
import com.example.mvpdemo.data.network.model.MovieResponse;
import com.example.mvpdemo.utils.rx.SchedulerProvider;
import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import okhttp3.MediaType;

public class MovieListPresenter<V extends MovieListMvpView> extends BasePresenter<V>
        implements MovieListMvpPresenter<V> {

    @Inject
    public MovieListPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onPostDetails() {
        getMvpView().showLoading();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        Gson gson = new Gson();
        getCompositeDisposable().add(getDataManager()
                .getPostApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<MovieListResponse>>() {
                    @Override
                    public void accept(List<MovieListResponse> movieResponse)
                            throws Exception {

                        if (movieResponse != null ) {
                            getMvpView().updatepost(movieResponse);
                        }

                        getMvpView().hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }
}
