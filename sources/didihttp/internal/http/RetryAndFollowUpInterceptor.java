package didihttp.internal.http;

import android.os.SystemClock;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.http.AsyncHttpHead;
import didihttp.Address;
import didihttp.Call;
import didihttp.CertificatePinner;
import didihttp.DidiHttpClient;
import didihttp.Dns;
import didihttp.HttpUrl;
import didihttp.Interceptor;
import didihttp.LogEventListener;
import didihttp.Request;
import didihttp.RequestBody;
import didihttp.Response;
import didihttp.Route;
import didihttp.ServerCallItem;
import didihttp.StatisticalContext;
import didihttp.internal.C20747Util;
import didihttp.internal.connection.RealConnection;
import didihttp.internal.connection.RouteExException;
import didihttp.internal.connection.RouteException;
import didihttp.internal.connection.StreamAllocation;
import didihttp.internal.http2.ConnectionShutdownException;
import didihttp.internal.trace.Tree;
import didinet.Logger;
import didinet.NetConfig;
import didinet.NetEngine;
import diditransreq.Http2SocketException;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class RetryAndFollowUpInterceptor implements Interceptor {

    /* renamed from: a */
    private static final String f56715a = "InnerRetry";

    /* renamed from: b */
    private static final int f56716b = 20;

    /* renamed from: c */
    private static final String f56717c = "Retry";

    /* renamed from: d */
    private final DidiHttpClient f56718d;

    /* renamed from: e */
    private final boolean f56719e;

    /* renamed from: f */
    private StreamAllocation f56720f;

    /* renamed from: g */
    private Object f56721g;

    /* renamed from: h */
    private volatile boolean f56722h;

    public RetryAndFollowUpInterceptor(DidiHttpClient didiHttpClient, boolean z) {
        this.f56718d = didiHttpClient;
        this.f56719e = z;
    }

    public void cancel() {
        this.f56722h = true;
        StreamAllocation streamAllocation = this.f56720f;
        if (streamAllocation != null) {
            streamAllocation.cancel();
        }
    }

    public boolean isCanceled() {
        return this.f56722h;
    }

    public void setCallStackTrace(Object obj) {
        this.f56721g = obj;
    }

    public StreamAllocation streamAllocation() {
        return this.f56720f;
    }

    /* JADX WARNING: type inference failed for: r15v0 */
    /* JADX WARNING: type inference failed for: r15v1, types: [didihttp.Connection, didihttp.ResponseBody, didihttp.internal.http.HttpCodec] */
    /* JADX WARNING: type inference failed for: r15v7 */
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        long j;
        Request request;
        int i;
        Request request2 = chain.request();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        StatisticalContext statisticalContext = (StatisticalContext) realInterceptorChain.getExtraData();
        Call call = realInterceptorChain.call();
        LogEventListener logEventListener = realInterceptorChain.logEventListener();
        Tree tree = realInterceptorChain.tree();
        this.f56720f = new StreamAllocation(this.f56718d.connectionPool(), m40709a(request2.url(), statisticalContext), this.f56721g, call, logEventListener);
        long totalStartTime = statisticalContext.getTotalStartTime();
        ? r15 = 0;
        boolean z2 = false;
        Request request3 = request2;
        Response response = null;
        int i2 = 0;
        while (!this.f56722h) {
            try {
                Response proceed = ((RealInterceptorChain) chain).proceed(request3, this.f56720f, r15, r15);
                if (response != null) {
                    proceed = proceed.newBuilder().priorResponse(response.newBuilder().body(r15).build()).build();
                }
                Request a = m40711a(proceed);
                if (a == null) {
                    if (!this.f56719e) {
                        this.f56720f.release();
                    }
                    return proceed;
                }
                C20747Util.closeQuietly((Closeable) proceed.body());
                int i3 = i2 + 1;
                if (i3 > 20) {
                    this.f56720f.release();
                    throw new ProtocolException("Too many follow-up requests: " + i3);
                } else if (!(a.body() instanceof UnrepeatableRequestBody)) {
                    if (!m40715a(proceed, a.url())) {
                        this.f56720f.release();
                        StreamAllocation streamAllocation = r2;
                        request = a;
                        i = i3;
                        StreamAllocation streamAllocation2 = new StreamAllocation(this.f56718d.connectionPool(), m40709a(a.url(), statisticalContext), this.f56721g, call, logEventListener);
                        this.f56720f = streamAllocation;
                    } else {
                        request = a;
                        i = i3;
                        if (this.f56720f.codec() != null) {
                            throw new IllegalStateException("Closing the body of " + proceed + " didn't close its backing stream. Bad interceptor?");
                        }
                    }
                    statisticalContext.newServerCallData();
                    statisticalContext.addRedirectCount();
                    logEventListener.redirect(call);
                    i2 = i;
                    request3 = request;
                    z = false;
                    response = proceed;
                    r15 = z;
                } else {
                    this.f56720f.release();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", proceed.code());
                }
            } catch (Http2SocketException e) {
                j = totalStartTime;
                Request request4 = request3;
                statisticalContext.currentServerCallData().setThrowable(e);
                statisticalContext.newServerCallData();
                statisticalContext.addRetryCount();
                request3 = m40710a(m40712a(statisticalContext, request4));
                logEventListener.retry(call, e);
                tree.popTo(this);
                totalStartTime = j;
                z = false;
                r15 = z;
            } catch (RouteExException e2) {
                statisticalContext.addFailIP(statisticalContext.currentServerCallData().getRemoteAddress());
                throw e2.getLastConnectException();
            } catch (RouteException e3) {
                j = totalStartTime;
                Request request5 = request3;
                ServerCallItem currentServerCallData = statisticalContext.currentServerCallData();
                statisticalContext.addFailIP(currentServerCallData.getRemoteAddress());
                if (m40717a(e3.getLastConnectException(), false, request5, j, statisticalContext)) {
                    currentServerCallData.setThrowable(e3);
                    statisticalContext.newServerCallData();
                    statisticalContext.addRetryCount();
                    request3 = m40712a(statisticalContext, request5);
                    logEventListener.retry(call, e3);
                    tree.popTo(this);
                    totalStartTime = j;
                    z = false;
                    r15 = z;
                } else {
                    throw e3.getLastConnectException();
                }
            } catch (IOException e4) {
                ServerCallItem currentServerCallData2 = statisticalContext.currentServerCallData();
                statisticalContext.addFailIP(currentServerCallData2.getRemoteAddress());
                long j2 = totalStartTime;
                j = totalStartTime;
                Request request6 = request3;
                if (m40717a(e4, !(e4 instanceof ConnectionShutdownException), request3, j2, statisticalContext)) {
                    currentServerCallData2.setThrowable(e4);
                    statisticalContext.newServerCallData();
                    statisticalContext.addRetryCount();
                    request3 = m40712a(statisticalContext, request6);
                    logEventListener.retry(call, e4);
                    tree.popTo(this);
                    totalStartTime = j;
                    z = false;
                    r15 = z;
                } else {
                    throw e4;
                }
            } catch (Throwable th) {
                th = th;
            }
        }
        this.f56720f.release();
        throw new IOException("Canceled");
        if (z2) {
            this.f56720f.streamFailed((IOException) null);
            this.f56720f.release();
        }
        throw th;
    }

    /* renamed from: a */
    private Address m40709a(HttpUrl httpUrl, StatisticalContext statisticalContext) {
        CertificatePinner certificatePinner;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (httpUrl.isHttps()) {
            SSLSocketFactory sslSocketFactory = this.f56718d.sslSocketFactory();
            hostnameVerifier = this.f56718d.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = this.f56718d.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        Dns customDns = statisticalContext.getCustomDns();
        if (customDns == null) {
            customDns = this.f56718d.dns();
        }
        return new Address(httpUrl, customDns, this.f56718d.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.f56718d.proxyAuthenticator(), this.f56718d.proxy(), this.f56718d.protocols(), this.f56718d.connectionSpecs(), this.f56718d.proxySelector());
    }

    /* renamed from: a */
    private boolean m40717a(IOException iOException, boolean z, Request request, long j, StatisticalContext statisticalContext) {
        this.f56720f.streamFailed(iOException);
        if (m40714a(request, statisticalContext) || !this.f56718d.retryOnConnectionFailure()) {
            return false;
        }
        if ((z && (request.body() instanceof UnrepeatableRequestBody)) || !m40716a(iOException, z)) {
            return false;
        }
        if (this.f56720f.hasMoreRoutes() || m40713a(request, j, statisticalContext)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m40716a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z) {
                return false;
            }
            return true;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    private boolean m40714a(Request request, StatisticalContext statisticalContext) {
        NetConfig.UrlConfig urlConfig = NetEngine.getInstance().getNetConfig().getUrlConfig(request.url());
        return urlConfig != null && urlConfig.getRetryMaxCount() >= 0 && statisticalContext.getRetryCount() >= urlConfig.getRetryMaxCount();
    }

    /* renamed from: a */
    private boolean m40713a(Request request, long j, StatisticalContext statisticalContext) {
        NetConfig netConfig = NetEngine.getInstance().getNetConfig();
        if (!netConfig.useTotalTimeout()) {
            return false;
        }
        NetConfig.UrlConfig urlConfig = netConfig.getUrlConfig(request.url());
        Logger.m40928d(f56715a, String.format("[%s] api: [%s], retryCount:%d, config => %s", new Object[]{f56715a, netConfig.getHostApi(request.url().toString()), Integer.valueOf(statisticalContext.getRetryCount()), urlConfig}));
        if (urlConfig != null) {
            int retryTotalTimeout = urlConfig.getRetryTotalTimeout();
            long j2 = (long) retryTotalTimeout;
            boolean z = SystemClock.uptimeMillis() - j > j2;
            if (!z) {
                urlConfig.sleepRetryInterval();
                z = SystemClock.uptimeMillis() - j > j2;
                if (!z) {
                    this.f56720f.resetProxyIfNoRoutes();
                    statisticalContext.setUrlConfigVer(urlConfig.getListType());
                    Logger.m40928d(f56715a, String.format("[%s] allowInnerRetry => %b, [useTotalTimeout:%b timeout => %b [used:%d, config:%d]", new Object[]{f56715a, Boolean.valueOf(!z), Boolean.valueOf(netConfig.useTotalTimeout()), Boolean.valueOf(z), Long.valueOf(SystemClock.uptimeMillis() - j), Integer.valueOf(retryTotalTimeout)}));
                    return !z;
                }
            }
            Logger.m40928d(f56715a, String.format("[%s] allowInnerRetry => %b, [useTotalTimeout:%b timeout => %b [used:%d, config:%d]", new Object[]{f56715a, Boolean.valueOf(!z), Boolean.valueOf(netConfig.useTotalTimeout()), Boolean.valueOf(z), Long.valueOf(SystemClock.uptimeMillis() - j), Integer.valueOf(retryTotalTimeout)}));
            return !z;
        }
        Logger.m40928d(f56715a, String.format("[%s] allowInnerRetry => false, [useTotalTimeout:%b]", new Object[]{f56715a, Boolean.valueOf(netConfig.useTotalTimeout())}));
        return false;
    }

    /* renamed from: a */
    private Request m40712a(StatisticalContext statisticalContext, Request request) {
        NetConfig.UrlConfig urlConfig = NetEngine.getInstance().getNetConfig().getUrlConfig(request.url());
        int retryMaxCount = urlConfig != null ? urlConfig.getRetryMaxCount() : -1;
        int retryCount = statisticalContext.getRetryCount();
        Request.Builder newBuilder = request.newBuilder();
        newBuilder.header(f56717c, String.format("%d/%d", new Object[]{Integer.valueOf(retryCount), Integer.valueOf(retryMaxCount)}));
        return newBuilder.build();
    }

    /* renamed from: a */
    private Request m40710a(Request request) {
        Request.Builder newBuilder = request.newBuilder();
        newBuilder.header("L2SDemotion", "1");
        return newBuilder.build();
    }

    /* renamed from: a */
    private Request m40711a(Response response) throws IOException {
        String header;
        HttpUrl resolve;
        Proxy proxy;
        if (response != null) {
            RealConnection connection = this.f56720f.connection();
            RequestBody requestBody = null;
            Route route = connection != null ? connection.route() : null;
            int code = response.code();
            String method = response.request().method();
            if (code == 307 || code == 308) {
                if (!method.equals("GET") && !method.equals(AsyncHttpHead.METHOD)) {
                    return null;
                }
            } else if (code == 401) {
                return this.f56718d.authenticator().authenticate(route, response);
            } else {
                if (code == 407) {
                    if (route != null) {
                        proxy = route.proxy();
                    } else {
                        proxy = this.f56718d.proxy();
                    }
                    if (proxy.type() == Proxy.Type.HTTP) {
                        return this.f56718d.proxyAuthenticator().authenticate(route, response);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                } else if (code != 408) {
                    switch (code) {
                        case 300:
                        case 301:
                        case 302:
                        case 303:
                            break;
                        default:
                            return null;
                    }
                } else if (response.request().body() instanceof UnrepeatableRequestBody) {
                    return null;
                } else {
                    return response.request();
                }
            }
            if (!this.f56718d.followRedirects() || (header = response.header("Location")) == null || (resolve = response.request().url().resolve(header)) == null) {
                return null;
            }
            if (!resolve.scheme().equals(response.request().url().scheme()) && !this.f56718d.followSslRedirects()) {
                return null;
            }
            Request.Builder newBuilder = response.request().newBuilder();
            if (HttpMethod.permitsRequestBody(method)) {
                boolean redirectsWithBody = HttpMethod.redirectsWithBody(method);
                if (HttpMethod.redirectsToGet(method)) {
                    newBuilder.method("GET", (RequestBody) null);
                } else {
                    if (redirectsWithBody) {
                        requestBody = response.request().body();
                    }
                    newBuilder.method(method, requestBody);
                }
                if (!redirectsWithBody) {
                    newBuilder.removeHeader(HttpHeaders.TRANSFER_ENCODING);
                    newBuilder.removeHeader(HttpHeaders.CONTENT_LENGTH);
                    newBuilder.removeHeader("Content-Type");
                }
            }
            if (!m40715a(response, resolve)) {
                newBuilder.removeHeader(HttpHeaders.AUTHORIZATION);
            }
            return newBuilder.url(resolve).build();
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    private boolean m40715a(Response response, HttpUrl httpUrl) {
        HttpUrl url = response.request().url();
        return url.host().equals(httpUrl.host()) && url.port() == httpUrl.port() && url.scheme().equals(httpUrl.scheme());
    }
}
