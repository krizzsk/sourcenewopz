package com.didichuxing.omega.sdk.cdnmonitor.detectionjob;

import java.util.ArrayList;
import java.util.List;

public class DetectionJobs {
    private List<DetectionJob> cdnJobs = new ArrayList();
    private int errorNo;

    public int getErrorNo() {
        return this.errorNo;
    }

    public void setErrorNo(int i) {
        this.errorNo = i;
    }

    public List<DetectionJob> getCdnJobs() {
        return this.cdnJobs;
    }

    public void setCdnJobs(List<DetectionJob> list) {
        this.cdnJobs = list;
    }

    public void addDetectionJob(String str, String str2, String str3) {
        this.cdnJobs.add(new DetectionJob(str, str2, str3));
    }
}
