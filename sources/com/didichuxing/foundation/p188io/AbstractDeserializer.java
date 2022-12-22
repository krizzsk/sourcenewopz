package com.didichuxing.foundation.p188io;

import com.didichuxing.foundation.util.GenericType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Map;

/* renamed from: com.didichuxing.foundation.io.AbstractDeserializer */
public abstract class AbstractDeserializer<T> extends GenericType<T> implements Deserializer<T> {
    protected final Map<String, String> headers;

    protected AbstractDeserializer() {
        this.headers = Collections.emptyMap();
    }

    protected AbstractDeserializer(Type type) {
        this(type, Collections.emptyMap());
    }

    protected AbstractDeserializer(Type type, Map<String, String> map) {
        super(type);
        this.headers = Collections.unmodifiableMap(map);
    }
}
