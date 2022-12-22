package com.didichuxing.foundation.p188io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.json.JSONException;
import org.json.JSONTokener;

/* renamed from: com.didichuxing.foundation.io.JSONDeserializer */
public class JSONDeserializer extends AbstractDeserializer<Object> {
    public Object deserialize(InputStream inputStream) throws IOException {
        try {
            return new JSONTokener(Streams.readFullyNoClose((Reader) new InputStreamReader(inputStream))).nextValue();
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }
}
