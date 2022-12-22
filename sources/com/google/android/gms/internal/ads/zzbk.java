package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzbk extends zzab<String> {
    private final Object mLock = new Object();
    private zzai<String> zzcy;

    public zzbk(int i, String str, zzai<String> zzai, zzaj zzaj) {
        super(i, str, zzaj);
        this.zzcy = zzai;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzi */
    public void zza(String str) {
        zzai<String> zzai;
        synchronized (this.mLock) {
            zzai = this.zzcy;
        }
        if (zzai != null) {
            zzai.zzb(str);
        }
    }

    /* access modifiers changed from: protected */
    public final zzag<String> zza(zzz zzz) {
        String str;
        String str2;
        try {
            byte[] bArr = zzz.data;
            Map<String, String> map = zzz.zzaj;
            String str3 = "ISO-8859-1";
            if (map != null && (str2 = map.get("Content-Type")) != null) {
                String[] split = str2.split(";", 0);
                int i = 1;
                while (true) {
                    if (i >= split.length) {
                        break;
                    }
                    String[] split2 = split[i].trim().split("=", 0);
                    if (split2.length == 2 && split2[0].equals("charset")) {
                        str3 = split2[1];
                        break;
                    }
                    i++;
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzz.data);
        }
        return zzag.zza(str, zzbc.zzb(zzz));
    }
}
