package com.example.mvpdemo.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.example.mvpdemo.data.network.model.MovieListResponse;
import com.example.mvpdemo.data.network.model.MoviesItem;
import com.example.mvpdemo.di.ActivityContext;
import com.example.mvpdemo.di.PerActivity;
import com.example.mvpdemo.ui.MovieList.MovieListMvpPresenter;
import com.example.mvpdemo.ui.MovieList.MovieListMvpView;
import com.example.mvpdemo.ui.MovieList.MovieListPresenter;
import com.example.mvpdemo.ui.UsersRecyclerAdapter;
import com.example.mvpdemo.utils.rx.AppSchedulerProvider;
import com.example.mvpdemo.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return activity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideScheduleProvider() {
        return new AppSchedulerProvider ();
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager (activity);
    }


    @Provides
    @PerActivity
    MovieListMvpPresenter<MovieListMvpView> providesMovieListPresenter(
            MovieListPresenter<MovieListMvpView> presenter) {
        return presenter;
    }
    @Provides
    UsersRecyclerAdapter providePersonInfoAdapter() {
        return new UsersRecyclerAdapter(activity,new ArrayList<MovieListResponse>());
    }
}
