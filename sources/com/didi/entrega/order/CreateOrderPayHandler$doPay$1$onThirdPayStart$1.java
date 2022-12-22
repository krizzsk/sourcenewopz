package com.didi.entrega.order;

import com.didi.app.nova.skeleton.ILive;
import com.didi.entrega.customer.foundation.util.BaseLifecycleHelper;
import com.didi.entrega.customer.foundation.util.UiHandlerUtil;
import com.didi.trackupload.sdk.Constants;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/entrega/order/CreateOrderPayHandler$doPay$1$onThirdPayStart$1", "Lcom/didi/entrega/customer/foundation/util/BaseLifecycleHelper;", "onPause", "", "p0", "Lcom/didi/app/nova/skeleton/ILive;", "onResume", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateOrderPayHandler.kt */
public final class CreateOrderPayHandler$doPay$1$onThirdPayStart$1 extends BaseLifecycleHelper {
    final /* synthetic */ CreateOrderPayHandler$doPay$1 this$0;
    final /* synthetic */ CreateOrderPayHandler this$1;

    CreateOrderPayHandler$doPay$1$onThirdPayStart$1(CreateOrderPayHandler$doPay$1 createOrderPayHandler$doPay$1, CreateOrderPayHandler createOrderPayHandler) {
        this.this$0 = createOrderPayHandler$doPay$1;
        this.this$1 = createOrderPayHandler;
    }

    public void onResume(ILive iLive) {
        UiHandlerUtil.postDelayed(this.this$0.thirdPayRunnable, Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
    }

    public void onPause(ILive iLive) {
        this.this$1.getTimeoutHandler().cancel();
        UiHandlerUtil.removeCallbacks(this.this$0.thirdPayRunnable);
    }
}
