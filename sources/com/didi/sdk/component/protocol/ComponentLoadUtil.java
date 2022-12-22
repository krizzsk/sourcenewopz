package com.didi.sdk.component.protocol;

import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.Iterator;

public class ComponentLoadUtil {
    public static <S> S getComponent(Class<S> cls) {
        ServiceLoader<S> load = ServiceLoader.load(cls);
        if (load == null) {
            return null;
        }
        Iterator<S> it = load.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }
}
