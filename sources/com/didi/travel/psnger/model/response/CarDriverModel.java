package com.didi.travel.psnger.model.response;

import com.didichuxing.carsliding.model.Driver;

public class CarDriverModel extends Driver {
    public int carLevel;
    public int debugStatus;
    public String debugStatusDetail;

    public CarDriverModel(String str) {
        super(str);
    }

    public int getDebugStatus() {
        return this.debugStatus;
    }

    public void setDebugStatus(int i) {
        this.debugStatus = i;
    }

    public String getDebugStatusDetail() {
        return this.debugStatusDetail;
    }

    public void setDebugStatusDetail(String str) {
        this.debugStatusDetail = str;
    }

    public int getCarLevel() {
        return this.carLevel;
    }

    public void setCarLevel(int i) {
        this.carLevel = i;
    }
}
