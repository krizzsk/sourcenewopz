package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setMin */
public enum setMin {
    PROTOCOL_EXCEPTION,
    MALFORMED_URL_EXCEPTION,
    SOCKET_TIMEOUT_EXCEPTION,
    IO_EXCEPTION,
    EXCEPTION;
    
    private static int configure = 1;
    private static int getInstance;

    static {
        int i = getInstance;
        int i2 = i & 1;
        int i3 = i2 + ((i ^ 1) | i2);
        configure = i3 % 128;
        int i4 = i3 % 2;
    }
}
