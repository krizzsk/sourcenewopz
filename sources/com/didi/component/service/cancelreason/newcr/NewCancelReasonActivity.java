package com.didi.component.service.cancelreason.newcr;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarHttpHelper;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.service.cancelreason.ISubmitReason;
import com.didi.component.service.cancelreason.cache.CancelReasonStore;
import com.didi.component.service.cancelreason.model.CRListModel;
import com.didi.component.service.view.NewCancelInterceptPopup;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.global.loading.app.AbsLoadingActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.BusinessContextManager;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.monitor.PubSIDManager;
import com.didi.soda.customer.app.constant.Const;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.CancelReasonInfo;
import com.didi.travel.psnger.model.response.CarCancelTrip;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class NewCancelReasonActivity extends AbsLoadingActivity {

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15763a = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED.equals(str)) {
                NewCancelReasonActivity.this.m11501c();
            } else if (BaseEventKeys.Service.CancelOrder.EVENT_HIDE_CANCEL_REASON_LIST.equals(str)) {
                NewCancelReasonActivity.this.m11503d();
            }
        }
    };

    /* renamed from: b */
    private ImageView f15764b;

    /* renamed from: c */
    private RecyclerView f15765c;

    /* renamed from: d */
    private FrameLayout f15766d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ComponentParams f15767e;

    /* renamed from: f */
    private ISubmitReason f15768f = new ISubmitReason() {
        public void submit(CRListModel cRListModel) {
            final String str;
            if (CarOrderHelper.getOrder() != null && !NewCancelReasonActivity.this.isFinishing()) {
                CarOrder order = CarOrderHelper.getOrder();
                NewCancelReasonActivity.this.showLoading();
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("reason_id", cRListModel.f15762id);
                    str = jSONObject.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                    str = "{\"reason_id\":\"101\"}";
                }
                hashMap.put(ParamKeys.PARAM_CANCEL_REASON, str);
                CarRequest.cancelTrip(NewCancelReasonActivity.this, order.oid, 1, 1, "", hashMap, new ResponseListener<CarCancelTrip>() {
                    public void onSuccess(CarCancelTrip carCancelTrip) {
                        super.onSuccess(carCancelTrip);
                        NewCancelReasonActivity.this.hideLoading();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(NewCancelInterceptPopup.KEY_CANCEL_TRIP, carCancelTrip);
                        NewCancelInterceptPopup.show(NewCancelReasonActivity.this.getSupportFragmentManager(), NewCancelInterceptPopup.CancelInterceptScene.on_service, NewCancelReasonActivity.this.f15767e, bundle, str, new NewCancelInterceptPopup.IStateListener() {
                            public void onCancel() {
                                NewCancelReasonActivity.this.finish();
                            }

                            public void onBack() {
                                NewCancelReasonActivity.this.finish();
                            }
                        });
                        NewCancelReasonActivity.this.m11499b();
                    }

                    public void onError(CarCancelTrip carCancelTrip) {
                        super.onError(carCancelTrip);
                        NewCancelReasonActivity.this.hideLoading();
                    }

                    public void onFail(CarCancelTrip carCancelTrip) {
                        super.onFail(carCancelTrip);
                        NewCancelReasonActivity.this.hideLoading();
                        CarHttpHelper.validate(NewCancelReasonActivity.this, carCancelTrip);
                        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.CancelOrder.EVENT_PRE_CANCEL_FAIL, carCancelTrip);
                    }
                });
            }
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_new_cancel_reason);
        initViews();
        m11498a();
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f15763a);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Service.CancelOrder.EVENT_HIDE_CANCEL_REASON_LIST, this.f15763a);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(View.STATUS_BAR_TRANSIENT);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(Color.parseColor(ColorUtils.DIDI_GREY));
        }
        OmegaSDKAdapter.trackEvent("gp_cancelreason_sw");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f15763a);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Service.CancelOrder.EVENT_HIDE_CANCEL_REASON_LIST, this.f15763a);
    }

    public void initViews() {
        this.f15764b = (ImageView) findViewById(R.id.cr_left_btn);
        this.f15765c = (RecyclerView) findViewById(R.id.rv_cancel_reason);
        this.f15766d = (FrameLayout) findViewById(R.id.fallback_view_layout);
        this.f15765c.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f15764b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                HashMap hashMap = new HashMap();
                hashMap.put(Const.CampaignKey.KEY_CLICK_TIME, Long.valueOf(System.currentTimeMillis()));
                hashMap.put("u_id", Long.valueOf(NationComponentDataUtil.getUid()));
                if (CarOrderHelper.getOrder() != null) {
                    hashMap.put("o_id", CarOrderHelper.getOrder().oid);
                }
                OmegaSDKAdapter.trackEvent("gp_cancelreason_close_ck", (Map<String, Object>) hashMap);
                NewCancelReasonActivity.this.finish();
            }
        });
    }

    /* renamed from: a */
    private void m11498a() {
        ComponentParams componentParams = new ComponentParams();
        this.f15767e = componentParams;
        componentParams.bid = ConfProxy.getInstance().getSelectedGroupId();
        this.f15767e.bizCtx = (BusinessContext) BusinessContextManager.getInstance().getCurBusinessContext();
        CancelReasonInfo currCancelReasonInfo = CancelReasonStore.getInstance().getCurrCancelReasonInfo();
        if (currCancelReasonInfo != null) {
            NewCancelReasonAdapter newCancelReasonAdapter = new NewCancelReasonAdapter(currCancelReasonInfo);
            newCancelReasonAdapter.setSubmitReason(this.f15768f);
            this.f15765c.setAdapter(newCancelReasonAdapter);
            return;
        }
        GLog.m7967e("get cancel reason info fail");
        finish();
    }

    public View getFallbackView() {
        return this.f15766d;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11499b() {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.FILE_OOM_KEY, 2);
        PubSIDManager.getInstance().setPubSID(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m11501c() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            if (6 == order.status || 2 == order.status || CarOrderHelper.isOnService()) {
                m11503d();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m11503d() {
        if (!isFinishing()) {
            finish();
        }
    }
}
