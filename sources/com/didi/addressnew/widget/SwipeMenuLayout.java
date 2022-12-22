package com.didi.addressnew.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.didi.passenger.C10448R;

public class SwipeMenuLayout extends ViewGroup {

    /* renamed from: a */
    private static final String f7689a = "SwipeMenuLayout";

    /* renamed from: i */
    private static SwipeMenuLayout f7690i;

    /* renamed from: b */
    private final Context f7691b;

    /* renamed from: c */
    private int f7692c;

    /* renamed from: d */
    private int f7693d;

    /* renamed from: e */
    private View f7694e;

    /* renamed from: f */
    private int f7695f;

    /* renamed from: g */
    private float f7696g;

    /* renamed from: h */
    private float f7697h;

    /* renamed from: j */
    private int f7698j;

    /* renamed from: k */
    private VelocityTracker f7699k;

    /* renamed from: l */
    private boolean f7700l;

    /* renamed from: m */
    private ValueAnimator f7701m;

    /* renamed from: n */
    private ValueAnimator f7702n;

    /* renamed from: o */
    private int f7703o;

    /* renamed from: p */
    private boolean f7704p;

    /* renamed from: q */
    private boolean f7705q;

    /* renamed from: r */
    private boolean f7706r;

    /* renamed from: s */
    private boolean f7707s;

    /* renamed from: t */
    private boolean f7708t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public SwipeMenuStateListener f7709u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f7710v;

    public interface SwipeMenuStateListener {
        void menuIsOpen(boolean z);
    }

