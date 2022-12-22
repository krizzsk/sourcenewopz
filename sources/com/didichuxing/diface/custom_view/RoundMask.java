package com.didichuxing.diface.custom_view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Xfermode;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.didichuxing.diface.utils.DisplayUtils;
import com.taxis99.R;

public class RoundMask extends View {

    /* renamed from: o */
    private static final int f47510o = -657931;

    /* renamed from: p */
    private static final int f47511p = -13399809;

    /* renamed from: a */
    private Paint f47512a;

    /* renamed from: b */
    private int f47513b;

    /* renamed from: c */
    private int f47514c;

    /* renamed from: d */
    private RectF f47515d;

    /* renamed from: e */
    private PorterDuffXfermode f47516e;

    /* renamed from: f */
    private int f47517f;

    /* renamed from: g */
    private Path f47518g;

    /* renamed from: h */
    private Rect f47519h;

    /* renamed from: i */
    private ValueAnimator f47520i;

    /* renamed from: j */
    private Bitmap f47521j;

    /* renamed from: k */
    private int f47522k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f47523l;

    /* renamed from: m */
    private boolean f47524m;

    /* renamed from: n */
    private boolean f47525n;

    /* renamed from: q */
    private int f47526q = 70;

    public RoundMask(Context context) {
        super(context);
        m34018a();
    }

    /* renamed from: a */
    private void m34018a() {
        this.f47513b = DisplayUtils.dip2px(getContext(), 10.0f);
        this.f47514c = DisplayUtils.dip2px(getContext(), 4.0f);
        this.f47512a = new Paint(1);
        this.f47516e = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.df_face_gradient_rect_area);
        this.f47521j = decodeResource;
        int height = decodeResource.getHeight();
        this.f47522k = height;
        this.f47523l = (-height) / 3;
    }

    public void setProgress(int i) {
        if (i < 0) {
            this.f47517f = 0;
        } else if (i > 100) {
            this.f47517f = 100;
        } else {
            this.f47517f = i;
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        int width = getWidth();
        int height = getHeight();
        this.f47512a.setColor(-1);
        canvas.drawRect(0.0f, 0.0f, (float) width, (float) height, this.f47512a);
        int i = width / 2;
        int i2 = i - this.f47513b;
        this.f47512a.setXfermode(this.f47516e);
        this.f47512a.setColor(-65536);
        float f = (float) i;
        float f2 = (float) (height / 2);
        float f3 = (float) i2;
        canvas2.drawCircle(f, f2, f3, this.f47512a);
        this.f47512a.setXfermode((Xfermode) null);
        if (this.f47515d == null) {
            this.f47515d = new RectF((float) (this.f47514c / 2), (float) ((((getHeight() / 2) - i2) - this.f47513b) + (this.f47514c / 2)), (float) (getWidth() - (this.f47514c / 2)), (float) ((((getHeight() / 2) + i2) + this.f47513b) - (this.f47514c / 2)));
        }
        this.f47512a.setColor(f47510o);
        this.f47512a.setStyle(Paint.Style.STROKE);
        this.f47512a.setStrokeWidth((float) this.f47514c);
        float f4 = (float) 90;
        float f5 = (float) 360;
        canvas.drawArc(this.f47515d, f4, f5, false, this.f47512a);
        if (this.f47517f != 0) {
            this.f47512a.setColor(f47511p);
            canvas.drawArc(this.f47515d, f4, (float) ((int) ((((float) this.f47517f) / 100.0f) * f5)), false, this.f47512a);
        }
        if (this.f47525n) {
            if (this.f47518g == null) {
                Path path = new Path();
                this.f47518g = path;
                path.addCircle(f, f2, f3, Path.Direction.CCW);
            }
            Rect rect = this.f47519h;
            if (rect == null) {
                int i3 = this.f47523l;
                this.f47519h = new Rect(0, i3, width, this.f47522k + i3);
            } else {
                rect.top = this.f47523l;
                this.f47519h.bottom = this.f47523l + this.f47522k;
            }
            canvas2.clipRect(this.f47519h);
            canvas2.clipPath(this.f47518g, Region.Op.INTERSECT);
            canvas2.drawBitmap(this.f47521j, (Rect) null, this.f47519h, this.f47512a);
            if (this.f47520i == null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f47523l, (width - this.f47522k) + 200});
                this.f47520i = ofInt;
                ofInt.setRepeatCount(-1);
                this.f47520i.setRepeatMode(1);
                this.f47520i.setInterpolator(new LinearInterpolator());
                this.f47520i.setDuration(3000);
                this.f47520i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int unused = RoundMask.this.f47523l = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        RoundMask.this.postInvalidate();
                    }
                });
                this.f47520i.start();
            }
        }
        this.f47512a.reset();
    }

    /* renamed from: b */
    private void m34019b() {
        int i = this.f47526q - 5;
        this.f47526q = i;
        if (((float) i) <= 10.0f) {
            this.f47526q = 70;
        }
        postDelayed(new Runnable() {
            public void run() {
                RoundMask.this.invalidate();
            }
        }, 200);
    }

    public void onFaceOk() {
        this.f47525n = true;
        invalidate();
    }

    public void cancelRectAnim() {
        this.f47523l = (-this.f47522k) / 3;
        this.f47525n = false;
        ValueAnimator valueAnimator = this.f47520i;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f47524m = true;
            this.f47520i = null;
            invalidate();
        }
    }
}
