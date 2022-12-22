package com.didi.component.framework.pages.carcheck.presenter;

import com.didi.component.framework.pages.carcheck.view.CarResultView;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.CarEvaluateQuestionData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/component/framework/pages/carcheck/presenter/CarResultPresenter$getCarCheckResult$1", "Lcom/didi/travel/psnger/common/net/base/ResponseListener;", "Lcom/didi/travel/psnger/model/response/CarEvaluateQuestionData;", "onError", "", "t", "onFail", "onFinish", "onSuccess", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CarResultPresenter.kt */
public final class CarResultPresenter$getCarCheckResult$1 extends ResponseListener<CarEvaluateQuestionData> {
    final /* synthetic */ CarResultPresenter this$0;

    CarResultPresenter$getCarCheckResult$1(CarResultPresenter carResultPresenter) {
        this.this$0 = carResultPresenter;
    }

    public void onSuccess(CarEvaluateQuestionData carEvaluateQuestionData) {
        String str;
        CarResultView carResultView;
        super.onSuccess(carEvaluateQuestionData);
        if (carEvaluateQuestionData == null) {
            str = null;
        } else {
            str = carEvaluateQuestionData.user_reply;
        }
        if (str != null && (carResultView = (CarResultView) this.this$0.mView) != null) {
            String str2 = carEvaluateQuestionData.user_reply;
            Intrinsics.checkNotNullExpressionValue(str2, "t.user_reply");
            carResultView.initContentView(str2);
        }
    }

    public void onFail(CarEvaluateQuestionData carEvaluateQuestionData) {
        String str;
        CarResultView carResultView;
        super.onFail(carEvaluateQuestionData);
        if (carEvaluateQuestionData == null) {
            str = null;
        } else {
            str = carEvaluateQuestionData.errmsg;
        }
        if (str != null && (carResultView = (CarResultView) this.this$0.mView) != null) {
            String errorMsg = carEvaluateQuestionData.getErrorMsg();
            Intrinsics.checkNotNullExpressionValue(errorMsg, "t.errorMsg");
            carResultView.showErrorDialog(errorMsg);
        }
    }

    public void onError(CarEvaluateQuestionData carEvaluateQuestionData) {
        super.onError(carEvaluateQuestionData);
        CarResultView carResultView = (CarResultView) this.this$0.mView;
        if (carResultView != null) {
            carResultView.showErrorView();
        }
    }

    public void onFinish(CarEvaluateQuestionData carEvaluateQuestionData) {
        super.onFinish(carEvaluateQuestionData);
        CarResultView carResultView = (CarResultView) this.this$0.mView;
        if (carResultView != null) {
            carResultView.hideLoadingView();
        }
    }
}
