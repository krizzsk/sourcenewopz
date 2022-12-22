package com.didi.soda.customer.foundation.rpc.net;

import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.rpc.Clock;
import com.didi.soda.customer.foundation.rpc.RpcErrorConsumer;
import com.didi.soda.customer.foundation.util.ErrorHandleUtil;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u0000 \u001a*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002:\u0001\u001aB\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J%\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/net/CRpcCallBackWithTraceId;", "T", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcResult;", "rpcErrorConsumer", "Lcom/didi/soda/customer/foundation/rpc/RpcErrorConsumer;", "(Lcom/didi/soda/customer/foundation/rpc/RpcErrorConsumer;)V", "()V", "mRpcErrorConsumerWr", "Ljava/lang/ref/WeakReference;", "onFailure", "", "exception", "Ljava/io/IOException;", "onRpcFailure", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "data", "serviceTime", "", "traceId", "", "(Ljava/lang/Object;JLjava/lang/String;)V", "onSuccess", "result", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CRpcCallBackWithTraceId.kt */
public abstract class CRpcCallBackWithTraceId<T> implements RpcService.Callback<SFRpcResult<T>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "CRpcCallBackWithTraceId";
    private WeakReference<RpcErrorConsumer> mRpcErrorConsumerWr;

    public abstract void onRpcSuccess(T t, long j, String str);

    public CRpcCallBackWithTraceId() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CRpcCallBackWithTraceId(RpcErrorConsumer rpcErrorConsumer) {
        this();
        Intrinsics.checkNotNullParameter(rpcErrorConsumer, "rpcErrorConsumer");
        this.mRpcErrorConsumerWr = new WeakReference<>(rpcErrorConsumer);
    }

    public void onFailure(IOException iOException) {
        onRpcFailure(new SFRpcException((Throwable) iOException));
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        RpcErrorConsumer rpcErrorConsumer;
        if (sFRpcException != null) {
            RecordTracker.Builder.create().setTag(TAG).setLogModule("m-net-fail|").setMessage(sFRpcException.getOriginalMessage()).setLogCategory("c-data|").build().info();
        }
        WeakReference<RpcErrorConsumer> weakReference = this.mRpcErrorConsumerWr;
        if (weakReference == null || ((rpcErrorConsumer = (RpcErrorConsumer) weakReference.get()) != null && !rpcErrorConsumer.doConsumeRpcError(sFRpcException))) {
            ErrorHandleUtil.setError(sFRpcException);
        }
    }

    public void onSuccess(SFRpcResult<T> sFRpcResult) {
        Intrinsics.checkNotNullParameter(sFRpcResult, "result");
        if (sFRpcResult.getCode() == 0) {
            Clock.updateServiceTime(sFRpcResult.getServiceTime());
            T data = sFRpcResult.getData();
            long serviceTime = sFRpcResult.getServiceTime();
            String traceId = sFRpcResult.getTraceId();
            if (traceId == null) {
                traceId = "";
            }
            onRpcSuccess(data, serviceTime, traceId);
            return;
        }
        onRpcFailure(new SFRpcException((SFRpcResult) sFRpcResult));
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/net/CRpcCallBackWithTraceId$Companion;", "", "()V", "TAG", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CRpcCallBackWithTraceId.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
