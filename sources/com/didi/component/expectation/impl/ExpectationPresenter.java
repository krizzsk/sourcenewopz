package com.didi.component.expectation.impl;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.work.PeriodicWorkRequest;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.TripListener;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.FormatUtils;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.business.xpanelnew.IXpCardLifeCycle;
import com.didi.component.business.xpanelnew.IXpCompRefresh;
import com.didi.component.business.xpanelnew.XpNewAdapter;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.push.model.ExpectationManagementModel;
import com.didi.component.common.util.GsonUtils;
import com.didi.component.core.ComponentParams;
import com.didi.component.expectation.AbsExpectationPresenter;
import com.didi.component.expectation.IExpectationView;
import com.didi.component.expectation.model.ExpectationData;
import com.didi.component.expectation.model.MatchingState;
import com.didi.component.expectation.model.ProgressState;
import com.didi.component.expectation.model.UsePrivilege;
import com.didi.component.expectation.model.UsePrivilegeMatchingState;
import com.didi.component.expectation.view.FlexRaiseDialogView;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.monitor.PubSIDManager;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.utils.OmegaUtils;
import com.didi.travel.psnger.utils.TextUtil;
import com.didichuxing.bigdata.p173dp.locsdk.ntp.TimeServiceManager;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.travel.util.CollectionUtils;
import com.didiglobal.travel.util.Preconditions;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

public class ExpectationPresenter extends AbsExpectationPresenter<IExpectationView> implements IXpCardLifeCycle, IXpCompRefresh, XpNewAdapter {

    /* renamed from: A */
    private static final int f13602A = 2;

    /* renamed from: D */
    private static final int f13603D = 400;

    /* renamed from: E */
    private static final float f13604E = 4.0f;

    /* renamed from: F */
    private static final int f13605F = 66;

    /* renamed from: G */
    private static final float f13606G = 8.0f;

    /* renamed from: S */
    private static final int f13607S = 1;

    /* renamed from: b */
    private static final String f13608b = "ExpectationPresenter";

    /* renamed from: d */
    private static final int f13609d = 100;

    /* renamed from: e */
    private static final int f13610e = 1000;

    /* renamed from: f */
    private static final int f13611f = 300000;

    /* renamed from: z */
    private static final int f13612z = 0;

    /* renamed from: B */
    private int f13613B = 0;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f13614C = false;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public boolean f13615H = true;

    /* renamed from: I */
    private int f13616I;

    /* renamed from: J */
    private boolean f13617J = false;

    /* renamed from: K */
    private CountDownTimer f13618K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public int f13619L;

    /* renamed from: M */
    private int f13620M = 0;

    /* renamed from: N */
    private boolean f13621N;

    /* renamed from: O */
    private boolean f13622O = false;

    /* renamed from: P */
    private ProgressState f13623P;

    /* renamed from: Q */
    private boolean f13624Q = false;

