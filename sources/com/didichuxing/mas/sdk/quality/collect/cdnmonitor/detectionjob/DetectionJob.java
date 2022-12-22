package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detectionjob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectionJob {

    /* renamed from: a */
    private String f47737a;

    /* renamed from: b */
    private String f47738b;

    /* renamed from: c */
    private List<String> f47739c;

    DetectionJob(String str, String str2, String str3) {
        this.f47737a = str;
        this.f47738b = str2;
        if (str3 == null || str3.equals("")) {
            this.f47739c = new ArrayList();
        } else {
            this.f47739c = Arrays.asList(str3.trim().toUpperCase().split(","));
        }
    }

    public String getUrl() {
        return this.f47737a;
    }

    public void setUrl(String str) {
        this.f47737a = str;
    }

    public String getMd5() {
        return this.f47738b;
    }

    public void setMd5(String str) {
        this.f47738b = str;
    }

    public List<String> getCcc() {
        return this.f47739c;
    }

    public void setCcc(List<String> list) {
        this.f47739c = list;
    }
}
