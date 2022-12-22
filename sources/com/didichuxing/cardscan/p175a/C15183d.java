package com.didichuxing.cardscan.p175a;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.hardware.Camera;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import p242io.card.payment.CardScanner;

/* renamed from: com.didichuxing.cardscan.a.d */
public class C15183d {

    /* renamed from: a */
    private static final String f46188a = C15183d.class.getSimpleName();

    /* renamed from: b */
    private static final boolean f46189b = Build.MODEL.equals("DROID2");

    /* renamed from: c */
    private static Boolean f46190c;

    /* renamed from: a */
    public static Rect m33169a(Point point, int i, int i2) {
        int i3 = i / 2;
        int i4 = i2 / 2;
        return new Rect(point.x - i3, point.y - i4, point.x + i3, point.y + i4);
    }

    /* renamed from: a */
    public static void m33170a(Paint paint) {
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
        paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        paint.setAntiAlias(true);
        paint.setShadowLayer(1.5f, 0.5f, 0.0f, Color.HSVToColor(200, new float[]{0.0f, 0.0f, 0.0f}));
    }

    /* renamed from: a */
    public static boolean m33171a() {
        if (f46190c == null) {
            f46190c = Boolean.valueOf(m33172b());
        }
        return f46190c.booleanValue();
    }

    /* renamed from: b */
    private static boolean m33172b() {
        if (!CardScanner.processorSupported()) {
            SystemUtils.log(5, "card.io", "- Processor type is not supported", (Throwable) null, "com.didichuxing.cardscan.a.d", -1);
            return false;
        }
        try {
            Camera open = Camera.open();
            if (open == null) {
                SystemUtils.log(5, "card.io", "- No camera found", (Throwable) null, "com.didichuxing.cardscan.a.d", -1);
                return false;
            }
            open.release();
            return true;
        } catch (RuntimeException e) {
            if (Build.VERSION.SDK_INT >= 23) {
                return true;
            }
            SystemUtils.log(5, "card.io", "- Error opening camera: " + e, (Throwable) null, "com.didichuxing.cardscan.a.d", -1);
            return false;
        }
    }
}
