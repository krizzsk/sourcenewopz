package com.didi.common.map.model.throwable;

public class MapError extends Error {
    public MapError() {
    }

    public MapError(String str) {
        super(str);
    }

    public MapError(String str, Throwable th) {
        super(str, th);
    }

    public MapError(Error error) {
        super(error);
    }
}
