package com.didi.app.nova.support.view.pullToRefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Scroller;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.didi.passenger.C10448R;
import com.didi.sdk.apm.SystemUtils;

public class NovaPullRefreshLayout extends ViewGroup implements NestedScrollingParent {

    /* renamed from: a */
    private static final String f8549a = "NovaPullRefreshLayout";

    /* renamed from: b */
    private static final int f8550b = -1;

    /* renamed from: c */
    private static final int f8551c = 0;

    /* renamed from: d */
    private static final int f8552d = 1;

    /* renamed from: e */
    private static final int f8553e = 2;

    /* renamed from: f */
    private static final int f8554f = 4;

    /* renamed from: g */
    private static final int f8555g = 8;

    /* renamed from: h */
    private static final float f8556h = 0.4f;

    /* renamed from: A */
    private float f8557A;

    /* renamed from: B */
    private float f8558B;

    /* renamed from: C */
    private float f8559C;

    /* renamed from: D */
    private float f8560D;

    /* renamed from: E */
    private float f8561E;

    /* renamed from: F */
    private View f8562F;

    /* renamed from: G */
    private View f8563G;

    /* renamed from: H */
    private IRefreshView f8564H;

    /* renamed from: I */
    private Scroller f8565I;

    /* renamed from: J */
    private VelocityTracker f8566J;

    /* renamed from: K */
    private PullRefreshListener f8567K;

    /* renamed from: L */
    private IRefreshOffsetCalculator f8568L;

    /* renamed from: M */
    private final NestedScrollingParentHelper f8569M;

    /* renamed from: i */
    private boolean f8570i;

    /* renamed from: j */
    private boolean f8571j;

    /* renamed from: k */
    private boolean f8572k;

    /* renamed from: l */
    private boolean f8573l;

    /* renamed from: m */
    private boolean f8574m;

    /* renamed from: n */
    private boolean f8575n;

    /* renamed from: o */
    private boolean f8576o;

    /* renamed from: p */
    private boolean f8577p;

    /* renamed from: q */
    private int f8578q;

    /* renamed from: r */
    private int f8579r;

    /* renamed from: s */
    private int f8580s;

    /* renamed from: t */
    private final int f8581t;

    /* renamed from: u */
    private int f8582u;

    /* renamed from: v */
    private int f8583v;

    /* renamed from: w */
    private int f8584w;

    /* renamed from: x */
    private int f8585x;

    /* renamed from: y */
    private float f8586y;

    /* renamed from: z */
    private float f8587z;

