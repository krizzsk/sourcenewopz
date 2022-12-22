package com.didiglobal.enginecore;

import com.didi.soda.customer.blocks.BlocksConst;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\b\tJ\r\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u000bJ\u0006\u0010\f\u001a\u00020\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\b¨\u0006\u000f"}, mo175978d2 = {"Lcom/didiglobal/enginecore/XERequest;", "", "keyId", "", "body", "Lcom/didiglobal/enginecore/XERequestBody;", "(Ljava/lang/String;Lcom/didiglobal/enginecore/XERequestBody;)V", "()Lcom/didiglobal/enginecore/XERequestBody;", "()Ljava/lang/String;", "-deprecated_body", "componentId", "-deprecated_componentId", "newBuilder", "Lcom/didiglobal/enginecore/XERequest$Builder;", "Builder", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: XERequest.kt */
public final class XERequest {

    /* renamed from: a */
    private final String f50107a;

    /* renamed from: b */
    private final XERequestBody f50108b;

    public XERequest(String str, XERequestBody xERequestBody) {
        Intrinsics.checkParameterIsNotNull(str, "keyId");
        this.f50107a = str;
        this.f50108b = xERequestBody;
    }

    public final String keyId() {
        return this.f50107a;
    }

    public final XERequestBody body() {
        return this.f50108b;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))
    /* renamed from: -deprecated_componentId  reason: not valid java name */
    public final String m47044deprecated_componentId() {
        return this.f50107a;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}))
    /* renamed from: -deprecated_body  reason: not valid java name */
    public final XERequestBody m47043deprecated_body() {
        return this.f50108b;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0016¢\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, mo175978d2 = {"Lcom/didiglobal/enginecore/XERequest$Builder;", "", "request", "Lcom/didiglobal/enginecore/XERequest;", "(Lcom/didiglobal/enginecore/XERequest;)V", "()V", "body", "Lcom/didiglobal/enginecore/XERequestBody;", "getBody$engine_core_release", "()Lcom/didiglobal/enginecore/XERequestBody;", "setBody$engine_core_release", "(Lcom/didiglobal/enginecore/XERequestBody;)V", "componentId", "", "getComponentId$engine_core_release", "()Ljava/lang/String;", "setComponentId$engine_core_release", "(Ljava/lang/String;)V", "build", "key", "engine-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: XERequest.kt */
    public static class Builder {
        private XERequestBody body;
        private String componentId;

        public final String getComponentId$engine_core_release() {
            return this.componentId;
        }

        public final void setComponentId$engine_core_release(String str) {
            this.componentId = str;
        }

        public final XERequestBody getBody$engine_core_release() {
            return this.body;
        }

        public final void setBody$engine_core_release(XERequestBody xERequestBody) {
            this.body = xERequestBody;
        }

        public Builder(XERequest xERequest) {
            Intrinsics.checkParameterIsNotNull(xERequest, "request");
            this.componentId = xERequest.keyId();
            this.body = xERequest.body();
        }

        public Builder() {
        }

        public Builder key(String str) {
            Intrinsics.checkParameterIsNotNull(str, BlocksConst.BLOCK_PARAM_COMPONENT_ID);
            Builder builder = this;
            builder.componentId = str;
            return builder;
        }

        public XERequest build() {
            String str = this.componentId;
            if (str != null) {
                return new XERequest(str, this.body);
            }
            throw new IllegalStateException("componentId == null".toString());
        }
    }
}
