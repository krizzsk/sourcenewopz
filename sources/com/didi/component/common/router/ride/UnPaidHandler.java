package com.didi.component.common.router.ride;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.base.ComponentWrap;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.travel.psnger.model.response.CashUnPayInterceptInfo;
import com.didiglobal.xbanner.XBanner;
import org.json.JSONException;
import org.json.JSONObject;

public class UnPaidHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        String string = request.getString(XBanner.XB_EXTENSION_KEY);
        String string2 = request.getString(XBanner.XB_CARDID_KEY);
        if (string != null) {
            try {
                JSONObject optJSONObject = new JSONObject(string).optJSONObject("biz_params");
                CashUnPayInterceptInfo cashUnPayInterceptInfo = new CashUnPayInterceptInfo();
                cashUnPayInterceptInfo.parse(optJSONObject);
                cashUnPayInterceptInfo.mCardId = string2;
                if (cashUnPayInterceptInfo.type != 2) {
                    if (cashUnPayInterceptInfo.type != 4) {
                        if (cashUnPayInterceptInfo.type == 1 && !TextUtils.isEmpty(cashUnPayInterceptInfo.link)) {
                            DRouter.build(cashUnPayInterceptInfo.link).start(request.getContext());
                            return;
                        }
                        return;
                    }
                }
                ComponentWrap componentWrap = new ComponentWrap(ComponentType.SERVICE_CONTROL_NO_PAY);
                componentWrap.setClickMaskHide(true);
                Bundle bundle = new Bundle();
                cashUnPayInterceptInfo.mEntry = "xbanner";
                bundle.putSerializable("BUNDLE_CAR_ORDER_UNPAY_INFO", cashUnPayInterceptInfo);
                componentWrap.setBundle(bundle);
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Template.EVENT_SHOW_POPUP_COMPONENT, componentWrap);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
