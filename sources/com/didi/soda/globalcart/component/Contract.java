package com.didi.soda.globalcart.component;

import com.didi.soda.cart.listener.OnCartItemOperateListener;
import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.soda.customer.base.recycler.CustomerRecyclerView;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/globalcart/component/Contract;", "", "AbsGlobalCartPresenter", "AbsGlobalCartView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Contract.kt */
public interface Contract {

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/globalcart/component/Contract$AbsGlobalCartPresenter;", "Lcom/didi/soda/customer/base/recycler/CustomerRecyclerPresenter;", "Lcom/didi/soda/globalcart/component/Contract$AbsGlobalCartView;", "Lcom/didi/soda/cart/listener/OnCartItemOperateListener;", "()V", "onClickBack", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsGlobalCartPresenter extends CustomerRecyclerPresenter<AbsGlobalCartView> implements OnCartItemOperateListener {
        public abstract void onClickBack();
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0007H&¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/globalcart/component/Contract$AbsGlobalCartView;", "Lcom/didi/soda/customer/base/recycler/CustomerRecyclerView;", "Lcom/didi/soda/globalcart/component/Contract$AbsGlobalCartPresenter;", "()V", "calculateAbnormalHeight", "", "hideLoadingView", "", "scrollToTop", "showLoadingView", "showNetErrorToast", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsGlobalCartView extends CustomerRecyclerView<AbsGlobalCartPresenter> {
        public abstract int calculateAbnormalHeight();

        public abstract void hideLoadingView();

        public abstract void scrollToTop();

        public abstract void showLoadingView();

        public abstract void showNetErrorToast();
    }
}
