package com.didi.sdk.webview;

import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebView;
import com.didi.sdk.push.ServerParam;

public class TicketUrlOverrider implements OverrideUrlLoader {

    /* renamed from: a */
    private BaseWebActivity f38398a;

    public TicketUrlOverrider(BaseWebActivity baseWebActivity) {
        this.f38398a = baseWebActivity;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.startsWith("dcq:")) {
            return false;
        }
        if (str.contains(ServerParam.PARAM_TAXI_TICKET_ID)) {
            String substring = str.substring(str.indexOf(ServerParam.PARAM_TAXI_TICKET_ID) + 6 + 1, str.length());
            if (!TextUtils.isEmpty(substring)) {
                m27166a(substring);
            } else if (!this.f38398a.goBack(false)) {
                m27166a("");
            }
        } else {
            this.f38398a.mo97969a();
        }
        return true;
    }

    /* renamed from: a */
    private void m27166a(String str) {
        Intent intent = new Intent();
        intent.putExtra("taxi_ticket", str);
        this.f38398a.setResult(-1, intent);
        this.f38398a.finish();
    }
}
