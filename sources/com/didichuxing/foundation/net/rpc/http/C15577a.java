package com.didichuxing.foundation.net.rpc.http;

/* renamed from: com.didichuxing.foundation.net.rpc.http.a */
/* compiled from: Constants */
interface C15577a {

    /* renamed from: a */
    public static final String f47608a = "http";

    /* renamed from: b */
    public static final String f47609b = "https";

    /* renamed from: c */
    public static final String[] f47610c = {"http", "https"};

    /* renamed from: d */
    public static final int f47611d;

    /* renamed from: e */
    public static final int f47612e;

    /* renamed from: f */
    public static final int f47613f;

    /* renamed from: g */
    public static final int f47614g;

    /* renamed from: h */
    public static final int f47615h = 1;

    /* renamed from: i */
    public static final boolean f47616i = false;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f47611d = availableProcessors;
        f47612e = (availableProcessors * 2) + 1;
        f47613f = (availableProcessors * 3) + 1;
        f47614g = (availableProcessors * 4) + 1;
    }
}
