package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.EncryptionMethod;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEAlgorithm;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEObject;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.Payload;
import com.cardinalcommerce.emvco.events.ProtocolErrorEvent;
import com.cardinalcommerce.emvco.events.RuntimeErrorEvent;
import com.cardinalcommerce.emvco.parameters.ChallengeParameters;
import com.cardinalcommerce.shared.models.ErrorMessage;
import com.cardinalcommerce.shared.models.exceptions.SDKRuntimeException;
import com.didi.soda.customer.app.constant.Const;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.facebook.internal.NativeProtocol;
import java.security.KeyPair;
import java.util.Arrays;
import java.util.concurrent.Executors;
import javax.crypto.SecretKey;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.VersionRange;

/* renamed from: com.cardinalcommerce.a.setProgressBackgroundTintList */
public final class setProgressBackgroundTintList extends setKeyListener implements Runnable {

    /* renamed from: l */
    private static int f2927l = 0;

    /* renamed from: m */
    private static int f2928m = 1;

    /* renamed from: a */
    private final setIndeterminateTintBlendMode f2929a;

    /* renamed from: b */
    private char[] f2930b;

    /* renamed from: c */
    private SecretKey f2931c;

    /* renamed from: d */
    private byte[] f2932d;

    /* renamed from: e */
    private C2026q f2933e;

    /* renamed from: f */
    private final char[] f2934f;

    /* renamed from: g */
    private final char[] f2935g;

    /* renamed from: h */
    private final char[] f2936h;

    /* renamed from: i */
    private setTypeface f2937i;

    /* renamed from: j */
    private char[] f2938j;

    /* renamed from: k */
    private final setProgressBackgroundTintMode f2939k;

    /* renamed from: a */
    private static /* synthetic */ char[] m2061a(setProgressBackgroundTintList setprogressbackgroundtintlist) {
        int i = f2927l;
        int i2 = (((i ^ 116) + ((i & 116) << 1)) + 0) - 1;
        f2928m = i2 % 128;
        char c = i2 % 2 == 0 ? 'W' : '*';
        char[] cArr = setprogressbackgroundtintlist.f2930b;
        if (c != '*') {
            Object obj = null;
            super.hashCode();
        }
        return cArr;
    }

    /* renamed from: b */
    private static /* synthetic */ byte[] m2063b(setProgressBackgroundTintList setprogressbackgroundtintlist) {
        int i = (f2927l + 126) - 1;
        f2928m = i % 128;
        boolean z = i % 2 == 0;
        byte[] bArr = null;
        setprogressbackgroundtintlist.f2932d = bArr;
        if (z) {
            int length = bArr.length;
        }
        int i2 = f2927l;
        int i3 = i2 & 35;
        int i4 = ((i2 ^ 35) | i3) << 1;
        int i5 = -((i2 | 35) & (~i3));
        int i6 = ((i4 | i5) << 1) - (i5 ^ i4);
        f2928m = i6 % 128;
        int i7 = i6 % 2;
        return bArr;
    }

    /* renamed from: c */
    private static /* synthetic */ char[] m2066c(setProgressBackgroundTintList setprogressbackgroundtintlist) {
        int i = f2928m;
        int i2 = (i & -60) | ((~i) & 59);
        int i3 = -(-((i & 59) << 1));
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f2927l = i4 % 128;
        char c = i4 % 2 != 0 ? 17 : '^';
        char[] cArr = setprogressbackgroundtintlist.f2934f;
        if (c != '^') {
            int i5 = 44 / 0;
        }
        int i6 = f2927l + 75;
        f2928m = i6 % 128;
        if ((i6 % 2 == 0 ? 'H' : ',') == ',') {
            return cArr;
        }
        int i7 = 23 / 0;
        return cArr;
    }

    /* renamed from: d */
    private static /* synthetic */ char[] m2067d(setProgressBackgroundTintList setprogressbackgroundtintlist) {
        int i = f2928m;
        int i2 = (i & 117) + (i | 117);
        f2927l = i2 % 128;
        int i3 = i2 % 2;
        char[] cArr = setprogressbackgroundtintlist.f2935g;
        int i4 = f2927l;
        int i5 = (((i4 ^ 10) + ((i4 & 10) << 1)) + 0) - 1;
        f2928m = i5 % 128;
        int i6 = i5 % 2;
        return cArr;
    }

    /* renamed from: e */
    private static /* synthetic */ char[] m2068e(setProgressBackgroundTintList setprogressbackgroundtintlist) {
        int i = f2927l + 69;
        f2928m = i % 128;
        boolean z = i % 2 == 0;
        char[] cArr = setprogressbackgroundtintlist.f2936h;
        if (z) {
            Object obj = null;
            super.hashCode();
        }
        return cArr;
    }

    /* renamed from: f */
    private static /* synthetic */ char[] m2069f(setProgressBackgroundTintList setprogressbackgroundtintlist) {
        int i = f2928m;
        int i2 = ((i ^ 117) | (i & 117)) << 1;
        int i3 = -(((~i) & 117) | (i & -118));
        int i4 = ((i2 | i3) << 1) - (i3 ^ i2);
        f2927l = i4 % 128;
        char c = i4 % 2 != 0 ? 6 : '\'';
        char[] cArr = setprogressbackgroundtintlist.f2938j;
        if (c != '\'') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i5 = f2928m;
        int i6 = i5 & 1;
        int i7 = ((((i5 ^ 1) | i6) << 1) - (~(-((i5 | 1) & (~i6))))) - 1;
        f2927l = i7 % 128;
        int i8 = i7 % 2;
        return cArr;
    }

    public setProgressBackgroundTintList(setIndeterminateTintBlendMode setindeterminatetintblendmode, ChallengeParameters challengeParameters, setProgressDrawable setprogressdrawable) throws JSONException {
        this.f2939k = setProgressBackgroundTintMode.init();
        C2026q.f2626a = null;
        C2026q a = C2026q.m1921a();
        this.f2933e = a;
        a.f2633f = setprogressdrawable.init();
        KeyPair keyPair = setprogressdrawable.getWarnings;
        this.f2934f = setHorizontallyScrolling.getInstance(setprogressdrawable.getSDKVersion);
        this.f2936h = setHorizontallyScrolling.getInstance(challengeParameters.getAcsTransactionID());
        this.f2935g = setHorizontallyScrolling.getInstance(challengeParameters.get3DSServerTransactionID());
        this.f2929a = setindeterminatetintblendmode;
        try {
            setImageTintBlendMode setimagetintblendmode = new setImageTintBlendMode(challengeParameters, setprogressdrawable);
            this.f2930b = setHorizontallyScrolling.getInstance(setimagetintblendmode.cca_continue);
            this.f2933e.f2630c = setimagetintblendmode;
            if (challengeParameters.getThreeDSRequestorAppURL() != null) {
                this.f2933e.f2632e = setHorizontallyScrolling.getInstance(challengeParameters.getThreeDSRequestorAppURL());
            }
            this.f2937i = new setTypeface(setHorizontallyScrolling.getInstance(challengeParameters.get3DSServerTransactionID()), setHorizontallyScrolling.getInstance(challengeParameters.getAcsTransactionID()), this.f2933e.f2629b, setHorizontallyScrolling.getInstance(setprogressdrawable.getSDKVersion), setprogressdrawable.init(), setHorizontallyScrolling.getInstance(challengeParameters.getThreeDSRequestorAppURL()));
            SecretKey cca_continue = setProgressDrawableTiled.cca_continue(setimagetintblendmode.configure, keyPair, setprogressdrawable.getInstance);
            this.f2931c = cca_continue;
            this.f2933e.f2631d = cca_continue;
            this.f2932d = m2060a(this.f2937i.CardinalConfigurationParameters());
            this.f2938j = this.f2937i.init();
            super.Cardinal(new String(this.f2930b), this.f2932d);
            this.f2939k.Cardinal("EMVCoTransaction", "Encrypted CReq created");
            setTypeface settypeface = this.f2937i;
            if (settypeface != null) {
                Executors.newSingleThreadExecutor().execute(settypeface);
            }
        } catch (SDKRuntimeException e) {
            setProgressBackgroundTintMode setprogressbackgroundtintmode = this.f2939k;
            StringBuilder sb = new StringBuilder("Invalid ACSSignedContent \n");
            sb.append(e.getLocalizedMessage());
            setprogressbackgroundtintmode.init(new setImageMatrix(11403, sb.toString()));
            throw e;
        } catch (JSONException e2) {
            setProgressBackgroundTintMode setprogressbackgroundtintmode2 = this.f2939k;
            StringBuilder sb2 = new StringBuilder("Message is not CRes \n");
            sb2.append(e2.getLocalizedMessage());
            setprogressbackgroundtintmode2.init(new setImageMatrix(11413, sb2.toString()));
            throw e2;
        } catch (Throwable th) {
            setTypeface settypeface2 = this.f2937i;
            if (settypeface2 != null) {
                Executors.newSingleThreadExecutor().execute(settypeface2);
            }
            throw th;
        }
    }

