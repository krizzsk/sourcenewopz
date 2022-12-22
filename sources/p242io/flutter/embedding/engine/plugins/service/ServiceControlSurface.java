package p242io.flutter.embedding.engine.plugins.service;

import android.app.Service;
import androidx.lifecycle.Lifecycle;

/* renamed from: io.flutter.embedding.engine.plugins.service.ServiceControlSurface */
public interface ServiceControlSurface {
    void attachToService(Service service, Lifecycle lifecycle, boolean z);

    void detachFromService();

    void onMoveToBackground();

    void onMoveToForeground();
}
