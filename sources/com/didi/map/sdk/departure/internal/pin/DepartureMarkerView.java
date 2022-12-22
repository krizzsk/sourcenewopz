package com.didi.map.sdk.departure.internal.pin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.didi.map.sdk.departure.internal.util.DimenUtil;
import com.didi.map.sdk.departure.param.PinStyle;
import java.lang.ref.WeakReference;

public class DepartureMarkerView extends View {
    public static final int TYPE_LOADED = 3;
    public static final int TYPE_LOADING = 2;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_NO_STOP = 5;
    public static final int TYPE_TEXT = 4;

    /* renamed from: A */
    private float f28167A;

    /* renamed from: B */
    private int f28168B;

    /* renamed from: C */
    private int f28169C;

    /* renamed from: D */
    private boolean f28170D;

    /* renamed from: a */
    int f28171a;

    /* renamed from: b */
    private int f28172b;

    /* renamed from: c */
    private int f28173c;

    /* renamed from: d */
    private int f28174d;

    /* renamed from: e */
    private int f28175e;

    /* renamed from: f */
    private int f28176f;

    /* renamed from: g */
    private int f28177g;

    /* renamed from: h */
    private Paint f28178h;

    /* renamed from: i */
    private Paint f28179i;

    /* renamed from: j */
    private Paint f28180j;

    /* renamed from: k */
    private Paint f28181k;

    /* renamed from: l */
    private Paint f28182l;

    /* renamed from: m */
    private Paint f28183m;

    /* renamed from: n */
    private int f28184n;

    /* renamed from: o */
    private int f28185o;

    /* renamed from: p */
    private int f28186p;

    /* renamed from: q */
    private int f28187q;

    /* renamed from: r */
    private int f28188r;

    /* renamed from: s */
    private int f28189s;

    /* renamed from: t */
    private int f28190t;

    /* renamed from: u */
    private int f28191u;

    /* renamed from: v */
    private int f28192v;

    /* renamed from: w */
    private String f28193w;

    /* renamed from: x */
    private StartLoadingAnimation f28194x;

    /* renamed from: y */
    private StopLoadingAnimation f28195y;

    /* renamed from: z */
    private float f28196z;

    public interface AnimationFinishListener {
        void onFinish();
    }

