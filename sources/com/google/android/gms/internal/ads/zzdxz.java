package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzdxz {
    private final String separator;

    public static zzdxz zzhl(String str) {
        return new zzdxz(str);
    }

    private zzdxz(String str) {
        this.separator = (String) zzdyi.checkNotNull(str);
    }

    public final StringBuilder zza(StringBuilder sb, Iterator<?> it) {
        try {
            zzdyi.checkNotNull(sb);
            if (it.hasNext()) {
                sb.append(zzx(it.next()));
                while (it.hasNext()) {
                    sb.append(this.separator);
                    sb.append(zzx(it.next()));
                }
            }
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    private static CharSequence zzx(Object obj) {
        zzdyi.checkNotNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
