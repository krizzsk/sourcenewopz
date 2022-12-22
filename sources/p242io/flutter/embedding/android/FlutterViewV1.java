package p242io.flutter.embedding.android;

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
import java.util.HashSet;
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
import p242io.flutter.view.AccessibilityBridge;

/* renamed from: io.flutter.embedding.android.FlutterViewV1 */
public class FlutterViewV1 extends FrameLayout implements MouseCursorPlugin.MouseCursorViewDelegate {

    /* renamed from: a */
    private static final String f57525a = "FlutterView";

    /* renamed from: b */
    private FlutterSurfaceView f57526b;

    /* renamed from: c */
    private FlutterTextureView f57527c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FlutterImageView f57528d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public RenderSurface f57529e;

    /* renamed from: f */
    private RenderSurface f57530f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Set<FlutterUiDisplayListener> f57531g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f57532h;

    /* renamed from: i */
    private FlutterEngine f57533i;

    /* renamed from: j */
    private final Set<FlutterEngineAttachmentListener> f57534j;

    /* renamed from: k */
    private MouseCursorPlugin f57535k;

    /* renamed from: l */
    private TextInputPlugin f57536l;

    /* renamed from: m */
    private LocalizationPlugin f57537m;

    /* renamed from: n */
    private KeyboardManager f57538n;

    /* renamed from: o */
    private AndroidTouchProcessor f57539o;

    /* renamed from: p */
    private AccessibilityBridge f57540p;

    /* renamed from: q */
    private final FlutterRenderer.ViewportMetrics f57541q;

    /* renamed from: r */
    private final AccessibilityBridge.OnAccessibilityChangeListener f57542r;

    /* renamed from: s */
    private final FlutterUiDisplayListener f57543s;

    /* renamed from: io.flutter.embedding.android.FlutterViewV1$FlutterEngineAttachmentListener */
    public interface FlutterEngineAttachmentListener {
        void onFlutterEngineAttachedToFlutterView(FlutterEngine flutterEngine);

        void onFlutterEngineDetachedFromFlutterView();
    }

    @Deprecated
    /* renamed from: io.flutter.embedding.android.FlutterViewV1$RenderMode */
    public enum RenderMode {
        surface,
        texture,
        image
    }

    @Deprecated
    /* renamed from: io.flutter.embedding.android.FlutterViewV1$TransparencyMode */
    public enum TransparencyMode {
        opaque,
        transparent
    }

