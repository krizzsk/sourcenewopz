package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdpz {
    private final Pattern zzhon;

    public zzdpz() {
        Pattern pattern;
        try {
            pattern = Pattern.compile((String) zzww.zzra().zzd(zzabq.zzczw));
        } catch (PatternSyntaxException unused) {
            pattern = null;
        }
        this.zzhon = pattern;
    }

    public final String zzgu(String str) {
        Pattern pattern = this.zzhon;
        if (!(pattern == null || str == null)) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                return matcher.group();
            }
        }
        return null;
    }
}
