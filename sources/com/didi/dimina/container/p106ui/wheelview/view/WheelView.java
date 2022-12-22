package com.didi.dimina.container.p106ui.wheelview.view;

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
import com.didi.dimina.container.p106ui.wheelview.adapter.WheelAdapter;
import com.didi.dimina.container.p106ui.wheelview.interfaces.IPickerViewData;
import com.didi.dimina.container.p106ui.wheelview.listener.LoopViewGestureListener;
import com.didi.dimina.container.p106ui.wheelview.listener.OnItemSelectedListener;
import com.didi.dimina.container.p106ui.wheelview.timer.InertiaTimerTask;
import com.didi.dimina.container.p106ui.wheelview.timer.MessageHandler;
import com.didi.dimina.container.p106ui.wheelview.timer.SmoothScrollTimerTask;
import com.didi.dimina.container.util.LogUtil;
import com.didi.passenger.C10448R;
import com.taxis99.R;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.didi.dimina.container.ui.wheelview.view.WheelView */
public class WheelView extends View {

    /* renamed from: P */
    private static final int f17881P = 5;

    /* renamed from: U */
    private static final float f17882U = 0.8f;

    /* renamed from: a */
    private static final String[] f17883a = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09"};

    /* renamed from: A */
    private boolean f17884A;

    /* renamed from: B */
    private float f17885B;

    /* renamed from: C */
    private float f17886C;

    /* renamed from: D */
    private float f17887D;

    /* renamed from: E */
    private float f17888E;

    /* renamed from: F */
    private int f17889F;

    /* renamed from: G */
    private int f17890G;

    /* renamed from: H */
    private int f17891H;

    /* renamed from: I */
    private int f17892I;

    /* renamed from: J */
    private int f17893J;

    /* renamed from: K */
    private int f17894K;

    /* renamed from: L */
    private int f17895L;

    /* renamed from: M */
    private int f17896M;

    /* renamed from: N */
    private float f17897N;

    /* renamed from: O */
    private long f17898O;

    /* renamed from: Q */
    private int f17899Q;

    /* renamed from: R */
    private int f17900R;

    /* renamed from: S */
    private int f17901S;

    /* renamed from: T */
    private int f17902T;

    /* renamed from: V */
    private float f17903V;

    /* renamed from: W */
    private boolean f17904W;

    /* renamed from: b */
    private DividerType f17905b;

    /* renamed from: c */
    private Context f17906c;

    /* renamed from: d */
    private Handler f17907d;

    /* renamed from: e */
    private GestureDetector f17908e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public OnItemSelectedListener f17909f;

    /* renamed from: g */
    private boolean f17910g;

    /* renamed from: h */
    private boolean f17911h;

    /* renamed from: i */
    private final ScheduledExecutorService f17912i;

    /* renamed from: j */
    private ScheduledFuture<?> f17913j;

    /* renamed from: k */
    private Paint f17914k;

    /* renamed from: l */
    private Paint f17915l;

    /* renamed from: m */
    private Paint f17916m;

    /* renamed from: n */
    private WheelAdapter f17917n;

    /* renamed from: o */
    private String f17918o;

    /* renamed from: p */
    private int f17919p;

    /* renamed from: q */
    private int f17920q;

    /* renamed from: r */
    private int f17921r;

    /* renamed from: s */
    private int f17922s;

    /* renamed from: t */
    private float f17923t;

    /* renamed from: u */
    private Typeface f17924u;

    /* renamed from: v */
    private int f17925v;

    /* renamed from: w */
    private int f17926w;

    /* renamed from: x */
    private int f17927x;

    /* renamed from: y */
    private int f17928y;

    /* renamed from: z */
    private float f17929z;

