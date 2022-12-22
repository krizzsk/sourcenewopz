package com.didi.map.global.component.collide;

import com.didi.map.global.component.collide.common.DMarker;

public interface ICollideStrategy {
    void addMarker(DMarker... dMarkerArr);

    DMarker getMarker(String str);

    void onDestroy();

    void removeMarker(String... strArr);

    void updateMarker(DMarker dMarker);
}
