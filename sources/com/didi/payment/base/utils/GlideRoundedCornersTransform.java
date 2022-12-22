package com.didi.payment.base.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import java.security.MessageDigest;

public class GlideRoundedCornersTransform extends CenterCrop {

    /* renamed from: c */
    private static final int f29984c = 1;

    /* renamed from: d */
    private static final String f29985d = "GlideRoundedCornersTransform.xxx1";

    /* renamed from: e */
    private static final byte[] f29986e = f29985d.getBytes(CHARSET);

    /* renamed from: a */
    private float f29987a;

    /* renamed from: b */
    private CornerType f29988b;

    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        TOP_LEFT_BOTTOM_RIGHT,
        TOP_RIGHT_BOTTOM_LEFT,
        TOP_LEFT_TOP_RIGHT_BOTTOM_RIGHT,
        TOP_RIGHT_BOTTOM_RIGHT_BOTTOM_LEFT
    }

    public int hashCode() {
        return 744982737;
    }

    public GlideRoundedCornersTransform(float f, CornerType cornerType) {
        this.f29987a = Resources.getSystem().getDisplayMetrics().density * f;
        this.f29988b = cornerType;
    }

    public GlideRoundedCornersTransform(CornerType cornerType, float f) {
        this.f29987a = f;
        this.f29988b = cornerType;
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return m21004a(bitmapPool, super.transform(bitmapPool, bitmap, i, i2));
    }

    /* renamed from: a */
    private Bitmap m21004a(BitmapPool bitmapPool, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmap2 = bitmapPool.get(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        m21005a(canvas, paint, new Path(), width, height);
        return bitmap2;
    }

    /* renamed from: com.didi.payment.base.utils.GlideRoundedCornersTransform$1 */
    static /* synthetic */ class C105141 {

        /* renamed from: $SwitchMap$com$didi$payment$base$utils$GlideRoundedCornersTransform$CornerType */
        static final /* synthetic */ int[] f29989xed22c9cc;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|(3:25|26|28)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.payment.base.utils.GlideRoundedCornersTransform$CornerType[] r0 = com.didi.payment.base.utils.GlideRoundedCornersTransform.CornerType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f29989xed22c9cc = r0
                com.didi.payment.base.utils.GlideRoundedCornersTransform$CornerType r1 = com.didi.payment.base.utils.GlideRoundedCornersTransform.CornerType.ALL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f29989xed22c9cc     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.payment.base.utils.GlideRoundedCornersTransform$CornerType r1 = com.didi.payment.base.utils.GlideRoundedCornersTransform.CornerType.TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f29989xed22c9cc     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.payment.base.utils.GlideRoundedCornersTransform$CornerType r1 = com.didi.payment.base.utils.GlideRoundedCornersTransform.CornerType.TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f29989xed22c9cc     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.payment.base.utils.GlideRoundedCornersTransform$CornerType r1 = com.didi.payment.base.utils.GlideRoundedCornersTransform.CornerType.BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f29989xed22c9cc     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.payment.base.utils.GlideRoundedCornersTransform$CornerType r1 = com.didi.payment.base.utils.GlideRoundedCornersTransform.CornerType.BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f29989xed22c9cc     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.payment.base.utils.GlideRoundedCornersTransform$CornerType r1 = com.didi.payment.base.utils.GlideRoundedCornersTransform.CornerType.TOP     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f29989xed22c9cc     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.payment.base.utils.GlideRoundedCornersTransform$CornerType r1 = com.didi.payment.base.utils.GlideRoundedCornersTransform.CornerType.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f29989xed22c9cc     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didi.payment.base.utils.GlideRoundedCornersTransform$CornerType r1 = com.didi.payment.base.utils.GlideRoundedCornersTransform.CornerType.LEFT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f29989xed22c9cc     // Catch:{ NoSuchFieldError -> 0x006c }
                com.didi.payment.base.utils.GlideRoundedCornersTransform$CornerType r1 = com.didi.payment.base.utils.GlideRoundedCornersTransform.CornerType.RIGHT     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f29989xed22c9cc     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.didi.payment.base.utils.GlideRoundedCornersTransform$CornerType r1 = com.didi.payment.base.utils.GlideRoundedCornersTransform.CornerType.TOP_LEFT_BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f29989xed22c9cc     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.didi.payment.base.utils.GlideRoundedCornersTransform$CornerType r1 = com.didi.payment.base.utils.GlideRoundedCornersTransform.CornerType.TOP_RIGHT_BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f29989xed22c9cc     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.didi.payment.base.utils.GlideRoundedCornersTransform$CornerType r1 = com.didi.payment.base.utils.GlideRoundedCornersTransform.CornerType.TOP_LEFT_TOP_RIGHT_BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f29989xed22c9cc     // Catch:{ NoSuchFieldError -> 0x009c }
                com.didi.payment.base.utils.GlideRoundedCornersTransform$CornerType r1 = com.didi.payment.base.utils.GlideRoundedCornersTransform.CornerType.TOP_RIGHT_BOTTOM_RIGHT_BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.base.utils.GlideRoundedCornersTransform.C105141.<clinit>():void");
        }
    }

    /* renamed from: a */
    private void m21005a(Canvas canvas, Paint paint, Path path, int i, int i2) {
        switch (C105141.f29989xed22c9cc[this.f29988b.ordinal()]) {
            case 1:
                float f = this.f29987a;
                m21006a(new float[]{f, f, f, f, f, f, f, f}, canvas, paint, path, i, i2);
                return;
            case 2:
                float f2 = this.f29987a;
                m21006a(new float[]{f2, f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, canvas, paint, path, i, i2);
                return;
            case 3:
                float f3 = this.f29987a;
                m21006a(new float[]{0.0f, 0.0f, f3, f3, 0.0f, 0.0f, 0.0f, 0.0f}, canvas, paint, path, i, i2);
                return;
            case 4:
                float f4 = this.f29987a;
                m21006a(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f4, f4, 0.0f, 0.0f}, canvas, paint, path, i, i2);
                return;
            case 5:
                float f5 = this.f29987a;
                m21006a(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f5, f5}, canvas, paint, path, i, i2);
                return;
            case 6:
                float f6 = this.f29987a;
                m21006a(new float[]{f6, f6, f6, f6, 0.0f, 0.0f, 0.0f, 0.0f}, canvas, paint, path, i, i2);
                return;
            case 7:
                float f7 = this.f29987a;
                m21006a(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f7, f7, f7, f7}, canvas, paint, path, i, i2);
                return;
            case 8:
                float f8 = this.f29987a;
                m21006a(new float[]{f8, f8, 0.0f, 0.0f, 0.0f, 0.0f, f8, f8}, canvas, paint, path, i, i2);
                return;
            case 9:
                float f9 = this.f29987a;
                m21006a(new float[]{0.0f, 0.0f, f9, f9, f9, f9, 0.0f, 0.0f}, canvas, paint, path, i, i2);
                return;
            case 10:
                float f10 = this.f29987a;
                m21006a(new float[]{f10, f10, 0.0f, 0.0f, f10, f10, 0.0f, 0.0f}, canvas, paint, path, i, i2);
                return;
            case 11:
                float f11 = this.f29987a;
                m21006a(new float[]{0.0f, 0.0f, f11, f11, 0.0f, 0.0f, f11, f11}, canvas, paint, path, i, i2);
                return;
            case 12:
                float f12 = this.f29987a;
                m21006a(new float[]{f12, f12, f12, f12, f12, f12, 0.0f, 0.0f}, canvas, paint, path, i, i2);
                return;
            case 13:
                float f13 = this.f29987a;
                m21006a(new float[]{0.0f, 0.0f, f13, f13, f13, f13, f13, f13}, canvas, paint, path, i, i2);
                return;
            default:
                throw new RuntimeException("RoundedCorners type not belong to CornerType");
        }
    }

    /* renamed from: a */
    private void m21006a(float[] fArr, Canvas canvas, Paint paint, Path path, int i, int i2) {
        path.addRoundRect(new RectF(0.0f, 0.0f, (float) i, (float) i2), fArr, Path.Direction.CW);
        canvas.drawPath(path, paint);
    }

    public boolean equals(Object obj) {
        return obj instanceof GlideRoundedCornersTransform;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f29986e);
    }
}
