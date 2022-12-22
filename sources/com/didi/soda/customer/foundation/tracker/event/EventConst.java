package com.didi.soda.customer.foundation.tracker.event;

public class EventConst {

    public static final class Address {
        public static final String EVENT_ADDRESS_CART_PAGE_CK = "sailing_c_x_cartpage_check_address_ck";
        public static final String EVENT_ADDRESS_CART_PAGE_SW = "sailing_c_x_cartpage_check_address_sw";
        public static final String EVENT_ADDRESS_COMPILER_CK = "sailing_c_x_deliverydetail_compiler_ck";
        public static final String EVENT_ADDRESS_COMPILER_SW = "sailing_c_x_deliverydetail_compiler_sw";
        public static final String EVENT_ADDRESS_DELETE_CK = "sailing_c_x_deliverydetail_delete_ck";
        public static final String EVENT_ADDRESS_DELETE_SW = "sailing_c_x_deliverydetail_delete_sw";
        public static final String EVENT_ADDRESS_EDIT = "sailing_c_x_deliverydetail_edit_ck";
        public static final String EVENT_ADDRESS_EDIT_SW = "sailing_c_x_cart_address_detail_sw";
        public static final String EVENT_ADDRESS_POPUP_ADD_CK = "sailing_c_x_cart_address_popup_add_ck";
        public static final String EVENT_ADDRESS_POPUP_IGNORE_CK = "sailing_c_x_cart_address_popup_ignore_ck";
        public static final String EVENT_ADDRESS_POPUP_SW = "sailing_c_x_cart_address_popup_sw";
        public static final String EVENT_ADDRESS_REALEXPOSURE_SW = "sailing_c_x_deliverydetail_realexposure_sw";
        public static final String EVENT_ADDRESS_REFRESH_LOCATION = "sailing_c_x_addresspage_refresh_location_ck";
        public static final String EVENT_ADDRESS_SEARCH = "sailing_c_x_deliverydetail_search_sw";
        public static final String EVENT_ADDRESS_SEARCH_CK = "sailing_c_x_deliverydetail_search_ck";
        public static final String EVENT_ADDRESS_SELECTED = "sailing_c_x_deliverydetail_choose_ck";
        public static final String EVENT_CART_ADDRESS_CART_ADDRESS_POI_CK = "sailing_c_x_cart_address_poi_ck";
        public static final String EVENT_CART_ADDRESS_CART_LOCATION_MOVE_CK = "sailing_c_x_cart_location_move_ck";
        public static final String EVENT_CART_ADDRESS_DETAIL_CONFIRM_CK = "sailing_c_x_cart_address_detail_confirm_ck";
        public static final String EVENT_CART_ADDRESS_DETAIL_LOCATION_MOVE_CK = "sailing_c_x_deliverydetail_location_move_ck";
        public static final String EVENT_CART_ADDRESS_DETAIL_LOCATION_REFRESH_CK = "sailing_c_x_deliverydetail_location_refresh_ck";
        public static final String EVENT_CART_ADDRESS_DETAIL_LOCATION_SW = "sailing_c_x_deliverydetail_location_sw";
        public static final String EVENT_GET_ADDRESS = "sailing_c_x_open_location_ck";
        public static final String EVENT_MANU_GET_ADDRESS = "sailing_c_x_open_locatefail_ck";
        public static final String EVENT_OPEN_ADDRESS_HOME = "sailing_c_x_deliverydetail_common_sw";
        public static final String EVENT_ORDERPAGE_DELIVERY_ADD_CK = "sailing_c_x_orderpage_delivery_add_ck";
        public static final String EVENT_ORDERPAGE_DELIVERY_COMMON_SW = "sailing_c_x_orderpage_delivery_common_sw";
        public static final String EVENT_ORDERPAGE_DELIVERY_CONFIRM_CHANGE_CK = "sailing_c_x_deliverydetail_confirm_change_ck";
        public static final String EVENT_ORDERPAGE_DELIVERY_CONFIRM_CK = "sailing_c_x_deliverydetail_confirm_ck";
        public static final String EVENT_ORDERPAGE_DELIVERY_CONFIRM_FAIL_SW = "sailing_c_x_deliverydetail_confirm_fail_sw";
        public static final String EVENT_ORDERPAGE_DELIVERY_EDIT_CK = "sailing_c_x_orderpage_delivery_edit_ck";
        public static final String EVENT_POI_TIP_CK = "sailing_c_x_poi_tips_ck";
        public static final String EVENT_POI_TIP_CLOSE_CK = "sailing_c_x_poi_tips_close_ck";
        public static final String EVENT_POI_TIP_SW = "sailing_c_x_poi_tips_sw";
    }

    public static final class Alcohol {
        public static final String ORDER_DIALOG_CANCEL_CK = "sailing_c_x_specselection_popup_cancel_ck";
        public static final String ORDER_DIALOG_CONFIRM_CK = "sailing_c_x_specselection_popup_confirm_ck";
        public static final String ORDER_DIALOG_SW = "sailing_c_x_specselection_popup_sw";
        public static final String SPEC_TEXT_SHOW = "sailing_c_x_specselection_text_sw";
    }

    public static final class AppFlyers {
        public static final String DEFERRED_URL_ERROR = "tech_sailing_c_rlink_deferred_adgroupmapurl_error";
        public static final String DEFERRED_URL_SUCCESS = "tech_sailing_c_rlink_deferred_adgroupmapurl_success";
        public static final String GET_DATA = "sailing_c_x_ads_startpage_conversion_success_sw";
    }

