package com.didi.map.global.component.departure.controller;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.departure.fence.FenceController;
import com.didi.map.global.component.departure.model.DepartureAddress;

public class DepartureControllerParams {

    /* renamed from: a */
    private Context f25026a;

    /* renamed from: b */
    private Map f25027b;

    /* renamed from: c */
    private boolean f25028c;

    /* renamed from: d */
    private LatLng f25029d;

    /* renamed from: e */
    private FenceController f25030e;

    /* renamed from: f */
    private int f25031f;

    public DepartureControllerParams(Context context, Map map, int i, boolean z, LatLng latLng, DepartureAddress departureAddress, FenceController fenceController) {
        this.f25026a = context;
        this.f25027b = map;
        this.f25028c = z;
        this.f25029d = latLng;
        this.f25030e = fenceController;
        this.f25031f = i;
    }

    public Context getContext() {
        return this.f25026a;
    }

    public Map getMap() {
        return this.f25027b;
    }

    public boolean isHasWayPoint() {
        return this.f25028c;
    }

    public LatLng getEndPoint() {
        return this.f25029d;
    }

    public FenceController getFenceController() {
        return this.f25030e;
    }

    public int getSceneType() {
        return this.f25031f;
    }
}
