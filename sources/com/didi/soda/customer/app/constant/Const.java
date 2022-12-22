package com.didi.soda.customer.app.constant;

import com.didi.soda.customer.foundation.rpc.ABConfigHelper;
import com.didi.soda.customer.foundation.rpc.entity.ABConfigEntity;
import javax.annotation.Nullable;

public final class Const {
    public static final String URI_FROM_OUTER = "soda_uri_from_outer";

    public static final class ActionType {
        public static final int ADD_GOODS_ITEM = 1;
        public static final int API_ANCHOR = 2;
        public static final int API_ANCHOR_ADD = 3;
    }

    public static final class ActivityCheckType {
        public static final int ALWAYS_CHECK = 2;
        public static final int CHECK_AFTER_LOGIN = 1;
        public static final int NO_CHECK = 0;
    }

    public static final class ActivityType {
        public static final int MONEY_OFF = 1;
    }

    public static class AddEvaluationCommentFrom {
        public static final int HOME_PAGE = 3;
        public static final int ORDER_LIST_PAGE = 2;
        public static final int ORDER_PAGE = 1;
    }

    public static class AddressActionType {
        public static final int TYPE_CHOOSED = 1;
        public static final int TYPE_CREATE = 3;
        public static final int TYPE_DELETE = 2;
        public static final int TYPE_UPDATE = 4;
    }

    public static class AddressAidType {
        public static final int TYPE_HOME = 1;
        public static final int TYPE_NORMAL = 0;
        public static final int TYPE_OFFICE = 2;
    }

    public static class AddressDeliveryType {
        public static final int TYPE_DOOR = 1;
        public static final int TYPE_LEAVE = 2;
        public static final int TYPE_OUTSIDE = 3;
    }

    public static class AddressDragStatus {
        public static final int TYPE_IN = 0;
        public static final int TYPE_OUT = 1;
    }

    public static class AddressLocationSource {
        public static final String GEO = "manual_rgeo";
        public static final String SUG = "manual_sug";
    }

    public static class AddressLocationSwBtnType {
        public static final int TYPE_DOWN_DRAG = 3;
        public static final int TYPE_MOVE_MAP = 1;
        public static final int TYPE_SELECT_CK = 2;
    }

    public static final class AddressPromptScene {
        public static final int AID_NOT_SHOW = 1;
        public static final int DEFAULT = 0;
        public static final int POI = 2;
    }

    public static class AddressType {
        public static final int TYPE_CURRENT_DELIVERY = 7;
        public static final int TYPE_CURRENT_GPS = 8;
        public static final int TYPE_SEARCH = 5;
        public static final int TYPE_SEARCH_HISTORY = 6;
        public static final int TYPE_SUGGEST = 4;
        public static final int TYPE_USER_HOME = 2;
        public static final int TYPE_USER_NORMAL = 1;
        public static final int TYPE_USER_OFFICE = 3;
    }

    public static final class AdsEventConst {
        public static final String EVENT_KEY_ADD_PAYMENT = "af_didi_food_add_payment";
        public static final String EVENT_KEY_ADD_TO_CART = "af_didi_food_add_to_cart";
        public static final String EVENT_KEY_CREATE_ORDER = "af_didi_food_create_order";
        public static final String EVENT_KEY_LOG_IN = "af_didi_food_login";
        public static final String EVENT_KEY_SIGN_UP = "af_didi_food_signup";
        public static final String EVENT_KEY_VIEW_RESTAURANT = "af_didi_food_view_restaurant";
    }

    public static final class AdsOmegaEventConst {
        public static final String EVENT_KEY_ADD_PAYMENT = "sailing_c_x_ads_add_payment_sw";
        public static final String EVENT_KEY_ADD_TO_CART = "sailing_c_x_ads_add_to_cart_sw";
        public static final String EVENT_KEY_CREATE_ORDER = "sailing_c_x_ads_create_order_sw";
        public static final String EVENT_KEY_LOG_IN = "sailing_c_x_ads_login_sw";
        public static final String EVENT_KEY_SIGN_UP = "sailing_c_x_ads_signup_sw";
    }

    public static final class AlcoholConfirmStatus {
        public static final int CONFIRMED = 1;
        public static final int NOT_CONFIRMED = 0;
    }

    public static final class AnchorActionType {
        public static final int ANCHOR = 1;
        public static final int ANCHOR_AND_ADD = 2;
    }

    public static final class AnchorType {
        public static final int CATE = 2;
        public static final int ITEM = 1;
        public static final int NONE = 0;
    }

    public static final class AnimationConst {
        public static final long ANIMATION_TIME_1000_MS = 1000;
        public static final long ANIMATION_TIME_100_MS = 100;
        public static final long ANIMATION_TIME_125_MS = 125;
        public static final long ANIMATION_TIME_150_MS = 150;
        public static final long ANIMATION_TIME_200_MS = 200;
        public static final long ANIMATION_TIME_250_MS = 250;
        public static final long ANIMATION_TIME_300_MS = 300;
        public static final long ANIMATION_TIME_350_MS = 350;
        public static final long ANIMATION_TIME_400_MS = 400;
        public static final long ANIMATION_TIME_450_MS = 450;
        public static final long ANIMATION_TIME_500_MS = 500;
        public static final long ANIMATION_TIME_50_MS = 50;
        public static final long ANIMATION_TIME_550_MS = 550;
        public static final long ANIMATION_TIME_600_MS = 600;
        public static final long ANIMATION_TIME_700_MS = 700;
        public static final long ANIMATION_TIME_75_MS = 75;
        public static final long ANIMATION_TIME_800_MS = 800;
        public static final long ANIMATION_TIME_900_MS = 900;
    }

    public static final class ArrearsOrderButtonType {
        public static final int TYPE_CANCEL = 2;
        public static final int TYPE_CONTACT_SERVICE = 3;
        public static final int TYPE_DETAIL_VIEW = 1;
    }

    public interface BillAddressBubbleStyle {
        public static final int STYLE_BLACK = 1;
        public static final int STYLE_WHITE = 2;
    }

    public static final class BillAddressPromptSWReason {
        public static final int NAME_EMPTY = 4;
        public static final int NAME_NOT_LEGAL = 5;
    }

    public interface BillAddressStrategy {
        public static final int ALERT = 3;
        public static final int BLACK_BUBBLE = 2;
        public static final int NONE = 0;
        public static final int WHITE_BUBBLE = 1;
    }

    public static class BillAlertPriority {
        public static final int ALERT_AID = 200;
        public static final int ALERT_CPF = 100;
        public static final int ALERT_REC_TIPS = 300;
    }

