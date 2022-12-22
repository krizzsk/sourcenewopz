package com.cardinalcommerce.dependencies.internal.nimbusds.jose.util;

import com.cardinalcommerce.p060a.setIndeterminateTintList;
import com.cardinalcommerce.p060a.setMinWidth;

public class Base64URL extends Base64 {
    public Base64URL(String str) {
        super(str);
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof Base64URL) && toString().equals(obj.toString());
    }

    public static Base64URL getInstance(String str) {
        if (str == null) {
            return null;
        }
        return new Base64URL(str);
    }

    public static Base64URL cca_continue(byte[] bArr) {
        return new Base64URL(setIndeterminateTintList.getInstance(bArr));
    }

    public static Base64URL init(String str) {
        return new Base64URL(setIndeterminateTintList.getInstance(str.getBytes(setMinWidth.getInstance)));
    }
}
