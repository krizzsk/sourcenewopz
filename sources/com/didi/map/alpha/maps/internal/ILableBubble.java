package com.didi.map.alpha.maps.internal;

import android.content.Context;
import android.graphics.Bitmap;

public interface ILableBubble {
    public static final int BLOCK_TYPE_JAM = 0;
    public static final int BLOCK_TYPE_JAM_BLOCK = 1;
    public static final int BLOCK_TYPE_JAM_HOSPITAL = 4;
    public static final int BLOCK_TYPE_JAM_IMAGE = 5;
    public static final int BLOCK_TYPE_JAM_MULTI = 2;
    public static final int BLOCK_TYPE_JAM_SCHOOL = 3;
    public static final byte DIRECTION_LB = 1;
    public static final byte DIRECTION_LT = 0;
    public static final byte DIRECTION_RB = 3;
    public static final byte DIRECTION_RT = 2;
    public static final int MARKER_DIRECTION_LEFT = 1;
    public static final int MARKER_DIRECTION_ORIGINAL = 0;
    public static final int MARKER_DIRECTION_RIGHT = 2;

    String getIconFileName(boolean z, String str);

    Bitmap getMarkerBitmap(Context context, String str, int i, String str2, String str3, boolean z, int i2);

    String getMarkerFileName(boolean z, String str, int i);

    int getTextColor(boolean z, String str);
}
