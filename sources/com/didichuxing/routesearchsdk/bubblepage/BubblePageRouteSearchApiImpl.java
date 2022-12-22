package com.didichuxing.routesearchsdk.bubblepage;

import android.os.AsyncTask;
import com.didi.common.map.util.NetUtils;
import com.didi.map.sdk.proto.driver_gl.BubblePageReq;
import com.didi.map.sdk.proto.driver_gl.BubblePageRes;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.routesearchsdk.RouteSearchUrls;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¨\u0006\f"}, mo175978d2 = {"Lcom/didichuxing/routesearchsdk/bubblepage/BubblePageRouteSearchApiImpl;", "Lcom/didichuxing/routesearchsdk/bubblepage/IBubblePageRouteSearchApi;", "()V", "calculateRoute", "", "param", "Lcom/didichuxing/routesearchsdk/bubblepage/BubblePageRouteSearchParam;", "callback", "Lcom/didichuxing/routesearchsdk/bubblepage/IBubblePageRouteSearchCallback;", "getRoutePlanReqBytes", "", "BubblePageRouteSearchTask", "RouteSearchSDK_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BubblePageRouteSearchApiImpl.kt */
public final class BubblePageRouteSearchApiImpl implements IBubblePageRouteSearchApi {
    public void calculateRoute(BubblePageRouteSearchParam bubblePageRouteSearchParam, IBubblePageRouteSearchCallback iBubblePageRouteSearchCallback) {
        Intrinsics.checkNotNullParameter(bubblePageRouteSearchParam, "param");
        Intrinsics.checkNotNullParameter(iBubblePageRouteSearchCallback, "callback");
        String checkParam = bubblePageRouteSearchParam.checkParam();
        if (checkParam != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.CHINA, "param %s can not be null!", Arrays.copyOf(new Object[]{checkParam}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            iBubblePageRouteSearchCallback.onFinishToSearch((BubblePageRes) null, format);
            return;
        }
        byte[] a = m34801a(bubblePageRouteSearchParam);
        if (a != null) {
            new BubblePageRouteSearchTask(iBubblePageRouteSearchCallback).execute((Object[]) new byte[][]{a});
        }
    }

    /* renamed from: a */
    private final byte[] m34801a(BubblePageRouteSearchParam bubblePageRouteSearchParam) {
        if (bubblePageRouteSearchParam == null) {
            return null;
        }
        return new BubblePageReq.Builder().visitorInfo(bubblePageRouteSearchParam.getVisitorInfo()).estimateRouteID(bubblePageRouteSearchParam.getEstimateRouteID()).passengerID(bubblePageRouteSearchParam.getPassengerID()).bizType(bubblePageRouteSearchParam.getBizType()).bizGroup(bubblePageRouteSearchParam.getBizGroup()).startCityID(bubblePageRouteSearchParam.getStartCityID()).endCityID(bubblePageRouteSearchParam.getEndCityID()).lang(bubblePageRouteSearchParam.getLang()).productId(bubblePageRouteSearchParam.getProductId()).orderType(bubblePageRouteSearchParam.getEpfOrderType()).NeedSingleRoute(bubblePageRouteSearchParam.getNeedSingleRoute()).startPoint(bubblePageRouteSearchParam.getStartPoint()).countryId(bubblePageRouteSearchParam.getCountryId()).endPoint(bubblePageRouteSearchParam.getEndPoint()).odPoints(bubblePageRouteSearchParam.getOdPoints()).build().toByteArray();
    }

    @Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J'\u0010\n\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\f\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\rJ\n\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u0012\u001a\u00020\u0010H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didichuxing/routesearchsdk/bubblepage/BubblePageRouteSearchApiImpl$BubblePageRouteSearchTask;", "Landroid/os/AsyncTask;", "", "", "Lcom/didi/map/sdk/proto/driver_gl/BubblePageRes;", "callback", "Lcom/didichuxing/routesearchsdk/bubblepage/IBubblePageRouteSearchCallback;", "(Lcom/didichuxing/routesearchsdk/bubblepage/IBubblePageRouteSearchCallback;)V", "errMsg", "", "doInBackground", "params", "", "([[B)Lcom/didi/map/sdk/proto/driver_gl/BubblePageRes;", "getRoutePlanRequestUrl", "onPostExecute", "", "routePlanRes", "onPreExecute", "RouteSearchSDK_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BubblePageRouteSearchApiImpl.kt */
    private static final class BubblePageRouteSearchTask extends AsyncTask<byte[], Integer, BubblePageRes> {
        private final IBubblePageRouteSearchCallback callback;
        private String errMsg = "";

        public BubblePageRouteSearchTask(IBubblePageRouteSearchCallback iBubblePageRouteSearchCallback) {
            Intrinsics.checkNotNullParameter(iBubblePageRouteSearchCallback, "callback");
            this.callback = iBubblePageRouteSearchCallback;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.callback.onBeginToSearch();
        }

        /* access modifiers changed from: protected */
        public BubblePageRes doInBackground(byte[]... bArr) {
            Intrinsics.checkNotNullParameter(bArr, "params");
            this.errMsg = "";
            try {
                byte[] doPost = NetUtils.doPost(getRoutePlanRequestUrl(), bArr[0]);
                if (doPost != null) {
                    Message parseFrom = new Wire((Class<?>[]) new Class[0]).parseFrom(doPost, BubblePageRes.class);
                    Intrinsics.checkNotNullExpressionValue(parseFrom, "wire.parseFrom(response, BubblePageRes::class.java)");
                    BubblePageRes bubblePageRes = (BubblePageRes) parseFrom;
                    SystemUtils.log(3, "david", Intrinsics.stringPlus("res:", bubblePageRes), (Throwable) null, "com.didichuxing.routesearchsdk.bubblepage.BubblePageRouteSearchApiImpl$BubblePageRouteSearchTask", 80);
                    return bubblePageRes;
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
        public void onPostExecute(BubblePageRes bubblePageRes) {
            this.callback.onFinishToSearch(bubblePageRes, this.errMsg);
        }

        private final String getRoutePlanRequestUrl() {
            return RouteSearchUrls.getBubblePageRouteSearchUrl();
        }
    }
}
