package com.koushikdutta.async.http;

import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;

public class SimpleMiddleware implements AsyncHttpClientMiddleware {
    public boolean exchangeHeaders(AsyncHttpClientMiddleware.OnExchangeHeaderData onExchangeHeaderData) {
        return false;
    }

    public Cancellable getSocket(AsyncHttpClientMiddleware.GetSocketData getSocketData) {
        return null;
    }

    public void onBodyDecoder(AsyncHttpClientMiddleware.OnBodyDecoderData onBodyDecoderData) {
    }

    public void onHeadersReceived(AsyncHttpClientMiddleware.OnHeadersReceivedData onHeadersReceivedData) {
    }

    public void onRequest(AsyncHttpClientMiddleware.OnRequestData onRequestData) {
    }

    public void onRequestSent(AsyncHttpClientMiddleware.OnRequestSentData onRequestSentData) {
    }

    public void onResponseComplete(AsyncHttpClientMiddleware.OnResponseCompleteData onResponseCompleteData) {
    }

    public AsyncHttpRequest onResponseReady(AsyncHttpClientMiddleware.OnResponseReadyData onResponseReadyData) {
        return null;
    }
}