    public static final class BillAutoClickType {
        public static final int FROM_BILL_ALERT_CK = 3;
        public static final int FROM_BILL_PAY_ADDRESS_EMPTY_CK = 2;
        public static final int FROM_BILL_PAY_NAME_EMPTY_CK = 4;
        public static final int FROM_BILL_PAY_NAME_NOT_LEGAL_CK = 5;
        public static final int FROM_BILL_RESPONSE = 1;
        public static final int FROM_ITEM_CK = 0;
    }

    public static final class BillAutoEditPageScene {
        public static final int ADDRESS_EMPTY = 1;
        public static final int NAME_EMPTY = 2;
        public static final int NAME_NOT_LEGAL = 3;
        public static final int OTHER = 0;
    }

    public static final class BillContactAPISource {
        public static final int LAST_ORDER = 1;
    }

    public static final class BillContactModifyFrom {
        public static final int USER_CENTER = 1;
    }

    public static final class BillEventToJS {
        public static final int BILL_CHANGED = 8;
        public static final int BILL_ERROR = 1;
        public static final int BILL_SHOW_ALERT = 3;
        public static final int BILL_SHOW_TOAST = 2;
        public static final int CREATE_ORDER_FAIL = 5;
        public static final int CREATE_ORDER_SUCESS = 4;
        public static final int PAY_PAIL = 7;
        public static final int PAY_SUCCESS = 6;
    }

    public interface BillPageRefreshType {
        public static final int FROM_BILL_BLACK_TIPS = 2;
        public static final int FROM_GOODS = 1;
    }

    public static class BillScene {
        public static final String GLOBAL_CART = "7";
    }

    public interface BillSceneType {
        public static final int CARD_VERIFY = 1;
        public static final int CREATE_ORDER_FAILED = 201;
        public static final int GOTO_BILL = 200;
        public static final int PAY_ERROR = 100;
        public static final int UPDATE_BILL_INFO = 202;
    }

    public static final class BindCardScene {
        public static final String DEFAULT_APP = "100";
        public static final String DEFAULT_EMBED = "101";
        public static final String ORDER_DEBT_APP = "108";
        public static final String ORDER_DEBT_EMBED = "109";
        public static final String ORDER_H5 = "105";
        public static final String ORDER_TIP_APP = "106";
        public static final String ORDER_TIP_EMBED = "107";
    }

    public static final class BlockLayer {
        public static final int TYPE_H5 = 2;
        public static final int TYPE_SHARE = 1;
    }

    public static final class BundleKey {
        public static final String BILL_MANUAL_UPDATE_TIPS_FEE = "bill_manual_update_tips_fee";
        public static final String BILL_PAYMENT_METHOD_PAYMENT_TYPE = "bill_payment_method_payment_type";
        public static final String BILL_PAY_CALLBACK = "bill_pay_callback";
        public static final String BIND_CARD_SCENE = "bind_card_scene";
        public static final String BUSINESS_ID = "business_id";
        public static final String CART_ID = "cart_id";
        public static final String CART_TYPE = "cart_type";
        public static final String CURRENT_SHOP_ID = "current_shop_id";
        public static final String DEBT_ID = "debt_id";
        public static final String DEBT_PAY_RESULT = "debt_pay_result";
        public static final String DEFAULT_NOTE = "cart_note";
        public static final String DELIVERY_METHOD_ID = "delivery_method_id";
        public static final String FROM_PAGE = "from_page";
        public static final String IS_EVALUATED_RESULT = "isEvaluatedResult";
        public static final String NO_ADDRESS_FROM_SERVICE = "no_address_from_service";
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
        public static final String SELECT_PAYMENT_METHOD = "select_payment_channel_id";
        public static final String SERVICE_CART_KEY = "service_cart_key";
        public static final String SERVICE_FLOATING_CART_KEY = "service_floating_cart_key";
        public static final String TRANSFER_TYPE = "transfer_type";
    }

    public static final class BusinessAlertType {
        public static final int ADJUSTED = 2;
        public static final int NOTICE = 1;
    }

    public static final class BusinessCardTraceParam {
        public static final int NO_REC = 2;
        public static final int WITH_REC = 1;
    }

    public static class BusinessCateType {
        public static final int TYPE_ALCOHOL = 1;
        public static final int TYPE_NORMAL = 0;
    }

    public static class BusinessDeliveryAdjusted {
        public static final int ADJUSTED = 1;
        public static final int NOT_ADJUSTED = 0;
    }

    public static class BusinessDeliveryType {
        public static final int STATUS_DELIVERY_TYPE_BUSINESS = 2;
        public static final int STATUS_DELIVERY_TYPE_DIDI = 1;
    }

    public static class BusinessExceptionShowStyle {
        public static final int SHOW_NEXT_OPEN_TIME = 2;
        public static final int SHOW_OPEN_SOON = 1;
        public static final int SHOW_OUT_OF_DELIVERY = 0;
        public static final int SHOW_STOP_DELIVERY = 3;
    }

    public static final class BusinessExperimentScene {
        public static final int NEW_HEAD_NEW_TAIL_WITH_MENU_FOLD = 3;
        public static final int NEW_HEAD_NEW_TAIL_WITH_MENU_UNFOLD = 2;
        public static final int NEW_HEAD_OLD_TAIL_WITH_MENU_UNFOLD = 1;
        public static final int OLD_HEAD_OLD_TAIL_WITH_MENU_UNFOLD = 0;
    }

    public static final class BusinessFavorType {
        public static final int FAVOR_NO = 0;
        public static final int FAVOR_NO_ENTRY = -1;
        public static final int FAVOR_YES = 1;
    }

    public static final class BusinessFromType {
        public static final int HISTORY_ORDER_LIST = 2;
        public static final int NORMAL = 0;
        public static final int ORDER = 1;
    }

    public static final class BusinessHaveOrNot {
        public static final int COMMON_HAVE = 2;
        public static final int COMMON_NOT_HAVE = 1;
    }

    public static final class BusinessMarketArea {
        public static final int EFO = 1;
        public static final int NONE = 0;
        public static final int REGGLAR = 2;
    }

    public static class BusinessMenuRefreshType {
        public static final int TYPE_NO_LOADING = 0;
        public static final int TYPE_PAGE_LOADING = 2;
        public static final int TYPE_SEARCH_LOADING = 1;
    }

    public static class BusinessModeType {
        public static final int BUSINESS_MODE_AGENT = 2;
        public static final int BUSINESS_MODE_NORMAL = 1;
    }

    public static final class BusinessOmegaEnterType {
        public static final int HISTORY_ORDER_LIST = 3;
        public static final int NORMAL = 1;
        public static final int ORDER = 4;
        public static final int OUT_LINK = 2;
    }

    public static class BusinessOutRangeShowType {
        public static final int FROM_ONE_MORE_ORDER = 2;
        public static final int FROM_OUT_LINK = 1;
    }

