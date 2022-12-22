package com.cardinalcommerce.p060a;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* renamed from: com.cardinalcommerce.a.setShadowLayer */
public final class setShadowLayer extends ContentProvider {

    /* renamed from: a */
    private static int f2992a = 0;

    /* renamed from: b */
    private static int f2993b = 1;
    public static Context cca_continue;

    public final boolean onCreate() {
        int i = (f2992a + 2) - 1;
        f2993b = i % 128;
        if (i % 2 == 0) {
        }
        cca_continue = getContext();
        int i2 = f2992a;
        int i3 = i2 ^ 59;
        int i4 = (((i2 & 59) | i3) << 1) - i3;
        f2993b = i4 % 128;
        if ((i4 % 2 == 0 ? ';' : 9) != ';') {
            return false;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return false;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i = f2993b;
        int i2 = i ^ 103;
        boolean z = true;
        int i3 = ((i & 103) | i2) << 1;
        int i4 = -i2;
        int i5 = (i3 & i4) + (i3 | i4);
        f2992a = i5 % 128;
        if (i5 % 2 != 0) {
            z = false;
        }
        if (z) {
            return null;
        }
        int i6 = 74 / 0;
        return null;
    }

    /* JADX WARNING: type inference failed for: r3v5, types: [java.lang.String] */
    public final String getType(Uri uri) {
        int i = f2993b;
        boolean z = true;
        int i2 = ((i & -38) | ((~i) & 37)) + ((i & 37) << 1);
        f2992a = i2 % 128;
        if (i2 % 2 == 0) {
            z = false;
        }
        ? r3 = 0;
        if (z) {
            int length = r3.length;
        }
        return r3;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        int i = f2993b;
        int i2 = i & 65;
        int i3 = i2 + ((i ^ 65) | i2);
        f2992a = i3 % 128;
        int i4 = i3 % 2;
        int i5 = f2992a;
        int i6 = (i5 & 20) + (i5 | 20);
        int i7 = (i6 & -1) + (i6 | -1);
        f2993b = i7 % 128;
        Uri uri2 = null;
        if (!(i7 % 2 == 0)) {
            return uri2;
        }
        super.hashCode();
        return uri2;
    }

    public final int delete(Uri uri, String str, String[] strArr) {
        int i = (f2992a + 74) - 1;
        f2993b = i % 128;
        int i2 = i % 2;
        int i3 = f2993b;
        int i4 = ((i3 ^ 67) | (i3 & 67)) << 1;
        int i5 = -(((~i3) & 67) | (i3 & -68));
        int i6 = (i4 ^ i5) + ((i5 & i4) << 1);
        f2992a = i6 % 128;
        if (i6 % 2 == 0) {
            return 0;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return 0;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int i = f2993b;
        int i2 = i & 39;
        int i3 = (i ^ 39) | i2;
        int i4 = (i2 & i3) + (i3 | i2);
        f2992a = i4 % 128;
        int i5 = i4 % 2;
        int i6 = f2992a;
        int i7 = (i6 & 105) + (i6 | 105);
        f2993b = i7 % 128;
        if (!(i7 % 2 == 0)) {
            return 0;
        }
        int i8 = 26 / 0;
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (r5 != null) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
        throw new java.lang.NullPointerException("YourLibraryInitProvider ProviderInfo cannot be null.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        if (r5 != null) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void attachInfo(android.content.Context r4, android.content.pm.ProviderInfo r5) {
        /*
            r3 = this;
            int r0 = f2992a
            r1 = r0 & 45
            r2 = 45
            r0 = r0 ^ r2
            r0 = r0 | r1
            int r1 = r1 + r0
            int r0 = r1 % 128
            f2993b = r0
            int r1 = r1 % 2
            r0 = 0
            if (r1 != 0) goto L_0x0014
            r1 = 1
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            if (r1 == 0) goto L_0x001f
            r1 = 47
            int r1 = r1 / r0
            if (r5 == 0) goto L_0x0052
            goto L_0x0021
        L_0x001d:
            r4 = move-exception
            throw r4
        L_0x001f:
            if (r5 == 0) goto L_0x0052
        L_0x0021:
            java.lang.String r0 = r5.authority
            java.lang.String r1 = "${applicationId}.CCInitProvider"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x004a
            super.attachInfo(r4, r5)
            int r4 = f2992a
            r5 = r4 & 95
            r4 = r4 | 95
            int r5 = r5 + r4
            int r4 = r5 % 128
            f2993b = r4
            int r5 = r5 % 2
            if (r5 != 0) goto L_0x0040
            r4 = 45
            goto L_0x0042
        L_0x0040:
            r4 = 41
        L_0x0042:
            if (r4 == r2) goto L_0x0045
            return
        L_0x0045:
            r4 = 0
            int r4 = r4.length     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r4 = move-exception
            throw r4
        L_0x004a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle."
            r4.<init>(r5)
            throw r4
        L_0x0052:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r5 = "YourLibraryInitProvider ProviderInfo cannot be null."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setShadowLayer.attachInfo(android.content.Context, android.content.pm.ProviderInfo):void");
    }
}
