package p092super;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.DisplayMetrics;

/* renamed from: super.goto */
/* compiled from: LightingUtils */
public class C3100goto {
    /* renamed from: do */
    public static Bitmap m3948do(Bitmap bitmap, int i, int i2, int i3, int i4) {
        Bitmap createBitmap = Bitmap.createBitmap(Math.min(i3, bitmap.getWidth()), Math.min(i4, bitmap.getHeight()), Bitmap.Config.ARGB_8888);
        if (createBitmap == null) {
            return null;
        }
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{0.2126f, 0.7152f, 0.0722f, 0.0f, 0.0f, 0.2126f, 0.7152f, 0.0722f, 0.0f, 0.0f, 0.2126f, 0.7152f, 0.0722f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, (float) (-i), (float) (-i2), paint);
        return createBitmap;
    }

    /* renamed from: a */
    static double m3947a() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return ((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi)) * 25.4d * ((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi)) * 25.4d;
    }
}
