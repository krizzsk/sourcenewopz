package com.didi.component.payway.anycar.model;

import android.text.TextUtils;
import com.didi.commoninterfacelib.sotre.IBusinessInfoStore;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.HashMap;

@ServiceProvider({IBusinessInfoStore.class})
public class GlobalPaymentStore implements IBusinessInfoStore {
    public HashMap<String, Object> getInfos() {
        int i;
        String str;
        HashMap<String, Object> hashMap = new HashMap<>();
        CarOrder order = CarOrderHelper.getOrder();
        String str2 = "";
        if (order == null || TextUtils.isEmpty(order.oid) || order.status != 5) {
            i = 0;
            str = str2;
        } else {
            str2 = order.getOid();
            str = String.valueOf(order.productid);
            i = 1;
        }
        hashMap.put("order_id", str2);
        hashMap.put("product_line", str);
        hashMap.put("sign_after_order", Integer.valueOf(i));
        return hashMap;
    }
}
