package com.didi.soda.customer.foundation.rpc.serializer;

import com.didi.soda.customer.app.constant.CharsetConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didichuxing.foundation.p188io.AbstractDeserializer;
import com.didichuxing.foundation.p188io.Streams;
import com.google.gson.JsonParseException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

public class CustomerAsyncDataDeserializer extends AbstractDeserializer<Object> {
    public CustomerAsyncDataDeserializer(Type type) {
        super(type);
    }

    public Object deserialize(InputStream inputStream) throws IOException {
        String str = new String(Streams.readFullyNoClose((InputStream) new BufferedInputStream(inputStream)), CharsetConst.CHARSET_UTF_8);
        try {
            return GsonUtil.fromJson(str, getType());
        } catch (JsonParseException e) {
            ErrorTracker.create(ErrorConst.ErrorName.PARSE_EXCEPTIONS).addModuleName("api").addErrorType(getType().toString()).addParam("content_json", str).addErrorMsg(ErrorTracker.getExceptionMsg(e)).build().trackError();
            e.printStackTrace();
            throw new IOException(e);
        }
    }
}
