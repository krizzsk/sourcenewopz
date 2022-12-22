package p242io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.window.java.layout.WindowInfoTrackerCallbackAdapter;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p242io.flutter.Log;
import p242io.flutter.embedding.android.FlutterImageView;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.embedding.engine.renderer.FlutterRenderer;
import p242io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import p242io.flutter.embedding.engine.renderer.RenderSurface;
import p242io.flutter.embedding.engine.systemchannels.SettingsChannel;
import p242io.flutter.plugin.editing.TextInputPlugin;
import p242io.flutter.plugin.localization.LocalizationPlugin;
import p242io.flutter.plugin.mouse.MouseCursorPlugin;
import p242io.flutter.util.ViewUtils;
import p242io.flutter.view.AccessibilityBridge;

/* renamed from: io.flutter.embedding.android.FlutterView2 */
public class FlutterView2 extends FrameLayout implements MouseCursorPlugin.MouseCursorViewDelegate {

    /* renamed from: b */
    private static final String f57502b = "FlutterView";

    /* renamed from: a */
    RenderSurface f57503a;

    /* renamed from: c */
    private FlutterSurfaceView f57504c;

    /* renamed from: d */
    private FlutterTextureView f57505d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FlutterImageView f57506e;

    /* renamed from: f */
    private RenderSurface f57507f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Set<FlutterUiDisplayListener> f57508g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f57509h;

    /* renamed from: i */
    private FlutterEngine f57510i;

    /* renamed from: j */
    private final Set<FlutterEngineAttachmentListener> f57511j;

    /* renamed from: k */
    private MouseCursorPlugin f57512k;

    /* renamed from: l */
    private TextInputPlugin f57513l;

    /* renamed from: m */
    private LocalizationPlugin f57514m;

    /* renamed from: n */
    private KeyboardManager f57515n;

    /* renamed from: o */
    private AndroidTouchProcessor f57516o;

    /* renamed from: p */
    private AccessibilityBridge f57517p;

    /* renamed from: q */
    private WindowInfoRepositoryCallbackAdapterWrapper f57518q;

    /* renamed from: r */
    private final FlutterRenderer.ViewportMetrics f57519r;

    /* renamed from: s */
    private final AccessibilityBridge.OnAccessibilityChangeListener f57520s;

    /* renamed from: t */
    private final FlutterUiDisplayListener f57521t;

    /* renamed from: u */
    private final Consumer<WindowLayoutInfo> f57522u;

    /* renamed from: io.flutter.embedding.android.FlutterView2$FlutterEngineAttachmentListener */
    public interface FlutterEngineAttachmentListener {
        void onFlutterEngineAttachedToFlutterView(FlutterEngine flutterEngine);

        void onFlutterEngineDetachedFromFlutterView();
    }

