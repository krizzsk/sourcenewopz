package com.didi.soda.web.tools;

import android.util.Log;
import com.didi.soda.web.WebInitializer;
import com.didi.soda.web.config.WebConstant;

public class LogUtil {

    public interface LogInterface {
        void debug(String str);

        void erro(String str);

        void info(String str);
    }

    public static void info(String str) {
        if (WebInitializer.getInitializer() == null || WebInitializer.getInitializer().getLogUtil() == null) {
            Log.d(WebConstant.WEB_LOG_TAG, str);
        } else {
            WebInitializer.getInitializer().getLogUtil().info(str);
        }
    }

    public static void debug(String str) {
        if (WebInitializer.getInitializer() == null || WebInitializer.getInitializer().getLogUtil() == null) {
            Log.d(WebConstant.WEB_LOG_TAG, str);
        } else {
            WebInitializer.getInitializer().getLogUtil().debug(str);
        }
    }

    public static void erro(String str) {
        if (WebInitializer.getInitializer() == null || WebInitializer.getInitializer().getLogUtil() == null) {
            Log.e(WebConstant.WEB_LOG_TAG, str);
        } else {
            WebInitializer.getInitializer().getLogUtil().erro(str);
        }
    }
}
