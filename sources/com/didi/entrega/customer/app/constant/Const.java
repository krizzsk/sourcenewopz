package com.didi.entrega.customer.app.constant;

public final class Const {
    public static final int INFO_REMARK_TOTAL = 200;

    public static class AddressAidType {
        public static final int TYPE_HOME = 1;
        public static final int TYPE_NORMAL = 0;
        public static final int TYPE_OFFICE = 2;
    }

    public static class AddressDragStatus {
        public static final int TYPE_IN = 0;
        public static final int TYPE_OUT = 1;
    }

    public static class AddressListItemType {
        public static final int DEFAULT = 0;
        public static final int ENTREGA = 3;
        public static final int NEARBY = 1;
        public static final int SEARCH = 4;
        public static final int SODA = 2;
    }

    public static class AddressType {
        public static final int TYPE_CURRENT_GPS = 4;
        public static final int TYPE_ENTREGA = 3;
        public static final int TYPE_NEARBY = 0;
        public static final int TYPE_SEARCH = 1;
        public static final int TYPE_SODA = 2;
    }

    public static final class AnimationConst {
        public static final long ANIMATION_TIME_100_MS = 100;
        public static final long ANIMATION_TIME_200_MS = 200;
        public static final long ANIMATION_TIME_300_MS = 300;
        public static final long ANIMATION_TIME_400_MS = 400;
        public static final long ANIMATION_TIME_50_MS = 50;
    }

    public static class AppBrand {
        public static final int Brazil99 = 2;
        public static final int DIDI = 1;
    }

    public static class BillClickType {
        public static final String COUPON = "coupon";
        public static final String GOODS = "goods";
        public static final String PAY_METHOD = "pay_method";
        public static final String RECEIVER = "receiver";
        public static final String SENDER = "sender";
        public static final String TIPS = "tips";
        public static final String TRANSFORM = "transform";
    }

    public static final class BillEventSource {
        public static final int CART_CLICK = 2;
        public static final int NEXT_CLICK = 1;
    }

    public static final class BillPageSource {
        public static final int INFO_PAGE = 2;
        public static final int POI_PAGE = 1;
    }

    public static final class BundleKey {
        public static final String BILL_PAY_CALLBACK = "bill_pay_callback";
        public static final String BUSINESS_ID = "business_id";
        public static final String CART_ID = "cartId";
        public static final String CART_TYPE = "cart_type";
        public static final String CURRENT_SHOP_ID = "current_shop_id";
        public static final String DEBT_ID = "debt_id";
        public static final String DEBT_PAY_RESULT = "debt_pay_result";
        public static final String DEFAULT_NOTE = "cart_note";
        public static final String DELIVERY_METHOD_ID = "delivery_method_id";
        public static final String FROM_PAGE = "from_page";
        public static final String INFO_PAGE_BILL_CARTID = "info_bill_cartid";
        public static final String INFO_PAGE_BILL_RECEIVE = "receiverAddress";
        public static final String INFO_PAGE_BILL_SEND = "senderAddress";
        public static final String INFO_PAGE_BILL_STUFF = "packageInfo";
        public static final String INFO_PAGE_CONFIG = "info_page_config";
        public static final String INFO_PAGE_SERVICE_ENTITY = "info_service_entity";
        public static final String IS_EVALUATED_RESULT = "isEvaluatedResult";
        public static final String ORDER_ID = "order_id";
        public static final String ORDER_PAY_TIPS_SELECT_PAYCARD = "order_pay_tips_select_paycard";
        public static final String OUT_OF_STOCK_DATA = "out_of_stock_data";
        public static final String PAY_CALLBACK = "pay_callback";
        public static final String PAY_CHANNEL = "pay_channel";
        public static final String PAY_METHOD_COUPON_INFO = "pay_method_coupon_info";
        public static final String PAY_METHOD_PRICE = "pay_method_price";
        public static final String PAY_METHOD_PRICE_DISPLAY = "pay_method_price_dislay";
        public static final String PAY_SCENE = "pay_scene";
        public static final String PICK_PHOTO_RESULT = "pick_photo_result";
        public static final String PICK_PHOTO_URI = "pick_photo_uri";
        public static final String POP_DIALOG_FRAGMENT = "pop_dialog_fragment";
        public static final String PRELOAD_STATE = "preload_state";
        public static final String RISK_AUTH_RESULT = "risk_auth_result";
        public static final String SELECT_COUPON = "platCoupon";
        public static final String SELECT_PAYMENT_DATA = "paymentMethodData";
        public static final String SELECT_PAYMENT_METHOD = "payMethodPage";
        public static final String SELECT_RECEVIER_ADDRESS = "select_recevier_address";
        public static final String SELECT_SENDER_ADDRESS = "select_sender_address";
        public static final String SELECT_TIP_FEE = "tipFee";
        public static final String SERVICE_CART_KEY = "service_cart_key";
        public static final String SERVICE_FLOATING_CART_KEY = "service_floating_cart_key";
        public static final String TRANSFER_TYPE = "transfer_type";
    }

