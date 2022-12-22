package com.didiglobal.travel.infra.text;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\b"}, mo175978d2 = {"Lcom/didiglobal/travel/infra/text/StringUtils;", "", "()V", "valueOrDefault", "", "text", "defaultVal", "valueOrEmpty", "lib-common_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: JStringUtils.kt */
public final class StringUtils {
    public static final StringUtils INSTANCE = new StringUtils();

    @JvmStatic
    public static final String valueOrEmpty(String str) {
        return str != null ? str : "";
    }

    private StringUtils() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if ((r2.length() > 0) != false) goto L_0x0017;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String valueOrDefault(java.lang.String r2, java.lang.String r3) {
        /*
            java.lang.String r0 = "defaultVal"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0 = 0
            if (r2 == 0) goto L_0x0016
            int r1 = r2.length()
            if (r1 <= 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            if (r1 == 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r2 = r0
        L_0x0017:
            if (r2 == 0) goto L_0x001a
            goto L_0x001d
        L_0x001a:
            r2 = r3
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
        L_0x001d:
            java.lang.String r2 = (java.lang.String) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.travel.infra.text.StringUtils.valueOrDefault(java.lang.String, java.lang.String):java.lang.String");
    }
}
