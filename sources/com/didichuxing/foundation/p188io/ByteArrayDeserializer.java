package com.didichuxing.foundation.p188io;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.didichuxing.foundation.io.ByteArrayDeserializer */
public class ByteArrayDeserializer extends AbstractDeserializer<byte[]> {
    public byte[] deserialize(InputStream inputStream) throws IOException {
        return Streams.readFullyNoClose(inputStream);
    }
}
