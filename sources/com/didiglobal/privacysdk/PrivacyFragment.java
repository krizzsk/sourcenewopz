package com.didiglobal.privacysdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.loading.app.AbsLoadingFragment;
import com.didi.one.netdetect.http.ResponseListener;
import com.didi.sdk.util.ToastHelper;
import com.didiglobal.privacysdk.GlobalPrivacyListeners;
import com.didiglobal.privacysdk.view.GlobalDialog;
import com.didiglobal.privacysdk.view.GlobalPrivacyTitleBar;
import com.didiglobal.privacysdk.view.SettingsSwitchView;
import com.didiglobal.privacysdk.view.TextComponentView;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrivacyFragment extends AbsLoadingFragment {

    /* renamed from: a */
    private static final String f50612a = "101_0001";

    /* renamed from: b */
    private static final String f50613b = "101_0002";

    /* renamed from: c */
    private static final String f50614c = "101_0003";

    /* renamed from: d */
    private static final String f50615d = "101_0011";
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f50616A = false;

    /* renamed from: B */
    private GlobalPrivacyTitleBar f50617B;

    /* renamed from: C */
    private GlobalDialog.IButtonAction[] f50618C = {new GlobalDialog.IButtonAction() {
        public String getName() {
            return PrivacyFragment.this.getString(R.string.Global_Driver_LGPD_Translation_Requirements_Confirmation_ZhBT);
        }

        public Runnable getAction() {
            return new Runnable() {
                public void run() {
                    PrivacyFragment.this.m36354a(PrivacyFragment.this.f50638w, false, (ResponseListener<JsonObject>) new SetSwitchResponseListener(PrivacyFragment.this.f50639x));
                    if (PrivacyFragment.this.f50638w == PrivacyFragment.f50615d) {
                        GlobalOmegaUtils.sendSharedPositionConfirmCloseCk();
                    } else {
                        GlobalOmegaUtils.sendDiscountSwitchConfirmCloseCk(PrivacyFragment.this.f50638w);
                    }
                    PrivacyFragment.this.m36350a();
                }
            };
        }

        public GlobalDialog.IButtonAction.ButtonType getType() {
            return GlobalDialog.IButtonAction.ButtonType.POSITIVE;
        }
    }, new GlobalDialog.IButtonAction() {
        public String getName() {
            return PrivacyFragment.this.getString(R.string.Global_Driver_LGPD_Translation_Requirements_Cancelled_DtEy);
        }

        public Runnable getAction() {
            return new Runnable() {
                public void run() {
                    if (PrivacyFragment.this.f50639x != null) {
                        PrivacyFragment.this.f50639x.setChecked(true);
                    }
                    PrivacyFragment.this.m36350a();
                }
            };
        }

        public GlobalDialog.IButtonAction.ButtonType getType() {
            return GlobalDialog.IButtonAction.ButtonType.NEGATIVE;
        }
    }};

    /* renamed from: D */
    private ResponseListener<Map<String, Boolean>> f50619D = new ResponseListener<Map<String, Boolean>>() {
        public void onSuccess(Map<String, Boolean> map) {
            PrivacyFragment.this.hideLoading();
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                boolean booleanValue = ((Boolean) next.getValue()).booleanValue();
                if (PrivacyFragment.f50614c.equals(str)) {
                    PrivacyFragment.this.f50633r.setChecked(booleanValue);
                    GlobalOmegaUtils.sendDiscountSwitchStatusSw(PrivacyFragment.f50614c, booleanValue);
                } else if (PrivacyFragment.f50612a.equals(str)) {
                    PrivacyFragment.this.f50632q.setChecked(booleanValue);
                    GlobalOmegaUtils.sendDiscountSwitchStatusSw(PrivacyFragment.f50612a, booleanValue);
                } else if (PrivacyFragment.f50613b.equals(str)) {
                    PrivacyFragment.this.f50631p.setChecked(booleanValue);
                    GlobalOmegaUtils.sendDiscountSwitchStatusSw(PrivacyFragment.f50613b, booleanValue);
                } else if (PrivacyFragment.f50615d.equals(str)) {
                    PrivacyFragment.this.f50634s.setChecked(booleanValue);
                    GlobalOmegaUtils.sendSharedPositionSwitchStatusSw(booleanValue);
                }
            }
        }

        public void onFail(Throwable th) {
            PrivacyFragment.this.hideLoading();
        }
    };

    /* renamed from: e */
    private FrameLayout f50620e = null;

    /* renamed from: f */
    private boolean f50621f = false;

    /* renamed from: g */
    private boolean f50622g = false;

    /* renamed from: h */
    private boolean f50623h = false;

    /* renamed from: i */
    private boolean f50624i = false;

    /* renamed from: j */
    private boolean f50625j = false;

    /* renamed from: k */
    private boolean f50626k = false;

    /* renamed from: l */
    private boolean f50627l = false;

    /* renamed from: m */
    private TextComponentView f50628m;

    /* renamed from: n */
    private ViewGroup f50629n;

    /* renamed from: o */
    private SettingsSwitchView f50630o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public SettingsSwitchView f50631p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public SettingsSwitchView f50632q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public SettingsSwitchView f50633r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public SettingsSwitchView f50634s;

    /* renamed from: t */
    private TextComponentView f50635t;

    /* renamed from: u */
    private TextComponentView f50636u;

    /* renamed from: v */
    private List<String> f50637v = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: w */
    public String f50638w = "";
    /* access modifiers changed from: private */

    /* renamed from: x */
    public SettingsSwitchView f50639x = null;

    /* renamed from: y */
    private int f50640y;

    /* renamed from: z */
    private GlobalDialog f50641z;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.global_privacy_fragment_privacy, (ViewGroup) null);
        this.f50616A = false;
        this.f50641z = new GlobalDialog();
        this.f50620e = (FrameLayout) inflate.findViewById(R.id.progressbar_layout);
        GlobalPrivacyTitleBar globalPrivacyTitleBar = (GlobalPrivacyTitleBar) inflate.findViewById(R.id.title_bar);
        this.f50617B = globalPrivacyTitleBar;
        globalPrivacyTitleBar.setOnLeftImgClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                PrivacyFragment.this.getActivity().onBackPressed();
            }
        });
        GlobalPrivacyThemeOptions globalPrivacyThemeOptions = GlobalPrivacySDK.getGlobalPrivacyThemeOptions();
        if (globalPrivacyThemeOptions != null) {
            this.f50617B.setBackgroundColor(globalPrivacyThemeOptions.getTitleBarBgColor());
            this.f50617B.setTitleColor(globalPrivacyThemeOptions.getTitleBarTitleColor());
            if (globalPrivacyThemeOptions.isUseTitleBarSmallLeftImg()) {
                this.f50617B.setLeftSmallImgRes(globalPrivacyThemeOptions.getTitleBarSmallLeftImgRes());
            } else {
                this.f50617B.setLeftImgRes(globalPrivacyThemeOptions.getTitleBarLeftImgRes());
            }
            if (globalPrivacyThemeOptions.isTitleInCenter()) {
                this.f50617B.setMidTitle(R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Privacy_ToTQ);
            } else {
                this.f50617B.setLeftTitle(R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Privacy_ToTQ);
            }
            this.f50640y = globalPrivacyThemeOptions.getSwitchColor();
        }
        GlobalPrivacyListeners.ItemDisplayListener itemDisplayListener = GlobalPrivacySDK.getItemDisplayListener();
        this.f50621f = itemDisplayListener.displaySms();
        this.f50622g = itemDisplayListener.displayDiscountPush();
        this.f50623h = itemDisplayListener.displayDiscountEmail();
        this.f50624i = itemDisplayListener.displayLocationShare();
        this.f50625j = itemDisplayListener.displayDownloadData();
        this.f50626k = itemDisplayListener.displaySystemPermission();
        this.f50627l = itemDisplayListener.displayDeleteAccount();
        TextComponentView textComponentView = (TextComponentView) inflate.findViewById(R.id.item_download_data);
        this.f50628m = textComponentView;
        if (this.f50625j) {
            textComponentView.setVisibility(0);
            this.f50628m.setName((int) R.string.Global_Driver_LGPD_Translation_Requirements_Download_personal_EEJQ);
            this.f50628m.setOnItemClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GlobalPrivacyListeners.WebViewListener webViewListener = GlobalPrivacySDK.getWebViewListener();
                    if (webViewListener != null) {
                        String downloadDataUrl = GlobalPrivacySDK.getDownloadDataUrl();
                        if (TextUtils.isEmpty(downloadDataUrl)) {
                            downloadDataUrl = "https://page.didiglobal.com/passenger-page/download/index.html";
                        }
                        webViewListener.jumpWebViewPage(PrivacyFragment.this.getContext(), downloadDataUrl);
                        GlobalOmegaUtils.sendDataDownloadEntranceCK();
                    }
                }
            });
        } else {
            textComponentView.setVisibility(8);
        }
        TextComponentView textComponentView2 = (TextComponentView) inflate.findViewById(R.id.item_system_permission);
        this.f50635t = textComponentView2;
        if (this.f50626k) {
            textComponentView2.setVisibility(0);
            this.f50635t.setName(getString(R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Permissions_systems_KEWu));
            this.f50635t.setDescText((CharSequence) getString(R.string.GDriver_update_Permissions_scenes_DiXo));
            this.f50635t.setOnItemClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    FragmentActivity activity = PrivacyFragment.this.getActivity();
                    if (activity != null && (activity instanceof PrivacyActivity)) {
                        ((PrivacyActivity) activity).jumpPermissionFragment();
                        GlobalOmegaUtils.sendSystemPermissionEntranceCK();
                    }
                }
            });
        } else {
            textComponentView2.setVisibility(8);
        }
        TextComponentView textComponentView3 = (TextComponentView) inflate.findViewById(R.id.item_delete_account);
        this.f50636u = textComponentView3;
        if (this.f50627l) {
            textComponentView3.setVisibility(0);
            this.f50636u.setName(getString(R.string.commonapi_sidebar_menu_25));
            this.f50636u.setOnItemClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (GlobalPrivacySDK.getOnItemClickedListener() != null) {
                        GlobalPrivacySDK.getOnItemClickedListener().onDeleteAccountItemClicked(PrivacyFragment.this.getActivity());
                    }
                }
            });
        } else {
            textComponentView3.setVisibility(8);
        }
        this.f50629n = (ViewGroup) inflate.findViewById(R.id.discount_items_container);
        this.f50630o = (SettingsSwitchView) inflate.findViewById(R.id.item_discount);
        this.f50631p = (SettingsSwitchView) inflate.findViewById(R.id.sms_switch);
        this.f50632q = (SettingsSwitchView) inflate.findViewById(R.id.push_switch);
        this.f50633r = (SettingsSwitchView) inflate.findViewById(R.id.email_switch);
        SettingsSwitchView settingsSwitchView = (SettingsSwitchView) inflate.findViewById(R.id.location_share_switch);
        this.f50634s = settingsSwitchView;
        settingsSwitchView.setDescText(getString(R.string.Global_Driver_LGPD_Translation_Requirements_Location_sharing_boFB));
        if (this.f50621f || this.f50622g || this.f50623h) {
            this.f50629n.setVisibility(0);
        } else {
            this.f50629n.setVisibility(8);
        }
        this.f50637v.clear();
        this.f50630o.setTitle(getString(GlobalPrivacySDK.getAppInfo().getIPrivacyStrings().getDiscountTitleRes()));
        int discountDescRes = GlobalPrivacySDK.getAppInfo().getIPrivacyStrings().getDiscountDescRes();
        this.f50630o.setSwitchVisibility(8);
        this.f50630o.setDividerVisibility(4);
        if (discountDescRes != 0) {
            this.f50630o.setDescText(getString(discountDescRes));
        }
        if (this.f50621f) {
            this.f50631p.setVisibility(0);
            this.f50631p.setTitle(getString(R.string.Global_Driver_LGPD_Translation_Requirements_SMS_nElm));
            this.f50631p.setSwitchColor(this.f50640y);
            this.f50631p.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    if (PrivacyFragment.this.f50616A) {
                        if (compoundButton.isChecked()) {
                            PrivacyFragment privacyFragment = PrivacyFragment.this;
                            privacyFragment.m36354a(PrivacyFragment.f50613b, true, (ResponseListener<JsonObject>) new SetSwitchResponseListener(privacyFragment.f50631p));
                            return;
                        }
                        PrivacyFragment privacyFragment2 = PrivacyFragment.this;
                        privacyFragment2.m36353a(PrivacyFragment.f50613b, privacyFragment2.f50631p);
                    }
                }
            });
            this.f50637v.add(f50613b);
        } else {
            this.f50631p.setVisibility(8);
        }
        if (this.f50622g) {
            this.f50632q.setVisibility(0);
            this.f50632q.setTitle(getString(R.string.Global_Driver_LGPD_Translation_Requirements_Notification_cWbM));
            this.f50632q.setSwitchColor(this.f50640y);
            this.f50632q.setDividerVisibility(4);
            this.f50632q.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    if (PrivacyFragment.this.f50616A) {
                        if (compoundButton.isChecked()) {
                            PrivacyFragment privacyFragment = PrivacyFragment.this;
                            privacyFragment.m36354a(PrivacyFragment.f50612a, true, (ResponseListener<JsonObject>) new SetSwitchResponseListener(privacyFragment.f50632q));
                            return;
                        }
                        PrivacyFragment privacyFragment2 = PrivacyFragment.this;
                        privacyFragment2.m36353a(PrivacyFragment.f50612a, privacyFragment2.f50632q);
                    }
                }
            });
            this.f50637v.add(f50612a);
        } else {
            this.f50632q.setVisibility(8);
        }
        if (this.f50623h) {
            this.f50633r.setVisibility(0);
            this.f50633r.setTitle(getString(R.string.Global_Driver_LGPD_Translation_Requirements_Mail_QXpk));
            this.f50633r.setSwitchColor(this.f50640y);
            this.f50633r.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    if (PrivacyFragment.this.f50616A) {
                        if (compoundButton.isChecked()) {
                            PrivacyFragment privacyFragment = PrivacyFragment.this;
                            privacyFragment.m36354a(PrivacyFragment.f50614c, true, (ResponseListener<JsonObject>) new SetSwitchResponseListener(privacyFragment.f50633r));
                            return;
                        }
                        PrivacyFragment privacyFragment2 = PrivacyFragment.this;
                        privacyFragment2.m36353a(PrivacyFragment.f50614c, privacyFragment2.f50633r);
                    }
                }
            });
            this.f50637v.add(f50614c);
        } else {
            this.f50633r.setVisibility(8);
        }
        if (this.f50624i) {
            this.f50634s.setTitle(getString(R.string.Global_Driver_LGPD_Translation_Requirements_Share_location_hkgv));
            this.f50634s.setDividerVisibility(4);
            this.f50634s.setSwitchColor(this.f50640y);
            this.f50634s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    if (PrivacyFragment.this.f50616A) {
                        if (compoundButton.isChecked()) {
                            PrivacyFragment privacyFragment = PrivacyFragment.this;
                            privacyFragment.m36354a(PrivacyFragment.f50615d, true, (ResponseListener<JsonObject>) new SetSwitchResponseListener(privacyFragment.f50634s));
                            return;
                        }
                        PrivacyFragment privacyFragment2 = PrivacyFragment.this;
                        privacyFragment2.m36353a(PrivacyFragment.f50615d, privacyFragment2.f50634s);
                    }
                }
            });
            this.f50637v.add(f50615d);
        } else {
            this.f50634s.setVisibility(8);
        }
        List<String> list = this.f50637v;
        if (list != null && list.size() > 0) {
            showLoading();
            FeatureManager.getFeatureList(getContext(), this.f50619D, this.f50637v);
        }
        return inflate;
    }

    public void onStart() {
        super.onStart();
        this.f50616A = true;
    }

    public View getFallbackView() {
        return this.f50620e;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36353a(String str, SettingsSwitchView settingsSwitchView) {
        Class<PrivacyFragment> cls = PrivacyFragment.class;
        if (this.f50641z.isPendingDismiss() || !this.f50641z.isVisible()) {
            if (str == f50615d) {
                this.f50641z.build().title(getString(R.string.Global_Driver_LGPD_Translation_Requirements_Close_location_iyDl)).content(getString(R.string.GDriver_update_Close_real_QoXo)).actions(this.f50618C).show(getFragmentManager(), cls.getName());
            } else {
                this.f50641z.build().title(getString(GlobalPrivacySDK.getAppInfo().getIPrivacyStrings().getDiscountDialogTitleRes())).content(getString(GlobalPrivacySDK.getAppInfo().getIPrivacyStrings().getDiscountDialogDescRes())).actions(this.f50618C).show(getFragmentManager(), cls.getName());
            }
            this.f50638w = str;
            this.f50639x = settingsSwitchView;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36350a() {
        if (this.f50641z.isVisible()) {
            this.f50641z.dismiss();
        }
        this.f50638w = "";
        this.f50639x = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36354a(String str, boolean z, ResponseListener<JsonObject> responseListener) {
        showLoading();
        FeatureManager.setFeature(getContext(), str, z, responseListener);
    }

    private class SetSwitchResponseListener implements ResponseListener<JsonObject> {
        SettingsSwitchView switchView;

        SetSwitchResponseListener(SettingsSwitchView settingsSwitchView) {
            this.switchView = settingsSwitchView;
        }

        public void onSuccess(JsonObject jsonObject) {
            PrivacyFragment.this.hideLoading();
        }

        public void onFail(Throwable th) {
            PrivacyFragment.this.hideLoading();
            SettingsSwitchView settingsSwitchView = this.switchView;
            if (settingsSwitchView != null) {
                settingsSwitchView.setChecked(!settingsSwitchView.isChecked());
            }
            Context context = PrivacyFragment.this.getContext();
            if (context != null) {
                ToastHelper.showShortCompleted(context, (int) R.string.no_net);
            }
        }
    }
}
