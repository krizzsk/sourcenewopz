package com.didi.global.ninja.strategy;

import android.content.Context;

public interface IStrategy {
    void filter();

    String getName();

    boolean init();

    boolean isHit();

    void setContext(Context context);
}
