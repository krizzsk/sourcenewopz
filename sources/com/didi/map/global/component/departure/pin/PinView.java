package com.didi.map.global.component.departure.pin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.graphics.ColorUtils;
import com.didi.common.map.util.DisplayUtils;
import com.didi.passenger.C10448R;
import com.didiglobal.font.DIDIFontUtils;
import com.taxis99.R;
import java.util.ArrayList;

public class PinView extends View {
    public static final int ANIM_DURATION_MILLIS = 400;
    public static int DEFAULT_BIG_CIRCLE_ANGLE_PX = 0;
    public static int DEFAULT_BIG_CIRCLE_HEIGHT_PX = 0;
    public static final int DEFAULT_COLOR = Color.parseColor("#00ccaa");
    public static int DEFAULT_TEXT_SIZE_SP = 0;
    public static int DRAGGING_BIG_CIRCLE_RADIUS_PX = 0;

    /* renamed from: I */
    private static Paint f25255I = null;
    public static int LOADING_BIG_CIRCLE_WIDTH_PX = 0;
    public static final int NO_PARKING_COLOR = Color.parseColor("#fd4060");
    public static int TEXT_LEFT_RIGHT_PADDING_PX = 0;

    /* renamed from: a */
    private static final String f25256a = "PinView";

    /* renamed from: b */
    private static final int f25257b = 1;

    /* renamed from: c */
    private static final int f25258c = 2;

    /* renamed from: d */
    private static final int f25259d = 3;

    /* renamed from: e */
    private static final int f25260e = 4;

    /* renamed from: A */
    private int f25261A;

    /* renamed from: B */
    private int f25262B;

    /* renamed from: C */
    private int f25263C;

    /* renamed from: D */
    private int f25264D;

    /* renamed from: E */
    private int f25265E;

    /* renamed from: F */
    private AnimatorSet f25266F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f25267G;

    /* renamed from: H */
    private RectF f25268H;

    /* renamed from: f */
    private Paint f25269f;

    /* renamed from: g */
    private int f25270g;

    /* renamed from: h */
    private int f25271h;

    /* renamed from: i */
    private int f25272i;

    /* renamed from: j */
    private Paint f25273j;

    /* renamed from: k */
    private int f25274k;

    /* renamed from: l */
    private int f25275l;

    /* renamed from: m */
    private float f25276m;

    /* renamed from: n */
    private Paint f25277n;

    /* renamed from: o */
    private String f25278o;

    /* renamed from: p */
    private int f25279p;

    /* renamed from: q */
    private int f25280q;

    /* renamed from: r */
    private float f25281r;

    /* renamed from: s */
    private float f25282s;

    /* renamed from: t */
    private Paint f25283t;

    /* renamed from: u */
    private int f25284u;

    /* renamed from: v */
    private int f25285v;

    /* renamed from: w */
    private int f25286w;

    /* renamed from: x */
    private int f25287x;

    /* renamed from: y */
    private int f25288y;

    /* renamed from: z */
    private int f25289z;

    public int getNoParkingColor() {
        return this.f25265E;
    }

    public int getNormalColor() {
        return this.f25264D;
    }

