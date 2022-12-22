package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detectionjob;

import java.util.ArrayList;
import java.util.List;

public class DetectionJobs {

    /* renamed from: a */
    private int f47740a;

    /* renamed from: b */
    private List<DetectionJob> f47741b = new ArrayList();

    public int getErrorNo() {
        return this.f47740a;
    }

    public void setErrorNo(int i) {
        this.f47740a = i;
    }

    public List<DetectionJob> getCdnJobs() {
        return this.f47741b;
    }

    public void setCdnJobs(List<DetectionJob> list) {
        this.f47741b = list;
    }

    public void addDetectionJob(String str, String str2, String str3) {
        this.f47741b.add(new DetectionJob(str, str2, str3));
    }
}
