package com.dmap.navigation.jni.sub;

import com.dmap.navigation.api.core.INaviPlannerInner;
import com.dmap.navigation.jni.swig.NaviInfo;
import com.dmap.navigation.jni.swig.RequestInfo;

public class NaviInfoNative extends NaviInfo implements INaviPlannerInner.INaviRequest {

    /* renamed from: a */
    private RequestInfo f52022a;

    public void setRequestInfo(RequestInfo requestInfo) {
        this.f52022a = requestInfo;
    }

    public String getTraceId() {
        return this.f52022a.getTraceId();
    }
}
