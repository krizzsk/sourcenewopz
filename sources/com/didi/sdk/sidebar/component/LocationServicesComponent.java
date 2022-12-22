package com.didi.sdk.sidebar.component;

import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.sidebar.model.SidebarItem;

@ComponentType(name = "menu_setting_location_switch")
public class LocationServicesComponent extends NavigationWithArrowComponent {
    public LocationServicesComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
    }
}
