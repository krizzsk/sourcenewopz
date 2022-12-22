package com.didichuxing.doraemonkit.kit.network.common;

import android.text.TextUtils;
import com.didichuxing.doraemonkit.kit.network.core.NetworkInterpreter;
import java.util.List;

public class CommonInspectorRequest implements NetworkInterpreter.InspectorRequest {

    /* renamed from: a */
    private final int f47546a;

    /* renamed from: b */
    private final String f47547b;

    /* renamed from: c */
    private final String f47548c;

    /* renamed from: d */
    private final String f47549d;

    /* renamed from: e */
    private final CommonHeaders f47550e;

    public CommonInspectorRequest(int i, String str, String str2, String str3, CommonHeaders commonHeaders) {
        this.f47546a = i;
        this.f47547b = str;
        this.f47548c = str2;
        this.f47549d = str3;
        this.f47550e = commonHeaders;
    }

    /* renamed from: id */
    public int mo117100id() {
        return this.f47546a;
    }

    public String url() {
        return this.f47547b;
    }

    public String method() {
        return this.f47548c;
    }

    public byte[] body() {
        if (TextUtils.isEmpty(this.f47549d)) {
            return null;
        }
        return this.f47549d.getBytes();
    }

    public int headerCount() {
        CommonHeaders commonHeaders = this.f47550e;
        if (commonHeaders != null) {
            return commonHeaders.size();
        }
        return 0;
    }

    public String headerName(int i) {
        CommonHeaders commonHeaders = this.f47550e;
        if (commonHeaders != null) {
            return commonHeaders.name(i);
        }
        return null;
    }

    public String headerValue(int i) {
        CommonHeaders commonHeaders = this.f47550e;
        if (commonHeaders != null) {
            return commonHeaders.value(i);
        }
        return null;
    }

    public String firstHeaderValue(String str) {
        List<String> values;
        CommonHeaders commonHeaders = this.f47550e;
        if (commonHeaders == null || (values = commonHeaders.values(str)) == null || values.size() <= 0) {
            return null;
        }
        return values.get(0);
    }
}
