package com.iproov.sdk.core;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.iproov.sdk.core.public */
/* compiled from: RootedDetector.kt */
public final class C19901public {
    /* renamed from: do */
    public static /* synthetic */ String[] m39248do(String str, String[] strArr, int i, Object obj) {
        if ((i & 1) != 0) {
            strArr = null;
        }
        return m39247do(str, strArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0058, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        kotlin.p245io.CloseableKt.closeFinally(r1, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005c, code lost:
        throw r2;
     */
    /* renamed from: do */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String[] m39247do(java.lang.String r8, java.lang.String[] r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException | NoSuchElementException -> 0x0062 }
            java.lang.Process r8 = r1.exec(r8, r9)     // Catch:{ IOException | NoSuchElementException -> 0x0062 }
            java.io.InputStream r9 = r8.getInputStream()     // Catch:{ all -> 0x005d }
            java.util.Scanner r1 = new java.util.Scanner     // Catch:{ all -> 0x005d }
            r1.<init>(r9)     // Catch:{ all -> 0x005d }
            java.lang.String r9 = "\\A"
            java.util.Scanner r9 = r1.useDelimiter(r9)     // Catch:{ all -> 0x0056 }
            java.lang.String r2 = r9.next()     // Catch:{ all -> 0x0056 }
            java.lang.String r9 = "scanner.useDelimiter(\"\\\\A\").next()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)     // Catch:{ all -> 0x0056 }
            java.lang.String r9 = "\n"
            java.lang.String[] r3 = new java.lang.String[]{r9}     // Catch:{ all -> 0x0056 }
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            java.util.List r9 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r2, (java.lang.String[]) r3, (boolean) r4, (int) r5, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x0056 }
            r2 = 0
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch:{ all -> 0x0056 }
            java.lang.Object[] r9 = r9.toArray(r3)     // Catch:{ all -> 0x0056 }
            if (r9 == 0) goto L_0x004e
            java.lang.String[] r9 = (java.lang.String[]) r9     // Catch:{ all -> 0x0056 }
            kotlin.p245io.CloseableKt.closeFinally(r1, r0)     // Catch:{ all -> 0x005d }
            int r1 = r9.length     // Catch:{ all -> 0x005d }
            if (r1 != 0) goto L_0x0046
            r2 = 1
        L_0x0046:
            if (r2 == 0) goto L_0x0049
            r9 = r0
        L_0x0049:
            r8.destroy()     // Catch:{ IOException | NoSuchElementException -> 0x0062 }
            r0 = r9
            goto L_0x0062
        L_0x004e:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException     // Catch:{ all -> 0x0056 }
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            r9.<init>(r2)     // Catch:{ all -> 0x0056 }
            throw r9     // Catch:{ all -> 0x0056 }
        L_0x0056:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0058 }
        L_0x0058:
            r2 = move-exception
            kotlin.p245io.CloseableKt.closeFinally(r1, r9)     // Catch:{ all -> 0x005d }
            throw r2     // Catch:{ all -> 0x005d }
        L_0x005d:
            r9 = move-exception
            r8.destroy()     // Catch:{ IOException | NoSuchElementException -> 0x0062 }
            throw r9     // Catch:{ IOException | NoSuchElementException -> 0x0062 }
        L_0x0062:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.core.C19901public.m39247do(java.lang.String, java.lang.String[]):java.lang.String[]");
    }

    /* renamed from: do */
    public static final boolean m39245do(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, SDKConsts.TAG_KEY_FILENAME);
        return new File(str, str2).exists();
    }

    /* renamed from: do */
    public static final boolean m39246do(List<Boolean> list) {
        T t;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((Boolean) t).booleanValue()) {
                break;
            }
        }
        Boolean bool = (Boolean) t;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
