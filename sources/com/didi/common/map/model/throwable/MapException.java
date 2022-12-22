package com.didi.common.map.model.throwable;

public class MapException extends Exception {
    public MapException() {
    }

    public MapException(String str) {
        super(str);
    }

    public MapException(String str, Throwable th) {
        super(str, th);
    }

    public MapException(Exception exc) {
        super(exc);
    }
}
