package global.didi.pay.threeds.model;

import com.adyen.checkout.components.ActionComponentData;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class AdyenActionComponentData implements Serializable {
    public ActionComponentData mData;

    public AdyenActionComponentData(ActionComponentData actionComponentData) {
        this.mData = actionComponentData;
    }

    public JSONObject trans() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("threeDSDetails", this.mData.getDetails().toString());
            jSONObject.put("paymentData", this.mData.getPaymentData());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
