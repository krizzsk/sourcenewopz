package com.didiglobal.privacysdk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.loading.app.AbsLoadingFragment;
import com.didiglobal.privacysdk.GlobalPrivacyListeners;
import com.didiglobal.privacysdk.util.PermissionUtils;
import com.didiglobal.privacysdk.view.GlobalPrivacyTitleBar;
import com.didiglobal.privacysdk.view.TextComponentView;
import com.taxis99.R;

public class PermissionFragment extends AbsLoadingFragment implements View.OnClickListener {

    /* renamed from: a */
    private static final int f50597a = 1713710637;

    /* renamed from: b */
    private static final int f50598b = -45992;

    /* renamed from: c */
    private boolean f50599c = false;

    /* renamed from: d */
    private boolean f50600d = false;

    /* renamed from: e */
    private boolean f50601e = false;

    /* renamed from: f */
    private boolean f50602f = false;

    /* renamed from: g */
    private boolean f50603g = false;

    /* renamed from: h */
    private TextComponentView f50604h;

    /* renamed from: i */
    private TextComponentView f50605i;

    /* renamed from: j */
    private TextComponentView f50606j;

    /* renamed from: k */
    private TextComponentView f50607k;

    /* renamed from: l */
    private TextComponentView f50608l;

    /* renamed from: m */
    private GlobalPrivacyTitleBar f50609m;

    /* renamed from: n */
    private GlobalPrivacyListeners.IAppInfo f50610n;

    /* renamed from: o */
    private GlobalPrivacyListeners.IPrivacyStrings f50611o;

    public View getFallbackView() {
        return null;
    }

