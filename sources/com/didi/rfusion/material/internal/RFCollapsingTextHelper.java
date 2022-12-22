package com.didi.rfusion.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.didi.passenger.C10448R;
import com.didi.rfusion.material.animation.RFAnimationUtils;
import com.didi.rfusion.material.internal.RFStaticLayoutBuilderCompat;
import com.didi.sdk.apm.SystemUtils;

public final class RFCollapsingTextHelper {

    /* renamed from: a */
    private static final boolean f33208a = (Build.VERSION.SDK_INT < 18);

    /* renamed from: b */
    private static final String f33209b = "RFCollapsingTextHelper";

    /* renamed from: c */
    private static final String f33210c = "…";

    /* renamed from: d */
    private static final float f33211d = 0.5f;

    /* renamed from: e */
    private static final boolean f33212e = false;

    /* renamed from: f */
    private static final Paint f33213f;

    /* renamed from: A */
    private float f33214A;

    /* renamed from: B */
    private float f33215B;

    /* renamed from: C */
    private Typeface f33216C;

    /* renamed from: D */
    private Typeface f33217D;

    /* renamed from: E */
    private Typeface f33218E;

    /* renamed from: F */
    private CharSequence f33219F;

    /* renamed from: G */
    private CharSequence f33220G;

    /* renamed from: H */
    private boolean f33221H;

    /* renamed from: I */
    private boolean f33222I;

    /* renamed from: J */
    private Bitmap f33223J;

    /* renamed from: K */
    private Paint f33224K;

    /* renamed from: L */
    private float f33225L;

    /* renamed from: M */
    private float f33226M;

    /* renamed from: N */
    private int[] f33227N;

    /* renamed from: O */
    private boolean f33228O;

    /* renamed from: P */
    private final TextPaint f33229P;

    /* renamed from: Q */
    private final TextPaint f33230Q;

    /* renamed from: R */
    private TimeInterpolator f33231R;

    /* renamed from: S */
    private TimeInterpolator f33232S;

    /* renamed from: T */
    private float f33233T;

    /* renamed from: U */
    private float f33234U;

    /* renamed from: V */
    private float f33235V;

    /* renamed from: W */
    private ColorStateList f33236W;

    /* renamed from: X */
    private float f33237X;

    /* renamed from: Y */
    private float f33238Y;

    /* renamed from: Z */
    private float f33239Z;

    /* renamed from: aa */
    private ColorStateList f33240aa;

    /* renamed from: ab */
    private float f33241ab;

    /* renamed from: ac */
    private float f33242ac;

    /* renamed from: ad */
    private StaticLayout f33243ad;

    /* renamed from: ae */
    private float f33244ae;

    /* renamed from: af */
    private float f33245af;

    /* renamed from: ag */
    private float f33246ag;

    /* renamed from: ah */
    private CharSequence f33247ah;

    /* renamed from: ai */
    private int f33248ai = 1;

    /* renamed from: aj */
    private Drawable f33249aj;

    /* renamed from: ak */
    private Rect f33250ak = new Rect();

    /* renamed from: g */
    private final View f33251g;

    /* renamed from: h */
    private boolean f33252h;

    /* renamed from: i */
    private float f33253i;

    /* renamed from: j */
    private boolean f33254j;

    /* renamed from: k */
    private float f33255k;

    /* renamed from: l */
    private float f33256l;

    /* renamed from: m */
    private int f33257m;

    /* renamed from: n */
    private final Rect f33258n;

    /* renamed from: o */
    private final Rect f33259o;

    /* renamed from: p */
    private final RectF f33260p;

    /* renamed from: q */
    private int f33261q = 16;

    /* renamed from: r */
    private int f33262r = 16;

    /* renamed from: s */
    private float f33263s = 15.0f;

    /* renamed from: t */
    private float f33264t = 15.0f;

    /* renamed from: u */
    private ColorStateList f33265u;

    /* renamed from: v */
    private ColorStateList f33266v;

    /* renamed from: w */
    private float f33267w;

