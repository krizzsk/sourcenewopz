package com.didichuxing.gbankcard.ocr.utils;

import android.text.TextUtils;

public class LuhnAlgo {
    private LuhnAlgo() {
    }

    public static boolean checkLuhn(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String replaceAll = str.replaceAll(" ", "");
        int i = 0;
        boolean z = false;
        for (int length = replaceAll.length() - 1; length >= 0; length--) {
            int parseInt = Integer.parseInt(replaceAll.substring(length, length + 1));
            if (z && (parseInt = parseInt * 2) > 9) {
                parseInt = (parseInt % 10) + 1;
            }
            i += parseInt;
            z = !z;
        }
        if (i % 10 == 0) {
            return true;
        }
        return false;
    }
}
