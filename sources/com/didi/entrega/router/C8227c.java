package com.didi.entrega.router;

/* renamed from: com.didi.entrega.router.c */
/* compiled from: StringUtil */
class C8227c {
    C8227c() {
    }

    /* renamed from: a */
    public static boolean m15431a(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: b */
    public static int m15433b(String str) {
        if (str == null) {
            return -1;
        }
        return str.length();
    }

    /* renamed from: a */
    public static boolean m15432a(String str, String str2) {
        if (m15431a(str) && m15431a(str2)) {
            return true;
        }
        if (m15433b(str) != m15433b(str2)) {
            return false;
        }
        return str.equals(str2);
    }
}
