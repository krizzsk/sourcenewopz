package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzmh;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzke {
    private static final zzml zzapi = new zzkd();
    private static final Pattern zzapj = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zzaib = -1;
    public int zzaic = -1;

    public final boolean zzb(zzmh zzmh) {
        for (int i = 0; i < zzmh.length(); i++) {
            zzmh.zza zzbb = zzmh.zzbb(i);
            if (zzbb instanceof zzmj) {
                zzmj zzmj = (zzmj) zzbb;
                if (zzb(zzmj.description, zzmj.text)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean zzb(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = zzapj.matcher(str2);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(matcher.group(1), 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.zzaib = parseInt;
                    this.zzaic = parseInt2;
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public final boolean zzgx() {
        return (this.zzaib == -1 || this.zzaic == -1) ? false : true;
    }
}
