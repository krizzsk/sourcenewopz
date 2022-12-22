package com.didi.common.map.model.throwable;

public final class MapNotExistApiException extends MapRuntimeException {
    public MapNotExistApiException() {
    }

    public MapNotExistApiException(String str) {
        super(str);
    }

    public MapNotExistApiException(String str, Throwable th) {
        super(str, th);
    }

    public MapNotExistApiException(Exception exc) {
        super(exc);
    }

    public MapNotExistApiException(MapException mapException) {
        super(mapException);
    }
}