    public PermissionFragment() {
        GlobalPrivacyListeners.IAppInfo appInfo = GlobalPrivacySDK.getAppInfo();
        this.f50610n = appInfo;
        this.f50611o = appInfo.getIPrivacyStrings();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.global_privacy_fragment_permission, (ViewGroup) null);
        GlobalPrivacyTitleBar globalPrivacyTitleBar = (GlobalPrivacyTitleBar) inflate.findViewById(R.id.title_bar);
        this.f50609m = globalPrivacyTitleBar;
        globalPrivacyTitleBar.setOnLeftImgClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                PermissionFragment.this.getActivity().onBackPressed();
            }
        });
        GlobalPrivacyThemeOptions globalPrivacyThemeOptions = GlobalPrivacySDK.getGlobalPrivacyThemeOptions();
        if (globalPrivacyThemeOptions != null) {
            this.f50609m.setBackgroundColor(globalPrivacyThemeOptions.getTitleBarBgColor());
            this.f50609m.setTitleColor(globalPrivacyThemeOptions.getTitleBarTitleColor());
            if (globalPrivacyThemeOptions.isUseTitleBarSmallLeftImg()) {
                this.f50609m.setLeftSmallImgRes(globalPrivacyThemeOptions.getTitleBarSmallLeftImgRes());
            } else {
                this.f50609m.setLeftImgRes(globalPrivacyThemeOptions.getTitleBarLeftImgRes());
            }
            if (globalPrivacyThemeOptions.isTitleInCenter()) {
                this.f50609m.setMidTitle(R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Permissions_systems_KEWu);
            } else {
                this.f50609m.setLeftTitle(R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Permissions_systems_KEWu);
            }
        }
        TextComponentView textComponentView = (TextComponentView) inflate.findViewById(R.id.item_permission_location);
        this.f50604h = textComponentView;
        textComponentView.setName(getString(R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Location_uqBG));
        this.f50604h.setOnItemClickListener(this);
        TextComponentView textComponentView2 = (TextComponentView) inflate.findViewById(R.id.item_permission_camera);
        this.f50605i = textComponentView2;
        textComponentView2.setName(getString(R.string.Global_Driver_Privacy_ComplianceFunctionCenter__camera_Vhsj));
        this.f50605i.setOnItemClickListener(this);
        TextComponentView textComponentView3 = (TextComponentView) inflate.findViewById(R.id.item_permission_album);
        this.f50606j = textComponentView3;
        textComponentView3.setName(getString(R.string.GDriver_scene_storage_mobile_ZEvo));
        this.f50606j.setOnItemClickListener(this);
        TextComponentView textComponentView4 = (TextComponentView) inflate.findViewById(R.id.item_permission_contacts);
        this.f50607k = textComponentView4;
        textComponentView4.setName(getString(R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Contacts_extf));
        this.f50607k.setOnItemClickListener(this);
        TextComponentView textComponentView5 = (TextComponentView) inflate.findViewById(R.id.item_permission_microphone);
        this.f50608l = textComponentView5;
        textComponentView5.setName(getString(R.string.Global_Driver_Privacy_ComplianceFunctionCenter__microphone_yeZK));
        this.f50608l.setOnItemClickListener(this);
        return inflate;
    }

    public void onResume() {
        super.onResume();
        m36343a();
    }

    /* renamed from: a */
    private void m36343a() {
        m36344b();
        m36345c();
        m36346d();
    }

    /* renamed from: b */
    private void m36344b() {
        this.f50599c = PermissionUtils.hasLocationPermission(getContext());
        this.f50600d = PermissionUtils.hasCameraPermission(getContext());
        this.f50601e = PermissionUtils.hasAlbumPermission(getContext());
        this.f50602f = PermissionUtils.hasContractsPermission(getContext());
        this.f50603g = PermissionUtils.hasMicrophonePermission(getContext());
        GlobalOmegaUtils.sendPositionAuthorityStatusSw(this.f50599c);
        GlobalOmegaUtils.sendCameraAuthorityStatusSw(this.f50600d);
        GlobalOmegaUtils.sendAlbumAuthorityStatusSw(this.f50601e);
        GlobalOmegaUtils.sendAddressBookAuthorityStatusSw(this.f50602f);
        GlobalOmegaUtils.sendMicrophoneAuthorityStatusSw(this.f50603g);
    }

    /* renamed from: c */
    private void m36345c() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        TextComponentView textComponentView = this.f50604h;
        if (this.f50599c) {
            i = this.f50611o.getLocationPermissionEnableDescRes();
        } else {
            i = this.f50611o.getLocationPermissionDisableDescRes();
        }
        textComponentView.setDescText(i);
        TextComponentView textComponentView2 = this.f50605i;
        if (this.f50600d) {
            i2 = this.f50611o.getCameraPermissionEnableDescRes();
        } else {
            i2 = this.f50611o.getCameraPermissionDisableDescRes();
        }
        textComponentView2.setDescText(i2);
        TextComponentView textComponentView3 = this.f50606j;
        if (this.f50601e) {
            i3 = this.f50611o.getAlbumPermissionEnableDescRes();
        } else {
            i3 = this.f50611o.getAlbumPermissionDisableDescRes();
        }
        textComponentView3.setDescText(i3);
        TextComponentView textComponentView4 = this.f50607k;
        if (this.f50602f) {
            i4 = this.f50611o.getContactsPermissionEnableDescRes();
        } else {
            i4 = this.f50611o.getContactsPermissionDisableDescRes();
        }
        textComponentView4.setDescText(i4);
        TextComponentView textComponentView5 = this.f50608l;
        if (this.f50603g) {
            i5 = this.f50611o.getMicrophonePermissionEnableDescRes();
        } else {
            i5 = this.f50611o.getMicrophonePermissionDisableDescRes();
        }
        textComponentView5.setDescText(i5);
    }

    /* renamed from: d */
    private void m36346d() {
        TextComponentView textComponentView = this.f50604h;
        boolean z = this.f50599c;
        int i = f50597a;
        textComponentView.setDescTextColor(z ? f50597a : f50598b);
        this.f50604h.setRightDesColor(this.f50599c ? f50597a : f50598b);
        TextComponentView textComponentView2 = this.f50604h;
        boolean z2 = this.f50599c;
        int i2 = R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Authorization_RYuU;
        textComponentView2.setRightDes(z2 ? R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Authorization_RYuU : R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Authorization_IBwf);
        this.f50605i.setDescTextColor(this.f50600d ? f50597a : f50598b);
        this.f50605i.setRightDesColor(this.f50600d ? f50597a : f50598b);
        this.f50605i.setRightDes(this.f50600d ? R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Authorization_RYuU : R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Authorization_IBwf);
        this.f50606j.setDescTextColor(this.f50601e ? f50597a : f50598b);
        this.f50606j.setRightDesColor(this.f50601e ? f50597a : f50598b);
        this.f50606j.setRightDes(this.f50601e ? R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Authorization_RYuU : R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Authorization_IBwf);
        this.f50607k.setDescTextColor(this.f50602f ? f50597a : f50598b);
        this.f50607k.setRightDesColor(this.f50602f ? f50597a : f50598b);
        this.f50607k.setRightDes(this.f50602f ? R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Authorization_RYuU : R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Authorization_IBwf);
        this.f50608l.setDescTextColor(this.f50603g ? f50597a : f50598b);
        TextComponentView textComponentView3 = this.f50608l;
        if (!this.f50603g) {
            i = f50598b;
        }
        textComponentView3.setRightDesColor(i);
        TextComponentView textComponentView4 = this.f50608l;
        if (!this.f50603g) {
            i2 = R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Authorization_IBwf;
        }
        textComponentView4.setRightDes(i2);
    }

    /* renamed from: e */
    private void m36347e() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + getContext().getPackageName()));
            intent.addCategory("android.intent.category.DEFAULT");
            startActivity(intent);
        } catch (Exception unused) {
            startActivity(new Intent("android.settings.SETTINGS"));
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        m36347e();
    }
}
