package com.cardinalcommerce.dependencies.internal.nimbusds.jose.util;

import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class X509CertUtils {
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        r2 = r2.substring(r1 + 27);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.cert.X509Certificate getInstance(java.lang.String r2) {
        /*
            r0 = 0
            if (r2 == 0) goto L_0x003d
            boolean r1 = r2.isEmpty()
            if (r1 == 0) goto L_0x000a
            goto L_0x003d
        L_0x000a:
            java.lang.String r1 = "-----BEGIN CERTIFICATE-----"
            int r1 = r2.indexOf(r1)
            if (r1 >= 0) goto L_0x0013
            return r0
        L_0x0013:
            int r1 = r1 + 27
            java.lang.String r2 = r2.substring(r1)
            java.lang.String r1 = "-----END CERTIFICATE-----"
            int r1 = r2.indexOf(r1)
            if (r1 >= 0) goto L_0x0022
            return r0
        L_0x0022:
            r0 = 0
            java.lang.String r2 = r2.substring(r0, r1)
            java.lang.String r0 = "\\s"
            java.lang.String r1 = ""
            java.lang.String r2 = r2.replaceAll(r0, r1)
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64 r0 = new com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64
            r0.<init>(r2)
            byte[] r2 = r0.cca_continue()
            java.security.cert.X509Certificate r2 = cca_continue(r2)
            return r2
        L_0x003d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.X509CertUtils.getInstance(java.lang.String):java.security.cert.X509Certificate");
    }

    public static X509Certificate cca_continue(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
                    if (generateCertificate instanceof X509Certificate) {
                        return (X509Certificate) generateCertificate;
                    }
                    StringBuilder sb = new StringBuilder("Not a X.509 certificate: ");
                    sb.append(generateCertificate.getType());
                    throw new CertificateException(sb.toString());
                }
            } catch (CertificateException unused) {
            }
        }
        return null;
    }
}