    public static final class BusinessOutsideButtonType {
        public static final int CANCEL = 3;
        public static final int CHANGE_ADDR = 1;
        public static final int VIEW_MORE = 2;
    }

    public static final class BusinessOutsideCloseButtonType {
        public static final int CANCEL = 2;
        public static final int VIEW_MORE = 1;
    }

    public static class BusinessScrollState {
        public static final int SCROLL_DOWN = 2;
        public static final int SCROLL_LEFT = 3;
        public static final int SCROLL_RIGHT = 4;
        public static final int SCROLL_UP = 1;
    }

    public static final class BusinessSlideScence {
        public static final int SCENCE_TAB = 1;
        public static final int SCENCE_TOPIC = 2;
    }

    public static class BusinessStatus {
        public static final int STATUS_OPEN = 1;
        public static final int STATUS_OUT_DELL_RANGE = 3;
        public static final int STATUS_REST = 2;
        public static final int STATUS_STOP_BIZ = 5;
        public static final int STATUS_STOP_DELIVERY = 4;
    }

    public static class BusinessTabShowType {
        public static final int FROM_HOME = 1;
        public static final int FROM_TAB_MENU = 2;
    }

    public static class BusinessType {
        public static final int FOOD = 1;
        public static final int GROCERY = 3;
    }

    public static class BusinessWineConfirmStatus {
        public static final int CONFIRMED = 1;
        public static final int NOT_CONFIRMED = 0;
    }

    public static class CEtaABTest {
        public static final int LATEST = 2;
        public static final int LEGACY = 1;
    }

    public static final class CampaignKey {
        public static final String KEY_AD_GROUP = "adgroup";
        public static final String KEY_AD_GROUP_ID = "adgroup_id";
        public static final String KEY_AD_SET_ID = "af_adset_id";
        public static final String KEY_CAMPAIGN = "campaign";
        public static final String KEY_CAMPAIGN_URL = "rlinkurl";
        public static final String KEY_CLICK_TIME = "click_time";
        public static final String KEY_MEDIA_SOURCE = "media_source";
    }

    public static final class CardBgType {
        public static final int BOTTOM = 2;
        public static final int MIDDLE = 3;
        public static final int SINGLE = 0;
        public static final int TOP = 1;
    }

    public static final class CartRedirectType {
        public static final int TYPE_CAN_REDIRECT = 1;
        public static final int TYPE_NOT_REDIRECT = 0;
    }

    public static class CaseOrderPayStatus {
        public static final int PAY_STATUS_NORMAL = 0;
        public static final int PAY_STATUS_UNFINISH = 1;
    }

    public static class CloseType {
        public static final int CLOSE_BUTTON = 0;
        public static final int SYSTEM_BACK = 1;
    }

    public static class CommonConst {
    }

    public static final class CommonHaveOrNot {
        public static final int COMMON_HAVE = 1;
        public static final int COMMON_NOT_HAVE = 2;
    }

    public static class ComponentType {
        public static final String BANNER = "banner";
        public static final String SEARCH_WORDS = "searchWords";
        public static final String SHOP_LARGE = "shopLarge";
        public static final String SHOP_SLIDE = "shopSlide";
        public static final String SHOP_SMALL = "shopSmall";
        public static final String SHOP_WITH_ITEMS = "shopWithItems";
        public static final String SHOW_ALL = "showAll";
        public static final String TITLE = "title";
    }

    public static class ConfirmOrderStatus {
        public static final int CONFIRM_ORDER_HIDE = 0;
        public static final int CONFIRM_ORDER_SHOW = 1;
    }

    public static final class CouponExpireInfoStyleType {
        public static final int EXPIRE_IN_2_DAYS = 2;
        public static final int EXPIRE_IN_3_DAYS = 3;
        public static final int EXPIRE_NORMAL = 4;
        public static final int EXPIRE_TODAY = 1;
    }

    public static final class CouponType {
        public static final int TYPE_ALL = 103;
        public static final int TYPE_DEDUCTION = 3;
        public static final int TYPE_DISCOUNT = 100;
    }

    public static final class CustomerAccountOpType {
        public static final int OP_ADD = 1;
        public static final int OP_SUB = 0;
    }

    public static class DebtOrderIsComplete {
        public static final int COMPLETED = 1;
        public static final int NO_COMPLETE = 0;
    }

    public static class DeliveryStatusBeforeTakeFood {
        public static final int ARRIVED_SHOP = 4;
        public static final int ASSIGNED_AND_GO = 3;
        public static final int ASSIGNED_BUT_NOT_GO = 2;
        public static final int DEFAULT = 0;
        public static final int REASSIGNMENT = 5;
        public static final int UNASSIGNED = 1;
    }

    public static final class EFO {
        public static final int EFO_ITEM_COPY_NUM = 1;
    }

    public static final class EditAddressCommitType {
        public static final int CREATE = 1;
        public static final int UPDATE = 2;
    }

    public interface EditAddressConfirmPopType {
        public static final int TYPE_BOTH_HOUSE_APARTMENT = 3;
        public static final int TYPE_ONLY_HOUSE_NUMBER = 2;
        public static final int TYPE_OTHER = 1;
    }

    public static final class EmailStatus {
        public static final int NOT_VERIFY = 0;
        public static final int VERIFIED = 1;
    }

    public static final class EnterAddressEditPageType {
        public static final int ENTER_PAGE_ADDRESS_LIST = 0;
        public static final int ENTER_PAGE_ADDRESS_SEARCH = 3;
        public static final int ENTER_PAGE_BILL_ALERT_CK = 8;
        public static final int ENTER_PAGE_BILL_PAY_CK = 7;
        public static final int ENTER_PAGE_BILL_SW = 6;
        public static final int ENTER_PAGE_CART = 1;
        public static final int ENTER_PAGE_CART_LIST = 2;
        public static final int ENTER_PAGE_ORDER_ADDRESS_LIST_ADD = 4;
        public static final int ENTER_PAGE_ORDER_ADDRESS_LIST_EDIT = 5;
    }

    public static final class EnterAddressMainPageType {
        public static final int FROM_ADDRESS_TIP = 3;
        public static final int FROM_GPS_DIALOG = 6;
        public static final int FROM_PAGE_BUSINESS = 8;
        public static final int FROM_PAGE_CART = 4;
        public static final int FROM_PAGE_HOME_AUTO = 5;
        public static final int FROM_PAGE_HOME_NO_SERVICE = 7;
        public static final int FROM_PAGE_MAIN = 2;
        public static final int FROM_PAGE_ORDER_LIST = 9;
        public static final int FROM_PAGE_SA_LANDING = 10;
    }

