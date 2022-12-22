package com.didi.rfusion.widget.toast;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface RFToastConstant {
    public static final int DARK = 1;
    public static final int LIGHT = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }
}
