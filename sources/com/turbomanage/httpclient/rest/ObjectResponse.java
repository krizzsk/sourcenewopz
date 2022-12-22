package com.turbomanage.httpclient.rest;

import com.turbomanage.httpclient.HttpResponse;
import com.turbomanage.httpclient.rest.MediaType;

public abstract class ObjectResponse<M extends MediaType> {
    protected HttpResponse httpResponse;
    protected ObjectFactory<M> objFactory;

    public ObjectResponse(HttpResponse httpResponse2, ObjectFactory<M> objectFactory) {
        this.httpResponse = httpResponse2;
        this.objFactory = objectFactory;
    }

    public <T> T toObj(Class<T> cls) {
        return this.objFactory.toObj(this.httpResponse.getBody(), cls);
    }

    public HttpResponse getHttpResponse() {
        return this.httpResponse;
    }
}
