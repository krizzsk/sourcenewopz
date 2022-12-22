package global.didi.pay.threeds.contract;

import com.adyen.checkout.components.model.payments.response.Action;
import global.didi.pay.threeds.method.adyen.IAdyen3DSListener;
import org.json.JSONObject;

public interface IAdyen3DS {
    boolean checkActionJsonObject(JSONObject jSONObject);

    void handleAction(Action action);

    void handleAction(JSONObject jSONObject);

    void registerListener(IAdyen3DSListener iAdyen3DSListener);

    void unregisterListener();
}
