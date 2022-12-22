package com.didi.dimina.container.page;

import com.didi.dimina.container.bean.NavigateConfig;
import java.util.List;
import org.json.JSONObject;

public interface ITabBarPageHost extends IPageHost {
    IPageHost getCurrentPage();

    List<IPageHost> getCurrentPages();

    boolean hideTabBar();

    boolean hideTabBarRedDot(JSONObject jSONObject);

    boolean removeTabBarBadge(JSONObject jSONObject);

    boolean setTabBarBadge(JSONObject jSONObject);

    boolean setTabBarItem(JSONObject jSONObject);

    boolean setTabBarStyle(JSONObject jSONObject);

    boolean showTabBar();

    boolean showTabBarRedDot(JSONObject jSONObject);

    boolean switchTab(NavigateConfig navigateConfig);
}
