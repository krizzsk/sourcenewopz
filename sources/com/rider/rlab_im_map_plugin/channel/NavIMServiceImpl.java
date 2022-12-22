package com.rider.rlab_im_map_plugin.channel;

import android.app.Activity;
import android.content.Context;
import com.didi.common.map.util.DisplayUtils;
import com.didi.rlab.uni_im_map.map.NavigationIMService;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.rider.rlab_im_map_plugin.engine.ImMapConfig;
import com.rider.rlab_im_map_plugin.engine.OnSelectNavListener;
import com.rider.rlab_im_map_plugin.nav.INavigationProvider;
import com.rider.rlab_im_map_plugin.nav.NavigationProviderImpl;
import com.rider.rlab_im_map_plugin.nav.NavigatorTools;
import com.rider.rlab_im_map_plugin.tool.ImCallFrom;
import com.rider.rlab_im_map_plugin.tool.ImMapUtils;
import com.rider.rlab_im_map_plugin.xpanel.XPanelLayout;

public class NavIMServiceImpl implements NavigationIMService {
    public static INavigationProvider iNavigationProvider = new NavigationProviderImpl();

    /* renamed from: a */
    private final Logger f55851a = LoggerFactory.getLogger("NavIMServiceImpl");

    public void startMapNavigation(double d, double d2) {
        this.f55851a.info("startMapNavigation", new Object[0]);
        iNavigationProvider.startMapNavigation(d, d2);
    }

    public void setNavigationPadding(double d, double d2, double d3, double d4) {
        this.f55851a.info("setNavigationPadding", new Object[0]);
        Context context = ImMapConfig.getInstance().getContext();
        int dp2px = DisplayUtils.dp2px(context, (float) d);
        int dp2px2 = DisplayUtils.dp2px(context, (float) d3);
        double d5 = (double) dp2px2;
        double d6 = d5;
        iNavigationProvider.setNavigationPadding((double) dp2px, (double) DisplayUtils.dp2px(context, (float) d2), d6, (double) DisplayUtils.dp2px(context, (float) d4));
        XPanelLayout xPanelLayout = iNavigationProvider.getXPanelLayout();
        if (xPanelLayout != null) {
            xPanelLayout.setMapTouchHeight(Double.valueOf(d5));
        }
    }

    public void closeMapNavigation() {
        this.f55851a.info("closeMapNavigation", new Object[0]);
        iNavigationProvider.closeMapNavigation();
    }

    public void setMapNavigationRecenter() {
        this.f55851a.info("setMapNavigationRecenter", new Object[0]);
        iNavigationProvider.setMapNavigationRecenter();
    }

    public void setMapNavigationBestView() {
        this.f55851a.info("setMapNavigationBestView", new Object[0]);
        iNavigationProvider.setMapNavigationBestView();
    }

    public void setMapNavigationOverView() {
        this.f55851a.info("setMapNavigationOverView", new Object[0]);
        iNavigationProvider.setMapNavigationOverView();
    }

    public void openMapOutAppNavigation(double d, double d2, String str) {
        this.f55851a.info("openMapOutAppNavigation", new Object[0]);
        iNavigationProvider.openMapOutAppNavigation(d, d2, str);
    }

    public void gotoDownloadMapApp(long j) {
        Logger logger = this.f55851a;
        logger.info("gotoDownloadMapApp : " + j, new Object[0]);
        XPanelLayout xPanelLayout = iNavigationProvider.getXPanelLayout();
        if (xPanelLayout != null) {
            Activity scanForActivity = ImMapUtils.scanForActivity(xPanelLayout.getContext());
            if (scanForActivity == null) {
                this.f55851a.info("gotoDownloadMapApp : activity is null", new Object[0]);
            } else if (j == 2) {
                NavigatorTools.launchAppDetail(scanForActivity, "com.google.android.apps.maps");
            } else if (j == 3) {
                NavigatorTools.launchAppDetail(scanForActivity, "com.waze");
            }
        } else {
            this.f55851a.info("gotoDownloadMapApp : xPanelLayout is null", new Object[0]);
        }
    }

    public void selectNavigationType(long j) {
        int i = (int) j;
        ImMapConfig.getInstance().setNavType(i);
        OnSelectNavListener onSelectNavListener = ImMapConfig.getInstance().getOnSelectNavListener();
        if (onSelectNavListener != null) {
            onSelectNavListener.selectNavigationType(i);
        }
    }

    public boolean canNavGoogle() {
        return NavigatorTools.isInstallGoogleMap(ImMapConfig.getInstance().getContext());
    }

    public boolean canNavWaze() {
        return NavigatorTools.isInstallWaze(ImMapConfig.getInstance().getContext());
    }

    public long getUserSettingNavigationType() {
        if (ImMapConfig.getInstance().getCallFrom() == ImCallFrom.IMMAP_RLAB_C) {
            return 2;
        }
        return (long) ImMapConfig.getInstance().getNavType();
    }
}
