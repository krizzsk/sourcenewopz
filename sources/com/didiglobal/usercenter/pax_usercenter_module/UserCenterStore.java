package com.didiglobal.usercenter.pax_usercenter_module;

import com.didi.sdk.sidebar.model.SidebarPage;

public class UserCenterStore {

    /* renamed from: a */
    private static final UserCenterStore f51460a = new UserCenterStore();
    public SidebarPage accountData;
    public SidebarPage settingData;

    public void setSettingData(SidebarPage sidebarPage) {
        this.settingData = sidebarPage;
    }

    public void setAccountData(SidebarPage sidebarPage) {
        this.accountData = sidebarPage;
    }

    public SidebarPage getSettingData() {
        return this.settingData;
    }

    public SidebarPage getAccountData() {
        return this.accountData;
    }

    public static final UserCenterStore getInstance() {
        return f51460a;
    }
}
