package com.didi.rfusion.widget.titlebar.tools;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.didi.passenger.C10448R;
import com.didi.rfusion.material.animation.RFAnimationUtils;
import com.didi.rfusion.material.internal.RFCollapsingTextHelper;
import com.didi.rfusion.material.internal.RFDescendantOffsetUtils;
import com.didi.rfusion.material.internal.RFThemeEnforcement;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.titlebar.RFStandardTitleBar;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.badge.BadgeDrawable;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class RFCollapsingTitleBarLayout extends FrameLayout {
    public static final int TITLE_COLLAPSE_MODE_FADE = 1;
    public static final int TITLE_COLLAPSE_MODE_SCALE = 0;

    /* renamed from: e */
    private static final int f33967e = 2132018199;

    /* renamed from: f */
    private static final int f33968f = 600;

    /* renamed from: a */
    final RFCollapsingTextHelper f33969a;

    /* renamed from: b */
    Drawable f33970b;

    /* renamed from: c */
    int f33971c;

    /* renamed from: d */
    WindowInsetsCompat f33972d;

    /* renamed from: g */
    private boolean f33973g;

    /* renamed from: h */
    private int f33974h;

    /* renamed from: i */
    private ViewGroup f33975i;

    /* renamed from: j */
    private View f33976j;

    /* renamed from: k */
    private View f33977k;

    /* renamed from: l */
    private int f33978l;

    /* renamed from: m */
    private int f33979m;

    /* renamed from: n */
    private int f33980n;

    /* renamed from: o */
    private int f33981o;

    /* renamed from: p */
    private final Rect f33982p;

    /* renamed from: q */
    private boolean f33983q;

    /* renamed from: r */
    private boolean f33984r;

    /* renamed from: s */
    private Drawable f33985s;

    /* renamed from: t */
    private int f33986t;

    /* renamed from: u */
    private boolean f33987u;

    /* renamed from: v */
    private ValueAnimator f33988v;

    /* renamed from: w */
    private long f33989w;

    /* renamed from: x */
    private int f33990x;

    /* renamed from: y */
    private AppBarLayout.OnOffsetChangedListener f33991y;

    /* renamed from: z */
    private int f33992z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TitleCollapseMode {
    }

    public RFCollapsingTitleBarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFCollapsingTitleBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFCollapsingTitleBarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33973g = true;
        this.f33982p = new Rect();
        this.f33990x = -1;
        Context context2 = getContext();
        RFCollapsingTextHelper rFCollapsingTextHelper = new RFCollapsingTextHelper(this);
        this.f33969a = rFCollapsingTextHelper;
        rFCollapsingTextHelper.setTextSizeInterpolator(RFAnimationUtils.DECELERATE_INTERPOLATOR);
        TypedArray obtainStyledAttributes = RFThemeEnforcement.obtainStyledAttributes(context2, attributeSet, C10448R.styleable.CollapsingToolbarLayout, i, f33967e, new int[0]);
        this.f33969a.setExpandedTextGravity(obtainStyledAttributes.getInt(3, BadgeDrawable.BOTTOM_START));
        this.f33969a.setCollapsedTextGravity(obtainStyledAttributes.getInt(0, 8388627));
        int dimens = (int) RFResUtils.getDimens(R.dimen.rf_dimen_36);
        this.f33981o = dimens;
        this.f33980n = dimens;
        this.f33979m = dimens;
        this.f33978l = dimens;
        if (obtainStyledAttributes.hasValue(7)) {
            this.f33978l = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.f33980n = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        }
        if (obtainStyledAttributes.hasValue(8)) {
            this.f33979m = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        }
        if (obtainStyledAttributes.hasValue(5)) {
            this.f33981o = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        }
        this.f33983q = obtainStyledAttributes.getBoolean(18, true);
        setTitle(obtainStyledAttributes.getText(16));
        this.f33969a.setExpandedTextAppearance(2132017888);
        this.f33969a.setCollapsedTextAppearance(2132017862);
        if (obtainStyledAttributes.hasValue(9)) {
            this.f33969a.setExpandedTextAppearance(obtainStyledAttributes.getResourceId(9, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f33969a.setCollapsedTextAppearance(obtainStyledAttributes.getResourceId(1, 0));
        }
        this.f33990x = obtainStyledAttributes.getDimensionPixelSize(14, -1);
        this.f33969a.setMaxLines(3);
        this.f33989w = (long) obtainStyledAttributes.getInt(13, 600);
        setContentScrim(obtainStyledAttributes.getDrawable(2));
        setStatusBarScrim(obtainStyledAttributes.getDrawable(15));
        setTitleCollapseMode(0);
        this.f33974h = obtainStyledAttributes.getResourceId(19, -1);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            m23977a(appBarLayout);
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows(appBarLayout));
            if (this.f33991y == null) {
                this.f33991y = new OffsetUpdateListener();
            }
            appBarLayout.addOnOffsetChangedListener(this.f33991y);
            ViewCompat.requestApplyInsets(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.f33991y;
        if (onOffsetChangedListener != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public WindowInsetsCompat mo88512a(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.f33972d, windowInsetsCompat2)) {
            this.f33972d = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        m23980c();
        if (this.f33975i == null && (drawable = this.f33985s) != null && this.f33986t > 0) {
            drawable.mutate().setAlpha(this.f33986t);
            this.f33985s.draw(canvas);
        }
        if (this.f33983q && this.f33984r) {
            if (this.f33975i == null || this.f33985s == null || this.f33986t <= 0 || !m23979b() || this.f33969a.getExpansionFraction() >= this.f33969a.getFadeModeThresholdFraction()) {
                this.f33969a.draw(canvas);
            } else {
                int save = canvas.save();
                canvas.clipRect(this.f33985s.getBounds(), Region.Op.DIFFERENCE);
                this.f33969a.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        if (this.f33970b != null && this.f33986t > 0) {
            WindowInsetsCompat windowInsetsCompat = this.f33972d;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.f33970b.setBounds(0, -this.f33971c, getWidth(), systemWindowInsetTop - this.f33971c);
                this.f33970b.mutate().setAlpha(this.f33986t);
                this.f33970b.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        if (this.f33985s == null || this.f33986t <= 0 || !m23983d(view)) {
            z = false;
        } else {
            m23976a(this.f33985s, view, getWidth(), getHeight());
            this.f33985s.mutate().setAlpha(this.f33986t);
            this.f33985s.draw(canvas);
            z = true;
        }
        if (super.drawChild(canvas, view, j) || z) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Drawable drawable = this.f33985s;
        if (drawable != null) {
            m23975a(drawable, i, i2);
        }
    }

    /* renamed from: b */
    private boolean m23979b() {
        return this.f33992z == 1;
    }

    /* renamed from: a */
    private void m23977a(AppBarLayout appBarLayout) {
        if (m23979b()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    /* renamed from: a */
    private void m23975a(Drawable drawable, int i, int i2) {
        m23976a(drawable, this.f33975i, i, i2);
    }

    /* renamed from: a */
    private void m23976a(Drawable drawable, View view, int i, int i2) {
        if (m23979b() && view != null && this.f33983q) {
            i2 = view.getBottom();
        }
        drawable.setBounds(0, 0, i, i2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.view.ViewGroup} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m23980c() {
        /*
            r6 = this;
            boolean r0 = r6.f33973g
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r6.f33975i = r0
            r6.f33976j = r0
            int r1 = r6.f33974h
            r2 = -1
            if (r1 == r2) goto L_0x001f
            android.view.View r1 = r6.findViewById(r1)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r6.f33975i = r1
            if (r1 == 0) goto L_0x001f
            android.view.View r1 = r6.m23984e(r1)
            r6.f33976j = r1
        L_0x001f:
            android.view.ViewGroup r1 = r6.f33975i
            r2 = 0
            if (r1 != 0) goto L_0x003e
            int r1 = r6.getChildCount()
            r3 = 0
        L_0x0029:
            if (r3 >= r1) goto L_0x003c
            android.view.View r4 = r6.getChildAt(r3)
            boolean r5 = m23981c(r4)
            if (r5 == 0) goto L_0x0039
            r0 = r4
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x003c
        L_0x0039:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x003c:
            r6.f33975i = r0
        L_0x003e:
            r6.m23982d()
            r6.f33973g = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.widget.titlebar.tools.RFCollapsingTitleBarLayout.m23980c():void");
    }

    /* renamed from: c */
    private static boolean m23981c(View view) {
        return view instanceof RFStandardTitleBar;
    }

    /* renamed from: d */
    private boolean m23983d(View view) {
        View view2 = this.f33976j;
        if (view2 == null || view2 == this) {
            if (view == this.f33975i) {
                return true;
            }
        } else if (view == view2) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    private View m23984e(View view) {
        ViewParent parent = view.getParent();
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view = (View) parent;
            }
            parent = parent.getParent();
        }
        return view;
    }

    /* renamed from: d */
    private void m23982d() {
        View view;
        if (!this.f33983q && (view = this.f33977k) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f33977k);
            }
        }
        if (this.f33983q && this.f33975i != null) {
            if (this.f33977k == null) {
                this.f33977k = new View(getContext());
            }
            if (this.f33977k.getParent() == null) {
                ViewGroup viewGroup = this.f33975i;
                if (viewGroup instanceof RFStandardTitleBar) {
                    ((RFStandardTitleBar) viewGroup).addTitleView(this.f33977k, new ViewGroup.LayoutParams(-1, -1));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        m23980c();
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        WindowInsetsCompat windowInsetsCompat = this.f33972d;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (mode == 0 && systemWindowInsetTop > 0) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + systemWindowInsetTop, 1073741824));
        }
        if (this.f33975i != null) {
            View view = this.f33976j;
            if (view == null || view == this) {
                setMinimumHeight(m23987g(this.f33975i));
            } else {
                setMinimumHeight(m23987g(view));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view;
        super.onLayout(z, i, i2, i3, i4);
        WindowInsetsCompat windowInsetsCompat = this.f33972d;
        if (windowInsetsCompat != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i6 = 0; i6 < childCount2; i6++) {
            m23973a(getChildAt(i6)).mo88584a();
        }
        if (this.f33983q && (view = this.f33977k) != null) {
            boolean z2 = true;
            boolean z3 = ViewCompat.isAttachedToWindow(view) && this.f33977k.getVisibility() == 0;
            this.f33984r = z3;
            if (z3) {
                if (ViewCompat.getLayoutDirection(this) != 1) {
                    z2 = false;
                }
                m23978a(z2);
                this.f33969a.setExpandedBounds(z2 ? this.f33980n : this.f33978l, this.f33982p.top + this.f33979m, (i3 - i) - (z2 ? this.f33978l : this.f33980n), (i4 - i2) - this.f33981o);
                this.f33969a.recalculate();
            }
        }
        if (this.f33975i != null && this.f33983q && TextUtils.isEmpty(this.f33969a.getText())) {
            setTitle(m23986f(this.f33975i));
        }
        mo88513a();
        int childCount3 = getChildCount();
        for (int i7 = 0; i7 < childCount3; i7++) {
            m23973a(getChildAt(i7)).mo88587b();
        }
    }

    /* renamed from: a */
    private void m23978a(boolean z) {
        View view = this.f33976j;
        if (view == null) {
            view = this.f33975i;
        }
        int b = mo88514b(view);
        RFDescendantOffsetUtils.getDescendantRect(this, this.f33977k, this.f33982p);
        this.f33969a.setCollapsedBounds(this.f33982p.left + 0, this.f33982p.top + b + 0, this.f33982p.right + 0, this.f33982p.bottom + b + 0);
    }

    /* renamed from: f */
    private static CharSequence m23986f(View view) {
        if (view instanceof RFStandardTitleBar) {
            return ((RFStandardTitleBar) view).getTitle();
        }
        return null;
    }

    /* renamed from: g */
    private static int m23987g(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    /* renamed from: a */
    static C11588a m23973a(View view) {
        C11588a aVar = (C11588a) view.getTag(R.id.view_offset_helper);
        if (aVar != null) {
            return aVar;
        }
        C11588a aVar2 = new C11588a(view);
        view.setTag(R.id.view_offset_helper, aVar2);
        return aVar2;
    }

    public void setTitle(CharSequence charSequence) {
        this.f33969a.setText(charSequence);
        m23985e();
    }

    public CharSequence getTitle() {
        if (this.f33983q) {
            return this.f33969a.getText();
        }
        return null;
    }

    public void setTitleCollapseMode(int i) {
        this.f33992z = i;
        boolean b = m23979b();
        this.f33969a.setFadeModeEnabled(b);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            m23977a((AppBarLayout) parent);
        }
        if (b && this.f33985s == null) {
            getResources().getDimension(R.dimen.design_appbar_elevation);
        }
    }

    public int getTitleCollapseMode() {
        return this.f33992z;
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.f33983q) {
            this.f33983q = z;
            m23985e();
            m23982d();
            requestLayout();
        }
    }

    public boolean isTitleEnabled() {
        return this.f33983q;
    }

    public void setScrimsShown(boolean z) {
        setScrimsShown(z, ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    public void setScrimsShown(boolean z, boolean z2) {
        if (this.f33987u != z) {
            int i = 255;
            if (z2) {
                if (!z) {
                    i = 0;
                }
                m23974a(i);
            } else {
                if (!z) {
                    i = 0;
                }
                setScrimAlpha(i);
            }
            this.f33987u = z;
        }
    }

    /* renamed from: a */
    private void m23974a(int i) {
        m23980c();
        ValueAnimator valueAnimator = this.f33988v;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f33988v = valueAnimator2;
            valueAnimator2.setDuration(this.f33989w);
            this.f33988v.setInterpolator(i > this.f33986t ? RFAnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR : RFAnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
            this.f33988v.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RFCollapsingTitleBarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
        } else if (valueAnimator.isRunning()) {
            this.f33988v.cancel();
        }
        this.f33988v.setIntValues(new int[]{this.f33986t, i});
        this.f33988v.start();
    }

    /* access modifiers changed from: package-private */
    public void setScrimAlpha(int i) {
        ViewGroup viewGroup;
        if (i != this.f33986t) {
            if (!(this.f33985s == null || (viewGroup = this.f33975i) == null)) {
                ViewCompat.postInvalidateOnAnimation(viewGroup);
            }
            this.f33986t = i;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: package-private */
    public int getScrimAlpha() {
        return this.f33986t;
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.f33985s;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f33985s = drawable3;
            if (drawable3 != null) {
                m23975a(drawable3, getWidth(), getHeight());
                this.f33985s.setCallback(this);
                this.f33985s.setAlpha(this.f33986t);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public Drawable getContentScrim() {
        return this.f33985s;
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.f33970b;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f33970b = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f33970b.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.f33970b, ViewCompat.getLayoutDirection(this));
                this.f33970b.setVisible(getVisibility() == 0, false);
                this.f33970b.setCallback(this);
                this.f33970b.setAlpha(this.f33986t);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f33970b;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f33985s;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        RFCollapsingTextHelper rFCollapsingTextHelper = this.f33969a;
        if (rFCollapsingTextHelper != null) {
            z |= rFCollapsingTextHelper.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f33985s || drawable == this.f33970b;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.f33970b;
        if (!(drawable == null || drawable.isVisible() == z)) {
            this.f33970b.setVisible(z, false);
        }
        Drawable drawable2 = this.f33985s;
        if (drawable2 != null && drawable2.isVisible() != z) {
            this.f33985s.setVisible(z, false);
        }
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public Drawable getStatusBarScrim() {
        return this.f33970b;
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.f33969a.setCollapsedTextAppearance(i);
    }

    public void setCollapsingTextSize(float f) {
        this.f33969a.setCollapsedTextSize(f);
    }

    public void setExpandedTextSize(float f) {
        this.f33969a.setExpandedTextSize(f);
    }

    public void setCollapsedTitleTextColor(int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.f33969a.setCollapsedTextColor(colorStateList);
    }

    public void setCollapsedTitleGravity(int i) {
        this.f33969a.setCollapsedTextGravity(i);
    }

    public int getCollapsedTitleGravity() {
        return this.f33969a.getCollapsedTextGravity();
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.f33969a.setExpandedTextAppearance(i);
    }

    public void setExpandedTitleColor(int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.f33969a.setExpandedTextColor(colorStateList);
    }

    public void setExpandedTitleGravity(int i) {
        this.f33969a.setExpandedTextGravity(i);
    }

    public int getExpandedTitleGravity() {
        return this.f33969a.getExpandedTextGravity();
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f33969a.setCollapsedTypeface(typeface);
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f33969a.getCollapsedTypeface();
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f33969a.setExpandedTypeface(typeface);
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f33969a.getExpandedTypeface();
    }

    public void setExpandedTitleMargin(int i, int i2, int i3, int i4) {
        this.f33978l = i;
        this.f33979m = i2;
        this.f33980n = i3;
        this.f33981o = i4;
        requestLayout();
    }

    public int getExpandedTitleMarginStart() {
        return this.f33978l;
    }

    public void setExpandedTitleMarginStart(int i) {
        this.f33978l = i;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.f33979m;
    }

    public void setExpandedTitleMarginTop(int i) {
        this.f33979m = i;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.f33980n;
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.f33980n = i;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f33981o;
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.f33981o = i;
        requestLayout();
    }

    public void setMaxLines(int i) {
        this.f33969a.setMaxLines(i);
    }

    public int getMaxLines() {
        return this.f33969a.getMaxLines();
    }

    public int getLineCount() {
        return this.f33969a.getLineCount();
    }

    public void setScrimVisibleHeightTrigger(int i) {
        if (this.f33990x != i) {
            this.f33990x = i;
            mo88513a();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        int i = this.f33990x;
        if (i >= 0) {
            return i;
        }
        WindowInsetsCompat windowInsetsCompat = this.f33972d;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight > 0) {
            return Math.min((minimumHeight * 2) + systemWindowInsetTop, getHeight());
        }
        return getHeight() / 3;
    }

    public void setScrimAnimationDuration(long j) {
        this.f33989w = j;
    }

    public long getScrimAnimationDuration() {
        return this.f33989w;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
        int collapseMode = 0;
        float parallaxMult = 0.5f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.CollapsingToolbarLayout_Layout);
            this.collapseMode = obtainStyledAttributes.getInt(0, 0);
            setParallaxMultiplier(obtainStyledAttributes.getFloat(1, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public void setCollapseMode(int i) {
            this.collapseMode = i;
        }

        public int getCollapseMode() {
            return this.collapseMode;
        }

        public void setParallaxMultiplier(float f) {
            this.parallaxMult = f;
        }

        public float getParallaxMultiplier() {
            return this.parallaxMult;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo88513a() {
        if (this.f33985s != null || this.f33970b != null) {
            setScrimsShown(getHeight() + this.f33971c < getScrimVisibleHeightTrigger());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final int mo88514b(View view) {
        return ((getHeight() - m23973a(view).mo88592e()) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    /* renamed from: e */
    private void m23985e() {
        setContentDescription(getTitle());
    }

    private class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        OffsetUpdateListener() {
        }

        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            RFCollapsingTitleBarLayout.this.f33971c = i;
            int systemWindowInsetTop = RFCollapsingTitleBarLayout.this.f33972d != null ? RFCollapsingTitleBarLayout.this.f33972d.getSystemWindowInsetTop() : 0;
            int childCount = RFCollapsingTitleBarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = RFCollapsingTitleBarLayout.this.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                C11588a a = RFCollapsingTitleBarLayout.m23973a(childAt);
                int i3 = layoutParams.collapseMode;
                if (i3 == 1) {
                    a.mo88586a(MathUtils.clamp(-i, 0, RFCollapsingTitleBarLayout.this.mo88514b(childAt)));
                } else if (i3 == 2) {
                    a.mo88586a(Math.round(((float) (-i)) * layoutParams.parallaxMult));
                }
            }
            RFCollapsingTitleBarLayout.this.mo88513a();
            if (RFCollapsingTitleBarLayout.this.f33970b != null && systemWindowInsetTop > 0) {
                ViewCompat.postInvalidateOnAnimation(RFCollapsingTitleBarLayout.this);
            }
            int height = RFCollapsingTitleBarLayout.this.getHeight();
            int minimumHeight = (height - ViewCompat.getMinimumHeight(RFCollapsingTitleBarLayout.this)) - systemWindowInsetTop;
            float f = (float) minimumHeight;
            RFCollapsingTitleBarLayout.this.f33969a.setFadeModeStartFraction(Math.min(1.0f, ((float) (height - RFCollapsingTitleBarLayout.this.getScrimVisibleHeightTrigger())) / f));
            RFCollapsingTitleBarLayout.this.f33969a.setCurrentOffsetY(RFCollapsingTitleBarLayout.this.f33971c + minimumHeight);
            RFCollapsingTitleBarLayout.this.f33969a.setExpansionFraction(((float) Math.abs(i)) / f);
        }
    }
}
