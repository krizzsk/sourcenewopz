package com.didi.soda.customer.p165h5.invokejs;

import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0014\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH'¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/customer/h5/invokejs/CustomerWebTrigger;", "", "triggerAddressChanged", "", "triggerBillEvent", "data", "Lorg/json/JSONObject;", "triggerWebViewLifecycleEvent", "type", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Module(name = "Customer")
/* renamed from: com.didi.soda.customer.h5.invokejs.CustomerWebTrigger */
/* compiled from: CustomerWebTrigger.kt */
public interface CustomerWebTrigger {
    @Trigger(name = "triggerAddressChanged")
    void triggerAddressChanged();

    @Trigger(name = "triggerBillEvent")
    void triggerBillEvent(JSONObject jSONObject);

    @Trigger(name = "triggerWebViewLifecycleEvent")
    void triggerWebViewLifecycleEvent(String str);

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.soda.customer.h5.invokejs.CustomerWebTrigger$DefaultImpls */
    /* compiled from: CustomerWebTrigger.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void triggerBillEvent$default(CustomerWebTrigger customerWebTrigger, JSONObject jSONObject, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    jSONObject = null;
                }
                customerWebTrigger.triggerBillEvent(jSONObject);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: triggerBillEvent");
        }
    }
}
