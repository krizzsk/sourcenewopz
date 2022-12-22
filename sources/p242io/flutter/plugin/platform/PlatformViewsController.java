package p242io.flutter.plugin.platform;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import p242io.flutter.Log;
import p242io.flutter.embedding.android.AndroidTouchProcessor;
import p242io.flutter.embedding.android.FlutterImageView;
import p242io.flutter.embedding.android.FlutterView;
import p242io.flutter.embedding.android.MotionEventTracker;
import p242io.flutter.embedding.engine.FlutterOverlaySurface;
import p242io.flutter.embedding.engine.dart.DartExecutor;
import p242io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView;
import p242io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import p242io.flutter.embedding.engine.renderer.FlutterRenderer;
import p242io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import p242io.flutter.plugin.editing.TextInputPlugin;
import p242io.flutter.plugin.platform.PlatformViewsController;
import p242io.flutter.view.AccessibilityBridge;
import p242io.flutter.view.TextureRegistry;

/* renamed from: io.flutter.plugin.platform.PlatformViewsController */
public class PlatformViewsController implements PlatformViewsAccessibilityDelegate {

    /* renamed from: c */
    private static final String f57858c = "PlatformViewsController";

    /* renamed from: a */
    final HashMap<Integer, VirtualDisplayController> f57859a = new HashMap<>();

    /* renamed from: b */
    final HashMap<Context, View> f57860b = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C21119b f57861d = new C21119b();

    /* renamed from: e */
    private AndroidTouchProcessor f57862e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Context f57863f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public FlutterView f57864g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextureRegistry f57865h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public TextInputPlugin f57866i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public PlatformViewsChannel f57867j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final C21118a f57868k = new C21118a();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final SparseArray<PlatformView> f57869l = new SparseArray<>();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final SparseArray<FlutterMutatorView> f57870m = new SparseArray<>();

    /* renamed from: n */
    private final SparseArray<FlutterImageView> f57871n = new SparseArray<>();

    /* renamed from: o */
    private int f57872o = 0;

    /* renamed from: p */
    private boolean f57873p = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f57874q = true;

    /* renamed from: r */
    private final HashSet<Integer> f57875r = new HashSet<>();

    /* renamed from: s */
    private final HashSet<Integer> f57876s = new HashSet<>();

    /* renamed from: t */
    private final MotionEventTracker f57877t = MotionEventTracker.getInstance();

