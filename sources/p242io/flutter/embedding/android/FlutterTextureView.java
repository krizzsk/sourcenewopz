package p242io.flutter.embedding.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.renderer.FlutterRenderer;
import p242io.flutter.embedding.engine.renderer.RenderSurface;

/* renamed from: io.flutter.embedding.android.FlutterTextureView */
public class FlutterTextureView extends TextureView implements RenderSurface {

    /* renamed from: a */
    private static final String f57474a = "FlutterTextureView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f57475b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f57476c;

    /* renamed from: d */
    private boolean f57477d;

    /* renamed from: e */
    private FlutterRenderer f57478e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Surface f57479f;

    /* renamed from: g */
    private final TextureView.SurfaceTextureListener f57480g;

    public FlutterTextureView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FlutterTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f57475b = false;
        this.f57476c = false;
        this.f57477d = false;
        this.f57480g = new TextureView.SurfaceTextureListener() {
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                Log.m41140v(FlutterTextureView.f57474a, "SurfaceTextureListener.onSurfaceTextureAvailable()");
                boolean unused = FlutterTextureView.this.f57475b = true;
                if (FlutterTextureView.this.f57476c) {
                    FlutterTextureView.this.m41368b();
                }
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                Log.m41140v(FlutterTextureView.f57474a, "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
                if (FlutterTextureView.this.f57476c) {
                    FlutterTextureView.this.m41364a(i, i2);
                }
            }

            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                Log.m41140v(FlutterTextureView.f57474a, "SurfaceTextureListener.onSurfaceTextureDestroyed()");
                boolean unused = FlutterTextureView.this.f57475b = false;
                if (FlutterTextureView.this.f57476c) {
                    FlutterTextureView.this.m41370c();
                }
                if (FlutterTextureView.this.f57479f == null) {
                    return true;
                }
                FlutterTextureView.this.f57479f.release();
                Surface unused2 = FlutterTextureView.this.f57479f = null;
                return true;
            }
        };
        m41363a();
    }

    /* renamed from: a */
    private void m41363a() {
        setSurfaceTextureListener(this.f57480g);
    }

    public FlutterRenderer getAttachedRenderer() {
        return this.f57478e;
    }

    public void attachToRenderer(FlutterRenderer flutterRenderer) {
        Log.m41140v(f57474a, "Attaching to FlutterRenderer.");
        if (this.f57478e != null) {
            Log.m41140v(f57474a, "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.f57478e.stopRenderingToSurface();
        }
        this.f57478e = flutterRenderer;
        this.f57476c = true;
        if (this.f57475b) {
            Log.m41140v(f57474a, "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            m41368b();
        }
    }

    public void detachFromRenderer() {
        if (this.f57478e != null) {
            if (getWindowToken() != null) {
                Log.m41140v(f57474a, "Disconnecting FlutterRenderer from Android surface.");
                m41370c();
            }
            this.f57478e = null;
            this.f57476c = false;
            return;
        }
        Log.m41142w(f57474a, "detachFromRenderer() invoked when no FlutterRenderer was attached.");
    }

    public void pause() {
        if (this.f57478e != null) {
            this.f57478e = null;
            this.f57477d = true;
            this.f57476c = false;
            return;
        }
        Log.m41142w(f57474a, "pause() invoked when no FlutterRenderer was attached.");
    }

    public void setRenderSurface(Surface surface) {
        this.f57479f = surface;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m41368b() {
        if (this.f57478e == null || getSurfaceTexture() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
        }
        Surface surface = this.f57479f;
        if (surface != null) {
            surface.release();
            this.f57479f = null;
        }
        Surface surface2 = new Surface(getSurfaceTexture());
        this.f57479f = surface2;
        this.f57478e.startRenderingToSurface(surface2, this.f57477d);
        this.f57477d = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41364a(int i, int i2) {
        if (this.f57478e != null) {
            Log.m41140v(f57474a, "Notifying FlutterRenderer that Android surface size has changed to " + i + " x " + i2);
            this.f57478e.surfaceChanged(i, i2);
            return;
        }
        throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m41370c() {
        FlutterRenderer flutterRenderer = this.f57478e;
        if (flutterRenderer != null) {
            flutterRenderer.stopRenderingToSurface();
            Surface surface = this.f57479f;
            if (surface != null) {
                surface.release();
                this.f57479f = null;
                return;
            }
            return;
        }
        throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
    }
}
