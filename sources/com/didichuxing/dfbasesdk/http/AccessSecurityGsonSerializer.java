package com.didichuxing.dfbasesdk.http;

import com.didichuxing.dfbasesdk.utils.GsonUtils;
import com.didichuxing.foundation.p188io.AbstractSerializer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class AccessSecurityGsonSerializer extends AbstractSerializer<Object> {
    public InputStream serialize(Object obj) throws IOException {
        return new ByteArrayInputStream(GsonUtils.toJson(obj, true).getBytes());
    }
}
