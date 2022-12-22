package com.didichuxing.mas.sdk.quality.report.customevent;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CustomEvent {
    private static final int CUSTOM_EVENT_MAX_ADD_NUM = 3;
    private String key;
    private final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
    long updateTime;

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getValue() {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        while (!this.queue.isEmpty()) {
            String poll = this.queue.poll();
            if (z) {
                sb.append(poll);
                z = false;
            } else {
                sb.append("->");
                sb.append(poll);
            }
        }
        return sb.toString();
    }

    public void setValue(String str) {
        this.queue.clear();
        this.updateTime = System.currentTimeMillis();
        this.queue.add(str);
    }

    public void addValue(String str) {
        if (!this.queue.isEmpty() && this.queue.size() >= 3) {
            this.queue.poll();
        }
        this.updateTime = System.currentTimeMillis();
        this.queue.add(str);
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public CustomEvent(String str, String str2) {
        this.key = str;
        setValue(str2);
    }

    public String toString() {
        return "CustomEvent{key='" + this.key + '\'' + ", value='" + getValue() + '\'' + ", updateTime=" + this.updateTime + '}';
    }
}
