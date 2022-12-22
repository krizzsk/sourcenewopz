package com.didi.hawaii.mapsdkv2.adapter.option;

import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.overlay.GLCollisionGroup;
import com.didi.map.outer.model.CollisionGroupOption;

public class GLCollisionGroupOptionAdapter implements GLViewOptionAdapter<GLCollisionGroup.Option, CollisionGroupOption> {
    public GLCollisionGroup.Option get(CollisionGroupOption collisionGroupOption, GLViewManager gLViewManager) {
        GLCollisionGroup.Option option = new GLCollisionGroup.Option();
        option.setPadding(collisionGroupOption.getScreenPadding());
        return option;
    }
}
