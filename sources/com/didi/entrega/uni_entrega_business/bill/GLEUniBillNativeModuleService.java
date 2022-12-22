package com.didi.entrega.uni_entrega_business.bill;

public interface GLEUniBillNativeModuleService {

    public interface Result<T> {
        void success(T t);
    }

    void createdSuccessOrderInsertPool(String str, String str2);

    void enterCouponPage(String str, String str2, Result<String> result);

    void gotoPayMethodPage(String str, String str2, String str3, String str4, Result<String> result);

    void gotoTripPage(String str, String str2, Result<String> result);

    void isApplePaySupportedWithNetworks(String str, Result<Boolean> result);

    void queryPayWithpageID(String str, String str2, Result<String> result);

    void routeToVerifyPageWithTypes(String str, String str2);

    void saveBillInfo(String str);

    void showBillTippage(String str, String str2, Result<String> result);

    void showPriceRulePage(String str, String str2);

    void updateOrderPool(String str, String str2);

    void updatePayListWithPreInterface(String str, String str2, String str3);

    void verifyRandomPayWithPayment(String str, String str2, Result<Boolean> result);
}
