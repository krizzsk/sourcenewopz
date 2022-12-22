package p242io.flutter.embedding.android;

import android.app.Activity;
import androidx.core.util.Consumer;
import androidx.window.java.layout.WindowInfoTrackerCallbackAdapter;
import androidx.window.layout.WindowLayoutInfo;
import java.util.concurrent.Executor;

/* renamed from: io.flutter.embedding.android.WindowInfoRepositoryCallbackAdapterWrapper */
public class WindowInfoRepositoryCallbackAdapterWrapper {

    /* renamed from: a */
    final WindowInfoTrackerCallbackAdapter f57556a;

    public WindowInfoRepositoryCallbackAdapterWrapper(WindowInfoTrackerCallbackAdapter windowInfoTrackerCallbackAdapter) {
        this.f57556a = windowInfoTrackerCallbackAdapter;
    }

    public void addWindowLayoutInfoListener(Activity activity, Executor executor, Consumer<WindowLayoutInfo> consumer) {
        this.f57556a.addWindowLayoutInfoListener(activity, executor, consumer);
    }

    public void removeWindowLayoutInfoListener(Consumer<WindowLayoutInfo> consumer) {
        this.f57556a.removeWindowLayoutInfoListener(consumer);
    }
}
