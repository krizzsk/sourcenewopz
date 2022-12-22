package com.didi.unifiedPay.component.widget.loading;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.PowerManager;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.didi.sdk.util.UiThreadHandler;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CircularProgressDrawable extends Drawable implements Animatable {
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_ROUNDED = 1;

    /* renamed from: a */
    private final RectF f44484a;

    /* renamed from: b */
    private C14475d f44485b;

    /* renamed from: c */
    private Paint f44486c;

    /* renamed from: d */
    private boolean f44487d;

    /* renamed from: e */
    private C14476e f44488e;

    /* renamed from: f */
    private Context f44489f;

    public interface OnEndListener {
        void onEnd(CircularProgressDrawable circularProgressDrawable);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Style {
    }

    public int getOpacity() {
        return -3;
    }

    private CircularProgressDrawable(Context context, PowerManager powerManager, C14475d dVar) {
        this.f44484a = new RectF();
        this.f44489f = context;
        this.f44485b = dVar;
        initPaint(dVar);
        m31595a();
    }

    public Paint initPaint(C14475d dVar) {
        if (this.f44486c == null) {
            this.f44486c = new Paint();
        }
        this.f44486c.setAntiAlias(true);
        this.f44486c.setStyle(Paint.Style.STROKE);
        this.f44486c.setStrokeWidth(dVar.f44535c);
        this.f44486c.setStrokeCap(dVar.f44542j == 1 ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        this.f44486c.setColor(dVar.f44536d[0]);
        return this.f44486c;
    }

    public void draw(Canvas canvas) {
        if (isRunning()) {
            this.f44488e.mo111595a(canvas, this.f44486c);
        }
    }

    public void changeToSuccess(Bitmap bitmap) {
        C14476e eVar = this.f44488e;
        if (eVar != null) {
            eVar.mo111594a(bitmap);
        }
    }

    public void changeToLoading() {
        C14476e eVar = this.f44488e;
        if (eVar != null) {
            eVar.mo111592a();
        }
    }

    public void setAlpha(int i) {
        this.f44486c.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f44486c.setColorFilter(colorFilter);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        float f = this.f44485b.f44535c;
        this.f44484a.left = ((float) rect.left) + f;
        this.f44484a.right = ((float) rect.right) - f;
        this.f44484a.top = ((float) rect.top) + f;
        this.f44484a.bottom = ((float) rect.bottom) - f;
    }

    public void start() {
        m31595a();
        this.f44488e.mo111597b();
        this.f44487d = true;
        invalidateSelf();
    }

    /* renamed from: a */
    private void m31595a() {
        if (this.f44488e == null) {
            this.f44488e = new C14472a(this.f44489f, this, this.f44485b);
        }
    }

    public void stop() {
        this.f44487d = false;
        this.f44488e.mo111599c();
        invalidateSelf();
    }

    public void invalidate() {
        if (getCallback() == null) {
            stop();
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            invalidateSelf();
        } else {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    CircularProgressDrawable.this.invalidateSelf();
                }
            });
        }
    }

    public boolean isRunning() {
        return this.f44487d;
    }

    public Paint getCurrentPaint() {
        return this.f44486c;
    }

    public RectF getDrawableBounds() {
        return this.f44484a;
    }

    public void progressiveStop(OnEndListener onEndListener) {
        this.f44488e.mo111596a(onEndListener);
    }

    public void progressiveStop() {
        progressiveStop((OnEndListener) null);
    }

    public static class Builder {
        private static final Interpolator DEFAULT_ROTATION_INTERPOLATOR = new LinearInterpolator();
        private static final Interpolator DEFAULT_SWEEP_INTERPOLATOR = new C14473b();
        private int bgColor;
        private Interpolator mAngleInterpolator;
        private float mBorderWidth;
        private int[] mColors;
        private Context mContext;
        private int mMaxSweepAngle;
        private int mMinSweepAngle;
        private PowerManager mPowerManager;
        private float mRotationSpeed;
        int mStyle;
        private Interpolator mSweepInterpolator;
        private float mSweepSpeed;

        public Builder(Context context) {
            this(context, false);
        }

        public Builder(Context context, boolean z) {
            this.mSweepInterpolator = DEFAULT_SWEEP_INTERPOLATOR;
            this.mAngleInterpolator = DEFAULT_ROTATION_INTERPOLATOR;
            initValues(context, z);
        }

        private void initValues(Context context, boolean z) {
            this.mContext = context;
            this.mBorderWidth = context.getResources().getDimension(R.dimen.cpb_default_stroke_width);
            this.mSweepSpeed = 1.0f;
            this.mRotationSpeed = 1.0f;
            if (z) {
                this.mColors = new int[]{-16776961};
                this.mMinSweepAngle = 20;
                this.mMaxSweepAngle = 300;
            } else {
                this.mColors = new int[]{context.getResources().getColor(R.color.cpb_default_color)};
                this.mMinSweepAngle = context.getResources().getInteger(R.integer.cpb_default_min_sweep_angle);
                this.mMaxSweepAngle = context.getResources().getInteger(R.integer.cpb_default_max_sweep_angle);
            }
            this.mStyle = 1;
            this.mPowerManager = C14478g.m31646a(context);
        }

        public Builder color(int i) {
            this.mColors = new int[]{i};
            return this;
        }

        public Builder colors(int[] iArr) {
            C14478g.m31652a(iArr);
            this.mColors = iArr;
            return this;
        }

        public Builder backGroundColor(int i) {
            this.bgColor = i;
            return this;
        }

        public Builder sweepSpeed(float f) {
            C14478g.m31647a(f);
            this.mSweepSpeed = f;
            return this;
        }

        public Builder rotationSpeed(float f) {
            C14478g.m31647a(f);
            this.mRotationSpeed = f;
            return this;
        }

        public Builder minSweepAngle(int i) {
            C14478g.m31649a(i);
            this.mMinSweepAngle = i;
            return this;
        }

        public Builder maxSweepAngle(int i) {
            C14478g.m31649a(i);
            this.mMaxSweepAngle = i;
            return this;
        }

        public Builder strokeWidth(float f) {
            C14478g.m31648a(f, "StrokeWidth");
            this.mBorderWidth = f;
            return this;
        }

        public Builder style(int i) {
            this.mStyle = i;
            return this;
        }

        public Builder sweepInterpolator(Interpolator interpolator) {
            C14478g.m31651a((Object) interpolator, "Sweep interpolator");
            this.mSweepInterpolator = interpolator;
            return this;
        }

        public Builder angleInterpolator(Interpolator interpolator) {
            C14478g.m31651a((Object) interpolator, "Angle interpolator");
            this.mAngleInterpolator = interpolator;
            return this;
        }

        public CircularProgressDrawable build() {
            return new CircularProgressDrawable(this.mContext, this.mPowerManager, new C14475d(this.mAngleInterpolator, this.mSweepInterpolator, this.mBorderWidth, this.mColors, this.mSweepSpeed, this.mRotationSpeed, this.mMinSweepAngle, this.mMaxSweepAngle, this.mStyle, this.bgColor));
        }
    }
}
