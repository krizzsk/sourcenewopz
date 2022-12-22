package com.didi.component.service.cancelreason;

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
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.service.cancelreason.bff.CancelReasonBff;
import com.didi.component.service.cancelreason.cache.CancelReasonStore;
import com.didi.component.service.cancelreason.model.CRListModel;
import com.didi.component.service.cancelreason.model.CancelReasonListResponse;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.global.loading.app.AbsLoadingActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.app.constant.Const;
import com.didi.travel.psnger.model.response.CancelReasonInfo;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CancelReasonActivity extends AbsLoadingActivity {

    /* renamed from: a */
    private int f15729a = GlobalApolloUtil.howLongCanRecreateOrderAfterCancelled();

    /* renamed from: b */
    private ImageView f15730b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RecyclerView f15731c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CancelReasonInfo.CancelReasonOperation f15732d;

    /* renamed from: e */
    private FrameLayout f15733e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ISubmitReason f15734f = new ISubmitReason() {
        public void submit(CRListModel cRListModel) {
            if (CarOrderHelper.getOrder() != null) {
                CancelReasonBff.cancelReasonSubmit(CancelReasonActivity.this.getApplicationContext(), CarOrderHelper.getOrder().oid, cRListModel.f15762id);
            }
            CancelReasonActivity.this.m11486a(cRListModel);
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11486a(CRListModel cRListModel) {
        if (this.f15729a <= 0 || cRListModel.show_alert != 1) {
            finish();
        } else {
            m11488b(cRListModel);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_cancel_reason);
        initViews();
        m11484a();
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
    }

    public void initViews() {
        this.f15730b = (ImageView) findViewById(R.id.cr_left_btn);
        this.f15731c = (RecyclerView) findViewById(R.id.rv_cancel_reason);
        this.f15733e = (FrameLayout) findViewById(R.id.fallback_view_layout);
        this.f15731c.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f15730b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CRListModel cRListModel = new CRListModel();
                cRListModel.reason_type = 2;
                cRListModel.f15762id = "";
                cRListModel.show_alert = 1;
                HashMap hashMap = new HashMap();
                hashMap.put(Const.CampaignKey.KEY_CLICK_TIME, Long.valueOf(System.currentTimeMillis()));
                hashMap.put("u_id", Long.valueOf(NationComponentDataUtil.getUid()));
                if (CarOrderHelper.getOrder() != null) {
                    hashMap.put("o_id", CarOrderHelper.getOrder().oid);
                }
                OmegaSDKAdapter.trackEvent("gp_cancelreason_close_ck", (Map<String, Object>) hashMap);
                CancelReasonActivity.this.m11486a(cRListModel);
            }
        });
    }

    /* renamed from: a */
    private void m11484a() {
        final CancelReasonStore instance = CancelReasonStore.getInstance();
        CancelReasonInfo currCancelReasonInfo = instance.getCurrCancelReasonInfo();
        if (currCancelReasonInfo != null) {
            this.f15732d = currCancelReasonInfo.operations;
            CancelReasonAdapter cancelReasonAdapter = new CancelReasonAdapter(currCancelReasonInfo);
            cancelReasonAdapter.setSubmitReason(this.f15734f);
            this.f15731c.setAdapter(cancelReasonAdapter);
            return;
        }
        showMaskLayerLoading();
        CancelReasonBff.cancelReasonListGet(this, CarOrderHelper.getOrder() == null ? "0" : CarOrderHelper.getOrder().oid, new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                CancelReasonActivity.this.hideLoading();
                try {
                    CancelReasonListResponse cancelReasonListResponse = (CancelReasonListResponse) new Gson().fromJson((JsonElement) jsonObject, CancelReasonListResponse.class);
                    if (cancelReasonListResponse != null && cancelReasonListResponse.data != null && cancelReasonListResponse.data.cancel_reason_info != null) {
                        CancelReasonAdapter cancelReasonAdapter = new CancelReasonAdapter(cancelReasonListResponse.data.cancel_reason_info);
                        cancelReasonAdapter.setSubmitReason(CancelReasonActivity.this.f15734f);
                        CancelReasonActivity.this.f15731c.setAdapter(cancelReasonAdapter);
                        instance.saveCurrCancelReasonInfo(cancelReasonListResponse.data.cancel_reason_info);
                        CancelReasonInfo.CancelReasonOperation unused = CancelReasonActivity.this.f15732d = cancelReasonListResponse.data.cancel_reason_info.operations;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onFailure(IOException iOException) {
                CancelReasonActivity.this.hideLoading();
            }
        });
    }

    /* renamed from: b */
    private void m11488b(CRListModel cRListModel) {
        CancelReasonInfo.CancelReasonOperation cancelReasonOperation = cRListModel.operations;
        if (cancelReasonOperation == null) {
            cancelReasonOperation = this.f15732d;
        }
        RecreateAfterCancelDialog instance = RecreateAfterCancelDialog.getInstance(cancelReasonOperation, cRListModel);
        OmegaSDKAdapter.trackEvent("gp_cancelreason_panel_sw");
        instance.show(getSupportFragmentManager(), "");
    }

    public View getFallbackView() {
        return this.f15733e;
    }
}
