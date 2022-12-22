package com.didi.component.business.constant;

public interface BffConstants {

    public interface AbilityID {
        public static final String ABILITY_CASH_UNPAY_CHOOSE_REPORT = "themis/passengerNoPayChooseReport";
        public static final String ABILITY_CASH_UNPAY_GET_SIGN = "themis/getPassengeNorPaySign";
        public static final String ABILITY_CHECK_VALIDFRIENDLIST = "hulkmgmapi/checkValidFriendList";
        public static final String ABILITY_COMMENT = "iapetos/pComment";
        public static final String ABILITY_COUPON_ASSISTANT_HOME = "passenger-api/pCouponHome";
        public static final String ABILITY_COUPON_DISPLAY = "passenger/pCouponDisplay";
        public static final String ABILITY_CPF_AWARE = "passenger/pCpfAware";
        public static final String ABILITY_DRAINAGE_COVER = "expo/passengerCover";
        public static final String ABILITY_DYNAMIC_CONFIG = "signpost/getFunctionsList";
        public static final String ABILITY_EMAIL_SUFFIX = "experiment/emailsuffix";
        public static final String ABILITY_EXPO = "expo/passenger";
        public static final String ABILITY_FACEBOOK_RISK = "shepherd/facebookRisk";
        public static final String ABILITY_FARE_DOUBT_URL = "optimus-i18n-web/commonAccess";
        public static final String ABILITY_FEE_DETAILS = "passenger/pGetFeeDetail";
        public static final String ABILITY_FINISH_ORDER_JUDGE = "themis/pGetFinishOrderJudge";
        public static final String ABILITY_GETCOMPANYGROUP = "passenger/pGetCompanyGroup";
        public static final String ABILITY_GET_A3_ID = "passenger/pGetA3";
        public static final String ABILITY_GET_CANCEL_REASON = "themis/getCancelReasonList";
        public static final String ABILITY_GET_COMMENTTAG = "iapetos/pGetCommentTag";
        public static final String ABILITY_GET_CONFIG = "conf/pGetConfig";
        public static final String ABILITY_GET_FENCE_INFO = "passenger/pGetFenceInfo";
        public static final String ABILITY_GET_HOME_COUPON_INFO = "passenger/pGetHomeCouponInfo";
        public static final String ABILITY_GET_ORDER_BAN_INFO = "passenger/pOrderBan";
        public static final String ABILITY_GET_PANEL_CONFIG = "conf/pGetPanelConfig";
        public static final String ABILITY_GET_QUESTIONAIRE = "iapetos/pGetQuestionaire";
        public static final String ABILITY_GET_QUESTION_LIST = "service/sGetQuestionList";
        public static final String ABILITY_GET_RECOMMEND_DEST = "passenger/pGetRecommendDest";
        public static final String ABILITY_GET_RULED_GLOBAL = "passenger/pResGetRuledGlobal";
        public static final String ABILITY_GET_RULED_TAG = "passenger/pResGetRuledTag";
        public static final String ABILITY_GET_SHAREINFO = "passenger/pGetShareInfo";
        public static final String ABILITY_GET_TIPINFO = "passenger/pGetTipInfo";
        public static final String ABILITY_HAS_COMMENTED = "iapetos/pHasCommented";
        public static final String ABILITY_HOME_AD_ALERT = "passenger/pADAlert";
        public static final String ABILITY_INVITE_LIST = "hulkmgmapi/ReferRelationList";
        public static final String ABILITY_INVITE_PAGE = "hulkmgmapi/inviteFriend";
        public static final String ABILITY_JARVIS_STATUS = "heimdallr/pJarvisSafetoolkit";
        public static final String ABILITY_MEMBER_UPGRADE_POP = "passenger/pMemberUpgradePop";
        public static final String ABILITY_MONITOR_REPORT_EVENT = "dexter/passengerRecord";
        public static final String ABILITY_MONITOR_STATE = "heimdallr/pMonitorState";
        public static final String ABILITY_MONITOR_USER_STATE = "heimdallr/pBubbleReport";
        public static final String ABILITY_NEW_CPF_BLOCKING = "experiment/pftCpf";
        public static final String ABILITY_NEW_CPF_BLOCKING_V2 = "experiment/pftCpfV2";
        public static final String ABILITY_NEW_GUIDE_SHOW = "confucius/selectItemPopContent";
        public static final String ABILITY_NEW_MULTIPRICE = "passenger_MultiEstimatePrice";
        public static final String ABILITY_PRE_PAY_TIPS = "passenger/pPrePayTips";
        public static final String ABILITY_PROMO_CODE = "hercules/nativeRedeem";
        public static final String ABILITY_RISK_VERIFY_LIST = "shepherd/pVerifyList";
        public static final String ABILITY_SAFETOOLKIT_STATUS = "heimdallr/pSafetoolkit";
        public static final String ABILITY_SAVE_ADDRESS = "experiment/useaddress";
        public static final String ABILITY_SECOND_CONF = "ibt-falcon-navigation/rideHome2ndMenu";
        public static final String ABILITY_SET_USERPIN = "passenger/pSetUserPin";
        public static final String ABILITY_SPLIT_FARE_UPDATE = "passenger/pUpdateSplitFareInfo";
        public static final String ABILITY_SPLIT_FARE_UPDATE_PARTNER = "passenger/pUpdateSplitFarePartner";
        public static final String ABILITY_SUBMIT_CANCEL_REASON = "themis/saveCancelReason";
        public static final String ABILITY_SUBMIT_QUESTIONAIRE = "iapetos/pSubmitQuestionaire";
        public static final String ABILITY_UNMATCH = "iapetos/unmatch";
        public static final String ABILITY_UPDATE_BOARDING_POINT = "passenger/pUpdateBoardingPoint";
        public static final String ABILITY_UPDATE_WAY_POINTS = "passenger/pUpdateWayPoints";
        public static final String ABLITY_TRIP_BUY = "ibt-vip-member/confirmBuy";
    }

