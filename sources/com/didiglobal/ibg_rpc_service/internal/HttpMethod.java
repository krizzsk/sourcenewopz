package com.didiglobal.ibg_rpc_service.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, mo175978d2 = {"Lcom/didiglobal/ibg_rpc_service/internal/HttpMethod;", "", "methodName", "", "methodId", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getMethodId", "()I", "getMethodName", "()Ljava/lang/String;", "GET", "POST", "Companion", "ibg_rpc_service_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HttpMethod.kt */
public enum HttpMethod {
    GET("get", 1),
    POST("post", 2);
    
    public static final Companion Companion = null;
    private final int methodId;
    private final String methodName;

    private HttpMethod(String str, int i) {
        this.methodName = str;
        this.methodId = i;
    }

    public final int getMethodId() {
        return this.methodId;
    }

    public final String getMethodName() {
        return this.methodName;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, mo175978d2 = {"Lcom/didiglobal/ibg_rpc_service/internal/HttpMethod$Companion;", "", "()V", "fromMethodId", "Lcom/didiglobal/ibg_rpc_service/internal/HttpMethod;", "id", "", "(Ljava/lang/Integer;)Lcom/didiglobal/ibg_rpc_service/internal/HttpMethod;", "ibg_rpc_service_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HttpMethod.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HttpMethod fromMethodId(Integer num) {
            for (HttpMethod httpMethod : HttpMethod.values()) {
                if (num != null && httpMethod.getMethodId() == num.intValue()) {
                    return httpMethod;
                }
            }
            return null;
        }
    }
}
