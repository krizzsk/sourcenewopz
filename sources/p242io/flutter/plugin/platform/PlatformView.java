package p242io.flutter.plugin.platform;

import android.view.View;

/* renamed from: io.flutter.plugin.platform.PlatformView */
public interface PlatformView {

    /* renamed from: io.flutter.plugin.platform.PlatformView$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onFlutterViewAttached(PlatformView platformView, View view) {
        }

        public static void $default$onFlutterViewDetached(PlatformView platformView) {
        }

        public static void $default$onInputConnectionLocked(PlatformView platformView) {
        }

        public static void $default$onInputConnectionUnlocked(PlatformView platformView) {
        }
    }

    void dispose();

    View getView();

    void onFlutterViewAttached(View view);

    void onFlutterViewDetached();

    void onInputConnectionLocked();

    void onInputConnectionUnlocked();
}
