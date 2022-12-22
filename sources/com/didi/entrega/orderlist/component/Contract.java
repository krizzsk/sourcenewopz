package com.didi.entrega.orderlist.component;

import android.os.Bundle;
import com.didi.entrega.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.entrega.customer.base.recycler.CustomerRecyclerView;
import com.didi.entrega.customer.foundation.rpc.entity.order.ButtonEntity;
import com.didi.entrega.orderlist.binder.OrderListItemModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/entrega/orderlist/component/Contract;", "", "IOrderListPresenter", "IOrderListView", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Contract.kt */
public interface Contract {

    @Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001a\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\tH&¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/entrega/orderlist/component/Contract$IOrderListPresenter;", "Lcom/didi/entrega/customer/base/recycler/CustomerRecyclerPresenter;", "Lcom/didi/entrega/orderlist/component/Contract$IOrderListView;", "()V", "buttonGroupClick", "", "buttonEntity", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/ButtonEntity;", "itemEntity", "Lcom/didi/entrega/orderlist/binder/OrderListItemModel;", "doRefresh", "bundle", "Landroid/os/Bundle;", "isPageBack", "", "goOrderPage", "itemModel", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class IOrderListPresenter extends CustomerRecyclerPresenter<IOrderListView> {
        public abstract void buttonGroupClick(ButtonEntity buttonEntity, OrderListItemModel orderListItemModel);

        public abstract void doRefresh(Bundle bundle, boolean z);

        public abstract void goOrderPage(OrderListItemModel orderListItemModel);
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0005H&J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/entrega/orderlist/component/Contract$IOrderListView;", "Lcom/didi/entrega/customer/base/recycler/CustomerRecyclerView;", "Lcom/didi/entrega/orderlist/component/Contract$IOrderListPresenter;", "()V", "hideAbnormalView", "", "hideGlobalLoading", "scrollToTop", "showGlobalLoading", "showNetError", "showNoData", "showServerError", "msg", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class IOrderListView extends CustomerRecyclerView<IOrderListPresenter> {
        public abstract void hideAbnormalView();

        public abstract void hideGlobalLoading();

        public abstract void scrollToTop();

        public abstract void showGlobalLoading();

        public abstract void showNetError();

        public abstract void showNoData();

        public abstract void showServerError(String str);
    }
}
