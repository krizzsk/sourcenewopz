package p242io.flutter.embedding.android;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import p242io.flutter.embedding.android.SplashScreen;

/* renamed from: io.flutter.embedding.android.NSkeletonFlutterSplashView */
public class NSkeletonFlutterSplashView implements SplashScreen {
    public /* synthetic */ boolean doesSplashViewRememberItsTransition() {
        return SplashScreen.CC.$default$doesSplashViewRememberItsTransition(this);
    }

    public /* synthetic */ Bundle saveSplashScreenState() {
        return SplashScreen.CC.$default$saveSplashScreenState(this);
    }

    public View createSplashView(Context context, Bundle bundle) {
        View view = new View(context);
        view.setBackgroundColor(-1);
        return view;
    }

    public void transitionToFlutter(Runnable runnable) {
        runnable.run();
    }
}
