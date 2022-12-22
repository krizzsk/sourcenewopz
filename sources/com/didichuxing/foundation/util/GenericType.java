package com.didichuxing.foundation.util;

import java.lang.reflect.Type;

public abstract class GenericType<T> {
    private final Type mType;

    protected GenericType() {
        this.mType = TypeResolver.getSuperclassTypeParameter(getClass());
    }

    protected GenericType(Type type) {
        this.mType = type;
    }

    public Type getType() {
        return this.mType;
    }
}
