package com.didichuxing.foundation.p188io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didichuxing.foundation.io.JSONObjectDeserializer */
public class JSONObjectDeserializer extends AbstractDeserializer<JSONObject> {
    public JSONObject deserialize(InputStream inputStream) throws IOException {
        try {
            return new JSONObject(Streams.readFullyNoClose((Reader) new InputStreamReader(inputStream)));
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }
}
