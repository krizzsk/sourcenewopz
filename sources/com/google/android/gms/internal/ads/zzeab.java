package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzeab implements FilenameFilter {
    private final Pattern zzhon;

    public zzeab(Pattern pattern) {
        this.zzhon = (Pattern) zzdyi.checkNotNull(pattern);
    }

    public final boolean accept(@NullableDecl File file, String str) {
        return this.zzhon.matcher(str).matches();
    }
}
