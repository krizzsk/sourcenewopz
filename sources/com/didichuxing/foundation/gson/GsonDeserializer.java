package com.didichuxing.foundation.gson;

import com.didichuxing.foundation.p188io.AbstractDeserializer;
import com.didichuxing.foundation.p188io.Streams;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;

public class GsonDeserializer<T> extends AbstractDeserializer<T> {
    private final GsonAdapter mAdapter = new GsonAdapter();

    protected GsonDeserializer() {
    }

    public GsonDeserializer(Type type) {
        super(type);
    }

    public T deserialize(InputStream inputStream) throws IOException {
        try {
            return this.mAdapter.getGson().fromJson(Streams.readFullyNoClose((Reader) new InputStreamReader(inputStream)), getType());
        } catch (JsonSyntaxException e) {
            throw new IOException(e);
        }
    }
}
