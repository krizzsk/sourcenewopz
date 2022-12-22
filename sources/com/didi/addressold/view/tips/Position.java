package com.didi.addressold.view.tips;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Position {

    @Retention(RetentionPolicy.SOURCE)
    public @interface HorizontalPosition {
        public static final int ALIGN_LEFT = 3;
        public static final int ALIGN_RIGHT = 4;
        public static final int CENTER = 0;
        public static final int LEFT = 1;
        public static final int RIGHT = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VerticalPosition {
        public static final int ABOVE = 1;
        public static final int ALIGN_BOTTOM = 4;
        public static final int ALIGN_TOP = 3;
        public static final int BELOW = 2;
        public static final int CENTER = 0;
    }
}
