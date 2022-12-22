package com.didi.sdk.map;

import android.content.Context;
import com.didi.common.map.MapVendor;
import com.didi.map.global.component.mapviewholder.IHmsDetermine;
import com.didi.sdk.util.AnalysisAPK;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({IHmsDetermine.class})
public class MapDetermine implements IHmsDetermine {
    public MapVendor getMapVendor(Context context) {
        return AnalysisAPK.isGlobalHmsApk(context) ? MapVendor.HUAWEI : MapVendor.GOOGLE;
    }
}
