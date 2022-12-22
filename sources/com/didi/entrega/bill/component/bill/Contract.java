package com.didi.entrega.bill.component.bill;

import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.entrega.bill.model.PriceModel;
import com.didi.entrega.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.entrega.customer.base.recycler.CustomerRecyclerView;
import com.didi.entrega.customer.widget.abnormal.AbnormalViewModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/entrega/bill/component/bill/Contract;", "", "AbsBillPresenter", "AbsBillView", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Contract.kt */
public interface Contract {

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/entrega/bill/component/bill/Contract$AbsBillPresenter;", "Lcom/didi/entrega/customer/base/recycler/CustomerRecyclerPresenter;", "Lcom/didi/entrega/bill/component/bill/Contract$AbsBillView;", "()V", "handleBack", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsBillPresenter extends CustomerRecyclerPresenter<AbsBillView> {
        public abstract boolean handleBack();
    }

    @Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/entrega/bill/component/bill/Contract$AbsBillView;", "Lcom/didi/entrega/customer/base/recycler/CustomerRecyclerView;", "Lcom/didi/entrega/bill/component/bill/Contract$AbsBillPresenter;", "()V", "getAdapter", "Lcom/didi/app/nova/support/view/recyclerview/adapter/NovaRecyclerAdapter;", "hideAbnormalView", "", "hindLoadingView", "showAbnormalView", "model", "Lcom/didi/entrega/customer/widget/abnormal/AbnormalViewModel;", "showLoadingView", "showMask", "", "showPriceLayout", "priceModel", "Lcom/didi/entrega/bill/model/PriceModel;", "updatePriceText", "payBtnText", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsBillView extends CustomerRecyclerView<AbsBillPresenter> {
        public abstract NovaRecyclerAdapter getAdapter();

        public abstract void hideAbnormalView();

        public abstract void hindLoadingView();

        public abstract void showAbnormalView(AbnormalViewModel abnormalViewModel);

        public abstract void showLoadingView(boolean z);

        public abstract void showPriceLayout(PriceModel priceModel);

        public abstract void updatePriceText(String str);
    }
}
