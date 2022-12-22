package p242io.flutter.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
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
import android.view.inputmethod.InputMethodManager;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import p242io.flutter.Log;
import p242io.flutter.app.FlutterPluginRegistry;
import p242io.flutter.embedding.android.AndroidTouchProcessor;
import p242io.flutter.embedding.android.KeyChannelResponder;
import p242io.flutter.embedding.android.KeyboardManager;
import p242io.flutter.embedding.engine.dart.DartExecutor;
import p242io.flutter.embedding.engine.renderer.FlutterRenderer;
import p242io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import p242io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import p242io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import p242io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import p242io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import p242io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import p242io.flutter.embedding.engine.systemchannels.NavigationChannel;
import p242io.flutter.embedding.engine.systemchannels.PlatformChannel;
import p242io.flutter.embedding.engine.systemchannels.SettingsChannel;
import p242io.flutter.embedding.engine.systemchannels.SystemChannel;
import p242io.flutter.embedding.engine.systemchannels.TextInputChannel;
import p242io.flutter.plugin.common.ActivityLifecycleListener;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.editing.TextInputPlugin;
import p242io.flutter.plugin.localization.LocalizationPlugin;
import p242io.flutter.plugin.mouse.MouseCursorPlugin;
import p242io.flutter.plugin.platform.PlatformPlugin;
import p242io.flutter.plugin.platform.PlatformViewsController;
import p242io.flutter.util.ViewUtils;
import p242io.flutter.view.AccessibilityBridge;
import p242io.flutter.view.TextureRegistry;

@Deprecated
/* renamed from: io.flutter.view.FlutterView */
public class FlutterView extends SurfaceView implements BinaryMessenger, MouseCursorPlugin.MouseCursorViewDelegate, TextureRegistry {

    /* renamed from: a */
    private static final String f57970a = "FlutterView";

    /* renamed from: b */
    private final DartExecutor f57971b;

    /* renamed from: c */
    private final FlutterRenderer f57972c;

    /* renamed from: d */
    private final NavigationChannel f57973d;

    /* renamed from: e */
    private final KeyEventChannel f57974e;

    /* renamed from: f */
    private final LifecycleChannel f57975f;

    /* renamed from: g */
    private final LocalizationChannel f57976g;

    /* renamed from: h */
    private final PlatformChannel f57977h;

    /* renamed from: i */
    private final SettingsChannel f57978i;

    /* renamed from: j */
    private final SystemChannel f57979j;

    /* renamed from: k */
    private final InputMethodManager f57980k;

    /* renamed from: l */
    private final TextInputPlugin f57981l;

    /* renamed from: m */
    private final LocalizationPlugin f57982m;

    /* renamed from: n */
    private final MouseCursorPlugin f57983n;

    /* renamed from: o */
    private final KeyboardManager f57984o;

    /* renamed from: p */
    private final AndroidTouchProcessor f57985p;

    /* renamed from: q */
    private AccessibilityBridge f57986q;

    /* renamed from: r */
    private final SurfaceHolder.Callback f57987r;

    /* renamed from: s */
    private final ViewportMetrics f57988s;

    /* renamed from: t */
    private final List<ActivityLifecycleListener> f57989t;

    /* renamed from: u */
    private final List<FirstFrameListener> f57990u;

    /* renamed from: v */
    private final AtomicLong f57991v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public FlutterNativeView f57992w;

    /* renamed from: x */
    private boolean f57993x;

    /* renamed from: y */
    private boolean f57994y;

    /* renamed from: z */
    private final AccessibilityBridge.OnAccessibilityChangeListener f57995z;

    /* renamed from: io.flutter.view.FlutterView$FirstFrameListener */
    public interface FirstFrameListener {
        void onFirstFrame();
    }

    /* renamed from: io.flutter.view.FlutterView$Provider */
    public interface Provider {
        FlutterView getFlutterView();
    }

    /* renamed from: io.flutter.view.FlutterView$ZeroSides */
    private enum ZeroSides {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    /* renamed from: g */
    private void m41759g() {
    }

