package com.koushikdutta.async.http.cache;

import java.util.Comparator;

class RawHeaders$1 implements Comparator<String> {
    RawHeaders$1() {
    }

    public int compare(String str, String str2) {
        if (str == str2) {
            return 0;
        }
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
    }
}
