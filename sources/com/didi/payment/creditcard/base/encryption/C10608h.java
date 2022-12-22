package com.didi.payment.creditcard.base.encryption;

import java.util.Random;

/* renamed from: com.didi.payment.creditcard.base.encryption.h */
/* compiled from: RandomUtil */
class C10608h {

    /* renamed from: a */
    public static Random f30295a = new Random();

    C10608h() {
    }

    /* renamed from: a */
    public static String m21260a(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            if (f30295a.nextInt(2) % 2 == 0) {
                sb.append((char) ((f30295a.nextInt(2) % 2 == 0 ? 65 : 97) + f30295a.nextInt(26)));
            } else {
                sb.append(Integer.toString(f30295a.nextInt(10)));
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static String m21261b(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(Integer.toString(f30295a.nextInt(10)));
        }
        return sb.toString();
    }
}
