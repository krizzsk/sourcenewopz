package com.didi.map.global.sdk.movement.sensor;

import com.didi.common.map.util.DLog;

public class PdrPointBounds {
    public int count = 0;
    public int errCount = 0;

    /* renamed from: lt */
    public PdrPoint f27742lt;

    /* renamed from: rb */
    public PdrPoint f27743rb;

    public void append(PdrPoint pdrPoint) {
        if (this.count <= 0) {
            this.f27742lt = new PdrPoint(pdrPoint);
            this.f27743rb = new PdrPoint(pdrPoint);
            this.count = 1;
        } else if (PdrPoint.getDistanceBetweenPoints(pdrPoint, getCenter()) < 3.0f) {
            this.f27742lt.f27740x = Math.min(pdrPoint.f27740x, this.f27742lt.f27740x);
            this.f27742lt.f27741y = Math.max(pdrPoint.f27741y, this.f27742lt.f27741y);
            this.f27743rb.f27740x = Math.max(pdrPoint.f27740x, this.f27742lt.f27740x);
            this.f27743rb.f27741y = Math.min(pdrPoint.f27741y, this.f27742lt.f27741y);
            this.count++;
            int i = this.errCount;
            if (i > 0) {
                this.errCount = i - 1;
            }
        } else {
            int i2 = this.errCount + 1;
            this.errCount = i2;
            if (i2 >= 3) {
                DLog.m7384d("ccc", "累计失败3次了", new Object[0]);
                this.f27742lt = new PdrPoint(pdrPoint);
                this.f27743rb = new PdrPoint(pdrPoint);
                this.count = 1;
                this.errCount = 0;
            }
        }
    }

    public PdrPoint getCenter() {
        return new PdrPoint((this.f27742lt.f27740x + this.f27743rb.f27740x) / 2.0f, (this.f27742lt.f27741y + this.f27743rb.f27741y) / 2.0f);
    }
}
