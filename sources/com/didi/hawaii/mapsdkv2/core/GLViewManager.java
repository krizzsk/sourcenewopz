package com.didi.hawaii.mapsdkv2.core;

import android.graphics.Bitmap;
import android.os.Handler;
import java.io.File;
import java.util.concurrent.Future;

public interface GLViewManager {
    void addFrameCallback(C9184d dVar);

    int addView(GLOverlayView... gLOverlayViewArr);

    boolean addView(GLOverlayView gLOverlayView);

    Future<File> dumpInspectInfo(File file);

    GLOverlayView findViewById(String str);

    GLBaseMapView getBaseMap();

    int getFps();

    GLInstrumentation getGLInstrumentation();

    Handler getMainHandler();

    MapContext getMapContext();

    void insertCollisionDisPlayId(int i, GLOverlayView gLOverlayView);

    void removeFrameCallback(C9184d dVar);

    boolean removeView(GLOverlayView gLOverlayView);

    Future<Bitmap> screenShots();

    void setFps(int i);

    void setFpsMode(int i);

    void setRenderProfile(RenderProfile renderProfile);
}
