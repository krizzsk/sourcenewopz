package com.didi.map.sdk.nav.car;

import com.didi.common.map.model.LatLng;

public class AnimationPartNode {
    public int index;
    public boolean isEraseEnd;
    public boolean isEraseRunning;
    public boolean jump;
    public LatLng latLng;
    public int offset;
    public long totalDuration;
    public AnimateNodeStatus type;

    public AnimationPartNode(long j, LatLng latLng2, int i, int i2, boolean z, boolean z2, boolean z3, AnimateNodeStatus animateNodeStatus) {
        this.totalDuration = j;
        this.latLng = latLng2;
        this.index = i;
        this.isEraseRunning = z;
        this.isEraseEnd = z2;
        this.type = animateNodeStatus;
        this.jump = z3;
        this.offset = i2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        LatLng latLng2 = this.latLng;
        sb.append(latLng2 == null ? "lat/lng: (null)" : latLng2.toString());
        sb.append(",totalDuration=" + this.totalDuration);
        sb.append(",isEraseEnd=" + this.isEraseEnd);
        sb.append(",isEraseRunning=" + this.isEraseRunning);
        sb.append(",index=" + this.index);
        sb.append(",offset=" + this.offset);
        sb.append(",jump=" + this.jump);
        sb.append(",type=" + this.type.name());
        return sb.toString();
    }
}
