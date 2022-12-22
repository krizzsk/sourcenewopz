package com.didi.soda.cart.manager.task;

import com.didi.soda.cart.repo.CartItemStateRepo;
import com.didi.soda.cart.repo.CartItemStateRepoKt;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartItemEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.repo.RepoFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0016\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u000e\u0010\u0005\u001a\u00020\u0006*\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, mo175978d2 = {"trackAddRpcCallback", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "model", "Lcom/didi/soda/cart/manager/task/AddTrackModel;", "isRollback", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartLoadingTrack.kt */
public final class CartLoadingTrackKt {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m28507a(CartInfoEntity cartInfoEntity) {
        int i;
        if (cartInfoEntity != null) {
            CartItemStateRepo cartItemStateRepo = (CartItemStateRepo) RepoFactory.getRepo(CartItemStateRepo.class);
            Intrinsics.checkNotNullExpressionValue(cartItemStateRepo, "repo");
            int cartAllNum = CartItemStateRepoKt.getCartAllNum(cartItemStateRepo, cartInfoEntity.getShopId());
            int cartAllGiftNum = CartItemStateRepoKt.getCartAllGiftNum(cartItemStateRepo, cartInfoEntity.getShopId());
            List<CartItemEntity> items = cartInfoEntity.getItems();
            if (items == null) {
                i = 0;
            } else {
                i = 0;
                for (CartItemEntity cartItemEntity : items) {
                    if (cartItemEntity.getMduType() == 1) {
                        i += cartItemEntity.getAmount();
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("pre = ");
            int i2 = cartAllNum - cartAllGiftNum;
            sb.append(i2);
            sb.append(" cur = ");
            sb.append(i);
            LogUtil.m29100d(">>>", sb.toString());
            return i != i2;
        }
    }

    public static final CustomerRpcCallback<CartInfoEntity> trackAddRpcCallback(AddTrackModel addTrackModel) {
        Intrinsics.checkNotNullParameter(addTrackModel, "model");
        return new CartLoadingTrackKt$trackAddRpcCallback$1(addTrackModel);
    }
}
