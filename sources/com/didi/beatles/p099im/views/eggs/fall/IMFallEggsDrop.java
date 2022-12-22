package com.didi.beatles.p099im.views.eggs.fall;

import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.animation.LinearInterpolator;
import androidx.core.util.Pools;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMFactoryPools;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMWindowUtil;
import com.didi.beatles.p099im.views.eggs.IIMEggsDrop;
import com.didi.beatles.p099im.views.eggs.evaluator.PointFInterpolatorEvaluator;
import java.util.Random;

/* renamed from: com.didi.beatles.im.views.eggs.fall.IMFallEggsDrop */
public class IMFallEggsDrop implements IIMEggsDrop {

    /* renamed from: a */
    private static final String f10210a = IMFallEggsDrop.class.getSimpleName();

    /* renamed from: b */
    private static int f10211b = IMWindowUtil.dip2px(100.0f);

    /* renamed from: c */
    private static Pools.Pool<IMFallEggsDrop> f10212c = IMFactoryPools.simple(30, new IMFactoryPools.Factory<IMFallEggsDrop>() {
        public IMFallEggsDrop create() {
            return new IMFallEggsDrop();
        }
    }, new IMFactoryPools.Resetter<IMFallEggsDrop>() {
        public void reset(IMFallEggsDrop iMFallEggsDrop) {
        }
    });

    /* renamed from: d */
    private Matrix f10213d;

    /* renamed from: e */
    private Paint f10214e;

    /* renamed from: f */
    private Bitmap f10215f;

    /* renamed from: g */
    private PointF f10216g;

    /* renamed from: h */
    private PointF f10217h;

    /* renamed from: i */
    private PointF f10218i;

    /* renamed from: j */
    private int f10219j;

    /* renamed from: k */
    private int f10220k;

    /* renamed from: l */
    private int f10221l;

    /* renamed from: m */
    private int f10222m;

    /* renamed from: n */
    private float f10223n;

    /* renamed from: o */
    private long f10224o;

    /* renamed from: p */
    private long f10225p;

    /* renamed from: q */
    private long f10226q;

    /* renamed from: r */
    private long f10227r;

    /* renamed from: s */
    private TypeEvaluator<PointF> f10228s;

    /* renamed from: t */
    private boolean f10229t;

    /* renamed from: u */
    private boolean f10230u;

    /* renamed from: v */
    private boolean f10231v;

    /* renamed from: w */
    private Random f10232w;

    public static IMFallEggsDrop obtain() {
        return f10212c.acquire();
    }

    private IMFallEggsDrop() {
        this.f10216g = new PointF();
        this.f10217h = new PointF();
        this.f10218i = new PointF();
        this.f10223n = 1.0f;
        this.f10232w = new Random();
    }

    public void init(Bitmap bitmap, int i, int i2) {
        init((long) (this.f10232w.nextInt(1000) + 4000), (long) this.f10232w.nextInt(3000), bitmap, i, i2);
    }

    public void init(long j, long j2, Bitmap bitmap, int i, int i2) {
        this.f10229t = true;
        this.f10213d = new Matrix();
        this.f10214e = new Paint();
        this.f10224o = j;
        this.f10225p = j2;
        this.f10228s = new PointFInterpolatorEvaluator(new LinearInterpolator());
        setBitmap(bitmap, i, i2);
    }

    public void setBitmap(Bitmap bitmap, int i, int i2) {
        this.f10215f = bitmap;
        if (bitmap != null) {
            this.f10219j = bitmap.getWidth();
            int height = bitmap.getHeight();
            this.f10220k = height;
            int i3 = this.f10219j;
            if (i3 == 0 || height == 0) {
                IMLog.m6632e(f10210a, C4234I.m6591t("[setBitmap] invalid size -> bmpWidth=", Integer.valueOf(this.f10219j), " |bmpHeight=", Integer.valueOf(this.f10220k)));
                return;
            }
            this.f10223n = Math.min(((float) i) / ((float) i3), ((float) i2) / ((float) height));
        }
    }

    public boolean isActive() {
        return !this.f10230u;
    }

    public void draw(Canvas canvas) {
        m6972a(canvas, SystemClock.uptimeMillis());
    }

