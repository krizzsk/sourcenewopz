package com.didi.sdk.envsetbase.util;

import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnvSpiUtil {
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

    public static <S> List<S> getComponents(Class<S> cls) {
        ArrayList arrayList = new ArrayList();
        ServiceLoader<S> load = ServiceLoader.load(cls);
        if (load != null) {
            Iterator<S> it = load.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return arrayList;
    }
}
