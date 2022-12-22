package com.didi.app.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.MainActivityImplV2;
import com.didi.sdk.util.SaApolloUtil;

public class MainDRouterHandler implements IRouterHandler {

    /* renamed from: a */
    private static final String f8668a = MainActivityImplV2.class.getName();

    /* renamed from: b */
    private static final String f8669b = "com.didiglobal.sa.biz.activity.SuperAppMainActivity";

    public void handle(Request request, Result result) {
        Context context = request.getContext();
        Intent intent = (Intent) request.getAddition("intent");
        if (intent == null) {
            SystemUtils.log(3, "MainDRouterHandler", "intent is null", (Throwable) null, "com.didi.app.router.MainDRouterHandler", 40);
            intent = new Intent();
        }
        if (SaApolloUtil.INSTANCE.getSaState()) {
            intent.setClassName(context.getPackageName(), f8669b);
        } else {
            intent.setClassName(context.getPackageName(), f8668a);
        }
        intent.addFlags(603979776);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }
}
