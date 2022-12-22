package com.didichuxing.foundation.net;

public interface SchemeSupport {
    String[] getSupportedSchemes();

    boolean isSchemeSupported(String str);
}
