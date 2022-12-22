package com.didi.map.global.flow.scene.minibus.scene.service;

import android.graphics.Bitmap;
import com.didi.map.global.component.slideCars.model.ICarBitmapDescriptor;
import com.didi.map.global.flow.scene.order.serving.param.ClientParams;
import com.didi.map.global.flow.scene.order.serving.param.OrderParams;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import java.util.List;

public interface MiniBusSctxParamInterface {
    ICarBitmapDescriptor getCarMarkerBitmap();

    ClientParams getClientParam();

    List<CommonLineParam> getLineParams();

    List<CommonMarkerParam> getMarkerParams();

    OrderParams getOrderParams();

    MiniBusStreetParam getStreetParam();

    Bitmap getWayPointIcon();
}
