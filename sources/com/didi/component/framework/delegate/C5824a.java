package com.didi.component.framework.delegate;

import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.didi.component.business.constant.BffConstants;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.sdk.bff.BffConstants;
import com.didi.travel.psnger.bff.BffConstants;
import com.didi.usercenter.bff.BffConstants;

/* renamed from: com.didi.component.framework.delegate.a */
/* compiled from: BffCarInitManager */
class C5824a {
    C5824a() {
    }

    /* renamed from: a */
    static void m9549a() {
        Bff.getBffConfig().setOpenRequestConcurrentForm(GlobalApolloUtil.getBffIsRequestConcurrentForm());
        String bffRequestsAbnormal = GlobalApolloUtil.getBffRequestsAbnormal();
        if (!TextUtils.isEmpty(bffRequestsAbnormal)) {
            Bff.getBffConfig().setConfig(bffRequestsAbnormal);
        }
        int bffServiceMaximumWaitingTime = GlobalApolloUtil.getBffServiceMaximumWaitingTime();
        if (bffServiceMaximumWaitingTime > 0) {
            Bff.getBffConfig().setServiceMaximunWaitingTime(bffServiceMaximumWaitingTime);
        }
        m9550b();
    }

    /* renamed from: b */
    private static void m9550b() {
        Bff.getBffConfig().addServiceAndAbilityIds(BffConstants.Services.BFF_HOME_POP_RESULT_SERVICE_NEW, new String[]{BffConstants.AbilityID.ABILITY_COUPON_DISPLAY, BffConstants.AbilityID.ABILITY_DRAINAGE_COVER, "passenger/pResGetRuledGlobal", "passenger/pResGetRuledTag", BffConstants.AbilityID.ABILITY_MEMBER_UPGRADE_POP, BffConstants.AbilityID.ABILITY_HOME_AD_ALERT, "expo/passenger"});
        Bff.getBffConfig().addServiceAndAbilityIds(BffConstants.Services.BFF_ESTIMATE_POP_RESULT_SERVICE_NEW, new String[]{BffConstants.AbilityID.ABILITY_NEW_GUIDE_SHOW, "expo/passenger"});
        Bff.getBffConfig().addTagAndAbilityIds("home_config", new String[]{BffConstants.AbilityID.ABILITY_GET_PANEL_CONFIG, BffConstants.AbilityID.ABILITY_GET_CONFIG, BffConstants.AbilityID.ABILITY_ORDER_RECOVER, BffConstants.AbilityID.ABILITY_GET_SAFETY_CONFIG, BffConstants.AbilityID.ABILITY_API_COMPONENT});
        Bff.getBffConfig().addTagAndAbilityIds("order_info", new String[]{BffConstants.AbilityID.ABILITY_GET_CANCEL_FEE_HISTORY, BffConstants.AbilityID.ABILITY_GET_REAL_TIME_PRICE, BffConstants.AbilityID.ABILITY_GET_FENCE_INFO, BffConstants.AbilityID.ABILITY_SET_USERPIN, BffConstants.AbilityID.ABILITY_ORDER_DETAIL, BffConstants.AbilityID.ABILITY_ORDER_STATUS});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_UPDATE_BOARDING_POINT_TAG, new String[]{BffConstants.AbilityID.ABILITY_UPDATE_BOARDING_POINT});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_UPDATE_WAY_POINTS_TAG, new String[]{BffConstants.AbilityID.ABILITY_UPDATE_WAY_POINTS});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_PBAR_RECOMMEND_TAG, new String[]{BffConstants.AbilityID.ABILITY_GET_RECOMMEND_DEST, BffConstants.AbilityID.ABILITY_GET_HOME_COUPON_INFO, BffConstants.AbilityID.ABILITY_COUPON_ASSISTANT_HOME});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_FINISHED_ORDERED_INFO_TAG, new String[]{BffConstants.AbilityID.ABILITY_GET_QUESTIONAIRE, BffConstants.AbilityID.ABILITY_SUBMIT_QUESTIONAIRE, BffConstants.AbilityID.ABILITY_GET_SHAREINFO, BffConstants.AbilityID.ABILITY_FINISH_ORDER_JUDGE});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_EVALUATE_INFO_TAG, new String[]{BffConstants.AbilityID.ABILITY_GET_COMMENTTAG, BffConstants.AbilityID.ABILITY_HAS_COMMENTED, BffConstants.AbilityID.ABILITY_PRE_PAY_TIPS, BffConstants.AbilityID.ABILITY_COMMENT, BffConstants.AbilityID.ABILITY_GET_TIPINFO});
        Bff.getBffConfig().addTagAndAbilityIds("config", new String[]{BffConstants.AbilityID.ABILITY_GET_A3_ID});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_USER_PROFILE_TAG, new String[]{BffConstants.AbilityID.ABILITY_GET_PROFILE});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_ONE_CONF_TAG, new String[]{BffConstants.AbilityID.ABILITY_ONE_CONF});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_CANCEL_ORDER_TAG, new String[]{BffConstants.AbilityID.ABILITY_CANCEL_ORDER});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_CANCEL_TRIP_TAG, new String[]{BffConstants.AbilityID.ABILITY_CANCEL_TRIP});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_CUSTOMER_SERVICE, new String[]{BffConstants.AbilityID.ABILITY_GET_QUESTION_LIST});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_SPLIT_FARE_OWNER, new String[]{BffConstants.AbilityID.ABILITY_SPLIT_FARE_UPDATE_PARTNER});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_SPLIT_FARE_SPLIT, new String[]{BffConstants.AbilityID.ABILITY_SPLIT_FARE_UPDATE});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_PROMO_CODE, new String[]{BffConstants.AbilityID.ABILITY_PROMO_CODE});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_INVITE_PAGE, new String[]{BffConstants.AbilityID.ABILITY_INVITE_PAGE});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_INVITE_LIST, new String[]{BffConstants.AbilityID.ABILITY_INVITE_LIST});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_UNMATCH, new String[]{BffConstants.AbilityID.ABILITY_UNMATCH});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_LOGIN_EMAIL_SUFFIX, new String[]{BffConstants.AbilityID.ABILITY_EMAIL_SUFFIX});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_NEW_CPF_BLOCKING, new String[]{BffConstants.AbilityID.ABILITY_NEW_CPF_BLOCKING});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_SAVE_ADDRESS, new String[]{BffConstants.AbilityID.ABILITY_SAVE_ADDRESS});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_CASH_UNPAY, new String[]{BffConstants.AbilityID.ABILITY_CASH_UNPAY_GET_SIGN});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_CASH_UNPAY, new String[]{BffConstants.AbilityID.ABILITY_CASH_UNPAY_CHOOSE_REPORT});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_SAFETOOLKIT_STATUS, new String[]{BffConstants.AbilityID.ABILITY_SAFETOOLKIT_STATUS});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_MONITOR_STATE, new String[]{BffConstants.AbilityID.ABILITY_MONITOR_STATE});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_MONITOR_USER_STATE, new String[]{BffConstants.AbilityID.ABILITY_MONITOR_USER_STATE});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_MONITOR_REPORT_EVENT, new String[]{BffConstants.AbilityID.ABILITY_MONITOR_REPORT_EVENT});
        Bff.getBffConfig().addTagAndAbilityIds(BffConstants.Tags.BFF_EXPO_PASSENGER, new String[]{"expo/passenger"});
    }
}