    public SwipeMenuLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7696g = 0.0f;
        this.f7697h = 0.0f;
        this.f7700l = false;
        this.f7703o = 300;
        this.f7704p = false;
        this.f7705q = true;
        this.f7706r = true;
        this.f7707s = false;
        this.f7708t = false;
        this.f7710v = false;
        this.f7691b = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.SwipeMenuLayout, i, 0);
        this.f7706r = obtainStyledAttributes.getBoolean(2, true);
        this.f7707s = obtainStyledAttributes.getBoolean(1, false);
        this.f7705q = obtainStyledAttributes.getBoolean(3, true);
        this.f7708t = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        m4856a();
    }

    /* renamed from: a */
    private void m4856a() {
        this.f7692c = ViewConfiguration.get(this.f7691b).getScaledTouchSlop();
        this.f7693d = ViewConfiguration.get(this.f7691b).getScaledMaximumFlingVelocity();
        setClickable(true);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        this.f7695f = 0;
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (i5 == 0) {
                    layoutParams.width = getMeasuredWidth();
                    this.f7694e = childAt;
                }
                measureChild(childAt, i, i2);
                if (mode != 1073741824) {
                    i3 = Math.max(i3, childAt.getMeasuredHeight());
                }
                if (i5 == 0) {
                    i4 = childAt.getMeasuredWidth();
                } else {
                    this.f7695f += childAt.getMeasuredWidth();
                }
            }
        }
        setMeasuredDimension(i4, Math.max(getMeasuredHeight(), i3));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                if (i7 == 0) {
                    childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                    measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
                } else if (this.f7707s) {
                    childAt.layout(i6 - childAt.getMeasuredWidth(), paddingTop, i6, childAt.getMeasuredHeight() + paddingTop);
                    i6 -= childAt.getMeasuredWidth();
                } else {
                    childAt.layout(i5, paddingTop, childAt.getMeasuredWidth() + i5, childAt.getMeasuredHeight() + paddingTop);
                    measuredWidth = childAt.getMeasuredWidth();
                }
                i5 += measuredWidth;
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f7697h = motionEvent.getRawX();
            getParent().requestDisallowInterceptTouchEvent(false);
            this.f7704p = false;
            SwipeMenuLayout swipeMenuLayout = f7690i;
            if (swipeMenuLayout != null) {
                if (swipeMenuLayout != this) {
                    swipeMenuLayout.closeMenuAnim();
                    this.f7704p = this.f7705q;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if (action == 1 || action == 3) {
            this.f7700l = false;
            if (Math.abs(getScrollX()) == Math.abs(this.f7695f)) {
                if ((!this.f7707s || motionEvent.getX() >= ((float) this.f7695f)) && (this.f7707s || motionEvent.getX() <= ((float) (getMeasuredWidth() - this.f7695f)))) {
                    closeMenuAnim();
                } else if (this.f7708t) {
                    closeMenuAnim();
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f7706r) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && Math.abs(motionEvent.getRawX() - this.f7697h) >= ((float) this.f7692c)) {
                m4858a(false);
                return true;
            }
        } else if (this.f7700l) {
            return true;
        } else {
            this.f7700l = true;
            this.f7698j = motionEvent.getPointerId(0);
            this.f7696g = motionEvent.getRawX();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        if (r0 != 3) goto L_0x013c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.f7706r
            if (r0 != 0) goto L_0x0009
            boolean r10 = super.onTouchEvent(r10)
            return r10
        L_0x0009:
            r9.m4857a((android.view.MotionEvent) r10)
            int r0 = r10.getAction()
            r1 = 1
            if (r0 == r1) goto L_0x0084
            r2 = 2
            if (r0 == r2) goto L_0x001b
            r2 = 3
            if (r0 == r2) goto L_0x0084
            goto L_0x013c
        L_0x001b:
            boolean r0 = r9.f7704p
            if (r0 == 0) goto L_0x0021
            goto L_0x013c
        L_0x0021:
            float r0 = r9.f7696g
            float r2 = r10.getRawX()
            float r0 = r0 - r2
            int r2 = (int) r0
            r3 = 0
            r9.scrollBy(r2, r3)
            float r0 = java.lang.Math.abs(r0)
            int r2 = r9.f7692c
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0044
            int r0 = r9.getScrollX()
            int r0 = java.lang.Math.abs(r0)
            int r2 = r9.f7692c
            if (r0 <= r2) goto L_0x004b
        L_0x0044:
            android.view.ViewParent r0 = r9.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
        L_0x004b:
            boolean r0 = r9.f7707s
            if (r0 == 0) goto L_0x0067
            int r0 = r9.getScrollX()
            int r1 = r9.f7695f
            int r2 = -r1
            if (r0 >= r2) goto L_0x005d
            int r0 = -r1
            r9.scrollTo(r0, r3)
            goto L_0x007c
        L_0x005d:
            int r0 = r9.getScrollX()
            if (r0 <= 0) goto L_0x007c
            r9.scrollTo(r3, r3)
            goto L_0x007c
        L_0x0067:
            int r0 = r9.getScrollX()
            if (r0 >= 0) goto L_0x0071
            r9.scrollTo(r3, r3)
            goto L_0x007c
        L_0x0071:
            int r0 = r9.getScrollX()
            int r1 = r9.f7695f
            if (r0 <= r1) goto L_0x007c
            r9.scrollTo(r1, r3)
        L_0x007c:
            float r0 = r10.getRawX()
            r9.f7696g = r0
            goto L_0x013c
        L_0x0084:
            android.view.VelocityTracker r0 = r9.f7699k
            r2 = 1000(0x3e8, float:1.401E-42)
            int r3 = r9.f7693d
            float r3 = (float) r3
            r0.computeCurrentVelocity(r2, r3)
            android.view.VelocityTracker r0 = r9.f7699k
            int r2 = r9.f7698j
            float r0 = r0.getXVelocity(r2)
            r9.m4860b()
            boolean r2 = r9.f7704p
            if (r2 != 0) goto L_0x013c
            float r2 = r10.getRawX()
            float r3 = r9.f7697h
            float r2 = r2 - r3
            float r2 = java.lang.Math.abs(r2)
            int r3 = r9.f7692c
            float r3 = (float) r3
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x013c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = "onTouchEvent: "
            r10.append(r2)
            r10.append(r0)
            java.lang.String r5 = r10.toString()
            r3 = 3
            r6 = 0
            r8 = 292(0x124, float:4.09E-43)
            java.lang.String r4 = "SwipeMenuLayout"
            java.lang.String r7 = "com.didi.addressnew.widget.SwipeMenuLayout"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
            float r10 = java.lang.Math.abs(r0)
            r2 = 1159479296(0x451c4000, float:2500.0)
            int r10 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r10 <= 0) goto L_0x00f5
            r10 = -988004352(0xffffffffc51c4000, float:-2500.0)
            int r10 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r10 >= 0) goto L_0x00e9
            boolean r10 = r9.f7707s
            if (r10 != 0) goto L_0x00e5
            r9.expandMenuAnim()
            goto L_0x013b
        L_0x00e5:
            r9.closeMenuAnim()
            goto L_0x013b
        L_0x00e9:
            boolean r10 = r9.f7707s
            if (r10 != 0) goto L_0x00f1
            r9.closeMenuAnim()
            goto L_0x013b
        L_0x00f1:
            r9.expandMenuAnim()
            goto L_0x013b
        L_0x00f5:
            int r10 = r9.getScrollX()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "scrollX = "
            r0.append(r2)
            r0.append(r10)
            java.lang.String r5 = r0.toString()
            r3 = 3
            r6 = 0
            r8 = 315(0x13b, float:4.41E-43)
            java.lang.String r4 = "david"
            java.lang.String r7 = "com.didi.addressnew.widget.SwipeMenuLayout"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
            int r10 = r9.getScrollX()
            int r10 = java.lang.Math.abs(r10)
            double r2 = (double) r10
            int r10 = r9.f7695f
            double r4 = (double) r10
            r6 = 4596373779694328218(0x3fc999999999999a, double:0.2)
            double r4 = r4 * r6
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 <= 0) goto L_0x0138
            boolean r10 = r9.f7710v
            if (r10 == 0) goto L_0x0134
            r9.closeMenuAnim()
            goto L_0x013b
        L_0x0134:
            r9.expandMenuAnim()
            goto L_0x013b
        L_0x0138:
            r9.closeMenuAnim()
        L_0x013b:
            return r1
        L_0x013c:
            boolean r10 = super.onTouchEvent(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.addressnew.widget.SwipeMenuLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    private void m4857a(MotionEvent motionEvent) {
        if (this.f7699k == null) {
            this.f7699k = VelocityTracker.obtain();
        }
        this.f7699k.addMovement(motionEvent);
    }

    /* renamed from: b */
    private void m4860b() {
        VelocityTracker velocityTracker = this.f7699k;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f7699k.recycle();
            this.f7699k = null;
        }
    }

    public void expandMenuAnim() {
        m4858a(false);
        m4862c();
        f7690i = this;
        int[] iArr = new int[2];
        iArr[0] = getScrollX();
        iArr[1] = this.f7707s ? -this.f7695f : this.f7695f;
        ValueAnimator ofInt = ValueAnimator.ofInt(iArr);
        this.f7701m = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            }
        });
        this.f7701m.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                boolean unused = SwipeMenuLayout.this.f7710v = true;
                if (SwipeMenuLayout.this.f7709u != null) {
                    SwipeMenuLayout.this.f7709u.menuIsOpen(true);
                }
            }
        });
        this.f7701m.setInterpolator(new OvershootInterpolator());
        this.f7701m.setDuration((long) this.f7703o).start();
    }

    public void closeMenuAnim() {
        f7690i = null;
        m4862c();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{getScrollX(), 0});
        this.f7702n = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            }
        });
        this.f7702n.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                boolean unused = SwipeMenuLayout.this.f7710v = false;
                SwipeMenuLayout.this.m4858a(true);
                if (SwipeMenuLayout.this.f7709u != null) {
                    SwipeMenuLayout.this.f7709u.menuIsOpen(false);
                }
            }
        });
        this.f7702n.setInterpolator(new AccelerateInterpolator());
        this.f7702n.setDuration((long) this.f7703o).start();
    }

    /* renamed from: c */
    private void m4862c() {
        ValueAnimator valueAnimator = this.f7702n;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f7702n.cancel();
        }
        ValueAnimator valueAnimator2 = this.f7701m;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.f7701m.cancel();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (getScrollX() != 0) {
            quickCloseMenu();
            f7690i = null;
        }
        super.onDetachedFromWindow();
    }

    public void quickCloseMenu() {
        if (getScrollX() != 0) {
            m4862c();
            scrollTo(0, 0);
            f7690i = null;
        }
    }

    public void quickExpandMenu() {
        if (getScrollX() == 0) {
            m4862c();
            scrollTo(this.f7707s ? -this.f7695f : this.f7695f, 0);
            f7690i = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4858a(boolean z) {
        setLongClickable(z);
    }

    public boolean performLongClick() {
        if (getScrollX() != 0) {
            return true;
        }
        return super.performLongClick();
    }

    public SwipeMenuLayout getCacheView() {
        return f7690i;
    }

    public boolean isExpandMenu() {
        return Math.abs(getScaleX()) >= ((float) this.f7695f);
    }

    public boolean isOpenChoke() {
        return this.f7705q;
    }

    public SwipeMenuLayout setOpenChoke(boolean z) {
        this.f7705q = z;
        return this;
    }

    public boolean isEnableSwipe() {
        return this.f7706r;
    }

    public SwipeMenuLayout setEnableSwipe(boolean z) {
        this.f7706r = z;
        return this;
    }

    public boolean isEnableLeftMenu() {
        return this.f7707s;
    }

    public SwipeMenuLayout setEnableLeftMenu(boolean z) {
        this.f7707s = z;
        return this;
    }

    public boolean isClickMenuAndClose() {
        return this.f7708t;
    }

    public SwipeMenuLayout setClickMenuAndClose(boolean z) {
        this.f7708t = z;
        return this;
    }

    public SwipeMenuLayout setSwipeMenuStateListener(SwipeMenuStateListener swipeMenuStateListener) {
        this.f7709u = swipeMenuStateListener;
        return this;
    }
}
