package com.didi.map.outer.model;

import android.graphics.Rect;

public class CollisionStubOption {
    private int collisionType = 274;
    private int priority;
    private Rect screenBound;
    private int type = 16;

    public int getCollisionType() {
        return this.collisionType;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getType() {
        return this.type;
    }

    public CollisionStubOption setPriority(int i) {
        this.priority = i;
        return this;
    }

    public Rect getScreenBound() {
        return this.screenBound;
    }

    public CollisionStubOption setScreenBound(Rect rect) {
        this.screenBound = rect;
        return this;
    }
}
