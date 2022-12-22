package com.didi.component.evaluateentrance.evaluate.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.OrderComManager;
import com.didi.component.business.util.SourceUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.common.net.CarRequest;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.evaluateentrance.evaluate.model.EvaluateQuestionModel;
import com.didi.component.evaluateentrance.evaluate.view.AbsEvaluateQuestionView;
import com.didi.component.evaluateentrance.impl.newView.AskForHelpDialog;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.CommonPopUp;
import com.didi.travel.psnger.model.response.CarEvaluateQuestionData;
import com.didi.travel.psnger.model.response.OrderCom;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class EvaluateQuestionPresenter extends AbsEvaluateQuestionPresenter {

    /* renamed from: b */
    private static final int f13487b = 100;

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<String> f13488a = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (str2 != null) {
                Intent intent = new Intent(EvaluateQuestionPresenter.this.mContext, GlobalWebActivity.class);
                intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(str2));
                EvaluateQuestionPresenter.this.startActivityForResult(intent, 100);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EvaluateQuestionModel f13489c;

    public EvaluateQuestionPresenter(Context context) {
        super(context);
    }

    public EvaluateQuestionPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public void setViewWithData(JSONObject jSONObject, IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        if (jSONObject != null) {
            EvaluateQuestionModel evaluateQuestionModel = new EvaluateQuestionModel();
            evaluateQuestionModel.parse(jSONObject);
            this.f13489c = evaluateQuestionModel;
            OrderCom orderCom = OrderComManager.getInstance().getOrderCom();
            if (orderCom != null) {
                this.f13489c.oid = orderCom.getOid();
            }
            ((AbsEvaluateQuestionView) this.mView).initData(evaluateQuestionModel);
            iXpCardBindDataReadyCallback.ready(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Evaluate.ASK_FOR_HELP, this.f13488a);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Evaluate.ASK_FOR_HELP, this.f13488a);
    }

    public void onEvaluatedClicked(final int i, EvaluateQuestionModel evaluateQuestionModel) {
        String str;
        int i2;
        final int i3;
        if (i >= 0 && evaluateQuestionModel != null) {
            final CommonPopUp commonPopUp = null;
            int i4 = 2;
            if (evaluateQuestionModel.questionCaller != null && evaluateQuestionModel.questionOptions != null) {
                int i5 = evaluateQuestionModel.questionOptions.get(i).state;
                String str2 = evaluateQuestionModel.questionOptions.get(i).text;
                int i6 = evaluateQuestionModel.questionOptions.get(i).type;
                CommonPopUp commonPopUp2 = evaluateQuestionModel.questionOptions.get(i).popUp;
                if (!TextUtils.isEmpty(evaluateQuestionModel.questionOptions.get(i).iconUrl)) {
                    i4 = 1;
                }
                i3 = i6;
                i2 = i5;
                commonPopUp = commonPopUp2;
                str = str2;
            } else if (evaluateQuestionModel.answers != null && evaluateQuestionModel.answers.length >= 2 && evaluateQuestionModel.answerState != null && evaluateQuestionModel.answerState.length >= 2) {
                int i7 = i < evaluateQuestionModel.answerState.length ? evaluateQuestionModel.answerState[i] : 0;
                str = i < evaluateQuestionModel.answers.length ? evaluateQuestionModel.answers[i] : "";
                i2 = i7;
                i3 = 0;
            } else {
                return;
            }
            this.f13489c.style = 1;
            showBeforeEvaluated(i, this.f13489c);
            m9238a("pas_ratecard_submit_ck", i2, i4);
            ((AbsEvaluateQuestionView) this.mView).showLoading();
            CarRequest.commitEvaluateQuestionData(this.mContext, this.f13489c.oid, this.f13489c.questionID, i2, (String) null, str, this.f13489c.questionCaller, i, new ResponseListener<CarEvaluateQuestionData>() {
                public void onSuccess(CarEvaluateQuestionData carEvaluateQuestionData) {
                    CommonPopUp commonPopUp;
                    super.onSuccess(carEvaluateQuestionData);
                    EvaluateQuestionPresenter evaluateQuestionPresenter = EvaluateQuestionPresenter.this;
                    evaluateQuestionPresenter.showAfterEvaluated(i, evaluateQuestionPresenter.f13489c);
                    ((AbsEvaluateQuestionView) EvaluateQuestionPresenter.this.mView).hideLoading();
                    ((AbsEvaluateQuestionView) EvaluateQuestionPresenter.this.mView).hideError();
                    EvaluateQuestionPresenter.this.f13489c.style = 1;
                    if (i3 == CommonPopUp.PopUpActionType.POPUP.type && (commonPopUp = commonPopUp) != null) {
                        EvaluateQuestionPresenter.this.showAskForHelp(commonPopUp);
                    }
                }

                public void onError(CarEvaluateQuestionData carEvaluateQuestionData) {
                    super.onError(carEvaluateQuestionData);
                    ((AbsEvaluateQuestionView) EvaluateQuestionPresenter.this.mView).hideLoading();
                    ((AbsEvaluateQuestionView) EvaluateQuestionPresenter.this.mView).showError();
                }

                public void onFail(CarEvaluateQuestionData carEvaluateQuestionData) {
                    super.onFail(carEvaluateQuestionData);
                    ((AbsEvaluateQuestionView) EvaluateQuestionPresenter.this.mView).hideLoading();
                    ((AbsEvaluateQuestionView) EvaluateQuestionPresenter.this.mView).showError();
                }

                public void onFinish(CarEvaluateQuestionData carEvaluateQuestionData) {
                    super.onFinish(carEvaluateQuestionData);
                }
            });
        }
    }

    public void showAskForHelp(final CommonPopUp commonPopUp) {
        ((AbsEvaluateQuestionView) this.mView).getView().postDelayed(new Runnable() {
            public void run() {
                if (EvaluateQuestionPresenter.this.getHost() != null && EvaluateQuestionPresenter.this.getHost().getFragmentManager() != null) {
                    AskForHelpDialog askForHelpDialog = new AskForHelpDialog(1);
                    askForHelpDialog.setPopUp(commonPopUp);
                    askForHelpDialog.show(EvaluateQuestionPresenter.this.getHost().getFragmentManager(), "ask_for_help_dialog");
                }
            }
        }, 1000);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            refreshXpanel();
        }
    }

    public void showBeforeEvaluated(int i, EvaluateQuestionModel evaluateQuestionModel) {
        ((AbsEvaluateQuestionView) this.mView).showBeforeEvaluated(i, evaluateQuestionModel);
    }

    public void showAfterEvaluated(int i, EvaluateQuestionModel evaluateQuestionModel) {
        ((AbsEvaluateQuestionView) this.mView).showAfterEvaluated(i, evaluateQuestionModel);
    }

    /* renamed from: a */
    private void m9238a(String str, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(SourceUtils.getSource()));
        hashMap.put("rate", Integer.valueOf(i));
        hashMap.put("style", Integer.valueOf(i2));
        EvaluateQuestionModel evaluateQuestionModel = this.f13489c;
        if (evaluateQuestionModel != null) {
            hashMap.put("xpanel_pos", Integer.valueOf(evaluateQuestionModel.xpanelPos));
            hashMap.put("question", Integer.valueOf(this.f13489c.questionID));
        }
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap);
    }
}
