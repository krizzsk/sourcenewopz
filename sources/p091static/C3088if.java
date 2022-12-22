package p091static;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.view.View;
import com.iproov.sdk.p223ui.views.C19931do;

/* renamed from: static.if */
/* compiled from: ScanlineView */
public class C3088if extends View {

    /* renamed from: a */
    private Paint f6852a = new Paint();

    /* renamed from: b */
    private float f6853b = 0.0f;

    /* renamed from: c */
    private Path f6854c = new Path();

    /* renamed from: d */
    private RectF f6855d;

    /* renamed from: e */
    private boolean f6856e = false;

    /* renamed from: f */
    private C19931do f6857f = C19931do.INSIDE_OVAL_ONLY;

    /* renamed from: g */
    private ValueAnimator f6858g;

    public C3088if(Context context) {
        super(context);
        m3883a();
    }

    /* renamed from: a */
    private void m3883a() {
        setAlpha(0.0f);
        setWillNotDraw(false);
        this.f6852a.setStyle(Paint.Style.STROKE);
        this.f6852a.setStrokeWidth(10.0f);
        this.f6852a.setStrokeCap(Paint.Cap.ROUND);
        this.f6852a.setAntiAlias(true);
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(800);
        this.f6858g = duration;
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C3088if.this.m3884a(valueAnimator);
            }
        });
        this.f6858g.setRepeatCount(-1);
        this.f6858g.setRepeatMode(2);
        this.f6858g.start();
    }

    /* renamed from: b */
    private void m3885b() {
        if (this.f6855d == null) {
            this.f6855d = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        }
        this.f6854c.reset();
        this.f6854c.addOval(this.f6855d, Path.Direction.CW);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r4.f6855d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.RectF getRect() {
        /*
            r4 = this;
            boolean r0 = r4.f6856e
            if (r0 != 0) goto L_0x0008
            android.graphics.RectF r0 = r4.f6855d
            if (r0 != 0) goto L_0x0018
        L_0x0008:
            android.graphics.RectF r0 = new android.graphics.RectF
            int r1 = r4.getWidth()
            float r1 = (float) r1
            int r2 = r4.getHeight()
            float r2 = (float) r2
            r3 = 0
            r0.<init>(r3, r3, r1, r2)
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p091static.C3088if.getRect():android.graphics.RectF");
    }

    private void setPosition(float f) {
        this.f6853b = f;
        invalidate();
    }

    /* renamed from: for  reason: not valid java name */
    public void m46186for() {
        this.f6858g.cancel();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        C19931do doVar = this.f6857f;
        if (doVar == C19931do.INSIDE_OVAL_ONLY) {
            canvas.clipPath(this.f6854c);
        } else if (doVar == C19931do.OUTSIDE_OVAL_ONLY) {
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipOutPath(this.f6854c);
            } else {
                canvas.clipPath(this.f6854c, Region.Op.DIFFERENCE);
            }
        }
        super.onDraw(canvas);
        RectF rect = getRect();
        float height = (float) ((int) (rect.top + (rect.height() * this.f6853b)));
        canvas.drawLine(rect.left, height, rect.right, height, this.f6852a);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        m3885b();
    }

    public void setColor(int i) {
        this.f6852a.setColor(i);
        this.f6852a.setAlpha(255);
        invalidate();
    }

    public void setDrawRect(RectF rectF) {
        this.f6855d = new RectF(rectF);
        m3885b();
    }

    public void setScanlineType(C19931do doVar) {
        this.f6857f = doVar;
        this.f6856e = doVar != C19931do.INSIDE_OVAL_ONLY;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m3884a(ValueAnimator valueAnimator) {
        setPosition(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
