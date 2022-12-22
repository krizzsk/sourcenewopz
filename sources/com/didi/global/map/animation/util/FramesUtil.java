package com.didi.global.map.animation.util;

import android.content.Context;
import android.content.res.Resources;
import com.didi.common.map.model.LatLng;
import com.didi.global.map.animation.SodaAnimEngine;
import com.taxis99.R;
import java.util.ArrayList;
import rui.config.RConfigConstants;

public class FramesUtil {
    public static final int[] customer_frames = {R.drawable.c_00000, R.drawable.c_00001, R.drawable.c_00002, R.drawable.c_00003, R.drawable.c_00004, R.drawable.c_00005, R.drawable.c_00006, R.drawable.c_00007, R.drawable.c_00008, R.drawable.c_00009, R.drawable.c_00010, R.drawable.c_00011, R.drawable.c_00012, R.drawable.c_00013, R.drawable.c_00014, R.drawable.c_00015, R.drawable.c_00016, R.drawable.c_00017, R.drawable.c_00018, R.drawable.c_00019, R.drawable.c_00020, R.drawable.c_00021, R.drawable.c_00022, R.drawable.c_00023, R.drawable.c_00024, R.drawable.c_00025};

    public static int getCustomerInitialResourceId() {
        return R.drawable.c_00025;
    }

    public static int getBusinessInitialResourceId(Context context) {
        return getBusinessFrame(context, 28);
    }

    public static int getDeliveryInitialResourceId(Context context) {
        return getDeliveryFrame(context, SodaAnimEngine.DefaultAngleFrame);
    }

    public static void initDefaultAngle(LatLng latLng, LatLng latLng2) {
        SodaAnimEngine.DefaultAngle = AngleUtil.getAngle(latLng, latLng2);
        SodaAnimEngine.DefaultAngleFrame = AngleUtil.getIndexByAngle(SodaAnimEngine.DefaultAngle);
        AngleManager.getInstant().setFromIndex(SodaAnimEngine.DefaultAngleFrame);
        AngleManager.getInstant().setToIndex(SodaAnimEngine.DefaultAngleFrame);
    }

    public static int getBusinessFrame(Context context, int i) {
        String str;
        StringBuilder sb;
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        if (i < 10) {
            sb = new StringBuilder();
            str = "0";
        } else {
            sb = new StringBuilder();
            str = "";
        }
        sb.append(str);
        sb.append(i);
        String sb2 = sb.toString();
        Resources resources = applicationContext.getResources();
        return resources.getIdentifier("bb_000" + sb2, RConfigConstants.TYPE_DRAWABLE, packageName);
    }

    public static int[] getBusinessFrames(Context context) {
        int[] iArr = new int[29];
        for (int i = 0; i <= 28; i++) {
            iArr[i] = getBusinessFrame(context, i);
        }
        return iArr;
    }

    public static int getDeliveryFrame(Context context, int i) {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        Resources resources = applicationContext.getResources();
        return resources.getIdentifier("d1_" + i, RConfigConstants.TYPE_DRAWABLE, packageName);
    }

    public static int[] getDeliveryFrames(Context context, int i) {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        int[] iArr = new int[3];
        for (int i2 = 1; i2 <= 3; i2++) {
            Resources resources = applicationContext.getResources();
            iArr[i2 - 1] = resources.getIdentifier("d" + i2 + "_" + i, RConfigConstants.TYPE_DRAWABLE, packageName);
        }
        return iArr;
    }

    public static int[] getDeliveryFrames(Context context, float f) {
        return getDeliveryFrames(context, AngleUtil.getIndexByAngle(f));
    }

    public static int[] getDeliveryDrawables(Context context, LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            return getDeliveryFrames(context, AngleUtil.getAngle(latLng, latLng2));
        }
        LogUtil.m16428e("getDeliveryDrawables() from = null || to = null");
        return null;
    }

    public static int[] getRotateFrames(Context context, int i, int i2) {
        int i3;
        if (i == i2) {
            return null;
        }
        int abs = Math.abs(i2 - i);
        boolean z = i2 <= i ? abs >= 8 : abs <= 8;
        ArrayList arrayList = new ArrayList();
        if (z) {
            if (i2 > i) {
                i3 = 0;
                while (i <= i2) {
                    i3++;
                    arrayList.add(Integer.valueOf(i));
                    i++;
                }
            } else {
                int i4 = 0;
                while (i <= 16) {
                    i4++;
                    arrayList.add(Integer.valueOf(i));
                    i++;
                }
                for (int i5 = 1; i5 <= i2; i5++) {
                    i4 = i3 + 1;
                    arrayList.add(Integer.valueOf(i5));
                }
            }
        } else if (i2 > i) {
            int i6 = 0;
            while (i >= 1) {
                i6++;
                arrayList.add(Integer.valueOf(i));
                i--;
            }
            for (int i7 = 16; i7 >= i2; i7--) {
                i6 = i3 + 1;
                arrayList.add(Integer.valueOf(i7));
            }
        } else {
            int i8 = 0;
            while (i >= i2) {
                i8 = i3 + 1;
                arrayList.add(Integer.valueOf(i));
                i--;
            }
        }
        if (i3 == 0) {
            return null;
        }
        int[] iArr = new int[i3];
        for (int i9 = 0; i9 < i3; i9++) {
            iArr[i9] = getDeliveryFrame(context, ((Integer) arrayList.get(i9)).intValue());
        }
        return iArr;
    }

    public static int[] getBoxFrames(Context context, int i) {
        int i2;
        String str = (i < 1 || i > 9) ? "to_left_box_" : "to_right_box_";
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        int[] iArr = new int[14];
        int i3 = 0;
        int i4 = 1;
        while (true) {
            i2 = 7;
            if (i4 > 7) {
                break;
            }
            Resources resources = applicationContext.getResources();
            iArr[i3] = resources.getIdentifier(str + i4, RConfigConstants.TYPE_DRAWABLE, packageName);
            i4++;
            i3++;
        }
        while (i2 >= 1) {
            Resources resources2 = applicationContext.getResources();
            iArr[i3] = resources2.getIdentifier(str + i2, RConfigConstants.TYPE_DRAWABLE, packageName);
            i2 += -1;
            i3++;
        }
        return iArr;
    }
}
