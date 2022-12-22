package com.didi.map.global.flow.scene.order.serving.components.guideentrance;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface GuideType {

    /* renamed from: AR */
    public static final int f26875AR = 1;
    public static final int DEFAULT = 0;
    public static final int OUTDOOR_AR = 4;
    public static final int REAL_SCENE = 2;
    public static final int STREET_VIEW = 3;
    public static final int STREET_VIEW_AND_CHECK = 5;
}
