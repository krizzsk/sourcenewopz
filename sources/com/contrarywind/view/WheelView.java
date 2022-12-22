package com.contrarywind.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.contrarywind.adapter.WheelAdapter;
import com.contrarywind.interfaces.IPickerViewData;
import com.contrarywind.listener.LoopViewGestureListener;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.timer.InertiaTimerTask;
import com.contrarywind.timer.MessageHandler;
import com.contrarywind.timer.SmoothScrollTimerTask;
import com.didi.passenger.C10448R;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class WheelView extends View {

    /* renamed from: P */
    private static final int f3325P = 5;

    /* renamed from: U */
    private static final float f3326U = 0.8f;

    /* renamed from: a */
    private static final String[] f3327a = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09"};

    /* renamed from: A */
    private boolean f3328A;

    /* renamed from: B */
    private float f3329B;

    /* renamed from: C */
    private float f3330C;

    /* renamed from: D */
    private float f3331D;

    /* renamed from: E */
    private float f3332E;

    /* renamed from: F */
    private int f3333F;

    /* renamed from: G */
    private int f3334G;

    /* renamed from: H */
    private int f3335H;

    /* renamed from: I */
    private int f3336I;

    /* renamed from: J */
    private int f3337J;

    /* renamed from: K */
    private int f3338K;

    /* renamed from: L */
    private int f3339L;

    /* renamed from: M */
    private int f3340M;

    /* renamed from: N */
    private float f3341N;

    /* renamed from: O */
    private long f3342O;

    /* renamed from: Q */
    private int f3343Q;

    /* renamed from: R */
    private int f3344R;

    /* renamed from: S */
    private int f3345S;

    /* renamed from: T */
    private int f3346T;

    /* renamed from: V */
    private float f3347V;

    /* renamed from: W */
    private boolean f3348W;

    /* renamed from: b */
    private DividerType f3349b;

    /* renamed from: c */
    private Context f3350c;

    /* renamed from: d */
    private Handler f3351d;

    /* renamed from: e */
    private GestureDetector f3352e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public OnItemSelectedListener f3353f;

    /* renamed from: g */
    private boolean f3354g;

    /* renamed from: h */
    private boolean f3355h;

    /* renamed from: i */
    private ScheduledExecutorService f3356i;

    /* renamed from: j */
    private ScheduledFuture<?> f3357j;

    /* renamed from: k */
    private Paint f3358k;

    /* renamed from: l */
    private Paint f3359l;

    /* renamed from: m */
    private Paint f3360m;

    /* renamed from: n */
    private WheelAdapter f3361n;

    /* renamed from: o */
    private String f3362o;

    /* renamed from: p */
    private int f3363p;

    /* renamed from: q */
    private int f3364q;

    /* renamed from: r */
    private int f3365r;

    /* renamed from: s */
    private int f3366s;

    /* renamed from: t */
    private float f3367t;

    /* renamed from: u */
    private Typeface f3368u;

    /* renamed from: v */
    private int f3369v;

    /* renamed from: w */
    private int f3370w;

    /* renamed from: x */
    private int f3371x;

    /* renamed from: y */
    private int f3372y;

    /* renamed from: z */
    private float f3373z;

    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    public enum DividerType {
        FILL,
        WRAP,
        CIRCLE
    }

    public WheelView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3354g = false;
        this.f3355h = true;
        this.f3356i = Executors.newSingleThreadScheduledExecutor();
        this.f3368u = Typeface.MONOSPACE;
        this.f3373z = 1.6f;
        this.f3336I = 11;
        this.f3340M = 0;
        this.f3341N = 0.0f;
        this.f3342O = 0;
        this.f3344R = 17;
        this.f3345S = 0;
        this.f3346T = 0;
        this.f3348W = false;
        this.f3363p = getResources().getDimensionPixelSize(R.dimen.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.f3347V = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.f3347V = 4.0f;
        } else if (2.0f <= f && f < 3.0f) {
            this.f3347V = 6.0f;
        } else if (f >= 3.0f) {
            this.f3347V = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.pickerview, 0, 0);
            this.f3344R = obtainStyledAttributes.getInt(2, 17);
            this.f3369v = obtainStyledAttributes.getColor(5, -5723992);
            this.f3370w = obtainStyledAttributes.getColor(4, -14013910);
            this.f3371x = obtainStyledAttributes.getColor(0, -2763307);
            this.f3372y = obtainStyledAttributes.getDimensionPixelSize(1, 2);
            this.f3363p = obtainStyledAttributes.getDimensionPixelOffset(6, this.f3363p);
            this.f3373z = obtainStyledAttributes.getFloat(3, this.f3373z);
            obtainStyledAttributes.recycle();
        }
        m2262a();
        m2264a(context);
    }

    /* renamed from: a */
    private void m2262a() {
        float f = this.f3373z;
        if (f < 1.0f) {
            this.f3373z = 1.0f;
        } else if (f > 4.0f) {
            this.f3373z = 4.0f;
        }
    }

    /* renamed from: a */
    private void m2264a(Context context) {
        this.f3350c = context;
        this.f3351d = new MessageHandler(this);
        GestureDetector gestureDetector = new GestureDetector(context, new LoopViewGestureListener(this));
        this.f3352e = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f3328A = true;
        this.f3332E = 0.0f;
        this.f3333F = -1;
        m2267b();
    }

    /* renamed from: b */
    private void m2267b() {
        Paint paint = new Paint();
        this.f3358k = paint;
        paint.setColor(this.f3369v);
        this.f3358k.setAntiAlias(true);
        this.f3358k.setTypeface(this.f3368u);
        this.f3358k.setTextSize((float) this.f3363p);
        Paint paint2 = new Paint();
        this.f3359l = paint2;
        paint2.setColor(this.f3370w);
        this.f3359l.setAntiAlias(true);
        this.f3359l.setTextScaleX(1.1f);
        this.f3359l.setTypeface(this.f3368u);
        this.f3359l.setTextSize((float) this.f3363p);
        Paint paint3 = new Paint();
        this.f3360m = paint3;
        paint3.setColor(this.f3371x);
        this.f3360m.setAntiAlias(true);
        setLayerType(1, (Paint) null);
    }

    /* renamed from: c */
    private void m2269c() {
        if (this.f3361n != null) {
            m2271d();
            int i = (int) (this.f3367t * ((float) (this.f3336I - 1)));
            this.f3337J = (int) (((double) (i * 2)) / 3.141592653589793d);
            this.f3339L = (int) (((double) i) / 3.141592653589793d);
            this.f3338K = View.MeasureSpec.getSize(this.f3343Q);
            int i2 = this.f3337J;
            float f = this.f3367t;
            this.f3329B = (((float) i2) - f) / 2.0f;
            float f2 = (((float) i2) + f) / 2.0f;
            this.f3330C = f2;
            this.f3331D = (f2 - ((f - ((float) this.f3365r)) / 2.0f)) - this.f3347V;
            if (this.f3333F == -1) {
                if (this.f3328A) {
                    this.f3333F = (this.f3361n.getItemsCount() + 1) / 2;
                } else {
                    this.f3333F = 0;
                }
            }
            this.f3335H = this.f3333F;
        }
    }

    /* renamed from: d */
    private void m2271d() {
        Rect rect = new Rect();
        for (int i = 0; i < this.f3361n.getItemsCount(); i++) {
            String a = m2261a(this.f3361n.getItem(i));
            this.f3359l.getTextBounds(a, 0, a.length(), rect);
            int width = rect.width();
            if (width > this.f3364q) {
                this.f3364q = width;
            }
        }
        this.f3359l.getTextBounds("星期", 0, 2, rect);
        int height = rect.height() + 2;
        this.f3365r = height;
        this.f3367t = this.f3373z * ((float) height);
    }

    public void smoothScroll(ACTION action) {
        cancelFuture();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f = this.f3332E;
            float f2 = this.f3367t;
            int i = (int) (((f % f2) + f2) % f2);
            this.f3340M = i;
            if (((float) i) > f2 / 2.0f) {
                this.f3340M = (int) (f2 - ((float) i));
            } else {
                this.f3340M = -i;
            }
        }
        this.f3357j = this.f3356i.scheduleWithFixedDelay(new SmoothScrollTimerTask(this, this.f3340M), 0, 10, TimeUnit.MILLISECONDS);
    }

    public final void scrollBy(float f) {
        cancelFuture();
        this.f3357j = this.f3356i.scheduleWithFixedDelay(new InertiaTimerTask(this, f), 0, 5, TimeUnit.MILLISECONDS);
    }

    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture = this.f3357j;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f3357j.cancel(true);
            this.f3357j = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.f3328A = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.f3368u = typeface;
        this.f3358k.setTypeface(typeface);
        this.f3359l.setTypeface(this.f3368u);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            int i = (int) (this.f3350c.getResources().getDisplayMetrics().density * f);
            this.f3363p = i;
            this.f3358k.setTextSize((float) i);
            this.f3359l.setTextSize((float) this.f3363p);
        }
    }

    public final void setCurrentItem(int i) {
        this.f3334G = i;
        this.f3333F = i;
        this.f3332E = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.f3353f = onItemSelectedListener;
    }

    public final void setAdapter(WheelAdapter wheelAdapter) {
        this.f3361n = wheelAdapter;
        m2269c();
        invalidate();
    }

    public void setItemsVisibleCount(int i) {
        if (i % 2 == 0) {
            i++;
        }
        this.f3336I = i + 2;
    }

    public void setAlphaGradient(boolean z) {
        this.f3348W = z;
    }

    public final WheelAdapter getAdapter() {
        return this.f3361n;
    }

    public final int getCurrentItem() {
        int i;
        WheelAdapter wheelAdapter = this.f3361n;
        if (wheelAdapter == null) {
            return 0;
        }
        if (!this.f3328A || ((i = this.f3334G) >= 0 && i < wheelAdapter.getItemsCount())) {
            return Math.max(0, Math.min(this.f3334G, this.f3361n.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(Math.abs(Math.abs(this.f3334G) - this.f3361n.getItemsCount()), this.f3361n.getItemsCount() - 1));
    }

    public final void onItemSelected() {
        if (this.f3353f != null) {
            postDelayed(new Runnable() {
                public void run() {
                    WheelView.this.f3353f.onItemSelected(WheelView.this.getCurrentItem());
                }
            }, 200);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        String str;
        float f2;
        int i;
        Canvas canvas2 = canvas;
        if (this.f3361n != null) {
            int min = Math.min(Math.max(0, this.f3333F), this.f3361n.getItemsCount() - 1);
            this.f3333F = min;
            try {
                this.f3335H = min + (((int) (this.f3332E / this.f3367t)) % this.f3361n.getItemsCount());
            } catch (ArithmeticException unused) {
                SystemUtils.log(6, "WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配", (Throwable) null, "com.contrarywind.view.WheelView", 381);
            }
            if (!this.f3328A) {
                if (this.f3335H < 0) {
                    this.f3335H = 0;
                }
                if (this.f3335H > this.f3361n.getItemsCount() - 1) {
                    this.f3335H = this.f3361n.getItemsCount() - 1;
                }
            } else {
                if (this.f3335H < 0) {
                    this.f3335H = this.f3361n.getItemsCount() + this.f3335H;
                }
                if (this.f3335H > this.f3361n.getItemsCount() - 1) {
                    this.f3335H -= this.f3361n.getItemsCount();
                }
            }
            float f3 = this.f3332E % this.f3367t;
            float f4 = 10.0f;
            if (this.f3349b == DividerType.WRAP) {
                if (TextUtils.isEmpty(this.f3362o)) {
                    i = (this.f3338K - this.f3364q) / 2;
                } else {
                    i = (this.f3338K - this.f3364q) / 4;
                }
                float f5 = (float) (i - 12);
                float f6 = f5 <= 0.0f ? 10.0f : f5;
                float f7 = ((float) this.f3338K) - f6;
                float f8 = this.f3329B;
                Canvas canvas3 = canvas;
                float f9 = f6;
                float f10 = f7;
                canvas3.drawLine(f9, f8, f10, f8, this.f3360m);
                float f11 = this.f3330C;
                canvas3.drawLine(f9, f11, f10, f11, this.f3360m);
            } else if (this.f3349b == DividerType.CIRCLE) {
                this.f3360m.setStyle(Paint.Style.STROKE);
                this.f3360m.setStrokeWidth((float) this.f3372y);
                if (TextUtils.isEmpty(this.f3362o)) {
                    f2 = ((float) (this.f3338K - this.f3364q)) / 2.0f;
                } else {
                    f2 = ((float) (this.f3338K - this.f3364q)) / 4.0f;
                }
                float f12 = f2 - 12.0f;
                if (f12 > 0.0f) {
                    f4 = f12;
                }
                canvas2.drawCircle(((float) this.f3338K) / 2.0f, ((float) this.f3337J) / 2.0f, Math.max((((float) this.f3338K) - f4) - f4, this.f3367t) / 1.8f, this.f3360m);
            } else {
                float f13 = this.f3329B;
                canvas.drawLine(0.0f, f13, (float) this.f3338K, f13, this.f3360m);
                float f14 = this.f3330C;
                canvas.drawLine(0.0f, f14, (float) this.f3338K, f14, this.f3360m);
            }
            if (!TextUtils.isEmpty(this.f3362o) && this.f3355h) {
                canvas2.drawText(this.f3362o, ((float) (this.f3338K - getTextWidth(this.f3359l, this.f3362o))) - this.f3347V, this.f3331D, this.f3359l);
            }
            int i2 = 0;
            while (true) {
                int i3 = this.f3336I;
                if (i2 < i3) {
                    int i4 = this.f3335H - ((i3 / 2) - i2);
                    Object obj = "";
                    if (this.f3328A) {
                        obj = this.f3361n.getItem(m2259a(i4));
                    } else if (i4 >= 0 && i4 <= this.f3361n.getItemsCount() - 1) {
                        obj = this.f3361n.getItem(i4);
                    }
                    canvas.save();
                    double d = (double) (((this.f3367t * ((float) i2)) - f3) / ((float) this.f3339L));
                    float f15 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                    if (f15 > 90.0f || f15 < -90.0f) {
                        f = f3;
                        canvas.restore();
                    } else {
                        if (this.f3355h || TextUtils.isEmpty(this.f3362o) || TextUtils.isEmpty(m2261a(obj))) {
                            str = m2261a(obj);
                        } else {
                            str = m2261a(obj) + this.f3362o;
                        }
                        float pow = (float) Math.pow((double) (Math.abs(f15) / 90.0f), 2.2d);
                        m2265a(str);
                        m2268b(str);
                        m2270c(str);
                        f = f3;
                        float cos = (float) ((((double) this.f3339L) - (Math.cos(d) * ((double) this.f3339L))) - ((Math.sin(d) * ((double) this.f3365r)) / 2.0d));
                        canvas2.translate(0.0f, cos);
                        float f16 = this.f3329B;
                        if (cos > f16 || ((float) this.f3365r) + cos < f16) {
                            float f17 = this.f3330C;
                            if (cos > f17 || ((float) this.f3365r) + cos < f17) {
                                if (cos >= this.f3329B) {
                                    int i5 = this.f3365r;
                                    if (((float) i5) + cos <= this.f3330C) {
                                        canvas2.drawText(str, (float) this.f3345S, ((float) i5) - this.f3347V, this.f3359l);
                                        this.f3334G = this.f3335H - ((this.f3336I / 2) - i2);
                                    }
                                }
                                canvas.save();
                                canvas2.clipRect(0, 0, this.f3338K, (int) this.f3367t);
                                canvas2.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                                m2263a(pow, f15);
                                canvas2.drawText(str, ((float) this.f3346T) + (((float) this.f3366s) * pow), (float) this.f3365r, this.f3358k);
                                canvas.restore();
                                canvas.restore();
                                this.f3359l.setTextSize((float) this.f3363p);
                            } else {
                                canvas.save();
                                canvas2.clipRect(0.0f, 0.0f, (float) this.f3338K, this.f3330C - cos);
                                canvas2.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                                canvas2.drawText(str, (float) this.f3345S, ((float) this.f3365r) - this.f3347V, this.f3359l);
                                canvas.restore();
                                canvas.save();
                                canvas2.clipRect(0.0f, this.f3330C - cos, (float) this.f3338K, (float) ((int) this.f3367t));
                                canvas2.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                                m2263a(pow, f15);
                                canvas2.drawText(str, (float) this.f3346T, (float) this.f3365r, this.f3358k);
                                canvas.restore();
                            }
                        } else {
                            canvas.save();
                            canvas2.clipRect(0.0f, 0.0f, (float) this.f3338K, this.f3329B - cos);
                            canvas2.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                            m2263a(pow, f15);
                            canvas2.drawText(str, (float) this.f3346T, (float) this.f3365r, this.f3358k);
                            canvas.restore();
                            canvas.save();
                            canvas2.clipRect(0.0f, this.f3329B - cos, (float) this.f3338K, (float) ((int) this.f3367t));
                            canvas2.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                            canvas2.drawText(str, (float) this.f3345S, ((float) this.f3365r) - this.f3347V, this.f3359l);
                            canvas.restore();
                        }
                        canvas.restore();
                        this.f3359l.setTextSize((float) this.f3363p);
                    }
                    i2++;
                    f3 = f;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private void m2263a(float f, float f2) {
        int i = this.f3366s;
        int i2 = -1;
        int i3 = i > 0 ? 1 : i < 0 ? -1 : 0;
        Paint paint = this.f3358k;
        if (f2 <= 0.0f) {
            i2 = 1;
        }
        paint.setTextSkewX(((float) (i3 * i2)) * 0.5f * f);
        this.f3358k.setAlpha(this.f3348W ? (int) (((90.0f - Math.abs(f2)) / 90.0f) * 255.0f) : 255);
    }

    /* renamed from: a */
    private void m2265a(String str) {
        Rect rect = new Rect();
        this.f3359l.getTextBounds(str, 0, str.length(), rect);
        int i = this.f3363p;
        for (int width = rect.width(); width > this.f3338K; width = rect.width()) {
            i--;
            this.f3359l.setTextSize((float) i);
            this.f3359l.getTextBounds(str, 0, str.length(), rect);
        }
        this.f3358k.setTextSize((float) i);
    }

    /* renamed from: a */
    private int m2259a(int i) {
        if (i < 0) {
            return m2259a(i + this.f3361n.getItemsCount());
        }
        return i > this.f3361n.getItemsCount() + -1 ? m2259a(i - this.f3361n.getItemsCount()) : i;
    }

    /* renamed from: a */
    private String m2261a(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof IPickerViewData) {
            return ((IPickerViewData) obj).getPickerViewText();
        }
        if (obj instanceof Integer) {
            return m2266b(((Integer) obj).intValue());
        }
        return obj.toString();
    }

    /* renamed from: b */
    private String m2266b(int i) {
        return (i < 0 || i >= 10) ? String.valueOf(i) : f3327a[i];
    }

    /* renamed from: b */
    private void m2268b(String str) {
        String str2;
        Rect rect = new Rect();
        this.f3359l.getTextBounds(str, 0, str.length(), rect);
        int i = this.f3344R;
        if (i == 3) {
            this.f3345S = 0;
        } else if (i == 5) {
            this.f3345S = (this.f3338K - rect.width()) - ((int) this.f3347V);
        } else if (i == 17) {
            if (this.f3354g || (str2 = this.f3362o) == null || str2.equals("") || !this.f3355h) {
                this.f3345S = (int) (((double) (this.f3338K - rect.width())) * 0.5d);
            } else {
                this.f3345S = (int) (((double) (this.f3338K - rect.width())) * 0.25d);
            }
        }
    }

    /* renamed from: c */
    private void m2270c(String str) {
        String str2;
        Rect rect = new Rect();
        this.f3358k.getTextBounds(str, 0, str.length(), rect);
        int i = this.f3344R;
        if (i == 3) {
            this.f3346T = 0;
        } else if (i == 5) {
            this.f3346T = (this.f3338K - rect.width()) - ((int) this.f3347V);
        } else if (i == 17) {
            if (this.f3354g || (str2 = this.f3362o) == null || str2.equals("") || !this.f3355h) {
                this.f3346T = (int) (((double) (this.f3338K - rect.width())) * 0.5d);
            } else {
                this.f3346T = (int) (((double) (this.f3338K - rect.width())) * 0.25d);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f3343Q = i;
        m2269c();
        setMeasuredDimension(this.f3338K, this.f3337J);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.f3352e.onTouchEvent(motionEvent);
        float f = ((float) (-this.f3333F)) * this.f3367t;
        float itemsCount = ((float) ((this.f3361n.getItemsCount() - 1) - this.f3333F)) * this.f3367t;
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.f3342O = System.currentTimeMillis();
            cancelFuture();
            this.f3341N = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.f3341N - motionEvent.getRawY();
            this.f3341N = motionEvent.getRawY();
            float f2 = this.f3332E + rawY;
            this.f3332E = f2;
            if (!this.f3328A && ((f2 - (this.f3367t * 0.25f) < f && rawY < 0.0f) || (this.f3332E + (this.f3367t * 0.25f) > itemsCount && rawY > 0.0f))) {
                this.f3332E -= rawY;
                z = true;
            }
        } else if (!onTouchEvent) {
            float y = motionEvent.getY();
            int i = this.f3339L;
            float f3 = this.f3367t;
            this.f3340M = (int) ((((float) (((int) (((Math.acos((double) ((((float) i) - y) / ((float) i))) * ((double) this.f3339L)) + ((double) (f3 / 2.0f))) / ((double) f3))) - (this.f3336I / 2))) * f3) - (((this.f3332E % f3) + f3) % f3));
            if (System.currentTimeMillis() - this.f3342O > 120) {
                smoothScroll(ACTION.DAGGLE);
            } else {
                smoothScroll(ACTION.CLICK);
            }
        }
        if (!z && motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public int getItemsCount() {
        WheelAdapter wheelAdapter = this.f3361n;
        if (wheelAdapter != null) {
            return wheelAdapter.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.f3362o = str;
    }

    public void isCenterLabel(boolean z) {
        this.f3355h = z;
    }

    public void setGravity(int i) {
        this.f3344R = i;
    }

    public int getTextWidth(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        float[] fArr = new float[length];
        paint.getTextWidths(str, fArr);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += (int) Math.ceil((double) fArr[i2]);
        }
        return i;
    }

    public void setIsOptions(boolean z) {
        this.f3354g = z;
    }

    public void setTextColorOut(int i) {
        this.f3369v = i;
        this.f3358k.setColor(i);
    }

    public void setTextColorCenter(int i) {
        this.f3370w = i;
        this.f3359l.setColor(i);
    }

    public void setTextXOffset(int i) {
        this.f3366s = i;
        if (i != 0) {
            this.f3359l.setTextScaleX(1.0f);
        }
    }

    public void setDividerWidth(int i) {
        this.f3372y = i;
        this.f3360m.setStrokeWidth((float) i);
    }

    public void setDividerColor(int i) {
        this.f3371x = i;
        this.f3360m.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.f3349b = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.f3373z = f;
            m2262a();
        }
    }

    public boolean isLoop() {
        return this.f3328A;
    }

    public float getTotalScrollY() {
        return this.f3332E;
    }

    public void setTotalScrollY(float f) {
        this.f3332E = f;
    }

    public float getItemHeight() {
        return this.f3367t;
    }

    public int getInitPosition() {
        return this.f3333F;
    }

    public Handler getHandler() {
        return this.f3351d;
    }
}
