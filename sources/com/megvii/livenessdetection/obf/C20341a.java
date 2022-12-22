package com.megvii.livenessdetection.obf;

import androidx.exifinterface.media.ExifInterface;
import com.didi.raven.config.RavenKey;
import com.megvii.livenessdetection.Detector;

/* renamed from: com.megvii.livenessdetection.obf.a */
public final class C20341a {

    /* renamed from: a */
    private StringBuilder f55794a = new StringBuilder();

    /* renamed from: b */
    private long f55795b = -1;

    /* renamed from: a */
    public final synchronized void mo165086a(Detector.DetectionType detectionType) {
        if (detectionType != null) {
            m40199b();
            StringBuilder sb = this.f55794a;
            String str = "";
            switch (C203421.f55797b[detectionType.ordinal()]) {
                case 1:
                    str = "N";
                    break;
                case 2:
                    str = "O";
                    break;
                case 3:
                    str = ExifInterface.LONGITUDE_EAST;
                    break;
                case 4:
                    str = "M";
                    break;
                case 5:
                    str = C16471q.f49113b;
                    break;
                case 6:
                    str = "L";
                    break;
                case 7:
                    str = "R";
                    break;
                case 8:
                    str = "P";
                    break;
                case 9:
                    str = "U";
                    break;
                case 10:
                    str = "D";
                    break;
                case 11:
                    str = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
                    break;
            }
            sb.append(str);
            this.f55794a.append("\n");
        }
    }

    /* renamed from: a */
    public final synchronized void mo165085a(Detector.DetectionFailedType detectionFailedType) {
        if (detectionFailedType != null) {
            m40199b();
            StringBuilder sb = this.f55794a;
            String str = "";
            switch (C203421.f55796a[detectionFailedType.ordinal()]) {
                case 1:
                    str = CampaignValue.f40469b;
                    break;
                case 2:
                    str = "b";
                    break;
                case 3:
                    str = RavenKey.TYPE;
                    break;
                case 4:
                    str = "m";
                    break;
                case 5:
                    str = "o";
                    break;
                case 6:
                    str = "l";
                    break;
                case 7:
                    str = "c";
                    break;
            }
            sb.append(str);
            this.f55794a.append("\n");
        }
    }

    /* renamed from: b */
    private void m40199b() {
        if (this.f55795b == -1) {
            this.f55795b = System.currentTimeMillis();
            this.f55794a.append(System.currentTimeMillis() / 1000);
            this.f55794a.append("\n");
        }
        this.f55794a.append(System.currentTimeMillis() - this.f55795b);
        this.f55794a.append(":");
    }

    /* renamed from: a */
    public final synchronized void mo165084a() {
        this.f55794a = new StringBuilder();
        this.f55795b = -1;
    }

    public final synchronized String toString() {
        return this.f55794a.toString();
    }

