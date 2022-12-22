package com.didi.safetoolkit.business.triprecording;

import android.text.TextUtils;
import com.android.didi.safetoolkit.activity.permisstion.AuthorizationInfo;
import com.android.didi.safetoolkit.activity.permisstion.callback.IPermissionRequest;
import com.android.didi.safetoolkit.activity.permisstion.callback.SimplePermissionCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\r"}, mo175978d2 = {"com/didi/safetoolkit/business/triprecording/SfPermissionActivity$initData$1", "Lcom/android/didi/safetoolkit/activity/permisstion/callback/SimplePermissionCallback;", "onBeforeGranted", "", "requestList", "", "Lcom/android/didi/safetoolkit/activity/permisstion/AuthorizationInfo;", "request", "Lcom/android/didi/safetoolkit/activity/permisstion/callback/IPermissionRequest;", "onGranted", "grantedList", "onRefuse", "refuseList", "safe-toolkit_passengerRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: SfPermissionActivity.kt */
public final class SfPermissionActivity$initData$1 extends SimplePermissionCallback {
    final /* synthetic */ SfPermissionActivity this$0;

    SfPermissionActivity$initData$1(SfPermissionActivity sfPermissionActivity) {
        this.this$0 = sfPermissionActivity;
    }

    public void onGranted(List<AuthorizationInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "grantedList");
        if (!TextUtils.isEmpty(this.this$0.getOid())) {
            TripRecordingManager.Companion.getInstance().start(this.this$0.getOid(), (RecordListenerImpl) null);
        }
        this.this$0.finish();
    }

    public void onBeforeGranted(List<AuthorizationInfo> list, IPermissionRequest iPermissionRequest) {
        Intrinsics.checkParameterIsNotNull(list, "requestList");
        Intrinsics.checkParameterIsNotNull(iPermissionRequest, "request");
        iPermissionRequest.proceed();
    }

    public void onRefuse(List<AuthorizationInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "refuseList");
        super.onRefuse(list);
        this.this$0.finish();
    }
}