    public static final class CartRedirectType {
        public static final int TYPE_CAN_REDIRECT = 1;
        public static final int TYPE_NOT_REDIRECT = 0;
    }

    public static class CommonConst {
    }

    public static class ContactInfoType {
        public static final int TYPE_RECEIVE = 2;
        public static final int TYPE_SEND = 1;
    }

    public static final class EnterAddressMainPageType {
        public static final int FROM_PAGE_BILL_RECEIVE_GOODS = 4;
        public static final int FROM_PAGE_BILL_SEND_GOODS = 3;
        public static final int FROM_PAGE_POI_RECEIVE_GOODS = 6;
        public static final int FROM_PAGE_POI_SEND_GOODS = 5;
        public static final int FROM_PAGE_RECEIVE_GOODS = 2;
        public static final int FROM_PAGE_SEND_GOODS = 1;
    }

    public static final class EnterOrderPageType {
        public static final int ENTER_HISTORY_ORDER_LIST = 3;
        public static final int ENTER_PAGE_BILL = 2;
        public static final int ENTER_PAGE_HOME = 1;
    }

    public static final class FlutterBundleKey {
        public static final String COUPON_ID = "couponId";
        public static final String CURRENCY = "currency";
        public static final String DEBT_ID = "debtId";
        public static final String DROP_OFF_ADDRESS = "dropoffAddress";
        public static final String ORDER_ADDRESS_LIST_TOAST = "modifyAddressSuccessToast";
        public static final String ORDER_ID = "orderId";
        public static final String Order_STATUS = "orderStatus";
        public static final String PAY_CHANNEL = "payChannel";
        public static final String PAY_CHANNEL4 = "payChannel4";
        public static final String PAY_METHOD_PRICE_DISPLAY = "unpaidMoneyDisplay";
        public static final String PICK_UP_ADDRESS = "pickupAddress";
        public static final String TIPFEEBASEPRICE = "tipFeeBasePrice";
        public static final String TIPFEEINFO = "tipFeeInfo";
        public static final String UNPAID_MONEY = "unpaidMoney";
    }

    public static final class H5Params {
        public static final String CLOSESIDEMENU = "closeSideMenu";
        public static final String COUPON_ID = "coupon_id";
        public static final String ORDER_ID = "orderId";
        public static final String STATUS = "status";
        public static final String STATUS_DESC = "statusDesc";
        public static final String STATUS_SUB_DESC = "statusSubDesc";
    }

    public static final class HomePageExceptionCKType {
        public static final int OPEN_LOCATION = 2;
        public static final int REFRESH = 1;
        public static final int SELECT_OPENED_LIST = 3;
    }

    public static final class HomePageExceptionStatu {
        public static final int GPS_NOT_OPEN = 4;
        public static final int NO_LOCATION_PERMISSION = 3;
        public static final int NO_NET_WORK = 1;
        public static final int NO_SERVICE = 2;
    }

    public static class HomeRefreshType {
        public static final int TYPE_INIT = 1;
        public static final int TYPE_LAT_LNG = 7;
        public static final int TYPE_ON_RESUME = 2;
        public static final int TYPE_ORDER_LIST = 3;
        public static final int TYPE_TRY_AGAIN = 4;
    }

    public static final class InfoComTmplType {
        public static final int INFO_TMPL_CARD_CONTACT = 100;
        public static final int INFO_TMPL_CARD_HISTORY = 300;
        public static final int INFO_TMPL_CARD_STUF_REMARK = 500;
        public static final int INFO_TMPL_CARD_STUF_RULE = 600;
        public static final int INFO_TMPL_CARD_STUF_TYPE = 400;
        public static final int INFO_TMPL_CARD_TITLE = 200;
    }

    public static final class InfoHasValue {

        /* renamed from: NO */
        public static final int f19798NO = 2;
        public static final int YES = 1;
    }

    public static final class InfoInitConfig {
        public static final int INFO_VIEW_CREATE = 1;
        public static final int INFO_VIEW_UPDATE = 2;
    }

