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
import com.didi.sdk.monitor.PubSIDManager;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.bigdata.p173dp.locsdk.ntp.TimeServiceManager;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.HashMap;
import java.util.Map;

public class WaitRspContinueHandler implements IRouterHandler {
    public static final String CONTINUE = "continue";

    public void handle(Request request, Result result) {
        if (!TextUtils.isEmpty(request.getUri().getPath())) {
            Bundle extra = request.getExtra();
            extra.putString("action", "continue");
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.WaitRsp.EVENT_WAITRSP_CANCEL, extra);
            m3837a();
            m3838b();
        }
    }

    /* renamed from: a */
    private void m3837a() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(CarOrderHelper.getReAssignOrderType()));
        hashMap.put("fixed", FormStore.getInstance().isCountPriceTypeFixed() ? "1" : "0");
        hashMap.put(ParamConst.PARAM_WAIT_TIME, String.valueOf((TimeServiceManager.getInstance().getNTPCurrenTimeMillis() - CarOrderHelper.getOrderCreateTime()) / 1000));
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            hashMap.put("oid", order.oid);
        }
        GlobalOmegaUtils.trackEvent("pas_waitforresponse_cancelconfdlgno_ck", (Map<String, Object>) hashMap);
    }

    /* renamed from: b */
    private void m3838b() {
        HashMap hashMap = new HashMap();
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            int i = order.status;
            int i2 = order.substatus;
            if (i == 7) {
                hashMap.put(Constants.FILE_OOM_KEY, 1);
            }
            PubSIDManager.getInstance().setPubSID(hashMap);
        }
    }
}