    /* renamed from: io.flutter.embedding.android.FlutterView2$ZeroSides */
    private enum ZeroSides {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    public FlutterView2(Context context) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context));
    }

    @Deprecated
    public FlutterView2(Context context, RenderMode renderMode) {
        super(context, (AttributeSet) null);
        this.f57508g = new HashSet();
        this.f57511j = new HashSet();
        this.f57519r = new FlutterRenderer.ViewportMetrics();
        this.f57520s = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView2.this.m41388a(z, z2);
            }
        };
        this.f57521t = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView2.this.f57509h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView2.this.f57508g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView2.this.f57509h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView2.this.f57508g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f57522u = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView2.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context);
            this.f57504c = flutterSurfaceView;
            this.f57503a = flutterSurfaceView;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView = new FlutterTextureView(context);
            this.f57505d = flutterTextureView;
            this.f57503a = flutterTextureView;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[]{renderMode}));
        }
        m41391b();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public FlutterView2(Context context, TransparencyMode transparencyMode) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent));
    }

    public FlutterView2(Context context, FlutterSurfaceView flutterSurfaceView) {
        this(context, (AttributeSet) null, flutterSurfaceView);
    }

    public FlutterView2(Context context, FlutterTextureView flutterTextureView) {
        this(context, (AttributeSet) null, flutterTextureView);
    }

    public FlutterView2(Context context, FlutterImageView flutterImageView) {
        this(context, (AttributeSet) null, flutterImageView);
    }

    public FlutterView2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new FlutterSurfaceView(context));
    }

    @Deprecated
    public FlutterView2(Context context, RenderMode renderMode, TransparencyMode transparencyMode) {
        super(context, (AttributeSet) null);
        this.f57508g = new HashSet();
        this.f57511j = new HashSet();
        this.f57519r = new FlutterRenderer.ViewportMetrics();
        this.f57520s = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView2.this.m41388a(z, z2);
            }
        };
        this.f57521t = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView2.this.f57509h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView2.this.f57508g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView2.this.f57509h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView2.this.f57508g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f57522u = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView2.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        boolean z = false;
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent ? true : z);
            this.f57504c = flutterSurfaceView;
            this.f57503a = flutterSurfaceView;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView = new FlutterTextureView(context);
            this.f57505d = flutterTextureView;
            this.f57503a = flutterTextureView;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[]{renderMode}));
        }
        m41391b();
    }

    private FlutterView2(Context context, AttributeSet attributeSet, FlutterSurfaceView flutterSurfaceView) {
        super(context, attributeSet);
        this.f57508g = new HashSet();
        this.f57511j = new HashSet();
        this.f57519r = new FlutterRenderer.ViewportMetrics();
        this.f57520s = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView2.this.m41388a(z, z2);
            }
        };
        this.f57521t = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView2.this.f57509h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView2.this.f57508g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView2.this.f57509h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView2.this.f57508g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f57522u = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView2.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.f57504c = flutterSurfaceView;
        this.f57503a = flutterSurfaceView;
        m41391b();
    }

    private FlutterView2(Context context, AttributeSet attributeSet, FlutterTextureView flutterTextureView) {
        super(context, attributeSet);
        this.f57508g = new HashSet();
        this.f57511j = new HashSet();
        this.f57519r = new FlutterRenderer.ViewportMetrics();
        this.f57520s = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView2.this.m41388a(z, z2);
            }
        };
        this.f57521t = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView2.this.f57509h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView2.this.f57508g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView2.this.f57509h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView2.this.f57508g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f57522u = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView2.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.f57505d = flutterTextureView;
        this.f57503a = flutterTextureView;
        m41391b();
    }

    private FlutterView2(Context context, AttributeSet attributeSet, FlutterImageView flutterImageView) {
        super(context, attributeSet);
        this.f57508g = new HashSet();
        this.f57511j = new HashSet();
        this.f57519r = new FlutterRenderer.ViewportMetrics();
        this.f57520s = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView2.this.m41388a(z, z2);
            }
        };
        this.f57521t = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView2.this.f57509h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView2.this.f57508g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView2.this.f57509h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView2.this.f57508g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f57522u = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView2.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.f57506e = flutterImageView;
        this.f57503a = flutterImageView;
        m41391b();
    }

    /* renamed from: b */
    private void m41391b() {
        Log.m41140v(f57502b, "Initializing FlutterView");
        if (this.f57504c != null) {
            Log.m41140v(f57502b, "Internally using a FlutterSurfaceView.");
            addView(this.f57504c);
        } else if (this.f57505d != null) {
            Log.m41140v(f57502b, "Internally using a FlutterTextureView.");
            addView(this.f57505d);
        } else {
            Log.m41140v(f57502b, "Internally using a FlutterImageView.");
            addView(this.f57506e);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(4);
        }
    }

    public boolean hasRenderedFirstFrame() {
        return this.f57509h;
    }

    public void addOnFirstFrameRenderedListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        this.f57508g.add(flutterUiDisplayListener);
    }

    public void removeOnFirstFrameRenderedListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        this.f57508g.remove(flutterUiDisplayListener);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f57510i != null) {
            Log.m41140v(f57502b, "Configuration changed. Sending locales and user settings to Flutter.");
            this.f57514m.sendLocalesToFlutter(configuration);
            mo172222a();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Log.m41140v(f57502b, "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i3 + " x " + i4 + ", it is now " + i + " x " + i2);
        this.f57519r.width = i;
        this.f57519r.height = i2;
        m41393d();
    }

    /* access modifiers changed from: protected */
    public WindowInfoRepositoryCallbackAdapterWrapper createWindowInfoRepo() {
        try {
            return new WindowInfoRepositoryCallbackAdapterWrapper(new WindowInfoTrackerCallbackAdapter(WindowInfoTracker.Companion.getOrCreate(getContext())));
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f57518q = createWindowInfoRepo();
        Activity activity = ViewUtils.getActivity(getContext());
        WindowInfoRepositoryCallbackAdapterWrapper windowInfoRepositoryCallbackAdapterWrapper = this.f57518q;
        if (windowInfoRepositoryCallbackAdapterWrapper != null && activity != null) {
            windowInfoRepositoryCallbackAdapterWrapper.addWindowLayoutInfoListener(activity, ContextCompat.getMainExecutor(getContext()), this.f57522u);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        WindowInfoRepositoryCallbackAdapterWrapper windowInfoRepositoryCallbackAdapterWrapper = this.f57518q;
        if (windowInfoRepositoryCallbackAdapterWrapper != null) {
            windowInfoRepositoryCallbackAdapterWrapper.removeWindowLayoutInfoListener(this.f57522u);
        }
        this.f57518q = null;
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void setWindowInfoListenerDisplayFeatures(WindowLayoutInfo windowLayoutInfo) {
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        FlutterRenderer.DisplayFeatureType displayFeatureType;
        FlutterRenderer.DisplayFeatureState displayFeatureState;
        List<DisplayFeature> displayFeatures = windowLayoutInfo.getDisplayFeatures();
        ArrayList arrayList = new ArrayList();
        for (DisplayFeature next : displayFeatures) {
            Log.m41140v(f57502b, "WindowInfoTracker Display Feature reported with bounds = " + next.getBounds().toString() + " and type = " + next.getClass().getSimpleName());
            if (next instanceof FoldingFeature) {
                FoldingFeature foldingFeature = (FoldingFeature) next;
                if (foldingFeature.getOcclusionType() == FoldingFeature.OcclusionType.FULL) {
                    displayFeatureType = FlutterRenderer.DisplayFeatureType.HINGE;
                } else {
                    displayFeatureType = FlutterRenderer.DisplayFeatureType.FOLD;
                }
                if (foldingFeature.getState() == FoldingFeature.State.FLAT) {
                    displayFeatureState = FlutterRenderer.DisplayFeatureState.POSTURE_FLAT;
                } else if (foldingFeature.getState() == FoldingFeature.State.HALF_OPENED) {
                    displayFeatureState = FlutterRenderer.DisplayFeatureState.POSTURE_HALF_OPENED;
                } else {
                    displayFeatureState = FlutterRenderer.DisplayFeatureState.UNKNOWN;
                }
                arrayList.add(new FlutterRenderer.DisplayFeature(next.getBounds(), displayFeatureType, displayFeatureState));
            } else {
                arrayList.add(new FlutterRenderer.DisplayFeature(next.getBounds(), FlutterRenderer.DisplayFeatureType.UNKNOWN, FlutterRenderer.DisplayFeatureState.UNKNOWN));
            }
        }
        if (!(Build.VERSION.SDK_INT < 28 || (rootWindowInsets = getRootWindowInsets()) == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null)) {
            for (Rect next2 : displayCutout.getBoundingRects()) {
                Log.m41140v(f57502b, "DisplayCutout area reported with bounds = " + next2.toString());
                arrayList.add(new FlutterRenderer.DisplayFeature(next2, FlutterRenderer.DisplayFeatureType.CUTOUT));
            }
        }
        this.f57519r.displayFeatures = arrayList;
        m41393d();
    }

    /* renamed from: c */
    private ZeroSides m41392c() {
        Context context = getContext();
        int i = context.getResources().getConfiguration().orientation;
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (i == 2) {
            if (rotation == 1) {
                return ZeroSides.RIGHT;
            }
            if (rotation == 3) {
                return Build.VERSION.SDK_INT >= 23 ? ZeroSides.LEFT : ZeroSides.RIGHT;
            }
            if (rotation == 0 || rotation == 2) {
                return ZeroSides.BOTH;
            }
        }
        return ZeroSides.NONE;
    }

    /* renamed from: a */
    private int m41384a(WindowInsets windowInsets) {
        if (((double) windowInsets.getSystemWindowInsetBottom()) < ((double) getRootView().getHeight()) * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        if (Build.VERSION.SDK_INT == 29) {
            Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
            this.f57519r.systemGestureInsetTop = systemGestureInsets.top;
            this.f57519r.systemGestureInsetRight = systemGestureInsets.right;
            this.f57519r.systemGestureInsetBottom = systemGestureInsets.bottom;
            this.f57519r.systemGestureInsetLeft = systemGestureInsets.left;
        }
        boolean z = true;
        int i = 0;
        boolean z2 = (getWindowSystemUiVisibility() & 4) == 0;
        if ((getWindowSystemUiVisibility() & 2) != 0) {
            z = false;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            if (z) {
                i = 0 | WindowInsets.Type.navigationBars();
            }
            if (z2) {
                i |= WindowInsets.Type.statusBars();
            }
            Insets insets = windowInsets.getInsets(i);
            this.f57519r.viewPaddingTop = insets.top;
            this.f57519r.viewPaddingRight = insets.right;
            this.f57519r.viewPaddingBottom = insets.bottom;
            this.f57519r.viewPaddingLeft = insets.left;
            Insets insets2 = windowInsets.getInsets(WindowInsets.Type.ime());
            this.f57519r.viewInsetTop = insets2.top;
            this.f57519r.viewInsetRight = insets2.right;
            this.f57519r.viewInsetBottom = insets2.bottom;
            this.f57519r.viewInsetLeft = insets2.left;
            Insets insets3 = windowInsets.getInsets(WindowInsets.Type.systemGestures());
            this.f57519r.systemGestureInsetTop = insets3.top;
            this.f57519r.systemGestureInsetRight = insets3.right;
            this.f57519r.systemGestureInsetBottom = insets3.bottom;
            this.f57519r.systemGestureInsetLeft = insets3.left;
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                Insets waterfallInsets = displayCutout.getWaterfallInsets();
                FlutterRenderer.ViewportMetrics viewportMetrics = this.f57519r;
                viewportMetrics.viewPaddingTop = Math.max(Math.max(viewportMetrics.viewPaddingTop, waterfallInsets.top), displayCutout.getSafeInsetTop());
                FlutterRenderer.ViewportMetrics viewportMetrics2 = this.f57519r;
                viewportMetrics2.viewPaddingRight = Math.max(Math.max(viewportMetrics2.viewPaddingRight, waterfallInsets.right), displayCutout.getSafeInsetRight());
                FlutterRenderer.ViewportMetrics viewportMetrics3 = this.f57519r;
                viewportMetrics3.viewPaddingBottom = Math.max(Math.max(viewportMetrics3.viewPaddingBottom, waterfallInsets.bottom), displayCutout.getSafeInsetBottom());
                FlutterRenderer.ViewportMetrics viewportMetrics4 = this.f57519r;
                viewportMetrics4.viewPaddingLeft = Math.max(Math.max(viewportMetrics4.viewPaddingLeft, waterfallInsets.left), displayCutout.getSafeInsetLeft());
            }
        } else {
            ZeroSides zeroSides = ZeroSides.NONE;
            if (!z) {
                zeroSides = m41392c();
            }
            this.f57519r.viewPaddingTop = z2 ? windowInsets.getSystemWindowInsetTop() : 0;
            this.f57519r.viewPaddingRight = (zeroSides == ZeroSides.RIGHT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.f57519r.viewPaddingBottom = (!z || m41384a(windowInsets) != 0) ? 0 : windowInsets.getSystemWindowInsetBottom();
            this.f57519r.viewPaddingLeft = (zeroSides == ZeroSides.LEFT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            this.f57519r.viewInsetTop = 0;
            this.f57519r.viewInsetRight = 0;
            this.f57519r.viewInsetBottom = m41384a(windowInsets);
            this.f57519r.viewInsetLeft = 0;
        }
        Log.m41140v(f57502b, "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.f57519r.viewPaddingTop + ", Left: " + this.f57519r.viewPaddingLeft + ", Right: " + this.f57519r.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.f57519r.viewInsetBottom + ", Left: " + this.f57519r.viewInsetLeft + ", Right: " + this.f57519r.viewInsetRight + "System Gesture Insets - Left: " + this.f57519r.systemGestureInsetLeft + ", Top: " + this.f57519r.systemGestureInsetTop + ", Right: " + this.f57519r.systemGestureInsetRight + ", Bottom: " + this.f57519r.viewInsetBottom);
        m41393d();
        return onApplyWindowInsets;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT > 19) {
            return super.fitSystemWindows(rect);
        }
        this.f57519r.viewPaddingTop = rect.top;
        this.f57519r.viewPaddingRight = rect.right;
        this.f57519r.viewPaddingBottom = 0;
        this.f57519r.viewPaddingLeft = rect.left;
        this.f57519r.viewInsetTop = 0;
        this.f57519r.viewInsetRight = 0;
        this.f57519r.viewInsetBottom = rect.bottom;
        this.f57519r.viewInsetLeft = 0;
        Log.m41140v(f57502b, "Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: " + this.f57519r.viewPaddingTop + ", Left: " + this.f57519r.viewPaddingLeft + ", Right: " + this.f57519r.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.f57519r.viewInsetBottom + ", Left: " + this.f57519r.viewInsetLeft + ", Right: " + this.f57519r.viewInsetRight);
        m41393d();
        return true;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (!isAttachedToFlutterEngine()) {
            return super.onCreateInputConnection(editorInfo);
        }
        return this.f57513l.createInputConnection(this, this.f57515n, editorInfo);
    }

    public boolean checkInputConnectionProxy(View view) {
        FlutterEngine flutterEngine = this.f57510i;
        if (flutterEngine != null) {
            return flutterEngine.getPlatformViewsController().checkInputConnectionProxy(view);
        }
        return super.checkInputConnectionProxy(view);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        if ((!isAttachedToFlutterEngine() || !this.f57515n.handleEvent(keyEvent)) && !super.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onTouchEvent(motionEvent);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            requestUnbufferedDispatch(motionEvent);
        }
        return this.f57516o.onTouchEvent(motionEvent);
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (isAttachedToFlutterEngine() && this.f57516o.onGenericMotionEvent(motionEvent)) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onHoverEvent(motionEvent);
        }
        return this.f57517p.onAccessibilityHoverEvent(motionEvent);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge = this.f57517p;
        if (accessibilityBridge == null || !accessibilityBridge.isAccessibilityEnabled()) {
            return null;
        }
        return this.f57517p;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View findViewByAccessibilityIdTraversal(int r8) {
        /*
            r7 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 >= r1) goto L_0x000b
            android.view.View r8 = r7.m41385a((int) r8, (android.view.View) r7)
            return r8
        L_0x000b:
            r0 = 0
            java.lang.Class<android.view.View> r1 = android.view.View.class
            java.lang.String r2 = "findViewByAccessibilityIdTraversal"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{  }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{  }
            r6 = 0
            r4[r6] = r5     // Catch:{  }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r4)     // Catch:{  }
            r1.setAccessible(r3)
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x002e }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ NoSuchMethodException -> 0x002e }
            r2[r6] = r8     // Catch:{ NoSuchMethodException -> 0x002e }
            java.lang.Object r8 = r1.invoke(r7, r2)     // Catch:{ NoSuchMethodException -> 0x002e }
            android.view.View r8 = (android.view.View) r8     // Catch:{ NoSuchMethodException -> 0x002e }
            return r8
        L_0x002e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.embedding.android.FlutterView2.findViewByAccessibilityIdTraversal(int):android.view.View");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View m41385a(int r6, android.view.View r7) {
        /*
            r5 = this;
            r0 = 0
            java.lang.Class<android.view.View> r1 = android.view.View.class
            java.lang.String r2 = "getAccessibilityViewId"
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{  }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r4)     // Catch:{  }
            r2 = 1
            r1.setAccessible(r2)
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x003c }
            java.lang.Object r1 = r1.invoke(r7, r2)     // Catch:{ NoSuchMethodException -> 0x003c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ NoSuchMethodException -> 0x003c }
            boolean r1 = r1.equals(r2)     // Catch:{ NoSuchMethodException -> 0x003c }
            if (r1 == 0) goto L_0x0021
            return r7
        L_0x0021:
            boolean r1 = r7 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x003c
        L_0x0025:
            r1 = r7
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            int r2 = r1.getChildCount()
            if (r3 >= r2) goto L_0x003c
            android.view.View r1 = r1.getChildAt(r3)
            android.view.View r1 = r5.m41385a((int) r6, (android.view.View) r1)
            if (r1 == 0) goto L_0x0039
            return r1
        L_0x0039:
            int r3 = r3 + 1
            goto L_0x0025
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.embedding.android.FlutterView2.m41385a(int, android.view.View):android.view.View");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41388a(boolean z, boolean z2) {
        boolean z3 = false;
        if (!this.f57510i.getRenderer().isSoftwareRenderingEnabled()) {
            if (!z && !z2) {
                z3 = true;
            }
            setWillNotDraw(z3);
            return;
        }
        setWillNotDraw(false);
    }

    public PointerIcon getSystemPointerIcon(int i) {
        return PointerIcon.getSystemIcon(getContext(), i);
    }

    public void attachToFlutterEngine(FlutterEngine flutterEngine) {
        Log.m41140v(f57502b, "Attaching to a FlutterEngine: " + flutterEngine);
        if (isAttachedToFlutterEngine()) {
            if (flutterEngine == this.f57510i) {
                Log.m41140v(f57502b, "Already attached to this engine. Doing nothing.");
                return;
            } else {
                Log.m41140v(f57502b, "Currently attached to a different engine. Detaching and then attaching to new engine.");
                detachFromFlutterEngine();
            }
        }
        this.f57510i = flutterEngine;
        FlutterRenderer renderer = flutterEngine.getRenderer();
        this.f57509h = renderer.isDisplayingFlutterUi();
        this.f57503a.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(this.f57521t);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f57512k = new MouseCursorPlugin(this, this.f57510i.getMouseCursorChannel());
        }
        this.f57513l = new TextInputPlugin(this, this.f57510i.getTextInputChannel(), this.f57510i.getPlatformViewsController());
        this.f57514m = this.f57510i.getLocalizationPlugin();
        this.f57515n = new KeyboardManager(this, this.f57513l, new KeyChannelResponder[]{new KeyChannelResponder(flutterEngine.getKeyEventChannel())});
        this.f57516o = new AndroidTouchProcessor(this.f57510i.getRenderer(), false);
        AccessibilityBridge accessibilityBridge = new AccessibilityBridge(this, flutterEngine.getAccessibilityChannel(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.f57510i.getPlatformViewsController());
        this.f57517p = accessibilityBridge;
        accessibilityBridge.setOnAccessibilityChangeListener(this.f57520s);
        m41388a(this.f57517p.isAccessibilityEnabled(), this.f57517p.isTouchExplorationEnabled());
        this.f57510i.getPlatformViewsController().attachAccessibilityBridge(this.f57517p);
        this.f57510i.getPlatformViewsController().attachToFlutterRenderer(this.f57510i.getRenderer());
        this.f57513l.getInputMethodManager().restartInput(this);
        mo172222a();
        this.f57514m.sendLocalesToFlutter(getResources().getConfiguration());
        m41393d();
        for (FlutterEngineAttachmentListener onFlutterEngineAttachedToFlutterView : this.f57511j) {
            onFlutterEngineAttachedToFlutterView.onFlutterEngineAttachedToFlutterView(flutterEngine);
        }
        if (this.f57509h) {
            this.f57521t.onFlutterUiDisplayed();
        }
    }

    public void detachFromFlutterEngine() {
        Log.m41140v(f57502b, "Detaching from a FlutterEngine: " + this.f57510i);
        if (!isAttachedToFlutterEngine()) {
            Log.m41140v(f57502b, "FlutterView not attached to an engine. Not detaching.");
            return;
        }
        for (FlutterEngineAttachmentListener onFlutterEngineDetachedFromFlutterView : this.f57511j) {
            onFlutterEngineDetachedFromFlutterView.onFlutterEngineDetachedFromFlutterView();
        }
        this.f57510i.getPlatformViewsController().detachFromView();
        this.f57510i.getPlatformViewsController().detachAccessibilityBridge();
        this.f57517p.release();
        this.f57517p = null;
        this.f57513l.getInputMethodManager().restartInput(this);
        this.f57513l.destroy();
        this.f57515n.destroy();
        if (this.f57512k != null && Build.VERSION.SDK_INT >= 24) {
            this.f57512k.destroy();
        }
        FlutterRenderer renderer = this.f57510i.getRenderer();
        this.f57509h = false;
        renderer.removeIsDisplayingFlutterUiListener(this.f57521t);
        renderer.stopRenderingToSurface();
        renderer.setSemanticsEnabled(false);
        RenderSurface renderSurface = this.f57507f;
        if (renderSurface != null && this.f57503a == this.f57506e) {
            this.f57503a = renderSurface;
        }
        this.f57503a.detachFromRenderer();
        FlutterImageView flutterImageView = this.f57506e;
        if (flutterImageView != null) {
            flutterImageView.closeImageReader();
            this.f57506e = null;
        }
        this.f57507f = null;
        this.f57510i = null;
    }

    public FlutterImageView createImageView() {
        return new FlutterImageView(getContext(), getWidth(), getHeight(), FlutterImageView.SurfaceKind.background);
    }

    public void convertToImageView() {
        this.f57503a.pause();
        FlutterImageView flutterImageView = this.f57506e;
        if (flutterImageView == null) {
            FlutterImageView createImageView = createImageView();
            this.f57506e = createImageView;
            addView(createImageView);
        } else {
            flutterImageView.resizeIfNeeded(getWidth(), getHeight());
        }
        this.f57507f = this.f57503a;
        FlutterImageView flutterImageView2 = this.f57506e;
        this.f57503a = flutterImageView2;
        FlutterEngine flutterEngine = this.f57510i;
        if (flutterEngine != null) {
            flutterImageView2.attachToRenderer(flutterEngine.getRenderer());
        }
    }

    public void revertImageView(final Runnable runnable) {
        FlutterImageView flutterImageView = this.f57506e;
        if (flutterImageView == null) {
            Log.m41140v(f57502b, "Tried to revert the image view, but no image view is used.");
            return;
        }
        RenderSurface renderSurface = this.f57507f;
        if (renderSurface == null) {
            Log.m41140v(f57502b, "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        this.f57503a = renderSurface;
        this.f57507f = null;
        FlutterEngine flutterEngine = this.f57510i;
        if (flutterEngine == null) {
            flutterImageView.detachFromRenderer();
            runnable.run();
            return;
        }
        final FlutterRenderer renderer = flutterEngine.getRenderer();
        if (renderer == null) {
            this.f57506e.detachFromRenderer();
            runnable.run();
            return;
        }
        this.f57503a.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(new FlutterUiDisplayListener() {
            public void onFlutterUiNoLongerDisplayed() {
            }

            public void onFlutterUiDisplayed() {
                renderer.removeIsDisplayingFlutterUiListener(this);
                runnable.run();
                if (!(FlutterView2.this.f57503a instanceof FlutterImageView)) {
                    FlutterView2.this.f57506e.detachFromRenderer();
                }
            }
        });
    }

    public void attachOverlaySurfaceToRender(FlutterImageView flutterImageView) {
        FlutterEngine flutterEngine = this.f57510i;
        if (flutterEngine != null) {
            flutterImageView.attachToRenderer(flutterEngine.getRenderer());
        }
    }

    public boolean acquireLatestImageViewFrame() {
        FlutterImageView flutterImageView = this.f57506e;
        if (flutterImageView != null) {
            return flutterImageView.acquireLatestImage();
        }
        return false;
    }

    public boolean isAttachedToFlutterEngine() {
        FlutterEngine flutterEngine = this.f57510i;
        return flutterEngine != null && flutterEngine.getRenderer() == this.f57503a.getAttachedRenderer();
    }

    public FlutterEngine getAttachedFlutterEngine() {
        return this.f57510i;
    }

    public void addFlutterEngineAttachmentListener(FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.f57511j.add(flutterEngineAttachmentListener);
    }

    public void removeFlutterEngineAttachmentListener(FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.f57511j.remove(flutterEngineAttachmentListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo172222a() {
        SettingsChannel.PlatformBrightness platformBrightness;
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            platformBrightness = SettingsChannel.PlatformBrightness.dark;
        } else {
            platformBrightness = SettingsChannel.PlatformBrightness.light;
        }
        this.f57510i.getSettingsChannel().startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness(platformBrightness).send();
    }

    /* renamed from: d */
    private void m41393d() {
        if (!isAttachedToFlutterEngine()) {
            Log.m41142w(f57502b, "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.f57519r.devicePixelRatio = getResources().getDisplayMetrics().density;
        this.f57519r.physicalTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f57510i.getRenderer().setViewportMetrics(this.f57519r);
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        super.onProvideAutofillVirtualStructure(viewStructure, i);
        this.f57513l.onProvideAutofillVirtualStructure(viewStructure, i);
    }

    public void autofill(SparseArray<AutofillValue> sparseArray) {
        this.f57513l.autofill(sparseArray);
    }

    public void attachToRenderer() {
        RenderSurface renderSurface = this.f57503a;
        if ((renderSurface != null && renderSurface.getAttachedRenderer() == null) || !this.f57503a.getAttachedRenderer().isDisplayingFlutterUi()) {
            this.f57503a.attachToRenderer(this.f57510i.getRenderer());
        }
    }

    public void detachFromRenderer() {
        this.f57503a.detachFromRenderer();
    }
}
