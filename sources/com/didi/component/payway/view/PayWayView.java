package com.didi.component.payway.view;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.util.SearchIdUploadManager;
import com.didi.component.common.view.DotLoadingView;
import com.didi.component.common.view.GlobalTipsContainer;
import com.didi.component.common.widget.CouponView;
import com.didi.component.common.widget.NewBubbleHelper;
import com.didi.component.core.ComponentParams;
import com.didi.component.payway.PaywayGuidanceActivity;
import com.didi.component.payway.callback.NewPopShowResultListener;
import com.didi.component.payway.presenter.AbsPayWayPresenter;
import com.didi.component.payway.presenter.PayWayPresenter;
import com.didi.component.payway.widget.CurrentPaymentsView;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.Utils;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel;
import com.google.gson.Gson;
import com.taxis99.R;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class PayWayView implements View.OnClickListener, IPayWayView {

    /* renamed from: a */
    Map f15195a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Activity f15196b;

    /* renamed from: c */
    private View f15197c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public PayWayPresenter f15198d;

    /* renamed from: e */
    private CurrentPaymentsView f15199e;

    /* renamed from: f */
    private ViewGroup f15200f;

    /* renamed from: g */
    private ViewGroup f15201g;

    /* renamed from: h */
    private DotLoadingView f15202h;

    /* renamed from: i */
    private LinearLayout f15203i;

    /* renamed from: j */
    private TextView f15204j;

    /* renamed from: k */
    private ImageView f15205k;

    /* renamed from: l */
    private ViewGroup f15206l;

    /* renamed from: m */
    private GlobalTipsContainer f15207m;

    /* renamed from: n */
    private Runnable f15208n;

    /* renamed from: o */
    private BusinessContext f15209o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public LEGOBubble f15210p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public NewBubbleHelper f15211q;

    /* renamed from: r */
    private View f15212r;

    /* renamed from: s */
    private CouponView f15213s;

    /* renamed from: t */
    private int f15214t;

    /* renamed from: u */
    private boolean f15215u = false;

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.global_payway_layout_new_ui;
    }

    public void showPayWayCouponPopup(int i, int i2, String str, String str2) {
    }

    public PayWayView(ComponentParams componentParams, ViewGroup viewGroup) {
        this.f15209o = componentParams.bizCtx;
        Activity activity = componentParams.getActivity();
        this.f15196b = activity;
        View inflate = LayoutInflater.from(activity).inflate(getLayoutId(), viewGroup, true);
        this.f15197c = inflate;
        inflate.setOnClickListener(this);
        this.f15203i = (LinearLayout) this.f15197c.findViewById(R.id.pay_way_default_lv);
        this.f15204j = (TextView) this.f15197c.findViewById(R.id.pay_way_default_tv);
        this.f15205k = (ImageView) this.f15197c.findViewById(R.id.pay_way_default_iv);
        this.f15199e = (CurrentPaymentsView) this.f15197c.findViewById(R.id.pay_way_select);
        this.f15200f = (ViewGroup) this.f15197c.findViewById(R.id.content_container);
        this.f15202h = (DotLoadingView) this.f15197c.findViewById(R.id.pay_way_loading);
        this.f15206l = (ViewGroup) this.f15197c.findViewById(R.id.pay_way_layout);
        this.f15201g = (ViewGroup) this.f15197c.findViewById(R.id.loading_container);
        this.f15202h.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f15212r = this.f15197c.findViewById(R.id.v_show_new_pay_way);
        this.f15213s = (CouponView) this.f15197c.findViewById(R.id.payway_coupon_layout);
    }

    public void hidePayWayLabel() {
        this.f15197c.setVisibility(8);
    }

    public void showPayWayLabel() {
        this.f15197c.setVisibility(0);
    }

    public void setLabel(List<PayWayModel.PayWayItem> list, String str) {
        if (list != null && list.size() > 0 && this.f15203i.getVisibility() == 0) {
            this.f15203i.setVisibility(8);
        }
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f15203i.setVisibility(0);
        }
        this.f15199e.updateLabel(m10890a(list), str);
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem == null || newEstimateItem.mPayAssistorModule == null) {
            this.f15213s.setVisibility(8);
            this.f15214t = 0;
        } else {
            try {
                GGKData gGKData = new GGKData();
                gGKData.parse(new JSONObject(newEstimateItem.mPayAssistorModule.toString()));
                if (gGKData.getData() != null) {
                    JSONObject data = gGKData.getData();
                    this.f15213s.setVisibility(0);
                    this.f15213s.bindData((CouponView.CouponModel) new Gson().fromJson(data.toString(), CouponView.CouponModel.class));
                    this.f15214t = 1;
                } else {
                    this.f15213s.setVisibility(8);
                    this.f15214t = 0;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (!(newEstimateItem == null || newEstimateItem.carConfig == null || newEstimateItem.carConfig.extraData == null)) {
            newEstimateItem.carConfig.extraData.putAllExtraLog(this.f15195a);
        }
        this.f15195a.put(GlobalPayOmegaConstant.EventKey.TAB, "orderconfirm_page");
        this.f15195a.put("style", Integer.valueOf(this.f15214t));
        this.f15195a.put("ischange", 0);
        this.f15195a.put("paytype", FormStore.getInstance().getPayWay());
        this.f15195a.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f15195a.put("status", "1");
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_payment_sw", (Map<String, Object>) this.f15195a);
        this.f15195a.clear();
        notifyUpdate();
    }

    /* renamed from: a */
    private List<PayWayModel.PayWayItem> m10890a(List<PayWayModel.PayWayItem> list) {
        List<PayWayModel.PayWayItem> arrayList = new ArrayList<>();
        if (!(list == null || list.size() == 0)) {
            int i = 0;
            while (i < list.size()) {
                if (list.get(i).priorityShow == 1) {
                    arrayList.clear();
                    arrayList.add(list.get(i));
                    return arrayList;
                }
                i++;
                arrayList = list;
            }
        }
        return arrayList;
    }

    public void setLabel(List<PayWayModel.PayWayItem> list) {
        setLabel(list, (String) null);
    }

    public void setClickable(boolean z) {
        this.f15197c.setClickable(z);
        this.f15203i.setEnabled(z);
        changeEnableColor(z);
    }

    public void changeEnableColor(boolean z) {
        if (z) {
            m10892a(this.f15196b.getResources().getColor(R.color.g_color_666666));
            this.f15204j.setTextColor(this.f15196b.getResources().getColor(R.color.pay_way_default_tv_color));
            this.f15205k.setVisibility(0);
            return;
        }
        m10892a(this.f15196b.getResources().getColor(R.color.g_color_D9D9D9));
        this.f15204j.setTextColor(this.f15196b.getResources().getColor(R.color.g_color_D9D9D9));
        this.f15205k.setVisibility(8);
    }

    public void setContentDescription(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f15196b.getString(R.string.pay_way_title);
        }
        this.f15197c.setContentDescription(str);
    }

    public boolean isClickable() {
        return this.f15197c.isClickable();
    }

    /* renamed from: a */
    private void m10892a(int i) {
        CurrentPaymentsView currentPaymentsView = this.f15199e;
        if (currentPaymentsView != null && currentPaymentsView.getChildCount() > 0) {
            for (int i2 = 0; i2 < this.f15199e.getChildCount(); i2++) {
                View childAt = this.f15199e.getChildAt(i2);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextColor(i);
                }
            }
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!Utils.isFastDoubleClick()) {
            LEGOBubble lEGOBubble = this.f15210p;
            if (lEGOBubble != null && lEGOBubble.isShowing()) {
                this.f15211q.saveBubbleShowCount(this.f15196b);
            }
            m10891a();
            this.f15198d.onFormPayWayClicked();
            HashMap hashMap = new HashMap();
            List<PayWayModel.PayWayItem> list = this.f15198d.mSelectedPaywayItem;
            if (list != null && list.size() > 0) {
                PayWayModel.PayWayItem payWayItem = list.get(0);
                if (payWayItem != null) {
                    hashMap.put("payment", Integer.valueOf(payWayItem.tag));
                }
                hashMap.put("bubble_id", SearchIdUploadManager.getInstance().getBubbleId());
                String estimateModelTraceId = FormStore.getInstance().getEstimateModelTraceId();
                if (estimateModelTraceId != null) {
                    hashMap.put("estimate_trace_id", estimateModelTraceId);
                }
            }
            SceneHelper.getInstance().setFromPayMethod(true);
            GlobalOmegaUtils.trackEvent("pas_orderconfirm_payment_ck", (Map<String, Object>) hashMap);
            EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
            if (!(newEstimateItem == null || newEstimateItem.carConfig == null || newEstimateItem.carConfig.extraData == null)) {
                newEstimateItem.carConfig.extraData.putAllExtraLog(this.f15195a);
            }
            this.f15195a.put(GlobalPayOmegaConstant.EventKey.TAB, "orderconfirm_page");
            this.f15195a.put("style", Integer.valueOf(this.f15214t));
            this.f15195a.put("ischange", 0);
            this.f15195a.put("paytype", FormStore.getInstance().getPayWay());
            if (CollectionUtil.isEmpty((Collection<?>) list)) {
                this.f15195a.put("status", 1);
            }
            hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
            GlobalOmegaUtils.trackEvent("ibt_gp_payment_ck", (Map<String, Object>) this.f15195a);
        }
    }

    public View getView() {
        return this.f15197c;
    }

    public void setPresenter(AbsPayWayPresenter absPayWayPresenter) {
        this.f15198d = (PayWayPresenter) absPayWayPresenter;
    }

    public void showNewPopup(final BubbleItemModel bubbleItemModel, NewPopShowResultListener newPopShowResultListener) {
        final boolean z = true;
        if (CollectionUtil.isEmpty((Collection<?>) this.f15198d.mSelectedPaywayItem)) {
            if (GlobalSPUtil.isShowPaywayGuide(this.f15196b) && bubbleItemModel.bubbleText != null && !TextUtils.isEmpty(bubbleItemModel.bubbleText.getContent())) {
                Intent intent = new Intent(this.f15196b, PaywayGuidanceActivity.class);
                intent.setFlags(268435456);
                Activity currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity();
                if (!this.f15215u) {
                    this.f15215u = true;
                    currentActivity.startActivity(intent);
                    currentActivity.overridePendingTransition(0, 0);
                    HashMap hashMap = new HashMap();
                    hashMap.put("type", "pay_guide");
                    hashMap.put("status", 1);
                    GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_paymentnewlearn_sw", (Map<String, Object>) hashMap);
                }
            }
        } else if (GlobalSPUtil.isShowPaywayGuide(this.f15196b)) {
            GlobalSPUtil.savePaywayGuideShown(this.f15196b);
            if (bubbleItemModel.actionEvent != null) {
                z = false;
            }
            NewBubbleHelper newBubbleHelper = new NewBubbleHelper(this.f15196b, bubbleItemModel);
            this.f15211q = newBubbleHelper;
            LEGOBubble.Builder builder = newBubbleHelper.getmBuilder();
            builder.setContentViewOnClick(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    PayWayView.this.f15211q.saveBubbleShowCount(PayWayView.this.f15196b);
                    PayWayView.this.m10891a();
                    PayWayView.this.f15211q.trackEvent(false);
                    PayWayView.this.m10895a(false);
                    if (z) {
                        PayWayView.this.f15210p.dismiss();
                    } else if (PayWayView.this.f15198d != null) {
                        PayWayView.this.f15198d.onNewPayWayGuideClicked(bubbleItemModel);
                    }
                }
            });
            this.f15210p = builder.build();
            builder.setMaxLines(2);
            if (this.f15210p.isShowing()) {
                return;
            }
            if (z) {
                View view = this.f15197c;
                if (view != null && view.getRootView().isAttachedToWindow()) {
                    m10894a(this.f15210p, newPopShowResultListener);
                    return;
                }
                return;
            }
            m10894a(this.f15210p, newPopShowResultListener);
        }
    }

    /* renamed from: a */
    private void m10894a(LEGOBubble lEGOBubble, NewPopShowResultListener newPopShowResultListener) {
        newPopShowResultListener.success(this.f15211q);
        m10895a(true);
        View view = this.f15197c;
        lEGOBubble.show(view, 0, (-view.getMeasuredHeight()) - ResourcesHelper.getDimensionPixelSize(this.f15196b, R.dimen.pay_method_bubble_yoff), 1999);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10895a(boolean z) {
        if (z) {
            showRedDot(this.f15211q.isShowRedMark(this.f15196b));
        } else {
            showRedDot(false);
        }
    }

    public void showGuildPopup(String str, boolean z) {
        if (this.f15207m == null) {
            this.f15207m = new GlobalTipsContainer(this.f15196b);
        }
        this.f15207m.showWithLocationBinded(str, this.f15197c, 1, 0, 0, ResourcesHelper.getDimensionPixelSize(this.f15196b, R.dimen.ms_12dp));
    }

    /* renamed from: a */
    private float m10887a(View view) {
        if (view != null) {
            return ((float) view.getLeft()) + m10888a(view.getParent());
        }
        return 0.0f;
    }

    /* renamed from: a */
    private float m10888a(ViewParent viewParent) {
        if (viewParent == null || !(viewParent instanceof ViewGroup)) {
            return 0.0f;
        }
        return ((float) ((ViewGroup) viewParent).getLeft()) + m10888a(viewParent.getParent());
    }

    public void dismissPopup() {
        LEGOBubble lEGOBubble = this.f15210p;
        if (lEGOBubble != null && lEGOBubble.isShowing()) {
            this.f15210p.dismiss();
            m10895a(false);
        }
    }

    public void showLoading() {
        this.f15201g.setVisibility(0);
        this.f15202h.setVisibility(0);
        this.f15202h.startLoading();
        this.f15200f.setVisibility(8);
    }

    public void hideLoading() {
        DotLoadingView dotLoadingView = this.f15202h;
        if (dotLoadingView != null && this.f15201g != null && this.f15200f != null) {
            dotLoadingView.stopLoading();
            this.f15201g.setVisibility(8);
            this.f15202h.setVisibility(8);
            this.f15200f.setVisibility(0);
        }
    }

    public String getContent() {
        String string = this.f15196b.getString(R.string.pay_way_title);
        CurrentPaymentsView currentPaymentsView = this.f15199e;
        return (currentPaymentsView == null || TextUtils.isEmpty(currentPaymentsView.getContent())) ? string : this.f15199e.getContent();
    }

    public List<String> getIcon() {
        CurrentPaymentsView currentPaymentsView = this.f15199e;
        if (currentPaymentsView != null) {
            return currentPaymentsView.getIcon();
        }
        return null;
    }

    public void notifyUpdate() {
        PayWayPresenter payWayPresenter = this.f15198d;
        if (payWayPresenter != null) {
            payWayPresenter.notifyUpdate();
        }
    }

    public void show() {
        ViewGroup viewGroup = this.f15206l;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public void hide() {
        ViewGroup viewGroup = this.f15206l;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public void showRedDot(boolean z) {
        if (z) {
            this.f15212r.setVisibility(0);
        } else {
            this.f15212r.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10891a() {
        View view = this.f15212r;
        if (view != null && view.getVisibility() == 0) {
            this.f15211q.saveRedMarkShowCount(this.f15196b);
        }
    }
}
