package com.didiglobal.privacy.domainmonitor.model;

public class OmegaReportParams {

    /* renamed from: a */
    private String f50537a;

    /* renamed from: b */
    private String f50538b;

    /* renamed from: c */
    private String f50539c;

    /* renamed from: d */
    private String f50540d;

    /* renamed from: e */
    private String f50541e;

    /* renamed from: f */
    private String f50542f;

    /* renamed from: g */
    private String f50543g;

    public OmegaReportParams(String str, String str2, String str3) {
        this(str, str2, str3, "");
    }

    public OmegaReportParams(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, "", "");
    }

    public OmegaReportParams(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f50537a = str;
        this.f50538b = str2;
        this.f50539c = str3;
        this.f50540d = str4;
        this.f50541e = str5;
        this.f50542f = str6;
    }

    public String getUrl() {
        return this.f50537a;
    }

    public void setUrl(String str) {
        this.f50537a = str;
    }

    public String getHost() {
        return this.f50538b;
    }

    public void setHost(String str) {
        this.f50538b = str;
    }

    public String getSource() {
        return this.f50539c;
    }

    public void setSource(String str) {
        this.f50539c = str;
    }

    public String getTraceId() {
        return this.f50540d;
    }

    public void setTraceId(String str) {
        this.f50540d = str;
    }

    public String getBffName() {
        return this.f50541e;
    }

    public void setBffName(String str) {
        this.f50541e = str;
    }

    public String getNetSource() {
        return this.f50542f;
    }

    public void setNetSource(String str) {
        this.f50542f = str;
    }

    public String getAlarmTag() {
        return this.f50543g;
    }

    public void setAlarmTag(String str) {
        this.f50543g = str;
    }
}
