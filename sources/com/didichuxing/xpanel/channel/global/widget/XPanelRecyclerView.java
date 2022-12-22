package com.didichuxing.xpanel.channel.global.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import com.didichuxing.xpanel.base.BorderRecyclerView;
import com.didichuxing.xpanel.base.IState;
import com.didichuxing.xpanel.util.LogcatUtil;
import com.taxis99.R;

public class XPanelRecyclerView extends BorderRecyclerView implements IState {
    public static final int CHECK = 0;
    public static final int IGNORE = 1;
    public static final int X_DEFAULT = 2;
    public static final int X_PULL_DOWN = 3;
    public static final int X_PULL_UP = 1;

    /* renamed from: a */
    private static final String f49433a = "XPanelRecyclerView";

    /* renamed from: t */
    private static float f49434t = ((float) (Math.log(0.28d) / Math.log(0.9d)));

    /* renamed from: v */
    private static final float f49435v = 0.1f;

    /* renamed from: A */
    private float f49436A;

    /* renamed from: B */
    private boolean f49437B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public IFlingListener f49438C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public int f49439D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public MyScrollerRunnable f49440E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public Handler f49441F;

    /* renamed from: G */
    private Rect f49442G;

    /* renamed from: H */
    private boolean f49443H;

    /* renamed from: I */
    private int f49444I;

    /* renamed from: J */
    private int f49445J;

    /* renamed from: K */
    private int f49446K;

    /* renamed from: L */
    private RectF f49447L;

    /* renamed from: M */
    private Paint f49448M;

    /* renamed from: N */
    private Paint f49449N;

    /* renamed from: O */
    private Paint f49450O;

    /* renamed from: P */
    private int f49451P;

    /* renamed from: Q */
    private float f49452Q;

    /* renamed from: R */
    private float f49453R;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f49454b;

    /* renamed from: c */
    private int f49455c;

    /* renamed from: d */
    private boolean f49456d;

    /* renamed from: e */
    private boolean f49457e;

    /* renamed from: f */
    private XPanelSpaceView f49458f;

    /* renamed from: g */
    private boolean f49459g;

    /* renamed from: h */
    private int f49460h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f49461i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f49462j;

    /* renamed from: k */
    private IScrollStateListener f49463k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public RecyclerView.LayoutManager f49464l;

    /* renamed from: m */
    private int f49465m;
    public boolean mHandTouch;
    public IRecyclerViewHelper mHelper;

    /* renamed from: n */
    private int f49466n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Context f49467o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public View f49468p;

    /* renamed from: q */
    private final int f49469q;

    /* renamed from: r */
    private float f49470r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f49471s;

    /* renamed from: u */
    private float f49472u;

    /* renamed from: w */
    private float f49473w;

    /* renamed from: x */
    private double f49474x;

    /* renamed from: y */
    private double f49475y;

    /* renamed from: z */
    private double f49476z;

    public interface IFlingListener {
        boolean onFling();
    }

    public interface IRecyclerViewHelper {
        int getTopWhiteBgIndex();

        boolean isItemNeedBgShadow(int i);
    }

    public interface IScrollStateListener {
        void changeState(int i);
    }

    public void requestChildFocus(View view, View view2) {
    }

    public void setHalfIndex(int i) {
    }

    public void stateBindChange(IState.IStateChange iStateChange) {
    }

    public void stateDestory() {
    }

    public void setDefaulStautsTop(int i) {
        this.f49454b = i;
    }

    public void setCardShaderTop(int i) {
        this.f49439D = i;
    }

    public void setRecyclerViewHelper(IRecyclerViewHelper iRecyclerViewHelper) {
        this.mHelper = iRecyclerViewHelper;
    }

