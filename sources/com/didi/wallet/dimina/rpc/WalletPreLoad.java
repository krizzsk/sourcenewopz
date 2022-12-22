package com.didi.wallet.dimina.rpc;

import android.app.Application;
import android.content.Context;
import com.didi.dimina.container.secondparty.DMConfig4Di;
import com.didi.dimina.container.secondparty.Dimina4Di;
import com.didi.dimina.container.secondparty.bundle.strategy.ReleaseBundleMangerStrategy;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.unifylogin.api.OneLoginFacade;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, mo175978d2 = {"Lcom/didi/wallet/dimina/rpc/WalletPreLoad;", "", "()V", "launchPreLoad", "", "application", "Landroid/app/Application;", "loadPreLoadList", "context", "Landroid/content/Context;", "preLoad", "appId", "", "wallet-service-dimina_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletPreLoad.kt */
public final class WalletPreLoad {
    public final void launchPreLoad(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        if (OneLoginFacade.getStore().isLoginNow()) {
            m32452a(application);
            return;
        }
        OneLoginFacade.getFunction().addLoginListener(new WalletPreLoad$launchPreLoad$loginListener$1(this, application));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m32452a(Context context) {
        Map hashMap = new HashMap();
        String stringParam = PayBaseParamUtil.getStringParam(context, "token");
        Intrinsics.checkNotNullExpressionValue(stringParam, "getStringParam(context, PayParam.TOKEN)");
        hashMap.put("token", stringParam);
        WalletDiminaRpcKt.walletDiminaRpcService(context).preloadList(hashMap, new WalletPreLoad$loadPreLoadList$1(this, context));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m32453a(Context context, String str) {
        DMConfig4Di dMConfig4Di = new DMConfig4Di(context);
        dMConfig4Di.getLaunchConfig().setAppId(str);
        dMConfig4Di.getLaunchConfig().setBundleManagerStrategy(new ReleaseBundleMangerStrategy(Intrinsics.stringPlus("dimina/bundle/", str)));
        Dimina4Di.requireInstall(dMConfig4Di);
    }
}
