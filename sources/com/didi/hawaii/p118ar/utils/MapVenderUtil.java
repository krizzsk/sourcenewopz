package com.didi.hawaii.p118ar.utils;

import android.content.Context;
import com.didi.common.map.MapAvailability;
import com.didi.common.map.MapVendor;
import com.didi.common.map.util.MapApolloTools;
import com.didi.map.global.component.mapviewholder.C9551util;
import com.didi.map.sdk.degrade.DegradeFactory;
import com.didi.map.sdk.degrade.DegradeMode;

/* renamed from: com.didi.hawaii.ar.utils.MapVenderUtil */
public class MapVenderUtil {

    /* renamed from: com.didi.hawaii.ar.utils.MapVenderUtil$1 */
    static /* synthetic */ class C89131 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$common$map$MapVendor;

        static {
            int[] iArr = new int[MapVendor.values().length];
            $SwitchMap$com$didi$common$map$MapVendor = iArr;
            try {
                iArr[MapVendor.GOOGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static MapVendor getCurrentMapType(Context context) {
        MapVendor mapVendor = C9551util.getMapVendor(context);
        if (C89131.$SwitchMap$com$didi$common$map$MapVendor[mapVendor.ordinal()] != 1) {
            return mapVendor;
        }
        if (MapApolloTools.isDiDiMapEnabled()) {
            return MapVendor.DIDI;
        }
        DegradeMode targetDegradeMode = DegradeFactory.create().getTargetDegradeMode(DegradeMode.GOOGLE, context);
        if (targetDegradeMode == DegradeMode.DIDI) {
            return MapVendor.DIDI;
        }
        if (targetDegradeMode == DegradeMode.GOOGLE && MapAvailability.isAvailable(context, MapVendor.GOOGLE) == 0) {
            return MapVendor.GOOGLE;
        }
        return MapVendor.Empty;
    }
}
