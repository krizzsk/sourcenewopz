package com.cardinalcommerce.p060a;

import com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode;
import com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse;
import com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.values */
public final class values extends setKeyListener {

    /* renamed from: d */
    private static final CardinalRenderType f3111d = CardinalRenderType.cca_continue();

    /* renamed from: e */
    private static int f3112e = 0;

    /* renamed from: f */
    private static int f3113f = 1;

    /* renamed from: a */
    private final CardinalError f3114a;

    /* renamed from: b */
    private final setTypeface f3115b;

    /* renamed from: c */
    private char[] f3116c;

    static {
        int i = f3113f;
        int i2 = (i & -110) | ((~i) & 109);
        int i3 = (i & 109) << 1;
        int i4 = (i2 & i3) + (i3 | i2);
        f3112e = i4 % 128;
        int i5 = i4 % 2;
    }

    public values(setTypeface settypeface, CardinalError cardinalError, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        this.f3114a = cardinalError;
        this.f3116c = settypeface.init();
        this.f3115b = settypeface;
        f3111d.init("CardinalContinue", "Challenge task initialized", String.valueOf(settypeface.CardinalUiType()));
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("Order/JWT/StepUp");
            String obj = sb.toString();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            char[] init = settypeface.init();
            String str11 = null;
            if (init == null) {
                str2 = null;
            } else {
                str2 = new String(init);
            }
            jSONObject2.putOpt("ChallengeCancel", str2);
            char[] instance = settypeface.getInstance();
            if (instance == null) {
                str3 = null;
            } else {
                str3 = new String(instance);
            }
            jSONObject2.putOpt("ChallengeDataEntry", str3);
            char[] configure = settypeface.configure();
            if (configure == null) {
                str4 = null;
            } else {
                str4 = new String(configure);
            }
            jSONObject2.putOpt("ChallengeHTMLDataEntry", str4);
            jSONObject2.putOpt("OobContinue", Boolean.valueOf(settypeface.values()));
            char[] sDKVersion = settypeface.getSDKVersion();
            if (sDKVersion == null) {
                str5 = null;
            } else {
                str5 = new String(sDKVersion);
            }
            jSONObject2.putOpt("ResendChallenge", str5);
            char[] CardinalEnvironment = settypeface.CardinalEnvironment();
            if (CardinalEnvironment == null) {
                str6 = null;
            } else {
                str6 = new String(CardinalEnvironment);
            }
            jSONObject2.putOpt("TransactionId", str6);
            char[] valueOf = settypeface.valueOf();
            if (valueOf == null) {
                str7 = null;
            } else {
                str7 = new String(valueOf);
            }
            jSONObject2.putOpt("ChallengeNoEntry", str7);
            char[] warnings = settypeface.getWarnings();
            if (warnings == null) {
                str8 = null;
            } else {
                str8 = new String(warnings);
            }
            jSONObject2.putOpt("RequestorAppUrl", str8);
            char[] cleanup = settypeface.cleanup();
            if (cleanup == null) {
                str9 = null;
            } else {
                str9 = new String(cleanup);
            }
            jSONObject2.putOpt("WhiteListDataEntry", str9);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("PaymentType", "cca");
            jSONObject3.putOpt("StepUp", jSONObject2);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.putOpt("Agent", "CardinalMobileSdk_Android");
            jSONObject4.putOpt("Version", setHeight.values);
            jSONObject.putOpt("BrowserPayload", jSONObject3);
            jSONObject.putOpt("Client", jSONObject4);
            if (settypeface.CardinalUiType().length != 0) {
                char[] CardinalUiType = settypeface.CardinalUiType();
                if (CardinalUiType == null) {
                    str10 = null;
                } else {
                    str10 = new String(CardinalUiType);
                }
                jSONObject.putOpt("ConsumerSessionId", str10);
            }
            if (settypeface.CardinalRenderType().length != 0) {
                char[] CardinalRenderType = settypeface.CardinalRenderType();
                if (CardinalRenderType != null) {
                    str11 = new String(CardinalRenderType);
                }
                jSONObject.putOpt("ServerJWT", str11);
            }
            super.configure(obj, String.valueOf(jSONObject), 10000);
        } catch (JSONException e) {
            CardinalRenderType cardinalRenderType = f3111d;
            CardinalError cardinalError2 = new CardinalError(10611, (Exception) e);
            cardinalRenderType.configure(String.valueOf(cardinalError2.Cardinal), cardinalError2.init, String.valueOf(settypeface.CardinalUiType()));
            this.f3114a.cca_continue(new ValidateResponse(CardinalActionCode.ERROR, new CardinalError(10611)), "");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        if ((r1) != false) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0044, code lost:
        if ((!com.cardinalcommerce.p060a.setHorizontallyScrolling.init(r8.f3116c) ? 'B' : 'Q') != 'B') goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0082, code lost:
        if (java.util.Arrays.equals(r8.f3116c, com.cardinalcommerce.p060a.setHeight.cleanup) != false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0090, code lost:
        if (r1 != false) goto L_0x0092;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void configure() {
        /*
            r8 = this;
            int r0 = f3113f
            r1 = r0 | 48
            r2 = 1
            int r1 = r1 << r2
            r0 = r0 ^ 48
            int r1 = r1 - r0
            int r1 = r1 - r2
            int r0 = r1 % 128
            f3112e = r0
            int r1 = r1 % 2
            r0 = 0
            if (r1 == 0) goto L_0x0015
            r1 = 0
            goto L_0x0016
        L_0x0015:
            r1 = 1
        L_0x0016:
            r3 = 81
            r4 = 0
            if (r1 == r2) goto L_0x0032
            super.configure()
            char[] r1 = r8.f3116c
            boolean r1 = com.cardinalcommerce.p060a.setHorizontallyScrolling.init((char[]) r1)
            super.hashCode()     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x002b
            r1 = 0
            goto L_0x002c
        L_0x002b:
            r1 = 1
        L_0x002c:
            if (r1 == 0) goto L_0x0047
            goto L_0x00b2
        L_0x0030:
            r0 = move-exception
            throw r0
        L_0x0032:
            super.configure()
            char[] r1 = r8.f3116c
            boolean r1 = com.cardinalcommerce.p060a.setHorizontallyScrolling.init((char[]) r1)
            r5 = 66
            if (r1 != 0) goto L_0x0042
            r1 = 66
            goto L_0x0044
        L_0x0042:
            r1 = 81
        L_0x0044:
            if (r1 == r5) goto L_0x0047
            goto L_0x00b2
        L_0x0047:
            int r1 = f3113f
            r5 = r1 | 57
            int r5 = r5 << r2
            r1 = r1 ^ 57
            int r5 = r5 - r1
            int r1 = r5 % 128
            f3112e = r1
            int r5 = r5 % 2
            char[] r1 = r8.f3116c
            char[] r5 = com.cardinalcommerce.p060a.setHeight.getWarnings
            boolean r1 = java.util.Arrays.equals(r1, r5)
            if (r1 != 0) goto L_0x0061
            r1 = 0
            goto L_0x0062
        L_0x0061:
            r1 = 1
        L_0x0062:
            if (r1 == 0) goto L_0x0065
            goto L_0x0092
        L_0x0065:
            int r1 = f3112e
            r5 = r1 & 75
            r1 = r1 ^ 75
            r1 = r1 | r5
            int r5 = r5 + r1
            int r1 = r5 % 128
            f3113f = r1
            int r5 = r5 % 2
            if (r5 != 0) goto L_0x0077
            r1 = 1
            goto L_0x0078
        L_0x0077:
            r1 = 0
        L_0x0078:
            if (r1 == r2) goto L_0x0085
            char[] r1 = r8.f3116c
            char[] r5 = com.cardinalcommerce.p060a.setHeight.cleanup
            boolean r1 = java.util.Arrays.equals(r1, r5)
            if (r1 == 0) goto L_0x00b2
            goto L_0x0092
        L_0x0085:
            char[] r1 = r8.f3116c
            char[] r5 = com.cardinalcommerce.p060a.setHeight.cleanup
            boolean r1 = java.util.Arrays.equals(r1, r5)
            super.hashCode()     // Catch:{ all -> 0x00c4 }
            if (r1 == 0) goto L_0x00b2
        L_0x0092:
            com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse r1 = new com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r5 = com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode.CANCEL
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r6 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            java.lang.String r7 = ""
            r6.<init>((int) r0, (java.lang.String) r7)
            r1.<init>(r5, r6)
            com.cardinalcommerce.a.CardinalError r0 = r8.f3114a
            r0.cca_continue(r1, r4)
            int r0 = f3112e
            r1 = r0 | 81
            int r1 = r1 << r2
            r0 = r0 ^ r3
            int r1 = r1 - r0
            int r0 = r1 % 128
            f3113f = r0
            int r1 = r1 % 2
        L_0x00b2:
            int r0 = f3112e
            int r0 = r0 + 55
            int r0 = r0 - r2
            r1 = r0 | -1
            int r1 = r1 << r2
            r0 = r0 ^ -1
            int r1 = r1 - r0
            int r0 = r1 % 128
            f3113f = r0
            int r1 = r1 % 2
            return
        L_0x00c4:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.values.configure():void");
    }

    public final void getInstance(String str, int i) {
        CardinalRenderType cardinalRenderType = f3111d;
        CardinalError cardinalError = new CardinalError(i, str);
        cardinalRenderType.configure(String.valueOf(cardinalError.Cardinal), cardinalError.init, String.valueOf(this.f3115b.CardinalUiType()));
        this.f3114a.cca_continue(new ValidateResponse(CardinalActionCode.ERROR, new CardinalError(10612)), "");
        int i2 = f3113f;
        int i3 = ((i2 | 39) << 1) - (i2 ^ 39);
        f3112e = i3 % 128;
        int i4 = i3 % 2;
    }

    /* renamed from: com.cardinalcommerce.a.values$2 */
    static /* synthetic */ class C21312 {
        private static int Cardinal = 1;
        static final /* synthetic */ int[] configure;
        private static int init;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|17) */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0074 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x001e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x003b */
        static {
            /*
                com.cardinalcommerce.a.setMin[] r0 = com.cardinalcommerce.p060a.setMin.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                configure = r0
                r1 = 2
                r2 = 1
                com.cardinalcommerce.a.setMin r3 = com.cardinalcommerce.p060a.setMin.EXCEPTION     // Catch:{ NoSuchFieldError -> 0x001e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001e }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
                int r0 = init
                int r0 = r0 + 9
                int r0 = r0 - r2
                int r0 = r0 - r2
                int r3 = r0 % 128
                Cardinal = r3
                int r0 = r0 % r1
            L_0x001e:
                int[] r0 = configure     // Catch:{ NoSuchFieldError -> 0x003b }
                com.cardinalcommerce.a.setMin r3 = com.cardinalcommerce.p060a.setMin.IO_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x003b }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x003b }
                int r0 = Cardinal
                r3 = r0 & 43
                r0 = r0 ^ 43
                r0 = r0 | r3
                int r0 = -r0
                int r0 = -r0
                r4 = r3 ^ r0
                r0 = r0 & r3
                int r0 = r0 << r2
                int r4 = r4 + r0
                int r0 = r4 % 128
                init = r0
                int r4 = r4 % r1
            L_0x003b:
                int[] r0 = configure     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.cardinalcommerce.a.setMin r3 = com.cardinalcommerce.p060a.setMin.PROTOCOL_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r4 = 3
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r0 = init
                r3 = r0 & 87
                r0 = r0 | 87
                r4 = r3 ^ r0
                r0 = r0 & r3
                int r0 = r0 << r2
                int r4 = r4 + r0
                int r0 = r4 % 128
                Cardinal = r0
                int r4 = r4 % r1
            L_0x0056:
                int[] r0 = configure     // Catch:{ NoSuchFieldError -> 0x0074 }
                com.cardinalcommerce.a.setMin r3 = com.cardinalcommerce.p060a.setMin.MALFORMED_URL_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
                r4 = 4
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r0 = init
                r3 = r0 & 99
                r0 = r0 ^ 99
                r0 = r0 | r3
                int r0 = -r0
                int r0 = -r0
                r4 = r3 | r0
                int r4 = r4 << r2
                r0 = r0 ^ r3
                int r4 = r4 - r0
                int r0 = r4 % 128
                Cardinal = r0
                int r4 = r4 % r1
            L_0x0074:
                int[] r0 = configure     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.cardinalcommerce.a.setMin r3 = com.cardinalcommerce.p060a.setMin.SOCKET_TIMEOUT_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r4 = 5
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r0 = init
                int r0 = r0 + 7
                int r0 = r0 - r2
                r3 = r0 | -1
                int r2 = r3 << 1
                r0 = r0 ^ -1
                int r2 = r2 - r0
                int r0 = r2 % 128
                Cardinal = r0
                int r2 = r2 % r1
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.values.C21312.<clinit>():void");
        }
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        r10 = 86 / 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0238, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
        if ((java.util.Arrays.equals(r9.f3116c, com.cardinalcommerce.p060a.setHeight.getWarnings) ? '#' : 'G') != '#') goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        if ((r1 ? 'b' : 23) != 23) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0073, code lost:
        if ((!java.util.Arrays.equals(r9.f3116c, com.cardinalcommerce.p060a.setHeight.cleanup) ? '6' : 22) != 22) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007b, code lost:
        if (com.cardinalcommerce.p060a.setHorizontallyScrolling.init(r9.f3116c) == false) goto L_0x0211;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r1 = new com.cardinalcommerce.p060a.valueOf(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0082, code lost:
        r10 = f3113f + 91;
        f3112e = r10 % 128;
        r10 = r10 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008d, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008e, code lost:
        r1 = f3111d;
        r7 = new java.lang.StringBuilder(com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError.SUBSEQUENT_CRES_VALIDATION_ERROR_MESSAGE);
        r7.append(r10.getLocalizedMessage());
        r3 = new com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError(10705, r7.toString());
        r1.configure(java.lang.String.valueOf(r3.Cardinal), r3.init, java.lang.String.valueOf(r9.f3115b.CardinalUiType()));
        r9.f3114a.cca_continue(new com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse(com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode.ERROR, new com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError(10705)), "");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d0, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d3, code lost:
        r1 = f3111d;
        r3 = new com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError(10611, r10);
        r1.configure(java.lang.String.valueOf(r3.Cardinal), r3.init, java.lang.String.valueOf(r9.f3115b.CardinalUiType()));
        r9.f3114a.cca_continue(new com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse(com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode.ERROR, new com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError(10611)), "");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0102, code lost:
        r1 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0103, code lost:
        if (r1 == null) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0105, code lost:
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0107, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0108, code lost:
        if (r10 == false) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x010c, code lost:
        r10 = f3112e + 111;
        f3113f = r10 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0117, code lost:
        if ((r10 % 2) == 0) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0119, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x011b, code lost:
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x011c, code lost:
        if (r10 != true) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0122, code lost:
        if (r1.f3107a == 0) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0124, code lost:
        r10 = org.osgi.framework.VersionRange.RIGHT_CLOSED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0127, code lost:
        r10 = 'T';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0129, code lost:
        if (r10 != 'T') goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x012c, code lost:
        r10 = r1.f3107a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        super.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0133, code lost:
        if (r10 == 0) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0135, code lost:
        r10 = 'A';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0138, code lost:
        r10 = kotlin.text.Typography.greater;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x013a, code lost:
        if (r10 != 'A') goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x013c, code lost:
        r9.f3114a.cca_continue(new com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse(com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode.ERROR, new com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError(r1.f3107a, r1.init)), r5);
        r10 = f3112e;
        r0 = (r10 & -42) | ((~r10) & 41);
        r10 = (r10 & 41) << 1;
        r1 = ((r0 | r10) << 1) - (r10 ^ r0);
        f3113f = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x016b, code lost:
        if (r1.configure == null) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x016d, code lost:
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x016f, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0170, code lost:
        if (r10 == false) goto L_0x01de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0176, code lost:
        if (r1.Cardinal() == false) goto L_0x017a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0178, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x017a, code lost:
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x017b, code lost:
        if (r10 == true) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x017d, code lost:
        r9.f3114a.cca_continue(new com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse(com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode.ERROR, new com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError(10702)), r5);
        r10 = f3112e;
        r0 = (((r10 | 14) << 1) - (r10 ^ 14)) - 1;
        f3113f = r0 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01a1, code lost:
        if ((r0 % 2) != 0) goto L_0x01a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01a3, code lost:
        r0 = '9';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01a6, code lost:
        r0 = 25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01a8, code lost:
        if (r0 == 25) goto L_0x01b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r10 = 78 / 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01ad, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01b0, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01b1, code lost:
        r10 = f3112e;
        r3 = (r10 & -112) | ((~r10) & 111);
        r10 = (r10 & 111) << 1;
        r0 = (r3 ^ r10) + ((r10 & r3) << 1);
        f3113f = r0 % 128;
        r0 = r0 % 2;
        r9.f3114a.cca_continue(r1.Cardinal, r1.f3108b);
        r10 = f3112e;
        r0 = (((r10 | 2) << 1) - (r10 ^ 2)) - 1;
        f3113f = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01dd, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01de, code lost:
        r10 = f3113f;
        r0 = r10 & 43;
        r0 = (r0 - (~((r10 ^ 43) | r0))) - 1;
        f3112e = r0 % 128;
        r0 = r0 % 2;
        r9.f3114a.cca_continue(r1.configure);
        r10 = f3113f + 19;
        f3112e = r10 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0201, code lost:
        if ((r10 % 2) == 0) goto L_0x0206;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0203, code lost:
        r10 = '0';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0206, code lost:
        r10 = 'S';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0208, code lost:
        if (r10 == 'S') goto L_0x020e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        r6 = 0 / 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x020b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x020e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0211, code lost:
        r10 = f3112e;
        r0 = ((r10 ^ 13) | (r10 & 13)) << 1;
        r10 = -(((~r10) & 13) | (r10 & -14));
        r1 = (r0 ^ r10) + ((r10 & r0) << 1);
        f3113f = r1 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x022b, code lost:
        if ((r1 % 2) != 0) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x022d, code lost:
        r10 = 'G';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0230, code lost:
        r10 = ',';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0232, code lost:
        if (r10 == 'G') goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0234, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0234 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cca_continue(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = ""
            int r1 = f3113f
            int r1 = r1 + 47
            r2 = 1
            int r1 = r1 - r2
            r3 = r1 | -1
            int r3 = r3 << r2
            r1 = r1 ^ -1
            int r3 = r3 - r1
            int r1 = r3 % 128
            f3112e = r1
            int r3 = r3 % 2
            r1 = 49
            if (r3 == 0) goto L_0x001b
            r3 = 49
            goto L_0x001d
        L_0x001b:
            r3 = 76
        L_0x001d:
            r4 = 71
            r5 = 0
            r6 = 0
            if (r3 == r1) goto L_0x0037
            char[] r1 = r9.f3116c
            char[] r3 = com.cardinalcommerce.p060a.setHeight.getWarnings
            boolean r1 = java.util.Arrays.equals(r1, r3)
            r3 = 35
            if (r1 == 0) goto L_0x0032
            r1 = 35
            goto L_0x0034
        L_0x0032:
            r1 = 71
        L_0x0034:
            if (r1 == r3) goto L_0x004b
            goto L_0x0075
        L_0x0037:
            char[] r1 = r9.f3116c
            char[] r3 = com.cardinalcommerce.p060a.setHeight.getWarnings
            boolean r1 = java.util.Arrays.equals(r1, r3)
            int r3 = r5.length     // Catch:{ all -> 0x023b }
            r3 = 23
            if (r1 == 0) goto L_0x0047
            r1 = 98
            goto L_0x0049
        L_0x0047:
            r1 = 23
        L_0x0049:
            if (r1 == r3) goto L_0x0075
        L_0x004b:
            int r1 = f3112e
            r3 = r1 & -34
            int r7 = ~r1
            r7 = r7 & 33
            r3 = r3 | r7
            r1 = r1 & 33
            int r1 = r1 << r2
            int r1 = -r1
            int r1 = -r1
            r7 = r3 & r1
            r1 = r1 | r3
            int r7 = r7 + r1
            int r1 = r7 % 128
            f3113f = r1
            int r7 = r7 % 2
            char[] r1 = r9.f3116c
            char[] r3 = com.cardinalcommerce.p060a.setHeight.cleanup
            boolean r1 = java.util.Arrays.equals(r1, r3)
            r3 = 22
            if (r1 != 0) goto L_0x0071
            r1 = 54
            goto L_0x0073
        L_0x0071:
            r1 = 22
        L_0x0073:
            if (r1 == r3) goto L_0x0211
        L_0x0075:
            char[] r1 = r9.f3116c
            boolean r1 = com.cardinalcommerce.p060a.setHorizontallyScrolling.init((char[]) r1)
            if (r1 == 0) goto L_0x0211
            com.cardinalcommerce.a.valueOf r1 = new com.cardinalcommerce.a.valueOf     // Catch:{ JSONException -> 0x00d2, UnsupportedOperationException -> 0x00d0, RuntimeException -> 0x008d }
            r1.<init>(r10)     // Catch:{ JSONException -> 0x00d2, UnsupportedOperationException -> 0x00d0, RuntimeException -> 0x008d }
            int r10 = f3113f
            int r10 = r10 + 91
            int r0 = r10 % 128
            f3112e = r0
            int r10 = r10 % 2
            goto L_0x0103
        L_0x008d:
            r10 = move-exception
            com.cardinalcommerce.a.CardinalRenderType r1 = f3111d
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r3 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Subsequent CRes Validation fails."
            r7.<init>(r8)
            java.lang.String r10 = r10.getLocalizedMessage()
            r7.append(r10)
            java.lang.String r10 = r7.toString()
            r7 = 10705(0x29d1, float:1.5001E-41)
            r3.<init>((int) r7, (java.lang.String) r10)
            com.cardinalcommerce.a.setTypeface r10 = r9.f3115b
            char[] r10 = r10.CardinalUiType()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            int r8 = r3.Cardinal
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r3 = r3.init
            r1.configure(r8, r3, r10)
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r10 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r10.<init>(r7)
            com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse r1 = new com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r3 = com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode.ERROR
            r1.<init>(r3, r10)
            com.cardinalcommerce.a.CardinalError r10 = r9.f3114a
            r10.cca_continue(r1, r0)
            goto L_0x0102
        L_0x00d0:
            r10 = move-exception
            goto L_0x00d3
        L_0x00d2:
            r10 = move-exception
        L_0x00d3:
            com.cardinalcommerce.a.CardinalRenderType r1 = f3111d
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r3 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r7 = 10611(0x2973, float:1.4869E-41)
            r3.<init>((int) r7, (java.lang.Exception) r10)
            com.cardinalcommerce.a.setTypeface r10 = r9.f3115b
            char[] r10 = r10.CardinalUiType()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            int r8 = r3.Cardinal
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r3 = r3.init
            r1.configure(r8, r3, r10)
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r10 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r10.<init>(r7)
            com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse r1 = new com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r3 = com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode.ERROR
            r1.<init>(r3, r10)
            com.cardinalcommerce.a.CardinalError r10 = r9.f3114a
            r10.cca_continue(r1, r0)
        L_0x0102:
            r1 = r5
        L_0x0103:
            if (r1 == 0) goto L_0x0107
            r10 = 0
            goto L_0x0108
        L_0x0107:
            r10 = 1
        L_0x0108:
            if (r10 == 0) goto L_0x010c
            goto L_0x0211
        L_0x010c:
            int r10 = f3112e
            r0 = 111(0x6f, float:1.56E-43)
            int r10 = r10 + r0
            int r3 = r10 % 128
            f3113f = r3
            int r10 = r10 % 2
            if (r10 != 0) goto L_0x011b
            r10 = 1
            goto L_0x011c
        L_0x011b:
            r10 = 0
        L_0x011c:
            if (r10 == r2) goto L_0x012c
            int r10 = r1.f3107a
            r3 = 84
            if (r10 != 0) goto L_0x0127
            r10 = 93
            goto L_0x0129
        L_0x0127:
            r10 = 84
        L_0x0129:
            if (r10 == r3) goto L_0x013c
            goto L_0x0169
        L_0x012c:
            int r10 = r1.f3107a
            super.hashCode()     // Catch:{ all -> 0x020f }
            r3 = 65
            if (r10 != 0) goto L_0x0138
            r10 = 65
            goto L_0x013a
        L_0x0138:
            r10 = 62
        L_0x013a:
            if (r10 == r3) goto L_0x0169
        L_0x013c:
            com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse r10 = new com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r0 = com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode.ERROR
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r3 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            int r7 = r1.f3107a
            java.lang.String r1 = r1.init
            r3.<init>((int) r7, (java.lang.String) r1)
            r10.<init>(r0, r3)
            com.cardinalcommerce.a.CardinalError r0 = r9.f3114a
            r0.cca_continue(r10, r5)
            int r10 = f3112e
            r0 = r10 & -42
            int r1 = ~r10
            r1 = r1 & 41
            r0 = r0 | r1
            r10 = r10 & 41
            int r10 = r10 << r2
            r1 = r0 | r10
            int r1 = r1 << r2
            r10 = r10 ^ r0
            int r1 = r1 - r10
            int r10 = r1 % 128
            f3113f = r10
            int r1 = r1 % 2
            goto L_0x0211
        L_0x0169:
            com.cardinalcommerce.a.setBaselineAligned r10 = r1.configure
            if (r10 == 0) goto L_0x016f
            r10 = 0
            goto L_0x0170
        L_0x016f:
            r10 = 1
        L_0x0170:
            if (r10 == 0) goto L_0x01de
            boolean r10 = r1.Cardinal()
            if (r10 == 0) goto L_0x017a
            r10 = 1
            goto L_0x017b
        L_0x017a:
            r10 = 0
        L_0x017b:
            if (r10 == r2) goto L_0x01b1
            com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse r10 = new com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r0 = com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode.ERROR
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r1 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r3 = 10702(0x29ce, float:1.4997E-41)
            r1.<init>(r3)
            r10.<init>(r0, r1)
            com.cardinalcommerce.a.CardinalError r0 = r9.f3114a
            r0.cca_continue(r10, r5)
            int r10 = f3112e
            r0 = r10 | 14
            int r0 = r0 << r2
            r10 = r10 ^ 14
            int r0 = r0 - r10
            int r0 = r0 - r2
            int r10 = r0 % 128
            f3113f = r10
            int r0 = r0 % 2
            r10 = 25
            if (r0 != 0) goto L_0x01a6
            r0 = 57
            goto L_0x01a8
        L_0x01a6:
            r0 = 25
        L_0x01a8:
            if (r0 == r10) goto L_0x01b0
            r10 = 78
            int r10 = r10 / r6
            return
        L_0x01ae:
            r10 = move-exception
            throw r10
        L_0x01b0:
            return
        L_0x01b1:
            int r10 = f3112e
            r3 = r10 & -112(0xffffffffffffff90, float:NaN)
            int r4 = ~r10
            r4 = r4 & r0
            r3 = r3 | r4
            r10 = r10 & r0
            int r10 = r10 << r2
            r0 = r3 ^ r10
            r10 = r10 & r3
            int r10 = r10 << r2
            int r0 = r0 + r10
            int r10 = r0 % 128
            f3113f = r10
            int r0 = r0 % 2
            com.cardinalcommerce.a.CardinalError r10 = r9.f3114a
            com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse r0 = r1.Cardinal
            java.lang.String r1 = r1.f3108b
            r10.cca_continue(r0, r1)
            int r10 = f3112e
            r0 = r10 | 2
            int r0 = r0 << r2
            r10 = r10 ^ 2
            int r0 = r0 - r10
            int r0 = r0 - r2
            int r10 = r0 % 128
            f3113f = r10
            int r0 = r0 % 2
            return
        L_0x01de:
            int r10 = f3113f
            r0 = r10 & 43
            r10 = r10 ^ 43
            r10 = r10 | r0
            int r10 = ~r10
            int r0 = r0 - r10
            int r0 = r0 - r2
            int r10 = r0 % 128
            f3112e = r10
            int r0 = r0 % 2
            com.cardinalcommerce.a.CardinalError r10 = r9.f3114a
            com.cardinalcommerce.a.setBaselineAligned r0 = r1.configure
            r10.cca_continue(r0)
            int r10 = f3113f
            int r10 = r10 + 19
            int r0 = r10 % 128
            f3112e = r0
            int r10 = r10 % 2
            r0 = 83
            if (r10 == 0) goto L_0x0206
            r10 = 48
            goto L_0x0208
        L_0x0206:
            r10 = 83
        L_0x0208:
            if (r10 == r0) goto L_0x020e
            int r6 = r6 / r6
            return
        L_0x020c:
            r10 = move-exception
            throw r10
        L_0x020e:
            return
        L_0x020f:
            r10 = move-exception
            throw r10
        L_0x0211:
            int r10 = f3112e
            r0 = r10 ^ 13
            r1 = r10 & 13
            r0 = r0 | r1
            int r0 = r0 << r2
            r1 = r10 & -14
            int r10 = ~r10
            r10 = r10 & 13
            r10 = r10 | r1
            int r10 = -r10
            r1 = r0 ^ r10
            r10 = r10 & r0
            int r10 = r10 << r2
            int r1 = r1 + r10
            int r10 = r1 % 128
            f3113f = r10
            int r1 = r1 % 2
            if (r1 != 0) goto L_0x0230
            r10 = 71
            goto L_0x0232
        L_0x0230:
            r10 = 44
        L_0x0232:
            if (r10 == r4) goto L_0x0235
            return
        L_0x0235:
            r10 = 86
            int r10 = r10 / r6
            return
        L_0x0239:
            r10 = move-exception
            throw r10
        L_0x023b:
            r10 = move-exception
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.values.cca_continue(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        if (r10 != 5) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        if (r10 != 5) goto L_0x008c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cca_continue(java.lang.Exception r9, com.cardinalcommerce.p060a.setMin r10) {
        /*
            r8 = this;
            int r0 = f3112e
            int r0 = r0 + 20
            r1 = 1
            int r0 = r0 - r1
            int r2 = r0 % 128
            f3113f = r2
            r2 = 2
            int r0 = r0 % r2
            r3 = 46
            if (r0 != 0) goto L_0x0013
            r0 = 46
            goto L_0x0015
        L_0x0013:
            r0 = 57
        L_0x0015:
            r4 = 5
            r5 = 4
            r6 = 3
            java.lang.String r7 = ""
            if (r0 == r3) goto L_0x0032
            super.cca_continue(r9, r10)
            int[] r0 = com.cardinalcommerce.p060a.values.C21312.configure
            int r10 = r10.ordinal()
            r10 = r0[r10]
            if (r10 == r1) goto L_0x0127
            if (r10 == r2) goto L_0x0127
            if (r10 == r6) goto L_0x00df
            if (r10 == r5) goto L_0x009b
            if (r10 == r4) goto L_0x004c
            goto L_0x008c
        L_0x0032:
            super.cca_continue(r9, r10)
            int[] r0 = com.cardinalcommerce.p060a.values.C21312.configure
            int r10 = r10.ordinal()
            r10 = r0[r10]
            r0 = 99
            int r0 = r0 / 0
            if (r10 == r1) goto L_0x0127
            if (r10 == r2) goto L_0x0127
            if (r10 == r6) goto L_0x00df
            if (r10 == r5) goto L_0x009b
            if (r10 == r4) goto L_0x004c
            goto L_0x008c
        L_0x004c:
            com.cardinalcommerce.a.CardinalRenderType r10 = f3111d
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r0 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r3 = 10614(0x2976, float:1.4873E-41)
            r0.<init>((int) r3, (java.lang.Exception) r9)
            com.cardinalcommerce.a.setTypeface r9 = r8.f3115b
            char[] r9 = r9.CardinalUiType()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r4 = r0.Cardinal
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r0 = r0.init
            r10.configure(r4, r0, r9)
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r9 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r9.<init>(r3)
            com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse r10 = new com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r0 = com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode.ERROR
            r10.<init>(r0, r9)
            com.cardinalcommerce.a.CardinalError r9 = r8.f3114a
            r9.cca_continue(r10, r7)
            int r9 = f3113f
            r10 = r9 ^ 2
            r9 = r9 & r2
            int r9 = r9 << r1
            int r10 = r10 + r9
            r9 = r10 & -1
            r10 = r10 | -1
            int r9 = r9 + r10
            int r10 = r9 % 128
            f3112e = r10
            int r9 = r9 % r2
        L_0x008c:
            int r9 = f3113f
            r10 = r9 | 16
            int r10 = r10 << r1
            r9 = r9 ^ 16
            int r10 = r10 - r9
            int r10 = r10 - r1
            int r9 = r10 % 128
            f3112e = r9
            int r10 = r10 % r2
            return
        L_0x009b:
            com.cardinalcommerce.a.CardinalRenderType r10 = f3111d
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r0 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r3 = 10613(0x2975, float:1.4872E-41)
            r0.<init>((int) r3, (java.lang.Exception) r9)
            com.cardinalcommerce.a.setTypeface r9 = r8.f3115b
            char[] r9 = r9.CardinalUiType()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r4 = r0.Cardinal
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r0 = r0.init
            r10.configure(r4, r0, r9)
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r9 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r9.<init>(r3)
            com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse r10 = new com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r0 = com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode.ERROR
            r10.<init>(r0, r9)
            com.cardinalcommerce.a.CardinalError r9 = r8.f3114a
            r9.cca_continue(r10, r7)
            int r9 = f3112e
            r10 = r9 & 19
            int r0 = ~r10
            r9 = r9 | 19
            r9 = r9 & r0
            int r10 = r10 << r1
            int r10 = -r10
            int r10 = -r10
            r0 = r9 & r10
            r9 = r9 | r10
            int r0 = r0 + r9
            int r9 = r0 % 128
            f3113f = r9
            int r0 = r0 % r2
            return
        L_0x00df:
            com.cardinalcommerce.a.CardinalRenderType r10 = f3111d
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r0 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r3 = 10615(0x2977, float:1.4875E-41)
            r0.<init>((int) r3, (java.lang.Exception) r9)
            com.cardinalcommerce.a.setTypeface r9 = r8.f3115b
            char[] r9 = r9.CardinalUiType()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r4 = r0.Cardinal
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r0 = r0.init
            r10.configure(r4, r0, r9)
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r9 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r9.<init>(r3)
            com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse r10 = new com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r0 = com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode.ERROR
            r10.<init>(r0, r9)
            com.cardinalcommerce.a.CardinalError r9 = r8.f3114a
            r9.cca_continue(r10, r7)
            int r9 = f3112e
            r10 = 65
            r0 = r9 ^ 65
            r3 = r9 & 65
            r0 = r0 | r3
            int r0 = r0 << r1
            r3 = r9 & -66
            int r9 = ~r9
            r9 = r9 & r10
            r9 = r9 | r3
            int r9 = -r9
            int r9 = ~r9
            int r0 = r0 - r9
            int r0 = r0 - r1
            int r9 = r0 % 128
            f3113f = r9
            int r0 = r0 % r2
            return
        L_0x0127:
            com.cardinalcommerce.a.CardinalRenderType r10 = f3111d
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r0 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r3 = 10612(0x2974, float:1.487E-41)
            r0.<init>((int) r3, (java.lang.Exception) r9)
            com.cardinalcommerce.a.setTypeface r9 = r8.f3115b
            char[] r9 = r9.CardinalUiType()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            int r4 = r0.Cardinal
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r0 = r0.init
            r10.configure(r4, r0, r9)
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r9 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r9.<init>(r3)
            com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse r10 = new com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r0 = com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode.ERROR
            r10.<init>(r0, r9)
            com.cardinalcommerce.a.CardinalError r9 = r8.f3114a
            r9.cca_continue(r10, r7)
            int r9 = f3112e
            r10 = r9 | 3
            int r10 = r10 << r1
            r9 = r9 ^ r6
            int r10 = r10 - r9
            int r9 = r10 % 128
            f3113f = r9
            int r10 = r10 % r2
            return
        L_0x0163:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.values.cca_continue(java.lang.Exception, com.cardinalcommerce.a.setMin):void");
    }
}
