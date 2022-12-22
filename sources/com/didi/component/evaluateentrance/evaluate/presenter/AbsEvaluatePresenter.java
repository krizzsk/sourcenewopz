package com.didi.component.evaluateentrance.evaluate.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.event.EndServiceTipPayEvent;
import com.didi.component.business.util.OrderComManager;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.common.dialog.NormalDialogInfo;
import com.didi.component.common.net.CarRequest;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.IView;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.soda.customer.app.constant.Const;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.OrderCom;
import com.didi.travel.psnger.model.response.PrePayTipsModel;
import com.google.gson.JsonObject;
import com.taxis99.R;

public abstract class AbsEvaluatePresenter<V extends IView> extends IPresenter<V> {
    public static final String TIP_EVALUATE = "tip_evaluate";

    /* renamed from: a */
    private static final int f13483a = 100;

    /* renamed from: b */
    private String f13484b = "";

    /* renamed from: c */
    private String f13485c = "";

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f13486d = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsEvaluatePresenter.this.refreshXpanel();
        }
    };

    public AbsEvaluatePresenter(Context context) {
        super(context);
    }

    public AbsEvaluatePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Service.EndService.EVENT_ENDSERVCIE_TIP_PAYED, this.f13486d);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Service.EndService.EVENT_ENDSERVCIE_TIP_PAYED, this.f13486d);
    }

    public void prePayTips(final String str) {
        OrderCom orderCom;
        if (!TextUtils.isEmpty(str) && (orderCom = OrderComManager.getInstance().getOrderCom()) != null) {
            CarRequest.prePayTips(this.mContext, orderCom.getOid(), str, new ResponseListener<PrePayTipsModel>() {
                public void onSuccess(PrePayTipsModel prePayTipsModel) {
                    super.onSuccess(prePayTipsModel);
                    if (prePayTipsModel != null) {
                        AbsEvaluatePresenter.this.m9234a(prePayTipsModel);
                        AbsEvaluatePresenter.this.doPublish(BaseEventKeys.Service.EndService.EVENT_ENDSERVCIE_TIP_SOURCE, new EndServiceTipPayEvent(AbsEvaluatePresenter.TIP_EVALUATE, str));
                    }
                }

                public void onError(PrePayTipsModel prePayTipsModel) {
                    super.onError(prePayTipsModel);
                    AbsEvaluatePresenter.this.m9235b();
                }

                public void onFail(PrePayTipsModel prePayTipsModel) {
                    super.onFail(prePayTipsModel);
                    AbsEvaluatePresenter.this.m9235b();
                }

                public void onFinish(PrePayTipsModel prePayTipsModel) {
                    super.onFinish(prePayTipsModel);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9235b() {
        NormalDialogInfo normalDialogInfo = new NormalDialogInfo(100);
        normalDialogInfo.setMessage(this.mContext.getResources().getString(R.string.global_evaluate_failed_add_tip));
        normalDialogInfo.setPositiveText(this.mContext.getResources().getString(R.string.global_evaluate_pay_again));
        normalDialogInfo.setNegativeText(this.mContext.getResources().getString(R.string.cancel));
        normalDialogInfo.setCancelable(false);
        showDialog(normalDialogInfo);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9234a(PrePayTipsModel prePayTipsModel) {
        try {
            Intent intent = new Intent();
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("sign", prePayTipsModel.sign);
            jsonObject.addProperty(Const.PayParams.SIGN_TYPE, prePayTipsModel.signType);
            jsonObject.addProperty(Const.PayParams.BIZ_CONTENT, prePayTipsModel.bizContent);
            jsonObject.addProperty("pixPrepay", Boolean.valueOf(prePayTipsModel.pixPrepay));
            intent.setPackage(this.mContext.getPackageName());
            intent.setAction("com.didi.global.unifiedPay.entrance");
            intent.putExtra("uni_pay_param", jsonObject.toString());
            this.mContext.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refreshXpanel() {
        XEngineReq.pageRequest(XERequestKey.SCENE_TRIP);
    }

    public void tipPayClose(String str, String str2) {
        this.f13485c = str2;
        this.f13484b = str;
    }
}
