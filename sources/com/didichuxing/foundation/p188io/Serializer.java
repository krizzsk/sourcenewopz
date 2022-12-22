package com.didichuxing.foundation.p188io;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.didichuxing.foundation.io.Serializer */
public interface Serializer<T> {
    InputStream serialize(T t) throws IOException;
}
