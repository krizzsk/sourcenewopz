package com.didi.soda.cart.component;

import com.didi.soda.cart.model.CartInfoModel;
import com.didi.soda.cart.model.CartItemModel;
import com.didi.soda.cart.model.CartTyingItemModel;
import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.soda.customer.base.recycler.CustomerRecyclerView;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/cart/component/Contract;", "", "AbsFloatingCartPresenter", "AbsFloatingCartView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Contract.kt */
public interface Contract {

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000eH&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/cart/component/Contract$AbsFloatingCartPresenter;", "Lcom/didi/soda/customer/base/recycler/CustomerRecyclerPresenter;", "Lcom/didi/soda/cart/component/Contract$AbsFloatingCartView;", "()V", "addSku", "", "cartItemModel", "Lcom/didi/soda/cart/model/CartTyingItemModel;", "action", "", "clearAllData", "openCartTracker", "toBillPage", "toSkuPage", "Lcom/didi/soda/cart/model/CartItemModel;", "updateSku", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsFloatingCartPresenter extends CustomerRecyclerPresenter<AbsFloatingCartView> {
        public abstract void addSku(CartTyingItemModel cartTyingItemModel, boolean z);

        public abstract void clearAllData();

        public abstract void openCartTracker();

        public abstract void toBillPage();

        public abstract void toSkuPage(CartItemModel cartItemModel);

        public abstract void toSkuPage(CartTyingItemModel cartTyingItemModel);

        public abstract void updateSku(CartItemModel cartItemModel, boolean z);
    }

    @Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\u0005H&J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH&J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\nH&¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/soda/cart/component/Contract$AbsFloatingCartView;", "Lcom/didi/soda/customer/base/recycler/CustomerRecyclerView;", "Lcom/didi/soda/cart/component/Contract$AbsFloatingCartPresenter;", "()V", "hideAllCartView", "", "hideCartMenu", "hidePriceLoading", "setBusinessStatus", "businessStatus", "", "setSkuDeleteFlag", "showBottomCartCard", "isForce", "", "showCartMenu", "showPriceLoading", "updateCartInfo", "cartInfoModel", "Lcom/didi/soda/cart/model/CartInfoModel;", "firstLoadPage", "updateCartTotalAmount", "amount", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsFloatingCartView extends CustomerRecyclerView<AbsFloatingCartPresenter> {
        public abstract void hideAllCartView();

        public abstract void hideCartMenu();

        public abstract void hidePriceLoading();

        public abstract void setBusinessStatus(int i);

        public abstract void setSkuDeleteFlag();

        public abstract void showBottomCartCard(boolean z);

        public abstract void showCartMenu();

        public abstract void showPriceLoading();

        public abstract void updateCartInfo(CartInfoModel cartInfoModel, boolean z);

        public abstract void updateCartTotalAmount(int i);
    }
}
