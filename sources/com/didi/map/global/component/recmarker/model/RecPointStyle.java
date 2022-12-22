package com.didi.map.global.component.recmarker.model;

import android.graphics.Bitmap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class RecPointStyle {
    public int defaultStyle = 1;
    public Bitmap icon;
    public boolean isShowAddressName;
    public boolean isShowInfoWindow;
    public Bitmap selectedIcon;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DefaultRecStyle {
        public static final int GRREN = 1;
        public static final int ORANGE = 2;
    }
}
