package com.didi.payment.kycservice.kyc.fragment;

import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.permission.PermissionCallback;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, mo175978d2 = {"com/didi/payment/kycservice/kyc/fragment/SignUp99PayFragment$requestLocationPermission$1", "Lcom/didi/commoninterfacelib/permission/PermissionCallback;", "isAllGranted", "", "granted", "", "strings", "", "", "(Z[Ljava/lang/String;)V", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SignUp99PayFragment.kt */
public final class SignUp99PayFragment$requestLocationPermission$1 implements PermissionCallback {
    final /* synthetic */ SignUp99PayFragment this$0;

    SignUp99PayFragment$requestLocationPermission$1(SignUp99PayFragment signUp99PayFragment) {
        this.this$0 = signUp99PayFragment;
    }

    public void isAllGranted(boolean z, String[] strArr) {
        FragmentActivity activity;
        if (z && (activity = this.this$0.getActivity()) != null) {
            activity.finish();
        }
    }
}
