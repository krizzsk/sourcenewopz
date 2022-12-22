package com.didi.beatles.p099im.net;

import com.didichuxing.foundation.p188io.AbstractSerializer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* renamed from: com.didi.beatles.im.net.IMJsonSerializer */
public class IMJsonSerializer extends AbstractSerializer<Object> {
    public InputStream serialize(Object obj) throws IOException {
        String str;
        if (!(obj instanceof Map) || (str = (String) ((Map) obj).get("data")) == null) {
            return null;
        }
        return new ByteArrayInputStream(str.getBytes());
    }
}
