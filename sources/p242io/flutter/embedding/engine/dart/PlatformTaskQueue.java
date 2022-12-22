package p242io.flutter.embedding.engine.dart;

import android.os.Handler;
import android.os.Looper;
import p242io.flutter.embedding.engine.dart.DartMessenger;

/* renamed from: io.flutter.embedding.engine.dart.PlatformTaskQueue */
public class PlatformTaskQueue implements DartMessenger.DartMessengerTaskQueue {

    /* renamed from: a */
    private final Handler f57621a = new Handler(Looper.getMainLooper());

    public void dispatch(Runnable runnable) {
        this.f57621a.post(runnable);
    }
}
