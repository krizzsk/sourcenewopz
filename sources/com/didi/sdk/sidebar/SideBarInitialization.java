package com.didi.sdk.sidebar;

import com.didi.sdk.sidebar.account.SettingsFragment;
import com.didi.sdk.sidebar.component.AccountSettingComponent;
import com.didi.sdk.sidebar.component.CheckUpdateComponent;
import com.didi.sdk.sidebar.component.ComponentFactory;
import com.didi.sdk.sidebar.component.CurpComponent;
import com.didi.sdk.sidebar.component.DeviceManageComponent;
import com.didi.sdk.sidebar.component.DiscountSwitchComponent;
import com.didi.sdk.sidebar.component.EditAvatarComponent;
import com.didi.sdk.sidebar.component.EditFirstNameComponent;
import com.didi.sdk.sidebar.component.EditLastNameComponent;
import com.didi.sdk.sidebar.component.GradeComponent;
import com.didi.sdk.sidebar.component.HideNumberComponent;
import com.didi.sdk.sidebar.component.JapanNav2UserInfoComponent;
import com.didi.sdk.sidebar.component.LinkedAccounts;
import com.didi.sdk.sidebar.component.LocationServicesComponent;
import com.didi.sdk.sidebar.component.LockScreenSwitchItemComponent;
import com.didi.sdk.sidebar.component.LogoutEntranceComponent;
import com.didi.sdk.sidebar.component.MexicoNav2UserInfoComponent;
import com.didi.sdk.sidebar.component.ModifyPhoneNumComponent;
import com.didi.sdk.sidebar.component.NavigationWithArrowComponent;
import com.didi.sdk.sidebar.component.SidebarItemComponent;
import com.didi.sdk.sidebar.component.SidebarSwitchItemComponent;
import com.didi.sdk.sidebar.component.WalletChangeSwitchItemComponent;
import com.didi.sdk.sidebar.templet.AutoLinker;

public class SideBarInitialization {

    /* renamed from: a */
    private static boolean f37178a = false;

    public static void init() {
        if (!f37178a) {
            m26354a();
        }
    }

    /* renamed from: a */
    private static void m26354a() {
        ComponentFactory.addComponentClass(LogoutEntranceComponent.class);
        ComponentFactory.addComponentClass(NavigationWithArrowComponent.class);
        ComponentFactory.addComponentClass(SidebarItemComponent.class);
        ComponentFactory.addComponentClass(EditAvatarComponent.class);
        ComponentFactory.addComponentClass(EditFirstNameComponent.class);
        ComponentFactory.addComponentClass(EditLastNameComponent.class);
        ComponentFactory.addComponentClass(MexicoNav2UserInfoComponent.class);
        ComponentFactory.addComponentClass(JapanNav2UserInfoComponent.class);
        ComponentFactory.addComponentClass(ModifyPhoneNumComponent.class);
        ComponentFactory.addComponentClass(CurpComponent.class);
        ComponentFactory.addComponentClass(CheckUpdateComponent.class);
        ComponentFactory.addComponentClass(LinkedAccounts.class);
        ComponentFactory.addComponentClass(AccountSettingComponent.class);
        ComponentFactory.addComponentClass(HideNumberComponent.class);
        ComponentFactory.addComponentClass(LocationServicesComponent.class);
        ComponentFactory.addComponentClass(GradeComponent.class);
        ComponentFactory.addComponentClass(SidebarSwitchItemComponent.class);
        ComponentFactory.addComponentClass(DiscountSwitchComponent.class);
        ComponentFactory.addComponentClass(DeviceManageComponent.class);
        ComponentFactory.addComponentClass(WalletChangeSwitchItemComponent.class);
        ComponentFactory.addComponentClass(LockScreenSwitchItemComponent.class);
        AutoLinker.getLinker().registerFragment("GlobalOneTravel://one/settings", SettingsFragment.class);
        AutoLinker.getLinker().registerFragment("GuaranaOneTravel://one/settings", SettingsFragment.class);
    }
}
