package com.didichuxing.foundation.rpc;

import com.didichuxing.foundation.net.DnsResolver;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponse;
import didihttp.Dns;
import java.net.CookieHandler;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public interface RpcClient<Request extends RpcRequest, Response extends RpcResponse> {

    public interface Builder<Request extends RpcRequest, Response extends RpcResponse> {
        Builder<Request, Response> addInterceptor(RpcInterceptor<Request, Response> rpcInterceptor);

        RpcClient<Request, Response> build();

        Builder<Request, Response> setConnectTimeout(long j);

        Builder<Request, Response> setCookieHandler(CookieHandler cookieHandler);

        Builder<Request, Response> setDnsResolver(DnsResolver dnsResolver);

        Builder<Request, Response> setExecutorService(ExecutorService executorService);

        Builder<Request, Response> setHostnameVerifier(HostnameVerifier hostnameVerifier);

        Builder<Request, Response> setInnerRetryOnConnectionFailure(boolean z);

        Builder<Request, Response> setProtocols(String... strArr) throws IllegalArgumentException;

        Builder<Request, Response> setProxy(Proxy proxy);

        Builder<Request, Response> setReadTimeout(long j);

        Builder<Request, Response> setSSLSocketFactory(SSLSocketFactory sSLSocketFactory);

        Builder<Request, Response> setSSLSocketFactory(SSLSocketFactory sSLSocketFactory, TrustManager trustManager);

        Builder<Request, Response> setSocketFactory(SocketFactory socketFactory);

        Builder<Request, Response> setWriteTimeout(long j);
    }

    void cancel(Object obj);

    long getConnectTimeout();

    CookieHandler getCookieHandler();

    DnsResolver getDnsResolver();

    ExecutorService getExecutorService();

    HostnameVerifier getHostnameVerifier();

    boolean getInnerRetry();

    List<RpcProtocol> getProtocols();

    Proxy getProxy();

    long getReadTimeout();

    SSLSocketFactory getSSLSocketFactory();

    SocketFactory getSocketFactory();

    String getUserAgent();

    long getWriteTimeout();

    Builder<Request, Response> newBuilder();

    RpcRequest.Builder newRequestBuilder();

    RpcResponse.Builder newResponseBuilder();

    Rpc<Request, Response> newRpc(Request request);

    void setConnectTimeout(long j);

    void setDns(Dns dns);

    void setInnerRetry(boolean z);

    void setReadTimeout(long j);

    void setWriteTimeout(long j);
}
