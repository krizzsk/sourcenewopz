package com.didi.component.payway.anycar.view;

import android.app.Activity;
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
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmGetListener;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.common.view.DotLoadingView;
import com.didi.component.common.view.GlobalTipsContainer;
import com.didi.component.common.widget.CouponView;
import com.didi.component.common.widget.NewBubbleHelper;
import com.didi.component.core.ComponentParams;
import com.didi.component.payway.anycar.callback.NewPopShowResultListener;
import com.didi.component.payway.anycar.presenter.AbsPayWayPresenter;
import com.didi.component.payway.anycar.presenter.AnyCarPayWayPresenter;
import com.didi.component.payway.widget.CurrentPaymentsView;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globaluikit.popup.LEGOBubble;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.Utils;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarPayModel;
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

public class AnycarPayWayView implements View.OnClickListener, IAnycarPayWayView {

    /* renamed from: a */
    Map<String, Object> f15146a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Activity f15147b;

    /* renamed from: c */
    private View f15148c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AnyCarPayWayPresenter f15149d;

    /* renamed from: e */
    private CurrentPaymentsView f15150e;

    /* renamed from: f */
    private ViewGroup f15151f;

    /* renamed from: g */
    private ViewGroup f15152g;

    /* renamed from: h */
    private DotLoadingView f15153h;

    /* renamed from: i */
    private LinearLayout f15154i;

    /* renamed from: j */
    private TextView f15155j;

    /* renamed from: k */
    private ImageView f15156k;

    /* renamed from: l */
    private ViewGroup f15157l;

    /* renamed from: m */
    private GlobalTipsContainer f15158m;

    /* renamed from: n */
    private Runnable f15159n;

    /* renamed from: o */
    private BusinessContext f15160o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public LEGOBubble f15161p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public NewBubbleHelper f15162q;

    /* renamed from: r */
    private View f15163r;

    /* renamed from: s */
    private CouponView f15164s;

    /* renamed from: t */
    private int f15165t;

