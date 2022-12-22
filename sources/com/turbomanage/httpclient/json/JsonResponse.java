package com.turbomanage.httpclient.json;

import com.turbomanage.httpclient.HttpResponse;
import com.turbomanage.httpclient.rest.ObjectFactory;
import com.turbomanage.httpclient.rest.ObjectResponse;

public class JsonResponse extends ObjectResponse<JsonType> {
    public JsonResponse(HttpResponse httpResponse, ObjectFactory<JsonType> objectFactory) {
        super(httpResponse, objectFactory);
    }
}
