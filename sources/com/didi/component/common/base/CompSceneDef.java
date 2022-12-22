package com.didi.component.common.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface CompSceneDef {
    public static final int SCENE_END_SERVICE = 10403;
    public static final int SCENE_ON_SERVICE = 10402;
    public static final int SCENE_UNKONOWN = -1;
    public static final int SCENE_WAIT_RSP = 10401;
}
