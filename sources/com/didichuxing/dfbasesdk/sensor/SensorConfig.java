package com.didichuxing.dfbasesdk.sensor;

public class SensorConfig {
    public int delay = 200;
    public int limit = 20;
    public int type;

    public int getType() {
        return this.type;
    }

    public int getDelay() {
        return this.delay;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setDelay(int i) {
        this.delay = i;
    }

    public void setLimit(int i) {
        this.limit = i;
    }
}
