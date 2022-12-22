package com.didi.component.business.merchant;

import android.app.Activity;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import global.didi.pay.merchant.processor.MerchantRequestChecker;
import global.didi.pay.merchant.processor.model.MerchantSDKRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "globalapi", value = {MerchantRequestChecker.class})
@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/component/business/merchant/MerchantRequestCheckerImpl;", "Lglobal/didi/pay/merchant/processor/MerchantRequestChecker;", "()V", "isLogin", "", "login", "", "context", "Landroid/app/Activity;", "request", "Lglobal/didi/pay/merchant/processor/model/MerchantSDKRequest;", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MerchantRequestCheckerImpl.kt */
public final class MerchantRequestCheckerImpl implements MerchantRequestChecker {
    public boolean isLogin() {
        return OneLoginFacade.getStore().isLoginNow();
    }

    public void login(Activity activity, MerchantSDKRequest merchantSDKRequest) {
        Intrinsics.checkNotNullParameter(activity, "context");
        OneLoginFacade.getFunction().addLoginListener(new MerchantRequestCheckerImpl$login$1(merchantSDKRequest));
        OneLoginFacade.getAction().go2Login(activity);
    }
}
