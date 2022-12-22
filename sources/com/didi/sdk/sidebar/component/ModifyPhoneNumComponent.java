package com.didi.sdk.sidebar.component;

import android.text.TextUtils;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.view.TextComponentView;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;

@ComponentType(name = "account_modfy_phone")
public class ModifyPhoneNumComponent extends NavigationWithArrowComponent {
    public ModifyPhoneNumComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
    }

    /* access modifiers changed from: protected */
    public void initData(TextComponentView textComponentView) {
        super.initData(textComponentView);
        UserInfo userInfo = UserCenterFacade.getIns().getUserInfo(getView().getContext());
        if (userInfo != null && !TextUtils.isEmpty(userInfo.getPhone())) {
            textComponentView.setRightDes(userInfo.getPhone(), true);
        }
    }
}
