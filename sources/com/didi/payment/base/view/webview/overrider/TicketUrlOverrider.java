package com.didi.payment.base.view.webview.overrider;

import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebView;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import com.didi.sdk.push.ServerParam;

public class TicketUrlOverrider implements OverrideUrlLoader {

    /* renamed from: a */
    private PayBaseWebActivity f30051a;

    public TicketUrlOverrider(PayBaseWebActivity payBaseWebActivity) {
        this.f30051a = payBaseWebActivity;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.startsWith("dcq:")) {
            return false;
        }
        if (str.contains(ServerParam.PARAM_TAXI_TICKET_ID)) {
            String substring = str.substring(str.indexOf(ServerParam.PARAM_TAXI_TICKET_ID) + 6 + 1);
            if (!TextUtils.isEmpty(substring)) {
                m21047a(substring);
            } else if (!this.f30051a.goBack(false)) {
                m21047a("");
            }
        } else {
            this.f30051a.finishWithResultCodeCanceled();
        }
        return true;
    }

    /* renamed from: a */
    private void m21047a(String str) {
        Intent intent = new Intent();
        intent.putExtra("taxi_ticket", str);
        this.f30051a.setResult(-1, intent);
        this.f30051a.finish();
    }
}
