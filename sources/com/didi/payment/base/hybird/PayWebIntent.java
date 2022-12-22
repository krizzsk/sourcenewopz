package com.didi.payment.base.hybird;

import android.content.Context;
import android.content.Intent;
import com.didi.payment.base.proxy.WebViewProxyHolder;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import com.didi.payment.base.view.webview.PayFusionWebActivity;
import com.didi.payment.base.view.webview.WebModel;
import com.didi.payment.base.web.WebViewModel;

public class PayWebIntent {

    /* renamed from: a */
    private static IWebIntent f29903a;

    public static void startWebIntent(Context context, WebViewModel webViewModel) {
        IWebIntent iWebIntent = f29903a;
        if (iWebIntent != null) {
            context.startActivity(iWebIntent.getIntent(new WebModel(webViewModel.title, webViewModel.url)));
        } else if (WebViewProxyHolder.getProxy() != null) {
            WebViewProxyHolder.getProxy().callWebActivity(webViewModel);
        } else {
            Intent intent = new Intent(context, PayFusionWebActivity.class);
            intent.putExtra(PayBaseWebActivity.EXTRA_WEB_MODEL, new WebModel(webViewModel.title, webViewModel.url));
            context.startActivity(intent);
        }
    }

    public static void setWebIntent(IWebIntent iWebIntent) {
        f29903a = iWebIntent;
    }
}
