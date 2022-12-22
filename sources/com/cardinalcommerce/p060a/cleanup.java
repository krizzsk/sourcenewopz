package com.cardinalcommerce.p060a;

import com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError;
import com.cardinalcommerce.shared.models.exceptions.InvalidInputException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.cleanup */
public final class cleanup extends setKeyListener {

    /* renamed from: c */
    private static final CardinalRenderType f2514c = CardinalRenderType.cca_continue();

    /* renamed from: d */
    private static int f2515d = 0;

    /* renamed from: e */
    private static int f2516e = 1;

    /* renamed from: a */
    private final String f2517a;

    /* renamed from: b */
    private final getWarnings f2518b;

    static {
        int i = ((f2515d + 65) - 1) - 1;
        f2516e = i % 128;
        if ((i % 2 == 0 ? '6' : 21) != 21) {
            Object obj = null;
            super.hashCode();
        }
    }

    public cleanup(getWarnings getwarnings, String str, String str2) throws JSONException, InvalidInputException {
        this.f2518b = getwarnings;
        this.f2517a = str2;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Order", new JSONObject());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("Agent", "CardinalMobileSdk_Android");
        jSONObject2.put("Version", setHeight.values);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("cca", true);
        jSONObject.put("SupportsAlternativePayments", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("BrowserPayload", jSONObject);
        jSONObject4.put("ConsumerSessionId", (Object) null);
        jSONObject4.put("Client", jSONObject2);
        jSONObject4.put("ServerJWT", str);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2517a);
        sb.append("Order/JWT/Init");
        super.configure(sb.toString(), jSONObject4.toString(), 10000);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.String] */
    public final void getInstance(String str, int i) {
        super.getInstance(str, i);
        CardinalError cardinalError = new CardinalError(i, str);
        ? r2 = 0;
        f2514c.configure(String.valueOf(cardinalError.Cardinal), cardinalError.init, r2);
        this.f2518b.getInstance(cardinalError);
        int i2 = f2515d;
        int i3 = i2 ^ 75;
        int i4 = ((i2 & 75) | i3) << 1;
        int i5 = -i3;
        int i6 = ((i4 | i5) << 1) - (i4 ^ i5);
        f2516e = i6 % 128;
        if ((i6 % 2 == 0 ? '7' : 'X') == '7') {
            int length = r2.length;
        }
    }

