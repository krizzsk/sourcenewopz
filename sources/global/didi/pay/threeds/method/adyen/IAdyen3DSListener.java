package global.didi.pay.threeds.method.adyen;

import com.adyen.checkout.components.ActionComponentData;
import com.adyen.checkout.components.ComponentError;

public interface IAdyen3DSListener {
    void onCancel();

    void onFailure(ComponentError componentError);

    void onSuccess(ActionComponentData actionComponentData);
}
