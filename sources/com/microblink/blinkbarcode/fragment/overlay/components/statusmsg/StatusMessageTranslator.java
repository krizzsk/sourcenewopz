package com.microblink.blinkbarcode.fragment.overlay.components.statusmsg;

import com.microblink.blinkbarcode.recognition.RecognitionSuccessType;
import com.microblink.blinkbarcode.view.recognition.DetectionStatus;

/* compiled from: line */
public interface StatusMessageTranslator {
    public static final StatusMessageTranslator EMPTY = new StatusMessageTranslator() {
        public int getMessage(Event event) {
            return 0;
        }
    };

    /* renamed from: com.microblink.blinkbarcode.fragment.overlay.components.statusmsg.StatusMessageTranslator$2 */
    /* compiled from: line */
    public static /* synthetic */ class C203852 {
        public static final /* synthetic */ int[] IlIllIlIIl;
        public static final /* synthetic */ int[] llIIlIlIIl;

        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|(2:23|24)|25|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|(2:23|24)|25|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0027 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x002b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x003d */
        static {
            /*
                com.microblink.blinkbarcode.recognition.RecognitionSuccessType.values()
                r0 = 4
                int[] r1 = new int[r0]
                IlIllIlIIl = r1
                r2 = 0
                r3 = 1
                com.microblink.blinkbarcode.recognition.RecognitionSuccessType r4 = com.microblink.blinkbarcode.recognition.RecognitionSuccessType.UNSUCCESSFUL     // Catch:{ NoSuchFieldError -> 0x000e }
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r1 = 2
                int[] r4 = IlIllIlIIl     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.microblink.blinkbarcode.recognition.RecognitionSuccessType r5 = com.microblink.blinkbarcode.recognition.RecognitionSuccessType.PARTIAL     // Catch:{ NoSuchFieldError -> 0x0015 }
                r4[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                r4 = 3
                int[] r5 = IlIllIlIIl     // Catch:{ NoSuchFieldError -> 0x001c }
                com.microblink.blinkbarcode.recognition.RecognitionSuccessType r6 = com.microblink.blinkbarcode.recognition.RecognitionSuccessType.STAGE_SUCCESSFUL     // Catch:{ NoSuchFieldError -> 0x001c }
                r5[r4] = r4     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                com.microblink.blinkbarcode.view.recognition.DetectionStatus.values()
                r5 = 8
                int[] r5 = new int[r5]
                llIIlIlIIl = r5
                r5[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0027 }
            L_0x0027:
                int[] r2 = llIIlIlIIl     // Catch:{ NoSuchFieldError -> 0x002b }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                int[] r2 = llIIlIlIIl     // Catch:{ NoSuchFieldError -> 0x002f }
                r2[r1] = r4     // Catch:{ NoSuchFieldError -> 0x002f }
            L_0x002f:
                int[] r1 = llIIlIlIIl     // Catch:{ NoSuchFieldError -> 0x0033 }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r1 = 5
                int[] r2 = llIIlIlIIl     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                r0 = 6
                int[] r2 = llIIlIlIIl     // Catch:{ NoSuchFieldError -> 0x003d }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r1 = llIIlIlIIl     // Catch:{ NoSuchFieldError -> 0x0042 }
                r2 = 7
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0042 }
            L_0x0042:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.fragment.overlay.components.statusmsg.StatusMessageTranslator.C203852.<clinit>():void");
        }
    }

    /* compiled from: line */
    public enum Event {
        INITIAL,
        RECOGNITION_SUCCESS,
        RECOGNITION_STAGE_SUCCESS,
        RECOGNITION_PARTIAL,
        RECOGNITION_UNSUCCESSFUL,
        DETECTION_FAILED,
        DETECTION_SUCCESS,
        DETECTION_CAMERA_TOO_HIGH,
        DETECTION_FALLBACK_SUCCESS,
        DETECTION_PARTIAL_OBJECT,
        DETECTION_CAMERA_AT_ANGLE,
        DETECTION_CAMERA_TOO_NEAR,
        AUTOFOCUS_FAILED;

        public static Event fromDetectionStatus(DetectionStatus detectionStatus) {
            switch (detectionStatus.ordinal()) {
                case 0:
                    return DETECTION_FAILED;
                case 1:
                    return DETECTION_SUCCESS;
                case 2:
                    return DETECTION_CAMERA_TOO_HIGH;
                case 3:
                    return DETECTION_FALLBACK_SUCCESS;
                case 4:
                    return DETECTION_PARTIAL_OBJECT;
                case 5:
                    return DETECTION_CAMERA_AT_ANGLE;
                case 6:
                    return DETECTION_CAMERA_TOO_NEAR;
                default:
                    return DETECTION_SUCCESS;
            }
        }

        public static Event fromRecognitionSuccessType(RecognitionSuccessType recognitionSuccessType) {
            int ordinal = recognitionSuccessType.ordinal();
            if (ordinal == 0) {
                return RECOGNITION_UNSUCCESSFUL;
            }
            if (ordinal == 1) {
                return RECOGNITION_PARTIAL;
            }
            if (ordinal != 3) {
                return RECOGNITION_SUCCESS;
            }
            return RECOGNITION_STAGE_SUCCESS;
        }
    }

    int getMessage(Event event);
}
