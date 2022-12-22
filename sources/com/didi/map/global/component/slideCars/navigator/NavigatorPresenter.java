package com.didi.map.global.component.slideCars.navigator;

import android.content.Context;
import com.didi.map.global.component.slideCars.api.ApiType;
import com.didi.map.global.component.slideCars.api.CarNavigatorApiFactory;
import com.didi.map.global.component.slideCars.api.CarNavigatorRequest;
import com.didi.map.global.component.slideCars.api.ICarNavigatorCallback;

public class NavigatorPresenter {

    /* renamed from: a */
    private String f26191a = "BaseNavigator";

    /* renamed from: b */
    private Context f26192b;

    /* renamed from: c */
    private ApiType f26193c;

    public NavigatorPresenter(Context context, ApiType apiType) {
        this.f26192b = context;
        this.f26193c = apiType;
    }

    public void getCarNavigatorData(CarNavigatorRequest carNavigatorRequest, ICarNavigatorCallback iCarNavigatorCallback) {
        if (carNavigatorRequest != null) {
            m18548a(carNavigatorRequest, this.f26193c, iCarNavigatorCallback);
        }
    }

    /* renamed from: a */
    private void m18548a(CarNavigatorRequest carNavigatorRequest, ApiType apiType, ICarNavigatorCallback iCarNavigatorCallback) {
        Context context = this.f26192b;
        if (context != null) {
            CarNavigatorApiFactory.createCarNavigator(context, apiType).getCarNavigator(carNavigatorRequest, iCarNavigatorCallback);
        }
    }
}
