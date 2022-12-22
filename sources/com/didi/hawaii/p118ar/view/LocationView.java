package com.didi.hawaii.p118ar.view;

import android.animation.Animator;
import android.animation.FloatEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.didi.hawaii.p118ar.utils.DisplayUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.taxis99.R;

/* renamed from: com.didi.hawaii.ar.view.LocationView */
public class LocationView extends View {

    /* renamed from: a */
    Path f23417a;

    /* renamed from: b */
    float f23418b;

    /* renamed from: c */
    boolean f23419c = false;

    /* renamed from: d */
    private Paint f23420d = new Paint();

    /* renamed from: e */
    private Paint f23421e = new Paint();

    /* renamed from: f */
    private Paint f23422f = new Paint();

    /* renamed from: g */
    private ValueAnimator f23423g = null;

    /* renamed from: h */
    private double f23424h = Math.sin(0.5235987755982988d);

    /* renamed from: i */
    private double f23425i = Math.cos(0.5235987755982988d);

    /* renamed from: j */
    private double f23426j = Math.tan(1.0471975511965976d);
    /* access modifiers changed from: private */

    /* renamed from: k */
    public float f23427k;

    /* renamed from: l */
    private Path f23428l;

    /* renamed from: m */
    private int f23429m = 50;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public float f23430n = (-this.f23427k);

    /* renamed from: o */
    private int f23431o;

    /* renamed from: p */
    private int f23432p;

    /* renamed from: q */
    private int f23433q;

    /* renamed from: r */
    private int f23434r;

    /* renamed from: s */
    private float f23435s;

    /* renamed from: t */
    private boolean f23436t = false;

    /* renamed from: u */
    private Bitmap f23437u = null;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Handler f23438v = new Handler(Looper.getMainLooper());

    /* renamed from: w */
    private int f23439w = 35;

    public LocationView(Context context) {
        super(context);
        m16739a(context);
    }

