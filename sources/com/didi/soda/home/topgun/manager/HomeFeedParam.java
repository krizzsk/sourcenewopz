package com.didi.soda.home.topgun.manager;

import com.didi.soda.datasource.page.PageParams;

public class HomeFeedParam extends PageParams {

    /* renamed from: a */
    private int f42977a;

    /* renamed from: b */
    private String f42978b;

    /* renamed from: c */
    private boolean f42979c;

    /* renamed from: d */
    private String f42980d;

    /* renamed from: e */
    private String f42981e;

    public String getCateId() {
        return this.f42981e;
    }

    public void setCateId(String str) {
        this.f42981e = str;
    }

    public void updateFilterParam(String str) {
        this.f42978b = str;
    }

    public void setIsFilter(boolean z) {
        this.f42979c = z;
    }

    public boolean isFilter() {
        return this.f42979c;
    }

    public void setScene(int i) {
        this.f42977a = i;
    }

    public int getScene() {
        return this.f42977a;
    }

    public String getFilterParam() {
        return this.f42978b;
    }

    public String getTraceId() {
        return this.f42980d;
    }

    public void setTraceId(String str) {
        this.f42980d = str;
    }

    public void reset() {
        super.reset();
        this.f42978b = "";
    }
}