    /* renamed from: com.cardinalcommerce.a.cleanup$3 */
    static /* synthetic */ class C19893 {
        static final /* synthetic */ int[] cca_continue;
        private static int configure = 0;
        private static int getInstance = 1;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(4:13|14|15|17)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x006a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x003a */
        static {
            /*
                com.cardinalcommerce.a.setMin[] r0 = com.cardinalcommerce.p060a.setMin.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                cca_continue = r0
                r1 = 2
                r2 = 1
                com.cardinalcommerce.a.setMin r3 = com.cardinalcommerce.p060a.setMin.EXCEPTION     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
                int r0 = configure
                r3 = r0 & 49
                r0 = r0 | 49
                int r3 = r3 + r0
                int r0 = r3 % 128
                getInstance = r0
                int r3 = r3 % r1
            L_0x001f:
                int[] r0 = cca_continue     // Catch:{ NoSuchFieldError -> 0x003a }
                com.cardinalcommerce.a.setMin r3 = com.cardinalcommerce.p060a.setMin.IO_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x003a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x003a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x003a }
                int r0 = getInstance
                r3 = r0 & 87
                r0 = r0 ^ 87
                r0 = r0 | r3
                r4 = r3 ^ r0
                r0 = r0 & r3
                int r0 = r0 << r2
                int r4 = r4 + r0
                int r0 = r4 % 128
                configure = r0
                int r4 = r4 % r1
            L_0x003a:
                int[] r0 = cca_continue     // Catch:{ NoSuchFieldError -> 0x0052 }
                com.cardinalcommerce.a.setMin r3 = com.cardinalcommerce.p060a.setMin.PROTOCOL_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r4 = 3
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r0 = configure
                r3 = r0 ^ 113(0x71, float:1.58E-43)
                r0 = r0 & 113(0x71, float:1.58E-43)
                int r0 = r0 << r2
                int r3 = r3 + r0
                int r0 = r3 % 128
                getInstance = r0
                int r3 = r3 % r1
            L_0x0052:
                int[] r0 = cca_continue     // Catch:{ NoSuchFieldError -> 0x006a }
                com.cardinalcommerce.a.setMin r3 = com.cardinalcommerce.p060a.setMin.MALFORMED_URL_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x006a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x006a }
                r4 = 4
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x006a }
                int r0 = getInstance
                r3 = r0 | 79
                int r3 = r3 << r2
                r0 = r0 ^ 79
                int r3 = r3 - r0
                int r0 = r3 % 128
                configure = r0
                int r3 = r3 % r1
            L_0x006a:
                int[] r0 = cca_continue     // Catch:{ NoSuchFieldError -> 0x0088 }
                com.cardinalcommerce.a.setMin r3 = com.cardinalcommerce.p060a.setMin.SOCKET_TIMEOUT_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x0088 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0088 }
                r4 = 5
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0088 }
                int r0 = configure
                r3 = r0 | 84
                int r3 = r3 << r2
                r0 = r0 ^ 84
                int r3 = r3 - r0
                r0 = r3 | -1
                int r0 = r0 << r2
                r2 = r3 ^ -1
                int r0 = r0 - r2
                int r2 = r0 % 128
                getInstance = r2
                int r0 = r0 % r1
            L_0x0088:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.cleanup.C19893.<clinit>():void");
        }
    }

    public final void cca_continue(Exception exc, setMin setmin) {
        int i = f2516e;
        int i2 = (((i ^ 60) + ((i & 60) << 1)) + 0) - 1;
        f2515d = i2 % 128;
        int i3 = i2 % 2;
        super.cca_continue(exc, setmin);
        int i4 = C19893.cca_continue[setmin.ordinal()];
        String str = null;
        if (i4 == 1 || i4 == 2) {
            CardinalRenderType cardinalRenderType = f2514c;
            CardinalError cardinalError = new CardinalError(10212, exc);
            cardinalRenderType.configure(String.valueOf(cardinalError.Cardinal), cardinalError.init, str);
            this.f2518b.getInstance(new CardinalError(10212));
            int i5 = f2515d;
            int i6 = i5 & 97;
            int i7 = (i5 ^ 97) | i6;
            int i8 = (i6 ^ i7) + ((i7 & i6) << 1);
            f2516e = i8 % 128;
            int i9 = i8 % 2;
        } else if (i4 == 3) {
            CardinalRenderType cardinalRenderType2 = f2514c;
            CardinalError cardinalError2 = new CardinalError(10213, exc);
            cardinalRenderType2.configure(String.valueOf(cardinalError2.Cardinal), cardinalError2.init, str);
            this.f2518b.getInstance(new CardinalError(10213));
            int i10 = f2516e;
            int i11 = (((i10 | 87) << 1) - (~(-(((~i10) & 87) | (i10 & -88))))) - 1;
            f2515d = i11 % 128;
            int i12 = i11 % 2;
        } else if (i4 != 4) {
            if (i4 == 5) {
                CardinalRenderType cardinalRenderType3 = f2514c;
                CardinalError cardinalError3 = new CardinalError(10216, exc);
                cardinalRenderType3.configure(String.valueOf(cardinalError3.Cardinal), cardinalError3.init, str);
                this.f2518b.getInstance(new CardinalError(10216));
                int i13 = f2516e;
                int i14 = (i13 | 27) << 1;
                int i15 = -(((~i13) & 27) | (i13 & -28));
                int i16 = (i14 & i15) + (i15 | i14);
                f2515d = i16 % 128;
                int i17 = i16 % 2;
            }
            int i18 = f2516e;
            int i19 = (((i18 ^ 26) + ((i18 & 26) << 1)) + 0) - 1;
            f2515d = i19 % 128;
            int i20 = i19 % 2;
        } else {
            CardinalRenderType cardinalRenderType4 = f2514c;
            CardinalError cardinalError4 = new CardinalError(10211, exc);
            cardinalRenderType4.configure(String.valueOf(cardinalError4.Cardinal), cardinalError4.init, str);
            this.f2518b.getInstance(new CardinalError(10211));
            int i21 = f2515d;
            int i22 = (i21 & 7) + (i21 | 7);
            f2516e = i22 % 128;
            if ((i22 % 2 == 0 ? 26 : 'K') == 26) {
                super.hashCode();
            }
        }
    }

    /* JADX WARNING: type inference failed for: r4v7, types: [java.lang.String] */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a4, code lost:
        if ((r9 != null ? 27 : org.osgi.framework.VersionRange.RIGHT_OPEN) != 27) goto L_0x0351;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b8, code lost:
        if ((r9 != null ? ' ' : '7') != ' ') goto L_0x0351;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00ee, code lost:
        if ((r9.length > 1 ? '!' : org.apache.commons.lang3.CharUtils.f5620CR) != 13) goto L_0x00f0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x036a A[Catch:{ JSONException -> 0x0405 }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0396 A[SYNTHETIC, Splitter:B:161:0x0396] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0126 A[SYNTHETIC, Splitter:B:73:0x0126] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cca_continue(java.lang.String r19) {
        /*
            r18 = this;
            r1 = r18
            java.lang.String r0 = "ErrorNumber"
            java.lang.String r2 = "jti"
            java.lang.String r3 = ""
            int r4 = f2516e
            r5 = r4 & -28
            int r6 = ~r4
            r7 = 27
            r6 = r6 & r7
            r5 = r5 | r6
            r4 = r4 & r7
            r6 = 1
            int r4 = r4 << r6
            int r4 = -r4
            int r4 = -r4
            r8 = r5 & r4
            r4 = r4 | r5
            int r8 = r8 + r4
            int r4 = r8 % 128
            f2515d = r4
            int r8 = r8 % 2
            r4 = 0
            boolean r5 = r19.isEmpty()     // Catch:{ JSONException -> 0x0405 }
            r8 = 0
            if (r5 == 0) goto L_0x0058
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r0 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError     // Catch:{ JSONException -> 0x0405 }
            r2 = 10219(0x27eb, float:1.432E-41)
            r0.<init>(r2)     // Catch:{ JSONException -> 0x0405 }
            com.cardinalcommerce.a.getWarnings r2 = r1.f2518b     // Catch:{ JSONException -> 0x0405 }
            r2.getInstance(r0)     // Catch:{ JSONException -> 0x0405 }
            int r0 = f2516e
            r2 = r0 ^ 29
            r0 = r0 & 29
            r0 = r0 | r2
            int r0 = r0 << r6
            int r2 = -r2
            r3 = r0 ^ r2
            r0 = r0 & r2
            int r0 = r0 << r6
            int r3 = r3 + r0
            int r0 = r3 % 128
            f2515d = r0
            int r3 = r3 % 2
            r0 = 68
            if (r3 == 0) goto L_0x004e
            r6 = 68
        L_0x004e:
            if (r6 == r0) goto L_0x0051
            return
        L_0x0051:
            r0 = 67
            int r0 = r0 / r8
            return
        L_0x0055:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x0058:
            boolean r5 = com.cardinalcommerce.p060a.setHeight.Cardinal     // Catch:{ JSONException -> 0x0405 }
            com.cardinalcommerce.a.configure r5 = new com.cardinalcommerce.a.configure     // Catch:{ JSONException -> 0x0405 }
            r5.<init>()     // Catch:{ JSONException -> 0x0405 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0405 }
            r10 = r19
            r9.<init>(r10)     // Catch:{ JSONException -> 0x0405 }
            int r10 = r9.optInt(r0, r8)     // Catch:{ JSONException -> 0x0405 }
            r5.configure = r10     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r10 = "Message"
            java.lang.String r10 = r9.optString(r10, r3)     // Catch:{ JSONException -> 0x0405 }
            r5.init = r10     // Catch:{ JSONException -> 0x0405 }
            int r10 = r5.configure     // Catch:{ JSONException -> 0x0405 }
            if (r10 != 0) goto L_0x007a
            r10 = 1
            goto L_0x007b
        L_0x007a:
            r10 = 0
        L_0x007b:
            if (r10 == r6) goto L_0x007f
            goto L_0x0351
        L_0x007f:
            int r10 = f2515d
            r11 = r10 ^ 121(0x79, float:1.7E-43)
            r10 = r10 & 121(0x79, float:1.7E-43)
            int r10 = r10 << r6
            int r11 = r11 + r10
            int r10 = r11 % 128
            f2516e = r10
            int r11 = r11 % 2
            if (r11 != 0) goto L_0x0091
            r10 = 0
            goto L_0x0092
        L_0x0091:
            r10 = 1
        L_0x0092:
            java.lang.String r12 = "CardinalJWT"
            if (r10 == r6) goto L_0x00ab
            java.lang.String r9 = r9.optString(r12, r3)     // Catch:{ JSONException -> 0x0405 }
            r10 = 63
            int r10 = r10 / r8
            if (r9 == 0) goto L_0x00a2
            r10 = 27
            goto L_0x00a4
        L_0x00a2:
            r10 = 41
        L_0x00a4:
            if (r10 == r7) goto L_0x00bc
            goto L_0x0351
        L_0x00a8:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x00ab:
            java.lang.String r9 = r9.optString(r12, r3)     // Catch:{ JSONException -> 0x0405 }
            r10 = 32
            if (r9 == 0) goto L_0x00b6
            r12 = 32
            goto L_0x00b8
        L_0x00b6:
            r12 = 55
        L_0x00b8:
            if (r12 == r10) goto L_0x00bc
            goto L_0x0351
        L_0x00bc:
            int r10 = f2516e
            int r10 = r10 + 5
            int r12 = r10 % 128
            f2515d = r12
            int r10 = r10 % 2
            if (r10 == 0) goto L_0x00ca
            r10 = 0
            goto L_0x00cb
        L_0x00ca:
            r10 = 1
        L_0x00cb:
            java.lang.String r12 = "\\."
            r13 = 57
            if (r10 == r6) goto L_0x00e0
            java.lang.String[] r9 = r9.split(r12)     // Catch:{ JSONException -> 0x0405 }
            int r10 = r9.length     // Catch:{ JSONException -> 0x0405 }
            if (r10 <= r6) goto L_0x00db
            r10 = 30
            goto L_0x00dd
        L_0x00db:
            r10 = 57
        L_0x00dd:
            if (r10 == r13) goto L_0x0118
            goto L_0x00f0
        L_0x00e0:
            java.lang.String[] r9 = r9.split(r12)     // Catch:{ JSONException -> 0x0405 }
            int r10 = r9.length     // Catch:{ JSONException -> 0x0405 }
            r12 = 13
            if (r10 <= r6) goto L_0x00ec
            r10 = 33
            goto L_0x00ee
        L_0x00ec:
            r10 = 13
        L_0x00ee:
            if (r10 == r12) goto L_0x0118
        L_0x00f0:
            int r10 = f2516e
            r12 = r10 & 59
            r10 = r10 ^ 59
            r10 = r10 | r12
            int r12 = r12 + r10
            int r10 = r12 % 128
            f2515d = r10
            int r12 = r12 % 2
            r9 = r9[r6]     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r9 = com.cardinalcommerce.p060a.CardinalEnvironment.cca_continue(r9)     // Catch:{ JSONException -> 0x0405 }
            int r10 = f2516e
            r12 = r10 & 27
            r7 = r7 ^ r10
            r7 = r7 | r12
            int r7 = -r7
            int r7 = -r7
            r10 = r12 ^ r7
            r7 = r7 & r12
            int r7 = r7 << r6
            int r10 = r10 + r7
            int r7 = r10 % 128
            f2515d = r7
            int r10 = r10 % 2
            goto L_0x0124
        L_0x0118:
            int r7 = f2516e
            int r7 = r7 + 100
            int r7 = r7 - r6
            int r9 = r7 % 128
            f2515d = r9
            int r7 = r7 % 2
            r9 = r4
        L_0x0124:
            if (r9 == 0) goto L_0x0351
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0405 }
            r7.<init>(r9)     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r9 = "iss"
            r7.optString(r9, r3)     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r9 = "iat"
            r7.optString(r9, r3)     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r9 = "exp"
            r7.optString(r9, r3)     // Catch:{ JSONException -> 0x0405 }
            r7.optString(r2, r3)     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r9 = "ConsumerSessionId"
            java.lang.String r9 = r7.optString(r9, r3)     // Catch:{ JSONException -> 0x0405 }
            r5.getInstance = r9     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r9 = "ReferenceId"
            r7.optString(r9, r3)     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r9 = "aud"
            r7.optString(r9, r3)     // Catch:{ JSONException -> 0x0405 }
            r7.optString(r2, r3)     // Catch:{ JSONException -> 0x0405 }
            r7.optString(r2, r3)     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r2 = "Payload"
            java.lang.String r2 = r7.optString(r2, r3)     // Catch:{ JSONException -> 0x0405 }
            com.cardinalcommerce.a.CardinalConfigurationParameters r7 = new com.cardinalcommerce.a.CardinalConfigurationParameters     // Catch:{ JSONException -> 0x0405 }
            r7.<init>()     // Catch:{ JSONException -> 0x0405 }
            boolean r9 = r2.equals(r3)     // Catch:{ JSONException -> 0x0405 }
            if (r9 != 0) goto L_0x031b
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0405 }
            r9.<init>(r2)     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r2 = "DeviceFingerprintingURL"
            java.lang.String r2 = r9.optString(r2, r3)     // Catch:{ JSONException -> 0x0405 }
            com.cardinalcommerce.a.setBaseline r10 = new com.cardinalcommerce.a.setBaseline     // Catch:{ JSONException -> 0x0405 }
            r10.<init>()     // Catch:{ JSONException -> 0x0405 }
            boolean r12 = r2.equals(r3)     // Catch:{ JSONException -> 0x0405 }
            r14 = 38
            if (r12 != 0) goto L_0x02e8
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r12 = r2.getScheme()     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r15 = r2.getAuthority()     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r16 = r2.getPath()     // Catch:{ JSONException -> 0x0405 }
            java.lang.Object r16 = java.util.Objects.requireNonNull(r16)     // Catch:{ JSONException -> 0x0405 }
            r11 = r16
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r8 = "/"
            java.lang.String[] r8 = r11.split(r8)     // Catch:{ JSONException -> 0x0405 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0405 }
            r11.<init>()     // Catch:{ JSONException -> 0x0405 }
            r11.append(r12)     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r12 = "://"
            r11.append(r12)     // Catch:{ JSONException -> 0x0405 }
            r11.append(r15)     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r12 = "/"
            r11.append(r12)     // Catch:{ JSONException -> 0x0405 }
            r8 = r8[r6]     // Catch:{ JSONException -> 0x0405 }
            r11.append(r8)     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r8 = r11.toString()     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r11 = "orgUnitId"
            java.lang.String r11 = r2.getQueryParameter(r11)     // Catch:{ JSONException -> 0x0405 }
            if (r11 == 0) goto L_0x01c4
            r12 = 1
            goto L_0x01c5
        L_0x01c4:
            r12 = 0
        L_0x01c5:
            if (r12 == 0) goto L_0x01ec
            int r12 = f2515d
            r15 = r12 ^ 109(0x6d, float:1.53E-43)
            r12 = r12 & 109(0x6d, float:1.53E-43)
            r12 = r12 | r15
            int r12 = r12 << r6
            int r15 = -r15
            r17 = r12 & r15
            r12 = r12 | r15
            int r12 = r17 + r12
            int r15 = r12 % 128
            f2516e = r15
            int r12 = r12 % 2
            if (r12 != 0) goto L_0x01df
            r12 = 0
            goto L_0x01e0
        L_0x01df:
            r12 = 1
        L_0x01e0:
            if (r12 == 0) goto L_0x01e5
            r10.cca_continue = r11     // Catch:{ JSONException -> 0x0405 }
            goto L_0x01ec
        L_0x01e5:
            r10.cca_continue = r11     // Catch:{ JSONException -> 0x0405 }
            int r11 = r4.length     // Catch:{ all -> 0x01e9 }
            goto L_0x01ec
        L_0x01e9:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x01ec:
            java.lang.String r11 = "referenceId"
            java.lang.String r11 = r2.getQueryParameter(r11)     // Catch:{ JSONException -> 0x0405 }
            if (r11 == 0) goto L_0x01f7
            r12 = 66
            goto L_0x01f9
        L_0x01f7:
            r12 = 38
        L_0x01f9:
            if (r12 == r14) goto L_0x0230
            int r12 = f2516e
            r15 = r12 ^ 57
            r17 = r12 & 57
            r15 = r15 | r17
            int r15 = r15 << r6
            r17 = r12 & -58
            int r12 = ~r12
            r12 = r12 & r13
            r12 = r17 | r12
            int r12 = -r12
            int r12 = ~r12
            int r15 = r15 - r12
            int r15 = r15 - r6
            int r12 = r15 % 128
            f2515d = r12
            int r15 = r15 % 2
            r10.getInstance = r11     // Catch:{ JSONException -> 0x0405 }
            int r11 = f2516e
            r12 = 43
            r13 = r11 ^ 43
            r15 = r11 & 43
            r13 = r13 | r15
            int r13 = r13 << r6
            r15 = r11 & -44
            int r11 = ~r11
            r11 = r11 & r12
            r11 = r11 | r15
            int r11 = -r11
            r12 = r13 & r11
            r11 = r11 | r13
            int r12 = r12 + r11
            int r11 = r12 % 128
            f2515d = r11
            int r12 = r12 % 2
        L_0x0230:
            java.lang.String r11 = "threatmetrix"
            java.lang.String r11 = r2.getQueryParameter(r11)     // Catch:{ JSONException -> 0x0405 }
            if (r11 == 0) goto L_0x023b
            r12 = 41
            goto L_0x023d
        L_0x023b:
            r12 = 22
        L_0x023d:
            r13 = 22
            if (r12 == r13) goto L_0x02c9
            int r12 = f2516e
            int r12 = r12 + 33
            int r12 = r12 - r6
            r13 = r12 | -1
            int r13 = r13 << r6
            r12 = r12 ^ -1
            int r13 = r13 - r12
            int r12 = r13 % 128
            f2515d = r12
            int r13 = r13 % 2
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)     // Catch:{ JSONException -> 0x0405 }
            boolean r11 = r11.booleanValue()     // Catch:{ JSONException -> 0x0405 }
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r11)     // Catch:{ JSONException -> 0x0405 }
            r10.init = r12     // Catch:{ JSONException -> 0x0405 }
            if (r11 == 0) goto L_0x0264
            r11 = 0
            goto L_0x0265
        L_0x0264:
            r11 = 1
        L_0x0265:
            if (r11 == r6) goto L_0x02c9
            int r11 = f2515d
            r12 = r11 ^ 4
            r11 = r11 & 4
            int r11 = r11 << r6
            int r12 = r12 + r11
            r11 = 0
            int r12 = r12 - r11
            int r12 = r12 - r6
            int r11 = r12 % 128
            f2516e = r11
            int r12 = r12 % 2
            java.lang.String r11 = "tmEventType"
            java.lang.String r11 = r2.getQueryParameter(r11)     // Catch:{ JSONException -> 0x0405 }
            if (r11 == 0) goto L_0x0282
            r12 = 1
            goto L_0x0283
        L_0x0282:
            r12 = 0
        L_0x0283:
            if (r12 == 0) goto L_0x02c9
            int r12 = f2515d
            r13 = r12 & 73
            int r15 = ~r13
            r12 = r12 | 73
            r12 = r12 & r15
            int r13 = r13 << r6
            int r12 = r12 + r13
            int r13 = r12 % 128
            f2516e = r13
            int r12 = r12 % 2
            boolean r12 = r11.isEmpty()     // Catch:{ JSONException -> 0x0405 }
            if (r12 != 0) goto L_0x029d
            r12 = 0
            goto L_0x029e
        L_0x029d:
            r12 = 1
        L_0x029e:
            if (r12 == 0) goto L_0x02a1
            goto L_0x02c9
        L_0x02a1:
            int r12 = f2516e
            r13 = r12 & 109(0x6d, float:1.53E-43)
            r12 = r12 | 109(0x6d, float:1.53E-43)
            int r12 = -r12
            int r12 = -r12
            r15 = r13 & r12
            r12 = r12 | r13
            int r15 = r15 + r12
            int r12 = r15 % 128
            f2515d = r12
            int r15 = r15 % 2
            r10.configure = r11     // Catch:{ JSONException -> 0x0405 }
            int r11 = f2515d
            r12 = r11 | 70
            int r12 = r12 << r6
            r11 = r11 ^ 70
            int r12 = r12 - r11
            r11 = r12 | -1
            int r11 = r11 << r6
            r12 = r12 ^ -1
            int r11 = r11 - r12
            int r12 = r11 % 128
            f2516e = r12
            int r11 = r11 % 2
        L_0x02c9:
            java.lang.String r11 = "geolocation"
            r2.getQueryParameter(r11)     // Catch:{ JSONException -> 0x0405 }
            r10.Cardinal = r8     // Catch:{ JSONException -> 0x0405 }
            int r2 = f2515d
            r8 = r2 ^ 59
            r11 = r2 & 59
            r8 = r8 | r11
            int r8 = r8 << r6
            int r11 = ~r11
            r2 = r2 | 59
            r2 = r2 & r11
            int r2 = -r2
            r11 = r8 | r2
            int r11 = r11 << r6
            r2 = r2 ^ r8
            int r11 = r11 - r2
            int r2 = r11 % 128
            f2516e = r2
            int r11 = r11 % 2
        L_0x02e8:
            r7.Cardinal = r10     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r2 = "EnabledCCA"
            r8 = 0
            r9.optBoolean(r2, r8)     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r2 = "EnabledDiscover"
            r9.optBoolean(r2, r8)     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r2 = "EnabledPaypal"
            r9.optBoolean(r2, r8)     // Catch:{ JSONException -> 0x0405 }
            int r0 = r9.optInt(r0, r8)     // Catch:{ JSONException -> 0x0405 }
            r7.cca_continue = r0     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r0 = "ErrorDescription"
            java.lang.String r0 = r9.optString(r0, r3)     // Catch:{ JSONException -> 0x0405 }
            r7.init = r0     // Catch:{ JSONException -> 0x0405 }
            int r0 = f2515d
            r2 = r0 & 38
            r0 = r0 | r14
            int r2 = r2 + r0
            r0 = r2 | -1
            int r0 = r0 << r6
            r2 = r2 ^ -1
            int r0 = r0 - r2
            int r2 = r0 % 128
            f2516e = r2
            int r0 = r0 % 2
            goto L_0x033b
        L_0x031b:
            r0 = 10214(0x27e6, float:1.4313E-41)
            r7.cca_continue = r0     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r0 = "Cardinal Init Response Error. Missing field :Payload"
            r7.init = r0     // Catch:{ JSONException -> 0x0405 }
            int r0 = f2515d
            r2 = r0 ^ 111(0x6f, float:1.56E-43)
            r3 = r0 & 111(0x6f, float:1.56E-43)
            r2 = r2 | r3
            int r2 = r2 << r6
            int r3 = ~r3
            r0 = r0 | 111(0x6f, float:1.56E-43)
            r0 = r0 & r3
            int r0 = -r0
            r3 = r2 ^ r0
            r0 = r0 & r2
            int r0 = r0 << r6
            int r3 = r3 + r0
            int r0 = r3 % 128
            f2516e = r0
            int r3 = r3 % 2
        L_0x033b:
            r5.Cardinal = r7     // Catch:{ JSONException -> 0x0405 }
            int r0 = f2515d
            r2 = r0 ^ 108(0x6c, float:1.51E-43)
            r0 = r0 & 108(0x6c, float:1.51E-43)
            int r0 = r0 << r6
            int r2 = r2 + r0
            r0 = r2 & -1
            r2 = r2 | -1
            int r0 = r0 + r2
            int r2 = r0 % 128
            f2516e = r2
            int r0 = r0 % 2
            goto L_0x0366
        L_0x0351:
            int r0 = f2516e
            r2 = r0 | 99
            int r3 = r2 << 1
            r0 = r0 & 99
            int r0 = ~r0
            r0 = r0 & r2
            int r0 = -r0
            r2 = r3 & r0
            r0 = r0 | r3
            int r2 = r2 + r0
            int r0 = r2 % 128
            f2515d = r0
            int r2 = r2 % 2
        L_0x0366:
            int r0 = r5.configure     // Catch:{ JSONException -> 0x0405 }
            if (r0 == 0) goto L_0x0396
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r0 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError     // Catch:{ JSONException -> 0x0405 }
            int r2 = r5.configure     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r3 = r5.init     // Catch:{ JSONException -> 0x0405 }
            r0.<init>((int) r2, (java.lang.String) r3)     // Catch:{ JSONException -> 0x0405 }
            com.cardinalcommerce.a.CardinalRenderType r2 = f2514c     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r3 = r5.getInstance     // Catch:{ JSONException -> 0x0405 }
            int r5 = r0.Cardinal     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r7 = r0.init     // Catch:{ JSONException -> 0x0405 }
            r2.configure(r5, r7, r3)     // Catch:{ JSONException -> 0x0405 }
            com.cardinalcommerce.a.getWarnings r2 = r1.f2518b     // Catch:{ JSONException -> 0x0405 }
            r2.getInstance(r0)     // Catch:{ JSONException -> 0x0405 }
            int r0 = f2515d
            r2 = r0 | 119(0x77, float:1.67E-43)
            int r2 = r2 << r6
            r0 = r0 ^ 119(0x77, float:1.67E-43)
            int r2 = r2 - r0
            int r0 = r2 % 128
            f2516e = r0
            int r2 = r2 % 2
            return
        L_0x0396:
            com.cardinalcommerce.a.CardinalConfigurationParameters r0 = r5.Cardinal     // Catch:{ JSONException -> 0x0405 }
            int r0 = r0.cca_continue     // Catch:{ JSONException -> 0x0405 }
            r2 = 17
            if (r0 == 0) goto L_0x03d8
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r0 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError     // Catch:{ JSONException -> 0x0405 }
            com.cardinalcommerce.a.CardinalConfigurationParameters r3 = r5.Cardinal     // Catch:{ JSONException -> 0x0405 }
            int r3 = r3.cca_continue     // Catch:{ JSONException -> 0x0405 }
            com.cardinalcommerce.a.CardinalConfigurationParameters r7 = r5.Cardinal     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r7 = r7.init     // Catch:{ JSONException -> 0x0405 }
            r0.<init>((int) r3, (java.lang.String) r7)     // Catch:{ JSONException -> 0x0405 }
            com.cardinalcommerce.a.CardinalRenderType r3 = f2514c     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r5 = r5.getInstance     // Catch:{ JSONException -> 0x0405 }
            int r7 = r0.Cardinal     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r8 = r0.init     // Catch:{ JSONException -> 0x0405 }
            r3.configure(r7, r8, r5)     // Catch:{ JSONException -> 0x0405 }
            com.cardinalcommerce.a.getWarnings r3 = r1.f2518b     // Catch:{ JSONException -> 0x0405 }
            r3.getInstance(r0)     // Catch:{ JSONException -> 0x0405 }
            int r0 = f2515d
            int r0 = r0 + r2
            int r2 = r0 % 128
            f2516e = r2
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x03cc
            r0 = 1
            goto L_0x03cd
        L_0x03cc:
            r0 = 0
        L_0x03cd:
            if (r0 == r6) goto L_0x03d0
            return
        L_0x03d0:
            r0 = 24
            r2 = 0
            int r0 = r0 / r2
            return
        L_0x03d5:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x03d8:
            com.cardinalcommerce.a.CardinalRenderType r0 = f2514c     // Catch:{ JSONException -> 0x0405 }
            java.lang.String r3 = "CardinalInit"
            java.lang.String r7 = "Init Successful"
            r0.init(r3, r7)     // Catch:{ JSONException -> 0x0405 }
            com.cardinalcommerce.a.getWarnings r0 = r1.f2518b     // Catch:{ JSONException -> 0x0405 }
            r0.Cardinal(r5)     // Catch:{ JSONException -> 0x0405 }
            int r0 = f2515d
            r3 = r0 | 63
            int r3 = r3 << r6
            r0 = r0 ^ 63
            int r3 = r3 - r0
            int r0 = r3 % 128
            f2516e = r0
            int r3 = r3 % 2
            r0 = 54
            if (r3 != 0) goto L_0x03fa
            r2 = 54
        L_0x03fa:
            if (r2 == r0) goto L_0x03fd
            return
        L_0x03fd:
            r0 = 49
            r2 = 0
            int r0 = r0 / r2
            return
        L_0x0402:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x0405:
            r0 = move-exception
            com.cardinalcommerce.a.CardinalRenderType r2 = f2514c
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r3 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r5 = 10206(0x27de, float:1.4302E-41)
            r3.<init>((int) r5, (java.lang.Exception) r0)
            int r6 = r3.Cardinal
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r3 = r3.init
            r2.configure(r6, r3, r4)
            com.cardinalcommerce.a.getWarnings r2 = r1.f2518b
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r3 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            java.lang.String r0 = r0.getLocalizedMessage()
            r3.<init>((int) r5, (java.lang.String) r0)
            r2.getInstance(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.cleanup.cca_continue(java.lang.String):void");
    }
}
