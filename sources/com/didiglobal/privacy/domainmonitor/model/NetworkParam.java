package com.didiglobal.privacy.domainmonitor.model;

import android.text.TextUtils;

public class NetworkParam {

    /* renamed from: a */
    private String f50532a = "";

    /* renamed from: b */
    private long f50533b;

    /* renamed from: c */
    private long f50534c;

    /* renamed from: d */
    private int f50535d = -1;

    /* renamed from: e */
    private String f50536e = "";

    public long getDownloadByteCount() {
        return this.f50534c;
    }

    public void setDownloadByteCount(long j) {
        this.f50534c = j;
    }

    public String getUrl() {
        return this.f50532a;
    }

    public void setUrl(String str) {
        this.f50532a = str;
    }

    public long getUploadByteCount() {
        return this.f50533b;
    }

    public void setUploadByteCount(long j) {
        this.f50533b = j;
    }

    public boolean isInvalid() {
        return TextUtils.isEmpty(this.f50532a) && (this.f50533b > 0 || this.f50534c > 0);
    }

    public int getStatusCode() {
        return this.f50535d;
    }

    public void setStatusCode(int i) {
        this.f50535d = i;
    }

    public String getErrorMessage() {
        return this.f50536e;
    }

    public void appendErrorMessage(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f50536e = str;
        }
    }

    public String toString() {
        return "NetworkParam{url='" + this.f50532a + '\'' + ", uploadByteCount=" + this.f50533b + ", downloadByteCount=" + this.f50534c + ", statusCode=" + this.f50535d + ", errorMessage='" + this.f50536e + '\'' + '}';
    }
}
