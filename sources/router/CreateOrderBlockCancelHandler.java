package router;

import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;

public class CreateOrderBlockCancelHandler implements IRouterHandler {
    public static final String CANCEL = "cancel";

    public void handle(Request request, Result result) {
        if (!TextUtils.isEmpty(request.getUri().getPath())) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.EVENT_CREATE_ORDER_BLOCK, "cancel");
        }
    }
}
