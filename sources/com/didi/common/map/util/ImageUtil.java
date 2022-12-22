package com.didi.common.map.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

public class ImageUtil {
    public static Bitmap getScaledBitmap(Context context, Bitmap bitmap) {
        float f = context.getResources().getDisplayMetrics().density / 3.0f;
        if (f == 1.0f) {
            return bitmap;
        }
        if (bitmap == null) {
            return null;
        }
        return scale(bitmap, ((float) bitmap.getWidth()) * f, ((float) bitmap.getHeight()) * f, ImageView.ScaleType.CENTER_CROP, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0031 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap scale(android.graphics.Bitmap r8, float r9, float r10, android.widget.ImageView.ScaleType r11, boolean r12) {
        /*
            r0 = 0
            if (r8 == 0) goto L_0x0053
            boolean r1 = r8.isRecycled()
            if (r1 != 0) goto L_0x0053
            int r1 = r8.getWidth()
            float r1 = (float) r1
            int r2 = r8.getHeight()
            float r2 = (float) r2
            float r3 = r1 / r2
            float r4 = r9 / r10
            android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP
            if (r11 != r5) goto L_0x0024
            int r11 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r11 <= 0) goto L_0x0021
        L_0x001f:
            float r10 = r10 / r2
            goto L_0x002b
        L_0x0021:
            float r10 = r9 / r1
            goto L_0x002b
        L_0x0024:
            int r11 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r11 >= 0) goto L_0x0029
            goto L_0x001f
        L_0x0029:
            float r9 = r9 / r1
            r10 = r9
        L_0x002b:
            r9 = 1065353216(0x3f800000, float:1.0)
            int r9 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
            if (r9 != 0) goto L_0x0032
            return r8
        L_0x0032:
            android.graphics.Matrix r6 = new android.graphics.Matrix
            r6.<init>()
            r6.setScale(r10, r10)
            r2 = 0
            r3 = 0
            int r4 = r8.getWidth()     // Catch:{ IllegalArgumentException | OutOfMemoryError -> 0x004b }
            int r5 = r8.getHeight()     // Catch:{ IllegalArgumentException | OutOfMemoryError -> 0x004b }
            r7 = 1
            r1 = r8
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ IllegalArgumentException | OutOfMemoryError -> 0x004b }
            goto L_0x004c
        L_0x004b:
        L_0x004c:
            if (r12 == 0) goto L_0x0053
            if (r8 == r0) goto L_0x0053
            clear(r8)
        L_0x0053:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.common.map.util.ImageUtil.scale(android.graphics.Bitmap, float, float, android.widget.ImageView$ScaleType, boolean):android.graphics.Bitmap");
    }

    public static void clear(Bitmap bitmap) {
        if (bitmap != null && Build.VERSION.SDK_INT < 14) {
            bitmap.recycle();
        }
    }

    public static Bitmap PassengerPicFormat(Context context, Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 == null || bitmap == null) {
            return bitmap2;
        }
        Bitmap circleBitmap = getCircleBitmap(bitmap);
        int i = (int) (context.getResources().getDisplayMetrics().density * 21.0f);
        float f = (float) i;
        Bitmap scale = scale(circleBitmap, f, f, ImageView.ScaleType.CENTER_CROP, true);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        int width = (bitmap2.getWidth() - i) / 2;
        canvas.drawBitmap(scale, new Rect(0, 0, scale.getWidth(), scale.getHeight()), new Rect(width, (bitmap2.getHeight() - bitmap2.getWidth()) + width, bitmap2.getWidth() - width, bitmap2.getHeight() - width), paint);
        return getScaledBitmap(context, bitmap2);
    }

    public static Bitmap getCircleBitmap(Bitmap bitmap) {
        int width;
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            RectF rectF = new RectF(new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()));
            if (bitmap.getWidth() > bitmap.getHeight()) {
                width = bitmap.getHeight();
            } else {
                width = bitmap.getWidth();
            }
            float f = ((float) width) / 2.0f;
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-1);
            canvas.drawRoundRect(rectF, f, f, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, paint);
            return createBitmap;
        } catch (Exception unused) {
            return bitmap;
        }
    }

    public static Bitmap getTransparentBitmap(Bitmap bitmap, int i) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        int width = bitmap.getWidth() * bitmap.getHeight();
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        int i2 = (i * 255) / 100;
        for (int i3 = 0; i3 < width; i3++) {
            iArr[i3] = (i2 << 24) | (iArr[i3] & 16777215);
        }
        return Bitmap.createBitmap(iArr, bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
    }

    public static Drawable Bitmap2Drawable(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapDrawable(bitmap);
    }

    public static Bitmap Drawable2Bitmap(Drawable drawable) {
        if (drawable == null) {
            DLog.m7384d("BitmapUtils", "drawableToBitmap() drawable == null", new Object[0]);
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            DLog.m7384d("BitmapUtils", "drawableToBitmap() w <= 0 || h <= 0", new Object[0]);
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }
}
