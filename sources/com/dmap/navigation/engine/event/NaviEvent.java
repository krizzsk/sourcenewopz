package com.dmap.navigation.engine.event;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class NaviEvent {
    public static final int HIDE = 2;
    public static final int NOACTION = 4;
    public static final int SHOW = 0;
    public static final int UPDATE = 1;
    public static final int WILLSHOW = 3;

    @Retention(RetentionPolicy.SOURCE)
    public @interface UpdateType {
    }
}