    public static final class Bill {
        public static final String BILL_DIALOG_SHOW = "tech_sailing_c_dialog_show";
        public static final String BILL_ORDER_RECOVERY_FAIL_TOAST_SW = "sailing_c_x_order_paypay_bill_fail_pop_sw";
        public static final String BILL_ORDER_RECOVERY_TECH = "tech_sailing_c_recover_order";
        public static final String BILL_ORDER_TIMEOUT_BACK_NO_DATA_TECH = "tech_sailing_c_order_timeout_back_no_data";
        public static final String BILL_ORDER_TIMEOUT_HAS_DATA_TECH = "tech_sailing_c_order_timeout_has_data";
        public static final String BILL_ORDER_TIMEOUT_TECH = "tech_sailing_c_order_timeout";
        public static final String BILL_OUT_OF_STOCK_CK = "sailing_c_x_cart_out_of_stock_ck";
        public static final String BILL_OUT_OF_STOCK_CONFIRM_CK = "sailing_c_x_cart_out_of_stock_confirm_ck";
        public static final String BILL_OUT_OF_STOCK_PAGE_SW = "sailing_c_x_cart_out_of_stock_popup_sw";
        public static final String BILL_OUT_OF_STOCK_SELECT_CK = "sailing_c_x_cart_out_of_stock_select_ck";
        public static final String BILL_REMINDER_SHOW = "tech_sailing_c_bill_tip_sw";
        public static final String BILL_TIPS_CONFIRM_CK = "sailing_c_x_cart_tips_confirm_ck";
        public static final String EVENT_ADDRESS_VERIFY_SW = "sailing_c_x_cart_address_verify_sw";
        public static final String EVENT_ARREARS_ORDER_INTERCEPT_CK = "sailing_c_x_arrears_order_intercept_ck";
        public static final String EVENT_ARREARS_ORDER_INTERCEPT_SW = "sailing_c_x_arrears_order_intercept_sw";
        public static final String EVENT_CART_ACTIVITY_TOAST_SW = "sailing_c_x_cart_activity_toast_sw";
        public static final String EVENT_CART_ADDRESS_PROMPT_SW = "sailing_c_x_cart_address_prompt_sw";
        public static final String EVENT_CART_CART_MUTEX_RULER_CK = "sailing_c_x_cart_mutex_ruler_ck";
        public static final String EVENT_CART_CART_ORDER_DETAIL_TIP_SW = "sailing_c_x_orderdetail_tip_sw";
        public static final String EVENT_CART_CART_PAY_METHOD_FAIL_CK = "sailing_c_x_cart_paymethod_fail_ck";
        public static final String EVENT_CART_CART_PAY_METHOD_FAIL_SW = "sailing_c_x_cart_paymethod_fail_sw";
        public static final String EVENT_CART_CHANGE_ADDRESS_CK = "sailing_c_x_cart_changeaddress_ck";
        public static final String EVENT_CART_COMMON_SW = "sailing_c_x_cart_common_sw";
        public static final String EVENT_CART_CONTENT_POPUP_SW = "sailing_c_x_cart_content_popup_sw";
        public static final String EVENT_CART_COUPON_PACKAGE_CK = "sailing_c_x_cart_coupon_package_ck";
        public static final String EVENT_CART_COUPON_PACKAGE_SW = "sailing_c_x_orderdetail_page_coupon_sw";
        public static final String EVENT_CART_DELIVERY_CONFIRM_CK = "sailing_c_x_cart_delivery_confirm_ck";
        public static final String EVENT_CART_DELIVERY_CONFIRM_SW = "sailing_c_x_cart_delivery_confirm_sw";
        public static final String EVENT_CART_DELIVERY_METHOD_CK = "sailing_c_x_cart_delivery_method_ck";
        public static final String EVENT_CART_DELIVERY_METHOD_CONFIRM_CK = "sailing_c_x_cart_delivery_method_confirm_ck";
        public static final String EVENT_CART_DISCOUNT_CK = "sailing_c_x_cart_discount_ck";
        public static final String EVENT_CART_EXPERIMENT_SW = "sailing_c_x_experiment_sw";
        public static final String EVENT_CART_PAYMENT_FAIL_CK = "sailing_c_x_cart_payment_fail_ck";
        public static final String EVENT_CART_PAYMENT_FAIL_SW = "sailing_c_x_cart_payment_fail_sw";
        public static final String EVENT_CART_RECOMMEND_BUBBLE_CK = "sailing_c_x_cart_recommend_bubble_ck";
        public static final String EVENT_CART_RECOMMEND_BUBBLE_SW = "sailing_c_x_cart_recommend_bubble_sw";
        public static final String EVENT_CART_RECOMMEND_BUUBLE_CL = "sailing_c_x_cart_recommend_bubble_close_ck";
        public static final String EVENT_CART_RETURN_CK = "sailing_c_x_cart_return_ck";
        public static final String EVENT_CART_VOUCHER_CK = "sailing_c_x_cart_voucher_ck";
        public static final String EVENT_CLICK_TIPS = "sailing_c_x_cart_tips_ck";
        public static final String SAILING_C_X_CART_ITEM_CK = "sailing_c_x_cart_item_ck";
        public static final String SAILING_C_X_CART_REMARK_CK = "sailing_c_x_cart_remark_ck";
        public static final String SAILING_C_X_CART_REMARK_COMFIRM_CK = "sailing_c_x_cart_remark_comfirm_ck";
    }

    public static final class Blocks {
        public static final String TECH_SAILING_C_X_AETHER_BUSINESS_DATA_ERROR = "tech_sailing_c_x_aether_business_data_error";
        public static final String TECH_SAILING_C_X_AETHER_TEMPLATE_NOT_FOUND = "tech_sailing_c_x_aether_template_not_found";
        public static final String TECH_SAILING_C_X_AETHER_TEMPLATE_NO_ID = "tech_sailing_c_x_aether_template_no_id";
    }

    public static final class Business {
        public static final String SAILING_C_X_SHOP_SLIDE_CK = "sailing_c_x_shop_slide_ck";
        public static final String SAILING_C_X_SHOP_TAB_SLIDE_CK = "sailing_c_x_shop_tab_slide_ck";
        public static final String SHOP_COMMON_SW = "sailing_c_x_shop_common_sw";
        public static final String SHOP_CPF_CHECK_CK = "sailing_c_x_shop_cpf_check_ck";
        public static final String SHOP_CPF_CHECK_FAIL_SW = "sailing_c_x_shop_cpf_check_fail_sw";
        public static final String SHOP_CPF_CHECK_SW = "sailing_c_x_shop_cpf_check_sw";
        public static final String SHOP_CPF_CHECK_TOAST_SW = "sailing_c_x_shop_cpf_check_toast_sw";
        public static final String SHOP_DETAIL_ADDRESS_CK = "sailing_c_x_shopdetail_address_ck";
        public static final String SHOP_DETAIL_RETURN_CK = "sailing_c_x_shopdetail_return_ck";
        public static final String SHOP_DETAIL_RULE_CK = "sailing_c_x_shopdetail_rule_ck";
        public static final String SHOP_DETAIL_SW = "sailing_c_x_shopdetail_common_sw";
        public static final String SHOP_EXPAND_SW = "sailing_c_x_shop_item_sold_out_show_sw";
        public static final String SHOP_EXPOSURE_SW = "sailing_c_x_realexposure_sw";
        public static final String SHOP_FAVORITE_CK = "sailing_c_x_shop_favorite_ck";
        public static final String SHOP_FOLD_SW = "sailing_c_x_shop_item_sold_out_put_away_sw";
        public static final String SHOP_GOODS_ITEM_ADD_CK = "sailing_c_x_shop_item_add_ck";
        public static final String SHOP_GOODS_ITEM_CK = "sailing_c_x_shop_item_ck";
        public static final String SHOP_GOODS_ITEM_POST_CART_SUCCESS = "sailing_c_x_shop_item_add_callback_ck";
        public static final String SHOP_GOODS_ITEM_TO_CART_SUCCESS = "sailing_c_x_shop_item2cart_ck";
        public static final String SHOP_HEADER_CK = "sailing_c_x_shop_title_ck";
        public static final String SHOP_HEADER_COUPON_REDUCE_CK = "sailing_c_x_shop_coupon_reduce_ck";
        public static final String SHOP_HEADER_COUPON_REDUCE_CLOSE_CK = "sailing_c_x_shop_coupon_reduce_close_ck";
        public static final String SHOP_HEADER_COUPON_REDUCE_SW = "sailing_c_x_shop_coupon_reduce_sw";
        public static final String SHOP_HEADER_SEARCH_CK = "sailing_c_x_shop_title_search_ck";
        public static final String SHOP_ITEM_EXPAND_CK = "sailing_c_x_shop_item_sold_out_show_ck";
        public static final String SHOP_ITEM_FOLD_CK = "sailing_c_x_shop_item_sold_out_put_away_ck";
        public static final String SHOP_ITEM_PHOTO_CK = "sailing_c_x_shop_item_photo_ck";
        public static final String SHOP_ITEM_PHOTO_CLOSE_CK = "sailing_c_x_shop_item_large_close_ck";
        public static final String SHOP_ITEM_PHOTO_SW = "sailing_c_x_shop_item_large_sw";
        public static final String SHOP_MORE_TAB_CK = "sailing_c_x_shop_tab_more_ck";
        public static final String SHOP_MORE_TAB_CLOSE_CK = "sailing_c_x_shop_tab_close_ck";
        public static final String SHOP_MORE_TAB_SW = "sailing_c_x_shop_tab_more_sw";
        public static final String SHOP_ONE_MORE_TOAST_SW = "sailing_c_x_shop_one_more_toast_sw";
        public static final String SHOP_OUTSIDE_COLSE_POPUP_CK = "sailing_c_x_shop_store_closed_popup_ck";
        public static final String SHOP_OUTSIDE_COLSE_POPUP_SW = "sailing_c_x_shop_store_closed_popup_sw";
        public static final String SHOP_OUTSIDE_DELIVERY_POPUP_CK = "sailing_c_x_shop_outside_delivery_popup_ck";
        public static final String SHOP_OUTSIDE_DELIVERY_POPUP_SW = "sailing_c_x_shop_outside_delivery_popup_sw";
        public static final String SHOP_RETURN_CK = "sailing_c_x_shop_return_ck";
        public static final String SHOP_SEARCH_CLOSE_CK = "sailing_c_x_shop_search_close_ck";
        public static final String SHOP_SEARCH_HOT_WORD_CK = "sailing_c_x_shop_search_hotword_ck";
        public static final String SHOP_SEARCH_HOT_WORD_SW = "sailing_c_x_shop_search_hotword_sw";
        public static final String SHOP_SEARCH_NO_RESULT_SW = "sailing_c_x_shop_search_no_result_sw";
        public static final String SHOP_SEARCH_PAGE_SEARCH_ITEM_SW = "sailing_c_x_shop_search_item_sw";
        public static final String SHOP_SEARCH_SW = "sailing_c_x_shop_search_sw";
        public static final String SHOP_TAB_CK = "sailing_c_x_shop_tab_ck";
        public static final String SHOP_TAB_SW = "sailing_c_x_shop_tab_sw";
        public static final String SHOP_TITLE_DELIVERY_MESSAGE_CK = "sailing_c_x_shop_title_delivery_message_ck";
        public static final String SHOP_TITLE_DELIVERY_MESSAGE_SW = "sailing_c_x_shop_title_delivery_message_sw";
        public static final String SHOP_TITLE_DEMAND_MESSAGE_SW = "sailing_c_x_shop_title_demand_message_sw";
    }

