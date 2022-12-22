package com.didichuxing.foundation.p188io;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.didichuxing.foundation.io.Deserializer */
public interface Deserializer<T> {
    T deserialize(InputStream inputStream) throws IOException;
}
