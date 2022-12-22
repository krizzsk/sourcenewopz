package com.didi.map.global.component.departure.pin;

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
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.departure.model.PinStyle;
import java.lang.ref.WeakReference;

public class DepartureMarkerView extends View {
    public static final int TYPE_LOADED = 3;
    public static final int TYPE_LOADING = 2;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_NO_STOP = 5;
    public static final int TYPE_TEXT = 4;

    /* renamed from: A */
    private float f25200A;

    /* renamed from: B */
    private int f25201B;

    /* renamed from: C */
    private int f25202C;

    /* renamed from: D */
    private boolean f25203D;

    /* renamed from: E */
    private Context f25204E;

    /* renamed from: a */
    int f25205a;

    /* renamed from: b */
    private int f25206b;

    /* renamed from: c */
    private int f25207c;

    /* renamed from: d */
    private int f25208d;

    /* renamed from: e */
    private int f25209e;

    /* renamed from: f */
    private int f25210f;

    /* renamed from: g */
    private int f25211g;

    /* renamed from: h */
    private Paint f25212h;

    /* renamed from: i */
    private Paint f25213i;

    /* renamed from: j */
    private Paint f25214j;

    /* renamed from: k */
    private Paint f25215k;

    /* renamed from: l */
    private Paint f25216l;

    /* renamed from: m */
    private Paint f25217m;

    /* renamed from: n */
    private int f25218n;

    /* renamed from: o */
    private int f25219o;

    /* renamed from: p */
    private int f25220p;

    /* renamed from: q */
    private int f25221q;

    /* renamed from: r */
    private int f25222r;

    /* renamed from: s */
    private int f25223s;

    /* renamed from: t */
    private int f25224t;

    /* renamed from: u */
    private int f25225u;

    /* renamed from: v */
    private int f25226v;

    /* renamed from: w */
    private String f25227w;

    /* renamed from: x */
    private StartLoadingAnimation f25228x;

    /* renamed from: y */
    private StopLoadingAnimation f25229y;

    /* renamed from: z */
    private float f25230z;

    public interface AnimationFinishListener {
        void onFinish();
    }