    public static final class Cart {
        public static final String EVENT_ADD_CART_ERROR = "sailing_add_cart_error";
        public static final String EVENT_CART_ADD_END = "tech_sailing_c_m_cart_action_session_end";
        public static final String EVENT_CART_ADD_TASK_BEGIN = "tech_sailing_c_m_cart_action_task_begin";
        public static final String EVENT_CART_ADD_TASK_END = "tech_sailing_c_m_cart_action_task_end";
        public static final String EVENT_CART_FLOATING_ADD_ITEM_CK = "sailing_c_x_cart_minicart_add_item_ck";
        public static final String EVENT_CART_FLOATING_CHECKOUT_CK = "sailing_c_x_cart_minicart_checkout_ck";
        public static final String EVENT_CART_FLOATING_ITEM_CK = "sailing_c_x_cart_minicart_item_ck";
        public static final String EVENT_CART_FLOATING_SW = "sailing_c_x_cart_minicart_floating_layer_sw";
        public static final String EVENT_CART_REFRESH_ADD_ITEM = "sailing_c_x_cart_refresh_additem_sw";
        public static final String EVENT_CLICK_CONTACT_AREACODE = "sailing_c_x_cart_concat_areacode_ck";
        public static final String EVENT_CLICK_PAY = "sailing_c_x_cart_pay_ck";
        public static final String EVENT_CLICK_PAYMENT = "sailing_c_x_cart_payment_ck";
        public static final String EVENT_CLICK_PAY_CREAT_ORDER_RESULT = "sailing_c_x_cart_pay_callback_ck";
        public static final String EVENT_CLICK_PAY_FAIL_CHANGE = "sailing_c_x_cartpage_paycallback_change_ck";
        public static final String EVENT_CLICK_PAY_RESULT = "sailing_c_x_cartpage_paycallback_response_upload";
        public static final String EVENT_GOTO_ADDRESS = "sailing_c_x_cart_changepoi_ck";
        public static final String EVENT_ITEM_REAL_SHOW = "sailing_c_x_cart_item_realexposure_sw";
        public static final String EVENT_JUVENILES_CONFIRM_POPUP_CK = "sailing_c_x_juveniles_confirm_popup_ck";
        public static final String EVENT_JUVENILES_CONFIRM_POPUP_SW = "sailing_c_x_juveniles_confirm_popup_sw";
        public static final String EVENT_JUVENILES_POPUP_CK = "sailing_c_x_juveniles_popup_ck";
        public static final String EVENT_JUVENILES_POPUP_SW = "sailing_c_x_juveniles_popup_sw";
        public static final String EVENT_JUVENILES_REFUSE_POPUP_CK = "sailing_c_x_juveniles_refuse_popup_ck";
        public static final String EVENT_JUVENILES_REFUSE_POPUP_SW = "sailing_c_x_juveniles_refuse_popup_sw";
        public static final String EVENT_PAY_DUPLICATE_CONFIRM_CK = "sailing_c_x_order_duplicate_confirm_ck";
        public static final String EVENT_PAY_PREMATCHBLOCK_CK = "sailing_c_x_cart_pay_prematchblock_ck";
        public static final String EVENT_PAY_PREMATCHBLOCK_SW = "sailing_c_x_cart_pay_prematchblock_sw";
        public static final String EVENT_REMARK_DISABLE_TOAST = "sailing_c_x_cart_remark_toast_sw";
        public static final String EVENT_SAILING_C_X_CART_MERGE_ITEM2CART_CK = "sailing_c_x_cart_merge_item2cart_ck";
        public static final String EVENT_SAILING_C_X_CART_MERGE_ITEM_CK = "sailing_c_x_cart_merge_item_ck";
        public static final String EVENT_SAILING_C_X_CART_MERGE_ORDER_SW = "sailing_c_x_cart_merge_order_sw";
        public static final String EVENT_SAILING_C_X_CART_MERGE_REALEXPOSURE_SW = "sailing_c_x_cart_merge_realexposure_sw";
        public static final String EVENT_SHOW_PAY_FAIL = "sailing_c_x_cart_pay_fail_sw";
        public static final String TECH_SAILING_C_CART_INFO_API_ERROR = "tech_sailing_c_cart_info_api_error";
    }

    public static final class Collections {
        public static final String FAVOR_NO_SHOP_SW = "sailing_c_x_favorite_no_shop_sw";
        public static final String FAVOR_SHOP_DELETE_CK = "sailing_c_x_favorite_shop_delete_ck";
        public static final String FAVOR_SHOP_DELETE_SW = "sailing_c_x_favorite_shop_delete_sw";
    }

    public static final class CommpentType {
        public static final String ACTIVITY = "activity";
        public static final String ITEM = "item";
        public static final String ORDER = "order";
        public static final String SHOP = "shop";
    }

    public static final class Conversion {
        public static final String CHECK_APP_PERMISSION = "sailing_c_x_startpage_permission_check_sw";
        public static final String DOUBLE_BACK_KILL = "tech_sailing_c_event_double_back_kill";
        public static final String END_LOC = "tech_sailing_c_start_get_location_end";
        public static final String ENTER_APP = "sailing_c_x_startpage_startup_app_sw";
        public static final String ENTER_APP_ON_APP_OPEN = "tech_sailing_c_rlink_onelink_onappopen";
        public static final String ENTER_APP_WITH_URL = "sailing_c_x_startpage_app_link_sw";
        public static final String ENTER_BACKGROUND = "sailing_c_x_startpage_enter_background_ck";
        public static final String ENTER_FOREGROUND = "sailing_c_x_startpage_switch_back_sw";
        public static final String ENTER_SPLASH = "tech_sailing_c_start_enter_splash";
        public static final String GOTO_LOGIN = "tech_sailing_c_home_goto_login";
        public static final String HOME_SPLASH_SHOW = "tech_sailing_c_home_splash_sw";
        public static final String KILL_APP = "sailing_c_x_startpage_kill_app_ck";
        public static final String LOCALE_EMB = "tech_sailing_c_emb_locale";
        public static final String START_APP = "tech_sailing_c_event_app_start";
        public static final String START_GET_POSITION = "sailing_c_x_startpage_get_position_sw";
        public static final String START_HOME_FRAME = "tech_sailing_c_start_home_frame";
        public static final String START_LOC = "tech_sailing_c_start_get_location_begain";
        public static final String TAB_IN_BY_URL = "sailing_c_x_startpage_schema_tab_in_ck";
        public static final String TAB_IN_CK = "sailing_c_x_startpage_tab_in_ck";
        public static final String TAB_OUT_CK = "sailing_c_x_startpage_tab_out_ck";
        public static final String WEB_APPEND_PARAM = "tech_sailing_c_x_webpage_appendquery_en";
    }

