package com.didi.dimina.container.secondparty.bundle.bean;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bundle.BundleManagerStrategy;

public class PreloadTask {
    public BundleManagerStrategy.SubpackageInfoCallback callback;
    public DMMina dmMina;
    public boolean isPreload;
    public String moduleName;

    public PreloadTask(boolean z, DMMina dMMina, String str, BundleManagerStrategy.SubpackageInfoCallback subpackageInfoCallback) {
        this.isPreload = z;
        this.dmMina = dMMina;
        this.moduleName = str;
        this.callback = subpackageInfoCallback;
    }
}
