package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzepm extends zzepn<FieldDescriptorType, Object> {
    zzepm(int i) {
        super(i, (zzepm) null);
    }

    public final void zzbhe() {
        if (!isImmutable()) {
            for (int i = 0; i < zzblp(); i++) {
                Map.Entry zzic = zzic(i);
                if (((zzemv) zzic.getKey()).zzbje()) {
                    zzic.setValue(Collections.unmodifiableList((List) zzic.getValue()));
                }
            }
            for (Map.Entry entry : zzblq()) {
                if (((zzemv) entry.getKey()).zzbje()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzbhe();
    }
}
