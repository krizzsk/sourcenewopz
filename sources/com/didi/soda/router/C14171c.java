package com.didi.soda.router;

/* renamed from: com.didi.soda.router.c */
/* compiled from: StringUtil */
class C14171c {
    C14171c() {
    }

    /* renamed from: a */
    public static boolean m30994a(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: b */
    public static int m30996b(String str) {
        if (str == null) {
            return -1;
        }
        return str.length();
    }

    /* renamed from: a */
    public static boolean m30995a(String str, String str2) {
        if (m30994a(str) && m30994a(str2)) {
            return true;
        }
        if (m30996b(str) != m30996b(str2)) {
            return false;
        }
        return str.equals(str2);
    }
}
