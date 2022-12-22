package com.didi.map.global.flow.scene.order.confirm.normal;

import com.didi.map.global.flow.scene.CarSlidingParam;
import com.didi.map.global.flow.scene.ISceneController;
import com.didi.map.global.flow.scene.order.confirm.BubbleContentParam;
import com.didi.map.global.flow.scene.order.confirm.MapElementStatus;
import com.didi.map.global.flow.scene.param.MapElementId;

public interface IOrderConfirmController extends ISceneController {
    long getDefaultRouteId();

    long getSelectedRouteId();

    void markerBubbleHandler(MapElementId mapElementId, MapElementStatus mapElementStatus, BubbleContentParam bubbleContentParam);

    void slidingCarHandler(MapElementStatus mapElementStatus, CarSlidingParam carSlidingParam);

    void updateCarLevel(CarLevelParam carLevelParam);
}
