package com.didiglobal.domainprocessor.service;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.view.CompassPopup;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class CustomCompassPopup extends CompassPopup {

    /* renamed from: a */
    private static final String f50034a = "key_compass";

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_domain_select;
    }

    public static CustomCompassPopup getInstance(CompassPopup.IPopupDataHandler iPopupDataHandler) {
        CustomCompassPopup customCompassPopup = new CustomCompassPopup();
        Bundle bundle = new Bundle();
        bundle.putSerializable(f50034a, iPopupDataHandler);
        customCompassPopup.setArguments(bundle);
        return customCompassPopup;
    }

    public void refreshData(CompassPopup.IPopupDataHandler iPopupDataHandler) {
        this.data = iPopupDataHandler;
        m36045a();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        HashMap hashMap = new HashMap();
        hashMap.put("appId", Integer.valueOf(LoginStore.getInstance().getAppId()));
        OmegaSDKAdapter.trackEvent("tone_p_x_roaming_sw", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.compass_title = (TextView) this.mRootView.findViewById(R.id.compass_title);
        this.compass_confirm_btn = (TextView) this.mRootView.findViewById(R.id.compass_confirm_btn);
        this.compass_cancel_btn = (TextView) this.mRootView.findViewById(R.id.compass_cancel_btn);
        setCancelable(false);
        this.compass_confirm_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CustomCompassPopup.this.dismiss();
                if (CustomCompassPopup.this.confirmListener != null) {
                    CustomCompassPopup.this.confirmListener.onClick(view);
                }
            }
        });
        this.compass_cancel_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CustomCompassPopup.this.dismiss();
                if (CustomCompassPopup.this.cancelListener != null) {
                    CustomCompassPopup.this.cancelListener.onClick(view);
                }
            }
        });
        m36045a();
    }

    /* renamed from: a */
    private void m36045a() {
        if (this.data != null) {
            this.compass_title.setText(this.data.getTitle());
            this.compass_confirm_btn.setText(this.data.getPositiveBtnText());
            this.compass_confirm_btn.setEnabled(true);
            this.compass_cancel_btn.setText(this.data.getNegativeBtnText());
        }
    }
}
