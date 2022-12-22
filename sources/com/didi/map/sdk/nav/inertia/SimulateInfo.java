package com.didi.map.sdk.nav.inertia;

import com.didi.map.sdk.nav.car.AnimateNode;

public class SimulateInfo {
    public AnimateNode currentPoint;
    public long currentPointTimestamp;
    public boolean isRepeatPoint = false;
    public boolean isReported = false;
    public int mockType = 99;
    public int routeCode;
    public SctxStateEnum sctxStateEnum;
    public AnimateNode startPoint;
    public long startPointTimestamp;
    public long usablePointTimestamp;
    public AnimateNode useablePoint;

    public static class MockType {
        public static int SIMULATE_STOP_ON_OFFROUTE_JUMPTO_R = 5;
        public static int SIMULATE_STOP_ON_REACHED_DISTANCE_LIMIT = 1;
        public static int SIMULATE_STOP_ON_REACHED_LIMIT = 6;
        public static int SIMULATE_STOP_ON_REACHED_TIME_LIMIT = 2;
        public static int SIMULATINT_OVER_R_POINT_WAIT_DRIVER_POINT = 3;
        public static int SIMULATINT_WAIT_ARRIVE_R = 4;
    }

    public void reset() {
        this.startPoint = null;
        this.currentPoint = null;
        this.currentPointTimestamp = 0;
        this.useablePoint = null;
        this.usablePointTimestamp = 0;
        this.mockType = 99;
        this.routeCode = 0;
    }

    public int getRouteCode() {
        return this.routeCode;
    }

    public void setRouteCode(int i) {
        this.routeCode = i;
    }

    public AnimateNode getStartPoint() {
        return this.startPoint;
    }

    public void setStartPoint(AnimateNode animateNode) {
        this.startPoint = animateNode;
    }

    public AnimateNode getCurrentPoint() {
        return this.currentPoint;
    }

    public void setCurrentPoint(AnimateNode animateNode) {
        this.currentPoint = animateNode;
    }

    public long getCurrentPointTimestamp() {
        return this.currentPointTimestamp;
    }

    public void setCurrentPointTimestamp(long j) {
        this.currentPointTimestamp = j;
    }

    public AnimateNode getUseablePoint() {
        return this.useablePoint;
    }

    public void setUseablePoint(AnimateNode animateNode) {
        this.useablePoint = animateNode;
    }

    public long getUsablePointTimestamp() {
        return this.usablePointTimestamp;
    }

    public void setUsablePointTimestamp(long j) {
        this.usablePointTimestamp = j;
    }

    public int getMockType() {
        return this.mockType;
    }

    public void setMockType(int i) {
        this.mockType = i;
    }

    public SctxStateEnum getSctxStateEnum() {
        return this.sctxStateEnum;
    }

    public void setSctxStateEnum(SctxStateEnum sctxStateEnum2) {
        this.sctxStateEnum = sctxStateEnum2;
    }

    public boolean isReportable() {
        return (this.isReported || this.useablePoint == null || this.startPoint == null) ? false : true;
    }

    public void setReported(boolean z) {
        this.isReported = z;
    }

    public long getStartPointTimestamp() {
        return this.startPointTimestamp;
    }

    public void setStartPointTimestamp(long j) {
        this.startPointTimestamp = j;
    }

    public boolean isRepeatPoint() {
        return this.isRepeatPoint;
    }

    public void setRepeatPoint(boolean z) {
        this.isRepeatPoint = z;
    }
}
