package com.didichuxing.carsliding.api;

import com.didi.common.map.Map;
import com.didi.common.map.model.BitmapDescriptor;

public class CarSlidingRenderFactory {
    private CarSlidingRenderFactory() {
    }

    public static final CarSlidingRender createRender(Map map) {
        CarSlidingRenderImpl carSlidingRenderImpl = new CarSlidingRenderImpl(map);
        CarSlidingMarkerCollection.recordRenders(carSlidingRenderImpl);
        return carSlidingRenderImpl;
    }

    public static final CarSlidingRender createRender(Map map, BitmapDescriptor bitmapDescriptor, BitmapDescriptor bitmapDescriptor2) {
        CarSlidingRenderImpl carSlidingRenderImpl = new CarSlidingRenderImpl(map, bitmapDescriptor, bitmapDescriptor2);
        CarSlidingMarkerCollection.recordRenders(carSlidingRenderImpl);
        return carSlidingRenderImpl;
    }
}
