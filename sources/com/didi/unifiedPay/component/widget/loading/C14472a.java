package com.didi.unifiedPay.component.widget.loading;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.didi.unifiedPay.component.widget.loading.CircularProgressDrawable;
import com.taxis99.R;

/* renamed from: com.didi.unifiedPay.component.widget.loading.a */
/* compiled from: DefaultDelegate */
class C14472a implements C14476e {
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final ArgbEvaluator f44496c = new ArgbEvaluator();

    /* renamed from: d */
    private static final Interpolator f44497d = new LinearInterpolator();

    /* renamed from: e */
    private static final long f44498e = 2000;

    /* renamed from: f */
    private static final long f44499f = 1500;

    /* renamed from: g */
    private static final long f44500g = 200;

    /* renamed from: h */
    private static long f44501h = 500;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f44502A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public int f44503B;

    /* renamed from: C */
    private int f44504C;

    /* renamed from: D */
    private int f44505D;

    /* renamed from: E */
    private C14475d f44506E;

    /* renamed from: F */
    private long f44507F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public CircularProgressDrawable f44508G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public CircularProgressDrawable.OnEndListener f44509H;

    /* renamed from: a */
    protected Bitmap f44510a;

    /* renamed from: b */
    protected boolean f44511b;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ValueAnimator f44512i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ValueAnimator f44513j;

    /* renamed from: k */
    private ValueAnimator f44514k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public ValueAnimator f44515l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f44516m;

    /* renamed from: n */
    private Context f44517n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f44518o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f44519p;

    /* renamed from: q */
    private float f44520q;

    /* renamed from: r */
    private float f44521r = 0.0f;

    /* renamed from: s */
    private float f44522s = 0.0f;

    /* renamed from: t */
    private float f44523t = 1.0f;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f44524u;

    /* renamed from: v */
    private Interpolator f44525v;

    /* renamed from: w */
    private Interpolator f44526w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int[] f44527x;

    /* renamed from: y */
    private float f44528y;

    /* renamed from: z */
    private float f44529z;

    /* renamed from: c */
    private float m31611c(float f) {
        return (360.0f - (f % 360.0f)) % 360.0f;
    }

    public C14472a(Context context, CircularProgressDrawable circularProgressDrawable, C14475d dVar) {
        this.f44517n = context;
        this.f44508G = circularProgressDrawable;
        this.f44506E = dVar;
        this.f44526w = dVar.f44534b;
        this.f44525v = dVar.f44533a;
        this.f44519p = 0;
        int[] iArr = dVar.f44536d;
        this.f44527x = iArr;
        this.f44518o = iArr[0];
        this.f44528y = dVar.f44537e;
        this.f44529z = dVar.f44538f;
        this.f44502A = dVar.f44539g;
        this.f44503B = dVar.f44540h;
        this.f44504C = dVar.f44541i;
        m31626j();
    }

    /* renamed from: e */
    private void m31617e() {
        this.f44524u = true;
        this.f44523t = 1.0f;
        this.f44508G.getCurrentPaint().setColor(this.f44518o);
    }

    /* renamed from: a */
    public void mo111594a(Bitmap bitmap) {
        this.f44510a = bitmap;
        this.f44507F = System.currentTimeMillis();
        this.f44505D = this.f44517n.getResources().getColor(R.color.cpb_success_bgcolor);
        this.f44511b = true;
    }

    /* renamed from: a */
    public void mo111592a() {
        this.f44511b = false;
    }

    /* renamed from: a */
    public void mo111595a(Canvas canvas, Paint paint) {
        RectF drawableBounds = this.f44508G.getDrawableBounds();
        int i = (int) (drawableBounds.left + ((drawableBounds.right - drawableBounds.left) / 2.0f));
        int i2 = (int) (drawableBounds.top + ((drawableBounds.right - drawableBounds.left) / 2.0f));
        int i3 = ((int) (drawableBounds.right - drawableBounds.left)) / 2;
        m31601a(canvas, paint, i, i2, (float) i3, !this.f44511b);
        if (this.f44511b) {
            m31602a(canvas, paint, i, i2, i3);
        } else {
            m31600a(canvas);
        }
    }

    /* renamed from: a */
    private void m31601a(Canvas canvas, Paint paint, int i, int i2, float f, boolean z) {
        m31603a(paint, z);
        canvas.drawCircle((float) i, (float) i2, f, paint);
    }

    /* renamed from: a */
    private void m31602a(Canvas canvas, Paint paint, int i, int i2, int i3) {
        int i4 = i3 * 2;
        int i5 = i - i3;
        int i6 = i2 - i3;
        Rect rect = new Rect(i5, i6, ((int) (((float) i4) * m31618f())) + i5, i4 + i6);
        RectF rectF = new RectF(rect);
        Bitmap a = m31598a(this.f44510a, i3);
        if (a != null) {
            canvas.drawBitmap(a, rect, rectF, paint);
        }
    }