    public void disableBufferingIncomingMessages() {
    }

    public void enableBufferingIncomingMessages() {
    }

    public /* synthetic */ BinaryMessenger.TaskQueue makeBackgroundTaskQueue() {
        return BinaryMessenger.CC.$default$makeBackgroundTaskQueue(this);
    }

    public BinaryMessenger.TaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
        return null;
    }

    /* renamed from: io.flutter.view.FlutterView$ViewportMetrics */
    static final class ViewportMetrics {
        float devicePixelRatio = 1.0f;
        int physicalHeight = 0;
        int physicalTouchSlop = -1;
        int physicalViewInsetBottom = 0;
        int physicalViewInsetLeft = 0;
        int physicalViewInsetRight = 0;
        int physicalViewInsetTop = 0;
        int physicalViewPaddingBottom = 0;
        int physicalViewPaddingLeft = 0;
        int physicalViewPaddingRight = 0;
        int physicalViewPaddingTop = 0;
        int physicalWidth = 0;
        int systemGestureInsetBottom = 0;
        int systemGestureInsetLeft = 0;
        int systemGestureInsetRight = 0;
        int systemGestureInsetTop = 0;

        ViewportMetrics() {
        }
    }

    public FlutterView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FlutterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (FlutterNativeView) null);
    }

    public FlutterView(Context context, AttributeSet attributeSet, FlutterNativeView flutterNativeView) {
        super(context, attributeSet);
        this.f57991v = new AtomicLong(0);
        this.f57993x = false;
        this.f57994y = false;
        this.f57995z = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.m41754a(z, z2);
            }
        };
        Activity activity = ViewUtils.getActivity(getContext());
        if (activity != null) {
            if (flutterNativeView == null) {
                this.f57992w = new FlutterNativeView(activity.getApplicationContext());
            } else {
                this.f57992w = flutterNativeView;
            }
            this.f57971b = this.f57992w.getDartExecutor();
            this.f57972c = new FlutterRenderer(this.f57992w.mo172958a());
            this.f57993x = this.f57992w.mo172958a().getIsSoftwareRenderingEnabled();
            ViewportMetrics viewportMetrics = new ViewportMetrics();
            this.f57988s = viewportMetrics;
            viewportMetrics.devicePixelRatio = context.getResources().getDisplayMetrics().density;
            this.f57988s.physicalTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
            setFocusable(true);
            setFocusableInTouchMode(true);
            this.f57992w.attachViewAndActivity(this, activity);
            this.f57987r = new SurfaceHolder.Callback() {
                public void surfaceCreated(SurfaceHolder surfaceHolder) {
                    FlutterView.this.mo172968a();
                    FlutterView.this.f57992w.mo172958a().onSurfaceCreated(surfaceHolder.getSurface());
                }

                public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                    FlutterView.this.mo172968a();
                    FlutterView.this.f57992w.mo172958a().onSurfaceChanged(i2, i3);
                }

                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    FlutterView.this.mo172968a();
                    FlutterView.this.f57992w.mo172958a().onSurfaceDestroyed();
                }
            };
            getHolder().addCallback(this.f57987r);
            this.f57989t = new ArrayList();
            this.f57990u = new ArrayList();
            this.f57973d = new NavigationChannel(this.f57971b);
            this.f57974e = new KeyEventChannel(this.f57971b);
            this.f57975f = new LifecycleChannel(this.f57971b);
            this.f57976g = new LocalizationChannel(this.f57971b);
            this.f57977h = new PlatformChannel(this.f57971b);
            this.f57979j = new SystemChannel(this.f57971b);
            this.f57978i = new SettingsChannel(this.f57971b);
            final PlatformPlugin platformPlugin = new PlatformPlugin(activity, this.f57977h);
            addActivityLifecycleListener(new ActivityLifecycleListener() {
                public void onPostResume() {
                    platformPlugin.updateSystemUiOverlays();
                }
            });
            this.f57980k = (InputMethodManager) getContext().getSystemService("input_method");
            PlatformViewsController platformViewsController = this.f57992w.getPluginRegistry().getPlatformViewsController();
            TextInputPlugin textInputPlugin = new TextInputPlugin(this, new TextInputChannel(this.f57971b), platformViewsController);
            this.f57981l = textInputPlugin;
            this.f57984o = new KeyboardManager(this, textInputPlugin, new KeyChannelResponder[]{new KeyChannelResponder(this.f57974e)});
            if (Build.VERSION.SDK_INT >= 24) {
                this.f57983n = new MouseCursorPlugin(this, new MouseCursorChannel(this.f57971b));
            } else {
                this.f57983n = null;
            }
            this.f57982m = new LocalizationPlugin(context, this.f57976g);
            this.f57985p = new AndroidTouchProcessor(this.f57972c, false);
            platformViewsController.attachToFlutterRenderer(this.f57972c);
            this.f57992w.getPluginRegistry().getPlatformViewsController().attachTextInputPlugin(this.f57981l);
            this.f57992w.mo172958a().setLocalizationPlugin(this.f57982m);
            this.f57982m.sendLocalesToFlutter(getResources().getConfiguration());
            m41755c();
            return;
        }
        throw new IllegalArgumentException("Bad context");
    }

    public DartExecutor getDartExecutor() {
        return this.f57971b;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Log.m41136e(f57970a, "dispatchKeyEvent: " + keyEvent.toString());
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        if ((!m41757e() || !this.f57984o.handleEvent(keyEvent)) && !super.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    public FlutterNativeView getFlutterNativeView() {
        return this.f57992w;
    }

    public FlutterPluginRegistry getPluginRegistry() {
        return this.f57992w.getPluginRegistry();
    }

    public String getLookupKeyForAsset(String str) {
        return FlutterMain.getLookupKeyForAsset(str);
    }

    public String getLookupKeyForAsset(String str, String str2) {
        return FlutterMain.getLookupKeyForAsset(str, str2);
    }

    public void addActivityLifecycleListener(ActivityLifecycleListener activityLifecycleListener) {
        this.f57989t.add(activityLifecycleListener);
    }

    public void onStart() {
        this.f57975f.appIsInactive();
    }

    public void onPause() {
        this.f57975f.appIsInactive();
    }

    public void onPostResume() {
        for (ActivityLifecycleListener onPostResume : this.f57989t) {
            onPostResume.onPostResume();
        }
        this.f57975f.appIsResumed();
    }

    public void onStop() {
        this.f57975f.appIsPaused();
    }

    public void onMemoryPressure() {
        this.f57992w.mo172958a().notifyLowMemoryWarning();
        this.f57979j.sendMemoryPressureWarning();
    }

    public boolean hasRenderedFirstFrame() {
        return this.f57994y;
    }

    public void addFirstFrameListener(FirstFrameListener firstFrameListener) {
        this.f57990u.add(firstFrameListener);
    }

    public void removeFirstFrameListener(FirstFrameListener firstFrameListener) {
        this.f57990u.remove(firstFrameListener);
    }

    public void disableTransparentBackground() {
        setZOrderOnTop(false);
        getHolder().setFormat(-1);
    }

    public void setInitialRoute(String str) {
        this.f57973d.setInitialRoute(str);
    }

    public void pushRoute(String str) {
        this.f57973d.pushRoute(str);
    }

    public void popRoute() {
        this.f57973d.popRoute();
    }

    /* renamed from: c */
    private void m41755c() {
        SettingsChannel.PlatformBrightness platformBrightness;
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            platformBrightness = SettingsChannel.PlatformBrightness.dark;
        } else {
            platformBrightness = SettingsChannel.PlatformBrightness.light;
        }
        this.f57978i.startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness(platformBrightness).send();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f57982m.sendLocalesToFlutter(configuration);
        m41755c();
    }

    /* access modifiers changed from: package-private */
    public float getDevicePixelRatio() {
        return this.f57988s.devicePixelRatio;
    }

    public FlutterNativeView detach() {
        if (!m41757e()) {
            return null;
        }
        getHolder().removeCallback(this.f57987r);
        this.f57992w.detachFromFlutterView();
        FlutterNativeView flutterNativeView = this.f57992w;
        this.f57992w = null;
        return flutterNativeView;
    }

    public void destroy() {
        if (m41757e()) {
            getHolder().removeCallback(this.f57987r);
            m41761i();
            this.f57992w.destroy();
            this.f57992w = null;
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f57981l.createInputConnection(this, this.f57984o, editorInfo);
    }

    public boolean checkInputConnectionProxy(View view) {
        return this.f57992w.getPluginRegistry().getPlatformViewsController().checkInputConnectionProxy(view);
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        super.onProvideAutofillVirtualStructure(viewStructure, i);
        this.f57981l.onProvideAutofillVirtualStructure(viewStructure, i);
    }

    public void autofill(SparseArray<AutofillValue> sparseArray) {
        this.f57981l.autofill(sparseArray);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!m41757e()) {
            return super.onTouchEvent(motionEvent);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            requestUnbufferedDispatch(motionEvent);
        }
        return this.f57985p.onTouchEvent(motionEvent);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (!m41757e()) {
            return super.onHoverEvent(motionEvent);
        }
        return this.f57986q.onAccessibilityHoverEvent(motionEvent);
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (m41757e() && this.f57985p.onGenericMotionEvent(motionEvent)) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f57988s.physicalWidth = i;
        this.f57988s.physicalHeight = i2;
        m41760h();
        super.onSizeChanged(i, i2, i3, i4);
    }

    /* renamed from: d */
    private ZeroSides m41756d() {
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
    private int m41751a(WindowInsets windowInsets) {
        if (((double) windowInsets.getSystemWindowInsetBottom()) < ((double) getRootView().getHeight()) * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT == 29) {
            Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
            this.f57988s.systemGestureInsetTop = systemGestureInsets.top;
            this.f57988s.systemGestureInsetRight = systemGestureInsets.right;
            this.f57988s.systemGestureInsetBottom = systemGestureInsets.bottom;
            this.f57988s.systemGestureInsetLeft = systemGestureInsets.left;
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
            this.f57988s.physicalViewPaddingTop = insets.top;
            this.f57988s.physicalViewPaddingRight = insets.right;
            this.f57988s.physicalViewPaddingBottom = insets.bottom;
            this.f57988s.physicalViewPaddingLeft = insets.left;
            Insets insets2 = windowInsets.getInsets(WindowInsets.Type.ime());
            this.f57988s.physicalViewInsetTop = insets2.top;
            this.f57988s.physicalViewInsetRight = insets2.right;
            this.f57988s.physicalViewInsetBottom = insets2.bottom;
            this.f57988s.physicalViewInsetLeft = insets2.left;
            Insets insets3 = windowInsets.getInsets(WindowInsets.Type.systemGestures());
            this.f57988s.systemGestureInsetTop = insets3.top;
            this.f57988s.systemGestureInsetRight = insets3.right;
            this.f57988s.systemGestureInsetBottom = insets3.bottom;
            this.f57988s.systemGestureInsetLeft = insets3.left;
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                Insets waterfallInsets = displayCutout.getWaterfallInsets();
                ViewportMetrics viewportMetrics = this.f57988s;
                viewportMetrics.physicalViewPaddingTop = Math.max(Math.max(viewportMetrics.physicalViewPaddingTop, waterfallInsets.top), displayCutout.getSafeInsetTop());
                ViewportMetrics viewportMetrics2 = this.f57988s;
                viewportMetrics2.physicalViewPaddingRight = Math.max(Math.max(viewportMetrics2.physicalViewPaddingRight, waterfallInsets.right), displayCutout.getSafeInsetRight());
                ViewportMetrics viewportMetrics3 = this.f57988s;
                viewportMetrics3.physicalViewPaddingBottom = Math.max(Math.max(viewportMetrics3.physicalViewPaddingBottom, waterfallInsets.bottom), displayCutout.getSafeInsetBottom());
                ViewportMetrics viewportMetrics4 = this.f57988s;
                viewportMetrics4.physicalViewPaddingLeft = Math.max(Math.max(viewportMetrics4.physicalViewPaddingLeft, waterfallInsets.left), displayCutout.getSafeInsetLeft());
            }
        } else {
            ZeroSides zeroSides = ZeroSides.NONE;
            if (!z) {
                zeroSides = m41756d();
            }
            this.f57988s.physicalViewPaddingTop = z2 ? windowInsets.getSystemWindowInsetTop() : 0;
            this.f57988s.physicalViewPaddingRight = (zeroSides == ZeroSides.RIGHT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.f57988s.physicalViewPaddingBottom = (!z || m41751a(windowInsets) != 0) ? 0 : windowInsets.getSystemWindowInsetBottom();
            this.f57988s.physicalViewPaddingLeft = (zeroSides == ZeroSides.LEFT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            this.f57988s.physicalViewInsetTop = 0;
            this.f57988s.physicalViewInsetRight = 0;
            this.f57988s.physicalViewInsetBottom = m41751a(windowInsets);
            this.f57988s.physicalViewInsetLeft = 0;
        }
        m41760h();
        return super.onApplyWindowInsets(windowInsets);
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT > 19) {
            return super.fitSystemWindows(rect);
        }
        this.f57988s.physicalViewPaddingTop = rect.top;
        this.f57988s.physicalViewPaddingRight = rect.right;
        this.f57988s.physicalViewPaddingBottom = 0;
        this.f57988s.physicalViewPaddingLeft = rect.left;
        this.f57988s.physicalViewInsetTop = 0;
        this.f57988s.physicalViewInsetRight = 0;
        this.f57988s.physicalViewInsetBottom = rect.bottom;
        this.f57988s.physicalViewInsetLeft = 0;
        m41760h();
        return true;
    }

    /* renamed from: e */
    private boolean m41757e() {
        FlutterNativeView flutterNativeView = this.f57992w;
        return flutterNativeView != null && flutterNativeView.isAttached();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo172968a() {
        if (!m41757e()) {
            throw new AssertionError("Platform view is not attached");
        }
    }

    /* renamed from: f */
    private void m41758f() {
        mo172972b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo172972b() {
        AccessibilityBridge accessibilityBridge = this.f57986q;
        if (accessibilityBridge != null) {
            accessibilityBridge.reset();
        }
    }

    public void runFromBundle(FlutterRunArguments flutterRunArguments) {
        mo172968a();
        m41758f();
        this.f57992w.runFromBundle(flutterRunArguments);
        m41759g();
    }

    public Bitmap getBitmap() {
        mo172968a();
        return this.f57992w.mo172958a().getBitmap();
    }

    /* renamed from: h */
    private void m41760h() {
        if (m41757e()) {
            this.f57992w.mo172958a().setViewportMetrics(this.f57988s.devicePixelRatio, this.f57988s.physicalWidth, this.f57988s.physicalHeight, this.f57988s.physicalViewPaddingTop, this.f57988s.physicalViewPaddingRight, this.f57988s.physicalViewPaddingBottom, this.f57988s.physicalViewPaddingLeft, this.f57988s.physicalViewInsetTop, this.f57988s.physicalViewInsetRight, this.f57988s.physicalViewInsetBottom, this.f57988s.physicalViewInsetLeft, this.f57988s.systemGestureInsetTop, this.f57988s.systemGestureInsetRight, this.f57988s.systemGestureInsetBottom, this.f57988s.systemGestureInsetLeft, this.f57988s.physicalTouchSlop, new int[0], new int[0], new int[0]);
        }
    }

    public void onFirstFrame() {
        this.f57994y = true;
        for (FirstFrameListener onFirstFrame : new ArrayList(this.f57990u)) {
            onFirstFrame.onFirstFrame();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AccessibilityBridge accessibilityBridge = new AccessibilityBridge(this, new AccessibilityChannel(this.f57971b, getFlutterNativeView().mo172958a()), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), getPluginRegistry().getPlatformViewsController());
        this.f57986q = accessibilityBridge;
        accessibilityBridge.setOnAccessibilityChangeListener(this.f57995z);
        m41754a(this.f57986q.isAccessibilityEnabled(), this.f57986q.isTouchExplorationEnabled());
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m41761i();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41754a(boolean z, boolean z2) {
        boolean z3 = false;
        if (!this.f57993x) {
            if (!z && !z2) {
                z3 = true;
            }
            setWillNotDraw(z3);
            return;
        }
        setWillNotDraw(false);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge = this.f57986q;
        if (accessibilityBridge == null || !accessibilityBridge.isAccessibilityEnabled()) {
            return null;
        }
        return this.f57986q;
    }

    /* renamed from: i */
    private void m41761i() {
        AccessibilityBridge accessibilityBridge = this.f57986q;
        if (accessibilityBridge != null) {
            accessibilityBridge.release();
            this.f57986q = null;
        }
    }

    public PointerIcon getSystemPointerIcon(int i) {
        return PointerIcon.getSystemIcon(getContext(), i);
    }

    public void send(String str, ByteBuffer byteBuffer) {
        send(str, byteBuffer, (BinaryMessenger.BinaryReply) null);
    }

    public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
        if (!m41757e()) {
            Log.m41134d(f57970a, "FlutterView.send called on a detached view, channel=" + str);
            return;
        }
        this.f57992w.send(str, byteBuffer, binaryReply);
    }

    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        this.f57992w.setMessageHandler(str, binaryMessageHandler);
    }

    public void setMessageHandler(String str, BinaryMessenger.BinaryMessageHandler binaryMessageHandler, BinaryMessenger.TaskQueue taskQueue) {
        this.f57992w.setMessageHandler(str, binaryMessageHandler, taskQueue);
    }

    public TextureRegistry.SurfaceTextureEntry createSurfaceTexture() {
        return registerSurfaceTexture(new SurfaceTexture(0));
    }

    public TextureRegistry.SurfaceTextureEntry registerSurfaceTexture(SurfaceTexture surfaceTexture) {
        surfaceTexture.detachFromGLContext();
        SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = new SurfaceTextureRegistryEntry(this.f57991v.getAndIncrement(), surfaceTexture);
        this.f57992w.mo172958a().registerTexture(surfaceTextureRegistryEntry.mo172604id(), surfaceTextureRegistryEntry.textureWrapper());
        return surfaceTextureRegistryEntry;
    }

    /* renamed from: io.flutter.view.FlutterView$SurfaceTextureRegistryEntry */
    final class SurfaceTextureRegistryEntry implements TextureRegistry.SurfaceTextureEntry {
        /* access modifiers changed from: private */

        /* renamed from: id */
        public final long f57996id;
        private SurfaceTexture.OnFrameAvailableListener onFrameListener = new SurfaceTexture.OnFrameAvailableListener() {
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                if (!SurfaceTextureRegistryEntry.this.released && FlutterView.this.f57992w != null) {
                    FlutterView.this.f57992w.mo172958a().markTextureFrameAvailable(SurfaceTextureRegistryEntry.this.f57996id);
                }
            }
        };
        /* access modifiers changed from: private */
        public boolean released;
        private final SurfaceTextureWrapper textureWrapper;

        SurfaceTextureRegistryEntry(long j, SurfaceTexture surfaceTexture) {
            this.f57996id = j;
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
            return this.f57996id;
        }

        public void release() {
            if (!this.released) {
                this.released = true;
                surfaceTexture().setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
                this.textureWrapper.release();
                FlutterView.this.f57992w.mo172958a().unregisterTexture(this.f57996id);
            }
        }
    }
}
