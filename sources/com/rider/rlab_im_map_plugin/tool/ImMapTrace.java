package com.rider.rlab_im_map_plugin.tool;

import com.didi.trace.annotations.Attribute;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.rider.rlab_im_map_plugin.channel.ErrorTracker;

public final class ImMapTrace {
    public static void traceMapDrag(@Attribute("zoom_level") int i) {
        try {
            Event event = new Event("sailing_d_x_map_drag_ck");
            event.putAttr("zoom_level", Integer.valueOf(i));
            OmegaSDKAdapter.trackEvent(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void traceMapZoom(@Attribute("zoom_level") int i, @Attribute("zoom_type") int i2) {
        try {
            Event event = new Event("sailing_d_x_map_zoom_ck");
            event.putAttr("zoom_level", Integer.valueOf(i));
            event.putAttr("zoom_type", Integer.valueOf(i2));
            OmegaSDKAdapter.trackEvent(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void trackAppNavigationSuccess() {
        try {
            Event event = new Event("tech_sailing_d_monitor_app_navigation_success");
            OmegaSDKAdapter.trackEvent(event);
            OmegaSDKAdapter.trackEvent(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void trackAppNavigationFail(@Attribute("error_code") String str, @Attribute("error_msg") String str2) {
        ErrorTracker.create("tech_sailing_d_monitor_app_navigation_fail").setErrorType(str).setErrorMessage(str2).trackError();
    }
}
