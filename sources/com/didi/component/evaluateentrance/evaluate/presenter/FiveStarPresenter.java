package com.didi.component.evaluateentrance.evaluate.presenter;

import android.content.Context;
import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.util.OrderComManager;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.base.ComponentWrap;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.evaluateentrance.evaluate.model.FiveStarModel;
import com.didi.component.evaluateentrance.evaluate.view.AbsFiveStarView;
import com.didi.travel.psnger.model.response.EvaluateModel;
import com.didi.travel.psnger.model.response.OrderCom;
import com.didichuxing.xpanel.util.Utils;
import org.json.JSONObject;

public class FiveStarPresenter extends AbsFiveStarPresenter {

    /* renamed from: a */
    final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f13490a = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            OrderCom orderCom = OrderComManager.getInstance().getOrderCom();
            EvaluateModel evaluateModel = OrderComManager.getInstance().evaluateModel;
            if (orderCom != null && evaluateModel != null) {
                ((AbsFiveStarView) FiveStarPresenter.this.mView).showEvaluated(evaluateModel.evaluateScore);
            }
        }
    };

    public FiveStarPresenter(Context context) {
        super(context);
    }

    public FiveStarPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public void setViewWithData(JSONObject jSONObject, IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        if (jSONObject != null) {
            FiveStarModel fiveStarModel = new FiveStarModel();
            fiveStarModel.parse(jSONObject);
            ((AbsFiveStarView) this.mView).initData(fiveStarModel);
            iXpCardBindDataReadyCallback.ready(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Trip.EVENT_GLOBAL_XPANEL_FIVE_STAR_COMPLETED, this.f13490a);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Trip.EVENT_GLOBAL_XPANEL_FIVE_STAR_COMPLETED, this.f13490a);
    }

    public void onEvaluatedClicked(int i, String str) {
        if (!Utils.isFastDoubleClick()) {
            if (i >= 0) {
                m9250a(i);
            }
            m9251a(i, str);
        }
    }

    /* renamed from: a */
    private void m9250a(int i) {
        if (OrderComManager.getInstance().evaluateModel == null) {
            OrderComManager.getInstance().evaluateModel = new EvaluateModel();
        }
        OrderComManager.getInstance().evaluateModel.evaluateScore = i;
    }

    /* renamed from: a */
    private void m9251a(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(BaseExtras.Home.EXTRAS_EVALUATE_LEVEL, i);
        bundle.putInt(BaseExtras.Home.EXTRAS_EVALUATE_STYLE, 1);
        bundle.putString(BaseExtras.Home.EXTRAS_EVALUATE_JSON, str);
        doPublish(BaseEventKeys.Template.EVENT_SHOW_POPUP_COMPONENT, new ComponentWrap(ComponentType.EVALUATE, bundle));
    }
}
