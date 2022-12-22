package com.didi.sdk.sidebar.component;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.view.SettingsSwitchItemView;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.GlobalApolloUtils;
import com.didi.sdk.util.GlobalOmegaUtils;
import com.didi.sdk.util.LockScreenUtilKt;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;

@ComponentType(name = "menu_setting_lock_screen_switch")
public class LockScreenSwitchItemComponent extends AbsComponent<SettingsSwitchItemView> {
    public static final String APP_NAME = "{{app_name}}";

    /* renamed from: a */
    private SettingsSwitchItemView f37209a;
    public LEGODrawer mDrawer;

    public LockScreenSwitchItemComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
    }

    /* access modifiers changed from: protected */
    public void initData(SettingsSwitchItemView settingsSwitchItemView) {
        String str;
        String str2;
        if (getComponentView() != null && ((SettingsSwitchItemView) getComponentView()).getView() != null) {
            if (!GlobalApolloUtils.isShowLockScreen()) {
                ((SettingsSwitchItemView) getComponentView()).getView().setVisibility(8);
                return;
            }
            ((SettingsSwitchItemView) getComponentView()).getView().setVisibility(0);
            SettingsSwitchItemView settingsSwitchItemView2 = this.f37209a;
            if (!TextUtils.isEmpty(this.sidebarItem.getName())) {
                str = this.sidebarItem.getName();
            } else {
                str = this.businessContext.getContext().getString(R.string.global_settings_lock_screen_item_title);
            }
            settingsSwitchItemView2.setName(str);
            SettingsSwitchItemView settingsSwitchItemView3 = this.f37209a;
            if (!TextUtils.isEmpty(this.sidebarItem.getDes())) {
                str2 = this.sidebarItem.getDes();
            } else {
                str2 = this.businessContext.getContext().getString(R.string.global_settings_lock_screen_item_info);
            }
            settingsSwitchItemView3.setSubtitle(str2);
            this.f37209a.setSwitchBtn(LockScreenUtilKt.hasLockScreenMap(this.businessContext.getContext()));
            this.f37209a.setSwitchVisible(true);
            this.f37209a.setCheckable(true);
            this.f37209a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    if (!z || LockScreenUtilKt.hasOverlayPermission(LockScreenSwitchItemComponent.this.businessContext.getContext())) {
                        LockScreenSwitchItemComponent.this.m26388a(z);
                    } else {
                        LockScreenSwitchItemComponent.this.m26385a();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26385a() {
        String str;
        String string = this.businessContext.getContext().getString(R.string.global_settings_lock_screen_bottom_drawer_title);
        if (AppUtils.isBrazilApp(this.businessContext.getContext())) {
            str = this.businessContext.getContext().getString(R.string.app_name_99);
        } else {
            str = this.businessContext.getContext().getString(R.string.app_name_global);
        }
        LEGODrawerModel1 lEGODrawerModel1 = new LEGODrawerModel1(string.replace(APP_NAME, str), new LEGOBtnTextAndCallback(this.businessContext.getContext().getString(R.string.global_settings_lock_screen_bottom_drawer_ok), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (LockScreenSwitchItemComponent.this.mDrawer != null && LockScreenSwitchItemComponent.this.businessContext != null && LockScreenSwitchItemComponent.this.businessContext.getContext() != null) {
                    LockScreenSwitchItemComponent.this.mDrawer.dismiss();
                    LockScreenUtilKt.requestAppSetting((Activity) LockScreenSwitchItemComponent.this.businessContext.getContext());
                    GlobalOmegaUtils.sendSettingLockScreenClickIntroduction(true);
                    LockScreenSwitchItemComponent.this.m26388a(true);
                }
            }
        }));
        lEGODrawerModel1.addMinorBtn(new LEGOBtnTextAndCallback(this.businessContext.getContext().getString(R.string.global_settings_lock_screen_bottom_drawer_cancel), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (LockScreenSwitchItemComponent.this.mDrawer != null && LockScreenSwitchItemComponent.this.businessContext != null && LockScreenSwitchItemComponent.this.businessContext.getContext() != null) {
                    LockScreenSwitchItemComponent.this.mDrawer.dismiss();
                    GlobalOmegaUtils.sendSettingLockScreenClickIntroduction(false);
                    LockScreenSwitchItemComponent.this.m26388a(true);
                }
            }
        }));
        lEGODrawerModel1.setClickOutsideCanCancel(false);
        this.mDrawer = LEGOUICreator.showDrawerTemplate(this.businessContext.getContext(), lEGODrawerModel1);
        GlobalOmegaUtils.sendSettingLockScreenIntroduction();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26388a(boolean z) {
        ToastHelper.showLongInfo(this.businessContext.getContext(), this.businessContext.getContext().getString(z ? R.string.global_settings_lock_screen_switch_on : R.string.global_settings_lock_screen_switch_off), (int) R.drawable.lock_toast_icon_success);
        LockScreenUtilKt.setLockScreenMap(this.businessContext.getContext(), z);
        GlobalOmegaUtils.sendSettingLockScreenSwitchCheck(z, 0);
    }

    /* access modifiers changed from: protected */
    public SettingsSwitchItemView createComponentView() {
        if (this.f37209a == null) {
            this.f37209a = new SettingsSwitchItemView(this.businessContext.getContext());
        }
        return this.f37209a;
    }
}