    public static final class EnterCartPageType {
        public static final String FROM_PAGE_BILL = "3";
        public static final String FROM_PAGE_GLOBAL = "2";
        public static final String FROM_PAGE_MINI = "1";
    }

    public static final class EnterGoodsPurchaseType {
        public static final int ENTER_PAGE_BILL_ITEM = 4;
        public static final int ENTER_PAGE_BILL_TYING = 9;
        public static final int ENTER_PAGE_BUSINESS = 1;
        public static final int ENTER_PAGE_BUSINESS_IMAGE_PREVIEW = 5;
        public static final int ENTER_PAGE_BUSINESS_SEARCH = 2;
        public static final int ENTER_PAGE_BUSINESS_SEARCH_IMAGE_PREVIEW = 6;
        public static final int ENTER_PAGE_CART = 3;
        public static final int ENTER_PAGE_EFO_ACTIVITY = 8;
        public static final int ENTER_PAGE_HOME_EFO = 7;
    }

    public static final class EnterOrderPageType {
        public static final int ENTER_PAGE_BILL = 2;
        public static final int ENTER_PAGE_HOME = 1;
        public static final int ENTER_PAY = 2;
        public static final int ENTER_SIDE = 3;
    }

    public static final class EnterSplashType {
        public static final int ENTER_FROM_PUSH = 2;
        public static final int ENTER_SHOW_SPLASH = 1;
    }

    public static final class EvaluateButtonType {
        public static final int CANCEL = 2;
        public static final int EVALUATE = 1;
    }

    public static class EvaluationEntryStatus {
        public static final int ENTRY_ADD_EVALUATION = 1;
        public static final int ENTRY_VIEW_EVALUATION = 2;
        public static final int NO_ENTRY = 0;
    }

    public static final class FavorPage {
        public static final int COMPONENT_FAVOR = 3333;
        public static final String PAGE_FAVOR = "favoritepage";
    }

    public static final class FileUploadTimeout {
        public static final long WRITE_TIMEOUT = 30000;
    }

    public static class FilterMType {
        public static final int GLCFilterGroupTypeActivity = 4;
        public static final int GLCFilterGroupTypeAveragePrice = 3;
        public static final int GLCFilterGroupTypeOther = 5;
        public static final int GLCFilterGroupTypeSort = 1;
    }

    public static final class FilterPageParam {
        public static final String KEY_FROM_SCENE = "from_scene";
        public static final String KEY_MODEL_ID = "model_id";
        public static final String KEY_TOPIC_FROM_SCENE = "topic_from_scence";
        public static final String PARAM_TIME_PERIOD = "time_period";
    }

    public static class FilterShowType {
        public static final int TYPE_ALL = 4;
        public static final int TYPE_CATEGORY = 2;
        public static final int TYPE_MUL = 3;
        public static final int TYPE_PANEL = 7;
        public static final int TYPE_RESET = 6;
        public static final int TYPE_SORT = 1;
        public static final int TYPE_SUB_OUTSIDE = 5;
    }

    public static final class FloatingDialogCKType {
        public static final int BACK_BTN = 1;
        public static final int DISMISS_EVENT = 2;
        public static final int MAIN_BTN = 3;
        public static final int SUB1_BTN = 4;
        public static final int SUB2_BTN = 5;
    }

    public static final class FlutterBundleKey {
        public static final String AFTER_FAV_PRICE = "afterFavPrice";
        public static final String CURRENCY = "currency";
        public static final String DEBT_ID = "debtId";
        public static final String FROM_TYPE = "fromType";
        public static final String IS_FROM_ORDER = "mIsFromOrder";
        public static final String IS_FROM_ORDER_FLUTTER = "isFromOrderFlutter";
        public static final String ORDER_ADDRESS_LIST_TOAST = "modifyAddressSuccessToast";
        public static final String ORDER_ID = "orderId";
        public static final String PAGE_RESULT_DATA = "data";
        public static final String PAY_CHANNEL = "payChannel";
        public static final String PAY_METHOD_PRICE_DISPLAY = "unpaidMoneyDisplay";
        public static final String SCENE_TYPE = "sceneType";
        public static final String SELECTED_NUMBER = "selectedNumber";
        public static final String UNPAID_MONEY = "unpaidMoney";
    }

    public static final class FreeExplainType {
        public static final int TYPE_DELIVERY = 2;
        public static final int TYPE_MONEY_OFF = 1;
        public static final int TYPE_SERVICE = 4;
        public static final int TYPE_SMALL_ORDER = 3;
        public static final int TYPE_TIP = 5;
    }

    public static final class FromChannel {
        public static final int CUSTOMER = 0;
        public static final int SUPER_APP = 1;
    }

    public static final class GoodComboType {
        public static final int MEAL_SET = 2;
        public static final int MEAL_SINGLE = 1;
    }

    public static final class GoodHasPicture {

        /* renamed from: NO */
        public static final int f40341NO = 0;
        public static final int YES = 1;
    }

    public static final class GoodIsMulti {
        public static final int IS_MULTI = 1;
        public static final int IS_SINGLE = 0;
    }

    public static class GoodsActivityType {
        public static final int BUY_GIFT = 4;
        public static final int EFO = 100;
        public static final int REGULAR_CUSTOMER = 101;
        public static final int SPECIAL_PRICE = 2;
    }

    public static class GoodsContentBuyMode {
        public static final int CAN_BUY_MORE = 1;
        public static final int CAN_NOT_BUY_MORE = 0;
    }

    public static class GoodsContentMustStatus {
        public static final int IS_MUST = 1;
        public static final int NOT_MUST = 2;
    }

    public static final class GoodsItemType {
        public static final int HAS_WINE = 1;
        public static final int NO_WINE = 0;
    }

    public static class GoodsSoldStatus {
        public static final int LIMIT_SALE = 3;
        public static final int SELLING = 1;
        public static final int SOLD_OUT = 2;
    }

    public static class GoodsStatus {
        public static final int SELLING = 1;
        public static final int UNDERCARRIAGE = 2;
    }

    public static class GoodsSubItemLoadType {
        public static final int NEED_LOADING = 1;
        public static final int NO_LOADING = 0;
    }

    public static class GoodsSubItemStatus {
        public static final int SELLING = 1;
        public static final int UNDERCARRIAGE = 2;
    }

    public static final class H5FromType {
        public static final String TYPE_CART = "block";
        public static final String TYPE_ORDER = "order";
    }

