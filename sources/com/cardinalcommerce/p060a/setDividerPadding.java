package com.cardinalcommerce.p060a;

import com.didi.beatles.p099im.service.dao.IMDaoInitTrace;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import java.text.ParseException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.cardinalcommerce.a.setDividerPadding */
public enum setDividerPadding {
    SIGN("sign"),
    VERIFY(LoginOmegaUtil.NEED_VERIFY_EMAIL),
    ENCRYPT(IMDaoInitTrace.APOLLO_ENCRYPT),
    DECRYPT("decrypt"),
    WRAP_KEY("wrapKey"),
    UNWRAP_KEY("unwrapKey"),
    DERIVE_KEY("deriveKey"),
    DERIVE_BITS("deriveBits");
    
    public final String identifier;

    private setDividerPadding(String str) {
        this.identifier = str;
    }

    public static Set<setDividerPadding> configure(List<String> list) throws ParseException {
        setDividerPadding setdividerpadding;
        if (list == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String next : list) {
            if (next != null) {
                setDividerPadding[] values = values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        setdividerpadding = null;
                        break;
                    }
                    setdividerpadding = values[i];
                    if (next.equals(setdividerpadding.identifier)) {
                        break;
                    }
                    i++;
                }
                if (setdividerpadding != null) {
                    linkedHashSet.add(setdividerpadding);
                } else {
                    throw new ParseException("Invalid JWK operation: ".concat(String.valueOf(next)), 0);
                }
            }
        }
        return linkedHashSet;
    }

    public final String toString() {
        return this.identifier;
    }
}
