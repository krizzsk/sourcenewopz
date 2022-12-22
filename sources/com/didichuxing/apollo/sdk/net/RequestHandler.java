package com.didichuxing.apollo.sdk.net;

public abstract class RequestHandler {
    private RequestParams mRequestParams = new RequestParams();

    public abstract void handleRequestParams(RequestParams requestParams);

    /* access modifiers changed from: package-private */
    public RequestParams getRequestParams() {
        handleRequestParams(this.mRequestParams);
        return this.mRequestParams;
    }
}