    public static final class H5Params {
        public static final String ADDRESS = "address";
        public static final String ADDRESSALL = "addressAll";
        public static final String ADDRESSALLDISPLAY = "addressAllDisplay";
        public static final String CITY = "city";
        public static final String CITYID = "cityId";
        public static final String CLOSESIDEMENU = "closeSideMenu";
        public static final String COMMON_TYPE = "type";
        public static final String COORDINATETYPE = "coordinateType";
        public static final String COUNTRYCODE = "countryCode";
        public static final String COUNTRYID = "countryId";
        public static final String COUPON_ID = "coupon_id";
        public static final String DISCOUNT_DETAIL = "discountDetail";
        public static final String DISPLYNAME = "displayName";
        public static final String DISTSTR = "distStr";
        public static final String FROM_XIAOXIHAO = "xiaoxihao";
        public static final String LAT = "lat";
        public static final String LNG = "lng";
        public static final String MESSAGE_FROM = "from";
        public static final String ORDER_CITY_ID = "orderCityId";
        public static final String ORDER_ID = "orderId";
        public static final String POIID = "poiId";
        public static final String POISRCTAG = "poiSrcTag";
        public static final String PRICE = "price";
        public static final String SEARCHID = "searchId";
        public static final String SELECTED = "selected";
        public static final String SHOPID = "shopId";
        public static final String SOURCETYPE = "sourceType";
        public static final String SOURCE_TYPE_MAX_CART = "1";
        public static final String SOURCE_TYPE_MY_COUPON_LIST = "2";
        public static final String SRCTAG = "srcTag";
        public static final String STATUS = "status";
        public static final String STATUS_DESC = "statusDesc";
        public static final String STATUS_SUB_DESC = "statusSubDesc";
        public static final String TOAST_TXT = "txt";
        public static final String TOAST_TYPE = "type";
        public static final String TOAST_TYPE_ERROR = "error";
        public static final String TOAST_TYPE_SUCCESS = "success";
    }

    public static final class HomeArrearsOrderStatus {
        public static final int NO_ARREARS = 0;
    }

    public static final class HomeBusinessPageSource {
        public static final String HOME_PAGE = "homepage";
        public static final String SHOP_SPECIAL_PAGE = "specialpage";
    }

    public static final class HomeEFO {
        public static final int EFO_ITEM_SW_FROM_HOME = 1;
        public static final int EFO_WINE = 1;
        public static final int ENTER_ACTIVITY_PAGE_FROM_MORE = 2;
        public static final int ENTER_ACTIVITY_PAGE_FROM_TITLE = 1;
        public static final int ENTER_BILL_PAGE_NOT_WINE = 0;
        public static final int PARAM_EFO_ITEM_MUTI_CONTENT_MUTI = 1;
        public static final int PARAM_EFO_ITEM_MUTI_CONTENT_SINGLE = 0;
    }

    public static final class HomeErrorCode {
        public static final int HOME_CITY_UNAVAILABLE = 40101;
        public static final int HOME_CITY_WARM_UP = 40109;
        public static final int HOME_COUNTRY_UNAVAILABL = 40114;
        public static final int HOME_DANGEROUS_AREA = 40110;
        public static final int HOME_NON_ACTIVATED_AREA = 40112;
        public static final int HOME_NO_MERCHANT = 40111;
    }

    public static class HomeRefreshType {
        public static final int TYPE_BACKGROUND = 4;
        public static final int TYPE_GPS = 6;
        public static final int TYPE_INIT = 1;
        public static final int TYPE_LAT_LNG = 7;
        public static final int TYPE_LOGIN = 2;
        public static final int TYPE_LOGOUT = 3;
        public static final int TYPE_REFRESH = 5;
    }

    public static final class HomeSceneType {
        public static final int EFO = 2;
        public static final int ITEM_TOPIC = 1;
    }

    public static final class HomeTags {
        public static String BACK_VIEW_TAG = "CustomerMainPageB_BACK_TAG";
    }

    public static final class HomeV3TraceModelId {
        public static final String BANNER = "6666";
        public static final String HOME_PAGE = "8888";
        public static final String SHOP_SPECIAL_PAGE = "7777";
    }

    public static final class ImageUpload {
        public static final String STR_PREFIX = "base64,";
    }

    public static final class InstantSP {
        public static final String INSTALL_DATA = "installdata";
        public static final String INSTALL_DATE = "installDate";
        public static final String INSTALL_TIME_STAMP = "installTimestamp";
        public static final String INSTANT_SP_NAME = "instant_app";
        public static final String URL_STRING = "urlString";
    }

    public static class ItemMerge {
        public static final String DEFAULT = "0";
        public static final String TYING_ITEM = "1";
    }

    public static final class KingKongItemType {
        public static final int ALL = 3;
    }

    public static final class KingKongSelected {
        public static final int SELECTED = 1;
        public static final int UN_SELECTED = 0;
    }

    public static final class LandingPageFrom {
        public static final String FROM_HOME_KINGKONG = "2";
        public static final String FROM_HOME_TOPIC = "1";
    }

    public static final class LaunchType {
        public static final String APP_LINK = "5";
        public static final String DEFFER_LINK = "4";
        public static final String ICON = "3";
        public static final String LINK = "2";
        public static final String PUSH = "1";
    }

    public static final class MainFragmentArgKey {
        public static final String KEY_ACTION_TYPE = "action_type";
        public static final String KEY_FROM_TAB = "from_tab";
    }

    public static class MenuWordType {
        public static final int FROM_MANUAL = 0;
        public static final int FROM_RECOMMEND = 1;
    }

    public static final class MiniCartShowStyle {
        public static final int STYLE_A = 2;
        public static final int STYLE_B = 3;
        public static final int STYLE_DEFAULT = 1;
    }

    public static class ModuleType {
        public static final String FOLDED = "foldedModule";
        public static final String FULL_AMOUNT = "fullAmountModule";
        public static final String PAGINATED = "paginatedModule";
    }

    public static final class NetworkStatus {
        public static final int CONNECTED = -10000;
        public static final int NOT_CONNECTED = -10001;
    }

    public static final class NumberRestriction {
        public static final int MAX_GOODS_ADD_NUM = 99;
    }

    public static final class OmegaParamsConst {
        public static final String PARAMS_KEY_AMOUNT = "amount";
        public static final String PARAMS_KEY_MESSAGE = "message";
        public static final String PARAMS_KEY_PRICE = "price";
        public static final String PARAMS_KEY_STATUS = "status";
    }

    public static class OrderAddErrorCode {
        public static final int ERROR_CODE_45303 = 45303;
        public static final int ERROR_CODE_45307 = 45307;
    }

    public static final class OrderAutoPay {
        public static final int PAY_FAIL = 0;
        public static final int PAY_SUCCESS = 1;
    }

    public static class OrderBannerType {
        public static final int IMAGE_TYPE = 0;
        public static final int SHARE_TYPE = 1;
    }

    public static class OrderBusinessMode {
        public static final int NON_AFFILIATE = 220;
        public static final int NORMAL = 1;
    }

