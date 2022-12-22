package com.didichuxing.foundation.net.rpc.http;

import com.didichuxing.foundation.net.DnsResolver;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcClient;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import didihttp.Dns;
import java.net.CookieHandler;
import java.net.Proxy;
import java.util.concurrent.ExecutorService;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public abstract class HttpRpcClient implements RpcClient<HttpRpcRequest, HttpRpcResponse> {

    public static abstract class Builder implements RpcClient.Builder<HttpRpcRequest, HttpRpcResponse> {
        public abstract Builder addInterceptor(RpcInterceptor<HttpRpcRequest, HttpRpcResponse> rpcInterceptor);

        public abstract HttpRpcClient build();

        public abstract Builder setConnectTimeout(long j);

        public abstract Builder setCookieHandler(CookieHandler cookieHandler);

        public abstract Builder setDnsResolver(DnsResolver dnsResolver);

        public abstract Builder setExecutorService(ExecutorService executorService);

        public abstract Builder setHostnameVerifier(HostnameVerifier hostnameVerifier);

        public abstract Builder setInnerRetryOnConnectionFailure(boolean z);

        public abstract Builder setProtocols(String... strArr) throws IllegalArgumentException;

        public abstract Builder setProxy(Proxy proxy);

        public abstract Builder setReadTimeout(long j);

        public abstract Builder setSSLSocketFactory(SSLSocketFactory sSLSocketFactory);

        public abstract Builder setSocketFactory(SocketFactory socketFactory);

        public abstract Builder setWriteTimeout(long j);
    }

    public boolean getInnerRetry() {
        return false;
    }

    public abstract Builder newBuilder();

    public abstract HttpRpc newRpc(HttpRpcRequest httpRpcRequest);

    public void setConnectTimeout(long j) {
    }

    public void setDns(Dns dns) {
    }

    public void setInnerRetry(boolean z) {
    }

    public void setReadTimeout(long j) {
    }

    public void setWriteTimeout(long j) {
    }

    public HttpRpcRequest.Builder newRequestBuilder() {
        return new HttpRpcRequest.Builder();
    }

    public HttpRpcResponse.Builder newResponseBuilder() {
        return new HttpRpcResponse.Builder();
    }
}
