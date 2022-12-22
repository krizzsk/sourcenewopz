package com.didi.component.evaluatequestion.impl.presenter;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.net.CarRequest;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.evaluatequestion.AbsEvaluateQuestionPresenter;
import com.didi.component.evaluatequestion.UnevaluatedViewModel;
import com.didi.component.evaluatequestion.impl.view.IEvaluatedView;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.util.Utils;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.CarEvaluateQuestionData;
import com.didi.travel.psnger.model.response.CarOrder;

public class EndServiceEvaluateQuestionPresenter extends AbsEvaluateQuestionPresenter {

    /* renamed from: a */
    private CloseEvaluateXPenal f13570a;

    /* renamed from: b */
    private CarEvaluateQuestionData f13571b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public UnevaluatedViewModel f13572c;

    public EndServiceEvaluateQuestionPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f13571b = (CarEvaluateQuestionData) componentParams.getExtra(BaseExtras.EndService.EXTRA_EVALUATE_QUESTION_DATA);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m9321b();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        close();
        return true;
    }

    public void close() {
        ((IEvaluatedView) this.mView).close();
        doPublish(BaseEventKeys.Template.EVENT_HIDE_POPUP_COMPONENT, ComponentType.EVALUATE_QUESTION);
    }

    public void onEvaluatedClicked(int i) {
        if (!Utils.isFastDoubleClick()) {
            m9318a(i);
        }
    }

    /* renamed from: b */
    private void m9321b() {
        this.f13572c = new UnevaluatedViewModel();
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            this.f13572c.parse(order.oid, this.f13571b);
            showUnevaluated(this.f13572c);
        }
    }

    /* renamed from: a */
    private void m9318a(final int i) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            ((IEvaluatedView) this.mView).getView().setVisibility(8);
            return;
        }
        UnevaluatedViewModel unevaluatedViewModel = this.f13572c;
        if (unevaluatedViewModel != null && unevaluatedViewModel.answers != null && this.f13572c.answers.length >= 2 && this.f13572c.answerState != null && this.f13572c.answerState.length >= 2) {
            int i2 = this.f13572c.answerState[i];
            String str = this.f13572c.answers[i];
            this.f13570a = new CloseEvaluateXPenal();
            ((IEvaluatedView) this.mView).showLoading();
            CarRequest.commitEvaluateQuestionData(this.mContext, order.getOid(), this.f13572c.questionID, i2, (String) null, str, this.f13572c.questionCaller, i, new ResponseListener<CarEvaluateQuestionData>() {
                public void onSuccess(CarEvaluateQuestionData carEvaluateQuestionData) {
                    super.onSuccess(carEvaluateQuestionData);
                    ((IEvaluatedView) EndServiceEvaluateQuestionPresenter.this.mView).hideError();
                    EndServiceEvaluateQuestionPresenter endServiceEvaluateQuestionPresenter = EndServiceEvaluateQuestionPresenter.this;
                    endServiceEvaluateQuestionPresenter.showEvaluated(i, endServiceEvaluateQuestionPresenter.f13572c);
                    EndServiceEvaluateQuestionPresenter.this.m9322c();
                }

                public void onError(CarEvaluateQuestionData carEvaluateQuestionData) {
                    super.onError(carEvaluateQuestionData);
                    ((IEvaluatedView) EndServiceEvaluateQuestionPresenter.this.mView).showError();
                }

                public void onFail(CarEvaluateQuestionData carEvaluateQuestionData) {
                    super.onFail(carEvaluateQuestionData);
                    ((IEvaluatedView) EndServiceEvaluateQuestionPresenter.this.mView).showError();
                }

                public void onFinish(CarEvaluateQuestionData carEvaluateQuestionData) {
                    super.onFinish(carEvaluateQuestionData);
                    ((IEvaluatedView) EndServiceEvaluateQuestionPresenter.this.mView).hideLoading();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m9322c() {
        UiThreadHandler.postDelayed(this.f13570a, 1000);
    }

    private class CloseEvaluateXPenal implements Runnable {
        private CloseEvaluateXPenal() {
        }

        public void run() {
            EndServiceEvaluateQuestionPresenter.this.doPublish(BaseEventKeys.Template.EVENT_HIDE_POPUP_COMPONENT, ComponentType.EVALUATE_QUESTION);
        }
    }
}
