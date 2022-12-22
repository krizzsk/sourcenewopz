package com.didi.component.common.router.common;

import android.net.Uri;
import android.text.TextUtils;
import com.didi.component.common.util.GLog;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.unifylogin.api.OneLoginFacade;

public class RegByKeyHandler implements IRouterHandler {

    /* renamed from: a */
    private String f11715a = RegByKeyHandler.class.getSimpleName();

    public void handle(Request request, Result result) {
        Uri uri = request.getUri();
        String str = this.f11715a;
        GLog.m7965d(str, "routeHandler uri = " + uri);
        String queryParameter = uri.getQueryParameter("reg_key");
        if (TextUtils.equals("1", uri.getQueryParameter("auto_register")) && !OneLoginFacade.getStore().isLoginNow()) {
            OneLoginFacade.getAction().go2LoginByKey(request.getContext(), queryParameter);
        }
    }
}
