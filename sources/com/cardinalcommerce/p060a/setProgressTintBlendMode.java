package com.cardinalcommerce.p060a;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEObject;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.Payload;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.DirectEncrypter;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.Curve;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.jwk.ECKey;
import com.cardinalcommerce.emvco.parameters.AuthenticationRequestParameters;
import com.cardinalcommerce.emvco.parameters.ChallengeParameters;
import com.cardinalcommerce.emvco.services.ChallengeStatusReceiver;
import com.cardinalcommerce.emvco.services.Transaction;
import com.cardinalcommerce.shared.models.exceptions.InvalidInputException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.text.ParseException;
import javax.crypto.SecretKey;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.osgi.framework.VersionRange;

/* renamed from: com.cardinalcommerce.a.setProgressTintBlendMode */
public final class setProgressTintBlendMode implements setIndeterminateTintBlendMode, Transaction {
    public static setProgressBackgroundTintMode CardinalError = null;

    /* renamed from: a */
    private static setProgressTintBlendMode f2950a = null;
    public static CountDownTimer configure = null;

    /* renamed from: e */
    private static int f2951e = 0;

    /* renamed from: f */
    private static int f2952f = 1;
    public static ChallengeStatusReceiver init;
    public char[] Cardinal;

    /* renamed from: b */
    private Activity f2953b;

    /* renamed from: c */
    private ChallengeParameters f2954c;
    public AuthenticationRequestParameters cca_continue;

    /* renamed from: d */
    private setProgressBackgroundTintList f2955d;
    public setProgressDrawable getInstance;

    /* renamed from: a */
    static /* synthetic */ CountDownTimer m2072a() {
        int i = f2952f;
        int i2 = i & 63;
        int i3 = (((i ^ 63) | i2) << 1) - ((i | 63) & (~i2));
        f2951e = i3 % 128;
        int i4 = i3 % 2;
        CountDownTimer countDownTimer = configure;
        int i5 = (f2952f + 76) - 1;
        f2951e = i5 % 128;
        int i6 = i5 % 2;
        return countDownTimer;
    }

