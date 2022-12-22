package com.didi.hawaii.mapsdkv2.adapter.option;

import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.overlay.GLCollisionStub;
import com.didi.map.outer.model.CollisionStubOption;

public class GLCollisionStubOptionAdapter implements GLViewOptionAdapter<GLCollisionStub.Option, CollisionStubOption> {
    public static final GLCollisionStubOptionAdapter GL_COLLISION_STUB_OPTION_ADAPTER = new GLCollisionStubOptionAdapter();

    public GLCollisionStub.Option get(CollisionStubOption collisionStubOption, GLViewManager gLViewManager) {
        GLCollisionStub.Option option = new GLCollisionStub.Option();
        option.setCollisionType(collisionStubOption.getCollisionType());
        option.setPriority(collisionStubOption.getPriority());
        option.setType(collisionStubOption.getType());
        option.setVirtualPosition(collisionStubOption.getScreenBound());
        return option;
    }
}
