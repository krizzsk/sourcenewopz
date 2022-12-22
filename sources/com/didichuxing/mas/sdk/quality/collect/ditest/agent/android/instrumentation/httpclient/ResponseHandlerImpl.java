package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.httpclient;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.TransactionState;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation.TransactionStateUtil;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

public final class ResponseHandlerImpl<T> implements ResponseHandler<T> {

    /* renamed from: a */
    private final ResponseHandler<T> f47986a;

    /* renamed from: b */
    private final TransactionState f47987b;

    private ResponseHandlerImpl(ResponseHandler<T> responseHandler, TransactionState transactionState) {
        this.f47986a = responseHandler;
        this.f47987b = transactionState;
    }

    public T handleResponse(HttpResponse httpResponse) throws IOException {
        TransactionStateUtil.inspectAndInstrument(this.f47987b, httpResponse);
        return this.f47986a.handleResponse(httpResponse);
    }

    public static <T> ResponseHandler<? extends T> wrap(ResponseHandler<? extends T> responseHandler, TransactionState transactionState) {
        return new ResponseHandlerImpl(responseHandler, transactionState);
    }
}
