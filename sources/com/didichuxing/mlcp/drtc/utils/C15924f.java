package com.didichuxing.mlcp.drtc.utils;

import java.util.Random;

/* renamed from: com.didichuxing.mlcp.drtc.utils.f */
/* compiled from: RandomString */
public class C15924f {

    /* renamed from: a */
    final Random f48465a = new Random();

    /* renamed from: a */
    public String mo119065a(Integer num) {
        StringBuilder sb = new StringBuilder(num.intValue());
        for (int i = 0; i < num.intValue(); i++) {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(this.f48465a.nextInt(62)));
        }
        return sb.toString();
    }
}
