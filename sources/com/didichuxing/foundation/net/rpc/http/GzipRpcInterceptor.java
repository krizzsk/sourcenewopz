package com.didichuxing.foundation.net.rpc.http;

import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import okio.Sink;

public class GzipRpcInterceptor implements HttpRpcInterceptor {
    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        if (request.getEntity() == null || request.getHeader(HttpHeaders.CONTENT_ENCODING) != null) {
            return rpcChain.proceed(request);
        }
        return rpcChain.proceed(request.newBuilder().addHeader(HttpHeaders.CONTENT_ENCODING, "gzip").setMethod(request.getMethod(), m34058a(request.getEntity())).build());
    }

    /* renamed from: a */
    private static HttpEntity m34058a(final HttpEntity httpEntity) throws IOException {
        final Buffer buffer = new Buffer();
        BufferedSink buffer2 = Okio.buffer((Sink) new GzipSink(buffer));
        httpEntity.writeTo(buffer2.outputStream());
        buffer2.close();
        final long size = buffer.size();
        return new HttpBody() {
            public InputStream getContent() throws IOException {
                return Buffer.this.inputStream();
            }

            public MimeType getContentType() {
                return httpEntity.getContentType();
            }

            public long getContentLength() throws IOException {
                return size;
            }

            public void close() throws IOException {
                Buffer.this.close();
            }
        };
    }
}
