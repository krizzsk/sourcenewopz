package com.didi.component.service.activity;

import android.content.Context;
import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.webview.BaseWebActivity;
import org.json.JSONObject;

public class DashCamAgreementWebActivity extends GlobalWebActivity {

    /* renamed from: a */
    private Context f15655a;

    /* renamed from: b */
    private BaseEventPublisher.OnEventListener<JSONObject> f15656b = new BaseEventPublisher.OnEventListener<JSONObject>() {
        public void onEvent(String str, JSONObject jSONObject) {
            if (jSONObject != null) {
                DashCamAgreementWebActivity.this.m11425a(jSONObject);
            }
        }
    };

    /* renamed from: c */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15657c = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            DashCamAgreementWebActivity.this.finish();
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        m11426b();
        this.f15655a = this;
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Service.OnService.EVENT_GET_DASH_CAM_AGREEMENT, this.f15656b);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Service.OnService.EVENT_DISAGREE_DASH_CAM, this.f15657c);
    }

    /* renamed from: b */
    private void m11426b() {
        if (getWebView() != null) {
            getWebView().getSettings().setCacheMode(2);
            getWebView().getSettings().setAppCacheEnabled(false);
        }
    }

    public void onBackPressed() {
        m11427c();
    }

    /* access modifiers changed from: protected */
    public void finishWithResultCodeOK() {
        m11427c();
    }

    public void onActivityFinish() {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        reSetWebViewClient((BaseWebActivity.DiDiWebViewClient) null);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Service.OnService.EVENT_GET_DASH_CAM_AGREEMENT, this.f15656b);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Service.OnService.EVENT_DISAGREE_DASH_CAM, this.f15657c);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11425a(JSONObject jSONObject) {
        if (jSONObject.optInt("isAgree") == 1) {
            m11427c();
        } else {
            finish();
        }
    }

    /* renamed from: c */
    private void m11427c() {
        if (CarOrderHelper.isOrderStatusNeedDashCamClosed()) {
            finish();
        } else {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.OnService.EVENT_START_CANCEL_TRIP, true);
        }
    }
}
