package com.didi.sdk.signkylib;

public class SignKeyUtil {

    /* renamed from: a */
    private static SignKey f37518a;

    private SignKeyUtil() {
    }

    public static SignKey getInstance() {
        if (f37518a == null) {
            f37518a = new SignKey();
        }
        return f37518a;
    }

    public String getPhoneSignKey() {
        return f37518a.getPhoneSignKey();
    }
}
