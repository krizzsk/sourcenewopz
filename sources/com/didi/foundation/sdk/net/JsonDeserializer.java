package com.didi.foundation.sdk.net;

import com.didichuxing.foundation.p188io.AbstractDeserializer;
import com.didichuxing.foundation.p188io.Streams;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;

public class JsonDeserializer extends AbstractDeserializer<Object> {

    /* renamed from: a */
    private Gson f21269a = new GsonBuilder().create();

    public JsonDeserializer(Type type) {
        super(type);
    }

    public Object deserialize(InputStream inputStream) throws IOException {
        return this.f21269a.fromJson(Streams.readFullyNoClose((Reader) new InputStreamReader(inputStream)), getType());
    }
}
