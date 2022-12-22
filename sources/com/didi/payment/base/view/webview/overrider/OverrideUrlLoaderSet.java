package com.didi.payment.base.view.webview.overrider;

import android.webkit.WebView;
import java.util.LinkedHashSet;
import java.util.Set;

public class OverrideUrlLoaderSet implements OverrideUrlLoader {

    /* renamed from: a */
    private Set<OverrideUrlLoader> f30050a = new LinkedHashSet();

    public void addOverrideUrlLoader(OverrideUrlLoader overrideUrlLoader) {
        if (overrideUrlLoader != null) {
            this.f30050a.add(overrideUrlLoader);
        }
    }

    public boolean removeOverrideUrlLoader(OverrideUrlLoader overrideUrlLoader) {
        return this.f30050a.remove(overrideUrlLoader);
    }

    public void clearAllOverrideUrlLoaders() {
        this.f30050a.clear();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        for (OverrideUrlLoader shouldOverrideUrlLoading : this.f30050a) {
            if (shouldOverrideUrlLoading.shouldOverrideUrlLoading(webView, str)) {
                return true;
            }
        }
        return false;
    }
}
