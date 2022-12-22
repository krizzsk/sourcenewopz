package p242io.flutter.view;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.Choreographer;
import java.util.Objects;
import p242io.flutter.embedding.engine.FlutterJNI;

/* renamed from: io.flutter.view.VsyncWaiter */
public class VsyncWaiter {

    /* renamed from: a */
    private static VsyncWaiter f57997a;

    /* renamed from: b */
    private static DisplayListener f57998b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public long f57999c = -1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FlutterJNI f58000d;

    /* renamed from: e */
    private final FlutterJNI.AsyncWaitForVsyncDelegate f58001e = new FlutterJNI.AsyncWaitForVsyncDelegate() {
        public void asyncWaitForVsync(final long j) {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
                public void doFrame(long j) {
                    long nanoTime = System.nanoTime() - j;
                    VsyncWaiter.this.f58000d.onVsync(nanoTime < 0 ? 0 : nanoTime, VsyncWaiter.this.f57999c, j);
                }
            });
        }
    };

    /* renamed from: io.flutter.view.VsyncWaiter$DisplayListener */
    class DisplayListener implements DisplayManager.DisplayListener {
        private DisplayManager displayManager;

        public void onDisplayAdded(int i) {
        }

        public void onDisplayRemoved(int i) {
        }

        DisplayListener(DisplayManager displayManager2) {
            this.displayManager = displayManager2;
        }

        /* access modifiers changed from: package-private */
        public void register() {
            this.displayManager.registerDisplayListener(this, (Handler) null);
        }

        public void onDisplayChanged(int i) {
            if (i == 0) {
                float refreshRate = this.displayManager.getDisplay(0).getRefreshRate();
                long unused = VsyncWaiter.this.f57999c = (long) (1.0E9d / ((double) refreshRate));
                VsyncWaiter.this.f58000d.setRefreshRateFPS(refreshRate);
            }
        }
    }

    public static VsyncWaiter getInstance(float f, FlutterJNI flutterJNI) {
        if (f57997a == null) {
            f57997a = new VsyncWaiter(flutterJNI);
        }
        flutterJNI.setRefreshRateFPS(f);
        VsyncWaiter vsyncWaiter = f57997a;
        vsyncWaiter.f57999c = (long) (1.0E9d / ((double) f));
        return vsyncWaiter;
    }

    public static VsyncWaiter getInstance(DisplayManager displayManager, FlutterJNI flutterJNI) {
        if (f57997a == null) {
            f57997a = new VsyncWaiter(flutterJNI);
        }
        if (f57998b == null) {
            VsyncWaiter vsyncWaiter = f57997a;
            Objects.requireNonNull(vsyncWaiter);
            DisplayListener displayListener = new DisplayListener(displayManager);
            f57998b = displayListener;
            displayListener.register();
        }
        if (f57997a.f57999c == -1) {
            float refreshRate = displayManager.getDisplay(0).getRefreshRate();
            f57997a.f57999c = (long) (1.0E9d / ((double) refreshRate));
            flutterJNI.setRefreshRateFPS(refreshRate);
        }
        return f57997a;
    }

    public static void reset() {
        f57997a = null;
        f57998b = null;
    }

    private VsyncWaiter(FlutterJNI flutterJNI) {
        this.f58000d = flutterJNI;
    }

    public void init() {
        this.f58000d.setAsyncWaitForVsyncDelegate(this.f58001e);
    }
}
