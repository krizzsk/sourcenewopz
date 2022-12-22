package com.didi.map.global.flow.scene.order.confirm.normal;

import android.view.View;
import com.didi.map.global.flow.scene.CarSlidingParam;
import com.didi.map.global.flow.scene.minibus.param.MiniBusParamInterface;
import com.didi.map.global.flow.scene.order.confirm.RoutePlanParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import java.util.List;

public class CarLevelParam {

    /* renamed from: a */
    private CircleParam f26627a;

    /* renamed from: b */
    private View f26628b;

    /* renamed from: c */
    private CarSlidingParam f26629c;

    /* renamed from: d */
    private RoutePlanParam f26630d;

    /* renamed from: e */
    private MiniBusParamInterface f26631e;

    /* renamed from: f */
    private List<CommonMarkerParam> f26632f;

    /* renamed from: g */
    private int f26633g = 0;

    public CircleParam getCircleParam() {
        return this.f26627a;
    }

    public void setCircleParam(CircleParam circleParam) {
        this.f26627a = circleParam;
    }

    public View getViewTip() {
        return this.f26628b;
    }

    public void setViewTip(View view) {
        this.f26628b = view;
    }

    public CarSlidingParam getCarSlidingParam() {
        return this.f26629c;
    }

    public void setCarSlidingParam(CarSlidingParam carSlidingParam) {
        this.f26629c = carSlidingParam;
    }

    public RoutePlanParam getRoutePlanParam() {
        return this.f26630d;
    }

    public void setRoutePlanParam(RoutePlanParam routePlanParam) {
        this.f26630d = routePlanParam;
    }

    public MiniBusParamInterface getMiniBusParamInterface() {
        return this.f26631e;
    }

    public void setMiniBusParamInterface(MiniBusParamInterface miniBusParamInterface) {
        this.f26631e = miniBusParamInterface;
    }

    public List<CommonMarkerParam> getMarkerParams() {
        return this.f26632f;
    }

    public void setMarkerParams(List<CommonMarkerParam> list) {
        this.f26632f = list;
    }

    public void setSceneType(int i) {
        this.f26633g = i;
    }

    public int getSceneType() {
        return this.f26633g;
    }
}
