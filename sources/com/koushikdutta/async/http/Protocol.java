package com.koushikdutta.async.http;

import java.util.Hashtable;
import java.util.Locale;

public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1") {
        public boolean needsSpdyConnection() {
            return true;
        }
    },
    HTTP_2("h2-13") {
        public boolean needsSpdyConnection() {
            return true;
        }
    };
    
    private static final Hashtable<String, Protocol> protocols = null;
    private final String protocol;

    public boolean needsSpdyConnection() {
        return false;
    }

    static {
        Hashtable<String, Protocol> hashtable = new Hashtable<>();
        protocols = hashtable;
        hashtable.put(HTTP_1_0.toString(), HTTP_1_0);
        protocols.put(HTTP_1_1.toString(), HTTP_1_1);
        protocols.put(SPDY_3.toString(), SPDY_3);
        protocols.put(HTTP_2.toString(), HTTP_2);
    }

    private Protocol(String str) {
        this.protocol = str;
    }

    public static Protocol get(String str) {
        if (str == null) {
            return null;
        }
        return protocols.get(str.toLowerCase(Locale.US));
    }

    public String toString() {
        return this.protocol;
    }
}
