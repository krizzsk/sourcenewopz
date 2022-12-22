package com.didi.sdk.sidebar.component;

import android.text.BidiFormatter;
import android.text.TextUtils;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.view.Nav2UserInfoComponentNewView;
import com.didi.sdk.util.TextUtil;
import com.didi.usercenter.entity.UserInfo;

@ComponentType(name = "japan_nav_to_edit_account")
public class JapanNav2UserInfoComponent extends AbsNav2UserInfoComponent {
    public JapanNav2UserInfoComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
    }

    /* access modifiers changed from: protected */
    public void setName(UserInfo userInfo) {
        if (userInfo != null) {
            Logger logger = LoggerFactory.getLogger("user_info_log");
            logger.info("JapanNav2UserInfoComponent first name  = " + userInfo.getFirst_name() + "  last name = " + userInfo.getLast_name(), new Object[0]);
            if (!TextUtil.isEmpty(userInfo.getLast_name()) && !TextUtils.isEmpty(userInfo.getFirst_name())) {
                ((Nav2UserInfoComponentNewView) this.componentView).setName(userInfo.getLast_name() + " " + userInfo.getFirst_name());
            } else if (!TextUtil.isEmpty(userInfo.getLast_name())) {
                ((Nav2UserInfoComponentNewView) this.componentView).setName(userInfo.getLast_name());
            } else if (!TextUtil.isEmpty(userInfo.getFirst_name())) {
                ((Nav2UserInfoComponentNewView) this.componentView).setName(userInfo.getFirst_name());
            } else if (!TextUtil.isEmpty(userInfo.getPhone())) {
                ((Nav2UserInfoComponentNewView) this.componentView).setName(BidiFormatter.getInstance().unicodeWrap(userInfo.getPhone()));
            }
        }
    }
}