    public NovaPullRefreshLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public NovaPullRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NovaPullRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8570i = false;
        this.f8572k = false;
        this.f8574m = false;
        this.f8575n = false;
        this.f8576o = true;
        this.f8577p = false;
        this.f8578q = -1;
        this.f8580s = 0;
        this.f8581t = 0;
        this.f8585x = -1;
        this.f8586y = 1.0f;
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f8560D = (float) viewConfiguration.getScaledMaximumFlingVelocity();
        this.f8561E = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.f8579r = viewConfiguration.getScaledTouchSlop();
        Scroller scroller = new Scroller(getContext());
        this.f8565I = scroller;
        scroller.setFriction(getScrollerFriction());
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        this.f8569M = new NestedScrollingParentHelper(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.NovaPullRefreshLayout, i, 0);
            setAutoRefreshThresholdPercent(obtainStyledAttributes.getFloat(0, this.f8586y));
            setEnableOverPull(obtainStyledAttributes.getBoolean(2, this.f8576o));
            this.f8577p = obtainStyledAttributes.getBoolean(1, this.f8577p);
            setRefreshViewOffsetFixedWhenRefreshing(obtainStyledAttributes.getBoolean(3, this.f8575n));
            obtainStyledAttributes.recycle();
        }
    }

    public void setAutoRefreshThresholdPercent(float f) {
        this.f8586y = f;
        if (f > 1.0f) {
            this.f8586y = 1.0f;
        }
        if (this.f8586y < 0.0f) {
            this.f8586y = 0.0f;
        }
    }

    public void setEnableOverPull(boolean z) {
        this.f8576o = z;
    }

    public void setRefreshViewOffsetFixedWhenRefreshing(boolean z) {
        this.f8575n = z;
    }

    public static boolean defaultCanScrollUp(View view) {
        return view != null && ViewCompat.canScrollVertically(view, -1);
    }

    public void setPullRefreshListener(PullRefreshListener pullRefreshListener) {
        this.f8567K = pullRefreshListener;
    }

    public void setRefreshOffsetCalculator(IRefreshOffsetCalculator iRefreshOffsetCalculator) {
        this.f8568L = iRefreshOffsetCalculator;
    }

    /* access modifiers changed from: protected */
    public float getScrollerFriction() {
        return ViewConfiguration.getScrollFriction();
    }

    public void setRefreshView(View view) {
        setRefreshView(view, (ViewGroup.LayoutParams) null);
    }

    public void setRefreshView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof IRefreshView) {
            View view2 = this.f8563G;
            if (view2 != null) {
                removeView(view2);
            }
            this.f8563G = view;
            this.f8564H = (IRefreshView) view;
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
            }
            addView(this.f8563G, layoutParams);
            return;
        }
        throw new RuntimeException("refreshView must be a instance of IRefreshView");
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        if (!this.f8577p) {
            return super.getChildDrawingOrder(i, i2);
        }
        int i3 = this.f8578q;
        if (i3 < 0) {
            return i2;
        }
        if (i2 == i3) {
            return i - 1;
        }
        return i2 > i3 ? i2 - 1 : i2;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.f8562F instanceof AbsListView)) {
            View view = this.f8562F;
            if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() != 0) {
            m5694a();
            if (this.f8562F == null) {
                m5697a("onMeasure: mTargetView == null");
                return;
            }
            this.f8562F.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.f8578q = -1;
            View view = this.f8563G;
            if (view == null) {
                m5697a("onMeasure: mRefreshView == null");
                return;
            }
            measureChild(view, i, i2);
            int i3 = 0;
            while (true) {
                if (i3 >= getChildCount()) {
                    break;
                } else if (getChildAt(i3) == this.f8563G) {
                    this.f8578q = i3;
                    break;
                } else {
                    i3++;
                }
            }
            int measuredHeight = this.f8563G.getMeasuredHeight();
            if (measuredHeight != this.f8583v) {
                this.f8583v = measuredHeight;
                if (!this.f8571j && !this.f8572k && !this.f8573l) {
                    this.f8584w = -measuredHeight;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() != 0) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            m5694a();
            if (this.f8562F == null) {
                m5697a("onLayout: mTargetView == null");
                return;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingLeft2 = (measuredWidth - getPaddingLeft()) - getPaddingRight();
            int paddingTop2 = (measuredHeight - getPaddingTop()) - getPaddingBottom();
            View view = this.f8562F;
            int i5 = this.f8582u;
            view.layout(paddingLeft, paddingTop + i5, paddingLeft2 + paddingLeft, paddingTop + paddingTop2 + i5);
            View view2 = this.f8563G;
            if (view2 == null) {
                m5697a("onLayout: mRefreshView == null");
                return;
            }
            int measuredWidth2 = view2.getMeasuredWidth();
            int measuredHeight2 = this.f8563G.getMeasuredHeight();
            int i6 = measuredWidth / 2;
            int i7 = measuredWidth2 / 2;
            int i8 = this.f8584w;
            this.f8563G.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m5694a();
        int action = motionEvent.getAction();
        if (!isEnabled() || canChildScrollUp() || this.f8573l) {
            m5697a("fast end onIntercept: isEnabled = " + isEnabled() + "; canChildScrollUp = " + canChildScrollUp() + " ; mNestedScrollInProgress = " + this.f8573l);
            return false;
        }
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f8585x);
                    if (findPointerIndex < 0) {
                        m5700b("Got ACTION_MOVE event but have an invalid active pointer id.");
                        return false;
                    }
                    startDragging(motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex));
                } else if (action != 3) {
                    if (action == 6) {
                        m5696a(motionEvent);
                    }
                }
            }
            this.f8571j = false;
            this.f8585x = -1;
        } else {
            this.f8571j = false;
            int pointerId = motionEvent.getPointerId(0);
            this.f8585x = pointerId;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.f8557A = motionEvent.getX(findPointerIndex2);
            this.f8587z = motionEvent.getY(findPointerIndex2);
        }
        return this.f8571j;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (!isEnabled() || canChildScrollUp() || this.f8573l) {
            m5697a("fast end onTouchEvent: isEnabled = " + isEnabled() + "; canChildScrollUp = " + canChildScrollUp() + " ; mNestedScrollInProgress = " + this.f8573l);
            return false;
        }
        m5699b(motionEvent);
        if (action != 0) {
            float f = 0.0f;
            if (action != 1) {
                if (action == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f8585x);
                    if (findPointerIndex < 0) {
                        m5700b("onTouchEvent Got ACTION_MOVE event but have an invalid active pointer id.");
                        return false;
                    }
                    float x = motionEvent.getX(findPointerIndex);
                    float y = motionEvent.getY(findPointerIndex);
                    startDragging(x, y);
                    if (this.f8571j) {
                        float f2 = y - this.f8559C;
                        if (f2 >= 0.0f) {
                            m5691a(f2, true);
                        } else {
                            float abs = Math.abs(f2) - ((float) Math.abs(m5691a(f2, true)));
                            if (abs > 0.0f) {
                                motionEvent.setAction(0);
                                float f3 = (float) (this.f8579r + 1);
                                if (abs <= f3) {
                                    abs = f3;
                                }
                                motionEvent.offsetLocation(0.0f, abs);
                                dispatchTouchEvent(motionEvent);
                                motionEvent.setAction(action);
                                motionEvent.offsetLocation(0.0f, -abs);
                                dispatchTouchEvent(motionEvent);
                            }
                        }
                        this.f8559C = y;
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                        if (actionIndex < 0) {
                            m5700b("Got ACTION_POINTER_DOWN event but have an invalid action index.");
                            return false;
                        }
                        this.f8585x = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        m5696a(motionEvent);
                    }
                }
            }
            if (motionEvent.findPointerIndex(this.f8585x) < 0) {
                m5700b("Got ACTION_UP or ACTION_CANCEL event but don't have an active pointer id.");
                return false;
            }
            if (this.f8571j) {
                this.f8571j = false;
                this.f8566J.computeCurrentVelocity(1000, this.f8560D);
                float yVelocity = this.f8566J.getYVelocity(this.f8585x);
                if (Math.abs(yVelocity) >= this.f8561E) {
                    f = yVelocity;
                }
                m5695a((int) f);
            }
            this.f8585x = -1;
            m5698b();
            return false;
        }
        this.f8571j = false;
        this.f8580s = 0;
        if (!this.f8565I.isFinished()) {
            this.f8565I.abortAnimation();
        }
        this.f8585x = motionEvent.getPointerId(0);
        return true;
    }

    /* renamed from: a */
    private void m5694a() {
        if (this.f8562F == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.f8563G)) {
                    if (this.f8562F == null) {
                        this.f8562F = childAt;
                    } else {
                        throw new IllegalStateException("PullRefreshLayout 除去 RefreshView 以外应该只有一个子 View");
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m5695a(int i) {
        m5697a("finishPull: vy = " + i + " ; mTargetCurrentOffset = " + this.f8582u + " ; mTargetRefreshOffset = " + this.f8583v + " ; mTargetInitOffset = " + 0 + " ; mScroller.isFinished() = " + this.f8565I.isFinished());
        if (((float) this.f8582u) >= this.f8586y * ((float) this.f8583v)) {
            this.f8580s = 12;
        } else {
            this.f8580s = 1;
        }
        invalidate();
        IRefreshView iRefreshView = this.f8564H;
        if (iRefreshView != null) {
            iRefreshView.onRelease(m5701b(8));
        }
    }

    /* access modifiers changed from: protected */
    public void onRefresh() {
        if (!this.f8572k) {
            this.f8572k = true;
            IRefreshView iRefreshView = this.f8564H;
            if (iRefreshView != null) {
                iRefreshView.onPullToRefresh();
            }
            PullRefreshListener pullRefreshListener = this.f8567K;
            if (pullRefreshListener != null) {
                pullRefreshListener.onPullToRefresh();
            }
        }
    }

    public void dismissPullToRefresh() {
        this.f8572k = false;
        IRefreshView iRefreshView = this.f8564H;
        if (iRefreshView != null) {
            iRefreshView.onComplete();
        }
        this.f8580s = 2;
        this.f8565I.forceFinished(true);
        invalidate();
    }

    /* renamed from: a */
    private void m5696a(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (motionEvent.getPointerId(actionIndex) == this.f8585x) {
            this.f8585x = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    public void reset() {
        m5692a(0, false);
        IRefreshView iRefreshView = this.f8564H;
        if (iRefreshView != null) {
            iRefreshView.onReset();
        }
        this.f8572k = false;
        this.f8565I.forceFinished(true);
        this.f8580s = 1;
    }

    /* access modifiers changed from: protected */
    public void startDragging(float f, float f2) {
        if (!this.f8572k || !this.f8575n) {
            float f3 = f - this.f8557A;
            float f4 = f2 - this.f8587z;
            if (isYDrag(f3, f4)) {
                int i = this.f8579r;
                if ((f4 > ((float) i) || (f4 < ((float) (-i)) && this.f8582u > 0)) && !this.f8571j) {
                    float f5 = this.f8587z + ((float) this.f8579r);
                    this.f8558B = f5;
                    this.f8559C = f5;
                    this.f8571j = true;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isYDrag(float f, float f2) {
        return Math.abs(f2) > Math.abs(f);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            reset();
            invalidate();
        }
    }

    public boolean canChildScrollUp() {
        return defaultCanScrollUp(this.f8562F);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        m5697a("onStartNestedScroll: nestedScrollAxes = " + i);
        return isEnabled() && (i & 2) != 0 && (!this.f8572k || !this.f8575n);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        m5697a("onNestedScrollAccepted: axes = " + i);
        this.f8569M.onNestedScrollAccepted(view, view2, i);
        this.f8573l = true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        m5697a("onNestedPreScroll: dx = " + i + " ; dy = " + i2);
        int i3 = this.f8582u - 0;
        if (i2 > 0 && i3 > 0) {
            if (i2 >= i3) {
                iArr[1] = i3;
                m5692a(0, true);
                return;
            }
            iArr[1] = i2;
            m5691a((float) (-i2), true);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        m5697a("onNestedScroll: dxConsumed = " + i + " ; dyConsumed = " + i2 + " ; dxUnconsumed = " + i3 + " ; dyUnconsumed = " + i4);
        if (i4 < 0 && !canChildScrollUp()) {
            m5691a((float) (-i4), true);
        }
    }

    public int getNestedScrollAxes() {
        return this.f8569M.getNestedScrollAxes();
    }

    public void onStopNestedScroll(View view) {
        m5697a("onStopNestedScroll: mNestedScrollInProgress = " + this.f8573l);
        this.f8569M.onStopNestedScroll(view);
        if (this.f8573l) {
            this.f8573l = false;
            if (this.f8570i) {
                m5695a(0);
            }
        }
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        m5697a("onNestedPreFling: mTargetCurrentOffset = " + this.f8582u + " ; velocityX = " + f + " ; velocityY = " + f2);
        if (this.f8582u <= 0) {
            return false;
        }
        this.f8573l = false;
        m5695a((int) (-f2));
        return true;
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        try {
            return super.onNestedFling(view, f, f2, z);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    private int m5691a(float f, boolean z) {
        return m5692a((int) (((float) this.f8582u) + (f * 0.4f)), z);
    }

    /* renamed from: a */
    private int m5692a(int i, boolean z) {
        return m5693a(i, z, false);
    }

    /* renamed from: a */
    private int m5693a(int i, boolean z, boolean z2) {
        int i2 = 0;
        if (!(this.f8562F == null || this.f8563G == null)) {
            int max = Math.max(i, 0);
            if (!this.f8576o) {
                max = Math.min(max, this.f8583v);
            }
            if (max != this.f8582u || z2) {
                if (z) {
                    this.f8570i = true;
                }
                i2 = max - this.f8582u;
                ViewCompat.offsetTopAndBottom(this.f8562F, i2);
                this.f8582u = max;
                PullRefreshListener pullRefreshListener = this.f8567K;
                if (pullRefreshListener != null) {
                    pullRefreshListener.onMoveTargetView(max);
                }
                if (this.f8568L == null) {
                    this.f8568L = new C3786a();
                }
                int height = this.f8563G.getHeight();
                int calculateRefreshOffset = this.f8568L.calculateRefreshOffset(this.f8563G.getHeight(), this.f8582u, this.f8583v);
                int i3 = this.f8584w;
                if (calculateRefreshOffset != i3) {
                    ViewCompat.offsetTopAndBottom(this.f8563G, calculateRefreshOffset - i3);
                    this.f8584w = calculateRefreshOffset;
                    IRefreshView iRefreshView = this.f8564H;
                    if (iRefreshView != null) {
                        iRefreshView.onMove(z, calculateRefreshOffset + height);
                    }
                    PullRefreshListener pullRefreshListener2 = this.f8567K;
                    if (pullRefreshListener2 != null) {
                        pullRefreshListener2.onMoveRefreshView(this.f8584w);
                    }
                }
            }
        }
        return i2;
    }

    /* renamed from: b */
    private void m5699b(MotionEvent motionEvent) {
        if (this.f8566J == null) {
            this.f8566J = VelocityTracker.obtain();
        }
        this.f8566J.addMovement(motionEvent);
    }

    /* renamed from: b */
    private void m5698b() {
        VelocityTracker velocityTracker = this.f8566J;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f8566J.recycle();
            this.f8566J = null;
        }
    }

    /* renamed from: b */
    private boolean m5701b(int i) {
        return (this.f8580s & i) == i;
    }

    /* renamed from: c */
    private void m5702c(int i) {
        this.f8580s = (~i) & this.f8580s;
    }

    public void computeScroll() {
        this.f8570i = false;
        if (this.f8565I.computeScrollOffset()) {
            m5692a(this.f8565I.getCurrY(), false);
            invalidate();
        } else if (m5701b(1)) {
            IRefreshView iRefreshView = this.f8564H;
            if (iRefreshView != null) {
                iRefreshView.onReset();
            }
            m5702c(1);
            int i = this.f8582u;
            if (i != 0) {
                this.f8565I.startScroll(0, i, 0, 0 - i);
            }
            invalidate();
        } else if (m5701b(2)) {
            m5702c(2);
            int i2 = this.f8582u;
            if (i2 != 0) {
                this.f8565I.startScroll(0, i2, 0, 0 - i2);
            }
            invalidate();
        } else if (m5701b(4)) {
            m5702c(4);
            int i3 = this.f8582u;
            int i4 = this.f8583v;
            if (i3 != i4) {
                this.f8565I.startScroll(0, i3, 0, i4 - i3);
            } else {
                m5693a(i4, false, true);
            }
            invalidate();
        } else if (m5701b(8)) {
            m5702c(8);
            m5693a(this.f8583v, false, true);
            onRefresh();
        }
    }

    /* renamed from: a */
    private void m5697a(String str) {
        SystemUtils.log(4, f8549a, str, (Throwable) null, "com.didi.app.nova.support.view.pullToRefresh.NovaPullRefreshLayout", 820);
    }

    /* renamed from: b */
    private void m5700b(String str) {
        SystemUtils.log(6, f8549a, str, (Throwable) null, "com.didi.app.nova.support.view.pullToRefresh.NovaPullRefreshLayout", 824);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f8574m = this.f8572k;
        } else if (this.f8574m) {
            if (action != 2) {
                this.f8574m = false;
            } else if (!this.f8572k) {
                this.f8574m = false;
                motionEvent.setAction(0);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
