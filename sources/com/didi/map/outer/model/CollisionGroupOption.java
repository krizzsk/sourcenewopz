package com.didi.map.outer.model;

import android.graphics.Rect;

public class CollisionGroupOption {
    private Rect screenPadding;

    public Rect getScreenPadding() {
        return this.screenPadding;
    }

    public CollisionGroupOption setScreenPadding(Rect rect) {
        this.screenPadding = rect;
        return this;
    }
}
