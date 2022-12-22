package p242io.flutter.embedding.engine.renderer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.FlutterJNI;
import p242io.flutter.view.TextureRegistry;

/* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer */
public class FlutterRenderer implements TextureRegistry {

    /* renamed from: a */
    private static final String f57692a = "FlutterRenderer";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final FlutterJNI f57693b;

    /* renamed from: c */
    private final AtomicLong f57694c = new AtomicLong(0);

    /* renamed from: d */
    private Surface f57695d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f57696e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Handler f57697f = new Handler();

    /* renamed from: g */
    private final FlutterUiDisplayListener f57698g;

    public FlutterRenderer(FlutterJNI flutterJNI) {
        C210841 r0 = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterRenderer.this.f57696e = true;
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterRenderer.this.f57696e = false;
            }
        };
        this.f57698g = r0;
        this.f57693b = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(r0);
    }

    public boolean isDisplayingFlutterUi() {
        return this.f57696e;
    }

    public void addIsDisplayingFlutterUiListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        this.f57693b.addIsDisplayingFlutterUiListener(flutterUiDisplayListener);
        if (this.f57696e) {
            flutterUiDisplayListener.onFlutterUiDisplayed();
        }
    }

    public void removeIsDisplayingFlutterUiListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        this.f57693b.removeIsDisplayingFlutterUiListener(flutterUiDisplayListener);
    }

    public TextureRegistry.SurfaceTextureEntry createSurfaceTexture() {
        Log.m41140v(f57692a, "Creating a SurfaceTexture.");
        return registerSurfaceTexture(new SurfaceTexture(0));
    }

    public TextureRegistry.SurfaceTextureEntry registerSurfaceTexture(SurfaceTexture surfaceTexture) {
        surfaceTexture.detachFromGLContext();
        SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = new SurfaceTextureRegistryEntry(this.f57694c.getAndIncrement(), surfaceTexture);
        Log.m41140v(f57692a, "New SurfaceTexture ID: " + surfaceTextureRegistryEntry.mo172604id());
        m41476a(surfaceTextureRegistryEntry.mo172604id(), surfaceTextureRegistryEntry.textureWrapper());
        return surfaceTextureRegistryEntry;
    }

    /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$SurfaceTextureRegistryEntry */
    final class SurfaceTextureRegistryEntry implements TextureRegistry.SurfaceTextureEntry {
        /* access modifiers changed from: private */

        /* renamed from: id */
        public final long f57700id;
        private SurfaceTexture.OnFrameAvailableListener onFrameListener = new SurfaceTexture.OnFrameAvailableListener() {
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                if (!SurfaceTextureRegistryEntry.this.released && FlutterRenderer.this.f57693b.isAttached()) {
                    FlutterRenderer.this.m41475a(SurfaceTextureRegistryEntry.this.f57700id);
                }
            }
        };
        /* access modifiers changed from: private */
        public boolean released;
        private final SurfaceTextureWrapper textureWrapper;

        SurfaceTextureRegistryEntry(long j, SurfaceTexture surfaceTexture) {
            this.f57700id = j;
            this.textureWrapper = new SurfaceTextureWrapper(surfaceTexture);
            if (Build.VERSION.SDK_INT >= 21) {
                surfaceTexture().setOnFrameAvailableListener(this.onFrameListener, new Handler());
            } else {
                surfaceTexture().setOnFrameAvailableListener(this.onFrameListener);
            }
        }

        public SurfaceTextureWrapper textureWrapper() {
            return this.textureWrapper;
        }

        public SurfaceTexture surfaceTexture() {
            return this.textureWrapper.surfaceTexture();
        }

        /* renamed from: id */
        public long mo172604id() {
            return this.f57700id;
        }

        public void release() {
            if (!this.released) {
                Log.m41140v(FlutterRenderer.f57692a, "Releasing a SurfaceTexture (" + this.f57700id + ").");
                this.textureWrapper.release();
                FlutterRenderer.this.m41480b(this.f57700id);
                this.released = true;
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            try {
                if (!this.released) {
                    FlutterRenderer.this.f57697f.post(new SurfaceTextureFinalizerRunnable(this.f57700id, FlutterRenderer.this.f57693b));
                    super.finalize();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$SurfaceTextureFinalizerRunnable */
    static final class SurfaceTextureFinalizerRunnable implements Runnable {
        private final FlutterJNI flutterJNI;

        /* renamed from: id */
        private final long f57699id;

        SurfaceTextureFinalizerRunnable(long j, FlutterJNI flutterJNI2) {
            this.f57699id = j;
            this.flutterJNI = flutterJNI2;
        }

        public void run() {
            if (this.flutterJNI.isAttached()) {
                Log.m41140v(FlutterRenderer.f57692a, "Releasing a SurfaceTexture (" + this.f57699id + ").");
                this.flutterJNI.unregisterTexture(this.f57699id);
            }
        }
    }

    public void startRenderingToSurface(Surface surface, boolean z) {
        if (this.f57695d != null && !z) {
            stopRenderingToSurface();
        }
        this.f57695d = surface;
        this.f57693b.onSurfaceCreated(surface);
    }

    public void swapSurface(Surface surface) {
        this.f57695d = surface;
        this.f57693b.onSurfaceWindowChanged(surface);
    }

    public void surfaceChanged(int i, int i2) {
        this.f57693b.onSurfaceChanged(i, i2);
    }

    public void stopRenderingToSurface() {
        this.f57693b.onSurfaceDestroyed();
        this.f57695d = null;
        if (this.f57696e) {
            this.f57698g.onFlutterUiNoLongerDisplayed();
        }
        this.f57696e = false;
    }

    public void setViewportMetrics(ViewportMetrics viewportMetrics) {
        ViewportMetrics viewportMetrics2 = viewportMetrics;
        if (viewportMetrics.validate()) {
            Log.m41140v(f57692a, "Setting viewport metrics\nSize: " + viewportMetrics2.width + " x " + viewportMetrics2.height + "\nPadding - L: " + viewportMetrics2.viewPaddingLeft + ", T: " + viewportMetrics2.viewPaddingTop + ", R: " + viewportMetrics2.viewPaddingRight + ", B: " + viewportMetrics2.viewPaddingBottom + "\nInsets - L: " + viewportMetrics2.viewInsetLeft + ", T: " + viewportMetrics2.viewInsetTop + ", R: " + viewportMetrics2.viewInsetRight + ", B: " + viewportMetrics2.viewInsetBottom + "\nSystem Gesture Insets - L: " + viewportMetrics2.systemGestureInsetLeft + ", T: " + viewportMetrics2.systemGestureInsetTop + ", R: " + viewportMetrics2.systemGestureInsetRight + ", B: " + viewportMetrics2.systemGestureInsetRight + "\nDisplay Features: " + viewportMetrics2.displayFeatures.size());
            int[] iArr = new int[(viewportMetrics2.displayFeatures.size() * 4)];
            int[] iArr2 = new int[viewportMetrics2.displayFeatures.size()];
            int[] iArr3 = new int[viewportMetrics2.displayFeatures.size()];
            for (int i = 0; i < viewportMetrics2.displayFeatures.size(); i++) {
                DisplayFeature displayFeature = viewportMetrics2.displayFeatures.get(i);
                int i2 = i * 4;
                iArr[i2] = displayFeature.bounds.left;
                iArr[i2 + 1] = displayFeature.bounds.top;
                iArr[i2 + 2] = displayFeature.bounds.right;
                iArr[i2 + 3] = displayFeature.bounds.bottom;
                iArr2[i] = displayFeature.type.encodedValue;
                iArr3[i] = displayFeature.state.encodedValue;
            }
            int[] iArr4 = iArr3;
            FlutterJNI flutterJNI = this.f57693b;
            flutterJNI.setViewportMetrics(viewportMetrics2.devicePixelRatio, viewportMetrics2.width, viewportMetrics2.height, viewportMetrics2.viewPaddingTop, viewportMetrics2.viewPaddingRight, viewportMetrics2.viewPaddingBottom, viewportMetrics2.viewPaddingLeft, viewportMetrics2.viewInsetTop, viewportMetrics2.viewInsetRight, viewportMetrics2.viewInsetBottom, viewportMetrics2.viewInsetLeft, viewportMetrics2.systemGestureInsetTop, viewportMetrics2.systemGestureInsetRight, viewportMetrics2.systemGestureInsetBottom, viewportMetrics2.systemGestureInsetLeft, viewportMetrics2.physicalTouchSlop, iArr, iArr2, iArr4);
        }
    }

    public Bitmap getBitmap() {
        return this.f57693b.getBitmap();
    }

    public void dispatchPointerDataPacket(ByteBuffer byteBuffer, int i) {
        this.f57693b.dispatchPointerDataPacket(byteBuffer, i);
    }

    /* renamed from: a */
    private void m41476a(long j, SurfaceTextureWrapper surfaceTextureWrapper) {
        this.f57693b.registerTexture(j, surfaceTextureWrapper);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41475a(long j) {
        this.f57693b.markTextureFrameAvailable(j);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m41480b(long j) {
        this.f57693b.unregisterTexture(j);
    }

    public boolean isSoftwareRenderingEnabled() {
        return this.f57693b.getIsSoftwareRenderingEnabled();
    }

    public void setAccessibilityFeatures(int i) {
        this.f57693b.setAccessibilityFeatures(i);
    }

    public void setSemanticsEnabled(boolean z) {
        this.f57693b.setSemanticsEnabled(z);
    }

    public void dispatchSemanticsAction(int i, int i2, ByteBuffer byteBuffer, int i3) {
        this.f57693b.dispatchSemanticsAction(i, i2, byteBuffer, i3);
    }

    /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$ViewportMetrics */
    public static final class ViewportMetrics {
        public static final int unsetValue = -1;
        public float devicePixelRatio = 1.0f;
        public List<DisplayFeature> displayFeatures = new ArrayList();
        public int height = 0;
        public int physicalTouchSlop = -1;
        public int systemGestureInsetBottom = 0;
        public int systemGestureInsetLeft = 0;
        public int systemGestureInsetRight = 0;
        public int systemGestureInsetTop = 0;
        public int viewInsetBottom = 0;
        public int viewInsetLeft = 0;
        public int viewInsetRight = 0;
        public int viewInsetTop = 0;
        public int viewPaddingBottom = 0;
        public int viewPaddingLeft = 0;
        public int viewPaddingRight = 0;
        public int viewPaddingTop = 0;
        public int width = 0;

        /* access modifiers changed from: package-private */
        public boolean validate() {
            return this.width > 0 && this.height > 0 && this.devicePixelRatio > 0.0f;
        }
    }

    /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$DisplayFeature */
    public static final class DisplayFeature {
        public final Rect bounds;
        public final DisplayFeatureState state;
        public final DisplayFeatureType type;

        public DisplayFeature(Rect rect, DisplayFeatureType displayFeatureType, DisplayFeatureState displayFeatureState) {
            this.bounds = rect;
            this.type = displayFeatureType;
            this.state = displayFeatureState;
        }

        public DisplayFeature(Rect rect, DisplayFeatureType displayFeatureType) {
            this.bounds = rect;
            this.type = displayFeatureType;
            this.state = DisplayFeatureState.UNKNOWN;
        }
    }

    /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$DisplayFeatureType */
    public enum DisplayFeatureType {
        UNKNOWN(0),
        FOLD(1),
        HINGE(2),
        CUTOUT(3);
        
        public final int encodedValue;

        private DisplayFeatureType(int i) {
            this.encodedValue = i;
        }
    }

    /* renamed from: io.flutter.embedding.engine.renderer.FlutterRenderer$DisplayFeatureState */
    public enum DisplayFeatureState {
        UNKNOWN(0),
        POSTURE_FLAT(1),
        POSTURE_HALF_OPENED(2);
        
        public final int encodedValue;

        private DisplayFeatureState(int i) {
            this.encodedValue = i;
        }
    }
}
