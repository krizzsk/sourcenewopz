package com.cardinalcommerce.p060a;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode;
import com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters;
import com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse;
import com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError;
import com.cardinalcommerce.cardinalmobilesdk.services.CardinalInitService;
import com.cardinalcommerce.cardinalmobilesdk.services.CardinalValidateReceiver;
import java.lang.ref.WeakReference;

/* renamed from: com.cardinalcommerce.a.init */
public class C2014init implements getWarnings {
    public static CardinalRenderType CardinalEnvironment = null;
    public static cca_continue CardinalError = null;

    /* renamed from: b */
    private static final Object f2593b = new Object();

    /* renamed from: c */
    private static int f2594c = 0;
    public static WeakReference<Context> cca_continue = null;
    public static String configure = null;

    /* renamed from: d */
    private static int f2595d = 1;
    public static CountDownTimer getInstance;
    public static C2014init init;
    public static boolean valueOf;
    public WeakReference<Activity> Cardinal;
    public WeakReference<Context> CardinalActionCode;
    public CardinalConfigurationParameters CardinalRenderType;

    /* renamed from: a */
    private boolean f2596a = true;
    public C1990configure cleanup;
    public String getSDKVersion;
    public CardinalValidateReceiver getWarnings;
    public CardinalInitService values;

    /* renamed from: a */
    static /* synthetic */ CountDownTimer m1912a() {
        int i = f2595d;
        int i2 = i & 3;
        int i3 = ((i | 3) & (~i2)) + (i2 << 1);
        f2594c = i3 % 128;
        int i4 = i3 % 2;
        CountDownTimer countDownTimer = getInstance;
        int i5 = f2594c;
        int i6 = ((i5 | 21) << 1) - (i5 ^ 21);
        f2595d = i6 % 128;
        int i7 = i6 % 2;
        return countDownTimer;
    }

