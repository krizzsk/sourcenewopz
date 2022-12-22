package com.didi.rfusion.widget.tips;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class RFTipsConstant {
    public static final int BOTTOM_CENTER = 3;
    public static final int BOTTOM_LEFT = 4;
    public static final int BOTTOM_RIGHT = 5;
    public static final int TOP_CENTER = 0;
    public static final int TOP_LEFT = 1;
    public static final int TOP_RIGHT = 2;
    public static final int TYPE_DARK = 1;
    public static final int TYPE_LIGHT = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ArrowLocation {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }
}
