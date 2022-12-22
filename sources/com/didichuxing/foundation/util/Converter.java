package com.didichuxing.foundation.util;

import java.lang.reflect.Type;

public abstract class Converter<Origin, Target> {
    public abstract Target convert(Origin origin, Object... objArr);

    public Type getOriginType() {
        return TypeResolver.getSuperclassTypeParameter((Object) this, 0);
    }

    public Type getTargetType() {
        return TypeResolver.getSuperclassTypeParameter((Object) this, 1);
    }
}
