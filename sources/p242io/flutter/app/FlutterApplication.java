package p242io.flutter.app;

import android.app.Activity;
import android.app.Application;
import p242io.flutter.FlutterInjector;

/* renamed from: io.flutter.app.FlutterApplication */
public class FlutterApplication extends Application {

    /* renamed from: a */
    private Activity f57320a = null;

    public void onCreate() {
        super.onCreate();
        FlutterInjector.instance().flutterLoader().startInitialization(this);
    }

    public Activity getCurrentActivity() {
        return this.f57320a;
    }

    public void setCurrentActivity(Activity activity) {
        this.f57320a = activity;
    }
}
