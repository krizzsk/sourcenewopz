package com.didi.soda.order.component.refund;

import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity;
import com.didi.soda.order.model.AbnormalItemsInfoModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/order/component/refund/Contract;", "", "AbsRefundDetailPresenter", "AbsRefundDetailView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Contract.kt */
public interface Contract {

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/order/component/refund/Contract$AbsRefundDetailPresenter;", "Lcom/didi/app/nova/skeleton/mvp/IPresenter;", "Lcom/didi/soda/order/component/refund/Contract$AbsRefundDetailView;", "()V", "finish", "", "onRefundDetailSw", "onTotalTipsCk", "ruleDesc", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/RuleDescEntity;", "retryRequest", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsRefundDetailPresenter extends IPresenter<AbsRefundDetailView> {
        public abstract void finish();

        public abstract void onRefundDetailSw();

        public abstract void onTotalTipsCk(RuleDescEntity ruleDescEntity);

        public abstract void retryRequest();
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\bH&¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/order/component/refund/Contract$AbsRefundDetailView;", "Lcom/didi/app/nova/skeleton/mvp/IView;", "Lcom/didi/soda/order/component/refund/Contract$AbsRefundDetailPresenter;", "()V", "hideAbnormalView", "", "showAbnormalView", "errorMsg", "", "updateUI", "abnormalItemsInfoModel", "Lcom/didi/soda/order/model/AbnormalItemsInfoModel;", "orderId", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsRefundDetailView extends IView<AbsRefundDetailPresenter> {
        public abstract void hideAbnormalView();

        public abstract void showAbnormalView(String str);

        public abstract void updateUI(AbnormalItemsInfoModel abnormalItemsInfoModel, String str);
    }
}
