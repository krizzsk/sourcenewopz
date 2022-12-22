package com.didi.app.nova.skeleton.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.bumptech.glide.util.C1850Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class RoundedCornersTransformation extends BitmapTransformation {

    /* renamed from: a */
    private static final String f8444a = "com.didi.app.nova.skeleton.image.RoundedCornersTransformation";

    /* renamed from: b */
    private static final byte[] f8445b = f8444a.getBytes(CHARSET);

    /* renamed from: c */
    private int f8446c;

    /* renamed from: d */
    private int f8447d;

    /* renamed from: e */
    private int f8448e;

    /* renamed from: f */
    private CornerType f8449f;

    /* renamed from: g */
    private boolean f8450g;

    /* renamed from: h */
    private int f8451h;

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
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    public RoundedCornersTransformation(Context context, int i, int i2, CornerType cornerType, boolean z) {
        this.f8446c = i;
        this.f8447d = i * 2;
        this.f8448e = i2;
        this.f8449f = cornerType;
        this.f8450g = z;
        this.f8451h = (i + String.valueOf(i2) + cornerType + z).hashCode();
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        if (this.f8450g) {
            return m5646a(bitmapPool, bitmap, i, i2);
        }
        return m5645a(bitmapPool, bitmap);
    }

    /* renamed from: a */
    private Bitmap m5646a(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return m5647a(bitmapPool, TransformationUtils.centerCrop(bitmapPool, bitmap, i, i2), bitmapPool.getDirty(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888));
    }

    /* renamed from: a */
    private Bitmap m5645a(BitmapPool bitmapPool, Bitmap bitmap) {
        return m5647a(bitmapPool, bitmap, bitmapPool.getDirty(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888));
    }

    /* renamed from: a */
    private Bitmap m5647a(BitmapPool bitmapPool, Bitmap bitmap, Bitmap bitmap2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (bitmap2.isRecycled()) {
            bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        }
        if (bitmap2.equals(bitmap)) {
            bitmap2 = bitmapPool.get(width, height, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        } else {
            bitmap2.eraseColor(0);
        }
        bitmap2.setHasAlpha(true);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        m5648a(canvas, paint, (float) width, (float) height);
        return bitmap2;
    }

    /* renamed from: a */
    private void m5648a(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f8448e;
        float f3 = f - ((float) i);
        float f4 = f2 - ((float) i);
        switch (C37361.f8452x46c673b7[this.f8449f.ordinal()]) {
            case 1:
                int i2 = this.f8448e;
                RectF rectF = new RectF((float) i2, (float) i2, f3, f4);
                int i3 = this.f8446c;
                canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
                return;
            case 2:
                m5649b(canvas, paint, f3, f4);
                return;
            case 3:
                m5650c(canvas, paint, f3, f4);
                return;
            case 4:
                m5651d(canvas, paint, f3, f4);
                return;
            case 5:
                m5652e(canvas, paint, f3, f4);
                return;
            case 6:
                m5653f(canvas, paint, f3, f4);
                return;
            case 7:
                m5654g(canvas, paint, f3, f4);
                return;
            case 8:
                m5655h(canvas, paint, f3, f4);
                return;
            case 9:
                m5656i(canvas, paint, f3, f4);
                return;
            case 10:
                m5657j(canvas, paint, f3, f4);
                return;
            case 11:
                m5658k(canvas, paint, f3, f4);
                return;
            case 12:
                m5659l(canvas, paint, f3, f4);
                return;
            case 13:
                m5660m(canvas, paint, f3, f4);
                return;
            case 14:
                m5661n(canvas, paint, f3, f4);
                return;
            case 15:
                m5662o(canvas, paint, f3, f4);
                return;
            default:
                int i4 = this.f8448e;
                RectF rectF2 = new RectF((float) i4, (float) i4, f3, f4);
                int i5 = this.f8446c;
                canvas.drawRoundRect(rectF2, (float) i5, (float) i5, paint);
                return;
        }
    }

    /* renamed from: com.didi.app.nova.skeleton.image.RoundedCornersTransformation$1 */
    static /* synthetic */ class C37361 {

        /* renamed from: $SwitchMap$com$didi$app$nova$skeleton$image$RoundedCornersTransformation$CornerType */
        static final /* synthetic */ int[] f8452x46c673b7;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.app.nova.skeleton.image.RoundedCornersTransformation$CornerType[] r0 = com.didi.app.nova.skeleton.image.RoundedCornersTransformation.CornerType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8452x46c673b7 = r0
                com.didi.app.nova.skeleton.image.RoundedCornersTransformation$CornerType r1 = com.didi.app.nova.skeleton.image.RoundedCornersTransformation.CornerType.ALL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8452x46c673b7     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.app.nova.skeleton.image.RoundedCornersTransformation$CornerType r1 = com.didi.app.nova.skeleton.image.RoundedCornersTransformation.CornerType.TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8452x46c673b7     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.app.nova.skeleton.image.RoundedCornersTransformation$CornerType r1 = com.didi.app.nova.skeleton.image.RoundedCornersTransformation.CornerType.TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8452x46c673b7     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.app.nova.skeleton.image.RoundedCornersTransformation$CornerType r1 = com.didi.app.nova.skeleton.image.RoundedCornersTransformation.CornerType.BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8452x46c673b7     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.app.nova.skeleton.image.RoundedCornersTransformation$CornerType r1 = com.didi.app.nova.skeleton.image.RoundedCornersTransformation.CornerType.BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8452x46c673b7     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.app.nova.skeleton.image.RoundedCornersTransformation$CornerType r1 = com.didi.app.nova.skeleton.image.RoundedCornersTransformation.CornerType.TOP     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f8452x46c673b7     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.app.nova.skeleton.image.RoundedCornersTransformation$CornerType r1 = com.didi.app.nova.skeleton.image.RoundedCornersTransformation.CornerType.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f8452x46c673b7     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didi.app.nova.skeleton.image.RoundedCornersTransformation$CornerType r1 = com.didi.app.nova.skeleton.image.RoundedCornersTransformation.CornerType.LEFT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f8452x46c673b7     // Catch:{ NoSuchFieldError -> 0x006c }
                com.didi.app.nova.skeleton.image.RoundedCornersTransformation$CornerType r1 = com.didi.app.nova.skeleton.image.RoundedCornersTransformation.CornerType.RIGHT     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f8452x46c673b7     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.didi.app.nova.skeleton.image.RoundedCornersTransformation$CornerType r1 = com.didi.app.nova.skeleton.image.RoundedCornersTransformation.CornerType.OTHER_TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f8452x46c673b7     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.didi.app.nova.skeleton.image.RoundedCornersTransformation$CornerType r1 = com.didi.app.nova.skeleton.image.RoundedCornersTransformation.CornerType.OTHER_TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f8452x46c673b7     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.didi.app.nova.skeleton.image.RoundedCornersTransformation$CornerType r1 = com.didi.app.nova.skeleton.image.RoundedCornersTransformation.CornerType.OTHER_BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f8452x46c673b7     // Catch:{ NoSuchFieldError -> 0x009c }
                com.didi.app.nova.skeleton.image.RoundedCornersTransformation$CornerType r1 = com.didi.app.nova.skeleton.image.RoundedCornersTransformation.CornerType.OTHER_BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f8452x46c673b7     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.didi.app.nova.skeleton.image.RoundedCornersTransformation$CornerType r1 = com.didi.app.nova.skeleton.image.RoundedCornersTransformation.CornerType.DIAGONAL_FROM_TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f8452x46c673b7     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.didi.app.nova.skeleton.image.RoundedCornersTransformation$CornerType r1 = com.didi.app.nova.skeleton.image.RoundedCornersTransformation.CornerType.DIAGONAL_FROM_TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.app.nova.skeleton.image.RoundedCornersTransformation.C37361.<clinit>():void");
        }
    }

    /* renamed from: b */
    private void m5649b(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f8448e;
        int i2 = this.f8447d;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + i2), (float) (i + i2));
        int i3 = this.f8446c;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.f8448e;
        int i5 = this.f8446c;
        canvas.drawRect(new RectF((float) i4, (float) (i4 + i5), (float) (i4 + i5), f2), paint);
        int i6 = this.f8448e;
        canvas.drawRect(new RectF((float) (this.f8446c + i6), (float) i6, f, f2), paint);
    }

    /* renamed from: c */
    private void m5650c(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f8447d;
        int i2 = this.f8448e;
        RectF rectF = new RectF(f - ((float) i), (float) i2, f, (float) (i2 + i));
        int i3 = this.f8446c;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.f8448e;
        canvas.drawRect(new RectF((float) i4, (float) i4, f - ((float) this.f8446c), f2), paint);
        int i5 = this.f8446c;
        canvas.drawRect(new RectF(f - ((float) i5), (float) (this.f8448e + i5), f, f2), paint);
    }

    /* renamed from: d */
    private void m5651d(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f8448e;
        int i2 = this.f8447d;
        RectF rectF = new RectF((float) i, f2 - ((float) i2), (float) (i + i2), f2);
        int i3 = this.f8446c;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.f8448e;
        canvas.drawRect(new RectF((float) i4, (float) i4, (float) (i4 + this.f8447d), f2 - ((float) this.f8446c)), paint);
        int i5 = this.f8448e;
        canvas.drawRect(new RectF((float) (this.f8446c + i5), (float) i5, f, f2), paint);
    }

    /* renamed from: e */
    private void m5652e(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f8447d;
        RectF rectF = new RectF(f - ((float) i), f2 - ((float) i), f, f2);
        int i2 = this.f8446c;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.f8448e;
        canvas.drawRect(new RectF((float) i3, (float) i3, f - ((float) this.f8446c), f2), paint);
        int i4 = this.f8446c;
        canvas.drawRect(new RectF(f - ((float) i4), (float) this.f8448e, f, f2 - ((float) i4)), paint);
    }

    /* renamed from: f */
    private void m5653f(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f8448e;
        RectF rectF = new RectF((float) i, (float) i, f, (float) (i + this.f8447d));
        int i2 = this.f8446c;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.f8448e;
        canvas.drawRect(new RectF((float) i3, (float) (i3 + this.f8446c), f, f2), paint);
    }

    /* renamed from: g */
    private void m5654g(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF((float) this.f8448e, f2 - ((float) this.f8447d), f, f2);
        int i = this.f8446c;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        int i2 = this.f8448e;
        canvas.drawRect(new RectF((float) i2, (float) i2, f, f2 - ((float) this.f8446c)), paint);
    }

    /* renamed from: h */
    private void m5655h(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f8448e;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + this.f8447d), f2);
        int i2 = this.f8446c;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.f8448e;
        canvas.drawRect(new RectF((float) (this.f8446c + i3), (float) i3, f, f2), paint);
    }

    /* renamed from: i */
    private void m5656i(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF(f - ((float) this.f8447d), (float) this.f8448e, f, f2);
        int i = this.f8446c;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        int i2 = this.f8448e;
        canvas.drawRect(new RectF((float) i2, (float) i2, f - ((float) this.f8446c), f2), paint);
    }

    /* renamed from: j */
    private void m5657j(Canvas canvas, Paint paint, float f, float f2) {
        RectF rectF = new RectF((float) this.f8448e, f2 - ((float) this.f8447d), f, f2);
        int i = this.f8446c;
        canvas.drawRoundRect(rectF, (float) i, (float) i, paint);
        RectF rectF2 = new RectF(f - ((float) this.f8447d), (float) this.f8448e, f, f2);
        int i2 = this.f8446c;
        canvas.drawRoundRect(rectF2, (float) i2, (float) i2, paint);
        int i3 = this.f8448e;
        int i4 = this.f8446c;
        canvas.drawRect(new RectF((float) i3, (float) i3, f - ((float) i4), f2 - ((float) i4)), paint);
    }

    /* renamed from: k */
    private void m5658k(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f8448e;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + this.f8447d), f2);
        int i2 = this.f8446c;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        RectF rectF2 = new RectF((float) this.f8448e, f2 - ((float) this.f8447d), f, f2);
        int i3 = this.f8446c;
        canvas.drawRoundRect(rectF2, (float) i3, (float) i3, paint);
        int i4 = this.f8448e;
        int i5 = this.f8446c;
        canvas.drawRect(new RectF((float) (i4 + i5), (float) i4, f, f2 - ((float) i5)), paint);
    }

    /* renamed from: l */
    private void m5659l(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f8448e;
        RectF rectF = new RectF((float) i, (float) i, f, (float) (i + this.f8447d));
        int i2 = this.f8446c;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        RectF rectF2 = new RectF(f - ((float) this.f8447d), (float) this.f8448e, f, f2);
        int i3 = this.f8446c;
        canvas.drawRoundRect(rectF2, (float) i3, (float) i3, paint);
        int i4 = this.f8448e;
        int i5 = this.f8446c;
        canvas.drawRect(new RectF((float) i4, (float) (i4 + i5), f - ((float) i5), f2), paint);
    }

    /* renamed from: m */
    private void m5660m(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f8448e;
        RectF rectF = new RectF((float) i, (float) i, f, (float) (i + this.f8447d));
        int i2 = this.f8446c;
        canvas.drawRoundRect(rectF, (float) i2, (float) i2, paint);
        int i3 = this.f8448e;
        RectF rectF2 = new RectF((float) i3, (float) i3, (float) (i3 + this.f8447d), f2);
        int i4 = this.f8446c;
        canvas.drawRoundRect(rectF2, (float) i4, (float) i4, paint);
        int i5 = this.f8448e;
        int i6 = this.f8446c;
        canvas.drawRect(new RectF((float) (i5 + i6), (float) (i5 + i6), f, f2), paint);
    }

    /* renamed from: n */
    private void m5661n(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f8448e;
        int i2 = this.f8447d;
        RectF rectF = new RectF((float) i, (float) i, (float) (i + i2), (float) (i + i2));
        int i3 = this.f8446c;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.f8447d;
        RectF rectF2 = new RectF(f - ((float) i4), f2 - ((float) i4), f, f2);
        int i5 = this.f8446c;
        canvas.drawRoundRect(rectF2, (float) i5, (float) i5, paint);
        int i6 = this.f8448e;
        canvas.drawRect(new RectF((float) i6, (float) (i6 + this.f8446c), f - ((float) this.f8447d), f2), paint);
        int i7 = this.f8448e;
        canvas.drawRect(new RectF((float) (this.f8447d + i7), (float) i7, f, f2 - ((float) this.f8446c)), paint);
    }

    /* renamed from: o */
    private void m5662o(Canvas canvas, Paint paint, float f, float f2) {
        int i = this.f8447d;
        int i2 = this.f8448e;
        RectF rectF = new RectF(f - ((float) i), (float) i2, f, (float) (i2 + i));
        int i3 = this.f8446c;
        canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint);
        int i4 = this.f8448e;
        int i5 = this.f8447d;
        RectF rectF2 = new RectF((float) i4, f2 - ((float) i5), (float) (i4 + i5), f2);
        int i6 = this.f8446c;
        canvas.drawRoundRect(rectF2, (float) i6, (float) i6, paint);
        int i7 = this.f8448e;
        int i8 = this.f8446c;
        canvas.drawRect(new RectF((float) i7, (float) i7, f - ((float) i8), f2 - ((float) i8)), paint);
        int i9 = this.f8448e;
        int i10 = this.f8446c;
        canvas.drawRect(new RectF((float) (i9 + i10), (float) (i9 + i10), f, f2), paint);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f8445b);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f8451h).array());
    }

    public boolean equals(Object obj) {
        if (obj instanceof RoundedCornersTransformation) {
            RoundedCornersTransformation roundedCornersTransformation = (RoundedCornersTransformation) obj;
            return roundedCornersTransformation.f8446c == this.f8446c && roundedCornersTransformation.f8448e == this.f8448e && roundedCornersTransformation.f8449f == this.f8449f && roundedCornersTransformation.f8450g == this.f8450g;
        }
    }

    public int hashCode() {
        return C1850Util.hashCode(-1249616208, C1850Util.hashCode(this.f8451h));
    }
}
