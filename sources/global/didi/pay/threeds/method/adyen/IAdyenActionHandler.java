package global.didi.pay.threeds.method.adyen;

import android.net.Uri;
import com.adyen.checkout.components.model.payments.response.Action;

public interface IAdyenActionHandler {
    void handleAction(Action action);

    void handleRedirectResponse(Uri uri);

    boolean openActivityHandle(Action action);

    void setListener(IAdyen3DSListener iAdyen3DSListener);
}
