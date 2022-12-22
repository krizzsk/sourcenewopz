package com.adyen.checkout.core.encryption;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/adyen/checkout/core/encryption/Sha256;", "", "()V", "SHA_256", "", "digest", "Ljava/security/MessageDigest;", "kotlin.jvm.PlatformType", "hash", "", "byteArray", "hashString", "string", "checkout-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Sha256.kt */
public final class Sha256 {
    public static final Sha256 INSTANCE = new Sha256();

    /* renamed from: a */
    private static final String f934a = "SHA-256";

    /* renamed from: b */
    private static final MessageDigest f935b = MessageDigest.getInstance("SHA-256");

    private Sha256() {
    }

    public final byte[] hash(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "byteArray");
        f935b.reset();
        f935b.update(bArr);
        byte[] digest = f935b.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "digest.digest()");
        return digest;
    }

    public final String hashString(String str) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return new String(hash(bytes), Charsets.UTF_8);
    }
}
