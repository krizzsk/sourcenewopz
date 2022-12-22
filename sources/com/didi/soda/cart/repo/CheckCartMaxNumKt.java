package com.didi.soda.cart.repo;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.repo.model.ItemState;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001aD\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¨\u0006\r"}, mo175978d2 = {"isReachMaxNum", "", "context", "Lcom/didi/app/nova/skeleton/ScopeContext;", "shopId", "", "itemUniKey", "mduId", "amount", "", "block", "Lkotlin/Function0;", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CheckCartMaxNum.kt */
public final class CheckCartMaxNumKt {
    public static /* synthetic */ boolean isReachMaxNum$default(ScopeContext scopeContext, String str, String str2, String str3, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            function0 = null;
        }
        return isReachMaxNum(scopeContext, str, str2, str3, i, function0);
    }

    public static final boolean isReachMaxNum(ScopeContext scopeContext, String str, String str2, String str3, int i, Function0<Unit> function0) {
        int i2;
        int i3;
        Object obj;
        Intrinsics.checkNotNullParameter(scopeContext, "context");
        Intrinsics.checkNotNullParameter(str, "shopId");
        CartItemStateRepo cartItemStateRepo = (CartItemStateRepo) RepoFactory.getRepo(CartItemStateRepo.class);
        Intrinsics.checkNotNullExpressionValue(cartItemStateRepo, "repo");
        int cartAllNum = CartItemStateRepoKt.getCartAllNum(cartItemStateRepo, str);
        CharSequence charSequence = str3;
        if (charSequence == null || charSequence.length() == 0) {
            i3 = CartItemStateRepoKt.getCartAllNum(cartItemStateRepo, str);
        } else {
            ArrayList<ItemState> value = cartItemStateRepo.getValue(str);
            if (value != null) {
                Iterator it = value.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual((Object) str2, (Object) ((ItemState) obj).itemUniKey)) {
                        break;
                    }
                }
                ItemState itemState = (ItemState) obj;
                if (itemState != null) {
                    i2 = itemState.amount;
                    i3 = cartAllNum - i2;
                }
            }
            i2 = 0;
            i3 = cartAllNum - i2;
        }
        int i4 = i3 + i;
        boolean z = i4 > cartAllNum;
        if (i4 <= CustomerApolloUtil.getAddCartMaxNum() || !z) {
            if (function0 != null) {
                function0.invoke();
            }
            return false;
        }
        ToastUtil.showCustomerToast(scopeContext, ResourceHelper.getString(R.string.customer_cart_check_max));
        return true;
    }
}
