package com.datadog.android.core.internal.utils;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0000¨\u0006\t"}, mo175978d2 = {"indexOf", "", "", "b", "", "startIndex", "split", "", "delimiter", "dd-sdk-android_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ByteArrayExt.kt */
public final class ByteArrayExtKt {
    public static final List<byte[]> split(byte[] bArr, byte b) {
        int indexOf;
        int i;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        List<byte[]> arrayList = new ArrayList<>();
        int i2 = 0;
        do {
            indexOf = indexOf(bArr, b, i2);
            if (indexOf >= 0) {
                i = indexOf - i2;
            } else {
                i = bArr.length - i2;
            }
            if (i > 0) {
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, i2, bArr2, 0, i);
                arrayList.add(bArr2);
            }
            i2 = indexOf + 1;
        } while (indexOf != -1);
        return arrayList;
    }

    public static /* synthetic */ int indexOf$default(byte[] bArr, byte b, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return indexOf(bArr, b, i);
    }

    public static final int indexOf(byte[] bArr, byte b, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        if (i >= length) {
            return -1;
        }
        while (true) {
            int i2 = i + 1;
            if (bArr[i] == b) {
                return i;
            }
            if (i2 >= length) {
                return -1;
            }
            i = i2;
        }
    }
}
