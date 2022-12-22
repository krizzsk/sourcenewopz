package com.didi.safetoolkit.business.emergency.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.safetoolkit.util.SfUIThreadHelper;
import com.didi.safetoolkit.util.SfViewUtils;
import com.didichuxing.drtl.tookit.DRtlToolkit;
import com.didiglobal.font.DIDIFontUtils;
import com.taxis99.R;

public class SliderMoveView extends View {
    public static final int STATE_SLIDER_FREE = 3;
    public static final int STATE_SLIDER_IDLE = 0;
    public static final int STATE_SLIDER_LOCKED = 1;
    public static final int STATE_SLIDER_MOVE = 2;

    /* renamed from: a */
    private static final long f34372a = 500;

    /* renamed from: b */
    private static final int f34373b = 5;

    /* renamed from: c */
    private Paint f34374c = new Paint();

    /* renamed from: d */
    private int f34375d;

    /* renamed from: e */
    private Bitmap f34376e;

    /* renamed from: f */
    private float f34377f;

    /* renamed from: g */
    private float f34378g;

    /* renamed from: h */
    private int f34379h;

    /* renamed from: i */
    private GradientDrawable f34380i;

    /* renamed from: j */
    private Bitmap f34381j;

    /* renamed from: k */
    private float f34382k;

    /* renamed from: l */
    private int f34383l;

    /* renamed from: m */
    private int f34384m;

    /* renamed from: n */
    private int f34385n;

    /* renamed from: o */
    private Matrix f34386o = new Matrix();

    /* renamed from: p */
    private RectF f34387p = new RectF();

    /* renamed from: q */
    private Rect f34388q = new Rect();

    /* renamed from: r */
    private float f34389r = -1.0f;

    /* renamed from: s */
    private float f34390s = -1.0f;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public float f34391t = 0.0f;

    /* renamed from: u */
    private ValueAnimator f34392u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f34393v = 0;

    /* renamed from: w */
    private String f34394w;

    /* renamed from: x */
    private String f34395x;

    /* renamed from: y */
    private boolean f34396y = false;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public SlideButtonViewListener f34397z;

    public interface SlideButtonViewListener {
        void onSliderMove(float f, float f2);

        boolean onSliderStateChange(int i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public float m24309a(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    public SliderMoveView(Context context) {
        super(context);
        m24313a();
    }

    public SliderMoveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24313a();
    }

    public SliderMoveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24313a();
    }

