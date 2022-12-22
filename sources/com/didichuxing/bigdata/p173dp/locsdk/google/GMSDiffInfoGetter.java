package com.didichuxing.bigdata.p173dp.locsdk.google;

import com.didichuxing.bigdata.p173dp.locsdk.IDiffInfoGetter;
import com.didichuxing.bigdata.p173dp.locsdk.trace.data.ETraceSource;
import com.didichuxing.bigdata.p173dp.locsdk.utils.Utils;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.google.android.gms.location.FusedLocationProviderApi;

@ServiceProvider({IDiffInfoGetter.class})
/* renamed from: com.didichuxing.bigdata.dp.locsdk.google.GMSDiffInfoGetter */
public class GMSDiffInfoGetter implements IDiffInfoGetter {
    public String getJustStartOmegaKey() {
        return "map_global_locsdk_first_success_sw";
    }

    public String getMockExtraKey() {
        return FusedLocationProviderApi.KEY_MOCK_LOCATION;
    }

    public boolean getNTPTimeDiffWTFSwitch() {
        return false;
    }

    public int getNLPCoordinateType() {
        return Utils.getCoordinateType();
    }

    public ETraceSource getInfoSource() {
        return ETraceSource.googleflp;
    }
}
