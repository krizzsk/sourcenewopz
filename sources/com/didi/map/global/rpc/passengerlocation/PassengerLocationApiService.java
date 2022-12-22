package com.didi.map.global.rpc.passengerlocation;

import android.content.Context;
import com.didi.map.global.rpc.callback.MapRequestCallback;
import com.didi.map.global.rpc.callback.MapRpcCallback;
import com.didi.map.global.rpc.passengerlocation.IPassengerLocationApiService;
import com.didi.map.global.rpc.service.MapHttpService;
import com.didi.map.sdk.proto.driver_gl.UserLocationReq;

public class PassengerLocationApiService extends MapHttpService implements IPassengerLocationApiService {
    public static final String PASSENGER_LOCATION = "https://apimap.didiglobal.com/navi/v1/userlocation/";

    /* renamed from: a */
    private IPassengerLocationApiService.IPassengerLocationRpcService f27353a = ((IPassengerLocationApiService.IPassengerLocationRpcService) getService(IPassengerLocationApiService.IPassengerLocationRpcService.class, "https://apimap.didiglobal.com/navi/v1/userlocation/"));

    public PassengerLocationApiService(Context context) {
        super(context);
    }

    public void requestPassengerLocation(UserLocationReq userLocationReq, MapRequestCallback<UserLocationResWrapper> mapRequestCallback) {
        this.f27353a.requestPassengerLocation(userLocationReq.toByteArray(), new MapRpcCallback<UserLocationResWrapper>(mapRequestCallback) {
        });
    }
}
