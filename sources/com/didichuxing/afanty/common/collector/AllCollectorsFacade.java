package com.didichuxing.afanty.common.collector;

import android.app.Application;
import android.content.Context;
import com.didichuxing.omega.sdk.feedback.webview.neweb.DidiFileConfig;

public class AllCollectorsFacade {
    public static void initAll(Application application) {
        Context applicationContext = application.getApplicationContext();
        NetworkCollector.init(applicationContext);
        MemoryCollector.init(applicationContext);
        PackageCollector.init(applicationContext);
        ScreenCollector.init(applicationContext);
        UserInfoCollector.init(applicationContext);
        DidiFileConfig.init(applicationContext);
    }
}
