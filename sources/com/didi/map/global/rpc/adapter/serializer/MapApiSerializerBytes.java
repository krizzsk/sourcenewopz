package com.didi.map.global.rpc.adapter.serializer;

import com.didichuxing.foundation.p188io.AbstractSerializer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

public class MapApiSerializerBytes extends AbstractSerializer<Object> {
    public static final String BYTE_KEY = "BYTE_KEY";

    public ByteArrayInputStream serialize(Object obj) throws IOException {
        try {
            if (obj instanceof LinkedHashMap) {
                LinkedHashMap linkedHashMap = (LinkedHashMap) obj;
                if (!linkedHashMap.isEmpty()) {
                    return new ByteArrayInputStream((byte[]) linkedHashMap.get(BYTE_KEY));
                }
            }
            return new ByteArrayInputStream(new byte[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return new ByteArrayInputStream(new byte[0]);
        }
    }
}
