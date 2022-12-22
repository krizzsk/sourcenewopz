package com.rider.rlab_im_map_plugin.channel;

import com.didi.rlab.uni_im_map.UniAPI;
import com.didi.rlab.uni_im_map.map.MapIMNavigationServicePlugin;
import com.didi.rlab.uni_im_map.map.MapIMServicePlugin;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public final class MapIMPluginHelper {

    /* renamed from: a */
    private static final Logger f55849a = LoggerFactory.getLogger("MapIMPluginHelper");

    public static void setCustomerOrderInfo(String str) {
        Logger logger = f55849a;
        logger.info("MapIMPluginHelper setCustomerOrderInfo : " + str, new Object[0]);
        ((MapIMServicePlugin) UniAPI.get(MapIMServicePlugin.class)).setCustomerOrderInfo(str, new MapIMServicePlugin.Result<Void>() {
            public void result(Void voidR) {
            }
        });
    }

    public static void setLocationInfo(double d, double d2) {
        Logger logger = f55849a;
        logger.info("MapIMPluginHelper setLocationInfo : " + d + " " + d2, new Object[0]);
        ((MapIMServicePlugin) UniAPI.get(MapIMServicePlugin.class)).setLocationInfo(d, d2, new MapIMServicePlugin.Result<Void>() {
            public void result(Void voidR) {
            }
        });
    }

    public static void setMapDragStartChange() {
        ((MapIMServicePlugin) UniAPI.get(MapIMServicePlugin.class)).setMapDragStartChange(new MapIMServicePlugin.Result<Void>() {
            public void result(Void voidR) {
            }
        });
    }

    public static void reverseGeo(int i, String str, double d, double d2) {
        ((MapIMServicePlugin) UniAPI.get(MapIMServicePlugin.class)).reverseGeo((long) i, str, d, d2, new MapIMServicePlugin.Result<Void>() {
            public void result(Void voidR) {
            }
        });
    }

    public static void setMapDragDidChange(double d, double d2) {
        ((MapIMServicePlugin) UniAPI.get(MapIMServicePlugin.class)).setMapDragDidChange(d, d2, new MapIMServicePlugin.Result<Void>() {
            public void result(Void voidR) {
            }
        });
    }

    public static void isCheckOverlap(boolean z) {
        ((MapIMServicePlugin) UniAPI.get(MapIMServicePlugin.class)).isCheckOverlap(z, new MapIMServicePlugin.Result<Void>() {
            public void result(Void voidR) {
            }
        });
    }

    public static void setIMNavigationState(long j, String str) {
        Logger logger = f55849a;
        logger.info("MapIMPluginHelper setIMNavigationState : " + j + " " + str, new Object[0]);
        ((MapIMNavigationServicePlugin) UniAPI.get(MapIMNavigationServicePlugin.class)).setIMNavigationState(j, str, new MapIMNavigationServicePlugin.Result<Void>() {
            public void result(Void voidR) {
            }
        });
    }

    public static void setNavigationInfo(String str, String str2) {
        ((MapIMNavigationServicePlugin) UniAPI.get(MapIMNavigationServicePlugin.class)).setNavigationInfo(str, str2, new MapIMNavigationServicePlugin.Result<Void>() {
            public void result(Void voidR) {
            }
        });
        Logger logger = f55849a;
        logger.info("setNavigationInfo : " + str2 + " " + str, new Object[0]);
    }

    public static void setMapNavigationDragDidChange() {
        ((MapIMNavigationServicePlugin) UniAPI.get(MapIMNavigationServicePlugin.class)).setMapNavigationDragDidChange(new MapIMNavigationServicePlugin.Result<Void>() {
            public void result(Void voidR) {
            }
        });
        f55849a.debug("setMapNavigationDragDidChange", new Object[0]);
    }

    public static void setMapNavigationFinish() {
        ((MapIMNavigationServicePlugin) UniAPI.get(MapIMNavigationServicePlugin.class)).setMapNavigationFinish(new MapIMNavigationServicePlugin.Result<Void>() {
            public void result(Void voidR) {
            }
        });
        f55849a.debug("setMapNavigationFinish", new Object[0]);
    }
}
