package com.didi.sdk.sidebar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.loading.app.AbsLoadingFragment;
import com.didi.one.netdetect.http.ResponseListener;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.app.IComponent;
import com.didi.sdk.app.IStatusBar;
import com.didi.sdk.sidebar.feature.FeatureManager;
import com.didi.sdk.sidebar.view.SettingsSwitchView;
import com.didi.sdk.util.GlobalApolloUtils;
import com.didi.sdk.util.GlobalOmegaUtils;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.view.GlobalDialog;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DiscountFragment extends AbsLoadingFragment implements View.OnClickListener, IComponent<BaseBusinessContext>, IStatusBar {

    /* renamed from: a */
    private static final String f37243a = "101_0001";

    /* renamed from: b */
    private static final String f37244b = "101_0002";

    /* renamed from: c */
    private static final String f37245c = "101_0003";

    /* renamed from: d */
    private BaseBusinessContext f37246d;

    /* renamed from: e */
    private FrameLayout f37247e = null;

    /* renamed from: f */
    private boolean f37248f = true;

    /* renamed from: g */
    private boolean f37249g = true;

    /* renamed from: h */
    private boolean f37250h = true;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public SettingsSwitchView f37251i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public SettingsSwitchView f37252j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public SettingsSwitchView f37253k;

    /* renamed from: l */
    private List<String> f37254l = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f37255m = "";
    /* access modifiers changed from: private */

    /* renamed from: n */
    public SettingsSwitchView f37256n = null;

    /* renamed from: o */
    private GlobalDialog f37257o;

    /* renamed from: p */
    private GlobalDialog.IButtonAction[] f37258p = {new GlobalDialog.IButtonAction() {
        public String getName() {
            return DiscountFragment.this.getString(R.string.global_settings_discount_dialog_ok);
        }

        public Runnable getAction() {
            return new Runnable() {
                public void run() {
                    FeatureManager.setFeature(DiscountFragment.this.f37255m, false, DiscountFragment.this.f37260r);
                    GlobalOmegaUtils.sendClickDiscountDialogOK();
                    DiscountFragment.this.m26455a();
                }
            };
        }

        public GlobalDialog.IButtonAction.ButtonType getType() {
            return GlobalDialog.IButtonAction.ButtonType.POSITIVE;
        }
    }, new GlobalDialog.IButtonAction() {
        public String getName() {
            return DiscountFragment.this.getString(R.string.global_settings_discount_dialog_cancel);
        }

        public Runnable getAction() {
            return new Runnable() {
                public void run() {
                    GlobalOmegaUtils.sendClickDiscountDialogCancel();
                    if (DiscountFragment.this.f37256n != null) {
                        DiscountFragment.this.f37256n.setChecked(true);
                    }
                    DiscountFragment.this.m26455a();
                }
            };
        }

        public GlobalDialog.IButtonAction.ButtonType getType() {
            return GlobalDialog.IButtonAction.ButtonType.NEGATIVE;
        }
    }};

    /* renamed from: q */
    private ResponseListener<Map<String, Boolean>> f37259q = new ResponseListener<Map<String, Boolean>>() {
        public void onSuccess(Map<String, Boolean> map) {
            DiscountFragment.this.hideLoading();
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                if (DiscountFragment.f37245c.equals(str)) {
                    DiscountFragment.this.f37253k.setChecked(((Boolean) next.getValue()).booleanValue());
                } else if (DiscountFragment.f37243a.equals(str)) {
                    DiscountFragment.this.f37252j.setChecked(((Boolean) next.getValue()).booleanValue());
                } else if (DiscountFragment.f37244b.equals(str)) {
                    DiscountFragment.this.f37251i.setChecked(((Boolean) next.getValue()).booleanValue());
                }
            }
        }

        public void onFail(Throwable th) {
            DiscountFragment.this.hideLoading();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ResponseListener<JsonObject> f37260r = new ResponseListener<JsonObject>() {
        public void onSuccess(JsonObject jsonObject) {
        }

        public void onFail(Throwable th) {
            ToastHelper.showShortCompleted(DiscountFragment.this.getContext(), (int) R.string.no_net);
        }
    };

    public boolean showStatusBar() {
        return true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.setting_discount_fragment, (ViewGroup) null);
        this.f37257o = new GlobalDialog();
        CommonTitleBar commonTitleBar = (CommonTitleBar) inflate.findViewById(R.id.title_bar);
        commonTitleBar.setLeftBackListener(this);
        commonTitleBar.setTitle((int) R.string.global_settings_discount_title);
        commonTitleBar.setTitleBarLineVisible(8);
        this.f37247e = (FrameLayout) inflate.findViewById(R.id.progressbar_layout);
        this.f37251i = (SettingsSwitchView) inflate.findViewById(R.id.sms_switch);
        this.f37252j = (SettingsSwitchView) inflate.findViewById(R.id.push_switch);
        this.f37253k = (SettingsSwitchView) inflate.findViewById(R.id.email_switch);
        this.f37248f = GlobalApolloUtils.getDiscountSMSSwitch();
        this.f37249g = GlobalApolloUtils.getDiscountPushSwitch();
        this.f37250h = GlobalApolloUtils.getDiscountEmailSwitch();
        this.f37254l.clear();
        if (this.f37248f) {
            this.f37251i.setVisibility(0);
            this.f37251i.setTitle(getString(R.string.global_settings_discount_switch_sms));
            this.f37251i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    GlobalOmegaUtils.sendClickDiscountSwitchSMS();
                    if (compoundButton.isChecked()) {
                        FeatureManager.setFeature(DiscountFragment.f37244b, true, DiscountFragment.this.f37260r);
                        return;
                    }
                    DiscountFragment discountFragment = DiscountFragment.this;
                    discountFragment.m26457a(DiscountFragment.f37244b, discountFragment.f37251i);
                }
            });
            this.f37254l.add(f37244b);
        }
        if (this.f37249g) {
            this.f37252j.setVisibility(0);
            this.f37252j.setTitle(getString(R.string.global_settings_discount_switch_push));
            this.f37252j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    GlobalOmegaUtils.sendClickDiscountSwitchPush();
                    if (compoundButton.isChecked()) {
                        FeatureManager.setFeature(DiscountFragment.f37243a, true, DiscountFragment.this.f37260r);
                        return;
                    }
                    DiscountFragment discountFragment = DiscountFragment.this;
                    discountFragment.m26457a(DiscountFragment.f37243a, discountFragment.f37252j);
                }
            });
            this.f37254l.add(f37243a);
        }
        if (this.f37250h) {
            this.f37253k.setVisibility(0);
            this.f37253k.setTitle(getString(R.string.global_settings_discount_switch_email));
            this.f37253k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    GlobalOmegaUtils.sendClickDiscountSwitchEmail();
                    if (compoundButton.isChecked()) {
                        FeatureManager.setFeature(DiscountFragment.f37245c, true, DiscountFragment.this.f37260r);
                        return;
                    }
                    DiscountFragment discountFragment = DiscountFragment.this;
                    discountFragment.m26457a(DiscountFragment.f37245c, discountFragment.f37253k);
                }
            });
            this.f37254l.add(f37245c);
        }
        showLoading();
        FeatureManager.getFeatureList(this.f37259q, this.f37254l);
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26457a(String str, SettingsSwitchView settingsSwitchView) {
        if (this.f37257o.isPendingDismiss() || !this.f37257o.isVisible()) {
            this.f37257o.build().title(getString(R.string.global_settings_discount_dialog_title)).content(getString(R.string.global_settings_discount_dialog_content)).actions(this.f37258p).show(getFragmentManager(), DiscountFragment.class.getName());
            this.f37255m = str;
            this.f37256n = settingsSwitchView;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26455a() {
        if (this.f37257o.isVisible()) {
            this.f37257o.dismiss();
        }
        this.f37255m = "";
        this.f37256n = null;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        this.f37246d.getNavigation().popBackStack();
    }

    public BaseBusinessContext getBusinessContext() {
        return this.f37246d;
    }

    public void setBusinessContext(BaseBusinessContext baseBusinessContext) {
        this.f37246d = baseBusinessContext;
    }

    public View getFallbackView() {
        return this.f37247e;
    }
}