    /* renamed from: io.flutter.embedding.android.FlutterViewV1$ZeroSides */
    private enum ZeroSides {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    public FlutterViewV1(Context context) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context));
    }

    @Deprecated
    public FlutterViewV1(Context context, RenderMode renderMode) {
        super(context, (AttributeSet) null);
        this.f57531g = new HashSet();
        this.f57534j = new HashSet();
        this.f57541q = new FlutterRenderer.ViewportMetrics();
        this.f57542r = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterViewV1.this.m41399a(z, z2);
            }
        };
        this.f57543s = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterViewV1.this.f57532h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterViewV1.this.f57531g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterViewV1.this.f57532h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterViewV1.this.f57531g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context);
            this.f57526b = flutterSurfaceView;
            this.f57529e = flutterSurfaceView;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView = new FlutterTextureView(context);
            this.f57527c = flutterTextureView;
            this.f57529e = flutterTextureView;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[]{renderMode}));
        }
        m41402b();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public FlutterViewV1(Context context, TransparencyMode transparencyMode) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent));
    }

    public FlutterViewV1(Context context, FlutterSurfaceView flutterSurfaceView) {
        this(context, (AttributeSet) null, flutterSurfaceView);
    }

    public FlutterViewV1(Context context, FlutterTextureView flutterTextureView) {
        this(context, (AttributeSet) null, flutterTextureView);
    }

    public FlutterViewV1(Context context, FlutterImageView flutterImageView) {
        this(context, (AttributeSet) null, flutterImageView);
    }

    public FlutterViewV1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new FlutterSurfaceView(context));
    }

    @Deprecated
    public FlutterViewV1(Context context, RenderMode renderMode, TransparencyMode transparencyMode) {
        super(context, (AttributeSet) null);
        this.f57531g = new HashSet();
        this.f57534j = new HashSet();
        this.f57541q = new FlutterRenderer.ViewportMetrics();
        this.f57542r = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterViewV1.this.m41399a(z, z2);
            }
        };
        this.f57543s = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterViewV1.this.f57532h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterViewV1.this.f57531g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterViewV1.this.f57532h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterViewV1.this.f57531g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        boolean z = false;
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent ? true : z);
            this.f57526b = flutterSurfaceView;
            this.f57529e = flutterSurfaceView;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView = new FlutterTextureView(context);
            this.f57527c = flutterTextureView;
            this.f57529e = flutterTextureView;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[]{renderMode}));
        }
        m41402b();
    }

    private FlutterViewV1(Context context, AttributeSet attributeSet, FlutterSurfaceView flutterSurfaceView) {
        super(context, attributeSet);
        this.f57531g = new HashSet();
        this.f57534j = new HashSet();
        this.f57541q = new FlutterRenderer.ViewportMetrics();
        this.f57542r = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterViewV1.this.m41399a(z, z2);
            }
        };
        this.f57543s = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterViewV1.this.f57532h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterViewV1.this.f57531g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterViewV1.this.f57532h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterViewV1.this.f57531g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f57526b = flutterSurfaceView;
        this.f57529e = flutterSurfaceView;
        m41402b();
    }

    private FlutterViewV1(Context context, AttributeSet attributeSet, FlutterTextureView flutterTextureView) {
        super(context, attributeSet);
        this.f57531g = new HashSet();
        this.f57534j = new HashSet();
        this.f57541q = new FlutterRenderer.ViewportMetrics();
        this.f57542r = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterViewV1.this.m41399a(z, z2);
            }
        };
        this.f57543s = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterViewV1.this.f57532h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterViewV1.this.f57531g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterViewV1.this.f57532h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterViewV1.this.f57531g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f57527c = flutterTextureView;
        this.f57529e = flutterTextureView;
        m41402b();
    }

    private FlutterViewV1(Context context, AttributeSet attributeSet, FlutterImageView flutterImageView) {
        super(context, attributeSet);
        this.f57531g = new HashSet();
        this.f57534j = new HashSet();
        this.f57541q = new FlutterRenderer.ViewportMetrics();
        this.f57542r = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterViewV1.this.m41399a(z, z2);
            }
        };
        this.f57543s = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterViewV1.this.f57532h = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterViewV1.this.f57531g) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterViewV1.this.f57532h = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterViewV1.this.f57531g) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.f57528d = flutterImageView;
        this.f57529e = flutterImageView;
        m41402b();
    }

    /* renamed from: b */
    private void m41402b() {
        Log.m41140v(f57525a, "Initializing FlutterView");
        if (this.f57526b != null) {
            Log.m41140v(f57525a, "Internally using a FlutterSurfaceView.");
            addView(this.f57526b);
        } else if (this.f57527c != null) {
            Log.m41140v(f57525a, "Internally using a FlutterTextureView.");
            addView(this.f57527c);
        } else {
            Log.m41140v(f57525a, "Internally using a FlutterImageView.");
            addView(this.f57528d);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(4);
        }
    }

    public boolean hasRenderedFirstFrame() {
        return this.f57532h;
    }

    public void addOnFirstFrameRenderedListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        this.f57531g.add(flutterUiDisplayListener);
    }

    public void removeOnFirstFrameRenderedListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        this.f57531g.remove(flutterUiDisplayListener);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f57533i != null) {
            Log.m41140v(f57525a, "Configuration changed. Sending locales and user settings to Flutter.");
            this.f57537m.sendLocalesToFlutter(configuration);
            mo172263a();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Log.m41140v(f57525a, "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i3 + " x " + i4 + ", it is now " + i + " x " + i2);
        this.f57541q.width = i;
        this.f57541q.height = i2;
        m41405d();
    }

    /* renamed from: c */
    private ZeroSides m41404c() {
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
    private int m41395a(WindowInsets windowInsets) {
        if (((double) windowInsets.getSystemWindowInsetBottom()) < ((double) getRootView().getHeight()) * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        if (Build.VERSION.SDK_INT == 29) {
            Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
            this.f57541q.systemGestureInsetTop = systemGestureInsets.top;
            this.f57541q.systemGestureInsetRight = systemGestureInsets.right;
            this.f57541q.systemGestureInsetBottom = systemGestureInsets.bottom;
            this.f57541q.systemGestureInsetLeft = systemGestureInsets.left;
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
            this.f57541q.viewPaddingTop = insets.top;
            this.f57541q.viewPaddingRight = insets.right;
            this.f57541q.viewPaddingBottom = insets.bottom;
            this.f57541q.viewPaddingLeft = insets.left;
            Insets insets2 = windowInsets.getInsets(WindowInsets.Type.ime());
            this.f57541q.viewInsetTop = insets2.top;
            this.f57541q.viewInsetRight = insets2.right;
            this.f57541q.viewInsetBottom = insets2.bottom;
            this.f57541q.viewInsetLeft = insets2.left;
            Insets insets3 = windowInsets.getInsets(WindowInsets.Type.systemGestures());
            this.f57541q.systemGestureInsetTop = insets3.top;
            this.f57541q.systemGestureInsetRight = insets3.right;
            this.f57541q.systemGestureInsetBottom = insets3.bottom;
            this.f57541q.systemGestureInsetLeft = insets3.left;
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                Insets waterfallInsets = displayCutout.getWaterfallInsets();
                FlutterRenderer.ViewportMetrics viewportMetrics = this.f57541q;
                viewportMetrics.viewPaddingTop = Math.max(Math.max(viewportMetrics.viewPaddingTop, waterfallInsets.top), displayCutout.getSafeInsetTop());
                FlutterRenderer.ViewportMetrics viewportMetrics2 = this.f57541q;
                viewportMetrics2.viewPaddingRight = Math.max(Math.max(viewportMetrics2.viewPaddingRight, waterfallInsets.right), displayCutout.getSafeInsetRight());
                FlutterRenderer.ViewportMetrics viewportMetrics3 = this.f57541q;
                viewportMetrics3.viewPaddingBottom = Math.max(Math.max(viewportMetrics3.viewPaddingBottom, waterfallInsets.bottom), displayCutout.getSafeInsetBottom());
                FlutterRenderer.ViewportMetrics viewportMetrics4 = this.f57541q;
                viewportMetrics4.viewPaddingLeft = Math.max(Math.max(viewportMetrics4.viewPaddingLeft, waterfallInsets.left), displayCutout.getSafeInsetLeft());
            }
        } else {
            ZeroSides zeroSides = ZeroSides.NONE;
            if (!z) {
                zeroSides = m41404c();
            }
            this.f57541q.viewPaddingTop = z2 ? windowInsets.getSystemWindowInsetTop() : 0;
            this.f57541q.viewPaddingRight = (zeroSides == ZeroSides.RIGHT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.f57541q.viewPaddingBottom = (!z || m41395a(windowInsets) != 0) ? 0 : windowInsets.getSystemWindowInsetBottom();
            this.f57541q.viewPaddingLeft = (zeroSides == ZeroSides.LEFT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            this.f57541q.viewInsetTop = 0;
            this.f57541q.viewInsetRight = 0;
            this.f57541q.viewInsetBottom = m41395a(windowInsets);
            this.f57541q.viewInsetLeft = 0;
        }
        Log.m41140v(f57525a, "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.f57541q.viewPaddingTop + ", Left: " + this.f57541q.viewPaddingLeft + ", Right: " + this.f57541q.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.f57541q.viewInsetBottom + ", Left: " + this.f57541q.viewInsetLeft + ", Right: " + this.f57541q.viewInsetRight + "System Gesture Insets - Left: " + this.f57541q.systemGestureInsetLeft + ", Top: " + this.f57541q.systemGestureInsetTop + ", Right: " + this.f57541q.systemGestureInsetRight + ", Bottom: " + this.f57541q.viewInsetBottom);
        m41405d();
        return onApplyWindowInsets;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT > 19) {
            return super.fitSystemWindows(rect);
        }
        this.f57541q.viewPaddingTop = rect.top;
        this.f57541q.viewPaddingRight = rect.right;
        this.f57541q.viewPaddingBottom = 0;
        this.f57541q.viewPaddingLeft = rect.left;
        this.f57541q.viewInsetTop = 0;
        this.f57541q.viewInsetRight = 0;
        this.f57541q.viewInsetBottom = rect.bottom;
        this.f57541q.viewInsetLeft = 0;
        Log.m41140v(f57525a, "Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: " + this.f57541q.viewPaddingTop + ", Left: " + this.f57541q.viewPaddingLeft + ", Right: " + this.f57541q.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.f57541q.viewInsetBottom + ", Left: " + this.f57541q.viewInsetLeft + ", Right: " + this.f57541q.viewInsetRight);
        m41405d();
        return true;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (!isAttachedToFlutterEngine()) {
            return super.onCreateInputConnection(editorInfo);
        }
        return this.f57536l.createInputConnection(this, this.f57538n, editorInfo);
    }

    public boolean checkInputConnectionProxy(View view) {
        FlutterEngine flutterEngine = this.f57533i;
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
        if ((!isAttachedToFlutterEngine() || !this.f57538n.handleEvent(keyEvent)) && !super.dispatchKeyEvent(keyEvent)) {
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
        return this.f57539o.onTouchEvent(motionEvent);
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (isAttachedToFlutterEngine() && this.f57539o.onGenericMotionEvent(motionEvent)) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onHoverEvent(motionEvent);
        }
        return this.f57540p.onAccessibilityHoverEvent(motionEvent);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge = this.f57540p;
        if (accessibilityBridge == null || !accessibilityBridge.isAccessibilityEnabled()) {
            return null;
        }
        return this.f57540p;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View findViewByAccessibilityIdTraversal(int r8) {
        /*
            r7 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 >= r1) goto L_0x000b
            android.view.View r8 = r7.m41396a((int) r8, (android.view.View) r7)
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
        throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.embedding.android.FlutterViewV1.findViewByAccessibilityIdTraversal(int):android.view.View");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View m41396a(int r6, android.view.View r7) {
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
            android.view.View r1 = r5.m41396a((int) r6, (android.view.View) r1)
            if (r1 == 0) goto L_0x0039
            return r1
        L_0x0039:
            int r3 = r3 + 1
            goto L_0x0025
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.flutter.embedding.android.FlutterViewV1.m41396a(int, android.view.View):android.view.View");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41399a(boolean z, boolean z2) {
        boolean z3 = false;
        if (!this.f57533i.getRenderer().isSoftwareRenderingEnabled()) {
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
        Log.m41140v(f57525a, "Attaching to a FlutterEngine: " + flutterEngine);
        if (isAttachedToFlutterEngine()) {
            if (flutterEngine == this.f57533i) {
                Log.m41140v(f57525a, "Already attached to this engine. Doing nothing.");
                return;
            } else {
                Log.m41140v(f57525a, "Currently attached to a different engine. Detaching and then attaching to new engine.");
                detachFromFlutterEngine();
            }
        }
        this.f57533i = flutterEngine;
        FlutterRenderer renderer = flutterEngine.getRenderer();
        this.f57532h = renderer.isDisplayingFlutterUi();
        this.f57529e.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(this.f57543s);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f57535k = new MouseCursorPlugin(this, this.f57533i.getMouseCursorChannel());
        }
        this.f57536l = new TextInputPlugin(this, this.f57533i.getTextInputChannel(), this.f57533i.getPlatformViewsController());
        this.f57537m = this.f57533i.getLocalizationPlugin();
        this.f57538n = new KeyboardManager(this, this.f57536l, new KeyChannelResponder[]{new KeyChannelResponder(flutterEngine.getKeyEventChannel())});
        this.f57539o = new AndroidTouchProcessor(this.f57533i.getRenderer(), false);
        AccessibilityBridge accessibilityBridge = new AccessibilityBridge(this, flutterEngine.getAccessibilityChannel(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.f57533i.getPlatformViewsController());
        this.f57540p = accessibilityBridge;
        accessibilityBridge.setOnAccessibilityChangeListener(this.f57542r);
        m41399a(this.f57540p.isAccessibilityEnabled(), this.f57540p.isTouchExplorationEnabled());
        this.f57533i.getPlatformViewsController().attachAccessibilityBridge(this.f57540p);
        this.f57533i.getPlatformViewsController().attachToFlutterRenderer(this.f57533i.getRenderer());
        this.f57536l.getInputMethodManager().restartInput(this);
        mo172263a();
        this.f57537m.sendLocalesToFlutter(getResources().getConfiguration());
        m41405d();
        for (FlutterEngineAttachmentListener onFlutterEngineAttachedToFlutterView : this.f57534j) {
            onFlutterEngineAttachedToFlutterView.onFlutterEngineAttachedToFlutterView(flutterEngine);
        }
        if (this.f57532h) {
            this.f57543s.onFlutterUiDisplayed();
        }
    }

    public void detachFromFlutterEngine() {
        Log.m41140v(f57525a, "Detaching from a FlutterEngine: " + this.f57533i);
        if (!isAttachedToFlutterEngine()) {
            Log.m41140v(f57525a, "FlutterView not attached to an engine. Not detaching.");
            return;
        }
        for (FlutterEngineAttachmentListener onFlutterEngineDetachedFromFlutterView : this.f57534j) {
            onFlutterEngineDetachedFromFlutterView.onFlutterEngineDetachedFromFlutterView();
        }
        this.f57533i.getPlatformViewsController().detachFromView();
        this.f57540p.release();
        this.f57540p = null;
        this.f57536l.getInputMethodManager().restartInput(this);
        this.f57536l.destroy();
        this.f57538n.destroy();
        MouseCursorPlugin mouseCursorPlugin = this.f57535k;
        if (mouseCursorPlugin != null) {
            mouseCursorPlugin.destroy();
        }
        FlutterRenderer renderer = this.f57533i.getRenderer();
        this.f57532h = false;
        renderer.removeIsDisplayingFlutterUiListener(this.f57543s);
        renderer.stopRenderingToSurface();
        renderer.setSemanticsEnabled(false);
        this.f57529e.detachFromRenderer();
        this.f57528d = null;
        this.f57530f = null;
        this.f57533i = null;
    }

    public FlutterImageView createImageView() {
        return new FlutterImageView(getContext(), getWidth(), getHeight(), FlutterImageView.SurfaceKind.background);
    }

    public void convertToImageView() {
        this.f57529e.pause();
        FlutterImageView flutterImageView = this.f57528d;
        if (flutterImageView == null) {
            FlutterImageView createImageView = createImageView();
            this.f57528d = createImageView;
            addView(createImageView);
        } else {
            flutterImageView.resizeIfNeeded(getWidth(), getHeight());
        }
        this.f57530f = this.f57529e;
        FlutterImageView flutterImageView2 = this.f57528d;
        this.f57529e = flutterImageView2;
        FlutterEngine flutterEngine = this.f57533i;
        if (flutterEngine != null) {
            flutterImageView2.attachToRenderer(flutterEngine.getRenderer());
        }
    }

    public void revertImageView(final Runnable runnable) {
        FlutterImageView flutterImageView = this.f57528d;
        if (flutterImageView == null) {
            Log.m41140v(f57525a, "Tried to revert the image view, but no image view is used.");
            return;
        }
        RenderSurface renderSurface = this.f57530f;
        if (renderSurface == null) {
            Log.m41140v(f57525a, "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        this.f57529e = renderSurface;
        this.f57530f = null;
        FlutterEngine flutterEngine = this.f57533i;
        if (flutterEngine == null) {
            flutterImageView.detachFromRenderer();
            runnable.run();
            return;
        }
        final FlutterRenderer renderer = flutterEngine.getRenderer();
        if (renderer == null) {
            this.f57528d.detachFromRenderer();
            runnable.run();
            return;
        }
        this.f57529e.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(new FlutterUiDisplayListener() {
            public void onFlutterUiNoLongerDisplayed() {
            }

            public void onFlutterUiDisplayed() {
                renderer.removeIsDisplayingFlutterUiListener(this);
                runnable.run();
                if (!(FlutterViewV1.this.f57529e instanceof FlutterImageView)) {
                    FlutterViewV1.this.f57528d.detachFromRenderer();
                }
            }
        });
    }

    public void attachOverlaySurfaceToRender(FlutterImageView flutterImageView) {
        FlutterEngine flutterEngine = this.f57533i;
        if (flutterEngine != null) {
            flutterImageView.attachToRenderer(flutterEngine.getRenderer());
        }
    }

    public boolean acquireLatestImageViewFrame() {
        FlutterImageView flutterImageView = this.f57528d;
        if (flutterImageView != null) {
            return flutterImageView.acquireLatestImage();
        }
        return false;
    }

    public boolean isAttachedToFlutterEngine() {
        FlutterEngine flutterEngine = this.f57533i;
        return flutterEngine != null && flutterEngine.getRenderer() == this.f57529e.getAttachedRenderer();
    }

    public FlutterEngine getAttachedFlutterEngine() {
        return this.f57533i;
    }

    public void addFlutterEngineAttachmentListener(FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.f57534j.add(flutterEngineAttachmentListener);
    }

    public void removeFlutterEngineAttachmentListener(FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.f57534j.remove(flutterEngineAttachmentListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo172263a() {
        SettingsChannel.PlatformBrightness platformBrightness;
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            platformBrightness = SettingsChannel.PlatformBrightness.dark;
        } else {
            platformBrightness = SettingsChannel.PlatformBrightness.light;
        }
        this.f57533i.getSettingsChannel().startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness(platformBrightness).send();
    }

    /* renamed from: d */
    private void m41405d() {
        if (!isAttachedToFlutterEngine()) {
            Log.m41142w(f57525a, "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.f57541q.devicePixelRatio = getResources().getDisplayMetrics().density;
        this.f57541q.physicalTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f57533i.getRenderer().setViewportMetrics(this.f57541q);
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        super.onProvideAutofillVirtualStructure(viewStructure, i);
        this.f57536l.onProvideAutofillVirtualStructure(viewStructure, i);
    }

    public void autofill(SparseArray<AutofillValue> sparseArray) {
        this.f57536l.autofill(sparseArray);
    }

    public void attachToRenderer() {
        RenderSurface renderSurface = this.f57529e;
        if ((renderSurface != null && renderSurface.getAttachedRenderer() == null) || !this.f57529e.getAttachedRenderer().isDisplayingFlutterUi()) {
            this.f57529e.attachToRenderer(this.f57533i.getRenderer());
        }
    }

    public void detachFromRenderer() {
        this.f57529e.detachFromRenderer();
    }
}
