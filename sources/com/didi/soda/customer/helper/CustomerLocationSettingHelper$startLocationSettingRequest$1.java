package com.didi.soda.customer.helper;

import android.app.Activity;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.CommonOmegaHelper;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.LocalPermissionHelper;
import com.didi.soda.customer.helper.CustomerLocationSettingHelper;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import com.didichuxing.bigdata.p173dp.locsdk.setting.LocationSettingRequestCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/soda/customer/helper/CustomerLocationSettingHelper$startLocationSettingRequest$1", "Lcom/didichuxing/bigdata/dp/locsdk/setting/LocationSettingRequestCallback;", "onFailed", "", "isWindowShown", "", "onSuccess", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerLocationSettingHelper.kt */
public final class CustomerLocationSettingHelper$startLocationSettingRequest$1 implements LocationSettingRequestCallback {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ CustomerLocationSettingHelper.ILocationSettingRequestCallback $requestCallback;
    final /* synthetic */ int $scene;
    final /* synthetic */ CustomerLocationSettingHelper this$0;

    CustomerLocationSettingHelper$startLocationSettingRequest$1(CustomerLocationSettingHelper customerLocationSettingHelper, CustomerLocationSettingHelper.ILocationSettingRequestCallback iLocationSettingRequestCallback, int i, Activity activity) {
        this.this$0 = customerLocationSettingHelper;
        this.$requestCallback = iLocationSettingRequestCallback;
        this.$scene = i;
        this.$activity = activity;
    }

    public void onSuccess() {
        LogUtil.m29104i("CustomerLocationSettingHelper", "checkSettingRequest----onSuccess");
        this.this$0.f41346a = false;
        CustomerLocationSettingHelper.ILocationSettingRequestCallback iLocationSettingRequestCallback = this.$requestCallback;
        if (iLocationSettingRequestCallback != null) {
            iLocationSettingRequestCallback.onSuccess();
        }
        CommonOmegaHelper.INSTANCE.locationOpenSettingGpsStatusCk(this.$scene, LocalPermissionHelper.checkoutPermission(this.$activity, LocalPermissionHelper.LOCATION_PERMISSIONS), CustomerSystemUtil.isGpsEnabled(this.$activity));
    }

    public void onFailed() {
        LogUtil.m29104i("CustomerLocationSettingHelper", "checkSettingRequest----onFailed---");
    }

    public void onFailed(boolean z) {
        LogUtil.m29104i("CustomerLocationSettingHelper", Intrinsics.stringPlus("checkSettingRequest----onFailed---", Boolean.valueOf(z)));
        this.this$0.f41346a = z;
        CustomerLocationSettingHelper.ILocationSettingRequestCallback iLocationSettingRequestCallback = this.$requestCallback;
        if (iLocationSettingRequestCallback != null) {
            iLocationSettingRequestCallback.onFailed(z);
        }
        if (z) {
            HomeOmegaHelper.getInstance().locationServiceSettingSw(this.$scene);
        }
    }
}
