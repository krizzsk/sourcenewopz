package com.rider.rlab_im_map_plugin.page;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.SimpleSwapChangeHandler;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.google.android.libraries.navigation.Waypoint;
import com.rider.rlab_im_map_plugin.channel.MapIMPluginHelper;
import com.rider.rlab_im_map_plugin.channel.NavIMServiceImpl;
import com.rider.rlab_im_map_plugin.nav.ImNavigationView;
import com.rider.rlab_im_map_plugin.nav.ImNavigator;
import com.taxis99.R;

public class ImNavPage extends Page {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f55962a = LoggerFactory.getLogger("ImNavPage");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ImNavigationView f55963b;

    /* renamed from: c */
    private Waypoint f55964c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final ImNavigator f55965d = new ImNavigator();

    /* renamed from: e */
    private final ImNavigator.NavigationListener f55966e = new ImNavigator.NavigationListener() {
        public void onSuccess() {
            ImNavPage.this.f55962a.info("Navigator onSuccess", new Object[0]);
            MapIMPluginHelper.setIMNavigationState(0, "onSuccess");
        }

        public void onFail(String str) {
            Logger a = ImNavPage.this.f55962a;
            a.info("Navigator onFail : " + str, new Object[0]);
            MapIMPluginHelper.setIMNavigationState(1, str);
        }
    };

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.rider_im_nav_page, viewGroup, false);
        this.f55963b = (ImNavigationView) inflate.findViewById(R.id.rider_im_nav_view);
        this.f55962a.info("onInflateView", new Object[0]);
        return inflate;
    }

    public void onCreate(View view) {
        super.onCreate(view);
        this.f55962a.info(NachoLifecycleManager.LIFECYCLE_ON_CREATE, new Object[0]);
        this.f55963b.onCreate((Bundle) null);
        NavIMServiceImpl.iNavigationProvider.setNavigationView(this.f55963b);
        if (getArgs() != null && getArgs().containsKey("lat") && getArgs().containsKey("lng") && getArgs().containsKey("address")) {
            double d = getArgs().getDouble("lat");
            double d2 = getArgs().getDouble("lng");
            String string = getArgs().getString("address");
            Logger logger = this.f55962a;
            logger.info("create nav to way point : lat : " + d + " lng : " + d2, new Object[0]);
            this.f55964c = Waypoint.fromLatLng(d, d2, string);
        }
        m40302a(this.f55964c);
    }

    /* renamed from: a */
    private void m40302a(Waypoint waypoint) {
        Context context = this.f55963b.getContext();
        if (waypoint != null && context != null && (context instanceof Activity)) {
            this.f55965d.navigate((Activity) context, waypoint, this.f55966e);
        }
    }

    public void onStart() {
        super.onStart();
        this.f55963b.onStart();
        this.f55962a.info("onStart", new Object[0]);
    }

    public void onResume() {
        super.onResume();
        this.f55963b.onResume();
        this.f55962a.info("onResume", new Object[0]);
    }

    public void onPause() {
        super.onPause();
        this.f55963b.onPause();
        this.f55962a.info("onPause", new Object[0]);
    }

    public void onStop() {
        super.onStop();
        this.f55963b.onStop();
        this.f55962a.info("onStop", new Object[0]);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f55962a.info(NachoLifecycleManager.LIFECYCLE_ON_DESTROY, new Object[0]);
        this.f55963b.onDestroy();
        this.f55965d.release();
        MapIMPluginHelper.setIMNavigationState(2, XPanelScene.SCENE_FINISH);
        NavIMServiceImpl.iNavigationProvider.setNavigationView((ImNavigationView) null);
    }

    public ControllerChangeHandler getPushHandler() {
        return new SimpleSwapChangeHandler();
    }

    public ControllerChangeHandler getPopHandler() {
        return new SimpleSwapChangeHandler();
    }

    public void reLoad() {
        if (getArgs() != null && getArgs().containsKey("lat") && getArgs().containsKey("lng") && getArgs().containsKey("address")) {
            double d = getArgs().getDouble("lat");
            double d2 = getArgs().getDouble("lng");
            this.f55964c = Waypoint.fromLatLng(d, d2, getArgs().getString("address"));
            if (this.f55965d.getNavigatorInit().get()) {
                Logger logger = this.f55962a;
                logger.info("create nav to way point : lat : " + d + " lng : " + d2, new Object[0]);
                this.f55965d.navToWayPoint(this.f55964c, this.f55966e);
                return;
            }
            Logger logger2 = this.f55962a;
            logger2.info("reLoad init nav : lat : " + d + " lng : " + d2, new Object[0]);
            m40302a(this.f55964c);
        }
    }
}
