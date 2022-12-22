package com.turbomanage.httpclient;

import com.didichuxing.apollo.sdk.utils.GzipUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public class HttpResponse {
    private byte[] body;
    private Map<String, List<String>> headers;
    private int status;
    private String url;

    public HttpResponse(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            this.status = httpURLConnection.getResponseCode();
            this.url = httpURLConnection.getURL().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.headers = httpURLConnection.getHeaderFields();
        String contentEncoding = httpURLConnection.getContentEncoding();
        if (contentEncoding == null || !contentEncoding.equals("gzip")) {
            this.body = bArr;
            return;
        }
        try {
            this.body = GzipUtil.decompress(new ByteArrayInputStream(bArr)).getBytes();
        } catch (Exception e2) {
            e2.printStackTrace();
            this.body = bArr;
        }
    }

    public int getStatus() {
        return this.status;
    }

    public String getUrl() {
        return this.url;
    }

    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public byte[] getBody() {
        return this.body;
    }

    public String getBodyAsString() {
        if (this.body != null) {
            return new String(this.body);
        }
        return null;
    }
}
