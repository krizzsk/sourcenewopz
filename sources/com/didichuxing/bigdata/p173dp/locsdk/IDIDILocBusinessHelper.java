package com.didichuxing.bigdata.p173dp.locsdk;

import android.content.Context;
import com.didichuxing.bigdata.p173dp.locsdk.LocDataDef;
import java.util.List;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.IDIDILocBusinessHelper */
public interface IDIDILocBusinessHelper {
    void destroy();

    LocDataDef.LocCellInfo getCurrentCellInfo();

    List<LocDataDef.LocWifiInfo> getCurrentWifiList();

    DIDILocation getNewestGeneratedLoc(int i);

    List<DIDILocation> getRecentEffectiveLocations(int i);

    List<DIDILocation> getRecentGPSLocations(int i);

    List<DIDILocation> getRecentLocations(int i);

    void init(Context context);
}
