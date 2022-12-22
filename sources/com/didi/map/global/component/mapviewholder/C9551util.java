package com.didi.map.global.component.mapviewholder;

import android.content.Context;
import com.didi.common.map.MapVendor;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.Iterator;

/* renamed from: com.didi.map.global.component.mapviewholder.util */
public class C9551util {
    public static MapVendor getMapVendor(Context context) {
        ServiceLoader<S> load = ServiceLoader.load(IHmsDetermine.class);
        if (load != null) {
            Iterator<S> it = load.iterator();
            while (it.hasNext()) {
                MapVendor mapVendor = ((IHmsDetermine) it.next()).getMapVendor(context);
                if (mapVendor != null && !mapVendor.toString().equals(MapVendor.GOOGLE.toString())) {
                    return mapVendor;
                }
            }
        }
        return MapVendor.GOOGLE;
    }
}
