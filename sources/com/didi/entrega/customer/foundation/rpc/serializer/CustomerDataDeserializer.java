package com.didi.entrega.customer.foundation.rpc.serializer;

import com.didi.entrega.customer.app.constant.CharsetConst;
import com.didi.entrega.customer.foundation.rpc.net.CRpcResult;
import com.didi.entrega.customer.foundation.rpc.net.TypeUtil;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.customer.foundation.util.GsonUtil;
import com.didichuxing.foundation.p188io.AbstractDeserializer;
import com.didichuxing.foundation.p188io.Streams;
import com.google.gson.JsonParseException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

public class CustomerDataDeserializer extends AbstractDeserializer<Object> {
    public CustomerDataDeserializer(Type type) {
        super(type);
    }

    public Object deserialize(InputStream inputStream) throws IOException {
        TypeUtil.ParameterizedTypeImpl parameterizedTypeImpl = new TypeUtil.ParameterizedTypeImpl((Type) null, CRpcResult.class, getType());
        String str = new String(Streams.readFullyNoClose((InputStream) new BufferedInputStream(inputStream)), CharsetConst.CHARSET_UTF_8);
        try {
            return GsonUtil.fromJson(str, (Type) parameterizedTypeImpl);
        } catch (JsonParseException e) {
            ErrorTracker.create(ErrorConst.ErrorName.PARSE_EXCEPTIONS).addModuleName("api").addErrorType(getType().toString()).addParam("content_json", str).addErrorMsg(ErrorTracker.getExceptionMsg(e)).build().trackError();
            e.printStackTrace();
            throw new IOException(e);
        }
    }
}
