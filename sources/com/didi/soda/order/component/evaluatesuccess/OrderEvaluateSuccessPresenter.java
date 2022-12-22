package com.didi.soda.order.component.evaluatesuccess;

import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationResultEntity;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.order.component.evaluatesuccess.Contract;
import com.didi.soda.router.DiRouter;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/order/component/evaluatesuccess/OrderEvaluateSuccessPresenter;", "Lcom/didi/soda/order/component/evaluatesuccess/Contract$AbsOrderEvaluateSuccessPresenter;", "()V", "mEvaluateFeedBackEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderEvaluationResultEntity$EvaluationFeedBackEntity;", "go2AfterSale", "", "url", "", "goBack", "onCreate", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderEvaluateSuccessPresenter.kt */
public final class OrderEvaluateSuccessPresenter extends Contract.AbsOrderEvaluateSuccessPresenter {

    /* renamed from: a */
    private OrderEvaluationResultEntity.EvaluationFeedBackEntity f43428a;

    public void onCreate() {
        super.onCreate();
        Serializable serializable = getScopeContext().getBundle().getSerializable(Const.PageParams.EVALUATE_RESULT);
        OrderEvaluationResultEntity.EvaluationFeedBackEntity evaluationFeedBackEntity = serializable instanceof OrderEvaluationResultEntity.EvaluationFeedBackEntity ? (OrderEvaluationResultEntity.EvaluationFeedBackEntity) serializable : null;
        this.f43428a = evaluationFeedBackEntity;
        if (evaluationFeedBackEntity != null) {
            ((Contract.AbsOrderEvaluateSuccessView) getLogicView()).updateUI(evaluationFeedBackEntity);
        }
        OmegaTracker.Builder.create(EventConst.Order.SAILING_C_X_SIDEBAR_EVALUATE_ABNORMAL_SW).build().track();
    }

    public void goBack() {
        getScopeContext().getNavigator().finish();
    }

    public void go2AfterSale(String str) {
        OmegaTracker.Builder.create(EventConst.Order.SAILING_C_X_SIDEBAR_EVALUATE_ABNORMAL_CK).build().track();
        if (str != null) {
            DiRouter.request().path("webPage").putString("url", str).open();
        }
    }
}
