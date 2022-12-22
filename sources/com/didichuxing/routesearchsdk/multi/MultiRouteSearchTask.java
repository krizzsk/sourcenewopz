package com.didichuxing.routesearchsdk.multi;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.didi.common.map.util.NetUtils;
import com.didi.map.sdk.proto.driver_gl.MultiRoutePlanReq;
import com.didi.map.sdk.proto.driver_gl.MultiRoutePlanRes;
import com.didi.map.sdk.proto.driver_gl.SingleRouteReq;
import com.didichuxing.routesearchsdk.RouteSearchUrls;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;

public class MultiRouteSearchTask extends AsyncTask<MultiRouteSearchParam, Integer, MultiRoutePlanRes> {

    /* renamed from: a */
    private IMultiRouteSearchCallback f48559a;

    /* renamed from: b */
    private String f48560b = "";

    /* renamed from: c */
    private int f48561c;

    public MultiRouteSearchTask(int i, IMultiRouteSearchCallback iMultiRouteSearchCallback) {
        this.f48559a = iMultiRouteSearchCallback;
        this.f48561c = i;
    }

    public MultiRouteSearchTask(IMultiRouteSearchCallback iMultiRouteSearchCallback) {
        this.f48559a = iMultiRouteSearchCallback;
    }

    /* access modifiers changed from: protected */
    public MultiRoutePlanRes doInBackground(MultiRouteSearchParam... multiRouteSearchParamArr) {
        if (multiRouteSearchParamArr == null || multiRouteSearchParamArr.length <= 0) {
            this.f48560b = "request param is null";
            return null;
        }
        this.f48560b = "";
        try {
            byte[] doPost = NetUtils.doPost(m34802a(), m34804a(multiRouteSearchParamArr[0]));
            if (doPost != null) {
                return (MultiRoutePlanRes) new Wire((Class<?>[]) new Class[0]).parseFrom(doPost, MultiRoutePlanRes.class);
            }
            this.f48560b = "response is null";
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            this.f48560b = e.toString();
        }
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        IMultiRouteSearchCallback iMultiRouteSearchCallback = this.f48559a;
        if (iMultiRouteSearchCallback != null) {
            iMultiRouteSearchCallback.onBeginToSearch();
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(MultiRoutePlanRes multiRoutePlanRes) {
        IMultiRouteSearchCallback iMultiRouteSearchCallback = this.f48559a;
        if (iMultiRouteSearchCallback != null) {
            iMultiRouteSearchCallback.onFinishToSearch(multiRoutePlanRes, this.f48560b);
            this.f48559a.onFinishToSearch(multiRoutePlanRes, this.f48560b, this.f48561c);
        }
    }

    /* renamed from: a */
    private String m34802a() {
        return RouteSearchUrls.getMultiRoutePlanUrl();
    }

    /* renamed from: a */
    private byte[] m34804a(MultiRouteSearchParam multiRouteSearchParam) {
        if (multiRouteSearchParam == null) {
            return null;
        }
        String str = "";
        MultiRoutePlanReq.Builder caller = new MultiRoutePlanReq.Builder().routeReq(m34803a(multiRouteSearchParam.getRouteReq())).token(multiRouteSearchParam.getToken()).productId(multiRouteSearchParam.getProductId()).phoneNum(TextUtils.isEmpty(multiRouteSearchParam.getPhoneNum()) ? str : multiRouteSearchParam.getPhoneNum()).caller(multiRouteSearchParam.getCaller() != null ? multiRouteSearchParam.getCaller().toString() : str);
        if (!TextUtils.isEmpty(multiRouteSearchParam.getCountryId())) {
            str = multiRouteSearchParam.getCountryId();
        }
        return caller.countryId(str).passengerId(Long.valueOf(multiRouteSearchParam.getPassengerId())).orderStage(Integer.valueOf(multiRouteSearchParam.getOrderStage())).didiVersion(multiRouteSearchParam.getDidiVersion()).orderId(multiRouteSearchParam.getOrderId()).build().toByteArray();
    }

    /* renamed from: a */
    private List<SingleRouteReq> m34803a(List<SingleRouteReqParam> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (SingleRouteReqParam next : list) {
                if (next != null) {
                    arrayList.add(new SingleRouteReq(next.getStart(), next.getEnd(), next.getWayPoints(), next.getTravelMode(), Integer.valueOf(next.getExpectStyle())));
                }
            }
        }
        return arrayList;
    }
}
