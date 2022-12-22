package com.didi.one.netdetect.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DetectionGroup implements Serializable {
    private static final int MAX_COUNT = 20;
    private static final int MAX_HTTP_TIMEOUT = 2000;
    private static final int MAX_PERCENT = 100;
    private static final int MAX_PING_TIMEOUT = 2000;
    private static final int MIN_DETECT_INTERVAL = 180;
    private static final int MIN_PING_OUTPUT_INTERVAL = 1800;
    private static final int MIN_TRACE_ROUTE_INTERVAL = 1800;
    public int detecTimeout;
    public int detectInterval = 120;
    public List<DetectionItem> detectList = new ArrayList();
    public int pingCount;
    public int pingOutputInterval;
    public int pingOutputPercent;
    public int pingTimeout;
    public List<String> reportUrl = new ArrayList();
    public int trInterval;
    public int trPercent;

    public void checkValid() {
        int size = this.detectList.size();
        if (size > 20) {
            while (true) {
                size--;
                if (size <= 19) {
                    break;
                }
                this.detectList.remove(size);
            }
        }
        if (this.detecTimeout > 2000) {
            this.detecTimeout = 2000;
        }
        if (this.pingTimeout > 2000) {
            this.pingTimeout = 2000;
        }
        if (this.detectInterval < 180) {
            this.detectInterval = 180;
        }
        if (this.trInterval < 1800) {
            this.trInterval = 180;
        }
        if (this.trPercent > 100) {
            this.trPercent = 100;
        }
        if (this.pingOutputInterval < 1800) {
            this.pingOutputInterval = 180;
        }
        if (this.pingOutputPercent > 100) {
            this.pingOutputPercent = 100;
        }
    }
}
