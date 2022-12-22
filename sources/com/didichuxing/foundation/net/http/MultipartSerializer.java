package com.didichuxing.foundation.net.http;

import com.didichuxing.foundation.net.http.MultipartBody;
import com.didichuxing.foundation.p188io.AbstractSerializer;
import com.didichuxing.foundation.util.Introspector;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MultipartSerializer extends AbstractSerializer<Object> {

    /* renamed from: a */
    private final MultipartBody.Builder f47584a = new MultipartBody.Builder();

    public InputStream serialize(Object obj) throws IOException {
        Map<String, Object> map;
        if (obj instanceof Map) {
            if (obj instanceof TreeMap) {
                map = new TreeMap<>();
            } else if (obj instanceof LinkedHashMap) {
                map = new LinkedHashMap<>();
            } else {
                map = new HashMap<>();
            }
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                map.put(String.valueOf(entry.getKey()), entry.getValue());
            }
        } else {
            map = Introspector.properties(obj, true);
        }
        MultipartBody.Builder newBuilder = this.f47584a.build().newBuilder();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (value instanceof byte[]) {
                newBuilder.addPart(str, (byte[]) value);
            } else if (value instanceof File) {
                newBuilder.addPart(str, (File) value);
            } else if (value instanceof InputStream) {
                newBuilder.addPart(str, (InputStream) value);
            } else if (value instanceof MultipartEntity) {
                newBuilder.addPart(str, (MultipartEntity) value);
            } else {
                newBuilder.addPart(str, value);
            }
        }
        return newBuilder.build().getContent();
    }

    public String getBoundary() {
        return this.f47584a.getBoundary();
    }
}