    public static final class DidiPass {
        public static final String DIDI_PASS_PAY_CALLBACK = "tech_sailing_c_event_didi_pass_pay_callback";
        public static final String DIDI_PASS_PAY_CK = "tech_sailing_c_event_didi_pass_pay_ck";
        public static final String GO_DIDI_PASS = "tech_sailing_c_event_go_didi_pass";
    }

    public static final class Foster {
        public static final String FOSTER_SCROLL = "sailing_c_x_homepage_top_slide_sw";
        public static final String FOSTER_SHOW = "sailing_c_x_homepage_top_common_sw";
    }

    public static final class GlobalCart {
        public static final String SAILING_C_X_CART_GLOBAL_CHECKOUT_CK = "sailing_c_x_cart_global_checkout_ck";
        public static final String SAILING_C_X_CART_GLOBAL_MUTEX_RULER_SW = "sailing_c_x_cart_global_mutex_ruler_sw";
        public static final String SAILING_C_X_CART_GLOBAL_SHOP_CK = "sailing_c_x_cart_global_shop_ck";
        public static final String SAILING_C_X_CART_GLOBAL_SW = "sailing_c_x_cart_global_sw";
        public static final String SAILING_C_X_CART_HOME_GUIDE_CK = "sailing_c_x_cart_home_guide_ck";
        public static final String SAILING_C_X_CART_HOME_GUIDE_SW = "sailing_c_x_cart_home_guide_sw";
        public static final String TECH_SAILING_C_CART_LIST_API_ERROR = "tech_sailing_c_cart_list_api_error";
    }

    public static final class Goods {
        public static final String ITEM_MULTI_LEVEL_COMMON_SW = "sailing_c_x_specselection_hierarchy_sw";
        public static final String ITEM_MULTI_LEVEL_CONFIRM_CK = "sailing_c_x_specselection_hierarchy_confirm_ck";
        public static final String ITEM_MULTI_LEVEL_ENTER_CK = "sailing_c_x_specselection_into_hierarchy_ck";
        public static final String ITEM_PURCHASE_ADD_CART_CK = "sailing_c_x_specselection_item2cart_ck";
        public static final String ITEM_PURCHASE_CHECK_OUT = "sailing_c_x_specselection_checkout_ck";
        public static final String ITEM_PURCHASE_CHOOSE_CK = "sailing_c_x_specselection_choose_ck";
        public static final String ITEM_PURCHASE_COMMON_SW = "sailing_c_x_specselection_common_sw";
        public static final String ITEM_PURCHASE_RETURN_CK = "sailing_c_x_specselection_return_ck";
        public static final String ITEM_PURCHASE_TOAST_SW = "sailing_c_x_specselection_activity_toast_sw";
    }

    public static final class History {
        public static final String MYORDER_COMMON_SW = "sailing_c_x_myorder_common_sw";
        public static final String MYORDER_EXPOSE_SW = "sailing_c_x_myorder_realexpose_sw";
        public static final String MYORDER_ONE_MORE_CK = "sailing_c_x_myorder_one_more_ck";
        public static final String MYORDER_ORDER_CK = "sailing_c_x_myorder_order_ck";
        public static final String MYORDER_RETURN_CK = "sailing_c_x_myorder_return_ck";
    }

