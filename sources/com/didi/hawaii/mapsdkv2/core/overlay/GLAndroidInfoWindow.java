package com.didi.hawaii.mapsdkv2.core.overlay;

import android.widget.FrameLayout;
import com.didi.hawaii.mapsdkv2.core.GLAndroidView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.IGLInfoWindow;
import com.didi.hawaii.mapsdkv2.jni.HWBSManager;
import com.didi.hawaii.mapsdkv2.jni.MapOverlay;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;

public class GLAndroidInfoWindow extends GLAndroidView implements IGLInfoWindow {
    public void attachCollisionEngine(HWBSManager hWBSManager, MapOverlay mapOverlay) {
    }

    public LatLngBounds getGeoBound() {
        return null;
    }

    public void setCollisionOption(MapOverlay mapOverlay) {
    }

    public GLAndroidInfoWindow(GLViewManager gLViewManager, GLAndroidView.Option option, FrameLayout frameLayout) {
        super(gLViewManager, option, frameLayout);
    }

    public void setPosition(LatLng latLng) {
        setCenter(latLng);
    }

    public LatLng getPosition() {
        return super.getCenter();
    }

    public int[] getTextureWH() {
        return getViewWH();
    }
}
