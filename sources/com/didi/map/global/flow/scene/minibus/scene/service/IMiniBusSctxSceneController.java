package com.didi.map.global.flow.scene.minibus.scene.service;

import com.didi.common.map.model.BitmapDescriptor;
import com.didi.map.global.flow.scene.ISceneController;
import com.didi.map.global.flow.scene.order.serving.param.OrderParams;

public interface IMiniBusSctxSceneController extends ISceneController {
    void onOrderStateChanged(int i, OrderParams orderParams);

    void refreshCarBitmap(BitmapDescriptor bitmapDescriptor);
}
