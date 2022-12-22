package com.adyen.checkout.components.model.payments.response;

import android.text.TextUtils;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.model.ModelObject;
import org.json.JSONObject;

public abstract class Action extends ModelObject {
    public static final String PAYMENT_DATA = "paymentData";
    public static final String PAYMENT_METHOD_TYPE = "paymentMethodType";
    public static final ModelObject.Serializer<Action> SERIALIZER = new ModelObject.Serializer<Action>() {
        public JSONObject serialize(Action action) {
            String type = action.getType();
            if (!TextUtils.isEmpty(type)) {
                return Action.m1047a(type).serialize(action);
            }
            throw new CheckoutException("Action type not found");
        }

        public Action deserialize(JSONObject jSONObject) {
            String optString = jSONObject.optString("type");
            if (!TextUtils.isEmpty(optString)) {
                return (Action) Action.m1047a(optString).deserialize(jSONObject);
            }
            throw new CheckoutException("Action type not found");
        }
    };
    public static final String TYPE = "type";

    /* renamed from: a */
    private String f809a;

    /* renamed from: b */
    private String f810b;

    /* renamed from: c */
    private String f811c;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.adyen.checkout.core.model.ModelObject.Serializer<? extends com.adyen.checkout.components.model.payments.response.Action> m1047a(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            switch(r0) {
                case -952485970: goto L_0x0052;
                case -776144932: goto L_0x0048;
                case 113722: goto L_0x003e;
                case 93223254: goto L_0x0034;
                case 640192174: goto L_0x0029;
                case 1021099710: goto L_0x001e;
                case 1337458815: goto L_0x0013;
                case 1473713957: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x005c
        L_0x0008:
            java.lang.String r0 = "threeDS2"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x005c
            r0 = 3
            goto L_0x005d
        L_0x0013:
            java.lang.String r0 = "threeDS2Fingerprint"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x005c
            r0 = 1
            goto L_0x005d
        L_0x001e:
            java.lang.String r0 = "threeDS2Challenge"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x005c
            r0 = 2
            goto L_0x005d
        L_0x0029:
            java.lang.String r0 = "voucher"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x005c
            r0 = 5
            goto L_0x005d
        L_0x0034:
            java.lang.String r0 = "await"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x005c
            r0 = 7
            goto L_0x005d
        L_0x003e:
            java.lang.String r0 = "sdk"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x005c
            r0 = 6
            goto L_0x005d
        L_0x0048:
            java.lang.String r0 = "redirect"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x005c
            r0 = 0
            goto L_0x005d
        L_0x0052:
            java.lang.String r0 = "qrCode"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x005c
            r0 = 4
            goto L_0x005d
        L_0x005c:
            r0 = -1
        L_0x005d:
            switch(r0) {
                case 0: goto L_0x008c;
                case 1: goto L_0x0089;
                case 2: goto L_0x0086;
                case 3: goto L_0x0083;
                case 4: goto L_0x0080;
                case 5: goto L_0x007d;
                case 6: goto L_0x007a;
                case 7: goto L_0x0077;
                default: goto L_0x0060;
            }
        L_0x0060:
            com.adyen.checkout.core.exception.CheckoutException r0 = new com.adyen.checkout.core.exception.CheckoutException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Action type not found - "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        L_0x0077:
            com.adyen.checkout.core.model.ModelObject$Serializer<com.adyen.checkout.components.model.payments.response.AwaitAction> r3 = com.adyen.checkout.components.model.payments.response.AwaitAction.SERIALIZER
            return r3
        L_0x007a:
            com.adyen.checkout.core.model.ModelObject$Serializer<com.adyen.checkout.components.model.payments.response.SdkAction> r3 = com.adyen.checkout.components.model.payments.response.SdkAction.SERIALIZER
            return r3
        L_0x007d:
            com.adyen.checkout.core.model.ModelObject$Serializer<com.adyen.checkout.components.model.payments.response.VoucherAction> r3 = com.adyen.checkout.components.model.payments.response.VoucherAction.SERIALIZER
            return r3
        L_0x0080:
            com.adyen.checkout.core.model.ModelObject$Serializer<com.adyen.checkout.components.model.payments.response.QrCodeAction> r3 = com.adyen.checkout.components.model.payments.response.QrCodeAction.SERIALIZER
            return r3
        L_0x0083:
            com.adyen.checkout.core.model.ModelObject$Serializer<com.adyen.checkout.components.model.payments.response.Threeds2Action> r3 = com.adyen.checkout.components.model.payments.response.Threeds2Action.SERIALIZER
            return r3
        L_0x0086:
            com.adyen.checkout.core.model.ModelObject$Serializer<com.adyen.checkout.components.model.payments.response.Threeds2ChallengeAction> r3 = com.adyen.checkout.components.model.payments.response.Threeds2ChallengeAction.SERIALIZER
            return r3
        L_0x0089:
            com.adyen.checkout.core.model.ModelObject$Serializer<com.adyen.checkout.components.model.payments.response.Threeds2FingerprintAction> r3 = com.adyen.checkout.components.model.payments.response.Threeds2FingerprintAction.SERIALIZER
            return r3
        L_0x008c:
            com.adyen.checkout.core.model.ModelObject$Serializer<com.adyen.checkout.components.model.payments.response.RedirectAction> r3 = com.adyen.checkout.components.model.payments.response.RedirectAction.SERIALIZER
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.components.model.payments.response.Action.m1047a(java.lang.String):com.adyen.checkout.core.model.ModelObject$Serializer");
    }

    public String getType() {
        return this.f809a;
    }

    public void setType(String str) {
        this.f809a = str;
    }

    public String getPaymentData() {
        return this.f810b;
    }

    public void setPaymentData(String str) {
        this.f810b = str;
    }

    public String getPaymentMethodType() {
        return this.f811c;
    }

    public void setPaymentMethodType(String str) {
        this.f811c = str;
    }
}
