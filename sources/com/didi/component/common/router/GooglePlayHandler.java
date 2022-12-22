package com.didi.component.common.router;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import com.didi.drouter.router.IRouterInterceptor;
import com.didi.drouter.router.Request;

public class GooglePlayHandler implements IRouterInterceptor {
    public void handle(Request request) {
        Uri uri = request.getUri();
        if (uri.toString().startsWith("https://play.google.com/store/apps/details")) {
            String queryParameter = uri.getQueryParameter("id");
            if (queryParameter == null) {
                queryParameter = "";
            }
            String queryParameter2 = uri.getQueryParameter(Payload.REFERRER);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            String str = "market://details?id=" + queryParameter;
            if (!TextUtils.isEmpty(queryParameter2)) {
                str = str + "&referrer=" + queryParameter2;
            }
            intent.setData(Uri.parse(str));
            PackageManager packageManager = request.getContext().getPackageManager();
            if (intent.resolveActivity(packageManager) != null) {
                m7937a(request, intent);
                return;
            }
            intent.setData(uri);
            if (intent.resolveActivity(packageManager) != null) {
                m7937a(request, intent);
            } else {
                request.getInterceptor().onContinue();
            }
        } else {
            request.getInterceptor().onContinue();
        }
    }

    /* renamed from: a */
    private void m7937a(Request request, Intent intent) {
        request.getContext().startActivity(intent);
    }
}
