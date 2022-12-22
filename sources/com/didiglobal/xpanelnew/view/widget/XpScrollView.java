package com.didiglobal.xpanelnew.view.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.xpanelnew.util.XpLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class XpScrollView extends NestedScrollView {

    /* renamed from: A */
    private static final int f51691A = 100;

    /* renamed from: B */
    private static final int f51692B = 500;
    public static final int XP_SCROLL_DOWN = 2;
    public static final int XP_SCROLL_IDLE = 3;
    public static final int XP_SCROLL_UP = 1;
    public static final int X_DEFAULT = 2;
    public static final int X_PULL_DOWN = 3;
    public static final int X_PULL_UP = 1;

    /* renamed from: i */
    private static final String f51693i = "XpScrollView";

    /* renamed from: j */
    private static final String f51694j = "XpScrollView";

    /* renamed from: p */
    private static final long f51695p = 10;

    /* renamed from: z */
    private static final int f51696z = 250;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public OnScrollListener f51697C;

    /* renamed from: D */
    private int f51698D;

    /* renamed from: E */
    private int f51699E;

    /* renamed from: F */
    private XpMsgContainerListener f51700F;

    /* renamed from: G */
    private XpMsgClickListener f51701G;

    /* renamed from: H */
    private OnVisibilityChangedListener f51702H;

    /* renamed from: a */
    int f51703a;

    /* renamed from: b */
    int f51704b;

    /* renamed from: c */
    int f51705c;

    /* renamed from: d */
    int f51706d;

    /* renamed from: e */
    boolean f51707e;

    /* renamed from: f */
    boolean f51708f;

    /* renamed from: g */
    Runnable f51709g;

    /* renamed from: h */
    Runnable f51710h;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f51711k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public XpScrollViewListener f51712l;

    /* renamed from: m */
    private int f51713m;

    /* renamed from: n */
    private boolean f51714n;

    /* renamed from: o */
    private Context f51715o;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f51716q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public float f51717r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public float f51718s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public Runnable f51719t;

    /* renamed from: u */
    private GestureListener f51720u;

    /* renamed from: v */
    private boolean f51721v;

    /* renamed from: w */
    private boolean f51722w;

    /* renamed from: x */
    private boolean f51723x;

    /* renamed from: y */
    private Rect f51724y;

    public interface GestureListener {
        void fling();
    }

    public interface OnScrollListener {
        void onScrollChanged(int i, int i2, int i3, int i4);

        void onScrollStopped(float f);

        void onScrolling();
    }

    public interface OnVisibilityChangedListener {
        void onVisibilityChanged(int i);
    }

    public interface XpMsgClickListener {
        void onClick();
    }

    public interface XpMsgContainerListener {
        Rect getMsgContainerRect();
    }

    public interface XpScrollViewListener {
        void direction(int i);

        void event(float f, float f2);

        int getAreaCanScrollAboveFirstCard();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface XpStatus {
    }

    public void setBlockFlinging(boolean z) {
        this.f51714n = z;
    }

    public void fling(int i) {
        if (!this.f51714n) {
            super.fling(i);
        }
    }

    public XpScrollView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public XpScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XpScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f51713m = 2;
        this.f51722w = true;
        this.f51723x = false;
        this.f51703a = 0;
        this.f51704b = 0;
        this.f51705c = 0;
        this.f51706d = 0;
        this.f51707e = false;
        this.f51708f = false;
        this.f51709g = new Runnable() {
            public void run() {
                if (XpScrollView.this.f51707e) {
                    SystemUtils.log(3, "XpScrollView", "The mTimerForUpEvent has executed, so set the mIsWaitUpEvent as false", (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView$3", 245);
                    XpScrollView.this.f51707e = false;
                    return;
                }
                SystemUtils.log(3, "XpScrollView", "The mTimerForUpEvent has executed, mIsWaitUpEvent is false,so do nothing", (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView$3", 249);
            }
        };
        this.f51710h = new Runnable() {
            public void run() {
                if (XpScrollView.this.f51708f) {
                    SystemUtils.log(3, "XpScrollView", "The mTimerForSecondClick has executed,so as a singleClick", (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView$4", 333);
                    XpScrollView.this.f51708f = false;
                    return;
                }
                SystemUtils.log(3, "XpScrollView", "The mTimerForSecondClick has executed, the doubleclick has executed ,so do thing", (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView$4", 338);
            }
        };
        m37006a(context);
    }

    public void setScrollEnabled(boolean z) {
        this.f51722w = z;
    }

    /* renamed from: a */
    private void m37006a(Context context) {
        this.f51715o = context;
        this.f51719t = new Runnable() {
            public void run() {
                if (XpScrollView.this.f51716q != XpScrollView.this.getScrollY()) {
                    if (XpScrollView.this.f51697C != null) {
                        XpScrollView.this.f51697C.onScrolling();
                    }
                    XpScrollView xpScrollView = XpScrollView.this;
                    int unused = xpScrollView.f51716q = xpScrollView.getScrollY();
                    XpScrollView xpScrollView2 = XpScrollView.this;
                    xpScrollView2.postDelayed(xpScrollView2.f51719t, 10);
                } else if (XpScrollView.this.f51697C != null) {
                    XpScrollView.this.f51697C.onScrollStopped(XpScrollView.this.f51718s);
                }
            }
        };
        setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int i = 2;
                if (motionEvent.getAction() == 2 && XpScrollView.this.f51712l != null) {
                    XpScrollView.this.f51712l.event(motionEvent.getX(), motionEvent.getY());
                }
                if (motionEvent.getAction() == 1) {
                    boolean unused = XpScrollView.this.f51711k = false;
                    if (motionEvent.getY() != XpScrollView.this.f51717r) {
                        if (motionEvent.getY() <= XpScrollView.this.f51717r) {
                            i = 1;
                        }
                        float unused2 = XpScrollView.this.f51718s = Math.abs(motionEvent.getY() - XpScrollView.this.f51717r);
                        if (XpScrollView.this.f51712l != null) {
                            XpScrollView.this.f51712l.direction(i);
                        }
                        if (XpScrollView.this.getDirection() != i) {
                            XpScrollView.this.setDirection(i);
                        }
                    }
                    XpScrollView xpScrollView = XpScrollView.this;
                    int unused3 = xpScrollView.f51716q = xpScrollView.getScrollY();
                    XpScrollView xpScrollView2 = XpScrollView.this;
                    xpScrollView2.postDelayed(xpScrollView2.f51719t, 10);
                }
                return false;
            }
        });
    }

    public void setDirectionListener(XpScrollViewListener xpScrollViewListener) {
        this.f51712l = xpScrollViewListener;
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        OnVisibilityChangedListener onVisibilityChangedListener;
        super.onWindowVisibilityChanged(i);
        boolean z = i == 0;
        SystemUtils.log(6, "onWindowVisiChanged", z + "", (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView", 184);
        SystemUtils.log(6, "onWindowVisiChanged", this.f51723x + "", (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView", 185);
        if (this.f51723x != z && (onVisibilityChangedListener = this.f51702H) != null) {
            this.f51723x = z;
            onVisibilityChangedListener.onVisibilityChanged(i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        if (r5.getRawY() < ((float) r0)) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = r4.f51721v
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r5.getAction()
            r2 = 1
            if (r0 != 0) goto L_0x004b
            android.view.View r0 = r4.getChildAt(r1)
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x004a
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r3 = r0.getChildCount()
            if (r3 <= r2) goto L_0x004a
            android.view.View r0 = r0.getChildAt(r2)
            r3 = 2
            int[] r3 = new int[r3]
            if (r0 == 0) goto L_0x004b
            r0.getLocationOnScreen(r3)
            r0 = r3[r2]
            int r3 = r4.getStatus()
            if (r3 != r2) goto L_0x003a
            android.content.Context r0 = r4.f51715o
            r3 = 1106247680(0x41f00000, float:30.0)
            int r0 = com.didiglobal.xpanelnew.util.XpUtils.dip2px(r0, r3)
            goto L_0x0041
        L_0x003a:
            com.didiglobal.xpanelnew.view.widget.XpScrollView$XpScrollViewListener r3 = r4.f51712l
            int r3 = r3.getAreaCanScrollAboveFirstCard()
            int r0 = r0 - r3
        L_0x0041:
            float r3 = r5.getRawY()
            float r0 = (float) r0
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x004b
        L_0x004a:
            return r1
        L_0x004b:
            int r0 = r5.getAction()
            if (r0 != r2) goto L_0x0058
            java.lang.String r0 = "MotionEvent"
            java.lang.String r1 = "dispatchTouchEvent"
            com.didiglobal.xpanelnew.util.XpLog.m36924d(r0, r1)
        L_0x0058:
            boolean r5 = super.dispatchTouchEvent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.xpanelnew.view.widget.XpScrollView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f51722w) {
            return false;
        }
        if (this.f51702H != null) {
            this.f51724y = this.f51700F.getMsgContainerRect();
        }
        if (this.f51724y == null) {
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!this.f51707e && motionEvent.getAction() != 0) {
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.f51705c = (int) motionEvent.getX();
                this.f51706d = (int) motionEvent.getY();
                if (Math.abs(this.f51705c - this.f51703a) > 100 || Math.abs(this.f51706d - this.f51704b) > 100) {
                    this.f51707e = false;
                    removeCallbacks(this.f51709g);
                    SystemUtils.log(3, "XpScrollView", "The touch down and up distance too far:cancel the click", (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView", 302);
                } else {
                    this.f51707e = false;
                    removeCallbacks(this.f51709g);
                    if (this.f51724y != null && motionEvent.getRawY() > ((float) this.f51724y.top) && motionEvent.getRawY() < ((float) this.f51724y.bottom)) {
                        onSingleClick();
                        return true;
                    }
                }
            } else if (action == 2) {
                this.f51705c = (int) motionEvent.getX();
                this.f51706d = (int) motionEvent.getY();
                if (Math.abs(this.f51705c - this.f51703a) > 100 || Math.abs(this.f51706d - this.f51704b) > 100) {
                    this.f51707e = false;
                    removeCallbacks(this.f51709g);
                    SystemUtils.log(3, "XpScrollView", "The move distance too far:cancel the click", (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView", 292);
                }
            } else if (action != 3) {
                SystemUtils.log(3, "XpScrollView", "irrelevant MotionEvent state:" + motionEvent.getAction(), (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView", 319);
            }
            this.f51707e = false;
            removeCallbacks(this.f51709g);
            SystemUtils.log(3, "XpScrollView", "The touch cancel state:cancel the click", (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView", 316);
        } else {
            this.f51703a = (int) motionEvent.getX();
            this.f51704b = (int) motionEvent.getY();
            this.f51707e = true;
            postDelayed(this.f51709g, 250);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public void onSingleClick() {
        if (this.f51708f) {
            onDoubleClick();
            this.f51708f = false;
            removeCallbacks(this.f51710h);
            return;
        }
        this.f51708f = true;
        XpMsgClickListener xpMsgClickListener = this.f51701G;
        if (xpMsgClickListener != null) {
            xpMsgClickListener.onClick();
        }
        postDelayed(this.f51710h, 500);
    }

    public void onDoubleClick() {
        SystemUtils.log(3, "XpScrollView", "we can do sth for double click here", (Throwable) null, "com.didiglobal.xpanelnew.view.widget.XpScrollView", 359);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f51713m = getStatus();
            this.f51717r = motionEvent.getY();
            this.f51711k = true;
            XpLog.m36924d("XpScrollView", "ACTION_DOWN");
        }
        if (motionEvent.getAction() == 1) {
            XpLog.m36924d("MotionEvent", "onInterceptTouchEvent");
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public int getLastStatus() {
        return this.f51713m;
    }

    public void setLastStatus(int i) {
        this.f51713m = i;
    }

    public float getFirstTouchY() {
        return this.f51717r;
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f51697C = onScrollListener;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        OnScrollListener onScrollListener = this.f51697C;
        if (onScrollListener != null) {
            onScrollListener.onScrollChanged(i, i2, i3, i4);
        }
    }

    public boolean isChildVisible(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        getHitRect(rect);
        return view.getLocalVisibleRect(rect);
    }

    public boolean isAtTop() {
        return getScrollY() <= 0;
    }

    public boolean isAtBottom() {
        return getChildAt(getChildCount() - 1).getBottom() + getPaddingBottom() == getHeight() + getScrollY();
    }

    public void setCurrentStatus(int i) {
        this.f51698D = i;
    }

    public int getStatus() {
        return this.f51698D;
    }

    public int getDirection() {
        return this.f51699E;
    }

    public void setDoingAnim(boolean z) {
        this.f51721v = z;
    }

    public boolean getDoingAnim() {
        return this.f51721v;
    }

    /* access modifiers changed from: private */
    public void setDirection(int i) {
        this.f51699E = i;
    }

    public void setGestureListener(GestureListener gestureListener) {
        this.f51720u = gestureListener;
    }

    public boolean getIsFingerOnScreen() {
        return this.f51711k;
    }

    public void setXpMsgContainerListener(XpMsgContainerListener xpMsgContainerListener) {
        this.f51700F = xpMsgContainerListener;
    }

    public void setXpMsgClickListener(XpMsgClickListener xpMsgClickListener) {
        this.f51701G = xpMsgClickListener;
    }

    public void setOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener) {
        this.f51702H = onVisibilityChangedListener;
    }
}
