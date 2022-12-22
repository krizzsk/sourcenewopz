package com.didi.addressnew.view.shadow;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.addressnew.util.ViewUtils;
import com.didi.passenger.C10448R;
import rui.config.RConfigConstants;

public class ShadowLayout extends FrameLayout {

    /* renamed from: A */
    private float f7601A;

    /* renamed from: B */
    private float f7602B;

    /* renamed from: C */
    private float f7603C;

    /* renamed from: D */
    private float f7604D;

    /* renamed from: E */
    private Paint f7605E;

    /* renamed from: F */
    private float f7606F;

    /* renamed from: G */
    private int f7607G;

    /* renamed from: H */
    private int f7608H;

    /* renamed from: I */
    private boolean f7609I;

    /* renamed from: a */
    private Drawable f7610a;

    /* renamed from: b */
    private int f7611b;

    /* renamed from: c */
    private Drawable f7612c;

    /* renamed from: d */
    private Drawable f7613d;

    /* renamed from: e */
    private View f7614e;

    /* renamed from: f */
    private int f7615f;

    /* renamed from: g */
    private int f7616g;

    /* renamed from: h */
    private int f7617h;

    /* renamed from: i */
    private float f7618i;

    /* renamed from: j */
    private float f7619j;

    /* renamed from: k */
    private float f7620k;

    /* renamed from: l */
    private float f7621l;

    /* renamed from: m */
    private boolean f7622m;

    /* renamed from: n */
    private boolean f7623n;

    /* renamed from: o */
    private boolean f7624o;

    /* renamed from: p */
    private boolean f7625p;

    /* renamed from: q */
    private Paint f7626q;

    /* renamed from: r */
    private Paint f7627r;

    /* renamed from: s */
    private int f7628s;

    /* renamed from: t */
    private int f7629t;

    /* renamed from: u */
    private int f7630u;

    /* renamed from: v */
    private int f7631v;

    /* renamed from: w */
    private RectF f7632w;

    /* renamed from: x */
    private int f7633x;

    /* renamed from: y */
    private boolean f7634y;

    /* renamed from: z */
    private boolean f7635z;

