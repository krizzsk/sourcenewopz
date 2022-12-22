package com.didichuxing.hawaii.arsdk.glarlib;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class RenderView extends SurfaceView implements SurfaceHolder.Callback {
    private long mNativeRVObj;

    private native void nativeSurfaceChanged(long j, Surface surface, int i, int i2, int i3);

    private native void nativeSurfaceCreated(long j, Surface surface);

    private native void nativeSurfaceDestroyed(long j, Surface surface);

    public RenderView(Context context, long j) {
        super(context);
        this.mNativeRVObj = j;
        getHolder().addCallback(this);
        setZOrderMediaOverlay(true);
        getHolder().setFormat(-3);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        nativeSurfaceCreated(this.mNativeRVObj, surfaceHolder.getSurface());
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        nativeSurfaceChanged(this.mNativeRVObj, surfaceHolder.getSurface(), i, i2, i3);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        nativeSurfaceDestroyed(this.mNativeRVObj, surfaceHolder.getSurface());
    }
}
