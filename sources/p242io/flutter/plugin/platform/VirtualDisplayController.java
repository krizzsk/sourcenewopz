package p242io.flutter.plugin.platform;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewTreeObserver;
import com.didi.sdk.apm.SystemUtils;
import p242io.flutter.plugin.platform.SingleViewPresentation;
import p242io.flutter.view.TextureRegistry;

/* renamed from: io.flutter.plugin.platform.VirtualDisplayController */
class VirtualDisplayController {

    /* renamed from: a */
    SingleViewPresentation f57879a;

    /* renamed from: b */
    private final Context f57880b;

    /* renamed from: c */
    private final C21118a f57881c;

    /* renamed from: d */
    private final int f57882d;

    /* renamed from: e */
    private final TextureRegistry.SurfaceTextureEntry f57883e;

    /* renamed from: f */
    private final View.OnFocusChangeListener f57884f;

    /* renamed from: g */
    private VirtualDisplay f57885g;

    /* renamed from: h */
    private final Surface f57886h;

    /* renamed from: a */
    public static VirtualDisplayController m41645a(Context context, C21118a aVar, PlatformViewFactory platformViewFactory, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, int i, int i2, int i3, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        int i4 = i;
        int i5 = i2;
        surfaceTextureEntry.surfaceTexture().setDefaultBufferSize(i4, i5);
        Surface surface = new Surface(surfaceTextureEntry.surfaceTexture());
        Context context2 = context;
        VirtualDisplay createVirtualDisplay = ((DisplayManager) context.getSystemService("display")).createVirtualDisplay("flutter-vd", i4, i5, context.getResources().getDisplayMetrics().densityDpi, surface, 0);
        if (createVirtualDisplay == null) {
            return null;
        }
        return new VirtualDisplayController(context, aVar, createVirtualDisplay, platformViewFactory, surface, surfaceTextureEntry, onFocusChangeListener, i3, obj);
    }

    private VirtualDisplayController(Context context, C21118a aVar, VirtualDisplay virtualDisplay, PlatformViewFactory platformViewFactory, Surface surface, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, View.OnFocusChangeListener onFocusChangeListener, int i, Object obj) {
        Context context2 = context;
        this.f57880b = context2;
        C21118a aVar2 = aVar;
        this.f57881c = aVar2;
        this.f57883e = surfaceTextureEntry;
        View.OnFocusChangeListener onFocusChangeListener2 = onFocusChangeListener;
        this.f57884f = onFocusChangeListener2;
        this.f57886h = surface;
        this.f57885g = virtualDisplay;
        this.f57882d = context.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(context2, this.f57885g.getDisplay(), platformViewFactory, aVar2, i, obj, onFocusChangeListener2);
        this.f57879a = singleViewPresentation;
        SystemUtils.showDialog(singleViewPresentation);
    }

    /* renamed from: a */
    public void mo172877a(int i, int i2, Runnable runnable) {
        boolean isFocused = mo172883e().isFocused();
        SingleViewPresentation.PresentationState detachState = this.f57879a.detachState();
        this.f57885g.setSurface((Surface) null);
        this.f57885g.release();
        this.f57883e.surfaceTexture().setDefaultBufferSize(i, i2);
        this.f57885g = ((DisplayManager) this.f57880b.getSystemService("display")).createVirtualDisplay("flutter-vd", i, i2, this.f57882d, this.f57886h, 0);
        final View e = mo172883e();
        final Runnable runnable2 = runnable;
        e.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            public void onViewDetachedFromWindow(View view) {
            }

            public void onViewAttachedToWindow(View view) {
                OneTimeOnDrawListener.schedule(e, new Runnable() {
                    public void run() {
                        e.postDelayed(runnable2, 128);
                    }
                });
                e.removeOnAttachStateChangeListener(this);
            }
        });
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.f57880b, this.f57885g.getDisplay(), this.f57881c, detachState, this.f57884f, isFocused);
        SystemUtils.showDialog(singleViewPresentation);
        this.f57879a.cancel();
        this.f57879a = singleViewPresentation;
    }

    /* renamed from: a */
    public void mo172876a() {
        PlatformView view = this.f57879a.getView();
        this.f57879a.cancel();
        this.f57879a.detachState();
        view.dispose();
        this.f57885g.release();
        this.f57883e.release();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo172879a(View view) {
        SingleViewPresentation singleViewPresentation = this.f57879a;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.f57879a.getView().onFlutterViewAttached(view);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo172880b() {
        SingleViewPresentation singleViewPresentation = this.f57879a;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.f57879a.getView().onFlutterViewDetached();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo172881c() {
        SingleViewPresentation singleViewPresentation = this.f57879a;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.f57879a.getView().onInputConnectionLocked();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo172882d() {
        SingleViewPresentation singleViewPresentation = this.f57879a;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.f57879a.getView().onInputConnectionUnlocked();
        }
    }

    /* renamed from: e */
    public View mo172883e() {
        SingleViewPresentation singleViewPresentation = this.f57879a;
        if (singleViewPresentation == null) {
            return null;
        }
        return singleViewPresentation.getView().getView();
    }

    /* renamed from: a */
    public void mo172878a(MotionEvent motionEvent) {
        SingleViewPresentation singleViewPresentation = this.f57879a;
        if (singleViewPresentation != null) {
            singleViewPresentation.dispatchTouchEvent(motionEvent);
        }
    }

    /* renamed from: io.flutter.plugin.platform.VirtualDisplayController$OneTimeOnDrawListener */
    static class OneTimeOnDrawListener implements ViewTreeObserver.OnDrawListener {
        Runnable mOnDrawRunnable;
        final View mView;

        static void schedule(View view, Runnable runnable) {
            view.getViewTreeObserver().addOnDrawListener(new OneTimeOnDrawListener(view, runnable));
        }

        OneTimeOnDrawListener(View view, Runnable runnable) {
            this.mView = view;
            this.mOnDrawRunnable = runnable;
        }

        public void onDraw() {
            Runnable runnable = this.mOnDrawRunnable;
            if (runnable != null) {
                runnable.run();
                this.mOnDrawRunnable = null;
                this.mView.post(new Runnable() {
                    public void run() {
                        OneTimeOnDrawListener.this.mView.getViewTreeObserver().removeOnDrawListener(OneTimeOnDrawListener.this);
                    }
                });
            }
        }
    }
}
