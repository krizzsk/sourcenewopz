package com.google.android.gms.internal.firebase_messaging;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
final /* synthetic */ class zzaa implements ObjectEncoder {
    static final ObjectEncoder zza = new zzaa();

    private zzaa() {
    }

    public final void encode(Object obj, Object obj2) {
        zzab.zzg((Map.Entry) obj, (ObjectEncoderContext) obj2);
    }
}
