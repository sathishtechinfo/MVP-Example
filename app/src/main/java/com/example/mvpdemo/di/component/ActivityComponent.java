package com.example.mvpdemo.di.component;




import com.example.mvpdemo.MainActivity;
import com.example.mvpdemo.di.PerActivity;
import com.example.mvpdemo.di.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {


    void inject(MainActivity activity);


}
