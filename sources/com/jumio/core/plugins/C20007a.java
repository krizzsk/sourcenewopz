package com.jumio.core.plugins;

import com.jumio.core.util.ReflectionUtil;
import java.util.ArrayList;

/* renamed from: com.jumio.core.plugins.a */
/* compiled from: PluginRegistry */
public class C20007a {

    /* renamed from: a */
    public static final Object f54942a = new Object();

    /* renamed from: b */
    public static String f54943b = "com.jumio.core.extraction.linefinder.LineFinderPlugin";

    /* renamed from: c */
    public static String f54944c = "com.jumio.core.extraction.mrz.MrzPlugin";

    /* renamed from: d */
    public static String f54945d = "com.jumio.core.extraction.nfc.NfcPlugin";

    /* renamed from: e */
    public static String f54946e = "com.jumio.core.extraction.barcode.BarcodePlugin";

    /* renamed from: f */
    public static String f54947f = "com.jumio.core.extraction.barcode.vision.BarcodeVisionPlugin";

    /* renamed from: g */
    public static String f54948g = "com.jumio.core.extraction.facemanual.FaceManualPlugin";

    /* renamed from: h */
    public static String f54949h = "com.jumio.iproov.IproovPlugin";

    /* renamed from: i */
    public static String f54950i = "com.iproov.sdk.IProov";

    /* renamed from: j */
    public static String f54951j = "com.jumio.datadog.DataDogPlugin";

    /* renamed from: k */
    public static String f54952k = "com.datadog.android.Datadog";

    /* renamed from: l */
    public static String f54953l = "com.jumio.emulator.EmulatorPlugin";

