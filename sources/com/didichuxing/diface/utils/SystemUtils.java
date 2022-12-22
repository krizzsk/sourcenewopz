package com.didichuxing.diface.utils;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.Window;
import android.view.WindowManager;
import com.didi.dimina.container.bridge.NetworkSubJSBridge;
import com.didichuxing.security.safecollector.WsgSecInfo;

public class SystemUtils {
    public static void changeAppBrightness(Activity activity, int i) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (i == -1) {
            attributes.screenBrightness = -1.0f;
        } else {
            if (i <= 0) {
                i = 1;
            }
            attributes.screenBrightness = ((float) i) / 255.0f;
        }
        window.setAttributes(attributes);
    }

    public static void changeActBrightness(Activity activity, float f) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (f < 0.0f) {
            f = -1.0f;
        }
        attributes.screenBrightness = f;
        window.setAttributes(attributes);
    }

    public static int getMediaMaxVolume(Context context) {
        return ((AudioManager) context.getSystemService("audio")).getStreamMaxVolume(1);
    }

    public static int getMediaVolume(Context context) {
        return ((AudioManager) context.getSystemService("audio")).getStreamVolume(3);
    }

    public static void halfMediaVolume(Context context) {
        int mediaMaxVolume = getMediaMaxVolume(context) / 2;
        if (getMediaVolume(context) < mediaMaxVolume) {
            changeMediaVolume(context, mediaMaxVolume);
        }
    }

    public static void changeMediaVolume(Context context, int i) {
        ((AudioManager) context.getSystemService("audio")).setStreamVolume(3, i, 4);
    }

    public static NetworkType getNetworkType(Context context) {
        String networkType = WsgSecInfo.networkType(context);
        if (networkType == null) {
            networkType = "unknown";
        }
        char c = 65535;
        int hashCode = networkType.hashCode();
        if (hashCode != 1621) {
            if (hashCode != 1652) {
                if (hashCode != 1683) {
                    if (hashCode != 1714) {
                        if (hashCode == 2664213 && networkType.equals("WIFI")) {
                            c = 0;
                        }
                    } else if (networkType.equals("5G")) {
                        c = 4;
                    }
                } else if (networkType.equals("4G")) {
                    c = 3;
                }
            } else if (networkType.equals("3G")) {
                c = 2;
            }
        } else if (networkType.equals("2G")) {
            c = 1;
        }
        if (c == 0) {
            return NetworkType.NETWORK_WIFI;
        }
        if (c == 1) {
            return NetworkType.NETWORK_2G;
        }
        if (c == 2) {
            return NetworkType.NETWORK_3G;
        }
        if (c == 3) {
            return NetworkType.NETWORK_4G;
        }
        if (c != 4) {
            return NetworkType.NETWORK_NONE;
        }
        return NetworkType.NETWORK_5G;
    }

    public enum NetworkType {
        NETWORK_NONE("none"),
        NETWORK_WIFI("wifi"),
        NETWORK_2G(NetworkSubJSBridge.NetworkType.TYPE_2G),
        NETWORK_3G(NetworkSubJSBridge.NetworkType.TYPE_3G),
        NETWORK_4G(NetworkSubJSBridge.NetworkType.TYPE_4G),
        NETWORK_5G(NetworkSubJSBridge.NetworkType.TYPE_5G),
        NETWORK_MOBILE("mobile");
        
        public final String type;

        private NetworkType(String str) {
            this.type = str;
        }

        public String toString() {
            return "Network type : " + this.type;
        }
    }
}
