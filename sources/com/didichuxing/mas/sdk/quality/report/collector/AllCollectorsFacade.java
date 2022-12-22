package com.didichuxing.mas.sdk.quality.report.collector;

import android.content.Context;

public class AllCollectorsFacade {
    public static void initAll(Context context) {
        TimeCollector.init();
        DeviceCollector.init(context);
        MemoryCollector.init(context);
        PackageCollector.init(context);
        ScreenCollector.init(context);
        LocaleCollector.init(context);
        PersistentInfoCollector.init(context);
        ActivityCollector.init();
        CustomCollector.init();
        StorageCollector.init(context);
        NetworkCollector.init(context);
    }
}
