package com.didichuxing.mas.sdk.quality.report.transport;

import java.util.List;
import java.util.Map;

public class HttpResponse {
    private String body;
    private Map<String, List<String>> headers;

    public String getBody() {
        return this.body;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public void setHeaders(Map<String, List<String>> map) {
        this.headers = map;
    }
}