    /* renamed from: u */
    private final PlatformViewsChannel.PlatformViewsHandler f57878u = new PlatformViewsChannel.PlatformViewsHandler() {
        public void createAndroidViewForPlatformView(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            ensureValidAndroidVersion(19);
            if (PlatformViewsController.m41634c(platformViewCreationRequest.direction)) {
                PlatformViewFactory a = PlatformViewsController.this.f57861d.mo172889a(platformViewCreationRequest.viewType);
                if (a != null) {
                    Object obj = null;
                    if (platformViewCreationRequest.params != null) {
                        obj = a.getCreateArgsCodec().decodeMessage(platformViewCreationRequest.params);
                    }
                    PlatformView create = a.create(PlatformViewsController.this.f57863f, platformViewCreationRequest.viewId, obj);
                    create.getView().setLayoutDirection(platformViewCreationRequest.direction);
                    PlatformViewsController.this.f57869l.put(platformViewCreationRequest.viewId, create);
                    return;
                }
                throw new IllegalStateException("Trying to create a platform view of unregistered type: " + platformViewCreationRequest.viewType);
            }
            throw new IllegalStateException("Trying to create a view with unknown direction value: " + platformViewCreationRequest.direction + "(view id: " + platformViewCreationRequest.viewId + ")");
        }

        public void disposeAndroidViewForPlatformView(int i) {
            PlatformView platformView = (PlatformView) PlatformViewsController.this.f57869l.get(i);
            FlutterMutatorView flutterMutatorView = (FlutterMutatorView) PlatformViewsController.this.f57870m.get(i);
            if (platformView != null) {
                if (flutterMutatorView != null) {
                    flutterMutatorView.removeView(platformView.getView());
                }
                PlatformViewsController.this.f57869l.remove(i);
                platformView.dispose();
            }
            if (flutterMutatorView != null) {
                flutterMutatorView.unsetOnDescendantFocusChangeListener();
                ((ViewGroup) flutterMutatorView.getParent()).removeView(flutterMutatorView);
                PlatformViewsController.this.f57870m.remove(i);
            }
        }

        public long createVirtualDisplayForPlatformView(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            ensureValidAndroidVersion(20);
            if (!PlatformViewsController.m41634c(platformViewCreationRequest.direction)) {
                throw new IllegalStateException("Trying to create a view with unknown direction value: " + platformViewCreationRequest.direction + "(view id: " + platformViewCreationRequest.viewId + ")");
            } else if (!PlatformViewsController.this.f57859a.containsKey(Integer.valueOf(platformViewCreationRequest.viewId))) {
                PlatformViewFactory a = PlatformViewsController.this.f57861d.mo172889a(platformViewCreationRequest.viewType);
                if (a != null) {
                    Object obj = null;
                    if (platformViewCreationRequest.params != null) {
                        obj = a.getCreateArgsCodec().decodeMessage(platformViewCreationRequest.params);
                    }
                    Object obj2 = obj;
                    int a2 = PlatformViewsController.this.m41613a(platformViewCreationRequest.logicalWidth);
                    int a3 = PlatformViewsController.this.m41613a(platformViewCreationRequest.logicalHeight);
                    PlatformViewsController.this.m41618a(a2, a3);
                    TextureRegistry.SurfaceTextureEntry createSurfaceTexture = PlatformViewsController.this.f57865h.createSurfaceTexture();
                    VirtualDisplayController a4 = VirtualDisplayController.m41645a(PlatformViewsController.this.f57863f, PlatformViewsController.this.f57868k, a, createSurfaceTexture, a2, a3, platformViewCreationRequest.viewId, obj2, new View.OnFocusChangeListener(platformViewCreationRequest) {
                        public final /* synthetic */ PlatformViewsChannel.PlatformViewCreationRequest f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onFocusChange(View view, boolean z) {
                            PlatformViewsController.C211141.this.mo172863x2dd95fbd(this.f$1, view, z);
                        }
                    });
                    if (a4 != null) {
                        if (PlatformViewsController.this.f57864g != null) {
                            a4.mo172879a((View) PlatformViewsController.this.f57864g);
                        }
                        PlatformViewsController.this.f57859a.put(Integer.valueOf(platformViewCreationRequest.viewId), a4);
                        View e = a4.mo172883e();
                        e.setLayoutDirection(platformViewCreationRequest.direction);
                        PlatformViewsController.this.f57860b.put(e.getContext(), e);
                        return createSurfaceTexture.mo172604id();
                    }
                    throw new IllegalStateException("Failed creating virtual display for a " + platformViewCreationRequest.viewType + " with id: " + platformViewCreationRequest.viewId);
                }
                throw new IllegalStateException("Trying to create a platform view of unregistered type: " + platformViewCreationRequest.viewType);
            } else {
                throw new IllegalStateException("Trying to create an already created platform view, view id: " + platformViewCreationRequest.viewId);
            }
        }

        /* renamed from: lambda$createVirtualDisplayForPlatformView$0$PlatformViewsController$1 */
        public /* synthetic */ void mo172863x2dd95fbd(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest, View view, boolean z) {
            if (z) {
                PlatformViewsController.this.f57867j.invokeViewFocused(platformViewCreationRequest.viewId);
            }
        }

        public void disposeVirtualDisplayForPlatformView(int i) {
            ensureValidAndroidVersion(20);
            VirtualDisplayController virtualDisplayController = PlatformViewsController.this.f57859a.get(Integer.valueOf(i));
            if (virtualDisplayController != null) {
                if (PlatformViewsController.this.f57866i != null) {
                    PlatformViewsController.this.f57866i.clearPlatformViewClient(i);
                }
                PlatformViewsController.this.f57860b.remove(virtualDisplayController.mo172883e().getContext());
                virtualDisplayController.mo172876a();
                PlatformViewsController.this.f57859a.remove(Integer.valueOf(i));
                return;
            }
            throw new IllegalStateException("Trying to dispose a platform view with unknown id: " + i);
        }

        public void resizePlatformView(PlatformViewsChannel.PlatformViewResizeRequest platformViewResizeRequest, Runnable runnable) {
            ensureValidAndroidVersion(20);
            VirtualDisplayController virtualDisplayController = PlatformViewsController.this.f57859a.get(Integer.valueOf(platformViewResizeRequest.viewId));
            if (virtualDisplayController != null) {
                int a = PlatformViewsController.this.m41613a(platformViewResizeRequest.newLogicalWidth);
                int a2 = PlatformViewsController.this.m41613a(platformViewResizeRequest.newLogicalHeight);
                PlatformViewsController.this.m41618a(a, a2);
                PlatformViewsController.this.m41622a(virtualDisplayController);
                virtualDisplayController.mo172877a(a, a2, new Runnable(virtualDisplayController, runnable) {
                    public final /* synthetic */ VirtualDisplayController f$1;
                    public final /* synthetic */ Runnable f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        PlatformViewsController.C211141.this.lambda$resizePlatformView$1$PlatformViewsController$1(this.f$1, this.f$2);
                    }
                });
                return;
            }
            throw new IllegalStateException("Trying to resize a platform view with unknown id: " + platformViewResizeRequest.viewId);
        }