    public LocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16739a(context);
    }

    public LocationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16739a(context);
    }

    public LocationView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m16739a(context);
    }

    /* renamed from: a */
    private void m16739a(Context context) {
        this.f23420d.setColor(-16776961);
        this.f23420d.setAntiAlias(true);
        this.f23420d.setStyle(Paint.Style.STROKE);
        this.f23420d.setStrokeWidth(8.0f);
        this.f23421e.setColor(getResources().getColor(R.color.line_center));
        this.f23421e.setAntiAlias(true);
        this.f23421e.setStyle(Paint.Style.STROKE);
        this.f23421e.setStrokeWidth(4.0f);
        this.f23422f.setAntiAlias(true);
        this.f23422f.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f23421e.setStrokeWidth(4.0f);
        this.f23431o = getScreenWidth();
        int screenHeight = getScreenHeight();
        this.f23432p = screenHeight;
        int i = this.f23431o / 2;
        this.f23433q = i;
        this.f23434r = screenHeight / 2;
        float f = (float) (i - 20);
        this.f23427k = f;
        this.f23418b = f;
        this.f23435s = f;
        TextView textView = new TextView(context);
        textView.setText(getResources().getString(R.string.location_success_toast));
        textView.setBackground(getResources().getDrawable(R.mipmap.alert_bg));
        textView.setDrawingCacheEnabled(true);
        textView.setGravity(17);
        textView.setTextSize(1, 14.0f);
        textView.setTextColor(Color.parseColor("#4BDAFF"));
        textView.setPadding(120, 0, 120, 0);
        textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        textView.layout(0, 0, textView.getMeasuredWidth(), textView.getMeasuredHeight());
        this.f23437u = Bitmap.createBitmap(textView.getDrawingCache());
        textView.destroyDrawingCache();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f23431o = View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        this.f23432p = size;
        int i3 = this.f23431o / 2;
        this.f23433q = i3;
        this.f23434r = size / 2;
        float f = (float) (i3 - 15);
        this.f23427k = f;
        this.f23418b = f;
        this.f23435s = f;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f23419c) {
            Paint paint = new Paint();
            Bitmap bitmap = this.f23437u;
            canvas.drawBitmap(bitmap, (float) ((this.f23431o / 2) - (bitmap.getWidth() / 2)), (float) (((this.f23432p / 2) - (this.f23437u.getHeight() / 2)) + this.f23439w), paint);
            return;
        }
        if (!this.f23436t) {
            canvas.translate((float) this.f23433q, (float) this.f23434r);
            canvas.drawColor(getResources().getColor(R.color.black_effective));
        } else {
            canvas.translate((float) this.f23433q, (float) (this.f23434r + this.f23439w));
        }
        canvas.save();
        m16740a(canvas);
        canvas.restore();
        canvas.save();
        this.f23420d.setStrokeWidth(6.0f);
        this.f23420d.setColor(getResources().getColor(R.color.waikuang));
        this.f23420d.setStyle(Paint.Style.STROKE);
        canvas.drawPath(this.f23417a, this.f23420d);
        if (!this.f23436t) {
            float f = this.f23427k;
            double d = this.f23425i;
            canvas.drawLine((float) (((double) (-f)) * d), 0.0f, (float) (((double) f) * d), 0.0f, this.f23421e);
        }
        canvas.restore();
    }

    /* renamed from: a */
    private void m16740a(Canvas canvas) {
        Path path = new Path();
        this.f23417a = path;
        path.moveTo(0.0f, this.f23418b);
        float f = this.f23418b;
        float f2 = this.f23427k;
        double d = this.f23424h;
        if (((double) f) < ((double) f2) * d) {
            this.f23417a.lineTo((float) (((double) f2) * this.f23425i), f);
            this.f23417a.lineTo((float) (((double) this.f23427k) * this.f23425i), -this.f23418b);
        } else {
            this.f23417a.lineTo((float) (((double) f2) * this.f23425i), (float) (((double) f2) * d));
            Path path2 = this.f23417a;
            float f3 = this.f23427k;
            path2.lineTo((float) (((double) f3) * this.f23425i), (float) (((double) (-f3)) * this.f23424h));
        }
        this.f23417a.lineTo(0.0f, -this.f23418b);
        float f4 = this.f23418b;
        float f5 = this.f23427k;
        double d2 = this.f23424h;
        if (((double) f4) < ((double) f5) * d2) {
            this.f23417a.lineTo((float) (((double) (-f5)) * this.f23425i), -f4);
            this.f23417a.lineTo((float) (((double) (-this.f23427k)) * this.f23425i), this.f23418b);
        } else {
            this.f23417a.lineTo((float) (((double) (-f5)) * this.f23425i), (float) (((double) (-f5)) * d2));
            Path path3 = this.f23417a;
            float f6 = this.f23427k;
            path3.lineTo((float) (((double) (-f6)) * this.f23425i), (float) (((double) f6) * this.f23424h));
        }
        this.f23417a.lineTo(0.0f, this.f23418b);
        if (!this.f23436t) {
            canvas.clipPath(this.f23417a);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            int argb = Color.argb(Math.round(153.0f), 75, 218, 255);
            int argb2 = Color.argb(Math.round(0.0f), 75, 218, 255);
            float f7 = this.f23430n;
            this.f23422f.setShader(new LinearGradient(f7 - this.f23427k, 0.0f, f7, 0.0f, argb2, argb, Shader.TileMode.CLAMP));
            float f8 = this.f23430n;
            float f9 = this.f23427k;
            canvas.drawRect(f8 - f9, f9, f8, -f9, this.f23422f);
            m16742b(canvas);
        }
    }

    /* renamed from: b */
    private void m16742b(Canvas canvas) {
        this.f23420d.setColor(getResources().getColor(R.color.gray_slate));
        this.f23420d.setStrokeWidth(4.0f);
        float f = this.f23427k;
        Rect rect = new Rect((int) (-f), (int) (-f), (int) f, (int) f);
        if (this.f23428l == null) {
            this.f23428l = new Path();
            float width = ((float) rect.width()) / (((float) this.f23429m) + 1.0E-5f);
            float height = ((float) rect.height()) / (((float) this.f23429m) + 1.0E-5f);
            for (int i = 0; i <= this.f23429m; i++) {
                float f2 = ((float) i) * width;
                this.f23428l.moveTo(((float) rect.left) + f2, (float) rect.top);
                this.f23428l.lineTo(((float) rect.left) + f2, (float) rect.bottom);
            }
            for (int i2 = 0; i2 <= this.f23429m; i2++) {
                float f3 = ((float) i2) * height;
                this.f23428l.moveTo((float) rect.left, ((float) rect.top) + f3);
                this.f23428l.lineTo((float) rect.right, ((float) rect.top) + f3);
            }
        }
        this.f23420d.setStrokeWidth(1.0f);
        this.f23420d.setStyle(Paint.Style.STROKE);
        canvas.drawPath(this.f23428l, this.f23420d);
    }

    public void startScan() {
        this.f23438v.removeCallbacksAndMessages((Object) null);
        this.f23419c = false;
        ValueAnimator valueAnimator = this.f23423g;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            this.f23423g.cancel();
        }
        this.f23436t = false;
        float f = this.f23435s;
        double d = this.f23425i;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) (((double) (-f)) * d), (float) (((double) f) * d)});
        this.f23423g = ofFloat;
        ofFloat.setDuration(Const.DELAY_TIME4LAST_GPS_TASK);
        this.f23423g.setRepeatCount(-1);
        this.f23423g.setRepeatMode(1);
        this.f23423g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = LocationView.this.f23430n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LocationView.this.invalidate();
            }
        });
        this.f23423g.start();
    }

    public void stopScan() {
        this.f23438v.removeCallbacksAndMessages((Object) null);
        ValueAnimator valueAnimator = this.f23423g;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            this.f23423g.cancel();
        }
    }

    public void exeDisAppearAnimator() {
        this.f23436t = true;
        float f = this.f23435s;
        int width = (this.f23437u.getWidth() / 2) - DisplayUtils.px2dip(getContext(), 30.0f);
        int height = (this.f23437u.getHeight() / 2) - DisplayUtils.px2dip(getContext(), 30.0f);
        float sqrt = (float) Math.sqrt((double) ((width * width) + (height * height)));
        PropertyValuesHolder ofObject = PropertyValuesHolder.ofObject("r", new FloatEvaluator(), new Object[]{Float.valueOf(f), Float.valueOf(sqrt)});
        PropertyValuesHolder ofObject2 = PropertyValuesHolder.ofObject("rAnimate", new FloatEvaluator(), new Object[]{Float.valueOf(f), Float.valueOf((float) height)});
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f23423g = valueAnimator;
        valueAnimator.setValues(new PropertyValuesHolder[]{ofObject, ofObject2});
        this.f23423g.setDuration(300);
        this.f23423g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = LocationView.this.f23427k = ((Float) valueAnimator.getAnimatedValue("r")).floatValue();
                LocationView.this.f23418b = ((Float) valueAnimator.getAnimatedValue("rAnimate")).floatValue();
                LocationView.this.invalidate();
            }
        });
        this.f23423g.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                LocationView.this.f23419c = true;
                LocationView.this.f23438v.postDelayed(new Runnable() {
                    public void run() {
                        LocationView.this.setVisibility(8);
                    }
                }, 2000);
            }
        });
        this.f23423g.start();
    }

    private int getScreenWidth() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private int getScreenHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }
}