    public DepartureMarkerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DepartureMarkerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25205a = 1;
        this.f25206b = Color.parseColor("#ffffff");
        this.f25207c = Color.parseColor("#00D0AD");
        this.f25208d = Color.parseColor("#00ffffff");
        this.f25209e = Color.parseColor("#227B6C");
        this.f25210f = Color.parseColor("#ffffff");
        this.f25211g = Color.parseColor("#00D0AD");
        this.f25212h = null;
        this.f25213i = null;
        this.f25214j = null;
        this.f25215k = null;
        this.f25216l = null;
        this.f25217m = null;
        this.f25218n = 0;
        this.f25219o = 0;
        this.f25220p = 0;
        this.f25221q = 0;
        this.f25222r = 0;
        this.f25223s = 0;
        this.f25224t = 0;
        this.f25225u = 0;
        this.f25226v = 0;
        this.f25227w = null;
        this.f25228x = null;
        this.f25229y = null;
        this.f25230z = 0.0f;
        this.f25200A = 0.0f;
        this.f25201B = 0;
        this.f25202C = 0;
        this.f25203D = false;
        this.f25204E = context;
        this.f25218n = DisplayUtils.dp2px(context, 3.0f);
        this.f25219o = DisplayUtils.dp2px(context, 11.0f);
        this.f25220p = DisplayUtils.dp2px(context, 0.5f);
        this.f25221q = DisplayUtils.dp2px(context, 2.0f);
        this.f25222r = DisplayUtils.dp2px(context, 10.0f);
        this.f25224t = DisplayUtils.dp2px(context, 10.0f);
        this.f25223s = DisplayUtils.dp2px(context, -15.0f);
        this.f25225u = DisplayUtils.dp2px(context, 3.0f);
        this.f25226v = DisplayUtils.dp2px(context, 2.0f);
        Paint paint = new Paint();
        this.f25212h = paint;
        paint.setAntiAlias(true);
        this.f25212h.setColor(this.f25206b);
        Paint paint2 = new Paint();
        this.f25213i = paint2;
        paint2.setAntiAlias(true);
        this.f25213i.setColor(this.f25207c);
        Paint paint3 = new Paint();
        this.f25214j = paint3;
        paint3.setAntiAlias(true);
        this.f25214j.setColor(this.f25208d);
        this.f25214j.setStrokeWidth((float) this.f25220p);
        this.f25214j.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint();
        this.f25215k = paint4;
        paint4.setAntiAlias(true);
        this.f25215k.setColor(this.f25209e);
        Paint paint5 = new Paint();
        this.f25216l = paint5;
        paint5.setAntiAlias(true);
        this.f25216l.setColor(this.f25210f);
        this.f25216l.setTextAlign(Paint.Align.CENTER);
        this.f25216l.setTextSize((float) this.f25224t);
        Paint paint6 = new Paint();
        this.f25217m = paint6;
        paint6.setAntiAlias(true);
        this.f25217m.setColor(this.f25211g);
    }

    public void setPinStyle(PinStyle pinStyle) {
        if (pinStyle != null) {
            if (pinStyle.smallCircleColor != 0) {
                this.f25206b = pinStyle.smallCircleColor;
            }
            if (pinStyle.bigCircleColor != 0) {
                this.f25207c = pinStyle.bigCircleColor;
            }
            if (pinStyle.bigCircleStrokeColor != 0) {
                this.f25208d = pinStyle.bigCircleStrokeColor;
            }
            if (pinStyle.rectColor != 0) {
                this.f25209e = pinStyle.rectColor;
            }
            if (pinStyle.shadowColor != 0) {
                this.f25211g = pinStyle.shadowColor;
            }
            boolean z = pinStyle.rectVisible;
            this.f25203D = z;
            if (!z) {
                this.f25222r = 0;
                this.f25221q = 0;
            }
            this.f25212h.setColor(this.f25206b);
            this.f25213i.setColor(this.f25207c);
            this.f25214j.setColor(this.f25208d);
            this.f25214j.setStrokeWidth((float) this.f25220p);
            this.f25214j.setStyle(Paint.Style.STROKE);
            this.f25215k.setColor(this.f25209e);
            this.f25216l.setColor(this.f25210f);
            this.f25216l.setTextAlign(Paint.Align.CENTER);
            this.f25216l.setTextSize((float) this.f25224t);
            this.f25217m.setColor(this.f25211g);
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f25205a == 3) {
            super.onMeasure(i, i2);
            return;
        }
        if (this.f25201B == 0) {
            this.f25201B = this.f25222r + (this.f25219o * 2) + (this.f25226v / 2) + this.f25220p;
        }
        if (this.f25202C == 0) {
            this.f25202C = (this.f25219o * 2) + (this.f25220p * 2);
        }
        setMeasuredDimension(this.f25202C, this.f25201B);
    }

    public void setNormal() {
        clearAnimation();
        this.f25205a = 1;
        invalidate();
    }

    public void setNoStopZoneStatus() {
        clearAnimation();
        this.f25205a = 5;
        invalidate();
    }

    public void setText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f25205a = 4;
            this.f25227w = str.substring(0, 1);
            invalidate();
            return;
        }
        setNormal();
    }

    public void startLoading() {
        clearAnimation();
        this.f25205a = 2;
        StartLoadingAnimation startLoadingAnimation = new StartLoadingAnimation();
        this.f25228x = startLoadingAnimation;
        startLoadingAnimation.setAnimationListener(new DepartureMarkerAnimationListener());
        startAnimation(this.f25228x);
    }

    /* access modifiers changed from: private */
    public void setLoading(float f) {
        this.f25230z = f;
        invalidate();
    }

    public void startJump(final AnimationFinishListener animationFinishListener) {
        clearAnimation();
        this.f25205a = 3;
        StopLoadingAnimation stopLoadingAnimation = new StopLoadingAnimation();
        this.f25229y = stopLoadingAnimation;
        stopLoadingAnimation.setAnimationListener(new DepartureMarkerAnimationListener() {
            public void onAnimationEnd(Animation animation) {
                super.onAnimationEnd(animation);
                AnimationFinishListener animationFinishListener = animationFinishListener;
                if (animationFinishListener != null) {
                    animationFinishListener.onFinish();
                }
            }
        });
        startAnimation(this.f25229y);
    }

    /* access modifiers changed from: package-private */
    public void setLoaded(float f) {
        this.f25200A = f;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (f >= 0.0f && ((double) f) < 0.5d) {
            layoutParams.width = this.f25202C;
            layoutParams.height = (int) (((float) this.f25201B) + ((f / 0.5f) * ((float) this.f25222r)));
        } else if (((double) f) >= 0.5d && f <= 1.0f) {
            layoutParams.width = this.f25202C;
            layoutParams.height = (int) (((float) this.f25201B) + (((1.0f - f) / 0.5f) * ((float) this.f25222r)));
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
        int i = this.f25205a;
        if (i == 1) {
            m18055a(canvas);
        } else if (i == 2) {
            m18058b(canvas);
        } else if (i == 3) {
            m18059c(canvas);
        } else if (i == 4) {
            m18056a(canvas, this.f25227w);
        } else if (i == 5) {
            drawNoStopZoneIcon(canvas);
        } else {
            m18055a(canvas);
        }
    }

    /* renamed from: a */
    private void m18055a(Canvas canvas) {
        if (this.f25203D) {
            canvas.drawOval(new RectF((((float) getWidth()) / 2.0f) - (((float) this.f25225u) / 2.0f), (float) (getHeight() - this.f25226v), (((float) getWidth()) / 2.0f) + (((float) this.f25225u) / 2.0f), (float) getHeight()), this.f25217m);
            canvas.drawRect((((float) getWidth()) / 2.0f) - (((float) this.f25221q) / 2.0f), (float) this.f25219o, (((float) getWidth()) / 2.0f) + (((float) this.f25221q) / 2.0f), ((float) getHeight()) - (((float) this.f25226v) / 2.0f), this.f25215k);
        }
        this.f25213i.setAlpha(255);
        int i = this.f25219o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f25220p + i), (float) i, this.f25213i);
        int i2 = this.f25219o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f25220p + i2), (float) i2, this.f25214j);
        this.f25212h.setAlpha(255);
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f25219o + this.f25220p), (float) this.f25218n, this.f25212h);
    }

    /* renamed from: b */
    private void m18058b(Canvas canvas) {
        if (this.f25230z < 0.0f) {
            this.f25230z = 0.0f;
        }
        if (this.f25230z > 1.0f) {
            this.f25230z = 1.0f;
        }
        if (this.f25203D) {
            canvas.drawOval(new RectF((((float) getWidth()) / 2.0f) - (((float) this.f25225u) / 2.0f), (float) (getHeight() - this.f25226v), (((float) getWidth()) / 2.0f) + (((float) this.f25225u) / 2.0f), (float) getHeight()), this.f25217m);
            canvas.drawRect((((float) getWidth()) / 2.0f) - (((float) this.f25221q) / 2.0f), (float) this.f25219o, (((float) getWidth()) / 2.0f) + (((float) this.f25221q) / 2.0f), ((float) getHeight()) - (((float) this.f25226v) / 2.0f), this.f25215k);
        }
        float f = this.f25230z;
        if (f < 0.0f || ((double) f) >= 0.5d) {
            float f2 = this.f25230z;
            if (((double) f2) >= 0.5d && f2 <= 1.0f) {
                this.f25212h.setAlpha(255);
                int i = this.f25219o;
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f25220p + i), (float) i, this.f25212h);
                this.f25213i.setAlpha(255);
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f25219o + this.f25220p), ((float) this.f25218n) + (((this.f25230z - 0.5f) / 0.5f) * ((float) (this.f25219o - this.f25218n))), this.f25213i);
                this.f25212h.setAlpha((int) ((((double) this.f25230z) - 0.5d) * 255.0d * 2.0d));
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f25219o + this.f25220p), (float) this.f25218n, this.f25212h);
            }
        } else {
            this.f25213i.setAlpha(255);
            int i2 = this.f25219o;
            canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f25220p + i2), (float) i2, this.f25213i);
            this.f25212h.setAlpha(255);
            canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f25219o + this.f25220p), ((float) this.f25218n) + ((this.f25230z / 0.5f) * ((float) (this.f25219o - this.f25218n))), this.f25212h);
            this.f25213i.setAlpha((int) (this.f25230z * 255.0f * 2.0f));
            canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f25219o + this.f25220p), (float) this.f25218n, this.f25213i);
        }
        int i3 = this.f25219o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f25220p + i3), (float) i3, this.f25214j);
    }

    /* renamed from: c */
    private void m18059c(Canvas canvas) {
        float f;
        if (this.f25200A < 0.0f) {
            this.f25200A = 0.0f;
        }
        if (this.f25200A > 1.0f) {
            this.f25200A = 1.0f;
        }
        float f2 = this.f25200A;
        if (f2 < 0.0f || ((double) f2) >= 0.5d) {
            float f3 = this.f25200A;
            if (((double) f3) >= 0.5d && f3 <= 1.0f) {
                if (((double) f3) <= 0.5d || ((double) f3) > 0.75d) {
                    f = ((float) this.f25222r) * ((1.0f - this.f25200A) / 0.25f);
                } else {
                    f = ((f3 - 0.5f) / 0.25f) * ((float) this.f25222r);
                }
                if (this.f25203D) {
                    canvas.drawOval(new RectF((((float) getWidth()) / 2.0f) - (((float) this.f25225u) / 2.0f), ((float) (getHeight() - this.f25226v)) - f, (((float) getWidth()) / 2.0f) + (((float) this.f25225u) / 2.0f), ((float) getHeight()) - f), this.f25217m);
                    canvas.drawRect((((float) getWidth()) / 2.0f) - (((float) this.f25221q) / 2.0f), (float) this.f25219o, (((float) getWidth()) / 2.0f) + (((float) this.f25221q) / 2.0f), (((float) getHeight()) - (((float) this.f25226v) / 2.0f)) - f, this.f25215k);
                }
                this.f25213i.setAlpha(255);
                int i = this.f25219o;
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f25220p + i), (float) i, this.f25213i);
                int i2 = this.f25219o;
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f25220p + i2), (float) i2, this.f25214j);
                this.f25212h.setAlpha(255);
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f25219o + this.f25220p), (float) this.f25218n, this.f25212h);
                return;
            }
            return;
        }
        if (this.f25203D) {
            canvas.drawOval(new RectF((((float) getWidth()) / 2.0f) - (((float) this.f25225u) / 2.0f), (float) (getHeight() - this.f25226v), (((float) getWidth()) / 2.0f) + (((float) this.f25225u) / 2.0f), (float) getHeight()), this.f25217m);
            canvas.drawRect((((float) getWidth()) / 2.0f) - (((float) this.f25221q) / 2.0f), (float) this.f25219o, (((float) getWidth()) / 2.0f) + (((float) this.f25221q) / 2.0f), ((float) getHeight()) - (((float) this.f25226v) / 2.0f), this.f25215k);
        }
        this.f25213i.setAlpha(255);
        int i3 = this.f25219o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f25220p + i3), (float) i3, this.f25213i);
        int i4 = this.f25219o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f25220p + i4), (float) i4, this.f25214j);
        this.f25212h.setAlpha(255);
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f25219o + this.f25220p), (float) this.f25218n, this.f25212h);
    }

    /* renamed from: a */
    private void m18056a(Canvas canvas, String str) {
        if (this.f25203D) {
            canvas.drawOval(new RectF((((float) getWidth()) / 2.0f) - (((float) this.f25225u) / 2.0f), (float) (getHeight() - this.f25226v), (((float) getWidth()) / 2.0f) + (((float) this.f25225u) / 2.0f), (float) getHeight()), this.f25217m);
            canvas.drawRect((((float) getWidth()) / 2.0f) - (((float) this.f25221q) / 2.0f), (float) this.f25219o, (((float) getWidth()) / 2.0f) + (((float) this.f25221q) / 2.0f), ((float) getHeight()) - (((float) this.f25226v) / 2.0f), this.f25215k);
        }
        int i = this.f25219o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f25220p + i), (float) i, this.f25213i);
        int i2 = this.f25219o;
        canvas.drawCircle(((float) getWidth()) / 2.0f, (float) (this.f25220p + i2), (float) i2, this.f25214j);
        Paint.FontMetrics fontMetrics = this.f25216l.getFontMetrics();
        canvas.drawText(str, ((float) getWidth()) / 2.0f, ((float) this.f25219o) + (((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom), this.f25216l);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        StartLoadingAnimation startLoadingAnimation = this.f25228x;
        if (startLoadingAnimation != null) {
            startLoadingAnimation.cancel();
            this.f25228x = null;
        }
        StartLoadingAnimation startLoadingAnimation2 = this.f25228x;
        if (startLoadingAnimation2 != null) {
            startLoadingAnimation2.cancel();
            this.f25228x = null;
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
        if (this.f25203D) {
            canvas.drawOval(new RectF(width - (((float) this.f25225u) / 2.0f), (float) (getHeight() - this.f25226v), (((float) this.f25225u) / 2.0f) + width, (float) getHeight()), this.f25217m);
            int i = this.f25221q;
            canvas.drawRect(width - (((float) i) / 2.0f), (float) this.f25219o, width + (((float) i) / 2.0f), ((float) getHeight()) - (((float) this.f25226v) / 2.0f), this.f25215k);
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setAlpha(255);
        paint.setColor(Color.parseColor("#FF525D"));
        int i2 = this.f25219o;
        canvas.drawCircle(width, (float) (this.f25220p + i2), (float) i2, paint);
        paint.setColor(Color.parseColor("#ffffff"));
        canvas.drawCircle(width, (float) (this.f25219o + this.f25220p), (float) DisplayUtils.dp2px(this.f25204E, 8.0f), paint);
        paint.setColor(Color.parseColor("#FF525D"));
        int dp2px = DisplayUtils.dp2px(this.f25204E, 4.0f);
        int dp2px2 = DisplayUtils.dp2px(this.f25204E, 7.0f);
        paint.setStrokeWidth((float) dp2px);
        float f = (float) dp2px2;
        float dp2px3 = (float) DisplayUtils.dp2px(this.f25204E, 8.0f);
        canvas.drawLine(width + f, width - dp2px3, width - f, width + dp2px3, paint);
    }
}
