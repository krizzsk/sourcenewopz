package com.didichuxing.bigdata.p173dp.locsdk;

import android.content.Context;
import java.util.List;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.ICellManager */
public interface ICellManager {
    boolean cgiNeedUpdate(boolean z);

    void destroy();

    List<Cgi> getDetectedCgiList();

    String getDeviceId();

    void init(Context context);

    void refineCellT();

    void refresh();

    void requestCgiLocationUpdate();

    void reset();
}
