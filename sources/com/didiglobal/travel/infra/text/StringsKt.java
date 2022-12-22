package com.didiglobal.travel.infra.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000J\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\u0018\u0001H\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\b¢\u0006\u0002\u0010\u0005\u001a \u0010\u0006\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\u0018\u0001H\u0001H\b¢\u0006\u0002\u0010\u0007\u001a\u001b\u0010\b\u001a\u00020\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\b\u001a\u001b\u0010\f\u001a\u00020\r*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\u0004H\b\u001a\u001b\u0010\u000e\u001a\u00020\u000f*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004H\b\u001a\u001b\u0010\u0010\u001a\u00020\u0011*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004H\b\u001a\u001b\u0010\u0012\u001a\u00020\u0013*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004H\b\u001a\u001b\u0010\u0014\u001a\u00020\u0015*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004H\b\u001a2\u0010\u0016\u001a\u00020\u0017\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\u0018\u0001H\u00012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00170\u0019H\b¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, mo175978d2 = {"orDefault", "T", "", "provider", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/CharSequence;", "takeIfNotEmpty", "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "toByteOr", "", "", "fallback", "toDoubleOr", "", "toFloatOr", "", "toIntOr", "", "toLongOr", "", "toShortOr", "", "withNotEmpty", "", "action", "Lkotlin/Function1;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)V", "lib-common_release"}, mo175979k = 2, mo175980mv = {1, 1, 16})
/* compiled from: Strings.kt */
public final class StringsKt {
    public static final <T extends CharSequence> T takeIfNotEmpty(T t) {
        if (t != null) {
            if (t.length() > 0) {
                return t;
            }
        }
        return null;
    }

    public static final byte toByteOr(String str, Function0<Byte> function0) {
        Byte byteOrNull;
        Intrinsics.checkParameterIsNotNull(str, "$this$toByteOr");
        Intrinsics.checkParameterIsNotNull(function0, "fallback");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        String str2 = (String) charSequence;
        return (str2 == null || (byteOrNull = kotlin.text.StringsKt.toByteOrNull(str2)) == null) ? function0.invoke().byteValue() : byteOrNull.byteValue();
    }

    public static final short toShortOr(String str, Function0<Short> function0) {
        Short shortOrNull;
        Intrinsics.checkParameterIsNotNull(str, "$this$toShortOr");
        Intrinsics.checkParameterIsNotNull(function0, "fallback");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        String str2 = (String) charSequence;
        return (str2 == null || (shortOrNull = kotlin.text.StringsKt.toShortOrNull(str2)) == null) ? function0.invoke().shortValue() : shortOrNull.shortValue();
    }

    public static final int toIntOr(String str, Function0<Integer> function0) {
        Integer intOrNull;
        Intrinsics.checkParameterIsNotNull(str, "$this$toIntOr");
        Intrinsics.checkParameterIsNotNull(function0, "fallback");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        String str2 = (String) charSequence;
        return (str2 == null || (intOrNull = kotlin.text.StringsKt.toIntOrNull(str2)) == null) ? function0.invoke().intValue() : intOrNull.intValue();
    }

    public static final long toLongOr(String str, Function0<Long> function0) {
        Long longOrNull;
        Intrinsics.checkParameterIsNotNull(str, "$this$toLongOr");
        Intrinsics.checkParameterIsNotNull(function0, "fallback");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        String str2 = (String) charSequence;
        return (str2 == null || (longOrNull = kotlin.text.StringsKt.toLongOrNull(str2)) == null) ? function0.invoke().longValue() : longOrNull.longValue();
    }

    public static final float toFloatOr(String str, Function0<Float> function0) {
        Float floatOrNull;
        Intrinsics.checkParameterIsNotNull(str, "$this$toFloatOr");
        Intrinsics.checkParameterIsNotNull(function0, "fallback");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        String str2 = (String) charSequence;
        return (str2 == null || (floatOrNull = kotlin.text.StringsKt.toFloatOrNull(str2)) == null) ? function0.invoke().floatValue() : floatOrNull.floatValue();
    }

    public static final double toDoubleOr(String str, Function0<Double> function0) {
        Double doubleOrNull;
        Intrinsics.checkParameterIsNotNull(str, "$this$toDoubleOr");
        Intrinsics.checkParameterIsNotNull(function0, "fallback");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0)) {
            charSequence = null;
        }
        String str2 = (String) charSequence;
        return (str2 == null || (doubleOrNull = kotlin.text.StringsKt.toDoubleOrNull(str2)) == null) ? function0.invoke().doubleValue() : doubleOrNull.doubleValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        if ((r2.length() > 0) != false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends java.lang.CharSequence> T orDefault(T r2, kotlin.jvm.functions.Function0<? extends T> r3) {
        /*
            java.lang.String r0 = "provider"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            r0 = 0
            if (r2 == 0) goto L_0x0014
            int r1 = r2.length()
            if (r1 <= 0) goto L_0x0010
            r1 = 1
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            if (r1 == 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r2 = r0
        L_0x0015:
            if (r2 == 0) goto L_0x0018
            goto L_0x001e
        L_0x0018:
            java.lang.Object r2 = r3.invoke()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
        L_0x001e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.travel.infra.text.StringsKt.orDefault(java.lang.CharSequence, kotlin.jvm.functions.Function0):java.lang.CharSequence");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        if ((r2.length() > 0) != false) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends java.lang.CharSequence> void withNotEmpty(T r2, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r3) {
        /*
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            r0 = 0
            if (r2 == 0) goto L_0x0014
            int r1 = r2.length()
            if (r1 <= 0) goto L_0x0010
            r1 = 1
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            if (r1 == 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r2 = r0
        L_0x0015:
            if (r2 == 0) goto L_0x001a
            r3.invoke(r2)
        L_0x001a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.travel.infra.text.StringsKt.withNotEmpty(java.lang.CharSequence, kotlin.jvm.functions.Function1):void");
    }
}
