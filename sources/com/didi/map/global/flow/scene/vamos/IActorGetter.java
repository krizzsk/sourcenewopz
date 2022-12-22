package com.didi.map.global.flow.scene.vamos;

public interface IActorGetter {
    public static final int DRIVER = 1;
    public static final int PASSENGER = 0;
    public static final int UNKNOWN = -1;

    int getActor();
}
