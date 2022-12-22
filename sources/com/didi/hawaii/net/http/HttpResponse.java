package com.didi.hawaii.net.http;

public class HttpResponse {
    public String charset = "GBK";
    public byte[] data;

    public String toString() {
        try {
            return new String(this.data, this.charset);
        } catch (Exception unused) {
            return "";
        }
    }
}
