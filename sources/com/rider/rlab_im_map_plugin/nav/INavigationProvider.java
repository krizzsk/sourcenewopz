package com.rider.rlab_im_map_plugin.nav;

import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;
import com.rider.rlab_im_map_plugin.xpanel.XPanelLayout;

@ServiceProviderInterface
public interface INavigationProvider {
    void closeMapNavigation();

    XPanelLayout getXPanelLayout();

    void openMapOutAppNavigation(double d, double d2, String str);

    void setMapNavigationBestView();

    void setMapNavigationOverView();

    void setMapNavigationRecenter();

    void setNavigationPadding(double d, double d2, double d3, double d4);

    void setNavigationView(ImNavigationView imNavigationView);

    void setPanelFrameTouchLayout(XPanelLayout xPanelLayout);

    void startMapNavigation(double d, double d2);
}
