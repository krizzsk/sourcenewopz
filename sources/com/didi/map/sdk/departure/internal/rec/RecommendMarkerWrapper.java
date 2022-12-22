package com.didi.map.sdk.departure.internal.rec;

public class RecommendMarkerWrapper implements Comparable<RecommendMarkerWrapper> {

    /* renamed from: a */
    private Square f28220a = null;
    public boolean mIsDuplicate = false;

    public RecommendMarkerWrapper(Square square) {
        this.f28220a = square;
    }

    public Square getTarget() {
        return this.f28220a;
    }

    public boolean mayCollisionTest(RecommendMarkerWrapper recommendMarkerWrapper) {
        Square target = recommendMarkerWrapper.getTarget();
        double a = m20043a(this.f28220a);
        double b = m20044b(this.f28220a);
        double a2 = m20043a(target);
        double abs = Math.abs(b - m20044b(target)) - ((double) ((target.getHeight() + this.f28220a.getHeight()) / 2.0f));
        if (Math.abs(a - a2) - ((double) ((target.getWidth() + this.f28220a.getWidth()) / 2.0f)) < 0.0d && abs < 0.0d) {
            return true;
        }
        if (Math.abs(a - (a2 - ((double) this.f28220a.getWidth()))) - ((double) ((target.getWidth() + this.f28220a.getWidth()) / 2.0f)) >= 0.0d || abs >= 0.0d) {
            return false;
        }
        return true;
    }

    public boolean collisionTest(RecommendMarkerWrapper recommendMarkerWrapper) {
        Square target = recommendMarkerWrapper.getTarget();
        return Math.abs(m20043a(this.f28220a) - m20043a(target)) - ((double) ((target.getWidth() + this.f28220a.getWidth()) / 2.0f)) < 0.0d && Math.abs(m20044b(this.f28220a) - m20044b(target)) - ((double) ((target.getHeight() + this.f28220a.getHeight()) / 2.0f)) < 0.0d;
    }

    /* renamed from: a */
    private double m20043a(Square square) {
        return square.getX();
    }

    /* renamed from: b */
    private double m20044b(Square square) {
        return square.getY();
    }

    public int compareTo(RecommendMarkerWrapper recommendMarkerWrapper) {
        Square target = recommendMarkerWrapper.getTarget();
        double a = m20043a(this.f28220a);
        double a2 = m20043a(target);
        if (a < a2) {
            return -1;
        }
        return a > a2 ? 1 : 0;
    }

    public boolean isCollision(RecommendMarkerWrapper recommendMarkerWrapper, double d) {
        double d2;
        Square target = recommendMarkerWrapper.getTarget();
        double a = m20043a(this.f28220a);
        double b = m20044b(this.f28220a);
        double width = (double) this.f28220a.getWidth();
        double height = (double) this.f28220a.getHeight();
        double a2 = m20043a(target);
        double b2 = m20044b(target);
        double width2 = (double) target.getWidth();
        double height2 = (double) target.getHeight();
        if (a < a2) {
            d2 = Math.abs(a - a2) - width;
        } else {
            d2 = Math.abs(a - a2) - width2;
        }
        return d2 - (d * 2.0d) < 0.0d && (Math.abs(b - b2) - ((height + height2) / 2.0d)) - (d * 2.0d) < 0.0d;
    }
}
