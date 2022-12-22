package com.didi.rfusion.widget.button;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface RFButtonConst {
    public static final int LARGE = 0;
    public static final int MAX = 2;
    public static final int SMALL = 1;

    public interface ButtonPosition {
        public static final int LEFT = 0;
        public static final int RIGHT = 1;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Position {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSpec {
    }

    public interface GhostButtonType {
        public static final int DARK = 1;
        public static final int LIGHT = 0;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }
    }

    public interface TextButtonType {
        public static final int DARK = 1;
        public static final int LIGHT = 0;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }
    }
}
