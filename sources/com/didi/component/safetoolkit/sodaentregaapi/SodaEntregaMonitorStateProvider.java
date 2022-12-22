package com.didi.component.safetoolkit.sodaentregaapi;

import android.content.Context;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.safetoolkit.api.requests.SafeToolkitBffRequest;
import com.didi.safetoolkit.api.ISMonitorDetailsService;
import com.didi.safetoolkit.business.monitor.ISMonitorCallback;
import com.didi.safetoolkit.business.monitor.ISMonitorConfigCallback;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.google.gson.JsonObject;
import java.io.IOException;

@ServiceProvider(alias = "sodaEntrega", value = {ISMonitorDetailsService.class})
public class SodaEntregaMonitorStateProvider implements ISMonitorDetailsService {
    public void reportMonitorState(Context context, int i, int i2, final ISMonitorCallback iSMonitorCallback) {
        SafeToolkitBffRequest.reportMonitorState(context, new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                iSMonitorCallback.onSuccess(jsonObject.toString());
            }

            public void onFailure(IOException iOException) {
                iSMonitorCallback.onFailed(iOException);
            }
        }, i, i2);
    }

    public void refreshBubbleInfo(ISMonitorConfigCallback iSMonitorConfigCallback) {
        SceneHelper.getInstance().monitorConfigCallback = iSMonitorConfigCallback;
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.SafeToolkit.EVENT_MONITOR_STATUS_CHANGED);
    }

    public void reportMonitorEvent(Context context, int i) {
        String str;
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            str = "";
        } else {
            str = order.oid;
        }
        SafeToolkitBffRequest.reportEvent(context, new RpcService.Callback<JsonObject>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(JsonObject jsonObject) {
            }
        }, str, i);
    }
}
