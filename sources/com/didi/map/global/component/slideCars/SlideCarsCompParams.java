package com.didi.map.global.component.slideCars;

import com.didi.map.global.component.slideCars.api.CarNavigatorRequest;
import com.didi.map.global.component.slideCars.model.ICarBitmapDescriptor;

public class SlideCarsCompParams {

    /* renamed from: a */
    private ICarBitmapDescriptor f26130a;

    /* renamed from: b */
    private int f26131b;

    /* renamed from: c */
    private CarNavigatorRequest f26132c;

    /* renamed from: d */
    private boolean f26133d = true;

    public boolean isShowSlidingCar() {
        return this.f26133d;
    }

    public void setShowSlidingCar(boolean z) {
        this.f26133d = z;
    }

    public ICarBitmapDescriptor getBitmapGetter() {
        return this.f26130a;
    }

    public void setBitmapGetter(ICarBitmapDescriptor iCarBitmapDescriptor) {
        this.f26130a = iCarBitmapDescriptor;
    }

    public int getPullIntervalMs() {
        return this.f26131b;
    }

    public void setPullIntervalMs(int i) {
        this.f26131b = i;
    }

    public CarNavigatorRequest getCarSlidingRequestParam() {
        return this.f26132c;
    }

    public void setCarSlidingRequestParam(CarNavigatorRequest carNavigatorRequest) {
        this.f26132c = carNavigatorRequest;
    }
}
