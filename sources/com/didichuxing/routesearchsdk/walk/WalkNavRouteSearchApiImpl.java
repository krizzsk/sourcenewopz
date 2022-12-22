package com.didichuxing.routesearchsdk.walk;

import android.os.AsyncTask;
import com.didi.common.map.util.NetUtils;
import com.didi.map.sdk.proto.driver_gl.OrderWalkingReq;
import com.didi.map.sdk.proto.driver_gl.OrderWalkingRes;
import com.didichuxing.routesearchsdk.CallFrom;
import com.didichuxing.routesearchsdk.RouteSearchUrls;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didichuxing/routesearchsdk/walk/WalkNavRouteSearchApiImpl;", "Lcom/didichuxing/routesearchsdk/walk/IWalkNavRouteSearchApi;", "()V", "walkNavRouteSearchTask", "Lcom/didichuxing/routesearchsdk/walk/WalkNavRouteSearchApiImpl$WalkNavRouteSearchTask;", "calculateRoute", "", "param", "Lcom/didichuxing/routesearchsdk/walk/WalkNavRouteSearchParam;", "callback", "Lcom/didichuxing/routesearchsdk/walk/WalkNavRouteSearchCallback;", "cancelRequest", "getRoutePlanReqBytes", "", "WalkNavRouteSearchTask", "RouteSearchSDK_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalkNavRouteSearchApiImpl.kt */
public final class WalkNavRouteSearchApiImpl implements IWalkNavRouteSearchApi {

    /* renamed from: a */
    private WalkNavRouteSearchTask f48567a;

    public void calculateRoute(WalkNavRouteSearchParam walkNavRouteSearchParam, WalkNavRouteSearchCallback walkNavRouteSearchCallback) {
        Intrinsics.checkNotNullParameter(walkNavRouteSearchParam, "param");
        Intrinsics.checkNotNullParameter(walkNavRouteSearchCallback, "callback");
        String checkParam = walkNavRouteSearchParam.checkParam();
        if (checkParam != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.CHINA, "param %s can not be null!", Arrays.copyOf(new Object[]{checkParam}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            walkNavRouteSearchCallback.onFinishToSearch((OrderWalkingRes) null, format);
            return;
        }
        byte[] a = m34805a(walkNavRouteSearchParam);
        if (a != null) {
            WalkNavRouteSearchTask walkNavRouteSearchTask = new WalkNavRouteSearchTask(walkNavRouteSearchCallback);
            this.f48567a = walkNavRouteSearchTask;
            if (walkNavRouteSearchTask != null) {
                walkNavRouteSearchTask.execute((Object[]) new byte[][]{a});
            }
        }
    }

    public void cancelRequest() {
        WalkNavRouteSearchTask walkNavRouteSearchTask = this.f48567a;
        if (walkNavRouteSearchTask != null) {
            walkNavRouteSearchTask.cancelRequest();
        }
    }

    /* renamed from: a */
    private final byte[] m34805a(WalkNavRouteSearchParam walkNavRouteSearchParam) {
        String str = null;
        if (walkNavRouteSearchParam == null) {
            return null;
        }
        OrderWalkingReq.Builder sdkmaptype = new OrderWalkingReq.Builder().srcGeo(walkNavRouteSearchParam.getStartPoint()).dstGeo(walkNavRouteSearchParam.getEndPoint()).role(walkNavRouteSearchParam.getRole()).psgPos(walkNavRouteSearchParam.getPsgPos()).type(walkNavRouteSearchParam.getType()).productId(Intrinsics.stringPlus("", walkNavRouteSearchParam.getBizType())).bizType(walkNavRouteSearchParam.getBizType()).driverId(walkNavRouteSearchParam.getDriverId()).passengerId(walkNavRouteSearchParam.getPassengerID()).orderId(walkNavRouteSearchParam.getOrderId()).visitorInfo(walkNavRouteSearchParam.getVisitorInfo()).eventType(walkNavRouteSearchParam.getEventType()).curRouteId(walkNavRouteSearchParam.getCurRouteId()).state(walkNavRouteSearchParam.getState()).scene(walkNavRouteSearchParam.getScene()).sdkmaptype(walkNavRouteSearchParam.getSdkMapType());
        CallFrom caller = walkNavRouteSearchParam.getCaller();
        if (caller != null) {
            str = caller.toString();
        }
        return sdkmaptype.caller(str).didiVersion(walkNavRouteSearchParam.getDidiVersion()).build().toByteArray();
    }

    @Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0002\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ'\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0010\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0011J\n\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u0015\u001a\u00020\rH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didichuxing/routesearchsdk/walk/WalkNavRouteSearchApiImpl$WalkNavRouteSearchTask;", "Landroid/os/AsyncTask;", "", "", "Lcom/didi/map/sdk/proto/driver_gl/OrderWalkingRes;", "callback", "Lcom/didichuxing/routesearchsdk/walk/WalkNavRouteSearchCallback;", "(Lcom/didichuxing/routesearchsdk/walk/WalkNavRouteSearchCallback;)V", "errMsg", "", "isRequestInvalid", "", "cancelRequest", "", "doInBackground", "params", "", "([[B)Lcom/didi/map/sdk/proto/driver_gl/OrderWalkingRes;", "getUrl", "onPostExecute", "routePlanRes", "onPreExecute", "RouteSearchSDK_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: WalkNavRouteSearchApiImpl.kt */
    private static final class WalkNavRouteSearchTask extends AsyncTask<byte[], Integer, OrderWalkingRes> {
        private final WalkNavRouteSearchCallback callback;
        private String errMsg = "";
        private boolean isRequestInvalid;

        public WalkNavRouteSearchTask(WalkNavRouteSearchCallback walkNavRouteSearchCallback) {
            Intrinsics.checkNotNullParameter(walkNavRouteSearchCallback, "callback");
            this.callback = walkNavRouteSearchCallback;
        }

        public final void cancelRequest() {
            this.isRequestInvalid = true;
            cancel(true);
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            WalkNavRouteSearchCallback walkNavRouteSearchCallback;
            if (!this.isRequestInvalid && (walkNavRouteSearchCallback = this.callback) != null) {
                walkNavRouteSearchCallback.onBeginToSearch();
            }
        }

        /* access modifiers changed from: protected */
        public OrderWalkingRes doInBackground(byte[]... bArr) {
            Intrinsics.checkNotNullParameter(bArr, "params");
            this.errMsg = "";
            try {
                byte[] doPost = NetUtils.doPost(getUrl(), bArr[0]);
                if (doPost != null) {
                    Message parseFrom = new Wire((Class<?>[]) new Class[0]).parseFrom(doPost, OrderWalkingRes.class);
                    Intrinsics.checkNotNullExpressionValue(parseFrom, "wire.parseFrom(response, OrderWalkingRes::class.java)");
                    return (OrderWalkingRes) parseFrom;
                }
                this.errMsg = "request return is null";
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                this.errMsg = e.toString();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(OrderWalkingRes orderWalkingRes) {
            WalkNavRouteSearchCallback walkNavRouteSearchCallback;
            if (!this.isRequestInvalid && (walkNavRouteSearchCallback = this.callback) != null) {
                walkNavRouteSearchCallback.onFinishToSearch(orderWalkingRes, this.errMsg);
            }
        }

        private final String getUrl() {
            return RouteSearchUrls.getWalkNavRouteUrl();
        }
    }
}