    /* renamed from: com.jumio.core.plugins.a$a */
    /* compiled from: PluginRegistry */
    public static /* synthetic */ class C20008a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f54954a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f54955b;

        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(3:27|28|30)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(3:27|28|30)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0087 */
        static {
            /*
                com.jumio.core.plugins.a$b[] r0 = com.jumio.core.plugins.C20007a.C20009b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f54955b = r0
                r1 = 1
                com.jumio.core.plugins.a$b r2 = com.jumio.core.plugins.C20007a.C20009b.IPROOV     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f54955b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.jumio.core.plugins.a$b r3 = com.jumio.core.plugins.C20007a.C20009b.DATADOG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.jumio.core.plugins.a$c[] r2 = com.jumio.core.plugins.C20007a.C20010c.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f54954a = r2
                com.jumio.core.plugins.a$c r3 = com.jumio.core.plugins.C20007a.C20010c.MRZ     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f54954a     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.jumio.core.plugins.a$c r2 = com.jumio.core.plugins.C20007a.C20010c.NFC     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = f54954a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.jumio.core.plugins.a$c r1 = com.jumio.core.plugins.C20007a.C20010c.BARCODE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f54954a     // Catch:{ NoSuchFieldError -> 0x004e }
                com.jumio.core.plugins.a$c r1 = com.jumio.core.plugins.C20007a.C20010c.BARCODE_NATIVE     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f54954a     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.jumio.core.plugins.a$c r1 = com.jumio.core.plugins.C20007a.C20010c.LINEFINDER     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = f54954a     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.jumio.core.plugins.a$c r1 = com.jumio.core.plugins.C20007a.C20010c.MANUAL     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = f54954a     // Catch:{ NoSuchFieldError -> 0x006f }
                com.jumio.core.plugins.a$c r1 = com.jumio.core.plugins.C20007a.C20010c.FACE_IPROOV     // Catch:{ NoSuchFieldError -> 0x006f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                int[] r0 = f54954a     // Catch:{ NoSuchFieldError -> 0x007b }
                com.jumio.core.plugins.a$c r1 = com.jumio.core.plugins.C20007a.C20010c.FACE_MANUAL     // Catch:{ NoSuchFieldError -> 0x007b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                int[] r0 = f54954a     // Catch:{ NoSuchFieldError -> 0x0087 }
                com.jumio.core.plugins.a$c r1 = com.jumio.core.plugins.C20007a.C20010c.DATADOG     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                int[] r0 = f54954a     // Catch:{ NoSuchFieldError -> 0x0093 }
                com.jumio.core.plugins.a$c r1 = com.jumio.core.plugins.C20007a.C20010c.EMULATOR     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.plugins.C20007a.C20008a.<clinit>():void");
        }
    }

    /* renamed from: com.jumio.core.plugins.a$b */
    /* compiled from: PluginRegistry */
    public enum C20009b {
        IPROOV,
        DATADOG
    }

    /* renamed from: com.jumio.core.plugins.a$c */
    /* compiled from: PluginRegistry */
    public enum C20010c {
        MRZ(new C20009b[0]),
        NFC(new C20009b[0]),
        BARCODE(new C20009b[0]),
        BARCODE_NATIVE(new C20009b[0]),
        LINEFINDER(new C20009b[0]),
        MANUAL(new C20009b[0]),
        FACE_MANUAL(new C20009b[0]),
        FACE_IPROOV(C20009b.IPROOV),
        DATADOG(C20009b.DATADOG),
        EMULATOR(new C20009b[0]);
        

        /* renamed from: a */
        public final C20009b[] f54970a;

        /* access modifiers changed from: public */
        C20010c(C20009b... bVarArr) {
            this.f54970a = bVarArr;
        }
    }

    /* renamed from: a */
    public static String m39591a(C20010c cVar) {
        switch (C20008a.f54954a[cVar.ordinal()]) {
            case 1:
                return f54944c;
            case 2:
                return f54945d;
            case 3:
                return f54946e;
            case 4:
                return f54947f;
            case 5:
                return f54943b;
            case 6:
                return "com.jumio.core.extraction.manual.ManualPicturePlugin";
            case 7:
                return f54949h;
            case 8:
                return f54948g;
            case 9:
                return f54951j;
            case 10:
                return f54953l;
            default:
                return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|4|(3:6|7|8)|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0015 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends jumio.core.C21343c0> T m39594b(com.jumio.core.plugins.C20007a.C20010c r2) {
        /*
            java.lang.Object r0 = f54942a
            monitor-enter(r0)
            java.lang.String r2 = m39591a((com.jumio.core.plugins.C20007a.C20010c) r2)     // Catch:{ all -> 0x0017 }
            java.lang.Class r2 = com.jumio.core.util.ReflectionUtil.getClass(r2)     // Catch:{ all -> 0x0017 }
            r1 = 0
            if (r2 == 0) goto L_0x0015
            java.lang.Object r2 = r2.newInstance()     // Catch:{ all -> 0x0015 }
            jumio.core.c0 r2 = (jumio.core.C21343c0) r2     // Catch:{ all -> 0x0015 }
            r1 = r2
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return r1
        L_0x0017:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.plugins.C20007a.m39594b(com.jumio.core.plugins.a$c):jumio.core.c0");
    }

    /* renamed from: c */
    public static boolean m39595c(C20010c cVar) {
        boolean z;
        synchronized (f54942a) {
            z = ReflectionUtil.getClass(m39591a(cVar)) != null;
            if (cVar.f54970a.length != 0) {
                z &= m39593a(cVar.f54970a);
            }
        }
        return z;
    }

    /* renamed from: a */
    public static String m39590a(C20009b bVar) {
        int i = C20008a.f54955b[bVar.ordinal()];
        if (i == 1) {
            return f54950i;
        }
        if (i != 2) {
            return null;
        }
        return f54952k;
    }

    /* renamed from: a */
    public static ArrayList<String> m39592a() {
        ArrayList<String> arrayList;
        synchronized (f54942a) {
            arrayList = new ArrayList<>();
            C20010c cVar = C20010c.MRZ;
            if (m39595c(cVar)) {
                arrayList.add(cVar.name());
            }
            C20010c cVar2 = C20010c.NFC;
            if (m39595c(cVar2)) {
                arrayList.add(cVar2.name());
            }
            C20010c cVar3 = C20010c.BARCODE;
            if (m39595c(cVar3)) {
                arrayList.add(cVar3.name());
            }
            C20010c cVar4 = C20010c.BARCODE_NATIVE;
            if (m39595c(cVar4)) {
                arrayList.add(cVar4.name());
            }
            C20010c cVar5 = C20010c.LINEFINDER;
            if (m39595c(cVar5)) {
                arrayList.add(cVar5.name());
            }
            C20010c cVar6 = C20010c.MANUAL;
            if (m39595c(cVar6)) {
                arrayList.add(cVar6.name());
            }
            C20010c cVar7 = C20010c.FACE_MANUAL;
            if (m39595c(cVar7)) {
                arrayList.add(cVar7.name());
            }
            C20010c cVar8 = C20010c.FACE_IPROOV;
            if (m39595c(cVar8)) {
                arrayList.add(cVar8.name());
            }
            C20010c cVar9 = C20010c.DATADOG;
            if (m39595c(cVar9)) {
                arrayList.add(cVar9.name());
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m39593a(C20009b... bVarArr) {
        boolean z;
        synchronized (f54942a) {
            int length = bVarArr.length;
            z = true;
            for (int i = 0; i < length; i++) {
                z &= ReflectionUtil.getClass(m39590a(bVarArr[i])) != null;
            }
        }
        return z;
    }
}