        public /* synthetic */ void lambda$resizePlatformView$1$PlatformViewsController$1(VirtualDisplayController virtualDisplayController, Runnable runnable) {
            PlatformViewsController.this.m41630b(virtualDisplayController);
            runnable.run();
        }

        public void onTouch(PlatformViewsChannel.PlatformViewTouch platformViewTouch) {
            int i = platformViewTouch.viewId;
            float f = PlatformViewsController.this.f57863f.getResources().getDisplayMetrics().density;
            ensureValidAndroidVersion(20);
            if (PlatformViewsController.this.f57859a.containsKey(Integer.valueOf(i))) {
                PlatformViewsController.this.f57859a.get(Integer.valueOf(platformViewTouch.viewId)).mo172878a(PlatformViewsController.this.toMotionEvent(f, platformViewTouch, true));
            } else if (PlatformViewsController.this.f57869l.get(i) != null) {
                MotionEvent motionEvent = PlatformViewsController.this.toMotionEvent(f, platformViewTouch, false);
                View view = ((PlatformView) PlatformViewsController.this.f57869l.get(platformViewTouch.viewId)).getView();
                if (view != null) {
                    view.dispatchTouchEvent(motionEvent);
                }
            } else {
                throw new IllegalStateException("Sending touch to an unknown view with id: " + i);
            }
        }

        public void setDirection(int i, int i2) {
            if (PlatformViewsController.m41634c(i2)) {
                ensureValidAndroidVersion(20);
                PlatformView platformView = (PlatformView) PlatformViewsController.this.f57869l.get(i);
                if (platformView != null) {
                    platformView.getView().setLayoutDirection(i2);
                    return;
                }
                VirtualDisplayController virtualDisplayController = PlatformViewsController.this.f57859a.get(Integer.valueOf(i));
                if (virtualDisplayController != null) {
                    virtualDisplayController.mo172883e().setLayoutDirection(i2);
                    return;
                }
                throw new IllegalStateException("Trying to set direction: " + i2 + " to an unknown platform view with id: " + i);
            }
            throw new IllegalStateException("Trying to set unknown direction value: " + i2 + "(view id: " + i + ")");
        }

        public void clearFocus(int i) {
            PlatformView platformView = (PlatformView) PlatformViewsController.this.f57869l.get(i);
            if (platformView != null) {
                platformView.getView().clearFocus();
                return;
            }
            ensureValidAndroidVersion(20);
            PlatformViewsController.this.f57859a.get(Integer.valueOf(i)).mo172883e().clearFocus();
        }

        private void ensureValidAndroidVersion(int i) {
            if (Build.VERSION.SDK_INT < i) {
                throw new IllegalStateException("Trying to use platform views with API " + Build.VERSION.SDK_INT + ", required API level is: " + i);
            }
        }

