package com.rider.rlab_im_map_plugin.nav;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.ToastUtil;
import com.google.android.libraries.navigation.Navigator;
import com.taxis99.R;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class NavigatorTools {
    public static final String GOOGLE_MAP = "com.google.android.apps.maps";
    public static final String GOOGLE_PLAY_STORE = "com.android.vending";
    public static final String WAZE_MAP = "com.waze";

    /* renamed from: a */
    private static final Logger f55953a = LoggerFactory.getLogger("RiderNavigationView");

    private NavigatorTools() {
    }

    public static String getRouteStatusStr(Context context, Navigator.RouteStatus routeStatus) {
        if (routeStatus == Navigator.RouteStatus.NO_ROUTE_FOUND) {
            return context.getString(R.string.rider_google_nav_err_no_route_found);
        }
        if (routeStatus == Navigator.RouteStatus.NETWORK_ERROR) {
            return context.getString(R.string.rider_google_nav_err_network_error);
        }
        if (routeStatus == Navigator.RouteStatus.QUOTA_CHECK_FAILED) {
            return context.getString(R.string.rider_google_nav_err_quota_check_failed);
        }
        if (routeStatus == Navigator.RouteStatus.ROUTE_CANCELED) {
            return context.getString(R.string.rider_google_nav_err_route_canceled);
        }
        if (routeStatus == Navigator.RouteStatus.LOCATION_DISABLED) {
            return context.getString(R.string.rider_google_nav_err_location_disabled);
        }
        if (routeStatus == Navigator.RouteStatus.LOCATION_UNKNOWN) {
            return context.getString(R.string.rider_google_nav_err_location_unknown);
        }
        if (routeStatus == Navigator.RouteStatus.WAYPOINT_ERROR) {
            return context.getString(R.string.rider_google_nav_err_waypoint_error);
        }
        return context.getString(R.string.rider_google_nav_err_other_error);
    }

    public static String getNavApiErrorStr(Context context, int i) {
        if (i == 1) {
            return context.getString(R.string.rider_google_nav_err_not_authorized);
        }
        if (i == 2) {
            return context.getString(R.string.rider_google_nav_err_terms_not_accepted);
        }
        if (i == 3) {
            return context.getString(R.string.rider_google_nav_err_network_error);
        }
        if (i != 4) {
            return context.getString(R.string.rider_google_nav_err_other_error);
        }
        return context.getString(R.string.rider_google_nav_err_location_permission_missing);
    }

    public static void toGoogleMap(Context context, double d, double d2, int i) {
        String str = "d";
        if (i != 1) {
            if (i == 2) {
                str = "b";
            } else if (i == 3) {
                str = "w";
            }
        }
        try {
            String str2 = "google.navigation:q=" + d + "," + d2;
            if (!TextUtils.isEmpty(str)) {
                str2 = str2 + "&mode=" + str;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(268435456);
            intent.setFlags(View.STATUS_BAR_TRANSIENT);
            context.startActivity(intent);
        } catch (Exception e) {
            f55953a.error("goGaoDeMap error", (Throwable) e);
        }
    }

    public static void toWazeMap(Context context, double d, double d2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("https://waze.com/ul?ll=%s,%s&navigate=yes", new Object[]{Double.valueOf(d), Double.valueOf(d2)})));
            intent.setFlags(268435456);
            intent.setFlags(View.STATUS_BAR_TRANSIENT);
            context.startActivity(intent);
        } catch (Exception e) {
            f55953a.error("goGaoDeMap error", (Throwable) e);
        }
    }

    public static boolean isPlayStoreInstalled(Context context) {
        try {
            SystemUtils.getPackageInfo(context.getPackageManager(), "com.android.vending", 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean isInstallGoogleMap(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:37.7749,-122.4194"));
        intent.setPackage("com.google.android.apps.maps");
        return intent.resolveActivity(context.getPackageManager()) != null;
    }

    public static boolean isInstallWaze(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://waze.com/ul?q=Hawaii"));
        intent.setPackage("com.waze");
        return intent.resolveActivity(context.getPackageManager()) != null;
    }

    public static void launchAppDetail(Context context, String str) {
        if (isPlayStoreInstalled(context)) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
                    intent.setPackage("com.android.vending");
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            ToastUtil.show(context, (CharSequence) context.getString(R.string.rider_google_play_store_not_installed));
        }
    }

    public static int getTravelMode(String str) {
        if (str == null || str.isEmpty()) {
            return 1;
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 644680819) {
            if (hashCode != 1118815609) {
                if (hashCode == 1920367559 && str.equals("driving")) {
                    c = 0;
                }
            } else if (str.equals("walking")) {
                c = 2;
            }
        } else if (str.equals("bicyling")) {
            c = 1;
        }
        if (c == 0) {
            return 1;
        }
        if (c == 1) {
            return 2;
        }
        if (c != 2) {
            return 1;
        }
        return 3;
    }

    public static String getTime(long j) {
        return m40298a(System.currentTimeMillis() + (j * 1000));
    }

    /* renamed from: a */
    private static String m40298a(long j) {
        return new SimpleDateFormat("HH:mm").format(new Date(j));
    }
}
