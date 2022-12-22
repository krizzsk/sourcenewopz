package com.didi.map.global.component.line.data.route;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.data.IRouteSearchResultCallback;
import com.didi.map.global.component.line.data.param.BaseLineRequest;
import com.didi.map.global.component.line.data.param.LineDataResponse;
import com.didi.map.sdk.proto.driver_gl.BubblePageRes;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.MultiRoutePlanRes;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.map.sdk.proto.driver_gl.OrderTrajResponse;
import com.didi.map.sdk.proto.driver_gl.RoutePlanRes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseLineRoute<T extends BaseLineRequest> implements IRoute<T> {

    /* renamed from: a */
    private Context f25818a;

    /* renamed from: b */
    private boolean f25819b = false;

    /* renamed from: c */
    private String f25820c = "BaseLineRoute";

    /* renamed from: d */
    private boolean f25821d = true;

    public abstract void start(T t, IRouteSearchResultCallback iRouteSearchResultCallback);

    public boolean isDestroy() {
        return this.f25819b;
    }

    public Context getContext() {
        return this.f25818a;
    }

    public List<OdPoint> convertToOdPoints(List<LatLng> list) {
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (LatLng convertToDoublePoint : list) {
            arrayList.add(new OdPoint(0L, 0, convertToDoublePoint(convertToDoublePoint), "", 0, Float.valueOf(0.0f), 0, (DoublePoint) null, (String) null));
        }
        return arrayList;
    }

    public DoublePoint convertToDoublePoint(LatLng latLng) {
        if (latLng != null) {
            return new DoublePoint.Builder().lat(Float.valueOf((float) latLng.latitude)).lng(Float.valueOf((float) latLng.longitude)).build();
        }
        return null;
    }

    public boolean checkCommonParamIsRight(T t, IRouteSearchResultCallback iRouteSearchResultCallback) {
        if (t == null) {
            DLog.m7384d(this.f25820c, "param is null", new Object[0]);
            return false;
        } else if (iRouteSearchResultCallback == null) {
            DLog.m7384d(this.f25820c, "lineSearchCallback is null", new Object[0]);
            return false;
        } else if (getContext() != null) {
            return true;
        } else {
            DLog.m7384d(this.f25820c, "context is null", new Object[0]);
            return false;
        }
    }

    public LineDataResponse packageResponse(Object obj) {
        LineDataResponse lineDataResponse = new LineDataResponse();
        if (obj instanceof RoutePlanRes) {
            lineDataResponse.setRoutePlanRes((RoutePlanRes) obj);
            return lineDataResponse;
        } else if (obj instanceof MultiRoutePlanRes) {
            lineDataResponse.setMultiRoutePlanRes((MultiRoutePlanRes) obj);
            return lineDataResponse;
        } else if (obj instanceof OrderTrajResponse) {
            lineDataResponse.setOrderTrajResponse((OrderTrajResponse) obj);
            return lineDataResponse;
        } else if (!(obj instanceof BubblePageRes)) {
            return null;
        } else {
            lineDataResponse.setBubblePageRes((BubblePageRes) obj);
            return lineDataResponse;
        }
    }

    public void create(Context context) {
        this.f25818a = context;
    }

    public void destroy() {
        this.f25819b = true;
    }

    public void setCacheEnable(boolean z) {
        this.f25821d = z;
    }

    public boolean isCacheEnable() {
        return this.f25821d;
    }
}
