package com.didi.map.global.flow.scene.order.serving.carpool;

import android.graphics.Bitmap;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import java.util.List;

public interface ISctxCarpoolMgr {
    void destroy();

    List<IMapElement> getSctxWayPoints();

    void onFinishFetchingCarpoolPoint(boolean z, List<OdPoint> list, List<LatLng> list2, Marker marker, Bitmap bitmap, Bitmap bitmap2);

    void setCarpoolInfoFetcher(IFetchCarpoolInfo iFetchCarpoolInfo);

    void setCarpoolShowBubblesEnabled(boolean z);
}
