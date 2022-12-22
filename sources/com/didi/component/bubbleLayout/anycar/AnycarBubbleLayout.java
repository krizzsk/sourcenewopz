package com.didi.component.bubbleLayout.anycar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.bubbleLayout.anycar.AanycarAbnormalView;
import com.didi.component.bubbleLayout.anycar.AnycarEstimatePanelLayout;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarGlobalConfig;
import com.didi.travel.psnger.model.response.anycar.AnyCarResponse;
import com.didi.travel.psnger.model.response.estimate.CarMessageModel;
import com.didi.travel.psnger.model.response.estimate.EstimateAbnormalModel;
import com.taxis99.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnycarBubbleLayout extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f11013A = (UiUtils.dip2px(getContext(), 70.0f) + UiUtils.getStatusBarHeight(getContext()));

    /* renamed from: B */
    private LinearLayout f11014B;

    /* renamed from: C */
    private TextView f11015C;

    /* renamed from: D */
    private FrameLayout f11016D;

    /* renamed from: E */
    private LinearLayout f11017E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public LinearLayout f11018F;

    /* renamed from: G */
    private TextView f11019G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public RelativeLayout f11020H;

    /* renamed from: I */
    private TextView f11021I;

    /* renamed from: J */
    private TextView f11022J;

    /* renamed from: K */
    private TextView f11023K;

    /* renamed from: L */
    private ImageView f11024L;

    /* renamed from: M */
    private ImageView f11025M;

    /* renamed from: N */
    private LinearLayout f11026N;

    /* renamed from: O */
    private LinearLayout f11027O;

    /* renamed from: P */
    private ImageView f11028P;

    /* renamed from: Q */
    private TextView f11029Q;

    /* renamed from: R */
    private TextView f11030R;

    /* renamed from: S */
    private ImageView f11031S;

    /* renamed from: T */
    private ImageView f11032T;

    /* renamed from: U */
    private LinearLayout f11033U;

    /* renamed from: V */
    private LinearLayout f11034V;
    /* access modifiers changed from: private */

    /* renamed from: W */
    public int f11035W;
    /* access modifiers changed from: private */

    /* renamed from: X */
    public int f11036X;

    /* renamed from: Y */
    private boolean f11037Y = false;

    /* renamed from: Z */
    private View f11038Z;

    /* renamed from: a */
    int f11039a = UiUtils.dip2px(getContext(), 110.0f);

    /* renamed from: aa */
    private View f11040aa;
    /* access modifiers changed from: private */

    /* renamed from: ab */
    public AanycarAbnormalView f11041ab;

    /* renamed from: ac */
    private boolean f11042ac = false;
    /* access modifiers changed from: private */

    /* renamed from: ad */
    public int f11043ad = 0;

    /* renamed from: ae */
    private final int f11044ae = UiUtils.dip2px(getContext(), 40.0f);

    /* renamed from: af */
    private final int f11045af = UiUtils.dip2px(getContext(), 90.0f);

    /* renamed from: ag */
    private int f11046ag = 0;

    /* renamed from: ah */
    private final int f11047ah = UiUtils.dip2px(getContext(), 174.0f);
    /* access modifiers changed from: private */

    /* renamed from: ai */
    public int f11048ai = 0;
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public boolean f11049aj = false;

    /* renamed from: ak */
    private boolean f11050ak = false;

    /* renamed from: b */
    int f11051b = UiUtils.dip2px(getContext(), 60.0f);

    /* renamed from: c */
    int f11052c = 0;

    /* renamed from: d */
    private final Logger f11053d = LoggerFactory.getLogger("AnycarBubbleLayout");
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f11054e;

    /* renamed from: f */
    private Context f11055f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f11056g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f11057h = 48;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public float f11058i = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public float f11059j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f11060k = 0;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f11061l = 3;

    /* renamed from: m */
    private RecyclerView f11062m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public AnycarEstimatePanelLayout f11063n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public LinearLayout f11064o;

    /* renamed from: p */
    private AnyCarMessageView f11065p;

    /* renamed from: q */
    private LinearLayout f11066q;

    /* renamed from: r */
    private LinearLayout f11067r;

    /* renamed from: s */
    private FrameLayout f11068s;

    /* renamed from: t */
    private LinearLayout f11069t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public View f11070u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f11071v = 0;

    /* renamed from: w */
    private float f11072w = 0.5f;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public final int f11073x = UiUtils.dip2px(getContext(), 11.0f);
    /* access modifiers changed from: private */

    /* renamed from: y */
    public final int f11074y = UiUtils.dip2px(getContext(), 20.0f);

    /* renamed from: z */
    private int f11075z = UiUtils.dip2px(getContext(), 67.0f);

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7469a(String str) {
        Logger logger = this.f11053d;
        logger.info("dongxt ---- " + str, new Object[0]);
    }

    public AnycarBubbleLayout(Context context) {
        super(context);
        m7465a(context);
    }

    public AnycarBubbleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7465a(context);
    }

    public AnycarBubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7465a(context);
    }

    public LinearLayout getContentView() {
        return this.f11067r;
    }

    public LinearLayout getFormContentView() {
        return this.f11069t;
    }

    public void showLoading() {
        showEstimateWithAnimation(true);
    }

    public void showEstimateWithAnimation(boolean z) {
        m7469a("showEstimateWithAnimation loading =" + z + "/ isloading =" + this.f11042ac);
        if (z != this.f11042ac) {
            int i = 0;
            this.f11052c = 0;
            this.f11042ac = z;
            this.f11043ad = 0;
            this.f11071v = 0;
            this.f11016D.setVisibility(8);
            this.f11017E.setVisibility(8);
            this.f11014B.setVisibility(8);
            if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
                PageCompDataTransfer.getInstance().getConfirmListener().updateAlpha(1.0f);
            }
            this.f11040aa.setVisibility(0);
            this.f11041ab.setVisibility(8);
            this.f11064o.setVisibility(8);
            this.f11063n.setVisibility(0);
            this.f11063n.setLockDispatchTouchEvent(z);
            this.f11062m.setVisibility(z ? 0 : 8);
            View view = this.f11038Z;
            if (z) {
                i = 8;
            }
            view.setVisibility(i);
            this.f11062m.post(new Runnable() {
                public void run() {
                    int defauleHeight = AnycarBubbleLayout.this.getDefauleHeight();
                    AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                    anycarBubbleLayout.m7469a("showEstimateWithAnimation ----current " + defauleHeight);
                    AnycarBubbleLayout.this.f11063n.peek(defauleHeight, (Runnable) null, 0);
                }
            });
        }
    }

    public void bindView(View view, View view2) {
        this.f11038Z = view;
        this.f11040aa = view2;
        this.f11063n.post(new Runnable() {
            public void run() {
                int defauleHeight = AnycarBubbleLayout.this.getDefauleHeight();
                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                anycarBubbleLayout.m7469a("update ----current " + defauleHeight);
                AnycarBubbleLayout.this.f11063n.peek(defauleHeight, (Runnable) null, 0);
            }
        });
    }

    /* renamed from: a */
    private void m7465a(Context context) {
        this.f11055f = context;
        this.f11054e = LayoutInflater.from(context).inflate(R.layout.anycar_estimate_layout, this, true);
        this.f11057h = UiUtils.dip2px(this.f11055f, 24.0f);
        this.f11064o = (LinearLayout) this.f11054e.findViewById(R.id.message_ll);
        this.f11065p = (AnyCarMessageView) this.f11054e.findViewById(R.id.anycar_msg);
        this.f11066q = (LinearLayout) this.f11054e.findViewById(R.id.content_ll);
        this.f11067r = (LinearLayout) this.f11054e.findViewById(R.id.estimate_content_ll);
        this.f11068s = (FrameLayout) this.f11054e.findViewById(R.id.panel_view_content);
        this.f11069t = (LinearLayout) this.f11054e.findViewById(R.id.form_view_content);
        this.f11014B = (LinearLayout) this.f11054e.findViewById(R.id.slide_tips_ll);
        this.f11015C = (TextView) this.f11054e.findViewById(R.id.slide_tips_tv);
        this.f11014B.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AnycarBubbleLayout.this.f11063n.expand();
            }
        });
        this.f11070u = this.f11054e.findViewById(R.id.baseline_v);
        FrameLayout frameLayout = (FrameLayout) this.f11054e.findViewById(R.id.preference_fl);
        this.f11016D = frameLayout;
        frameLayout.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.preference_top_fl);
        this.f11017E = linearLayout;
        linearLayout.setVisibility(8);
        m7461a();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.loading_rv);
        this.f11062m = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f11055f, 1, false));
        this.f11062m.setAdapter(new InnerAdapter(this.f11055f));
        AanycarAbnormalView aanycarAbnormalView = (AanycarAbnormalView) findViewById(R.id.anycar_abnormal);
        this.f11041ab = aanycarAbnormalView;
        aanycarAbnormalView.setClickListener(new AanycarAbnormalView.BtnClickListener() {
            public void click() {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_SHOW_GROUP_FORM);
                AnycarBubbleLayout.this.showLoading();
                AnycarBubbleLayout.this.f11041ab.setVisibility(8);
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
            }
        });
        AnycarEstimatePanelLayout anycarEstimatePanelLayout = (AnycarEstimatePanelLayout) findViewById(R.id.wrapper);
        this.f11063n = anycarEstimatePanelLayout;
        anycarEstimatePanelLayout.registerWrapperDispatchEvent(new AnycarEstimatePanelLayout.INestChildDispatchTouchEvent() {
            public void dispatchWrapperTouchEvent(MotionEvent motionEvent) {
            }

            public void dispatchWrapperOrigineTouchEvent(MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    float unused = AnycarBubbleLayout.this.f11059j = motionEvent.getY();
                } else if (action == 1 || action == 3) {
                    float y = motionEvent.getY();
                    float abs = Math.abs(y - AnycarBubbleLayout.this.f11059j);
                    boolean z = y < AnycarBubbleLayout.this.f11059j && abs > ((float) AnycarBubbleLayout.this.f11057h);
                    boolean z2 = y > AnycarBubbleLayout.this.f11059j && abs > ((float) AnycarBubbleLayout.this.f11057h);
                    int showState = AnycarBubbleLayout.this.f11063n.getShowState();
                    int defauleHeight = AnycarBubbleLayout.this.getDefauleHeight();
                    int bottomHeight = AnycarBubbleLayout.this.getBottomHeight();
                    AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                    anycarBubbleLayout.m7469a("SCROLL_DIRECTION======== deltaY=" + AnycarBubbleLayout.this.f11058i + "/ status=" + showState + "/ defalutH=" + defauleHeight + "? bottomH=" + bottomHeight + "？ SCROLL_DIRECTION=" + AnycarBubbleLayout.this.f11060k);
                    AnycarBubbleLayout anycarBubbleLayout2 = AnycarBubbleLayout.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("SCROLL_DIRECTION======== mPanelHight=");
                    sb.append(AnycarBubbleLayout.this.f11056g);
                    sb.append("、 isCanScrollUp=");
                    sb.append(AnycarBubbleLayout.this.isCanScrollUp());
                    anycarBubbleLayout2.m7469a(sb.toString());
                    AnycarBubbleLayout anycarBubbleLayout3 = AnycarBubbleLayout.this;
                    anycarBubbleLayout3.m7469a("SCROLL_DIRECTION  downY=" + AnycarBubbleLayout.this.f11059j + "/ moveY =" + y + "/ yDiff=" + abs + "/ isSlideUp=" + z + "/ isSlideDown=" + z2);
                    if (abs == 0.0f || AnycarBubbleLayout.this.f11058i <= ((float) AnycarBubbleLayout.this.f11063n.getLockTopLimit())) {
                        AnycarBubbleLayout.this.m7469a("SCROLL_DIRECTION  break");
                        AnycarBubbleLayout.this.updateSwipeTips(true);
                    } else if (z) {
                        AnycarBubbleLayout.this.m7469a(" 向上滑动");
                        int unused2 = AnycarBubbleLayout.this.f11060k = 1;
                        if (AnycarBubbleLayout.this.f11058i < ((float) (defauleHeight - AnycarBubbleLayout.this.f11057h)) && AnycarBubbleLayout.this.isCanScrollUp()) {
                            AnycarBubbleLayout.this.f11063n.expand();
                            AnycarBubbleLayout.this.m7469a("onNestChildScrollRelease=====up=== expand");
                        } else if (AnycarBubbleLayout.this.f11058i < ((float) (bottomHeight - AnycarBubbleLayout.this.f11057h))) {
                            AnycarBubbleLayout.this.m7469a("onNestChildScrollRelease======up== peek");
                            AnycarBubbleLayout.this.f11063n.peek(defauleHeight);
                        } else {
                            AnycarBubbleLayout.this.m7469a("onNestChildScrollRelease=====up=== current");
                            if (showState == 0) {
                                defauleHeight = AnycarBubbleLayout.this.getBottomHeight();
                            }
                            AnycarBubbleLayout.this.f11063n.updateStatus(showState, defauleHeight);
                        }
                    } else if (z2) {
                        AnycarBubbleLayout.this.m7469a("向下滑动");
                        int unused3 = AnycarBubbleLayout.this.f11060k = 2;
                        if (AnycarBubbleLayout.this.f11058i > ((float) (AnycarBubbleLayout.this.f11057h + defauleHeight))) {
                            AnycarBubbleLayout.this.m7469a("onNestChildScrollRelease====down==== hiden");
                            AnycarBubbleLayout.this.f11063n.hiden(bottomHeight);
                        } else if (AnycarBubbleLayout.this.f11058i > ((float) AnycarBubbleLayout.this.f11057h)) {
                            AnycarBubbleLayout.this.m7469a("onNestChildScrollRelease====down==== peek");
                            AnycarBubbleLayout.this.f11063n.peek(defauleHeight);
                        } else {
                            AnycarBubbleLayout.this.m7469a("onNestChildScrollRelease====down==== current");
                            if (showState == 0) {
                                defauleHeight = AnycarBubbleLayout.this.getBottomHeight();
                            }
                            AnycarBubbleLayout.this.f11063n.updateStatus(showState, defauleHeight);
                        }
                    } else {
                        int unused4 = AnycarBubbleLayout.this.f11060k = 0;
                        AnycarBubbleLayout.this.m7469a("onNestChildScrollRelease======= current");
                        if (showState == 0) {
                            defauleHeight = AnycarBubbleLayout.this.getBottomHeight();
                        }
                        AnycarBubbleLayout.this.f11063n.updateStatus(showState, defauleHeight);
                    }
                }
            }
        });
        this.f11063n.registerNestScrollChildCallback(new AnycarEstimatePanelLayout.INestChildScrollChange() {
            public void onFingerUp(float f) {
            }

            public void onNestChildHorizationScroll(MotionEvent motionEvent, float f, float f2) {
            }

            public void onNestChildScrollChange(float f, float f2) {
                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                anycarBubbleLayout.m7469a("onNestChildScrollChange deltaY = " + f + "/ velocityY=" + f2 + "/ preferenceTopAnimaH=" + AnycarBubbleLayout.this.f11039a + "? alphaLimit=" + AnycarBubbleLayout.this.f11051b);
                float unused = AnycarBubbleLayout.this.f11058i = f;
                AnycarBubbleLayout.this.m7462a(f);
            }

            public void onNestChildScrollRelease(float f, int i) {
                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                anycarBubbleLayout.m7469a("onNestChildScrollRelease deltaY = " + f + "/ velocityY=" + i + "/ preferenceH=" + AnycarBubbleLayout.this.f11071v);
                AnycarBubbleLayout.this.m7462a(f);
            }

            public void onNestScrollingState(int i) {
                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                anycarBubbleLayout.m7469a("onNestChildScrollRelease onNestScrollingState state= " + i);
                if (i == 1) {
                    AnycarBubbleLayout anycarBubbleLayout2 = AnycarBubbleLayout.this;
                    anycarBubbleLayout2.m7462a(anycarBubbleLayout2.f11058i);
                    AnycarBubbleLayout.this.updateSwipeTips(false);
                    AnycarBubbleLayout anycarBubbleLayout3 = AnycarBubbleLayout.this;
                    anycarBubbleLayout3.m7463a((int) anycarBubbleLayout3.f11058i);
                }
            }
        });
        this.f11063n.setSheetDirection(2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7463a(int i) {
        int i2 = i + this.f11044ae;
        if (this.f11071v != 0) {
            i2 += this.f11013A;
        }
        m7473b(i2);
        this.f11070u.post(new Runnable() {
            public void run() {
                if (AnycarBubbleLayout.this.f11063n.getShowState() != 2) {
                    Rect rect = new Rect();
                    AnycarBubbleLayout.this.f11070u.getGlobalVisibleRect(rect);
                    Rect rect2 = new Rect();
                    AnycarBubbleLayout.this.f11054e.getGlobalVisibleRect(rect2);
                    AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                    anycarBubbleLayout.m7469a("updateRect  baselineRect=" + rect.toString() + "/ bottom =" + rect.bottom + "/ currentdeltaY=" + AnycarBubbleLayout.this.f11058i);
                    AnycarBubbleLayout anycarBubbleLayout2 = AnycarBubbleLayout.this;
                    anycarBubbleLayout2.m7469a("updateRect  baselineRect  rootRect =" + rect2.toString() + "/ bottom =" + rect2.bottom + " mMessaeHeight =" + AnycarBubbleLayout.this.f11043ad);
                    int unused = AnycarBubbleLayout.this.f11048ai = ((rect2.bottom - rect.top) - AnycarBubbleLayout.this.f11073x) + AnycarBubbleLayout.this.f11043ad;
                    if (AnycarBubbleLayout.this.f11071v == 0) {
                        BaseEventPublisher.getPublisher().publish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, Integer.valueOf(AnycarBubbleLayout.this.f11048ai));
                    } else {
                        AnycarBubbleLayout.this.f11018F.post(new Runnable() {
                            public void run() {
                                int measuredHeight = AnycarBubbleLayout.this.f11018F.getMeasuredHeight();
                                int measuredHeight2 = AnycarBubbleLayout.this.f11020H.getMeasuredHeight();
                                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                                anycarBubbleLayout.m7469a("EVENT_HEIGHT_CHANGED / mBestViewHeight =" + AnycarBubbleLayout.this.f11048ai + "/ any_car_preference_card_narrow h= " + measuredHeight + "/anycar_preference_expand_content h=  " + measuredHeight2);
                                if (AnycarBubbleLayout.this.f11018F.getVisibility() != 0) {
                                    measuredHeight = 0;
                                }
                                if (AnycarBubbleLayout.this.f11020H.getVisibility() != 0) {
                                    measuredHeight2 = measuredHeight;
                                }
                                BaseEventPublisher.getPublisher().publish(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, Integer.valueOf(AnycarBubbleLayout.this.f11048ai + measuredHeight2));
                            }
                        });
                    }
                }
            }
        });
    }

    public int getDefauleHeight() {
        int measuredHeight = this.f11063n.getMeasuredHeight();
        this.f11046ag = measuredHeight;
        int i = (int) (((float) measuredHeight) * this.f11072w);
        int measuredHeight2 = this.f11066q.getMeasuredHeight();
        int i2 = measuredHeight2 + 0;
        this.f11056g = i2;
        if (i2 < i) {
            i = i2;
        }
        m7469a("===========deault hight =" + i + "、 mBestViewHeight=" + this.f11048ai + "、 messageH=" + 0 + "/ contentH=" + measuredHeight2 + "? real_h=" + this.f11056g + "/ maxH =" + this.f11046ag);
        return this.f11046ag - i;
    }

    public int getBottomHeight() {
        int i = (this.f11046ag - 0) - this.f11045af;
        m7469a("===========getBottomHight  =" + i + "/ messageH=" + 0 + "/ minestimateH " + this.f11045af);
        return i;
    }

    public boolean isCanScrollUp() {
        return this.f11056g >= ((int) (((float) this.f11046ag) * this.f11072w));
    }

    public void handleMsg() {
        CarMessageModel anyCarMsg = getAnyCarMsg();
        if (anyCarMsg == null) {
            this.f11049aj = false;
            this.f11064o.setVisibility(8);
        } else {
            if (!this.f11049aj) {
                GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_bubble_sw");
            }
            this.f11049aj = true;
            this.f11064o.setVisibility(0);
            this.f11065p.setData(anyCarMsg);
        }
        this.f11064o.post(new Runnable() {
            public void run() {
                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                int unused = anycarBubbleLayout.f11043ad = anycarBubbleLayout.f11064o.getMeasuredHeight() - AnycarBubbleLayout.this.f11074y;
                AnycarBubbleLayout anycarBubbleLayout2 = AnycarBubbleLayout.this;
                anycarBubbleLayout2.m7469a("===mMessaeHeight====" + AnycarBubbleLayout.this.f11043ad + "/ preferenceTopMaxH =" + AnycarBubbleLayout.this.f11013A + "、 " + AnycarBubbleLayout.this.f11049aj);
                if (!AnycarBubbleLayout.this.f11049aj) {
                    int unused2 = AnycarBubbleLayout.this.f11043ad = 0;
                }
                AnycarBubbleLayout anycarBubbleLayout3 = AnycarBubbleLayout.this;
                anycarBubbleLayout3.m7462a(anycarBubbleLayout3.f11058i);
                AnycarBubbleLayout.this.m7463a(AnycarBubbleLayout.this.getDefauleHeight());
            }
        });
    }

    private CarMessageModel getAnyCarMsg() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        CarMessageModel carMessageModel = null;
        if (confirmListener == null) {
            return null;
        }
        List<AnyCarEstimateItemModel> selectedAnyCarItems = confirmListener.getSelectedAnyCarItems();
        int i = Integer.MIN_VALUE;
        if (!CollectionUtil.isEmpty((Collection<?>) selectedAnyCarItems)) {
            for (AnyCarEstimateItemModel next : selectedAnyCarItems) {
                if (!(next == null || next.mAnyCarEstimateNetItem.carMessage == null || next.mAnyCarEstimateNetItem.carMessage.level < i)) {
                    i = next.mAnyCarEstimateNetItem.carMessage.level;
                    carMessageModel = next.mAnyCarEstimateNetItem.carMessage;
                }
            }
            Logger logger = this.f11053d;
            StringBuilder sb = new StringBuilder();
            sb.append("lxsanycar msg");
            sb.append((carMessageModel == null || carMessageModel.msg == null) ? "空的" : carMessageModel.msg.getContent());
            logger.debug(sb.toString(), new Object[0]);
            return carMessageModel;
        }
        this.f11053d.debug("lxsanycar msg空的", new Object[0]);
        return null;
    }

    public void handleAbnormal(boolean z) {
        boolean z2;
        EstimateAbnormalModel estimateAbnormalModel;
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null || confirmListener.getAnyCarResponse() == null || (estimateAbnormalModel = confirmListener.getAnyCarResponse().abnormalModels) == null) {
            z2 = false;
        } else {
            z2 = true;
            updateAbnormal(estimateAbnormalModel);
        }
        if (z && !z2) {
            updateAbnormal((EstimateAbnormalModel) null);
        }
    }

    public void updateAbnormal(EstimateAbnormalModel estimateAbnormalModel) {
        this.f11017E.setVisibility(8);
        this.f11014B.setVisibility(8);
        if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
            PageCompDataTransfer.getInstance().getConfirmListener().updateAlpha(1.0f);
        }
        this.f11064o.setVisibility(8);
        this.f11063n.setVisibility(8);
        this.f11016D.setVisibility(8);
        this.f11040aa.setVisibility(8);
        this.f11038Z.setVisibility(8);
        this.f11041ab.setVisibility(0);
        this.f11041ab.setData(estimateAbnormalModel);
    }

    public class InnerAdapter extends RecyclerView.Adapter<InnerViewHolder> {
        private Context mContext;
        private LayoutInflater mInflater;

        public void onBindViewHolder(InnerViewHolder innerViewHolder, int i) {
        }

        public InnerAdapter(Context context) {
            this.mContext = context;
            this.mInflater = LayoutInflater.from(context);
        }

        public InnerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new InnerViewHolder(this.mInflater.inflate(R.layout.anycar_loading, viewGroup, false));
        }

        public int getItemCount() {
            return AnycarBubbleLayout.this.f11061l;
        }
    }

    public class InnerViewHolder extends RecyclerView.ViewHolder {
        public InnerViewHolder(View view) {
            super(view);
        }
    }

    /* renamed from: a */
    private void m7461a() {
        findViewById(R.id.status_bar_v).getLayoutParams().height = UiUtils.getStatusBarHeight(this.f11055f);
        this.f11029Q = (TextView) findViewById(R.id.anycar_preference_top_left_button_title);
        this.f11030R = (TextView) findViewById(R.id.anycar_preference_top_right_button_title);
        this.f11031S = (ImageView) findViewById(R.id.anycar_preference_top_left_button_icon);
        this.f11032T = (ImageView) findViewById(R.id.anycar_preference_top_right_button_icon);
        this.f11034V = (LinearLayout) findViewById(R.id.anycar_preference_top_right_ll);
        this.f11033U = (LinearLayout) findViewById(R.id.anycar_preference_top_left_ll);
        ((ImageView) findViewById(R.id.anycar_preference_back)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                int defauleHeight = AnycarBubbleLayout.this.getDefauleHeight();
                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                anycarBubbleLayout.m7469a("top back ----current " + defauleHeight);
                AnycarBubbleLayout.this.f11063n.peek(defauleHeight);
            }
        });
        this.f11033U.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AnycarBubbleLayout.this.m7469a(" anycar_preference_top_left_ll click");
                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                anycarBubbleLayout.m7464a(anycarBubbleLayout.f11035W, true);
            }
        });
        this.f11034V.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AnycarBubbleLayout.this.m7469a(" anycar_preference_top_right_ll click");
                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                anycarBubbleLayout.m7464a(anycarBubbleLayout.f11036X, true);
            }
        });
        this.f11018F = (LinearLayout) findViewById(R.id.any_car_preference_card_narrow);
        this.f11019G = (TextView) findViewById(R.id.anycar_preference_narrow_title);
        this.f11020H = (RelativeLayout) findViewById(R.id.anycar_preference_expand_content);
        this.f11021I = (TextView) findViewById(R.id.anycar_preference_expand_title);
        this.f11022J = (TextView) findViewById(R.id.anycar_preference_left_button_title);
        this.f11023K = (TextView) findViewById(R.id.anycar_preference_right_button_title);
        this.f11024L = (ImageView) findViewById(R.id.anycar_preference_left_button_icon);
        this.f11025M = (ImageView) findViewById(R.id.anycar_preference_right_button_icon);
        this.f11027O = (LinearLayout) findViewById(R.id.anycar_preference_right_ll);
        this.f11026N = (LinearLayout) findViewById(R.id.anycar_preference_left_ll);
        this.f11018F.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AnycarBubbleLayout.this.m7469a(" any_car_preference_card_narrow click");
                GlobalOmegaUtils.trackEvent("ibt_gp_anycar_prefbtn_ck");
                AnycarBubbleLayout.this.m7470a(true);
            }
        });
        ((ImageView) findViewById(R.id.anycar_preference_card_close)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AnycarBubbleLayout.this.m7469a(" anycar_preference_card_close close");
                AnycarBubbleLayout.this.m7476b(true);
                GlobalOmegaUtils.trackEvent("ibt_gp_anycar_pref_choice_quit_ck");
            }
        });
        this.f11026N.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AnycarBubbleLayout.this.m7469a(" anycar_preference_left_ll click");
                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                anycarBubbleLayout.m7464a(anycarBubbleLayout.f11035W, true);
            }
        });
        this.f11027O.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AnycarBubbleLayout.this.m7469a(" anycar_preference_right_ll click");
                AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                anycarBubbleLayout.m7464a(anycarBubbleLayout.f11036X, true);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7462a(float f) {
        int defauleHeight = getDefauleHeight();
        this.f11064o.setTranslationY((((((float) this.f11013A) + f) + ((float) this.f11044ae)) - ((float) this.f11043ad)) + ((float) this.f11073x));
        float f2 = (float) defauleHeight;
        if (f < f2) {
            float f3 = (f2 - f) / f2;
            m7469a("updatePreferenceAlpha bg ==alphe " + f3);
            this.f11054e.setBackgroundColor(Color.parseColor("#EAEEF3"));
            if (f3 <= 0.95f) {
                this.f11054e.getBackground().setAlpha((int) (f3 * 255.0f));
            } else {
                this.f11054e.getBackground().setAlpha((int) 242.25f);
            }
        } else {
            this.f11054e.setBackgroundColor(Color.parseColor("#00000000"));
            this.f11054e.getBackground().setAlpha(0);
            this.f11070u.setTranslationY(f);
        }
        if ((this.f11071v == 0 || this.f11062m.getVisibility() == 0) && this.f11016D.getVisibility() == 0) {
            this.f11016D.setVisibility(8);
        }
        m7469a("updatePreferenceAlpha== delatY = " + f + "、 preferenceTopAnimaH=" + this.f11039a);
        int i = this.f11039a;
        if (f < ((float) i)) {
            float abs = Math.abs(f - ((float) i));
            float f4 = 1.0f - (abs / ((float) this.f11051b));
            float f5 = abs - ((float) this.f11075z);
            m7469a("updatePreferenceAlpha== alpha = " + f4 + "、 step = " + abs + "/ toplimit = " + this.f11075z + "? topstep=" + f5);
            if (f4 < 0.0f) {
                if (this.f11071v != 0) {
                    m7469a("updatePreferenceAlpha== preference_top_fl.getAlpha() = " + this.f11017E.getAlpha() + "、 preference_top_fl.getTranslationY()=" + this.f11017E.getTranslationY());
                    if (this.f11071v != 0 && this.f11016D.getVisibility() == 0) {
                        this.f11016D.setVisibility(8);
                    }
                    if (this.f11071v != 0 && this.f11017E.getVisibility() == 8) {
                        this.f11017E.setVisibility(0);
                        if (!this.f11050ak) {
                            this.f11050ak = true;
                            HashMap hashMap = new HashMap();
                            hashMap.put("type", 2);
                            GlobalOmegaUtils.trackEvent("ibt_gp_anycar_prefbtn_sw", (Map<String, Object>) hashMap);
                        }
                    }
                    if (!(this.f11071v == 0 || this.f11017E.getTranslationY() == 0.0f)) {
                        this.f11017E.setTranslationY(0.0f);
                    }
                    if (!(this.f11071v == 0 || this.f11017E.getAlpha() == 1.0f)) {
                        this.f11017E.setAlpha(1.0f);
                    }
                }
                if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
                    PageCompDataTransfer.getInstance().getConfirmListener().updateAlpha(0.0f);
                    return;
                }
                return;
            }
            if (this.f11071v != 0) {
                if (this.f11016D.getVisibility() == 8) {
                    this.f11016D.setVisibility(0);
                }
                this.f11016D.setTranslationY((((f - ((float) this.f11071v)) + ((float) this.f11013A)) + ((float) this.f11044ae)) - ((float) this.f11043ad));
                this.f11016D.setAlpha(f4);
                if (this.f11017E.getVisibility() == 8) {
                    this.f11017E.setVisibility(0);
                    if (!this.f11050ak) {
                        this.f11050ak = true;
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("type", 2);
                        GlobalOmegaUtils.trackEvent("ibt_gp_anycar_prefbtn_sw", (Map<String, Object>) hashMap2);
                    }
                }
                if (f5 < 0.0f) {
                    this.f11017E.setTranslationY(f5);
                } else {
                    this.f11017E.setTranslationY(0.0f);
                }
                this.f11017E.setAlpha(1.0f - f4);
            }
            if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
                PageCompDataTransfer.getInstance().getConfirmListener().updateAlpha(f4);
                return;
            }
            return;
        }
        if (this.f11071v != 0) {
            if (this.f11017E.getVisibility() == 0) {
                this.f11017E.setVisibility(8);
            }
            this.f11050ak = false;
            if (this.f11016D.getVisibility() == 8) {
                this.f11016D.setVisibility(0);
            }
            if (this.f11016D.getAlpha() != 1.0f) {
                this.f11016D.setAlpha(1.0f);
            }
            this.f11016D.setTranslationY((((f - ((float) this.f11071v)) + ((float) this.f11013A)) + ((float) this.f11044ae)) - ((float) this.f11043ad));
        }
        if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
            PageCompDataTransfer.getInstance().getConfirmListener().updateAlpha(1.0f);
        }
    }

    public void updatePreferenceStatus(boolean z) {
        ConfirmListener confirmListener;
        int i;
        String str;
        String str2;
        if (this.f11071v != 0 && (confirmListener = PageCompDataTransfer.getInstance().getConfirmListener()) != null) {
            List<AnyCarEstimateItemModel> selectedAnyCarItems = confirmListener.getSelectedAnyCarItems();
            if (selectedAnyCarItems == null || selectedAnyCarItems.size() <= 1) {
                this.f11026N.setEnabled(false);
                this.f11027O.setEnabled(false);
                this.f11033U.setEnabled(false);
                this.f11034V.setEnabled(false);
                this.f11024L.setEnabled(false);
                this.f11025M.setEnabled(false);
                this.f11031S.setEnabled(false);
                this.f11032T.setEnabled(false);
                this.f11022J.setTextColor(Color.parseColor("#D4D7D9"));
                this.f11023K.setTextColor(Color.parseColor("#D4D7D9"));
                this.f11029Q.setTextColor(Color.parseColor("#D4D7D9"));
                this.f11030R.setTextColor(Color.parseColor("#D4D7D9"));
                this.f11026N.setEnabled(false);
                this.f11027O.setEnabled(false);
                this.f11033U.setEnabled(false);
                this.f11034V.setEnabled(false);
                i = 1;
            } else {
                i = selectedAnyCarItems.size();
                this.f11026N.setEnabled(true);
                this.f11027O.setEnabled(true);
                this.f11033U.setEnabled(true);
                this.f11034V.setEnabled(true);
                this.f11024L.setEnabled(true);
                this.f11025M.setEnabled(true);
                this.f11031S.setEnabled(true);
                this.f11032T.setEnabled(true);
                this.f11026N.setEnabled(true);
                this.f11027O.setEnabled(true);
                this.f11033U.setEnabled(true);
                this.f11034V.setEnabled(true);
                int preference = confirmListener.getPreference();
                String str3 = "#FF6A00";
                this.f11022J.setTextColor(Color.parseColor(preference == this.f11035W ? str3 : "#000000"));
                TextView textView = this.f11023K;
                if (preference == this.f11036X) {
                    str = str3;
                } else {
                    str = "#000000";
                }
                textView.setTextColor(Color.parseColor(str));
                TextView textView2 = this.f11029Q;
                if (preference == this.f11035W) {
                    str2 = str3;
                } else {
                    str2 = "#000000";
                }
                textView2.setTextColor(Color.parseColor(str2));
                TextView textView3 = this.f11030R;
                if (preference != this.f11036X) {
                    str3 = "#000000";
                }
                textView3.setTextColor(Color.parseColor(str3));
            }
            if (z) {
                if (this.f11052c == 1 && i == 2 && !this.f11037Y) {
                    m7470a(z);
                } else if (this.f11052c == 2 && i == 1 && this.f11037Y) {
                    m7476b(z);
                }
            }
            this.f11052c = i;
        }
    }

    public void updatePreferenceData() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener != null) {
            AnyCarResponse anyCarResponse = confirmListener.getAnyCarResponse();
            if (!(anyCarResponse == null || anyCarResponse.globalConfig == null)) {
                String str = anyCarResponse.globalConfig.slideTips;
                if (this.f11015C != null && !TextUtils.isEmpty(str)) {
                    this.f11015C.setText(str);
                }
                AnyCarGlobalConfig.AnyCarPreference anyCarPreference = anyCarResponse.globalConfig.preference;
                if (anyCarPreference == null || anyCarPreference.collapseTitle == null) {
                    this.f11071v = 0;
                    this.f11016D.setVisibility(8);
                    this.f11018F.setVisibility(8);
                    this.f11020H.setVisibility(8);
                } else {
                    this.f11071v = UiUtils.dip2px(this.f11055f, 80.0f);
                    boolean z = anyCarPreference.isExpand == 1;
                    this.f11037Y = z;
                    if (z) {
                        this.f11018F.setVisibility(8);
                        this.f11020H.setVisibility(0);
                    } else {
                        this.f11018F.setVisibility(0);
                        this.f11020H.setVisibility(8);
                    }
                    anyCarPreference.collapseTitle.bindTextView(this.f11019G);
                    anyCarPreference.title.bindTextView(this.f11021I);
                    if (anyCarPreference.options != null && anyCarPreference.options.size() == 2) {
                        this.f11035W = anyCarPreference.options.get(0).type;
                        this.f11036X = anyCarPreference.options.get(1).type;
                        m7464a(anyCarPreference.userType, false);
                        this.f11022J.setText(anyCarPreference.options.get(0).title);
                        this.f11023K.setText(anyCarPreference.options.get(1).title);
                        this.f11029Q.setText(anyCarPreference.options.get(0).title);
                        this.f11030R.setText(anyCarPreference.options.get(1).title);
                    }
                }
                if (this.f11037Y) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("type", 1);
                    GlobalOmegaUtils.trackEvent("ibt_gp_anycar_prefbtn_sw", (Map<String, Object>) hashMap);
                }
            }
            updatePreferenceStatus(false);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f11068s.getLayoutParams();
        if (this.f11071v == 0) {
            layoutParams.topMargin = this.f11044ae;
        } else {
            layoutParams.topMargin = this.f11013A + this.f11044ae;
        }
        this.f11068s.setLayoutParams(layoutParams);
        m7463a(getDefauleHeight());
    }

    /* renamed from: b */
    private void m7473b(int i) {
        final ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener != null) {
            final Rect rect = new Rect();
            rect.top = i;
            rect.left = 0;
            rect.right = UiUtils.getScreenWidth(this.f11055f);
            rect.bottom = this.f11046ag;
            confirmListener.setAnycarEstimteRect(rect);
            this.f11018F.post(new Runnable() {
                public void run() {
                    Rect rect = new Rect();
                    if (AnycarBubbleLayout.this.f11018F.getVisibility() == 0) {
                        AnycarBubbleLayout.this.f11018F.getGlobalVisibleRect(rect);
                    }
                    if (AnycarBubbleLayout.this.f11020H.getVisibility() == 0) {
                        AnycarBubbleLayout.this.f11020H.getGlobalVisibleRect(rect);
                    }
                    if (rect.top == 0) {
                        confirmListener.setPreferenceRect((Rect) null);
                    } else {
                        confirmListener.setPreferenceRect(rect);
                    }
                    AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                    anycarBubbleLayout.m7469a("updateRect " + rect.toString() + "/ preference_rect=" + rect.toString());
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7464a(int i, boolean z) {
        String str;
        String str2;
        if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
            PageCompDataTransfer.getInstance().getConfirmListener().setPreference(i);
        }
        if (z) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_PREFERENCE_CHANGE);
            HashMap hashMap = new HashMap();
            hashMap.put("type", Integer.valueOf(i));
            GlobalOmegaUtils.trackEvent("ibt_gp_anycar_pref_choice_ck", (Map<String, Object>) hashMap);
        }
        boolean z2 = true;
        this.f11024L.setSelected(i == this.f11035W);
        this.f11025M.setSelected(i == this.f11036X);
        this.f11031S.setSelected(i == this.f11035W);
        this.f11032T.setSelected(i == this.f11036X);
        this.f11026N.setSelected(i == this.f11035W);
        this.f11027O.setSelected(i == this.f11036X);
        this.f11033U.setSelected(i == this.f11035W);
        LinearLayout linearLayout = this.f11034V;
        if (i != this.f11036X) {
            z2 = false;
        }
        linearLayout.setSelected(z2);
        String str3 = "#FF6A00";
        this.f11022J.setTextColor(Color.parseColor(i == this.f11035W ? str3 : "#000000"));
        TextView textView = this.f11023K;
        if (i == this.f11036X) {
            str = str3;
        } else {
            str = "#000000";
        }
        textView.setTextColor(Color.parseColor(str));
        TextView textView2 = this.f11029Q;
        if (i == this.f11035W) {
            str2 = str3;
        } else {
            str2 = "#000000";
        }
        textView2.setTextColor(Color.parseColor(str2));
        TextView textView3 = this.f11030R;
        if (i != this.f11036X) {
            str3 = "#000000";
        }
        textView3.setTextColor(Color.parseColor(str3));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7470a(boolean z) {
        this.f11037Y = true;
        if (z) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f11055f, R.anim.anycar_preference_expand_alpha_animation);
            this.f11020H.startAnimation(AnimationUtils.loadAnimation(this.f11055f, R.anim.anycar_preference_expand_animation));
            this.f11020H.setVisibility(0);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    AnycarBubbleLayout.this.f11018F.setVisibility(8);
                    AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                    anycarBubbleLayout.m7463a((int) anycarBubbleLayout.f11058i);
                }
            });
            this.f11018F.startAnimation(loadAnimation);
        } else {
            this.f11020H.setVisibility(0);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", 1);
        GlobalOmegaUtils.trackEvent("ibt_gp_anycar_prefbtn_sw", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7476b(boolean z) {
        this.f11037Y = false;
        if (z) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f11055f, R.anim.anycar_preference_narrow_animation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    AnycarBubbleLayout.this.f11020H.setVisibility(8);
                    AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                    anycarBubbleLayout.m7463a((int) anycarBubbleLayout.f11058i);
                }
            });
            this.f11020H.startAnimation(loadAnimation);
            m7459a(100, 0, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (AnycarBubbleLayout.this.f11018F != null && AnycarBubbleLayout.this.f11018F.isAttachedToWindow()) {
                        if (AnycarBubbleLayout.this.f11018F.getVisibility() == 8) {
                            AnycarBubbleLayout.this.f11018F.setVisibility(0);
                        }
                        AnycarBubbleLayout anycarBubbleLayout = AnycarBubbleLayout.this;
                        anycarBubbleLayout.m7469a("alpha = " + valueAnimator.getAnimatedValue());
                        AnycarBubbleLayout.this.f11018F.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }).start();
            return;
        }
        this.f11020H.setVisibility(8);
    }

    /* renamed from: a */
    private ValueAnimator m7459a(long j, long j2, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT));
        ofFloat.setDuration(j);
        ofFloat.setStartDelay(j2);
        ofFloat.addUpdateListener(animatorUpdateListener);
        return ofFloat;
    }

    public void updateSwipeTips(boolean z) {
        if (this.f11063n.getShowState() != 1 || z || this.f11042ac) {
            this.f11014B.setVisibility(8);
            return;
        }
        try {
            int[] viewLocation = UiUtils.getViewLocation(this.f11040aa);
            ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
            if (confirmListener == null || confirmListener.getItemStatusListener() == null || !confirmListener.getItemStatusListener().isSwipe(viewLocation[1])) {
                this.f11014B.setVisibility(8);
            } else {
                this.f11014B.setVisibility(0);
            }
        } catch (Exception unused) {
            this.f11014B.setVisibility(8);
        }
    }
}
