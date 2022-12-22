package com.didi.rfusion.widget.selector;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface RFSelectorConst {
    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SelectorType {
    }
}