    /* renamed from: x */
    private float f33268x;

    /* renamed from: y */
    private float f33269y;

    /* renamed from: z */
    private float f33270z;

    static {
        Paint paint = null;
        f33213f = paint;
        if (paint != null) {
            paint.setAntiAlias(true);
            f33213f.setColor(-65281);
        }
    }

    public RFCollapsingTextHelper(View view) {
        this.f33251g = view;
        this.f33229P = new TextPaint(129);
        this.f33230Q = new TextPaint(this.f33229P);
        this.f33259o = new Rect();
        this.f33258n = new Rect();
        this.f33260p = new RectF();
        this.f33256l = m23391b();
    }

    public void setTextSizeInterpolator(TimeInterpolator timeInterpolator) {
        this.f33232S = timeInterpolator;
        recalculate();
    }

    public void setPositionInterpolator(TimeInterpolator timeInterpolator) {
        this.f33231R = timeInterpolator;
        recalculate();
    }

    public void setRightDrawable(Drawable drawable) {
        this.f33249aj = drawable;
        recalculate();
    }

    public Drawable getRightDrawable() {
        return this.f33249aj;
    }

    public void setExpandedTextSize(float f) {
        if (this.f33263s != f) {
            this.f33263s = f;
            recalculate();
        }
    }

    public void setCollapsedTextSize(float f) {
        if (this.f33264t != f) {
            this.f33264t = f;
            recalculate();
        }
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.f33266v != colorStateList) {
            this.f33266v = colorStateList;
            recalculate();
        }
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.f33265u != colorStateList) {
            this.f33265u = colorStateList;
            recalculate();
        }
    }

    public void setExpandedBounds(int i, int i2, int i3, int i4) {
        if (!m23389a(this.f33258n, i, i2, i3, i4)) {
            this.f33258n.set(i, i2, i3, i4);
            this.f33228O = true;
            mo87347a();
        }
    }

    public void setExpandedBounds(Rect rect) {
        setExpandedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setCollapsedBounds(int i, int i2, int i3, int i4) {
        if (!m23389a(this.f33259o, i, i2, i3, i4)) {
            this.f33259o.set(i, i2, i3, i4);
            this.f33228O = true;
            mo87347a();
        }
    }

    public void setCollapsedBounds(Rect rect) {
        setCollapsedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void getCollapsedTextActualBounds(RectF rectF, int i, int i2) {
        this.f33221H = m23390a(this.f33219F);
        rectF.left = m23379a(i, i2);
        rectF.top = (float) this.f33259o.top;
        rectF.right = m23380a(rectF, i, i2);
        rectF.bottom = ((float) this.f33259o.top) + getCollapsedTextHeight();
    }

    /* renamed from: a */
    private float m23379a(int i, int i2) {
        if (i2 == 17 || (i2 & 7) == 1) {
            return (((float) i) / 2.0f) - (calculateCollapsedTextWidth() / 2.0f);
        }
        return ((i2 & GravityCompat.END) == 8388613 || (i2 & 5) == 5) ? this.f33221H ? (float) this.f33259o.left : ((float) this.f33259o.right) - calculateCollapsedTextWidth() : this.f33221H ? ((float) this.f33259o.right) - calculateCollapsedTextWidth() : (float) this.f33259o.left;
    }

    /* renamed from: a */
    private float m23380a(RectF rectF, int i, int i2) {
        if (i2 == 17 || (i2 & 7) == 1) {
            return (((float) i) / 2.0f) + (calculateCollapsedTextWidth() / 2.0f);
        }
        return ((i2 & GravityCompat.END) == 8388613 || (i2 & 5) == 5) ? this.f33221H ? rectF.left + calculateCollapsedTextWidth() : (float) this.f33259o.right : this.f33221H ? (float) this.f33259o.right : rectF.left + calculateCollapsedTextWidth();
    }

    public float calculateCollapsedTextWidth() {
        if (this.f33219F == null) {
            return 0.0f;
        }
        m23393b(this.f33230Q);
        TextPaint textPaint = this.f33230Q;
        CharSequence charSequence = this.f33219F;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public float getExpandedTextHeight() {
        m23387a(this.f33230Q);
        return -this.f33230Q.ascent();
    }

    public float getCollapsedTextHeight() {
        m23393b(this.f33230Q);
        return -this.f33230Q.ascent();
    }

    public void setCurrentOffsetY(int i) {
        this.f33257m = i;
    }

    public void setFadeModeStartFraction(float f) {
        this.f33255k = f;
        this.f33256l = m23391b();
    }

    /* renamed from: b */
    private float m23391b() {
        float f = this.f33255k;
        return f + ((1.0f - f) * 0.5f);
    }

    public void setFadeModeEnabled(boolean z) {
        this.f33254j = z;
    }

    /* renamed from: a */
    private void m23387a(TextPaint textPaint) {
        textPaint.setTextSize(this.f33263s);
        textPaint.setTypeface(this.f33217D);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.f33242ac);
        }
    }

    /* renamed from: b */
    private void m23393b(TextPaint textPaint) {
        textPaint.setTextSize(this.f33264t);
        textPaint.setTypeface(this.f33216C);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.f33241ab);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo87347a() {
        this.f33252h = this.f33259o.width() > 0 && this.f33259o.height() > 0 && this.f33258n.width() > 0 && this.f33258n.height() > 0;
    }

    public void setExpandedTextGravity(int i) {
        if (this.f33261q != i) {
            this.f33261q = i;
            recalculate();
        }
    }

    public int getExpandedTextGravity() {
        return this.f33261q;
    }

    public void setCollapsedTextGravity(int i) {
        if (this.f33262r != i) {
            this.f33262r = i;
            recalculate();
        }
    }

    public int getCollapsedTextGravity() {
        return this.f33262r;
    }

    public void setCollapsedTextAppearance(int i) {
        RFTintTypedArray obtainStyledAttributes = RFTintTypedArray.obtainStyledAttributes(this.f33251g.getContext(), i, C10448R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f33266v = obtainStyledAttributes.getColorStateList(3);
        }
        if (obtainStyledAttributes.hasValue(0)) {
            this.f33264t = (float) obtainStyledAttributes.getDimensionPixelSize(0, (int) this.f33264t);
        }
        recalculate();
    }

    public void setExpandedTextAppearance(int i) {
        RFTintTypedArray obtainStyledAttributes = RFTintTypedArray.obtainStyledAttributes(this.f33251g.getContext(), i, C10448R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f33265u = obtainStyledAttributes.getColorStateList(3);
        }
        if (obtainStyledAttributes.hasValue(0)) {
            this.f33263s = (float) obtainStyledAttributes.getDimensionPixelSize(0, (int) this.f33263s);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f33217D = m23383a(i);
        }
        recalculate();
    }

    public void setCollapsedTypeface(Typeface typeface) {
        if (this.f33216C != typeface) {
            this.f33216C = typeface;
            recalculate();
        }
    }

    public void setExpandedTypeface(Typeface typeface) {
        if (this.f33217D != typeface) {
            this.f33217D = typeface;
            recalculate();
        }
    }

    public void setTypefaces(Typeface typeface) {
        this.f33217D = typeface;
        this.f33216C = typeface;
        recalculate();
    }

    /* renamed from: a */
    private Typeface m23383a(int i) {
        TypedArray obtainStyledAttributes = this.f33251g.getContext().obtainStyledAttributes(i, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public Typeface getCollapsedTypeface() {
        Typeface typeface = this.f33216C;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public Typeface getExpandedTypeface() {
        Typeface typeface = this.f33217D;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void setExpansionFraction(float f) {
        float clamp = MathUtils.clamp(f, 0.0f, 1.0f);
        if (clamp != this.f33253i) {
            this.f33253i = clamp;
            m23394c();
        }
    }

    public final boolean setState(int[] iArr) {
        this.f33227N = iArr;
        if (!isStateful()) {
            return false;
        }
        recalculate();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f33265u;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isStateful() {
        /*
            r1 = this;
            android.content.res.ColorStateList r0 = r1.f33266v
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0014
        L_0x000a:
            android.content.res.ColorStateList r0 = r1.f33265u
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.material.internal.RFCollapsingTextHelper.isStateful():boolean");
    }

    public float getFadeModeThresholdFraction() {
        return this.f33256l;
    }

    public float getExpansionFraction() {
        return this.f33253i;
    }

    public float getCollapsedTextSize() {
        return this.f33264t;
    }

    public float getExpandedTextSize() {
        return this.f33263s;
    }

    /* renamed from: c */
    private void m23394c() {
        m23385a(this.f33253i);
    }

    /* renamed from: a */
    private void m23385a(float f) {
        m23395c(f);
        if (!this.f33254j) {
            this.f33214A = m23378a(this.f33269y, this.f33270z, f, this.f33231R);
            this.f33215B = m23378a(this.f33267w, this.f33268x, f, this.f33231R);
            m23400f(m23378a(this.f33263s, this.f33264t, f, this.f33232S));
        } else if (f < this.f33256l) {
            this.f33214A = this.f33269y;
            this.f33215B = m23378a(this.f33267w, this.f33268x, f, this.f33231R);
            m23400f(this.f33263s);
        } else {
            this.f33214A = this.f33270z;
            this.f33215B = this.f33268x - ((float) this.f33257m);
            m23400f(this.f33264t);
        }
        m23397d(1.0f - m23378a(0.0f, 1.0f, 1.0f - f, RFAnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        m23399e(m23378a(1.0f, 0.0f, f, RFAnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        if (this.f33266v != this.f33265u) {
            this.f33229P.setColor(m23381a(m23396d(), getCurrentCollapsedTextColor(), f));
        } else {
            this.f33229P.setColor(getCurrentCollapsedTextColor());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            float f2 = this.f33241ab;
            float f3 = this.f33242ac;
            if (f2 != f3) {
                this.f33229P.setLetterSpacing(m23378a(f3, f2, f, RFAnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            } else {
                this.f33229P.setLetterSpacing(f2);
            }
        }
        if (this.f33254j) {
            this.f33229P.setAlpha((int) (m23392b(f) * 255.0f));
        }
        ViewCompat.postInvalidateOnAnimation(this.f33251g);
    }

    /* renamed from: b */
    private float m23392b(float f) {
        float f2 = this.f33256l;
        if (f <= f2) {
            return RFAnimationUtils.lerp(1.0f, 0.0f, this.f33255k, f2, f);
        }
        return RFAnimationUtils.lerp(0.0f, 1.0f, f2, 1.0f, f);
    }

    /* renamed from: d */
    private int m23396d() {
        return m23382a(this.f33265u);
    }

    public int getCurrentCollapsedTextColor() {
        return m23382a(this.f33266v);
    }

    /* renamed from: a */
    private int m23382a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.f33227N;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    /* renamed from: e */
    private void m23398e() {
        StaticLayout staticLayout;
        float f = this.f33226M;
        m23402g(this.f33264t);
        CharSequence charSequence = this.f33220G;
        if (!(charSequence == null || (staticLayout = this.f33243ad) == null)) {
            this.f33247ah = TextUtils.ellipsize(charSequence, this.f33229P, (float) staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.f33247ah;
        float f2 = 0.0f;
        float measureText = charSequence2 != null ? this.f33229P.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.f33262r, this.f33221H ? 1 : 0);
        int i = absoluteGravity & 112;
        if (i == 48) {
            this.f33268x = (float) this.f33259o.top;
        } else if (i != 80) {
            this.f33268x = ((float) this.f33259o.centerY()) - ((this.f33229P.descent() - this.f33229P.ascent()) / 2.0f);
        } else {
            this.f33268x = ((float) this.f33259o.bottom) + this.f33229P.ascent();
        }
        int i2 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i2 == 1) {
            this.f33270z = ((float) this.f33259o.centerX()) - (measureText / 2.0f);
        } else if (i2 != 5) {
            this.f33270z = (float) this.f33259o.left;
        } else {
            this.f33270z = ((float) this.f33259o.right) - measureText;
        }
        m23402g(this.f33263s);
        StaticLayout staticLayout2 = this.f33243ad;
        float height = staticLayout2 != null ? (float) staticLayout2.getHeight() : 0.0f;
        CharSequence charSequence3 = this.f33220G;
        float measureText2 = charSequence3 != null ? this.f33229P.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        StaticLayout staticLayout3 = this.f33243ad;
        if (staticLayout3 != null && this.f33248ai > 1) {
            measureText2 = (float) staticLayout3.getWidth();
        }
        StaticLayout staticLayout4 = this.f33243ad;
        if (staticLayout4 != null) {
            f2 = this.f33248ai > 1 ? (float) staticLayout4.getLineStart(0) : staticLayout4.getLineLeft(0);
        }
        this.f33246ag = f2;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.f33261q, this.f33221H ? 1 : 0);
        int i3 = absoluteGravity2 & 112;
        if (i3 == 48) {
            this.f33267w = (float) this.f33258n.top;
        } else if (i3 != 80) {
            this.f33267w = ((float) this.f33258n.centerY()) - (height / 2.0f);
        } else {
            this.f33267w = (((float) this.f33258n.bottom) - height) + this.f33229P.descent();
        }
        int i4 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i4 == 1) {
            this.f33269y = ((float) this.f33258n.centerX()) - (measureText2 / 2.0f);
        } else if (i4 != 5) {
            this.f33269y = (float) this.f33258n.left;
        } else {
            this.f33269y = ((float) this.f33258n.right) - measureText2;
        }
        m23407k();
        m23400f(f);
    }

    /* renamed from: c */
    private void m23395c(float f) {
        if (!this.f33254j) {
            this.f33260p.left = m23378a((float) this.f33258n.left, (float) this.f33259o.left, f, this.f33231R);
            this.f33260p.top = m23378a(this.f33267w, this.f33268x, f, this.f33231R);
            this.f33260p.right = m23378a((float) this.f33258n.right, (float) this.f33259o.right, f, this.f33231R);
            this.f33260p.bottom = m23378a((float) this.f33258n.bottom, (float) this.f33259o.bottom, f, this.f33231R);
        } else if (f < this.f33256l) {
            this.f33260p.left = (float) this.f33258n.left;
            this.f33260p.top = m23378a(this.f33267w, this.f33268x, f, this.f33231R);
            this.f33260p.right = (float) this.f33258n.right;
            this.f33260p.bottom = m23378a((float) this.f33258n.bottom, (float) this.f33259o.bottom, f, this.f33231R);
        } else {
            this.f33260p.left = (float) this.f33259o.left;
            this.f33260p.top = (float) this.f33259o.top;
            this.f33260p.right = (float) this.f33259o.right;
            this.f33260p.bottom = (float) this.f33259o.bottom;
        }
    }

    /* renamed from: d */
    private void m23397d(float f) {
        this.f33244ae = f;
        ViewCompat.postInvalidateOnAnimation(this.f33251g);
    }

    /* renamed from: e */
    private void m23399e(float f) {
        this.f33245af = f;
        ViewCompat.postInvalidateOnAnimation(this.f33251g);
    }

    public void draw(Canvas canvas) {
        int save = canvas.save();
        if (this.f33220G != null && this.f33252h) {
            float lineLeft = (this.f33214A + this.f33243ad.getLineLeft(0)) - (this.f33246ag * 2.0f);
            this.f33229P.setTextSize(this.f33226M);
            float f = this.f33214A;
            float f2 = this.f33215B;
            float height = ((float) this.f33243ad.getHeight()) * this.f33225L;
            boolean z = this.f33222I && this.f33223J != null;
            float f3 = this.f33225L;
            if (f3 != 1.0f && !this.f33254j) {
                canvas.scale(f3, f3, f, f2);
            }
            if (z) {
                canvas.drawBitmap(this.f33223J, f, f2, this.f33224K);
                canvas.restoreToCount(save);
                return;
            }
            if (!m23401f() || (this.f33254j && this.f33253i <= this.f33256l)) {
                canvas.translate(f, f2);
                this.f33243ad.draw(canvas);
            } else {
                m23386a(canvas, lineLeft, f2);
            }
            canvas.restoreToCount(save);
            if (this.f33249aj != null) {
                canvas.save();
                float f4 = 0.0f;
                if (this.f33243ad.getLineCount() > 0) {
                    f4 = this.f33243ad.getLineWidth(0);
                }
                canvas.translate(f + (f4 * this.f33225L), f2 + ((height - ((float) m23405i())) / 2.0f));
                this.f33249aj.draw(canvas);
                canvas.restore();
            }
        }
    }

    /* renamed from: f */
    private boolean m23401f() {
        return this.f33248ai > 1 && (!this.f33221H || this.f33254j) && !this.f33222I;
    }

    /* renamed from: a */
    private void m23386a(Canvas canvas, float f, float f2) {
        int alpha = this.f33229P.getAlpha();
        canvas.translate(f, f2);
        float f3 = (float) alpha;
        this.f33229P.setAlpha((int) (this.f33245af * f3));
        this.f33243ad.draw(canvas);
        this.f33229P.setAlpha((int) (this.f33244ae * f3));
        int lineBaseline = this.f33243ad.getLineBaseline(0);
        CharSequence charSequence = this.f33247ah;
        float f4 = (float) lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f4, this.f33229P);
        if (!this.f33254j) {
            String trim = this.f33247ah.toString().trim();
            if (trim.endsWith(f33210c)) {
                trim = trim.substring(0, trim.length() - 1);
            }
            String str = trim;
            this.f33229P.setAlpha(alpha);
            canvas.drawText(str, 0, Math.min(this.f33243ad.getLineEnd(0), str.length()), 0.0f, f4, this.f33229P);
        }
    }

    /* renamed from: a */
    private boolean m23390a(CharSequence charSequence) {
        return (m23403g() ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
    }

    /* renamed from: g */
    private boolean m23403g() {
        return ViewCompat.getLayoutDirection(this.f33251g) == 1;
    }

    /* renamed from: f */
    private void m23400f(float f) {
        m23402g(f);
        boolean z = f33208a && this.f33225L != 1.0f;
        this.f33222I = z;
        if (z) {
            m23406j();
        }
        ViewCompat.postInvalidateOnAnimation(this.f33251g);
    }

    /* renamed from: g */
    private void m23402g(float f) {
        float f2;
        boolean z;
        boolean z2;
        if (this.f33219F != null) {
            float width = (float) this.f33259o.width();
            float width2 = (float) this.f33258n.width();
            boolean z3 = false;
            int i = 1;
            if (m23388a(f, this.f33264t)) {
                f2 = this.f33264t;
                this.f33225L = 1.0f;
                Typeface typeface = this.f33218E;
                Typeface typeface2 = this.f33216C;
                if (typeface != typeface2) {
                    this.f33218E = typeface2;
                    z = true;
                } else {
                    z = false;
                }
            } else {
                float f3 = this.f33263s;
                Typeface typeface3 = this.f33218E;
                Typeface typeface4 = this.f33217D;
                if (typeface3 != typeface4) {
                    this.f33218E = typeface4;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (m23388a(f, this.f33263s)) {
                    this.f33225L = 1.0f;
                } else {
                    this.f33225L = f / this.f33263s;
                }
                f2 = f3;
                width = width2;
                z = z2;
            }
            if (this.f33249aj != null) {
                width -= (float) m23404h();
            }
            if (width > 0.0f) {
                z = this.f33226M != f2 || this.f33228O || z;
                this.f33226M = f2;
                this.f33228O = false;
            }
            if (this.f33220G == null || z) {
                this.f33229P.setTextSize(this.f33226M);
                this.f33229P.setTypeface(this.f33218E);
                TextPaint textPaint = this.f33229P;
                if (this.f33225L != 1.0f) {
                    z3 = true;
                }
                textPaint.setLinearText(z3);
                this.f33221H = m23390a(this.f33219F);
                if (m23401f()) {
                    i = this.f33248ai;
                }
                StaticLayout a = m23384a(i, width, this.f33221H);
                this.f33243ad = a;
                this.f33220G = a.getText();
            }
        }
    }

    /* renamed from: h */
    private int m23404h() {
        Drawable drawable = this.f33249aj;
        if (drawable == null) {
            return 0;
        }
        drawable.getPadding(this.f33250ak);
        return this.f33249aj.getBounds().width() + this.f33250ak.left + this.f33250ak.right;
    }

    /* renamed from: i */
    private int m23405i() {
        Drawable drawable = this.f33249aj;
        if (drawable == null) {
            return 0;
        }
        drawable.getPadding(this.f33250ak);
        return this.f33249aj.getBounds().height() + this.f33250ak.top + this.f33250ak.bottom;
    }

    /* renamed from: a */
    private StaticLayout m23384a(int i, float f, boolean z) {
        StaticLayout staticLayout;
        try {
            staticLayout = RFStaticLayoutBuilderCompat.obtain(this.f33219F, this.f33229P, (int) f).setEllipsize(TextUtils.TruncateAt.END).setIsRtl(z).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(false).setMaxLines(i).build();
        } catch (RFStaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e) {
            RFStaticLayoutBuilderCompat.StaticLayoutBuilderCompatException staticLayoutBuilderCompatException = e;
            SystemUtils.log(6, f33209b, staticLayoutBuilderCompatException.getCause().getMessage(), staticLayoutBuilderCompatException, "com.didi.rfusion.material.internal.RFCollapsingTextHelper", 974);
            staticLayout = null;
        }
        return (StaticLayout) RFPreconditions.checkNotNull(staticLayout);
    }

    /* renamed from: j */
    private void m23406j() {
        if (this.f33223J == null && !this.f33258n.isEmpty() && !TextUtils.isEmpty(this.f33220G)) {
            m23385a(0.0f);
            int width = this.f33243ad.getWidth();
            int height = this.f33243ad.getHeight();
            if (width > 0 && height > 0) {
                this.f33223J = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.f33243ad.draw(new Canvas(this.f33223J));
                if (this.f33224K == null) {
                    this.f33224K = new Paint(3);
                }
            }
        }
    }

    public void recalculate() {
        if (this.f33251g.getHeight() > 0 && this.f33251g.getWidth() > 0) {
            m23398e();
            m23394c();
        }
    }

    public void setText(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.f33219F, charSequence)) {
            this.f33219F = charSequence;
            this.f33220G = null;
            m23407k();
            recalculate();
        }
    }

    public CharSequence getText() {
        return this.f33219F;
    }

    /* renamed from: k */
    private void m23407k() {
        Bitmap bitmap = this.f33223J;
        if (bitmap != null) {
            bitmap.recycle();
            this.f33223J = null;
        }
    }

    public void setMaxLines(int i) {
        if (i != this.f33248ai) {
            this.f33248ai = i;
            m23407k();
            recalculate();
        }
    }

    public int getMaxLines() {
        return this.f33248ai;
    }

    public int getLineCount() {
        StaticLayout staticLayout = this.f33243ad;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    /* renamed from: a */
    private static boolean m23388a(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    public ColorStateList getExpandedTextColor() {
        return this.f33265u;
    }

    public ColorStateList getCollapsedTextColor() {
        return this.f33266v;
    }

    /* renamed from: a */
    private static int m23381a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((((float) Color.blue(i)) * f2) + (((float) Color.blue(i2)) * f)));
    }

    /* renamed from: a */
    private static float m23378a(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return RFAnimationUtils.lerp(f, f2, f3);
    }

    /* renamed from: a */
    private static boolean m23389a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