    public static class OrderContactRole {
        public static final int ROLE_RIDER = 2;
        public static final int ROLE_SHOP = 1;
    }

    public static class OrderContactType {
        public static final int CONTACT_CALL = 22;
        public static final int CONTACT_IM = 11;
    }

    public static final class OrderCreateFailedReason {
        public static final int ADDRESS_EMPTY = 2;
        public static final int ENSURE_DIALOG = 3;
        public static final int NAME_EMPTY = 4;
        public static final int PAY_METHOD_EMPTY = 1;
    }

    public static final class OrderDetailFrom {
        public static final int ORDER_DETAIL = 2;
        public static final int ORDER_PAYING = 1;
    }

    public static class OrderEvaluationType {
        public static final int EVALUATION_SCORE_BAD = 2;
        public static final int EVALUATION_SCORE_FIVE_STAR = 500;
        public static final int EVALUATION_SCORE_FOUR_STAR = 400;
        public static final int EVALUATION_SCORE_GOOD = 10;
        public static final int EVALUATION_SCORE_ONE_STAR = 100;
        public static final int EVALUATION_SCORE_THREE_STAR = 300;
        public static final int EVALUATION_SCORE_TWO_STAR = 200;
        public static final int NO_EVALUATION = 0;
    }

    public static final class OrderListButtonsType {
        public static final int BUY_AGAIN = 2;
        public static final int DEBT_UN_PAY = 5;
        public static final int HAS_EVALUATED = 4;
        public static final int NO_EVALUATE = 3;
        public static final int UN_PAY = 1;
    }

    public static class OrderPayButtonStatus {
        public static final int ORDER_PAY_BUTTON_HIDE = 0;
        public static final int ORDER_PAY_BUTTON_SHOW = 1;
    }

    public static class OrderPayStatus {
        public static final int ORDER_FOR_PAY = 0;
        public static final int ORDER_PAYED = 1;
        public static final int ORDER_REFUND = 2;
    }

    public static class OrderPayType {
        public static final int PAYED_99_PAY = 4;
        public static final int PAYED_BY_CRASH = 2;
        public static final int PAYED_ONLINE = 1;
        public static final int PAYED_PAY_PAY = 5;
        public static final int PAYED_POS = 3;
        public static final int SYSTEM = 0;
    }

    public static class OrderPayWay {
        public static final int FOR_CLIENT_PAY_PAY = 1;
        public static final int FOR_SERVICE_PAY = 0;
    }

    public static class OrderRefreshType {
        public static final int TYPE_ORDER_CREATE = 1;
    }

    public static class OrderStatus {
        public static final int B_CONFIRMED = 200;
        public static final int B_FOR_CONFIRM = 100;
        public static final int B_FOR_CONFIRM_AFTER_D = 140;
        public static final int B_READY = 300;
        public static final int C_CANCEL_BY_CUSTOMER = 901;
        public static final int C_FOR_PAY = 0;
        public static final int C_GOT = 600;
        public static final int DEFAULT = -200;
        public static final int D_FOR_CONFIRM = 120;
        public static final int R_ARRIVED_C = 500;
        public static final int R_TAKEN = 400;
    }

    public static class OrderTipMsgStyle {
        public static final int MSG_STYLE_DEFAULT = 0;
        public static final int MSG_STYLE_THEME = 1;
    }

    public static final class Page {
        public static final String HOME = "homepage";
    }

