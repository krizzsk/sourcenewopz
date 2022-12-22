package com.didi.one.netdetect.model;

import com.didi.one.netdetect.command.PingResult;
import com.didi.one.netdetect.task.DidiHttpTask;
import java.io.Serializable;

public class DetectionItemResult implements Serializable {
    public int detectErrCode;
    public int detectId;
    public String detectIp;
    public int detectTime;
    public String detectType;
    public int dnsTime;
    public String downFileMd5;
    public int initialConnTime;
    public String localDns;
    public int pingErrorNum;
    public String pingIp;
    public String pingOutput;
    public int pingTime;
    public int reqSendTime;
    public String resHeaders;
    public int resReadTime;
    public int sslTime;
    public int waitingTime;

    public void resolveHttpTaskResult(DidiHttpTask.HttpTaskResult httpTaskResult) {
        if (httpTaskResult != null) {
            this.detectErrCode = httpTaskResult.getCode();
            this.detectTime = httpTaskResult.getConsumeTime();
            this.detectIp = httpTaskResult.getDetectIp();
            this.detectType = httpTaskResult.getDetectType();
            this.localDns = httpTaskResult.getLocalDns();
            this.dnsTime = httpTaskResult.getDnsTime();
            this.initialConnTime = httpTaskResult.getInitialConnTime();
            this.sslTime = httpTaskResult.getSslTime();
            this.reqSendTime = httpTaskResult.getReqSentTime();
            this.waitingTime = httpTaskResult.getWaitingTime();
            this.resReadTime = httpTaskResult.getResReadTime();
            this.resHeaders = httpTaskResult.getResHeaders();
            this.downFileMd5 = httpTaskResult.getDownFileMd5();
        }
    }

    public void resolvePingTaskResult(PingResult pingResult) {
        if (pingResult != null) {
            this.pingIp = pingResult.getIp();
            this.pingTime = (int) pingResult.getAverageTime();
            this.pingErrorNum = pingResult.getFailCount();
        }
    }

    public void resolvePingTaskResultExtra(PingResult pingResult) {
        if (pingResult != null) {
            this.pingOutput = pingResult.getNormalValue() + pingResult.getErrValue();
        }
    }
}
