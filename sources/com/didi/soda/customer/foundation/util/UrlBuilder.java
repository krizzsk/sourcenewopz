package com.didi.soda.customer.foundation.util;

import android.net.Uri;
import android.text.TextUtils;

public final class UrlBuilder {

    /* renamed from: a */
    private Uri.Builder f41261a;

    private UrlBuilder(String str) {
        this.f41261a = Uri.parse(str).buildUpon();
    }

    public static UrlBuilder create(String str) {
        return new UrlBuilder(str);
    }

    public UrlBuilder appendParam(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f41261a.appendQueryParameter(str, str2);
        }
        return this;
    }

    public String build() {
        return this.f41261a.build().toString();
    }

    public Uri buildUri() {
        return this.f41261a.build();
    }
}
