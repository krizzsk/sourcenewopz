package com.didi.soda.customer.biz.popdialog;

import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.AFGroupEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didichuxing.foundation.rpc.Rpc;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a4\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u0004 \u0003*\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0001¨\u0006\u00010\u0001¨\u0006\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didichuxing/foundation/rpc/Rpc;", "Lcom/didichuxing/foundation/rpc/RpcRequest;", "kotlin.jvm.PlatformType", "Lcom/didichuxing/foundation/rpc/RpcResponse;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AFGroupIdManager.kt */
final class AFGroupIdManager$Companion$requestGroupIdMap$closure$1 extends Lambda implements Function0<Rpc> {
    public static final AFGroupIdManager$Companion$requestGroupIdMap$closure$1 INSTANCE = new AFGroupIdManager$Companion$requestGroupIdMap$closure$1();

    AFGroupIdManager$Companion$requestGroupIdMap$closure$1() {
        super(0);
    }

    public final Rpc invoke() {
        return CustomerRpcManagerProxy.get().getAFGroupIdMap(new CustomerRpcCallback<AFGroupEntity>() {
            public void onRpcSuccess(AFGroupEntity aFGroupEntity, long j) {
                boolean z;
                if (aFGroupEntity == null) {
                    z = true;
                } else {
                    AFGroupIdManager.Companion.setAfGroupEntity(aFGroupEntity);
                    AFGroupIdManager.Companion.doFindUriByAFGroup();
                    z = false;
                }
                if (z) {
                    AFGroupIdManager.Companion.errorTrack(0);
                }
            }

            public void onRpcFailure(SFRpcException sFRpcException) {
                AFGroupIdManager.Companion.errorTrack(sFRpcException == null ? -1 : sFRpcException.getCode());
            }
        });
    }
}
