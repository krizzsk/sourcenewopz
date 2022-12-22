package com.turbomanage.httpclient.rest;

import com.turbomanage.httpclient.HttpResponse;
import com.turbomanage.httpclient.rest.MediaType;

public abstract class ObjectFactory<M extends MediaType> {
    public abstract <T> byte[] toBytes(T t);

    public abstract <T> T toObj(byte[] bArr, Class<T> cls);

    public abstract ObjectResponse<M> wrapResponse(HttpResponse httpResponse);
}
