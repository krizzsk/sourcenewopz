package com.didi.component.servicecontrol.nopay.impl.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.loading.LoadingWrapper;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.servicecontrol.nopay.AbsServiceControlNopayPresenter;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.LoadingRenderType;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.CashUnPayInterceptInfo;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class ServiceControlNopayView extends LoadingWrapper implements IServiceControlNopayView, ILoadingHolder {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AbsServiceControlNopayPresenter f15849a;

    /* renamed from: b */
    private ViewGroup f15850b;

    /* renamed from: c */
    private TextView f15851c = ((TextView) this.f15850b.findViewById(R.id.title));

    /* renamed from: d */
    private TextView f15852d = ((TextView) this.f15850b.findViewById(R.id.cartype));

    /* renamed from: e */
    private TextView f15853e = ((TextView) this.f15850b.findViewById(R.id.price));

    /* renamed from: f */
    private TextView f15854f = ((TextView) this.f15850b.findViewById(R.id.start_address));

    /* renamed from: g */
    private TextView f15855g = ((TextView) this.f15850b.findViewById(R.id.end_address));

    /* renamed from: h */
    private TextView f15856h = ((TextView) this.f15850b.findViewById(R.id.time));

    /* renamed from: i */
    private TextView f15857i;

    /* renamed from: j */
    private TextView f15858j = ((TextView) this.f15850b.findViewById(R.id.bind_card_next_button));

    /* renamed from: k */
    private TextView f15859k = ((TextView) this.f15850b.findViewById(R.id.paid_button));

    /* renamed from: l */
    private TextView f15860l = ((TextView) this.f15850b.findViewById(R.id.content));

    /* renamed from: m */
    private FrameLayout f15861m = ((FrameLayout) this.f15850b.findViewById(R.id.global_service_control_no_pay_loading));

    /* renamed from: n */
    private ImageView f15862n = ((ImageView) this.f15850b.findViewById(R.id.iv_dialog_close));

    /* renamed from: o */
    private TextView f15863o = ((TextView) this.f15850b.findViewById(R.id.pay_question_link));

    /* renamed from: p */
    private LinearLayout f15864p = ((LinearLayout) this.f15850b.findViewById(R.id.btn_layout));

    /* renamed from: a */
    private int m11571a() {
        return R.layout.global_service_control_no_pay_layout_new;
    }

    public void close() {
    }

    public ServiceControlNopayView(Activity activity, ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(activity).inflate(m11571a(), viewGroup, false);
        this.f15850b = viewGroup2;
        this.f15857i = (TextView) viewGroup2.findViewById(R.id.pay_now_button);
        setLoadingShowOn(this);
        m11573b();
    }

    /* renamed from: b */
    private void m11573b() {
        this.f15857i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (ServiceControlNopayView.this.f15849a != null) {
                    ServiceControlNopayView.this.f15849a.payNow();
                }
            }
        });
        this.f15858j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (ServiceControlNopayView.this.f15849a != null) {
                    ServiceControlNopayView.this.f15849a.bindCardNextTime();
                }
            }
        });
        this.f15859k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (ServiceControlNopayView.this.f15849a != null) {
                    ServiceControlNopayView.this.f15849a.havePaid();
                }
            }
        });
        this.f15862n.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (ServiceControlNopayView.this.f15849a != null) {
                    ServiceControlNopayView.this.f15849a.close();
                }
            }
        });
    }

    public void setPresenter(AbsServiceControlNopayPresenter absServiceControlNopayPresenter) {
        this.f15849a = absServiceControlNopayPresenter;
    }

    public View getView() {
        return this.f15850b;
    }

    public void showNoPayView(final CashUnPayInterceptInfo cashUnPayInterceptInfo) {
        if (cashUnPayInterceptInfo != null) {
            this.f15851c.setText(cashUnPayInterceptInfo.title);
            this.f15860l.setText(cashUnPayInterceptInfo.content);
            this.f15852d.setText(cashUnPayInterceptInfo.productName);
            this.f15853e.setText(cashUnPayInterceptInfo.feeDisplay);
            this.f15854f.setText(cashUnPayInterceptInfo.startAddress);
            this.f15855g.setText(cashUnPayInterceptInfo.endAddress);
            this.f15856h.setText(cashUnPayInterceptInfo.endTime);
            if (cashUnPayInterceptInfo.payNow != null) {
                this.f15857i.setText(cashUnPayInterceptInfo.payNow.name);
                HashMap hashMap = new HashMap();
                hashMap.put("type", cashUnPayInterceptInfo.payNow.action);
                Map<String, Object> extraLog = cashUnPayInterceptInfo.getExtraLog();
                if (!CollectionUtils.isEmpty((Map) extraLog)) {
                    hashMap.putAll(extraLog);
                }
                GlobalOmegaUtils.trackEvent("ibt_gp_payback_card_btn_sw", (Map<String, Object>) hashMap);
            }
            if (cashUnPayInterceptInfo.nextBindCard != null) {
                this.f15858j.setText(cashUnPayInterceptInfo.nextBindCard.name);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("type", cashUnPayInterceptInfo.nextBindCard.action);
                Map<String, Object> extraLog2 = cashUnPayInterceptInfo.getExtraLog();
                if (!CollectionUtils.isEmpty((Map) extraLog2)) {
                    hashMap2.putAll(extraLog2);
                }
                GlobalOmegaUtils.trackEvent("ibt_gp_payback_card_btn_sw", (Map<String, Object>) hashMap2);
            } else {
                this.f15858j.setVisibility(8);
            }
            if (cashUnPayInterceptInfo.havePaid != null) {
                this.f15859k.setText(cashUnPayInterceptInfo.havePaid.name);
                HashMap hashMap3 = new HashMap();
                hashMap3.put("type", cashUnPayInterceptInfo.havePaid.action);
                Map<String, Object> extraLog3 = cashUnPayInterceptInfo.getExtraLog();
                if (!CollectionUtils.isEmpty((Map) extraLog3)) {
                    hashMap3.putAll(extraLog3);
                }
                GlobalOmegaUtils.trackEvent("ibt_gp_payback_card_btn_sw", (Map<String, Object>) hashMap3);
            } else {
                this.f15859k.setVisibility(8);
            }
            if (cashUnPayInterceptInfo.mFeedback == null || TextUtils.isEmpty(cashUnPayInterceptInfo.mFeedback.name) || TextUtils.isEmpty(cashUnPayInterceptInfo.mFeedback.url)) {
                this.f15863o.setVisibility(8);
            } else {
                final String str = cashUnPayInterceptInfo.mFeedback.url;
                this.f15863o.setVisibility(0);
                this.f15863o.setText(cashUnPayInterceptInfo.mFeedback.name);
                HashMap hashMap4 = new HashMap();
                hashMap4.put("type", "LINK");
                Map<String, Object> extraLog4 = cashUnPayInterceptInfo.getExtraLog();
                if (!CollectionUtils.isEmpty((Map) extraLog4)) {
                    hashMap4.putAll(extraLog4);
                }
                GlobalOmegaUtils.trackEvent("ibt_gp_payback_card_btn_sw", (Map<String, Object>) hashMap4);
                this.f15863o.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        HashMap hashMap = new HashMap();
                        hashMap.put("type", "LINK");
                        Map<String, Object> extraLog = cashUnPayInterceptInfo.getExtraLog();
                        if (!CollectionUtils.isEmpty((Map) extraLog)) {
                            hashMap.putAll(extraLog);
                        }
                        GlobalOmegaUtils.trackEvent("ibt_gp_payback_card_btn_ck", (Map<String, Object>) hashMap);
                        DRouter.build(str).start();
                    }
                });
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f15864p.getLayoutParams();
                layoutParams.topMargin = UiUtils.dip2px(this.f15850b.getContext(), 30.0f);
                this.f15864p.setLayoutParams(layoutParams);
            }
            HashMap hashMap5 = new HashMap();
            if (!TextUtils.isEmpty(cashUnPayInterceptInfo.mEntry)) {
                hashMap5.put(ParamKeys.PARAM_COMPLAIN_ENTRY, cashUnPayInterceptInfo.mEntry);
                Map<String, Object> extraLog5 = cashUnPayInterceptInfo.getExtraLog();
                if (!CollectionUtils.isEmpty((Map) extraLog5)) {
                    hashMap5.putAll(extraLog5);
                }
                GlobalOmegaUtils.trackEvent("ibt_gp_payback_card_sw", (Map<String, Object>) hashMap5);
            }
        }
    }

    public void showLoading() {
        super.showLoading();
    }

    public void hideLoading() {
        super.hideLoading();
    }

    public View getFallbackView() {
        return this.f15861m;
    }

    public LoadingConfig getLoadingConfig() {
        return LoadingConfig.create().setRenderType(LoadingRenderType.ANIMATION).build();
    }
}
