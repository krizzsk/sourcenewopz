package com.didi.map.alpha.maps.internal;

import android.graphics.Rect;
import com.didi.map.outer.model.CollisionMarker;
import com.didi.map.outer.model.CollisionMarkerOption;
import com.didi.map.outer.model.CollisionStub;
import com.didi.map.outer.model.CollisionStubOption;
import com.didi.map.outer.model.LatLng;
import java.util.List;

public interface ICollisionGroupDelegate {
    CollisionMarker addCollisionOverlay(String str, CollisionMarkerOption collisionMarkerOption);

    void addRoute4Collision(String str, List<LatLng> list);

    CollisionStub addVirtualCollsionStub(String str, CollisionStubOption collisionStubOption);

    void clearCollisionOverlay(String str);

    void clearGroup();

    void clearRoute4Collision(String str);

    int getCurShowTexture(String str, String str2);

    boolean isVisible(String str, String str2);

    void removeCollisionGroup(String str);

    void removeCollisionOverlay(String str, String str2);

    void requestCollision(String str);

    void setCollisonGroupPadding(String str, Rect rect);

    void setGroupVisible(String str, boolean z);

    void setVisible(String str, String str2, boolean z);

    void updateCollisionMarkerOption(String str, String str2, CollisionMarkerOption collisionMarkerOption);

    void updateCollisionMarkerPosition(String str, String str2, LatLng latLng);

    void updateCollisionOverlay(String str, String str2, CollisionMarkerOption collisionMarkerOption);
}
