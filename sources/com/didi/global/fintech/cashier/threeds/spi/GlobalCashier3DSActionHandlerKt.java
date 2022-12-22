package com.didi.global.fintech.cashier.threeds.spi;

import com.adyen.checkout.components.ActionComponentData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo175978d2 = {"trans", "", "Lcom/adyen/checkout/components/ActionComponentData;", "cashier_threeds_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashier3DSActionHandler.kt */
public final class GlobalCashier3DSActionHandlerKt {
    public static final String trans(ActionComponentData actionComponentData) {
        Intrinsics.checkNotNullParameter(actionComponentData, "<this>");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("threeDSDetails", String.valueOf(actionComponentData.getDetails()));
            jSONObject.put("paymentData", actionComponentData.getPaymentData());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }
}
