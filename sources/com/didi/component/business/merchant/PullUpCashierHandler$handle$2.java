package com.didi.component.business.merchant;

import android.app.Activity;
import android.content.Context;
import com.didi.unifylogin.listener.LoginListeners;
import global.didi.pay.merchant.processor.GlobalMerchantUnifiedPayProcessor;
import global.didi.pay.merchant.processor.model.MerchantWebRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/component/business/merchant/PullUpCashierHandler$handle$2", "Lcom/didi/unifylogin/listener/LoginListeners$LoginListener;", "onCancel", "", "onSuccess", "activity", "Landroid/app/Activity;", "token", "", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PullUpCashierHandler.kt */
public final class PullUpCashierHandler$handle$2 implements LoginListeners.LoginListener {
    final /* synthetic */ Ref.ObjectRef<Context> $context;
    final /* synthetic */ MerchantWebRequest $request;

    public void onCancel() {
    }

    PullUpCashierHandler$handle$2(Ref.ObjectRef<Context> objectRef, MerchantWebRequest merchantWebRequest) {
        this.$context = objectRef;
        this.$request = merchantWebRequest;
    }

    public void onSuccess(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        GlobalMerchantUnifiedPayProcessor globalMerchantUnifiedPayProcessor = GlobalMerchantUnifiedPayProcessor.INS;
        T t = this.$context.element;
        if (t != null) {
            globalMerchantUnifiedPayProcessor.onHandleMerchantRequest((Activity) t, this.$request);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }
}
