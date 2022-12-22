package com.didi.sdk.sidebar.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.events.SettingsLoadingEvent;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.model.WalletChangeSwitchModel;
import com.didi.sdk.sidebar.view.SettingsSwitchItemView;
import com.didi.sdk.util.ToastHelper;
import com.didi.unifiedPay.util.UiThreadHandler;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

@ComponentType(name = "menu_setting_wallet_return_change")
public class WalletChangeSwitchItemComponent extends AbsComponent<SettingsSwitchItemView> {

    /* renamed from: a */
    private SettingsSwitchItemView f37220a;

    /* renamed from: b */
    private WalletChangeSwitchModel f37221b;

    /* renamed from: c */
    private int f37222c;

    /* renamed from: d */
    private Context f37223d;

    public WalletChangeSwitchItemComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
    }

    /* access modifiers changed from: protected */
    public void initData(SettingsSwitchItemView settingsSwitchItemView) {
        Context context = this.businessContext.getContext();
        this.f37223d = context;
        this.f37221b = new WalletChangeSwitchModel(context);
        this.f37220a = settingsSwitchItemView;
        settingsSwitchItemView.setName(this.sidebarItem.getName());
        UiThreadHandler.post(new Runnable() {
            public void run() {
                WalletChangeSwitchItemComponent.this.m26395a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26395a() {
        m26400b();
        final int i = this.f37222c + 1;
        this.f37222c = i;
        this.f37221b.getSwitchStatus(new BffResponseListener<WalletChangeSwitchModel.WalletChangeResponse>() {
            public void onFinish(WalletChangeSwitchModel.WalletChangeResponse walletChangeResponse) {
                WalletChangeSwitchItemComponent.this.m26396a(i, walletChangeResponse);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26396a(int i, WalletChangeSwitchModel.WalletChangeResponse walletChangeResponse) {
        m26403c();
        this.f37220a.setSwitchVisible(true);
        if (i == this.f37222c) {
            if (walletChangeResponse == null || walletChangeResponse.errno != 0) {
                this.f37220a.setSwitchBtn(false);
            } else {
                this.f37220a.setSwitchBtn(TextUtils.equals("1", walletChangeResponse.changeSwitchFlag));
            }
        }
    }

    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public SettingsSwitchItemView createComponentView() {
        return new SettingsSwitchItemView(this.businessContext.getContext());
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.f37220a.isSwitchVisible()) {
            m26399a(!this.f37220a.isChecked());
            if (this.sidebarItem != null) {
                String traceEvent = this.sidebarItem.getTraceEvent();
                if (!TextUtils.isEmpty(traceEvent)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("city_id", NationTypeUtil.getNationComponentData().getCityId());
                    hashMap.put("country_code", NationTypeUtil.getNationComponentData().getLocCountry());
                    OmegaSDKAdapter.trackEvent(traceEvent, (Map<String, Object>) hashMap);
                }
            }
        }
    }

    /* renamed from: a */
    private void m26399a(boolean z) {
        m26400b();
        final int i = this.f37222c + 1;
        this.f37222c = i;
        this.f37221b.setSwitchStatus(z, new BffResponseListener<WalletChangeSwitchModel.WalletChangeResponse>() {
            public void onFinish(WalletChangeSwitchModel.WalletChangeResponse walletChangeResponse) {
                WalletChangeSwitchItemComponent.this.m26401b(i, walletChangeResponse);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m26401b(int i, WalletChangeSwitchModel.WalletChangeResponse walletChangeResponse) {
        m26403c();
        if (i == this.f37222c) {
            if (walletChangeResponse == null) {
                ToastHelper.showLongInfo(this.f37223d, (int) R.string.no_net);
            } else if (walletChangeResponse.errno == 0) {
                boolean equals = TextUtils.equals("1", walletChangeResponse.changeSwitchFlag);
                this.f37220a.setSwitchBtn(equals);
                HashMap hashMap = new HashMap();
                hashMap.put("status", Integer.valueOf(equals ? 1 : 0));
                OmegaSDKAdapter.trackEvent("ibt_online_change_setting_switch_ck", (Map<String, Object>) hashMap);
            } else {
                ToastHelper.showLongInfo(this.f37223d, walletChangeResponse.errmsg);
            }
        }
    }

    /* renamed from: b */
    private void m26400b() {
        SettingsLoadingEvent settingsLoadingEvent = new SettingsLoadingEvent();
        settingsLoadingEvent.visible = true;
        settingsLoadingEvent.withMask = true;
        EventBus.getDefault().post(settingsLoadingEvent);
    }

    /* renamed from: c */
    private void m26403c() {
        SettingsLoadingEvent settingsLoadingEvent = new SettingsLoadingEvent();
        settingsLoadingEvent.visible = false;
        EventBus.getDefault().post(settingsLoadingEvent);
    }
}
