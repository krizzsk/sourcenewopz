package p093switch;

import android.graphics.RectF;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import androidx.core.view.GravityCompat;

/* renamed from: switch.super */
/* compiled from: UiUtils */
public final class C3125super {
    /* renamed from: b */
    private static float[] m4038b(float f, float f2, float f3) {
        float f4 = 0.9f * f;
        return new float[]{f4 * f3, Math.min(f2, Math.min(1.4f, f2 / f) * f4) * f3};
    }

    /* renamed from: c */
    private static float[] m4039c(float f, float f2, float f3) {
        float f4 = 0.9f * f2;
        return new float[]{Math.min(f, Math.min(0.71428573f, f / f2) * f4) * f3, f4 * f3};
    }

    /* renamed from: do */
    public static Drawable m4041do(int i, int i2) {
        RectShape rectShape = new RectShape();
        ShapeDrawable shapeDrawable = new ShapeDrawable(rectShape);
        shapeDrawable.getPaint().setColor(i);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(rectShape);
        shapeDrawable2.getPaint().setColor(i2);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, new ClipDrawable(shapeDrawable2, GravityCompat.START, 1)});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908301);
        return layerDrawable;
    }

    /* renamed from: do */
    public static RectF m4040do(int i, int i2, float f) {
        float f2 = (float) i;
        float f3 = (float) i2;
        float[] a = m4037a(f2, f3, f);
        float f4 = (f2 - a[0]) / 2.0f;
        float f5 = (f3 - a[1]) / 2.0f;
        return new RectF(f4, f5, a[0] + f4, a[1] + f5);
    }

    /* renamed from: a */
    private static float[] m4037a(float f, float f2, float f3) {
        if (f2 > f) {
            return m4038b(f, f2, f3);
        }
        return m4039c(f, f2, f3);
    }
}
