package com.didi.map.sdk.sharetrack.external;

import com.didi.map.sdk.proto.driver_gl.OrderFeatureRes;
import com.didi.map.sdk.sharetrack.callback.IOrderFeatureDataCallback;
import com.didi.map.sdk.sharetrack.external.round.BaseRoundStrategy;
import com.didi.map.sdk.sharetrack.logger.DLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/map/sdk/sharetrack/external/CommonNavigator$mOrderFeatureDataCallback$1", "Lcom/didi/map/sdk/sharetrack/callback/IOrderFeatureDataCallback;", "onBeginToFetch", "", "onFetchFailed", "code", "", "msg", "", "onFetchSuccess", "res", "Lcom/didi/map/sdk/proto/driver_gl/OrderFeatureRes;", "CommonShareTrack_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CommonNavigator.kt */
public final class CommonNavigator$mOrderFeatureDataCallback$1 implements IOrderFeatureDataCallback {
    final /* synthetic */ CommonNavigator this$0;

    public void onBeginToFetch() {
    }

    CommonNavigator$mOrderFeatureDataCallback$1(CommonNavigator commonNavigator) {
        this.this$0 = commonNavigator;
    }

    public void onFetchSuccess(OrderFeatureRes orderFeatureRes) {
        INavDelegate access$getMNavDelegate$p;
        if ((orderFeatureRes != null ? orderFeatureRes.pickupHint : null) == null || orderFeatureRes.pickupHint.driverBeyondPickupFunc == null) {
            INavDelegate access$getMNavDelegate$p2 = this.this$0.f28656b;
            if (access$getMNavDelegate$p2 != null) {
                access$getMNavDelegate$p2.setRouteLineVisible(true);
            }
            DLog.m20357d(BaseRoundStrategy.TAG, "fetch feature data success but with no data", new Object[0]);
            return;
        }
        CommonNavigator commonNavigator = this.this$0;
        Integer num = orderFeatureRes.pickupHint.driverBeyondPickupFunc.Parking;
        Intrinsics.checkExpressionValueIsNotNull(num, "res.pickupHint.driverBeyondPickupFunc.Parking");
        commonNavigator.f28669o = num.intValue();
        BaseRoundStrategy access$getMStrategy$p = this.this$0.f28659e;
        if (access$getMStrategy$p != null) {
            access$getMStrategy$p.updateParkingStatus(this.this$0.f28669o);
        }
        CommonNavigator commonNavigator2 = this.this$0;
        Integer num2 = orderFeatureRes.pickupHint.driverBeyondPickupFunc.PickupType;
        Intrinsics.checkExpressionValueIsNotNull(num2, "res.pickupHint.driverBeyondPickupFunc.PickupType");
        commonNavigator2.f28670p = num2.intValue();
        DLog.m20357d(BaseRoundStrategy.TAG, "fetch strategy success: " + this.this$0.f28670p, new Object[0]);
        if (!this.this$0.f28665k) {
            CommonNavigator commonNavigator3 = this.this$0;
            commonNavigator3.m20217b(commonNavigator3.f28670p);
            CommonNavigator commonNavigator4 = this.this$0;
            commonNavigator4.m20215a(commonNavigator4.f28670p);
            this.this$0.f28665k = true;
            if (this.this$0.f28670p != 2 && (access$getMNavDelegate$p = this.this$0.f28656b) != null) {
                access$getMNavDelegate$p.setRouteLineVisible(true);
            }
        }
    }

    public void onFetchFailed(int i, String str) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        DLog.m20357d(BaseRoundStrategy.TAG, "fetch feature data failed: " + i + ", " + str, new Object[0]);
        INavDelegate access$getMNavDelegate$p = this.this$0.f28656b;
        if (access$getMNavDelegate$p != null) {
            access$getMNavDelegate$p.setRouteLineVisible(true);
        }
    }
}
