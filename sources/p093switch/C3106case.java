package p093switch;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.SensorManager;

/* renamed from: switch.case */
/* compiled from: MathUtils */
public class C3106case {

    /* renamed from: switch.case$do */
    /* compiled from: MathUtils */
    public enum C3107do {
        FILL,
        FIT
    }

    /* renamed from: do */
    public static double m4004do(Point point, Point point2) {
        return (Math.atan2((double) (point.y - point2.y), (double) (point.x - point2.x)) + 3.141592653589793d) % 6.283185307179586d;
    }

    /* renamed from: if */
    public static Point m4013if(Rect rect) {
        return new Point(rect.centerX(), rect.centerY());
    }

    /* renamed from: do */
    public static Rect m4008do(RectF rectF) {
        return new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    /* renamed from: if */
    public static double m4012if(Point point, Point point2) {
        return Math.sqrt(Math.pow((double) (point2.y - point.y), 2.0d) + Math.pow((double) (point2.x - point.x), 2.0d));
    }

    /* renamed from: do */
    public static RectF m4009do(Rect rect, Rect rect2) {
        return new RectF((((float) rect.left) * 1.0f) / ((float) rect2.width()), (((float) rect.top) * 1.0f) / ((float) rect2.height()), (((float) rect.right) * 1.0f) / ((float) rect2.width()), (((float) rect.bottom) * 1.0f) / ((float) rect2.height()));
    }

    /* renamed from: do */
    public static Rect m4006do(Rect rect, float f) {
        int min = (int) (((float) Math.min(rect.width(), rect.height())) * f);
        int width = rect.left + ((int) (((float) (rect.width() - min)) / 2.0f));
        int height = rect.top + ((int) (((float) (rect.height() - min)) / 2.0f));
        return new Rect(width, height, width + min, min + height);
    }

    /* renamed from: do */
    public static Rect m4007do(Rect rect, Rect rect2, Rect rect3, C3107do doVar) {
        if (rect == null) {
            return null;
        }
        float width = (((float) rect3.width()) * 1.0f) / ((float) rect2.width());
        float height = (((float) rect3.height()) * 1.0f) / ((float) rect2.height());
        float min = doVar == C3107do.FIT ? Math.min(width, height) : Math.max(width, height);
        int width2 = rect2.width() / 2;
        int height2 = rect2.height() / 2;
        float width3 = (float) (rect3.width() / 2);
        float height3 = (float) (rect3.height() / 2);
        return new Rect((int) ((((float) (rect.left - width2)) * min) + width3), (int) ((((float) (rect.top - height2)) * min) + height3), (int) ((((float) (rect.right - width2)) * min) + width3), (int) ((((float) (rect.bottom - height2)) * min) + height3));
    }

    /* renamed from: do */
    public static double m4003do(float f) {
        return Double.parseDouble(Float.toString(f));
    }

    /* renamed from: do */
    public static float m4005do(double d) {
        return Float.parseFloat(Double.toString(d));
    }

    /* renamed from: do */
    public static float[] m4011do(float[] fArr) {
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrixFromVector(fArr2, fArr);
        float[] fArr3 = new float[3];
        SensorManager.getOrientation(fArr2, fArr3);
        float f = fArr3[1];
        fArr3[1] = -fArr3[0];
        fArr3[0] = -f;
        return fArr3;
    }

    /* renamed from: do */
    public static C3130while m4010do(Rect rect) {
        return new C3130while((double) rect.exactCenterX(), (double) rect.exactCenterY(), (double) rect.width());
    }
}