    public static class PageParams {
        public static final String ABNORMAL_ITEMS_INFO = "abnormal_items_info";
        public static final String ACTION_INFO = "actioninfo";
        public static final String ACTION_INFO_DICT = "actionInfoDict";
        public static final String ACTION_INFO_DICT2 = "actioninfodict";
        public static final String ACTIVITY_ID = "activityid";
        public static final String ACT_INFO = "actinfo";
        public static final String ADDRESS_ENTITY = "address_entity";
        public static final String ADDRESS_KEYBOARD_ENTITY = "address_keyboard_entity";
        public static final String ADDRESS_STRATEGY = "address_strategy";
        public static final String ALL_CATEGORY_PAGE_OPEN_SOURCE = "allCategoryPageOpenSource";
        public static final String ALL_CATEGORY_TITLE = "title";
        public static final String ANCHOR_INFO = "anchorInfoDict";
        public static final String ANCHOR_INFO2 = "anchorinfodict";
        public static final String BACK_BUTTON_SHOW = "backbuttonshow";
        public static final String BIDATA = "bi_data";
        public static final String BILL_ADDRESS_EDIT_SCENE = "bill_address_page_scene";
        public static final String BUNDLE = "bundle";
        public static final String BUSINESS_ANIMATION_SOURCE = "businessanimationsource";
        public static final String BUSINESS_GOODS_PURCHASED = "businessgoodspurchased";
        public static final String BUSINESS_TYPE = "businesstype";
        public static final String CART_ID = "cartid";
        public static final String CART_INFO_CONFIRM_ENTITY = "cart_info_confirm_entity";
        public static final String CART_ITEM_ENTITY = "cartitementity";
        public static final String CART_REVISION = "cartrevision";
        public static final String CHECK_STATUS = "check_status";
        public static final String COMPONENT_ID = "componentid";
        public static final String CONTACT_ENTITY = "contact_entity";
        public static final String CONTACT_ROLE = "contactrole";
        public static final String CONTACT_TYPE = "contacttype";
        public static final String DIDI_PASS = "didi_pass";
        public static final String ENTITY = "entity";
        public static final String EVALUATE_RESULT = "evaluateresult";
        public static final String FLOATING_DIALOG_CK_TYPE = "floating_dialog_btn_type";
        public static final String FROM = "from";
        public static final String FROM_PAGE = "fromPage";
        public static final String FROM_TYPE = "fromType";
        public static final String GOODS_PRICE_CALCULATOR = "goodspricecalculator";
        public static final String HOMEPAGE_SOURCE = "homepage_source";
        public static final String HOME_COMPONENT_ID = "homeComponentId";
        public static final String HOME_COMPONENT_TITLE = "homeComponentTitle";
        public static final String IS_BUSINESS_FAVORED = "isbusinessfavored";
        public static final String IS_FROM_BUSINESS = "is_from_business";
        public static final String IS_ITEM_MERGE = "is_item_merge";
        public static final String IS_SHOW_BILL_ADDRESS_DATA = "is_show_bill_address_data";
        public static final String IS_SYNERGY_SHOP = "issynergyshop";
        public static final String ITEM_ENTITY = "itementity";
        public static final String ITEM_ID = "itemid";
        public static final String ITEM_NEED_SHOW_ALCOHOL_REMIND = "itemneedalcoholremind";
        public static final String ITEM_NOTNEEDCAL = "item_notneedclientcal";
        public static final String ITEM_UNIQ_KEY = "itemUniqKey";
        public static final String KEY_BILL_TIP_FEE_CURRENCY = "key_bill_tip_fee_currency";
        public static final String KEY_BILL_TIP_FEE_MODEL = "key_bill_tip_fee_model";
        public static final String KEY_BILL_TIP_FEE_SELECTED_FEE = "key_bill_tip_fee_selected_fee";
        public static final String KEY_CATE_ID = "cateid";
        public static final String KEY_REC_ID = "recid";
        public static final String LATITUDE = "latitude";
        public static final String LOCAL_PREVIEW_IMAGE = "localPreviewImage";
        public static final String LONGITUDE = "longitude";
        public static final String MODULE_ID = "moduleid";
        public static final String MODULE_REC_ID = "modulerecid";
        public static final String MODULE_TITLE = "moduletitle";
        public static final String MULTI_SELECTED_SUB_ITEM_STATE_BACK = "multiselectedsubitemstateback";
        public static final String MULTI_SUB_ITEM_STATE_BACK = "multisubitemstateback";
        public static final String NAME_COMPLETE_STRATEGY = "name_complete_strategy";
        public static final String NAME_NOT_LEGAL = "address_name_not_legal";
        public static final String NODE_LIST = "node_list";
        public static final String ORDER_DEBT_PAY_FAILURE_REASON = "failure_reason";
        public static final String ORDER_ID = "orderid";
        public static final String ORDER_PAYING = "orderpaying";
        public static final String ORDER_RECEIPT_STATE = "order_receipt_state";
        public static final String PAGE_DATA = "pageData";
        public static final String PAGE_NAME = "PageName";
        public static final String PAY_LOAD = "payload";
        public static final String POLICY_DETAIL_PAGE = "policydetailpage";
        public static final String PREVIEW_IMAGE = "previewImageModel";
        public static final String PREVIEW_IMAGE_URL = "previewImageUrl";
        public static final String PREVIEW_IMAGE_WIDTH = "previewImageWidth";
        public static final String RECEIPT_ENTITIES = "receiptEntities";
        public static final String RECEIPT_PAGE_TYPE = "receiptPageType";
        public static final String REC_ADDRESS_ENTITY = "rec_address_entity";
        public static final String REC_ID = "recid";
        public static final String REMOVE_FONT_PAGE = "remove_font_page";
        public static final String SCENE = "scene";
        public static final String SCHEME_ASSIST_PATH = "schemeAssistPath";
        public static final String SCHEME_ROUTER_TAG = "schemeRouterTag";
        public static final String SEARCH_HOME_MODEL = "search_home_model";
        public static final String SEARCH_URL = "search_url";
        public static final String SEARCH_WORD = "search_word";
        public static final String SECURITY_LIST = "securitylist";
        public static final String SELECTED_SUB_ITEM_STATE_COPY = "selected_sub_item_state_copy";
        public static final String SELECT_ITEM_STATE_UNIQUE_ID = "stateuniqueid";
        public static final String SHOP_ADDRESS = "shopaddress";
        public static final String SHOP_ADDRESS_LAT_LNG = "shopaddresslatlng";
        public static final String SHOP_CATEGORY_LIST = "categorylist";
        public static final String SHOP_ID = "shopid";
        public static final String SHOP_INFO_ENTITY = "shopinfoentity";
        public static final String SHOP_ITEM_SEARCH_INFO = "searchInfo";
        public static final String SHOP_NAME = "shopname";
        public static final String SHOP_OMEGA_MODEL = "shopomegamodel";
        public static final String SHOP_STATUS = "shopstatus";
        public static final String SOURCE = "source";
        public static final String SUBITEM_ENTITY = "subitementity";
        public static final String SUBITEM_NOTNEEDCAL = "notneedcal";
        public static final String SUB_BACK_FROM_PHONE = "subscribe_back_from_phone";
        public static final String SUB_FROM_SKU_CHECK_OUT = "subscribe_from_sku_check_out";
        public static final String SUB_ITEMS = "subitems";
        public static final String SUB_ITEM_STATE_COPY = "subitemstatecopy";
        public static final String TAG_ID = "tagid";
        public static final String TOPIC_SCENE = "scene";
        public static final String TOPIC_TITLE = "topictitle";
        public static final String TRANSITION_NAMES = "transitionname";
        public static final String WEBPAGE_BUNDLE = "webpagebundle";
        public static final String WEBPAGE_FROM_TAB = "fromTab";
        public static final String WEBPAGE_TYPE = "nativeWebUIType";
        public static final String WINE_CONFIRM = "wineConfirm";
    }

    public static final class Pay99Status {
        public static final int AVAILABLE = 1;
        public static final int DEFAULT = 0;
        public static final int NOT_ENABLE = 3;
        public static final int NOT_ENOUGH = 2;
    }

    public static final class PayAddressState {
        public static final int STATE_ADDRESS_CHANGED_NOT_SHOW_DIALOG = 2;
        public static final int STATE_ADDRESS_CHANGED_SHOW_DIALOG = 3;
        public static final int STATE_ADDRESS_TIP_SHOW_DIALOG = 4;
        public static final int STATE_UNADDRESS_CHANGED_NOT_SHOW_DIALOG = 0;
        public static final int STATE_UNADDRESS_CHANGED_SHOW_DIALOG = 1;
    }

    public static final class PayCode {
        public static final int ORDERPAY_CODE_ERR = 3;
        public static final int ORDERPAY_CODE_SUCCESS = 1;
        public static final int ORDERPAY_CODE_USERCANCEL = 2;
    }

    public static final class PayFailTipFrom {
        public static final int BILL_PAGE = 1;
        public static final int ORDER_PAGE = 2;
    }

    public static final class PayParams {
        public static final String BIZ_CONTENT = "bizContent";
        public static final String BIZ_CONTENT_UNDERLINE = "biz_content";
        public static final String CODE = "code";
        public static final String MESSAGE = "message";
        public static final String OUT_TRADE_ID = "outTradeId";
        public static final String OUT_TRADE_ID_UNDERLINE = "out_trade_id";
        public static final String PAY_ACTIVITY_ACTION = "com.didi.global.soda.unifiedPay.entrance";
        public static final String SIGN_TYPE = "signType";
        public static final String SIGN_TYPE_UNDERLINE = "sign_type";
        public static final String UNI_PAY_PARAM = "uni_pay_param";
    }

    public static final class PayScene {
        public static final int DEBT_ORDER = 1;
        public static final int DEFAULT = 0;
        public static final int TIP = 2;
    }

    public static final class PopDialogDynamic {
        public static final int DYNAMIC = 2;
        public static final int UN_DYNAMIC = 1;
    }

