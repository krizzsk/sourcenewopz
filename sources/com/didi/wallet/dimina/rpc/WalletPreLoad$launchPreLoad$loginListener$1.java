package com.didi.wallet.dimina.rpc;

import android.app.Activity;
import android.app.Application;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/wallet/dimina/rpc/WalletPreLoad$launchPreLoad$loginListener$1", "Lcom/didi/unifylogin/listener/LoginListeners$LoginListener;", "onCancel", "", "onSuccess", "activity", "Landroid/app/Activity;", "token", "", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletPreLoad.kt */
public final class WalletPreLoad$launchPreLoad$loginListener$1 implements LoginListeners.LoginListener {
    final /* synthetic */ Application $application;
    final /* synthetic */ WalletPreLoad this$0;

    WalletPreLoad$launchPreLoad$loginListener$1(WalletPreLoad walletPreLoad, Application application) {
        this.this$0 = walletPreLoad;
        this.$application = application;
    }

    public void onSuccess(Activity activity, String str) {
        this.this$0.m32452a(this.$application);
        OneLoginFacade.getFunction().removeLoginListener(this);
    }

    public void onCancel() {
        OneLoginFacade.getFunction().removeLoginListener(this);
    }
}
