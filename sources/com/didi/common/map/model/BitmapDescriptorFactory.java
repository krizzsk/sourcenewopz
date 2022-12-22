package com.didi.common.map.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.didi.common.map.model.BitmapDescriptor;

public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;

    /* renamed from: a */
    static final /* synthetic */ boolean f10799a = (!BitmapDescriptorFactory.class.desiredAssertionStatus());

    /* renamed from: b */
    private static final BitmapDescriptor f10800b = new BitmapDescriptor((Bitmap) null);

    private BitmapDescriptorFactory() {
    }

    public static BitmapDescriptor defaultMarker() {
        return f10800b;
    }

    public static BitmapDescriptor defaultMarker(float f) {
        float[] fArr = new float[3];
        m7344a(fArr, f, 1.0f, 1.0f);
        return new BitmapDescriptor((Bitmap) null, fArr[0], fArr[1], fArr[2]);
    }

    public static BitmapDescriptor fromAsset(Context context, String str) {
        return new BitmapDescriptor(context, str, BitmapDescriptor.Type.PATH_ASSET);
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        return new BitmapDescriptor(bitmap);
    }

    public static BitmapDescriptor fromFile(Context context, String str) {
        return new BitmapDescriptor(context, str, BitmapDescriptor.Type.PATH_FILEINPUT);
    }

    public static BitmapDescriptor fromPath(Context context, String str) {
        return new BitmapDescriptor(context, str, BitmapDescriptor.Type.PATH_ABSOLUTE);
    }

    public static BitmapDescriptor fromResource(Context context, int i) {
        if (context != null) {
            try {
                return fromBitmap(BitmapFactory.decodeStream(context.getResources().openRawResource(i)));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m7344a(float[] fArr, float f, float f2, float f3) {
        float f4 = ((f / 60.0f) + 1.0f) % 6.0f;
        float f5 = 0.0f;
        if (f4 < 0.0f) {
            f4 += 6.0f;
        }
        int floor = ((int) Math.floor((double) (f4 / 2.0f))) % 3;
        float f6 = f4 - ((float) ((floor * 2) + 1));
        float f7 = f3 * f2;
        float max = Math.max(-f6, 0.0f) * f7;
        float max2 = Math.max(f6, 0.0f) * f7;
        if (floor == 0) {
            f5 = f7;
        } else if (floor == 1) {
            f5 = max;
            max = max2;
            max2 = f7;
        } else if (floor == 2) {
            f5 = max2;
            max2 = max;
            max = f7;
        } else if (f10799a) {
            max2 = 0.0f;
            max = 0.0f;
        } else {
            throw new AssertionError();
        }
        fArr[0] = f5;
        fArr[1] = max2;
        fArr[2] = max;
    }
}
