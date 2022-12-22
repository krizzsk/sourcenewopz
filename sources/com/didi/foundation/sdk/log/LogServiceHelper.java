package com.didi.foundation.sdk.log;

import android.app.Application;
import com.didi.foundation.sdk.login.LoginService;
import com.didi.sdk.logging.LoggerConfig;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.logging.util.Supplier;

public final class LogServiceHelper {
    private LogServiceHelper() {
    }

    public static void config(Application application, LogFileConfiguration logFileConfiguration) {
        LoggerConfig.Builder builder = new LoggerConfig.Builder();
        builder.serverHost(LoggerConfig.GLOBAL_SERVER_HOST);
        boolean z = false;
        if (logFileConfiguration != null) {
            boolean isDebug = logFileConfiguration.isDebug();
            builder.debuggable(isDebug);
            builder.logcatLogEnabled(isDebug);
            if (!isDebug || logFileConfiguration.isFileLogEnabled()) {
                z = true;
            }
            builder.fileLogEnabled(z);
            builder.encryptEnabled(!isDebug);
            if (logFileConfiguration.getTotalFileSize() > 0) {
                builder.totalFileSize(logFileConfiguration.getTotalFileSize() * 1024 * 1024);
            }
        } else {
            builder.debuggable(false);
            builder.logcatLogEnabled(false);
            builder.fileLogEnabled(true);
            builder.encryptEnabled(true);
        }
        builder.phoneNumSupplier(new Supplier<String>() {
            public String get() {
                return LoginService.getInstance().getPhone();
            }
        });
        LoggerFactory.init(application, builder.build());
    }
}