    public static final class Home {
        public static final String END_REQUEST_FEED_INDEX = "sailing_c_x_homepage_request_data_result_sw";
        public static final String HOMEPAGE_ADDRESS_NONE_CK = "sailing_c_x_homepage_address_none_ck";
        public static final String HOMEPAGE_GOOGLE_SERVICE_AUTHORITY_CK = "sailing_c_x_homepage_google_service_authority_ck";
        public static final String HOMEPAGE_GOOGLE_SERVICE_AUTHORITY_SW = "sailing_c_x_homepage_google_service_authority_sw";
        public static final String HOMEPAGE_OPEN_LOCATION_CK = "sailing_c_x_homepage_open_location_ck";
        public static final String HOMEPAGE_OPEN_LOCATION_SW = "sailing_c_x_homepage_open_location_sw";
        public static final String HOME_ADDRESS_CK = "sailing_c_x_address_click";
        public static final String HOME_ADDRESS_NONE_SW = "sailing_c_x_homepage_address_none_sw";
        public static final String HOME_AVAILABLE_CITY_CK = "sailing_c_x_homepage_available_city_ck";
        public static final String HOME_AVAILABLE_CITY_SW = "sailing_c_x_homepage_available_city_sw";
        public static final String HOME_BANNER_CK = "sailing_c_x_homepage_banner_ck";
        public static final String HOME_BANNER_SW = "sailing_c_x_homepage_banner_sw";
        public static final String HOME_BOTTOM_LOGIN_CK = "sailing_c_x_homepage_bottom_ck";
        public static final String HOME_BOTTOM_LOGIN_SW = "sailing_c_x_homepage_bottom_common_sw";
        public static final String HOME_BROWSE_SW = "sailing_c_x_homepage_slidefeed_ck";
        public static final String HOME_CHANGE_LOCATION_CK = "sailing_c_x_homepage_change_location_ck";
        public static final String HOME_CHECK_AVAILABLE_CITY_CK = "sailing_c_x_homepage_check_available_city_ck";
        public static final String HOME_CHECK_AVAILABLE_COUNTRY_CK = "sailing_c_x_homepage_check_available_country_ck";
        public static final String HOME_CITY_UNAVAILABLE_SW = "sailing_c_x_homepage_city_unavailable_sw";
        public static final String HOME_CITY_WARM_UP_SW = "sailing_c_x_homepage_warm_up_sw";
        public static final String HOME_COMMON_REQUEST_SW = "sailing_c_x_homepage_common_request_sw";
        public static final String HOME_COMMON_SW = "sailing_c_x_homepage_common_sw";
        public static final String HOME_COUNTRY_UNAVAILABLE_SW = "sailing_c_x_homepage_country_unavailable_sw";
        public static final String HOME_DANGEROUS_AREA_SW = "sailing_c_x_homepage_dangerous_area_sw";
        public static final String HOME_EFO_ENTER_CK = "sailing_c_x_homepage_operation_more_ck";
        public static final String HOME_EFO_ITEM_BUY_CK = "sailing_c_x_operation_buy_ck";
        public static final String HOME_EFO_ITEM_CK = "sailing_c_x_operation_item_ck";
        public static final String HOME_EFO_ITEM_SW = "sailing_c_x_operation_realexposure_sw";
        public static final String HOME_EFO_SW = "sailing_c_x_homepage_operation_common_sw";
        public static final String HOME_ERROR_SW = "sailing_c_x_homepage_error_sw";
        public static final String HOME_FILTER_CATE_REAL_SW = "sailing_c_x_homepage_category_realexposure_sw";
        public static final String HOME_FILTER_CATE_SW = "sailing_c_x_homepage_category_sw";
        public static final String HOME_FILTER_ITEM_CATE_CK = "sailing_c_x_homepage_allcategory_ck";
        public static final String HOME_FILTER_ITEM_CATE_SELECT_CK = "sailing_c_x_homepage_category_ck";
        public static final String HOME_FILTER_ITEM_MUL_CK = "sailing_c_x_homepage_filter_ck";
        public static final String HOME_FILTER_ITEM_MUL_CLEAR_CK = "sailing_c_x_homepage_filterclear_ck";
        public static final String HOME_FILTER_ITEM_MUL_CONFIRM_CK = "sailing_c_x_homepage_filterconfirm_ck";
        public static final String HOME_FILTER_ITEM_OUT_CLICK = "sailing_c_x_homepage_filter_features_ck";
        public static final String HOME_FILTER_ITEM_REALEXPOSURE_SW = "sailing_c_x_homepage_filterselect_realexposure_sw";
        public static final String HOME_FILTER_ITEM_SORT_CK = "sailing_c_x_homepage_filtersort_ck";
        public static final String HOME_FILTER_ITEM_SORT_SELECT_CK = "sailing_c_x_homepage_sorttype_ck";
        public static final String HOME_FILTER_ITEM_SW = "sailing_c_x_homepage_filter_common_sw";
        public static final String HOME_FILTER_MODULE_INALL_SW = "sailing_c_x_homepage_filter_realexposure_sw";
        public static final String HOME_FILTER_NO_RESULT_SW = "sailing_c_x_homepage_filter_none_sw";
        public static final String HOME_FILTER_OUTSIDE_CK = "sailing_c_x_homepage_filter_outside_ck";
        public static final String HOME_FILTER_OUTSIDE_CONFIRM_CK = "sailing_c_x_homepage_filter_outside_confirm_ck";
        public static final String HOME_FILTER_RESET_CK = "sailing_c_x_homepage_filter_reset_ck";
        public static final String HOME_FILTER_RESET_SHOW = "sailing_c_x_homepage_filter_reset_sw";
        public static final String HOME_HEADER_SPECIAL_CK = "sailing_c_x_homepage_upper_activity_ck";
        public static final String HOME_HEADER_SPECIAL_SW = "sailing_c_x_homepage_upper_activity_sw";
        public static final String HOME_HOT_AREA_CK = "sailing_c_x_homepage_hot_area_ck";
        public static final String HOME_LOGIN_GUIDANCE_CLOSE_CK = "sailing_c_x_login_guidance_close_ck";
        public static final String HOME_LOGIN_GUIDANCE_IS_SHOW_SKIP = "sailing_c_x_login_guidance_skip_sw";
        public static final String HOME_LOGIN_GUIDANCE_LOGIN_CK = "sailing_c_x_login_guidance_service_ck";
        public static final String HOME_LOGIN_GUIDANCE_SKIP_CK = "sailing_c_x_login_guidance_skip_ck";
        public static final String HOME_LOGIN_GUIDANCE_SW = "sailing_c_x_login_guidance_sw";
        public static final String HOME_NON_ACTIVATED_AREA_SW = "sailing_c_x_homepage_nonactivated_area_sw";
        public static final String HOME_NO_MERCHANT_SW = "sailing_c_x_homepage_no_merchant_sw";
        public static final String HOME_ORDERLIST_CK = "sailing_c_x_homepage_orderlist_ck";
        public static final String HOME_ORDERLIST_SHOWALL_CK = "sailing_c_x_homepage_orderlist_showall_ck";
        public static final String HOME_ORDERLIST_SHOWALL_SW = "sailing_c_x_homepage_orderlist_showall_sw";
        public static final String HOME_ORDERLIST_SW = "sailing_c_x_homepage_orderlist_sw";
        public static final String HOME_PERSON_CENTER_CK = "sailing_c_x_homepage_personcenter_ck";
        public static final String HOME_PULL_UP_TO_LOAD = "sailing_c_x_home_pullUpToLoad";
        public static final String HOME_REAL_EXPOSURE_SW = "sailing_c_x_homepage_realexposure_sw";
        public static final String HOME_REFRESH = "sailing_c_x_home_refresh";
        public static final String HOME_SEARCH_RESULT_SEE_MORE_CK = "sailing_c_x_searchresult_see_more_ck";
        public static final String HOME_SERVICE_NOTIFICATION_CK = "sailing_c_x_homepage_service_notification_ck";
        public static final String HOME_SHOP_CK = "sailing_c_x_homepage_shop_ck";
        public static final String HOME_SHOWALL_CK = "sailing_c_x_homepage_topic_viewall_ck";
        public static final String HOME_START_PAGE_COOPEN_CK = "sailing_c_x_startpage_coopen_ck";
        public static final String HOME_START_PAGE_COOPEN_SW = "sailing_c_x_startpage_coopen_sw";
        public static final String HOME_SUBMIT_PHONE_CK = "sailing_c_x_homepage_submit_phone_ck";
        public static final String HOME_SUBMIT_PHONE_SW = "sailing_c_x_homepage_submit_phone_sw";
        public static final String HOME_TAB_BAR_CK = "sailing_c_x_homepage_bottom_navigation_ck";
        public static final String HOME_TAB_BAR_RED_FLAG_SW = "sailing_c_x_bottom_redflag_sw";
        public static final String HOME_TAB_BAR_SW = "sailing_c_x_homepage_bottom_navigation_sw";
        public static final String HOME_TASK_CENTER_CK = "sailing_c_x_homepage_task_center_ck";
        public static final String HOME_TASK_CENTER_SW = "sailing_c_x_homepage_task_center_sw";
        public static final String HOME_TOPIC_BUY_CK = "sailing_c_x_top_buy_ck";
        public static final String HOME_TOPIC_ENTER_STORE_CK = "sailing_c_x_top_item_enter_store_ck";
        public static final String HOME_TOPIC_GOODS_ITEM_SW = "sailing_c_x_top_item_realexposure_sw";
        public static final String HOME_TOPIC_GOOD_ITEM_CK = "sailing_c_x_top_item_ck";
        public static final String HOME_TOPIC_MORE_CK = "sailing_c_x_homepage_top_more_ck";
        public static final String HOME_TOPIC_PAGE_SW = "sailing_c_x_homepage_topic_sw";
        public static final String HOME_TOPIC_SHOP_CK = "sailing_c_x_homepage_topic_shop_ck";
        public static final String HOME_TOPIC_SHOP_SW = "sailing_c_x_homepage_topic_shop_sw";
        public static final String HOME_TOPIC_SW = "sailing_c_x_homepage_top_common_sw";
        public static final String SAILING_C_X_HOMEPAGE_BUBBLE_TASK_CENTER_CK = "sailing_c_x_homepage_bubble_task_center_ck";
        public static final String SAILING_C_X_HOMEPAGE_BUBBLE_TASK_CENTER_SW = "sailing_c_x_homepage_bubble_task_center_sw";
        public static final String SAILING_C_X_HOMEPAGE_PROFILE_COMMON_SW = "sailing_c_x_homepage_profile_common_sw";
        public static final String SAILING_C_X_HOMEPAGE_SEARCH_INPUT_SW = "sailing_c_x_homepage_search_input_sw";
        public static final String SAILING_C_X_HOMEPAGE_SHOP_FEEDBACK_CK = "sailing_c_x_homepage_shop_feedback_ck";
        public static final String SAILING_C_X_HOMEPAGE_SHOP_FEEDBACK_SW = "sailing_c_x_homepage_shop_feedback_sw";
        public static final String SAILING_C_X_HOME_COORD_CK = "sailing_c_x_synergy_shop_ck";
        public static final String SAILING_C_X_HOME_COORD_ERROR = "tech_sailing_c_coord_shop_error";
        public static final String SAILING_C_X_HOME_COORD_REQUEST_SUCCESS = "sailing_c_x_synergy_success_sw";
        public static final String SAILING_C_X_HOME_COORD_SW = "sailing_c_x_synergy_shop_sw";
        public static final String SAILING_C_X_OPERATION_CATEGORY_FILTER_CK = "sailing_c_x_operation_category_filter_ck";
        public static final String SAILING_C_X_OPERATION_CATEGORY_FILTER_POP_CK = "sailing_c_x_operation_category_filter_pop_ck";
        public static final String SAILING_C_X_OPERATION_CATEGORY_FILTER_POP_SW = "sailing_c_x_operation_category_filter_pop_sw";
        public static final String SAILING_C_X_OPERATION_CATEGORY_FILTER_SW = "sailing_c_x_operation_category_filter_sw";
        public static final String SAILING_C_X_OPERATION_SORT_FILTER_CK = "sailing_c_x_operation_sort_filter_ck";
        public static final String SAILING_C_X_OPERATION_SORT_FILTER_SW = "sailing_c_x_operation_sort_filter_sw";
        public static final String SAILING_C_X_PROMPT_MSG_SW = "sailing_c_x_prompt_msg_sw";
    }