    public interface Services {
        public static final String BFF_ESTIMATE_POP_RESULT_SERVICE = "passenger/pEstimatePopResult";
        public static final String BFF_ESTIMATE_POP_RESULT_SERVICE_NEW = "passenger/pNewEstimatePopResult";
        public static final String BFF_HOME_POP_RESULT_SERVICE = "passenger/pHomePopResult";
        public static final String BFF_HOME_POP_RESULT_SERVICE_NEW = "passenger/pNewHomePopResult";
    }

    public interface Tags {
        public static final String BFF_CASH_UNPAY = "bff_cash_unpay";
        public static final String BFF_CONFIG_TAG = "config";
        public static final String BFF_CUSTOMER_SERVICE = "bff_customer_service";
        public static final String BFF_EVALUATE_INFO_TAG = "evaluate_info";
        public static final String BFF_EXPO_PASSENGER = "bff_expo_passenger";
        public static final String BFF_FINISHED_ORDERED_INFO_TAG = "finished_order_info";
        public static final String BFF_HOME_CONFIG_TAG = "home_config";
        public static final String BFF_INVITE_LIST = "bff_invite_list";
        public static final String BFF_INVITE_PAGE = "bff_invite_page";
        public static final String BFF_JARVIS_STATUS = "bff_javris_status";
        public static final String BFF_LOGIN_EMAIL_SUFFIX = "bff_login_email_suffix";
        public static final String BFF_MONITOR_REPORT_EVENT = "bff_monitor_report_event";
        public static final String BFF_MONITOR_STATE = "bff_monitor_state";
        public static final String BFF_MONITOR_USER_STATE = "bff_monitor_user_state";
        public static final String BFF_NEW_CPF_BLOCKING = "new_cpf_blocking";
        public static final String BFF_ORDER_INFO_TAG = "order_info";
        public static final String BFF_PBAR_RECOMMEND_TAG = "pbar_recommend";
        public static final String BFF_PROMO_CODE = "bff_promo_code";
        public static final String BFF_SAFETOOLKIT_STATUS = "bff_safetoolkit_status";
        public static final String BFF_SAVE_ADDRESS = "bff_save_address";
        public static final String BFF_SPLIT_FARE_OWNER = "bff_split_fare_owner";
        public static final String BFF_SPLIT_FARE_SPLIT = "bff_split_fare_split";
        public static final String BFF_UNMATCH = "bff_unmatch";
        public static final String BFF_UPDATE_BOARDING_POINT_TAG = "update_boarding_point";
        public static final String BFF_UPDATE_WAY_POINTS_TAG = "update_way_points";
        public static final String BFF_USER_PROFILE_TAG = "user_profile";
    }
}
