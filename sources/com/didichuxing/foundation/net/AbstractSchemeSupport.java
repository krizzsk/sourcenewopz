package com.didichuxing.foundation.net;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractSchemeSupport implements SchemeSupport {
    private final Set<String> mSupportedSchemes;

    public AbstractSchemeSupport() {
        HashSet hashSet = new HashSet();
        String[] supportedSchemes = getSupportedSchemes();
        if (supportedSchemes != null) {
            for (String lowerCase : supportedSchemes) {
                hashSet.add(lowerCase.toLowerCase());
            }
        }
        this.mSupportedSchemes = Collections.unmodifiableSet(hashSet);
    }

    public boolean isSchemeSupported(String str) {
        return this.mSupportedSchemes.contains(str.toLowerCase());
    }
}
