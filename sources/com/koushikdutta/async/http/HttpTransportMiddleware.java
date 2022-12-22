package com.koushikdutta.async.http;

import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import com.koushikdutta.async.http.filter.ChunkedOutputFilter;

public class HttpTransportMiddleware extends SimpleMiddleware {
    /* renamed from: a */
    static boolean m39859a(int i) {
        return (i >= 100 && i <= 199) || i == 204 || i == 304;
    }

    /* JADX WARNING: type inference failed for: r5v1, types: [com.koushikdutta.async.AsyncSocket] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean exchangeHeaders(final com.koushikdutta.async.http.AsyncHttpClientMiddleware.OnExchangeHeaderData r10) {
        /*
            r9 = this;
            java.lang.String r0 = r10.protocol
            com.koushikdutta.async.http.Protocol r0 = com.koushikdutta.async.http.Protocol.get(r0)
            if (r0 == 0) goto L_0x0015
            com.koushikdutta.async.http.Protocol r1 = com.koushikdutta.async.http.Protocol.HTTP_1_0
            if (r0 == r1) goto L_0x0015
            com.koushikdutta.async.http.Protocol r1 = com.koushikdutta.async.http.Protocol.HTTP_1_1
            if (r0 == r1) goto L_0x0015
            boolean r10 = super.exchangeHeaders(r10)
            return r10
        L_0x0015:
            com.koushikdutta.async.http.AsyncHttpRequest r0 = r10.request
            com.koushikdutta.async.http.AsyncHttpRequest r1 = r10.request
            com.koushikdutta.async.http.body.AsyncHttpRequestBody r1 = r1.getBody()
            if (r1 == 0) goto L_0x006f
            int r2 = r1.length()
            if (r2 < 0) goto L_0x003e
            com.koushikdutta.async.http.Headers r2 = r0.getHeaders()
            int r3 = r1.length()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Content-Length"
            r2.set(r4, r3)
            com.koushikdutta.async.http.AsyncHttpClientMiddleware$ResponseHead r2 = r10.response
            com.koushikdutta.async.AsyncSocket r3 = r10.socket
            r2.sink(r3)
            goto L_0x006f
        L_0x003e:
            com.koushikdutta.async.http.Headers r2 = r0.getHeaders()
            java.lang.String r3 = "Connection"
            java.lang.String r2 = r2.get(r3)
            java.lang.String r3 = "close"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0058
            com.koushikdutta.async.http.AsyncHttpClientMiddleware$ResponseHead r2 = r10.response
            com.koushikdutta.async.AsyncSocket r3 = r10.socket
            r2.sink(r3)
            goto L_0x006f
        L_0x0058:
            com.koushikdutta.async.http.Headers r2 = r0.getHeaders()
            java.lang.String r3 = "Transfer-Encoding"
            java.lang.String r4 = "Chunked"
            r2.set(r3, r4)
            com.koushikdutta.async.http.AsyncHttpClientMiddleware$ResponseHead r2 = r10.response
            com.koushikdutta.async.http.filter.ChunkedOutputFilter r3 = new com.koushikdutta.async.http.filter.ChunkedOutputFilter
            com.koushikdutta.async.AsyncSocket r4 = r10.socket
            r3.<init>(r4)
            r2.sink(r3)
        L_0x006f:
            com.koushikdutta.async.http.RequestLine r2 = r0.getRequestLine()
            java.lang.String r2 = r2.toString()
            com.koushikdutta.async.http.Headers r3 = r0.getHeaders()
            java.lang.String r2 = r3.toPrefixString(r2)
            byte[] r3 = r2.getBytes()
            r4 = 1
            if (r1 == 0) goto L_0x0098
            int r5 = r1.length()
            if (r5 < 0) goto L_0x0098
            int r1 = r1.length()
            int r5 = r3.length
            int r1 = r1 + r5
            r5 = 1024(0x400, float:1.435E-42)
            if (r1 >= r5) goto L_0x0098
            r1 = 1
            goto L_0x0099
        L_0x0098:
            r1 = 0
        L_0x0099:
            if (r1 == 0) goto L_0x00b0
            com.koushikdutta.async.BufferedDataSink r1 = new com.koushikdutta.async.BufferedDataSink
            com.koushikdutta.async.http.AsyncHttpClientMiddleware$ResponseHead r5 = r10.response
            com.koushikdutta.async.DataSink r5 = r5.sink()
            r1.<init>(r5)
            r1.forceBuffering(r4)
            com.koushikdutta.async.http.AsyncHttpClientMiddleware$ResponseHead r5 = r10.response
            r5.sink(r1)
            r5 = r1
            goto L_0x00b6
        L_0x00b0:
            r1 = 0
            com.koushikdutta.async.AsyncSocket r5 = r10.socket
            r8 = r5
            r5 = r1
            r1 = r8
        L_0x00b6:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "\n"
            r6.append(r7)
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r0.logv(r2)
            com.koushikdutta.async.callback.CompletedCallback r0 = r10.sendHeadersCallback
            com.koushikdutta.async.http.HttpTransportMiddleware$1 r2 = new com.koushikdutta.async.http.HttpTransportMiddleware$1
            r2.<init>(r0, r5)
            com.koushikdutta.async.C20137Util.writeAll((com.koushikdutta.async.DataSink) r1, (byte[]) r3, (com.koushikdutta.async.callback.CompletedCallback) r2)
            com.koushikdutta.async.http.HttpTransportMiddleware$2 r0 = new com.koushikdutta.async.http.HttpTransportMiddleware$2
            r0.<init>(r10)
            com.koushikdutta.async.LineEmitter r1 = new com.koushikdutta.async.LineEmitter
            r1.<init>()
            com.koushikdutta.async.AsyncSocket r10 = r10.socket
            r10.setDataCallback(r1)
            r1.setLineCallback(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.http.HttpTransportMiddleware.exchangeHeaders(com.koushikdutta.async.http.AsyncHttpClientMiddleware$OnExchangeHeaderData):boolean");
    }

    public void onRequestSent(AsyncHttpClientMiddleware.OnRequestSentData onRequestSentData) {
        Protocol protocol = Protocol.get(onRequestSentData.protocol);
        if ((protocol == null || protocol == Protocol.HTTP_1_0 || protocol == Protocol.HTTP_1_1) && (onRequestSentData.response.sink() instanceof ChunkedOutputFilter)) {
            onRequestSentData.response.sink().end();
        }
    }
}
