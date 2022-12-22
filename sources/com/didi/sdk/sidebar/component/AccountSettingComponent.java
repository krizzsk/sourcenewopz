package com.didi.sdk.sidebar.component;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.view.TextComponentView;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;

@ComponentType(name = "account_settings")
public class AccountSettingComponent extends NavigationWithArrowComponent {
    public AccountSettingComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        OmegaSDKAdapter.trackEvent("pas_profile_thirdparty_sw");
        OneLoginFacade.getAction().go2SetThirdParty(this.businessContext.getContext());
    }

    /* access modifiers changed from: protected */
    public void initData(TextComponentView textComponentView) {
        super.initData(textComponentView);
    }
}
