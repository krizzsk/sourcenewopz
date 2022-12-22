package com.didi.map.global.sdk.movement.sensor;

public class PdrPoint {

    /* renamed from: x */
    public float f27740x;

    /* renamed from: y */
    public float f27741y;

    public PdrPoint() {
        this.f27740x = 0.0f;
        this.f27741y = 0.0f;
    }

    public PdrPoint(PdrPoint pdrPoint) {
        this.f27740x = pdrPoint.f27740x;
        this.f27741y = pdrPoint.f27741y;
    }

    public PdrPoint(float f, float f2) {
        this.f27740x = f;
        this.f27741y = f2;
    }

    public String toString() {
        return "Point(" + this.f27740x + "," + this.f27741y + ")";
    }

    public static PdrPoint getNextPoint(PdrPoint pdrPoint, float f, float f2) {
        if (pdrPoint == null) {
            return null;
        }
        if (f2 >= 0.0f && f2 <= 90.0f) {
            PdrPoint pdrPoint2 = new PdrPoint();
            double d = (double) f;
            double d2 = (double) (90.0f - f2);
            pdrPoint2.f27740x = ((float) Math.round((((double) pdrPoint.f27740x) + (Math.cos(Math.toRadians(d2)) * d)) * 100.0d)) / 100.0f;
            pdrPoint2.f27741y = ((float) Math.round((((double) pdrPoint.f27741y) + (d * Math.sin(Math.toRadians(d2)))) * 100.0d)) / 100.0f;
            return pdrPoint2;
        } else if (f2 > 90.0f && f2 <= 180.0f) {
            PdrPoint pdrPoint3 = new PdrPoint();
            double d3 = (double) f;
            double d4 = (double) (f2 - 90.0f);
            pdrPoint3.f27740x = ((float) Math.round((((double) pdrPoint.f27740x) + (Math.cos(Math.toRadians(d4)) * d3)) * 100.0d)) / 100.0f;
            pdrPoint3.f27741y = ((float) Math.round((((double) pdrPoint.f27741y) - (d3 * Math.sin(Math.toRadians(d4)))) * 100.0d)) / 100.0f;
            return pdrPoint3;
        } else if (f2 > 180.0f && f2 <= 270.0f) {
            PdrPoint pdrPoint4 = new PdrPoint();
            double d5 = (double) f;
            double d6 = (double) (270.0f - f2);
            pdrPoint4.f27740x = ((float) Math.round((((double) pdrPoint.f27740x) - (Math.cos(Math.toRadians(d6)) * d5)) * 100.0d)) / 100.0f;
            pdrPoint4.f27741y = ((float) Math.round((((double) pdrPoint.f27741y) - (d5 * Math.sin(Math.toRadians(d6)))) * 100.0d)) / 100.0f;
            return pdrPoint4;
        } else if (f2 <= 270.0f || f2 >= 360.0f) {
            return null;
        } else {
            PdrPoint pdrPoint5 = new PdrPoint();
            double d7 = (double) f;
            double d8 = (double) (f2 - 270.0f);
            pdrPoint5.f27740x = ((float) Math.round((((double) pdrPoint.f27740x) - (Math.cos(Math.toRadians(d8)) * d7)) * 100.0d)) / 100.0f;
            pdrPoint5.f27741y = ((float) Math.round((((double) pdrPoint.f27741y) + (d7 * Math.sin(Math.toRadians(d8)))) * 100.0d)) / 100.0f;
            return pdrPoint5;
        }
    }

    public static float getDirectBetweenPoints(PdrPoint pdrPoint, PdrPoint pdrPoint2) {
        if (!(pdrPoint == null || pdrPoint2 == null)) {
            if (pdrPoint.f27741y == pdrPoint2.f27741y && pdrPoint.f27740x > pdrPoint2.f27740x) {
                return 270.0f;
            }
            if (pdrPoint.f27741y == pdrPoint2.f27741y && pdrPoint.f27740x < pdrPoint2.f27740x) {
                return 90.0f;
            }
            if (pdrPoint.f27741y == pdrPoint2.f27741y && pdrPoint.f27740x == pdrPoint2.f27740x) {
                return Float.NaN;
            }
            if (pdrPoint.f27741y > pdrPoint2.f27741y && pdrPoint.f27740x == pdrPoint2.f27740x) {
                return 180.0f;
            }
            if (pdrPoint.f27741y < pdrPoint2.f27741y && pdrPoint.f27740x == pdrPoint2.f27740x) {
                return 0.0f;
            }
            float atan2 = (float) ((Math.atan2((double) Math.abs(pdrPoint.f27741y - pdrPoint2.f27741y), (double) Math.abs(pdrPoint.f27740x - pdrPoint2.f27740x)) * 180.0d) / 3.141592653589793d);
            if (pdrPoint.f27741y > pdrPoint2.f27741y && pdrPoint.f27740x > pdrPoint2.f27740x) {
                return 270.0f - atan2;
            }
            if (pdrPoint.f27741y > pdrPoint2.f27741y && pdrPoint.f27740x < pdrPoint2.f27740x) {
                return atan2 + 90.0f;
            }
            if (pdrPoint.f27741y < pdrPoint2.f27741y && pdrPoint.f27740x > pdrPoint2.f27740x) {
                return atan2 + 270.0f;
            }
            if (pdrPoint.f27741y < pdrPoint2.f27741y && pdrPoint.f27740x < pdrPoint2.f27740x) {
                return 90.0f - atan2;
            }
        }
        return Float.NaN;
    }

    public static float getDistanceBetweenPoints(PdrPoint pdrPoint, PdrPoint pdrPoint2) {
        if (pdrPoint == null || pdrPoint2 == null) {
            return Float.NaN;
        }
        return (float) Math.sqrt(Math.pow((double) (pdrPoint.f27740x - pdrPoint2.f27740x), 2.0d) + Math.pow((double) (pdrPoint.f27741y - pdrPoint2.f27741y), 2.0d));
    }
}
