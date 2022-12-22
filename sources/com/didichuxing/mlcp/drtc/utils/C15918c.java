package com.didichuxing.mlcp.drtc.utils;

import com.didichuxing.mlcp.drtc.interfaces.C15887a;
import com.didichuxing.mlcp.drtc.interfaces.C15888b;

/* renamed from: com.didichuxing.mlcp.drtc.utils.c */
/* compiled from: DrtcMessengerFactory */
public class C15918c {
    /* renamed from: a */
    public static C15888b m34721a(String str, C15887a aVar) {
        if (str.indexOf("ws") == 0) {
            return new C15926h(str, aVar);
        }
        return new C15921e(str, aVar);
    }
}
