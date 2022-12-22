package okhttp3.internal.http;

import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.http.AsyncHttpHead;
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
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Route;
import okhttp3.internal.C2434Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http2.ConnectionShutdownException;

public final class RetryAndFollowUpInterceptor implements Interceptor {

    /* renamed from: a */
    private static final int f5373a = 20;

    /* renamed from: b */
    private final OkHttpClient f5374b;

    /* renamed from: c */
    private final boolean f5375c;

    /* renamed from: d */
    private volatile StreamAllocation f5376d;

    /* renamed from: e */
    private Object f5377e;

    /* renamed from: f */
    private volatile boolean f5378f;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient, boolean z) {
        this.f5374b = okHttpClient;
        this.f5375c = z;
    }

    public void cancel() {
        this.f5378f = true;
        StreamAllocation streamAllocation = this.f5376d;
        if (streamAllocation != null) {
            streamAllocation.cancel();
        }
    }

    public boolean isCanceled() {
        return this.f5378f;
    }

    public void setCallStackTrace(Object obj) {
        this.f5377e = obj;
    }

    public StreamAllocation streamAllocation() {
        return this.f5376d;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Call call = realInterceptorChain.call();
        EventListener eventListener = realInterceptorChain.eventListener();
        StreamAllocation streamAllocation = new StreamAllocation(this.f5374b.connectionPool(), m3442a(request.url()), call, eventListener, this.f5377e);
        this.f5376d = streamAllocation;
        Response response = null;
        int i = 0;
        while (!this.f5378f) {
            try {
                Response proceed = realInterceptorChain.proceed(request, streamAllocation, (HttpCodec) null, (RealConnection) null);
                if (response != null) {
                    proceed = proceed.newBuilder().priorResponse(response.newBuilder().body((ResponseBody) null).build()).build();
                }
                try {
                    Request a = m3443a(proceed, streamAllocation.route());
                    if (a == null) {
                        streamAllocation.release();
                        return proceed;
                    }
                    C2434Util.closeQuietly((Closeable) proceed.body());
                    int i2 = i + 1;
                    if (i2 > 20) {
                        streamAllocation.release();
                        throw new ProtocolException("Too many follow-up requests: " + i2);
                    } else if (!(a.body() instanceof UnrepeatableRequestBody)) {
                        if (!m3446a(proceed, a.url())) {
                            streamAllocation.release();
                            streamAllocation = new StreamAllocation(this.f5374b.connectionPool(), m3442a(a.url()), call, eventListener, this.f5377e);
                            this.f5376d = streamAllocation;
                        } else if (streamAllocation.codec() != null) {
                            throw new IllegalStateException("Closing the body of " + proceed + " didn't close its backing stream. Bad interceptor?");
                        }
                        response = proceed;
                        request = a;
                        i = i2;
                    } else {
                        streamAllocation.release();
                        throw new HttpRetryException("Cannot retry streamed HTTP body", proceed.code());
                    }
                } catch (IOException e) {
                    streamAllocation.release();
                    throw e;
                }
            } catch (RouteException e2) {
                if (!m3444a(e2.getLastConnectException(), streamAllocation, false, request)) {
                    throw e2.getFirstConnectException();
                }
            } catch (IOException e3) {
                if (!m3444a(e3, streamAllocation, !(e3 instanceof ConnectionShutdownException), request)) {
                    throw e3;
                }
            } catch (Throwable th) {
                streamAllocation.streamFailed((IOException) null);
                streamAllocation.release();
                throw th;
            }
        }
        streamAllocation.release();
        throw new IOException("Canceled");
    }

    /* renamed from: a */
    private Address m3442a(HttpUrl httpUrl) {
        CertificatePinner certificatePinner;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (httpUrl.isHttps()) {
            SSLSocketFactory sslSocketFactory = this.f5374b.sslSocketFactory();
            hostnameVerifier = this.f5374b.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = this.f5374b.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.f5374b.dns(), this.f5374b.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.f5374b.proxyAuthenticator(), this.f5374b.proxy(), this.f5374b.protocols(), this.f5374b.connectionSpecs(), this.f5374b.proxySelector());
    }

    /* renamed from: a */
    private boolean m3444a(IOException iOException, StreamAllocation streamAllocation, boolean z, Request request) {
        streamAllocation.streamFailed(iOException);
        if (!this.f5374b.retryOnConnectionFailure()) {
            return false;
        }
        if ((!z || !(request.body() instanceof UnrepeatableRequestBody)) && m3445a(iOException, z) && streamAllocation.hasMoreRoutes()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m3445a(IOException iOException, boolean z) {
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
    private Request m3443a(Response response, Route route) throws IOException {
        String header;
        HttpUrl resolve;
        Proxy proxy;
        if (response != null) {
            int code = response.code();
            String method = response.request().method();
            RequestBody requestBody = null;
            if (code == 307 || code == 308) {
                if (!method.equals("GET") && !method.equals(AsyncHttpHead.METHOD)) {
                    return null;
                }
            } else if (code == 401) {
                return this.f5374b.authenticator().authenticate(route, response);
            } else {
                if (code != 503) {
                    if (code == 407) {
                        if (route != null) {
                            proxy = route.proxy();
                        } else {
                            proxy = this.f5374b.proxy();
                        }
                        if (proxy.type() == Proxy.Type.HTTP) {
                            return this.f5374b.proxyAuthenticator().authenticate(route, response);
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
                    } else if (!this.f5374b.retryOnConnectionFailure() || (response.request().body() instanceof UnrepeatableRequestBody)) {
                        return null;
                    } else {
                        if ((response.priorResponse() == null || response.priorResponse().code() != 408) && m3441a(response, 0) <= 0) {
                            return response.request();
                        }
                        return null;
                    }
                } else if ((response.priorResponse() == null || response.priorResponse().code() != 503) && m3441a(response, Integer.MAX_VALUE) == 0) {
                    return response.request();
                } else {
                    return null;
                }
            }
            if (!this.f5374b.followRedirects() || (header = response.header("Location")) == null || (resolve = response.request().url().resolve(header)) == null) {
                return null;
            }
            if (!resolve.scheme().equals(response.request().url().scheme()) && !this.f5374b.followSslRedirects()) {
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
            if (!m3446a(response, resolve)) {
                newBuilder.removeHeader(HttpHeaders.AUTHORIZATION);
            }
            return newBuilder.url(resolve).build();
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    private int m3441a(Response response, int i) {
        String header = response.header(HttpHeaders.RETRY_AFTER);
        if (header == null) {
            return i;
        }
        if (header.matches("\\d+")) {
            return Integer.valueOf(header).intValue();
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: a */
    private boolean m3446a(Response response, HttpUrl httpUrl) {
        HttpUrl url = response.request().url();
        return url.host().equals(httpUrl.host()) && url.port() == httpUrl.port() && url.scheme().equals(httpUrl.scheme());
    }
}
