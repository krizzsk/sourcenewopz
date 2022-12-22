package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSObject;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.X509CertUtils;
import com.cardinalcommerce.emvco.parameters.ChallengeParameters;
import com.cardinalcommerce.shared.models.exceptions.SDKRuntimeException;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.setImageTintBlendMode */
public final class setImageTintBlendMode {

    /* renamed from: d */
    private static int f2818d = 0;

    /* renamed from: e */
    private static int f2819e = 1;

    /* renamed from: a */
    private final setProgressDrawable f2820a;

    /* renamed from: b */
    private setProgressBackgroundTintMode f2821b;

    /* renamed from: c */
    private char[] f2822c;
    public String cca_continue;
    public setIndeterminateDrawableTiled configure;

    public setImageTintBlendMode() {
    }

    public setImageTintBlendMode(ChallengeParameters challengeParameters, setProgressDrawable setprogressdrawable) throws SDKRuntimeException {
        this.f2821b = setProgressBackgroundTintMode.init();
        this.f2820a = setprogressdrawable;
        this.f2822c = setHorizontallyScrolling.getInstance(challengeParameters.get3DSServerTransactionID());
        try {
            String acsSignedContent = challengeParameters.getAcsSignedContent();
            X509Certificate instance = X509CertUtils.getInstance(new setMaxHeight(this.f2820a.init).getInstance(this.f2820a.cca_continue));
            JWSObject cca_continue2 = JWSObject.cca_continue(acsSignedContent);
            boolean z = setHeight.Cardinal;
            m2002a(cca_continue2, instance);
            JSONObject jSONObject = new JSONObject(cca_continue2.cca_continue.toString());
            if (jSONObject.has("acsURL")) {
                this.cca_continue = jSONObject.optString("acsURL");
                this.configure = new setIndeterminateDrawableTiled(jSONObject.optJSONObject("acsEphemPubKey"));
                new setIndeterminateDrawableTiled(jSONObject.optJSONObject("sdkEphemPubKey"));
                return;
            }
            throw new SDKRuntimeException("Invalid ACSUrl \n", new Throwable("ACS signed content failed"));
        } catch (Exception e) {
            setProgressBackgroundTintMode setprogressbackgroundtintmode = this.f2821b;
            StringBuilder sb = new StringBuilder("ACSSignedContent Exception \n");
            sb.append(e.getLocalizedMessage());
            setprogressbackgroundtintmode.init(new setImageMatrix(11404, sb.toString()));
            throw new SDKRuntimeException("ACSSignedContent Exception ", e.getCause());
        }
    }

