package com.didi.map.sdk.sharetrack.net;

import android.content.Context;
import android.util.Base64;
import com.didi.common.map.MapVendor;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.sdk.proto.driver_gl.OrderFeatureRouteReq;
import com.didi.map.sdk.sharetrack.callback.IOrderFeatureDataCallback;
import com.didi.map.sdk.sharetrack.entity.OrderInfo;
import com.didi.map.sdk.sharetrack.external.round.BaseRoundStrategy;
import com.didi.map.sdk.sharetrack.logger.DLog;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\bJ\b\u0010\u0017\u001a\u00020\u000eH\u0002J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\bJ\u0010\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, mo175978d2 = {"Lcom/didi/map/sdk/sharetrack/net/DataFetcherManager;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mFeatureDataFetcher", "Lcom/didi/map/sdk/sharetrack/net/OrderFeatureDataFetcher;", "mLineVisible", "", "mMapVendor", "Lcom/didi/common/map/MapVendor;", "mOrderInfo", "Lcom/didi/map/sdk/sharetrack/entity/OrderInfo;", "mRouteId", "", "buildOrderFeatureDataReq", "Lcom/didi/map/sdk/proto/driver_gl/OrderFeatureRouteReq;", "forceZero", "destroy", "", "fetchOrderFeatureDataWith", "callback", "Lcom/didi/map/sdk/sharetrack/callback/IOrderFeatureDataCallback;", "getDrvSyncMsg", "updateLineVisibility", "visible", "updateMapVendor", "vendor", "updateOrderInfo", "orderInfo", "updateRouteId", "routeId", "Companion", "CommonShareTrack_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DataFetcherManager.kt */
public final class DataFetcherManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: g */
    private static final String f28906g = "DataFetcherManager";

    /* renamed from: a */
    private OrderInfo f28907a;

    /* renamed from: b */
    private String f28908b = "0";

    /* renamed from: c */
    private MapVendor f28909c;

    /* renamed from: d */
    private OrderFeatureDataFetcher f28910d;

    /* renamed from: e */
    private boolean f28911e = true;

    /* renamed from: f */
    private final Context f28912f;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/map/sdk/sharetrack/net/DataFetcherManager$Companion;", "", "()V", "TAG", "", "CommonShareTrack_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: DataFetcherManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DataFetcherManager(Context context) {
        this.f28912f = context;
    }

    public final void updateOrderInfo(OrderInfo orderInfo) {
        this.f28907a = orderInfo;
    }

    public final void updateMapVendor(MapVendor mapVendor) {
        this.f28909c = mapVendor;
    }

    public final void updateRouteId(String str) {
        this.f28908b = str;
    }

    public final void updateLineVisibility(boolean z) {
        this.f28911e = z;
    }

    public final void fetchOrderFeatureDataWith(IOrderFeatureDataCallback iOrderFeatureDataCallback, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("fetch order feature with callback? ");
        sb.append(iOrderFeatureDataCallback != null);
        sb.append(", force zero: ");
        sb.append(z);
        DLog.m20357d(BaseRoundStrategy.TAG, sb.toString(), new Object[0]);
        OrderFeatureDataFetcher orderFeatureDataFetcher = new OrderFeatureDataFetcher(iOrderFeatureDataCallback, m20360a(z));
        this.f28910d = orderFeatureDataFetcher;
        if (orderFeatureDataFetcher != null) {
            orderFeatureDataFetcher.setCurRouteId(this.f28908b);
        }
        OrderFeatureDataFetcher orderFeatureDataFetcher2 = this.f28910d;
        if (orderFeatureDataFetcher2 != null) {
            orderFeatureDataFetcher2.execute(new String[]{DUrl.getOrderFeatureDataUrl(this.f28912f)});
        }
    }

    /* renamed from: a */
    private final OrderFeatureRouteReq m20360a(boolean z) {
        long j = null;
        if (this.f28907a == null) {
            DLog.m20357d(BaseRoundStrategy.TAG, "orderInfo is null, won't request", new Object[0]);
            return null;
        }
        OrderFeatureRouteReq.Builder builder = new OrderFeatureRouteReq.Builder();
        PlatInfo instance = PlatInfo.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "PlatInfo.getInstance()");
        builder.token = instance.getDriverTicket();
        OrderInfo orderInfo = this.f28907a;
        if (orderInfo == null) {
            Intrinsics.throwNpe();
        }
        builder.orderId = orderInfo.getOrderId();
        PlatInfo instance2 = PlatInfo.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance2, "PlatInfo.getInstance()");
        builder.travelID = instance2.getTraverId();
        PlatInfo instance3 = PlatInfo.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance3, "PlatInfo.getInstance()");
        builder.phoneNum = instance3.getDriverPhoneNumber();
        OrderInfo orderInfo2 = this.f28907a;
        builder.orderStage = orderInfo2 != null ? Integer.valueOf(orderInfo2.getOrderStage()) : null;
        PlatInfo instance4 = PlatInfo.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance4, "PlatInfo.getInstance()");
        builder.driverId = Long.valueOf(instance4.getDriverId());
        PlatInfo instance5 = PlatInfo.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance5, "PlatInfo.getInstance()");
        builder.productId = String.valueOf(instance5.getBizType());
        if (z) {
            try {
                j = 0L;
            } catch (Exception e) {
                DLog.m20357d(f28906g, "to long exc: " + e.getMessage(), new Object[0]);
            }
        } else {
            String str = this.f28908b;
            if (str != null) {
                j = Long.valueOf(Long.parseLong(str));
            }
        }
        builder.curRouteId = j;
        String a = m20361a();
        if (a.length() > 0) {
            builder.drvSyncMsg = a;
        }
        builder.caller = "driver";
        builder.maptype = "google";
        PlatInfo instance6 = PlatInfo.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance6, "PlatInfo.getInstance()");
        builder.didiVersion = instance6.getClientVersion();
        OrderFeatureRouteReq build = builder.build();
        DLog.m20357d(BaseRoundStrategy.TAG, "req: " + build, new Object[0]);
        return build;
    }

    /* renamed from: a */
    private final String m20361a() {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("line_visible", this.f28911e ? "1" : "0");
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "obj.toString()");
            Charset charset = Charsets.UTF_8;
            if (jSONObject2 != null) {
                byte[] bytes = jSONObject2.getBytes(charset);
                Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                String encodeToString = Base64.encodeToString(bytes, 0);
                Intrinsics.checkExpressionValueIsNotNull(encodeToString, "encodeStr");
                if (encodeToString.length() > 0) {
                    str = encodeToString.substring(0, encodeToString.length() - 1);
                    Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                } else {
                    str = "";
                }
                DLog.m20357d(BaseRoundStrategy.TAG, "sync msg: " + str, new Object[0]);
                return str;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        } catch (Exception e) {
            DLog.m20357d(BaseRoundStrategy.TAG, "sync exception: " + e.getMessage(), new Object[0]);
            return "";
        }
    }

    public final void destroy() {
        this.f28911e = true;
        try {
            OrderFeatureDataFetcher orderFeatureDataFetcher = this.f28910d;
            if (orderFeatureDataFetcher != null) {
                orderFeatureDataFetcher.cancel(true);
            }
        } catch (Exception e) {
            DLog.m20357d(f28906g, "fetcher cancel exc: " + e.getMessage(), new Object[0]);
        }
    }
}
