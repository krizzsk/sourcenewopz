package com.didi.sdk.sidebar.component;

import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.sidebar.model.SidebarItem;

@ComponentType(name = "menu_setting_hide_number")
public class HideNumberComponent extends NavigationWithArrowComponent {
    public HideNumberComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
    }
}
