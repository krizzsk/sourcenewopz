package com.didi.sdk.connectivity;

import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.didi.sdk.connectivity.b */
/* compiled from: IdGenerator */
class C12166b {

    /* renamed from: a */
    static AtomicInteger f35761a = new AtomicInteger(0);

    C12166b() {
    }

    /* renamed from: a */
    static int m25330a() {
        return f35761a.getAndIncrement();
    }
}
