package p093switch;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.iproov.sdk.cameray.Orientation;

/* renamed from: switch.for */
/* compiled from: BitmapUtils */
public class C3121for {
    /* renamed from: do */
    public static Bitmap m4030do(Bitmap bitmap, Orientation orientation) {
        if (orientation.angleDegrees == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) orientation.angleDegrees);
        matrix.postScale(-1.0f, 1.0f, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* renamed from: do */
    public static Bitmap m4029do(Bitmap bitmap, int i, int i2, int i3, int i4) {
        Bitmap createBitmap = Bitmap.createBitmap(Math.min(i3, bitmap.getWidth()), Math.min(i4, bitmap.getHeight()), Bitmap.Config.ARGB_8888);
        if (createBitmap == null) {
            return null;
        }
        new Canvas(createBitmap).drawBitmap(bitmap, (float) (-i), (float) (-i2), new Paint());
        return createBitmap;
    }
}