    public static final class Instant {
        public static final String HAS_CLICK_INSTANT = "sailing_c_x_rlink_applite_sw";
    }

    public static final class KingKong {
        public static final String SAILING_C_X_CATEGORY_REDFLAG_SW = "sailing_c_x_category_redflag_sw";
        public static final String SAILING_C_X_HOMEPAGE_DIAMOND_BAR_SW = "sailing_c_x_homepage_diamond_bar_sw";
        public static final String SAILING_C_X_HOMEPAGE_DIAMOND_CK = "sailing_c_x_homepage_diamond_ck";
        public static final String SAILING_C_X_HOMEPAGE_DIAMOND_REALEXPOSURE_SW = "sailing_c_x_homepage_diamond_realexposure_sw";
    }

    public static final class LaunchOptimize {
        public static final String LAZY_COMPONENT_SW = "tech_sailing_c_event_lazy_component_sw";
    }

    public static final class LawDialog {
        public static final String SAILING_C_X_LAWWINDOW_AGREE_CK = "sailing_c_x_lawwindow_agree_ck";
        public static final String SAILING_C_X_LAWWINDOW_CANCEL_CK = "sailing_c_x_privacy_popup_cancel_ck";
        public static final String SAILING_C_X_LAWWINDOW_POLICY_CK = "sailing_c_x_lawwindow_policy_ck";
        public static final String SAILING_C_X_LAW_WINDOW_SW = "sailing_c_x_law_window_sw";
        public static final String SAILING_C_X_STARTPAGE_ACTUALIZATION_IMPORTANTE_CK = "sailing_c_x_startpage_actualization_importante_ck";
        public static final String SAILING_C_X_STARTPAGE_ACTUALIZATION_IMPORTANTE_SW = "sailing_c_x_startpage_actualization_importante_sw";
        public static final String SAILING_C_X_STARTPAGE_ACTUALIZATION_IMPORTANTE_TEXTLINK_CK = "sailing_c_x_startpage_actualization_importante_textlink_ck";
        public static final String SAILING_C_X_UPDATE_LAW_WINDOW_AGREE_CK = "sailing_c_x_lgpd_update_popup_accept_ck";
        public static final String SAILING_C_X_UPDATE_LAW_WINDOW_CANCEL_CK = "sailing_c_x_lgpd_update_popup_decline_ck";
        public static final String SAILING_C_X_UPDATE_LAW_WINDOW_POLICY_CK = "sailing_c_x_lgpd_update_popup_link_ck";
        public static final String SAILING_C_X_UPDATE_LAW_WINDOW_SW = "sailing_c_x_lgpd_update_popup_sw";
    }

    public static class Order {
        public static final String ORDER_COMMON_SW = "sailing_c_x_orderdetail_common_sw";
        public static final String ORDER_CONTACT_CK = "sailing_c_x_orderdetail_contact_ck";
        public static final String ORDER_DEBT_ARREARS_PAYMETHOD_CK = "sailing_c_x_arrears_order_paymethod_ck";
        public static final String ORDER_DEBT_ARREARS_PAY_CK = "sailing_c_x_arrears_order_pay_ck";
        public static final String ORDER_DEBT_INIT_CHANNEL_FAILED = "tech_sailing_c_debt_channel_init_failed";
        public static final String ORDER_DEBT_PAY_FAIL_POPUP_CK = "sailing_c_x_arrears_order_fail_popup_ck";
        public static final String ORDER_DEBT_PAY_FAIL_POPUP_SW = "sailing_c_x_arrears_order_fail_popup_sw";
        public static final String ORDER_ORDER_RATE_CLICK = "sailing_c_x_app_ratings_ck";
        public static final String ORDER_ORDER_RATE_SHOW = "sailing_c_x_app_ratings_sw";
        public static final String ORDER_PUSH_REMIND_CK = "sailing_c_ordermsg_push_ck";
        public static final String ORDER_PUSH_REMIND_SW = "sailing_c_ordermsg_push_sw";
        public static final String ORDER_SEND_RECEIPT_CK = "sailing_c_x_orderpage_receipt_send_ck";
        public static final String ORDER_SEND_RECEIPT_SUCCESS_SW = "sailing_c_x_orderpage_receipt_send_success_sw";
        public static final String ORDER_SEND_RECEIPT_SW = "sailing_c_x_orderpage_receipt_sw";
        public static final String SAILING_C_X_EVALUATION_ENTRANCE_CK = "sailing_c_x_evaluation_entrance_ck";
        public static final String SAILING_C_X_MYORDER_RETURN_CK = "sailing_c_x_myorder_return_ck";
        public static final String SAILING_C_X_MYORDER_SHOP_CK = "sailing_c_x_myorder_shop_ck";
        public static final String SAILING_C_X_ORDERDETAIL_REFUND_POPUP_SW = "sailing_c_x_orderdetail_refund_popup_sw";
        public static final String SAILING_C_X_ORDERDETAIL_REFUND_RULE_CK = "sailing_c_x_orderdetail_refund_rule_ck";
        public static final String SAILING_C_X_ORDERDETAIL_REFUND_RULE_CONFIRM_CK = "sailing_c_x_orderdetail_refund_rule_confirm_ck";
        public static final String SAILING_C_X_ORDERDETAIL_REFUND_RULE_POPUP_SW = "sailing_c_x_orderdetail_refund_rule_popup_sw";
        public static final String SAILING_C_X_SIDEBAR_EVALUATE_ABNORMAL_CK = "sailing_c_x_sidebar_evaluate_abnormal_ck";
        public static final String SAILING_C_X_SIDEBAR_EVALUATE_ABNORMAL_SW = "sailing_c_x_sidebar_evaluate_abnormal_sw";
        public static final String SAILING_C_X_SIDEBAR_EVALUATE_PAGE_COMPLETE_CK = "sailing_c_x_evaluation_page_complete_ck";
        public static final String SAILING_C_X_SIDEBAR_EVALUATE_PAGE_LICK_CK = "sailing_c_x_dish_evaluation_page_like_ck";
        public static final String SAILING_C_X_SIDEBAR_EVALUATE_PAGE_RATING_CK = "sailing_c_x_evaluation_page_rating_ck";
        public static final String SAILING_C_X_SIDEBAR_EVALUATE_PAGE_SW = "sailing_c_x_evaluation_page_sw";
        public static final String SAILING_C_X_SIDEBAR_EVALUATE_PAGE_TAG_CK = "sailing_c_x_evaluation_page_tag_ck";
        public static final String SAILING_C_X_SIDEBAR_EVALUATE_PAGE_TEXT_CK = "sailing_c_x_evaluation_page_text_ck";
        public static final String SAILING_C_X_SIDEBAR_EVALUATE_POP_CK = "sailing_c_x_evaluation_detain_pop_ck";
        public static final String SAILING_C_X_SIDEBAR_EVALUATE_POP_SW = "sailing_c_x_evaluation_detain_pop_sw";
    }

