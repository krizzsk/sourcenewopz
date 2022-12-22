package com.didi.travel.psnger.gson;

import com.didichuxing.foundation.p188io.AbstractDeserializer;
import com.didichuxing.foundation.p188io.Streams;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;

public class PostProcessableGsonDeserializer<T> extends AbstractDeserializer<T> {
    protected PostProcessableGsonDeserializer() {
    }

    public PostProcessableGsonDeserializer(Type type) {
        super(type);
    }

    public T deserialize(InputStream inputStream) throws IOException {
        try {
            return m31413a().fromJson(Streams.readFullyNoClose((Reader) new InputStreamReader(inputStream)), getType());
        } catch (JsonSyntaxException e) {
            throw new IOException(e);
        }
    }

    /* renamed from: a */
    private Gson m31413a() {
        return new GsonBuilder().registerTypeAdapterFactory(new PostProcessableFactory()).create();
    }
}
