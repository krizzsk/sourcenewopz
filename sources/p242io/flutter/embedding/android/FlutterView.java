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

/* renamed from: io.flutter.embedding.android.FlutterView */
public class FlutterView extends FrameLayout implements MouseCursorPlugin.MouseCursorViewDelegate {

    /* renamed from: b */
    private static final String f57481b = "FlutterView";

    /* renamed from: a */
    RenderSurface f57482a;

    /* renamed from: c */
    private FlutterSurfaceView f57483c;

    /* renamed from: d */
    private FlutterTextureView f57484d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FlutterImageView f57485e;

    /* renamed from: f */
    private RenderSurface f57486f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Set<FlutterUiDisplayListener> f57487g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f57488h;

    /* renamed from: i */
    private FlutterEngine f57489i;

    /* renamed from: j */
    private final Set<FlutterEngineAttachmentListener> f57490j;

    /* renamed from: k */
    private MouseCursorPlugin f57491k;

    /* renamed from: l */
    private TextInputPlugin f57492l;

    /* renamed from: m */
    private LocalizationPlugin f57493m;

    /* renamed from: n */
    private KeyboardManager f57494n;

    /* renamed from: o */
    private AndroidTouchProcessor f57495o;

    /* renamed from: p */
    private AccessibilityBridge f57496p;

    /* renamed from: q */
    private WindowInfoRepositoryCallbackAdapterWrapper f57497q;

    /* renamed from: r */
    private final FlutterRenderer.ViewportMetrics f57498r;

    /* renamed from: s */
    private final AccessibilityBridge.OnAccessibilityChangeListener f57499s;

    /* renamed from: t */
    private final FlutterUiDisplayListener f57500t;

    /* renamed from: u */
    private final Consumer<WindowLayoutInfo> f57501u;

    /* renamed from: io.flutter.embedding.android.FlutterView$FlutterEngineAttachmentListener */
    public interface FlutterEngineAttachmentListener {
        void onFlutterEngineAttachedToFlutterView(FlutterEngine flutterEngine);

        void onFlutterEngineDetachedFromFlutterView();
    }

