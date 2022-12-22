package com.didi.rlab.uni_customer_business.order_service;

public interface OrderService {

    public interface Result<T> {
        void success(T t);
    }

    void contactByCall(String str, String str2, long j);

    void contactByIm(String str, String str2, long j);

    void dismissFloatingPage(String str);

    void goAppStoreRate(String str);

    void onMapReset(String str);

    void refreshIMUnreadCount(String str);

    void sendReceipt(String str, String str2, long j, Result<Boolean> result);
}
