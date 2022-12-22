package com.didi.travel.psnger.common.net.base;

import com.didi.travel.psnger.common.net.rpc.IRouteService;
import com.didichuxing.foundation.p188io.AbstractSerializer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class ByteArraySerializer extends AbstractSerializer<Object> {
    public InputStream serialize(Object obj) throws IOException {
        if (obj instanceof Map) {
            Object obj2 = ((Map) obj).get(IRouteService.KEY_BYTE_ARRAY);
            if (obj2 instanceof byte[]) {
                return new ByteArrayInputStream((byte[]) obj2);
            }
            return null;
        } else if (obj instanceof byte[]) {
            return new ByteArrayInputStream((byte[]) obj);
        } else {
            return null;
        }
    }
}