    /* renamed from: io.flutter.embedding.android.FlutterView$ZeroSides */
    private enum ZeroSides {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    public FlutterView(Context context) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context));
    }

    @Deprecated
    public FlutterView(Context context, RenderMode renderMode) {
        super(context, (AttributeSet) null);
        this.f57487g = new HashSet();
        this.f57490j = new HashSet();
        this.f57498r = new FlutterRenderer.ViewportMetrics();
        this.f57499s = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.m41377a(z, z2);
            }
        };
        this.f57500t = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.f57488h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView.this.f57487g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.f57488h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView.this.f57487g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f57501u = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context);
            this.f57483c = flutterSurfaceView;
            this.f57482a = flutterSurfaceView;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView = new FlutterTextureView(context);
            this.f57484d = flutterTextureView;
            this.f57482a = flutterTextureView;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[]{renderMode}));
        }
        m41380b();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public FlutterView(Context context, TransparencyMode transparencyMode) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent));
    }

    public FlutterView(Context context, FlutterSurfaceView flutterSurfaceView) {
        this(context, (AttributeSet) null, flutterSurfaceView);
    }

    public FlutterView(Context context, FlutterTextureView flutterTextureView) {
        this(context, (AttributeSet) null, flutterTextureView);
    }

    public FlutterView(Context context, FlutterImageView flutterImageView) {
        this(context, (AttributeSet) null, flutterImageView);
    }

    public FlutterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new FlutterSurfaceView(context));
    }

    @Deprecated
    public FlutterView(Context context, RenderMode renderMode, TransparencyMode transparencyMode) {
        super(context, (AttributeSet) null);
        this.f57487g = new HashSet();
        this.f57490j = new HashSet();
        this.f57498r = new FlutterRenderer.ViewportMetrics();
        this.f57499s = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.m41377a(z, z2);
            }
        };
        this.f57500t = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.f57488h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView.this.f57487g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.f57488h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView.this.f57487g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f57501u = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        boolean z = false;
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent ? true : z);
            this.f57483c = flutterSurfaceView;
            this.f57482a = flutterSurfaceView;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView = new FlutterTextureView(context);
            this.f57484d = flutterTextureView;
            this.f57482a = flutterTextureView;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[]{renderMode}));
        }
        m41380b();
    }

    private FlutterView(Context context, AttributeSet attributeSet, FlutterSurfaceView flutterSurfaceView) {
        super(context, attributeSet);
        this.f57487g = new HashSet();
        this.f57490j = new HashSet();
        this.f57498r = new FlutterRenderer.ViewportMetrics();
        this.f57499s = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.m41377a(z, z2);
            }
        };
        this.f57500t = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.f57488h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView.this.f57487g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.f57488h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView.this.f57487g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f57501u = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.f57483c = flutterSurfaceView;
        this.f57482a = flutterSurfaceView;
        m41380b();
    }

    private FlutterView(Context context, AttributeSet attributeSet, FlutterTextureView flutterTextureView) {
        super(context, attributeSet);
        this.f57487g = new HashSet();
        this.f57490j = new HashSet();
        this.f57498r = new FlutterRenderer.ViewportMetrics();
        this.f57499s = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.m41377a(z, z2);
            }
        };
        this.f57500t = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.f57488h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView.this.f57487g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.f57488h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView.this.f57487g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f57501u = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.f57484d = flutterTextureView;
        this.f57482a = flutterTextureView;
        m41380b();
    }

    private FlutterView(Context context, AttributeSet attributeSet, FlutterImageView flutterImageView) {
        super(context, attributeSet);
        this.f57487g = new HashSet();
        this.f57490j = new HashSet();
        this.f57498r = new FlutterRenderer.ViewportMetrics();
        this.f57499s = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.m41377a(z, z2);
            }
        };
        this.f57500t = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.f57488h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView.this.f57487g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.f57488h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView.this.f57487g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f57501u = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.f57485e = flutterImageView;
        this.f57482a = flutterImageView;
        m41380b();
    }

    /* renamed from: b */
    private void m41380b() {
        Log.m41140v(f57481b, "Initializing FlutterView");
        if (this.f57483c != null) {
            Log.m41140v(f57481b, "Internally using a FlutterSurfaceView.");
            addView(this.f57483c);
        } else if (this.f57484d != null) {
            Log.m41140v(f57481b, "Internally using a FlutterTextureView.");
            addView(this.f57484d);
        } else {
            Log.m41140v(f57481b, "Internally using a FlutterImageView.");
            addView(this.f57485e);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(4);
        }
    }

    public boolean hasRenderedFirstFrame() {
        return this.f57488h;
    }

    public void addOnFirstFrameRenderedListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        this.f57487g.add(flutterUiDisplayListener);
    }

    public void removeOnFirstFrameRenderedListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        this.f57487g.remove(flutterUiDisplayListener);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f57489i != null) {
            Log.m41140v(f57481b, "Configuration changed. Sending locales and user settings to Flutter.");
            this.f57493m.sendLocalesToFlutter(configuration);
            mo172186a();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Log.m41140v(f57481b, "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i3 + " x " + i4 + ", it is now " + i + " x " + i2);
        this.f57498r.width = i;
        this.f57498r.height = i2;
        m41382d();
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
        this.f57497q = createWindowInfoRepo();
        Activity activity = ViewUtils.getActivity(getContext());
        WindowInfoRepositoryCallbackAdapterWrapper windowInfoRepositoryCallbackAdapterWrapper = this.f57497q;
        if (windowInfoRepositoryCallbackAdapterWrapper != null && activity != null) {
            windowInfoRepositoryCallbackAdapterWrapper.addWindowLayoutInfoListener(activity, ContextCompat.getMainExecutor(getContext()), this.f57501u);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        WindowInfoRepositoryCallbackAdapterWrapper windowInfoRepositoryCallbackAdapterWrapper = this.f57497q;
        if (windowInfoRepositoryCallbackAdapterWrapper != null) {
            windowInfoRepositoryCallbackAdapterWrapper.removeWindowLayoutInfoListener(this.f57501u);
        }
        this.f57497q = null;
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
            Log.m41140v(f57481b, "WindowInfoTracker Display Feature reported with bounds = " + next.getBounds().toString() + " and type = " + next.getClass().getSimpleName());
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
                Log.m41140v(f57481b, "DisplayCutout area reported with bounds = " + next2.toString());
                arrayList.add(new FlutterRenderer.DisplayFeature(next2, FlutterRenderer.DisplayFeatureType.CUTOUT));
            }
        }
        this.f57498r.displayFeatures = arrayList;
        m41382d();
    }

    /* renamed from: c */
    private ZeroSides m41381c() {
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
    private int m41373a(WindowInsets windowInsets) {
        if (((double) windowInsets.getSystemWindowInsetBottom()) < ((double) getRootView().getHeight()) * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        if (Build.VERSION.SDK_INT == 29) {
            Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
            this.f57498r.systemGestureInsetTop = systemGestureInsets.top;
            this.f57498r.systemGestureInsetRight = systemGestureInsets.right;
            this.f57498r.systemGestureInsetBottom = systemGestureInsets.bottom;
            this.f57498r.systemGestureInsetLeft = systemGestureInsets.left;
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
            this.f57498r.viewPaddingTop = insets.top;
            this.f57498r.viewPaddingRight = insets.right;
            this.f57498r.viewPaddingBottom = insets.bottom;
            this.f57498r.viewPaddingLeft = insets.left;
            Insets insets2 = windowInsets.getInsets(WindowInsets.Type.ime());
            this.f57498r.viewInsetTop = insets2.top;
            this.f57498r.viewInsetRight = insets2.right;
            this.f57498r.viewInsetBottom = insets2.bottom;
            this.f57498r.viewInsetLeft = insets2.left;
            Insets insets3 = windowInsets.getInsets(WindowInsets.Type.systemGestures());
            this.f57498r.systemGestureInsetTop = insets3.top;
            this.f57498r.systemGestureInsetRight = insets3.right;
            this.f57498r.systemGestureInsetBottom = insets3.bottom;
            this.f57498r.systemGestureInsetLeft = insets3.left;
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                Insets waterfallInsets = displayCutout.getWaterfallInsets();
                FlutterRenderer.ViewportMetrics viewportMetrics = this.f57498r;
                viewportMetrics.viewPaddingTop = Math.max(Math.max(viewportMetrics.viewPaddingTop, waterfallInsets.top), displayCutout.getSafeInsetTop());
                FlutterRenderer.ViewportMetrics viewportMetrics2 = this.f57498r;
                viewportMetrics2.viewPaddingRight = Math.max(Math.max(viewportMetrics2.viewPaddingRight, waterfallInsets.right), displayCutout.getSafeInsetRight());
                FlutterRenderer.ViewportMetrics viewportMetrics3 = this.f57498r;
                viewportMetrics3.viewPaddingBottom = Math.max(Math.max(viewportMetrics3.viewPaddingBottom, waterfallInsets.bottom), displayCutout.getSafeInsetBottom());
                FlutterRenderer.ViewportMetrics viewportMetrics4 = this.f57498r;
                viewportMetrics4.viewPaddingLeft = Math.max(Math.max(viewportMetrics4.viewPaddingLeft, waterfallInsets.left), displayCutout.getSafeInsetLeft());
            }
        } else {
            ZeroSides zeroSides = ZeroSides.NONE;
            if (!z) {
                zeroSides = m41381c();
            }
            this.f57498r.viewPaddingTop = z2 ? windowInsets.getSystemWindowInsetTop() : 0;
            this.f57498r.viewPaddingRight = (zeroSides == ZeroSides.RIGHT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.f57498r.viewPaddingBottom = (!z || m41373a(windowInsets) != 0) ? 0 : windowInsets.getSystemWindowInsetBottom();
            this.f57498r.viewPaddingLeft = (zeroSides == ZeroSides.LEFT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            this.f57498r.viewInsetTop = 0;
            this.f57498r.viewInsetRight = 0;
            this.f57498r.viewInsetBottom = m41373a(windowInsets);
            this.f57498r.viewInsetLeft = 0;
        }
        Log.m41140v(f57481b, "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.f57498r.viewPaddingTop + ", Left: " + this.f57498r.viewPaddingLeft + ", Right: " + this.f57498r.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.f57498r.viewInsetBottom + ", Left: " + this.f57498r.viewInsetLeft + ", Right: " + this.f57498r.viewInsetRight + "System Gesture Insets - Left: " + this.f57498r.systemGestureInsetLeft + ", Top: " + this.f57498r.systemGestureInsetTop + ", Right: " + this.f57498r.systemGestureInsetRight + ", Bottom: " + this.f57498r.viewInsetBottom);
        m41382d();
        return onApplyWindowInsets;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT > 19) {
            return super.fitSystemWindows(rect);
        }
        this.f57498r.viewPaddingTop = rect.top;
        this.f57498r.viewPaddingRight = rect.right;
        this.f57498r.viewPaddingBottom = 0;
        this.f57498r.viewPaddingLeft = rect.left;
        this.f57498r.viewInsetTop = 0;
        this.f57498r.viewInsetRight = 0;
        this.f57498r.viewInsetBottom = rect.bottom;
        this.f57498r.viewInsetLeft = 0;
        Log.m41140v(f57481b, "Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: " + this.f57498r.viewPaddingTop + ", Left: " + this.f57498r.viewPaddingLeft + ", Right: " + this.f57498r.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.f57498r.viewInsetBottom + ", Left: " + this.f57498r.viewInsetLeft + ", Right: " + this.f57498r.viewInsetRight);
        m41382d();
        return true;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (!isAttachedToFlutterEngine()) {
            return super.onCreateInputConnection(editorInfo);
        }
        return this.f57492l.createInputConnection(this, this.f57494n, editorInfo);
    }

    public boolean checkInputConnectionProxy(View view) {
        FlutterEngine flutterEngine = this.f57489i;
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
        if ((!isAttachedToFlutterEngine() || !this.f57494n.handleEvent(keyEvent)) && !super.dispatchKeyEvent(keyEvent)) {
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
        return this.f57495o.onTouchEvent(motionEvent);
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (isAttachedToFlutterEngine() && this.f57495o.onGenericMotionEvent(motionEvent)) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onHoverEvent(motionEvent);
        }
        return this.f57496p.onAccessibilityHoverEvent(motionEvent);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge = this.f57496p;
        if (accessibilityBridge == null || !accessibilityBridge.isAccessibilityEnabled()) {
            return null;
        }
        return this.f57496p;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View findViewByAccessibilityIdTraversal(int r8) {
        /*
            r7 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 >= r1) goto L_0x000b
            android.view.View r8 = r7.m41374a((int) r8, (android.view.View) r7)
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
        throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.embedding.android.FlutterView.findViewByAccessibilityIdTraversal(int):android.view.View");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View m41374a(int r6, android.view.View r7) {
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
            android.view.View r1 = r5.m41374a((int) r6, (android.view.View) r1)
            if (r1 == 0) goto L_0x0039
            return r1
        L_0x0039:
            int r3 = r3 + 1
            goto L_0x0025
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.embedding.android.FlutterView.m41374a(int, android.view.View):android.view.View");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41377a(boolean z, boolean z2) {
        boolean z3 = false;
        if (!this.f57489i.getRenderer().isSoftwareRenderingEnabled()) {
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
        Log.m41140v(f57481b, "Attaching to a FlutterEngine: " + flutterEngine);
        if (isAttachedToFlutterEngine()) {
            if (flutterEngine == this.f57489i) {
                Log.m41140v(f57481b, "Already attached to this engine. Doing nothing.");
                return;
            } else {
                Log.m41140v(f57481b, "Currently attached to a different engine. Detaching and then attaching to new engine.");
                detachFromFlutterEngine();
            }
        }
        this.f57489i = flutterEngine;
        FlutterRenderer renderer = flutterEngine.getRenderer();
        this.f57488h = renderer.isDisplayingFlutterUi();
        this.f57482a.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(this.f57500t);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f57491k = new MouseCursorPlugin(this, this.f57489i.getMouseCursorChannel());
        }
        this.f57492l = new TextInputPlugin(this, this.f57489i.getTextInputChannel(), this.f57489i.getPlatformViewsController());
        this.f57493m = this.f57489i.getLocalizationPlugin();
        this.f57494n = new KeyboardManager(this, this.f57492l, new KeyChannelResponder[]{new KeyChannelResponder(flutterEngine.getKeyEventChannel())});
        this.f57495o = new AndroidTouchProcessor(this.f57489i.getRenderer(), false);
        AccessibilityBridge accessibilityBridge = new AccessibilityBridge(this, flutterEngine.getAccessibilityChannel(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.f57489i.getPlatformViewsController());
        this.f57496p = accessibilityBridge;
        accessibilityBridge.setOnAccessibilityChangeListener(this.f57499s);
        m41377a(this.f57496p.isAccessibilityEnabled(), this.f57496p.isTouchExplorationEnabled());
        this.f57489i.getPlatformViewsController().attachAccessibilityBridge(this.f57496p);
        this.f57489i.getPlatformViewsController().attachToFlutterRenderer(this.f57489i.getRenderer());
        this.f57492l.getInputMethodManager().restartInput(this);
        mo172186a();
        this.f57493m.sendLocalesToFlutter(getResources().getConfiguration());
        m41382d();
        flutterEngine.getPlatformViewsController().attachToView(this);
        for (FlutterEngineAttachmentListener onFlutterEngineAttachedToFlutterView : this.f57490j) {
            onFlutterEngineAttachedToFlutterView.onFlutterEngineAttachedToFlutterView(flutterEngine);
        }
        if (this.f57488h) {
            this.f57500t.onFlutterUiDisplayed();
        }
    }

    public void detachFromFlutterEngine() {
        Log.m41140v(f57481b, "Detaching from a FlutterEngine: " + this.f57489i);
        if (!isAttachedToFlutterEngine()) {
            Log.m41140v(f57481b, "FlutterView not attached to an engine. Not detaching.");
            return;
        }
        for (FlutterEngineAttachmentListener onFlutterEngineDetachedFromFlutterView : this.f57490j) {
            onFlutterEngineDetachedFromFlutterView.onFlutterEngineDetachedFromFlutterView();
        }
        this.f57489i.getPlatformViewsController().detachFromView();
        this.f57489i.getPlatformViewsController().detachAccessibilityBridge();
        this.f57496p.release();
        this.f57496p = null;
        this.f57492l.getInputMethodManager().restartInput(this);
        this.f57492l.destroy();
        this.f57494n.destroy();
        MouseCursorPlugin mouseCursorPlugin = this.f57491k;
        if (mouseCursorPlugin != null) {
            mouseCursorPlugin.destroy();
        }
        FlutterRenderer renderer = this.f57489i.getRenderer();
        this.f57488h = false;
        renderer.removeIsDisplayingFlutterUiListener(this.f57500t);
        renderer.stopRenderingToSurface();
        renderer.setSemanticsEnabled(false);
        RenderSurface renderSurface = this.f57486f;
        if (renderSurface != null && this.f57482a == this.f57485e) {
            this.f57482a = renderSurface;
        }
        this.f57482a.detachFromRenderer();
        FlutterImageView flutterImageView = this.f57485e;
        if (flutterImageView != null) {
            flutterImageView.closeImageReader();
            this.f57485e = null;
        }
        this.f57486f = null;
        this.f57489i = null;
    }

    public FlutterImageView createImageView() {
        return new FlutterImageView(getContext(), getWidth(), getHeight(), FlutterImageView.SurfaceKind.background);
    }

    public void convertToImageView() {
        this.f57482a.pause();
        FlutterImageView flutterImageView = this.f57485e;
        if (flutterImageView == null) {
            FlutterImageView createImageView = createImageView();
            this.f57485e = createImageView;
            addView(createImageView);
        } else {
            flutterImageView.resizeIfNeeded(getWidth(), getHeight());
        }
        this.f57486f = this.f57482a;
        FlutterImageView flutterImageView2 = this.f57485e;
        this.f57482a = flutterImageView2;
        FlutterEngine flutterEngine = this.f57489i;
        if (flutterEngine != null) {
            flutterImageView2.attachToRenderer(flutterEngine.getRenderer());
        }
    }

    public void revertImageView(final Runnable runnable) {
        FlutterImageView flutterImageView = this.f57485e;
        if (flutterImageView == null) {
            Log.m41140v(f57481b, "Tried to revert the image view, but no image view is used.");
            return;
        }
        RenderSurface renderSurface = this.f57486f;
        if (renderSurface == null) {
            Log.m41140v(f57481b, "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        this.f57482a = renderSurface;
        this.f57486f = null;
        FlutterEngine flutterEngine = this.f57489i;
        if (flutterEngine == null) {
            flutterImageView.detachFromRenderer();
            runnable.run();
            return;
        }
        final FlutterRenderer renderer = flutterEngine.getRenderer();
        if (renderer == null) {
            this.f57485e.detachFromRenderer();
            runnable.run();
            return;
        }
        this.f57482a.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(new FlutterUiDisplayListener() {
            public void onFlutterUiNoLongerDisplayed() {
            }

            public void onFlutterUiDisplayed() {
                renderer.removeIsDisplayingFlutterUiListener(this);
                runnable.run();
                if (!(FlutterView.this.f57482a instanceof FlutterImageView)) {
                    FlutterView.this.f57485e.detachFromRenderer();
                }
            }
        });
    }

    public void attachOverlaySurfaceToRender(FlutterImageView flutterImageView) {
        FlutterEngine flutterEngine = this.f57489i;
        if (flutterEngine != null) {
            flutterImageView.attachToRenderer(flutterEngine.getRenderer());
        }
    }

    public boolean acquireLatestImageViewFrame() {
        FlutterImageView flutterImageView = this.f57485e;
        if (flutterImageView != null) {
            return flutterImageView.acquireLatestImage();
        }
        return false;
    }

    public boolean isAttachedToFlutterEngine() {
        FlutterEngine flutterEngine = this.f57489i;
        return flutterEngine != null && flutterEngine.getRenderer() == this.f57482a.getAttachedRenderer();
    }

    public FlutterEngine getAttachedFlutterEngine() {
        return this.f57489i;
    }

    public void addFlutterEngineAttachmentListener(FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.f57490j.add(flutterEngineAttachmentListener);
    }

    public void removeFlutterEngineAttachmentListener(FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.f57490j.remove(flutterEngineAttachmentListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo172186a() {
        SettingsChannel.PlatformBrightness platformBrightness;
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            platformBrightness = SettingsChannel.PlatformBrightness.dark;
        } else {
            platformBrightness = SettingsChannel.PlatformBrightness.light;
        }
        this.f57489i.getSettingsChannel().startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness(platformBrightness).send();
    }

    /* renamed from: d */
    private void m41382d() {
        if (!isAttachedToFlutterEngine()) {
            Log.m41142w(f57481b, "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.f57498r.devicePixelRatio = getResources().getDisplayMetrics().density;
        this.f57498r.physicalTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f57489i.getRenderer().setViewportMetrics(this.f57498r);
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        super.onProvideAutofillVirtualStructure(viewStructure, i);
        this.f57492l.onProvideAutofillVirtualStructure(viewStructure, i);
    }

    public void autofill(SparseArray<AutofillValue> sparseArray) {
        this.f57492l.autofill(sparseArray);
    }
}
