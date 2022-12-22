package com.didichuxing.foundation.gson;

import com.didichuxing.foundation.p188io.AbstractSerializer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class GsonSerializer extends AbstractSerializer<Object> {

    /* renamed from: a */
    private final GsonAdapter f47559a = new GsonAdapter();

    public InputStream serialize(Object obj) throws IOException {
        return new ByteArrayInputStream(this.f47559a.getGson().toJson(obj).getBytes());
    }
}
