package com.didichuxing.doraemonkit.kit.network.common;

import com.didichuxing.doraemonkit.kit.network.core.NetworkInterpreter;
import java.util.List;

public class CommonInspectorResponse implements NetworkInterpreter.InspectorResponse {

    /* renamed from: a */
    private final int f47551a;

    /* renamed from: b */
    private final String f47552b;

    /* renamed from: c */
    private final int f47553c;

    /* renamed from: d */
    private final CommonHeaders f47554d;

    public CommonInspectorResponse(int i, String str, int i2, CommonHeaders commonHeaders) {
        this.f47551a = i;
        this.f47552b = str;
        this.f47553c = i2;
        this.f47554d = commonHeaders;
    }

    public int requestId() {
        return this.f47551a;
    }

    public String url() {
        return this.f47552b;
    }

    public int statusCode() {
        return this.f47553c;
    }

    public int headerCount() {
        CommonHeaders commonHeaders = this.f47554d;
        if (commonHeaders != null) {
            return commonHeaders.size();
        }
        return 0;
    }

    public String headerName(int i) {
        CommonHeaders commonHeaders = this.f47554d;
        if (commonHeaders != null) {
            return commonHeaders.name(i);
        }
        return null;
    }

    public String headerValue(int i) {
        CommonHeaders commonHeaders = this.f47554d;
        if (commonHeaders != null) {
            return commonHeaders.value(i);
        }
        return null;
    }

    public String firstHeaderValue(String str) {
        List<String> values;
        CommonHeaders commonHeaders = this.f47554d;
        if (commonHeaders == null || (values = commonHeaders.values(str)) == null || values.size() <= 0) {
            return null;
        }
        return values.get(0);
    }
}
