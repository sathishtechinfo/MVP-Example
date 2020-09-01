package com.example.mvpdemo.data.network;


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



   /* @Override
    public Single<LoginResponse> getLoginApi(LoginRequest request) {
        return  Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINTLOGINPASSWORD).addJSONObjectBody(request.toJSON()).
                build().getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<List<PlaceListResponse>> getRoutListapi(PlaceListRequest request) {
        return  Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_PLACELIST).addJSONObjectBody(request.toJSON()).
                build().getObjectListSingle(PlaceListResponse.class);
    }

    @Override
    public Single<List<PersonResponse>> getPersonApiCall() {

            return  Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_PERSON).
                    build().getObjectListSingle(PersonResponse.class);

    }
*/
}

