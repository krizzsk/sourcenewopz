package com.didi.map.outer.model;

import android.graphics.Rect;
import com.didi.map.alpha.maps.internal.ICollisionGroupDelegate;
import java.util.List;

public class CollisionGroup {
    private final ICollisionGroupDelegate control;

    /* renamed from: id */
    private final String f27920id;
    private final CollisionGroupOption option;

    public CollisionGroup(CollisionGroupOption collisionGroupOption, ICollisionGroupDelegate iCollisionGroupDelegate, String str) {
        this.control = iCollisionGroupDelegate;
        this.f27920id = str;
        this.option = collisionGroupOption;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.control.setCollisonGroupPadding(this.f27920id, new Rect(i, i2, i3, i4));
    }

    public void setPadding(Rect rect) {
        this.control.setCollisonGroupPadding(this.f27920id, rect);
    }

    public void addRoute4Collision(List<LatLng> list) {
        this.control.addRoute4Collision(this.f27920id, list);
    }

    public void clearRoute4Collision() {
        this.control.clearRoute4Collision(this.f27920id);
    }

    public void remove() {
        this.control.removeCollisionGroup(this.f27920id);
    }

    public CollisionMarker addCollisionOverlay(CollisionMarkerOption collisionMarkerOption) {
        return this.control.addCollisionOverlay(this.f27920id, collisionMarkerOption);
    }

    public CollisionStub addVirtualCollsionStub(CollisionStubOption collisionStubOption) {
        return this.control.addVirtualCollsionStub(this.f27920id, collisionStubOption);
    }

    public void removeCollisionOverlay(String str) {
        this.control.removeCollisionOverlay(this.f27920id, str);
    }

    public void clearCollisionOverlay() {
        this.control.clearCollisionOverlay(this.f27920id);
    }

    public void requestCollision() {
        this.control.requestCollision(this.f27920id);
    }

    public void setVisible(boolean z) {
        this.control.setGroupVisible(this.f27920id, z);
    }
}
