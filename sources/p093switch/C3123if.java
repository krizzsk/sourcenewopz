package p093switch;

import android.graphics.Bitmap;

/* renamed from: switch.if */
/* compiled from: BitmapBlurAnalyser */
public class C3123if {

    /* renamed from: a */
    private int[] f6953a = new int[0];

    /* renamed from: b */
    private int m4034b(Bitmap bitmap, int i, int i2) {
        return ((m4033a(bitmap, i, i2 - 1) + m4033a(bitmap, i - 1, i2)) - (m4033a(bitmap, i, i2) * 4)) + m4033a(bitmap, i + 1, i2) + m4033a(bitmap, i, i2 + 1);
    }

    /* renamed from: do */
    public double mo38625do(Bitmap bitmap) {
        int height = (bitmap.getHeight() - 2) * (bitmap.getWidth() - 2);
        if (height != this.f6953a.length) {
            this.f6953a = new int[height];
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 1; i3 < bitmap.getHeight() - 1; i3++) {
            int i4 = 1;
            while (i4 < bitmap.getWidth() - 1) {
                int b = m4034b(bitmap, i4, i3);
                i += b;
                this.f6953a[i2] = b;
                i4++;
                i2++;
            }
        }
        double d = (double) i;
        double d2 = (double) height;
        double d3 = d / d2;
        double d4 = 0.0d;
        for (int i5 = 0; i5 < height; i5++) {
            double d5 = ((double) this.f6953a[i5]) - d3;
            d4 += d5 * d5;
        }
        return d4 / d2;
    }

    /* renamed from: a */
    private int m4033a(Bitmap bitmap, int i, int i2) {
        return bitmap.getPixel(i, i2) & 255;
    }
}
