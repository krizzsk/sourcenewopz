package com.didichuxing.foundation.net.rpc.http;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.foundation.p188io.AbstractSerializer;
import com.didichuxing.foundation.util.Introspector;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class JSONFormSerializer extends AbstractSerializer<Object> {
    public InputStream serialize(Object obj) throws IOException {
        StringBuilder sb = new StringBuilder();
        JSONObject jSONObject = new JSONObject(obj instanceof Map ? (Map) obj : Introspector.properties(obj, true));
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String valueOf = String.valueOf(jSONObject.opt(next));
                sb.append(next);
                sb.append('=');
                sb.append(valueOf);
                if (keys.hasNext()) {
                    sb.append(ParamKeys.SIGN_AND);
                }
            }
            return new ByteArrayInputStream(sb.toString().getBytes());
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
