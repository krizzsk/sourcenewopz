package com.didichuxing.foundation.p188io;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.didichuxing.foundation.io.StringDeserializer */
public class StringDeserializer extends AbstractDeserializer<String> {
    public String deserialize(InputStream inputStream) throws IOException {
        byte[] readFullyNoClose = Streams.readFullyNoClose(inputStream);
        if (readFullyNoClose == null) {
            return "";
        }
        return new String(readFullyNoClose);
    }
}
