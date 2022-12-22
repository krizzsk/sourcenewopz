package com.turbomanage.httpclient.rest;

import com.turbomanage.httpclient.AbstractHttpClient;
import com.turbomanage.httpclient.AsyncHttpClient;
import com.turbomanage.httpclient.HttpResponse;
import com.turbomanage.httpclient.ParameterMap;
import com.turbomanage.httpclient.rest.MediaType;

public abstract class AsyncRestClient<M extends MediaType> {
    protected AsyncHttpClient httpClient;
    protected ObjectFactory<M> objFactory;
    protected ResultHandler resultHandler;

    public AsyncRestClient(AsyncHttpClient asyncHttpClient, ObjectFactory<M> objectFactory, ResultHandler resultHandler2) {
        this.httpClient = asyncHttpClient;
        this.objFactory = objectFactory;
        this.resultHandler = resultHandler2;
    }

    public ObjectResponse<M> get(String str, ParameterMap parameterMap) {
        HttpResponse httpResponse = this.httpClient.get(str, parameterMap);
        if (this.resultHandler.onResult(httpResponse)) {
            return this.objFactory.wrapResponse(httpResponse);
        }
        return null;
    }

    public <T> T get(String str, ParameterMap parameterMap, Class<T> cls) {
        HttpResponse httpResponse = this.httpClient.get(str, parameterMap);
        if (!this.resultHandler.onResult(httpResponse) || httpResponse == null) {
            return null;
        }
        return this.objFactory.wrapResponse(httpResponse).toObj(cls);
    }

    public <T> ObjectResponse<M> post(String str, T t) {
        HttpResponse post = this.httpClient.post(str, AbstractHttpClient.JSON, toBytes(t));
        if (this.resultHandler.onResult(post)) {
            return this.objFactory.wrapResponse(post);
        }
        return null;
    }

    public <T> ObjectResponse<M> put(String str, T t) {
        HttpResponse put = this.httpClient.put(str, AbstractHttpClient.JSON, toBytes(t));
        if (this.resultHandler.onResult(put)) {
            return this.objFactory.wrapResponse(put);
        }
        return null;
    }

    public ObjectResponse<M> delete(String str, ParameterMap parameterMap) {
        HttpResponse delete = this.httpClient.delete(str, parameterMap);
        if (this.resultHandler.onResult(delete)) {
            return this.objFactory.wrapResponse(delete);
        }
        return null;
    }

    public <T> byte[] toBytes(T t) {
        return this.objFactory.toBytes(t);
    }
}