    /* renamed from: a */
    private void m24313a() {
        this.f34396y = DRtlToolkit.rtl();
        this.f34374c.setTextSize((float) SfViewUtils.dp2px(getContext(), 20.0f));
        this.f34374c.setAntiAlias(true);
        this.f34375d = Color.parseColor(ColorUtils.DIDI_GREY);
        this.f34376e = ((BitmapDrawable) getResources().getDrawable(R.drawable.sf_ic_call_police_arrow)).getBitmap();
        this.f34377f = (float) SfViewUtils.dp2px(getContext(), 19.0f);
        this.f34378g = (float) SfViewUtils.dp2px(getContext(), 16.0f);
        this.f34379h = Color.parseColor("#000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f34380i = gradientDrawable;
        gradientDrawable.setShape(0);
        this.f34380i.setColor(Color.parseColor("#FA8988"));
        this.f34381j = ((BitmapDrawable) getResources().getDrawable(R.drawable.sf_ic_call_police_call)).getBitmap();
        this.f34382k = (float) SfViewUtils.dp2px(getContext(), 4.0f);
        this.f34383l = Color.parseColor("#FFFFFF");
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(500);
        this.f34392u = duration;
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    SliderMoveView sliderMoveView = SliderMoveView.this;
                    float unused = sliderMoveView.f34391t = sliderMoveView.m24309a(floatValue);
                    SliderMoveView.this.invalidate();
                }
            }
        });
        this.f34392u.addListener(new Animator.AnimatorListener() {
            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                float unused = SliderMoveView.this.f34391t = 0.0f;
                int unused2 = SliderMoveView.this.f34393v = 0;
                SliderMoveView.this.invalidate();
                if (SliderMoveView.this.f34397z != null) {
                    SliderMoveView.this.f34397z.onSliderStateChange(0);
                }
            }

            public void onAnimationCancel(Animator animator) {
                float unused = SliderMoveView.this.f34391t = 0.0f;
                int unused2 = SliderMoveView.this.f34393v = 0;
                SliderMoveView.this.invalidate();
                if (SliderMoveView.this.f34397z != null) {
                    SliderMoveView.this.f34397z.onSliderStateChange(0);
                }
            }
        });
    }

    public float getCurrentPercent() {
        return this.f34391t;
    }

    public void setForegroundText(String str) {
        if (str == null) {
            str = "";
        }
        this.f34395x = str;
        invalidate();
    }

    public void setBackgroundText(String str) {
        if (str == null) {
            str = "";
        }
        this.f34394w = str;
        invalidate();
    }

    public void setListener(SlideButtonViewListener slideButtonViewListener) {
        this.f34397z = slideButtonViewListener;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f34384m = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f34385n = measuredHeight;
        m24314a(canvas, this.f34384m, measuredHeight);
        m24319b(canvas, this.f34384m, this.f34385n);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = false;
        boolean z2 = true;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x = motionEvent.getX();
                    int i = this.f34393v;
                    if (i == 1 || i == 2) {
                        float f = this.f34396y ? this.f34389r - x : x - this.f34389r;
                        this.f34391t = m24309a(f / ((float) (this.f34384m - this.f34385n)));
                        int i2 = this.f34393v;
                        this.f34393v = 2;
                        invalidate();
                        SlideButtonViewListener slideButtonViewListener = this.f34397z;
                        if (slideButtonViewListener != null) {
                            if (i2 == 1) {
                                slideButtonViewListener.onSliderStateChange(2);
                            }
                            this.f34397z.onSliderMove(this.f34391t, f);
                        }
                    } else {
                        float f2 = this.f34389r;
                        if (f2 == -1.0f || this.f34390s == -1.0f) {
                            return false;
                        }
                        if (Math.abs(x - f2) > ((float) ViewConfiguration.get(getContext()).getScaledTouchSlop())) {
                            this.f34393v = 1;
                            invalidate();
                            SlideButtonViewListener slideButtonViewListener2 = this.f34397z;
                            if (slideButtonViewListener2 != null) {
                                slideButtonViewListener2.onSliderStateChange(1);
                            }
                        }
                    }
                } else if (action != 3) {
                    return false;
                }
            }
            if (this.f34389r == -1.0f || this.f34390s == -1.0f) {
                z2 = false;
            } else {
                this.f34389r = -1.0f;
                this.f34390s = -1.0f;
            }
            this.f34393v = 3;
            SlideButtonViewListener slideButtonViewListener3 = this.f34397z;
            if (slideButtonViewListener3 != null) {
                z = slideButtonViewListener3.onSliderStateChange(3);
            }
            if (z) {
                SfUIThreadHelper.postDelay(new Runnable() {
                    public void run() {
                        int unused = SliderMoveView.this.f34393v = 0;
                        float unused2 = SliderMoveView.this.f34391t = 0.0f;
                        SliderMoveView.this.invalidate();
                    }
                }, 500);
            } else {
                this.f34392u.setCurrentPlayTime((long) ((1.0f - this.f34391t) * 500.0f));
                this.f34392u.start();
            }
            return z2;
        }
        float x2 = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = this.f34388q;
        int i3 = (int) (this.f34396y ? ((float) (this.f34384m - this.f34385n)) + this.f34382k : this.f34382k);
        float f3 = this.f34382k;
        m24315a(rect, i3, (int) f3, (int) (((float) (this.f34396y ? this.f34384m : this.f34385n)) - f3), (int) (((float) this.f34385n) - this.f34382k));
        if (!m24317a(this.f34388q, (int) x2, (int) y)) {
            return false;
        }
        this.f34389r = x2;
        this.f34390s = y;
        return true;
    }

    /* renamed from: a */
    private void m24315a(Rect rect, int i, int i2, int i3, int i4) {
        if (rect != null) {
            rect.left = i;
            rect.top = i2;
            rect.right = i3;
            rect.bottom = i4;
        }
    }

    /* renamed from: a */
    private void m24316a(RectF rectF, float f, float f2, float f3, float f4) {
        if (rectF != null) {
            rectF.left = f;
            rectF.top = f2;
            rectF.right = f3;
            rectF.bottom = f4;
        }
    }

    /* renamed from: a */
    private void m24314a(Canvas canvas, int i, int i2) {
        float f;
        Canvas canvas2 = canvas;
        int i3 = i2;
        this.f34374c.setColor(this.f34375d);
        this.f34374c.setStyle(Paint.Style.FILL);
        DIDIFontUtils.Companion.setPaintTypeface(getContext(), this.f34374c);
        float f2 = (float) (((double) i3) / 2.0d);
        float f3 = f2 * 2.0f;
        float f4 = (float) i3;
        m24316a(this.f34387p, 0.0f, 0.0f, f3, f4);
        canvas.drawArc(this.f34387p, 270.0f, -180.0f, false, this.f34374c);
        float f5 = (float) i;
        canvas.drawRect(f2, 0.0f, f5 - f2, f4, this.f34374c);
        m24316a(this.f34387p, f5 - f3, 0.0f, f5, f4);
        canvas.drawArc(this.f34387p, 90.0f, -180.0f, false, this.f34374c);
        this.f34386o.reset();
        float width = this.f34377f / ((float) this.f34376e.getWidth());
        this.f34386o.postScale(this.f34396y ? -width : width, width, 0.5f, 0.5f);
        Matrix matrix = this.f34386o;
        if (this.f34396y) {
            f = this.f34378g + this.f34377f;
        } else {
            float f6 = this.f34378g;
            f = (f5 - f6) - f6;
        }
        matrix.postTranslate(f, (f4 - this.f34377f) / 2.0f);
        canvas.drawBitmap(this.f34376e, this.f34386o, this.f34374c);
        if (!TextUtils.isEmpty(this.f34394w)) {
            this.f34374c.setColor(this.f34379h);
            this.f34374c.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
            Paint paint = this.f34374c;
            String str = this.f34394w;
            paint.getTextBounds(str, 0, str.length(), this.f34388q);
            canvas.drawText(this.f34394w, (f5 - ((float) this.f34388q.width())) / 2.0f, ((f4 + ((float) this.f34388q.height())) / 2.0f) - 5.0f, this.f34374c);
        }
    }

    /* renamed from: b */
    private void m24319b(Canvas canvas, int i, int i2) {
        if (this.f34393v != 0) {
            this.f34380i.setCornerRadius((float) (((double) i2) / 2.0d));
            this.f34380i.setBounds(this.f34396y ? (int) ((((float) i) - (((float) (i - i2)) * this.f34391t)) - ((float) i2)) : 0, 0, this.f34396y ? i : (int) ((((float) (i - i2)) * this.f34391t) + ((float) i2)), i2);
            this.f34380i.draw(canvas);
            if (!TextUtils.isEmpty(this.f34395x)) {
                this.f34374c.setColor(this.f34383l);
                this.f34374c.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                Paint paint = this.f34374c;
                String str = this.f34395x;
                paint.getTextBounds(str, 0, str.length(), this.f34388q);
                float width = (float) this.f34388q.width();
                float height = (float) this.f34388q.height();
                canvas.clipRect(this.f34396y ? (int) (((((float) i) - (((float) (i - i2)) * this.f34391t)) - ((float) i2)) + this.f34382k) : 0, 0, this.f34396y ? i : (int) (((((float) (i - i2)) * this.f34391t) + ((float) i2)) - this.f34382k), i2);
                canvas.drawText(this.f34395x, (((float) i) - width) / 2.0f, ((((float) i2) + height) / 2.0f) - 5.0f, this.f34374c);
            }
        }
        float f = (float) i2;
        float height2 = (f - (this.f34382k * 2.0f)) / ((float) this.f34381j.getHeight());
        this.f34386o.reset();
        this.f34386o.postScale(height2, height2, 0.5f, 0.5f);
        this.f34386o.postTranslate(this.f34396y ? (float) ((int) (((((float) i) - (((float) (i - i2)) * this.f34391t)) - f) + this.f34382k)) : (((float) (i - i2)) * this.f34391t) + this.f34382k, this.f34382k);
        canvas.drawBitmap(this.f34381j, this.f34386o, this.f34374c);
    }

    /* renamed from: a */
    private boolean m24317a(Rect rect, int i, int i2) {
        return rect != null && rect.left < i && i < rect.right && rect.top < i2 && i2 < rect.bottom;
    }
}
