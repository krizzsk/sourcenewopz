package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzdya {
    private final String className;
    private final zzdyd zzhyw;
    private zzdyd zzhyx;
    private boolean zzhyy;

    private zzdya(String str) {
        zzdyd zzdyd = new zzdyd();
        this.zzhyw = zzdyd;
        this.zzhyx = zzdyd;
        this.zzhyy = false;
        this.className = (String) zzdyi.checkNotNull(str);
    }

    public final zzdya zzy(@NullableDecl Object obj) {
        zzdyd zzdyd = new zzdyd();
        this.zzhyx.zzhyz = zzdyd;
        this.zzhyx = zzdyd;
        zzdyd.value = obj;
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.className);
        sb.append('{');
        zzdyd zzdyd = this.zzhyw.zzhyz;
        String str = "";
        while (zzdyd != null) {
            Object obj = zzdyd.value;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append(deepToString, 1, deepToString.length() - 1);
            }
            zzdyd = zzdyd.zzhyz;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
