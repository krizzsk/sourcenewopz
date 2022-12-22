package com.didi.security.wireless;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.sdk.apm.SystemUtils;

public class StatUtils {

    /* renamed from: a */
    private static WSGConnectionChangeReceiver f38579a;

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return true;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo state : allNetworkInfo) {
                if (state.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void registerReceiver(final Context context) {
        if (context == null) {
            SystemUtils.log(6, "WSGLOG", "registerReceiver ctx == null   ", (Throwable) null, "com.didi.security.wireless.StatUtils", 51);
            return;
        }
        try {
            if (f38579a == null) {
                IntentFilter intentFilter = new IntentFilter(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
                C133491 r1 = new WSGConnectionChangeReceiver() {
                    public void changeNetStatus(boolean z) {
                        SystemUtils.log(6, "WSGLOG", "changeNetStatus 网络变化  " + z, (Throwable) null, "com.didi.security.wireless.StatUtils$1", 62);
                        if (z) {
                            SecurityLib.nativeInitRetry(context);
                        }
                    }
                };
                f38579a = r1;
                context.registerReceiver(r1, intentFilter);
            }
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        } catch (Throwable unused) {
        }
    }

    public static void unregisterReceiver(Context context) {
        if (context == null) {
            SystemUtils.log(6, "WSGLOG", "unregisterReceiver ctx == null   ", (Throwable) null, "com.didi.security.wireless.StatUtils", 84);
            return;
        }
        try {
            if (f38579a != null) {
                context.unregisterReceiver(f38579a);
                f38579a = null;
            }
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        } catch (Throwable th) {
            SystemUtils.log(6, "WSGLOG", "unregisterReceiver error  " + th, (Throwable) null, "com.didi.security.wireless.StatUtils", 93);
        }
    }
}
