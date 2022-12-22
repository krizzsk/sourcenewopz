package com.didi.component.bubbleLayout.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.bubbleLayout.anycar.AnycarBubbleLayout;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.animator.GlobalXPanelAnimatorImpl;
import com.didi.component.common.animator.IGlobalXPanelAnimator;
import com.didi.component.common.util.GLog;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class BubbleAnimationLayout extends RelativeLayout {

    /* renamed from: d */
    private static final String f11130d = "BubbleLayout";

    /* renamed from: e */
    private static final int f11131e = 1;

    /* renamed from: f */
    private static final int f11132f = 2;

    /* renamed from: g */
    private static final int f11133g = 3;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f11134A;

    /* renamed from: B */
    private int f11135B;

    /* renamed from: C */
    private AppCompatTextView f11136C;

    /* renamed from: D */
    private boolean f11137D;

    /* renamed from: E */
    private boolean f11138E;

    /* renamed from: F */
    private AnycarBubbleLayout f11139F;

    /* renamed from: G */
    private boolean f11140G;

    /* renamed from: a */
    int f11141a;

    /* renamed from: b */
    int f11142b;

    /* renamed from: c */
    int f11143c;

    /* renamed from: h */
    private int f11144h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View f11145i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f11146j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f11147k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public View f11148l;

    /* renamed from: m */
    private RecyclerView f11149m;

    /* renamed from: n */
    private IGlobalXPanelAnimator f11150n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f11151o;

    /* renamed from: p */
    private int f11152p;

    /* renamed from: q */
    private float f11153q;

    /* renamed from: r */
    private float f11154r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f11155s;

    /* renamed from: t */
    private final int f11156t;

    /* renamed from: u */
    private final int f11157u;

    /* renamed from: v */
    private final int f11158v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f11159w;

    /* renamed from: x */
    private boolean f11160x;

    /* renamed from: y */
    private IGlobalXPanelAnimator.VisibilityChangedListener f11161y;

    /* renamed from: z */
    private VelocityTracker f11162z;

    public static class StaticConfig {
        public static int AUTO_RECOVER_DURATION = 500;
        public static int FAULT_OFFSET = 5;
        public static int PULL_GUIDE_DURATION = 800;
        public static int PULL_UP_DURATION = 400;
        public static int TOUCH_THRESHOLD_Y_PIX = 7;
        public static int TOUCH_VELOCITY_THRESHOLD_AUTO_SCROLL = 100;
        public static int TOUCH_Y_THRESHOLD_AUTO_SCROLL = 150;
    }

    private int getLayoutId() {
        return R.layout.bubble_overlay_view;
    }

    public BubbleAnimationLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public BubbleAnimationLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleAnimationLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11151o = 0;
        this.f11152p = 0;
        this.f11155s = UiUtils.dip2px(getContext(), 129.0f);
        this.f11156t = UiUtils.dip2px(getContext(), 80.0f);
        this.f11157u = UiUtils.dip2px(getContext(), 13.0f);
        this.f11158v = UiUtils.dip2px(getContext(), 22.0f);
        this.f11159w = 2;
        this.f11160x = false;
        this.f11134A = false;
        this.f11135B = 0;
        this.f11141a = 0;
        this.f11142b = 0;
        this.f11143c = 0;
        this.f11140G = true;
        m7558a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f11152p = getMeasuredHeight();
    }

    /* renamed from: a */
    private void m7558a() {
        StaticConfig.TOUCH_THRESHOLD_Y_PIX = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f11150n = new GlobalXPanelAnimatorImpl();
        this.f11162z = VelocityTracker.obtain();
        this.f11161y = new IGlobalXPanelAnimator.VisibilityChangedListener() {
            public void onHidden() {
            }

            public void onHiddenStart() {
            }

            public void onShownStart() {
            }

            public void onShown() {
                BubbleAnimationLayout.this.m7590m();
            }
        };
    }

    public void bindAnycarView(AnycarBubbleLayout anycarBubbleLayout) {
        this.f11139F = anycarBubbleLayout;
    }

    public void bindView(View view, View view2, View view3, View view4) {
        this.f11145i = view;
        this.f11146j = view2;
        this.f11147k = view3;
        view2.post(new Runnable() {
            public void run() {
                GLog.m7965d(BubbleAnimationLayout.f11130d, "run: mFormView.getMeasuredHeight  = " + BubbleAnimationLayout.this.f11146j.getMeasuredHeight());
                if (!FormStore.getInstance().ismGroupFormViewChanged()) {
                    BubbleAnimationLayout bubbleAnimationLayout = BubbleAnimationLayout.this;
                    int unused = bubbleAnimationLayout.f11155s = bubbleAnimationLayout.f11146j.getMeasuredHeight();
                }
            }
        });
        RecyclerView recyclerView = (RecyclerView) this.f11145i.findViewById(R.id.new_estimate_all_list);
        this.f11149m = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false) {
                public boolean canScrollVertically() {
                    return BubbleAnimationLayout.this.f11159w == 1 || BubbleAnimationLayout.this.f11159w == 3;
                }
            });
        }
        m7567b();
    }

    public void hideViewByAnycar() {
        this.f11146j.setVisibility(8);
        this.f11147k.setVisibility(8);
        this.f11145i.setVisibility(8);
        setPadding(0, 0, 0, 0);
    }

    public void hideAnycarByOldEstimate() {
        int i = this.f11151o;
        if (i == 0 || i == 1) {
            this.f11147k.setVisibility(8);
            this.f11146j.setVisibility(0);
            this.f11145i.setVisibility(0);
            setPadding(0, UiUtils.dip2px(getContext(), 10.0f), 0, 0);
        }
    }

    /* renamed from: b */
    private void m7567b() {
        RecyclerView recyclerView = this.f11149m;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                }

                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    GLog.m7965d(BubbleAnimationLayout.f11130d, "onScrollStateChanged: " + i);
                    if (i == 0) {
                        if (recyclerView.computeVerticalScrollOffset() <= 0) {
                            int unused = BubbleAnimationLayout.this.f11159w = 1;
                        } else {
                            int unused2 = BubbleAnimationLayout.this.f11159w = 3;
                        }
                        GLog.m7965d(BubbleAnimationLayout.f11130d, "state赋值199: " + BubbleAnimationLayout.this.f11159w);
                    }
                }
            });
        }
    }

    public void setTopOffsetY(int i) {
        this.f11144h = i;
        m7571c();
    }

    public void setBottomCardHeight(int i) {
        this.f11155s = i;
        m7571c();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m7571c() {
        if (this.f11159w == 2) {
            m7572d();
            post(new Runnable() {
                public void run() {
                    BubbleAnimationLayout.this.m7590m();
                }
            });
        }
    }

    public void setCanPullUp(boolean z) {
        this.f11160x = z;
    }

    /* renamed from: d */
    private void m7572d() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f11145i.getLayoutParams();
        marginLayoutParams.topMargin = getPullDownStateMargin();
        this.f11145i.setLayoutParams(marginLayoutParams);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (m7576e() || motionEvent.getRawY() <= ((float) this.f11156t)) {
            return false;
        }
        if ((this.f11146j.getVisibility() == 0 && motionEvent.getRawY() >= ((float) (this.f11152p - this.f11155s))) || this.f11134A || this.f11151o != 1) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            float y = motionEvent.getY();
            this.f11153q = y;
            this.f11154r = y;
        } else if (action == 2) {
            GLog.m7965d(f11130d, "move, state: " + this.f11159w);
            float y2 = motionEvent.getY();
            int i = this.f11159w;
            if (i == 3) {
                return false;
            }
            if (i == 1) {
                if (Math.abs(y2 - this.f11153q) > ((float) StaticConfig.TOUCH_THRESHOLD_Y_PIX)) {
                    float f = this.f11153q;
                    if (f - y2 < 0.0f) {
                        return true;
                    }
                    if (f - y2 > 0.0f) {
                        this.f11159w = 3;
                        GLog.m7965d(f11130d, "state赋值292: " + this.f11159w);
                        return false;
                    }
                }
            } else if (Math.abs(y2 - this.f11153q) > ((float) StaticConfig.TOUCH_THRESHOLD_Y_PIX)) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0077, code lost:
        if (r0 != 4) goto L_0x00db;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.m7576e()
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            int r0 = r9.f11151o
            r2 = 2
            r3 = 3
            r4 = 1
            if (r0 == r3) goto L_0x0011
            if (r0 != r2) goto L_0x0020
        L_0x0011:
            float r0 = r10.getRawY()
            int r5 = r9.f11152p
            int r6 = r9.f11135B
            int r5 = r5 - r6
            float r5 = (float) r5
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x0020
            return r4
        L_0x0020:
            int r0 = r9.f11151o
            if (r0 == r4) goto L_0x0025
            return r1
        L_0x0025:
            float r0 = r10.getRawY()
            int r5 = r9.f11156t
            float r5 = (float) r5
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 > 0) goto L_0x0041
            boolean r0 = r9.f11137D
            if (r0 == 0) goto L_0x003c
            r9.f11137D = r1
            r9.f11138E = r1
            r9.m7562a((android.view.MotionEvent) r10)
            goto L_0x0041
        L_0x003c:
            boolean r10 = super.onTouchEvent(r10)
            return r10
        L_0x0041:
            android.view.View r0 = r9.f11146j
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0063
            float r0 = r10.getRawY()
            int r5 = r9.f11152p
            int r6 = r9.f11155s
            int r5 = r5 - r6
            float r5 = (float) r5
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x0063
            boolean r0 = r9.f11137D
            if (r0 == 0) goto L_0x0062
            r9.f11137D = r1
            r9.f11138E = r1
            r9.m7562a((android.view.MotionEvent) r10)
        L_0x0062:
            return r4
        L_0x0063:
            boolean r0 = r9.f11134A
            if (r0 == 0) goto L_0x0068
            return r4
        L_0x0068:
            boolean r0 = r9.f11160x
            if (r0 == 0) goto L_0x00db
            int r0 = r10.getAction()
            if (r0 == r4) goto L_0x00d4
            if (r0 == r2) goto L_0x007a
            if (r0 == r3) goto L_0x00d4
            r2 = 4
            if (r0 == r2) goto L_0x00d4
            goto L_0x00db
        L_0x007a:
            r9.f11137D = r4
            float r0 = r10.getY()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onTouchEvent: move = "
            r1.append(r2)
            float r2 = r9.f11154r
            float r2 = r0 - r2
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "BubbleLayout"
            com.didi.component.common.util.GLog.m7965d(r2, r1)
            float r1 = r9.f11154r
            float r1 = r0 - r1
            double r5 = (double) r1
            r7 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r5 = r5 + r7
            int r1 = (int) r5
            r9.m7560a((int) r1)
            r9.f11154r = r0
            boolean r0 = r9.f11138E
            if (r0 != 0) goto L_0x00db
            if (r1 > 0) goto L_0x00db
            r9.f11138E = r4
            com.didi.component.core.event.BaseEventPublisher r0 = com.didi.component.core.event.BaseEventPublisher.getPublisher()
            r5 = 8
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "event_confirm_sense_top_window_visibility"
            r0.publish(r6, r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "EVENT_CONFIRM_SENSE_TOP_WINDOW_VISIBILITY "
            r0.append(r5)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.didi.component.common.util.GLog.m7965d(r2, r0)
            goto L_0x00db
        L_0x00d4:
            r9.m7562a((android.view.MotionEvent) r10)
            r9.f11138E = r1
            r9.f11137D = r1
        L_0x00db:
            int r0 = r9.f11159w
            if (r0 == r4) goto L_0x00f6
            if (r0 == r3) goto L_0x00f6
            float r0 = r10.getY()
            android.view.View r1 = r9.f11145i
            int r1 = r1.getTop()
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x00f1
            goto L_0x00f6
        L_0x00f1:
            boolean r10 = super.onTouchEvent(r10)
            return r10
        L_0x00f6:
            android.view.VelocityTracker r0 = r9.f11162z
            r0.addMovement(r10)
            android.view.VelocityTracker r10 = r9.f11162z
            r10.getYVelocity()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.bubbleLayout.view.BubbleAnimationLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: e */
    private boolean m7576e() {
        if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
            return PageCompDataTransfer.getInstance().getConfirmListener().getIsAnyCar();
        }
        return false;
    }

    public void showEstimatePage() {
        final ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        int i = this.f11151o;
        if (i == 0) {
            this.f11147k.setVisibility(8);
            m7580g();
            AnycarBubbleLayout anycarBubbleLayout = this.f11139F;
            if (anycarBubbleLayout != null) {
                anycarBubbleLayout.setVisibility(0);
                this.f11139F.showEstimateWithAnimation(true);
            }
            this.f11151o = 1;
            if (confirmListener != null) {
                confirmListener.setCurrentPage(1);
            }
        } else if (i != 3) {
        } else {
            if (m7576e()) {
                this.f11139F.setVisibility(0);
                this.f11139F.showEstimateWithAnimation(false);
                this.f11147k.setVisibility(8);
                this.f11151o = 1;
                if (confirmListener != null) {
                    confirmListener.setCurrentPage(1);
                    return;
                }
                return;
            }
            this.f11145i.setVisibility(4);
            post(new Runnable() {
                public void run() {
                    if (BubbleAnimationLayout.this.m7578f()) {
                        int unused = BubbleAnimationLayout.this.f11151o = 1;
                        ConfirmListener confirmListener = confirmListener;
                        if (confirmListener != null) {
                            confirmListener.setCurrentPage(BubbleAnimationLayout.this.f11151o);
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public boolean m7578f() {
        if (this.f11148l == null) {
            this.f11148l = LayoutInflater.from(getContext()).inflate(getLayoutId(), this, false);
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) this.f11148l.findViewById(R.id.form_btn);
        this.f11136C = appCompatTextView;
        appCompatTextView.setText(R.string.global_confirm_btn);
        if (this.f11148l.getParent() != null) {
            return false;
        }
        this.f11141a = this.f11147k.getMeasuredHeight();
        this.f11142b = this.f11145i.getMeasuredHeight() - UiUtils.dip2px(getContext(), 10.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f11141a);
        layoutParams.addRule(12);
        addView(this.f11148l, layoutParams);
        ValueAnimator duration = ValueAnimator.ofInt(new int[]{this.f11141a, this.f11142b}).setDuration((long) StaticConfig.PULL_UP_DURATION);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                GLog.m7965d(BubbleAnimationLayout.f11130d, "onAnimationUpdate: " + valueAnimator.getAnimatedValue());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) BubbleAnimationLayout.this.f11148l.getLayoutParams();
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                BubbleAnimationLayout.this.f11148l.setLayoutParams(layoutParams);
            }
        });
        duration.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BubbleAnimationLayout.this.f11147k.setVisibility(8);
                BubbleAnimationLayout.this.f11145i.setVisibility(0);
                BubbleAnimationLayout.this.f11146j.setVisibility(0);
                BubbleAnimationLayout bubbleAnimationLayout = BubbleAnimationLayout.this;
                bubbleAnimationLayout.removeView(bubbleAnimationLayout.f11148l);
                BubbleAnimationLayout.this.m7590m();
            }
        });
        duration.start();
        return true;
    }

    private int getPullDownStateMargin() {
        return (this.f11152p - this.f11144h) - this.f11155s;
    }

    /* renamed from: g */
    private void m7580g() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f11145i.getLayoutParams();
        marginLayoutParams.topMargin = getPullDownStateMargin();
        this.f11145i.setLayoutParams(marginLayoutParams);
        setTranslationY((float) (this.f11144h + this.f11155s));
        showBottomCard();
        this.f11145i.setVisibility(0);
        post(new Runnable() {
            public void run() {
                final ViewPropertyAnimator animate = BubbleAnimationLayout.this.animate();
                animate.translationY(0.0f);
                animate.setDuration((long) StaticConfig.PULL_UP_DURATION);
                animate.setListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        animate.setListener((Animator.AnimatorListener) null);
                        if (!GlobalSPUtil.isShowBubblePullGuide(BubbleAnimationLayout.this.getContext())) {
                            BubbleAnimationLayout.this.m7590m();
                        }
                        BubbleAnimationLayout.this.m7571c();
                    }
                });
                animate.start();
            }
        });
    }

    public void showConfirmAddressPage() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (this.f11151o != 1) {
            this.f11146j.setVisibility(8);
            this.f11145i.setVisibility(8);
            AnycarBubbleLayout anycarBubbleLayout = this.f11139F;
            if (anycarBubbleLayout != null) {
                anycarBubbleLayout.setVisibility(8);
            }
            this.f11150n.initPrepare(this.f11147k);
            this.f11150n.show(this.f11147k, 0, this.f11161y);
            this.f11151o = 3;
            if (confirmListener != null) {
                confirmListener.setCurrentPage(3);
                return;
            }
            return;
        }
        AnycarBubbleLayout anycarBubbleLayout2 = this.f11139F;
        if (anycarBubbleLayout2 != null) {
            anycarBubbleLayout2.setVisibility(8);
        }
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.EVENT_ESTIMATE_IS_ONE_CAR, false);
        if (m7582h()) {
            this.f11151o = 3;
            if (confirmListener != null) {
                confirmListener.setCurrentPage(3);
            }
        }
    }

    /* renamed from: h */
    private boolean m7582h() {
        if (this.f11148l == null) {
            this.f11148l = LayoutInflater.from(getContext()).inflate(getLayoutId(), this, false);
        }
        if (this.f11148l.getParent() != null) {
            return false;
        }
        this.f11147k.setVisibility(4);
        this.f11147k.post(new Runnable() {
            public void run() {
                BubbleAnimationLayout bubbleAnimationLayout = BubbleAnimationLayout.this;
                bubbleAnimationLayout.f11141a = bubbleAnimationLayout.f11147k.getMeasuredHeight();
                BubbleAnimationLayout bubbleAnimationLayout2 = BubbleAnimationLayout.this;
                bubbleAnimationLayout2.f11142b = bubbleAnimationLayout2.f11145i.getMeasuredHeight() - UiUtils.dip2px(BubbleAnimationLayout.this.getContext(), 4.0f);
                BubbleAnimationLayout.this.f11145i.setVisibility(4);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BubbleAnimationLayout.this.f11142b);
                layoutParams.addRule(12);
                BubbleAnimationLayout bubbleAnimationLayout3 = BubbleAnimationLayout.this;
                bubbleAnimationLayout3.addView(bubbleAnimationLayout3.f11148l, layoutParams);
                BubbleAnimationLayout.this.m7583i();
            }
        });
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m7583i() {
        ValueAnimator duration = ValueAnimator.ofInt(new int[]{this.f11142b, this.f11141a}).setDuration((long) StaticConfig.PULL_UP_DURATION);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                GLog.m7965d(BubbleAnimationLayout.f11130d, "onAnimationUpdate: " + valueAnimator.getAnimatedValue());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) BubbleAnimationLayout.this.f11148l.getLayoutParams();
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                BubbleAnimationLayout.this.f11148l.setLayoutParams(layoutParams);
            }
        });
        duration.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BubbleAnimationLayout.this.f11147k.setVisibility(0);
                BubbleAnimationLayout.this.f11145i.setVisibility(8);
                BubbleAnimationLayout.this.f11146j.setVisibility(8);
                BubbleAnimationLayout bubbleAnimationLayout = BubbleAnimationLayout.this;
                bubbleAnimationLayout.removeView(bubbleAnimationLayout.f11148l);
                BubbleAnimationLayout.this.m7590m();
            }
        });
        duration.start();
    }

    public void hideAndShow() {
        int i = this.f11159w;
        if (i != 2 && i != 0) {
            scrollToBottom();
        }
    }

    /* renamed from: a */
    private void m7562a(MotionEvent motionEvent) {
        m7585j();
        int currentMarginTop = getCurrentMarginTop();
        this.f11162z.computeCurrentVelocity(1000);
        if (this.f11162z.getYVelocity() > ((float) StaticConfig.TOUCH_VELOCITY_THRESHOLD_AUTO_SCROLL)) {
            if (motionEvent.getY() - this.f11153q > ((float) (StaticConfig.TOUCH_Y_THRESHOLD_AUTO_SCROLL / 3))) {
                scrollToBottom();
                return;
            } else if (this.f11153q - motionEvent.getY() > ((float) (StaticConfig.TOUCH_Y_THRESHOLD_AUTO_SCROLL / 3))) {
                scrollToTop();
                return;
            }
        }
        if (motionEvent.getY() - this.f11153q > ((float) StaticConfig.TOUCH_Y_THRESHOLD_AUTO_SCROLL)) {
            scrollToBottom();
        } else if (this.f11153q - motionEvent.getY() > ((float) StaticConfig.TOUCH_Y_THRESHOLD_AUTO_SCROLL)) {
            scrollToTop();
        } else if (currentMarginTop > (this.f11152p * 3) / 10) {
            scrollToBottom();
        } else {
            scrollToTop();
        }
    }

    /* renamed from: j */
    private void m7585j() {
        HashMap hashMap = new HashMap();
        String estimateModelTraceId = FormStore.getInstance().getEstimateModelTraceId();
        if (estimateModelTraceId != null) {
            hashMap.put(ParamConst.TRACE_ID, estimateModelTraceId);
        }
        OmegaSDKAdapter.trackEvent("gp_orderconfirm_modeXpanel_sp", (Map<String, Object>) hashMap);
    }

    public void scrollToTop() {
        m7561a(-getCurrentMarginTop(), -0.5f, true);
    }

    public void scrollToBottom() {
        m7561a(getPullDownStateMargin() - getCurrentMarginTop(), 0.5f, false);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_CONFIRM_SENSE_TOP_WINDOW_VISIBILITY, 0);
    }

    /* renamed from: a */
    private void m7561a(final int i, final float f, final boolean z) {
        long abs = (long) (this.f11152p != 0 ? (StaticConfig.AUTO_RECOVER_DURATION * Math.abs(i)) / this.f11152p : StaticConfig.AUTO_RECOVER_DURATION);
        this.f11143c = 0;
        GLog.m7965d(f11130d, "performScrollAnimation: 时长 " + abs);
        this.f11134A = true;
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(abs);
        duration.setInterpolator(new TimeInterpolator() {
            public float getInterpolation(float f) {
                return ((-f) * f) + (f * 2.0f);
            }
        });
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) ((((Float) valueAnimator.getAnimatedValue()).floatValue() * ((float) i)) + f);
                GLog.m7965d(BubbleAnimationLayout.f11130d, "onAnimationUpdate: currentY " + floatValue);
                BubbleAnimationLayout bubbleAnimationLayout = BubbleAnimationLayout.this;
                bubbleAnimationLayout.m7560a(floatValue - bubbleAnimationLayout.f11143c);
                BubbleAnimationLayout.this.f11143c = floatValue;
            }
        });
        duration.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = BubbleAnimationLayout.this.f11134A = false;
                if (z) {
                    BubbleAnimationLayout.this.m7587k();
                } else {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_VERTICAL_ESTIMATE_VIEW_BOTTOM);
                }
                BubbleAnimationLayout.this.m7590m();
            }
        });
        duration.start();
    }

    private int getCurrentMarginTop() {
        return ((ViewGroup.MarginLayoutParams) this.f11145i.getLayoutParams()).topMargin;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7560a(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f11145i.getLayoutParams();
        marginLayoutParams.topMargin += i;
        if (marginLayoutParams.topMargin < 0) {
            marginLayoutParams.topMargin = 0;
        }
        if (marginLayoutParams.topMargin <= (-(this.f11144h - this.f11156t)) + StaticConfig.FAULT_OFFSET) {
            marginLayoutParams.topMargin = -(this.f11144h - this.f11156t);
            m7587k();
        }
        if (marginLayoutParams.topMargin >= getPullDownStateMargin() - StaticConfig.FAULT_OFFSET) {
            marginLayoutParams.topMargin = getPullDownStateMargin();
            m7568b(i);
            if (FormStore.getInstance().getNewEstimateItem() != null) {
                showBottomCard();
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_TOP_MARGIN_CHANGED, true);
            }
        }
        if (marginLayoutParams.topMargin < getPullDownStateMargin() - this.f11157u) {
            hideBottomCard();
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_TOP_MARGIN_CHANGED, false);
        }
        this.f11145i.setLayoutParams(marginLayoutParams);
        m7589l();
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED_SCROLL_LISTENER, Integer.valueOf(this.f11144h));
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m7587k() {
        GLog.m7965d(f11130d, "onPullToTop: ");
        this.f11159w = 1;
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_VERTICAL_ESTIMATE_VIEW_TOP);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_CONFIRM_SENSE_TOP_WINDOW_VISIBILITY, 8);
    }

    /* renamed from: b */
    private void m7568b(int i) {
        GLog.m7965d(f11130d, "onPullToBottom: ");
        this.f11159w = 2;
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_VERTICAL_ESTIMATE_VIEW_BOTTOM);
        if (this.f11151o == 1 && this.f11135B != 0 && i > 0) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Location.EVENT_BEST_VIEW);
        }
    }

    /* renamed from: l */
    private void m7589l() {
        float currentMarginTop = (((float) getCurrentMarginTop()) - ((float) this.f11156t)) / ((float) (getPullDownStateMargin() - this.f11156t));
        if (currentMarginTop < 0.0f) {
            currentMarginTop = 0.0f;
        } else if (currentMarginTop > 1.0f) {
            currentMarginTop = 1.0f;
        }
        m7559a(currentMarginTop);
    }

    /* renamed from: a */
    private void m7559a(float f) {
        int i = 128 - ((int) (128.0f * f));
        setBackgroundColor(Color.argb(i, 0, 0, 0));
        if (i >= 180 && this.f11140G) {
            this.f11140G = false;
        } else if (i < 180 && !this.f11140G) {
            this.f11140G = true;
        }
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_RECOMMAND_SLIDE, Float.valueOf(f));
    }

    public void hideBottomCard() {
        if (this.f11146j.getVisibility() != 8) {
            this.f11146j.setVisibility(8);
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_BOTTOM_FORM_HINTED);
        }
    }

    public void showBottomCard() {
        if (this.f11146j.getVisibility() != 0) {
            this.f11146j.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m7590m() {
        Integer num = 0;
        int i = this.f11151o;
        if (i == 1) {
            num = Integer.valueOf((this.f11144h + this.f11155s) - this.f11158v);
        } else if (i == 3) {
            num = Integer.valueOf(this.f11147k.getMeasuredHeight());
        }
        this.f11135B = num.intValue();
        GLog.m7965d(f11130d, "onDefaultHeightChanged: " + num);
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, num);
    }

    public void refreshBestView() {
        m7590m();
    }
}
