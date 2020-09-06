package com.example.mvpdemo.ui.MovieList;


import com.example.mvpdemo.base.MvpPresenter;

public interface MovieListMvpPresenter<V extends MovieListMvpView> extends MvpPresenter<V> {

    void onPostDetails();

}