    /* renamed from: u */
    private AnyCarPayModel f15166u;

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.global_payway_layout_new_ui;
    }

    public AnycarPayWayView(ComponentParams componentParams, ViewGroup viewGroup) {
        this.f15160o = componentParams.bizCtx;
        Activity activity = componentParams.getActivity();
        this.f15147b = activity;
        View inflate = LayoutInflater.from(activity).inflate(getLayoutId(), viewGroup, true);
        this.f15148c = inflate;
        inflate.setOnClickListener(this);
        this.f15154i = (LinearLayout) this.f15148c.findViewById(R.id.pay_way_default_lv);
        this.f15155j = (TextView) this.f15148c.findViewById(R.id.pay_way_default_tv);
        this.f15156k = (ImageView) this.f15148c.findViewById(R.id.pay_way_default_iv);
        this.f15150e = (CurrentPaymentsView) this.f15148c.findViewById(R.id.pay_way_select);
        this.f15151f = (ViewGroup) this.f15148c.findViewById(R.id.content_container);
        this.f15153h = (DotLoadingView) this.f15148c.findViewById(R.id.pay_way_loading);
        this.f15157l = (ViewGroup) this.f15148c.findViewById(R.id.pay_way_layout);
        this.f15152g = (ViewGroup) this.f15148c.findViewById(R.id.loading_container);
        this.f15153h.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f15163r = this.f15148c.findViewById(R.id.v_show_new_pay_way);
        this.f15164s = (CouponView) this.f15148c.findViewById(R.id.payway_coupon_layout);
    }

    public void setLabel(List<PayWayModel.PayWayItem> list, String str) {
        if (list != null && list.size() > 0 && this.f15154i.getVisibility() == 0) {
            this.f15154i.setVisibility(8);
        }
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f15154i.setVisibility(0);
        }
        this.f15150e.updateLabel(m10842a(list), str);
        AnyCarPayModel anyCarPayModel = this.f15166u;
        if (anyCarPayModel == null || anyCarPayModel.mPayAssistorModule == null) {
            this.f15164s.setVisibility(8);
            this.f15165t = 0;
        } else {
            try {
                GGKData gGKData = new GGKData();
                gGKData.parse(new JSONObject(anyCarPayModel.mPayAssistorModule.toString()));
                if (gGKData.getData() != null) {
                    JSONObject data = gGKData.getData();
                    this.f15164s.setVisibility(0);
                    this.f15164s.bindData((CouponView.CouponModel) new Gson().fromJson(data.toString(), CouponView.CouponModel.class));
                    this.f15165t = 1;
                } else {
                    this.f15164s.setVisibility(8);
                    this.f15165t = 0;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        this.f15146a.put(GlobalPayOmegaConstant.EventKey.TAB, "orderconfirm_page");
        this.f15146a.put("style", Integer.valueOf(this.f15165t));
        this.f15146a.put("ischange", 0);
        this.f15146a.put("paytype", FormStore.getInstance().getPayWay());
        this.f15146a.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
        GlobalOmegaUtils.trackEvent("ibt_gp_payment_sw", this.f15146a);
        this.f15146a.clear();
        notifyUpdate();
    }

    /* renamed from: a */
    private List<PayWayModel.PayWayItem> m10842a(List<PayWayModel.PayWayItem> list) {
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
        this.f15148c.setClickable(z);
        this.f15154i.setEnabled(z);
        changeEnableColor(z);
    }

    public void changeEnableColor(boolean z) {
        if (z) {
            m10844a(this.f15147b.getResources().getColor(R.color.g_color_666666));
            this.f15155j.setTextColor(this.f15147b.getResources().getColor(R.color.pay_way_default_tv_color));
            this.f15156k.setVisibility(0);
            return;
        }
        m10844a(this.f15147b.getResources().getColor(R.color.g_color_D9D9D9));
        this.f15155j.setTextColor(this.f15147b.getResources().getColor(R.color.g_color_D9D9D9));
        this.f15156k.setVisibility(8);
    }

    public void setContentDescription(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f15147b.getString(R.string.pay_way_title);
        }
        this.f15148c.setContentDescription(str);
    }

    public boolean isClickable() {
        return this.f15148c.isClickable();
    }

    /* renamed from: a */
    private void m10844a(int i) {
        CurrentPaymentsView currentPaymentsView = this.f15150e;
        if (currentPaymentsView != null && currentPaymentsView.getChildCount() > 0) {
            for (int i2 = 0; i2 < this.f15150e.getChildCount(); i2++) {
                View childAt = this.f15150e.getChildAt(i2);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextColor(i);
                }
            }
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!Utils.isFastDoubleClick()) {
            LEGOBubble lEGOBubble = this.f15161p;
            if (lEGOBubble != null && lEGOBubble.isShowing()) {
                this.f15162q.saveBubbleShowCount(this.f15147b);
            }
            m10843a();
            this.f15149d.onFormPayWayClicked();
            HashMap hashMap = new HashMap();
            List<PayWayModel.PayWayItem> list = this.f15149d.mSelectedPaywayItem;
            if (list != null && list.size() > 0) {
                PayWayModel.PayWayItem payWayItem = list.get(0);
                if (payWayItem != null) {
                    hashMap.put("payment", Integer.valueOf(payWayItem.tag));
                }
                String str = null;
                ConfirmGetListener confirmGetListener = PageCompDataTransfer.getInstance().getConfirmGetListener();
                if (confirmGetListener != null) {
                    str = confirmGetListener.getTraceId();
                }
                if (str != null) {
                    hashMap.put("estimate_trace_id", str);
                }
            }
            SceneHelper.getInstance().setFromPayMethod(true);
            GlobalOmegaUtils.trackEvent("pas_orderconfirm_payment_ck", (Map<String, Object>) hashMap);
            this.f15146a.put(GlobalPayOmegaConstant.EventKey.TAB, "orderconfirm_page");
            this.f15146a.put("style", Integer.valueOf(this.f15165t));
            this.f15146a.put("ischange", 0);
            this.f15146a.put("paytype", FormStore.getInstance().getPayWay());
            hashMap.put(ParamConst.PARAM_PUB_BIZ_LINE, Const.PubBizLine.FIN);
            GlobalOmegaUtils.trackEvent("ibt_gp_payment_ck", this.f15146a);
        }
    }

    public View getView() {
        return this.f15148c;
    }

    public void setPresenter(AbsPayWayPresenter absPayWayPresenter) {
        this.f15149d = (AnyCarPayWayPresenter) absPayWayPresenter;
    }

    public void showNewPopup(final BubbleItemModel bubbleItemModel, NewPopShowResultListener newPopShowResultListener) {
        LEGOBubble lEGOBubble = this.f15161p;
        final boolean z = false;
        if (lEGOBubble != null && lEGOBubble.isShowing()) {
            this.f15161p.dismiss();
            m10847a(false);
        }
        if (bubbleItemModel.actionEvent == null) {
            z = true;
        }
        NewBubbleHelper newBubbleHelper = new NewBubbleHelper(this.f15147b, bubbleItemModel);
        this.f15162q = newBubbleHelper;
        LEGOBubble.Builder builder = newBubbleHelper.getmBuilder();
        builder.setContentViewOnClick(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AnycarPayWayView.this.f15162q.saveBubbleShowCount(AnycarPayWayView.this.f15147b);
                AnycarPayWayView.this.m10843a();
                AnycarPayWayView.this.f15162q.trackEvent(false);
                AnycarPayWayView.this.m10847a(false);
                if (z) {
                    AnycarPayWayView.this.f15161p.dismiss();
                } else if (AnycarPayWayView.this.f15149d != null) {
                    AnycarPayWayView.this.f15149d.onNewPayWayGuideClicked(bubbleItemModel);
                }
            }
        });
        this.f15161p = builder.build();
        builder.setMaxLines(2);
        if (this.f15161p.isShowing()) {
            return;
        }
        if (z) {
            View view = this.f15148c;
            if (view != null && view.getRootView().isAttachedToWindow()) {
                m10846a(this.f15161p, newPopShowResultListener);
                return;
            }
            return;
        }
        m10846a(this.f15161p, newPopShowResultListener);
    }

    /* renamed from: a */
    private void m10846a(LEGOBubble lEGOBubble, NewPopShowResultListener newPopShowResultListener) {
        newPopShowResultListener.success(this.f15162q);
        m10847a(true);
        View view = this.f15148c;
        lEGOBubble.show(view, 0, (-view.getMeasuredHeight()) - ResourcesHelper.getDimensionPixelSize(this.f15147b, R.dimen.pay_method_bubble_yoff), 1999);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10847a(boolean z) {
        if (z) {
            showRedDot(this.f15162q.isShowRedMark(this.f15147b));
        } else {
            showRedDot(false);
        }
    }

    /* renamed from: a */
    private float m10839a(View view) {
        if (view != null) {
            return ((float) view.getLeft()) + m10840a(view.getParent());
        }
        return 0.0f;
    }

    /* renamed from: a */
    private float m10840a(ViewParent viewParent) {
        if (viewParent == null || !(viewParent instanceof ViewGroup)) {
            return 0.0f;
        }
        return ((float) ((ViewGroup) viewParent).getLeft()) + m10840a(viewParent.getParent());
    }

    public void dismissPopup() {
        LEGOBubble lEGOBubble = this.f15161p;
        if (lEGOBubble != null && lEGOBubble.isShowing()) {
            this.f15161p.dismiss();
            m10847a(false);
        }
    }

    public void hideLoading() {
        DotLoadingView dotLoadingView = this.f15153h;
        if (dotLoadingView != null && this.f15152g != null && this.f15151f != null) {
            dotLoadingView.stopLoading();
            this.f15152g.setVisibility(8);
            this.f15153h.setVisibility(8);
            this.f15151f.setVisibility(0);
        }
    }

    public String getContent() {
        String string = this.f15147b.getString(R.string.pay_way_title);
        CurrentPaymentsView currentPaymentsView = this.f15150e;
        return (currentPaymentsView == null || TextUtils.isEmpty(currentPaymentsView.getContent())) ? string : this.f15150e.getContent();
    }

    public List<String> getIcon() {
        CurrentPaymentsView currentPaymentsView = this.f15150e;
        if (currentPaymentsView != null) {
            return currentPaymentsView.getIcon();
        }
        return null;
    }

    public void notifyUpdate() {
        AnyCarPayWayPresenter anyCarPayWayPresenter = this.f15149d;
        if (anyCarPayWayPresenter != null) {
            anyCarPayWayPresenter.notifyUpdate();
        }
    }

    public void show() {
        ViewGroup viewGroup = this.f15157l;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public void hide() {
        ViewGroup viewGroup = this.f15157l;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public void showRedDot(boolean z) {
        if (z) {
            this.f15163r.setVisibility(0);
        } else {
            this.f15163r.setVisibility(8);
        }
    }

    public void setData(AnyCarPayModel anyCarPayModel) {
        this.f15166u = anyCarPayModel;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10843a() {
        View view = this.f15163r;
        if (view != null && view.getVisibility() == 0) {
            this.f15162q.saveRedMarkShowCount(this.f15147b);
        }
    }
}
