package com.adyen.checkout.components.model.payments.request;

import android.text.TextUtils;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONObject;

public abstract class PaymentMethodDetails extends ModelObject {
    public static final ModelObject.Serializer<PaymentMethodDetails> SERIALIZER = new ModelObject.Serializer<PaymentMethodDetails>() {
        public JSONObject serialize(PaymentMethodDetails paymentMethodDetails) {
            String type = paymentMethodDetails.getType();
            if (!TextUtils.isEmpty(type)) {
                return PaymentMethodDetails.m1046a(type).serialize(paymentMethodDetails);
            }
            throw new CheckoutException("PaymentMethod type not found");
        }

        public PaymentMethodDetails deserialize(JSONObject jSONObject) {
            String optString = jSONObject.optString("type", (String) null);
            if (!TextUtils.isEmpty(optString)) {
                return (PaymentMethodDetails) PaymentMethodDetails.m1046a(optString).deserialize(jSONObject);
            }
            throw new CheckoutException("PaymentMethod type not found");
        }
    };
    public static final String TYPE = "type";

    /* renamed from: a */
    private String f796a;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.adyen.checkout.core.model.ModelObject.Serializer<? extends com.adyen.checkout.components.model.payments.request.PaymentMethodDetails> m1046a(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -1647305830: goto L_0x0095;
                case -1325974849: goto L_0x008b;
                case -907987547: goto L_0x0081;
                case -857582069: goto L_0x0076;
                case 100648: goto L_0x006c;
                case 3026668: goto L_0x0061;
                case 100048981: goto L_0x0057;
                case 103700794: goto L_0x004c;
                case 970824177: goto L_0x0042;
                case 970824245: goto L_0x0038;
                case 1200873767: goto L_0x002c;
                case 1474526159: goto L_0x0020;
                case 1545915136: goto L_0x0014;
                case 1984622361: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x009f
        L_0x0009:
            java.lang.String r0 = "openbanking_UK"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x009f
            r1 = 7
            goto L_0x00a0
        L_0x0014:
            java.lang.String r0 = "sepadirectdebit"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x009f
            r1 = 11
            goto L_0x00a0
        L_0x0020:
            java.lang.String r0 = "googlepay"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x009f
            r1 = 9
            goto L_0x00a0
        L_0x002c:
            java.lang.String r0 = "paywithgoogle"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x009f
            r1 = 10
            goto L_0x00a0
        L_0x0038:
            java.lang.String r0 = "molpay_ebanking_VN"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x009f
            r1 = 4
            goto L_0x00a0
        L_0x0042:
            java.lang.String r0 = "molpay_ebanking_TH"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x009f
            r1 = 3
            goto L_0x00a0
        L_0x004c:
            java.lang.String r0 = "mbway"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x009f
            r1 = 12
            goto L_0x00a0
        L_0x0057:
            java.lang.String r0 = "ideal"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x009f
            r1 = 0
            goto L_0x00a0
        L_0x0061:
            java.lang.String r0 = "blik"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x009f
            r1 = 13
            goto L_0x00a0
        L_0x006c:
            java.lang.String r0 = "eps"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x009f
            r1 = 6
            goto L_0x00a0
        L_0x0076:
            java.lang.String r0 = "entercash"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x009f
            r1 = 8
            goto L_0x00a0
        L_0x0081:
            java.lang.String r0 = "scheme"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x009f
            r1 = 1
            goto L_0x00a0
        L_0x008b:
            java.lang.String r0 = "dotpay"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x009f
            r1 = 5
            goto L_0x00a0
        L_0x0095:
            java.lang.String r0 = "molpay_ebanking_fpx_MY"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x009f
            r1 = 2
            goto L_0x00a0
        L_0x009f:
            r1 = -1
        L_0x00a0:
            switch(r1) {
                case 0: goto L_0x00c4;
                case 1: goto L_0x00c1;
                case 2: goto L_0x00be;
                case 3: goto L_0x00be;
                case 4: goto L_0x00be;
                case 5: goto L_0x00bb;
                case 6: goto L_0x00b8;
                case 7: goto L_0x00b5;
                case 8: goto L_0x00b2;
                case 9: goto L_0x00af;
                case 10: goto L_0x00af;
                case 11: goto L_0x00ac;
                case 12: goto L_0x00a9;
                case 13: goto L_0x00a6;
                default: goto L_0x00a3;
            }
        L_0x00a3:
            com.adyen.checkout.core.model.ModelObject$Serializer<com.adyen.checkout.components.model.payments.request.GenericPaymentMethod> r1 = com.adyen.checkout.components.model.payments.request.GenericPaymentMethod.SERIALIZER
            return r1
        L_0x00a6:
            com.adyen.checkout.core.model.ModelObject$Serializer<com.adyen.checkout.components.model.payments.request.BlikPaymentMethod> r1 = com.adyen.checkout.components.model.payments.request.BlikPaymentMethod.SERIALIZER
            return r1
        L_0x00a9:
            com.adyen.checkout.core.model.ModelObject$Serializer<com.adyen.checkout.components.model.payments.request.MBWayPaymentMethod> r1 = com.adyen.checkout.components.model.payments.request.MBWayPaymentMethod.SERIALIZER
            return r1
        L_0x00ac:
            com.adyen.checkout.core.model.ModelObject$Serializer<com.adyen.checkout.components.model.payments.request.SepaPaymentMethod> r1 = com.adyen.checkout.components.model.payments.request.SepaPaymentMethod.SERIALIZER
            return r1
        L_0x00af:
            com.adyen.checkout.core.model.ModelObject$Serializer<com.adyen.checkout.components.model.payments.request.GooglePayPaymentMethod> r1 = com.adyen.checkout.components.model.payments.request.GooglePayPaymentMethod.SERIALIZER
            return r1
        L_0x00b2:
            com.adyen.checkout.core.model.ModelObject$Serializer<com.adyen.checkout.components.model.payments.request.EntercashPaymentMethod> r1 = com.adyen.checkout.components.model.payments.request.EntercashPaymentMethod.SERIALIZER
            return r1
        L_0x00b5:
            com.adyen.checkout.core.model.ModelObject$Serializer<com.adyen.checkout.components.model.payments.request.OpenBankingPaymentMethod> r1 = com.adyen.checkout.components.model.payments.request.OpenBankingPaymentMethod.SERIALIZER
            return r1
        L_0x00b8:
            com.adyen.checkout.core.model.ModelObject$Serializer<com.adyen.checkout.components.model.payments.request.EPSPaymentMethod> r1 = com.adyen.checkout.components.model.payments.request.EPSPaymentMethod.SERIALIZER
            return r1
        L_0x00bb:
            com.adyen.checkout.core.model.ModelObject$Serializer<com.adyen.checkout.components.model.payments.request.DotpayPaymentMethod> r1 = com.adyen.checkout.components.model.payments.request.DotpayPaymentMethod.SERIALIZER
            return r1
        L_0x00be:
            com.adyen.checkout.core.model.ModelObject$Serializer<com.adyen.checkout.components.model.payments.request.MolpayPaymentMethod> r1 = com.adyen.checkout.components.model.payments.request.MolpayPaymentMethod.SERIALIZER
            return r1
        L_0x00c1:
            com.adyen.checkout.core.model.ModelObject$Serializer<com.adyen.checkout.components.model.payments.request.CardPaymentMethod> r1 = com.adyen.checkout.components.model.payments.request.CardPaymentMethod.SERIALIZER
            return r1
        L_0x00c4:
            com.adyen.checkout.core.model.ModelObject$Serializer<com.adyen.checkout.components.model.payments.request.IdealPaymentMethod> r1 = com.adyen.checkout.components.model.payments.request.IdealPaymentMethod.SERIALIZER
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.components.model.payments.request.PaymentMethodDetails.m1046a(java.lang.String):com.adyen.checkout.core.model.ModelObject$Serializer");
    }

    public String getType() {
        return this.f796a;
    }

    public void setType(String str) {
        this.f796a = str;
    }
}
