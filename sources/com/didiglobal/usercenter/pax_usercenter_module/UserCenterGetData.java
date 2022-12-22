package com.didiglobal.usercenter.pax_usercenter_module;

import com.didi.sdk.sidebar.data.ISetSidebarData;
import com.didi.sdk.sidebar.model.SidebarPage;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({ISetSidebarData.class})
public class UserCenterGetData implements ISetSidebarData {
    public SidebarPage getSettingData() {
        return UserCenterStore.getInstance().getSettingData();
    }

    public SidebarPage getAccountData() {
        return UserCenterStore.getInstance().getAccountData();
    }
}
