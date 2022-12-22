package com.didi.component.base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

public class XRay {

    /* renamed from: a */
    private static final XRay f10983a = new XRay();

    /* renamed from: b */
    private static final int f10984b = 50;

    /* renamed from: c */
    private static final float f10985c = 0.9f;

    /* renamed from: d */
    private static final int f10986d = 30;

    /* renamed from: e */
    private static final int f10987e = -65536;

    /* renamed from: f */
    private boolean f10988f;

    /* renamed from: g */
    private Paint f10989g;

    private XRay() {
        Paint paint = new Paint();
        this.f10989g = paint;
        paint.setTextSize(30.0f);
        this.f10989g.setColor(-65536);
    }

    public static void toggle() {
        XRay xRay = f10983a;
        xRay.f10988f = !xRay.f10988f;
    }

    /* renamed from: a */
    static boolean m7426a() {
        return f10983a.f10988f;
    }

    /* renamed from: a */
    static void m7425a(BaseComponent baseComponent) {
        Bitmap bitmap;
        if (Build.VERSION.SDK_INT >= 16) {
            View view = baseComponent.getView() != null ? baseComponent.getView().getView() : null;
            if (view != null) {
                String b = m7427b(baseComponent);
                int a = f10983a.m7422a(b);
                Drawable background = view.getBackground();
                if (background != null) {
                    bitmap = m7423a(background, a);
                } else {
                    bitmap = Bitmap.createBitmap(a, 50, Bitmap.Config.ARGB_8888);
                }
                f10983a.m7424a(bitmap, b);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(view.getContext().getResources(), bitmap);
                bitmapDrawable.setGravity(17);
                view.setBackground(bitmapDrawable);
                view.setAlpha(f10985c);
            }
        }
    }

    /* renamed from: a */
    private static Bitmap m7423a(Drawable drawable, int i) {
        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(i, 50, Bitmap.Config.ARGB_8888);
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }
        drawable.draw(new Canvas(bitmap));
        return bitmap;
    }

    /* renamed from: b */
    private static String m7427b(BaseComponent baseComponent) {
        String str = (String) baseComponent.getExtra("BUNDLE_KEY_TYPE");
        return str != null ? str : "";
    }

    /* renamed from: a */
    private void m7424a(Bitmap bitmap, String str) {
        new Canvas(bitmap).drawText(str, (((float) bitmap.getWidth()) - this.f10989g.measureText(str)) / 2.0f, ((float) bitmap.getHeight()) / 2.0f, this.f10989g);
    }

    /* renamed from: a */
    private int m7422a(String str) {
        return ((int) this.f10989g.measureText(str)) + 1;
    }
}
