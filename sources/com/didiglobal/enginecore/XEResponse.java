package com.didiglobal.enginecore;

import java.io.Closeable;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\b\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\b¨\u0006\u000f"}, mo175978d2 = {"Lcom/didiglobal/enginecore/XEResponse;", "Ljava/io/Closeable;", "request", "Lcom/didiglobal/enginecore/XERequest;", "body", "Lcom/didiglobal/enginecore/XEResponseBody;", "(Lcom/didiglobal/enginecore/XERequest;Lcom/didiglobal/enginecore/XEResponseBody;)V", "()Lcom/didiglobal/enginecore/XEResponseBody;", "()Lcom/didiglobal/enginecore/XERequest;", "-deprecated_body", "close", "", "newBuilder", "Lcom/didiglobal/enginecore/XEResponse$Builder;", "Builder", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XEResponse.kt */
public final class XEResponse implements Closeable {

    /* renamed from: a */
    private final XERequest f50109a;

    /* renamed from: b */
    private final XEResponseBody f50110b;

    public XEResponse(XERequest xERequest, XEResponseBody xEResponseBody) {
        Intrinsics.checkParameterIsNotNull(xERequest, "request");
        this.f50109a = xERequest;
        this.f50110b = xEResponseBody;
    }

    public final XERequest request() {
        return this.f50109a;
    }

    public final XEResponseBody body() {
        return this.f50110b;
    }

    public void close() {
        XEResponseBody xEResponseBody = this.f50110b;
        if (xEResponseBody != null) {
            xEResponseBody.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}))
    /* renamed from: -deprecated_body  reason: not valid java name */
    public final XEResponseBody m47045deprecated_body() {
        return this.f50110b;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, mo175978d2 = {"Lcom/didiglobal/enginecore/XEResponse$Builder;", "", "()V", "response", "Lcom/didiglobal/enginecore/XEResponse;", "(Lcom/didiglobal/enginecore/XEResponse;)V", "body", "Lcom/didiglobal/enginecore/XEResponseBody;", "getBody$engine_core_release", "()Lcom/didiglobal/enginecore/XEResponseBody;", "setBody$engine_core_release", "(Lcom/didiglobal/enginecore/XEResponseBody;)V", "request", "Lcom/didiglobal/enginecore/XERequest;", "getRequest$engine_core_release", "()Lcom/didiglobal/enginecore/XERequest;", "setRequest$engine_core_release", "(Lcom/didiglobal/enginecore/XERequest;)V", "build", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: XEResponse.kt */
    public static class Builder {
        private XEResponseBody body;
        private XERequest request;

        public final XERequest getRequest$engine_core_release() {
            return this.request;
        }

        public final void setRequest$engine_core_release(XERequest xERequest) {
            this.request = xERequest;
        }

        public final XEResponseBody getBody$engine_core_release() {
            return this.body;
        }

        public final void setBody$engine_core_release(XEResponseBody xEResponseBody) {
            this.body = xEResponseBody;
        }

        public Builder() {
        }

        public Builder(XEResponse xEResponse) {
            Intrinsics.checkParameterIsNotNull(xEResponse, "response");
            this.request = xEResponse.request();
            this.body = xEResponse.body();
        }

        public Builder request(XERequest xERequest) {
            Intrinsics.checkParameterIsNotNull(xERequest, "request");
            Builder builder = this;
            builder.request = xERequest;
            return builder;
        }

        public Builder body(XEResponseBody xEResponseBody) {
            Builder builder = this;
            builder.body = xEResponseBody;
            return builder;
        }

        public XEResponse build() {
            XERequest xERequest = this.request;
            if (xERequest != null) {
                return new XEResponse(xERequest, this.body);
            }
            throw new IllegalStateException("request == null".toString());
        }
    }
}
