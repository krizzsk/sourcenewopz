package p242io.flutter.app;

import com.google.android.play.core.splitcompat.SplitCompatApplication;
import p242io.flutter.FlutterInjector;
import p242io.flutter.embedding.engine.FlutterJNI;
import p242io.flutter.embedding.engine.deferredcomponents.PlayStoreDeferredComponentManager;

/* renamed from: io.flutter.app.FlutterPlayStoreSplitApplication */
public class FlutterPlayStoreSplitApplication extends SplitCompatApplication {
    public void onCreate() {
        super.onCreate();
        FlutterInjector.setInstance(new FlutterInjector.Builder().setDeferredComponentManager(new PlayStoreDeferredComponentManager(this, (FlutterJNI) null)).build());
    }
}
