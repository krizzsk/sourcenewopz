package global.didi.pay;

import android.content.Context;
import com.didi.unifiedPay.sdk.net.service.IUnipayService;
import com.didi.unifiedPay.sdk.net.service.UniPayNonTripHttpServiceImpl;
import com.didi.unifiedPay.sdk.net.service.UniPayTripHttpServiceImpl;
import java.io.Serializable;

public class GlobalUniPayService {

    public static class PayServiceParam implements Serializable {
        public boolean isOnline = true;
        public boolean isTripScene = true;
        public String oid;
        public int productId;
        public String token;
    }

    public IUnipayService getService(Context context, PayServiceParam payServiceParam) {
        if (context == null || payServiceParam == null) {
            return null;
        }
        if (payServiceParam.isTripScene) {
            UniPayTripHttpServiceImpl uniPayTripHttpServiceImpl = new UniPayTripHttpServiceImpl(context);
            uniPayTripHttpServiceImpl.init(payServiceParam.productId, payServiceParam.oid);
            return uniPayTripHttpServiceImpl;
        }
        UniPayNonTripHttpServiceImpl uniPayNonTripHttpServiceImpl = new UniPayNonTripHttpServiceImpl(context);
        uniPayNonTripHttpServiceImpl.init(payServiceParam.productId, payServiceParam.oid);
        return uniPayNonTripHttpServiceImpl;
    }
}
