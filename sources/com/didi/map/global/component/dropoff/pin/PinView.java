package com.didi.map.global.component.dropoff.pin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
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
    private static Paint f25537I = null;
    public static int LOADING_BIG_CIRCLE_WIDTH_PX = 0;
    public static final int NO_PARKING_COLOR = Color.parseColor("#fd4060");
    public static int TEXT_LEFT_RIGHT_PADDING_PX = 0;

    /* renamed from: a */
    private static final String f25538a = "PinView";

    /* renamed from: b */
    private static final int f25539b = 1;

    /* renamed from: c */
    private static final int f25540c = 2;

    /* renamed from: d */
    private static final int f25541d = 3;

    /* renamed from: e */
    private static final int f25542e = 4;

    /* renamed from: A */
    private int f25543A;

    /* renamed from: B */
    private int f25544B;

    /* renamed from: C */
    private int f25545C;

    /* renamed from: D */
    private int f25546D;

    /* renamed from: E */
    private int f25547E;

    /* renamed from: F */
    private AnimatorSet f25548F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public boolean f25549G;

    /* renamed from: H */
    private RectF f25550H;

    /* renamed from: f */
    private Paint f25551f;

    /* renamed from: g */
    private int f25552g;

    /* renamed from: h */
    private int f25553h;

    /* renamed from: i */
    private int f25554i;

    /* renamed from: j */
    private Paint f25555j;

    /* renamed from: k */
    private int f25556k;

    /* renamed from: l */
    private int f25557l;

    /* renamed from: m */
    private float f25558m;

    /* renamed from: n */
    private Paint f25559n;

    /* renamed from: o */
    private String f25560o;

    /* renamed from: p */
    private int f25561p;

    /* renamed from: q */
    private int f25562q;

    /* renamed from: r */
    private float f25563r;

    /* renamed from: s */
    private float f25564s;

    /* renamed from: t */
    private Paint f25565t;

    /* renamed from: u */
    private int f25566u;

    /* renamed from: v */
    private int f25567v;

    /* renamed from: w */
    private int f25568w;

    /* renamed from: x */
    private int f25569x;

    /* renamed from: y */
    private int f25570y;

    /* renamed from: z */
    private int f25571z;

    public int getNoParkingColor() {
        return this.f25547E;
    }

    public int getNormalColor() {
        return this.f25546D;
    }

    public PinView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f25551f = null;
        this.f25552g = 0;
        this.f25553h = 0;
        this.f25554i = 0;
        this.f25555j = null;
        this.f25556k = 0;
        this.f25557l = Color.parseColor("#ffffff");
        this.f25558m = 0.0f;
        this.f25559n = null;
        this.f25560o = "PICK-UP";
        this.f25561p = 12;
        this.f25562q = Color.parseColor("#ffffff");
        this.f25563r = 1.0f;
        this.f25564s = 1.0f;
        this.f25565t = null;
        this.f25566u = 0;
        this.f25567v = 0;
        this.f25568w = 3;
        this.f25569x = 400;
        this.f25570y = 0;
        this.f25571z = 0;
        int i2 = DEFAULT_COLOR;
        this.f25543A = i2;
        this.f25544B = i2;
        this.f25545C = i2;
        this.f25546D = i2;
        this.f25547E = NO_PARKING_COLOR;
        this.f25549G = false;
        this.f25550H = new RectF();
        m18268a(context);
    }

    /* renamed from: a */
    private void m18268a(Context context) {
        DEFAULT_TEXT_SIZE_SP = DisplayUtils.sp2px(context, 12.0f);
        TEXT_LEFT_RIGHT_PADDING_PX = DisplayUtils.dp2px(context, 14.0f) * 2;
        DRAGGING_BIG_CIRCLE_RADIUS_PX = DisplayUtils.dp2px(context, 15.0f);
        LOADING_BIG_CIRCLE_WIDTH_PX = DisplayUtils.dp2px(context, 60.0f);
        DEFAULT_BIG_CIRCLE_HEIGHT_PX = DisplayUtils.sp2px(context, 36.0f);
        DEFAULT_BIG_CIRCLE_ANGLE_PX = DisplayUtils.sp2px(context, 20.0f);
        Paint paint = new Paint();
        this.f25551f = paint;
        paint.setAntiAlias(true);
        this.f25551f.setColor(this.f25543A);
        this.f25552g = getPinWidth();
        this.f25553h = DEFAULT_BIG_CIRCLE_HEIGHT_PX;
        this.f25554i = DEFAULT_BIG_CIRCLE_ANGLE_PX;
        Paint paint2 = new Paint();
        this.f25555j = paint2;
        paint2.setAntiAlias(true);
        this.f25555j.setColor(this.f25557l);
        this.f25556k = DisplayUtils.dp2px(context, 2.0f);
        Paint paint3 = new Paint();
        this.f25559n = paint3;
        paint3.setAntiAlias(true);
        this.f25559n.setColor(this.f25562q);
        this.f25559n.setTextAlign(Paint.Align.CENTER);
        int i = DEFAULT_TEXT_SIZE_SP;
        this.f25561p = i;
        this.f25559n.setTextSize((float) i);
        DIDIFontUtils.Companion.setPaintTypeface(context, this.f25559n, Typeface.DEFAULT_BOLD);
        Paint paint4 = new Paint();
        this.f25565t = paint4;
        paint4.setAntiAlias(true);
        this.f25565t.setColor(this.f25543A);
        this.f25566u = DisplayUtils.dp2px(context, 4.0f);
        this.f25567v = DisplayUtils.dp2px(context, 20.0f);
        if (context != null) {
            this.f25560o = context.getString(R.string.GRider_destination_Departure_point_lmkd);
        }
    }

    /* renamed from: a */
    private void m18265a() {
        this.f25551f.setColor(this.f25543A);
        this.f25565t.setColor(this.f25543A);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f25570y = getPinWidth();
        int pinHeight = getPinHeight();
        this.f25571z = pinHeight;
        setMeasuredDimension(this.f25570y, pinHeight);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f25550H;
        int i = this.f25570y;
        int i2 = this.f25566u;
        int i3 = this.f25553h;
        rectF.set((((float) i) / 2.0f) - (((float) i2) / 2.0f), ((float) i3) / 2.0f, (((float) i) / 2.0f) + (((float) i2) / 2.0f), (float) (i3 + this.f25567v));
        RectF rectF2 = this.f25550H;
        int i4 = this.f25566u;
        canvas.drawRoundRect(rectF2, ((float) i4) / 2.0f, ((float) i4) / 2.0f, this.f25565t);
        RectF rectF3 = this.f25550H;
        int i5 = this.f25570y;
        int i6 = this.f25552g;
        rectF3.set((((float) i5) / 2.0f) - (((float) i6) / 2.0f), 0.0f, (((float) i5) / 2.0f) + (((float) i6) / 2.0f), (float) this.f25553h);
        RectF rectF4 = this.f25550H;
        int i7 = this.f25554i;
        canvas.drawRoundRect(rectF4, (float) i7, (float) i7, this.f25551f);
        this.f25555j.setAlpha((int) (this.f25558m * 255.0f));
        canvas.drawCircle(((float) this.f25570y) / 2.0f, ((float) this.f25553h) / 2.0f, (float) this.f25556k, this.f25555j);
        this.f25559n.setAlpha((int) (this.f25563r * 255.0f));
        this.f25559n.setTextSize(((float) this.f25561p) * this.f25564s);
        Paint.FontMetrics fontMetrics = this.f25559n.getFontMetrics();
        canvas.drawText(this.f25560o, ((float) this.f25570y) / 2.0f, (((float) this.f25553h) / 2.0f) + (((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom), this.f25559n);
    }

    public String getText() {
        return this.f25560o;
    }

    public boolean isNormal() {
        return this.f25568w == 1;
    }

    public boolean isDragging() {
        return this.f25568w == 2;
    }

    public boolean isLoading() {
        return this.f25568w == 3;
    }

    public boolean isCustom() {
        return this.f25568w == 4;
    }

    public void setPinColor(int i, int i2) {
        this.f25543A = i;
        this.f25544B = i;
        this.f25545C = i;
        this.f25546D = i;
        this.f25547E = i2;
        m18265a();
    }

    public void toNormal() {
        stopAnimation();
        ArrayList arrayList = new ArrayList();
        if (this.f25552g != getNormalWidth()) {
            arrayList.add(m18263a(this.f25552g, getNormalWidth()));
        }
        int i = this.f25553h;
        int i2 = DEFAULT_BIG_CIRCLE_HEIGHT_PX;
        if (i != i2) {
            arrayList.add(m18271b(i, i2));
        }
        int i3 = this.f25554i;
        int i4 = DEFAULT_BIG_CIRCLE_ANGLE_PX;
        if (i3 != i4) {
            arrayList.add(m18275c(i3, i4));
        }
        int i5 = this.f25543A;
        int i6 = this.f25545C;
        if (i5 != i6) {
            arrayList.add(m18278d(i5, i6));
        }
        if (isLoading()) {
            this.f25564s = 1.0f;
        } else if (isCustom()) {
            this.f25564s = 1.0f;
        }
        float f = this.f25563r;
        if (f < 1.0f) {
            arrayList.add(m18270b(f, 1.0f));
        }
        float f2 = this.f25564s;
        if (f2 < 1.0f) {
            arrayList.add(m18274c(f2, 1.0f));
        }
        float f3 = this.f25558m;
        if (f3 > 0.0f) {
            arrayList.add(m18262a(f3, 0.0f));
        }
        if (arrayList.size() != 0) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f25548F = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    boolean unused = PinView.this.f25549G = true;
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = PinView.this.f25549G = false;
                }
            });
            this.f25568w = 1;
            this.f25548F.setDuration(400);
            this.f25548F.playTogether(arrayList);
            this.f25548F.start();
        }
    }

    public void toDragging() {
        stopAnimation();
        ArrayList arrayList = new ArrayList();
        if (this.f25552g != getDraggingWidth()) {
            arrayList.add(m18263a(this.f25552g, getDraggingWidth()));
        }
        if (this.f25553h != getDraggingWidth()) {
            arrayList.add(m18271b(this.f25553h, getDraggingWidth()));
        }
        int i = this.f25554i;
        int i2 = DRAGGING_BIG_CIRCLE_RADIUS_PX;
        if (i != i2) {
            arrayList.add(m18275c(i, i2));
        }
        int i3 = this.f25543A;
        int i4 = this.f25545C;
        if (i3 != i4) {
            arrayList.add(m18278d(i3, i4));
        }
        float f = this.f25563r;
        if (f > 0.0f) {
            arrayList.add(m18270b(f, 0.0f));
        }
        float f2 = this.f25564s;
        if (f2 > 0.0f) {
            arrayList.add(m18274c(f2, 0.0f));
        }
        float f3 = this.f25558m;
        if (f3 < 1.0f) {
            arrayList.add(m18262a(f3, 1.0f));
        }
        if (arrayList.size() != 0) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f25548F = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    boolean unused = PinView.this.f25549G = true;
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = PinView.this.f25549G = false;
                }
            });
            this.f25568w = 2;
            this.f25548F.setDuration(400);
            this.f25548F.playTogether(arrayList);
            this.f25548F.start();
        }
    }

    public void toLoading() {
        stopAnimation();
        ArrayList arrayList = new ArrayList();
        if (this.f25552g != getLoadingWidth()) {
            arrayList.add(m18263a(this.f25552g, getLoadingWidth()));
        }
        int i = this.f25553h;
        int i2 = DEFAULT_BIG_CIRCLE_HEIGHT_PX;
        if (i != i2) {
            arrayList.add(m18271b(i, i2));
        }
        int i3 = this.f25554i;
        int i4 = DEFAULT_BIG_CIRCLE_ANGLE_PX;
        if (i3 != i4) {
            arrayList.add(m18275c(i3, i4));
        }
        int i5 = this.f25543A;
        int i6 = this.f25545C;
        if (i5 != i6) {
            arrayList.add(m18278d(i5, i6));
        }
        float f = this.f25563r;
        if (f > 0.0f) {
            arrayList.add(m18270b(f, 0.0f));
        }
        float f2 = this.f25564s;
        if (f2 > 0.0f) {
            arrayList.add(m18274c(f2, 0.0f));
        }
        float f3 = this.f25558m;
        if (f3 > 0.0f) {
            arrayList.add(m18262a(f3, 0.0f));
        }
        if (arrayList.size() != 0) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f25548F = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    boolean unused = PinView.this.f25549G = true;
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = PinView.this.f25549G = false;
                }
            });
            this.f25568w = 3;
            this.f25548F.setDuration(400);
            this.f25548F.playTogether(arrayList);
            this.f25548F.start();
        }
    }

    public void showText(String str) {
        this.f25560o = str;
        toNormal();
    }

    public void animSetBigCircleWidthHeightAngle(int i, int i2, int i3) {
        if (i != this.f25552g || i2 != this.f25553h || i3 != this.f25554i || this.f25543A != this.f25545C) {
            stopAnimation();
            ArrayList arrayList = new ArrayList();
            int i4 = this.f25552g;
            if (i != i4) {
                arrayList.add(m18263a(i4, i));
            }
            int i5 = this.f25553h;
            if (i2 != i5) {
                arrayList.add(m18271b(i5, i2));
            }
            int i6 = this.f25554i;
            if (i3 != i6) {
                arrayList.add(m18275c(i6, i3));
            }
            int i7 = this.f25544B;
            int i8 = this.f25545C;
            if (!(i7 == i8 || this.f25543A == i8)) {
                arrayList.add(m18278d(i7, i8));
            }
            float f = this.f25563r;
            if (f > 0.0f) {
                arrayList.add(m18270b(f, 0.0f));
            }
            float f2 = this.f25564s;
            if (f2 > 0.0f) {
                arrayList.add(m18274c(f2, 0.0f));
            }
            float f3 = this.f25558m;
            if (f3 > 0.0f) {
                arrayList.add(m18262a(f3, 0.0f));
            }
            if (arrayList.size() != 0) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f25548F = animatorSet;
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        boolean unused = PinView.this.f25549G = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        boolean unused = PinView.this.f25549G = false;
                    }
                });
                this.f25568w = 4;
                this.f25548F.setDuration(400);
                this.f25548F.playTogether(arrayList);
                this.f25548F.start();
            }
        }
    }

    public void stopAnimation() {
        this.f25549G = false;
        AnimatorSet animatorSet = this.f25548F;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f25548F = null;
        }
    }

    /* renamed from: a */
    private ValueAnimator m18263a(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m18281f(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m18281f(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f25552g = intValue;
        setPinWidthHeight(intValue, this.f25571z);
    }

    /* renamed from: b */
    private ValueAnimator m18271b(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m18280e(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m18280e(ValueAnimator valueAnimator) {
        this.f25553h = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        int pinHeight = getPinHeight();
        this.f25571z = pinHeight;
        setPinWidthHeight(this.f25552g, pinHeight);
    }

    /* renamed from: c */
    private ValueAnimator m18275c(int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m18279d(valueAnimator);
            }
        });
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(400);
        return ofInt;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m18279d(ValueAnimator valueAnimator) {
        this.f25554i = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        invalidate();
    }

    /* renamed from: a */
    private ValueAnimator m18264a(boolean z) {
        return z ? m18262a(0.0f, 1.0f) : m18262a(1.0f, 0.0f);
    }

    /* renamed from: a */
    private ValueAnimator m18262a(float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m18277c(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m18277c(ValueAnimator valueAnimator) {
        this.f25558m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* renamed from: d */
    private ValueAnimator m18278d(int i, int i2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(i, i2) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m18266a(this.f$1, this.f$2, valueAnimator);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18266a(int i, int i2, ValueAnimator valueAnimator) {
        setPinColor(ColorUtils.blendARGB(i, i2, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
    }

    /* renamed from: b */
    private ValueAnimator m18272b(boolean z) {
        return z ? m18270b(0.0f, 1.0f) : m18270b(1.0f, 0.0f);
    }

    /* renamed from: b */
    private ValueAnimator m18270b(float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m18273b(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m18273b(ValueAnimator valueAnimator) {
        this.f25563r = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* renamed from: c */
    private ValueAnimator m18276c(boolean z) {
        return z ? m18274c(0.0f, 1.0f) : m18274c(1.0f, 0.0f);
    }

    /* renamed from: c */
    private ValueAnimator m18274c(float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PinView.this.m18267a(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(400);
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18267a(ValueAnimator valueAnimator) {
        this.f25564s = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    public void setPinStartEndColor(int i, int i2) {
        this.f25544B = i;
        this.f25545C = i2;
    }

    public void setPinColor(int i) {
        this.f25543A = i;
        this.f25551f.setColor(i);
        this.f25565t.setColor(i);
        invalidate();
    }

    public void setPinWidthHeight(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        setLayoutParams(layoutParams);
    }

    public int getPinWidth() {
        if (this.f25549G) {
            return this.f25552g;
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
        return this.f25552g;
    }

    public int getPinHeight() {
        return this.f25553h + this.f25567v;
    }

    public int getNormalWidth() {
        return TEXT_LEFT_RIGHT_PADDING_PX + getTextWidth(this.f25560o);
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
        return this.f25552g;
    }

    public int getBigCircleHeight() {
        return this.f25553h;
    }

    public static int getTextWidth(String str) {
        if (f25537I == null) {
            Paint paint = new Paint();
            f25537I = paint;
            paint.setAntiAlias(true);
            f25537I.setTextAlign(Paint.Align.CENTER);
            f25537I.setTextSize((float) DEFAULT_TEXT_SIZE_SP);
            f25537I.setTypeface(Typeface.DEFAULT_BOLD);
        }
        Paint paint2 = f25537I;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return (int) paint2.measureText(str);
    }
}