    public ShadowLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ShadowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7611b = -101;
        this.f7616g = -101;
        this.f7632w = new RectF();
        this.f7633x = 1;
        this.f7634y = true;
        m4824a(context, attributeSet);
    }

    /* renamed from: a */
    private void m4824a(Context context, AttributeSet attributeSet) {
        m4826a(attributeSet);
        Paint paint = new Paint();
        this.f7626q = paint;
        paint.setAntiAlias(true);
        this.f7626q.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f7605E = paint2;
        paint2.setAntiAlias(true);
        this.f7605E.setStyle(Paint.Style.STROKE);
        this.f7605E.setStrokeWidth(this.f7606F);
        int i = this.f7607G;
        if (i != -101) {
            this.f7605E.setColor(i);
        }
        Paint paint3 = new Paint(1);
        this.f7627r = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.f7627r.setColor(this.f7615f);
        setPadding();
    }

    /* renamed from: a */
    private void m4826a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10448R.styleable.ShadowLayout);
        if (obtainStyledAttributes != null) {
            try {
                this.f7634y = !obtainStyledAttributes.getBoolean(44, false);
                this.f7622m = !obtainStyledAttributes.getBoolean(46, false);
                this.f7623n = !obtainStyledAttributes.getBoolean(47, false);
                this.f7625p = !obtainStyledAttributes.getBoolean(45, false);
                this.f7624o = !obtainStyledAttributes.getBoolean(48, false);
                this.f7619j = obtainStyledAttributes.getDimension(3, 0.0f);
                this.f7601A = obtainStyledAttributes.getDimension(5, -1.0f);
                this.f7603C = obtainStyledAttributes.getDimension(4, -1.0f);
                this.f7602B = obtainStyledAttributes.getDimension(7, -1.0f);
                this.f7604D = obtainStyledAttributes.getDimension(6, -1.0f);
                float dimension = obtainStyledAttributes.getDimension(49, 0.0f);
                this.f7618i = dimension;
                if (dimension == 0.0f) {
                    this.f7634y = false;
                }
                this.f7620k = obtainStyledAttributes.getDimension(50, 0.0f);
                this.f7621l = obtainStyledAttributes.getDimension(51, 0.0f);
                this.f7617h = obtainStyledAttributes.getColor(43, Color.parseColor("#2a000000"));
                this.f7633x = obtainStyledAttributes.getInt(54, 1);
                this.f7635z = obtainStyledAttributes.getBoolean(53, true);
                this.f7615f = -1;
                Drawable drawable = obtainStyledAttributes.getDrawable(40);
                if (drawable != null) {
                    if (drawable instanceof ColorDrawable) {
                        this.f7615f = ((ColorDrawable) drawable).getColor();
                    } else {
                        this.f7612c = drawable;
                    }
                }
                Drawable drawable2 = obtainStyledAttributes.getDrawable(42);
                if (drawable2 != null) {
                    if (drawable2 instanceof ColorDrawable) {
                        this.f7616g = ((ColorDrawable) drawable2).getColor();
                    } else {
                        this.f7613d = drawable2;
                    }
                }
                if (this.f7616g != -101) {
                    if (this.f7612c != null) {
                        throw new UnsupportedOperationException("使用了ShadowLayout_layoutBackground_true属性，必须先设置ShadowLayout_layoutBackground属性。且设置颜色时，必须保持都为颜色");
                    }
                }
                if (this.f7612c == null) {
                    if (this.f7613d != null) {
                        throw new UnsupportedOperationException("使用了ShadowLayout_layoutBackground_true属性，必须先设置ShadowLayout_layoutBackground属性。且设置图片时，必须保持都为图片");
                    }
                }
                this.f7607G = obtainStyledAttributes.getColor(55, -101);
                int color = obtainStyledAttributes.getColor(56, -101);
                this.f7608H = color;
                if (this.f7607G == -101) {
                    if (color != -101) {
                        throw new UnsupportedOperationException("使用了ShadowLayout_strokeColor_true属性，必须先设置ShadowLayout_strokeColor属性");
                    }
                }
                float dimension2 = obtainStyledAttributes.getDimension(57, (float) ViewUtils.dip2px(getContext(), 1.0f));
                this.f7606F = dimension2;
                if (dimension2 > ((float) ViewUtils.dip2px(getContext(), 7.0f))) {
                    this.f7606F = (float) ViewUtils.dip2px(getContext(), 5.0f);
                }
                Drawable drawable3 = obtainStyledAttributes.getDrawable(41);
                if (drawable3 != null) {
                    if (drawable3 instanceof ColorDrawable) {
                        this.f7611b = ((ColorDrawable) drawable3).getColor();
                    } else {
                        this.f7610a = drawable3;
                    }
                }
                boolean z = obtainStyledAttributes.getBoolean(2, true);
                this.f7609I = z;
                setClickable(z);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        this.f7609I = z;
        changeSwitchClickable();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.f7609I) {
            super.setOnClickListener(onClickListener);
        }
    }

    public void changeSwitchClickable() {
        View view;
        if (this.f7633x == 1 && (view = this.f7614e) != null) {
            if (this.f7609I) {
                Drawable drawable = this.f7612c;
                if (drawable != null) {
                    setBackGround(drawable);
                } else if (view.getBackground() != null) {
                    this.f7614e.getBackground().setAlpha(0);
                }
                this.f7627r.setColor(this.f7615f);
                postInvalidate();
            } else if (this.f7611b != -101) {
                if (this.f7612c != null) {
                    view.getBackground().setAlpha(0);
                }
                this.f7627r.setColor(this.f7611b);
                postInvalidate();
            } else {
                Drawable drawable2 = this.f7610a;
                if (drawable2 != null) {
                    setBackGround(drawable2);
                    this.f7627r.setColor(Color.parseColor("#00000000"));
                    postInvalidate();
                }
            }
        }
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        if (this.f7633x == 2) {
            if (z) {
                int i = this.f7616g;
                if (i != -101) {
                    this.f7627r.setColor(i);
                }
                int i2 = this.f7608H;
                if (i2 != -101) {
                    this.f7605E.setColor(i2);
                }
                Drawable drawable = this.f7613d;
                if (drawable != null) {
                    setBackGround(drawable);
                }
            } else {
                this.f7627r.setColor(this.f7615f);
                int i3 = this.f7607G;
                if (i3 != -101) {
                    this.f7605E.setColor(i3);
                }
                Drawable drawable2 = this.f7612c;
                if (drawable2 != null) {
                    setBackGround(drawable2);
                }
            }
            postInvalidate();
        }
    }

    public void setShowShadow(boolean z) {
        this.f7634y = z;
        if (getWidth() != 0 && getHeight() != 0) {
            m4823a(getWidth(), getHeight());
        }
    }

    public void setXOffset(float f) {
        float abs = Math.abs(f);
        float f2 = this.f7618i;
        if (abs <= f2) {
            this.f7620k = f;
        } else if (f > 0.0f) {
            this.f7620k = f2;
        } else {
            this.f7620k = -f2;
        }
        setPadding();
    }

    public void setYOffset(float f) {
        float abs = Math.abs(f);
        float f2 = this.f7618i;
        if (abs <= f2) {
            this.f7621l = f;
        } else if (f > 0.0f) {
            this.f7621l = f2;
        } else {
            this.f7621l = -f2;
        }
        setPadding();
    }

    public void setCornerRadius(int i) {
        this.f7619j = (float) i;
        if (getWidth() != 0 && getHeight() != 0) {
            m4823a(getWidth(), getHeight());
        }
    }

    public void setShadowSpreed(int i) {
        this.f7618i = (float) i;
        setPadding();
    }

    public void setShadowColor(int i) {
        this.f7617h = i;
        if (getWidth() != 0 && getHeight() != 0) {
            m4823a(getWidth(), getHeight());
        }
    }

    public void setIsShowLeftShadow(boolean z) {
        this.f7622m = z;
        setPadding();
    }

    public void setIsShowRightShadow(boolean z) {
        this.f7623n = z;
        setPadding();
    }

    public void setIsShowTopShadow(boolean z) {
        this.f7624o = z;
        setPadding();
    }

    public void setIsShowBottomShadow(boolean z) {
        this.f7625p = z;
        setPadding();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        View childAt = getChildAt(0);
        this.f7614e = childAt;
        if (childAt == null) {
            this.f7614e = this;
        }
        if (this.f7614e == null) {
            return;
        }
        if (this.f7633x == 2) {
            if (isSelected()) {
                setBackGround(this.f7613d);
            } else {
                setBackGround(this.f7612c);
            }
        } else if (this.f7609I) {
            setBackGround(this.f7612c);
        } else {
            setBackGround(this.f7610a);
            int i = this.f7611b;
            if (i != -101) {
                this.f7627r.setColor(i);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            m4823a(i, i2);
        }
    }

    public void setPadding() {
        if (this.f7634y) {
            float f = this.f7618i;
            if (f > 0.0f) {
                int i = 0;
                if (this.f7635z) {
                    int abs = (int) (f + Math.abs(this.f7620k));
                    int abs2 = (int) (this.f7618i + Math.abs(this.f7621l));
                    this.f7628s = this.f7622m ? abs : 0;
                    if (!this.f7623n) {
                        abs = 0;
                    }
                    this.f7630u = abs;
                    this.f7629t = this.f7624o ? abs2 : 0;
                    if (this.f7625p) {
                        i = abs2;
                    }
                    this.f7631v = i;
                } else {
                    float abs3 = Math.abs(this.f7621l);
                    float f2 = this.f7618i;
                    if (abs3 > f2) {
                        if (this.f7621l <= 0.0f) {
                            f2 = -f2;
                        }
                        this.f7621l = f2;
                    }
                    float abs4 = Math.abs(this.f7620k);
                    float f3 = this.f7618i;
                    if (abs4 > f3) {
                        if (this.f7620k <= 0.0f) {
                            f3 = -f3;
                        }
                        this.f7620k = f3;
                    }
                    this.f7629t = this.f7624o ? (int) (this.f7618i - this.f7621l) : 0;
                    this.f7630u = this.f7623n ? (int) (this.f7618i - this.f7620k) : 0;
                    this.f7631v = this.f7625p ? (int) (this.f7618i + this.f7621l) : 0;
                    if (this.f7622m) {
                        i = (int) (this.f7618i + this.f7620k);
                    }
                    this.f7628s = i;
                }
                setPadding(this.f7628s, this.f7629t, this.f7630u, this.f7631v);
            }
        }
    }

    /* renamed from: a */
    private void m4823a(int i, int i2) {
        if (this.f7634y) {
            isAddAlpha(this.f7617h);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(m4822a(i, i2, this.f7619j, this.f7618i, this.f7620k, this.f7621l, this.f7617h, 0));
            if (Build.VERSION.SDK_INT <= 16) {
                setBackgroundDrawable(bitmapDrawable);
            } else {
                setBackground(bitmapDrawable);
            }
        } else if (getChildAt(0) == null) {
            Drawable drawable = this.f7612c;
            if (drawable != null) {
                this.f7614e = this;
                if (this.f7609I) {
                    setBackGround(drawable);
                } else {
                    changeSwitchClickable();
                }
            } else {
                setBackgroundColor(Color.parseColor("#00000000"));
            }
        } else {
            setBackgroundColor(Color.parseColor("#00000000"));
        }
    }

    /* renamed from: a */
    private Bitmap m4822a(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4) {
        float f5;
        float f6;
        float f7 = f3 / 4.0f;
        float f8 = f4 / 4.0f;
        int i5 = i / 4;
        int i6 = i2 / 4;
        float f9 = f / 4.0f;
        float f10 = f2 / 4.0f;
        Bitmap createBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF(f10, f10, ((float) i5) - f10, ((float) i6) - f10);
        if (this.f7635z) {
            if (f8 > 0.0f) {
                f5 = f7;
            } else {
                f5 = Math.abs(f8);
            }
            rectF.top += f5;
            rectF.bottom -= f5;
            if (f7 > 0.0f) {
                f6 = f7;
            } else {
                f6 = Math.abs(f7);
            }
            rectF.left += f6;
            rectF.right -= f6;
        } else {
            rectF.top -= f8;
            rectF.bottom -= f8;
            rectF.right -= f7;
            rectF.left -= f7;
        }
        this.f7626q.setColor(i4);
        if (!isInEditMode()) {
            this.f7626q.setShadowLayer(f10, f7, f8, i3);
        }
        if (this.f7603C == -1.0f && this.f7601A == -1.0f && this.f7602B == -1.0f && this.f7604D == -1.0f) {
            canvas.drawRoundRect(rectF, f9, f9, this.f7626q);
        } else {
            this.f7632w.left = (float) this.f7628s;
            this.f7632w.top = (float) this.f7629t;
            this.f7632w.right = (float) (getWidth() - this.f7630u);
            this.f7632w.bottom = (float) (getHeight() - this.f7631v);
            this.f7626q.setAntiAlias(true);
            float f11 = this.f7601A;
            if (f11 == -1.0f) {
                f11 = this.f7619j;
            }
            int i7 = ((int) f11) / 4;
            float f12 = this.f7603C;
            if (f12 == -1.0f) {
                f12 = this.f7619j;
            }
            int i8 = ((int) f12) / 4;
            float f13 = this.f7602B;
            if (f13 == -1.0f) {
                f13 = this.f7619j;
            }
            int i9 = ((int) f13) / 4;
            float f14 = this.f7604D;
            float f15 = (float) i7;
            float f16 = (float) i9;
            float f17 = (float) ((f14 == -1.0f ? (int) this.f7619j : (int) f14) / 4);
            float f18 = (float) i8;
            float[] fArr = {f15, f15, f16, f16, f17, f17, f18, f18};
            Path path = new Path();
            path.addRoundRect(rectF, fArr, Path.Direction.CW);
            canvas.drawPath(path, this.f7626q);
        }
        return createBitmap;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f7632w.left = (float) this.f7628s;
        this.f7632w.top = (float) this.f7629t;
        this.f7632w.right = (float) (getWidth() - this.f7630u);
        this.f7632w.bottom = (float) (getHeight() - this.f7631v);
        int i = (int) (this.f7632w.bottom - this.f7632w.top);
        if (getChildAt(0) == null) {
            return;
        }
        if (this.f7601A == -1.0f && this.f7603C == -1.0f && this.f7602B == -1.0f && this.f7604D == -1.0f) {
            float f = this.f7619j;
            float f2 = (float) (i / 2);
            if (f > f2) {
                canvas.drawRoundRect(this.f7632w, f2, f2, this.f7627r);
                if (this.f7607G != -101) {
                    canvas.drawRoundRect(new RectF(this.f7632w.left + (this.f7606F / 2.0f), this.f7632w.top + (this.f7606F / 2.0f), this.f7632w.right - (this.f7606F / 2.0f), this.f7632w.bottom - (this.f7606F / 2.0f)), f2, f2, this.f7605E);
                    return;
                }
                return;
            }
            canvas.drawRoundRect(this.f7632w, f, f, this.f7627r);
            if (this.f7607G != -101) {
                RectF rectF = new RectF(this.f7632w.left + (this.f7606F / 2.0f), this.f7632w.top + (this.f7606F / 2.0f), this.f7632w.right - (this.f7606F / 2.0f), this.f7632w.bottom - (this.f7606F / 2.0f));
                float f3 = this.f7619j;
                canvas.drawRoundRect(rectF, f3, f3, this.f7605E);
                return;
            }
            return;
        }
        m4825a(canvas, i);
    }

    /* renamed from: a */
    private void m4825a(Canvas canvas, int i) {
        float f = this.f7601A;
        if (f == -1.0f) {
            f = this.f7619j;
        }
        int i2 = (int) f;
        int i3 = i / 2;
        if (i2 > i3) {
            i2 = i3;
        }
        float f2 = this.f7602B;
        if (f2 == -1.0f) {
            f2 = this.f7619j;
        }
        int i4 = (int) f2;
        if (i4 > i3) {
            i4 = i3;
        }
        float f3 = this.f7604D;
        if (f3 == -1.0f) {
            f3 = this.f7619j;
        }
        int i5 = (int) f3;
        if (i5 > i3) {
            i5 = i3;
        }
        float f4 = this.f7603C;
        int i6 = f4 == -1.0f ? (int) this.f7619j : (int) f4;
        if (i6 <= i3) {
            i3 = i6;
        }
        float f5 = (float) i2;
        float f6 = (float) i4;
        float f7 = (float) i5;
        float f8 = (float) i3;
        float[] fArr = {f5, f5, f6, f6, f7, f7, f8, f8};
        if (this.f7607G != -101) {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, (RectF) null, (float[]) null));
            shapeDrawable.getPaint().setColor(this.f7627r.getColor());
            shapeDrawable.setBounds(this.f7628s, this.f7629t, getWidth() - this.f7630u, getHeight() - this.f7631v);
            shapeDrawable.draw(canvas);
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new RoundRectShape(fArr, (RectF) null, (float[]) null));
            shapeDrawable2.getPaint().setColor(this.f7605E.getColor());
            shapeDrawable2.getPaint().setStyle(Paint.Style.STROKE);
            shapeDrawable2.getPaint().setStrokeWidth(this.f7606F);
            float f9 = this.f7606F;
            shapeDrawable2.setBounds((int) (((float) this.f7628s) + (f9 / 2.0f)), (int) (((float) this.f7629t) + (f9 / 2.0f)), (int) (((float) (getWidth() - this.f7630u)) - (this.f7606F / 2.0f)), (int) (((float) (getHeight() - this.f7631v)) - (this.f7606F / 2.0f)));
            shapeDrawable2.draw(canvas);
            return;
        }
        ShapeDrawable shapeDrawable3 = new ShapeDrawable(new RoundRectShape(fArr, (RectF) null, (float[]) null));
        shapeDrawable3.getPaint().setColor(this.f7627r.getColor());
        shapeDrawable3.setBounds(this.f7628s, this.f7629t, getWidth() - this.f7630u, getHeight() - this.f7631v);
        shapeDrawable3.draw(canvas);
    }

    public void isAddAlpha(int i) {
        if (Color.alpha(i) == 255) {
            String hexString = Integer.toHexString(Color.red(i));
            String hexString2 = Integer.toHexString(Color.green(i));
            String hexString3 = Integer.toHexString(Color.blue(i));
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            if (hexString2.length() == 1) {
                hexString2 = "0" + hexString2;
            }
            if (hexString3.length() == 1) {
                hexString3 = "0" + hexString3;
            }
            this.f7617h = convertToColorInt("#2a" + hexString + hexString2 + hexString3);
        }
    }

    public static int convertToColorInt(String str) throws IllegalArgumentException {
        if (!str.startsWith(RConfigConstants.KEYWORD_COLOR_SIGN)) {
            str = RConfigConstants.KEYWORD_COLOR_SIGN + str;
        }
        return Color.parseColor(str);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!(this.f7616g == -101 && this.f7608H == -101 && this.f7613d == null) && this.f7609I) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if ((action == 1 || action == 3) && this.f7633x == 1) {
                    this.f7627r.setColor(this.f7615f);
                    int i = this.f7607G;
                    if (i != -101) {
                        this.f7605E.setColor(i);
                    }
                    Drawable drawable = this.f7612c;
                    if (drawable != null) {
                        setBackGround(drawable);
                    }
                    postInvalidate();
                }
            } else if (this.f7633x == 1) {
                int i2 = this.f7616g;
                if (i2 != -101) {
                    this.f7627r.setColor(i2);
                }
                int i3 = this.f7608H;
                if (i3 != -101) {
                    this.f7605E.setColor(i3);
                }
                Drawable drawable2 = this.f7613d;
                if (drawable2 != null) {
                    setBackGround(drawable2);
                }
                postInvalidate();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBackGround(Drawable drawable) {
        if (this.f7614e != null && drawable != null) {
            if (this.f7601A != -1.0f || this.f7603C != -1.0f || this.f7602B != -1.0f || this.f7604D != -1.0f) {
                int i = (this.f7601A > -1.0f ? 1 : (this.f7601A == -1.0f ? 0 : -1));
                int i2 = (this.f7603C > -1.0f ? 1 : (this.f7603C == -1.0f ? 0 : -1));
                int i3 = (this.f7602B > -1.0f ? 1 : (this.f7602B == -1.0f ? 0 : -1));
                int i4 = (this.f7604D > -1.0f ? 1 : (this.f7604D == -1.0f ? 0 : -1));
            }
        }
    }
}
