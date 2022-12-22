package com.didichuxing.cardscan.model;

import android.text.TextUtils;
import android.util.Pair;
import com.appsflyer.AppsFlyerLibCore;
import com.didichuxing.diface.logger.DiFaceLogger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public enum CardType {
    AMEX("AmEx"),
    DINERSCLUB("DinersClub"),
    DISCOVER("Discover"),
    JCB("JCB"),
    MASTERCARD("MasterCard"),
    VISA("Visa"),
    MAESTRO("Maestro"),
    UNKNOWN("Unknown"),
    INSUFFICIENT_DIGITS("More digits required");
    
    private static HashMap<Pair<String, String>, CardType> intervalLookup;
    private static int minDigits;
    public final String name;

    /* renamed from: com.didichuxing.cardscan.model.CardType$1 */
    static /* synthetic */ class C151841 {

        /* renamed from: a */
        static final /* synthetic */ int[] f46191a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didichuxing.cardscan.model.CardType[] r0 = com.didichuxing.cardscan.model.CardType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f46191a = r0
                com.didichuxing.cardscan.model.CardType r1 = com.didichuxing.cardscan.model.CardType.AMEX     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f46191a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didichuxing.cardscan.model.CardType r1 = com.didichuxing.cardscan.model.CardType.JCB     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f46191a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didichuxing.cardscan.model.CardType r1 = com.didichuxing.cardscan.model.CardType.MASTERCARD     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f46191a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didichuxing.cardscan.model.CardType r1 = com.didichuxing.cardscan.model.CardType.MAESTRO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f46191a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didichuxing.cardscan.model.CardType r1 = com.didichuxing.cardscan.model.CardType.VISA     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f46191a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didichuxing.cardscan.model.CardType r1 = com.didichuxing.cardscan.model.CardType.DISCOVER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f46191a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didichuxing.cardscan.model.CardType r1 = com.didichuxing.cardscan.model.CardType.DINERSCLUB     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f46191a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didichuxing.cardscan.model.CardType r1 = com.didichuxing.cardscan.model.CardType.INSUFFICIENT_DIGITS     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f46191a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.didichuxing.cardscan.model.CardType r1 = com.didichuxing.cardscan.model.CardType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.cardscan.model.CardType.C151841.<clinit>():void");
        }
    }

    static {
        minDigits = 1;
        HashMap<Pair<String, String>, CardType> hashMap = new HashMap<>();
        intervalLookup = hashMap;
        hashMap.put(getNewPair("2221", "2720"), MASTERCARD);
        intervalLookup.put(getNewPair("300", "305"), DINERSCLUB);
        intervalLookup.put(getNewPair("309", (String) null), DINERSCLUB);
        intervalLookup.put(getNewPair(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_STOP_VIDEO_TAKE, (String) null), AMEX);
        intervalLookup.put(getNewPair("3528", "3589"), JCB);
        intervalLookup.put(getNewPair(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_YES, (String) null), DINERSCLUB);
        intervalLookup.put(getNewPair("37", (String) null), AMEX);
        intervalLookup.put(getNewPair(AppsFlyerLibCore.f1788, "39"), DINERSCLUB);
        intervalLookup.put(getNewPair("4", (String) null), VISA);
        intervalLookup.put(getNewPair(DiFaceLogger.EVENT_ID_BI_DETECT_DONE, (String) null), MAESTRO);
        intervalLookup.put(getNewPair("51", "55"), MASTERCARD);
        intervalLookup.put(getNewPair(DiFaceLogger.EVENT_ID_MODEL_DOWNLOAD_FAIL, DiFaceLogger.EVENT_ID_COMPARE_FAILED_EXIT_CLICKED), MAESTRO);
        intervalLookup.put(getNewPair("6011", (String) null), DISCOVER);
        intervalLookup.put(getNewPair(DiFaceLogger.EVENT_ID_SELECT_DRIVER_LICENSE_NEXT_CLICKED, (String) null), MAESTRO);
        intervalLookup.put(getNewPair(DiFaceLogger.EVENT_ID_ENTER_SUBMIT_MATERIALS, (String) null), DISCOVER);
        intervalLookup.put(getNewPair(DiFaceLogger.EVENT_ID_SUBMIT_MATERIALS_CLICKED, (String) null), MAESTRO);
        intervalLookup.put(getNewPair("644", "649"), DISCOVER);
        intervalLookup.put(getNewPair(DiFaceLogger.EVENT_ID_ENTER_APPEAL_RESULT, (String) null), DISCOVER);
        intervalLookup.put(getNewPair(DiFaceLogger.EVENT_ID_APPEAL_RESULT_EXIT_CLICKED, DiFaceLogger.EVENT_ID_APPEAL_CONFIG_CALLBACK), MAESTRO);
        intervalLookup.put(getNewPair("88", (String) null), DISCOVER);
        for (Map.Entry next : getIntervalLookup().entrySet()) {
            minDigits = Math.max(minDigits, ((String) ((Pair) next.getKey()).first).length());
            if (((Pair) next.getKey()).second != null) {
                minDigits = Math.max(minDigits, ((String) ((Pair) next.getKey()).second).length());
            }
        }
    }

    private CardType(String str) {
        this.name = str;
    }

    public static CardType fromCardNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNKNOWN;
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry next : getIntervalLookup().entrySet()) {
            if (isNumberInInterval(str, (String) ((Pair) next.getKey()).first, (String) ((Pair) next.getKey()).second)) {
                hashSet.add(next.getValue());
            }
        }
        return hashSet.size() > 1 ? INSUFFICIENT_DIGITS : hashSet.size() == 1 ? (CardType) hashSet.iterator().next() : UNKNOWN;
    }

    public static CardType fromString(String str) {
        if (str == null) {
            return UNKNOWN;
        }
        for (CardType cardType : values()) {
            if (cardType != UNKNOWN && cardType != INSUFFICIENT_DIGITS && str.equalsIgnoreCase(cardType.toString())) {
                return cardType;
            }
        }
        return UNKNOWN;
    }

    private static HashMap<Pair<String, String>, CardType> getIntervalLookup() {
        return intervalLookup;
    }

    private static Pair<String, String> getNewPair(String str, String str2) {
        if (str2 == null) {
            str2 = str;
        }
        return new Pair<>(str, str2);
    }

    private static boolean isNumberInInterval(String str, String str2, String str3) {
        int min = Math.min(str.length(), str2.length());
        int min2 = Math.min(str.length(), str3.length());
        return Integer.parseInt(str.substring(0, min)) >= Integer.parseInt(str2.substring(0, min)) && Integer.parseInt(str.substring(0, min2)) <= Integer.parseInt(str3.substring(0, min2));
    }

    public int cvvLength() {
        switch (C151841.f46191a[ordinal()]) {
            case 1:
                return 4;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return 3;
            default:
                return -1;
        }
    }

    public int numberLength() {
        switch (C151841.f46191a[ordinal()]) {
            case 1:
                return 15;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return 16;
            case 7:
                return 14;
            case 8:
                return minDigits;
            default:
                return -1;
        }
    }

    public String toString() {
        return this.name;
    }
}
