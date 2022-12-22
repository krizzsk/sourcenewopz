package com.didi.component.common.router;

import android.net.Uri;
import android.text.TextUtils;
import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.common.util.GsonUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.google.gson.annotations.SerializedName;

public class PayRouterHandler implements IRouterHandler {

    public static class PayInfo implements BffGsonStruct {
        @SerializedName("pay_tag")
        public int payTag;
        @SerializedName("resource_id")
        public int resourceId;
        @SerializedName("to_add_card_info")
        public String toAddCardInfo;
    }

    public static class PayRouterModel implements BffGsonStruct {
        public static final String OPEN_BIND_CARD = "1";
        public static final String OPEN_PAY_WAY_LIST = "2";
        public static final String SWITCH_PAY_WAY = "3";
        public String actionType;
        public PayInfo payInfo;
    }

    public void handle(Request request, Result result) {
        Uri uri = request.getUri();
        final String queryParameter = uri.getQueryParameter("action_type");
        GsonUtils.fromJsonAsync(uri.getQueryParameter("pay_info"), PayInfo.class, new GsonUtils.OnFromJsonListener<PayInfo>() {
            public void onFail() {
            }

            public void onSuccess(PayInfo payInfo) {
                PayRouterModel payRouterModel = new PayRouterModel();
                payRouterModel.actionType = queryParameter;
                payRouterModel.payInfo = payInfo;
                if (!TextUtils.isEmpty(queryParameter)) {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Estimate.EVENT_PREORDER_INTERCEPT_PAYMENT_ACTION, payRouterModel);
                }
            }
        });
    }
}
