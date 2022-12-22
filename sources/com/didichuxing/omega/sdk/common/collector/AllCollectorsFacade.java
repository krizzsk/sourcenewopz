package com.didichuxing.omega.sdk.common.collector;

import android.content.Context;

public class AllCollectorsFacade {
    public static void initAll(Context context) {
        TimeCollector.init();
        NetworkCollector.init(context);
        DeviceCollector.init(context);
        MemoryCollector.init(context);
        PackageCollector.init(context);
        ProcessCollector.init(context);
        ScreenCollector.init(context);
        LocationCollector.init(context);
        LocaleCollector.init(context);
        PersistentInfoCollector.init(context);
        ActivityCollector.init();
        CustomCollector.init();
        StorageCollector.init(context);
    }
}
