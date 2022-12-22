package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.C2434Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;

public final class RealInterceptorChain implements Interceptor.Chain {

    /* renamed from: a */
    private final List<Interceptor> f5358a;

    /* renamed from: b */
    private final StreamAllocation f5359b;

    /* renamed from: c */
    private final HttpCodec f5360c;

    /* renamed from: d */
    private final RealConnection f5361d;

    /* renamed from: e */
    private final int f5362e;

    /* renamed from: f */
    private final Request f5363f;

    /* renamed from: g */
    private final Call f5364g;

    /* renamed from: h */
    private final EventListener f5365h;

    /* renamed from: i */
    private final int f5366i;

    /* renamed from: j */
    private final int f5367j;

    /* renamed from: k */
    private final int f5368k;

    /* renamed from: l */
    private int f5369l;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection, int i, Request request, Call call, EventListener eventListener, int i2, int i3, int i4) {
        this.f5358a = list;
        this.f5361d = realConnection;
        this.f5359b = streamAllocation;
        this.f5360c = httpCodec;
        this.f5362e = i;
        this.f5363f = request;
        this.f5364g = call;
        this.f5365h = eventListener;
        this.f5366i = i2;
        this.f5367j = i3;
        this.f5368k = i4;
    }

    public Connection connection() {
        return this.f5361d;
    }

    public int connectTimeoutMillis() {
        return this.f5366i;
    }

    public Interceptor.Chain withConnectTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f5358a, this.f5359b, this.f5360c, this.f5361d, this.f5362e, this.f5363f, this.f5364g, this.f5365h, C2434Util.checkDuration("timeout", (long) i, timeUnit), this.f5367j, this.f5368k);
    }

    public int readTimeoutMillis() {
        return this.f5367j;
    }

    public Interceptor.Chain withReadTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f5358a, this.f5359b, this.f5360c, this.f5361d, this.f5362e, this.f5363f, this.f5364g, this.f5365h, this.f5366i, C2434Util.checkDuration("timeout", (long) i, timeUnit), this.f5368k);
    }

    public int writeTimeoutMillis() {
        return this.f5368k;
    }

    public Interceptor.Chain withWriteTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f5358a, this.f5359b, this.f5360c, this.f5361d, this.f5362e, this.f5363f, this.f5364g, this.f5365h, this.f5366i, this.f5367j, C2434Util.checkDuration("timeout", (long) i, timeUnit));
    }

    public StreamAllocation streamAllocation() {
        return this.f5359b;
    }

    public HttpCodec httpStream() {
        return this.f5360c;
    }

    public Call call() {
        return this.f5364g;
    }

    public EventListener eventListener() {
        return this.f5365h;
    }

    public Request request() {
        return this.f5363f;
    }

    public Response proceed(Request request) throws IOException {
        return proceed(request, this.f5359b, this.f5360c, this.f5361d);
    }

    public Response proceed(Request request, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection) throws IOException {
        if (this.f5362e < this.f5358a.size()) {
            this.f5369l++;
            if (this.f5360c != null && !this.f5361d.supportsUrl(request.url())) {
                throw new IllegalStateException("network interceptor " + this.f5358a.get(this.f5362e - 1) + " must retain the same host and port");
            } else if (this.f5360c == null || this.f5369l <= 1) {
                RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.f5358a, streamAllocation, httpCodec, realConnection, this.f5362e + 1, request, this.f5364g, this.f5365h, this.f5366i, this.f5367j, this.f5368k);
                Interceptor interceptor = this.f5358a.get(this.f5362e);
                Response intercept = interceptor.intercept(realInterceptorChain);
                if (httpCodec != null && this.f5362e + 1 < this.f5358a.size() && realInterceptorChain.f5369l != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                } else if (intercept == null) {
                    throw new NullPointerException("interceptor " + interceptor + " returned null");
                } else if (intercept.body() != null) {
                    return intercept;
                } else {
                    throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
                }
            } else {
                throw new IllegalStateException("network interceptor " + this.f5358a.get(this.f5362e - 1) + " must call proceed() exactly once");
            }
        } else {
            throw new AssertionError();
        }
    }
}
