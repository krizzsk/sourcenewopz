package com.didi.dimina.starbox.p107ui.floaticon;

import android.os.Bundle;

/* renamed from: com.didi.dimina.starbox.ui.floaticon.PageIntent */
public class PageIntent {
    public static final int MODE_NORMAL = 0;
    public static final int MODE_SINGLE_INSTANCE = 1;
    public Bundle bundle;
    public int mode = 0;
    public String tag;
    public Class<? extends BaseFloatPage> targetClass;

    public PageIntent() {
    }

    public PageIntent(Class<? extends BaseFloatPage> cls) {
        this.targetClass = cls;
    }
}
