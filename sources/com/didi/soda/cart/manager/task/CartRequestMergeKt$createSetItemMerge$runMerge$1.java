package com.didi.soda.cart.manager.task;

import com.didi.soda.cart.model.SetItemParams;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/soda/cart/model/SetItemParams;", "old", "cur"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartRequestMerge.kt */
final class CartRequestMergeKt$createSetItemMerge$runMerge$1 extends Lambda implements Function2<SetItemParams, SetItemParams, SetItemParams> {
    final /* synthetic */ Function2<SetItemParams, SetItemParams, Boolean> $compareItemUniKey;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CartRequestMergeKt$createSetItemMerge$runMerge$1(Function2<? super SetItemParams, ? super SetItemParams, Boolean> function2) {
        super(2);
        this.$compareItemUniKey = function2;
    }

    public final SetItemParams invoke(SetItemParams setItemParams, SetItemParams setItemParams2) {
        CustomerRpcCallback<CartInfoEntity> callback;
        List<CustomerRpcCallback<CartInfoEntity>> callbacks;
        Intrinsics.checkNotNullParameter(setItemParams2, "cur");
        if (setItemParams == null) {
            return setItemParams2;
        }
        if (setItemParams2.getMduId() != null) {
            if (Intrinsics.areEqual((Object) setItemParams.getMduId(), (Object) setItemParams2.getMduId())) {
                setItemParams = setItemParams2;
                callback = setItemParams2.getCallback();
                if (!(callback == null || setItemParams == null || (callbacks = setItemParams.getCallbacks()) == null)) {
                    callbacks.add(callback);
                }
                return setItemParams;
            }
        } else if (this.$compareItemUniKey.invoke(setItemParams, setItemParams2).booleanValue() && setItemParams.getNodeList().size() == 1 && setItemParams2.getNodeList().size() == 1) {
            setItemParams.getNodeList().get(0).amount += setItemParams2.getNodeList().get(0).amount;
            callback = setItemParams2.getCallback();
            callbacks.add(callback);
            return setItemParams;
        }
        setItemParams = null;
        callback = setItemParams2.getCallback();
        callbacks.add(callback);
        return setItemParams;
    }
}
