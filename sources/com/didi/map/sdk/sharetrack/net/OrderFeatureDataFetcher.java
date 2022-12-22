package com.didi.map.sdk.sharetrack.net;

import android.os.AsyncTask;
import com.didi.dimina.container.util.TraceUtil;
import com.didi.map.sdk.proto.driver_gl.OrderFeatureRes;
import com.didi.map.sdk.proto.driver_gl.OrderFeatureRouteReq;
import com.didi.map.sdk.sharetrack.callback.IOrderFeatureDataCallback;
import com.didi.map.sdk.sharetrack.common.NetUtils;
import com.didi.map.sdk.sharetrack.common.ShareTrackApolloHelper;
import com.didi.map.sdk.sharetrack.common.ShareTrackUtils;
import com.didi.map.sdk.sharetrack.external.round.BaseRoundStrategy;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.squareup.wire.Wire;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u001cB\u0019\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ'\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0014\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u0019\u001a\u00020\u0017H\u0014J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0003H\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/map/sdk/sharetrack/net/OrderFeatureDataFetcher;", "Landroid/os/AsyncTask;", "", "", "Lcom/didi/map/sdk/proto/driver_gl/OrderFeatureRes;", "mCallback", "Lcom/didi/map/sdk/sharetrack/callback/IOrderFeatureDataCallback;", "mReqData", "Lcom/didi/map/sdk/proto/driver_gl/OrderFeatureRouteReq;", "(Lcom/didi/map/sdk/sharetrack/callback/IOrderFeatureDataCallback;Lcom/didi/map/sdk/proto/driver_gl/OrderFeatureRouteReq;)V", "curRouteId", "getCurRouteId", "()Ljava/lang/String;", "setCurRouteId", "(Ljava/lang/String;)V", "mEndTime", "", "mStartTime", "doInBackground", "params", "", "([Ljava/lang/String;)Lcom/didi/map/sdk/proto/driver_gl/OrderFeatureRes;", "onPostExecute", "", "result", "onPreExecute", "trackTimeConsuming", "code", "Companion", "CommonShareTrack_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: OrderFeatureDataFetcher.kt */
public final class OrderFeatureDataFetcher extends AsyncTask<String, Integer, OrderFeatureRes> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: f */
    private static final String f28913f = "OrderFeatureDataFetcher";

    /* renamed from: a */
    private String f28914a = "0";

    /* renamed from: b */
    private long f28915b;

    /* renamed from: c */
    private long f28916c;

    /* renamed from: d */
    private final IOrderFeatureDataCallback f28917d;

    /* renamed from: e */
    private final OrderFeatureRouteReq f28918e;

    public OrderFeatureDataFetcher(IOrderFeatureDataCallback iOrderFeatureDataCallback, OrderFeatureRouteReq orderFeatureRouteReq) {
        this.f28917d = iOrderFeatureDataCallback;
        this.f28918e = orderFeatureRouteReq;
    }

    public final String getCurRouteId() {
        return this.f28914a;
    }

    public final void setCurRouteId(String str) {
        this.f28914a = str;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/map/sdk/sharetrack/net/OrderFeatureDataFetcher$Companion;", "", "()V", "TAG", "", "CommonShareTrack_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: OrderFeatureDataFetcher.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        IOrderFeatureDataCallback iOrderFeatureDataCallback = this.f28917d;
        if (iOrderFeatureDataCallback != null) {
            iOrderFeatureDataCallback.onBeginToFetch();
        }
    }

    /* access modifiers changed from: protected */
    public OrderFeatureRes doInBackground(String... strArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "params");
        if (this.f28918e == null) {
            DLog.m20357d(f28913f, "req data is null", new Object[0]);
            return null;
        }
        try {
            this.f28915b = System.currentTimeMillis();
            return (OrderFeatureRes) new Wire((Class<?>[]) new Class[0]).parseFrom(NetUtils.doPost(strArr[0], this.f28918e.toByteArray()), OrderFeatureRes.class);
        } catch (Exception e) {
            DLog.m20357d(f28913f, "fetch exce: " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(OrderFeatureRes orderFeatureRes) {
        this.f28916c = System.currentTimeMillis();
        if (orderFeatureRes == null) {
            IOrderFeatureDataCallback iOrderFeatureDataCallback = this.f28917d;
            if (iOrderFeatureDataCallback != null) {
                iOrderFeatureDataCallback.onFetchFailed(TraceUtil.MINA_INDEX_UN_KNOW, "result is null locally");
            }
            m20362a(1);
            return;
        }
        DLog.m20357d(f28913f, "fetch complete: ret: " + orderFeatureRes.ret + ", msg: " + orderFeatureRes.msg, new Object[0]);
        Integer num = orderFeatureRes.ret;
        if (num != null && num.intValue() == 0) {
            IOrderFeatureDataCallback iOrderFeatureDataCallback2 = this.f28917d;
            if (iOrderFeatureDataCallback2 != null) {
                iOrderFeatureDataCallback2.onFetchSuccess(orderFeatureRes);
            }
            m20362a(0);
            return;
        }
        IOrderFeatureDataCallback iOrderFeatureDataCallback3 = this.f28917d;
        if (iOrderFeatureDataCallback3 != null) {
            Integer num2 = orderFeatureRes.ret;
            Intrinsics.checkExpressionValueIsNotNull(num2, "result.ret");
            int intValue = num2.intValue();
            String str = orderFeatureRes.msg;
            Intrinsics.checkExpressionValueIsNotNull(str, "result.msg");
            iOrderFeatureDataCallback3.onFetchFailed(intValue, str);
        }
        m20362a(1);
    }

    /* renamed from: a */
    private final void m20362a(int i) {
        if (ShareTrackApolloHelper.INSTANCE.getShouldTrackEvent() == 1) {
            long j = this.f28916c;
            long j2 = this.f28915b;
            if (j > j2) {
                long j3 = j - j2;
                Map hashMap = new HashMap();
                hashMap.put(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, this.f28914a);
                hashMap.put("time_consuming", Long.valueOf(j3));
                hashMap.put("error_no", Integer.valueOf(i));
                ShareTrackUtils.INSTANCE.traceEvent("map_order_feature_api_total_time_sw", hashMap, BaseRoundStrategy.TAG);
            }
        }
    }
}
