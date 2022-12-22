package com.didichuxing.omega.sdk.cdnmonitor.detectionjob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectionJob {
    private List<String> ccc;
    private String md5;
    private String url;

    DetectionJob(String str, String str2, String str3) {
        this.url = str;
        this.md5 = str2;
        if (str3 == null || str3.equals("")) {
            this.ccc = new ArrayList();
        } else {
            this.ccc = Arrays.asList(str3.trim().toUpperCase().split(","));
        }
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getMd5() {
        return this.md5;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public List<String> getCcc() {
        return this.ccc;
    }

    public void setCcc(List<String> list) {
        this.ccc = list;
    }
}
