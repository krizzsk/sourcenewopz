package com.didi.raven.model;

public class RavenPoolConfigModel {
    private int cache_max = 2048;
    private int count = 5;
    private long delay = 5000;
    private int max = 2048;
    private int postMax = 20;

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public long getDelay() {
        return this.delay;
    }

    public void setDelay(long j) {
        this.delay = j;
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int i) {
        this.max = i;
    }

    public int getPostMax() {
        return this.postMax;
    }

    public void setPostMax(int i) {
        this.postMax = i;
    }

    public int getCacheMax() {
        return this.cache_max;
    }

    public void setCacheMax(int i) {
        this.cache_max = i;
    }
}