    public void recycle() {
        this.f10229t = false;
        this.f10231v = false;
        this.f10230u = false;
        this.f10215f = null;
        try {
            f10212c.release(this);
        } catch (Exception e) {
            IMLog.m6632e(f10210a, "[recycle]", e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r6.f10228s != null) goto L_0x001d;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6972a(android.graphics.Canvas r7, long r8) {
        /*
            r6 = this;
            boolean r0 = r6.f10229t
            if (r0 == 0) goto L_0x010a
            android.graphics.Bitmap r0 = r6.f10215f
            r1 = 1
            if (r0 == 0) goto L_0x001b
            long r2 = r6.f10224o
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x001b
            long r4 = r6.f10225p
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x001b
            android.animation.TypeEvaluator<android.graphics.PointF> r0 = r6.f10228s
            if (r0 != 0) goto L_0x001d
        L_0x001b:
            r6.f10230u = r1
        L_0x001d:
            boolean r0 = r6.f10231v
            if (r0 != 0) goto L_0x0056
            r6.f10231v = r1
            int r0 = r7.getWidth()
            r6.f10221l = r0
            int r0 = r7.getHeight()
            r6.f10222m = r0
            long r2 = r6.f10225p
            long r2 = r2 + r8
            r6.f10226q = r2
            long r4 = r6.f10224o
            long r2 = r2 + r4
            r6.f10227r = r2
            android.graphics.PointF r0 = r6.f10217h
            android.graphics.PointF r0 = r6.m6970a(r0)
            r6.f10217h = r0
            android.graphics.PointF r2 = r6.f10216g
            float r0 = r0.x
            android.graphics.PointF r3 = r6.f10217h
            float r3 = r3.y
            r2.set(r0, r3)
            android.graphics.PointF r0 = r6.f10217h
            android.graphics.PointF r2 = r6.f10218i
            android.graphics.PointF r0 = r6.m6971a((android.graphics.PointF) r0, (android.graphics.PointF) r2)
            r6.f10218i = r0
        L_0x0056:
            long r2 = r6.f10226q
            int r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x005d
            return
        L_0x005d:
            long r2 = r6.f10227r
            int r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x006c
            java.lang.String r0 = f10210a
            java.lang.String r2 = "[draw]============finished============"
            com.didi.beatles.p099im.utils.IMLog.m6631d(r0, r2)
            r6.f10230u = r1
        L_0x006c:
            int r0 = r6.f10219j
            int r2 = r6.f10221l
            if (r0 > r2) goto L_0x0078
            int r0 = r6.f10220k
            int r2 = r6.f10222m
            if (r0 <= r2) goto L_0x00b5
        L_0x0078:
            java.lang.String r0 = f10210a
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "[draw] #Invalid Size# bitmapWidth="
            r4.append(r5)
            int r5 = r6.f10219j
            r4.append(r5)
            java.lang.String r5 = " |bitmapHeight="
            r4.append(r5)
            int r5 = r6.f10220k
            r4.append(r5)
            java.lang.String r5 = " |canvasWidth="
            r4.append(r5)
            int r5 = r6.f10221l
            r4.append(r5)
            java.lang.String r5 = " |canvasHeight="
            r4.append(r5)
            int r5 = r6.f10222m
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r2[r3] = r4
            com.didi.beatles.p099im.utils.IMLog.m6632e(r0, r2)
            r6.f10230u = r1
        L_0x00b5:
            boolean r0 = r6.f10230u
            if (r0 != 0) goto L_0x0109
            boolean r0 = r6.f10231v
            if (r0 == 0) goto L_0x0109
            long r0 = r6.f10226q
            long r8 = r8 - r0
            float r8 = (float) r8
            long r0 = r6.f10224o
            float r9 = (float) r0
            float r8 = r8 / r9
            android.graphics.PointF r9 = r6.f10217h
            android.graphics.PointF r0 = r6.f10218i
            android.graphics.PointF r8 = r6.m6969a(r8, r9, r0)
            android.graphics.Matrix r9 = r6.f10213d
            android.graphics.PointF r0 = r6.f10216g
            float r1 = r8.x
            int r2 = r6.f10219j
            int r2 = r2 / 2
            float r2 = (float) r2
            float r1 = r1 - r2
            r0.x = r1
            android.graphics.PointF r0 = r6.f10216g
            float r2 = r8.y
            r0.y = r2
            r9.setTranslate(r1, r2)
            android.graphics.Matrix r9 = r6.f10213d
            float r0 = r6.f10223n
            int r1 = r6.f10219j
            int r1 = r1 / 2
            float r1 = (float) r1
            int r2 = r6.f10220k
            float r2 = (float) r2
            r9.preScale(r0, r0, r1, r2)
            android.graphics.Bitmap r9 = r6.f10215f
            if (r9 == 0) goto L_0x0106
            boolean r9 = r9.isRecycled()
            if (r9 != 0) goto L_0x0106
            android.graphics.Bitmap r9 = r6.f10215f
            android.graphics.Matrix r0 = r6.f10213d
            android.graphics.Paint r1 = r6.f10214e
            r7.drawBitmap(r9, r0, r1)
        L_0x0106:
            com.didi.beatles.p099im.views.eggs.evaluator.PointFInterpolatorEvaluator.recyclePointF(r8)
        L_0x0109:
            return
        L_0x010a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "You should call #init first!"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.views.eggs.fall.IMFallEggsDrop.m6972a(android.graphics.Canvas, long):void");
    }

    /* renamed from: a */
    private PointF m6969a(float f, PointF pointF, PointF pointF2) {
        return this.f10228s.evaluate(f, pointF, pointF2);
    }

    /* renamed from: a */
    private PointF m6970a(PointF pointF) {
        int i = this.f10219j;
        pointF.set((float) (i + this.f10232w.nextInt(this.f10221l - i)), (float) (-this.f10220k));
        return pointF;
    }

    /* renamed from: a */
    private PointF m6971a(PointF pointF, PointF pointF2) {
        pointF2.set(pointF.x + ((float) ((this.f10232w.nextBoolean() ? 1 : -1) * (this.f10219j + this.f10232w.nextInt(this.f10221l / 4)))), (float) (IMWindowUtil.getScreenHeight() - f10211b));
        return pointF2;
    }
}
