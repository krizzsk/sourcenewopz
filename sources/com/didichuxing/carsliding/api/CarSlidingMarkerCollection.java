package com.didichuxing.carsliding.api;

import com.didi.common.map.Map;
import com.didi.common.map.model.Marker;
import java.util.ArrayList;
import java.util.List;

public class CarSlidingMarkerCollection {

    /* renamed from: a */
    private static List<Marker> f46244a = new ArrayList();

    /* renamed from: b */
    private static List<CarSlidingRender> f46245b = new ArrayList();

    public static void onSceneOut() {
    }

    public static void registerMarker(Marker marker) {
        if (marker != null && !f46244a.contains(marker)) {
            f46244a.add(marker);
        }
    }

    public static void unRegisterMarkers() {
        for (Marker next : f46244a) {
            if (next != null) {
                next.setVisible(false);
            }
        }
        f46244a.clear();
    }

    public static void unRegisterMarkersWithRemove(Map map) {
        for (Marker next : f46244a) {
            if (next != null) {
                next.setVisible(false);
                if (map != null) {
                    map.remove(next);
                }
            }
        }
        f46244a.clear();
    }

    public static void onSceneIn(Map map) {
        unRegisterMarkersWithRemove(map);
        cleanRenders();
    }

    public static void recordRenders(CarSlidingRender carSlidingRender) {
        if (carSlidingRender != null && !f46245b.contains(carSlidingRender)) {
            f46245b.add(carSlidingRender);
        }
    }

    public static void cleanRenders() {
        for (CarSlidingRender next : f46245b) {
            if (next != null) {
                next.destroy();
            }
        }
        f46245b.clear();
    }
}