        public void synchronizeToNativeViewHierarchy(boolean z) {
            boolean unused = PlatformViewsController.this.f57874q = z;
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static boolean m41634c(int i) {
        return i == 0 || i == 1;
    }

    public void onAttachedToJNI() {
    }

    public MotionEvent toMotionEvent(float f, PlatformViewsChannel.PlatformViewTouch platformViewTouch, boolean z) {
        PlatformViewsChannel.PlatformViewTouch platformViewTouch2 = platformViewTouch;
        MotionEvent pop = this.f57877t.pop(MotionEventTracker.MotionEventId.from(platformViewTouch2.motionEventId));
        MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) m41616a(platformViewTouch2.rawPointerPropertiesList).toArray(new MotionEvent.PointerProperties[platformViewTouch2.pointerCount]);
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) m41617a(platformViewTouch2.rawPointerCoords, f).toArray(new MotionEvent.PointerCoords[platformViewTouch2.pointerCount]);
        if (!z && pop != null) {
            return MotionEvent.obtain(pop.getDownTime(), pop.getEventTime(), pop.getAction(), platformViewTouch2.pointerCount, pointerPropertiesArr, pointerCoordsArr, pop.getMetaState(), pop.getButtonState(), pop.getXPrecision(), pop.getYPrecision(), pop.getDeviceId(), pop.getEdgeFlags(), pop.getSource(), pop.getFlags());
        }
        return MotionEvent.obtain(platformViewTouch2.downTime.longValue(), platformViewTouch2.eventTime.longValue(), platformViewTouch2.action, platformViewTouch2.pointerCount, pointerPropertiesArr, pointerCoordsArr, platformViewTouch2.metaState, platformViewTouch2.buttonState, platformViewTouch2.xPrecision, platformViewTouch2.yPrecision, platformViewTouch2.deviceId, platformViewTouch2.edgeFlags, platformViewTouch2.source, platformViewTouch2.flags);
    }

    public void attach(Context context, TextureRegistry textureRegistry, DartExecutor dartExecutor) {
        if (this.f57863f == null) {
            this.f57863f = context;
            this.f57865h = textureRegistry;
            PlatformViewsChannel platformViewsChannel = new PlatformViewsChannel(dartExecutor);
            this.f57867j = platformViewsChannel;
            platformViewsChannel.setPlatformViewsHandler(this.f57878u);
            return;
        }
        throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
    }

    public void detach() {
        PlatformViewsChannel platformViewsChannel = this.f57867j;
        if (platformViewsChannel != null) {
            platformViewsChannel.setPlatformViewsHandler((PlatformViewsChannel.PlatformViewsHandler) null);
        }
        destroyOverlaySurfaces();
        this.f57867j = null;
        this.f57863f = null;
        this.f57865h = null;
    }

    public void attachToView(FlutterView flutterView) {
        this.f57864g = flutterView;
        for (VirtualDisplayController a : this.f57859a.values()) {
            a.mo172879a((View) flutterView);
        }
    }

    public void detachFromView() {
        destroyOverlaySurfaces();
        m41636d();
        this.f57864g = null;
        this.f57873p = false;
        for (VirtualDisplayController b : this.f57859a.values()) {
            b.mo172880b();
        }
    }

    public void attachAccessibilityBridge(AccessibilityBridge accessibilityBridge) {
        this.f57868k.mo172887a(accessibilityBridge);
    }

    public void detachAccessibilityBridge() {
        this.f57868k.mo172887a((AccessibilityBridge) null);
    }

    public void attachTextInputPlugin(TextInputPlugin textInputPlugin) {
        this.f57866i = textInputPlugin;
    }

    public void detachTextInputPlugin() {
        this.f57866i = null;
    }

    public boolean checkInputConnectionProxy(View view) {
        if (view == null || !this.f57860b.containsKey(view.getContext())) {
            return false;
        }
        View view2 = this.f57860b.get(view.getContext());
        if (view2 == view) {
            return true;
        }
        return view2.checkInputConnectionProxy(view);
    }

    public PlatformViewRegistry getRegistry() {
        return this.f57861d;
    }

    public void onDetachedFromJNI() {
        m41628b();
    }

    public void onPreEngineRestart() {
        m41628b();
    }

    public View getPlatformViewById(Integer num) {
        if (this.f57869l.get(num.intValue()) != null) {
            return this.f57869l.get(num.intValue()).getView();
        }
        VirtualDisplayController virtualDisplayController = this.f57859a.get(num);
        if (virtualDisplayController == null) {
            return null;
        }
        return virtualDisplayController.mo172883e();
    }

    public boolean usesVirtualDisplay(Integer num) {
        return this.f57859a.containsKey(num);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41622a(VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin = this.f57866i;
        if (textInputPlugin != null) {
            textInputPlugin.lockPlatformViewInputConnection();
            virtualDisplayController.mo172881c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m41630b(VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin = this.f57866i;
        if (textInputPlugin != null) {
            textInputPlugin.unlockPlatformViewInputConnection();
            virtualDisplayController.mo172882d();
        }
    }

    /* renamed from: a */
    private static List<MotionEvent.PointerProperties> m41616a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object b : (List) obj) {
            arrayList.add(m41627b(b));
        }
        return arrayList;
    }

    /* renamed from: b */
    private static MotionEvent.PointerProperties m41627b(Object obj) {
        List list = (List) obj;
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = ((Integer) list.get(0)).intValue();
        pointerProperties.toolType = ((Integer) list.get(1)).intValue();
        return pointerProperties;
    }

    /* renamed from: a */
    private static List<MotionEvent.PointerCoords> m41617a(Object obj, float f) {
        ArrayList arrayList = new ArrayList();
        for (Object b : (List) obj) {
            arrayList.add(m41626b(b, f));
        }
        return arrayList;
    }

    /* renamed from: b */
    private static MotionEvent.PointerCoords m41626b(Object obj, float f) {
        List list = (List) obj;
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.orientation = (float) ((Double) list.get(0)).doubleValue();
        pointerCoords.pressure = (float) ((Double) list.get(1)).doubleValue();
        pointerCoords.size = (float) ((Double) list.get(2)).doubleValue();
        pointerCoords.toolMajor = ((float) ((Double) list.get(3)).doubleValue()) * f;
        pointerCoords.toolMinor = ((float) ((Double) list.get(4)).doubleValue()) * f;
        pointerCoords.touchMajor = ((float) ((Double) list.get(5)).doubleValue()) * f;
        pointerCoords.touchMinor = ((float) ((Double) list.get(6)).doubleValue()) * f;
        pointerCoords.x = ((float) ((Double) list.get(7)).doubleValue()) * f;
        pointerCoords.y = ((float) ((Double) list.get(8)).doubleValue()) * f;
        return pointerCoords;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41618a(int i, int i2) {
        DisplayMetrics displayMetrics = this.f57863f.getResources().getDisplayMetrics();
        if (i2 > displayMetrics.heightPixels || i > displayMetrics.widthPixels) {
            Log.m41142w(f57858c, "Creating a virtual display of size: [" + i + ", " + i2 + "] may result in problems(https://github.com/flutter/flutter/issues/2897).It is larger than the device screen size: [" + displayMetrics.widthPixels + ", " + displayMetrics.heightPixels + "].");
        }
    }

    /* renamed from: a */
    private float m41612a() {
        return this.f57863f.getResources().getDisplayMetrics().density;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m41613a(double d) {
        return (int) Math.round(d * ((double) m41612a()));
    }

    /* renamed from: b */
    private void m41628b() {
        for (VirtualDisplayController a : this.f57859a.values()) {
            a.mo172876a();
        }
        this.f57859a.clear();
        while (this.f57869l.size() > 0) {
            this.f57878u.disposeAndroidViewForPlatformView(this.f57869l.keyAt(0));
        }
        if (this.f57860b.size() > 0) {
            this.f57860b.clear();
        }
    }

    /* renamed from: c */
    private void m41633c() {
        if (this.f57874q && !this.f57873p) {
            this.f57864g.convertToImageView();
            this.f57873p = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo172842a(int i) {
        PlatformView platformView = this.f57869l.get(i);
        if (platformView == null) {
            throw new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
        } else if (this.f57870m.get(i) == null) {
            if (platformView.getView() == null) {
                throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
            } else if (platformView.getView().getParent() == null) {
                Context context = this.f57863f;
                FlutterMutatorView flutterMutatorView = new FlutterMutatorView(context, context.getResources().getDisplayMetrics().density, this.f57862e);
                flutterMutatorView.setOnDescendantFocusChangeListener(new View.OnFocusChangeListener(i) {
                    public final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onFocusChange(View view, boolean z) {
                        PlatformViewsController.this.m41619a(this.f$1, view, z);
                    }
                });
                this.f57870m.put(i, flutterMutatorView);
                flutterMutatorView.addView(platformView.getView());
                this.f57864g.addView(flutterMutatorView);
            } else {
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m41619a(int i, View view, boolean z) {
        if (z) {
            this.f57867j.invokeViewFocused(i);
            return;
        }
        TextInputPlugin textInputPlugin = this.f57866i;
        if (textInputPlugin != null) {
            textInputPlugin.clearPlatformViewClient(i);
        }
    }

    public void attachToFlutterRenderer(FlutterRenderer flutterRenderer) {
        this.f57862e = new AndroidTouchProcessor(flutterRenderer, true);
    }

    public void onDisplayPlatformView(int i, int i2, int i3, int i4, int i5, int i6, int i7, FlutterMutatorsStack flutterMutatorsStack) {
        m41633c();
        mo172842a(i);
        FlutterMutatorView flutterMutatorView = this.f57870m.get(i);
        flutterMutatorView.readyToDisplay(flutterMutatorsStack, i2, i3, i4, i5);
        flutterMutatorView.setVisibility(0);
        flutterMutatorView.bringToFront();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i6, i7);
        View view = this.f57869l.get(i).getView();
        if (view != null) {
            view.setLayoutParams(layoutParams);
            view.bringToFront();
        }
        this.f57876s.add(Integer.valueOf(i));
    }

    public void onDisplayOverlaySurface(int i, int i2, int i3, int i4, int i5) {
        if (this.f57871n.get(i) != null) {
            m41633c();
            FlutterImageView flutterImageView = this.f57871n.get(i);
            if (flutterImageView.getParent() == null) {
                this.f57864g.addView(flutterImageView);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i5);
            layoutParams.leftMargin = i2;
            layoutParams.topMargin = i3;
            flutterImageView.setLayoutParams(layoutParams);
            flutterImageView.setVisibility(0);
            flutterImageView.bringToFront();
            this.f57875r.add(Integer.valueOf(i));
            return;
        }
        throw new IllegalStateException("The overlay surface (id:" + i + ") doesn't exist");
    }

    public void onBeginFrame() {
        this.f57875r.clear();
        this.f57876s.clear();
    }

    public void onEndFrame() {
        boolean z = false;
        if (!this.f57873p || !this.f57876s.isEmpty()) {
            if (this.f57873p && this.f57864g.acquireLatestImageViewFrame()) {
                z = true;
            }
            m41623a(z);
            return;
        }
        this.f57873p = false;
        this.f57864g.revertImageView(new Runnable() {
            public final void run() {
                PlatformViewsController.this.m41638e();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m41638e() {
        m41623a(false);
    }

    /* renamed from: a */
    private void m41623a(boolean z) {
        for (int i = 0; i < this.f57871n.size(); i++) {
            int keyAt = this.f57871n.keyAt(i);
            FlutterImageView valueAt = this.f57871n.valueAt(i);
            if (this.f57875r.contains(Integer.valueOf(keyAt))) {
                this.f57864g.attachOverlaySurfaceToRender(valueAt);
                z &= valueAt.acquireLatestImage();
            } else {
                if (!this.f57873p) {
                    valueAt.detachFromRenderer();
                }
                valueAt.setVisibility(8);
            }
        }
        for (int i2 = 0; i2 < this.f57870m.size(); i2++) {
            int keyAt2 = this.f57870m.keyAt(i2);
            View view = this.f57870m.get(keyAt2);
            if (!this.f57876s.contains(Integer.valueOf(keyAt2)) || (!z && this.f57874q)) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public FlutterOverlaySurface createOverlaySurface(FlutterImageView flutterImageView) {
        int i = this.f57872o;
        this.f57872o = i + 1;
        this.f57871n.put(i, flutterImageView);
        return new FlutterOverlaySurface(i, flutterImageView.getSurface());
    }

    public FlutterOverlaySurface createOverlaySurface() {
        return createOverlaySurface(new FlutterImageView(this.f57864g.getContext(), this.f57864g.getWidth(), this.f57864g.getHeight(), FlutterImageView.SurfaceKind.overlay));
    }

    public void destroyOverlaySurfaces() {
        for (int i = 0; i < this.f57871n.size(); i++) {
            FlutterImageView valueAt = this.f57871n.valueAt(i);
            valueAt.detachFromRenderer();
            valueAt.closeImageReader();
        }
    }

    /* renamed from: d */
    private void m41636d() {
        if (this.f57864g == null) {
            Log.m41136e(f57858c, "removeOverlaySurfaces called while flutter view is null");
            return;
        }
        for (int i = 0; i < this.f57871n.size(); i++) {
            this.f57864g.removeView(this.f57871n.valueAt(i));
        }
        this.f57871n.clear();
    }
}
