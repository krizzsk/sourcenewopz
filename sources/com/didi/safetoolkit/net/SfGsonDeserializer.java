package com.didi.safetoolkit.net;

import com.didichuxing.foundation.p188io.AbstractDeserializer;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;

public class SfGsonDeserializer extends AbstractDeserializer<Object> {
    protected SfGsonDeserializer() {
    }

    public SfGsonDeserializer(Type type) {
        super(type);
    }

    public Object deserialize(InputStream inputStream) throws IOException {
        return SfJsonUtils.fromJson((Reader) new InputStreamReader(inputStream), getType());
    }
}
