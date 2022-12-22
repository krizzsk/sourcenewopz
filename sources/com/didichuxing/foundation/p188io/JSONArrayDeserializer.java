package com.didichuxing.foundation.p188io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.didichuxing.foundation.io.JSONArrayDeserializer */
public class JSONArrayDeserializer extends AbstractDeserializer<JSONArray> {
    public JSONArray deserialize(InputStream inputStream) throws IOException {
        try {
            return new JSONArray(Streams.readFullyNoClose((Reader) new InputStreamReader(inputStream)));
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }
}
