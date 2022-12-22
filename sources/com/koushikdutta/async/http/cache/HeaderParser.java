package com.koushikdutta.async.http.cache;

import com.didichuxing.bigdata.p173dp.locsdk.Const;

final class HeaderParser {

    public interface CacheControlHandler {
        void handle(String str, String str2);
    }

    HeaderParser() {
    }

    /* renamed from: a */
    public static void m39882a(String str, CacheControlHandler cacheControlHandler) {
        int i;
        String str2;
        if (str != null) {
            int i2 = 0;
            while (i2 < str.length()) {
                int a = m39881a(str, i2, "=,");
                String trim = str.substring(i2, a).trim();
                if (a == str.length() || str.charAt(a) == ',') {
                    cacheControlHandler.handle(trim, (String) null);
                    i2 = a + 1;
                } else {
                    int a2 = m39880a(str, a + 1);
                    if (a2 >= str.length() || str.charAt(a2) != '\"') {
                        i = m39881a(str, a2, ",");
                        str2 = str.substring(a2, i).trim();
                    } else {
                        int i3 = a2 + 1;
                        int a3 = m39881a(str, i3, Const.jsQuote);
                        str2 = str.substring(i3, a3);
                        i = a3 + 1;
                    }
                    cacheControlHandler.handle(trim, str2);
                    i2 = i;
                }
            }
        }
    }

    /* renamed from: a */
    private static int m39881a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    /* renamed from: a */
    private static int m39880a(String str, int i) {
        while (i < str.length() && ((r0 = str.charAt(i)) == ' ' || r0 == 9)) {
            i++;
        }
        return i;
    }

    /* renamed from: a */
    public static int m39879a(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
