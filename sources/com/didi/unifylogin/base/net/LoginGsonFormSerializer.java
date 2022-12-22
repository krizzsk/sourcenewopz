package com.didi.unifylogin.base.net;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.foundation.gson.GsonAdapter;
import com.didichuxing.foundation.p188io.AbstractSerializer;
import com.google.gson.JsonElement;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

public class LoginGsonFormSerializer extends AbstractSerializer<Object> {
    public InputStream serialize(Object obj) throws IOException {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, JsonElement>> it = new GsonAdapter().getGson().toJsonTree(obj).getAsJsonObject().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            String encode = URLEncoder.encode(((JsonElement) next.getValue()).toString(), "UTF-8");
            sb.append((String) next.getKey());
            sb.append('=');
            sb.append(encode);
            if (it.hasNext()) {
                sb.append(ParamKeys.SIGN_AND);
            }
        }
        return new ByteArrayInputStream(sb.toString().getBytes());
    }
}
