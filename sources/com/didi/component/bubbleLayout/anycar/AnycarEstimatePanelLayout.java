package com.didi.component.bubbleLayout.anycar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnycarEstimatePanelLayout extends FrameLayout implements NestedScrollingParent {

    /* renamed from: A */
    private List<INestChildScrollChange> f11076A;

    /* renamed from: B */
    private INestChildDispatchTouchEvent f11077B;

    /* renamed from: C */
    private Map<Integer, OnNestOffsetChangedListener> f11078C = new ArrayMap();

    /* renamed from: D */
    private boolean f11079D = false;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public int f11080E = 0;

    /* renamed from: F */
    private boolean f11081F = false;

    /* renamed from: G */
    private int f11082G = 0;

    /* renamed from: H */
    private boolean f11083H = false;

    /* renamed from: I */
    private final Property<AnycarEstimatePanelLayout, Float> f11084I = new Property<AnycarEstimatePanelLayout, Float>(Float.class, "sheetTranslation") {
        public Float get(AnycarEstimatePanelLayout anycarEstimatePanelLayout) {
            return Float.valueOf(((float) AnycarEstimatePanelLayout.this.f11103s) - anycarEstimatePanelLayout.f11107w);
        }

        public void set(AnycarEstimatePanelLayout anycarEstimatePanelLayout, Float f) {
            anycarEstimatePanelLayout.m7504a(f.floatValue());
        }
    };

    /* renamed from: a */
    int f11085a = 0;

    /* renamed from: b */
    private final Logger f11086b = LoggerFactory.getLogger("AnycarEstimatePanelLayout");

    /* renamed from: c */
    private View f11087c;

    /* renamed from: d */
    private ObjectAnimator f11088d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ObjectAnimator f11089e;

    /* renamed from: f */
    private VelocityTracker f11090f;

    /* renamed from: g */
    private float f11091g;

    /* renamed from: h */
    private float f11092h;

    /* renamed from: i */
    private float f11093i;

    /* renamed from: j */
    private float f11094j;

    /* renamed from: k */
    private float f11095k;

    /* renamed from: l */
    private float f11096l = 0.0f;

    /* renamed from: m */
    private int f11097m = 300;

    /* renamed from: n */
    private int f11098n = 0;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f11099o = 3;

    /* renamed from: p */
    private int f11100p = 1;

    /* renamed from: q */
    private float f11101q = 1.0f;

    /* renamed from: r */
    private float f11102r = 1.0f;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f11103s = 0;

    /* renamed from: t */
    private int f11104t;

    /* renamed from: u */
    private boolean f11105u;

    /* renamed from: v */
    private boolean f11106v = true;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public float f11107w;

    /* renamed from: x */
    private boolean f11108x = false;

    /* renamed from: y */
    private boolean f11109y = true;

    /* renamed from: z */
    private boolean f11110z = true;

    public interface INestChildDispatchTouchEvent {
        void dispatchWrapperOrigineTouchEvent(MotionEvent motionEvent);

        void dispatchWrapperTouchEvent(MotionEvent motionEvent);
    }

    public interface INestChildScrollChange {
        void onFingerUp(float f);

        void onNestChildHorizationScroll(MotionEvent motionEvent, float f, float f2);

        void onNestChildScrollChange(float f, float f2);

        void onNestChildScrollRelease(float f, int i);

        void onNestScrollingState(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Scrolltate {
        public static final int SCROLL_STATE_DRAGGING = 0;
        public static final int SCROLL_STATE_SETTLING = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SheetDirection {
        public static final int ALL = 0;
        public static final int BOTTOM = 2;
        public static final int TOP = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShowState {
        public static final int EXTEND = 2;
        public static final int HIDE = 0;
        public static final int INIT = 3;
        public static final int PEEK = 1;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7512a(String str) {
        Logger logger = this.f11086b;
        logger.info("dongxt-panel---" + str, new Object[0]);
    }

    public AnycarEstimatePanelLayout(Context context) {
        super(context);
        m7503a();
    }

    public AnycarEstimatePanelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7503a();
    }

    public AnycarEstimatePanelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7503a();
    }

    public AnycarEstimatePanelLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m7503a();
    }

    /* renamed from: a */
    private void m7503a() {
        this.f11076A = new ArrayList();
        this.f11092h = (float) ViewConfiguration.get(getContext()).getScaledTouchSlop();
        m7512a("init mtouchslop " + this.f11092h);
        post(new Runnable() {
            public void run() {
                AnycarEstimatePanelLayout anycarEstimatePanelLayout = AnycarEstimatePanelLayout.this;
                int unused = anycarEstimatePanelLayout.f11103s = anycarEstimatePanelLayout.getMeasuredHeight();
                if (AnycarEstimatePanelLayout.this.f11085a != 0) {
                    AnycarEstimatePanelLayout anycarEstimatePanelLayout2 = AnycarEstimatePanelLayout.this;
                    int unused2 = anycarEstimatePanelLayout2.f11080E = anycarEstimatePanelLayout2.f11103s - AnycarEstimatePanelLayout.this.f11085a;
                }
                AnycarEstimatePanelLayout anycarEstimatePanelLayout3 = AnycarEstimatePanelLayout.this;
                anycarEstimatePanelLayout3.m7512a("init height " + AnycarEstimatePanelLayout.this.f11103s + "、 mLockTopTranslateY =" + AnycarEstimatePanelLayout.this.f11080E);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() <= 1) {
            this.f11087c = getChildAt(0);
            return;
        }
        throw new IllegalStateException("child must be 1!!!");
    }

    public void addView(View view) {
        if (getChildCount() < 1) {
            this.f11087c = view;
            super.addView(view);
            return;
        }
        throw new IllegalStateException("child must be 1!!!");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() < 1) {
            m7509a(view);
            this.f11087c = view;
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("child must be 1!!!");
    }

    class OnNestOffsetChangedListener implements AppBarLayout.OnOffsetChangedListener {
        int offsetY = 0;

        OnNestOffsetChangedListener() {
        }

        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            this.offsetY = i;
        }

        public int getOffsetY() {
            return Math.abs(this.offsetY);
        }
    }

    /* renamed from: a */
    private void m7509a(View view) {
        m7512a("deepSearchView == " + view.getClass());
        if (view instanceof AppBarLayout) {
            OnNestOffsetChangedListener onNestOffsetChangedListener = new OnNestOffsetChangedListener();
            this.f11078C.put(Integer.valueOf(view.hashCode()), onNestOffsetChangedListener);
            ((AppBarLayout) view).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) onNestOffsetChangedListener);
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i < viewGroup.getChildCount()) {
                    m7509a(viewGroup.getChildAt(i));
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f11090f = VelocityTracker.obtain();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearNestScrollChildCallback();
        this.f11090f.clear();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f11083H) {
            return true;
        }
        if (m7524b()) {
            return false;
        }
        if (!this.f11109y || m7526b(getChildAt(0), motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    /* renamed from: a */
    private boolean m7515a(View view, MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if ((rawX < ((float) iArr[0]) || rawX > ((float) (iArr[0] + view.getMeasuredWidth())) || rawY < ((float) iArr[1]) || rawY > ((float) (iArr[1] + view.getMeasuredHeight()))) && this.f11110z) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private boolean m7526b(View view, MotionEvent motionEvent) {
        Class<?> cls = view.getClass();
        int i = 0;
        if (cls.getSimpleName().equals(AnycarEstimatePanelLayout.class.getSimpleName())) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("getShowState", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(view, new Object[0]);
                if ((invoke instanceof Integer) && ((Integer) invoke).intValue() == 0) {
                    return false;
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
            return m7515a(view, motionEvent);
        } else if (!(view instanceof ViewGroup)) {
            return false;
        } else {
            boolean z = false;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    return z;
                }
                if (m7526b(viewGroup.getChildAt(i), motionEvent)) {
                    z = true;
                }
                i++;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r12) {
        /*
            r11 = this;
            boolean r0 = r11.f11083H
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r11.m7524b()
            if (r0 == 0) goto L_0x000d
            return r1
        L_0x000d:
            boolean r0 = r11.f11109y
            if (r0 == 0) goto L_0x01dc
            android.view.View r0 = r11.getChildAt(r1)
            if (r0 == 0) goto L_0x01dc
            android.view.View r0 = r11.getChildAt(r1)
            boolean r0 = r11.m7515a((android.view.View) r0, (android.view.MotionEvent) r12)
            r2 = 2
            if (r0 != 0) goto L_0x002a
            int r0 = r12.getAction()
            if (r0 == r2) goto L_0x002a
            goto L_0x01dc
        L_0x002a:
            r11.m7522b((android.view.MotionEvent) r12)
            int r0 = r12.getAction()
            r3 = 1
            if (r0 != 0) goto L_0x0068
            android.view.View r0 = r11.f11087c
            float r0 = r0.getTranslationY()
            r11.f11096l = r0
            int r0 = r11.getMeasuredHeight()
            r11.f11103s = r0
            r11.f11105u = r1
            float r0 = r12.getY()
            r11.f11093i = r0
            float r0 = r12.getX()
            r11.f11094j = r0
            int r0 = r11.f11103s
            float r0 = (float) r0
            float r4 = r11.f11096l
            float r0 = r0 - r4
            r11.f11107w = r0
            r11.f11095k = r0
            android.view.VelocityTracker r0 = r11.f11090f
            r0.clear()
            r11.f11108x = r3
            android.view.View r0 = r11.getChildAt(r1)
            r11.m7531c((android.view.View) r0, (android.view.MotionEvent) r12)
        L_0x0068:
            android.view.VelocityTracker r0 = r11.f11090f
            r0.addMovement(r12)
            int r0 = r12.getAction()
            r4 = 3
            r5 = 0
            if (r0 == r3) goto L_0x007e
            int r0 = r12.getAction()
            if (r0 != r4) goto L_0x007c
            goto L_0x007e
        L_0x007c:
            r0 = 0
            goto L_0x0090
        L_0x007e:
            r11.f11108x = r1
            android.view.VelocityTracker r0 = r11.f11090f
            r6 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r6)
            android.view.VelocityTracker r0 = r11.f11090f
            float r0 = r0.getYVelocity()
            r11.m7519b((float) r0)
        L_0x0090:
            android.view.ViewParent r6 = r11.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            int r6 = r11.f11103s
            float r7 = (float) r6
            boolean r8 = r11.f11079D
            if (r8 == 0) goto L_0x00a2
            int r7 = r11.f11085a
            int r6 = r6 - r7
            float r7 = (float) r6
        L_0x00a2:
            float r6 = r11.f11093i
            float r8 = r12.getY()
            float r6 = r6 - r8
            float r8 = r11.f11094j
            float r9 = r12.getX()
            float r8 = r8 - r9
            int r9 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r9 <= 0) goto L_0x00b9
            float r9 = r11.f11102r
        L_0x00b6:
            float r6 = r6 * r9
            goto L_0x00c0
        L_0x00b9:
            int r9 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r9 >= 0) goto L_0x00c0
            float r9 = r11.f11101q
            goto L_0x00b6
        L_0x00c0:
            boolean r9 = r11.f11105u
            if (r9 != 0) goto L_0x00f9
            float r9 = java.lang.Math.abs(r6)
            android.content.Context r10 = r11.getContext()
            android.view.ViewConfiguration r10 = android.view.ViewConfiguration.get(r10)
            int r10 = r10.getScaledTouchSlop()
            float r10 = (float) r10
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x00e7
            float r9 = java.lang.Math.abs(r6)
            float r8 = java.lang.Math.abs(r8)
            int r8 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x00e7
            r8 = 1
            goto L_0x00e8
        L_0x00e7:
            r8 = 0
        L_0x00e8:
            r11.f11105u = r8
            if (r8 == 0) goto L_0x00f9
            float r6 = r12.getY()
            r11.f11093i = r6
            float r6 = r12.getX()
            r11.f11094j = r6
            r6 = 0
        L_0x00f9:
            float r8 = r11.f11095k
            float r8 = r8 + r6
            r11.m7507a((android.view.MotionEvent) r12)
            boolean r9 = r11.f11105u
            if (r9 == 0) goto L_0x01cb
            boolean r9 = r11.f11106v
            if (r9 == 0) goto L_0x0131
            boolean r9 = r11.m7513a((android.view.MotionEvent) r12, (float) r6)
            if (r9 != 0) goto L_0x0131
            int r9 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x0131
            float r8 = r12.getY()
            r11.f11093i = r8
            android.view.VelocityTracker r8 = r11.f11090f
            r8.clear()
            r11.f11106v = r1
            float r8 = r11.f11107w
            android.view.MotionEvent r9 = android.view.MotionEvent.obtain(r12)
            r9.setAction(r4)
            android.view.View r10 = r11.getChildAt(r1)
            r10.dispatchTouchEvent(r9)
            r9.recycle()
        L_0x0131:
            boolean r9 = r11.f11106v
            if (r9 != 0) goto L_0x0161
            boolean r9 = r11.m7513a((android.view.MotionEvent) r12, (float) r6)
            if (r9 == 0) goto L_0x0161
            int r9 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x0161
            r11.m7505a((float) r7, (float) r5)
            r11.f11106v = r3
            int r7 = r12.getAction()
            if (r7 != r2) goto L_0x0161
            android.view.MotionEvent r7 = android.view.MotionEvent.obtain(r12)
            r7.setAction(r1)
            android.view.View r9 = r11.getChildAt(r1)
            r9.dispatchTouchEvent(r7)
            r7.recycle()
            r11.m7519b((float) r5)
            r11.m7521b((int) r3)
        L_0x0161:
            boolean r7 = r11.f11106v
            if (r7 == 0) goto L_0x017d
            int r7 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x017d
            float r0 = r11.f11107w
            int r2 = r11.f11103s
            float r2 = (float) r2
            float r0 = r0 - r2
            r12.offsetLocation(r5, r0)
            android.view.View r0 = r11.getChildAt(r1)
            r0.dispatchTouchEvent(r12)
            r11.m7521b((int) r3)
            goto L_0x01db
        L_0x017d:
            boolean r5 = r11.f11079D
            if (r5 == 0) goto L_0x018e
            int r5 = r11.f11103s
            int r7 = r11.f11085a
            int r5 = r5 - r7
            r11.f11080E = r5
            float r7 = (float) r5
            int r7 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x018e
            float r8 = (float) r5
        L_0x018e:
            boolean r5 = r11.f11081F
            if (r5 == 0) goto L_0x019a
            int r5 = r11.f11082G
            float r7 = (float) r5
            int r7 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x019a
            float r8 = (float) r5
        L_0x019a:
            r11.m7505a((float) r8, (float) r6)
            int r5 = r12.getAction()
            if (r5 == r3) goto L_0x01a9
            int r12 = r12.getAction()
            if (r12 != r4) goto L_0x01db
        L_0x01a9:
            r11.f11106v = r3
            android.view.ViewParent r12 = r11.getParent()
            r12.requestDisallowInterceptTouchEvent(r1)
            float r12 = java.lang.Math.abs(r0)
            float r1 = r11.f11091g
            int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r12 >= 0) goto L_0x01c6
            float r12 = r11.f11107w
            int r1 = r11.getHeight()
            int r1 = r1 / r2
            float r1 = (float) r1
            int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
        L_0x01c6:
            int r12 = (int) r0
            r11.m7506a((int) r12)
            goto L_0x01db
        L_0x01cb:
            float r0 = r11.f11107w
            int r2 = r11.f11103s
            float r2 = (float) r2
            float r0 = r0 - r2
            r12.offsetLocation(r5, r0)
            android.view.View r0 = r11.getChildAt(r1)
            r0.dispatchTouchEvent(r12)
        L_0x01db:
            return r3
        L_0x01dc:
            r11.m7522b((android.view.MotionEvent) r12)
            boolean r12 = super.onTouchEvent(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.bubbleLayout.anycar.AnycarEstimatePanelLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    private boolean m7513a(MotionEvent motionEvent, float f) {
        boolean z = f - this.f11096l < 0.0f;
        boolean canScrollDown = canScrollDown(getChildAt(0), motionEvent, motionEvent.getX(), motionEvent.getY() + (this.f11107w - ((float) getHeight())), false);
        boolean z2 = f - this.f11096l > 0.0f;
        boolean canScrollUp = canScrollUp(getChildAt(0), motionEvent, motionEvent.getX(), motionEvent.getY() + (this.f11107w - ((float) getHeight())), false);
        if (z && canScrollUp) {
            return true;
        }
        if (!z2 || !canScrollDown) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean canScrollUp(View view, MotionEvent motionEvent, float f, float f2, boolean z) {
        View view2 = view;
        if (view2 instanceof WebView) {
            return m7516a((WebView) view2);
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                int left = childAt.getLeft() - view.getScrollX();
                int top = childAt.getTop() - view.getScrollY();
                float f3 = (float) left;
                boolean z2 = f > f3 && f < ((float) (childAt.getRight() - view.getScrollX())) && f2 > ((float) top) && f2 < ((float) (childAt.getBottom() - view.getScrollY()));
                if (!z || z2) {
                    if (canScrollUp(childAt, motionEvent, f - f3, f2 - ((float) top), z)) {
                        return true;
                    }
                }
            }
        }
        if (view2 instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view2;
            if (coordinatorLayout.getChildCount() > 0 && (coordinatorLayout.getChildAt(0) instanceof AppBarLayout)) {
                AppBarLayout appBarLayout = (AppBarLayout) coordinatorLayout.getChildAt(0);
                OnNestOffsetChangedListener onNestOffsetChangedListener = this.f11078C.get(Integer.valueOf(appBarLayout.hashCode()));
                if (onNestOffsetChangedListener != null && onNestOffsetChangedListener.getOffsetY() < appBarLayout.getMeasuredHeight() && onNestOffsetChangedListener.getOffsetY() > 0) {
                    return true;
                }
            }
        }
        if (!m7515a(view, motionEvent) || !view.canScrollVertically(-1)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean canScrollDown(View view, MotionEvent motionEvent, float f, float f2, boolean z) {
        View view2 = view;
        if (view2 instanceof WebView) {
            return m7527b((WebView) view2);
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                int left = childAt.getLeft() - view.getScrollX();
                int top = childAt.getTop() - view.getScrollY();
                float f3 = (float) left;
                boolean z2 = f > f3 && f < ((float) (childAt.getRight() - view.getScrollX())) && f2 > ((float) top) && f2 < ((float) (childAt.getBottom() - view.getScrollY()));
                if (!z || z2) {
                    if (canScrollDown(childAt, motionEvent, f - f3, f2 - ((float) top), z)) {
                        return true;
                    }
                }
            }
        }
        if (view2 instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view2;
            if (coordinatorLayout.getChildCount() > 0 && (coordinatorLayout.getChildAt(0) instanceof AppBarLayout)) {
                AppBarLayout appBarLayout = (AppBarLayout) coordinatorLayout.getChildAt(0);
                OnNestOffsetChangedListener onNestOffsetChangedListener = this.f11078C.get(Integer.valueOf(appBarLayout.hashCode()));
                if (onNestOffsetChangedListener != null && onNestOffsetChangedListener.getOffsetY() < appBarLayout.getMeasuredHeight() && onNestOffsetChangedListener.getOffsetY() > 0) {
                    return true;
                }
            }
        }
        if (!m7515a(view, motionEvent) || !view.canScrollVertically(1)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m7514a(View view, float f, float f2) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                int left = childAt.getLeft() - view.getScrollX();
                int top = childAt.getTop() - view.getScrollY();
                float f3 = (float) left;
                if ((f > f3 && f < ((float) (childAt.getRight() - view.getScrollX())) && f2 > ((float) top) && f2 < ((float) (childAt.getBottom() - view.getScrollY()))) && m7514a(childAt, f - f3, f2 - ((float) top))) {
                    return true;
                }
            }
        }
        return view.canScrollHorizontally(-1);
    }

    /* renamed from: b */
    private boolean m7525b(View view, float f, float f2) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                int left = childAt.getLeft() - view.getScrollX();
                int top = childAt.getTop() - view.getScrollY();
                float f3 = (float) left;
                if ((f > f3 && f < ((float) (childAt.getRight() - view.getScrollX())) && f2 > ((float) top) && f2 < ((float) (childAt.getBottom() - view.getScrollY()))) && m7525b(childAt, f - f3, f2 - ((float) top))) {
                    return true;
                }
            }
        }
        return view.canScrollHorizontally(1);
    }

    /* renamed from: a */
    private boolean m7516a(WebView webView) {
        if (this.f11104t == 0) {
            this.f11104t = (int) (((float) webView.getContentHeight()) * webView.getScale());
        }
        return this.f11104t - webView.getHeight() != 0 && webView.getScrollY() > 2;
    }

    /* renamed from: b */
    private boolean m7527b(WebView webView) {
        if (this.f11104t == 0) {
            this.f11104t = (int) (((float) webView.getContentHeight()) * webView.getScale());
        }
        int scrollY = webView.getScrollY();
        int height = this.f11104t - webView.getHeight();
        return height != 0 && scrollY < height + -2;
    }

    /* renamed from: a */
    private void m7507a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, this.f11107w - ((float) this.f11103s));
        INestChildDispatchTouchEvent iNestChildDispatchTouchEvent = this.f11077B;
        if (iNestChildDispatchTouchEvent != null) {
            iNestChildDispatchTouchEvent.dispatchWrapperTouchEvent(obtain);
        }
    }

    /* renamed from: b */
    private void m7522b(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        INestChildDispatchTouchEvent iNestChildDispatchTouchEvent = this.f11077B;
        if (iNestChildDispatchTouchEvent != null) {
            iNestChildDispatchTouchEvent.dispatchWrapperOrigineTouchEvent(obtain);
        }
    }

    /* renamed from: c */
    private void m7531c(View view, MotionEvent motionEvent) {
        if ((view instanceof WebView) && m7515a(view, motionEvent)) {
            WebView webView = (WebView) view;
            this.f11104t = (int) (((float) webView.getContentHeight()) * webView.getScale());
        } else if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i < viewGroup.getChildCount()) {
                    m7531c(viewGroup.getChildAt(i), motionEvent);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private void m7505a(float f, float f2) {
        this.f11107w = f;
        this.f11090f.computeCurrentVelocity(1000);
        m7520b((float) ((int) (((double) this.f11103s) - Math.ceil((double) f))), this.f11090f.getYVelocity());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7504a(float f) {
        this.f11107w = ((float) this.f11103s) - f;
        m7520b(f, 0.0f);
    }

    /* renamed from: b */
    private void m7520b(float f, float f2) {
        if (this.f11098n == 2 && f < 0.0f) {
            this.f11087c.setTranslationY(0.0f);
            m7529c(0.0f, f2);
        } else if (this.f11098n != 1 || f <= 0.0f) {
            m7529c(f, f2);
            m7521b(0);
            View view = this.f11087c;
            if (view != null) {
                view.setTranslationY(f);
            }
            if (f == 0.0f) {
                this.f11095k = (float) this.f11103s;
                this.f11093i -= this.f11096l;
                this.f11096l = 0.0f;
            }
        } else {
            this.f11087c.setTranslationY(0.0f);
            m7529c(0.0f, f2);
        }
    }

    public void recover(int i) {
        recover(i, (Runnable) null);
    }

    public void recover(int i, Runnable runnable) {
        recover(i, runnable, this.f11097m);
    }

    public void recover(int i, final Runnable runnable, int i2) {
        ObjectAnimator objectAnimator = this.f11089e;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, this.f11084I, new float[]{(float) i});
            this.f11089e = ofFloat;
            ofFloat.setDuration((long) i2);
            this.f11089e.setInterpolator(new DecelerateInterpolator(1.0f));
            this.f11089e.addListener(new CancelDetectionAnimationListener() {
                public void onAnimationEnd(Animator animator) {
                    if (!this.canceled) {
                        ObjectAnimator unused = AnycarEstimatePanelLayout.this.f11089e = null;
                    }
                    Runnable runnable = runnable;
                    if (runnable != null) {
                        runnable.run();
                    }
                    AnycarEstimatePanelLayout.this.m7521b(1);
                }
            });
            this.f11089e.start();
        }
    }

    /* renamed from: a */
    private void m7508a(MotionEvent motionEvent, float f, float f2) {
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            m7523b(motionEvent, f, f2);
        } else if (Math.abs(f) > this.f11092h * 8.0f && Math.abs(f) > Math.abs(f2) && Math.abs(f) > 0.0f) {
            m7523b(motionEvent, f, f2);
        }
    }

    /* renamed from: b */
    private boolean m7524b() {
        ObjectAnimator objectAnimator = this.f11089e;
        return objectAnimator != null && objectAnimator.isRunning();
    }

    private static class CancelDetectionAnimationListener extends AnimatorListenerAdapter {
        protected boolean canceled;

        private CancelDetectionAnimationListener() {
        }

        public void onAnimationCancel(Animator animator) {
            this.canceled = true;
        }
    }

    @Deprecated
    /* renamed from: c */
    private void m7530c(MotionEvent motionEvent) {
        this.f11087c.setTranslationY(m7533d(motionEvent));
    }

    @Deprecated
    public void onActionRelease(MotionEvent motionEvent) {
        m7533d(motionEvent);
        ObjectAnimator objectAnimator = this.f11088d;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f11088d.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f11087c, View.TRANSLATION_Y, new float[]{this.f11087c.getTranslationY(), 0.0f});
        this.f11088d = ofFloat;
        ofFloat.setDuration(200);
        this.f11088d.setInterpolator(PathInterpolatorCompat.create(0.4f, 0.0f, 0.2f, 1.0f));
        this.f11088d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
            }
        });
        this.f11088d.start();
    }

    public void registerNestScrollChildCallback(INestChildScrollChange iNestChildScrollChange) {
        if (!this.f11076A.contains(iNestChildScrollChange)) {
            this.f11076A.add(iNestChildScrollChange);
        }
    }

    public void registerWrapperDispatchEvent(INestChildDispatchTouchEvent iNestChildDispatchTouchEvent) {
        this.f11077B = iNestChildDispatchTouchEvent;
    }

    public void removeNestScrollChildCallback(INestChildScrollChange iNestChildScrollChange) {
        if (this.f11076A.contains(iNestChildScrollChange)) {
            this.f11076A.remove(iNestChildScrollChange);
        }
    }

    public void clearNestScrollChildCallback() {
        this.f11076A.clear();
    }

    /* renamed from: c */
    private void m7529c(float f, float f2) {
        for (INestChildScrollChange onNestChildScrollChange : this.f11076A) {
            onNestChildScrollChange.onNestChildScrollChange(f, f2);
        }
    }

    /* renamed from: a */
    private void m7506a(int i) {
        for (INestChildScrollChange onNestChildScrollRelease : this.f11076A) {
            onNestChildScrollRelease.onNestChildScrollRelease(getChildAt(0).getTranslationY(), i);
        }
    }

    /* renamed from: b */
    private void m7523b(MotionEvent motionEvent, float f, float f2) {
        for (INestChildScrollChange onNestChildHorizationScroll : this.f11076A) {
            onNestChildHorizationScroll.onNestChildHorizationScroll(motionEvent, f, f2);
        }
    }

    /* renamed from: b */
    private void m7519b(float f) {
        for (INestChildScrollChange onFingerUp : this.f11076A) {
            onFingerUp.onFingerUp(f);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7521b(int i) {
        this.f11100p = i;
        for (INestChildScrollChange onNestScrollingState : this.f11076A) {
            onNestScrollingState.onNestScrollingState(i);
        }
    }

    /* access modifiers changed from: protected */
    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    /* renamed from: d */
    private float m7533d(MotionEvent motionEvent) {
        return motionEvent.getRawY();
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        super.onNestedScrollAccepted(view, view2, i);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        super.onNestedPreScroll(view, i, i2, iArr);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        super.onNestedScroll(view, i, i2, i3, i4);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return super.onNestedPreFling(view, f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return super.onNestedFling(view, f, f2, z);
    }

    public void onStopNestedScroll(View view) {
        super.onStopNestedScroll(view);
    }

    public int getNestedScrollAxes() {
        return super.getNestedScrollAxes();
    }

    public boolean isFingerHolderTouch() {
        return this.f11108x;
    }

    public float getMinFlingVelocity() {
        return this.f11091g;
    }

    public void updateStatus(int i, int i2) {
        if (i == 0) {
            hiden(i2);
        } else if (i == 1) {
            peek(i2);
        } else if (i == 2) {
            expand();
        }
    }

    public void expand() {
        expand((Runnable) null);
    }

    public void peek(int i) {
        peek(i, (Runnable) null);
    }

    public void hiden() {
        hiden((Runnable) null);
    }

    public void expand(Runnable runnable) {
        expand(runnable, this.f11097m);
    }

    public void expand(final Runnable runnable, int i) {
        recover(this.f11085a, new Runnable() {
            public void run() {
                int unused = AnycarEstimatePanelLayout.this.f11099o = 2;
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }, i);
    }

    public void peek(int i, Runnable runnable) {
        peek(i, runnable, this.f11097m);
    }

    public void peek(int i, final Runnable runnable, int i2) {
        recover(i, new Runnable() {
            public void run() {
                int unused = AnycarEstimatePanelLayout.this.f11099o = 1;
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }, i2);
    }

    public void hiden(Runnable runnable) {
        hiden(runnable, this.f11097m);
    }

    public void hiden(int i) {
        recover(i, new Runnable() {
            public void run() {
                int unused = AnycarEstimatePanelLayout.this.f11099o = 0;
            }
        }, this.f11097m);
    }

    public void hiden(final Runnable runnable, int i) {
        recover(getMeasuredHeight(), new Runnable() {
            public void run() {
                int unused = AnycarEstimatePanelLayout.this.f11099o = 0;
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }, i);
    }

    public void hiden(int i, final Runnable runnable, int i2) {
        recover(i, new Runnable() {
            public void run() {
                int unused = AnycarEstimatePanelLayout.this.f11099o = 0;
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }, i2);
    }

    public void setSheetDirection(int i) {
        this.f11098n = i;
    }

    public void setDampingDown(float f) {
        this.f11102r = f;
    }

    public void setDampingUp(float f) {
        this.f11101q = f;
    }

    public void setParentDispatchTouchEvent(boolean z) {
        this.f11109y = z;
    }

    public boolean isAniming() {
        ObjectAnimator objectAnimator = this.f11089e;
        if (objectAnimator == null) {
            return false;
        }
        return objectAnimator.isRunning();
    }

    public int getShowState() {
        return this.f11099o;
    }

    public int getScrollState() {
        return this.f11100p;
    }

    public void setLockTop(boolean z, int i) {
        this.f11079D = z;
        this.f11080E = i;
    }

    public void setLockTopLimit(boolean z, int i) {
        this.f11079D = z;
        this.f11085a = i;
        if (i != 0) {
            post(new Runnable() {
                public void run() {
                    AnycarEstimatePanelLayout anycarEstimatePanelLayout = AnycarEstimatePanelLayout.this;
                    int unused = anycarEstimatePanelLayout.f11080E = anycarEstimatePanelLayout.f11103s - AnycarEstimatePanelLayout.this.f11085a;
                }
            });
        }
    }

    public void setNormalLockTopLimti(int i) {
        this.f11079D = true;
        this.f11085a = i;
        if (i != 0) {
            post(new Runnable() {
                public void run() {
                    AnycarEstimatePanelLayout anycarEstimatePanelLayout = AnycarEstimatePanelLayout.this;
                    int unused = anycarEstimatePanelLayout.f11080E = anycarEstimatePanelLayout.f11103s - AnycarEstimatePanelLayout.this.f11085a;
                    if (((float) AnycarEstimatePanelLayout.this.f11080E) < AnycarEstimatePanelLayout.this.f11107w) {
                        AnycarEstimatePanelLayout anycarEstimatePanelLayout2 = AnycarEstimatePanelLayout.this;
                        anycarEstimatePanelLayout2.f11085a = (int) (((float) anycarEstimatePanelLayout2.f11103s) - AnycarEstimatePanelLayout.this.f11107w);
                        AnycarEstimatePanelLayout anycarEstimatePanelLayout3 = AnycarEstimatePanelLayout.this;
                        int unused2 = anycarEstimatePanelLayout3.f11080E = (int) anycarEstimatePanelLayout3.f11107w;
                    }
                }
            });
        }
    }

    public int getLockTopLimit() {
        return this.f11085a;
    }

    public void setLockDispatchTouchEvent(boolean z) {
        this.f11083H = z;
    }

    public void setLockBottom(boolean z, int i) {
        this.f11081F = z;
        this.f11082G = i;
    }

    public void setNeedTouchUnderTargetView(boolean z) {
        this.f11110z = z;
    }

    public void setTouchParentViewOriginMeasureHeight(int i) {
        this.f11103s = i;
    }
}
