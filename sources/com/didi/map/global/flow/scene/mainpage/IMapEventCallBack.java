package com.didi.map.global.flow.scene.mainpage;

import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnMapGestureListener;

public abstract class IMapEventCallBack implements OnCameraChangeListener, OnMapGestureListener {
    public boolean onFling(float f, float f2) {
        return false;
    }

    public boolean onLongPress(float f, float f2) {
        return false;
    }

    public boolean onSingleTap(float f, float f2) {
        return false;
    }
}