    public static final class Pay {
        public static final String EVENT_CLICK_99_PAY_TOP_UP = "sailing_c_x_cartpayment_recharge_ck";
        public static final String EVENT_CLICK_ADD_PAYCARD = "sailing_c_x_cartpayment_addcard_ck";
        public static final String EVENT_CLICK_ADD_PAY_PAY = "sailing_c_x_cartpayment_paypay_add_ck";
        public static final String EVENT_CLICK_ADD_PAY_PAY_SW = "sailing_c_x_cartpayment_paypay_add_sw";
        public static final String EVENT_CLICK_PAYMETHOD_BACK = "sailing_c_x_cartpayment_return_ck";
        public static final String EVENT_CLICK_PAY_PAY = "sailing_c_x_cartpayment_paypay_ck";
        public static final String EVENT_CLICK_PAY_PAY_SW = "sailing_c_x_cartpayment_paypay_sw";
        public static final String EVENT_OPEN_PAYMETHOD_PAGE = "sailing_c_x_cartpayment_common_sw";
        public static final String EVENT_PAY_TIP_DIALOG_CLOSE_CK = "sailing_c_x_confirm_page_close_ck";
        public static final String EVENT_PAY_TIP_DIALOG_CONFIRM_CK = "sailing_c_x_confirm_page_confirmed_ck";
        public static final String EVENT_PAY_TIP_DIALOG_CORRECT_CK = "sailing_c_x_confirm_page_correct_ck";
        public static final String EVENT_PAY_TIP_DIALOG_SW = "sailing_c_x_confirm_page_sw";
        public static final String EVENT_SELECT_CARD_SW = "sailing_c_x_cartpayment_selectcard_sw";
        public static final String EVENT_SELECT_PAYMETHOD = "sailing_c_x_cartpayment_selectcard_ck";
        public static final String TECH_SAILING_C_EVENT_DIDI_PASS_PAY_SW = "tech_sailing_c_event_didi_pass_pay_sw";
    }

    public static final class Performance {
        public static final String LAUNCHWITHOPTIONSROOTVC = "launchWithOptionsRootvc";
        public static final String LAUNCH_DETAIL = "tech_sailing_c_x_launch_detail";
        public static final String LOCATIONMANAGER = "locationManager";
        public static final String PAGE_RENDERING_TIME = "soda_s_page_render_taggle";
        public static final String REQUESTFEEDDATACALLBACK = "requestFeedDataCallback";
        public static final String SODA_S_APP_RUN_DURATION = "tech_sailing_c_app_run_duration";
        public static final String SODA_S_IMG_AVG_LDT = "soda_s_img_avg_ldt";
        public static final String TECH_PAGE_PERFORMANCE = "tech_sailing_c_page_performance";
        public static final String TONE_P_X_FUSION_RENDER_FROM_NATIVE = "tone_p_x_fusion_render_from_native";
    }

    public static final class PopDialog {
        public static final String REDENVELOPE_APP_KILL = "sailing_c_x_redenvelope_app_kill";
        public static final String REDENVELOPE_BUTTON_CK = "sailing_c_x_redenvelope_button_ck";
        public static final String REDENVELOPE_CLOSE_CK = "sailing_c_x_redenvelope_close_ck";
        public static final String REDENVELOPE_COUPON_CK = "sailing_c_x_redenvelope_coupon_ck";
        public static final String REDENVELOPE_EXCHANGE_RESULT = "sailing_c_x_redenvelope_redeem";
        public static final String REDENVELOPE_FETCH = "sailing_c_x_redenvelope_fetch";
        public static final String REDENVELOPE_IMAGE_CK = "sailing_c_x_redenvelope_ck";
        public static final String REDENVELOPE_IMAGE_DOWNLOAD = "sailing_c_x_redenvelope_image_download";
        public static final String REDENVELOPE_PAGE_DESTORY = "sailing_c_x_redenvelope_page_destory";
        public static final String REDENVELOPE_REAL_SW = "sailing_c_x_redenvelope_coupon_realexposure_sw";
        public static final String REDENVELOPE_SHOW = "sailing_c_x_redenvelope_show";
        public static final String REDENVELOPE_SW = "sailing_c_x_redenvelope_sw";
    }

    public static final class Privacy {
        public static final String DOWNLOAD_EMAIL_CHECK_GUIDE_CONFIRM_CK = "sailing_c_x_download_email_guide_confirm_ck";
        public static final String DOWNLOAD_EMAIL_CHECK_GUIDE_SW = "sailing_c_x_download_email_guide_sw";
        public static final String DOWNLOAD_EMAIL_CHECK_GUIDE_VERIFY_CK = "sailing_c_x_download_email_guide_verify_ck";
        public static final String DOWNLOAD_EMAIL_CHECK_POPUP_CK = "sailing_c_x_download_email_check_popup_ck";
        public static final String DOWNLOAD_EMAIL_CHECK_POPUP_SW = "sailing_c_x_download_email_check_popup_sw";
    }

    public static final class Profile {
        public static final String PROFILE_COMMON_SW = "sailing_c_x_profile_common_sw";
        public static final String PROFILE_RETURN_CK = "sailing_c_x_profile_return_ck";
    }

    public static final class Redeem {
        public static final String ON_REDEEM_BTN_CK = "sailing_c_x_auto_exchange_button_ck";
        public static final String ON_REDEEM_PAGE_SHOW = "sailing_c_x_auto_exchange_common_sw";
        public static final String ON_REDEEM_RESULT_BTN_CLICK = "sailing_c_x_auto_exchange_result_button_ck";
        public static final String ON_REDEEM_RESULT_PAGE_SHOW = "sailing_c_x_auto_exchange_result_common_sw";
    }

    public static final class Search {
        public static final String ENTRANCE_BACK_CK = "sailing_c_x_search_return_ck";
        public static final String ENTRANCE_SW = "sailing_c_x_search_common_sw";
        public static final String HISTORY_WORD = "sailing_c_x_search_history_words";
        public static final String HISTORY_WORD_CK = "sailing_c_x_search_clickhistoryword";
        public static final String RECOMMENT_WORD_CK = "sailing_c_x_search_clickhotword";
        public static final String REC_WORD_SW = "sailing_c_x_search_recommend_words";
        public static final String RESULT_SW = "sailing_c_x_searchresult_common_sw";
        public static final String SAILING_C_X_SEARCH_COMMON_CK = "sailing_c_x_search_common_ck";
        public static final String SEARCH_EDITVIEW_CK = "sailing_c_x_search_clicktextbox";
        public static final String SEARCH_WORD_INPUT = "sailing_c_x_search_input";
        public static final String SHOP_BRAND_VIEW_MORE_CK = "sailing_c_x_searchresult_view_more_ck";
        public static final String SHOP_CK = "sailing_c_x_searchresult_shop_ck";
        public static final String SHOP_EXPOSURE = "sailing_c_x_searchresult_realexposure_sw";
        public static final String SHOP_WITH_DISH_CK = "sailing_c_x_searchresult_item_ck";
        public static final String SHOP_WITH_DISH_EXPOSURE = "sailing_c_x_searchresult_item_realexposure_sw";
        public static final String SUGGESTION_ASSOCIATIONAL_CK = "sailing_c_x_search_clickassociationalword";
        public static final String SUGGESTION_CK = "sailing_c_x_sugword_result_ck";
        public static final String SUGGESTION_SW = "sailing_c_x_sugword_result_common_sw";
    }

