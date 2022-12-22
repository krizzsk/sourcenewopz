package p242io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;

/* renamed from: io.flutter.embedding.engine.renderer.SurfaceTextureWrapper */
public class SurfaceTextureWrapper {
    private boolean attached;
    private boolean released = false;
    private SurfaceTexture surfaceTexture;

    public SurfaceTextureWrapper(SurfaceTexture surfaceTexture2) {
        this.surfaceTexture = surfaceTexture2;
    }

    public SurfaceTexture surfaceTexture() {
        return this.surfaceTexture;
    }

    public void updateTexImage() {
        synchronized (this) {
            if (!this.released) {
                this.surfaceTexture.updateTexImage();
            }
        }
    }

    public void release() {
        synchronized (this) {
            if (!this.released) {
                this.surfaceTexture.release();
                this.released = true;
                this.attached = false;
            }
        }
    }

    public void attachToGLContext(int i) {
        synchronized (this) {
            if (!this.released) {
                if (this.attached) {
                    this.surfaceTexture.detachFromGLContext();
                }
                this.surfaceTexture.attachToGLContext(i);
                this.attached = true;
            }
        }
    }

    public void detachFromGLContext() {
        synchronized (this) {
            if (this.attached && !this.released) {
                this.surfaceTexture.detachFromGLContext();
                this.attached = false;
            }
        }
    }

    public void getTransformMatrix(float[] fArr) {
        this.surfaceTexture.getTransformMatrix(fArr);
    }
}
