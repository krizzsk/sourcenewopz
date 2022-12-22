package com.jumio.commons.obfuscate;

import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\n"}, mo175978d2 = {"Lcom/jumio/commons/obfuscate/StringDeobfuscator;", "", "", "input", "", "seed", "", "deobfuscate", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: StringObfuscation.kt */
public final class StringDeobfuscator {
    public static final StringDeobfuscator INSTANCE = new StringDeobfuscator();

    @JvmStatic
    public static final String deobfuscate(byte[] bArr, long j) {
        Intrinsics.checkNotNullParameter(bArr, "input");
        byte[] bArr2 = new byte[bArr.length];
        new Random(j).nextBytes(bArr2);
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            bArr2[i2] = (byte) (bArr[i] ^ bArr2[i2]);
            i++;
            i2++;
        }
        return new String(bArr2, Charsets.UTF_8);
    }
}