    public XPanelRecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public XPanelRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XPanelRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f49454b = -1;
        this.f49456d = false;
        this.mHandTouch = false;
        this.f49457e = false;
        this.f49458f = null;
        this.f49459g = false;
        this.f49461i = 0;
        this.f49462j = 0;
        this.f49469q = 1;
        this.f49471s = 0;
        this.f49472u = ViewConfiguration.getScrollFriction();
        this.f49436A = 0.0f;
        this.f49437B = true;
        this.f49441F = new Handler(Looper.getMainLooper());
        this.f49442G = new Rect();
        this.f49443H = true;
        this.f49446K = -1;
        this.f49447L = new RectF();
        this.f49451P = 553648128;
        m35695a(context);
    }

    private class SScroller extends Scroller {
        public SScroller(Context context) {
            super(context);
        }

        public SScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        public SScroller(Context context, Interpolator interpolator, boolean z) {
            super(context, interpolator, z);
        }
    }

    private class MyScrollerRunnable implements Runnable {
        private int mCurrentY;
        private int mFinalY;
        private SScroller ssCroller;

        public MyScrollerRunnable(Context context) {
            this.ssCroller = new SScroller(context);
        }

        public void stop() {
            this.ssCroller.abortAnimation();
        }

        public void start(int i) {
            this.ssCroller.abortAnimation();
            this.ssCroller.fling(0, 0, 0, i, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            this.mCurrentY = 0;
            this.mFinalY = this.ssCroller.getFinalY();
            XPanelRecyclerView.this.f49441F.post(this);
        }

        public void run() {
            this.ssCroller.computeScrollOffset();
            int currY = this.ssCroller.getCurrY() - this.mCurrentY;
            if (currY != 0) {
                View findViewByPosition = XPanelRecyclerView.this.f49464l.findViewByPosition(0);
                if (findViewByPosition == null || findViewByPosition.getTop() != 0) {
                    XPanelRecyclerView xPanelRecyclerView = XPanelRecyclerView.this;
                    View unused = xPanelRecyclerView.f49468p = xPanelRecyclerView.f49464l.findViewByPosition(1);
                    if (XPanelRecyclerView.this.f49468p != null) {
                        int top = XPanelRecyclerView.this.f49468p.getTop() + XPanelRecyclerView.this.f49439D;
                        if (top > currY && top - (this.mFinalY - this.mCurrentY) < (XPanelRecyclerView.this.getMeasuredHeight() - XPanelRecyclerView.this.f49461i) - XPanelRecyclerView.this.f49462j) {
                            XPanelRecyclerView.this.scrollBy(0, top);
                            this.ssCroller.abortAnimation();
                            XPanelRecyclerView.this.stopScroll();
                            return;
                        } else if (XPanelRecyclerView.this.f49454b > 0 && top - currY > XPanelRecyclerView.this.f49454b) {
                            XPanelRecyclerView xPanelRecyclerView2 = XPanelRecyclerView.this;
                            xPanelRecyclerView2.scrollBy(0, top - xPanelRecyclerView2.f49454b);
                            this.ssCroller.abortAnimation();
                            XPanelRecyclerView.this.stopScroll();
                            return;
                        }
                    }
                    XPanelRecyclerView.this.scrollBy(0, currY);
                } else {
                    this.ssCroller.abortAnimation();
                    return;
                }
            }
            this.mCurrentY = this.ssCroller.getCurrY();
            if (!this.ssCroller.isFinished()) {
                XPanelRecyclerView.this.f49441F.post(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public BorderRecyclerView.Border[] getDismissBorder() {
        return new BorderRecyclerView.Border[]{BorderRecyclerView.Border.TOP};
    }

    /* renamed from: a */
    private void m35695a(Context context) {
        m35694a();
        this.f49467o = context;
        this.f49436A = (float) getResources().getDimensionPixelSize(R.dimen._30dp);
        this.f49455c = 3;
        this.f49460h = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f49470r = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setOnFlingListener(new RecyclerView.OnFlingListener() {
            public boolean onFling(int i, int i2) {
                int unused = XPanelRecyclerView.this.f49471s = 0;
                XPanelRecyclerView xPanelRecyclerView = XPanelRecyclerView.this;
                View unused2 = xPanelRecyclerView.f49468p = xPanelRecyclerView.f49464l.findViewByPosition(1);
                int b = (int) (XPanelRecyclerView.this.m35689a(i2) * ((double) Math.signum((float) i2)));
                if (XPanelRecyclerView.this.f49468p != null && XPanelRecyclerView.this.f49468p.getTop() >= 0) {
                    LogcatUtil.m35794d(XPanelRecyclerView.f49433a, "mSplineDistance=" + b);
                    if (XPanelRecyclerView.this.f49438C != null) {
                        return XPanelRecyclerView.this.f49438C.onFling();
                    }
                    return true;
                } else if (i2 >= 0) {
                    return false;
                } else {
                    if (XPanelRecyclerView.this.f49440E == null) {
                        XPanelRecyclerView xPanelRecyclerView2 = XPanelRecyclerView.this;
                        MyScrollerRunnable unused3 = xPanelRecyclerView2.f49440E = new MyScrollerRunnable(xPanelRecyclerView2.f49467o);
                    }
                    LogcatUtil.m35794d(XPanelRecyclerView.f49433a, "mFirstCard==null, start MyScrollerRunnable....");
                    XPanelRecyclerView.this.f49440E.start(i2);
                    return true;
                }
            }
        });
    }

    public boolean fling(int i, int i2) {
        LogcatUtil.m35794d(f49433a, "@fling, velocityY=" + i2);
        return super.fling(i, i2);
    }

    public void setFlingListener(IFlingListener iFlingListener) {
        this.f49438C = iFlingListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public double m35689a(int i) {
        double b = m35698b(i);
        float f = f49434t;
        return ((double) (this.f49472u * this.f49470r)) * Math.exp((((double) f) / (((double) f) - 1.0d)) * b);
    }

    /* renamed from: b */
    private double m35698b(int i) {
        return Math.log((double) ((((float) Math.abs(i)) * 0.1f) / (this.f49472u * this.f49470r)));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i2);
        this.f49465m = size;
        double d = ((double) size) * 0.5d;
        this.f49475y = d;
        this.f49476z = d;
        LogcatUtil.m35794d(f49433a, "@onMeasure, mPullUpLimit=" + this.f49476z);
    }

    public void smoothScrollBy(int i, int i2) {
        this.f49471s = 1;
        super.smoothScrollBy(i, i2);
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator) {
        this.f49471s = 1;
        super.smoothScrollBy(i, i2, interpolator);
    }

    public void scrollBy(int i, int i2) {
        super.scrollBy(i, i2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        XPanelSpaceView xPanelSpaceView;
        if (this.f49456d) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f49446K = motionEvent.getPointerId(0);
            this.f49444I = Math.round(motionEvent.getX() + 0.5f);
            this.f49445J = Math.round(motionEvent.getY() + 0.5f);
            if (this.f49458f == null || getLayoutManager().getChildAt(0) != (xPanelSpaceView = this.f49458f)) {
                this.f49443H = false;
            } else {
                xPanelSpaceView.getHitRect(this.f49442G);
                if (this.f49442G.contains(this.f49444I, this.f49445J)) {
                    this.f49443H = !this.f49458f.contain(((int) motionEvent.getX()) - this.f49458f.getLeft(), ((int) motionEvent.getY()) - this.f49458f.getTop());
                } else {
                    this.f49443H = false;
                }
            }
        } else if (action == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f49446K);
            this.f49466n = findPointerIndex;
            if (findPointerIndex < 0) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            int round = Math.round(motionEvent.getX(findPointerIndex) + 0.5f);
            int round2 = Math.round(motionEvent.getY(this.f49466n) + 0.5f);
            if (getScrollState() != 1) {
                int i = round - this.f49444I;
                int i2 = round2 - this.f49445J;
                boolean z = getLayoutManager().canScrollHorizontally() && Math.abs(i) > this.f49460h && (getLayoutManager().canScrollVertically() || Math.abs(i) > Math.abs(i2));
                if (getLayoutManager().canScrollVertically() && Math.abs(i2) > this.f49460h && (getLayoutManager().canScrollHorizontally() || Math.abs(i2) > Math.abs(i))) {
                    z = true;
                }
                if (!z || !super.onInterceptTouchEvent(motionEvent)) {
                    return false;
                }
                return true;
            }
        }
        if (!this.f49443H || this.mHandTouch) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        this.f49464l = layoutManager;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MyScrollerRunnable myScrollerRunnable = this.f49440E;
        if (myScrollerRunnable != null) {
            myScrollerRunnable.stop();
        }
        if (this.f49456d) {
            return false;
        }
        if (this.f49443H && !this.mHandTouch) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f49457e = true;
        }
        if (action == 2) {
            this.f49473w = motionEvent.getY() - ((float) this.f49445J);
            LogcatUtil.m35796i(f49433a, "mDirection=" + this.f49473w);
            this.f49471s = 0;
            if (this.mHandTouch && this.f49457e && ((float) this.f49445J) - motionEvent.getY() <= (-this.f49436A)) {
                this.f49457e = false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListenerScrollState(IScrollStateListener iScrollStateListener) {
        this.f49463k = iScrollStateListener;
    }

    public void bindHandView(XPanelSpaceView xPanelSpaceView) {
        this.f49458f = xPanelSpaceView;
    }

    public void destroy() {
        this.f49458f = null;
    }

    /* renamed from: a */
    private void m35694a() {
        Paint paint = new Paint();
        this.f49449N = paint;
        paint.setColor(0);
        this.f49449N.setAntiAlias(true);
        this.f49449N.setStyle(Paint.Style.FILL);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r3.mHelper;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m35696a(android.graphics.Canvas r4, int r5, android.view.View r6) {
        /*
            r3 = this;
            if (r5 == 0) goto L_0x000b
            com.didichuxing.xpanel.channel.global.widget.XPanelRecyclerView$IRecyclerViewHelper r0 = r3.mHelper
            if (r0 == 0) goto L_0x000b
            boolean r5 = r0.isItemNeedBgShadow(r5)
            goto L_0x000c
        L_0x000b:
            r5 = 0
        L_0x000c:
            if (r5 != 0) goto L_0x000f
            return
        L_0x000f:
            android.graphics.RectF r5 = r3.f49447L
            int r0 = r6.getLeft()
            float r0 = (float) r0
            int r1 = r6.getTop()
            float r1 = (float) r1
            int r2 = r6.getRight()
            float r2 = (float) r2
            int r6 = r6.getBottom()
            float r6 = (float) r6
            r5.set(r0, r1, r2, r6)
            android.graphics.RectF r5 = r3.f49447L
            android.graphics.Paint r6 = r3.f49450O
            r0 = 0
            r4.drawRoundRect(r5, r0, r0, r6)
            android.graphics.RectF r5 = r3.f49447L
            android.graphics.Paint r6 = r3.f49448M
            r4.drawRoundRect(r5, r0, r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.xpanel.channel.global.widget.XPanelRecyclerView.m35696a(android.graphics.Canvas, int, android.view.View):void");
    }

    /* renamed from: a */
    private void m35697a(Canvas canvas, boolean z, View view) {
        this.f49447L.top = (float) (!z ? view.getBottom() : view.getTop());
        this.f49447L.left = 0.0f;
        this.f49447L.right = (float) getWidth();
        this.f49447L.bottom = (float) getBottom();
        canvas.drawRoundRect(this.f49447L, 0.0f, 0.0f, this.f49449N);
    }

    public void setKeepState(boolean z) {
        this.f49459g = z;
    }

    public void setBottomSpace(int i) {
        this.f49461i = i;
    }

    public void setDecoration(int i) {
        this.f49462j = i;
    }

    public int getState() {
        return this.f49471s;
    }

    public float getDirection() {
        return this.f49473w;
    }

    public boolean isDefault() {
        return this.f49437B;
    }

    public int getStatus() {
        return this.f49455c;
    }

    public void setCurrentStatus(int i) {
        this.f49455c = i;
    }
}
