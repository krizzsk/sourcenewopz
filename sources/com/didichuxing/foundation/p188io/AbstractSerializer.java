package com.didichuxing.foundation.p188io;

import com.didichuxing.foundation.util.GenericType;
import java.lang.reflect.Type;

/* renamed from: com.didichuxing.foundation.io.AbstractSerializer */
public abstract class AbstractSerializer<T> extends GenericType<T> implements Serializer<T> {
    protected AbstractSerializer() {
    }

    protected AbstractSerializer(Type type) {
        super(type);
    }
}
