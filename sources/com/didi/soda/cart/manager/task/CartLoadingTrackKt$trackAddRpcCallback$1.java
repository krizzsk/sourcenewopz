package com.didi.soda.cart.manager.task;

import com.didi.soda.cart.omega.FloatingCartOmegaHelper;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartItemEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.util.ApiErrorUtil;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/cart/manager/task/CartLoadingTrackKt$trackAddRpcCallback$1", "Lcom/didi/soda/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "onRpcFailure", "", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "onRpcSuccess", "entity", "var2", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartLoadingTrack.kt */
public final class CartLoadingTrackKt$trackAddRpcCallback$1 extends CustomerRpcCallback<CartInfoEntity> {
    final /* synthetic */ AddTrackModel $model;

    CartLoadingTrackKt$trackAddRpcCallback$1(AddTrackModel addTrackModel) {
        this.$model = addTrackModel;
    }

    public void onRpcSuccess(CartInfoEntity cartInfoEntity, long j) {
        int i;
        if (cartInfoEntity != null) {
            AddTrackModel addTrackModel = this.$model;
            List<CartItemEntity> items = cartInfoEntity.getItems();
            if (items == null) {
                i = 0;
            } else {
                i = 0;
                for (CartItemEntity amount : items) {
                    i += amount.getAmount();
                }
            }
            FloatingCartOmegaHelper.Companion.trackAddTaskEnd(0, addTrackModel, i > CustomerApolloUtil.getAddCartMaxNum());
        }
        if (cartInfoEntity == null) {
            ErrorTracker.create(Intrinsics.areEqual((Object) this.$model.getApi(), (Object) "2") ? ErrorConst.ErrorName.SALING_C_SETITEM_AMOUNT_ERROR : ErrorConst.ErrorName.SALING_C_SETITEM_ERROR).addModuleName(ErrorConst.ModuleName.CART).addErrorType(ApiErrorUtil.Companion.getErrorType("-1")).addErrorMsg("unknown error, entity 为 null导致").build().trackError();
        }
    }

    public void onRpcFailure(SFRpcException sFRpcException) {
        String message;
        int i = -1;
        FloatingCartOmegaHelper.Companion.trackAddTaskEnd(sFRpcException == null ? -1 : sFRpcException.getCode(), this.$model, false);
        ErrorTracker.Builder addModuleName = ErrorTracker.create(Intrinsics.areEqual((Object) this.$model.getApi(), (Object) "2") ? ErrorConst.ErrorName.SALING_C_SETITEM_AMOUNT_ERROR : ErrorConst.ErrorName.SALING_C_SETITEM_ERROR).addModuleName(ErrorConst.ModuleName.CART);
        ApiErrorUtil.Companion companion = ApiErrorUtil.Companion;
        if (sFRpcException != null) {
            i = sFRpcException.getCode();
        }
        ErrorTracker.Builder addErrorType = addModuleName.addErrorType(companion.getErrorType(String.valueOf(i)));
        String str = "unknown error,api 没有message信息";
        if (!(sFRpcException == null || (message = sFRpcException.getMessage()) == null)) {
            str = message;
        }
        addErrorType.addErrorMsg(str).build().trackError();
    }
}
