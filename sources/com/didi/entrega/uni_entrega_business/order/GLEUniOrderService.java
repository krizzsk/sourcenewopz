package com.didi.entrega.uni_entrega_business.order;

import java.util.Map;

public interface GLEUniOrderService {

    public interface Result<T> {
        void success(T t);
    }

    void contactByCall(String str, String str2);

    void contactByIm(String str, String str2);

    void contactByProtectedCall(String str, String str2);

    void getOrderDataByLocal(String str, String str2, Result<String> result);

    void onMapReset(String str);

    void requestOrderDataByService(String str, String str2, Result<String> result);

    void shareData(String str, Map<String, String> map);
}
