package router;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import java.util.HashMap;
import java.util.Map;

public class WaitRspCancelHandler implements IRouterHandler {
    public static final String CANCEL = "cancel";

    public void handle(Request request, Result result) {
        if (!TextUtils.isEmpty(request.getUri().getPath())) {
            Bundle extra = request.getExtra();
            extra.putString("action", "cancel");
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.WaitRsp.EVENT_WAITRSP_CANCEL, extra);
            dialogClickYesEvent();
        }
    }

    /* access modifiers changed from: protected */
    public void dialogClickYesEvent() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(CarOrderHelper.getReAssignOrderType()));
        hashMap.put("fixed", FormStore.getInstance().isCountPriceTypeFixed() ? "1" : "0");
        hashMap.put(ParamConst.PARAM_WAIT_TIME, String.valueOf((System.currentTimeMillis() - CarOrderHelper.getOrderCreateTime()) / 1000));
        GlobalOmegaUtils.trackEvent("pas_waitforresponse_cancelconfdlgyes_ck", (Map<String, Object>) hashMap);
    }
}
