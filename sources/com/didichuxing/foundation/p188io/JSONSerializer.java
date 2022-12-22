package com.didichuxing.foundation.p188io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;

@Deprecated
/* renamed from: com.didichuxing.foundation.io.JSONSerializer */
public class JSONSerializer extends AbstractSerializer<Object> {
    public InputStream serialize(Object obj) throws IOException {
        try {
            return new ByteArrayInputStream(JSON.stringify(obj).getBytes());
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }
}
