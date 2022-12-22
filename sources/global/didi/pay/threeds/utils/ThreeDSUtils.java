package global.didi.pay.threeds.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.adyen.checkout.adyen3ds2.Adyen3DS2Configuration;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.core.api.Environment;
import com.adyen.checkout.redirect.RedirectConfiguration;
import com.adyen.checkout.redirect.RedirectUtil;
import com.taxis99.R;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeDSUtils {
    private static final String BRAZIL_CLIENT_KEY = "live_MFZ26T2JP5CTTOHE5CWYWKPDUAYHZUWB";
    private static final String GLOBAL_CLIENT_KEY = "live_D32EKMIDOVFFDA6QBJPFESLAWQYYHHHW";
    public static final String THREEDS_SDK_VERSION = "global.didi.pay.threeds.sdk.version";

    public static boolean needThreeds() {
        return true;
    }

    public static String getCallbackUrl(String str) {
        return RedirectUtil.REDIRECT_RESULT_SCHEME + str;
    }

    public static Configuration getConfiguration(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        boolean isBrazilApp = isBrazilApp(context, getPackageName(context));
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -776144932) {
            if (hashCode == 1473713957 && str.equals("threeDS2")) {
                c = 0;
            }
        } else if (str.equals("redirect")) {
            c = 1;
        }
        String str2 = BRAZIL_CLIENT_KEY;
        if (c == 0) {
            if (!isBrazilApp) {
                str2 = GLOBAL_CLIENT_KEY;
            }
            return new Adyen3DS2Configuration.Builder(context, str2).setEnvironment(isBrazilApp ? Environment.UNITED_STATES : Environment.EUROPE).build();
        } else if (c != 1) {
            return null;
        } else {
            if (!isBrazilApp) {
                str2 = GLOBAL_CLIENT_KEY;
            }
            return new RedirectConfiguration.Builder(context, str2).setEnvironment(isBrazilApp ? Environment.UNITED_STATES : Environment.EUROPE).build();
        }
    }

    public static String getPackageName(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return "";
    }

    public static boolean isBrazilApp(Context context, String str) {
        return new HashSet(Arrays.asList(context.getResources().getStringArray(R.array.BRAZIL_PACKAGES))).contains(str) && !new HashSet(Arrays.asList(context.getResources().getStringArray(R.array.GLOBAL_PACKAGES))).contains(str);
    }
}
