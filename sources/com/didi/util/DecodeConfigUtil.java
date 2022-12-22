package com.didi.util;

import com.didi.zxing.barcodescanner.DecodeConfig;
import com.didichuxing.foundation.spi.ServiceLoader;

public class DecodeConfigUtil {

    /* renamed from: a */
    private static DecodeConfig f45139a;
    public static int lum;

    public static DecodeConfig getConfig() {
        if (f45139a == null) {
            f45139a = (DecodeConfig) ServiceLoader.load(DecodeConfig.class).get();
        }
        return f45139a;
    }
}
