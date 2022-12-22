package didihttp.internal.http;

import didihttp.Call;
import didihttp.Connection;
import didihttp.HttpUrl;
import didihttp.Interceptor;
import didihttp.LogEventListener;
import didihttp.Request;
import didihttp.Response;
import didihttp.internal.connection.StreamAllocation;
import didihttp.internal.trace.Node;
import didihttp.internal.trace.Tree;
import java.io.IOException;
import java.util.List;

public final class RealInterceptorChain implements Interceptor.Chain {

    /* renamed from: a */
    private final List<Interceptor> f56702a;

    /* renamed from: b */
    private final StreamAllocation f56703b;

    /* renamed from: c */
    private final HttpCodec f56704c;

    /* renamed from: d */
    private final Connection f56705d;

    /* renamed from: e */
    private final int f56706e;

    /* renamed from: f */
    private final Request f56707f;

    /* renamed from: g */
    private int f56708g;

    /* renamed from: h */
    private Call f56709h;

    /* renamed from: i */
    private LogEventListener f56710i;

    /* renamed from: j */
    private Object f56711j;

    /* renamed from: k */
    private Tree f56712k;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation streamAllocation, HttpCodec httpCodec, Connection connection, int i, Request request, Call call, LogEventListener logEventListener, Tree tree) {
        this.f56702a = list;
        this.f56705d = connection;
        this.f56703b = streamAllocation;
        this.f56704c = httpCodec;
        this.f56706e = i;
        this.f56707f = request;
        this.f56709h = call;
        this.f56710i = logEventListener;
        this.f56712k = tree;
    }

    public Connection connection() {
        return this.f56705d;
    }

    public StreamAllocation streamAllocation() {
        return this.f56703b;
    }

    public HttpCodec httpStream() {
        return this.f56704c;
    }

    public Request request() {
        return this.f56707f;
    }

    public Call call() {
        return this.f56709h;
    }

    public LogEventListener logEventListener() {
        return this.f56710i;
    }

    public Tree tree() {
        return this.f56712k;
    }

    public Response proceed(Request request) throws IOException {
        return proceed(request, this.f56703b, this.f56704c, this.f56705d);
    }

    public Response proceed(Request request, StreamAllocation streamAllocation, HttpCodec httpCodec, Connection connection) throws IOException {
        if (this.f56706e < this.f56702a.size()) {
            this.f56708g++;
            if (this.f56704c != null && !m40707a(request.url())) {
                throw new IllegalStateException("network interceptor " + this.f56702a.get(this.f56706e - 1) + " must retain the same host and port");
            } else if (this.f56704c == null || this.f56708g <= 1) {
                RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.f56702a, streamAllocation, httpCodec, connection, this.f56706e + 1, request, this.f56709h, this.f56710i, this.f56712k);
                realInterceptorChain.f56711j = this.f56711j;
                Interceptor interceptor = this.f56702a.get(this.f56706e);
                Node node = new Node();
                node.value = interceptor;
                this.f56712k.push(node);
                this.f56710i.interceptorStart(this.f56709h, interceptor);
                Response intercept = interceptor.intercept(realInterceptorChain);
                this.f56710i.interceptorEnd(this.f56709h, interceptor);
                this.f56712k.pop(node);
                if (httpCodec != null && this.f56706e + 1 < this.f56702a.size() && realInterceptorChain.f56708g != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                } else if (intercept != null) {
                    return intercept;
                } else {
                    throw new NullPointerException("interceptor " + interceptor + " returned null");
                }
            } else {
                throw new IllegalStateException("network interceptor " + this.f56702a.get(this.f56706e - 1) + " must call proceed() exactly once");
            }
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private boolean m40707a(HttpUrl httpUrl) {
        return httpUrl.host().equals(this.f56705d.route().address().url().host()) && httpUrl.port() == this.f56705d.route().address().url().port();
    }

    public Object getExtraData() {
        return this.f56711j;
    }

    public void setExtraData(Object obj) {
        this.f56711j = obj;
    }
}