    /* renamed from: com.didi.dimina.container.ui.wheelview.view.WheelView$ACTION */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    /* renamed from: com.didi.dimina.container.ui.wheelview.view.WheelView$DividerType */
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
        this.f17910g = false;
        this.f17911h = true;
        this.f17912i = Executors.newSingleThreadScheduledExecutor();
        this.f17924u = Typeface.MONOSPACE;
        this.f17929z = 1.6f;
        this.f17892I = 11;
        this.f17896M = 0;
        this.f17897N = 0.0f;
        this.f17898O = 0;
        this.f17900R = 17;
        this.f17901S = 0;
        this.f17902T = 0;
        this.f17904W = false;
        this.f17919p = getResources().getDimensionPixelSize(R.dimen.dimina_pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.f17903V = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.f17903V = 4.0f;
        } else if (2.0f <= f && f < 3.0f) {
            this.f17903V = 6.0f;
        } else if (f >= 3.0f) {
            this.f17903V = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.dimina_pickerview, 0, 0);
            this.f17900R = obtainStyledAttributes.getInt(0, 17);
            this.f17925v = obtainStyledAttributes.getColor(5, -5723992);
            this.f17926w = obtainStyledAttributes.getColor(4, -14013910);
            this.f17927x = obtainStyledAttributes.getColor(1, -2763307);
            this.f17928y = obtainStyledAttributes.getDimensionPixelSize(2, 2);
            this.f17919p = obtainStyledAttributes.getDimensionPixelOffset(6, this.f17919p);
            this.f17929z = obtainStyledAttributes.getFloat(3, this.f17929z);
            obtainStyledAttributes.recycle();
        }
        m13375a();
        m13377a(context);
    }

    /* renamed from: a */
    private void m13375a() {
        float f = this.f17929z;
        if (f < 1.0f) {
            this.f17929z = 1.0f;
        } else if (f > 4.0f) {
            this.f17929z = 4.0f;
        }
    }

    /* renamed from: a */
    private void m13377a(Context context) {
        this.f17906c = context;
        this.f17907d = new MessageHandler(this);
        GestureDetector gestureDetector = new GestureDetector(context, new LoopViewGestureListener(this));
        this.f17908e = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f17884A = true;
        this.f17888E = 0.0f;
        this.f17889F = -1;
        m13380b();
    }

    /* renamed from: b */
    private void m13380b() {
        Paint paint = new Paint();
        this.f17914k = paint;
        paint.setColor(this.f17925v);
        this.f17914k.setAntiAlias(true);
        this.f17914k.setTypeface(this.f17924u);
        this.f17914k.setTextSize((float) this.f17919p);
        Paint paint2 = new Paint();
        this.f17915l = paint2;
        paint2.setColor(this.f17926w);
        this.f17915l.setAntiAlias(true);
        this.f17915l.setTextScaleX(1.1f);
        this.f17915l.setTypeface(this.f17924u);
        this.f17915l.setTextSize((float) this.f17919p);
        Paint paint3 = new Paint();
        this.f17916m = paint3;
        paint3.setColor(this.f17927x);
        this.f17916m.setAntiAlias(true);
        setLayerType(1, (Paint) null);
    }

    /* renamed from: c */
    private void m13382c() {
        if (this.f17917n != null) {
            m13384d();
            int i = (int) (this.f17923t * ((float) (this.f17892I - 1)));
            this.f17893J = (int) (((double) (i * 2)) / 3.141592653589793d);
            this.f17895L = (int) (((double) i) / 3.141592653589793d);
            this.f17894K = View.MeasureSpec.getSize(this.f17899Q);
            int i2 = this.f17893J;
            float f = this.f17923t;
            this.f17885B = (((float) i2) - f) / 2.0f;
            float f2 = (((float) i2) + f) / 2.0f;
            this.f17886C = f2;
            this.f17887D = (f2 - ((f - ((float) this.f17921r)) / 2.0f)) - this.f17903V;
            if (this.f17889F == -1) {
                if (this.f17884A) {
                    this.f17889F = (this.f17917n.getItemsCount() + 1) / 2;
                } else {
                    this.f17889F = 0;
                }
            }
            this.f17891H = this.f17889F;
        }
    }

    /* renamed from: d */
    private void m13384d() {
        Rect rect = new Rect();
        for (int i = 0; i < this.f17917n.getItemsCount(); i++) {
            String a = m13374a(this.f17917n.getItem(i));
            this.f17915l.getTextBounds(a, 0, a.length(), rect);
            int width = rect.width();
            if (width > this.f17920q) {
                this.f17920q = width;
            }
        }
        this.f17915l.getTextBounds("星期", 0, 2, rect);
        int height = rect.height() + 2;
        this.f17921r = height;
        this.f17923t = this.f17929z * ((float) height);
    }

    public void smoothScroll(ACTION action) {
        cancelFuture();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f = this.f17888E;
            float f2 = this.f17923t;
            int i = (int) (((f % f2) + f2) % f2);
            this.f17896M = i;
            if (((float) i) > f2 / 2.0f) {
                this.f17896M = (int) (f2 - ((float) i));
            } else {
                this.f17896M = -i;
            }
        }
        this.f17913j = this.f17912i.scheduleWithFixedDelay(new SmoothScrollTimerTask(this, this.f17896M), 0, 10, TimeUnit.MILLISECONDS);
    }

    public final void scrollBy(float f) {
        cancelFuture();
        this.f17913j = this.f17912i.scheduleWithFixedDelay(new InertiaTimerTask(this, f), 0, 5, TimeUnit.MILLISECONDS);
    }

    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture = this.f17913j;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f17913j.cancel(true);
            this.f17913j = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.f17884A = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.f17924u = typeface;
        this.f17914k.setTypeface(typeface);
        this.f17915l.setTypeface(this.f17924u);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            int i = (int) (this.f17906c.getResources().getDisplayMetrics().density * f);
            this.f17919p = i;
            this.f17914k.setTextSize((float) i);
            this.f17915l.setTextSize((float) this.f17919p);
        }
    }

    public final void setCurrentItem(int i) {
        this.f17890G = i;
        this.f17889F = i;
        this.f17888E = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.f17909f = onItemSelectedListener;
    }

    public final void setAdapter(WheelAdapter wheelAdapter) {
        this.f17917n = wheelAdapter;
        m13382c();
        invalidate();
    }

    public void setItemsVisibleCount(int i) {
        if (i % 2 == 0) {
            i++;
        }
        this.f17892I = i + 2;
    }

    public void setAlphaGradient(boolean z) {
        this.f17904W = z;
    }

    public final WheelAdapter getAdapter() {
        return this.f17917n;
    }

    public final int getCurrentItem() {
        int i;
        WheelAdapter wheelAdapter = this.f17917n;
        if (wheelAdapter == null) {
            return 0;
        }
        if (!this.f17884A || ((i = this.f17890G) >= 0 && i < wheelAdapter.getItemsCount())) {
            return Math.max(0, Math.min(this.f17890G, this.f17917n.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(Math.abs(Math.abs(this.f17890G) - this.f17917n.getItemsCount()), this.f17917n.getItemsCount() - 1));
    }

    public final void onItemSelected() {
        if (this.f17909f != null) {
            postDelayed(new Runnable() {
                public void run() {
                    WheelView.this.f17909f.onItemSelected(WheelView.this.getCurrentItem());
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
        if (this.f17917n != null) {
            int min = Math.min(Math.max(0, this.f17889F), this.f17917n.getItemsCount() - 1);
            this.f17889F = min;
            try {
                this.f17891H = min + (((int) (this.f17888E / this.f17923t)) % this.f17917n.getItemsCount());
            } catch (ArithmeticException unused) {
                LogUtil.m13410e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.f17884A) {
                if (this.f17891H < 0) {
                    this.f17891H = 0;
                }
                if (this.f17891H > this.f17917n.getItemsCount() - 1) {
                    this.f17891H = this.f17917n.getItemsCount() - 1;
                }
            } else {
                if (this.f17891H < 0) {
                    this.f17891H = this.f17917n.getItemsCount() + this.f17891H;
                }
                if (this.f17891H > this.f17917n.getItemsCount() - 1) {
                    this.f17891H -= this.f17917n.getItemsCount();
                }
            }
            float f3 = this.f17888E % this.f17923t;
            float f4 = 10.0f;
            if (this.f17905b == DividerType.WRAP) {
                if (TextUtils.isEmpty(this.f17918o)) {
                    i = (this.f17894K - this.f17920q) >> 1;
                } else {
                    i = (this.f17894K - this.f17920q) >> 2;
                }
                float f5 = (float) (i - 12);
                float f6 = f5 <= 0.0f ? 10.0f : f5;
                float f7 = ((float) this.f17894K) - f6;
                float f8 = this.f17885B;
                Canvas canvas3 = canvas;
                float f9 = f6;
                float f10 = f7;
                canvas3.drawLine(f9, f8, f10, f8, this.f17916m);
                float f11 = this.f17886C;
                canvas3.drawLine(f9, f11, f10, f11, this.f17916m);
            } else if (this.f17905b == DividerType.CIRCLE) {
                this.f17916m.setStyle(Paint.Style.STROKE);
                this.f17916m.setStrokeWidth((float) this.f17928y);
                if (TextUtils.isEmpty(this.f17918o)) {
                    f2 = ((float) (this.f17894K - this.f17920q)) / 2.0f;
                } else {
                    f2 = ((float) (this.f17894K - this.f17920q)) / 4.0f;
                }
                float f12 = f2 - 12.0f;
                if (f12 > 0.0f) {
                    f4 = f12;
                }
                canvas2.drawCircle(((float) this.f17894K) / 2.0f, ((float) this.f17893J) / 2.0f, Math.max((((float) this.f17894K) - f4) - f4, this.f17923t) / 1.8f, this.f17916m);
            } else {
                float f13 = this.f17885B;
                canvas.drawLine(0.0f, f13, (float) this.f17894K, f13, this.f17916m);
                float f14 = this.f17886C;
                canvas.drawLine(0.0f, f14, (float) this.f17894K, f14, this.f17916m);
            }
            if (!TextUtils.isEmpty(this.f17918o) && this.f17911h) {
                canvas2.drawText(this.f17918o, ((float) (this.f17894K - getTextWidth(this.f17915l, this.f17918o))) - this.f17903V, this.f17887D, this.f17915l);
            }
            int i2 = 0;
            while (true) {
                int i3 = this.f17892I;
                if (i2 < i3) {
                    int i4 = this.f17891H - ((i3 / 2) - i2);
                    Object obj = "";
                    if (this.f17884A) {
                        obj = this.f17917n.getItem(m13372a(i4));
                    } else if (i4 >= 0 && i4 <= this.f17917n.getItemsCount() - 1) {
                        obj = this.f17917n.getItem(i4);
                    }
                    canvas.save();
                    double d = (double) (((this.f17923t * ((float) i2)) - f3) / ((float) this.f17895L));
                    float f15 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                    if (f15 > 90.0f || f15 < -90.0f) {
                        f = f3;
                        canvas.restore();
                    } else {
                        if (this.f17911h || TextUtils.isEmpty(this.f17918o) || TextUtils.isEmpty(m13374a(obj))) {
                            str = m13374a(obj);
                        } else {
                            str = m13374a(obj) + this.f17918o;
                        }
                        float pow = (float) Math.pow((double) (Math.abs(f15) / 90.0f), 2.2d);
                        m13378a(str);
                        m13381b(str);
                        m13383c(str);
                        f = f3;
                        float cos = (float) ((((double) this.f17895L) - (Math.cos(d) * ((double) this.f17895L))) - ((Math.sin(d) * ((double) this.f17921r)) / 2.0d));
                        canvas2.translate(0.0f, cos);
                        float f16 = this.f17885B;
                        if (cos > f16 || ((float) this.f17921r) + cos < f16) {
                            float f17 = this.f17886C;
                            if (cos > f17 || ((float) this.f17921r) + cos < f17) {
                                if (cos >= this.f17885B) {
                                    int i5 = this.f17921r;
                                    if (((float) i5) + cos <= this.f17886C) {
                                        canvas2.drawText(str, (float) this.f17901S, ((float) i5) - this.f17903V, this.f17915l);
                                        this.f17890G = this.f17891H - ((this.f17892I / 2) - i2);
                                    }
                                }
                                canvas.save();
                                canvas2.clipRect(0, 0, this.f17894K, (int) this.f17923t);
                                canvas2.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                                m13376a(pow, f15);
                                canvas2.drawText(str, ((float) this.f17902T) + (((float) this.f17922s) * pow), (float) this.f17921r, this.f17914k);
                                canvas.restore();
                                canvas.restore();
                                this.f17915l.setTextSize((float) this.f17919p);
                            } else {
                                canvas.save();
                                canvas2.clipRect(0.0f, 0.0f, (float) this.f17894K, this.f17886C - cos);
                                canvas2.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                                canvas2.drawText(str, (float) this.f17901S, ((float) this.f17921r) - this.f17903V, this.f17915l);
                                canvas.restore();
                                canvas.save();
                                canvas2.clipRect(0.0f, this.f17886C - cos, (float) this.f17894K, (float) ((int) this.f17923t));
                                canvas2.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                                m13376a(pow, f15);
                                canvas2.drawText(str, (float) this.f17902T, (float) this.f17921r, this.f17914k);
                                canvas.restore();
                            }
                        } else {
                            canvas.save();
                            canvas2.clipRect(0.0f, 0.0f, (float) this.f17894K, this.f17885B - cos);
                            canvas2.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                            m13376a(pow, f15);
                            canvas2.drawText(str, (float) this.f17902T, (float) this.f17921r, this.f17914k);
                            canvas.restore();
                            canvas.save();
                            canvas2.clipRect(0.0f, this.f17885B - cos, (float) this.f17894K, (float) ((int) this.f17923t));
                            canvas2.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                            canvas2.drawText(str, (float) this.f17901S, ((float) this.f17921r) - this.f17903V, this.f17915l);
                            canvas.restore();
                        }
                        canvas.restore();
                        this.f17915l.setTextSize((float) this.f17919p);
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
    private void m13376a(float f, float f2) {
        int i = this.f17922s;
        int i2 = -1;
        int i3 = i > 0 ? 1 : i < 0 ? -1 : 0;
        Paint paint = this.f17914k;
        if (f2 <= 0.0f) {
            i2 = 1;
        }
        paint.setTextSkewX(((float) (i3 * i2)) * 0.5f * f);
        this.f17914k.setAlpha(this.f17904W ? (int) (((90.0f - Math.abs(f2)) / 90.0f) * 255.0f) : 255);
    }

    /* renamed from: a */
    private void m13378a(String str) {
        Rect rect = new Rect();
        this.f17915l.getTextBounds(str, 0, str.length(), rect);
        int i = this.f17919p;
        for (int width = rect.width(); width > this.f17894K; width = rect.width()) {
            i--;
            this.f17915l.setTextSize((float) i);
            this.f17915l.getTextBounds(str, 0, str.length(), rect);
        }
        this.f17914k.setTextSize((float) i);
    }

    /* renamed from: a */
    private int m13372a(int i) {
        if (i < 0) {
            return m13372a(i + this.f17917n.getItemsCount());
        }
        return i > this.f17917n.getItemsCount() + -1 ? m13372a(i - this.f17917n.getItemsCount()) : i;
    }

    /* renamed from: a */
    private String m13374a(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof IPickerViewData) {
            return ((IPickerViewData) obj).getPickerViewText();
        }
        if (obj instanceof Integer) {
            return m13379b(((Integer) obj).intValue());
        }
        return obj.toString();
    }

    /* renamed from: b */
    private String m13379b(int i) {
        return (i < 0 || i >= 10) ? String.valueOf(i) : f17883a[i];
    }

    /* renamed from: b */
    private void m13381b(String str) {
        String str2;
        Rect rect = new Rect();
        this.f17915l.getTextBounds(str, 0, str.length(), rect);
        int i = this.f17900R;
        if (i == 3) {
            this.f17901S = 0;
        } else if (i == 5) {
            this.f17901S = (this.f17894K - rect.width()) - ((int) this.f17903V);
        } else if (i == 17) {
            if (this.f17910g || (str2 = this.f17918o) == null || str2.equals("") || !this.f17911h) {
                this.f17901S = (int) (((double) (this.f17894K - rect.width())) * 0.5d);
            } else {
                this.f17901S = (int) (((double) (this.f17894K - rect.width())) * 0.25d);
            }
        }
    }

    /* renamed from: c */
    private void m13383c(String str) {
        String str2;
        Rect rect = new Rect();
        this.f17914k.getTextBounds(str, 0, str.length(), rect);
        int i = this.f17900R;
        if (i == 3) {
            this.f17902T = 0;
        } else if (i == 5) {
            this.f17902T = (this.f17894K - rect.width()) - ((int) this.f17903V);
        } else if (i == 17) {
            if (this.f17910g || (str2 = this.f17918o) == null || str2.equals("") || !this.f17911h) {
                this.f17902T = (int) (((double) (this.f17894K - rect.width())) * 0.5d);
            } else {
                this.f17902T = (int) (((double) (this.f17894K - rect.width())) * 0.25d);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f17899Q = i;
        m13382c();
        setMeasuredDimension(this.f17894K, this.f17893J);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.f17908e.onTouchEvent(motionEvent);
        float f = ((float) (-this.f17889F)) * this.f17923t;
        float itemsCount = ((float) ((this.f17917n.getItemsCount() - 1) - this.f17889F)) * this.f17923t;
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.f17898O = System.currentTimeMillis();
            cancelFuture();
            this.f17897N = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.f17897N - motionEvent.getRawY();
            this.f17897N = motionEvent.getRawY();
            float f2 = this.f17888E + rawY;
            this.f17888E = f2;
            if (!this.f17884A && ((f2 - (this.f17923t * 0.25f) < f && rawY < 0.0f) || (this.f17888E + (this.f17923t * 0.25f) > itemsCount && rawY > 0.0f))) {
                this.f17888E -= rawY;
                z = true;
            }
        } else if (!onTouchEvent) {
            float y = motionEvent.getY();
            int i = this.f17895L;
            float f3 = this.f17923t;
            this.f17896M = (int) ((((float) (((int) (((Math.acos((double) ((((float) i) - y) / ((float) i))) * ((double) this.f17895L)) + ((double) (f3 / 2.0f))) / ((double) f3))) - (this.f17892I / 2))) * f3) - (((this.f17888E % f3) + f3) % f3));
            if (System.currentTimeMillis() - this.f17898O > 120) {
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
        WheelAdapter wheelAdapter = this.f17917n;
        if (wheelAdapter != null) {
            return wheelAdapter.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.f17918o = str;
    }

    public void isCenterLabel(boolean z) {
        this.f17911h = z;
    }

    public void setGravity(int i) {
        this.f17900R = i;
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
        this.f17910g = z;
    }

    public void setTextColorOut(int i) {
        this.f17925v = i;
        this.f17914k.setColor(i);
    }

    public void setTextColorCenter(int i) {
        this.f17926w = i;
        this.f17915l.setColor(i);
    }

    public void setTextXOffset(int i) {
        this.f17922s = i;
        if (i != 0) {
            this.f17915l.setTextScaleX(1.0f);
        }
    }

    public void setDividerWidth(int i) {
        this.f17928y = i;
        this.f17916m.setStrokeWidth((float) i);
    }

    public void setDividerColor(int i) {
        this.f17927x = i;
        this.f17916m.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.f17905b = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.f17929z = f;
            m13375a();
        }
    }

    public boolean isLoop() {
        return this.f17884A;
    }

    public float getTotalScrollY() {
        return this.f17888E;
    }

    public void setTotalScrollY(float f) {
        this.f17888E = f;
    }

    public float getItemHeight() {
        return this.f17923t;
    }

    public int getInitPosition() {
        return this.f17889F;
    }

    public Handler getHandler() {
        return this.f17907d;
    }
}