    public PinView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f25269f = null;
        this.f25270g = 0;
        this.f25271h = 0;
        this.f25272i = 0;
        this.f25273j = null;
        this.f25274k = 0;
        this.f25275l = Color.parseColor("#ffffff");
        this.f25276m = 0.0f;
        this.f25277n = null;
        this.f25278o = "PICK-UP";
        this.f25279p = 12;
        this.f25280q = Color.parseColor("#ffffff");
        this.f25281r = 1.0f;
        this.f25282s = 1.0f;
        this.f25283t = null;
        this.f25284u = 0;
        this.f25285v = 0;
        this.f25286w = 3;
        this.f25287x = 400;
        this.f25288y = 0;
        this.f25289z = 0;
        int i2 = DEFAULT_COLOR;
        this.f25261A = i2;
        this.f25262B = i2;
        this.f25263C = i2;
        this.f25264D = i2;
        this.f25265E = NO_PARKING_COLOR;
        this.f25267G = false;
        this.f25268H = new RectF();
        m18089a(context, attributeSet);
    }

    /* renamed from: a */
    private void m18089a(Context context, AttributeSet attributeSet) {
        DEFAULT_TEXT_SIZE_SP = DisplayUtils.sp2px(context, 12.0f);
        TEXT_LEFT_RIGHT_PADDING_PX = DisplayUtils.dp2px(context, 14.0f) * 2;
        DRAGGING_BIG_CIRCLE_RADIUS_PX = DisplayUtils.dp2px(context, 15.0f);
        LOADING_BIG_CIRCLE_WIDTH_PX = DisplayUtils.dp2px(context, 60.0f);
        DEFAULT_BIG_CIRCLE_HEIGHT_PX = DisplayUtils.sp2px(context, 36.0f);
        DEFAULT_BIG_CIRCLE_ANGLE_PX = DisplayUtils.sp2px(context, 20.0f);
        m18095b(context, attributeSet);
        Paint paint = new Paint();
        this.f25269f = paint;
        paint.setAntiAlias(true);
        this.f25269f.setColor(this.f25261A);
        this.f25270g = getPinWidth();
        this.f25271h = DEFAULT_BIG_CIRCLE_HEIGHT_PX;
        this.f25272i = DEFAULT_BIG_CIRCLE_ANGLE_PX;
        Paint paint2 = new Paint();
        this.f25273j = paint2;
        paint2.setAntiAlias(true);
        this.f25273j.setColor(this.f25275l);
        Paint paint3 = new Paint();
        this.f25277n = paint3;
        paint3.setAntiAlias(true);
        this.f25277n.setColor(this.f25280q);
        this.f25277n.setTextAlign(Paint.Align.CENTER);
        int i = DEFAULT_TEXT_SIZE_SP;
        this.f25279p = i;
        this.f25277n.setTextSize((float) i);
        DIDIFontUtils.Companion.setPaintTypeface(context, this.f25277n, Typeface.DEFAULT_BOLD);
        Paint paint4 = new Paint();
        this.f25283t = paint4;
        paint4.setAntiAlias(true);
        this.f25283t.setColor(this.f25261A);
        this.f25284u = DisplayUtils.dp2px(context, 4.0f);
        this.f25285v = DisplayUtils.dp2px(context, 20.0f);
        if (context != null) {
            this.f25278o = context.getString(R.string.GRider_Homepage0714_Get_in_tpiW);
        }
    }

    /* renamed from: b */
    private void m18095b(Context context, AttributeSet attributeSet) {
        int dp2px = DisplayUtils.dp2px(context, 2.0f);
        if (context == null || attributeSet == null) {
            this.f25274k = dp2px;
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.departurePinView);
        this.f25274k = (int) obtainStyledAttributes.getDimension(0, (float) dp2px);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m18086a() {
        this.f25269f.setColor(this.f25261A);
        this.f25283t.setColor(this.f25261A);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f25288y = getPinWidth();
        int pinHeight = getPinHeight();
        this.f25289z = pinHeight;
        setMeasuredDimension(this.f25288y, pinHeight);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f25268H;
        int i = this.f25288y;
        int i2 = this.f25284u;
        int i3 = this.f25271h;
        rectF.set((((float) i) / 2.0f) - (((float) i2) / 2.0f), ((float) i3) / 2.0f, (((float) i) / 2.0f) + (((float) i2) / 2.0f), (float) (i3 + this.f25285v));
        RectF rectF2 = this.f25268H;
        int i4 = this.f25284u;
        canvas.drawRoundRect(rectF2, ((float) i4) / 2.0f, ((float) i4) / 2.0f, this.f25283t);
        RectF rectF3 = this.f25268H;
        int i5 = this.f25288y;
        int i6 = this.f25270g;
        rectF3.set((((float) i5) / 2.0f) - (((float) i6) / 2.0f), 0.0f, (((float) i5) / 2.0f) + (((float) i6) / 2.0f), (float) this.f25271h);
        RectF rectF4 = this.f25268H;
        int i7 = this.f25272i;
        canvas.drawRoundRect(rectF4, (float) i7, (float) i7, this.f25269f);
        this.f25273j.setAlpha((int) (this.f25276m * 255.0f));
        canvas.drawCircle(((float) this.f25288y) / 2.0f, ((float) this.f25271h) / 2.0f, (float) this.f25274k, this.f25273j);
        this.f25277n.setAlpha((int) (this.f25281r * 255.0f));
        this.f25277n.setTextSize(((float) this.f25279p) * this.f25282s);
        Paint.FontMetrics fontMetrics = this.f25277n.getFontMetrics();
        canvas.drawText(this.f25278o, ((float) this.f25288y) / 2.0f, (((float) this.f25271h) / 2.0f) + (((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom), this.f25277n);
    }

    public String getText() {
        return this.f25278o;
    }

    public boolean isNormal() {
        return this.f25286w == 1;
    }

    public boolean isDragging() {
        return this.f25286w == 2;
    }

    public boolean isLoading() {
        return this.f25286w == 3;
    }

    public boolean isCustom() {
        return this.f25286w == 4;
    }

    public void setPinColor(int i, int i2) {
        this.f25261A = i;
        this.f25262B = i;
        this.f25263C = i;
        this.f25264D = i;
        this.f25265E = i2;
        m18086a();
    }

    public void toNormal() {
        stopAnimation();
        ArrayList arrayList = new ArrayList();
        if (this.f25270g != getNormalWidth()) {
            arrayList.add(m18084a(this.f25270g, getNormalWidth()));
        }
        int i = this.f25271h;
        int i2 = DEFAULT_BIG_CIRCLE_HEIGHT_PX;
        if (i != i2) {
            arrayList.add(m18092b(i, i2));
        }
        int i3 = this.f25272i;
        int i4 = DEFAULT_BIG_CIRCLE_ANGLE_PX;
        if (i3 != i4) {
            arrayList.add(m18097c(i3, i4));
        }
        int i5 = this.f25261A;
        int i6 = this.f25263C;
        if (i5 != i6) {
            arrayList.add(m18100d(i5, i6));
        }
        if (isLoading()) {
            this.f25282s = 1.0f;
        } else if (isCustom()) {
            this.f25282s = 1.0f;
        }
        float f = this.f25281r;
        if (f < 1.0f) {
            arrayList.add(m18091b(f, 1.0f));
        }
        float f2 = this.f25282s;
        if (f2 < 1.0f) {
            arrayList.add(m18096c(f2, 1.0f));
        }
        float f3 = this.f25276m;
        if (f3 > 0.0f) {
            arrayList.add(m18083a(f3, 0.0f));
        }
        if (arrayList.size() != 0) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f25266F = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    boolean unused = PinView.this.f25267G = true;
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = PinView.this.f25267G = false;
                }
            });
            this.f25286w = 1;
            this.f25266F.setDuration(400);
            this.f25266F.playTogether(arrayList);
            this.f25266F.start();
        }
    }

    public void toDragging() {
        stopAnimation();
        ArrayList arrayList = new ArrayList();
        if (this.f25270g != getDraggingWidth()) {
            arrayList.add(m18084a(this.f25270g, getDraggingWidth()));
        }
        if (this.f25271h != getDraggingWidth()) {
            arrayList.add(m18092b(this.f25271h, getDraggingWidth()));
        }
        int i = this.f25272i;
        int i2 = DRAGGING_BIG_CIRCLE_RADIUS_PX;
        if (i != i2) {
            arrayList.add(m18097c(i, i2));
        }
        int i3 = this.f25261A;
        int i4 = this.f25263C;
        if (i3 != i4) {
            arrayList.add(m18100d(i3, i4));
        }
        float f = this.f25281r;
        if (f > 0.0f) {
            arrayList.add(m18091b(f, 0.0f));
        }
        float f2 = this.f25282s;
        if (f2 > 0.0f) {
            arrayList.add(m18096c(f2, 0.0f));
        }
        float f3 = this.f25276m;
        if (f3 < 1.0f) {
            arrayList.add(m18083a(f3, 1.0f));
        }
        if (arrayList.size() != 0) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f25266F = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    boolean unused = PinView.this.f25267G = true;
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = PinView.this.f25267G = false;
                }
            });
            this.f25286w = 2;
            this.f25266F.setDuration(400);
            this.f25266F.playTogether(arrayList);
            this.f25266F.start();
        }
    }

    public void toLoading() {
        stopAnimation();
        ArrayList arrayList = new ArrayList();
        if (this.f25270g != getLoadingWidth()) {
            arrayList.add(m18084a(this.f25270g, getLoadingWidth()));
        }
        int i = this.f25271h;
        int i2 = DEFAULT_BIG_CIRCLE_HEIGHT_PX;
        if (i != i2) {
            arrayList.add(m18092b(i, i2));
        }
        int i3 = this.f25272i;
        int i4 = DEFAULT_BIG_CIRCLE_ANGLE_PX;
        if (i3 != i4) {
            arrayList.add(m18097c(i3, i4));
        }
        int i5 = this.f25261A;
        int i6 = this.f25263C;
        if (i5 != i6) {
            arrayList.add(m18100d(i5, i6));
        }
        float f = this.f25281r;
        if (f > 0.0f) {
            arrayList.add(m18091b(f, 0.0f));
        }
        float f2 = this.f25282s;
        if (f2 > 0.0f) {
            arrayList.add(m18096c(f2, 0.0f));
        }
        float f3 = this.f25276m;
        if (f3 > 0.0f) {
            arrayList.add(m18083a(f3, 0.0f));
        }
        if (arrayList.size() != 0) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f25266F = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    boolean unused = PinView.this.f25267G = true;
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = PinView.this.f25267G = false;
                }
            });
            this.f25286w = 3;
            this.f25266F.setDuration(400);
            this.f25266F.playTogether(arrayList);
            this.f25266F.start();
        }
    }

    public void showText(String str) {
        this.f25278o = str;
        toNormal();
    }

    public void animSetBigCircleWidthHeightAngle(int i, int i2, int i3) {
        if (i != this.f25270g || i2 != this.f25271h || i3 != this.f25272i || this.f25261A != this.f25263C) {
            stopAnimation();
            ArrayList arrayList = new ArrayList();
            int i4 = this.f25270g;
            if (i != i4) {
                arrayList.add(m18084a(i4, i));
            }
            int i5 = this.f25271h;
            if (i2 != i5) {
                arrayList.add(m18092b(i5, i2));
            }
            int i6 = this.f25272i;
            if (i3 != i6) {
                arrayList.add(m18097c(i6, i3));
            }
            int i7 = this.f25262B;
            int i8 = this.f25263C;
            if (!(i7 == i8 || this.f25261A == i8)) {
                arrayList.add(m18100d(i7, i8));
            }
            float f = this.f25281r;
            if (f > 0.0f) {
                arrayList.add(m18091b(f, 0.0f));
            }
            float f2 = this.f25282s;
            if (f2 > 0.0f) {
                arrayList.add(m18096c(f2, 0.0f));
            }
            float f3 = this.f25276m;
            if (f3 > 0.0f) {
                arrayList.add(m18083a(f3, 0.0f));
            }
            if (arrayList.size() != 0) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f25266F = animatorSet;
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        boolean unused = PinView.this.f25267G = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        boolean unused = PinView.this.f25267G = false;
                    }
                });
                this.f25286w = 4;
                this.f25266F.setDuration(400);
                this.f25266F.playTogether(arrayList);
                this.f25266F.start();
            }
        }
    }

    public void stopAnimation() {
        this.f25267G = false;
        AnimatorSet animatorSet = this.f25266F;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f25266F = null;
        }
    }

    /* renamed from: a */
    private ValueAnimator m18084a(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m18103f(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m18103f(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f25270g = intValue;
        setPinWidthHeight(intValue, this.f25289z);
    }

    /* renamed from: b */
    private ValueAnimator m18092b(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m18102e(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m18102e(ValueAnimator valueAnimator) {
        this.f25271h = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        int pinHeight = getPinHeight();
        this.f25289z = pinHeight;
        setPinWidthHeight(this.f25270g, pinHeight);
    }

    /* renamed from: c */
    private ValueAnimator m18097c(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m18101d(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m18101d(ValueAnimator valueAnimator) {
        this.f25272i = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        invalidate();
    }

    /* renamed from: a */
    private ValueAnimator m18085a(boolean z) {
        return z ? m18083a(0.0f, 1.0f) : m18083a(1.0f, 0.0f);
    }

    /* renamed from: a */
    private ValueAnimator m18083a(float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m18099c(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m18099c(ValueAnimator valueAnimator) {
        this.f25276m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* renamed from: d */
    private ValueAnimator m18100d(int i, int i2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(i, i2) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m18087a(this.f$1, this.f$2, valueAnimator);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18087a(int i, int i2, ValueAnimator valueAnimator) {
        setPinColor(ColorUtils.blendARGB(i, i2, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
    }

    /* renamed from: b */
    private ValueAnimator m18093b(boolean z) {
        return z ? m18091b(0.0f, 1.0f) : m18091b(1.0f, 0.0f);
    }

    /* renamed from: b */
    private ValueAnimator m18091b(float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m18094b(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m18094b(ValueAnimator valueAnimator) {
        this.f25281r = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* renamed from: c */
    private ValueAnimator m18098c(boolean z) {
        return z ? m18096c(0.0f, 1.0f) : m18096c(1.0f, 0.0f);
    }

    /* renamed from: c */
    private ValueAnimator m18096c(float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m18088a(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18088a(ValueAnimator valueAnimator) {
        this.f25282s = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    public void setPinStartEndColor(int i, int i2) {
        this.f25262B = i;
        this.f25263C = i2;
    }

    public void setPinColor(int i) {
        this.f25261A = i;
        this.f25269f.setColor(i);
        this.f25283t.setColor(i);
        invalidate();
    }

    public void setPinWidthHeight(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        setLayoutParams(layoutParams);
    }

    public int getPinWidth() {
        if (this.f25267G) {
            return this.f25270g;
        }
        if (isNormal()) {
            return getNormalWidth();
        }
        if (isDragging()) {
            return getDraggingWidth();
        }
        if (isLoading()) {
            return getLoadingWidth();
        }
        return this.f25270g;
    }

    public int getPinHeight() {
        return this.f25271h + this.f25285v;
    }

    public int getNormalWidth() {
        return TEXT_LEFT_RIGHT_PADDING_PX + getTextWidth(this.f25278o);
    }

    public int getNormalHeight() {
        return DEFAULT_BIG_CIRCLE_HEIGHT_PX;
    }

    public int getDraggingWidth() {
        return DRAGGING_BIG_CIRCLE_RADIUS_PX * 2;
    }

    public int getDraggingHeight() {
        return DRAGGING_BIG_CIRCLE_RADIUS_PX * 2;
    }

    public int getLoadingWidth() {
        return LOADING_BIG_CIRCLE_WIDTH_PX;
    }

    public int getLoadingHeight() {
        return DEFAULT_BIG_CIRCLE_HEIGHT_PX;
    }

    public int getBigCircleWidth() {
        return this.f25270g;
    }

    public int getBigCircleHeight() {
        return this.f25271h;
    }

    public static int getTextWidth(String str) {
        if (f25255I == null) {
            Paint paint = new Paint();
            f25255I = paint;
            paint.setAntiAlias(true);
            f25255I.setTextAlign(Paint.Align.CENTER);
            f25255I.setTextSize((float) DEFAULT_TEXT_SIZE_SP);
            f25255I.setTypeface(Typeface.DEFAULT_BOLD);
        }
        Paint paint2 = f25255I;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return (int) paint2.measureText(str);
    }
}
