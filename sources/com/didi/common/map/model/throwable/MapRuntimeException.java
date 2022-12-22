package com.didi.common.map.model.throwable;

public class MapRuntimeException extends RuntimeException {
    public MapRuntimeException() {
    }

    public MapRuntimeException(String str) {
        super(str);
    }

    public MapRuntimeException(String str, Throwable th) {
        super(str, th);
    }

    public MapRuntimeException(Exception exc) {
        super(exc);
    }

    public MapRuntimeException(MapException mapException) {
        super(mapException);
    }
}
