package com.didi.map.outer.model;

import com.didi.map.alpha.maps.internal.ICollisionGroupDelegate;

public class CollisionStub {
    private String collisionGroupId;
    private ICollisionGroupDelegate control;

    /* renamed from: id */
    private String f27921id;
    private CollisionStubOption option;

    public CollisionStub(CollisionStubOption collisionStubOption, ICollisionGroupDelegate iCollisionGroupDelegate, String str, String str2) {
        this.control = iCollisionGroupDelegate;
        this.option = collisionStubOption;
        this.collisionGroupId = str2;
        this.f27921id = str;
    }

    public void remove() {
        this.control.removeCollisionOverlay(this.collisionGroupId, this.f27921id);
    }
}
