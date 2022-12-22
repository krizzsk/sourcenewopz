package com.didi.map.global.rpc.model;

import com.didichuxing.foundation.util.TypeResolver;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.lang.reflect.Type;

public class MapProtobufResWrapper<T extends Message> extends MapRpcBaseResult {
    private T data;

    public T getData() {
        byte[] bytes;
        if (this.data == null && (bytes = getBytes()) != null && bytes.length > 0) {
            Wire wire = new Wire((Class<?>[]) new Class[0]);
            try {
                Type superclassTypeParameter = TypeResolver.getSuperclassTypeParameter(getClass());
                if (superclassTypeParameter instanceof Class) {
                    this.data = wire.parseFrom(bytes, (Class) superclassTypeParameter);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this.data;
    }
}
