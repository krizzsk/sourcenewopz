package com.didi.payment.base.router.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.didi.payment.base.router.ActivityLauncher;
import com.didi.payment.base.utils.IntentUtil;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import com.didi.payment.base.view.webview.PayFusionWebActivity;
import com.didi.payment.base.view.webview.WebModel;
import java.util.Map;

public class WebRouter implements IPayRouter {

    /* renamed from: a */
    private String f29937a;

    public void destroy() {
    }

    public void route(Context context, String str, Map<String, Object> map, final RouteCallback routeCallback) {
        this.f29937a = str;
        Intent intent = new Intent(context, PayFusionWebActivity.class);
        WebModel webModel = new WebModel();
        webModel.url = str;
        intent.putExtra(PayBaseWebActivity.EXTRA_WEB_MODEL, webModel);
        ActivityLauncher.init((Activity) context).startActivityForResult(intent, (ActivityLauncher.Callback) new ActivityLauncher.Callback() {
            public void onActivityResult(int i, Intent intent) {
                RouteCallback routeCallback = routeCallback;
                if (routeCallback == null) {
                    return;
                }
                if (i == -1) {
                    routeCallback.onResult(true, IntentUtil.getIntent(intent));
                } else {
                    routeCallback.onResult(false, IntentUtil.getIntent(intent));
                }
            }
        });
    }

    public String getUrl() {
        return this.f29937a;
    }
}
