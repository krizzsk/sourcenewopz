package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeik;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzedc<P> {
    private final Class<P> zziek;
    private final ConcurrentMap<zzedh, List<zzede<P>>> zzier = new ConcurrentHashMap();
    private zzede<P> zzies;

    public final zzede<P> zzbbp() {
        return this.zzies;
    }

    private zzedc(Class<P> cls) {
        this.zziek = cls;
    }

    public static <P> zzedc<P> zzb(Class<P> cls) {
        return new zzedc<>(cls);
    }

    public final void zza(zzede<P> zzede) {
        if (zzede == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        } else if (zzede.zzbbr() == zzeid.ENABLED) {
            List list = (List) this.zzier.get(new zzedh(zzede.zzbbt()));
            if (list == null) {
                list = Collections.emptyList();
            }
            if (!list.isEmpty()) {
                this.zzies = zzede;
                return;
            }
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        } else {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        }
    }

    public final zzede<P> zza(P p, zzeik.zzb zzb) throws GeneralSecurityException {
        byte[] bArr;
        if (zzb.zzbbr() == zzeid.ENABLED) {
            int i = zzeco.zzieh[zzb.zzbbs().ordinal()];
            if (i == 1 || i == 2) {
                bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zzb.zzbfo()).array();
            } else if (i == 3) {
                bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zzb.zzbfo()).array();
            } else if (i == 4) {
                bArr = zzecp.zziei;
            } else {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            zzede zzede = new zzede(p, bArr, zzb.zzbbr(), zzb.zzbbs(), zzb.zzbfo());
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzede);
            zzedh zzedh = new zzedh(zzede.zzbbt());
            List list = (List) this.zzier.put(zzedh, Collections.unmodifiableList(arrayList));
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(list);
                arrayList2.add(zzede);
                this.zzier.put(zzedh, Collections.unmodifiableList(arrayList2));
            }
            return zzede;
        }
        throw new GeneralSecurityException("only ENABLED key is allowed");
    }

    public final Class<P> zzbbh() {
        return this.zziek;
    }
}
