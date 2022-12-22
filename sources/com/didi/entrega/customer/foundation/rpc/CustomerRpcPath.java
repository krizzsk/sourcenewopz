package com.didi.entrega.customer.foundation.rpc;

public final class CustomerRpcPath {
    public static final String ADDRESS_CHECK = "/entrega/addressCheck";
    public static final String ADDRESS_LIST = "entrega/addressList";
    public static final String ADDRESS_NEARBY = "/entrega/addressNearBy";
    public static final String ADDRESS_SEARCH = "/address/textSearch";
    public static final String BILL_INFO = "/entrega/billInfo";
    public static final String BILL_UPDATE = "/entrega/updateBill";
    public static final String COMMON_GET_INFO = "/entrega/getCateInfo";
    public static final String COMMON_INFO = "/entrega/commonInfo";
    public static final String COMMON_INFO_DELETE_CONTACT = "/entrega/addressDel";
    public static final String COMMON_INFO_HISTORY_CONTACT_LIST = "/entrega/contactList";
    public static final String DEBT_REPAY = "/entrega/repay";
    public static final String DEBT_REPAY_FAIL = "/entrega/repayFail";
    public static final String ENTREGA_CONFIG = "/entrega/config";
    public static final String FEED_INDEX = "/entrega/index";
    public static final String HOME_SERVICE_CITY_LIST = "/entrega/serviceCityList";
    public static final String ORDER_CANCEL = "/entrega/orderCancel";
    public static final String ORDER_CREATE = "/entrega/orderCreate";
    public static final String ORDER_DETAIL = "/entrega/orderDetail";
    public static final String ORDER_INFO = "/entrega/getOrderInfo";
    public static final String ORDER_LIST = "/entrega/orderList";
    public static final String PAY_GETPAYINFO = "/entrega/payMethodList";
    public static final String POI_INFO = "/entrega/poiInfo";
    public static final String PROTECT_NUM = "/entrega/virtualTelPreCall";
    public static final String SET_APP_LANG = "/user/setAppLang";

    private CustomerRpcPath() {
    }
}
