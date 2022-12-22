package com.didi.sdk.sidebar.component;

import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.sidebar.model.SidebarItem;

@ComponentType(name = "menu_setting_discount_switch")
public class DiscountSwitchComponent extends NavigationWithArrowComponent {
    public DiscountSwitchComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
    }
}