    /* renamed from: a */
    private Bitmap m31598a(Bitmap bitmap, int i) {
        int width = (int) (((float) bitmap.getWidth()) * m31618f());
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return createBitmap;
    }

    /* renamed from: f */
    private float m31618f() {
        float currentTimeMillis = (((float) (System.currentTimeMillis() - this.f44507F)) * 1.0f) / ((float) f44501h);
        if (currentTimeMillis > 1.0f) {
            return 1.0f;
        }
        return currentTimeMillis;
    }

    /* renamed from: b */
    private Bitmap m31609b(Bitmap bitmap, int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        float f = (float) (i / 2);
        canvas.drawCircle(f, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    /* renamed from: a */
    private void m31600a(Canvas canvas) {
        float f;
        Paint initPaint = this.f44508G.initPaint(this.f44506E);
        float f2 = this.f44522s - this.f44521r;
        float f3 = this.f44520q;
        if (!this.f44516m) {
            f2 += 360.0f - f3;
        }
        float f4 = f2 % 360.0f;
        float f5 = this.f44523t;
        if (f5 < 1.0f) {
            float f6 = f5 * f3;
            f4 = (f4 + (f3 - f6)) % 360.0f;
            f = f6;
        } else {
            f = f3;
        }
        float c = m31611c(f4 + f);
        float f7 = c + f;
        if (f7 > 360.0f) {
            Paint paint = initPaint;
            canvas.drawArc(this.f44508G.getDrawableBounds(), c, 360.0f - c, false, paint);
            canvas.drawArc(this.f44508G.getDrawableBounds(), 0.0f, f7 - 360.0f, false, paint);
            return;
        }
        canvas.drawArc(this.f44508G.getDrawableBounds(), c, f, false, initPaint);
    }

    /* renamed from: a */
    private void m31603a(Paint paint, boolean z) {
        if (z) {
            paint.setColor(this.f44504C);
        } else {
            paint.setColor(this.f44505D);
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(0.0f);
        paint.setAntiAlias(true);
    }

    /* renamed from: b */
    public void mo111597b() {
        this.f44515l.cancel();
        m31617e();
        this.f44514k.start();
        this.f44512i.start();
    }

    /* renamed from: c */
    public void mo111599c() {
        m31621g();
    }

    /* renamed from: g */
    private void m31621g() {
        this.f44514k.cancel();
        this.f44512i.cancel();
        this.f44513j.cancel();
        this.f44515l.cancel();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m31623h() {
        this.f44516m = true;
        this.f44521r += (float) this.f44502A;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m31625i() {
        this.f44516m = false;
        this.f44521r += (float) (360 - this.f44503B);
    }

    /* renamed from: a */
    public void mo111593a(float f) {
        this.f44522s = f;
        this.f44508G.invalidate();
    }

    /* renamed from: b */
    public void mo111598b(float f) {
        this.f44520q = f;
        this.f44508G.invalidate();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m31614d(float f) {
        this.f44523t = f;
        this.f44508G.invalidate();
    }

    /* renamed from: j */
    private void m31626j() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
        this.f44514k = ofFloat;
        ofFloat.setInterpolator(this.f44525v);
        this.f44514k.setDuration((long) (2000.0f / this.f44529z));
        this.f44514k.addUpdateListener(new DefaultDelegate$1(this));
        this.f44514k.setRepeatCount(-1);
        this.f44514k.setRepeatMode(1);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{(float) this.f44502A, (float) this.f44503B});
        this.f44512i = ofFloat2;
        ofFloat2.setInterpolator(this.f44526w);
        this.f44512i.setDuration((long) (1500.0f / this.f44528y));
        this.f44512i.addUpdateListener(new DefaultDelegate$2(this));
        this.f44512i.addListener(new DefaultDelegate$3(this));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{(float) this.f44503B, (float) this.f44502A});
        this.f44513j = ofFloat3;
        ofFloat3.setInterpolator(this.f44526w);
        this.f44513j.setDuration((long) (1500.0f / this.f44528y));
        this.f44513j.addUpdateListener(new DefaultDelegate$4(this));
        this.f44513j.addListener(new DefaultDelegate$5(this));
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.f44515l = ofFloat4;
        ofFloat4.setInterpolator(f44497d);
        this.f44515l.setDuration(200);
        this.f44515l.addUpdateListener(new DefaultDelegate$6(this));
    }

    /* renamed from: a */
    public void mo111596a(CircularProgressDrawable.OnEndListener onEndListener) {
        if (this.f44508G.isRunning() && !this.f44515l.isRunning()) {
            this.f44509H = onEndListener;
            this.f44515l.addListener(new DefaultDelegate$7(this));
            this.f44515l.start();
        }
    }
}
