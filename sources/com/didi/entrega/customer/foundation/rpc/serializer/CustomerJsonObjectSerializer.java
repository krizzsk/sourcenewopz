package com.didi.entrega.customer.foundation.rpc.serializer;

import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.customer.foundation.util.GsonUtil;
import com.didichuxing.foundation.p188io.AbstractSerializer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.Iterator;
import kotlin.text.Typography;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomerJsonObjectSerializer extends AbstractSerializer<Object> {
    public CustomerJsonObjectSerializer(Type type) {
        super(type);
    }

    public final InputStream serialize(Object obj) throws IOException {
        try {
            return doSerialize(new JSONObject(GsonUtil.toJson(obj)));
        } catch (JSONException e) {
            ErrorTracker.create(ErrorConst.ErrorName.PARSE_EXCEPTIONS).addModuleName("api").addErrorType(getType().toString()).addErrorMsg(ErrorTracker.getExceptionMsg(e)).addParam("content_json", obj != null ? obj.toString() : "").build().trackError();
            e.printStackTrace();
            throw new IOException(e);
        }
    }

    /* access modifiers changed from: protected */
    public void serialize(JSONObject jSONObject, StringBuilder sb) throws JSONException, IOException {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            serialize(next, jSONObject.get(next).toString(), sb);
            if (keys.hasNext()) {
                sb.append(Typography.amp);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void serialize(String str, String str2, StringBuilder sb) throws JSONException, IOException {
        sb.append(str);
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }

    /* access modifiers changed from: protected */
    public InputStream doSerialize(JSONObject jSONObject) throws IOException, JSONException {
        StringBuilder sb = new StringBuilder();
        serialize(jSONObject, sb);
        return new ByteArrayInputStream(sb.toString().getBytes());
    }
}
