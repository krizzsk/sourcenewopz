package com.didi.sdk.data;

import android.content.Context;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.Iterator;

public class NimbleLoader {
    public static final String TAG = "NLogger";

    /* renamed from: a */
    private NLogger f35778a = NLogger.getNLogger();

    public static NimbleLoader create() {
        return new NimbleLoader();
    }

    private NimbleLoader() {
    }

    public NimbleLoader load(String str, Context context) {
        Iterator<S> it = ServiceLoader.load(Incubator.class, str).iterator();
        if (it.hasNext()) {
            ((Incubator) it.next()).init(context);
            NLogger nLogger = this.f35778a;
            nLogger.info("load module : " + str + " finish");
        } else {
            NLogger nLogger2 = this.f35778a;
            nLogger2.warn("module: " + str + ",not load,can't find module");
        }
        return this;
    }
}
