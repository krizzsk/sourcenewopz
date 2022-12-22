package com.dmap.navigation.engine.event;

import com.dmap.navigation.engine.core.camera.INaviCamera;
import com.dmap.navigation.engine.simple.SimpleNaviCamera;
import com.dmap.navigation.jni.swig.NaviCameraList;
import java.util.ArrayList;
import java.util.List;

public class CameraEvent extends NaviEvent {

    /* renamed from: a */
    private final int f51856a;

    /* renamed from: b */
    private final List<INaviCamera> f51857b;

    /* renamed from: c */
    private final int f51858c;

    public CameraEvent(int i, NaviCameraList naviCameraList, int i2) {
        this.f51856a = i;
        int size = (int) naviCameraList.size();
        if (size > 0) {
            this.f51857b = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                this.f51857b.add(new SimpleNaviCamera(naviCameraList.get(i3)));
            }
        } else {
            this.f51857b = null;
        }
        this.f51858c = i2;
    }

    public String toString() {
        return "CameraEvent{updateType=" + this.f51856a + ", cameras=" + this.f51857b + ", style=" + this.f51858c + '}';
    }

    public int getUpdateType() {
        return this.f51856a;
    }

    public List<INaviCamera> getCameras() {
        return this.f51857b;
    }

    public int getStyle() {
        return this.f51858c;
    }
}
