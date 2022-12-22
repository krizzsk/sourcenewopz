package p242io.flutter.view;

import android.graphics.SurfaceTexture;

/* renamed from: io.flutter.view.TextureRegistry */
public interface TextureRegistry {

    /* renamed from: io.flutter.view.TextureRegistry$SurfaceTextureEntry */
    public interface SurfaceTextureEntry {
        /* renamed from: id */
        long mo172604id();

        void release();

        SurfaceTexture surfaceTexture();
    }

    SurfaceTextureEntry createSurfaceTexture();

    SurfaceTextureEntry registerSurfaceTexture(SurfaceTexture surfaceTexture);
}
