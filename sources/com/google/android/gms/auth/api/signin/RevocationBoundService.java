package com.google.android.gms.auth.api.signin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.auth.api.signin.internal.zbt;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class RevocationBoundService extends Service {
    public IBinder onBind(Intent intent) {
        if ("com.google.android.gms.auth.api.signin.RevocationBoundService.disconnect".equals(intent.getAction()) || "com.google.android.gms.auth.api.signin.RevocationBoundService.clearClientState".equals(intent.getAction())) {
            if (Log.isLoggable("RevocationService", 2)) {
                String valueOf = String.valueOf(intent.getAction());
                SystemUtils.log(2, "RevocationService", valueOf.length() != 0 ? "RevocationBoundService handling ".concat(valueOf) : new String("RevocationBoundService handling "), (Throwable) null, "com.google.android.gms.auth.api.signin.RevocationBoundService", 4);
            }
            return new zbt(this);
        }
        String valueOf2 = String.valueOf(intent.getAction());
        SystemUtils.log(5, "RevocationService", valueOf2.length() != 0 ? "Unknown action sent to RevocationBoundService: ".concat(valueOf2) : new String("Unknown action sent to RevocationBoundService: "), (Throwable) null, "com.google.android.gms.auth.api.signin.RevocationBoundService", 6);
        return null;
    }
}