    public final char[] init() {
        int i = f2818d;
        int i2 = (i ^ 17) + ((i & 17) << 1);
        f2819e = i2 % 128;
        int i3 = i2 % 2;
        char[] cArr = this.f2822c;
        int i4 = f2819e;
        int i5 = (i4 & 83) + (i4 | 83);
        f2818d = i5 % 128;
        if ((i5 % 2 != 0 ? '3' : ' ') == ' ') {
            return cArr;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return cArr;
    }

    /* renamed from: a */
    private X509Certificate m2001a(String str) {
        CertificateFactory certificateFactory;
        int i = f2818d;
        int i2 = (i ^ 22) + ((i & 22) << 1);
        int i3 = (i2 & -1) + (i2 | -1);
        f2819e = i3 % 128;
        int i4 = i3 % 2;
        Certificate certificate = null;
        try {
            certificateFactory = CertificateFactory.getInstance("X.509", setProgressDrawableTiled.cca_continue);
            int i5 = (f2819e + 62) - 1;
            f2818d = i5 % 128;
            int i6 = i5 % 2;
        } catch (CertificateException e) {
            setProgressBackgroundTintMode setprogressbackgroundtintmode = this.f2821b;
            StringBuilder sb = new StringBuilder("Certificate Exception \n");
            sb.append(e.getLocalizedMessage());
            setprogressbackgroundtintmode.cca_continue("EMVCoInitialize", sb.toString());
            certificateFactory = null;
        }
        if (certificateFactory != null) {
            try {
                certificate = certificateFactory.generateCertificate(new ByteArrayInputStream(str.getBytes()));
                int i7 = f2819e;
                int i8 = i7 & 15;
                int i9 = (((i7 ^ 15) | i8) << 1) - ((i7 | 15) & (~i8));
                f2818d = i9 % 128;
                int i10 = i9 % 2;
            } catch (CertificateException e2) {
                setProgressBackgroundTintMode setprogressbackgroundtintmode2 = this.f2821b;
                StringBuilder sb2 = new StringBuilder("Certificate Exception \n");
                sb2.append(e2.getLocalizedMessage());
                setprogressbackgroundtintmode2.init(new setImageMatrix(11404, sb2.toString()));
                throw new SDKRuntimeException("ACSSignedContent Exception ", e2.getCause());
            }
        } else {
            int i11 = ((f2819e + 83) - 1) - 1;
            f2818d = i11 % 128;
            int i12 = i11 % 2;
        }
        X509Certificate x509Certificate = (X509Certificate) certificate;
        int i13 = f2819e;
        int i14 = i13 & 95;
        int i15 = ((i13 ^ 95) | i14) << 1;
        int i16 = -((i13 | 95) & (~i14));
        int i17 = ((i15 | i16) << 1) - (i16 ^ i15);
        f2818d = i17 % 128;
        int i18 = i17 % 2;
        return x509Certificate;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f7, code lost:
        if ((r0.equals(com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.getSDKVersion)) != false) goto L_0x011e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01a5 A[SYNTHETIC, Splitter:B:53:0x01a5] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2002a(com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSObject r10, java.security.cert.X509Certificate r11) {
        /*
            r9 = this;
            com.cardinalcommerce.a.setButtonTintList r0 = r10.configure
            java.util.List r0 = r0.cca_continue()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
            int r2 = f2819e
            r3 = 65
            r4 = r2 & -66
            int r5 = ~r2
            r5 = r5 & r3
            r4 = r4 | r5
            r2 = r2 & r3
            r3 = 1
            int r2 = r2 << r3
            r5 = r4 | r2
            int r5 = r5 << r3
            r2 = r2 ^ r4
            int r5 = r5 - r2
            int r2 = r5 % 128
            f2818d = r2
            int r5 = r5 % 2
        L_0x0026:
            boolean r2 = r0.hasNext()
            java.lang.String r4 = "Invalid Signature Exception: "
            r5 = 11404(0x2c8c, float:1.598E-41)
            r6 = 0
            if (r2 == 0) goto L_0x008d
            java.lang.Object r2 = r0.next()
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64 r2 = (com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64) r2
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0066 }
            java.lang.String r8 = "-----BEGIN CERTIFICATE-----\n"
            r7.<init>(r8)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0066 }
            r7.append(r2)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r2 = "\n-----END CERTIFICATE-----"
            r7.append(r2)     // Catch:{ Exception -> 0x0066 }
            java.lang.String r2 = r7.toString()     // Catch:{ Exception -> 0x0066 }
            java.security.cert.X509Certificate r2 = r9.m2001a(r2)     // Catch:{ Exception -> 0x0066 }
            r1.add(r2)     // Catch:{ Exception -> 0x0066 }
            int r2 = f2819e
            r4 = r2 ^ 96
            r2 = r2 & 96
            int r2 = r2 << r3
            int r4 = r4 + r2
            int r4 = r4 - r6
            int r4 = r4 - r3
            int r2 = r4 % 128
            f2818d = r2
            int r4 = r4 % 2
            goto L_0x0026
        L_0x0066:
            r10 = move-exception
            com.cardinalcommerce.a.setProgressBackgroundTintMode r11 = r9.f2821b
            com.cardinalcommerce.a.setImageMatrix r0 = new com.cardinalcommerce.a.setImageMatrix
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
            java.lang.String r2 = r10.getLocalizedMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r5, r1)
            r11.init(r0)
            com.cardinalcommerce.shared.models.exceptions.SDKRuntimeException r11 = new com.cardinalcommerce.shared.models.exceptions.SDKRuntimeException
            java.lang.Throwable r10 = r10.getCause()
            java.lang.String r0 = "ACSSignedContent Exception "
            r11.<init>(r0, r10)
            throw r11
        L_0x008d:
            java.security.cert.TrustAnchor r0 = new java.security.cert.TrustAnchor     // Catch:{ Exception -> 0x01df }
            r2 = 0
            r0.<init>(r11, r2)     // Catch:{ Exception -> 0x01df }
            java.util.Set r11 = java.util.Collections.singleton(r0)     // Catch:{ Exception -> 0x01df }
            java.lang.String r0 = "X.509"
            java.security.cert.CertificateFactory r0 = java.security.cert.CertificateFactory.getInstance(r0)     // Catch:{ Exception -> 0x01df }
            java.security.cert.CertPath r0 = r0.generateCertPath(r1)     // Catch:{ Exception -> 0x01df }
            java.security.cert.PKIXParameters r1 = new java.security.cert.PKIXParameters     // Catch:{ Exception -> 0x01df }
            r1.<init>(r11)     // Catch:{ Exception -> 0x01df }
            r1.setRevocationEnabled(r6)     // Catch:{ Exception -> 0x01df }
            java.lang.String r11 = "PKIX"
            java.security.cert.CertPathValidator r11 = java.security.cert.CertPathValidator.getInstance(r11)     // Catch:{ Exception -> 0x01df }
            r11.validate(r0, r1)     // Catch:{ Exception -> 0x01df }
            int r11 = f2819e
            r0 = r11 ^ 54
            r11 = r11 & 54
            int r11 = r11 << r3
            int r0 = r0 + r11
            r11 = r0 | -1
            int r11 = r11 << r3
            r0 = r0 ^ -1
            int r11 = r11 - r0
            int r0 = r11 % 128
            f2818d = r0
            int r11 = r11 % 2
            int r11 = f2818d
            int r11 = r11 + 115
            int r0 = r11 % 128
            f2819e = r0
            int r11 = r11 % 2
            r0 = 28
            if (r11 != 0) goto L_0x00d7
            r11 = 63
            goto L_0x00d9
        L_0x00d7:
            r11 = 28
        L_0x00d9:
            java.lang.String r1 = "JWS validation failed."
            if (r11 == r0) goto L_0x00fc
            com.cardinalcommerce.a.setButtonTintList r11 = r10.configure
            java.util.List r11 = r11.cca_continue()
            com.cardinalcommerce.a.setButtonTintList r0 = r10.configure
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r0 = r0.getInstance()
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r2 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.getSDKVersion     // Catch:{ JOSEException -> 0x01b8 }
            boolean r2 = r0.equals(r2)     // Catch:{ JOSEException -> 0x01b8 }
            r4 = 69
            int r4 = r4 / r6
            if (r2 != 0) goto L_0x00f6
            r2 = 0
            goto L_0x00f7
        L_0x00f6:
            r2 = 1
        L_0x00f7:
            if (r2 == 0) goto L_0x0116
            goto L_0x011e
        L_0x00fa:
            r10 = move-exception
            throw r10
        L_0x00fc:
            com.cardinalcommerce.a.setButtonTintList r11 = r10.configure
            java.util.List r11 = r11.cca_continue()
            com.cardinalcommerce.a.setButtonTintList r0 = r10.configure
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r0 = r0.getInstance()
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r2 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.getSDKVersion     // Catch:{ JOSEException -> 0x01b8 }
            boolean r2 = r0.equals(r2)     // Catch:{ JOSEException -> 0x01b8 }
            if (r2 != 0) goto L_0x0112
            r2 = 0
            goto L_0x0113
        L_0x0112:
            r2 = 1
        L_0x0113:
            if (r2 == 0) goto L_0x0116
            goto L_0x011e
        L_0x0116:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r2 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.Cardinal     // Catch:{ JOSEException -> 0x01b8 }
            boolean r2 = r0.equals(r2)     // Catch:{ JOSEException -> 0x01b8 }
            if (r2 == 0) goto L_0x0153
        L_0x011e:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.RSASSAVerifier r0 = new com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.RSASSAVerifier     // Catch:{ JOSEException -> 0x01b8 }
            java.lang.Object r11 = r11.get(r6)     // Catch:{ JOSEException -> 0x01b8 }
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64 r11 = (com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64) r11     // Catch:{ JOSEException -> 0x01b8 }
            byte[] r11 = r11.cca_continue()     // Catch:{ JOSEException -> 0x01b8 }
            java.security.cert.X509Certificate r11 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.X509CertUtils.cca_continue(r11)     // Catch:{ JOSEException -> 0x01b8 }
            java.security.PublicKey r11 = r11.getPublicKey()     // Catch:{ JOSEException -> 0x01b8 }
            java.security.interfaces.RSAPublicKey r11 = (java.security.interfaces.RSAPublicKey) r11     // Catch:{ JOSEException -> 0x01b8 }
            r0.<init>(r11)     // Catch:{ JOSEException -> 0x01b8 }
            com.cardinalcommerce.a.setColorFilter r11 = r0.Cardinal()     // Catch:{ JOSEException -> 0x01b8 }
            com.cardinalcommerce.a.JWK r2 = com.cardinalcommerce.p060a.setProgressDrawableTiled.cca_continue     // Catch:{ JOSEException -> 0x01b8 }
            r11.Cardinal = r2     // Catch:{ JOSEException -> 0x01b8 }
            int r11 = f2819e
            r2 = r11 & 95
            r11 = r11 ^ 95
            r11 = r11 | r2
            int r11 = -r11
            int r11 = -r11
            r4 = r2 & r11
            r11 = r11 | r2
            int r4 = r4 + r11
            int r11 = r4 % 128
            f2818d = r11
        L_0x0150:
            int r4 = r4 % 2
            goto L_0x018f
        L_0x0153:
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm r2 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSAlgorithm.getWarnings     // Catch:{ JOSEException -> 0x01b8 }
            boolean r0 = r0.equals(r2)     // Catch:{ JOSEException -> 0x01b8 }
            if (r0 == 0) goto L_0x01ab
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.ECDSAVerifier r0 = new com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.ECDSAVerifier     // Catch:{ JOSEException -> 0x01b8 }
            java.lang.Object r11 = r11.get(r6)     // Catch:{ JOSEException -> 0x01b8 }
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64 r11 = (com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64) r11     // Catch:{ JOSEException -> 0x01b8 }
            byte[] r11 = r11.cca_continue()     // Catch:{ JOSEException -> 0x01b8 }
            java.security.cert.X509Certificate r11 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.X509CertUtils.cca_continue(r11)     // Catch:{ JOSEException -> 0x01b8 }
            java.security.PublicKey r11 = r11.getPublicKey()     // Catch:{ JOSEException -> 0x01b8 }
            java.security.interfaces.ECPublicKey r11 = (java.security.interfaces.ECPublicKey) r11     // Catch:{ JOSEException -> 0x01b8 }
            r0.<init>(r11)     // Catch:{ JOSEException -> 0x01b8 }
            com.cardinalcommerce.a.setColorFilter r11 = r0.Cardinal()     // Catch:{ JOSEException -> 0x01b8 }
            com.cardinalcommerce.a.JWK r2 = com.cardinalcommerce.p060a.setProgressDrawableTiled.cca_continue     // Catch:{ JOSEException -> 0x01b8 }
            r11.Cardinal = r2     // Catch:{ JOSEException -> 0x01b8 }
            int r11 = f2818d
            r2 = r11 ^ 21
            r11 = r11 & 21
            r11 = r11 | r2
            int r11 = r11 << r3
            int r2 = -r2
            r4 = r11 | r2
            int r4 = r4 << r3
            r11 = r11 ^ r2
            int r4 = r4 - r11
            int r11 = r4 % 128
            f2819e = r11
            goto L_0x0150
        L_0x018f:
            boolean r10 = r10.configure(r0)     // Catch:{ JOSEException -> 0x01b8 }
            if (r10 == 0) goto L_0x01a5
            int r10 = f2819e
            r11 = r10 & 43
            r10 = r10 | 43
            int r10 = ~r10
            int r11 = r11 - r10
            int r11 = r11 - r3
            int r10 = r11 % 128
            f2818d = r10
            int r11 = r11 % 2
            return
        L_0x01a5:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ JOSEException -> 0x01b8 }
            r10.<init>(r1)     // Catch:{ JOSEException -> 0x01b8 }
            throw r10     // Catch:{ JOSEException -> 0x01b8 }
        L_0x01ab:
            java.lang.Throwable r10 = new java.lang.Throwable     // Catch:{ JOSEException -> 0x01b8 }
            java.lang.String r11 = "Invalid JWSAlgorithm"
            r10.<init>(r11)     // Catch:{ JOSEException -> 0x01b8 }
            com.cardinalcommerce.shared.models.exceptions.SDKRuntimeException r11 = new com.cardinalcommerce.shared.models.exceptions.SDKRuntimeException     // Catch:{ JOSEException -> 0x01b8 }
            r11.<init>(r1, r10)     // Catch:{ JOSEException -> 0x01b8 }
            throw r11     // Catch:{ JOSEException -> 0x01b8 }
        L_0x01b8:
            r10 = move-exception
            com.cardinalcommerce.a.setProgressBackgroundTintMode r11 = r9.f2821b
            com.cardinalcommerce.a.setImageMatrix r0 = new com.cardinalcommerce.a.setImageMatrix
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid Algorithm JOSE Exception: "
            r2.<init>(r3)
            java.lang.String r3 = r10.getLocalizedMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r5, r2)
            r11.init(r0)
            com.cardinalcommerce.shared.models.exceptions.SDKRuntimeException r11 = new com.cardinalcommerce.shared.models.exceptions.SDKRuntimeException
            java.lang.Throwable r10 = r10.getCause()
            r11.<init>(r1, r10)
            throw r11
        L_0x01df:
            r10 = move-exception
            com.cardinalcommerce.a.setProgressBackgroundTintMode r11 = r9.f2821b
            com.cardinalcommerce.a.setImageMatrix r0 = new com.cardinalcommerce.a.setImageMatrix
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
            java.lang.String r10 = r10.getLocalizedMessage()
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r0.<init>(r5, r10)
            r11.init(r0)
            java.lang.RuntimeException r10 = new java.lang.RuntimeException
            java.lang.String r11 = "JWS certificate chain validation failed."
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setImageTintBlendMode.m2002a(com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWSObject, java.security.cert.X509Certificate):void");
    }
}
