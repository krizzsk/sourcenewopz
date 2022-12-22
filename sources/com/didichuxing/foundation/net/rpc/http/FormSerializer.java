package com.didichuxing.foundation.net.rpc.http;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.foundation.p188io.AbstractSerializer;
import com.didichuxing.foundation.util.Introspector;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;

public final class FormSerializer extends AbstractSerializer<Object> {
    public InputStream serialize(Object obj) throws IOException {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, Object>> it = (obj instanceof Map ? (Map) obj : Introspector.properties(obj, true)).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!(next.getKey() == null || next.getValue() == null)) {
                String encode = URLEncoder.encode(String.valueOf(next.getKey()), "UTF-8");
                Object value = next.getValue();
                if ((value instanceof Collection) || value.getClass().isArray()) {
                    int length = Array.getLength(value);
                    if (length > 0) {
                        sb.append(encode);
                        sb.append('=');
                        sb.append(URLEncoder.encode(String.valueOf(Array.get(value, 0)), "UTF-8"));
                        for (int i = 1; i < length; i++) {
                            sb.append(Typography.amp);
                            sb.append(encode);
                            sb.append('=');
                            sb.append(URLEncoder.encode(String.valueOf(Array.get(value, i)), "UTF-8"));
                        }
                    }
                } else {
                    sb.append(encode);
                    sb.append("=");
                    sb.append(URLEncoder.encode(String.valueOf(value), "UTF-8"));
                }
                if (it.hasNext()) {
                    sb.append(ParamKeys.SIGN_AND);
                }
            }
        }
        return new ByteArrayInputStream(sb.toString().getBytes());
    }
}