    /* renamed from: com.megvii.livenessdetection.obf.a$1 */
    static /* synthetic */ class C203421 {

        /* renamed from: a */
        static final /* synthetic */ int[] f55796a;

        /* renamed from: b */
        static final /* synthetic */ int[] f55797b;

        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|28|29|30|31|32|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|52) */
        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|28|29|30|31|32|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|52) */
        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|28|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|52) */
        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|52) */
        /* JADX WARNING: Can't wrap try/catch for region: R(43:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|52) */
        /* JADX WARNING: Can't wrap try/catch for region: R(44:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|52) */
        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|52) */
        /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0095 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x009f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00a9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00b3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00bd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00c7 */
        static {
            /*
                com.megvii.livenessdetection.Detector$DetectionType[] r0 = com.megvii.livenessdetection.Detector.DetectionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f55797b = r0
                r1 = 1
                com.megvii.livenessdetection.Detector$DetectionType r2 = com.megvii.livenessdetection.Detector.DetectionType.NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f55797b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.megvii.livenessdetection.Detector$DetectionType r3 = com.megvii.livenessdetection.Detector.DetectionType.DONE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f55797b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.megvii.livenessdetection.Detector$DetectionType r4 = com.megvii.livenessdetection.Detector.DetectionType.BLINK     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f55797b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.megvii.livenessdetection.Detector$DetectionType r5 = com.megvii.livenessdetection.Detector.DetectionType.MOUTH     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f55797b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.megvii.livenessdetection.Detector$DetectionType r6 = com.megvii.livenessdetection.Detector.DetectionType.POS_YAW     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = f55797b     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.megvii.livenessdetection.Detector$DetectionType r7 = com.megvii.livenessdetection.Detector.DetectionType.POS_YAW_LEFT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = f55797b     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.megvii.livenessdetection.Detector$DetectionType r8 = com.megvii.livenessdetection.Detector.DetectionType.POS_YAW_RIGHT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r7 = f55797b     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.megvii.livenessdetection.Detector$DetectionType r8 = com.megvii.livenessdetection.Detector.DetectionType.POS_PITCH     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r9 = 8
                r7[r8] = r9     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r7 = f55797b     // Catch:{ NoSuchFieldError -> 0x006c }
                com.megvii.livenessdetection.Detector$DetectionType r8 = com.megvii.livenessdetection.Detector.DetectionType.POS_PITCH_UP     // Catch:{ NoSuchFieldError -> 0x006c }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r9 = 9
                r7[r8] = r9     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r7 = f55797b     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.megvii.livenessdetection.Detector$DetectionType r8 = com.megvii.livenessdetection.Detector.DetectionType.POS_PITCH_DOWN     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r9 = 10
                r7[r8] = r9     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r7 = f55797b     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.megvii.livenessdetection.Detector$DetectionType r8 = com.megvii.livenessdetection.Detector.DetectionType.AIMLESS     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r9 = 11
                r7[r8] = r9     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                com.megvii.livenessdetection.Detector$DetectionFailedType[] r7 = com.megvii.livenessdetection.Detector.DetectionFailedType.values()
                int r7 = r7.length
                int[] r7 = new int[r7]
                f55796a = r7
                com.megvii.livenessdetection.Detector$DetectionFailedType r8 = com.megvii.livenessdetection.Detector.DetectionFailedType.NOTVIDEO     // Catch:{ NoSuchFieldError -> 0x0095 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0095 }
                r7[r8] = r1     // Catch:{ NoSuchFieldError -> 0x0095 }
            L_0x0095:
                int[] r1 = f55796a     // Catch:{ NoSuchFieldError -> 0x009f }
                com.megvii.livenessdetection.Detector$DetectionFailedType r7 = com.megvii.livenessdetection.Detector.DetectionFailedType.ACTIONBLEND     // Catch:{ NoSuchFieldError -> 0x009f }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x009f }
                r1[r7] = r0     // Catch:{ NoSuchFieldError -> 0x009f }
            L_0x009f:
                int[] r0 = f55796a     // Catch:{ NoSuchFieldError -> 0x00a9 }
                com.megvii.livenessdetection.Detector$DetectionFailedType r1 = com.megvii.livenessdetection.Detector.DetectionFailedType.TIMEOUT     // Catch:{ NoSuchFieldError -> 0x00a9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a9 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a9 }
            L_0x00a9:
                int[] r0 = f55796a     // Catch:{ NoSuchFieldError -> 0x00b3 }
                com.megvii.livenessdetection.Detector$DetectionFailedType r1 = com.megvii.livenessdetection.Detector.DetectionFailedType.MASK     // Catch:{ NoSuchFieldError -> 0x00b3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b3 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00b3 }
            L_0x00b3:
                int[] r0 = f55796a     // Catch:{ NoSuchFieldError -> 0x00bd }
                com.megvii.livenessdetection.Detector$DetectionFailedType r1 = com.megvii.livenessdetection.Detector.DetectionFailedType.TOOMANYFACELOST     // Catch:{ NoSuchFieldError -> 0x00bd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bd }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00bd }
            L_0x00bd:
                int[] r0 = f55796a     // Catch:{ NoSuchFieldError -> 0x00c7 }
                com.megvii.livenessdetection.Detector$DetectionFailedType r1 = com.megvii.livenessdetection.Detector.DetectionFailedType.FACELOSTNOTCONTINUOUS     // Catch:{ NoSuchFieldError -> 0x00c7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c7 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00c7 }
            L_0x00c7:
                int[] r0 = f55796a     // Catch:{ NoSuchFieldError -> 0x00d1 }
                com.megvii.livenessdetection.Detector$DetectionFailedType r1 = com.megvii.livenessdetection.Detector.DetectionFailedType.FACENOTCONTINUOUS     // Catch:{ NoSuchFieldError -> 0x00d1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d1 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x00d1 }
            L_0x00d1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.megvii.livenessdetection.obf.C20341a.C203421.<clinit>():void");
        }
    }
}
