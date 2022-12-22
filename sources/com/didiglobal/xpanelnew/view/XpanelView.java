package com.didiglobal.xpanelnew.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.utils.UIThreadHandler;
import com.didi.global.globaluikit.widget.RoundCornerRelativeLayout;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.xpanelnew.anim.XPanelAnimListener;
import com.didiglobal.xpanelnew.anim.XPanelAnimShadowFrame;
import com.didiglobal.xpanelnew.base.XpCardProperty;
import com.didiglobal.xpanelnew.base.XpConfig;
import com.didiglobal.xpanelnew.base.XpOmegaConfig;
import com.didiglobal.xpanelnew.callback.IXpCallback;
import com.didiglobal.xpanelnew.callback.IXpView;
import com.didiglobal.xpanelnew.message.IMessageDataListener;
import com.didiglobal.xpanelnew.message.IXpMessageContainer;
import com.didiglobal.xpanelnew.message.XpMessageLayout;
import com.didiglobal.xpanelnew.omega.XPanelOmegaTracker;
import com.didiglobal.xpanelnew.sdk.IXpanelNew;
import com.didiglobal.xpanelnew.util.XpLog;
import com.didiglobal.xpanelnew.util.XpUtils;
import com.didiglobal.xpanelnew.view.widget.XpBottomView;
import com.didiglobal.xpanelnew.view.widget.XpScrollView;
import com.didiglobal.xpanelnew.view.widget.XpTopView;
import com.taxis99.R;
import global.didi.pay.newview.pix.IPixView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XpanelView implements IXpView, IXpanelNew, XpScrollView.OnScrollListener, XpScrollView.OnVisibilityChangedListener {

    /* renamed from: F */
    private static int f51631F = 0;

    /* renamed from: a */
    private static final String f51632a = "Xpanel";

    /* renamed from: c */
    private static final float f51633c = 10.0f;

    /* renamed from: d */
    private static final float f51634d = 10.0f;

    /* renamed from: e */
    private static final int f51635e = 97;

    /* renamed from: f */
    private static final int f51636f = 300;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f51637A;

    /* renamed from: B */
    private int f51638B = 0;

    /* renamed from: C */
    private int f51639C = 0;

    /* renamed from: D */
    private int f51640D = 0;

    /* renamed from: E */
    private int f51641E = 0;

    /* renamed from: G */
    private int f51642G = 0;

    /* renamed from: H */
    private int f51643H;

    /* renamed from: I */
    private int f51644I;

    /* renamed from: J */
    private int f51645J;

    /* renamed from: K */
    private int f51646K;

    /* renamed from: L */
    private float f51647L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public boolean f51648M = true;
    /* access modifiers changed from: private */

    /* renamed from: N */
    public IXpCallback f51649N;

    /* renamed from: O */
    private String f51650O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public float f51651P;
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public int f51652Q;

    /* renamed from: R */
    private boolean f51653R;

    /* renamed from: S */
    private int f51654S;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public XPanelOmegaTracker f51655T;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public boolean f51656U;

    /* renamed from: V */
    private boolean f51657V;

    /* renamed from: W */
    private List<XpCardProperty> f51658W = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: X */
    public boolean f51659X;
    /* access modifiers changed from: private */

    /* renamed from: Y */
    public int f51660Y;
    /* access modifiers changed from: private */

    /* renamed from: Z */
    public boolean f51661Z = false;

    /* renamed from: aa */
    private List<XpCardProperty> f51662aa = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public boolean f51663ab;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Logger f51664b = LoggerFactory.getLogger(XpLog.sTAG);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Context f51665g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Activity f51666h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Handler f51667i = new Handler(Looper.getMainLooper());

    /* renamed from: j */
    private XpConfig f51668j;

    /* renamed from: k */
    private LayoutInflater f51669k;

    /* renamed from: l */
    private FrameLayout f51670l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public XpScrollView f51671m;
    protected int mDownHeight;
    protected int mScrollerHeight;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public LinearLayout f51672n;

    /* renamed from: o */
    private XpTopView f51673o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public XpBottomView f51674p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public CardView f51675q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public View f51676r;

    /* renamed from: s */
    private View f51677s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f51678t;

    /* renamed from: u */
    private XpTopView.IXpSpaceViewHeightCalculate f51679u;

    /* renamed from: v */
    private XpBottomView.IBottomViewHeightCaculate f51680v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public XpMessageLayout f51681w;

    /* renamed from: x */
    private TextView f51682x;

    /* renamed from: y */
    private int f51683y;

    /* renamed from: z */
    private int f51684z;

    public void destroy() {
    }

    public void onScrolling() {
    }

    public XpanelView(Activity activity) {
        this.f51665g = activity;
        this.f51666h = activity;
        this.f51655T = new XPanelOmegaTracker(this);
    }

    public void init(XpConfig xpConfig) {
        if (xpConfig == null) {
            xpConfig = new XpConfig.Builder().build();
        }
        XpLog.m36924d("lxsConfig", IPixView.PAGE_STATUS_INIT + xpConfig.getDefaultDpSecondCardShowHeight());
        m36949a(xpConfig);
        m36942a();
    }

    public void setXpScrollEnabled(boolean z) {
        XpScrollView xpScrollView = this.f51671m;
        if (xpScrollView != null) {
            xpScrollView.setScrollEnabled(z);
        }
    }

    /* renamed from: a */
    private void m36942a() {
        LayoutInflater from = LayoutInflater.from(this.f51665g);
        this.f51669k = from;
        FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.xpanel_new_view, (ViewGroup) null);
        this.f51670l = frameLayout;
        XpScrollView xpScrollView = (XpScrollView) frameLayout.findViewById(R.id.xp_scroll_view);
        this.f51671m = xpScrollView;
        xpScrollView.setOnScrollListener(this);
        this.f51671m.setBlockFlinging(true);
        this.f51671m.setOnVisibilityChangedListener(this);
        this.f51672n = (LinearLayout) this.f51670l.findViewById(R.id.xp_cell_container);
        this.f51675q = (CardView) this.f51670l.findViewById(R.id.xp_bg_back_msg);
        this.f51676r = this.f51670l.findViewById(R.id.xp_bg_view);
        this.f51675q.setRadius((float) this.f51652Q);
        if (this.f51675q.getLayoutParams() != null && (this.f51675q.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.f51675q.getLayoutParams()).bottomMargin = -this.f51652Q;
        }
        TextView textView = (TextView) this.f51669k.inflate(R.layout.xpanel_title_layout, this.f51675q, false);
        this.f51682x = textView;
        this.f51675q.addView(textView, 0);
        XpMessageLayout xpMessageLayout = new XpMessageLayout(this.f51665g, this.f51652Q);
        this.f51681w = xpMessageLayout;
        xpMessageLayout.setVisibility(8);
        this.f51681w.setMessageDataListener(new IMessageDataListener() {
            public void notifyAdd() {
                XpanelView.this.f51649N.doXpanelStatusHeight(2, XpanelView.this.f51637A + XpanelView.this.getMessageRealHeight());
                XpanelView.this.m36991n();
                XpanelView.this.m36993o();
                XpanelView.this.m36983j();
                XpanelView.this.m36979h();
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.setMargins(XpUtils.dip2px(this.f51665g, 10.0f), 0, XpUtils.dip2px(this.f51665g, 10.0f), 0);
        this.f51670l.addView(this.f51681w, 2, layoutParams);
        this.f51671m.setDirectionListener(new XpScrollView.XpScrollViewListener() {
            public void direction(int i) {
            }

            public void event(float f, float f2) {
                float unused = XpanelView.this.f51651P = f2;
                XpLog.m36923d("event: " + f2);
            }

            public int getAreaCanScrollAboveFirstCard() {
                if (XpanelView.this.m36994p() != 0) {
                    return XpanelView.this.getMessageRealHeight();
                }
                return 0;
            }
        });
        this.f51671m.setXpMsgContainerListener(new XpScrollView.XpMsgContainerListener() {
            public Rect getMsgContainerRect() {
                Rect rect = new Rect();
                XpanelView.this.f51681w.getGlobalVisibleRect(rect);
                rect.bottom = rect.top + XpanelView.this.getMessageRealHeight();
                return rect;
            }
        });
        this.f51671m.setXpMsgClickListener(new XpScrollView.XpMsgClickListener() {
            public void onClick() {
                if (XpanelView.this.getStatus() != 1) {
                    XpanelView xpanelView = XpanelView.this;
                    boolean unused = xpanelView.m36955a(xpanelView.f51681w.getView());
                }
            }
        });
        this.f51677s = this.f51670l.findViewById(R.id.xp_scroll_mark);
    }

    public View getView() {
        return this.f51670l;
    }

    public int getScrollerRealHeight() {
        return XpUtils.getScreenHeight(this.f51666h) - this.mScrollerHeight;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m36955a(View view) {
        if (!(view instanceof ViewGroup)) {
            return view.callOnClick();
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (!viewGroup.getChildAt(0).callOnClick()) {
            return m36955a(viewGroup.getChildAt(0));
        }
        return false;
    }

    /* renamed from: a */
    private void m36949a(XpConfig xpConfig) {
        this.f51668j = xpConfig;
        this.f51637A = XpUtils.dip2px(this.f51665g, 250.0f);
        this.mDownHeight = XpUtils.dip2px(this.f51665g, xpConfig.getDefaultDpFoldHeight());
        this.f51652Q = XpUtils.dip2px(this.f51665g, xpConfig.getCardRoundedCornerDp());
        this.mScrollerHeight = XpUtils.getScreenHeight(this.f51666h) - XpUtils.dip2px(this.f51665g, 97.0f);
        f51631F = XpUtils.dip2px(this.f51665g, 30.0f);
        m36960b();
        this.f51684z = (int) (((double) XpUtils.getScreenHeight(this.f51666h)) * 0.65d);
        this.f51654S = (int) (((double) XpUtils.getScreenHeight(this.f51666h)) * 0.6d);
        this.f51643H = XpUtils.getScreenWidth(this.f51665g) - (XpUtils.dip2px(this.f51665g, 10.0f) * 2);
    }

    /* renamed from: a */
    private void m36950a(XpOmegaConfig xpOmegaConfig) {
        XPanelOmegaTracker xPanelOmegaTracker = this.f51655T;
        if (xPanelOmegaTracker != null) {
            xPanelOmegaTracker.setXPanelItemShowCallback(xpOmegaConfig.getxPanelOmegaCallback());
        }
    }

    /* renamed from: b */
    private void m36960b() {
        this.f51638B = XpUtils.dip2px(this.f51665g, 97.0f);
        this.f51640D = XpUtils.getScreenHeight(this.f51666h) - this.mDownHeight;
    }

    /* renamed from: a */
    private void m36944a(final int i) {
        this.f51673o = new XpTopView(this.f51665g);
        C173495 r0 = new XpTopView.IXpSpaceViewHeightCalculate() {
            public int measureHeight(int i) {
                return XpanelView.this.mScrollerHeight - i;
            }
        };
        this.f51679u = r0;
        this.f51673o.setSpaceViewHeightCalculate(r0);
        this.f51672n.addView(this.f51673o);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36943a(float f) {
        if (!this.f51653R) {
            this.f51674p = new XpBottomView(this.f51665g);
            int i = 0;
            int i2 = this.mScrollerHeight;
            if (f < ((float) i2)) {
                i = i2 - ((int) f);
            }
            this.f51660Y = i;
            C173506 r4 = new XpBottomView.IBottomViewHeightCaculate() {
                public int measureBottomHeight() {
                    return XpanelView.this.f51660Y;
                }
            };
            this.f51680v = r4;
            this.f51674p.bindInterface(r4);
            this.f51672n.addView(this.f51674p);
            this.f51653R = true;
        }
    }

    public void setData(List<XpCardProperty> list) {
        if (!this.f51661Z) {
            setDataWithAnimator(list, false);
        }
    }

    public void addCard(final XpCardProperty xpCardProperty, final int i) {
        m36947a(xpCardProperty.getView(), i, (Animator.AnimatorListener) new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (XpanelView.this.f51655T != null) {
                    XpanelView.this.f51655T.addCurrentCardProperties(xpCardProperty, i);
                    UIThreadHandler.post(new Runnable() {
                        public void run() {
                            XpanelView.this.f51655T.omegaShowTrack(XpanelView.this.f51663ab);
                        }
                    }, 1000);
                }
            }
        });
    }

    public void setDataWithAnimator(List<XpCardProperty> list, boolean z) {
        if (list != null && !list.isEmpty() && !this.f51661Z) {
            if (this.f51657V) {
                this.f51658W = list;
            } else {
                m36954a(list, z);
            }
        }
    }

    /* renamed from: a */
    private void m36954a(final List<XpCardProperty> list, boolean z) {
        if (this.f51672n != null) {
            final List<RoundCornerRelativeLayout> a = m36941a(list);
            if (!z || m36966c()) {
                m36971e();
                m36953a(a, list, false);
            } else if (getStatus() == 2) {
                final XPanelAnimShadowFrame xPanelAnimShadowFrame = new XPanelAnimShadowFrame(this.f51665g, this.f51652Q, 300);
                xPanelAnimShadowFrame.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                RoundCornerRelativeLayout roundCornerRelativeLayout = (RoundCornerRelativeLayout) this.f51672n.getChildAt(1);
                RoundCornerRelativeLayout roundCornerRelativeLayout2 = a.get(0);
                roundCornerRelativeLayout.setDrawingCacheEnabled(true);
                roundCornerRelativeLayout2.setDrawingCacheEnabled(true);
                xPanelAnimShadowFrame.setAnimView(roundCornerRelativeLayout, roundCornerRelativeLayout2);
                ((ViewGroup) this.f51666h.getWindow().getDecorView()).addView(xPanelAnimShadowFrame);
                xPanelAnimShadowFrame.setAnimatorEndListener(new XPanelAnimShadowFrame.AnimatorEndListener() {
                    public void onAnimatorEnd() {
                        ((ViewGroup) XpanelView.this.f51666h.getWindow().getDecorView()).removeView(xPanelAnimShadowFrame);
                        XpanelView.this.m36971e();
                        XpanelView.this.m36953a((List<RoundCornerRelativeLayout>) a, (List<XpCardProperty>) list, false);
                        XpanelView.this.f51671m.setDoingAnim(false);
                        boolean unused = XpanelView.this.f51661Z = false;
                    }

                    public void onAnimatorStart() {
                        boolean unused = XpanelView.this.f51661Z = true;
                        XpanelView.this.f51671m.setDoingAnim(true);
                    }
                });
            } else {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f51672n, "alpha", new float[]{1.0f, 0.0f});
                ofFloat.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                        boolean unused = XpanelView.this.f51661Z = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        XpanelView.this.m36971e();
                        XpanelView.this.m36953a((List<RoundCornerRelativeLayout>) a, (List<XpCardProperty>) list, true);
                        XpanelView.this.f51671m.setDoingAnim(false);
                        boolean unused = XpanelView.this.f51661Z = false;
                    }
                });
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f51681w, "alpha", new float[]{1.0f, 0.0f});
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
                animatorSet.setDuration(300);
                animatorSet.start();
                this.f51671m.setDoingAnim(true);
            }
        }
    }

    /* renamed from: c */
    private boolean m36966c() {
        LinearLayout linearLayout = this.f51672n;
        if (linearLayout != null && linearLayout.getChildCount() >= 3) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private List<RoundCornerRelativeLayout> m36941a(List<XpCardProperty> list) {
        View view;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            XpCardProperty xpCardProperty = list.get(i);
            if (!(xpCardProperty == null || (view = xpCardProperty.getView()) == null)) {
                if (view.getParent() != null && (view.getParent() instanceof RoundCornerRelativeLayout)) {
                    ((RoundCornerRelativeLayout) view.getParent()).removeAllViews();
                }
                RoundCornerRelativeLayout d = m36968d();
                d.addView(view, new ViewGroup.LayoutParams(-1, -2));
                arrayList.add(d);
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    private RoundCornerRelativeLayout m36968d() {
        RoundCornerRelativeLayout roundCornerRelativeLayout = (RoundCornerRelativeLayout) this.f51669k.inflate(R.layout.xpanel_card_parent_layout, this.f51672n, false);
        roundCornerRelativeLayout.setRadius(this.f51652Q);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) this.f51652Q);
        gradientDrawable.setColor(-1);
        roundCornerRelativeLayout.setBackground(gradientDrawable);
        return roundCornerRelativeLayout;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36953a(List<RoundCornerRelativeLayout> list, List<XpCardProperty> list2, final boolean z) {
        m36944a(this.mDownHeight);
        final int size = list2.size();
        XpLog.m36924d(f51632a, "cardcount:" + size);
        for (int i = 0; i < list.size(); i++) {
            this.f51672n.addView(list.get(i));
        }
        this.f51672n.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                XpLog.m36924d(XpanelView.f51632a, "onPreDraw");
                XpanelView.this.f51672n.getViewTreeObserver().removeOnPreDrawListener(this);
                if (XpanelView.this.f51672n.getChildAt(1) != null && Build.VERSION.SDK_INT >= 21) {
                    XpanelView.this.f51672n.getChildAt(1).setTranslationZ(60.0f);
                }
                int i = 0;
                for (int i2 = 1; i2 < XpanelView.this.f51672n.getChildCount(); i2++) {
                    if (XpanelView.this.f51672n.getChildAt(i2) instanceof RoundCornerRelativeLayout) {
                        i += XpanelView.this.f51672n.getChildAt(i2).getMeasuredHeight() + XpUtils.dip2px(XpanelView.this.f51665g, 10.0f);
                    }
                }
                XpanelView.this.m36943a((float) i);
                XpanelView.this.f51667i.post(new Runnable() {
                    public void run() {
                        XpanelView.this.m36961b(size);
                        boolean unused = XpanelView.this.f51678t = false;
                        XpanelView.this.f51671m.setLastStatus(XpanelView.this.f51671m.getStatus());
                        XpanelView.this.defaultState(z);
                        XpanelView.this.f51664b.info("三态：addView 默认态", new Object[0]);
                    }
                });
                return false;
            }
        });
        this.f51662aa = list2;
        this.f51655T.setCurrentCardProperties(list2);
        List<XpCardProperty> list3 = this.f51658W;
        if (list3 != null && list3.size() > 0) {
            this.f51658W.clear();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m36971e() {
        RoundCornerRelativeLayout roundCornerRelativeLayout;
        int childCount = this.f51672n.getChildCount();
        for (int i = 0; i <= childCount - 1; i++) {
            if ((this.f51672n.getChildAt(i) instanceof RoundCornerRelativeLayout) && (roundCornerRelativeLayout = (RoundCornerRelativeLayout) this.f51672n.getChildAt(i)) != null) {
                roundCornerRelativeLayout.removeAllViews();
            }
        }
        this.f51672n.removeAllViews();
        this.f51653R = false;
    }

    public void setShowOneCard() {
        m36961b(1);
        XpScrollView xpScrollView = this.f51671m;
        xpScrollView.setLastStatus(xpScrollView.getStatus());
        defaultState();
        this.f51664b.info("三态：多张卡片只展示一张卡片，默认态", new Object[0]);
    }

    public void firstCardHeightWillChangeTo(XpConfig xpConfig) {
        m36949a(xpConfig);
        m36961b(-1);
        XpScrollView xpScrollView = this.f51671m;
        xpScrollView.setLastStatus(xpScrollView.getStatus());
        this.f51659X = true;
        UIThreadHandler.post(new Runnable() {
            public void run() {
                boolean unused = XpanelView.this.f51659X = false;
            }
        }, 600);
        if (getStatus() != 1) {
            defaultState();
        }
    }

    public void cardHeightChange(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 1; i5 < this.f51672n.getChildCount(); i5++) {
            if (this.f51672n.getChildAt(i5) instanceof RoundCornerRelativeLayout) {
                i4 += this.f51672n.getChildAt(i5).getMeasuredHeight() + XpUtils.dip2px(this.f51665g, 10.0f);
                XpLog.m36924d("xpanel_bottom", "item height = " + this.f51672n.getChildAt(i5).getMeasuredHeight());
            }
        }
        int measuredHeight = i4 - (this.f51672n.getChildAt(i).getMeasuredHeight() - i2);
        if (this.f51674p == null) {
            m36943a((float) measuredHeight);
            return;
        }
        int i6 = this.mScrollerHeight;
        if (measuredHeight < i6) {
            i3 = i6 - measuredHeight;
        }
        this.f51660Y = i3;
        this.f51674p.requestLayout();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m36961b(int i) {
        if (!m36987l()) {
            if (this.f51668j.getFirstCardHeightWillChangeTo() != 0) {
                this.f51637A = XpUtils.dip2px(this.f51665g, this.f51668j.getDefaultDpSecondCardShowHeight() + 10.0f) + this.f51668j.getFirstCardHeightWillChangeTo();
                XpLog.m36924d("setConfigValue", this.f51668j.getDefaultDpSecondCardShowHeight() + ";" + this.f51668j.getFirstCardHeightWillChangeTo());
            } else if (this.f51668j.getOneCardAndXDp() != 0.0f) {
                this.f51637A = this.f51672n.getChildAt(1).getMeasuredHeight() + XpUtils.dip2px(this.f51665g, this.f51668j.getOneCardAndXDp() + 10.0f);
            } else if (i == 1) {
                this.f51637A = this.f51672n.getChildAt(1).getMeasuredHeight() + XpUtils.dip2px(this.f51665g, 10.0f);
            } else {
                this.f51637A = this.f51672n.getChildAt(1).getMeasuredHeight() + XpUtils.dip2px(this.f51665g, this.f51668j.getDefaultDpSecondCardShowHeight() + 10.0f);
            }
            int messageRealHeight = this.f51637A + getMessageRealHeight();
            int i2 = this.f51654S;
            if (messageRealHeight > i2) {
                this.f51637A = i2 - getMessageRealHeight();
            }
            int i3 = this.f51637A;
            int i4 = this.mDownHeight;
            if (i3 <= i4) {
                this.f51637A = i4 + 1;
            }
            XpLog.m36924d("lxsConfig", "setConfigValue" + this.f51668j.getDefaultDpSecondCardShowHeight() + " mLastDefaultShow: " + this.f51637A);
            this.f51639C = XpUtils.getScreenHeight(this.f51666h) - this.f51637A;
        }
    }

    /* renamed from: a */
    private void m36948a(XpCardProperty xpCardProperty, int i) {
        XpBottomView xpBottomView = this.f51674p;
        if (xpBottomView != null) {
            this.f51672n.removeView(xpBottomView);
        }
        View view = xpCardProperty.getView();
        if (view != null) {
            this.f51672n.addView(view, i);
        }
        this.f51667i.post(new Runnable() {
            public void run() {
                int i = 0;
                for (int i2 = 1; i2 < XpanelView.this.f51672n.getChildCount(); i2++) {
                    i += XpanelView.this.f51672n.getChildAt(i2).getMeasuredHeight();
                }
                XpanelView.this.m36943a((float) i);
            }
        });
    }

    public void setXpCallback(IXpCallback iXpCallback) {
        this.f51649N = iXpCallback;
        iXpCallback.onCardWithCallback(this.f51643H);
    }

    public void addViewWhenDefault(View view, int i) {
        LinearLayout linearLayout = this.f51672n;
        if (linearLayout != null) {
            if (i > 1) {
                linearLayout.addView(view, i);
            } else {
                m36946a(view, i);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r0 = m36968d();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m36947a(android.view.View r8, int r9, android.animation.Animator.AnimatorListener r10) {
        /*
            r7 = this;
            android.widget.LinearLayout r0 = r7.f51672n
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.didi.global.globaluikit.widget.RoundCornerRelativeLayout r0 = r7.m36968d()
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            android.view.ViewGroup$LayoutParams r1 = new android.view.ViewGroup$LayoutParams
            r2 = -1
            r3 = -2
            r1.<init>(r2, r3)
            android.view.ViewParent r2 = r8.getParent()
            if (r2 == 0) goto L_0x002a
            android.view.ViewParent r2 = r8.getParent()
            boolean r2 = r2 instanceof android.view.ViewGroup
            if (r2 == 0) goto L_0x002a
            android.view.ViewParent r2 = r8.getParent()
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r2.removeView(r8)
        L_0x002a:
            r0.addView(r8, r1)
            android.widget.LinearLayout r1 = r7.f51672n
            r1.addView(r0, r9)
            r9 = 0
            r0.measure(r9, r9)
            int r1 = r0.getMeasuredHeight()
            r2 = 2
            int[] r3 = new int[r2]
            r3[r9] = r9
            r4 = 1
            r3[r4] = r1
            android.animation.ValueAnimator r1 = android.animation.ValueAnimator.ofInt(r3)
            com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory$InterpolatorType r3 = com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT
            android.view.animation.Interpolator r3 = com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(r3)
            r1.setInterpolator(r3)
            com.didiglobal.xpanelnew.view.XpanelView$13 r3 = new com.didiglobal.xpanelnew.view.XpanelView$13
            r3.<init>(r0)
            r1.addUpdateListener(r3)
            com.didiglobal.xpanelnew.view.XpanelView$14 r3 = new com.didiglobal.xpanelnew.view.XpanelView$14
            r3.<init>(r0)
            r1.addListener(r3)
            int[] r3 = new int[r2]
            r3[r9] = r9
            android.content.Context r5 = r7.f51665g
            r6 = 1092616192(0x41200000, float:10.0)
            int r5 = com.didiglobal.xpanelnew.util.XpUtils.dip2px(r5, r6)
            r3[r4] = r5
            android.animation.ValueAnimator r3 = android.animation.ValueAnimator.ofInt(r3)
            com.didiglobal.xpanelnew.view.XpanelView$15 r5 = new com.didiglobal.xpanelnew.view.XpanelView$15
            r5.<init>(r0)
            r3.addUpdateListener(r5)
            float[] r0 = new float[r2]
            r0 = {0, 1065353216} // fill-array
            java.lang.String r5 = "alpha"
            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofFloat(r8, r5, r0)
            com.didiglobal.xpanelnew.view.widget.MountainInterpolator r0 = new com.didiglobal.xpanelnew.view.widget.MountainInterpolator
            r0.<init>()
            r8.setInterpolator(r0)
            android.animation.AnimatorSet r0 = new android.animation.AnimatorSet
            r0.<init>()
            r5 = 3
            android.animation.Animator[] r5 = new android.animation.Animator[r5]
            r5[r9] = r1
            r5[r4] = r8
            r5[r2] = r3
            r0.playTogether(r5)
            r8 = 400(0x190, double:1.976E-321)
            r0.setDuration(r8)
            r0.addListener(r10)
            r0.start()
            com.didiglobal.xpanelnew.view.widget.XpScrollView r8 = r7.f51671m
            r8.setDoingAnim(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.xpanelnew.view.XpanelView.m36947a(android.view.View, int, android.animation.Animator$AnimatorListener):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m36974f() {
        int i = 0;
        int i2 = 0;
        for (int i3 = 1; i3 < this.f51672n.getChildCount(); i3++) {
            if (this.f51672n.getChildAt(i3) instanceof RoundCornerRelativeLayout) {
                i2 += this.f51672n.getChildAt(i3).getMeasuredHeight() + XpUtils.dip2px(this.f51665g, 10.0f);
                XpLog.m36924d("xpanel_bottom", "item height = " + this.f51672n.getChildAt(i3).getMeasuredHeight());
            }
        }
        if (this.f51674p == null) {
            m36943a((float) i2);
            return;
        }
        int i4 = this.mScrollerHeight;
        if (i2 < i4) {
            i = i4 - i2;
        }
        this.f51660Y = i;
        this.f51674p.requestLayout();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r0 = r0.getChildAt(r10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeCard(final int r10) {
        /*
            r9 = this;
            android.widget.LinearLayout r0 = r9.f51672n
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.view.View r0 = r0.getChildAt(r10)
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            int r1 = r0.getMeasuredHeight()
            r2 = 2
            int[] r3 = new int[r2]
            r4 = 0
            r3[r4] = r1
            r5 = 1
            r3[r5] = r4
            android.animation.ValueAnimator r3 = android.animation.ValueAnimator.ofInt(r3)
            com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory$InterpolatorType r6 = com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT
            android.view.animation.Interpolator r6 = com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(r6)
            r3.setInterpolator(r6)
            com.didiglobal.xpanelnew.view.XpanelView$16 r6 = new com.didiglobal.xpanelnew.view.XpanelView$16
            r6.<init>(r0)
            r3.addUpdateListener(r6)
            int[] r6 = new int[r2]
            android.content.Context r7 = r9.f51665g
            r8 = 1092616192(0x41200000, float:10.0)
            int r7 = com.didiglobal.xpanelnew.util.XpUtils.dip2px(r7, r8)
            r6[r4] = r7
            r6[r5] = r4
            android.animation.ValueAnimator r6 = android.animation.ValueAnimator.ofInt(r6)
            com.didiglobal.xpanelnew.view.XpanelView$17 r7 = new com.didiglobal.xpanelnew.view.XpanelView$17
            r7.<init>(r0)
            r6.addUpdateListener(r7)
            float[] r7 = new float[r2]
            r7 = {1065353216, 0} // fill-array
            java.lang.String r8 = "alpha"
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r0, r8, r7)
            android.animation.AnimatorSet r7 = new android.animation.AnimatorSet
            r7.<init>()
            r8 = 3
            android.animation.Animator[] r8 = new android.animation.Animator[r8]
            r8[r4] = r3
            r8[r5] = r0
            r8[r2] = r6
            r7.playTogether(r8)
            r2 = 400(0x190, double:1.976E-321)
            r7.setDuration(r2)
            com.didiglobal.xpanelnew.view.XpanelView$18 r0 = new com.didiglobal.xpanelnew.view.XpanelView$18
            r0.<init>(r1, r10)
            r7.addListener(r0)
            r7.start()
            com.didiglobal.xpanelnew.view.widget.XpScrollView r10 = r9.f51671m
            r10.setDoingAnim(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.xpanelnew.view.XpanelView.removeCard(int):void");
    }

    /* renamed from: a */
    private List<Animator> m36940a(int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        int i2 = i;
        while (i2 <= this.f51672n.getChildCount()) {
            int i3 = i2 + 1;
            if (i3 < this.f51672n.getChildCount()) {
                View childAt = this.f51672n.getChildAt(i3);
                if (i2 < i + 1 && z) {
                    childAt.setTranslationY((float) (-childAt.getHeight()));
                }
                arrayList.add(ObjectAnimator.ofFloat(childAt, "TranslationY", new float[]{(float) (-childAt.getMeasuredHeight()), 0.0f}));
            }
            i2 = i3;
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m36946a(View view, int i) {
        final float f;
        final RoundCornerRelativeLayout roundCornerRelativeLayout = (RoundCornerRelativeLayout) this.f51672n.getChildAt(i);
        int[] iArr = new int[2];
        roundCornerRelativeLayout.getLocationOnScreen(iArr);
        final RoundCornerRelativeLayout d = m36968d();
        int width = roundCornerRelativeLayout.getWidth();
        int height = roundCornerRelativeLayout.getHeight();
        d.addView(view);
        this.f51672n.addView(d, i);
        RoundCornerRelativeLayout roundCornerRelativeLayout2 = new RoundCornerRelativeLayout(this.f51665g);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
        roundCornerRelativeLayout2.setRadius((int) roundCornerRelativeLayout.getTopLeftRadius());
        roundCornerRelativeLayout2.setLayoutParams(layoutParams);
        roundCornerRelativeLayout2.setBackground(this.f51681w.getChildAt(0).getBackground());
        roundCornerRelativeLayout2.setX((float) iArr[0]);
        roundCornerRelativeLayout2.setY((float) iArr[1]);
        final FrameLayout frameLayout = new FrameLayout(this.f51665g);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        frameLayout.addView(roundCornerRelativeLayout2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(roundCornerRelativeLayout2, "Alpha", new float[]{1.0f, 0.0f});
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        if (Build.VERSION.SDK_INT >= 21) {
            float translationZ = d.getTranslationZ();
            d.setTranslationZ(100.0f + translationZ);
            f = translationZ;
        } else {
            f = 0.0f;
        }
        arrayList.addAll(m36940a(i, true));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.addListener(new XPanelAnimListener() {
            public void onAnimationStart(Animator animator) {
                ((FrameLayout) XpanelView.this.f51666h.getWindow().getDecorView()).addView(frameLayout);
                if (Build.VERSION.SDK_INT >= 21) {
                    roundCornerRelativeLayout.setTranslationZ(0.0f);
                }
            }

            public void onAnimationEnd(Animator animator) {
                XpanelView.this.f51671m.setDoingAnim(false);
                ((FrameLayout) XpanelView.this.f51666h.getWindow().getDecorView()).removeView(frameLayout);
                if (Build.VERSION.SDK_INT >= 21) {
                    d.setTranslationZ(f);
                }
            }
        });
        animatorSet.setDuration(1000);
        animatorSet.start();
        this.f51671m.setDoingAnim(true);
    }

    /* renamed from: a */
    private void m36945a(int i, int i2) {
        int lastStatus = this.f51671m.getLastStatus();
        if (i == 2) {
            int i3 = this.f51638B;
            if (i3 < i2 && i2 < i3 + f51631F) {
                upState();
                this.f51664b.info("三态：下拉，吸顶", new Object[0]);
            } else if (this.f51638B + f51631F <= i2 && i2 <= this.f51639C) {
                defaultState();
                this.f51664b.info("三态：下拉，默认", new Object[0]);
            } else if (this.f51639C >= i2 || i2 > this.f51640D || this.f51671m.getLastStatus() == 3) {
                Logger logger = this.f51664b;
                logger.info("三态：下拉 currentY：" + i2, new Object[0]);
            } else {
                bottomState();
                if (i2 == this.f51640D) {
                    m36991n();
                    m36993o();
                    m36983j();
                    m36979h();
                }
                this.f51664b.info("三态：下拉，吸底", new Object[0]);
            }
        } else if (i2 <= this.f51684z && this.f51671m.getLastStatus() != 1) {
            upState();
            this.f51664b.info("三态：上拉，吸顶", new Object[0]);
        } else if (this.f51684z >= i2 || i2 >= this.f51640D) {
            Logger logger2 = this.f51664b;
            logger2.info("三态：上拉 currentY" + i2, new Object[0]);
        } else {
            defaultState();
            Logger logger3 = this.f51664b;
            logger3.info("三态：上拉，默认" + this.f51684z + "--" + this.f51639C, new Object[0]);
        }
        m36962b(i, lastStatus);
    }

    /* renamed from: b */
    private void m36962b(int i, int i2) {
        int i3 = 2;
        String str = i == 2 ? "xpanel_pull_down" : "xpanel_pull_up";
        if (i2 != 1) {
            i3 = i2 != 2 ? i2 != 3 ? -1 : 1 : 0;
        }
        if (i3 >= 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("from_pos", Integer.valueOf(i3));
            SystemUtils.log(6, "omegaScrollTrack", str + ":" + i3, (Throwable) null, "com.didiglobal.xpanelnew.view.XpanelView", 1109);
            OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap);
        }
    }

    /* renamed from: g */
    private int m36976g() {
        LinearLayout linearLayout = this.f51672n;
        if (linearLayout == null || linearLayout.getChildCount() < 2 || this.f51672n.getChildAt(1) == null) {
            return 0;
        }
        int[] iArr = new int[2];
        this.f51672n.getChildAt(1).getLocationOnScreen(iArr);
        XpLog.m36924d(f51632a, iArr[1] + " !! " + this.f51671m.getTop() + " @ " + XpUtils.getScreenHeight(this.f51666h) + " $ " + this.mScrollerHeight);
        return iArr[1];
    }

    public int getFirstCardHeight() {
        return XpUtils.getScreenHeight(this.f51666h) - m36976g();
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        m36991n();
        m36993o();
        m36983j();
        m36979h();
        XpLog.m36926e("onScrollChanged x: " + i + "; y:" + i2 + "; oldx: " + i3 + "; oldy:" + i4);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m36979h() {
        if (getFirstCardHeight() <= this.f51637A || (this.f51659X && getStatus() != 1)) {
            this.f51670l.setBackgroundColor(0);
            return;
        }
        int firstCardHeight = getFirstCardHeight();
        int i = this.f51637A;
        float min = Math.min(Math.max((float) (((double) (firstCardHeight - i)) / (((double) (this.mScrollerHeight - i)) * 0.5d)), 0.0f), 1.0f);
        this.f51670l.setBackgroundColor(Color.parseColor("#0A121A"));
        this.f51670l.getBackground().setAlpha((int) (((double) min) * 0.7d * 255.0d));
    }

    public void onScrollStopped(float f) {
        XpLog.m36924d("lxs Slop", f + " : " + ViewConfiguration.get(this.f51665g).getScaledTouchSlop());
        if (f >= ((float) ViewConfiguration.get(this.f51665g).getScaledTouchSlop())) {
            m36945a(this.f51671m.getDirection(), m36976g());
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    if (XpanelView.this.f51663ab) {
                        XpanelView.this.f51655T.omegaShowTrack(true);
                    }
                }
            }, 500);
        }
    }

    /* renamed from: i */
    private boolean m36981i() {
        return XpUtils.dip2px(this.f51665g, 97.0f) > m36976g();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m36983j() {
        if (this.f51671m.getStatus() == 1) {
            if (this.f51671m.getLastStatus() == 1 && getFirstCardHeight() <= this.mScrollerHeight) {
                this.f51646K = getFirstCardHeight() + this.f51682x.getMeasuredHeight() + this.f51652Q;
                this.f51675q.getLayoutParams().height = this.f51646K;
                IXpCallback iXpCallback = this.f51649N;
                if (iXpCallback != null && !this.f51656U) {
                    iXpCallback.doXPanelHeightChange(this.f51646K - this.f51652Q);
                }
                this.f51675q.requestLayout();
                this.f51676r.getLayoutParams().height = this.f51646K - this.f51652Q;
                this.f51676r.requestLayout();
                this.f51677s.setTranslationY((float) (-(((getFirstCardHeight() + this.f51682x.getMeasuredHeight()) - XpUtils.dip2px(this.f51665g, 5.0f)) - this.f51677s.getMeasuredHeight())));
            }
        } else if (!m36981i()) {
            this.f51646K = getFirstCardHeight();
            this.f51645J = this.f51643H;
            int firstCardHeight = getFirstCardHeight();
            int i = this.f51637A;
            float f = (float) (((double) (firstCardHeight - i)) / (((double) (this.mScrollerHeight - i)) * 0.5d));
            this.f51647L = f;
            float max = Math.max(f, 0.0f);
            this.f51647L = max;
            this.f51647L = Math.min(max, 1.0f);
            int dip2px = (int) (((float) XpUtils.dip2px(this.f51665g, 10.0f)) * this.f51647L);
            if (m36994p() > 0) {
                this.f51646K += getMessageRealHeight();
            }
            int i2 = this.f51646K + dip2px;
            this.f51646K = i2;
            this.f51645J += dip2px * 2;
            this.f51646K = i2 + this.f51652Q;
            this.f51675q.getLayoutParams().height = this.f51646K;
            IXpCallback iXpCallback2 = this.f51649N;
            if (iXpCallback2 != null && !this.f51656U) {
                iXpCallback2.doXPanelHeightChange(this.f51646K - this.f51652Q);
            }
            this.f51675q.getLayoutParams().width = this.f51645J;
            if (!this.f51659X) {
                this.f51675q.setAlpha(this.f51647L);
            }
            XpLog.m36923d("bgwidth" + dip2px + "mMsgBgRatio" + this.f51647L);
            this.f51675q.requestLayout();
            this.f51676r.getLayoutParams().height = this.f51646K - this.f51652Q;
            this.f51676r.requestLayout();
        }
    }

    public int getMessageRealHeight() {
        if (m36994p() == 0) {
            return 0;
        }
        return m36994p() - (this.f51652Q * 2);
    }

    public void fistCardHeightChange(int i) {
        if (getStatus() == 1) {
            for (int i2 = 2; i2 < this.f51672n.getChildCount(); i2++) {
                this.f51672n.getChildAt(i2).setTranslationY((float) (-(XpUtils.dip2px(this.f51665g, 10.0f) + i)));
            }
        }
    }

    public LinearLayout getCellContainer() {
        return this.f51672n;
    }

    public void upState() {
        LinearLayout linearLayout = this.f51672n;
        if (linearLayout != null && linearLayout.getChildAt(1) != null) {
            int[] iArr = new int[2];
            this.f51672n.getChildAt(1).getLocationOnScreen(iArr);
            int i = iArr[1];
            this.f51671m.setCurrentStatus(1);
            XpLog.m36927e(f51632a, "currentY:" + i + ", status:" + XpUtils.getStatusBarHeight(this.f51665g) + ", 97: " + XpUtils.dip2px(this.f51665g, 97.0f));
            this.f51671m.smoothScrollBy(0, i - XpUtils.dip2px(this.f51665g, 97.0f));
            this.f51649N.doXpanelStatusHeight(1, this.mScrollerHeight + this.f51682x.getMeasuredHeight());
            if (this.f51671m.getDirection() == 1) {
                m36984k();
            }
            this.f51664b.info("state吸顶态", new Object[0]);
        }
    }

    /* renamed from: k */
    private void m36984k() {
        XpanelView xpanelView = this;
        int i = 2;
        char c = 0;
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{xpanelView.f51646K, xpanelView.mScrollerHeight + xpanelView.f51682x.getMeasuredHeight() + xpanelView.f51652Q});
        ofInt.setDuration(100);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                XpanelView.this.f51675q.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (XpanelView.this.f51649N != null) {
                    XpanelView.this.f51649N.doXPanelHeightChange(((Integer) valueAnimator.getAnimatedValue()).intValue() - XpanelView.this.f51652Q);
                }
                XpanelView.this.f51675q.requestLayout();
                XpanelView.this.f51676r.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue() - XpanelView.this.f51652Q;
                XpanelView.this.f51676r.requestLayout();
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{xpanelView.f51645J, xpanelView.f51671m.getWidth()});
        ofInt2.setDuration(100);
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                XpanelView.this.f51675q.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                XpanelView.this.f51675q.requestLayout();
            }
        });
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{xpanelView.f51647L, 1.0f});
        ofFloat.setDuration(100);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                XpanelView.this.f51675q.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(xpanelView.f51677s, "translationY", new float[]{(float) (-(((xpanelView.mScrollerHeight + xpanelView.f51682x.getMeasuredHeight()) - XpUtils.dip2px(xpanelView.f51665g, 5.0f)) - xpanelView.f51677s.getMeasuredHeight()))});
        ofFloat2.setDuration(100);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(xpanelView.f51681w, "alpha", new float[]{1.0f, 0.0f});
        ofFloat3.setDuration(150);
        if (!m36987l()) {
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(xpanelView.f51672n.getChildAt(1), "alpha", new float[]{1.0f, 0.0f});
            ofFloat4.setDuration(200);
            if (Build.VERSION.SDK_INT >= 21) {
                xpanelView.f51672n.getChildAt(1).setZ(0.0f);
            }
            int measuredHeight = xpanelView.f51672n.getChildAt(1).getMeasuredHeight() + XpUtils.dip2px(xpanelView.f51665g, 10.0f);
            XpLog.m36924d("xpanel_upstate", "translationY: " + measuredHeight);
            ArrayList arrayList = new ArrayList();
            int i2 = 2;
            while (i2 < xpanelView.f51672n.getChildCount()) {
                View childAt = xpanelView.f51672n.getChildAt(i2);
                float[] fArr = new float[i];
                fArr[c] = 0.0f;
                fArr[1] = (float) (-measuredHeight);
                arrayList.add(ObjectAnimator.ofFloat(childAt, "translationY", fArr).setDuration(300));
                i2++;
                i = 2;
                c = 0;
                xpanelView = this;
            }
            arrayList.add(ofFloat3);
            arrayList.add(ofFloat4);
            arrayList.add(ofInt);
            arrayList.add(ofInt2);
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
            animatorSet.playTogether(arrayList);
            animatorSet.start();
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = XpanelView.this.f51656U = false;
                    XpanelView.this.f51671m.setDoingAnim(false);
                    boolean unused2 = XpanelView.this.f51648M = false;
                    XpanelView.this.f51672n.getChildAt(1).setVisibility(4);
                    XpanelView.this.f51681w.setVisibility(4);
                }
            });
            this.f51671m.setDoingAnim(true);
            this.f51656U = true;
        }
    }

    /* renamed from: l */
    private boolean m36987l() {
        LinearLayout linearLayout = this.f51672n;
        if (linearLayout == null || linearLayout.getChildCount() <= 2 || this.f51672n.getChildAt(1) == null) {
            return true;
        }
        return false;
    }

    public void defaultState(boolean z) {
        LinearLayout linearLayout = this.f51672n;
        if (linearLayout != null && linearLayout.getChildAt(1) != null) {
            if (!this.f51678t) {
                this.f51655T.omegaShowTrack(true);
                this.f51678t = true;
            }
            int[] iArr = new int[2];
            this.f51672n.getChildAt(1).getLocationOnScreen(iArr);
            int i = iArr[1];
            this.f51671m.setCurrentStatus(2);
            this.f51671m.smoothScrollBy(0, -((XpUtils.getScreenHeight(this.f51666h) - i) - this.f51637A), this.f51648M ? 600 : 300);
            if (z) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(XpanelView.this.f51672n, "alpha", new float[]{0.0f, 1.0f});
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(XpanelView.this.f51681w, "alpha", new float[]{0.0f, 1.0f});
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
                        animatorSet.setDuration(300);
                        animatorSet.start();
                    }
                }, 250);
            }
            this.f51649N.doXpanelStatusHeight(2, this.f51637A + getMessageRealHeight());
            XpLog.m36927e(f51632a, "default: doXpanelStatusHeight: " + (this.f51637A + getMessageRealHeight()) + ", mLastDefaultShow: " + this.f51637A + ", msgHeight: " + getMessageRealHeight() + ", 250: " + XpUtils.dip2px(this.f51665g, 250.0f) + ", screen: " + XpUtils.getScreenHeight(this.f51666h));
            m36988m();
            this.f51664b.info("state默认态", new Object[0]);
        }
    }

    public void defaultState() {
        defaultState(false);
    }

    /* renamed from: m */
    private void m36988m() {
        int i;
        int i2;
        ObjectAnimator objectAnimator;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (!this.f51648M) {
            this.f51681w.setVisibility(0);
            this.f51672n.getChildAt(1).setVisibility(0);
            int i8 = 2;
            if (m36994p() != 0) {
                if (this.f51671m.getStatus() == 2) {
                    i2 = this.f51637A + getMessageRealHeight() + this.f51652Q;
                    i6 = (this.f51637A + getMessageRealHeight()) - XpUtils.dip2px(this.f51665g, 5.0f);
                    i7 = this.f51677s.getMeasuredHeight();
                } else {
                    i2 = this.mDownHeight + getMessageRealHeight() + this.f51652Q;
                    i6 = (this.mDownHeight + getMessageRealHeight()) - XpUtils.dip2px(this.f51665g, 5.0f);
                    i7 = this.f51677s.getMeasuredHeight();
                }
                i = i6 - i7;
            } else {
                if (this.f51671m.getStatus() == 2) {
                    int i9 = this.f51637A;
                    i3 = this.f51652Q + i9;
                    i5 = i9 - XpUtils.dip2px(this.f51665g, 5.0f);
                    i4 = this.f51677s.getMeasuredHeight();
                } else {
                    int i10 = this.mDownHeight;
                    i3 = this.f51652Q + i10;
                    i5 = i10 - XpUtils.dip2px(this.f51665g, 5.0f);
                    i4 = this.f51677s.getMeasuredHeight();
                }
                int i11 = i3;
                i = i5 - i4;
                i2 = i11;
            }
            float[] fArr = {(float) (-i)};
            String str = "translationY";
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f51677s, str, fArr);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.setDuration(150);
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f51646K, i2});
            ofInt.setInterpolator(new DecelerateInterpolator());
            ofInt.setDuration(100);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    XpanelView.this.f51675q.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (XpanelView.this.f51649N != null) {
                        XpanelView.this.f51649N.doXPanelHeightChange(((Integer) valueAnimator.getAnimatedValue()).intValue() - XpanelView.this.f51652Q);
                    }
                    XpanelView.this.f51675q.requestLayout();
                    XpanelView.this.f51676r.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue() - XpanelView.this.f51652Q;
                    XpanelView.this.f51676r.requestLayout();
                }
            });
            ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{this.f51671m.getWidth(), this.f51643H});
            ofInt2.setInterpolator(new DecelerateInterpolator());
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    XpanelView.this.f51675q.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    XpanelView.this.f51675q.requestLayout();
                }
            });
            ofInt2.setDuration(100);
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            ofFloat2.setInterpolator(new DecelerateInterpolator());
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    XpanelView.this.f51675q.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            ofFloat2.setDuration(100);
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f51681w, "alpha", new float[]{0.0f, 1.0f});
            ofFloat3.setDuration(200);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f51672n.getChildAt(1), "alpha", new float[]{0.0f, 1.0f});
            ofFloat4.setDuration(150);
            int measuredHeight = this.f51672n.getChildAt(1).getMeasuredHeight() + XpUtils.dip2px(this.f51665g, 10.0f);
            XpLog.m36924d("xpanel_downstate", "translationY: " + measuredHeight);
            ArrayList arrayList = new ArrayList();
            int i12 = 2;
            while (true) {
                objectAnimator = ofFloat;
                if (i12 >= this.f51672n.getChildCount()) {
                    break;
                }
                View childAt = this.f51672n.getChildAt(i12);
                float[] fArr2 = new float[i8];
                fArr2[0] = (float) (-measuredHeight);
                fArr2[1] = 0.0f;
                arrayList.add(ObjectAnimator.ofFloat(childAt, str, fArr2).setDuration(300));
                i12++;
                str = str;
                ofFloat = objectAnimator;
                i8 = 2;
            }
            arrayList.add(ofFloat3);
            arrayList.add(ofFloat4);
            if (Build.VERSION.SDK_INT >= 21) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f51672n.getChildAt(1), "translationZ", new float[]{0.0f, 60.0f});
                ofFloat5.setDuration(300);
                arrayList.add(ofFloat5);
            }
            arrayList.add(ofInt);
            arrayList.add(ofInt2);
            arrayList.add(ofFloat2);
            arrayList.add(objectAnimator);
            animatorSet.playTogether(arrayList);
            animatorSet.start();
            this.f51671m.setDoingAnim(true);
            this.f51656U = true;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    XpanelView.this.f51671m.setDoingAnim(false);
                    boolean unused = XpanelView.this.f51656U = false;
                    boolean unused2 = XpanelView.this.f51648M = true;
                    if (Build.VERSION.SDK_INT >= 21) {
                        XpanelView.this.f51672n.getChildAt(1).setTranslationZ(60.0f);
                    }
                }
            });
        }
    }

    public void bottomState() {
        LinearLayout linearLayout = this.f51672n;
        if (linearLayout != null && linearLayout.getChildAt(1) != null) {
            int[] iArr = new int[2];
            this.f51672n.getChildAt(1).getLocationOnScreen(iArr);
            int i = iArr[1];
            this.f51671m.setCurrentStatus(3);
            this.f51671m.smoothScrollBy(0, -((XpUtils.getScreenHeight(this.f51666h) - i) - this.mDownHeight), this.f51648M ? 600 : 250);
            this.f51649N.doXpanelStatusHeight(3, this.mDownHeight + getMessageRealHeight());
            m36988m();
            this.f51664b.info("state吸底态", new Object[0]);
        }
    }

    public IXpMessageContainer getMessageContainer() {
        return this.f51681w;
    }

    public void setTitle(String str) {
        this.f51650O = str;
        this.f51682x.setText(str);
    }

    public void refreshMsgHeight() {
        this.f51667i.post(new Runnable() {
            public void run() {
                XpanelView.this.m36991n();
                XpanelView.this.m36993o();
                XpanelView.this.m36983j();
                XpanelView.this.m36979h();
                XpanelView.this.f51649N.doXpanelStatusHeight(2, XpanelView.this.f51637A + XpanelView.this.getMessageRealHeight());
                XpanelView.this.f51649N.doXPanelHeightChange(XpanelView.this.getFirstCardHeight() + XpanelView.this.getMessageRealHeight());
                XpLog.m36927e("doXPanelHeightChange xpanelend", "refreshMsgHeight:  getFirstCardHeight: " + XpanelView.this.getFirstCardHeight() + " getMessageRealHeight: " + XpanelView.this.getMessageRealHeight());
            }
        });
    }

    public void setConfig(XpConfig xpConfig) {
        XpLog.m36924d("lxsConfig", "setConfig" + xpConfig.getDefaultDpSecondCardShowHeight());
        m36949a(xpConfig);
    }

    public void setOmegaConfig(XpOmegaConfig xpOmegaConfig) {
        m36950a(xpOmegaConfig);
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m36991n() {
        if (this.f51681w.getVisibility() == 0 && !m36981i()) {
            this.f51681w.setTranslationY((float) (-(getFirstCardHeight() - (this.f51652Q * 2))));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m36993o() {
        if (this.f51671m.getLastStatus() != 1 && this.f51671m.getStatus() == 1) {
            return;
        }
        if (this.f51671m.getLastStatus() == 1 && this.f51671m.getStatus() != 1) {
            return;
        }
        if (m36994p() <= 0 || this.f51681w.getVisibility() != 0) {
            if (m36994p() <= 0 && !m36981i()) {
                this.f51677s.setTranslationY((float) (-((getFirstCardHeight() - XpUtils.dip2px(this.f51665g, 5.0f)) - this.f51677s.getMeasuredHeight())));
            }
        } else if (!m36981i()) {
            this.f51677s.setTranslationY((float) (-(((getFirstCardHeight() + getMessageRealHeight()) - XpUtils.dip2px(this.f51665g, 5.0f)) - this.f51677s.getMeasuredHeight())));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public int m36994p() {
        XpMessageLayout xpMessageLayout = this.f51681w;
        if (xpMessageLayout == null) {
            return 0;
        }
        return xpMessageLayout.getCurrentHeight();
    }

    public int getStatus() {
        return this.f51671m.getStatus();
    }

    public void onResume() {
        this.f51657V = false;
        if (this.f51658W.size() > 0) {
            m36954a(this.f51658W, false);
        }
    }

    public void onPause() {
        this.f51657V = true;
    }

    public void onVisibilityChanged(int i) {
        if (this.f51655T != null) {
            boolean z = i == 0;
            if (this.f51663ab != z) {
                if (i == 0) {
                    this.f51655T.setCurrentCardProperties(this.f51662aa);
                } else {
                    this.f51655T.removeCurrentCardProperties();
                }
                this.f51663ab = z;
                this.f51655T.omegaShowTrack(z);
            }
        }
    }
}
