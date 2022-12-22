package com.didi.zxing.barcodescanner.camera;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.view.SurfaceHolder;
import java.io.IOException;

public class CameraSurface {

    /* renamed from: a */
    private SurfaceHolder f45380a;

    /* renamed from: b */
    private SurfaceTexture f45381b;

    public CameraSurface(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != null) {
            this.f45380a = surfaceHolder;
            return;
        }
        throw new IllegalArgumentException("surfaceHolder may not be null");
    }

    public CameraSurface(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null) {
            this.f45381b = surfaceTexture;
            return;
        }
        throw new IllegalArgumentException("surfaceTexture may not be null");
    }

    public SurfaceHolder getSurfaceHolder() {
        return this.f45380a;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.f45381b;
    }

    public void setPreview(Camera camera) throws IOException {
        SurfaceHolder surfaceHolder = this.f45380a;
        if (surfaceHolder != null) {
            camera.setPreviewDisplay(surfaceHolder);
        } else if (Build.VERSION.SDK_INT >= 11) {
            camera.setPreviewTexture(this.f45381b);
        } else {
            throw new IllegalStateException("SurfaceTexture not supported.");
        }
    }
}
