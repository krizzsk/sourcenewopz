package com.didi.soda.cart.manager.task;

import com.didi.soda.cart.model.SetItemAmountParams;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/soda/cart/model/SetItemAmountParams;", "old", "cur"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartRequestMerge.kt */
final class CartRequestMergeKt$createSetAmountMerge$runMerge$1 extends Lambda implements Function2<SetItemAmountParams, SetItemAmountParams, SetItemAmountParams> {
    public static final CartRequestMergeKt$createSetAmountMerge$runMerge$1 INSTANCE = new CartRequestMergeKt$createSetAmountMerge$runMerge$1();

    CartRequestMergeKt$createSetAmountMerge$runMerge$1() {
        super(2);
    }

    public final SetItemAmountParams invoke(SetItemAmountParams setItemAmountParams, SetItemAmountParams setItemAmountParams2) {
        Boolean bool;
        Object obj;
        Intrinsics.checkNotNullParameter(setItemAmountParams2, "cur");
        if (setItemAmountParams == null) {
            return setItemAmountParams2;
        }
        Iterator it = setItemAmountParams.getContents().iterator();
        while (true) {
            bool = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((SetItemAmountParams.Content) obj).getMduId(), (Object) setItemAmountParams2.getContent().getMduId())) {
                break;
            }
        }
        SetItemAmountParams.Content content = (SetItemAmountParams.Content) obj;
        if (content != null) {
            setItemAmountParams.getContents().remove(content);
        }
        setItemAmountParams.getContents().add(setItemAmountParams2.getContent());
        CustomerRpcCallback<CartInfoEntity> callback = setItemAmountParams2.getCallback();
        if (callback == null) {
            return setItemAmountParams;
        }
        List<CustomerRpcCallback<CartInfoEntity>> callbacks = setItemAmountParams.getCallbacks();
        if (callbacks != null) {
            bool = Boolean.valueOf(callbacks.add(callback));
        }
        bool.booleanValue();
        return setItemAmountParams;
    }
}