    /* renamed from: a */
    static /* synthetic */ CountDownTimer m2073a(CountDownTimer countDownTimer) {
        int i = f2951e;
        int i2 = i & 17;
        int i3 = (i ^ 17) | i2;
        int i4 = (i2 & i3) + (i3 | i2);
        f2952f = i4 % 128;
        int i5 = i4 % 2;
        configure = countDownTimer;
        int i6 = f2951e;
        int i7 = ((i6 | 85) << 1) - (i6 ^ 85);
        f2952f = i7 % 128;
        if ((i7 % 2 == 0 ? Matrix.MATRIX_TYPE_ZERO : 'S') == 'S') {
            return countDownTimer;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return countDownTimer;
    }

    private setProgressTintBlendMode() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        if (r1 == null) goto L_0x0046;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.cardinalcommerce.p060a.setProgressTintBlendMode cca_continue() {
        /*
            java.lang.Class<com.cardinalcommerce.a.setProgressTintBlendMode> r0 = com.cardinalcommerce.p060a.setProgressTintBlendMode.class
            monitor-enter(r0)
            int r1 = f2952f     // Catch:{ all -> 0x007e }
            r2 = r1 & 115(0x73, float:1.61E-43)
            r1 = r1 ^ 115(0x73, float:1.61E-43)
            r1 = r1 | r2
            int r1 = ~r1     // Catch:{ all -> 0x007e }
            int r2 = r2 - r1
            int r2 = r2 + -1
            int r1 = r2 % 128
            f2951e = r1     // Catch:{ all -> 0x007e }
            int r2 = r2 % 2
            r1 = 32
            if (r2 == 0) goto L_0x001b
            r2 = 32
            goto L_0x001d
        L_0x001b:
            r2 = 17
        L_0x001d:
            if (r2 == r1) goto L_0x0031
            com.cardinalcommerce.a.setProgressBackgroundTintMode r1 = com.cardinalcommerce.p060a.setProgressBackgroundTintMode.init()     // Catch:{ all -> 0x007e }
            CardinalError = r1     // Catch:{ all -> 0x007e }
            java.lang.String r2 = "EMVCoTransaction"
            java.lang.String r3 = "getInstance called"
            r1.Cardinal(r2, r3)     // Catch:{ all -> 0x007e }
            com.cardinalcommerce.a.setProgressTintBlendMode r1 = f2950a     // Catch:{ all -> 0x007e }
            if (r1 != 0) goto L_0x0065
            goto L_0x0046
        L_0x0031:
            com.cardinalcommerce.a.setProgressBackgroundTintMode r1 = com.cardinalcommerce.p060a.setProgressBackgroundTintMode.init()     // Catch:{ all -> 0x007e }
            CardinalError = r1     // Catch:{ all -> 0x007e }
            java.lang.String r2 = "EMVCoTransaction"
            java.lang.String r3 = "getInstance called"
            r1.Cardinal(r2, r3)     // Catch:{ all -> 0x007e }
            com.cardinalcommerce.a.setProgressTintBlendMode r1 = f2950a     // Catch:{ all -> 0x007e }
            r2 = 0
            super.hashCode()     // Catch:{ all -> 0x007c }
            if (r1 != 0) goto L_0x0065
        L_0x0046:
            com.cardinalcommerce.a.setProgressTintBlendMode r1 = new com.cardinalcommerce.a.setProgressTintBlendMode     // Catch:{ all -> 0x007e }
            r1.<init>()     // Catch:{ all -> 0x007e }
            f2950a = r1     // Catch:{ all -> 0x007e }
            com.cardinalcommerce.a.setProgressBackgroundTintMode r1 = CardinalError     // Catch:{ all -> 0x007e }
            java.lang.String r2 = "EMVCoTransaction"
            java.lang.String r3 = "Instance created"
            r1.Cardinal(r2, r3)     // Catch:{ all -> 0x007e }
            int r1 = f2951e     // Catch:{ all -> 0x007e }
            r2 = r1 | 15
            int r2 = r2 << 1
            r1 = r1 ^ 15
            int r2 = r2 - r1
            int r1 = r2 % 128
            f2952f = r1     // Catch:{ all -> 0x007e }
            int r2 = r2 % 2
        L_0x0065:
            com.cardinalcommerce.a.setProgressTintBlendMode r1 = f2950a     // Catch:{ all -> 0x007e }
            int r2 = f2951e     // Catch:{ all -> 0x007e }
            r3 = r2 & 79
            r2 = r2 ^ 79
            r2 = r2 | r3
            int r2 = -r2
            int r2 = -r2
            r4 = r3 & r2
            r2 = r2 | r3
            int r4 = r4 + r2
            int r2 = r4 % 128
            f2952f = r2     // Catch:{ all -> 0x007e }
            int r4 = r4 % 2
            monitor-exit(r0)
            return r1
        L_0x007c:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x007e }
        L_0x007e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setProgressTintBlendMode.cca_continue():com.cardinalcommerce.a.setProgressTintBlendMode");
    }

    public final char[] configure() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException {
        KeyPair configure2 = setProgressDrawableTiled.configure();
        this.getInstance.getWarnings = configure2;
        ECKey Cardinal2 = new ECKey.cca_continue(Curve.getInstance, (ECPublicKey) configure2.getPublic()).Cardinal();
        CardinalError.Cardinal("EMVCoTransaction", "EphemeralKey Generated");
        char[] instance = setHorizontallyScrolling.getInstance(Cardinal2.cca_continue().toString());
        int i = f2951e;
        int i2 = (i & -42) | ((~i) & 41);
        int i3 = (i & 41) << 1;
        int i4 = ((i2 | i3) << 1) - (i3 ^ i2);
        f2952f = i4 % 128;
        int i5 = i4 % 2;
        return instance;
    }

    public final AuthenticationRequestParameters getAuthenticationRequestParameters() {
        AuthenticationRequestParameters authenticationRequestParameters;
        int i = f2951e;
        int i2 = (((i | 93) << 1) - (~(-(i ^ 93)))) - 1;
        f2952f = i2 % 128;
        if ((i2 % 2 == 0 ? 18 : 'C') != 18) {
            authenticationRequestParameters = this.cca_continue;
        } else {
            authenticationRequestParameters = this.cca_continue;
            Object obj = null;
            super.hashCode();
        }
        int i3 = f2951e;
        int i4 = i3 ^ 111;
        int i5 = (((i3 & 111) | i4) << 1) - i4;
        f2952f = i5 % 128;
        if (!(i5 % 2 == 0)) {
            return authenticationRequestParameters;
        }
        int i6 = 39 / 0;
        return authenticationRequestParameters;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0271, code lost:
        CardinalError.init(new com.cardinalcommerce.p060a.setImageMatrix(11412, "Null Challenge Status Receiver \n"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0285, code lost:
        throw m2074a("Challenge Status Receiver");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0094, code lost:
        if ((r12.getAcsSignedContent() != null ? '%' : 'A') == '%') goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a3, code lost:
        if ((r12.getAcsSignedContent() == null) != true) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c5, code lost:
        if ((r12.get3DSServerTransactionID() != null) != false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d8, code lost:
        if ((r12.get3DSServerTransactionID() != null ? kotlin.text.Typography.amp : 10) == '&') goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0107, code lost:
        if (r12.getAcsRefNumber() != null) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0111, code lost:
        if (r6 != null) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0172, code lost:
        if ((r13 != null) != false) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0180, code lost:
        if ((r13 != null ? 'S' : '5') == 'S') goto L_0x0182;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void doChallenge(android.app.Activity r11, com.cardinalcommerce.emvco.parameters.ChallengeParameters r12, com.cardinalcommerce.emvco.services.ChallengeStatusReceiver r13, final int r14) throws com.cardinalcommerce.shared.models.exceptions.InvalidInputException {
        /*
            r10 = this;
            java.lang.String r0 = "RunTimeError"
            java.lang.String r1 = "101"
            java.lang.String r2 = "Error while creating and executing CReq \n"
            int r3 = f2951e
            r4 = r3 & 85
            int r5 = ~r4
            r3 = r3 | 85
            r3 = r3 & r5
            r5 = 1
            int r4 = r4 << r5
            int r4 = ~r4
            int r3 = r3 - r4
            int r3 = r3 - r5
            int r4 = r3 % 128
            f2952f = r4
            int r3 = r3 % 2
            com.cardinalcommerce.a.setProgressBackgroundTintMode r3 = CardinalError
            java.lang.String r4 = "EMVCoTransaction"
            java.lang.String r6 = "doChallenge called"
            r3.Cardinal(r4, r6)
            r3 = 0
            if (r11 == 0) goto L_0x0027
            r6 = 0
            goto L_0x0028
        L_0x0027:
            r6 = 1
        L_0x0028:
            if (r6 != 0) goto L_0x02a3
            int r6 = f2952f
            r7 = r6 | 89
            int r8 = r7 << 1
            r6 = r6 & 89
            int r6 = ~r6
            r6 = r6 & r7
            int r6 = -r6
            r7 = r8 | r6
            int r7 = r7 << r5
            r6 = r6 ^ r8
            int r7 = r7 - r6
            int r6 = r7 % 128
            f2951e = r6
            int r7 = r7 % 2
            if (r7 == 0) goto L_0x0044
            r6 = 1
            goto L_0x0045
        L_0x0044:
            r6 = 0
        L_0x0045:
            r7 = 0
            if (r6 == r5) goto L_0x004b
            r10.f2953b = r11
            goto L_0x0050
        L_0x004b:
            r10.f2953b = r11
            super.hashCode()     // Catch:{ all -> 0x02a1 }
        L_0x0050:
            int r11 = f2951e
            r6 = r11 ^ 19
            r11 = r11 & 19
            int r11 = r11 << r5
            int r11 = -r11
            int r11 = -r11
            r8 = r6 | r11
            int r8 = r8 << r5
            r11 = r11 ^ r6
            int r8 = r8 - r11
            int r11 = r8 % 128
            f2952f = r11
            int r8 = r8 % 2
            r11 = 52
            if (r12 == 0) goto L_0x006b
            r6 = 52
            goto L_0x006d
        L_0x006b:
            r6 = 73
        L_0x006d:
            if (r6 != r11) goto L_0x028c
            int r11 = f2952f
            r6 = r11 & 55
            r11 = r11 | 55
            int r6 = r6 + r11
            int r11 = r6 % 128
            f2951e = r11
            int r6 = r6 % 2
            r11 = 18
            if (r6 == 0) goto L_0x0083
            r6 = 18
            goto L_0x0085
        L_0x0083:
            r6 = 63
        L_0x0085:
            if (r6 == r11) goto L_0x0097
            java.lang.String r11 = r12.getAcsSignedContent()
            r6 = 37
            if (r11 == 0) goto L_0x0092
            r11 = 37
            goto L_0x0094
        L_0x0092:
            r11 = 65
        L_0x0094:
            if (r11 != r6) goto L_0x028c
            goto L_0x00a5
        L_0x0097:
            java.lang.String r11 = r12.getAcsSignedContent()
            r6 = 94
            int r6 = r6 / r3
            if (r11 == 0) goto L_0x00a2
            r11 = 0
            goto L_0x00a3
        L_0x00a2:
            r11 = 1
        L_0x00a3:
            if (r11 == r5) goto L_0x028c
        L_0x00a5:
            int r11 = f2951e
            r6 = r11 | 101(0x65, float:1.42E-43)
            int r6 = r6 << r5
            r11 = r11 ^ 101(0x65, float:1.42E-43)
            int r6 = r6 - r11
            int r11 = r6 % 128
            f2952f = r11
            int r6 = r6 % 2
            r11 = 5
            if (r6 != 0) goto L_0x00b8
            r6 = 5
            goto L_0x00ba
        L_0x00b8:
            r6 = 75
        L_0x00ba:
            if (r6 == r11) goto L_0x00c8
            java.lang.String r6 = r12.get3DSServerTransactionID()
            if (r6 == 0) goto L_0x00c4
            r6 = 1
            goto L_0x00c5
        L_0x00c4:
            r6 = 0
        L_0x00c5:
            if (r6 == 0) goto L_0x028c
            goto L_0x00da
        L_0x00c8:
            java.lang.String r6 = r12.get3DSServerTransactionID()
            r8 = 82
            int r8 = r8 / r3
            r8 = 38
            if (r6 == 0) goto L_0x00d6
            r6 = 38
            goto L_0x00d8
        L_0x00d6:
            r6 = 10
        L_0x00d8:
            if (r6 != r8) goto L_0x028c
        L_0x00da:
            java.lang.String r6 = r12.getAcsRefNumber()
            if (r6 == 0) goto L_0x00e2
            r6 = 1
            goto L_0x00e3
        L_0x00e2:
            r6 = 0
        L_0x00e3:
            if (r6 != r5) goto L_0x028c
            int r6 = f2952f
            r8 = r6 ^ 5
            r9 = r6 & 5
            r8 = r8 | r9
            int r8 = r8 << r5
            r9 = r6 & -6
            int r6 = ~r6
            r6 = r6 & r11
            r6 = r6 | r9
            int r6 = -r6
            int r6 = ~r6
            int r8 = r8 - r6
            int r8 = r8 - r5
            int r6 = r8 % 128
            f2951e = r6
            int r8 = r8 % 2
            if (r8 == 0) goto L_0x0100
            r6 = 0
            goto L_0x0101
        L_0x0100:
            r6 = 1
        L_0x0101:
            if (r6 == 0) goto L_0x010a
            java.lang.String r6 = r12.getAcsRefNumber()
            if (r6 == 0) goto L_0x028c
            goto L_0x0113
        L_0x010a:
            java.lang.String r6 = r12.getAcsRefNumber()
            super.hashCode()     // Catch:{ all -> 0x0286 }
            if (r6 == 0) goto L_0x028c
        L_0x0113:
            com.cardinalcommerce.a.setProgressBackgroundTintMode r6 = CardinalError
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "ACSTransactionID "
            r8.<init>(r9)
            java.lang.String r9 = r12.getAcsTransactionID()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r6.Cardinal(r4, r8)
            com.cardinalcommerce.a.setProgressBackgroundTintMode r6 = CardinalError
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "3DSTransactionID "
            r8.<init>(r9)
            java.lang.String r9 = r12.get3DSServerTransactionID()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r6.Cardinal(r4, r8)
            r10.f2954c = r12
            int r6 = f2951e
            r8 = r6 & 89
            int r9 = ~r8
            r6 = r6 | 89
            r6 = r6 & r9
            int r8 = r8 << r5
            int r6 = r6 + r8
            int r8 = r6 % 128
            f2952f = r8
            int r6 = r6 % 2
            int r6 = f2951e
            r8 = r6 ^ 95
            r6 = r6 & 95
            int r6 = r6 << r5
            int r8 = r8 + r6
            int r6 = r8 % 128
            f2952f = r6
            int r8 = r8 % 2
            r6 = 60
            if (r8 != 0) goto L_0x0168
            r8 = 8
            goto L_0x016a
        L_0x0168:
            r8 = 60
        L_0x016a:
            if (r8 == r6) goto L_0x0177
            int r6 = r7.length     // Catch:{ all -> 0x0175 }
            if (r13 == 0) goto L_0x0171
            r6 = 1
            goto L_0x0172
        L_0x0171:
            r6 = 0
        L_0x0172:
            if (r6 == 0) goto L_0x0271
            goto L_0x0182
        L_0x0175:
            r11 = move-exception
            throw r11
        L_0x0177:
            r6 = 83
            if (r13 == 0) goto L_0x017e
            r7 = 83
            goto L_0x0180
        L_0x017e:
            r7 = 53
        L_0x0180:
            if (r7 != r6) goto L_0x0271
        L_0x0182:
            init = r13
            int r13 = f2951e
            r6 = r13 & 107(0x6b, float:1.5E-43)
            r13 = r13 | 107(0x6b, float:1.5E-43)
            int r6 = r6 + r13
            int r13 = r6 % 128
            f2952f = r13
            int r6 = r6 % 2
            int r13 = f2951e
            r6 = 123(0x7b, float:1.72E-43)
            r7 = r13 & -124(0xffffffffffffff84, float:NaN)
            int r8 = ~r13
            r8 = r8 & r6
            r7 = r7 | r8
            r13 = r13 & r6
            int r13 = r13 << r5
            int r13 = -r13
            int r13 = -r13
            int r13 = ~r13
            int r7 = r7 - r13
            int r7 = r7 - r5
            int r13 = r7 % 128
            f2952f = r13
            int r7 = r7 % 2
            r13 = 33
            if (r7 != 0) goto L_0x01ae
            r6 = 33
            goto L_0x01b0
        L_0x01ae:
            r6 = 71
        L_0x01b0:
            if (r6 == r13) goto L_0x01b5
            if (r14 < r11) goto L_0x025c
            goto L_0x01b8
        L_0x01b5:
            r11 = 3
            if (r14 < r11) goto L_0x025c
        L_0x01b8:
            android.app.Activity r11 = r10.f2953b
            com.cardinalcommerce.a.setProgressTintBlendMode$3 r13 = new com.cardinalcommerce.a.setProgressTintBlendMode$3
            r13.<init>(r14)
            r11.runOnUiThread(r13)
            int r11 = f2952f
            r13 = r11 & 125(0x7d, float:1.75E-43)
            r11 = r11 ^ 125(0x7d, float:1.75E-43)
            r11 = r11 | r13
            int r13 = r13 + r11
            int r11 = r13 % 128
            f2951e = r11
            int r13 = r13 % 2
            r11 = 11416(0x2c98, float:1.5997E-41)
            com.cardinalcommerce.a.setProgressBackgroundTintList r13 = new com.cardinalcommerce.a.setProgressBackgroundTintList     // Catch:{ SDKRuntimeException -> 0x0236, JSONException -> 0x0210 }
            com.cardinalcommerce.a.setProgressDrawable r14 = r10.getInstance     // Catch:{ SDKRuntimeException -> 0x0236, JSONException -> 0x0210 }
            r13.<init>(r10, r12, r14)     // Catch:{ SDKRuntimeException -> 0x0236, JSONException -> 0x0210 }
            r10.f2955d = r13     // Catch:{ SDKRuntimeException -> 0x0236, JSONException -> 0x0210 }
            com.cardinalcommerce.p060a.setTextAppearance.getInstance = r3     // Catch:{ SDKRuntimeException -> 0x0236, JSONException -> 0x0210 }
            com.cardinalcommerce.a.setProgressBackgroundTintMode r12 = CardinalError     // Catch:{ SDKRuntimeException -> 0x0236, JSONException -> 0x0210 }
            java.lang.String r13 = "Transaction Timer started"
            r12.Cardinal(r4, r13)     // Catch:{ SDKRuntimeException -> 0x0236, JSONException -> 0x0210 }
            com.cardinalcommerce.a.setProgressBackgroundTintList r12 = r10.f2955d     // Catch:{ SDKRuntimeException -> 0x0236, JSONException -> 0x0210 }
            r12.configure()     // Catch:{ SDKRuntimeException -> 0x0236, JSONException -> 0x0210 }
            java.util.concurrent.ExecutorService r13 = r12.getSDKVersion     // Catch:{ SDKRuntimeException -> 0x0236, JSONException -> 0x0210 }
            com.cardinalcommerce.a.setKeyListener$4 r14 = new com.cardinalcommerce.a.setKeyListener$4     // Catch:{ SDKRuntimeException -> 0x0236, JSONException -> 0x0210 }
            r14.<init>()     // Catch:{ SDKRuntimeException -> 0x0236, JSONException -> 0x0210 }
            r13.execute(r14)     // Catch:{ SDKRuntimeException -> 0x0236, JSONException -> 0x0210 }
            com.cardinalcommerce.a.setProgressBackgroundTintMode r12 = CardinalError     // Catch:{ SDKRuntimeException -> 0x0236, JSONException -> 0x0210 }
            java.lang.String r13 = "Challenge Task started 01"
            r12.Cardinal(r4, r13)     // Catch:{ SDKRuntimeException -> 0x0236, JSONException -> 0x0210 }
            com.cardinalcommerce.a.setProgressBackgroundTintMode r12 = CardinalError     // Catch:{ SDKRuntimeException -> 0x0236, JSONException -> 0x0210 }
            r12.getInstance()     // Catch:{ SDKRuntimeException -> 0x0236, JSONException -> 0x0210 }
            int r11 = f2951e
            r12 = r11 ^ 23
            r11 = r11 & 23
            int r11 = r11 << r5
            int r11 = ~r11
            int r12 = r12 - r11
            int r12 = r12 - r5
            int r11 = r12 % 128
            f2952f = r11
            int r12 = r12 % 2
            return
        L_0x0210:
            r12 = move-exception
            com.cardinalcommerce.a.setProgressBackgroundTintMode r13 = CardinalError
            com.cardinalcommerce.a.setImageMatrix r14 = new com.cardinalcommerce.a.setImageMatrix
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r12 = r12.getLocalizedMessage()
            r3.append(r12)
            java.lang.String r12 = r3.toString()
            r14.<init>(r11, r12)
            r13.init(r14)
            com.cardinalcommerce.emvco.events.RuntimeErrorEvent r11 = new com.cardinalcommerce.emvco.events.RuntimeErrorEvent
            java.lang.String r12 = "Message is not CRes"
            r11.<init>(r1, r12)
            r10.configure(r0, r11)
            return
        L_0x0236:
            r12 = move-exception
            com.cardinalcommerce.a.setProgressBackgroundTintMode r13 = CardinalError
            com.cardinalcommerce.a.setImageMatrix r14 = new com.cardinalcommerce.a.setImageMatrix
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r12 = r12.getLocalizedMessage()
            r3.append(r12)
            java.lang.String r12 = r3.toString()
            r14.<init>(r11, r12)
            r13.init(r14)
            com.cardinalcommerce.emvco.events.RuntimeErrorEvent r11 = new com.cardinalcommerce.emvco.events.RuntimeErrorEvent
            java.lang.String r12 = "INVALID ACS CONTENT Failed"
            r11.<init>(r1, r12)
            r10.configure(r0, r11)
            return
        L_0x025c:
            com.cardinalcommerce.a.setProgressBackgroundTintMode r11 = CardinalError
            com.cardinalcommerce.a.setImageMatrix r12 = new com.cardinalcommerce.a.setImageMatrix
            r13 = 11401(0x2c89, float:1.5976E-41)
            java.lang.String r14 = "Invalid Timeout \n"
            r12.<init>(r13, r14)
            r11.init(r12)
            java.lang.String r11 = "Timeout"
            com.cardinalcommerce.shared.models.exceptions.InvalidInputException r11 = r10.m2074a((java.lang.String) r11)
            throw r11
        L_0x0271:
            com.cardinalcommerce.a.setProgressBackgroundTintMode r11 = CardinalError
            com.cardinalcommerce.a.setImageMatrix r12 = new com.cardinalcommerce.a.setImageMatrix
            r13 = 11412(0x2c94, float:1.5992E-41)
            java.lang.String r14 = "Null Challenge Status Receiver \n"
            r12.<init>(r13, r14)
            r11.init(r12)
            java.lang.String r11 = "Challenge Status Receiver"
            com.cardinalcommerce.shared.models.exceptions.InvalidInputException r11 = r10.m2074a((java.lang.String) r11)
            throw r11
        L_0x0286:
            r11 = move-exception
            throw r11
        L_0x0288:
            r11 = move-exception
            throw r11
        L_0x028a:
            r11 = move-exception
            throw r11
        L_0x028c:
            com.cardinalcommerce.a.setProgressBackgroundTintMode r11 = CardinalError
            com.cardinalcommerce.a.setImageMatrix r12 = new com.cardinalcommerce.a.setImageMatrix
            r13 = 11402(0x2c8a, float:1.5978E-41)
            java.lang.String r14 = " Null Challenge Parameters \n"
            r12.<init>(r13, r14)
            r11.init(r12)
            java.lang.String r11 = "Challenge Parameters"
            com.cardinalcommerce.shared.models.exceptions.InvalidInputException r11 = r10.m2074a((java.lang.String) r11)
            throw r11
        L_0x02a1:
            r11 = move-exception
            throw r11
        L_0x02a3:
            com.cardinalcommerce.a.setProgressBackgroundTintMode r11 = CardinalError
            com.cardinalcommerce.a.setImageMatrix r12 = new com.cardinalcommerce.a.setImageMatrix
            r13 = 11411(0x2c93, float:1.599E-41)
            java.lang.String r14 = " Null Current Activity \n"
            r12.<init>(r13, r14)
            r11.init(r12)
            java.lang.String r11 = "Current Activity"
            com.cardinalcommerce.shared.models.exceptions.InvalidInputException r11 = r10.m2074a((java.lang.String) r11)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setProgressTintBlendMode.doChallenge(android.app.Activity, com.cardinalcommerce.emvco.parameters.ChallengeParameters, com.cardinalcommerce.emvco.services.ChallengeStatusReceiver, int):void");
    }

    /* renamed from: a */
    private InvalidInputException m2074a(String str) {
        StringBuilder sb = new StringBuilder("Caught in ");
        sb.append(getClass().getName());
        sb.append("\n Invalid ");
        sb.append(str);
        InvalidInputException invalidInputException = new InvalidInputException("InvalidInputException", new Throwable(sb.toString()));
        int i = f2952f;
        int i2 = ((i | 116) << 1) - (i ^ 116);
        int i3 = (i2 & -1) + (i2 | -1);
        f2951e = i3 % 128;
        if (i3 % 2 == 0) {
            return invalidInputException;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return invalidInputException;
    }

    public final setEms getProgressView(Activity activity) throws InvalidInputException {
        setEms setems = new setEms(activity, this.getInstance.cca_continue);
        int i = f2952f;
        int i2 = i & 7;
        int i3 = (i ^ 7) | i2;
        int i4 = (i2 & i3) + (i3 | i2);
        f2951e = i4 % 128;
        if ((i4 % 2 != 0 ? 14 : 'X') != 14) {
            return setems;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return setems;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0036, code lost:
        if ((r8.setChallengeTimeout.equalsIgnoreCase(com.didichuxing.sofa.animation.C16471q.f49113b)) != true) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        if ((!r8.setChallengeTimeout.equalsIgnoreCase(com.didichuxing.sofa.animation.C16471q.f49113b)) != true) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008a, code lost:
        if ((!r1 ? 'C' : ',') != 'C') goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009e, code lost:
        if ((!r8.getWarnings.equalsIgnoreCase("N") ? org.bouncycastle.pqc.math.linearalgebra.Matrix.MATRIX_TYPE_RANDOM_LT : 'H') != 'L') goto L_0x00f8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cca_continue(com.cardinalcommerce.p060a.setBaselineAligned r8) {
        /*
            r7 = this;
            int r0 = f2951e
            r1 = r0 & 105(0x69, float:1.47E-43)
            int r2 = ~r1
            r0 = r0 | 105(0x69, float:1.47E-43)
            r0 = r0 & r2
            r2 = 1
            int r1 = r1 << r2
            int r1 = -r1
            int r1 = -r1
            r3 = r0 ^ r1
            r0 = r0 & r1
            int r0 = r0 << r2
            int r3 = r3 + r0
            int r0 = r3 % 128
            f2952f = r0
            int r3 = r3 % 2
            r0 = 0
            if (r3 != 0) goto L_0x001c
            r1 = 1
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            java.lang.String r3 = "Y"
            java.lang.String r4 = "onCReqSuccess called"
            java.lang.String r5 = "EMVCoTransaction"
            r6 = 0
            if (r1 == r2) goto L_0x0039
            com.cardinalcommerce.a.setProgressBackgroundTintMode r1 = CardinalError
            r1.Cardinal(r5, r4)
            java.lang.String r1 = r8.setChallengeTimeout
            boolean r1 = r1.equalsIgnoreCase(r3)
            if (r1 != 0) goto L_0x0035
            r1 = 0
            goto L_0x0036
        L_0x0035:
            r1 = 1
        L_0x0036:
            if (r1 == r2) goto L_0x00a1
            goto L_0x004f
        L_0x0039:
            com.cardinalcommerce.a.setProgressBackgroundTintMode r1 = CardinalError
            r1.Cardinal(r5, r4)
            java.lang.String r1 = r8.setChallengeTimeout
            boolean r1 = r1.equalsIgnoreCase(r3)
            r3 = 42
            int r3 = r3 / r0
            if (r1 != 0) goto L_0x004b
            r1 = 1
            goto L_0x004c
        L_0x004b:
            r1 = 0
        L_0x004c:
            if (r1 == r2) goto L_0x004f
            goto L_0x00a1
        L_0x004f:
            java.lang.String r1 = r8.setChallengeTimeout
            java.lang.String r3 = "N"
            boolean r1 = r1.equalsIgnoreCase(r3)
            r4 = 42
            if (r1 != 0) goto L_0x005e
            r1 = 42
            goto L_0x0060
        L_0x005e:
            r1 = 83
        L_0x0060:
            if (r1 == r4) goto L_0x0063
            goto L_0x00a1
        L_0x0063:
            int r1 = f2952f
            r4 = r1 ^ 59
            r1 = r1 & 59
            int r1 = r1 << r2
            int r4 = r4 + r1
            int r1 = r4 % 128
            f2951e = r1
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x0075
            r1 = 1
            goto L_0x0076
        L_0x0075:
            r1 = 0
        L_0x0076:
            if (r1 == 0) goto L_0x008f
            java.lang.String r1 = r8.getWarnings
            boolean r1 = r1.equalsIgnoreCase(r3)
            super.hashCode()     // Catch:{ all -> 0x008d }
            r3 = 67
            if (r1 != 0) goto L_0x0088
            r1 = 67
            goto L_0x008a
        L_0x0088:
            r1 = 44
        L_0x008a:
            if (r1 == r3) goto L_0x00a1
            goto L_0x00f8
        L_0x008d:
            r8 = move-exception
            throw r8
        L_0x008f:
            java.lang.String r1 = r8.getWarnings
            boolean r1 = r1.equalsIgnoreCase(r3)
            r3 = 76
            if (r1 != 0) goto L_0x009c
            r1 = 76
            goto L_0x009e
        L_0x009c:
            r1 = 72
        L_0x009e:
            if (r1 == r3) goto L_0x00a1
            goto L_0x00f8
        L_0x00a1:
            android.os.CountDownTimer r1 = configure
            if (r1 == 0) goto L_0x00a7
            r1 = 0
            goto L_0x00a8
        L_0x00a7:
            r1 = 1
        L_0x00a8:
            if (r1 == 0) goto L_0x00ab
            goto L_0x00da
        L_0x00ab:
            int r1 = f2951e
            r3 = r1 | 12
            int r3 = r3 << r2
            r1 = r1 ^ 12
            int r3 = r3 - r1
            r1 = r3 ^ -1
            r3 = r3 & -1
            int r3 = r3 << r2
            int r1 = r1 + r3
            int r3 = r1 % 128
            f2952f = r3
            int r1 = r1 % 2
            android.os.CountDownTimer r1 = configure
            r1.cancel()
            configure = r6
            int r1 = f2952f
            r3 = r1 & 37
            int r4 = ~r3
            r1 = r1 | 37
            r1 = r1 & r4
            int r3 = r3 << r2
            r4 = r1 ^ r3
            r1 = r1 & r3
            int r1 = r1 << r2
            int r4 = r4 + r1
            int r1 = r4 % 128
            f2951e = r1
            int r4 = r4 % 2
        L_0x00da:
            com.cardinalcommerce.a.setProgressBackgroundTintMode r1 = CardinalError
            java.lang.String r3 = "Transaction Timer ended"
            r1.Cardinal(r5, r3)
            int r1 = f2951e
            r3 = r1 | 95
            int r3 = r3 << r2
            r4 = r1 & -96
            int r1 = ~r1
            r1 = r1 & 95
            r1 = r1 | r4
            int r1 = -r1
            r4 = r3 ^ r1
            r1 = r1 & r3
            int r1 = r1 << r2
            int r4 = r4 + r1
            int r1 = r4 % 128
            f2952f = r1
            int r4 = r4 % 2
        L_0x00f8:
            com.cardinalcommerce.a.setProgressBackgroundTintList r1 = r7.f2955d
            boolean r1 = r1.init()
            r3 = 73
            if (r1 != 0) goto L_0x0105
            r1 = 73
            goto L_0x0107
        L_0x0105:
            r1 = 41
        L_0x0107:
            if (r1 == r3) goto L_0x010a
            goto L_0x0143
        L_0x010a:
            int r1 = f2952f
            r3 = r1 | 11
            int r3 = r3 << r2
            r1 = r1 ^ 11
            int r3 = r3 - r1
            int r1 = r3 % 128
            f2951e = r1
            int r3 = r3 % 2
            if (r3 == 0) goto L_0x011c
            r1 = 0
            goto L_0x011d
        L_0x011c:
            r1 = 1
        L_0x011d:
            if (r1 == 0) goto L_0x0129
            android.app.Activity r1 = r7.f2953b
            com.cardinalcommerce.a.setProgressDrawable r3 = r7.getInstance
            com.cardinalcommerce.shared.userinterfaces.UiCustomization r3 = r3.configure
            com.cardinalcommerce.p060a.setTextAppearance.getInstance(r8, r1, r3)
            goto L_0x0135
        L_0x0129:
            android.app.Activity r1 = r7.f2953b
            com.cardinalcommerce.a.setProgressDrawable r3 = r7.getInstance
            com.cardinalcommerce.shared.userinterfaces.UiCustomization r3 = r3.configure
            com.cardinalcommerce.p060a.setTextAppearance.getInstance(r8, r1, r3)
            super.hashCode()     // Catch:{ all -> 0x015d }
        L_0x0135:
            int r8 = f2951e
            r1 = r8 & 121(0x79, float:1.7E-43)
            r8 = r8 ^ 121(0x79, float:1.7E-43)
            r8 = r8 | r1
            int r1 = r1 + r8
            int r8 = r1 % 128
            f2952f = r8
            int r1 = r1 % 2
        L_0x0143:
            int r8 = f2951e
            r1 = r8 & 27
            r8 = r8 ^ 27
            r8 = r8 | r1
            int r1 = r1 + r8
            int r8 = r1 % 128
            f2952f = r8
            int r1 = r1 % 2
            if (r1 != 0) goto L_0x0154
            r2 = 0
        L_0x0154:
            if (r2 == 0) goto L_0x0157
            return
        L_0x0157:
            super.hashCode()     // Catch:{ all -> 0x015b }
            return
        L_0x015b:
            r8 = move-exception
            throw r8
        L_0x015d:
            r8 = move-exception
            throw r8
        L_0x015f:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setProgressTintBlendMode.cca_continue(com.cardinalcommerce.a.setBaselineAligned):void");
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.cardinalcommerce.a.setProgressTintBlendMode, com.cardinalcommerce.emvco.parameters.ChallengeParameters, android.os.CountDownTimer, com.cardinalcommerce.emvco.services.ChallengeStatusReceiver, com.cardinalcommerce.a.setProgressBackgroundTintList, java.lang.Object, com.cardinalcommerce.emvco.parameters.AuthenticationRequestParameters, com.cardinalcommerce.a.setProgressDrawable, android.app.Activity] */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        if ((r8.f2955d != null ? '@' : kotlin.text.Typography.less) != '@') goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
        if ((r1 == null) != true) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() {
        /*
            r8 = this;
            int r0 = f2952f
            r1 = r0 & 45
            r0 = r0 ^ 45
            r0 = r0 | r1
            int r1 = r1 + r0
            int r0 = r1 % 128
            f2951e = r0
            r0 = 2
            int r1 = r1 % r0
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0014
            r1 = 1
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            r4 = 0
            if (r1 == r3) goto L_0x0026
            com.cardinalcommerce.a.setProgressBackgroundTintList r1 = r8.f2955d
            r5 = 64
            if (r1 == 0) goto L_0x0021
            r1 = 64
            goto L_0x0023
        L_0x0021:
            r1 = 60
        L_0x0023:
            if (r1 == r5) goto L_0x0032
            goto L_0x005a
        L_0x0026:
            com.cardinalcommerce.a.setProgressBackgroundTintList r1 = r8.f2955d
            super.hashCode()     // Catch:{ all -> 0x00cb }
            if (r1 == 0) goto L_0x002f
            r1 = 0
            goto L_0x0030
        L_0x002f:
            r1 = 1
        L_0x0030:
            if (r1 == r3) goto L_0x005a
        L_0x0032:
            int r1 = f2952f
            r5 = r1 | 45
            int r5 = r5 << r3
            r1 = r1 ^ 45
            int r1 = -r1
            r6 = r5 ^ r1
            r1 = r1 & r5
            int r1 = r1 << r3
            int r6 = r6 + r1
            int r1 = r6 % 128
            f2951e = r1
            int r6 = r6 % r0
            com.cardinalcommerce.a.setProgressBackgroundTintList r1 = r8.f2955d
            java.util.concurrent.ExecutorService r5 = java.util.concurrent.Executors.newSingleThreadExecutor()
            r5.execute(r1)
            int r1 = f2951e
            r5 = r1 | 95
            int r5 = r5 << r3
            r1 = r1 ^ 95
            int r5 = r5 - r1
            int r1 = r5 % 128
            f2952f = r1
            int r5 = r5 % r0
        L_0x005a:
            r8.f2955d = r4
            r8.cca_continue = r4
            r8.f2953b = r4
            r8.f2954c = r4
            init = r4
            char[] r1 = r8.Cardinal
            com.cardinalcommerce.p060a.setHorizontallyScrolling.getInstance((char[]) r1)
            r8.getInstance = r4
            android.os.CountDownTimer r1 = configure
            if (r1 == 0) goto L_0x0071
            r1 = 1
            goto L_0x0072
        L_0x0071:
            r1 = 0
        L_0x0072:
            if (r1 == 0) goto L_0x00a3
            int r1 = f2951e
            r5 = 105(0x69, float:1.47E-43)
            r6 = r1 & -106(0xffffffffffffff96, float:NaN)
            int r7 = ~r1
            r7 = r7 & r5
            r6 = r6 | r7
            r1 = r1 & r5
            int r1 = r1 << r3
            int r1 = -r1
            int r1 = -r1
            int r1 = ~r1
            int r6 = r6 - r1
            int r6 = r6 - r3
            int r1 = r6 % 128
            f2952f = r1
            int r6 = r6 % r0
            if (r6 != 0) goto L_0x008c
            r2 = 1
        L_0x008c:
            if (r2 == r3) goto L_0x0096
            android.os.CountDownTimer r1 = configure
            r1.cancel()
            configure = r4
            goto L_0x00a3
        L_0x0096:
            android.os.CountDownTimer r1 = configure
            r1.cancel()
            configure = r4
            super.hashCode()     // Catch:{ all -> 0x00a1 }
            goto L_0x00a3
        L_0x00a1:
            r0 = move-exception
            throw r0
        L_0x00a3:
            f2950a = r4
            int r1 = f2952f
            r2 = 81
            r5 = r1 & -82
            int r6 = ~r1
            r6 = r6 & r2
            r5 = r5 | r6
            r1 = r1 & r2
            int r1 = r1 << r3
            int r1 = -r1
            int r1 = -r1
            r2 = r5 | r1
            int r2 = r2 << r3
            r1 = r1 ^ r5
            int r2 = r2 - r1
            int r1 = r2 % 128
            f2951e = r1
            int r2 = r2 % r0
            if (r2 == 0) goto L_0x00c0
            r1 = 2
            goto L_0x00c2
        L_0x00c0:
            r1 = 58
        L_0x00c2:
            if (r1 == r0) goto L_0x00c5
            return
        L_0x00c5:
            super.hashCode()     // Catch:{ all -> 0x00c9 }
            return
        L_0x00c9:
            r0 = move-exception
            throw r0
        L_0x00cb:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setProgressTintBlendMode.close():void");
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [android.os.CountDownTimer, java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0125, code lost:
        if ((r8.f2955d != null ? 18 : 'E') != 'E') goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0139, code lost:
        if ((r8.f2955d != null ? 'O' : org.bouncycastle.pqc.math.linearalgebra.Matrix.MATRIX_TYPE_RANDOM_UT) != 'O') goto L_0x01a5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void configure(java.lang.String r9, com.cardinalcommerce.p060a.setSecondaryProgressTintMode r10) {
        /*
            r8 = this;
            int r0 = f2951e
            r1 = r0 & -64
            int r2 = ~r0
            r3 = 63
            r2 = r2 & r3
            r1 = r1 | r2
            r0 = r0 & r3
            r2 = 1
            int r0 = r0 << r2
            int r0 = -r0
            int r0 = -r0
            int r0 = ~r0
            int r1 = r1 - r0
            int r1 = r1 - r2
            int r0 = r1 % 128
            f2952f = r0
            int r1 = r1 % 2
            com.cardinalcommerce.a.setProgressBackgroundTintMode r0 = CardinalError
            java.lang.String r1 = "EMVCoTransaction"
            java.lang.String r3 = "onCReqError called"
            r0.Cardinal(r1, r3)
            com.cardinalcommerce.a.setProgressBackgroundTintMode r0 = CardinalError
            java.lang.String r3 = "Transaction Timer ended"
            r0.Cardinal(r1, r3)
            java.lang.String r0 = "ProtocolError"
            boolean r0 = java.util.Objects.equals(r9, r0)
            r1 = 97
            if (r0 == 0) goto L_0x0034
            r0 = 80
            goto L_0x0036
        L_0x0034:
            r0 = 97
        L_0x0036:
            r3 = 85
            r4 = 57
            r5 = 89
            r6 = 0
            r7 = 0
            if (r0 == r1) goto L_0x006e
            int r9 = f2951e
            r0 = r9 & 113(0x71, float:1.58E-43)
            int r1 = ~r0
            r9 = r9 | 113(0x71, float:1.58E-43)
            r9 = r9 & r1
            int r0 = r0 << r2
            int r9 = r9 + r0
            int r0 = r9 % 128
            f2952f = r0
            int r9 = r9 % 2
            if (r9 != 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r4 = 89
        L_0x0055:
            if (r4 == r5) goto L_0x0065
            com.cardinalcommerce.emvco.services.ChallengeStatusReceiver r9 = init
            com.cardinalcommerce.emvco.events.ProtocolErrorEvent r10 = (com.cardinalcommerce.emvco.events.ProtocolErrorEvent) r10
            r9.protocolError(r10)
            r9 = 88
            int r9 = r9 / r7
            goto L_0x01a5
        L_0x0063:
            r9 = move-exception
            throw r9
        L_0x0065:
            com.cardinalcommerce.emvco.services.ChallengeStatusReceiver r9 = init
            com.cardinalcommerce.emvco.events.ProtocolErrorEvent r10 = (com.cardinalcommerce.emvco.events.ProtocolErrorEvent) r10
            r9.protocolError(r10)
            goto L_0x01a5
        L_0x006e:
            java.lang.String r0 = "RunTimeError"
            boolean r0 = java.util.Objects.equals(r9, r0)
            if (r0 == 0) goto L_0x0078
            r0 = 1
            goto L_0x0079
        L_0x0078:
            r0 = 0
        L_0x0079:
            r1 = 15
            if (r0 == 0) goto L_0x00ab
            int r9 = f2952f
            r0 = r9 | 57
            int r5 = r0 << 1
            r9 = r9 & r4
            int r9 = ~r9
            r9 = r9 & r0
            int r9 = -r9
            r0 = r5 ^ r9
            r9 = r9 & r5
            int r9 = r9 << r2
            int r0 = r0 + r9
            int r9 = r0 % 128
            f2951e = r9
            int r0 = r0 % 2
            com.cardinalcommerce.emvco.services.ChallengeStatusReceiver r9 = init
            com.cardinalcommerce.emvco.events.RuntimeErrorEvent r10 = (com.cardinalcommerce.emvco.events.RuntimeErrorEvent) r10
            r9.runtimeError(r10)
            int r9 = f2952f
            r10 = r9 & -16
            int r0 = ~r9
            r0 = r0 & r1
            r10 = r10 | r0
            r9 = r9 & r1
            int r9 = r9 << r2
            int r10 = r10 + r9
        L_0x00a3:
            int r9 = r10 % 128
            f2951e = r9
            int r10 = r10 % 2
            goto L_0x01a5
        L_0x00ab:
            java.lang.String r10 = "TimeOutError"
            boolean r10 = java.util.Objects.equals(r9, r10)
            if (r10 == 0) goto L_0x00b5
            r10 = 0
            goto L_0x00b6
        L_0x00b5:
            r10 = 1
        L_0x00b6:
            if (r10 == 0) goto L_0x0178
            java.lang.String r10 = "CancelTimeout"
            boolean r9 = java.util.Objects.equals(r9, r10)
            r10 = 27
            if (r9 == 0) goto L_0x00c5
            r9 = 27
            goto L_0x00c7
        L_0x00c5:
            r9 = 77
        L_0x00c7:
            if (r9 == r10) goto L_0x00ca
            goto L_0x00e0
        L_0x00ca:
            int r9 = f2951e
            int r9 = r9 + 35
            int r9 = r9 - r2
            int r9 = r9 - r7
            int r9 = r9 - r2
            int r10 = r9 % 128
            f2952f = r10
            int r9 = r9 % 2
            com.cardinalcommerce.a.setProgressBackgroundTintList r9 = r8.f2955d
            if (r9 == 0) goto L_0x00dd
            r9 = 0
            goto L_0x00de
        L_0x00dd:
            r9 = 1
        L_0x00de:
            if (r9 == 0) goto L_0x00fb
        L_0x00e0:
            com.cardinalcommerce.emvco.services.ChallengeStatusReceiver r9 = init
            r9.cancelled()
            int r9 = f2951e
            r10 = r9 & 109(0x6d, float:1.53E-43)
            int r0 = ~r10
            r9 = r9 | 109(0x6d, float:1.53E-43)
            r9 = r9 & r0
            int r10 = r10 << r2
            r0 = r9 | r10
            int r0 = r0 << r2
            r9 = r9 ^ r10
            int r0 = r0 - r9
            int r9 = r0 % 128
            f2952f = r9
            int r0 = r0 % 2
            goto L_0x01a5
        L_0x00fb:
            int r9 = f2951e
            r10 = r9 & 99
            r9 = r9 | 99
            r0 = r10 ^ r9
            r9 = r9 & r10
            int r9 = r9 << r2
            int r0 = r0 + r9
            int r9 = r0 % 128
            f2952f = r9
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x0110
            r9 = 1
            goto L_0x0111
        L_0x0110:
            r9 = 0
        L_0x0111:
            r10 = 79
            if (r9 == r2) goto L_0x0128
            com.cardinalcommerce.emvco.services.ChallengeStatusReceiver r9 = init
            r9.cancelled()
            com.cardinalcommerce.a.setProgressBackgroundTintList r9 = r8.f2955d
            r0 = 69
            if (r9 == 0) goto L_0x0123
            r9 = 18
            goto L_0x0125
        L_0x0123:
            r9 = 69
        L_0x0125:
            if (r9 == r0) goto L_0x01a5
            goto L_0x013c
        L_0x0128:
            com.cardinalcommerce.emvco.services.ChallengeStatusReceiver r9 = init
            r9.cancelled()
            com.cardinalcommerce.a.setProgressBackgroundTintList r9 = r8.f2955d
            r0 = 63
            int r0 = r0 / r7
            if (r9 == 0) goto L_0x0137
            r9 = 79
            goto L_0x0139
        L_0x0137:
            r9 = 85
        L_0x0139:
            if (r9 == r10) goto L_0x013c
            goto L_0x01a5
        L_0x013c:
            int r9 = f2952f
            r0 = r9 | 89
            int r0 = r0 << r2
            r9 = r9 ^ r5
            int r0 = r0 - r9
            int r9 = r0 % 128
            f2951e = r9
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x014d
            r10 = 15
        L_0x014d:
            if (r10 == r1) goto L_0x0157
            com.cardinalcommerce.a.setProgressBackgroundTintList r9 = r8.f2955d
            java.util.concurrent.ExecutorService r9 = r9.getSDKVersion
            r9.shutdownNow()
            goto L_0x015f
        L_0x0157:
            com.cardinalcommerce.a.setProgressBackgroundTintList r9 = r8.f2955d
            java.util.concurrent.ExecutorService r9 = r9.getSDKVersion
            r9.shutdownNow()
            int r9 = r6.length     // Catch:{ all -> 0x0174 }
        L_0x015f:
            int r9 = f2951e
            r10 = r9 & 83
            r9 = r9 ^ 83
            r9 = r9 | r10
            int r9 = -r9
            int r9 = -r9
            r0 = r10 ^ r9
            r9 = r9 & r10
            int r9 = r9 << r2
            int r0 = r0 + r9
            int r9 = r0 % 128
            f2952f = r9
            int r0 = r0 % 2
            goto L_0x01a5
        L_0x0174:
            r9 = move-exception
            throw r9
        L_0x0176:
            r9 = move-exception
            throw r9
        L_0x0178:
            int r9 = f2952f
            int r9 = r9 + 53
            int r10 = r9 % 128
            f2951e = r10
            int r9 = r9 % 2
            if (r9 == 0) goto L_0x0186
            r9 = 0
            goto L_0x0187
        L_0x0186:
            r9 = 1
        L_0x0187:
            if (r9 == r2) goto L_0x0194
            com.cardinalcommerce.emvco.services.ChallengeStatusReceiver r9 = init
            r9.timedout()
            super.hashCode()     // Catch:{ all -> 0x0192 }
            goto L_0x0199
        L_0x0192:
            r9 = move-exception
            throw r9
        L_0x0194:
            com.cardinalcommerce.emvco.services.ChallengeStatusReceiver r9 = init
            r9.timedout()
        L_0x0199:
            int r9 = f2952f
            r10 = r9 & 103(0x67, float:1.44E-43)
            r9 = r9 ^ 103(0x67, float:1.44E-43)
            r9 = r9 | r10
            int r9 = ~r9
            int r10 = r10 - r9
            int r10 = r10 - r2
            goto L_0x00a3
        L_0x01a5:
            com.cardinalcommerce.p060a.setTextAppearance.getInstance()
            android.os.CountDownTimer r9 = configure
            if (r9 == 0) goto L_0x01ae
            r9 = 0
            goto L_0x01af
        L_0x01ae:
            r9 = 1
        L_0x01af:
            if (r9 == r2) goto L_0x01e9
            int r9 = f2951e
            r10 = r9 & 55
            int r0 = ~r10
            r9 = r9 | 55
            r9 = r9 & r0
            int r10 = r10 << r2
            r0 = r9 ^ r10
            r9 = r9 & r10
            int r9 = r9 << r2
            int r0 = r0 + r9
            int r9 = r0 % 128
            f2952f = r9
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x01c8
            r7 = 1
        L_0x01c8:
            if (r7 == 0) goto L_0x01d5
            android.os.CountDownTimer r9 = configure
            r9.cancel()
            configure = r6
            int r9 = r6.length     // Catch:{ all -> 0x01d3 }
            goto L_0x01dc
        L_0x01d3:
            r9 = move-exception
            throw r9
        L_0x01d5:
            android.os.CountDownTimer r9 = configure
            r9.cancel()
            configure = r6
        L_0x01dc:
            int r9 = f2951e
            r10 = r9 & 111(0x6f, float:1.56E-43)
            r9 = r9 | 111(0x6f, float:1.56E-43)
            int r10 = r10 + r9
            int r9 = r10 % 128
            f2952f = r9
            int r10 = r10 % 2
        L_0x01e9:
            int r9 = f2951e
            r10 = r9 | 85
            int r10 = r10 << r2
            r0 = r9 & -86
            int r9 = ~r9
            r9 = r9 & r3
            r9 = r9 | r0
            int r10 = r10 - r9
            int r9 = r10 % 128
            f2952f = r9
            int r10 = r10 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setProgressTintBlendMode.configure(java.lang.String, com.cardinalcommerce.a.setSecondaryProgressTintMode):void");
    }

    /* JADX WARNING: type inference failed for: r9v1, types: [java.lang.Object, com.cardinalcommerce.a.setCompoundDrawablePadding, com.cardinalcommerce.a.setProgress] */
    public static char[] getInstance(setProgressDrawable setprogressdrawable) {
        String str;
        char[] cArr = new char[0];
        String str2 = setprogressdrawable.cca_continue;
        C2029s sVar = new C2029s(setprogressdrawable);
        ? r9 = 0;
        Context context = sVar.f2644e;
        sVar.f2640a.put("DV", "1.1");
        sVar.f2640a.put("DD", sVar.f2641b);
        sVar.f2640a.put("DPNA", sVar.f2642c);
        sVar.f2640a.put("SW", sVar.f2643d);
        String jSONObject = sVar.f2640a.toString();
        setProgressTintList init2 = new setMaxHeight(context).init(str2);
        if ((init2.cca_continue == setSecondaryProgress.RSA ? 'a' : '!') != 'a') {
            ECPublicKey init3 = setProgressDrawableTiled.init(init2.configure);
            KeyPair configure2 = setProgressDrawableTiled.configure();
            SecretKey cca_continue2 = setProgressDrawableTiled.cca_continue((PublicKey) init3, configure2.getPrivate(), str2);
            ECKey Cardinal2 = new ECKey.cca_continue(Curve.getInstance, (ECPublicKey) configure2.getPublic()).Cardinal();
            JWEHeader.C2155configure configure3 = new JWEHeader.C2155configure(JWEAlgorithm.cleanup, EncryptionMethod.getInstance);
            configure3.CardinalEnvironment = ECKey.Cardinal(Cardinal2.cca_continue().toString());
            JWEObject jWEObject = new JWEObject(configure3.cca_continue(), new Payload(jSONObject));
            if (cca_continue2 != null) {
                jWEObject.init(new DirectEncrypter(cca_continue2));
                str = jWEObject.init();
                int i = (f2952f + 67) - 1;
                int i2 = (i & -1) + (i | -1);
                f2951e = i2 % 128;
                int i3 = i2 % 2;
            } else {
                throw new ParseException("Null secretKey Exception", 0);
            }
        } else {
            int i4 = f2952f;
            int i5 = ((i4 | 77) << 1) - (i4 ^ 77);
            f2951e = i5 % 128;
            int i6 = i5 % 2;
            if (!(init2.init != setMax.KEY)) {
                int i7 = f2951e;
                int i8 = i7 ^ 25;
                int i9 = ((i7 & 25) | i8) << 1;
                int i10 = -i8;
                int i11 = (i9 ^ i10) + ((i9 & i10) << 1);
                f2952f = i11 % 128;
                int i12 = i11 % 2;
                str = setSecondaryProgressTintList.cca_continue(jSONObject, setProgressDrawableTiled.configure(init2.configure));
                int i13 = f2952f;
                int i14 = i13 | 29;
                int i15 = ((i14 << 1) - (~(-((~(i13 & 29)) & i14)))) - 1;
                f2951e = i15 % 128;
                int i16 = i15 % 2;
            } else {
                str = setSecondaryProgressTintList.cca_continue(jSONObject, setProgressDrawableTiled.Cardinal(init2.configure));
                int i17 = (f2951e + 56) - 1;
                f2952f = i17 % 128;
                int i18 = i17 % 2;
            }
        }
        try {
            cArr = setHorizontallyScrolling.getInstance(str);
            setProgress.Cardinal();
            setProgress.getInstance.init();
            setProgress.Cardinal();
            if (setProgress.getInstance != null) {
                int i19 = (((f2952f + 37) - 1) - 0) - 1;
                f2951e = i19 % 128;
                int i20 = i19 % 2;
                setProgress.getInstance.init();
                int i21 = f2951e;
                int i22 = i21 ^ 35;
                int i23 = ((i21 & 35) | i22) << 1;
                int i24 = -i22;
                int i25 = ((i23 | i24) << 1) - (i23 ^ i24);
                f2952f = i25 % 128;
                int i26 = i25 % 2;
            }
            setProgress.getInstance = r9;
            setProgress.configure = r9;
            CardinalError.Cardinal("EMVCoTransaction", "Encrypted LASSO Created");
            int i27 = f2952f;
            int i28 = (((i27 & 28) + (i27 | 28)) - 0) - 1;
            f2951e = i28 % 128;
            int i29 = i28 % 2;
        } catch (Exception e) {
            setProgressBackgroundTintMode setprogressbackgroundtintmode = CardinalError;
            StringBuilder sb = new StringBuilder("Error Encrypting Device Information: \n");
            sb.append(e.getLocalizedMessage());
            setprogressbackgroundtintmode.init(new setImageMatrix(11315, sb.toString()));
        }
        int i30 = f2951e;
        int i31 = i30 ^ 67;
        int i32 = (i30 & 67) << 1;
        int i33 = (i31 & i32) + (i32 | i31);
        f2952f = i33 % 128;
        if ((i33 % 2 == 0 ? '?' : VersionRange.RIGHT_OPEN) != '?') {
            return cArr;
        }
        super.hashCode();
        return cArr;
    }

    /* renamed from: a */
    static /* synthetic */ void m2075a(setProgressTintBlendMode setprogresstintblendmode) {
        setSecondaryProgressTintList setsecondaryprogresstintlist = new setSecondaryProgressTintList(setprogresstintblendmode.getInstance.init());
        setsecondaryprogresstintlist.cca_continue = "402";
        setsecondaryprogresstintlist.getInstance = "Transaction Timed Out";
        setsecondaryprogresstintlist.init = "For example, a slowly processing back-end system.";
        setsecondaryprogresstintlist.CardinalError = setprogresstintblendmode.f2954c.get3DSServerTransactionID();
        setsecondaryprogresstintlist.getWarnings = setprogresstintblendmode.f2954c.getAcsTransactionID();
        setsecondaryprogresstintlist.getSDKVersion = new String(setprogresstintblendmode.Cardinal);
        setProgressBackgroundTintBlendMode setprogressbackgroundtintblendmode = new setProgressBackgroundTintBlendMode(setsecondaryprogresstintlist, (String) null);
        setprogressbackgroundtintblendmode.configure();
        setprogressbackgroundtintblendmode.getSDKVersion.execute(new Runnable() {
            private static int Cardinal;
            private static int configure;

            /*  JADX ERROR: Method generation error
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cardinalcommerce.a.setKeyListener.4.run():void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                */
            /*  JADX ERROR: Method generation error: Method args not loaded: com.cardinalcommerce.a.setKeyListener.4.run():void, class status: UNLOADED
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cardinalcommerce.a.setKeyListener.4.run():void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                */
            public final void run(
/*
Method generation error in method: com.cardinalcommerce.a.setKeyListener.4.run():void, dex: classes.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cardinalcommerce.a.setKeyListener.4.run():void, class status: UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/
        });
        setprogresstintblendmode.configure("TimeOutError", new setSecondaryProgressTintMode());
        int i = f2952f;
        int i2 = ((i | 15) << 1) - (i ^ 15);
        f2951e = i2 % 128;
        int i3 = i2 % 2;
    }
}
