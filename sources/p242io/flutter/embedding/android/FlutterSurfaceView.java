package p242io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.renderer.FlutterRenderer;
import p242io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import p242io.flutter.embedding.engine.renderer.RenderSurface;

/* renamed from: io.flutter.embedding.android.FlutterSurfaceView */
public class FlutterSurfaceView extends SurfaceView implements RenderSurface {

    /* renamed from: a */
    private static final String f57466a = "FlutterSurfaceView";

    /* renamed from: b */
    private final boolean f57467b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f57468c;

    /* renamed from: d */
    private boolean f57469d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f57470e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public FlutterRenderer f57471f;

    /* renamed from: g */
    private final SurfaceHolder.Callback f57472g;

    /* renamed from: h */
    private final FlutterUiDisplayListener f57473h;

    public FlutterSurfaceView(Context context) {
        this(context, (AttributeSet) null, false);
    }

    public FlutterSurfaceView(Context context, boolean z) {
        this(context, (AttributeSet) null, z);
    }

    public FlutterSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, false);
    }

    private FlutterSurfaceView(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.f57468c = false;
        this.f57469d = false;
        this.f57470e = false;
        this.f57472g = new SurfaceHolder.Callback() {
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Log.m41140v(FlutterSurfaceView.f57466a, "SurfaceHolder.Callback.startRenderingToSurface()");
                boolean unused = FlutterSurfaceView.this.f57468c = true;
                if (FlutterSurfaceView.this.f57470e) {
                    FlutterSurfaceView.this.m41357b();
                }
            }

            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                Log.m41140v(FlutterSurfaceView.f57466a, "SurfaceHolder.Callback.surfaceChanged()");
                if (FlutterSurfaceView.this.f57470e) {
                    FlutterSurfaceView.this.m41353a(i2, i3);
                }
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                Log.m41140v(FlutterSurfaceView.f57466a, "SurfaceHolder.Callback.stopRenderingToSurface()");
                boolean unused = FlutterSurfaceView.this.f57468c = false;
                if (FlutterSurfaceView.this.f57470e) {
                    FlutterSurfaceView.this.m41359c();
                }
            }
        };
        this.f57473h = new FlutterUiDisplayListener() {
            public void onFlutterUiNoLongerDisplayed() {
            }

            public void onFlutterUiDisplayed() {
                Log.m41140v(FlutterSurfaceView.f57466a, "onFlutterUiDisplayed()");
                FlutterSurfaceView.this.setAlpha(1.0f);
                if (FlutterSurfaceView.this.f57471f != null) {
                    FlutterSurfaceView.this.f57471f.removeIsDisplayingFlutterUiListener(this);
                }
            }
        };
        this.f57467b = z;
        m41352a();
    }

    /* renamed from: a */
    private void m41352a() {
        if (this.f57467b) {
            getHolder().setFormat(-2);
            setZOrderOnTop(true);
        }
        getHolder().addCallback(this.f57472g);
        setAlpha(0.0f);
    }

    public boolean gatherTransparentRegion(Region region) {
        if (getAlpha() < 1.0f) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        region.op(iArr[0], iArr[1], (iArr[0] + getRight()) - getLeft(), (iArr[1] + getBottom()) - getTop(), Region.Op.DIFFERENCE);
        return true;
    }

    public FlutterRenderer getAttachedRenderer() {
        return this.f57471f;
    }

    public void attachToRenderer(FlutterRenderer flutterRenderer) {
        Log.m41140v(f57466a, "Attaching to FlutterRenderer.");
        if (this.f57471f != null) {
            Log.m41140v(f57466a, "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.f57471f.stopRenderingToSurface();
            this.f57471f.removeIsDisplayingFlutterUiListener(this.f57473h);
        }
        this.f57471f = flutterRenderer;
        this.f57470e = true;
        flutterRenderer.addIsDisplayingFlutterUiListener(this.f57473h);
        if (this.f57468c) {
            Log.m41140v(f57466a, "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            m41357b();
        }
        this.f57469d = false;
    }

    public void detachFromRenderer() {
        if (this.f57471f != null) {
            if (getWindowToken() != null) {
                Log.m41140v(f57466a, "Disconnecting FlutterRenderer from Android surface.");
                m41359c();
            }
            setAlpha(0.0f);
            this.f57471f.removeIsDisplayingFlutterUiListener(this.f57473h);
            this.f57471f = null;
            this.f57470e = false;
            return;
        }
        Log.m41142w(f57466a, "detachFromRenderer() invoked when no FlutterRenderer was attached.");
    }

    public void pause() {
        if (this.f57471f != null) {
            this.f57471f = null;
            this.f57469d = true;
            this.f57470e = false;
            return;
        }
        Log.m41142w(f57466a, "pause() invoked when no FlutterRenderer was attached.");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m41357b() {
        if (this.f57471f == null || getHolder() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
        }
        this.f57471f.startRenderingToSurface(getHolder().getSurface(), this.f57469d);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41353a(int i, int i2) {
        if (this.f57471f != null) {
            Log.m41140v(f57466a, "Notifying FlutterRenderer that Android surface size has changed to " + i + " x " + i2);
            this.f57471f.surfaceChanged(i, i2);
            return;
        }
        throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m41359c() {
        FlutterRenderer flutterRenderer = this.f57471f;
        if (flutterRenderer != null) {
            flutterRenderer.stopRenderingToSurface();
            return;
        }
        throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
    }
}
