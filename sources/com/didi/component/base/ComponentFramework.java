package com.didi.component.base;

import android.app.Activity;
import android.content.Context;
import com.didi.component.config.ConfigLoader;
import com.didi.component.core.ComponentLoader;
import com.didi.component.core.util.CLog;

public class ComponentFramework {
    public static void supportComponentLayout(Activity activity) {
    }

    public static void init(Context context, String str) {
        CLog.m8710i("ComponentFramework#init");
        ComponentLoader.load(str);
        ConfigLoader.init(context);
    }
}
