package com.didi.sdk.p146ad.operation;

import android.app.Activity;
import com.didi.sdk.p146ad.model.AdConfigItem;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/sdk/ad/operation/HomeAdOperation$handResponse$1", "Lcom/didi/unifylogin/listener/LoginListeners$LoginListener;", "onCancel", "", "onSuccess", "activity", "Landroid/app/Activity;", "token", "", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.sdk.ad.operation.HomeAdOperation$handResponse$1 */
/* compiled from: HomeAdOperation.kt */
public final class HomeAdOperation$handResponse$1 implements LoginListeners.LoginListener {
    final /* synthetic */ AdConfigItem $normalAfterPassportConfigItem;
    final /* synthetic */ HomeAdOperation this$0;

    public void onCancel() {
    }

    HomeAdOperation$handResponse$1(HomeAdOperation homeAdOperation, AdConfigItem adConfigItem) {
        this.this$0 = homeAdOperation;
        this.$normalAfterPassportConfigItem = adConfigItem;
    }

    public void onSuccess(Activity activity, String str) {
        OneLoginFacade.getFunction().removeLoginListener(this);
        this.this$0.m24679a(this.$normalAfterPassportConfigItem.getLandingPageLink());
    }
}