    public DepartureMarkerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DepartureMarkerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28171a = 1;
        this.f28172b = Color.parseColor("#ffffff");
        this.f28173c = Color.parseColor("#00D0AD");
        this.f28174d = Color.parseColor("#00ffffff");
        this.f28175e = Color.parseColor("#227B6C");
        this.f28176f = Color.parseColor("#ffffff");
        this.f28177g = Color.parseColor("#00D0AD");
        this.f28178h = null;
        this.f28179i = null;
        this.f28180j = null;
        this.f28181k = null;
        this.f28182l = null;
        this.f28183m = null;
        this.f28184n = 0;
        this.f28185o = 0;
        this.f28186p = 0;
        this.f28187q = 0;
        this.f28188r = 0;
        this.f28189s = 0;
        this.f28190t = 0;
        this.f28191u = 0;
        this.f28192v = 0;
        this.f28193w = null;
        this.f28194x = null;
        this.f28195y = null;
        this.f28196z = 0.0f;
        this.f28167A = 0.0f;
        this.f28168B = 0;
        this.f28169C = 0;
        this.f28170D = false;
        this.f28184n = DimenUtil.dip2px(getContext(), 3.0f);
        this.f28185o = DimenUtil.dip2px(getContext(), 11.0f);
        this.f28186p = DimenUtil.dip2px(getContext(), 0.5f);
        this.f28187q = DimenUtil.dip2px(getContext(), 2.0f);
        this.f28188r = DimenUtil.dip2px(getContext(), 10.0f);
        this.f28190t = DimenUtil.dip2px(getContext(), 10.0f);
        this.f28189s = DimenUtil.dip2px(getContext(), -15.0f);
        this.f28191u = DimenUtil.dip2px(getContext(), 3.0f);
        this.f28192v = DimenUtil.dip2px(getContext(), 2.0f);
        Paint paint = new Paint();
        this.f28178h = paint;
        paint.setAntiAlias(true);
        this.f28178h.setColor(this.f28172b);
        Paint paint2 = new Paint();
        this.f28179i = paint2;
        paint2.setAntiAlias(true);
        this.f28179i.setColor(this.f28173c);
        Paint paint3 = new Paint();
        this.f28180j = paint3;
        paint3.setAntiAlias(true);
        this.f28180j.setColor(this.f28174d);
        this.f28180j.setStrokeWidth((float) this.f28186p);
        this.f28180j.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint();
        this.f28181k = paint4;
        paint4.setAntiAlias(true);
        this.f28181k.setColor(this.f28175e);
        Paint paint5 = new Paint();
        this.f28182l = paint5;
        paint5.setAntiAlias(true);
        this.f28182l.setColor(this.f28176f);
        this.f28182l.setTextAlign(Paint.Align.CENTER);
        this.f28182l.setTextSize((float) this.f28190t);
        Paint paint6 = new Paint();
        this.f28183m = paint6;
        paint6.setAntiAlias(true);
        this.f28183m.setColor(this.f28177g);
    }

    public void setPinStyle(PinStyle pinStyle) {
        if (pinStyle != null) {
            if (pinStyle.smallCircleColor != 0) {
                this.f28172b = pinStyle.smallCircleColor;
            }
            if (pinStyle.bigCircleColor != 0) {
                this.f28173c = pinStyle.bigCircleColor;
            }
            if (pinStyle.bigCircleStrokeColor != 0) {
                this.f28174d = pinStyle.bigCircleStrokeColor;
            }
            if (pinStyle.rectColor != 0) {
                this.f28175e = pinStyle.rectColor;
            }
            if (pinStyle.shadowColor != 0) {
                this.f28177g = pinStyle.shadowColor;
            }
            boolean z = pinStyle.rectVisible;
            this.f28170D = z;
            if (!z) {
                this.f28188r = 0;
                this.f28187q = 0;
            }
            this.f28178h.setColor(this.f28172b);
            this.f28179i.setColor(this.f28173c);
            this.f28180j.setColor(this.f28174d);
            this.f28180j.setStrokeWidth((float) this.f28186p);
            this.f28180j.setStyle(Paint.Style.STROKE);
            this.f28181k.setColor(this.f28175e);
            this.f28182l.setColor(this.f28176f);
            this.f28182l.setTextAlign(Paint.Align.CENTER);
            this.f28182l.setTextSize((float) this.f28190t);
            this.f28183m.setColor(this.f28177g);
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f28171a == 3) {
            super.onMeasure(i, i2);
            return;
        }
        if (this.f28168B == 0) {
            this.f28168B = this.f28188r + (this.f28185o * 2) + (this.f28192v / 2) + this.f28186p;
        }
        if (this.f28169C == 0) {
            this.f28169C = (this.f28185o * 2) + (this.f28186p * 2);
        }
        setMeasuredDimension(this.f28169C, this.f28168B);
    }

    public void setNormal() {
        clearAnimation();
        this.f28171a = 1;
        invalidate();
    }

    public void setNoStopZoneStatus() {
        clearAnimation();
        this.f28171a = 5;
        invalidate();
    }

    public void setText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f28171a = 4;
            this.f28193w = str.substring(0, 1);
            invalidate();
            return;
        }
        setNormal();
    }

    public void startLoading() {
        clearAnimation();
        this.f28171a = 2;
        StartLoadingAnimation startLoadingAnimation = new StartLoadingAnimation();
        this.f28194x = startLoadingAnimation;
        startLoadingAnimation.setAnimationListener(new DepartureMarkerAnimationListener());
        startAnimation(this.f28194x);
    }

    /* access modifiers changed from: private */
    public void setLoading(float f) {
        this.f28196z = f;
        invalidate();
    }

    public void startJump(final AnimationFinishListener animationFinishListener) {
        clearAnimation();
        this.f28171a = 3;
        StopLoadingAnimation stopLoadingAnimation = new StopLoadingAnimation();
        this.f28195y = stopLoadingAnimation;
        stopLoadingAnimation.setAnimationListener(new DepartureMarkerAnimationListener() {
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                AnimationFinishListener animationFinishListener = animationFinishListener;
                if (animationFinishListener != null) {
                    animationFinishListener.onFinish();
                }
            }
        });
        startAnimation(this.f28195y);
    }

    /* access modifiers changed from: package-private */
    public void setLoaded(float f) {
        this.f28167A = f;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (f >= 0.0f && ((double) f) < 0.5d) {
            layoutParams.width = this.f28169C;
            layoutParams.height = (int) (((float) this.f28168B) + ((f / 0.5f) * ((float) this.f28188r)));
        } else if (((double) f) >= 0.5d && f <= 1.0f) {
            layoutParams.width = this.f28169C;
            layoutParams.height = (int) (((float) this.f28168B) + (((1.0f - f) / 0.5f) * ((float) this.f28188r)));
        }
        setLayoutParams(layoutParams);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.f28171a;
        if (i == 1) {
            m20028a(canvas);
        } else if (i == 2) {
            m20031b(canvas);
        } else if (i == 3) {
            m20032c(canvas);
        } else if (i == 4) {
            m20029a(canvas, this.f28193w);
        } else if (i == 5) {
            drawNoStopZoneIcon(canvas);
        } else {
            m20028a(canvas);
        }
    }

    /* renamed from: a */
    private void m20028a(Canvas canvas) {
        if (this.f28170D) {
            canvas.drawOval(new RectF((((float) getWidth()) / 2.0f) - (((float) this.f28191u) / 2.0f), (float) (getHeight() - this.f28192v), (((float) getWidth()) / 2.0f) + (((float) this.f28191u) / 2.0f), (float) getHeight()), this.f28183m);
            canvas.drawRect((((float) getWidth()) / 2.0f) - (((float) this.f28187q) / 2.0f), (float) this.f28185o, (((float) getWidth()) / 2.0f) + (((float) this.f28187q) / 2.0f), ((float) getHeight()) - (((float) this.f28192v) / 2.0f), this.f28181k);
        }
        this.f28179i.setAlpha(255);
        int i = this.f28185o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f28186p + i), (float) i, this.f28179i);
        int i2 = this.f28185o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f28186p + i2), (float) i2, this.f28180j);
        this.f28178h.setAlpha(255);
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f28185o + this.f28186p), (float) this.f28184n, this.f28178h);
    }

    /* renamed from: b */
    private void m20031b(Canvas canvas) {
        if (this.f28196z < 0.0f) {
            this.f28196z = 0.0f;
        }
        if (this.f28196z > 1.0f) {
            this.f28196z = 1.0f;
        }
        if (this.f28170D) {
            canvas.drawOval(new RectF((((float) getWidth()) / 2.0f) - (((float) this.f28191u) / 2.0f), (float) (getHeight() - this.f28192v), (((float) getWidth()) / 2.0f) + (((float) this.f28191u) / 2.0f), (float) getHeight()), this.f28183m);
            canvas.drawRect((((float) getWidth()) / 2.0f) - (((float) this.f28187q) / 2.0f), (float) this.f28185o, (((float) getWidth()) / 2.0f) + (((float) this.f28187q) / 2.0f), ((float) getHeight()) - (((float) this.f28192v) / 2.0f), this.f28181k);
        }
        float f = this.f28196z;
        if (f < 0.0f || ((double) f) >= 0.5d) {
            float f2 = this.f28196z;
            if (((double) f2) >= 0.5d && f2 <= 1.0f) {
                this.f28178h.setAlpha(255);
                int i = this.f28185o;
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f28186p + i), (float) i, this.f28178h);
                this.f28179i.setAlpha(255);
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f28185o + this.f28186p), ((float) this.f28184n) + (((this.f28196z - 0.5f) / 0.5f) * ((float) (this.f28185o - this.f28184n))), this.f28179i);
                this.f28178h.setAlpha((int) ((((double) this.f28196z) - 0.5d) * 255.0d * 2.0d));
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f28185o + this.f28186p), (float) this.f28184n, this.f28178h);
            }
        } else {
            this.f28179i.setAlpha(255);
            int i2 = this.f28185o;
            canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f28186p + i2), (float) i2, this.f28179i);
            this.f28178h.setAlpha(255);
            canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f28185o + this.f28186p), ((float) this.f28184n) + ((this.f28196z / 0.5f) * ((float) (this.f28185o - this.f28184n))), this.f28178h);
            this.f28179i.setAlpha((int) (this.f28196z * 255.0f * 2.0f));
            canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f28185o + this.f28186p), (float) this.f28184n, this.f28179i);
        }
        int i3 = this.f28185o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f28186p + i3), (float) i3, this.f28180j);
    }

    /* renamed from: c */
    private void m20032c(Canvas canvas) {
        float f;
        if (this.f28167A < 0.0f) {
            this.f28167A = 0.0f;
        }
        if (this.f28167A > 1.0f) {
            this.f28167A = 1.0f;
        }
        float f2 = this.f28167A;
        if (f2 < 0.0f || ((double) f2) >= 0.5d) {
            float f3 = this.f28167A;
            if (((double) f3) >= 0.5d && f3 <= 1.0f) {
                if (((double) f3) <= 0.5d || ((double) f3) > 0.75d) {
                    f = ((float) this.f28188r) * ((1.0f - this.f28167A) / 0.25f);
                } else {
                    f = ((f3 - 0.5f) / 0.25f) * ((float) this.f28188r);
                }
                if (this.f28170D) {
                    canvas.drawOval(new RectF((((float) getWidth()) / 2.0f) - (((float) this.f28191u) / 2.0f), ((float) (getHeight() - this.f28192v)) - f, (((float) getWidth()) / 2.0f) + (((float) this.f28191u) / 2.0f), ((float) getHeight()) - f), this.f28183m);
                    canvas.drawRect((((float) getWidth()) / 2.0f) - (((float) this.f28187q) / 2.0f), (float) this.f28185o, (((float) getWidth()) / 2.0f) + (((float) this.f28187q) / 2.0f), (((float) getHeight()) - (((float) this.f28192v) / 2.0f)) - f, this.f28181k);
                }
                this.f28179i.setAlpha(255);
                int i = this.f28185o;
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f28186p + i), (float) i, this.f28179i);
                int i2 = this.f28185o;
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f28186p + i2), (float) i2, this.f28180j);
                this.f28178h.setAlpha(255);
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f28185o + this.f28186p), (float) this.f28184n, this.f28178h);
                return;
            }
            return;
        }
        if (this.f28170D) {
            canvas.drawOval(new RectF((((float) getWidth()) / 2.0f) - (((float) this.f28191u) / 2.0f), (float) (getHeight() - this.f28192v), (((float) getWidth()) / 2.0f) + (((float) this.f28191u) / 2.0f), (float) getHeight()), this.f28183m);
            canvas.drawRect((((float) getWidth()) / 2.0f) - (((float) this.f28187q) / 2.0f), (float) this.f28185o, (((float) getWidth()) / 2.0f) + (((float) this.f28187q) / 2.0f), ((float) getHeight()) - (((float) this.f28192v) / 2.0f), this.f28181k);
        }
        this.f28179i.setAlpha(255);
        int i3 = this.f28185o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f28186p + i3), (float) i3, this.f28179i);
        int i4 = this.f28185o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f28186p + i4), (float) i4, this.f28180j);
        this.f28178h.setAlpha(255);
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f28185o + this.f28186p), (float) this.f28184n, this.f28178h);
    }

    /* renamed from: a */
    private void m20029a(Canvas canvas, String str) {
        if (this.f28170D) {
            canvas.drawOval(new RectF((((float) getWidth()) / 2.0f) - (((float) this.f28191u) / 2.0f), (float) (getHeight() - this.f28192v), (((float) getWidth()) / 2.0f) + (((float) this.f28191u) / 2.0f), (float) getHeight()), this.f28183m);
            canvas.drawRect((((float) getWidth()) / 2.0f) - (((float) this.f28187q) / 2.0f), (float) this.f28185o, (((float) getWidth()) / 2.0f) + (((float) this.f28187q) / 2.0f), ((float) getHeight()) - (((float) this.f28192v) / 2.0f), this.f28181k);
        }
        int i = this.f28185o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f28186p + i), (float) i, this.f28179i);
        int i2 = this.f28185o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f28186p + i2), (float) i2, this.f28180j);
        Paint.FontMetrics fontMetrics = this.f28182l.getFontMetrics();
        canvas.drawText(str, ((float) getWidth()) / 2.0f, ((float) this.f28185o) + (((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom), this.f28182l);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        StartLoadingAnimation startLoadingAnimation = this.f28194x;
        if (startLoadingAnimation != null) {
            startLoadingAnimation.cancel();
            this.f28194x = null;
        }
        StartLoadingAnimation startLoadingAnimation2 = this.f28194x;
        if (startLoadingAnimation2 != null) {
            startLoadingAnimation2.cancel();
            this.f28194x = null;
        }
    }

    static class StartLoadingAnimation extends Animation {
        private static int sDuration = 1000;
        private WeakReference<DepartureMarkerView> mDepartureMarkerView;

        private StartLoadingAnimation(DepartureMarkerView departureMarkerView) {
            this.mDepartureMarkerView = null;
            this.mDepartureMarkerView = new WeakReference<>(departureMarkerView);
        }

        public void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            setDuration((long) sDuration);
            setRepeatCount(-1);
            setRepeatMode(1);
            setInterpolator(new LinearInterpolator());
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            DepartureMarkerView departureMarkerView = (DepartureMarkerView) this.mDepartureMarkerView.get();
            if (departureMarkerView != null) {
                departureMarkerView.setLoading(f);
            }
        }
    }

    static class DepartureMarkerAnimationListener implements Animation.AnimationListener {
        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        DepartureMarkerAnimationListener() {
        }
    }

    static class StopLoadingAnimation extends Animation {
        private static int sDuration = 400;
        private WeakReference<DepartureMarkerView> mDepartureMarkerView;

        private StopLoadingAnimation(DepartureMarkerView departureMarkerView) {
            this.mDepartureMarkerView = null;
            this.mDepartureMarkerView = new WeakReference<>(departureMarkerView);
        }

        public void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            setDuration((long) sDuration);
            setRepeatCount(0);
            setInterpolator(new AccelerateInterpolator());
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            DepartureMarkerView departureMarkerView = (DepartureMarkerView) this.mDepartureMarkerView.get();
            if (departureMarkerView != null) {
                departureMarkerView.setLoaded(f);
            }
        }
    }

    public void drawNoStopZoneIcon(Canvas canvas) {
        float width = ((float) getWidth()) / 2.0f;
        if (this.f28170D) {
            canvas.drawOval(new RectF(width - (((float) this.f28191u) / 2.0f), (float) (getHeight() - this.f28192v), (((float) this.f28191u) / 2.0f) + width, (float) getHeight()), this.f28183m);
            int i = this.f28187q;
            canvas.drawRect(width - (((float) i) / 2.0f), (float) this.f28185o, width + (((float) i) / 2.0f), ((float) getHeight()) - (((float) this.f28192v) / 2.0f), this.f28181k);
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setAlpha(255);
        paint.setColor(Color.parseColor("#FF525D"));
        int i2 = this.f28185o;
        canvas.drawCircle(width, (float) (this.f28186p + i2), (float) i2, paint);
        paint.setColor(Color.parseColor("#ffffff"));
        canvas.drawCircle(width, (float) (this.f28185o + this.f28186p), (float) DimenUtil.dip2px(getContext(), 8.0f), paint);
        paint.setColor(Color.parseColor("#FF525D"));
        int dip2px = DimenUtil.dip2px(getContext(), 4.0f);
        int dip2px2 = DimenUtil.dip2px(getContext(), 7.0f);
        paint.setStrokeWidth((float) dip2px);
        float f = (float) dip2px2;
        float dip2px3 = (float) DimenUtil.dip2px(getContext(), 8.0f);
        canvas.drawLine(width + f, width - dip2px3, width - f, width + dip2px3, paint);
    }
}
