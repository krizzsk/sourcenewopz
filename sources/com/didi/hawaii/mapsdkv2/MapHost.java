package com.didi.hawaii.mapsdkv2;

import android.content.Context;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.RenderProfile;
import com.didi.map.core.SurfaceChangeListener;

public interface MapHost {

    public interface LifeCycleCallback {
        void onHostCreated();

        void onHostDestroy();

        void onHostDetached();

        void onHostPause();

        void onHostResume();

        void onHostSizeChanged(int i, int i2);
    }

    Context getContext();

    GLViewManager getGLViewManage();

    int getHeight();

    int getWidth();

    void onDestroy();

    void onPause();

    void onResume();

    void setRenderProfile(RenderProfile renderProfile);

    void setSurfaceChangeListener(SurfaceChangeListener surfaceChangeListener);

    void setZOrderMediaOverlay(boolean z);
}
