package com.example.mvpdemo.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.example.mvpdemo.di.ActivityContext;
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


   /* @Provides
    @PerActivity
    LoginPresenterMVPView<loginMVP> providesCancelListPresenter(
            LoginPresenter<loginMVP> presenter) {
        return presenter;
    }
    @Provides
    @PerActivity
    RouteListMvpPresenter<RouteListMvpView> providesRouteListPresenter(
            RouteListPresenter<RouteListMvpView> presenter) {
        return presenter;
    }
    @Provides
    @PerActivity
    SpinnerPresenterMVPView<SpinnerMVP> providesSpinnerListPresenter(
            SpinnerPresenter<SpinnerMVP> presenter) {
        return presenter;
    }
    @Provides
    PersonListAdapter providePersonInfoAdapter() {
        return new PersonListAdapter(new ArrayList<PersonResponse>());
    }*/
}