    public static final class ProfileFromType {
        public static final String TYPE_SETTING = "settings";
        public static final String TYPE_SIDEBAR = "picture";
    }

    public static final class PubBizLine {
        public static final String FIN = "fin";
    }

    public static final class PushParams {
        public static final int DISPATCHER_RIDER_ID_TOPIC = 2049;
        public static final int RIDER_LOC_GET_BY_ID_TYPE = 10;
        public static final int ROLE_PASSENGER = 1;
        public static final int SLIDING_RIDER_PUSH_TOPIC = 259;
    }

    public static final class PushServiceTag {
        public static final String OUTSIDE_TAG = "OutsideScheme";
    }

    public static final class ReceiptPageType {
        public static final int TYPE_SAVE = 0;
        public static final int TYPE_SEND = 1;
    }

    public static final class Redeem {
        public static final int REDEEM_FAIL = 2;
        public static final int REDEEM_SUCCESS = 1;
    }

    public static final class RedeemResultBtnType {
        public static final int REDEEM_RESULT_BTN_TYPE_BACK = 2;
        public static final int REDEEM_RESULT_BTN_TYPE_OK = 1;
    }

    public static class ReminderOrderStatus {
        public static final int REMINDER_HIDE = 0;
        public static final int REMINDER_SHOW = 1;
    }

    public static final class RpcConst {
        public static final String DATA = "data";
        public static final String ERRMSG = "errmsg";
        public static final String ERRNO = "errno";
        public static final String TIME = "time";
        public static final String TRACEID = "traceId";
        public static final String URL = "url";
    }

    public static final class RulePage {
        public static final String RULE_CLOSE_BTN_TYPE = "button_type";
        public static final int RULE_CLOSE_BTN_TYPE_ENUM_CONFIRM = 0;
        public static final int RULE_CLOSE_BTN_TYPE_ENUM_OTHER = 1;
        public static final int RULE_PAGE_FROM_DETAIL_COUPON_REDUCE = 1;
        public static final int RULE_PAGE_FROM_REFUND = 2;
    }

    public static final class SABusiness {
        public static final String KEY_ADDRESS_INFO = "addressInfo";
        public static final String KEY_DIRECT_OPEN = "soda_direct_open";
        public static final String VALUE_DIRECT_OPEN = "1";
    }

    public static final class SceneType {
        public static final int NORMAL = 0;
        public static final int ONE_MORE = 1;
    }

    public static final class SearchFrom {
        public static final int FROM_CATEGORY = 2;
        public static final int FROM_HOME = 1;
    }

    public static class SearchHotWordsType {
        public static final int TYPE_MARKETING = 2;
        public static final int TYPE_NORMAL = 1;
    }

    public static class SearchModuleId {
        public static final String MODULE_OUTRANGE = "outRange";
        public static final String MODULE_RECOMMEND = "recommend";
        public static final String MODULE_SEARCH = "search";
    }

    public static class SecondTipStatus {
        public static final int HIDE_ENTER = 0;
        public static final int SHOW_ENTER = 1;
    }

    public static final class SendStatus {
        public static final int NOT_SEND = 0;
        public static final int SENT = 1;
    }

    public static class ShopPrepareStatus {
        public static final int DEFAULT = 0;
        public static final int IN_PREPARATION = 1;
        public static final int PREPARE_READY = 2;
    }

    public static class ShowConfirmType {
        public static final int MULTIPLECHOICE = 1;
        public static final int SINGLECHOICE = 0;
    }

    public static class SkuType {
        public static final int GIFT = 2;
        public static final int NORMAL = 1;
    }

    public static class SubmitBillSource {
        public static final int DEFAULT = 0;
        public static final int FAST = 1;
    }

    public static class ThirdPayResultCode {
        public static final int NEED_INSTALL_CLIENT = 1;
        public static final int PAY_INNER_ERROR = 4;
        public static final int PAY_OUTER_ERROR = 3;
        public static final int PAY_SUCCESS = 2;
    }

    public static final class ToSplashActivity {
        public static final String FROM_PUSH = "from_push";
    }

    public static final class TopicActivity {
        public static final String KEY_COUNT_DOWN_CALLBACK = "key_count_down_callback";
        public static final int REQUEST_TYPE_COUNTDOWN_REFRESH = 2;
        public static final int REQUEST_TYPE_FIRST_LOAD = 1;
        public static final int REQUEST_TYPE_PULL2REFRESH = 3;
        public static final int REQUEST_TYPE_TAB_SWITCH = 4;
        public static final int REQUEST_TYPE_UNDEFINED = 0;
        public static final int VALUE_FROM_LANDING_PAGE = 2;
        public static final String VALUE_LANDING_PAGE_ID = "showAll";
        public static final int VALUE_PAGE_TYPE_ACTIVITY_END = 2;
        public static final int VALUE_PAGE_TYPE_API_ERROR = 3;
        public static final int VALUE_PAGE_TYPE_NORMAL = 0;
        public static final int VALUE_PAGE_TYPE_NOT_NEW = 1;
        public static final int VALUE_TYPE_ALERT = 1;
        public static final int VALUE_TYPE_ALERT_ACTION_BACK = 2;
        public static final int VALUE_TYPE_ALERT_ACTION_STAY = 1;
    }

    public static final class TopicClickActionType {
        public static final int TO_BUSINESS = 2;
        public static final int TO_FASTBUY = 1;
        public static final int TO_LANDING_PAGE = 3;
    }

    public static final class TopicClickDirection {
        public static final int NOT_TO_LIST_PAGE = 0;
        public static final int TO_LIST_PAGE = 1;
    }

    public static final class TyingFromPage {
        public static final String BILL = "2";
        public static final int BILL_INT = 2;
        public static final String MIMI_CART = "1";
        public static final int MIMI_CART_INT = 1;
    }

    public static final class TyingRequestType {
        public static final int FROM_PAGE_BILL = 2;
        public static final int FROM_PAGE_MINI = 1;
    }

    public static final class UriFromType {
        public static final String DEFAULT = "0";
        public static final String OUTER = "1";
    }

    public static final class UserCenterNeedLogin {
        public static final int NEED = 1;
    }

    public static final class UserCenterRVType {
        public static final int Hor = 2;
        public static final int Msg = 1;
        public static final int Ver = 3;
    }

    public enum ABConfigName {
        BILL_PAGE("abTestBill");
        
        public String name;

        private ABConfigName(String str) {
            this.name = str;
        }

        @Nullable
        public ABConfigEntity getConfigEntity() {
            return ABConfigHelper.Companion.getConfigByName(this.name);
        }

        public boolean isSwitchOn() {
            ABConfigEntity configEntity = getConfigEntity();
            if (configEntity == null || configEntity.getValue() == 0) {
                return false;
            }
            return true;
        }
    }
}