    public static final class Security {
        public static final String SAILING_C_X_CHECK_WINDOW_CK = "sailing_c_x_check_window_ck";
        public static final String SAILING_C_X_CHECK_WINDOW_SW = "sailing_c_x_check_window_sw";
        public static final String SAILING_C_X_SECURITYCHECK_COMMON_SW = "sailing_c_x_securitycheck_common_sw";
        public static final String SAILING_C_X_SECURITYCHECK_SELECT_CK = "sailing_c_x_securitycheck_select_ck";
    }

    public static final class Setting {
        public static final String LOGIN_CALLBACK_CK = "sailing_c_x_login_callback_ck";
        public static final String LOGIN_COMMON_CK = "sailing_c_x_login_common_ck";
        public static final String SAILING_C_X_SETTING_SIGN_OUT_CK = "sailing_c_x_setting_signout_ck";
        public static final String SETTING_BUTTON_CK = "sailing_c_x_setting_button_ck";
        public static final String SETTING_CLICK_CAMERA_CK = "sailing_c_x_camera_permission_ck";
        public static final String SETTING_CLICK_DISCOUNTS_NEWS_CK = "sailing_c_x_discounts_news_setting_ck";
        public static final String SETTING_CLICK_DISCOUNTS_NEWS_ITEM_CK = "sailing_c_x_discounts_news_setting_type_ck";
        public static final String SETTING_CLICK_DOWNLOAD_PERSONAL_DATA_CK = "sailing_c_x_download_personal_data_ck";
        public static final String SETTING_CLICK_LOCATION_CK = "sailing_c_x_position_permission_ck";
        public static final String SETTING_CLICK_MICROPHONE_CK = "sailing_c_x_microphone_permission_ck";
        public static final String SETTING_CLICK_NOTIFICATION_CK = "sailing_c_x_notification_permission_ck";
        public static final String SETTING_CLICK_PERMISSION_SETTING_CK = "sailing_c_x_system_permission_setting_ck";
        public static final String SETTING_CLICK_PERSONALIZED_CK = "sailing_c_x_personalized_setting_ck";
        public static final String SETTING_CLICK_PERSONALIZED_ITEM_CK = "sailing_c_x_personalized_recommend_ck";
        public static final String SETTING_CLICK_PERSONAL_DATA_CK = "sailing_c_x_personal_data_ck";
        public static final String SETTING_CLICK_PHOTO_CK = "sailing_c_x_photo_album_permission_ck";
        public static final String SETTING_COMMON_SW = "sailing_c_x_setting_common_sw";
        public static final String SETTING_RETURN_CK = "sailing_c_x_setting_return_ck";
    }

    public static final class ShareDialog {
        public static final String SAILING_C_X_SHARE_COMMON_SW = "sailing_c_x_share_common_sw";
        public static final String SAILING_C_X_SHARE_IMAGE_CK = "sailing_c_x_share_image_ck";
    }

    public static final class ShopCateLanding {
        public static final String SAILING_C_X_HOMEPAGE_SECOND_SEARCH_CK = "sailing_c_x_homepage_second_search_ck";
        public static final String SAILING_C_X_SECOND_CATEGORY_SW = "sailing_c_x_second_category_sw";
    }

    public static final class SideBar {
        public static final String SAILING_C_X_SIDEBAR_EVALUATE_DETAIN_POPUP_CK = "sailing_c_x_sidebar_evaluate_detain_popup_ck";
        public static final String SAILING_C_X_SIDEBAR_EVALUATE_DETAIN_POPUP_SW = "sailing_c_x_sidebar_evaluate_detain_popup_sw";
        public static final String SAILING_C_X_SIDEBAR_EVALUATE_POPUP_CK = "sailing_c_x_sidebar_evaluate_popup_ck";
        public static final String SAILING_C_X_SIDEBAR_EVALUATE_POPUP_SW = "sailing_c_x_sidebar_evaluate_popup_sw";
        public static final String SAILING_C_X_SIDEBAR_EVALUATE_SUCCESS_SW = "sailing_c_x_sidebar_evaluate_success_sw";
        public static final String SIDEBAR_BANNER_CK = "sailing_c_x_sidebar_banner_ck";
        public static final String SIDEBAR_BANNER_SW = "sailing_c_x_sidebar_banner_sw";
        public static final String SIDEBAR_COMMON_SW = "sailing_c_x_sidebar_common_sw";
        public static final String SIDEBAR_FUNCTION_CK = "sailing_c_x_sidebar_function_ck";
    }

    public static final class Splash {
        public static final String SPLASH_PERMISSION_RESULT = "sailing_c_x_startup_authority_sw";
    }

    public static final class SplashPrivacyPolicy {
        public static final String SPLASH_PRIVACY_POLICY_CONTINUE_BTN_CLICK = "sailing_c_x_startpage_authority_continue_ck";
        public static final String SPLASH_PRIVACY_POLICY_POLICY_CHECK_CLICK = "sailing_c_x_startpage_authority_secret_check_ck";
        public static final String SPLASH_PRIVACY_POLICY_POLICY_LINK_TEXT_CLICK = "sailing_c_x_startpage_authority_secret_ck";
        public static final String SPLASH_PRIVACY_POLICY_SHOW = "sailing_c_x_startpage_authority_sw";
    }

    public static final class Technology {
        public static final String IN_APP_REVIEW_CK_FAILURE = "tech_global_customer_in_app_review_ck_failure";
        public static final String IN_APP_REVIEW_CK_SUCCESS = "tech_global_customer_in_app_review_ck_success";
        public static final String IN_APP_REVIEW_SW = "tech_global_customer_in_app_review_sw";
        public static final String PAGE_KOTLIN_EVENT = "tech_sailing_c_t_kt_on_event";
        public static final String PAGE_LAUNCH_TIME = "page_launch_time";
        public static final String SAILING_C_X_GOOGLE_PLAY_ERROR = "soda_c_x_google_play_services_error";
        public static final String SAILING_C_X_PAGE_RETURN_CK = "sailing_c_x_page_return_ck";
        public static final String TECH_SAILING_C_GET_EXTRA_DATA_ERROR = "tech_sailing_c_get_extra_data_error";
        public static final String TECH_SAILING_C_STATUS_GET_GPS_EVENT = "tech_sailing_c_status_get_gps_event";
    }

    public static final class TopicActivity {
        public static final String LANDING_ADDRESS_CLICK = "sailing_c_x_top_address_ck";
        public static final String LANDING_NO_SHOP_SW = "sailing_c_x_top_address_none_sw";
        public static final String LANDING_PAGE_FAIL_SHOW = "sailing_c_x_second_activity_fail_sw";
        public static final String LANDING_PAGE_QUIT_POPUP_SW = "sailing_c_x_operation_activity_quit_popup_sw";
        public static final String LANDING_PAGE_SHOW = "sailing_c_x_top_second_common_sw";
        public static final String LANDING_PAGE_TAB_CLICK = "sailing_c_x_second_activity_session_ck";
        public static final String LANDING_RULES_CK = "sailing_c_x_second_activity_rule_ck";
        public static final String LANDING_SHOP_ITEM_CLICK = "sailing_c_x_top_shop_ck";
        public static final String LANDING_SHOP_ITEM_SHOW = "sailing_c_x_top_shop_realexposure_sw";
        public static final String PAGE_SHOW = "sailing_c_x_homepage_sales_promotion_sw";
        public static final String SHOP_ITEM_CLICK = "sailing_c_x_homepage_promotion_shop_ck";
        public static final String SHOP_ITEM_SHOW = "sailing_c_x_homepage_promotion_realexposure_sw";
    }

    public static final class Trace {
        public static final String SAILING_C_K_SYSTEM_ORDER_SLIDING = "sailing_c_k_system_order_sliding";
        public static final String SAILING_C_K_SYSTEM_PAY_TRACE = "sailing_c_k_system_pay_trace";
    }
}
