package com.didi.entrega.bill.datastore;

import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.info.repo.InfoComponentRepo;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/entrega/bill/datastore/BillInfoRequest$send$1", "Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity;", "onRpcFailure", "", "ex", "Lcom/didi/entrega/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "commonInfoEntity", "var2", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillRequestFactory.kt */
public final class BillInfoRequest$send$1 extends CustomerRpcCallback<CommonInfoEntity> {
    public void onRpcFailure(SFRpcException sFRpcException) {
    }

    BillInfoRequest$send$1() {
    }

    public void onRpcSuccess(CommonInfoEntity commonInfoEntity, long j) {
        if (commonInfoEntity != null) {
            ((InfoComponentRepo) RepoFactory.getRepo(InfoComponentRepo.class)).setCommonInfoEntity(commonInfoEntity);
        }
    }
}
