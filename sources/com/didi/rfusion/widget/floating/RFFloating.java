package com.didi.rfusion.widget.floating;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.didi.app.nova.skeleton.Component;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.internal.page.PageWrapper;
import com.didi.rfusion.config.RFLogger;
import com.didi.rfusion.config.RFusionConfig;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.utils.RFSystemBarUtils;
import com.didi.rfusion.utils.RFUtils;
import com.didi.rfusion.utils.tracker.RFTrackerHelper;
import com.didi.rfusion.widget.floating.RFExpandRelativeLayout;
import com.didi.rfusion.widget.floating.RFFloating;
import com.didi.rfusion.widget.floating.RFFloatingIconAttr;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RFFloating extends Page {
    public static final int LAUNCH_MODE_CLEAR_TASK = 1;
    public static final int LAUNCH_MODE_STANDARD = 0;
    public static final int TYPE_AUTO = 1;
    public static final int TYPE_FIXED = 2;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f33525a;

    /* renamed from: b */
    private static final String f33526b = "RFFloating";

    /* renamed from: l */
    static final String f33527l;

    /* renamed from: m */
    static final String f33528m;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final RFusionConfig.IRFusionLogger f33529c = RFLogger.getLogger();

    /* renamed from: d */
    private OnDismissListener f33530d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FrameLayout f33531e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public RFRoundRelativeLayout f33532f;

    /* renamed from: g */
    private RFExpandRelativeLayout f33533g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public RelativeLayout f33534h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public FrameLayout f33535i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public PageInstrument f33536j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public RFFloatingNavBarController f33537k = new RFFloatingNavBarController();
    /* access modifiers changed from: private */

    /* renamed from: n */
    public C11557a f33538n = new C11557a();

    /* renamed from: o */
    private RFFloatingChangeHandler f33539o = new RFFloatingChangeHandler(false);

    /* renamed from: p */
    private boolean f33540p;

    /* renamed from: q */
    private int f33541q = 1;

    /* renamed from: r */
    private boolean f33542r = true;

    /* renamed from: s */
    private int f33543s = 1;

    /* renamed from: t */
    private boolean f33544t = false;

    /* renamed from: u */
    private IScopeLifecycle f33545u = new IScopeLifecycle() {
        LinkedList<Integer> mPageIdList = new LinkedList<>();

        public void onPause(ILive iLive) {
        }

        public void onStop(ILive iLive) {
        }

        public void onCreate(ILive iLive) {
            int navBarId = getNavBarId(iLive);
            RFFloating.this.f33537k.mo87850a(navBarId);
            RFFloating.this.f33537k.mo87855a(navBarId, true);
            RFFloating.this.f33538n.mo87893b(navBarId);
            RFFloating.this.f33538n.mo87891a(navBarId);
            this.mPageIdList.add(Integer.valueOf(navBarId));
            RFusionConfig.IRFusionLogger d = RFFloating.this.f33529c;
            d.info(RFFloating.f33526b, "onCreate: " + navBarId);
        }

        public void onStart(ILive iLive) {
            int navBarId = getNavBarId(iLive);
            if (this.mPageIdList.getLast().intValue() != navBarId) {
                RFFloating.this.f33537k.mo87855a(navBarId, false);
                RFFloating.this.f33538n.mo87891a(navBarId);
            }
            RFusionConfig.IRFusionLogger d = RFFloating.this.f33529c;
            d.info(RFFloating.f33526b, "onStart: " + navBarId);
        }

        public void onResume(ILive iLive) {
            int navBarId = getNavBarId(iLive);
            if (this.mPageIdList.getLast().intValue() == navBarId) {
                RFFloating.this.f33538n.mo87891a(navBarId);
            }
        }

        public void onDestroy(ILive iLive) {
            int navBarId = getNavBarId(iLive);
            RFFloating.this.f33537k.mo87857b(navBarId);
            RFFloating.this.f33538n.mo87894c(navBarId);
            this.mPageIdList.remove(Integer.valueOf(navBarId));
            RFusionConfig.IRFusionLogger d = RFFloating.this.f33529c;
            d.info(RFFloating.f33526b, "onDestroy: " + navBarId);
            if (!RFFloating.this.f33536j.hasRootPage()) {
                RFFloating.this.dismiss();
            }
        }

        private int getNavBarId(ILive iLive) {
            return ((PageWrapper) iLive).getArgs().getInt(RFFloating.f33525a);
        }
    };

    public interface OnDismissListener {
        void onDismiss(RFFloating rFFloating);
    }

    /* access modifiers changed from: protected */
    public void initNavBar(RFFloatingNavBar rFFloatingNavBar) {
    }

    @Deprecated
    public void setupComponents(View view) {
    }

    static {
        Class<RFFloating> cls = RFFloating.class;
        f33527l = cls.getSimpleName() + ":CONTROLLER";
        f33528m = cls.getSimpleName() + ":NAV_BAR";
        f33525a = cls.getSimpleName() + ":ID";
    }

    public void show(ScopeContext scopeContext) {
        if (!this.f33544t) {
            scopeContext.getNavigator().push(this);
            this.f33544t = true;
        }
    }

    public void dismiss() {
        dismiss((Bundle) null);
    }

    public void dismiss(final Bundle bundle) {
        if (this.f33544t) {
            this.f33544t = false;
            this.f33529c.info(f33526b, "dismiss: start exit animator");
            Animator exitAnimator = this.f33539o.getExitAnimator(getView());
            exitAnimator.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    RFFloating.this.m23597a(bundle);
                }
            });
            exitAnimator.start();
        }
    }

    public void setDismissible(boolean z) {
        this.f33540p = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23597a(Bundle bundle) {
        m23609d();
        finish(bundle);
        this.f33529c.info(f33526b, "dismiss: success");
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f33530d = onDismissListener;
    }

    public void setShowBackground(boolean z) {
        this.f33542r = z;
        if (this.f33531e != null) {
            m23602a(z);
        }
    }

    public void setFitSystemWindow(boolean z) {
        int statusBarHeight = z ? RFSystemBarUtils.getStatusBarHeight(getBaseContext()) : 0;
        FrameLayout frameLayout = this.f33531e;
        frameLayout.setPadding(frameLayout.getLeft(), statusBarHeight, this.f33531e.getRight(), this.f33531e.getBottom());
    }

    public final View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.rf_floating_main, viewGroup, false);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        this.f33531e = (FrameLayout) findViewById(R.id.rf_fl_floating);
        this.f33532f = (RFRoundRelativeLayout) findViewById(R.id.rf_rrl_frame);
        this.f33533g = (RFExpandRelativeLayout) findViewById(R.id.rf_erl_frame);
        this.f33534h = (RelativeLayout) findViewById(R.id.rf_rl_container);
        this.f33535i = (FrameLayout) findViewById(R.id.rf_fl_nav_bar_container);
        this.f33537k.mo87856a(view);
        m23602a(this.f33542r);
        Context baseContext = getBaseContext();
        if ((baseContext instanceof Activity) && RFSystemBarUtils.isTranslucentStatusBar((Activity) baseContext)) {
            setFitSystemWindow(true);
        }
        setType(1);
        m23599a((Page) this);
        initNavBar(getNavBar());
        this.f33533g.setGestureListener(new RFFloatingGesture(this.f33534h));
        this.f33531e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RFFloating.this.m23605b(view);
            }
        });
        this.f33534h.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
            public void onChildViewRemoved(View view, View view2) {
            }

            public void onChildViewAdded(View view, View view2) {
                RFFloating.this.m23604b();
            }
        });
        this.f33544t = true;
        RFTrackerHelper.trackFloatingShow();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m23605b(View view) {
        if (this.f33540p) {
            dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23599a(Page page) {
        int e = m23610e();
        if (!this.f33537k.mo87860b()) {
            this.f33537k.mo87854a(e, new C11559c((RFFloatingTextAttr) null, new RFFloatingIconAttr.Builder(1).click(new View.OnClickListener() {
                public final void onClick(View view) {
                    RFFloating.this.m23598a(view);
                }
            }).build(), (RFFloatingTextAttr) null, true, false, RFResUtils.getColor(R.color.rf_color_white_100_FFFFFF)));
            this.f33538n.mo87893b(e);
            this.f33538n.mo87891a(e);
        }
        Bundle bundle = new Bundle();
        RFFloatingNavBar rFFloatingNavBar = new RFFloatingNavBar(this.f33537k, e);
        bundle.putSerializable(f33527l, new RFFloatingControllerProxy(this, this.f33538n, e));
        bundle.putSerializable(f33528m, rFFloatingNavBar);
        bundle.putSerializable(f33525a, Integer.valueOf(e));
        page.setArgs(bundle);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23598a(View view) {
        dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m23604b() {
        if (this.f33534h.getChildCount() > 0) {
            int i = this.f33534h.getChildAt(0).getLayoutParams().height;
            if (!RFUtils.isPadFlavor() && this.f33543s == 1) {
                ViewGroup.LayoutParams layoutParams = this.f33533g.getLayoutParams();
                if (i == -1) {
                    layoutParams.height = this.f33533g.getMinimumHeight();
                } else {
                    layoutParams.height = -2;
                }
                this.f33533g.setLayoutParams(layoutParams);
            }
        }
    }

    /* renamed from: a */
    private void m23602a(boolean z) {
        if (z) {
            this.f33531e.setBackgroundColor(RFResUtils.getColor(getBaseContext(), R.color.rf_color_gery_12_0_7F000000));
        } else {
            this.f33531e.setBackgroundColor(RFResUtils.getColor(getBaseContext(), R.color.rf_color_white_100_alpha_0));
        }
        this.f33531e.getBackground().mutate();
    }

    public void onStart() {
        super.onStart();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f33544t = false;
        this.f33537k.mo87849a();
        OnDismissListener onDismissListener = this.f33530d;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
    }

    public void setArgs(Bundle bundle) {
        super.setArgs(bundle);
    }

    public Bundle getArgs() {
        return super.getArgs();
    }

    /* access modifiers changed from: protected */
    public boolean addComponent(Component component) {
        return super.addComponent(component);
    }

    public boolean onHandleBack() {
        if (this.f33536j != null) {
            return true;
        }
        dismiss();
        return true;
    }

    public ControllerChangeHandler getPushHandler() {
        return this.f33539o;
    }

    public ControllerChangeHandler getPopHandler() {
        return new EmptyChangeHandler(false);
    }

    /* access modifiers changed from: protected */
    public void setContentView(int i) {
        m23607c();
        LayoutInflater.from(getBaseContext()).inflate(i, this.f33534h);
    }

    /* access modifiers changed from: protected */
    public void setContentView(View view) {
        m23607c();
        this.f33534h.addView(view);
    }

    /* access modifiers changed from: protected */
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m23607c();
        this.f33534h.addView(view, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void setContentView(Page page) {
        m23607c();
        if (this.f33536j == null) {
            this.f33536j = getInstrument(this.f33534h, "", true);
        }
        PageInstrument pageInstrument = this.f33536j;
        if (pageInstrument != null) {
            pageInstrument.setPagePushCallback(new PageInstrument.IPagePushCallback() {
                public final void pageConfigureOnPush(Page page) {
                    RFFloating.this.m23599a(page);
                }
            });
            this.f33536j.registerPageLifecycleCallback(this.f33545u);
            if (!this.f33536j.hasRootPage()) {
                this.f33536j.setRootPage(page);
                return;
            }
            return;
        }
        throw new RuntimeException("InnerPageInstrument create failed");
    }

    public void pushPage(Page page) {
        pushPage(page, 0);
    }

    public void pushPage(Page page, int i) {
        PageInstrument pageInstrument;
        if (page != null && (pageInstrument = this.f33536j) != null) {
            if (i == 1) {
                pageInstrument.setRootPage(page);
            } else if (pageInstrument.hasRootPage()) {
                this.f33536j.pushPage(page);
            } else {
                this.f33536j.setRootPage(page);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setType(int i) {
        if (this.f33543s != i) {
            this.f33543s = i;
            if (!RFUtils.isPadFlavor()) {
                int i2 = i == 1 ? -2 : -1;
                ViewGroup.LayoutParams layoutParams = this.f33533g.getLayoutParams();
                layoutParams.height = i2;
                this.f33533g.setLayoutParams(layoutParams);
            }
            m23604b();
        }
    }

    /* access modifiers changed from: protected */
    public RFFloatingNavBar getNavBar() {
        return (RFFloatingNavBar) getArgs().getSerializable(f33528m);
    }

    /* access modifiers changed from: protected */
    public void setGestureEnable(boolean z) {
        RFFloatingControllerProxy rFFloatingControllerProxy = (RFFloatingControllerProxy) getArgs().getSerializable(f33527l);
        if (rFFloatingControllerProxy != null) {
            rFFloatingControllerProxy.setGestureEnable(z);
        }
    }

    /* renamed from: c */
    private void m23607c() {
        if (this.f33536j != null) {
            m23609d();
        } else {
            this.f33534h.removeAllViews();
        }
    }

    /* renamed from: d */
    private void m23609d() {
        PageInstrument pageInstrument = this.f33536j;
        if (pageInstrument != null) {
            pageInstrument.popToRoot();
            this.f33536j.pop();
            this.f33536j.unregisterPageLifecycleCallback(this.f33545u);
            this.f33536j = null;
        }
    }

    /* renamed from: e */
    private int m23610e() {
        if (this.f33541q >= 2147483646) {
            this.f33541q = 0;
        }
        int i = this.f33541q + 1;
        this.f33541q = i;
        return i;
    }

    private class RFFloatingGesture implements RFExpandRelativeLayout.OnGestureListener {
        private static final int ANIMATION_TIME = 300;
        private static final int HEX_FF = 255;
        private boolean isDisallow = false;
        private boolean isEnableGesture = true;
        private boolean isHitNavBar = false;
        private boolean isIntercept = false;
        private boolean isMove = false;
        private float mDistanceX;
        private float mDistanceY;
        private View mHitView = null;
        private float mLastX;
        private float mLastY;
        private List<View> mScrollableViewList = new ArrayList();
        private Rect mTempHitRect = new Rect();
        private final int mTouchSlop = ViewConfiguration.get(RFFloating.this.getBaseContext()).getScaledTouchSlop();
        private float mTouchX;
        private float mTouchY;
        private int mTranslateHeight = 0;
        private VelocityTracker mVelocityTracker;

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public RFFloatingGesture(View view) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    RFFloating.RFFloatingGesture.this.lambda$new$0$RFFloating$RFFloatingGesture(view, i, i2, i3, i4, i5, i6, i7, i8);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$RFFloating$RFFloatingGesture(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            initScrollableViews();
        }

        private void initScrollableViews() {
            this.mScrollableViewList.clear();
            RFViewScrollChecker.scanScrollableViews(RFFloating.this.f33534h, this.mScrollableViewList);
            Collections.reverse(this.mScrollableViewList);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001f, code lost:
            if (r4 != 3) goto L_0x0132;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean dispatchTouchEvent(android.view.MotionEvent r4) {
            /*
                r3 = this;
                float r0 = r4.getRawX()
                r3.mTouchX = r0
                float r0 = r4.getRawY()
                r3.mTouchY = r0
                r0 = 0
                r3.isIntercept = r0
                r3.acquireVelocityTracker(r4)
                int r4 = r4.getAction()
                r1 = 1
                if (r4 == 0) goto L_0x00dc
                if (r4 == r1) goto L_0x009b
                r2 = 2
                if (r4 == r2) goto L_0x0023
                r0 = 3
                if (r4 == r0) goto L_0x009b
                goto L_0x0132
            L_0x0023:
                boolean r4 = r3.isEnableGesture
                if (r4 != 0) goto L_0x0029
                goto L_0x0132
            L_0x0029:
                boolean r4 = r3.isDisallow
                if (r4 == 0) goto L_0x0035
                boolean r4 = r3.isHitViewDisallow()
                if (r4 != 0) goto L_0x0035
                goto L_0x0132
            L_0x0035:
                float r4 = r3.mTouchX
                float r2 = r3.mLastX
                float r4 = r4 - r2
                r3.mDistanceX = r4
                float r4 = r3.mTouchY
                float r2 = r3.mLastY
                float r4 = r4 - r2
                r3.mDistanceY = r4
                android.view.VelocityTracker r4 = r3.mVelocityTracker
                r2 = 1000(0x3e8, float:1.401E-42)
                r4.computeCurrentVelocity(r2)
                boolean r4 = r3.isMove
                if (r4 != 0) goto L_0x0090
                float r4 = r3.mDistanceY
                r2 = 0
                int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x0132
                boolean r4 = r3.isHitNavBar
                if (r4 != 0) goto L_0x0063
                android.view.View r4 = r3.mHitView
                if (r4 == 0) goto L_0x0063
                boolean r4 = com.didi.rfusion.widget.floating.RFViewScrollChecker.isScrollTop((android.view.View) r4)
                if (r4 == 0) goto L_0x0132
            L_0x0063:
                float r4 = r3.mDistanceY
                float r4 = java.lang.Math.abs(r4)
                float r2 = r3.mDistanceX
                float r2 = java.lang.Math.abs(r2)
                int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x0081
                float r4 = r3.mDistanceY
                float r4 = java.lang.Math.abs(r4)
                int r2 = r3.mTouchSlop
                float r2 = (float) r2
                int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x0081
                r0 = 1
            L_0x0081:
                r3.isMove = r0
                if (r0 == 0) goto L_0x0132
                float r4 = r3.mDistanceX
                float r0 = r3.mDistanceY
                r3.onDragStart(r4, r0)
                r3.isIntercept = r1
                goto L_0x0132
            L_0x0090:
                float r4 = r3.mDistanceX
                float r0 = r3.mDistanceY
                r3.onDraging(r4, r0)
                r3.isIntercept = r1
                goto L_0x0132
            L_0x009b:
                boolean r4 = r3.isEnableGesture
                if (r4 != 0) goto L_0x00a1
                goto L_0x0132
            L_0x00a1:
                boolean r4 = r3.isDisallow
                if (r4 == 0) goto L_0x00ad
                boolean r4 = r3.isHitViewDisallow()
                if (r4 != 0) goto L_0x00ad
                goto L_0x0132
            L_0x00ad:
                float r4 = r3.mTouchX
                float r0 = r3.mLastX
                float r4 = r4 - r0
                r3.mDistanceX = r4
                float r4 = r3.mTouchY
                float r0 = r3.mLastY
                float r4 = r4 - r0
                r3.mDistanceY = r4
                boolean r4 = r3.isMove
                if (r4 == 0) goto L_0x00d8
                android.view.VelocityTracker r4 = r3.mVelocityTracker
                float r4 = r4.getYVelocity()
                r0 = 1133903872(0x43960000, float:300.0)
                int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r4 <= 0) goto L_0x00cf
                r3.startCollapseAnim()
                goto L_0x00d6
            L_0x00cf:
                float r4 = r3.mDistanceX
                float r0 = r3.mDistanceY
                r3.onDragEnd(r4, r0)
            L_0x00d6:
                r3.isIntercept = r1
            L_0x00d8:
                r3.releaseVelocityTracker()
                goto L_0x0132
            L_0x00dc:
                r3.isHitNavBar = r0
                r3.isMove = r0
                r3.isDisallow = r0
                r4 = 0
                r3.mHitView = r4
                com.didi.rfusion.widget.floating.RFFloating r4 = com.didi.rfusion.widget.floating.RFFloating.this
                com.didi.rfusion.widget.floating.a r4 = r4.f33538n
                java.lang.Integer r4 = r4.mo87890a()
                if (r4 == 0) goto L_0x0101
                com.didi.rfusion.widget.floating.RFFloating r2 = com.didi.rfusion.widget.floating.RFFloating.this
                com.didi.rfusion.widget.floating.a r2 = r2.f33538n
                int r4 = r4.intValue()
                boolean r4 = r2.mo87895d(r4)
                if (r4 == 0) goto L_0x0102
            L_0x0101:
                r0 = 1
            L_0x0102:
                r3.isEnableGesture = r0
                com.didi.rfusion.widget.floating.RFFloating r4 = com.didi.rfusion.widget.floating.RFFloating.this
                android.widget.FrameLayout r4 = r4.f33531e
                int r4 = r4.getHeight()
                com.didi.rfusion.widget.floating.RFFloating r0 = com.didi.rfusion.widget.floating.RFFloating.this
                com.didi.rfusion.widget.floating.RFRoundRelativeLayout r0 = r0.f33532f
                int r0 = r0.getTop()
                int r4 = r4 - r0
                r3.mTranslateHeight = r4
                float r4 = r3.mTouchX
                float r0 = r3.mTouchY
                boolean r4 = r3.isHitNavBar(r4, r0)
                if (r4 == 0) goto L_0x0128
                r3.isHitNavBar = r1
                goto L_0x0132
            L_0x0128:
                float r4 = r3.mTouchX
                float r0 = r3.mTouchY
                android.view.View r4 = r3.getHitScrollableView(r4, r0)
                r3.mHitView = r4
            L_0x0132:
                float r4 = r3.mTouchX
                r3.mLastX = r4
                float r4 = r3.mTouchY
                r3.mLastY = r4
                boolean r4 = r3.isIntercept
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.widget.floating.RFFloating.RFFloatingGesture.dispatchTouchEvent(android.view.MotionEvent):boolean");
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            this.isDisallow = z;
        }

        private boolean isHitViewDisallow() {
            View view;
            if (this.isDisallow && (view = this.mHitView) != null && (view instanceof ViewGroup)) {
                ((ViewGroup) view).requestDisallowInterceptTouchEvent(false);
                if (this.isDisallow) {
                    return true;
                }
                ((ViewGroup) this.mHitView).requestDisallowInterceptTouchEvent(true);
            }
            return false;
        }

        private boolean isHitNavBar(float f, float f2) {
            return RFFloating.this.f33535i.getGlobalVisibleRect(this.mTempHitRect) && this.mTempHitRect.contains((int) f, (int) f2);
        }

        private View getHitScrollableView(float f, float f2) {
            for (View next : this.mScrollableViewList) {
                if (next.isShown() && next.getGlobalVisibleRect(this.mTempHitRect) && this.mTempHitRect.contains((int) f, (int) f2)) {
                    return next;
                }
            }
            return null;
        }

        private void acquireVelocityTracker(MotionEvent motionEvent) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
        }

        private void releaseVelocityTracker() {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
            }
        }

        private void onDragStart(float f, float f2) {
            moveFloating(Math.max(RFFloating.this.f33532f.getTranslationY() + f2, 0.0f));
            RFusionConfig.IRFusionLogger d = RFFloating.this.f33529c;
            d.info(RFFloating.f33526b, "onDragStart: start drag = " + f2);
        }

        private void onDraging(float f, float f2) {
            moveFloating(Math.max(RFFloating.this.f33532f.getTranslationY() + f2, 0.0f));
        }

        private void onDragEnd(float f, float f2) {
            if (RFFloating.this.f33532f.getTranslationY() != 0.0f) {
                if (RFFloating.this.f33532f.getTranslationY() < ((float) RFFloating.this.f33532f.getHeight()) / 2.0f) {
                    startExpandAnim();
                } else {
                    startCollapseAnim();
                }
                RFusionConfig.IRFusionLogger d = RFFloating.this.f33529c;
                d.info(RFFloating.f33526b, "onDragEnd: end drag = " + f2);
            }
        }

        private void startExpandAnim() {
            int calculateTime = calculateTime(RFFloating.this.f33532f.getTranslationY());
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{RFFloating.this.f33532f.getTranslationY(), 0.0f});
            ofFloat.setDuration((long) calculateTime);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RFFloating.RFFloatingGesture.this.lambda$startExpandAnim$1$RFFloating$RFFloatingGesture(valueAnimator);
                }
            });
            ofFloat.start();
        }

        public /* synthetic */ void lambda$startExpandAnim$1$RFFloating$RFFloatingGesture(ValueAnimator valueAnimator) {
            moveFloating(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }

        private void startCollapseAnim() {
            int calculateTime = calculateTime(((float) this.mTranslateHeight) - RFFloating.this.f33532f.getTranslationY());
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{RFFloating.this.f33532f.getTranslationY(), (float) this.mTranslateHeight});
            ofFloat.setDuration((long) calculateTime);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RFFloating.RFFloatingGesture.this.lambda$startCollapseAnim$2$RFFloating$RFFloatingGesture(valueAnimator);
                }
            });
            ofFloat.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    RFFloating.this.m23597a((Bundle) null);
                }
            });
            ofFloat.start();
        }

        public /* synthetic */ void lambda$startCollapseAnim$2$RFFloating$RFFloatingGesture(ValueAnimator valueAnimator) {
            moveFloating(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }

        private void moveFloating(float f) {
            float min = Math.min(Math.max(f, 0.0f), (float) this.mTranslateHeight);
            if (RFFloating.this.f33532f.getTranslationY() != min) {
                float f2 = 1.0f - (min / ((float) this.mTranslateHeight));
                RFFloating.this.f33532f.setTranslationY(min);
                RFFloating.this.f33531e.getBackground().setAlpha((int) (f2 * 255.0f));
            }
        }

        private int calculateTime(float f) {
            return (int) ((f / ((float) this.mTranslateHeight)) * 300.0f);
        }
    }
}
