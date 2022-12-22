package com.didi.soda.customer.p165h5.invokejs;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.customer.p165h5.WebMessage;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/customer/h5/invokejs/TriggerJsHelper$listenBillMessage$subscription$1", "Lcom/didi/app/nova/skeleton/repo/Action1;", "Lcom/didi/soda/customer/h5/WebMessage;", "call", "", "msg", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.h5.invokejs.TriggerJsHelper$listenBillMessage$subscription$1 */
/* compiled from: TriggerJsHelper.kt */
public final class TriggerJsHelper$listenBillMessage$subscription$1 implements Action1<WebMessage> {
    final /* synthetic */ TriggerJsHelper this$0;

    TriggerJsHelper$listenBillMessage$subscription$1(TriggerJsHelper triggerJsHelper) {
        this.this$0 = triggerJsHelper;
    }

    public void call(WebMessage webMessage) {
        boolean z = false;
        if (webMessage != null && webMessage.getType() == 1) {
            z = true;
        }
        if (z) {
            CustomerWebTrigger customerWebTrigger = (CustomerWebTrigger) this.this$0.f41339d.get(CustomerWebTrigger.class);
            Object data = webMessage.getData();
            customerWebTrigger.triggerBillEvent(data instanceof JSONObject ? (JSONObject) data : null);
        }
    }
}
