package com.didichuxing.afanty.common.collector;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import com.didichuxing.afanty.common.utils.CommonUtil;
import java.lang.reflect.Field;

public class ScreenCollector {

    /* renamed from: a */
    private static Display f45559a;

    /* renamed from: b */
    private static int f45560b;

    /* renamed from: c */
    private static int f45561c;

    /* renamed from: d */
    private static Context f45562d;

    public static void init(Context context) {
        f45562d = context;
    }

    /* renamed from: a */
    private static int[] m32659a() {
        if (f45560b == 0) {
            if (f45559a == null) {
                f45559a = ((WindowManager) f45562d.getSystemService("window")).getDefaultDisplay();
            }
            Point point = new Point();
            if (CommonUtil.getAPILevel() < 13) {
                point.set(f45559a.getWidth(), f45559a.getHeight());
            } else {
                f45559a.getSize(point);
            }
            f45560b = point.x;
            f45561c = point.y;
        }
        return new int[]{f45560b, f45561c};
    }

    public static String getScreenSize() {
        int[] a = m32659a();
        return a[0] + "x" + a[1];
    }

    public static String getScreenInfo() {
        StringBuilder sb = new StringBuilder();
        if (f45559a == null) {
            f45559a = ((WindowManager) f45562d.getSystemService("window")).getDefaultDisplay();
        }
        sb.append(m32658a(f45559a));
        sb.append("screenSize: ");
        sb.append(getScreenSize());
        sb.append("\n");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        f45559a.getMetrics(displayMetrics);
        sb.append("density: ");
        sb.append(displayMetrics.density);
        sb.append("\n");
        sb.append("refreshRate: ");
        sb.append(f45559a.getRefreshRate());
        sb.append("\n");
        sb.append(m32660b(f45559a));
        return sb.toString();
    }

    /* renamed from: a */
    private static String m32658a(Display display) {
        StringBuilder sb = new StringBuilder();
        try {
            int intValue = ((Integer) display.getClass().getMethod("getFlags", new Class[0]).invoke(display, new Object[0])).intValue();
            SparseArray sparseArray = new SparseArray();
            for (Field field : display.getClass().getFields()) {
                if (field.getName().startsWith("FLAG_")) {
                    sparseArray.put(field.getInt((Object) null), field.getName());
                }
            }
            sb.append("flags: ");
            sb.append(m32657a(sparseArray, intValue));
            sb.append(10);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m32657a(SparseArray<String> sparseArray, int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            int keyAt = sparseArray.keyAt(i2) & i;
            if (keyAt > 0) {
                if (sb.length() > 0) {
                    sb.append('+');
                }
                sb.append(sparseArray.get(keyAt));
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    private static String m32660b(Display display) {
        StringBuilder sb = new StringBuilder();
        try {
            int intValue = ((Integer) display.getClass().getMethod("getRotation", new Class[0]).invoke(display, new Object[0])).intValue();
            sb.append("rotation: ");
            if (intValue == 0) {
                sb.append("0");
            } else if (intValue == 1) {
                sb.append("90");
            } else if (intValue == 2) {
                sb.append("180");
            } else if (intValue != 3) {
                sb.append(intValue);
            } else {
                sb.append("270");
            }
            sb.append(10);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }
}
