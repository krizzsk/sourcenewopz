package com.didi.soda.web.overriders;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.core.net.MailTo;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.net.URISyntaxException;
import java.net.URLDecoder;

@ServiceProvider({IUrlOverriders.class})
public class CommonUrlOverrider implements IUrlOverriders {
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            if (str.startsWith("tel:")) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.DIAL");
                intent.setData(Uri.parse(str));
                webView.getContext().startActivity(intent);
                return true;
            } else if (str.startsWith(MailTo.MAILTO_SCHEME)) {
                Intent intent2 = new Intent("android.intent.action.SENDTO");
                if (str.contains("?body=")) {
                    intent2.setData(Uri.parse(str.substring(0, str.indexOf(63))));
                    intent2.putExtra("android.intent.extra.TEXT", URLDecoder.decode(str.substring(str.indexOf("?body=") + 6).replaceAll("%(?![0-9a-fA-F]{2})", "%25")));
                } else {
                    intent2.setData(Uri.parse(str));
                }
                webView.getContext().startActivity(intent2);
                return true;
            } else if (str.startsWith("sms:")) {
                webView.getContext().startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(str)));
                return true;
            } else if (str.startsWith("weixin:")) {
                webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } else if (str.startsWith("alipays:")) {
                webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } else {
                if (str.startsWith("intent:")) {
                    try {
                        Intent parseUri = Intent.parseUri(str, 1);
                        if (parseUri != null) {
                            String stringExtra = parseUri.getStringExtra("browser_fallback_url");
                            if (!TextUtils.isEmpty(stringExtra)) {
                                webView.loadUrl(stringExtra);
                            } else {
                                webView.getContext().startActivity(parseUri);
                            }
                            return true;
                        }
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    return false;
                }
                return false;
            }
        } catch (Exception unused) {
            Log.d("CommonUrlOverrider", "CommonUrlOverrider startacivity error");
        }
    }
}
