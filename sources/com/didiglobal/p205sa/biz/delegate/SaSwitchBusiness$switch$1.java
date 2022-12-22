package com.didiglobal.p205sa.biz.delegate;

import android.app.Activity;
import android.os.Bundle;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, mo175978d2 = {"com/didiglobal/sa/biz/delegate/SaSwitchBusiness$switch$1", "Lcom/didi/unifylogin/listener/LoginListeners$LoginListener;", "onCancel", "", "onSuccess", "activity", "Landroid/app/Activity;", "token", "", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.delegate.SaSwitchBusiness$switch$1 */
/* compiled from: SaSwitchBusiness.kt */
public final class SaSwitchBusiness$switch$1 implements LoginListeners.LoginListener {
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ String $groupType;
    final /* synthetic */ String $link;
    final /* synthetic */ SaSwitchBusiness this$0;

    SaSwitchBusiness$switch$1(SaSwitchBusiness saSwitchBusiness, String str, String str2, Bundle bundle) {
        this.this$0 = saSwitchBusiness;
        this.$groupType = str;
        this.$link = str2;
        this.$bundle = bundle;
    }

    public void onSuccess(Activity activity, String str) {
        OneLoginFacade.getFunction().removeLoginListener(this);
        this.this$0.m36675a(this.$groupType, this.$link, this.$bundle);
    }

    public void onCancel() {
        OneLoginFacade.getFunction().removeLoginListener(this);
    }
}