    public static final class InfoOrderConfigUpdateType {
        public static final int UPDATE_TYPE_INCOMPLETE = 1;
        public static final int UPDATE_TYPE_TOTAL = 0;
    }

    public static final class InfoPageResource {
        public static final int CREATE = 101;
        public static final int UPDATE = 201;
    }

    public static final class InfoStepEnum {
        public static final int INFO_STEP_1 = 1;
        public static final int INFO_STEP_2 = 2;
        public static final int INFO_STEP_3 = 3;
    }

    public static final class MainFragmentArgKey {
        public static final String KEY_ACTION_TYPE = "action_type";
        public static final String KEY_FROM_TAB = "from_tab";
    }

    public static class MapShowStatus {
        public static final int HIDE_MAP = 0;
        public static final int SHOW_MAP = 1;
    }

    public static final class NetworkStatus {
        public static final int CONNECTED = -10000;
        public static final int NOT_CONNECTED = -10001;
    }

    public static class OrderContactRole {
        public static final int ROLE_RIDER = 2;
    }

    public static class OrderContactType {
        public static final int CONTACT_CALL = 22;
        public static final int CONTACT_IM = 11;
    }

    public static class OrderIsRealComplete {
        public static final int COMPLETED = 1;
        public static final int NO_COMPLETE = 0;
    }

    public static final class OrderItemStatus {
        public static final int COMPLETED = 2;
        public static final int IN_PROGRESS = 1;
    }

    public static final class OrderListButtonsType {
        public static final int DEBT = 3;
        public static final int EVALUATE = 2;
        public static final int SHARE = 1;
    }

    public static class OrderStatus {
        public static final int ABNORMAL = 1900;
        public static final int CANCEL = 1600;
        public static final int C_FOR_PAY = 0;
        public static final int DEFAULT = -2000;
        public static final int D_ARRIVED_DESTINATION = 1500;
        public static final int D_ARRIVED_ORIGIN = 1300;
        public static final int D_CONFIRM = 1200;
        public static final int D_TAKEN = 1400;
        public static final int FINISH = 1800;
        public static final int PAID = 1100;
    }

    public static class OrderSubStatus {
        public static final int DIDI_CANCEL = 320;
        public static final int RIDER_CANCEL_BACK = 220;
        public static final int RIDER_CANCEL_DELIVERY_LATER = 221;
        public static final int USER_CANCEL = 20;
    }

    public static class PageParams {
        public static final String BACK_BUTTON_SHOW = "backbuttonshow";
        public static final String BUNDLE = "bundle";
        public static final String CONTACT_ROLE = "contactRole";
        public static final String CONTACT_TYPE = "contactType";
        public static final String COUNT = "count";
        public static final String ENTITY = "entity";
        public static final String FROM = "from";
        public static final String FROM_PAGE = "fromPage";
        public static final String ORDER_ID = "orderId";
        public static final String ORDER_PAYING = "orderpaying";
        public static final String PAGE_NAME = "PageName";
        public static final String PHONE_NUMBER = "phoneNumber";
        public static final String REMOVE_FONT_PAGE = "remove_font_page";
        public static final String SCHEME_ASSIST_PATH = "schemeAssistPath";
        public static final String SCHEME_ROUTER_TAG = "schemeRouterTag";
        public static final String SECURITY_LIST = "securitylist";
        public static final String WEBPAGE_BUNDLE = "webpagebundle";
        public static final String WEBPAGE_TYPE = "nativeWebUIType";
    }

    public static final class Pay99Status {
        public static final int AVAILABLE = 1;
        public static final int DEFAULT = 0;
        public static final int NOT_ENABLE = 3;
        public static final int NOT_ENOUGH = 2;
    }

    public static final class PayScene {
        public static final int DEBT_ORDER = 1;
        public static final int DEFAULT = 0;
        public static final int TIP = 2;
    }

    public static final class PushParams {
        public static final int DISPATCHER_RIDER_ID_TOPIC = 2049;
        public static final int RIDER_LOC_GET_BY_ID_TYPE = 10;
        public static final int ROLE_PASSENGER = 1;
        public static final int SLIDING_RIDER_PUSH_TOPIC = 259;
    }

    public static final class RpcConst {
        public static final String DATA = "data";
        public static final String ERRMSG = "errmsg";
        public static final String ERRNO = "errno";
        public static final String TIME = "time";
        public static final String URL = "url";
    }

    public static final class ServiceNotifyPageCKType {
        public static final int CLOSE = 29;
        public static final int CONFIRM = 21;
        public static final int DETAIL = 22;
    }
}
