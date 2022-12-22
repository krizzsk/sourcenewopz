package com.cardinalcommerce.p060a;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.cardinalcommerce.a.setWeightSum */
public final class setWeightSum {

    /* renamed from: a */
    private static Map<setVerticalGravity, Set<setDividerPadding>> f3097a;

    setWeightSum() {
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(setVerticalGravity.init, new HashSet(Arrays.asList(new setDividerPadding[]{setDividerPadding.SIGN, setDividerPadding.VERIFY})));
        hashMap.put(setVerticalGravity.getInstance, new HashSet(Arrays.asList(new setDividerPadding[]{setDividerPadding.ENCRYPT, setDividerPadding.DECRYPT, setDividerPadding.WRAP_KEY, setDividerPadding.UNWRAP_KEY})));
        f3097a = Collections.unmodifiableMap(hashMap);
    }

    public static boolean cca_continue(setVerticalGravity setverticalgravity, Set<setDividerPadding> set) {
        if (setverticalgravity == null || set == null) {
            return true;
        }
        return f3097a.get(setverticalgravity).containsAll(set);
    }
}
