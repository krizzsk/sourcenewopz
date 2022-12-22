package com.jumio.core.network;

import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import jumio.core.C21374p0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* renamed from: com.jumio.core.network.a */
/* compiled from: AWSTrustManager.kt */
public final class C19997a extends JumioTrustManager {

    /* renamed from: c */
    public final byte[][] f54909c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C19997a(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "hostname");
        C21374p0 p0Var = C21374p0.f59668a;
        this.f54909c = new byte[][]{p0Var.mo175870a("fbe3018031f9586bcbf41727e417b7d1c45c2f47f93be372a17b96b50757d5a2"), p0Var.mo175870a("7f4296fc5b6a4e3b35d3c369623e364ab1af381d8fa7121533c9d6c633ea2461"), p0Var.mo175870a("36abc32656acfc645c61b71613c4bf21c787f5cabbee48348d58597803d7abc9"), p0Var.mo175870a("f7ecded5c66047d28ed6466b543c40e0743abe81d109254dcf845d4c2c7853c5"), p0Var.mo175870a("2b071c59a0a0ae76b0eadb2bad23bad4580b69c3601b630c2eaf0613afa83f92")};
    }

    public void checkCertificateChain(X509Certificate[] x509CertificateArr) throws CertificateException {
        boolean z;
        Intrinsics.checkNotNullParameter(x509CertificateArr, "x509Certificates");
        byte[] digest = MessageDigest.getInstance("SHA-256").digest(x509CertificateArr[x509CertificateArr.length - 1].getPublicKey().getEncoded());
        byte[][] bArr = this.f54909c;
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (Arrays.equals(digest, bArr[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            X509Certificate x509Certificate = x509CertificateArr[0];
            checkCertificate(x509Certificate);
            String name = x509Certificate.getSubjectDN().getName();
            Intrinsics.checkNotNullExpressionValue(name, "clientCertificate.subjectDN.name");
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < name.length(); i2++) {
                char charAt = name.charAt(i2);
                if (!CharsKt.isWhitespace(charAt)) {
                    sb.append(charAt);
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "filterNotTo(StringBuilder(), predicate).toString()");
            if (!StringsKt.contains((CharSequence) sb2, (CharSequence) Intrinsics.stringPlus("CN=", getHostname()), true)) {
                throw new CertificateException("Certificate pinning failed");
            }
            return;
        }
        throw new CertificateException("Certificate pinning failed");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        Intrinsics.checkNotNullParameter(x509CertificateArr, "chain");
        Intrinsics.checkNotNullParameter(str, "authType");
        super.checkServerTrusted(x509CertificateArr, str);
    }
}
