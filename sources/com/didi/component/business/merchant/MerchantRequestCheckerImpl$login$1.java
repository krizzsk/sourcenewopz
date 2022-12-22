package com.didi.component.business.merchant;

import android.app.Activity;
import com.didi.unifylogin.listener.LoginListeners;
import global.didi.pay.merchant.processor.GlobalMerchantUnifiedPayProcessor;
import global.didi.pay.merchant.processor.model.MerchantSDKRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/component/business/merchant/MerchantRequestCheckerImpl$login$1", "Lcom/didi/unifylogin/listener/LoginListeners$LoginListener;", "onCancel", "", "onSuccess", "activity", "Landroid/app/Activity;", "token", "", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MerchantRequestCheckerImpl.kt */
public final class MerchantRequestCheckerImpl$login$1 implements LoginListeners.LoginListener {
    final /* synthetic */ MerchantSDKRequest $request;

    public void onCancel() {
    }

    MerchantRequestCheckerImpl$login$1(MerchantSDKRequest merchantSDKRequest) {
        this.$request = merchantSDKRequest;
    }

    public void onSuccess(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        GlobalMerchantUnifiedPayProcessor.INS.onHandleMerchantRequest(activity, this.$request);
    }
}
