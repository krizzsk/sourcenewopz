package com.google.android.gms.internal.ads;

import org.apache.commons.p071io.IOUtils;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public abstract class zzdxr {
    public static zzdxr zzb(char c) {
        return new zzdxt(c);
    }

    public abstract boolean zzc(char c);

    protected zzdxr() {
    }

    public int zza(CharSequence charSequence, int i) {
        int length = charSequence.length();
        zzdyi.zzb(i, length, "index");
        while (i < length) {
            if (zzc(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static String zzd(char c) {
        char[] cArr = {IOUtils.DIR_SEPARATOR_WINDOWS, 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = C2382a.f4810a.charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }
}
