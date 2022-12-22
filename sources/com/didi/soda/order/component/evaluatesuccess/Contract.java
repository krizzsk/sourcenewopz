package com.didi.soda.order.component.evaluatesuccess;

import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationResultEntity;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/order/component/evaluatesuccess/Contract;", "", "AbsOrderEvaluateSuccessPresenter", "AbsOrderEvaluateSuccessView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Contract.kt */
public interface Contract {

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/order/component/evaluatesuccess/Contract$AbsOrderEvaluateSuccessPresenter;", "Lcom/didi/app/nova/skeleton/mvp/IPresenter;", "Lcom/didi/soda/order/component/evaluatesuccess/Contract$AbsOrderEvaluateSuccessView;", "()V", "go2AfterSale", "", "url", "", "goBack", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsOrderEvaluateSuccessPresenter extends IPresenter<AbsOrderEvaluateSuccessView> {
        public abstract void go2AfterSale(String str);

        public abstract void goBack();
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/order/component/evaluatesuccess/Contract$AbsOrderEvaluateSuccessView;", "Lcom/didi/app/nova/skeleton/mvp/IView;", "Lcom/didi/soda/order/component/evaluatesuccess/Contract$AbsOrderEvaluateSuccessPresenter;", "()V", "updateUI", "", "evaluateResult", "Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderEvaluationResultEntity$EvaluationFeedBackEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsOrderEvaluateSuccessView extends IView<AbsOrderEvaluateSuccessPresenter> {
        public abstract void updateUI(OrderEvaluationResultEntity.EvaluationFeedBackEntity evaluationFeedBackEntity);
    }
}
