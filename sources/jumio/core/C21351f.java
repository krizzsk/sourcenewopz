package jumio.core;

import android.content.Context;
import com.jumio.core.network.C19998b;
import com.jumio.core.persistence.DataManager;

/* renamed from: jumio.core.f */
/* compiled from: ApiCallSettings.kt */
public interface C21351f {
    Context getContext();

    DataManager getDataManager();

    C19998b getEncryptionProvider();

    String getEndpoint();

    String getUserAgent();
}