    /* renamed from: a */
    static /* synthetic */ CountDownTimer m1913a(CountDownTimer countDownTimer) {
        int i = f2595d;
        int i2 = (i & 66) + (i | 66);
        int i3 = (i2 & -1) + (i2 | -1);
        f2594c = i3 % 128;
        int i4 = i3 % 2;
        getInstance = countDownTimer;
        int i5 = f2595d;
        int i6 = (i5 ^ 31) + ((i5 & 31) << 1);
        f2594c = i6 % 128;
        if ((i6 % 2 != 0 ? '=' : 'V') != '=') {
            return countDownTimer;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return countDownTimer;
    }

    static {
        int i = f2594c + 47;
        f2595d = i % 128;
        if (i % 2 == 0) {
            int i2 = 86 / 0;
        }
    }

    private C2014init() {
    }

    public static synchronized C2014init init() {
        C2014init init2;
        synchronized (C2014init.class) {
            if (init == null) {
                synchronized (f2593b) {
                    if (init == null) {
                        init = new C2014init();
                        CardinalError = cca_continue.New;
                        CardinalEnvironment = CardinalRenderType.cca_continue();
                    }
                }
            }
            init2 = init;
        }
        return init2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (r0 != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0065, code lost:
        r0 = new java.util.ArrayList();
        r1 = f2594c;
        r2 = r1 & 95;
        r1 = (r1 ^ 95) | r2;
        r3 = (r2 & r1) + (r1 | r2);
        f2595d = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007b, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        if (r0 != null) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.cardinalcommerce.shared.models.Warning> cca_continue() {
        /*
            int r0 = f2595d
            int r0 = r0 + 24
            int r0 = r0 + -1
            int r1 = r0 % 128
            f2594c = r1
            int r0 = r0 % 2
            r1 = 88
            if (r0 == 0) goto L_0x0013
            r0 = 49
            goto L_0x0015
        L_0x0013:
            r0 = 88
        L_0x0015:
            java.lang.String r2 = "Warnings accessed"
            java.lang.String r3 = "CardinalInit"
            if (r0 == r1) goto L_0x002f
            com.cardinalcommerce.a.CardinalRenderType r0 = CardinalEnvironment
            r0.init(r3, r2)
            com.cardinalcommerce.a.setProgress r0 = com.cardinalcommerce.p060a.setProgress.Cardinal()
            com.cardinalcommerce.a.setTextCursorDrawable r0 = r0.init
            r1 = 87
            int r1 = r1 / 0
            if (r0 == 0) goto L_0x0065
            goto L_0x003c
        L_0x002d:
            r0 = move-exception
            throw r0
        L_0x002f:
            com.cardinalcommerce.a.CardinalRenderType r0 = CardinalEnvironment
            r0.init(r3, r2)
            com.cardinalcommerce.a.setProgress r0 = com.cardinalcommerce.p060a.setProgress.Cardinal()
            com.cardinalcommerce.a.setTextCursorDrawable r0 = r0.init
            if (r0 == 0) goto L_0x0065
        L_0x003c:
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.List<com.cardinalcommerce.shared.models.Warning> r0 = r0.cca_continue
            r1.<init>(r0)
            int r0 = f2594c
            int r0 = r0 + 36
            r2 = r0 | -1
            int r2 = r2 << 1
            r0 = r0 ^ -1
            int r2 = r2 - r0
            int r0 = r2 % 128
            f2595d = r0
            int r2 = r2 % 2
            r0 = 23
            if (r2 != 0) goto L_0x005b
            r2 = 23
            goto L_0x005d
        L_0x005b:
            r2 = 93
        L_0x005d:
            if (r2 == r0) goto L_0x0060
            return r1
        L_0x0060:
            r0 = 0
            int r0 = r0.length     // Catch:{ all -> 0x0063 }
            return r1
        L_0x0063:
            r0 = move-exception
            throw r0
        L_0x0065:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = f2594c
            r2 = r1 & 95
            r1 = r1 ^ 95
            r1 = r1 | r2
            r3 = r2 & r1
            r1 = r1 | r2
            int r3 = r3 + r1
            int r1 = r3 % 128
            f2595d = r1
            int r3 = r3 % 2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.C2014init.cca_continue():java.util.List");
    }

    public static String getInstance() {
        int i = ((f2594c + 6) + 0) - 1;
        f2595d = i % 128;
        int i2 = i % 2;
        String str = setHeight.values;
        int i3 = f2594c;
        int i4 = i3 & 71;
        int i5 = -(-((i3 ^ 71) | i4));
        int i6 = (i4 & i5) + (i5 | i4);
        f2595d = i6 % 128;
        int i7 = i6 % 2;
        return str;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0033, code lost:
        if ((r6.CardinalRenderType.getUiType() == com.cardinalcommerce.cardinalmobilesdk.enums.CardinalUiType.NATIVE ? 11 : 'F') != 11) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
        if ((r0 == r2 ? '#' : 27) != '#') goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bb, code lost:
        if (r7.isEmpty() == false) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c4, code lost:
        if (r7.isEmpty() == false) goto L_0x00c6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void init(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = f2595d
            r1 = r0 & 75
            r0 = r0 ^ 75
            r0 = r0 | r1
            int r0 = -r0
            int r0 = -r0
            r2 = r1 ^ r0
            r0 = r0 & r1
            r1 = 1
            int r0 = r0 << r1
            int r2 = r2 + r0
            int r0 = r2 % 128
            f2594c = r0
            int r2 = r2 % 2
            r0 = 21
            if (r2 == 0) goto L_0x001c
            r2 = 21
            goto L_0x001e
        L_0x001c:
            r2 = 49
        L_0x001e:
            r3 = 0
            r4 = 0
            if (r2 == r0) goto L_0x0036
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters r0 = r6.CardinalRenderType
            com.cardinalcommerce.cardinalmobilesdk.enums.CardinalUiType r0 = r0.getUiType()
            com.cardinalcommerce.cardinalmobilesdk.enums.CardinalUiType r2 = com.cardinalcommerce.cardinalmobilesdk.enums.CardinalUiType.NATIVE
            r5 = 11
            if (r0 != r2) goto L_0x0031
            r0 = 11
            goto L_0x0033
        L_0x0031:
            r0 = 70
        L_0x0033:
            if (r0 == r5) goto L_0x004b
            goto L_0x0094
        L_0x0036:
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters r0 = r6.CardinalRenderType
            com.cardinalcommerce.cardinalmobilesdk.enums.CardinalUiType r0 = r0.getUiType()
            com.cardinalcommerce.cardinalmobilesdk.enums.CardinalUiType r2 = com.cardinalcommerce.cardinalmobilesdk.enums.CardinalUiType.NATIVE
            int r5 = r4.length     // Catch:{ all -> 0x0197 }
            r5 = 35
            if (r0 != r2) goto L_0x0046
            r0 = 35
            goto L_0x0048
        L_0x0046:
            r0 = 27
        L_0x0048:
            if (r0 == r5) goto L_0x004b
            goto L_0x0094
        L_0x004b:
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters r0 = r6.CardinalRenderType
            org.json.JSONArray r0 = r0.getRenderType()
            java.lang.String r0 = r0.toString()
            com.cardinalcommerce.cardinalmobilesdk.enums.CardinalRenderType r2 = com.cardinalcommerce.cardinalmobilesdk.enums.CardinalRenderType.HTML
            java.lang.String r2 = r2.toString()
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto L_0x0094
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r7 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r0 = 10207(0x27df, float:1.4303E-41)
            r7.<init>(r0)
            com.cardinalcommerce.a.CardinalRenderType r0 = CardinalEnvironment
            int r2 = r7.Cardinal
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r5 = r7.init
            r0.configure(r2, r5, r4)
            r6.Cardinal((com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError) r7)
            int r7 = f2595d
            r0 = r7 & 111(0x6f, float:1.56E-43)
            r7 = r7 | 111(0x6f, float:1.56E-43)
            r2 = r0 & r7
            r7 = r7 | r0
            int r2 = r2 + r7
            int r7 = r2 % 128
            f2594c = r7
            int r2 = r2 % 2
            if (r2 == 0) goto L_0x008b
            r1 = 0
        L_0x008b:
            if (r1 == 0) goto L_0x008e
            return
        L_0x008e:
            super.hashCode()     // Catch:{ all -> 0x0092 }
            return
        L_0x0092:
            r7 = move-exception
            throw r7
        L_0x0094:
            if (r7 == 0) goto L_0x0098
            r0 = 1
            goto L_0x0099
        L_0x0098:
            r0 = 0
        L_0x0099:
            if (r0 == r1) goto L_0x009d
            goto L_0x0166
        L_0x009d:
            int r0 = f2595d
            int r0 = r0 + 109
            int r0 = r0 - r1
            int r0 = r0 - r1
            int r2 = r0 % 128
            f2594c = r2
            int r0 = r0 % 2
            r2 = 42
            if (r0 == 0) goto L_0x00b0
            r0 = 22
            goto L_0x00b2
        L_0x00b0:
            r0 = 42
        L_0x00b2:
            if (r0 == r2) goto L_0x00c0
            boolean r0 = r7.isEmpty()
            r2 = 9
            int r2 = r2 / r3
            if (r0 != 0) goto L_0x0166
            goto L_0x00c6
        L_0x00be:
            r7 = move-exception
            throw r7
        L_0x00c0:
            boolean r0 = r7.isEmpty()
            if (r0 != 0) goto L_0x0166
        L_0x00c6:
            r6.getSDKVersion = r7
            com.cardinalcommerce.a.cleanup r0 = new com.cardinalcommerce.a.cleanup     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r2 = configure     // Catch:{ JSONException -> 0x0136 }
            r0.<init>(r6, r7, r2)     // Catch:{ JSONException -> 0x0136 }
            com.cardinalcommerce.a.cca_continue r7 = CardinalError     // Catch:{ JSONException -> 0x0136 }
            com.cardinalcommerce.a.cca_continue r2 = com.cardinalcommerce.p060a.cca_continue.InitStarted     // Catch:{ JSONException -> 0x0136 }
            r5 = 4
            if (r7 != r2) goto L_0x00d8
            r7 = 4
            goto L_0x00da
        L_0x00d8:
            r7 = 44
        L_0x00da:
            if (r7 == r5) goto L_0x00dd
            goto L_0x0108
        L_0x00dd:
            int r7 = f2595d
            r2 = r7 & 113(0x71, float:1.58E-43)
            r7 = r7 ^ 113(0x71, float:1.58E-43)
            r7 = r7 | r2
            int r7 = -r7
            int r7 = -r7
            r5 = r2 & r7
            r7 = r7 | r2
            int r5 = r5 + r7
            int r7 = r5 % 128
            f2594c = r7
            int r5 = r5 % 2
            com.cardinalcommerce.a.CardinalRenderType r7 = CardinalEnvironment     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r2 = "CardinalInit"
            java.lang.String r5 = "Previous centinel API init task cancelled"
            r7.init(r2, r5)     // Catch:{ JSONException -> 0x0136 }
            java.util.concurrent.ExecutorService r7 = r0.getSDKVersion     // Catch:{ JSONException -> 0x0136 }
            r7.shutdownNow()     // Catch:{ JSONException -> 0x0136 }
            int r7 = f2594c
            int r7 = r7 + 45
            int r2 = r7 % 128
            f2595d = r2
            int r7 = r7 % 2
        L_0x0108:
            r0.configure()     // Catch:{ JSONException -> 0x0136 }
            java.util.concurrent.ExecutorService r7 = r0.getSDKVersion     // Catch:{ JSONException -> 0x0136 }
            com.cardinalcommerce.a.setKeyListener$4 r2 = new com.cardinalcommerce.a.setKeyListener$4     // Catch:{ JSONException -> 0x0136 }
            r2.<init>()     // Catch:{ JSONException -> 0x0136 }
            r7.execute(r2)     // Catch:{ JSONException -> 0x0136 }
            com.cardinalcommerce.a.cca_continue r7 = com.cardinalcommerce.p060a.cca_continue.InitStarted     // Catch:{ JSONException -> 0x0136 }
            CardinalError = r7     // Catch:{ JSONException -> 0x0136 }
            int r7 = f2594c
            r0 = r7 & 96
            r7 = r7 | 96
            int r0 = r0 + r7
            r7 = r0 & -1
            r0 = r0 | -1
            int r7 = r7 + r0
            int r0 = r7 % 128
            f2595d = r0
            int r7 = r7 % 2
            if (r7 != 0) goto L_0x012e
            goto L_0x012f
        L_0x012e:
            r3 = 1
        L_0x012f:
            if (r3 == r1) goto L_0x0135
            int r7 = r4.length     // Catch:{ all -> 0x0133 }
            return
        L_0x0133:
            r7 = move-exception
            throw r7
        L_0x0135:
            return
        L_0x0136:
            r7 = move-exception
            com.cardinalcommerce.a.CardinalRenderType r0 = CardinalEnvironment
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r1 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Cardinal Init Error"
            r2.<init>(r3)
            java.lang.String r7 = r7.getLocalizedMessage()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r2 = 10205(0x27dd, float:1.43E-41)
            r1.<init>((int) r2, (java.lang.String) r7)
            int r7 = r1.Cardinal
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r1 = r1.init
            r0.configure(r7, r1, r4)
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r7 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r7.<init>(r2)
            r6.Cardinal((com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError) r7)
            return
        L_0x0166:
            com.cardinalcommerce.a.CardinalRenderType r7 = CardinalEnvironment
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r0 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r2 = 10202(0x27da, float:1.4296E-41)
            r0.<init>(r2)
            int r3 = r0.Cardinal
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r0 = r0.init
            r7.configure(r3, r0, r4)
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r7 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r7.<init>(r2)
            r6.Cardinal((com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError) r7)
            int r7 = f2594c
            r0 = r7 & -76
            int r2 = ~r7
            r2 = r2 & 75
            r0 = r0 | r2
            r7 = r7 & 75
            int r7 = r7 << r1
            int r7 = ~r7
            int r0 = r0 - r7
            int r0 = r0 - r1
            int r7 = r0 % 128
            f2595d = r7
            int r0 = r0 % 2
            return
        L_0x0197:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.C2014init.init(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        if (r6.values != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r0 != null) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Cardinal(com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError r7) {
        /*
            r6 = this;
            int r0 = f2594c
            int r0 = r0 + 31
            r1 = 1
            int r0 = r0 - r1
            int r0 = r0 - r1
            int r2 = r0 % 128
            f2595d = r2
            int r0 = r0 % 2
            r2 = 0
            if (r0 != 0) goto L_0x0012
            r0 = 0
            goto L_0x0013
        L_0x0012:
            r0 = 1
        L_0x0013:
            r3 = 0
            if (r0 == r1) goto L_0x001e
            com.cardinalcommerce.cardinalmobilesdk.services.CardinalInitService r0 = r6.values
            int r4 = r3.length     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0097
            goto L_0x0022
        L_0x001c:
            r7 = move-exception
            throw r7
        L_0x001e:
            com.cardinalcommerce.cardinalmobilesdk.services.CardinalInitService r0 = r6.values
            if (r0 == 0) goto L_0x0097
        L_0x0022:
            com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse r0 = new com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r4 = com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode.ERROR
            r0.<init>(r4, r7)
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters r7 = r6.CardinalRenderType
            r4 = 26
            if (r7 == 0) goto L_0x0032
            r7 = 36
            goto L_0x0034
        L_0x0032:
            r7 = 26
        L_0x0034:
            if (r7 == r4) goto L_0x0064
            int r7 = f2595d
            r4 = r7 & 37
            r7 = r7 | 37
            int r4 = r4 + r7
            int r7 = r4 % 128
            f2594c = r7
            int r4 = r4 % 2
            com.cardinalcommerce.a.CardinalRenderType r7 = CardinalEnvironment
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters r4 = r6.CardinalRenderType
            com.cardinalcommerce.cardinalmobilesdk.enums.CardinalEnvironment r4 = r4.getEnvironment()
            java.lang.String r4 = r4.toString()
            r7.configure(r4)
            int r7 = f2595d
            int r7 = r7 + 19
            int r7 = r7 - r1
            r4 = r7 | -1
            int r4 = r4 << r1
            r7 = r7 ^ -1
            int r4 = r4 - r7
            int r7 = r4 % 128
            f2594c = r7
            int r4 = r4 % 2
            goto L_0x0080
        L_0x0064:
            com.cardinalcommerce.a.CardinalRenderType r7 = CardinalEnvironment
            java.lang.String r4 = "CardinalInit"
            java.lang.String r5 = "ConfigParameters are null"
            r7.init(r4, r5)
            int r7 = f2595d
            r4 = r7 | 6
            int r4 = r4 << r1
            r7 = r7 ^ 6
            int r4 = r4 - r7
            r7 = r4 & -1
            r4 = r4 | -1
            int r7 = r7 + r4
            int r4 = r7 % 128
            f2594c = r4
            int r7 = r7 % 2
        L_0x0080:
            com.cardinalcommerce.cardinalmobilesdk.services.CardinalInitService r7 = r6.values
            java.lang.String r4 = ""
            r7.onValidated(r0, r4)
            int r7 = f2595d
            r0 = r7 & 93
            int r4 = ~r0
            r7 = r7 | 93
            r7 = r7 & r4
            int r0 = r0 << r1
            int r7 = r7 + r0
            int r0 = r7 % 128
            f2594c = r0
            int r7 = r7 % 2
        L_0x0097:
            int r7 = f2595d
            r0 = r7 ^ 8
            r7 = r7 & 8
            int r7 = r7 << r1
            int r0 = r0 + r7
            r7 = r0 & -1
            r0 = r0 | -1
            int r7 = r7 + r0
            int r0 = r7 % 128
            f2594c = r0
            int r7 = r7 % 2
            if (r7 == 0) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r2 = 1
        L_0x00ae:
            if (r2 == r1) goto L_0x00b6
            super.hashCode()     // Catch:{ all -> 0x00b4 }
            return
        L_0x00b4:
            r7 = move-exception
            throw r7
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.C2014init.Cardinal(com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError):void");
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.os.CountDownTimer] */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r5.getWarnings == null) == false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        if ((r0 != null ? kotlin.text.Typography.amp : 0) == '&') goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d2, code lost:
        throw new com.cardinalcommerce.shared.models.exceptions.InvalidInputException("InvalidInputException", new java.lang.Throwable("Null CardinalValidateReceiver received on cca_continue"));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void getInstance(com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r6, com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError r7, android.content.Context r8, java.lang.String r9) throws com.cardinalcommerce.shared.models.exceptions.InvalidInputException {
        /*
            r5 = this;
            int r0 = f2595d
            r1 = r0 & 47
            int r2 = ~r1
            r0 = r0 | 47
            r0 = r0 & r2
            r2 = 1
            int r1 = r1 << r2
            int r0 = r0 + r1
            int r1 = r0 % 128
            f2594c = r1
            int r0 = r0 % 2
            r1 = 20
            if (r0 == 0) goto L_0x0018
            r0 = 20
            goto L_0x001a
        L_0x0018:
            r0 = 63
        L_0x001a:
            r3 = 0
            r4 = 0
            if (r0 == r1) goto L_0x0028
            com.cardinalcommerce.cardinalmobilesdk.services.CardinalValidateReceiver r0 = r5.getWarnings
            if (r0 == 0) goto L_0x0024
            r0 = 0
            goto L_0x0025
        L_0x0024:
            r0 = 1
        L_0x0025:
            if (r0 != 0) goto L_0x00c4
            goto L_0x0035
        L_0x0028:
            com.cardinalcommerce.cardinalmobilesdk.services.CardinalValidateReceiver r0 = r5.getWarnings
            int r1 = r4.length     // Catch:{ all -> 0x00d3 }
            r1 = 38
            if (r0 == 0) goto L_0x0032
            r0 = 38
            goto L_0x0033
        L_0x0032:
            r0 = 0
        L_0x0033:
            if (r0 != r1) goto L_0x00c4
        L_0x0035:
            int r0 = f2595d
            r1 = r0 & 33
            r0 = r0 ^ 33
            r0 = r0 | r1
            int r1 = r1 + r0
            int r0 = r1 % 128
            f2594c = r0
            int r1 = r1 % 2
            android.os.CountDownTimer r0 = getInstance
            r1 = 97
            if (r0 == 0) goto L_0x004c
            r0 = 21
            goto L_0x004e
        L_0x004c:
            r0 = 97
        L_0x004e:
            if (r0 == r1) goto L_0x0082
            int r0 = f2594c
            r1 = r0 | 4
            int r1 = r1 << r2
            r0 = r0 ^ 4
            int r1 = r1 - r0
            r0 = r1 & -1
            r1 = r1 | -1
            int r0 = r0 + r1
            int r1 = r0 % 128
            f2595d = r1
            int r0 = r0 % 2
            r1 = 26
            if (r0 != 0) goto L_0x006a
            r0 = 19
            goto L_0x006c
        L_0x006a:
            r0 = 26
        L_0x006c:
            if (r0 == r1) goto L_0x007b
            android.os.CountDownTimer r0 = getInstance
            r0.cancel()
            getInstance = r4
            r0 = 70
            int r0 = r0 / r3
            goto L_0x0082
        L_0x0079:
            r6 = move-exception
            throw r6
        L_0x007b:
            android.os.CountDownTimer r0 = getInstance
            r0.cancel()
            getInstance = r4
        L_0x0082:
            com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse r0 = new com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse
            r0.<init>(r6, r7)
            com.cardinalcommerce.a.CardinalRenderType r6 = CardinalEnvironment
            com.cardinalcommerce.a.configure r1 = r5.cleanup
            java.lang.String r1 = r1.getInstance
            int r3 = r7.Cardinal
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r7 = r7.init
            r6.configure(r3, r7, r1)
            com.cardinalcommerce.a.CardinalRenderType r6 = CardinalEnvironment
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters r7 = r5.CardinalRenderType
            com.cardinalcommerce.cardinalmobilesdk.enums.CardinalEnvironment r7 = r7.getEnvironment()
            java.lang.String r7 = r7.toString()
            r6.configure(r7)
            com.cardinalcommerce.cardinalmobilesdk.services.CardinalValidateReceiver r6 = r5.getWarnings
            r6.onValidated(r8, r0, r9)
            com.cardinalcommerce.a.cca_continue r6 = com.cardinalcommerce.p060a.cca_continue.Validated
            CardinalError = r6
            int r6 = f2594c
            r7 = r6 & 35
            r6 = r6 | 35
            int r6 = -r6
            int r6 = -r6
            r8 = r7 | r6
            int r8 = r8 << r2
            r6 = r6 ^ r7
            int r8 = r8 - r6
            int r6 = r8 % 128
            f2595d = r6
            int r8 = r8 % 2
            return
        L_0x00c4:
            java.lang.Throwable r6 = new java.lang.Throwable
            java.lang.String r7 = "Null CardinalValidateReceiver received on cca_continue"
            r6.<init>(r7)
            com.cardinalcommerce.shared.models.exceptions.InvalidInputException r7 = new com.cardinalcommerce.shared.models.exceptions.InvalidInputException
            java.lang.String r8 = "InvalidInputException"
            r7.<init>(r8, r6)
            throw r7
        L_0x00d3:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.C2014init.getInstance(com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode, com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError, android.content.Context, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        if ((r0 == null) != false) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
        if ((r7.cleanup == null) != true) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0056, code lost:
        if ((!r7.cleanup.getInstance.equals(r8.getInstance)) != false) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006f, code lost:
        if ((r0 ? '3' : 1) != '3') goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0099, code lost:
        if (r0 != ')') goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00aa, code lost:
        if ((!r0 ? '6' : 'J') != 'J') goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00dc, code lost:
        r7.cleanup = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00e6, code lost:
        if (r7.CardinalRenderType.isEnableDFSync() != false) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00e8, code lost:
        r0 = 14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00eb, code lost:
        r0 = 21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00ed, code lost:
        if (r0 == 21) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00ef, code lost:
        r0 = f2595d;
        r1 = ((((r0 ^ 101) | (r0 & 101)) << 1) - (~(-(((~r0) & 101) | (r0 & -102))))) - 1;
        f2594c = r1 % 128;
        r1 = r1 % 2;
        m1914a(r8);
        r8 = f2594c;
        r0 = ((r8 ^ 59) | (r8 & 59)) << 1;
        r8 = -(((~r8) & 59) | (r8 & -60));
        r1 = (r0 & r8) + (r8 | r0);
        f2595d = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r8 = new com.cardinalcommerce.p060a.getSDKVersion(r7, r7.cleanup, r7.CardinalRenderType.getRequestTimeout());
        r8.configure();
        r8.getSDKVersion.execute(new com.cardinalcommerce.p060a.setKeyListener.C20574(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x013d, code lost:
        r8 = f2595d;
        r0 = (r8 & -110) | ((~r8) & 109);
        r8 = (r8 & 109) << 1;
        r1 = (r0 ^ r8) + ((r8 & r0) << 1);
        f2594c = r1 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0153, code lost:
        if ((r1 % 2) == 0) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0156, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0157, code lost:
        if (r4 == true) goto L_0x015d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        r8 = r3.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x015a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x015d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x015e, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x015f, code lost:
        r0 = CardinalEnvironment;
        r1 = new com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError(10217, (java.lang.Exception) r8);
        r0.configure(java.lang.String.valueOf(r1.Cardinal), r1.init, r7.cleanup.getInstance);
        cca_continue(new com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError(10215));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0181, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Cardinal(com.cardinalcommerce.p060a.C1990configure r8) {
        /*
            r7 = this;
            int r0 = f2594c
            r1 = r0 & 39
            r0 = r0 ^ 39
            r0 = r0 | r1
            int r1 = r1 + r0
            int r0 = r1 % 128
            f2595d = r0
            int r1 = r1 % 2
            r0 = 60
            r2 = 34
            if (r1 != 0) goto L_0x0017
            r1 = 34
            goto L_0x0019
        L_0x0017:
            r1 = 60
        L_0x0019:
            r3 = 0
            r4 = 0
            r5 = 1
            if (r1 == r0) goto L_0x002c
            com.cardinalcommerce.a.configure r0 = r7.cleanup
            int r1 = r3.length     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x0025
            r0 = 0
            goto L_0x0026
        L_0x0025:
            r0 = 1
        L_0x0026:
            if (r0 == 0) goto L_0x0035
            goto L_0x00dc
        L_0x002a:
            r8 = move-exception
            throw r8
        L_0x002c:
            com.cardinalcommerce.a.configure r0 = r7.cleanup
            if (r0 == 0) goto L_0x0032
            r0 = 0
            goto L_0x0033
        L_0x0032:
            r0 = 1
        L_0x0033:
            if (r0 == r5) goto L_0x00dc
        L_0x0035:
            int r0 = f2595d
            int r0 = r0 + 40
            int r0 = r0 - r5
            int r1 = r0 % 128
            f2594c = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0044
            r0 = 0
            goto L_0x0045
        L_0x0044:
            r0 = 1
        L_0x0045:
            if (r0 == 0) goto L_0x005a
            com.cardinalcommerce.a.configure r0 = r7.cleanup
            java.lang.String r0 = r0.getInstance
            java.lang.String r1 = r8.getInstance
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0055
            r0 = 0
            goto L_0x0056
        L_0x0055:
            r0 = 1
        L_0x0056:
            if (r0 == 0) goto L_0x0072
            goto L_0x00dc
        L_0x005a:
            com.cardinalcommerce.a.configure r0 = r7.cleanup
            java.lang.String r0 = r0.getInstance
            java.lang.String r1 = r8.getInstance
            boolean r0 = r0.equals(r1)
            super.hashCode()     // Catch:{ all -> 0x00da }
            r1 = 51
            if (r0 == 0) goto L_0x006e
            r0 = 51
            goto L_0x006f
        L_0x006e:
            r0 = 1
        L_0x006f:
            if (r0 == r1) goto L_0x0072
            goto L_0x00dc
        L_0x0072:
            int r0 = f2594c
            r1 = r0 ^ 59
            r0 = r0 & 59
            int r0 = r0 << r5
            int r0 = -r0
            int r0 = -r0
            r6 = r1 | r0
            int r6 = r6 << r5
            r0 = r0 ^ r1
            int r6 = r6 - r0
            int r0 = r6 % 128
            f2595d = r0
            int r6 = r6 % 2
            r0 = 36
            if (r6 != 0) goto L_0x008d
            r1 = 34
            goto L_0x008f
        L_0x008d:
            r1 = 36
        L_0x008f:
            if (r1 == r2) goto L_0x009c
            boolean r1 = r7.f2596a
            r2 = 41
            if (r1 != 0) goto L_0x0099
            r0 = 41
        L_0x0099:
            if (r0 == r2) goto L_0x00dc
            goto L_0x00ad
        L_0x009c:
            boolean r0 = r7.f2596a
            super.hashCode()     // Catch:{ all -> 0x00d8 }
            r1 = 74
            if (r0 != 0) goto L_0x00a8
            r0 = 54
            goto L_0x00aa
        L_0x00a8:
            r0 = 74
        L_0x00aa:
            if (r0 == r1) goto L_0x00ad
            goto L_0x00dc
        L_0x00ad:
            com.cardinalcommerce.a.configure r8 = r7.cleanup
            r7.m1914a((com.cardinalcommerce.p060a.C1990configure) r8)
            int r8 = f2594c
            r0 = r8 ^ 83
            r1 = r8 & 83
            r0 = r0 | r1
            int r0 = r0 << r5
            int r1 = ~r1
            r8 = r8 | 83
            r8 = r8 & r1
            int r8 = -r8
            r1 = r0 | r8
            int r1 = r1 << r5
            r8 = r8 ^ r0
            int r1 = r1 - r8
            int r8 = r1 % 128
            f2595d = r8
            int r1 = r1 % 2
            if (r1 != 0) goto L_0x00ce
            r8 = 0
            goto L_0x00cf
        L_0x00ce:
            r8 = 1
        L_0x00cf:
            if (r8 == r5) goto L_0x00d7
            r8 = 94
            int r8 = r8 / r4
            return
        L_0x00d5:
            r8 = move-exception
            throw r8
        L_0x00d7:
            return
        L_0x00d8:
            r8 = move-exception
            throw r8
        L_0x00da:
            r8 = move-exception
            throw r8
        L_0x00dc:
            r7.cleanup = r8
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters r0 = r7.CardinalRenderType
            boolean r0 = r0.isEnableDFSync()
            r1 = 21
            if (r0 != 0) goto L_0x00eb
            r0 = 14
            goto L_0x00ed
        L_0x00eb:
            r0 = 21
        L_0x00ed:
            if (r0 == r1) goto L_0x0123
            int r0 = f2595d
            r1 = r0 ^ 101(0x65, float:1.42E-43)
            r2 = r0 & 101(0x65, float:1.42E-43)
            r1 = r1 | r2
            int r1 = r1 << r5
            r2 = r0 & -102(0xffffffffffffff9a, float:NaN)
            int r0 = ~r0
            r0 = r0 & 101(0x65, float:1.42E-43)
            r0 = r0 | r2
            int r0 = -r0
            int r0 = ~r0
            int r1 = r1 - r0
            int r1 = r1 - r5
            int r0 = r1 % 128
            f2594c = r0
            int r1 = r1 % 2
            r7.m1914a((com.cardinalcommerce.p060a.C1990configure) r8)
            int r8 = f2594c
            r0 = r8 ^ 59
            r1 = r8 & 59
            r0 = r0 | r1
            int r0 = r0 << r5
            r1 = r8 & -60
            int r8 = ~r8
            r8 = r8 & 59
            r8 = r8 | r1
            int r8 = -r8
            r1 = r0 & r8
            r8 = r8 | r0
            int r1 = r1 + r8
            int r8 = r1 % 128
            f2595d = r8
            int r1 = r1 % 2
        L_0x0123:
            com.cardinalcommerce.a.getSDKVersion r8 = new com.cardinalcommerce.a.getSDKVersion     // Catch:{ JSONException -> 0x015e }
            com.cardinalcommerce.a.configure r0 = r7.cleanup     // Catch:{ JSONException -> 0x015e }
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters r1 = r7.CardinalRenderType     // Catch:{ JSONException -> 0x015e }
            int r1 = r1.getRequestTimeout()     // Catch:{ JSONException -> 0x015e }
            r8.<init>(r7, r0, r1)     // Catch:{ JSONException -> 0x015e }
            r8.configure()     // Catch:{ JSONException -> 0x015e }
            java.util.concurrent.ExecutorService r0 = r8.getSDKVersion     // Catch:{ JSONException -> 0x015e }
            com.cardinalcommerce.a.setKeyListener$4 r1 = new com.cardinalcommerce.a.setKeyListener$4     // Catch:{ JSONException -> 0x015e }
            r1.<init>()     // Catch:{ JSONException -> 0x015e }
            r0.execute(r1)     // Catch:{ JSONException -> 0x015e }
            int r8 = f2595d
            r0 = r8 & -110(0xffffffffffffff92, float:NaN)
            int r1 = ~r8
            r1 = r1 & 109(0x6d, float:1.53E-43)
            r0 = r0 | r1
            r8 = r8 & 109(0x6d, float:1.53E-43)
            int r8 = r8 << r5
            r1 = r0 ^ r8
            r8 = r8 & r0
            int r8 = r8 << r5
            int r1 = r1 + r8
            int r8 = r1 % 128
            f2594c = r8
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x0156
            goto L_0x0157
        L_0x0156:
            r4 = 1
        L_0x0157:
            if (r4 == r5) goto L_0x015d
            int r8 = r3.length     // Catch:{ all -> 0x015b }
            return
        L_0x015b:
            r8 = move-exception
            throw r8
        L_0x015d:
            return
        L_0x015e:
            r8 = move-exception
            com.cardinalcommerce.a.CardinalRenderType r0 = CardinalEnvironment
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r1 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r2 = 10217(0x27e9, float:1.4317E-41)
            r1.<init>((int) r2, (java.lang.Exception) r8)
            com.cardinalcommerce.a.configure r8 = r7.cleanup
            java.lang.String r8 = r8.getInstance
            int r2 = r1.Cardinal
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r1 = r1.init
            r0.configure(r2, r1, r8)
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r8 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r0 = 10215(0x27e7, float:1.4314E-41)
            r8.<init>(r0)
            r7.cca_continue(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.C2014init.Cardinal(com.cardinalcommerce.a.configure):void");
    }

    /* renamed from: a */
    private void m1914a(C1990configure configure2) {
        int i = (f2594c + 94) - 1;
        f2595d = i % 128;
        if ((i % 2 == 0 ? '6' : '!') != '!') {
            CardinalEnvironment.init("CardinalInit", "Init completed", configure2.getInstance);
            CardinalError = cca_continue.InitCompleted;
            CardinalEnvironment.configure(this.CardinalRenderType.getEnvironment().toString());
            this.values.onSetupCompleted(configure2.getInstance);
            Object obj = null;
            super.hashCode();
            return;
        }
        CardinalEnvironment.init("CardinalInit", "Init completed", configure2.getInstance);
        CardinalError = cca_continue.InitCompleted;
        CardinalEnvironment.configure(this.CardinalRenderType.getEnvironment().toString());
        this.values.onSetupCompleted(configure2.getInstance);
    }

    public final void getInstance(CardinalError cardinalError) {
        boolean z = true;
        this.f2596a = true;
        ValidateResponse validateResponse = new ValidateResponse(CardinalActionCode.ERROR, cardinalError);
        CardinalEnvironment.configure(this.CardinalRenderType.getEnvironment().toString());
        String str = null;
        this.values.onValidated(validateResponse, str);
        int i = f2594c;
        int i2 = (((i & -56) | ((~i) & 55)) - (~((i & 55) << 1))) - 1;
        f2595d = i2 % 128;
        if (i2 % 2 == 0) {
            z = false;
        }
        if (!z) {
            super.hashCode();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        if ((r2) != false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        if ((r5.CardinalRenderType.isEnableDFSync() ? (char) 8 : 0) != 0) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Cardinal() {
        /*
            r5 = this;
            int r0 = f2594c
            r1 = r0 & 47
            r0 = r0 ^ 47
            r0 = r0 | r1
            r2 = r1 & r0
            r0 = r0 | r1
            int r2 = r2 + r0
            int r0 = r2 % 128
            f2595d = r0
            int r2 = r2 % 2
            r0 = 0
            r1 = 1
            if (r2 != 0) goto L_0x0017
            r2 = 1
            goto L_0x0018
        L_0x0017:
            r2 = 0
        L_0x0018:
            r3 = 0
            if (r2 == 0) goto L_0x002c
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters r2 = r5.CardinalRenderType
            boolean r2 = r2.isEnableDFSync()
            int r4 = r3.length     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x0026
            r2 = 1
            goto L_0x0027
        L_0x0026:
            r2 = 0
        L_0x0027:
            if (r2 == 0) goto L_0x0078
            goto L_0x003a
        L_0x002a:
            r0 = move-exception
            throw r0
        L_0x002c:
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters r2 = r5.CardinalRenderType
            boolean r2 = r2.isEnableDFSync()
            if (r2 == 0) goto L_0x0037
            r2 = 8
            goto L_0x0038
        L_0x0037:
            r2 = 0
        L_0x0038:
            if (r2 == 0) goto L_0x0078
        L_0x003a:
            int r2 = f2595d
            r4 = r2 | 108(0x6c, float:1.51E-43)
            int r4 = r4 << r1
            r2 = r2 ^ 108(0x6c, float:1.51E-43)
            int r4 = r4 - r2
            int r4 = r4 - r0
            int r4 = r4 - r1
            int r2 = r4 % 128
            f2594c = r2
            int r4 = r4 % 2
            r2 = 32
            if (r4 == 0) goto L_0x0051
            r4 = 32
            goto L_0x0053
        L_0x0051:
            r4 = 71
        L_0x0053:
            if (r4 == r2) goto L_0x005b
            com.cardinalcommerce.a.configure r2 = r5.cleanup
            r5.m1914a((com.cardinalcommerce.p060a.C1990configure) r2)
            goto L_0x0063
        L_0x005b:
            com.cardinalcommerce.a.configure r2 = r5.cleanup
            r5.m1914a((com.cardinalcommerce.p060a.C1990configure) r2)
            super.hashCode()     // Catch:{ all -> 0x0076 }
        L_0x0063:
            int r2 = f2595d
            r3 = r2 ^ 45
            r2 = r2 & 45
            int r2 = r2 << r1
            r4 = r3 ^ r2
            r2 = r2 & r3
            int r2 = r2 << r1
            int r4 = r4 + r2
            int r2 = r4 % 128
            f2594c = r2
            int r4 = r4 % 2
            goto L_0x0078
        L_0x0076:
            r0 = move-exception
            throw r0
        L_0x0078:
            r5.f2596a = r0
            int r0 = f2595d
            r2 = r0 & 23
            r0 = r0 ^ 23
            r0 = r0 | r2
            int r0 = -r0
            int r0 = -r0
            r3 = r2 | r0
            int r1 = r3 << 1
            r0 = r0 ^ r2
            int r1 = r1 - r0
            int r0 = r1 % 128
            f2594c = r0
            int r1 = r1 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.C2014init.Cardinal():void");
    }

    public final void cca_continue(CardinalError cardinalError) {
        int i = f2595d;
        int i2 = (i ^ 110) + ((i & 110) << 1);
        int i3 = ((i2 | -1) << 1) - (i2 ^ -1);
        f2594c = i3 % 128;
        int i4 = i3 % 2;
        if (this.CardinalRenderType.isEnableDFSync()) {
            this.f2596a = true;
            CardinalEnvironment.configure(String.valueOf(cardinalError.Cardinal), cardinalError.init, this.cleanup.getInstance);
            ValidateResponse validateResponse = new ValidateResponse(CardinalActionCode.ERROR, cardinalError);
            CardinalEnvironment.configure(this.CardinalRenderType.getEnvironment().toString());
            this.values.onValidated(validateResponse, (String) null);
            int i5 = f2594c + 84;
            int i6 = ((i5 | -1) << 1) - (i5 ^ -1);
            f2595d = i6 % 128;
            int i7 = i6 % 2;
        }
        int i8 = f2595d;
        int i9 = ((i8 | 37) << 1) - (i8 ^ 37);
        f2594c = i9 % 128;
        int i10 = i9 % 2;
    }

    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.CountDownTimer] */
    public final void init(ValidateResponse validateResponse, String str) {
        CardinalRenderType cardinalRenderType = CardinalEnvironment;
        StringBuilder sb = new StringBuilder("Stepup validated with action code: ");
        sb.append(validateResponse.getActionCode());
        cardinalRenderType.init("CardinalContinue", sb.toString(), this.cleanup.getInstance);
        ? r2 = 0;
        if ((getInstance != null ? 'V' : '@') != '@') {
            int i = f2595d + 49;
            f2594c = i % 128;
            if (!(i % 2 != 0)) {
                getInstance.cancel();
            } else {
                getInstance.cancel();
                int length = r2.length;
            }
            int i2 = ((f2595d + 36) - 0) - 1;
            f2594c = i2 % 128;
            int i3 = i2 % 2;
        }
        getInstance = r2;
        CardinalError = cca_continue.Validated;
        CardinalEnvironment.configure(this.CardinalRenderType.getEnvironment().toString());
        this.getWarnings.onValidated(this.CardinalActionCode.get(), validateResponse, str);
        int i4 = f2594c;
        int i5 = ((i4 | 51) << 1) - (i4 ^ 51);
        f2595d = i5 % 128;
        if (i5 % 2 == 0) {
            int i6 = 37 / 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0090, code lost:
        if ((r6 != 0 ? '^' : 'G') != '^') goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0098, code lost:
        if (r8 != false) goto L_0x009a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String configure(android.content.Context r14) {
        /*
            int r0 = f2595d
            r1 = r0 & 59
            r0 = r0 ^ 59
            r0 = r0 | r1
            int r0 = -r0
            int r0 = -r0
            r2 = r1 ^ r0
            r0 = r0 & r1
            r1 = 1
            int r0 = r0 << r1
            int r2 = r2 + r0
            int r0 = r2 % 128
            f2594c = r0
            int r2 = r2 % 2
            com.cardinalcommerce.a.setLines r0 = com.cardinalcommerce.p060a.setLines.init(r14)
            java.lang.String r2 = "SDKAppID"
            r3 = 0
            java.lang.String r4 = r0.cca_continue(r2, r3)
            java.lang.String r5 = "LastUpdatedTime"
            long r6 = r0.getInstance(r5)
            r8 = 0
            r9 = 0
            android.content.pm.PackageManager r11 = r14.getPackageManager()     // Catch:{ NameNotFoundException -> 0x004c }
            java.lang.String r14 = r14.getPackageName()     // Catch:{ NameNotFoundException -> 0x004c }
            android.content.pm.PackageInfo r14 = com.didi.sdk.apm.SystemUtils.getPackageInfo(r11, r14, r8)     // Catch:{ NameNotFoundException -> 0x004c }
            long r11 = r14.lastUpdateTime     // Catch:{ NameNotFoundException -> 0x004c }
            int r14 = f2595d
            r3 = r14 & 23
            int r13 = ~r3
            r14 = r14 | 23
            r14 = r14 & r13
            int r3 = r3 << r1
            r13 = r14 | r3
            int r13 = r13 << r1
            r14 = r14 ^ r3
            int r13 = r13 - r14
            int r14 = r13 % 128
            f2594c = r14
            int r13 = r13 % 2
            goto L_0x0061
        L_0x004c:
            com.cardinalcommerce.a.CardinalRenderType r14 = CardinalEnvironment
            com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError r11 = new com.cardinalcommerce.cardinalmobilesdk.cm.models.CardinalError
            r12 = 10220(0x27ec, float:1.4321E-41)
            r11.<init>(r12)
            int r12 = r11.Cardinal
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.lang.String r11 = r11.init
            r14.configure(r12, r11, r3)
            r11 = r9
        L_0x0061:
            r14 = 97
            if (r4 == 0) goto L_0x0068
            r3 = 22
            goto L_0x006a
        L_0x0068:
            r3 = 97
        L_0x006a:
            if (r3 == r14) goto L_0x00b8
            int r14 = f2594c
            r3 = r14 & 51
            int r13 = ~r3
            r14 = r14 | 51
            r14 = r14 & r13
            int r3 = r3 << r1
            int r3 = ~r3
            int r14 = r14 - r3
            int r14 = r14 - r1
            int r3 = r14 % 128
            f2595d = r3
            int r14 = r14 % 2
            if (r14 != 0) goto L_0x0082
            r14 = 0
            goto L_0x0083
        L_0x0082:
            r14 = 1
        L_0x0083:
            if (r14 == r1) goto L_0x0093
            r14 = 94
            int r3 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r3 == 0) goto L_0x008e
            r3 = 94
            goto L_0x0090
        L_0x008e:
            r3 = 71
        L_0x0090:
            if (r3 == r14) goto L_0x009a
            goto L_0x00b8
        L_0x0093:
            int r14 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r14 == 0) goto L_0x0098
            r8 = 1
        L_0x0098:
            if (r8 == 0) goto L_0x00b8
        L_0x009a:
            r14 = 86
            int r3 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r3 == 0) goto L_0x00a3
            r3 = 86
            goto L_0x00a5
        L_0x00a3:
            r3 = 74
        L_0x00a5:
            if (r3 == r14) goto L_0x00b8
            int r14 = f2594c
            r0 = r14 & 109(0x6d, float:1.53E-43)
            r14 = r14 ^ 109(0x6d, float:1.53E-43)
            r14 = r14 | r0
            int r14 = ~r14
            int r0 = r0 - r14
            int r0 = r0 - r1
            int r14 = r0 % 128
            f2595d = r14
            int r0 = r0 % 2
            return r4
        L_0x00b8:
            java.util.UUID r14 = java.util.UUID.randomUUID()
            java.lang.String r14 = r14.toString()
            r0.Cardinal(r2, r14)
            r0.configure(r5, r11)
            int r0 = f2594c
            r1 = r0 & 35
            r0 = r0 | 35
            int r1 = r1 + r0
            int r0 = r1 % 128
            f2595d = r0
            int r1 = r1 % 2
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.C2014init.configure(android.content.Context):java.lang.String");
    }

    /* renamed from: a */
    static /* synthetic */ void m1915a(C2014init init2) {
        Cardinal.getInstance();
        init2.getInstance(CardinalActionCode.TIMEOUT, new CardinalError(0), (Context) null, "");
        int i = f2595d;
        int i2 = i & 123;
        int i3 = (((i ^ 123) | i2) << 1) - ((i | 123) & (~i2));
        f2594c = i3 % 128;
        if ((i3 % 2 != 0 ? '\'' : 'P') != 'P') {
            int i4 = 2 / 0;
        }
    }
}
