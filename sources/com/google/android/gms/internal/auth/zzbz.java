package com.google.android.gms.internal.auth;

import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public abstract class zzbz extends FastSafeParcelableJsonResponse {
    public final byte[] toByteArray() {
        try {
            return toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            SystemUtils.log(6, "AUTH", "Error serializing object.", e, "com.google.android.gms.internal.auth.zzbz", 2);
            return null;
        }
    }
}