    /* renamed from: R */
    private FlexRaiseDialogView f13625R;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public final Handler f13626T = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                ExpectationPresenter.this.m9402q();
                ExpectationPresenter.this.f13626T.sendEmptyMessageDelayed(1, 30000);
            }
        }
    };

    /* renamed from: a */
    long f13627a = 400;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Logger f13628c = LoggerFactory.getLogger(f13608b);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ExpectationData f13629g;

    /* renamed from: h */
    private CountDownTimer f13630h;

    /* renamed from: i */
    private CountDownTimer f13631i;

    /* renamed from: j */
    private CountDownTimer f13632j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public long f13633k = 0;

    /* renamed from: l */
    private long f13634l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public long f13635m = 0;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f13636n = 0;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f13637p = 0;

    /* renamed from: q */
    private BusinessContext f13638q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public LEGODrawer f13639r;

    /* renamed from: s */
    private boolean f13640s = false;

    /* renamed from: t */
    private int f13641t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public String f13642u;

    /* renamed from: v */
    private int f13643v = -1;

    /* renamed from: w */
    private final ExpectationModel<ExpectationPresenter> f13644w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int f13645x = 0;

    /* renamed from: y */
    private long f13646y = 0;

    interface TimeCountCallBack {
        void onFinish();

        void onProgress(float f);
    }

    /* renamed from: D */
    static /* synthetic */ long m9333D(ExpectationPresenter expectationPresenter) {
        long j = expectationPresenter.f13634l;
        expectationPresenter.f13634l = 1 + j;
        return j;
    }

    /* renamed from: E */
    static /* synthetic */ long m9334E(ExpectationPresenter expectationPresenter) {
        long j = expectationPresenter.f13646y;
        expectationPresenter.f13646y = 1 + j;
        return j;
    }

    /* renamed from: F */
    static /* synthetic */ long m9335F(ExpectationPresenter expectationPresenter) {
        long j = expectationPresenter.f13646y;
        expectationPresenter.f13646y = j - 1;
        return j;
    }

    /* renamed from: v */
    static /* synthetic */ long m9407v(ExpectationPresenter expectationPresenter) {
        long j = expectationPresenter.f13635m;
        expectationPresenter.f13635m = 1 + j;
        return j;
    }

    /* renamed from: w */
    static /* synthetic */ long m9408w(ExpectationPresenter expectationPresenter) {
        long j = expectationPresenter.f13635m;
        expectationPresenter.f13635m = j - 1;
        return j;
    }

    /* renamed from: x */
    static /* synthetic */ long m9409x(ExpectationPresenter expectationPresenter) {
        long j = expectationPresenter.f13633k;
        expectationPresenter.f13633k = 1 + j;
        return j;
    }

    /* renamed from: y */
    static /* synthetic */ int m9410y(ExpectationPresenter expectationPresenter) {
        int i = expectationPresenter.f13645x;
        expectationPresenter.f13645x = i + 1;
        return i;
    }

    public ExpectationPresenter(ComponentParams componentParams) {
        super(componentParams.bizCtx.getContext());
        this.f13638q = componentParams.bizCtx;
        ExpectationModel<ExpectationPresenter> expectationModel = new ExpectationModel<>();
        this.f13644w = expectationModel;
        expectationModel.setPresenter(this);
    }

    public void onFinishAnimate(int i) {
        m9366b();
        if (i > 0 && this.f13629g != null) {
            ((IExpectationView) this.mView).finishProgressBar(m9383h(), i);
        }
    }

    public void onFlexClick() {
        if (this.f13629g.flex_raise == null || this.f13629g.flex_raise.raise_sheet == null) {
            this.f13628c.info(" raise_sheet is null", new Object[0]);
            return;
        }
        this.f13625R = FlexRaiseDialogView.newInstance(this.f13629g.flex_raise.raise_sheet);
        if (!(this.mContext == null || ((FragmentActivity) this.mContext).getSupportFragmentManager() == null)) {
            this.f13625R.show(((FragmentActivity) this.mContext).getSupportFragmentManager(), "flexRaiseDialogView");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("k", "click");
        hashMap.put(RavenKey.VERSION, "raisefare");
        if (!(this.f13629g.flex_raise.raise_sheet == null || this.f13629g.flex_raise.raise_sheet.config == null)) {
            hashMap.put("price", this.f13629g.flex_raise.raise_sheet.config.current_price);
        }
        hashMap.put("time", Integer.valueOf(m9377e()));
        if (!(this.f13629g.flex_raise.raise_sheet == null || this.f13629g.flex_raise.raise_sheet.config == null)) {
            hashMap.put("price", this.f13629g.flex_raise.raise_sheet.config.current_price);
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_wait_raisefare_ck", (Map<String, Object>) hashMap);
    }

    public void onTipsClick() {
        OmegaUtils.trackEvent("ibt_gp_waitforresponse_whywait_ck");
        LEGODrawer lEGODrawer = this.f13639r;
        if (lEGODrawer != null) {
            lEGODrawer.dismiss();
        }
        LEGODrawerModel1 lEGODrawerModel1 = new LEGODrawerModel1(this.mContext.getString(R.string.GRider_0930_Just_a_rzTo), new LEGOBtnTextAndCallback(this.mContext.getString(R.string.GRider_0930_I_see_MOst), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (ExpectationPresenter.this.f13639r != null) {
                    ExpectationPresenter.this.f13639r.dismiss();
                }
            }
        }));
        lEGODrawerModel1.setSubTitle(this.mContext.getString(R.string.GRider_0930_We_use_ZQLn));
        this.f13639r = LEGOUICreator.showDrawerTemplate(this.mContext, lEGODrawerModel1);
    }

    public void processDuseInfo(ExpectationManagementModel expectationManagementModel) {
        if (expectationManagementModel != null) {
            if (this.f13629g.skip_push == 1) {
                this.f13628c.info("skip_duse_push ", new Object[0]);
                return;
            }
            try {
                int i = expectationManagementModel.duse_status;
                int i2 = expectationManagementModel.driver_num;
                String str = expectationManagementModel.use_pmsg == 1 ? expectationManagementModel.pmsg : null;
                String str2 = expectationManagementModel.oid_base64;
                if (i == 1) {
                    if (TextUtils.isEmpty(str) && i2 > 0) {
                        str = this.mContext.getResources().getString(R.string.global_wait_4_resp_drivers_founds, new Object[]{Integer.valueOf(i2)});
                    }
                    m9390k();
                    if (!TextUtils.isEmpty(str)) {
                        m9356a(str);
                    }
                    if (this.f13643v == 2 && !TextUtils.isEmpty(this.f13642u)) {
                        int e = m9377e();
                        if (this.f13629g != null) {
                            if (m9395n() == 2) {
                                e = m9397o();
                            } else {
                                e = m9377e();
                            }
                        }
                        if (e < this.f13641t) {
                            m9348a(this.f13641t - e, (TimeCountCallBack) new TimeCountCallBack() {
                                public void onProgress(float f) {
                                    ExpectationPresenter expectationPresenter = ExpectationPresenter.this;
                                    expectationPresenter.m9373c(expectationPresenter.f13629g.getMatchingStateList().get(ExpectationPresenter.this.f13637p));
                                    if (ExpectationPresenter.this.m9395n() == 2) {
                                        ExpectationPresenter expectationPresenter2 = ExpectationPresenter.this;
                                        expectationPresenter2.m9376d(expectationPresenter2.f13629g.getMatchingStateList().get(ExpectationPresenter.this.f13637p));
                                    }
                                }

                                public void onFinish() {
                                    ExpectationPresenter expectationPresenter = ExpectationPresenter.this;
                                    expectationPresenter.m9356a(expectationPresenter.f13642u);
                                }
                            }, m9383h());
                        } else {
                            m9356a(this.f13642u);
                        }
                    }
                } else if (i != 2) {
                    if (i == 3) {
                        if (TextUtils.isEmpty(str)) {
                            str = ResourcesHelper.getString(this.mContext, R.string.global_wait_4_resp_driver_matching);
                        }
                        m9390k();
                        m9356a(str);
                        if (expectationManagementModel.showtime > 0) {
                            m9348a(expectationManagementModel.showtime, (TimeCountCallBack) new TimeCountCallBack() {
                                public void onProgress(float f) {
                                    if (ExpectationPresenter.this.f13629g == null || ExpectationPresenter.this.f13629g.getMatchingStateList() == null || ExpectationPresenter.this.f13629g.getMatchingStateList().size() <= ExpectationPresenter.this.f13637p) {
                                        ExpectationPresenter.this.f13628c.info("ExpectationData MatchingStateList size < mMatchingStep", new Object[0]);
                                        return;
                                    }
                                    ExpectationPresenter expectationPresenter = ExpectationPresenter.this;
                                    expectationPresenter.m9373c(expectationPresenter.f13629g.getMatchingStateList().get(ExpectationPresenter.this.f13637p));
                                    if (ExpectationPresenter.this.m9395n() == 2) {
                                        ExpectationPresenter expectationPresenter2 = ExpectationPresenter.this;
                                        expectationPresenter2.m9376d(expectationPresenter2.f13629g.getMatchingStateList().get(ExpectationPresenter.this.f13637p));
                                    }
                                }

                                public void onFinish() {
                                    ExpectationPresenter.this.doPublish(BaseEventKeys.Expectation.EVENT_EXPECTATION_DUSE_BROADCAST_FAIL);
                                    CarOrder order = CarOrderHelper.getOrder();
                                    if (order != null) {
                                        long unused = ExpectationPresenter.this.f13633k = (TimeServiceManager.getInstance().getNTPCurrenTimeMillis() - order.getCreateTime()) / 1000;
                                        ExpectationPresenter expectationPresenter = ExpectationPresenter.this;
                                        int b = expectationPresenter.m9341a(expectationPresenter.f13633k);
                                        if (ExpectationPresenter.this.f13629g != null) {
                                            if (ExpectationPresenter.this.m9395n() == 2) {
                                                ExpectationPresenter expectationPresenter2 = ExpectationPresenter.this;
                                                b = expectationPresenter2.m9341a((long) expectationPresenter2.m9397o());
                                            } else {
                                                ExpectationPresenter expectationPresenter3 = ExpectationPresenter.this;
                                                b = expectationPresenter3.m9341a(expectationPresenter3.f13633k);
                                            }
                                        }
                                        MatchingState a = ExpectationPresenter.this.m9343a(b);
                                        if (a != null) {
                                            ExpectationPresenter.this.m9368b(a);
                                        }
                                    }
                                }
                            }, m9383h());
                        }
                    }
                } else if (this.f13629g == null || this.f13629g.getExpectationManagementModel() == null) {
                    if (expectationManagementModel.use_pmsg == 1 && expectationManagementModel.wait_time > 0 && !TextUtil.isEmpty(expectationManagementModel.pmsg)) {
                        this.f13641t = expectationManagementModel.wait_time;
                        this.f13642u = expectationManagementModel.pmsg;
                    }
                }
                this.f13643v = i;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public BusinessContext getBizContext() {
        return this.f13638q;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        int i = bundle.getInt(BaseExtras.Common.EXTRA_ORDER_SOURCE, 0);
        this.f13616I = i;
        if (i == 0) {
            this.f13640s = true;
        }
        this.f13624Q = false;
        m9359a(false);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        ExpectationData expectationData = this.f13629g;
        if (!(expectationData == null || expectationData.carRequestingBubbleTip == null)) {
            ((IExpectationView) this.mView).closeAnyCarTipComplete(this.f13629g.carRequestingBubbleTip.bubbleId);
        }
        onCardRemove();
        this.f13624Q = false;
    }

    /* renamed from: b */
    private void m9366b() {
        m9386i();
        m9388j();
        m9390k();
    }

    /* renamed from: c */
    private void m9371c() {
        int i;
        int i2;
        if (this.f13640s) {
            this.f13633k = 0;
            this.f13635m = 0;
            this.f13640s = false;
        } else {
            this.f13633k = (long) m9377e();
            this.f13635m = (long) m9377e();
            this.f13634l = (long) m9377e();
        }
        if (m9395n() == 2) {
            this.f13645x = m9397o();
            this.f13646y = (long) m9397o();
            this.f13614C = true;
            this.f13634l = (long) m9397o();
        }
        if (m9395n() == 2) {
            i = m9341a((long) this.f13645x);
        } else {
            i = m9341a(this.f13633k);
        }
        if (m9395n() == 2) {
            i2 = m9361b((long) this.f13645x);
        } else {
            i2 = m9361b(this.f13633k);
        }
        if (m9383h() == 1 && !this.f13622O) {
            this.f13635m = ((long) this.f13629g.getTotalWaitTime()) - this.f13635m;
            if (m9395n() == 2) {
                this.f13646y = ((long) this.f13629g.getTotalWaitTime()) - this.f13646y;
            }
        }
        if (this.f13622O) {
            ((IExpectationView) this.mView).setAnyCarRequestingList(this.f13629g.carRequestingList);
            ((IExpectationView) this.mView).showAnyCarRequestTip(this.f13629g.carRequestingBubbleTip);
        }
        MatchingState a = m9343a(i);
        if (a != null) {
            m9368b(a);
        }
        if (m9395n() != 2 || m9397o() < this.f13629g.getTotalWaitTime()) {
            ProgressState b = m9365b(i2);
            if (b != null) {
                m9354a(b);
            }
            m9400p();
        }
    }

    /* renamed from: d */
    private void m9375d() {
        ((IExpectationView) this.mView).setAnyCarRequestingList(this.f13629g.carRequestingList);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9356a(String str) {
        ((IExpectationView) this.mView).setTitleText(str);
        doPublish(BaseEventKeys.NewXpanel.EVENT_XPANEL_UPDATE_TITLE, str);
    }

    /* renamed from: a */
    private void m9353a(MatchingState matchingState) {
        Objects.requireNonNull(matchingState);
        LEGORichInfo titleInfo = matchingState.getTitleInfo();
        String str = null;
        CharSequence parseRichInfo = Preconditions.nonNull(titleInfo) ? titleInfo.parseRichInfo(m9393m()) : null;
        if (TextUtils.isEmpty(parseRichInfo)) {
            parseRichInfo = matchingState.getTitle();
        }
        IExpectationView iExpectationView = (IExpectationView) this.mView;
        if (Preconditions.nonNull(iExpectationView)) {
            iExpectationView.setTitleText(parseRichInfo);
            iExpectationView.setTimeDes(matchingState.getTimeDes());
        }
        if (Preconditions.nonNull(parseRichInfo)) {
            str = parseRichInfo.toString();
        }
        doPublish(BaseEventKeys.NewXpanel.EVENT_XPANEL_UPDATE_TITLE, str);
    }

    /* renamed from: e */
    private int m9377e() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null || order.getCreateTime() <= 0) {
            return 0;
        }
        Logger logger = this.f13628c;
        logger.info("getOrderSpendTime: isNTPEnabled() " + TimeServiceManager.getInstance().isNTPEnabled() + " isNTPAvailable() " + TimeServiceManager.getInstance().isNTPAvailable(), new Object[0]);
        Logger logger2 = this.f13628c;
        StringBuilder sb = new StringBuilder();
        sb.append("getOrderSpendTime: order.getCreateTime() ");
        sb.append(order.getCreateTime());
        logger2.info(sb.toString(), new Object[0]);
        Logger logger3 = this.f13628c;
        logger3.info("getOrderSpendTime: diff " + TimeServiceManager.getInstance().getNTPTimeDiffMillis() + " npttime " + TimeServiceManager.getInstance().getNTPCurrenTimeMillis() + " System.currentTimeMillis() " + System.currentTimeMillis(), new Object[0]);
        Logger logger4 = this.f13628c;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getOrderSpendTime() CarOrder ");
        sb2.append((TimeServiceManager.getInstance().getNTPCurrenTimeMillis() - order.getCreateTime()) / 1000);
        logger4.info(sb2.toString(), new Object[0]);
        return (int) ((TimeServiceManager.getInstance().getNTPCurrenTimeMillis() - order.getCreateTime()) / 1000);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m9341a(long j) {
        this.f13637p = 0;
        ExpectationData expectationData = this.f13629g;
        if (expectationData == null || expectationData.getMatchingStateList() == null || j <= 0) {
            return -1;
        }
        for (MatchingState next : this.f13629g.getMatchingStateList()) {
            if (j < ((long) next.getTimeInterval())) {
                break;
            }
            this.f13637p++;
            j -= (long) next.getTimeInterval();
        }
        if (this.f13637p == this.f13629g.getMatchingStateList().size()) {
            return -1;
        }
        return (int) j;
    }

    /* renamed from: b */
    private int m9361b(long j) {
        this.f13636n = 0;
        ExpectationData expectationData = this.f13629g;
        if (expectationData == null || expectationData.getProgressStateList() == null || j <= 0) {
            return -1;
        }
        for (ProgressState next : this.f13629g.getProgressStateList()) {
            if (j < ((long) next.getTimeInterval())) {
                break;
            }
            this.f13636n++;
            j -= (long) next.getTimeInterval();
        }
        if (this.f13636n == this.f13629g.getProgressStateList().size()) {
            return -1;
        }
        return (int) j;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public MatchingState m9343a(int i) {
        ExpectationData expectationData = this.f13629g;
        if (expectationData == null || expectationData.getMatchingStateList() == null || this.f13629g.getMatchingStateList().size() <= 0) {
            return null;
        }
        if (this.f13637p >= this.f13629g.getMatchingStateList().size()) {
            this.f13637p = this.f13629g.getMatchingStateList().size() - 1;
        }
        MatchingState matchingState = this.f13629g.getMatchingStateList().get(this.f13637p);
        if (i > 0 && matchingState != null) {
            matchingState.setTimeInterval(matchingState.getTimeInterval() - i);
        }
        return matchingState;
    }

    /* renamed from: b */
    private ProgressState m9365b(int i) {
        ExpectationData expectationData = this.f13629g;
        if (expectationData == null || expectationData.getProgressStateList() == null || this.f13636n >= this.f13629g.getProgressStateList().size()) {
            return null;
        }
        ProgressState progressState = this.f13629g.getProgressStateList().get(this.f13636n);
        this.f13623P = progressState;
        if (i > 0 && progressState != null) {
            progressState.setStartProgress(((progressState.getEndProgress() - progressState.getStartProgress()) * (((float) i) / ((float) progressState.getTimeInterval()))) + progressState.getStartProgress());
            progressState.setTimeInterval(progressState.getTimeInterval() - i);
        }
        return progressState;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public MatchingState m9379f() {
        this.f13637p++;
        return m9343a(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public ProgressState m9382g() {
        this.f13636n++;
        return m9365b(0);
    }

    public void iconClick(String str) {
        DRouter.build(str).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9368b(final MatchingState matchingState) {
        if (matchingState != null) {
            m9353a(matchingState);
            if (m9395n() != 2) {
                GlobalRichInfo subtitleRich = matchingState.getSubtitleRich();
                CharSequence parseRichInfo = Preconditions.nonNull(subtitleRich) ? subtitleRich.parseRichInfo(m9393m()) : null;
                if (TextUtils.isEmpty(parseRichInfo)) {
                    parseRichInfo = matchingState.getSubtitle();
                }
                if (TextUtils.isEmpty(parseRichInfo)) {
                    ((IExpectationView) this.mView).hideSubTitleText();
                } else {
                    ((IExpectationView) this.mView).setSubTitleText(parseRichInfo);
                }
            } else if (matchingState.getSubtitleRich() == null || TextUtil.isEmpty(matchingState.getSubtitleRich().getContent())) {
                ((IExpectationView) this.mView).hideSubTitleText();
            } else {
                m9376d(matchingState);
            }
            if (TextUtils.isEmpty(matchingState.getCaption())) {
                ((IExpectationView) this.mView).hideCaptionText();
            } else {
                ((IExpectationView) this.mView).setCaptionText(matchingState.getCaption().replace("\\n", "\n").replace("%@", "00:00"));
                ((IExpectationView) this.mView).setTipsBackground((Drawable) null);
            }
            if (matchingState.getTipsText() == null || TextUtils.isEmpty(matchingState.getTipsText().getContent())) {
                ((IExpectationView) this.mView).hideTips();
            } else {
                ((IExpectationView) this.mView).setTips(matchingState.getTipsText(), matchingState.getRightIcon(), matchingState.getRightIconClick());
                if (m9395n() == 2) {
                    ((IExpectationView) this.mView).setTipsBackground(ContextCompat.getDrawable(this.mContext, R.drawable.tips_background));
                } else {
                    ((IExpectationView) this.mView).setTipsBackground((Drawable) null);
                }
            }
            ((IExpectationView) this.mView).setMainIcon(WebpLocResEnum.getEnum(matchingState.getAnimationImageType()));
            m9390k();
            m9348a(matchingState.getTimeInterval(), (TimeCountCallBack) new TimeCountCallBack() {
                public void onProgress(float f) {
                    ExpectationPresenter.this.m9373c(matchingState);
                    if (ExpectationPresenter.this.m9395n() == 2) {
                        ExpectationPresenter.this.m9376d(matchingState);
                    }
                }

                public void onFinish() {
                    MatchingState i = ExpectationPresenter.this.m9379f();
                    if (i != null) {
                        ExpectationPresenter.this.m9368b(i);
                    }
                }
            }, m9383h());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9354a(ProgressState progressState) {
        if (progressState != null) {
            boolean z = true;
            if (this.f13622O && progressState.getCountOrder() == 1) {
                this.f13635m = (long) progressState.getTimeInterval();
            }
            if (this.f13629g != null) {
                if (m9395n() == 2) {
                    ((IExpectationView) this.mView).setWaitProgressBar(progressState.getStartProgress(), progressState, this.f13636n);
                    ((IExpectationView) this.mView).showThumb(progressState.getProcessIconUri(), progressState.getProcessIconType(), progressState.getStartProgress(), progressState.getEndProgress(), progressState.getTimeInterval(), this.f13614C, this.f13636n, m9397o(), this.f13629g.getTotalWaitTime());
                    ((IExpectationView) this.mView).shakeGiftBox(4.0f, 400, -1, this.f13636n, (Animator.AnimatorListener) null);
                } else {
                    ((IExpectationView) this.mView).setProgressBar(progressState.getStartProgress());
                }
            }
            m9386i();
            if (progressState.getEndProgress() != progressState.getStartProgress()) {
                m9346a(progressState.getStartProgress(), progressState.getEndProgress(), progressState.getTimeInterval());
            }
            m9388j();
            if (progressState.getShowTime() != 1) {
                ((IExpectationView) this.mView).hideTime();
            } else if (m9395n() == 2) {
                ((IExpectationView) this.mView).hideTime();
            } else {
                ExpectationData expectationData = this.f13629g;
                ((IExpectationView) this.mView).setTimes(FormatUtils.formatTime(this.f13635m), (expectationData == null || TextUtils.isEmpty(expectationData.getTimePreFix())) ? "" : this.f13629g.getTimePreFix());
            }
            if (progressState.getTimeInterval() != -1) {
                int timeInterval = progressState.getTimeInterval();
                int h = m9383h();
                if (progressState.getShowTime() != 1) {
                    z = false;
                }
                m9347a(timeInterval, h, z);
            }
        }
    }

    /* renamed from: h */
    private int m9383h() {
        ExpectationData expectationData = this.f13629g;
        if (expectationData == null) {
            return 0;
        }
        if (this.f13623P == null && expectationData.getProgressStateList() != null && this.f13629g.getProgressStateList().size() > 0) {
            this.f13623P = this.f13629g.getProgressStateList().get(0);
        }
        ProgressState progressState = this.f13623P;
        if (progressState == null || progressState.getCountOrder() == -1000) {
            return this.f13629g.getCountOrder();
        }
        return this.f13623P.getCountOrder();
    }

    /* renamed from: a */
    private void m9346a(final float f, final float f2, int i) {
        m9386i();
        final C57295 r6 = new TimeCountCallBack() {
            public void onProgress(float f) {
                if (ExpectationPresenter.this.m9395n() == 2) {
                    float f2 = f;
                    ((IExpectationView) ExpectationPresenter.this.mView).setWaitProgressBar(f2 + ((f2 - f2) * f), ExpectationPresenter.this.f13629g.getProgressStateList().get(ExpectationPresenter.this.f13636n), ExpectationPresenter.this.f13636n);
                    if (f2 == 1.0f && ExpectationPresenter.this.f13615H && ((double) f) > 0.95d) {
                        ((IExpectationView) ExpectationPresenter.this.mView).shakeGiftBox(8.0f, 66, 0, ExpectationPresenter.this.f13636n, new Animator.AnimatorListener() {
                            public void onAnimationCancel(Animator animator) {
                            }

                            public void onAnimationRepeat(Animator animator) {
                            }

                            public void onAnimationStart(Animator animator) {
                            }

                            public void onAnimationEnd(Animator animator) {
                                if (animator != null) {
                                    animator.cancel();
                                    animator.removeAllListeners();
                                }
                                if (ExpectationPresenter.this.f13629g != null && ExpectationPresenter.this.f13629g.getCouponInfo() != null) {
                                    ((IExpectationView) ExpectationPresenter.this.mView).openBoxAndShowCoupon(ExpectationPresenter.this.f13629g.getCouponInfo().getDiscount());
                                }
                            }
                        });
                        boolean unused = ExpectationPresenter.this.f13615H = false;
                        return;
                    }
                    return;
                }
                float f3 = f;
                ((IExpectationView) ExpectationPresenter.this.mView).setProgressBar(f3 + ((f2 - f3) * f));
            }

            public void onFinish() {
                if (ExpectationPresenter.this.m9395n() != 2) {
                    ((IExpectationView) ExpectationPresenter.this.mView).setProgressBar(f2);
                } else if (ExpectationPresenter.this.f13636n < ExpectationPresenter.this.f13629g.getProgressStateList().size()) {
                    ((IExpectationView) ExpectationPresenter.this.mView).setWaitProgressBar(f2, ExpectationPresenter.this.f13629g.getProgressStateList().get(ExpectationPresenter.this.f13636n), ExpectationPresenter.this.f13636n);
                } else {
                    ((IExpectationView) ExpectationPresenter.this.mView).setWaitProgressBar(f2, ExpectationPresenter.this.f13629g.getProgressStateList().get(ExpectationPresenter.this.f13629g.getProgressStateList().size() - 1), ExpectationPresenter.this.f13629g.getProgressStateList().size() - 1);
                }
            }
        };
        final int i2 = i;
        this.f13631i = new CountDownTimer((long) (i * 1000), 100) {
            public void onTick(long j) {
                r6.onProgress((float) (1.0d - (((double) (j / ((long) i2))) / 1000.0d)));
            }

            public void onFinish() {
                r6.onFinish();
            }
        }.start();
    }

    /* renamed from: i */
    private void m9386i() {
        CountDownTimer countDownTimer = this.f13631i;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* renamed from: a */
    private void m9347a(int i, final int i2, final boolean z) {
        m9388j();
        final C57327 r6 = new TimeCountCallBack() {
            public void onProgress(float f) {
                if (z) {
                    if (ExpectationPresenter.this.m9395n() == 2) {
                        ((IExpectationView) ExpectationPresenter.this.mView).hideTime();
                    } else {
                        ((IExpectationView) ExpectationPresenter.this.mView).setTimes(FormatUtils.formatTime(ExpectationPresenter.this.f13635m), (ExpectationPresenter.this.f13629g == null || TextUtils.isEmpty(ExpectationPresenter.this.f13629g.getTimePreFix())) ? "" : ExpectationPresenter.this.f13629g.getTimePreFix());
                    }
                    if (i2 == 0) {
                        ExpectationPresenter.m9407v(ExpectationPresenter.this);
                    } else {
                        ExpectationPresenter.m9408w(ExpectationPresenter.this);
                    }
                    ExpectationPresenter.m9409x(ExpectationPresenter.this);
                    if (ExpectationPresenter.this.m9395n() == 2) {
                        ExpectationPresenter.m9410y(ExpectationPresenter.this);
                        if (ExpectationPresenter.this.f13629g != null) {
                            ExpectationPresenter.this.f13629g.setWaitedTime(ExpectationPresenter.this.f13645x);
                        }
                    }
                }
            }

            public void onFinish() {
                if (!z) {
                    if (ExpectationPresenter.this.m9395n() == 2) {
                        ((IExpectationView) ExpectationPresenter.this.mView).hideTime();
                    } else {
                        ((IExpectationView) ExpectationPresenter.this.mView).setTimes(FormatUtils.formatTime(ExpectationPresenter.this.f13635m), (ExpectationPresenter.this.f13629g == null || TextUtils.isEmpty(ExpectationPresenter.this.f13629g.getTimePreFix())) ? "" : ExpectationPresenter.this.f13629g.getTimePreFix());
                    }
                }
                ProgressState C = ExpectationPresenter.this.m9382g();
                if (C != null) {
                    if (ExpectationPresenter.this.m9395n() == 2) {
                        boolean unused = ExpectationPresenter.this.f13614C = false;
                    }
                    ExpectationPresenter.this.m9354a(C);
                }
            }
        };
        final int i3 = i;
        this.f13630h = new CountDownTimer((long) (i * 1000), 1000) {
            public void onTick(long j) {
                r6.onProgress((float) (1 - ((j / ((long) i3)) / 1000)));
            }

            public void onFinish() {
                r6.onFinish();
            }
        }.start();
    }

    /* renamed from: j */
    private void m9388j() {
        CountDownTimer countDownTimer = this.f13630h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* renamed from: a */
    private void m9348a(int i, TimeCountCallBack timeCountCallBack, int i2) {
        m9390k();
        final int i3 = i2;
        final TimeCountCallBack timeCountCallBack2 = timeCountCallBack;
        final int i4 = i;
        this.f13632j = new CountDownTimer(i < 0 ? PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS : (long) (i * 1000), 1000) {
            public void onTick(long j) {
                ExpectationPresenter.m9333D(ExpectationPresenter.this);
                if (ExpectationPresenter.this.m9395n() == 2) {
                    if (i3 == 0) {
                        ExpectationPresenter.m9334E(ExpectationPresenter.this);
                    } else {
                        ExpectationPresenter.m9335F(ExpectationPresenter.this);
                    }
                }
                timeCountCallBack2.onProgress((float) (1 - ((j / ((long) i4)) / 1000)));
            }

            public void onFinish() {
                if (i4 >= 0) {
                    timeCountCallBack2.onFinish();
                }
            }
        }.start();
    }

    /* renamed from: k */
    private void m9390k() {
        CountDownTimer countDownTimer = this.f13632j;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void setViewWithData(JSONObject jSONObject, IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        JSONObject optJSONObject = jSONObject.optJSONObject("normal");
        if (optJSONObject != null) {
            ExpectationData expectationData = (ExpectationData) GsonUtils.singleGson().fromJson(optJSONObject.optString("data"), ExpectationData.class);
            this.f13629g = expectationData;
            if (expectationData != null) {
                if (expectationData.carRequestingList == null || this.f13629g.carRequestingList.size() <= 0) {
                    this.f13622O = false;
                    ((IExpectationView) this.mView).setIsAnyCar(false);
                    m9359a(false);
                    OmegaSDK.removeGlobalAttr("pub_allbiz");
                } else {
                    this.f13622O = true;
                    ((IExpectationView) this.mView).setIsAnyCar(true);
                    if (!this.f13624Q) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < this.f13629g.carRequestingList.size(); i++) {
                            if (i < this.f13629g.carRequestingList.size() - 1) {
                                sb.append(this.f13629g.carRequestingList.get(i).business_id);
                                sb.append(",");
                            } else {
                                sb.append(this.f13629g.carRequestingList.get(i).business_id);
                            }
                        }
                        OmegaSDK.putGlobalAttr("pub_allbiz", sb.toString());
                        m9359a(true);
                    }
                }
                ((IExpectationView) this.mView).setSceneVisibility(this.f13629g.getSceneType());
                if (this.f13629g.getSceneType() == 2 && this.f13613B != 2) {
                    ((IExpectationView) this.mView).addProgressNode(this.f13629g.getProgressStateList());
                    ((IExpectationView) this.mView).setObtainedCouponViewVisibility(this.f13629g.getWaitedTime(), this.f13629g.getTotalWaitTime());
                    if (this.f13616I == 0 && !CarOrderHelper.isAssignOrder() && this.f13617J) {
                        m9391l();
                    }
                }
                this.f13613B = this.f13629g.getSceneType();
                if (this.f13629g.usePrivilege != null && !this.f13621N) {
                    m9355a(this.f13629g.usePrivilege);
                }
            }
            ExpectationManagementModel expectationManagementModel = Preconditions.nonNull(this.f13629g) ? this.f13629g.getExpectationManagementModel() : null;
            if (Preconditions.nonNull(expectationManagementModel)) {
                processDuseInfo(expectationManagementModel);
            }
            if (CarOrderHelper.getOrderStatus() == 7 && CarOrderHelper.getOrderSubStatus() == 7005) {
                m9371c();
            } else if (CarOrderHelper.getOrderStatus() == 7 && this.f13622O) {
                m9375d();
            }
            ExpectationData expectationData2 = this.f13629g;
            if (!(expectationData2 == null || expectationData2.flex_raise == null)) {
                ((IExpectationView) this.mView).updateFlex(this.f13629g.flex_raise);
                HashMap hashMap = new HashMap();
                hashMap.put("k", "show");
                hashMap.put(RavenKey.VERSION, "raisefare");
                if (!(this.f13629g.flex_raise.raise_sheet == null || this.f13629g.flex_raise.raise_sheet.config == null)) {
                    hashMap.put("price", this.f13629g.flex_raise.raise_sheet.config.current_price);
                }
                GlobalOmegaUtils.trackEvent("ibt_gp_wait_raisefare_sw", (Map<String, Object>) hashMap);
            }
        }
        this.f13624Q = true;
        iXpCardBindDataReadyCallback.ready(true);
    }

    /* renamed from: l */
    private void m9391l() {
        if (this.f13629g != null) {
            if (CarOrderHelper.isAssignOrder()) {
                this.f13640s = true;
            }
            m9371c();
        }
    }

    public void onCardAdd() {
        this.f13644w.subscribe();
        this.f13617J = true;
        m9391l();
    }

    public void onCardRemove() {
        this.f13644w.unSubscribe();
        m9366b();
        ((IExpectationView) this.mView).cancelAnim();
        ((IExpectationView) this.mView).cancelCircleAnim();
        ((IExpectationView) this.mView).setTranslationX(0.0f);
        ((IExpectationView) this.mView).resetViewStatus();
        this.f13615H = true;
        this.f13617J = false;
        this.f13613B = 0;
        this.f13629g = null;
        this.f13621N = false;
        this.f13620M = 0;
        CountDownTimer countDownTimer = this.f13618K;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f13618K = null;
        }
        this.f13626T.removeMessages(1);
        FlexRaiseDialogView flexRaiseDialogView = this.f13625R;
        if (flexRaiseDialogView != null) {
            flexRaiseDialogView.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m9373c(MatchingState matchingState) {
        if (!TextUtil.isEmpty(matchingState.getCaption())) {
            String replace = matchingState.getCaption().replace("\\n", "\n").replace("%@", FormatUtils.formatTime(this.f13634l));
            ((IExpectationView) this.mView).setTime(FormatUtils.formatTime(this.f13634l));
            ((IExpectationView) this.mView).setCaptionText(replace);
            ((IExpectationView) this.mView).setTipsBackground((Drawable) null);
        }
    }

    public void compRefresh(int i, String str, int i2, IXpCompRefresh.IXpCompRefreshCb iXpCompRefreshCb) {
        if (TextUtils.equals("passenger_newXpanel+bargainingCard_logic+bargaining_card", str)) {
            IExpectationView iExpectationView = (IExpectationView) this.mView;
            if (!Preconditions.isNull(Preconditions.nonNull(iExpectationView) ? iExpectationView.getView() : null)) {
                if (i == 1) {
                    iExpectationView.updateViewByIndriver(true, true, this.f13627a, iXpCompRefreshCb);
                } else if (i == 2) {
                    iExpectationView.updateViewByIndriver(false, true, this.f13627a, iXpCompRefreshCb);
                }
            }
        }
    }

    public void compIds(final List<String> list, int i, final IXpCompRefresh.IXpCompRefreshCb iXpCompRefreshCb) {
        SystemUtils.log(6, "dxt", "mode ==== " + list, (Throwable) null, "com.didi.component.expectation.impl.ExpectationPresenter", 1096);
        if (CollectionUtils.contains(list, ComponentType.RIDE_EXPECTATION)) {
            ((IExpectationView) this.mView).getView().postDelayed(new Runnable() {
                public void run() {
                    if (list.contains("passenger_newXpanel+bargainingCard_logic+bargaining_card")) {
                        ((IExpectationView) ExpectationPresenter.this.mView).updateViewByIndriver(true, false, 100, iXpCompRefreshCb);
                    } else {
                        ((IExpectationView) ExpectationPresenter.this.mView).updateViewByIndriver(false, false, 200, iXpCompRefreshCb);
                    }
                }
            }, this.f13627a);
        }
    }

    /* renamed from: m */
    private Context m9393m() {
        return Preconditions.nonNull(this.mContext) ? this.mContext : DIDIApplication.getAppContext();
    }

    /* renamed from: a */
    private void m9359a(boolean z) {
        TripListener tripListener = PageCompDataTransfer.getInstance().getTripListener();
        if (z || (tripListener != null && tripListener.getIsAnyCar())) {
            HashMap hashMap = new HashMap();
            hashMap.put("is_anycar", 1);
            PubSIDManager.getInstance().setPubSID(hashMap);
            return;
        }
        PubSIDManager.getInstance().removePubSID("is_anycar", 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m9376d(MatchingState matchingState) {
        GlobalRichInfo subtitleRich = matchingState.getSubtitleRich();
        if (subtitleRich != null && !TextUtil.isEmpty(subtitleRich.getContent())) {
            GlobalRichInfo globalRichInfo = new GlobalRichInfo();
            globalRichInfo.setContent(subtitleRich.getContent());
            globalRichInfo.setInfoList(subtitleRich.getInfoList());
            String content = globalRichInfo.getContent();
            if (content.contains("[!!") && content.contains("!!]")) {
                String substring = content.substring(content.indexOf("[!!"), content.indexOf("!!]") + 3);
                String valueOf = String.valueOf(this.f13646y);
                String replace = content.replace(substring, valueOf);
                globalRichInfo.setContent(replace);
                List<GlobalRichInfo.RichInfo> infoList = globalRichInfo.getInfoList();
                if (infoList != null && infoList.size() > 0) {
                    int indexOf = replace.indexOf(valueOf);
                    int length = valueOf.length();
                    GlobalRichInfo.RichInfo richInfo = infoList.get(0);
                    richInfo.start = indexOf;
                    richInfo.length = length;
                    infoList.set(0, richInfo);
                    globalRichInfo.setInfoList(infoList);
                }
            }
            ((IExpectationView) this.mView).setRichSubtitle(globalRichInfo);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public int m9395n() {
        ExpectationData expectationData = this.f13629g;
        if (expectationData != null) {
            return expectationData.getSceneType();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public int m9397o() {
        ExpectationData expectationData = this.f13629g;
        if (expectationData != null) {
            return expectationData.getWaitedTime();
        }
        return 0;
    }

    /* renamed from: a */
    private void m9355a(UsePrivilege usePrivilege) {
        if (CollectionUtils.isNotEmpty((Collection<?>) usePrivilege.mMatchingState)) {
            ((IExpectationView) this.mView).showEquityUI(usePrivilege);
            this.f13621N = true;
            m9357a(usePrivilege.mMatchingState);
            return;
        }
        this.f13628c.info("processEquityInfo>>usePrivilege.mMatchingState is mull", new Object[0]);
    }

    /* renamed from: a */
    private void m9357a(List<UsePrivilegeMatchingState> list) {
        String str;
        int size = list.size();
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            if (list.get(i) != null) {
                if (list.get(i).mTimeInterval == -1) {
                    str = list.get(i).mText;
                    break;
                }
                i2 += list.get(i).mTimeInterval;
                arrayList.add(Integer.valueOf(i2));
                arrayList2.add(list.get(i).mText);
            } else {
                this.f13628c.info("usePrivilegeMatchingState is null", new Object[0]);
            }
            i++;
        }
        final String str2 = str;
        if (i2 <= 0 || arrayList2.size() <= 0) {
            ((IExpectationView) this.mView).setEquityText(str2);
            return;
        }
        ((IExpectationView) this.mView).setEquityText((String) arrayList2.get(0));
        this.f13618K = new CountDownTimer((long) (i2 * 1000), 1000) {
            public void onTick(long j) {
                ExpectationPresenter.this.m9358a((List<Integer>) arrayList, (List<String>) arrayList2);
            }

            public void onFinish() {
                int unused = ExpectationPresenter.this.f13619L = 0;
                if (!TextUtils.isEmpty(str2)) {
                    ((IExpectationView) ExpectationPresenter.this.mView).setEquityText(str2);
                }
            }
        }.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9358a(List<Integer> list, List<String> list2) {
        try {
            if (this.f13619L > list.get(this.f13620M).intValue()) {
                this.f13620M++;
                ((IExpectationView) this.mView).setEquityText(list2.get(this.f13620M));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f13619L++;
    }

    /* renamed from: p */
    private void m9400p() {
        this.f13626T.sendEmptyMessageDelayed(1, 30000);
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m9402q() {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamConst.PARAM_WAIT_TIME, String.valueOf((TimeServiceManager.getInstance().getNTPCurrenTimeMillis() - CarOrderHelper.getOrderCreateTime()) / 1000));
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            hashMap.put("oid", order.oid);
        }
        GlobalOmegaUtils.trackEvent("tech_pax_event_call_wait_time", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        ((IExpectationView) this.mView).startCircleAnim();
        super.onPageResume();
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        ((IExpectationView) this.mView).cancelCircleAnim();
        super.onPagePause();
    }
}
