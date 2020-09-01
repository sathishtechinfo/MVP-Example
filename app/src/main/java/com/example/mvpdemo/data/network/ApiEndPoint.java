package com.example.mvpdemo.data.network;


import com.example.mvpdemo.BuildConfig;
import com.example.mvpdemo.appUtils.AppUtils;

public final class ApiEndPoint {

    public static final String ENDPOINTLOGINPASSWORD = BuildConfig.BASE_URLLOGIN
            + AppUtils.loginpwd;
    public static final String ENDPOINT_PLACELIST = BuildConfig.BASE_URL
            + AppUtils.busLocation;
    public static final String ENDPOINT_PERSON = BuildConfig.BASE_URL
            + AppUtils.person;

}