    public setProgressBackgroundTintList(setIndeterminateTintBlendMode setindeterminatetintblendmode, setTypeface settypeface) throws JSONException {
        this.f2933e = C2026q.m1921a();
        this.f2939k = setProgressBackgroundTintMode.init();
        this.f2937i = settypeface;
        if (this.f2933e.mo18295b() != null) {
            this.f2937i.getSDKVersion = this.f2933e.mo18295b();
        }
        this.f2929a = setindeterminatetintblendmode;
        this.f2935g = this.f2933e.f2630c.init();
        this.f2934f = settypeface.CardinalError();
        this.f2936h = settypeface.Cardinal();
        if (settypeface.getInstance.getInstance()) {
            this.f2937i = settypeface;
            if (this.f2933e.mo18295b() != null) {
                this.f2937i.getSDKVersion = this.f2933e.mo18295b();
            }
            settypeface.cca_continue(this.f2933e.f2629b);
            this.f2930b = setHorizontallyScrolling.getInstance(this.f2933e.f2630c.cca_continue);
            this.f2931c = this.f2933e.f2631d;
            JSONObject CardinalConfigurationParameters = settypeface.CardinalConfigurationParameters();
            CardinalConfigurationParameters.put("notificationURL", setHorizontallyScrolling.configure((char[]) null));
            if (!setHorizontallyScrolling.init(settypeface.cca_continue)) {
                CardinalConfigurationParameters.put("challengeCancel", setHorizontallyScrolling.configure(settypeface.cca_continue));
            }
            if (!setHorizontallyScrolling.init(settypeface.CardinalError)) {
                CardinalConfigurationParameters.put("resendChallenge", setHorizontallyScrolling.configure(settypeface.CardinalError));
            }
            if (!settypeface.Cardinal.init.equalsIgnoreCase("04") && !settypeface.Cardinal.init.equalsIgnoreCase("05")) {
                CardinalConfigurationParameters.put("challengeDataEntry", setHorizontallyScrolling.configure(settypeface.configure));
            }
            if (settypeface.Cardinal.init.equalsIgnoreCase("05")) {
                CardinalConfigurationParameters.put("challengeHTMLDataEntry", setHorizontallyScrolling.configure(settypeface.init));
            }
            if (settypeface.Cardinal.init.equalsIgnoreCase("04")) {
                CardinalConfigurationParameters.put("oobContinue", settypeface.cleanup);
            }
            if (settypeface.cleanup() != null) {
                CardinalConfigurationParameters.put("whitelistingDataEntry", setHorizontallyScrolling.configure(settypeface.cleanup()));
            }
            if (!setHorizontallyScrolling.init(settypeface.valueOf()) && settypeface.CardinalActionCode()) {
                CardinalConfigurationParameters.put("challengeNoEntry", setHorizontallyScrolling.configure(settypeface.valueOf()));
            }
            this.f2932d = m2060a(CardinalConfigurationParameters);
            this.f2938j = settypeface.init();
            super.Cardinal(new String(this.f2930b), this.f2932d);
        } else {
            setSecondaryProgressTintList setsecondaryprogresstintlist = new setSecondaryProgressTintList(this.f2933e.mo18296c());
            setsecondaryprogresstintlist.cca_continue = "203";
            setsecondaryprogresstintlist.getInstance = "Data element not in the required format or value is invalid as defined in Table A.1,";
            setsecondaryprogresstintlist.init = settypeface.getInstance.configure;
            setsecondaryprogresstintlist.getWarnings = Arrays.toString(settypeface.Cardinal());
            setsecondaryprogresstintlist.CardinalError = Arrays.toString(settypeface.cca_continue());
            setsecondaryprogresstintlist.getSDKVersion = Arrays.toString(settypeface.CardinalError());
            m2057a(setsecondaryprogresstintlist);
            m2058a(new ErrorMessage(setsecondaryprogresstintlist.CardinalError, setsecondaryprogresstintlist.cca_continue, setsecondaryprogresstintlist.getInstance, setsecondaryprogresstintlist.init));
            setProgressBackgroundTintMode setprogressbackgroundtintmode = this.f2939k;
            StringBuilder sb = new StringBuilder("Error 203 Created: \n");
            sb.append(setsecondaryprogresstintlist.getInstance);
            sb.append(" - ");
            sb.append(setsecondaryprogresstintlist.init);
            setprogressbackgroundtintmode.init(new setImageMatrix(12203, sb.toString()));
        }
        setTypeface settypeface2 = this.f2937i;
        if (settypeface2 != null) {
            Executors.newSingleThreadExecutor().execute(settypeface2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006f, code lost:
        if ((!java.util.Arrays.equals(r13.f2938j, com.cardinalcommerce.p060a.setHeight.cleanup) ? 25 : '$') != 25) goto L_0x0071;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0430  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0433  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0437  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x048b  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x048e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0492 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cca_continue(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "Challenge Task finished"
            java.lang.String r2 = "EMVCoTransaction"
            int r3 = f2927l
            r4 = r3 & 97
            r3 = r3 | 97
            r5 = r4 ^ r3
            r3 = r3 & r4
            r4 = 1
            int r3 = r3 << r4
            int r5 = r5 + r3
            int r3 = r5 % 128
            f2928m = r3
            int r5 = r5 % 2
            char[] r3 = r13.f2938j
            boolean r3 = com.cardinalcommerce.p060a.setHorizontallyScrolling.init((char[]) r3)
            r5 = 0
            if (r3 == 0) goto L_0x0023
            r3 = 0
            goto L_0x0024
        L_0x0023:
            r3 = 1
        L_0x0024:
            r6 = 0
            if (r3 == 0) goto L_0x0028
            goto L_0x0071
        L_0x0028:
            int r3 = f2928m
            r7 = r3 & 13
            r3 = r3 ^ 13
            r3 = r3 | r7
            r8 = r7 | r3
            int r8 = r8 << r4
            r3 = r3 ^ r7
            int r8 = r8 - r3
            int r3 = r8 % 128
            f2927l = r3
            int r8 = r8 % 2
            char[] r3 = r13.f2938j
            char[] r7 = com.cardinalcommerce.p060a.setHeight.getWarnings
            boolean r3 = java.util.Arrays.equals(r3, r7)
            if (r3 == 0) goto L_0x0046
            r3 = 0
            goto L_0x0047
        L_0x0046:
            r3 = 1
        L_0x0047:
            if (r3 == 0) goto L_0x004a
            goto L_0x0094
        L_0x004a:
            int r3 = f2928m
            r7 = r3 ^ 73
            r3 = r3 & 73
            int r3 = r3 << r4
            int r3 = -r3
            int r3 = -r3
            r8 = r7 ^ r3
            r3 = r3 & r7
            int r3 = r3 << r4
            int r8 = r8 + r3
            int r3 = r8 % 128
            f2927l = r3
            int r8 = r8 % 2
            char[] r3 = r13.f2938j
            char[] r7 = com.cardinalcommerce.p060a.setHeight.cleanup
            boolean r3 = java.util.Arrays.equals(r3, r7)
            r7 = 25
            if (r3 != 0) goto L_0x006d
            r3 = 25
            goto L_0x006f
        L_0x006d:
            r3 = 36
        L_0x006f:
            if (r3 == r7) goto L_0x0094
        L_0x0071:
            int r14 = f2927l
            r0 = r14 & 34
            r14 = r14 | 34
            int r0 = r0 + r14
            r14 = r0 ^ -1
            r0 = r0 & -1
            int r0 = r0 << r4
            int r14 = r14 + r0
            int r0 = r14 % 128
            f2928m = r0
            int r14 = r14 % 2
            r0 = 49
            if (r14 != 0) goto L_0x008b
            r14 = 49
            goto L_0x008d
        L_0x008b:
            r14 = 85
        L_0x008d:
            if (r14 == r0) goto L_0x0090
            return
        L_0x0090:
            int r14 = r6.length     // Catch:{ all -> 0x0092 }
            return
        L_0x0092:
            r14 = move-exception
            throw r14
        L_0x0094:
            r3 = 99
            r7 = 93
            r8 = 12101(0x2f45, float:1.6957E-41)
            boolean r9 = r14.isEmpty()     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r10 = 65
            if (r9 == 0) goto L_0x00a5
            r9 = 60
            goto L_0x00a7
        L_0x00a5:
            r9 = 65
        L_0x00a7:
            java.lang.String r11 = "Message is not CRes"
            if (r9 == r10) goto L_0x00d0
            int r14 = f2927l
            r0 = r14 & -94
            int r9 = ~r14
            r9 = r9 & r7
            r0 = r0 | r9
            r14 = r14 & r7
            int r14 = r14 << r4
            r9 = r0 ^ r14
            r14 = r14 & r0
            int r14 = r14 << r4
            int r9 = r9 + r14
            int r14 = r9 % 128
            f2928m = r14
            int r9 = r9 % 2
            r13.m2062b((java.lang.String) r11)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            int r14 = f2928m
            int r14 = r14 + 40
            int r14 = r14 - r5
        L_0x00c7:
            int r14 = r14 - r4
        L_0x00c8:
            int r0 = r14 % 128
            f2927l = r0
            int r14 = r14 % 2
            goto L_0x0425
        L_0x00d0:
            boolean r9 = m2059a((java.lang.String) r14)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            if (r9 != 0) goto L_0x039f
            javax.crypto.SecretKey r0 = r13.f2931c     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEObject r14 = com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEObject.Cardinal((java.lang.String) r14)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.DirectDecrypter r9 = new com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.DirectDecrypter     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            byte[] r0 = r0.getEncoded()     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r10 = 32
            r12 = 16
            byte[] r0 = java.util.Arrays.copyOfRange(r0, r12, r10)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.<init>((byte[]) r0)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.Cardinal((com.cardinalcommerce.p060a.setChecked) r9)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.dependencies.internal.nimbusds.jose.Payload r14 = r14.cca_continue     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = r14.toString()     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.setBaselineAligned r0 = new com.cardinalcommerce.a.setBaselineAligned     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r0.<init>(r14)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = r0.CardinalEnvironment     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = "CRes"
            boolean r14 = r14.equals(r9)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            if (r14 != 0) goto L_0x0123
            com.cardinalcommerce.a.setProgressBackgroundTintMode r14 = r13.f2939k     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.setImageMatrix r0 = new com.cardinalcommerce.a.setImageMatrix     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = "Error 101 Created: Message Description Invalid"
            r0.<init>(r8, r9)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.init(r0)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r13.m2062b((java.lang.String) r11)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            int r14 = f2927l
            r0 = r14 | 93
            int r0 = r0 << r4
            r14 = r14 ^ r7
            int r0 = r0 - r14
            int r14 = r0 % 128
            f2928m = r14
        L_0x011f:
            int r0 = r0 % 2
            goto L_0x0425
        L_0x0123:
            com.cardinalcommerce.a.setTransformationMethod r14 = com.cardinalcommerce.p060a.setProgressTintList.m2076a(r0)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            boolean r14 = r14.getInstance()     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            if (r14 != 0) goto L_0x017b
            com.cardinalcommerce.a.setProgressBackgroundTintMode r14 = r13.f2939k     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.setImageMatrix r9 = new com.cardinalcommerce.a.setImageMatrix     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r10 = 12201(0x2fa9, float:1.7097E-41)
            java.lang.String r11 = "Error 201 Created: Required data element missing"
            r9.<init>(r10, r11)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.init(r9)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.setTransformationMethod r14 = com.cardinalcommerce.p060a.setProgressTintList.m2076a(r0)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.setSecondaryProgressTintList r9 = new com.cardinalcommerce.a.setSecondaryProgressTintList     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.q r10 = r13.f2933e     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            char[] r10 = r10.mo18296c()     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.<init>((char[]) r10)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r10 = "201"
            r9.cca_continue = r10     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r10 = "A message element required as defined in Table A.1 is missing from the message."
            r9.getInstance = r10     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = r14.configure     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.init = r14     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = r0.cca_continue     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.getWarnings = r14     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = r0.configure     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.CardinalError = r14     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = r0.setRequestTimeout     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.getSDKVersion = r14     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r13.m2057a((com.cardinalcommerce.p060a.setSecondaryProgressTintList) r9)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.shared.models.ErrorMessage r14 = new com.cardinalcommerce.shared.models.ErrorMessage     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r0 = r9.CardinalError     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r10 = r9.cca_continue     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r11 = r9.getInstance     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = r9.init     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.<init>(r0, r10, r11, r9)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r13.m2058a((com.cardinalcommerce.shared.models.ErrorMessage) r14)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            int r14 = f2928m
            int r14 = r14 + 23
            goto L_0x00c8
        L_0x017b:
            java.util.List<java.lang.String> r14 = com.cardinalcommerce.p060a.setHeight.init     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = r0.CardinalConfigurationParameters     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            boolean r14 = r14.contains(r9)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            if (r14 != 0) goto L_0x01e8
            com.cardinalcommerce.a.setProgressBackgroundTintMode r14 = r13.f2939k     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.setImageMatrix r9 = new com.cardinalcommerce.a.setImageMatrix     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r10 = 12102(0x2f46, float:1.6959E-41)
            java.lang.String r11 = "Error 102 Created: Invalid Message Version"
            r9.<init>(r10, r11)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.init(r9)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.setSecondaryProgressTintList r14 = new com.cardinalcommerce.a.setSecondaryProgressTintList     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.q r9 = r13.f2933e     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            char[] r9 = r9.mo18296c()     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.<init>((char[]) r9)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = "102"
            r14.cca_continue = r9     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = "Message Version Number received is not valid for the receiving component."
            r14.getInstance = r9     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = new java.lang.String     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.q r10 = r13.f2933e     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            char[] r10 = r10.mo18296c()     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.<init>(r10)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.init = r9     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = r0.cca_continue     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.getWarnings = r9     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = r0.configure     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.CardinalError = r9     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r0 = r0.setRequestTimeout     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.getSDKVersion = r0     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r13.m2057a((com.cardinalcommerce.p060a.setSecondaryProgressTintList) r14)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.shared.models.ErrorMessage r0 = new com.cardinalcommerce.shared.models.ErrorMessage     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = r14.CardinalError     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r10 = r14.cca_continue     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r11 = r14.getInstance     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = r14.init     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r0.<init>(r9, r10, r11, r14)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r13.m2058a((com.cardinalcommerce.shared.models.ErrorMessage) r0)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            int r14 = f2927l
            r0 = 115(0x73, float:1.61E-43)
            r7 = r14 & -116(0xffffffffffffff8c, float:NaN)
            int r8 = ~r14
            r8 = r8 & r0
            r7 = r7 | r8
            r14 = r14 & r0
            int r14 = r14 << r4
            int r14 = ~r14
            int r7 = r7 - r14
            int r7 = r7 - r4
            int r14 = r7 % 128
            f2928m = r14
            int r7 = r7 % 2
            goto L_0x0425
        L_0x01e8:
            boolean r14 = r0.setProxyAddress     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            if (r14 == 0) goto L_0x0245
            com.cardinalcommerce.a.setProgressBackgroundTintMode r14 = r13.f2939k     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.setImageMatrix r9 = new com.cardinalcommerce.a.setImageMatrix     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r10 = 12202(0x2faa, float:1.7099E-41)
            java.lang.String r11 = "Error 202 Created: SDK is Critical"
            r9.<init>(r10, r11)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.init(r9)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.setSecondaryProgressTintList r14 = new com.cardinalcommerce.a.setSecondaryProgressTintList     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.q r9 = r13.f2933e     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            char[] r9 = r9.mo18296c()     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.<init>((char[]) r9)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = "202"
            r14.cca_continue = r9     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = "Critical message extension not recognised."
            r14.getInstance = r9     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = r0.getRenderType     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.init = r9     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = r0.cca_continue     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.getWarnings = r9     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = r0.configure     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.CardinalError = r9     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r0 = r0.setRequestTimeout     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.getSDKVersion = r0     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r13.m2057a((com.cardinalcommerce.p060a.setSecondaryProgressTintList) r14)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.shared.models.ErrorMessage r0 = new com.cardinalcommerce.shared.models.ErrorMessage     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = r14.CardinalError     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r10 = r14.cca_continue     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r11 = r14.getInstance     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = r14.init     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r0.<init>(r9, r10, r11, r14)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r13.m2058a((com.cardinalcommerce.shared.models.ErrorMessage) r0)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            int r14 = f2927l
            r0 = r14 & 71
            r14 = r14 ^ 71
            r14 = r14 | r0
            int r14 = -r14
            int r14 = -r14
            r7 = r0 & r14
            r14 = r14 | r0
        L_0x023c:
            int r7 = r7 + r14
            int r14 = r7 % 128
            f2928m = r14
            int r7 = r7 % 2
            goto L_0x0425
        L_0x0245:
            com.cardinalcommerce.a.setTransformationMethod r14 = r0.setRenderType     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            boolean r14 = r14.getInstance()     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            if (r14 != 0) goto L_0x02b2
            com.cardinalcommerce.a.setTransformationMethod r14 = r0.setRenderType     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.setSecondaryProgressTintList r9 = new com.cardinalcommerce.a.setSecondaryProgressTintList     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.q r10 = r13.f2933e     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            char[] r10 = r10.mo18296c()     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.<init>((char[]) r10)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r10 = "203"
            r9.cca_continue = r10     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r10 = "Data element not in the required format or value is invalid as defined in Table A.1,"
            r9.getInstance = r10     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = r14.configure     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.init = r14     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = r0.cca_continue     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.getWarnings = r14     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = r0.configure     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.CardinalError = r14     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = r0.setRequestTimeout     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.getSDKVersion = r14     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r13.m2057a((com.cardinalcommerce.p060a.setSecondaryProgressTintList) r9)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.shared.models.ErrorMessage r14 = new com.cardinalcommerce.shared.models.ErrorMessage     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r0 = r9.CardinalError     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r10 = r9.cca_continue     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r11 = r9.getInstance     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r12 = r9.init     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.<init>(r0, r10, r11, r12)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r13.m2058a((com.cardinalcommerce.shared.models.ErrorMessage) r14)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.setProgressBackgroundTintMode r14 = r13.f2939k     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.setImageMatrix r0 = new com.cardinalcommerce.a.setImageMatrix     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r10 = 12203(0x2fab, float:1.71E-41)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r12 = "Error 203 Created: \n"
            r11.<init>(r12)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r12 = r9.getInstance     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r11.append(r12)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r12 = " - "
            r11.append(r12)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = r9.init     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r11.append(r9)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = r11.toString()     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r0.<init>(r10, r9)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.init(r0)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            int r14 = f2928m
            int r14 = r14 + 33
            int r14 = r14 - r4
            goto L_0x00c7
        L_0x02b2:
            java.lang.String r14 = r0.configure     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = new java.lang.String     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            char[] r10 = r13.f2935g     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.<init>(r10)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            boolean r14 = r14.equals(r9)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9 = 12301(0x300d, float:1.7237E-41)
            if (r14 != 0) goto L_0x02d6
            com.cardinalcommerce.a.setProgressBackgroundTintMode r14 = r13.f2939k     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.setImageMatrix r10 = new com.cardinalcommerce.a.setImageMatrix     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r11 = "Error 301 Created: Invalid ThreeDSServerTransID"
            r10.<init>(r9, r11)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.init(r10)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = "ThreeDSServerTransID"
            r13.m2056a(r0, r14)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            goto L_0x0425
        L_0x02d6:
            java.lang.String r14 = r0.cca_continue     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r10 = new java.lang.String     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            char[] r11 = r13.f2936h     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r10.<init>(r11)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            boolean r14 = r14.equals(r10)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            if (r14 != 0) goto L_0x02f8
            com.cardinalcommerce.a.setProgressBackgroundTintMode r14 = r13.f2939k     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.setImageMatrix r10 = new com.cardinalcommerce.a.setImageMatrix     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r11 = "Error 301 Created: Invalid AcsTransId"
            r10.<init>(r9, r11)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.init(r10)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = "AcsTransId"
            r13.m2056a(r0, r14)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            goto L_0x0425
        L_0x02f8:
            java.lang.String r14 = r0.setRequestTimeout     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r10 = new java.lang.String     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            char[] r11 = r13.f2934f     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r10.<init>(r11)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            boolean r14 = r14.equalsIgnoreCase(r10)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            if (r14 != 0) goto L_0x0325
            com.cardinalcommerce.a.setProgressBackgroundTintMode r14 = r13.f2939k     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.setImageMatrix r10 = new com.cardinalcommerce.a.setImageMatrix     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r11 = "Error 301 Created: Invalid SdkTransactionID"
            r10.<init>(r9, r11)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.init(r10)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = "sdkTransactionID"
            r13.m2056a(r0, r14)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            int r14 = f2927l
            int r14 = r14 + 126
            int r14 = r14 - r4
            int r0 = r14 % 128
            f2928m = r0
            int r14 = r14 % 2
            goto L_0x0425
        L_0x0325:
            java.lang.String r14 = r0.getEnvironment     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            int r14 = java.lang.Integer.parseInt(r14)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.q r9 = r13.f2933e     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            int r9 = r9.f2629b     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r10 = r9 ^ 0
            r9 = r9 & r5
            int r9 = r9 << r4
            int r10 = r10 + r9
            int r10 = r10 - r4
            if (r14 == r10) goto L_0x0388
            com.cardinalcommerce.a.setProgressBackgroundTintMode r14 = r13.f2939k     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.setImageMatrix r9 = new com.cardinalcommerce.a.setImageMatrix     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r10 = 12302(0x300e, float:1.7239E-41)
            java.lang.String r11 = "Error 302 Created: Data could not be decrypted"
            r9.<init>(r10, r11)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.init(r9)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = "AcsCounterAtoS"
            com.cardinalcommerce.a.setSecondaryProgressTintList r9 = new com.cardinalcommerce.a.setSecondaryProgressTintList     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.q r10 = r13.f2933e     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            char[] r10 = r10.mo18296c()     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.<init>((char[]) r10)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r10 = "302"
            r9.cca_continue = r10     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r10 = "Data could not be decrypted by the receiving system due to technical or other reason."
            r9.getInstance = r10     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.init = r14     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = r0.cca_continue     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.getWarnings = r14     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = r0.configure     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.CardinalError = r14     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = r0.setRequestTimeout     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.getSDKVersion = r14     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r13.m2057a((com.cardinalcommerce.p060a.setSecondaryProgressTintList) r9)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.shared.models.ErrorMessage r14 = new com.cardinalcommerce.shared.models.ErrorMessage     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r0 = r9.CardinalError     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r10 = r9.cca_continue     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r11 = r9.getInstance     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = r9.init     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.<init>(r0, r10, r11, r9)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r13.m2058a((com.cardinalcommerce.shared.models.ErrorMessage) r14)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            int r14 = f2927l
            r0 = r14 & 23
            r14 = r14 ^ 23
            r14 = r14 | r0
            r7 = r0 ^ r14
            r14 = r14 & r0
            int r14 = r14 << r4
            goto L_0x023c
        L_0x0388:
            com.cardinalcommerce.a.setIndeterminateTintBlendMode r14 = r13.f2929a     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.cca_continue(r0)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            int r14 = f2928m
            r0 = r14 | 110(0x6e, float:1.54E-43)
            int r0 = r0 << r4
            r14 = r14 ^ 110(0x6e, float:1.54E-43)
            int r0 = r0 - r14
            int r0 = r0 - r5
            int r0 = r0 - r4
        L_0x0397:
            int r14 = r0 % 128
            f2927l = r14
            int r0 = r0 % 2
            goto L_0x0425
        L_0x039f:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.<init>(r14)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = "errorCode"
            java.lang.String r14 = r9.optString(r14, r0)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            boolean r10 = r14.isEmpty()     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r11 = "errorDescription"
            if (r10 != 0) goto L_0x03f0
            java.lang.String r10 = r9.optString(r11, r0)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r11 = "errorDetail"
            java.lang.String r0 = r9.optString(r11, r0)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.setSecondaryProgressTintList r9 = new com.cardinalcommerce.a.setSecondaryProgressTintList     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r11 = new java.lang.String     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.q r12 = r13.f2933e     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            char[] r12 = r12.mo18296c()     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r11.<init>(r12)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.<init>((java.lang.String) r11)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.cca_continue = r14     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.getInstance = r10     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r9.init = r0     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.shared.models.ErrorMessage r14 = new com.cardinalcommerce.shared.models.ErrorMessage     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r0 = r9.CardinalError     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r10 = r9.cca_continue     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r11 = r9.getInstance     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r9 = r9.init     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.<init>(r0, r10, r11, r9)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r13.m2058a((com.cardinalcommerce.shared.models.ErrorMessage) r14)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            int r14 = f2928m
            r0 = r14 ^ 123(0x7b, float:1.72E-43)
            r7 = r14 & 123(0x7b, float:1.72E-43)
            r0 = r0 | r7
            int r0 = r0 << r4
            int r7 = ~r7
            r14 = r14 | 123(0x7b, float:1.72E-43)
            r14 = r14 & r7
            int r0 = r0 - r14
            goto L_0x0397
        L_0x03f0:
            com.cardinalcommerce.a.setProgressBackgroundTintMode r14 = r13.f2939k     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            com.cardinalcommerce.a.setImageMatrix r0 = new com.cardinalcommerce.a.setImageMatrix     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r10 = "Error 101 Created: Message is not CRes - Challenge Decrypted CardinalError"
            r0.<init>(r8, r10)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r14.init(r0)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = "Challenge Decrypted CardinalError"
            java.lang.String r14 = r9.optString(r11, r14)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r0 = "Message is not CRes "
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            java.lang.String r14 = r0.concat(r14)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            r13.m2065c((java.lang.String) r14)     // Catch:{ JOSEException -> 0x04f6, ParseException -> 0x04f4, JSONException -> 0x0496 }
            int r14 = f2928m
            r0 = r14 ^ 125(0x7d, float:1.75E-43)
            r7 = r14 & 125(0x7d, float:1.75E-43)
            r0 = r0 | r7
            int r0 = r0 << r4
            int r7 = ~r7
            r14 = r14 | 125(0x7d, float:1.75E-43)
            r14 = r14 & r7
            int r14 = -r14
            int r14 = ~r14
            int r0 = r0 - r14
            int r0 = r0 - r4
            int r14 = r0 % 128
            f2927l = r14
            goto L_0x011f
        L_0x0425:
            com.cardinalcommerce.a.setProgressBackgroundTintMode r14 = r13.f2939k
            r14.Cardinal(r2, r1)
            com.cardinalcommerce.a.setTypeface r14 = r13.f2937i
            r0 = 89
            if (r14 == 0) goto L_0x0433
            r14 = 14
            goto L_0x0435
        L_0x0433:
            r14 = 89
        L_0x0435:
            if (r14 == r0) goto L_0x0473
            int r14 = f2928m
            r0 = r14 ^ 37
            r14 = r14 & 37
            r14 = r14 | r0
            int r14 = r14 << r4
            int r0 = -r0
            r1 = r14 & r0
            r14 = r14 | r0
            int r1 = r1 + r14
            int r14 = r1 % 128
            f2927l = r14
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x044e
            r14 = 0
            goto L_0x044f
        L_0x044e:
            r14 = 1
        L_0x044f:
            if (r14 == r4) goto L_0x0460
            com.cardinalcommerce.a.setTypeface r14 = r13.f2937i
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newSingleThreadExecutor()
            r0.execute(r14)
            r14 = 16
            int r14 = r14 / r5
            goto L_0x0469
        L_0x045e:
            r14 = move-exception
            throw r14
        L_0x0460:
            com.cardinalcommerce.a.setTypeface r14 = r13.f2937i
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newSingleThreadExecutor()
            r0.execute(r14)
        L_0x0469:
            int r14 = f2927l
            int r14 = r14 + 7
            int r0 = r14 % 128
            f2928m = r0
            int r14 = r14 % 2
        L_0x0473:
            int r14 = f2928m
            r0 = r14 & -100
            int r1 = ~r14
            r1 = r1 & r3
            r0 = r0 | r1
            r14 = r14 & r3
            int r14 = r14 << r4
            int r14 = -r14
            int r14 = -r14
            r1 = r0 & r14
            r14 = r14 | r0
            int r1 = r1 + r14
            int r14 = r1 % 128
            f2927l = r14
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x048b
            goto L_0x048c
        L_0x048b:
            r4 = 0
        L_0x048c:
            if (r4 == 0) goto L_0x0492
            int r14 = r6.length     // Catch:{ all -> 0x0490 }
            return
        L_0x0490:
            r14 = move-exception
            throw r14
        L_0x0492:
            return
        L_0x0493:
            r14 = move-exception
            goto L_0x0557
        L_0x0496:
            r14 = move-exception
            com.cardinalcommerce.a.setProgressBackgroundTintMode r0 = r13.f2939k     // Catch:{ all -> 0x0493 }
            com.cardinalcommerce.a.setImageMatrix r5 = new com.cardinalcommerce.a.setImageMatrix     // Catch:{ all -> 0x0493 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0493 }
            java.lang.String r7 = "Error 101 Created: Response is in invalid format"
            r6.<init>(r7)     // Catch:{ all -> 0x0493 }
            java.lang.String r14 = r14.getLocalizedMessage()     // Catch:{ all -> 0x0493 }
            r6.append(r14)     // Catch:{ all -> 0x0493 }
            java.lang.String r14 = r6.toString()     // Catch:{ all -> 0x0493 }
            r5.<init>(r8, r14)     // Catch:{ all -> 0x0493 }
            r0.init(r5)     // Catch:{ all -> 0x0493 }
            java.lang.String r14 = "Invalid Formatted Message"
            r13.m2062b((java.lang.String) r14)     // Catch:{ all -> 0x0493 }
            com.cardinalcommerce.a.setProgressBackgroundTintMode r14 = r13.f2939k
            r14.Cardinal(r2, r1)
            com.cardinalcommerce.a.setTypeface r14 = r13.f2937i
            if (r14 == 0) goto L_0x04db
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newSingleThreadExecutor()
            r0.execute(r14)
            int r14 = f2927l
            r0 = r14 & 99
            r14 = r14 ^ r3
            r14 = r14 | r0
            int r14 = -r14
            int r14 = -r14
            r1 = r0 ^ r14
            r14 = r14 & r0
            int r14 = r14 << r4
            int r1 = r1 + r14
            int r14 = r1 % 128
            f2928m = r14
            int r1 = r1 % 2
        L_0x04db:
            int r14 = f2928m
            r0 = 9
            r1 = r14 & -10
            int r2 = ~r14
            r2 = r2 & r0
            r1 = r1 | r2
            r14 = r14 & r0
            int r14 = r14 << r4
            int r14 = -r14
            int r14 = -r14
            r0 = r1 | r14
            int r0 = r0 << r4
            r14 = r14 ^ r1
            int r0 = r0 - r14
            int r14 = r0 % 128
            f2927l = r14
            int r0 = r0 % 2
            return
        L_0x04f4:
            r14 = move-exception
            goto L_0x04f7
        L_0x04f6:
            r14 = move-exception
        L_0x04f7:
            com.cardinalcommerce.a.setProgressBackgroundTintMode r0 = r13.f2939k     // Catch:{ all -> 0x0493 }
            com.cardinalcommerce.a.setImageMatrix r3 = new com.cardinalcommerce.a.setImageMatrix     // Catch:{ all -> 0x0493 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0493 }
            java.lang.String r6 = "Error 101 Created: Error Decrypting response"
            r5.<init>(r6)     // Catch:{ all -> 0x0493 }
            java.lang.String r14 = r14.getLocalizedMessage()     // Catch:{ all -> 0x0493 }
            r5.append(r14)     // Catch:{ all -> 0x0493 }
            java.lang.String r14 = r5.toString()     // Catch:{ all -> 0x0493 }
            r3.<init>(r8, r14)     // Catch:{ all -> 0x0493 }
            r0.init(r3)     // Catch:{ all -> 0x0493 }
            java.lang.String r14 = "Invalid Message from the ACS"
            r13.m2062b((java.lang.String) r14)     // Catch:{ all -> 0x0493 }
            com.cardinalcommerce.a.setProgressBackgroundTintMode r14 = r13.f2939k
            r14.Cardinal(r2, r1)
            com.cardinalcommerce.a.setTypeface r14 = r13.f2937i
            if (r14 == 0) goto L_0x0540
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newSingleThreadExecutor()
            r0.execute(r14)
            int r14 = f2927l
            r0 = r14 ^ 93
            r1 = r14 & 93
            r0 = r0 | r1
            int r0 = r0 << r4
            r1 = r14 & -94
            int r14 = ~r14
            r14 = r14 & r7
            r14 = r14 | r1
            int r14 = -r14
            r1 = r0 & r14
            r14 = r14 | r0
            int r1 = r1 + r14
            int r14 = r1 % 128
            f2928m = r14
            int r1 = r1 % 2
        L_0x0540:
            int r14 = f2928m
            r0 = r14 | 43
            int r0 = r0 << r4
            r1 = r14 & -44
            int r14 = ~r14
            r14 = r14 & 43
            r14 = r14 | r1
            int r14 = -r14
            r1 = r0 & r14
            r14 = r14 | r0
            int r1 = r1 + r14
            int r14 = r1 % 128
            f2927l = r14
            int r1 = r1 % 2
            return
        L_0x0557:
            com.cardinalcommerce.a.setProgressBackgroundTintMode r0 = r13.f2939k
            r0.Cardinal(r2, r1)
            com.cardinalcommerce.a.setTypeface r0 = r13.f2937i
            if (r0 == 0) goto L_0x0576
            java.util.concurrent.ExecutorService r1 = java.util.concurrent.Executors.newSingleThreadExecutor()
            r1.execute(r0)
            int r0 = f2928m
            r1 = r0 ^ 67
            r0 = r0 & 67
            r0 = r0 | r1
            int r0 = r0 << r4
            int r0 = r0 - r1
            int r1 = r0 % 128
            f2927l = r1
            int r0 = r0 % 2
        L_0x0576:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setProgressBackgroundTintList.cca_continue(java.lang.String):void");
    }

    /* renamed from: com.cardinalcommerce.a.setProgressBackgroundTintList$2 */
    static /* synthetic */ class C20642 {
        static final /* synthetic */ int[] cca_continue;
        private static int configure = 1;
        private static int init;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(5:13|14|15|(1:17)(1:18)|(4:20|21|22|23)(1:28))) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0025 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0042 */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x00a0  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00a3  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00a7  */
        /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        static {
            /*
                com.cardinalcommerce.a.setMin[] r0 = com.cardinalcommerce.p060a.setMin.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                cca_continue = r0
                r1 = 2
                r2 = 1
                com.cardinalcommerce.a.setMin r3 = com.cardinalcommerce.p060a.setMin.EXCEPTION     // Catch:{ NoSuchFieldError -> 0x0025 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0025 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0025 }
                int r0 = configure
                r3 = r0 ^ 96
                r0 = r0 & 96
                int r0 = r0 << r2
                int r3 = r3 + r0
                r0 = r3 & -1
                r3 = r3 | -1
                int r0 = r0 + r3
                int r3 = r0 % 128
                init = r3
                int r0 = r0 % r1
            L_0x0025:
                int[] r0 = cca_continue     // Catch:{ NoSuchFieldError -> 0x0042 }
                com.cardinalcommerce.a.setMin r3 = com.cardinalcommerce.p060a.setMin.IO_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x0042 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0042 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0042 }
                int r0 = init
                r3 = r0 & 99
                r0 = r0 ^ 99
                r0 = r0 | r3
                int r0 = -r0
                int r0 = -r0
                r4 = r3 ^ r0
                r0 = r0 & r3
                int r0 = r0 << r2
                int r4 = r4 + r0
                int r0 = r4 % 128
                configure = r0
                int r4 = r4 % r1
            L_0x0042:
                int[] r0 = cca_continue     // Catch:{ NoSuchFieldError -> 0x005e }
                com.cardinalcommerce.a.setMin r3 = com.cardinalcommerce.p060a.setMin.PROTOCOL_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x005e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r4 = 3
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x005e }
                int r0 = init
                r3 = r0 ^ 31
                r0 = r0 & 31
                int r0 = r0 << r2
                int r0 = -r0
                int r0 = -r0
                int r0 = ~r0
                int r3 = r3 - r0
                int r3 = r3 - r2
                int r0 = r3 % 128
                configure = r0
                int r3 = r3 % r1
            L_0x005e:
                int[] r0 = cca_continue     // Catch:{ NoSuchFieldError -> 0x007a }
                com.cardinalcommerce.a.setMin r3 = com.cardinalcommerce.p060a.setMin.MALFORMED_URL_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x007a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r4 = 4
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x007a }
                int r0 = init
                r3 = r0 & -118(0xffffffffffffff8a, float:NaN)
                int r4 = ~r0
                r4 = r4 & 117(0x75, float:1.64E-43)
                r3 = r3 | r4
                r0 = r0 & 117(0x75, float:1.64E-43)
                int r0 = r0 << r2
                int r3 = r3 + r0
                int r0 = r3 % 128
                configure = r0
                int r3 = r3 % r1
            L_0x007a:
                int[] r0 = cca_continue     // Catch:{ NoSuchFieldError -> 0x00ac }
                com.cardinalcommerce.a.setMin r3 = com.cardinalcommerce.p060a.setMin.SOCKET_TIMEOUT_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x00ac }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ac }
                r4 = 5
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00ac }
                int r0 = init
                r3 = r0 ^ 115(0x73, float:1.61E-43)
                r4 = r0 & 115(0x73, float:1.61E-43)
                r3 = r3 | r4
                int r2 = r3 << 1
                int r3 = ~r4
                r0 = r0 | 115(0x73, float:1.61E-43)
                r0 = r0 & r3
                int r0 = -r0
                r3 = r2 & r0
                r0 = r0 | r2
                int r3 = r3 + r0
                int r0 = r3 % 128
                configure = r0
                int r3 = r3 % r1
                r0 = 70
                if (r3 != 0) goto L_0x00a3
                r1 = 90
                goto L_0x00a5
            L_0x00a3:
                r1 = 70
            L_0x00a5:
                if (r1 == r0) goto L_0x00ac
                r0 = 0
                int r0 = r0.length     // Catch:{ all -> 0x00aa }
                return
            L_0x00aa:
                r0 = move-exception
                throw r0
            L_0x00ac:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setProgressBackgroundTintList.C20642.<clinit>():void");
        }
    }

    /* renamed from: a */
    private static boolean m2059a(String str) {
        int i = (((f2927l + 57) - 1) + 0) - 1;
        f2928m = i % 128;
        int i2 = i % 2;
        boolean contains = str.replaceAll("[\\s|\\u00A0]+", "").contains("\"messageType\":\"Erro\"");
        int i3 = f2928m;
        int i4 = i3 & 95;
        int i5 = ((i3 ^ 95) | i4) << 1;
        int i6 = -((i3 | 95) & (~i4));
        int i7 = (i5 ^ i6) + ((i6 & i5) << 1);
        f2927l = i7 % 128;
        if ((i7 % 2 != 0 ? ',' : '@') == '@') {
            return contains;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return contains;
    }

    /* renamed from: a */
    private void m2056a(setBaselineAligned setbaselinealigned, String str) {
        setSecondaryProgressTintList setsecondaryprogresstintlist = new setSecondaryProgressTintList(this.f2933e.mo18296c());
        setsecondaryprogresstintlist.cca_continue = DiFaceLogger.EVENT_ID_SOURCE_PICTURES;
        setsecondaryprogresstintlist.getInstance = "Transaction ID received is not valid for the receiving component.";
        setsecondaryprogresstintlist.init = str;
        setsecondaryprogresstintlist.getWarnings = setbaselinealigned.cca_continue;
        setsecondaryprogresstintlist.CardinalError = setbaselinealigned.configure;
        setsecondaryprogresstintlist.getSDKVersion = setbaselinealigned.setRequestTimeout;
        m2057a(setsecondaryprogresstintlist);
        m2058a(new ErrorMessage(setsecondaryprogresstintlist.CardinalError, setsecondaryprogresstintlist.cca_continue, setsecondaryprogresstintlist.getInstance, setsecondaryprogresstintlist.init));
        int i = f2927l;
        int i2 = ((i ^ 105) | (i & 105)) << 1;
        int i3 = -(((~i) & 105) | (i & -106));
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f2928m = i4 % 128;
        int i5 = i4 % 2;
    }

    /* renamed from: b */
    private void m2062b(String str) {
        setSecondaryProgressTintList setsecondaryprogresstintlist = new setSecondaryProgressTintList(this.f2933e.mo18296c());
        setsecondaryprogresstintlist.cca_continue = Const.BindCardScene.DEFAULT_EMBED;
        setsecondaryprogresstintlist.getInstance = str;
        setsecondaryprogresstintlist.init = "CRes";
        setsecondaryprogresstintlist.CardinalError = new String(this.f2935g);
        setsecondaryprogresstintlist.getWarnings = new String(this.f2936h);
        setsecondaryprogresstintlist.getSDKVersion = new String(this.f2934f);
        m2057a(setsecondaryprogresstintlist);
        m2058a(new ErrorMessage(setsecondaryprogresstintlist.CardinalError, setsecondaryprogresstintlist.cca_continue, setsecondaryprogresstintlist.getInstance, setsecondaryprogresstintlist.init));
        int i = f2927l;
        int i2 = (i & -46) | ((~i) & 45);
        int i3 = -(-((i & 45) << 1));
        int i4 = ((i2 | i3) << 1) - (i3 ^ i2);
        f2928m = i4 % 128;
        int i5 = i4 % 2;
    }

    /* renamed from: c */
    private void m2065c(String str) {
        setSecondaryProgressTintList setsecondaryprogresstintlist = new setSecondaryProgressTintList(this.f2933e.mo18296c());
        setsecondaryprogresstintlist.cca_continue = Const.BindCardScene.DEFAULT_EMBED;
        setsecondaryprogresstintlist.getInstance = str;
        setsecondaryprogresstintlist.init = "CRes";
        setsecondaryprogresstintlist.CardinalError = new String(this.f2935g);
        setsecondaryprogresstintlist.getWarnings = new String(this.f2936h);
        setsecondaryprogresstintlist.getSDKVersion = new String(this.f2934f);
        ErrorMessage errorMessage = new ErrorMessage(setsecondaryprogresstintlist.CardinalError, setsecondaryprogresstintlist.cca_continue, setsecondaryprogresstintlist.getInstance, setsecondaryprogresstintlist.init);
        this.f2929a.configure("RunTimeError", new RuntimeErrorEvent(errorMessage.getErrorCode(), errorMessage.getErrorDescription()));
        int i = f2927l;
        int i2 = ((((i ^ 23) | (i & 23)) << 1) - (~(-(((~i) & 23) | (i & -24))))) - 1;
        f2928m = i2 % 128;
        int i3 = i2 % 2;
    }

    /* renamed from: a */
    private void m2058a(ErrorMessage errorMessage) {
        this.f2929a.configure(NativeProtocol.ERROR_PROTOCOL_ERROR, new ProtocolErrorEvent(new String(this.f2934f), errorMessage));
        int i = f2928m;
        int i2 = (i & 106) + (i | 106);
        int i3 = (i2 ^ -1) + ((i2 & -1) << 1);
        f2927l = i3 % 128;
        int i4 = i3 % 2;
    }

    /* renamed from: a */
    private byte[] m2060a(JSONObject jSONObject) {
        int i = f2927l;
        int i2 = (i & -70) | ((~i) & 69);
        int i3 = -(-((i & 69) << 1));
        int i4 = (i2 & i3) + (i3 | i2);
        f2928m = i4 % 128;
        char c = i4 % 2 == 0 ? '^' : 'F';
        byte[] b = m2064b(jSONObject);
        if (c == '^') {
            Object obj = null;
            super.hashCode();
        }
        return b;
    }

    /* renamed from: b */
    private byte[] m2064b(JSONObject jSONObject) {
        try {
            int i = this.f2933e.f2629b;
            byte parseByte = Byte.parseByte("".concat(String.valueOf(i)));
            JWEHeader.C2155configure configure = new JWEHeader.C2155configure(JWEAlgorithm.cleanup, EncryptionMethod.cleanup);
            configure.CardinalError = (String) jSONObject.get("acsTransID");
            JWEHeader cca_continue = configure.cca_continue();
            boolean z = true;
            jSONObject.put("sdkCounterStoA", String.format("%03d", new Object[]{Byte.valueOf(parseByte)}));
            JWEObject jWEObject = new JWEObject(cca_continue, new Payload(jSONObject.toString()));
            jWEObject.init(new setMinHeight(Arrays.copyOfRange(this.f2931c.getEncoded(), 0, 16), parseByte));
            byte[] bytes = jWEObject.init().getBytes();
            int i2 = ((i ^ 1) | (i & 1)) << 1;
            int i3 = -(((~i) & 1) | (i & -2));
            int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
            if (i4 != 0) {
                this.f2933e.f2629b = i4;
                int i5 = f2927l;
                int i6 = (((i5 & -60) | ((~i5) & 59)) - (~(-(-((i5 & 59) << 1))))) - 1;
                f2928m = i6 % 128;
                if (i6 % 2 == 0) {
                    z = false;
                }
                if (z) {
                    return bytes;
                }
                Object obj = null;
                super.hashCode();
                return bytes;
            }
            throw new RuntimeException("SdkCounterStoA zero");
        } catch (Exception e) {
            setProgressBackgroundTintMode setprogressbackgroundtintmode = this.f2939k;
            StringBuilder sb = new StringBuilder("JWE Encryption Failed \n");
            sb.append(e.getLocalizedMessage());
            setprogressbackgroundtintmode.init(new setImageMatrix(11418, sb.toString()));
            return jSONObject.toString().getBytes();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        if ((com.cardinalcommerce.p060a.setHorizontallyScrolling.init(r4.f2938j)) != true) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003f, code lost:
        if ((com.cardinalcommerce.p060a.setHorizontallyScrolling.init(r4.f2938j)) != false) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0081, code lost:
        if (r2 != true) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0096, code lost:
        if ((java.util.Arrays.equals(r4.f2938j, com.cardinalcommerce.p060a.setHeight.cleanup) ? 6 : 'Y') != 'Y') goto L_0x0098;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void configure() {
        /*
            r4 = this;
            int r0 = f2927l
            r1 = r0 & 27
            r0 = r0 ^ 27
            r0 = r0 | r1
            int r1 = r1 + r0
            int r0 = r1 % 128
            f2928m = r0
            int r1 = r1 % 2
            r0 = 74
            if (r1 != 0) goto L_0x0015
            r1 = 91
            goto L_0x0017
        L_0x0015:
            r1 = 74
        L_0x0017:
            r2 = 0
            r3 = 1
            if (r1 == r0) goto L_0x0031
            super.configure()
            char[] r0 = r4.f2938j
            boolean r0 = com.cardinalcommerce.p060a.setHorizontallyScrolling.init((char[]) r0)
            r1 = 81
            int r1 = r1 / r2
            if (r0 != 0) goto L_0x002b
            r0 = 0
            goto L_0x002c
        L_0x002b:
            r0 = 1
        L_0x002c:
            if (r0 == r3) goto L_0x00ae
            goto L_0x0043
        L_0x002f:
            r0 = move-exception
            throw r0
        L_0x0031:
            super.configure()
            char[] r0 = r4.f2938j
            boolean r0 = com.cardinalcommerce.p060a.setHorizontallyScrolling.init((char[]) r0)
            if (r0 != 0) goto L_0x003e
            r0 = 0
            goto L_0x003f
        L_0x003e:
            r0 = 1
        L_0x003f:
            if (r0 == 0) goto L_0x0043
            goto L_0x00ae
        L_0x0043:
            char[] r0 = r4.f2938j
            char[] r1 = com.cardinalcommerce.p060a.setHeight.getWarnings
            boolean r0 = java.util.Arrays.equals(r0, r1)
            r1 = 66
            if (r0 != 0) goto L_0x0052
            r0 = 66
            goto L_0x0054
        L_0x0052:
            r0 = 54
        L_0x0054:
            if (r0 == r1) goto L_0x0057
            goto L_0x0098
        L_0x0057:
            int r0 = f2928m
            r1 = r0 ^ 110(0x6e, float:1.54E-43)
            r0 = r0 & 110(0x6e, float:1.54E-43)
            int r0 = r0 << r3
            int r1 = r1 + r0
            r0 = r1 ^ -1
            r1 = r1 & -1
            int r1 = r1 << r3
            int r0 = r0 + r1
            int r1 = r0 % 128
            f2927l = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x006f
            r0 = 0
            goto L_0x0070
        L_0x006f:
            r0 = 1
        L_0x0070:
            if (r0 == r3) goto L_0x0086
            char[] r0 = r4.f2938j
            char[] r1 = com.cardinalcommerce.p060a.setHeight.cleanup
            boolean r0 = java.util.Arrays.equals(r0, r1)
            r1 = 96
            int r1 = r1 / r2
            if (r0 == 0) goto L_0x0080
            goto L_0x0081
        L_0x0080:
            r2 = 1
        L_0x0081:
            if (r2 == r3) goto L_0x00ae
            goto L_0x0098
        L_0x0084:
            r0 = move-exception
            throw r0
        L_0x0086:
            char[] r0 = r4.f2938j
            char[] r1 = com.cardinalcommerce.p060a.setHeight.cleanup
            boolean r0 = java.util.Arrays.equals(r0, r1)
            r1 = 89
            if (r0 == 0) goto L_0x0094
            r0 = 6
            goto L_0x0096
        L_0x0094:
            r0 = 89
        L_0x0096:
            if (r0 == r1) goto L_0x00ae
        L_0x0098:
            com.cardinalcommerce.a.setIndeterminateTintBlendMode r0 = r4.f2929a
            r1 = 0
            java.lang.String r2 = "CancelTimeout"
            r0.configure(r2, r1)
            int r0 = f2928m
            r1 = r0 | 77
            int r1 = r1 << r3
            r0 = r0 ^ 77
            int r1 = r1 - r0
            int r0 = r1 % 128
            f2927l = r0
            int r1 = r1 % 2
        L_0x00ae:
            int r0 = f2927l
            r1 = r0 | 122(0x7a, float:1.71E-43)
            int r1 = r1 << r3
            r0 = r0 ^ 122(0x7a, float:1.71E-43)
            int r1 = r1 - r0
            int r1 = r1 - r3
            int r0 = r1 % 128
            f2928m = r0
            int r1 = r1 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setProgressBackgroundTintList.configure():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
        if ((r7.f2937i != null ? (char) 19 : 24) != 24) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0064, code lost:
        if (r0 != false) goto L_0x009d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void getInstance(java.lang.String r8, int r9) {
        /*
            r7 = this;
            int r0 = f2927l
            r1 = r0 & 39
            r0 = r0 ^ 39
            r0 = r0 | r1
            int r0 = -r0
            int r0 = -r0
            r2 = r1 ^ r0
            r0 = r0 & r1
            r1 = 1
            int r0 = r0 << r1
            int r2 = r2 + r0
            int r0 = r2 % 128
            f2928m = r0
            int r2 = r2 % 2
            r0 = 0
            if (r2 != 0) goto L_0x001a
            r2 = 1
            goto L_0x001b
        L_0x001a:
            r2 = 0
        L_0x001b:
            java.lang.String r3 = "Challenge Task finished"
            java.lang.String r4 = "EMVCoTransaction"
            java.lang.String r5 = "ACS not reachable"
            if (r2 == 0) goto L_0x004a
            com.cardinalcommerce.a.setProgressBackgroundTintMode r2 = r7.f2939k
            java.lang.String r6 = java.lang.String.valueOf(r9)
            r2.cca_continue(r6, r8)
            super.getInstance(r8, r9)
            r7.m2065c((java.lang.String) r5)
            com.cardinalcommerce.a.setProgressBackgroundTintMode r8 = r7.f2939k
            r8.Cardinal(r4, r3)
            com.cardinalcommerce.a.setTypeface r8 = r7.f2937i
            r9 = 11
            int r9 = r9 / r0
            r9 = 24
            if (r8 == 0) goto L_0x0043
            r8 = 19
            goto L_0x0045
        L_0x0043:
            r8 = 24
        L_0x0045:
            if (r8 == r9) goto L_0x009d
            goto L_0x0067
        L_0x0048:
            r8 = move-exception
            throw r8
        L_0x004a:
            com.cardinalcommerce.a.setProgressBackgroundTintMode r2 = r7.f2939k
            java.lang.String r6 = java.lang.String.valueOf(r9)
            r2.cca_continue(r6, r8)
            super.getInstance(r8, r9)
            r7.m2065c((java.lang.String) r5)
            com.cardinalcommerce.a.setProgressBackgroundTintMode r8 = r7.f2939k
            r8.Cardinal(r4, r3)
            com.cardinalcommerce.a.setTypeface r8 = r7.f2937i
            if (r8 == 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r0 = 1
        L_0x0064:
            if (r0 == 0) goto L_0x0067
            goto L_0x009d
        L_0x0067:
            int r8 = f2927l
            r9 = r8 & 27
            r8 = r8 ^ 27
            r8 = r8 | r9
            int r8 = -r8
            int r8 = -r8
            r0 = r9 | r8
            int r0 = r0 << r1
            r8 = r8 ^ r9
            int r0 = r0 - r8
            int r8 = r0 % 128
            f2928m = r8
            int r0 = r0 % 2
            com.cardinalcommerce.a.setTypeface r8 = r7.f2937i
            java.util.concurrent.ExecutorService r9 = java.util.concurrent.Executors.newSingleThreadExecutor()
            r9.execute(r8)
            int r8 = f2928m
            r9 = 99
            r0 = r8 ^ 99
            r2 = r8 & 99
            r0 = r0 | r2
            int r0 = r0 << r1
            r2 = r8 & -100
            int r8 = ~r8
            r8 = r8 & r9
            r8 = r8 | r2
            int r8 = -r8
            int r8 = ~r8
            int r0 = r0 - r8
            int r0 = r0 - r1
            int r8 = r0 % 128
            f2927l = r8
            int r0 = r0 % 2
        L_0x009d:
            int r8 = f2928m
            r9 = r8 & -86
            int r0 = ~r8
            r0 = r0 & 85
            r9 = r9 | r0
            r8 = r8 & 85
            int r8 = r8 << r1
            int r8 = ~r8
            int r9 = r9 - r8
            int r9 = r9 - r1
            int r8 = r9 % 128
            f2927l = r8
            int r9 = r9 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setProgressBackgroundTintList.getInstance(java.lang.String, int):void");
    }

    public final void cca_continue(Exception exc, setMin setmin) {
        int i = f2928m;
        int i2 = i & 11;
        int i3 = i2 + ((i ^ 11) | i2);
        f2927l = i3 % 128;
        int i4 = i3 % 2;
        super.cca_continue(exc, setmin);
        int i5 = C20642.cca_continue[setmin.ordinal()];
        boolean z = true;
        if (i5 == 1 || i5 == 2) {
            setProgressBackgroundTintMode setprogressbackgroundtintmode = this.f2939k;
            StringBuilder sb = new StringBuilder("Error 101 Created: Message is not CRes \n");
            sb.append(exc.getLocalizedMessage());
            setprogressbackgroundtintmode.init(new setImageMatrix(12101, sb.toString()));
            m2065c("Invalid Formatted Message");
            int i6 = f2927l;
            int i7 = ((i6 ^ 34) + ((i6 & 34) << 1)) - 1;
            f2928m = i7 % 128;
            int i8 = i7 % 2;
        } else if (i5 == 3 || i5 == 4 || i5 == 5) {
            setSecondaryProgressTintList setsecondaryprogresstintlist = new setSecondaryProgressTintList(this.f2933e.mo18296c());
            setsecondaryprogresstintlist.cca_continue = "402";
            setsecondaryprogresstintlist.getInstance = "Transaction Timed Out";
            setsecondaryprogresstintlist.init = "For example, a slowly processing back-end system.";
            setsecondaryprogresstintlist.CardinalError = new String(this.f2935g);
            setsecondaryprogresstintlist.getWarnings = new String(this.f2936h);
            setsecondaryprogresstintlist.getSDKVersion = new String(this.f2934f);
            m2057a(setsecondaryprogresstintlist);
            ErrorMessage errorMessage = new ErrorMessage(setsecondaryprogresstintlist.CardinalError, setsecondaryprogresstintlist.cca_continue, setsecondaryprogresstintlist.getInstance, setsecondaryprogresstintlist.init);
            this.f2929a.configure("RunTimeError", new RuntimeErrorEvent(errorMessage.getErrorCode(), errorMessage.getErrorDescription()));
            int i9 = f2927l + 99;
            f2928m = i9 % 128;
            int i10 = i9 % 2;
        }
        this.f2939k.Cardinal("EMVCoTransaction", "Challenge Task finished");
        if (!(this.f2937i == null)) {
            int i11 = f2927l + 50;
            int i12 = ((i11 | -1) << 1) - (i11 ^ -1);
            f2928m = i12 % 128;
            if ((i12 % 2 == 0 ? 'M' : VersionRange.RIGHT_CLOSED) != 'M') {
                Executors.newSingleThreadExecutor().execute(this.f2937i);
            } else {
                Executors.newSingleThreadExecutor().execute(this.f2937i);
                int i13 = 89 / 0;
            }
        }
        int i14 = f2927l;
        int i15 = i14 ^ 117;
        int i16 = ((((i14 & 117) | i15) << 1) - (~(-i15))) - 1;
        f2928m = i16 % 128;
        if (i16 % 2 == 0) {
            z = false;
        }
        if (!z) {
            int i17 = 12 / 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
        if (r4.f2930b.length > 0) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (r0 > 0) goto L_0x0044;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2057a(com.cardinalcommerce.p060a.setSecondaryProgressTintList r5) {
        /*
            r4 = this;
            int r0 = f2927l
            r1 = r0 | 33
            int r2 = r1 << 1
            r0 = r0 & 33
            int r0 = ~r0
            r0 = r0 & r1
            int r0 = -r0
            r1 = r2 | r0
            r3 = 1
            int r1 = r1 << r3
            r0 = r0 ^ r2
            int r1 = r1 - r0
            int r0 = r1 % 128
            f2928m = r0
            int r1 = r1 % 2
            char[] r0 = r4.f2930b
            r1 = 0
            if (r0 == 0) goto L_0x001e
            r0 = 1
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            if (r0 == 0) goto L_0x006e
            int r0 = f2928m
            r2 = r0 | 59
            int r2 = r2 << r3
            r0 = r0 ^ 59
            int r2 = r2 - r0
            int r0 = r2 % 128
            f2927l = r0
            int r2 = r2 % 2
            if (r2 == 0) goto L_0x0032
            goto L_0x0033
        L_0x0032:
            r1 = 1
        L_0x0033:
            if (r1 == 0) goto L_0x003b
            char[] r0 = r4.f2930b
            int r0 = r0.length
            if (r0 <= 0) goto L_0x006e
            goto L_0x0044
        L_0x003b:
            char[] r0 = r4.f2930b
            int r0 = r0.length
            r1 = 0
            super.hashCode()     // Catch:{ all -> 0x006c }
            if (r0 <= 0) goto L_0x006e
        L_0x0044:
            com.cardinalcommerce.a.setProgressBackgroundTintBlendMode r0 = new com.cardinalcommerce.a.setProgressBackgroundTintBlendMode
            java.lang.String r1 = new java.lang.String
            char[] r2 = r4.f2930b
            r1.<init>(r2)
            r0.<init>(r5, r1)
            r0.configure()
            java.util.concurrent.ExecutorService r5 = r0.getSDKVersion
            com.cardinalcommerce.a.setKeyListener$4 r1 = new com.cardinalcommerce.a.setKeyListener$4
            r1.<init>()
            r5.execute(r1)
            int r5 = f2927l
            r0 = r5 ^ 111(0x6f, float:1.56E-43)
            r5 = r5 & 111(0x6f, float:1.56E-43)
            int r5 = r5 << r3
            int r0 = r0 + r5
            int r5 = r0 % 128
            f2928m = r5
            int r0 = r0 % 2
            goto L_0x006e
        L_0x006c:
            r5 = move-exception
            throw r5
        L_0x006e:
            int r5 = f2928m
            r0 = r5 | 49
            int r0 = r0 << r3
            r5 = r5 ^ 49
            int r0 = r0 - r5
            int r5 = r0 % 128
            f2927l = r5
            int r0 = r0 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setProgressBackgroundTintList.m2057a(com.cardinalcommerce.a.setSecondaryProgressTintList):void");
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.cardinalcommerce.a.setTypeface, java.lang.Object, javax.crypto.SecretKey, com.cardinalcommerce.a.q] */
    public final void run() {
        setHorizontallyScrolling.getInstance(m2061a(this));
        ? r0 = 0;
        this.f2931c = r0;
        m2063b(this);
        C2026q.f2626a = r0;
        this.f2933e = r0;
        setHorizontallyScrolling.getInstance(m2066c(this));
        setHorizontallyScrolling.getInstance(m2067d(this));
        setHorizontallyScrolling.getInstance(m2068e(this));
        setTypeface settypeface = this.f2937i;
        Executors.newSingleThreadExecutor().execute(settypeface);
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            private static int cca_continue = 0;
            private static int getInstance = 1;

            public final void run() {
                int i = cca_continue;
                int i2 = ((i ^ 121) | (i & 121)) << 1;
                int i3 = -(((~i) & 121) | (i & -122));
                int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
                getInstance = i4 % 128;
                int i5 = i4 % 2;
                setHorizontallyScrolling.getInstance(setTypeface.m2157a(setTypeface.this));
                setHorizontallyScrolling.getInstance(setTypeface.m2158b(setTypeface.this));
                setHorizontallyScrolling.getInstance(setTypeface.m2159c(setTypeface.this));
                setHorizontallyScrolling.getInstance(setTypeface.m2160d(setTypeface.this));
                setHorizontallyScrolling.getInstance(setTypeface.m2161e(setTypeface.this));
                setHorizontallyScrolling.getInstance(setTypeface.m2162f(setTypeface.this));
                setHorizontallyScrolling.getInstance(setTypeface.m2163g(setTypeface.this));
                setHorizontallyScrolling.getInstance(setTypeface.m2164h(setTypeface.this));
                setHorizontallyScrolling.getInstance(setTypeface.m2165i(setTypeface.this));
                setHorizontallyScrolling.getInstance(setTypeface.m2166j(setTypeface.this));
                int i6 = cca_continue;
                int i7 = ((i6 | 1) << 1) - (i6 ^ 1);
                getInstance = i7 % 128;
                if (i7 % 2 == 0) {
                    int i8 = 69 / 0;
                }
            }
        });
        this.f2937i = r0;
        setHorizontallyScrolling.getInstance(m2069f(this));
        int i = f2927l;
        int i2 = (i ^ 29) + ((i & 29) << 1);
        f2928m = i2 % 128;
        if ((i2 % 2 == 0 ? 'W' : Matrix.MATRIX_TYPE_ZERO) != 'Z') {
            super.hashCode();
        }
    }
}
