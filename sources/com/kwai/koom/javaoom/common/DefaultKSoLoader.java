package com.kwai.koom.javaoom.common;

public class DefaultKSoLoader implements KSoLoader {
    public boolean loadLib(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return false;
        }
    }
}
