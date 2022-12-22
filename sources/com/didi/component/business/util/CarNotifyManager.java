package com.didi.component.business.util;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.core.model.response.DTSDKCurrency;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.didi.travel.psnger.utils.NumberUtil;
import com.taxis99.R;

public class CarNotifyManager {

    /* renamed from: a */
    private static final int f11372a = 10030;

    /* renamed from: a */
    private static boolean m7700a() {
        return false;
    }

    public static void waitRspTimeoutNotify(Context context) {
        NotificationUtils.getInstance(context).showNotification(ResourcesHelper.getString(context, R.string.car_noti_title_no_driver_rsp), ResourcesHelper.getString(context, R.string.car_wait_rsp_timeout));
    }

    public static void waitRspShowTimeNotify(Context context, String str) {
        String str2;
        String string = context.getString(R.string.car_notify_wait_title);
        if (GlobalApolloUtil.isNewWaitRspPushContent()) {
            str2 = context.getString(R.string.car_wait_rsp_al_tip_new);
        } else {
            str2 = context.getString(R.string.car_wait_rsp_al_tip, new Object[]{str});
        }
        NotificationUtils.getInstance(context).showNotification(string, HighlightUtil.highlight(context, str2), true, true);
    }

    public static void waitRspWaitOrNotNotify(Context context, String str, String str2) {
        if (str == null || str.isEmpty()) {
            str = context.getString(R.string.wait_or_not_push_title);
        }
        String str3 = str;
        if (str2 == null || str2.isEmpty()) {
            str2 = context.getString(R.string.wait_or_not_push_content);
        }
        NotificationUtils.getInstance(context).showNotification(10030, str3, HighlightUtil.highlight(context, str2), false, false, false, (String) null);
    }

    public static void assignOrderNotify(Context context, String str) {
        NotificationUtils.getInstance(context).showNotification(ResourcesHelper.getString(context, R.string.global_carpool_waitrsp_ridestatus_title_another), HighlightUtil.highlight(context, str));
    }

    public static void buildPickUpNotificationRealtime(Context context, String str, String str2) {
        String string = context.getString(R.string.car_noti_title_pick_up);
        String string2 = context.getString(R.string.car_noti_content_pick_up, new Object[]{str, str2});
        if (m7700a()) {
            NotificationUtils.getInstance(context).showNotificationNoSound(HighlightUtil.highlight(context, string), HighlightUtil.highlight(context, string2));
        }
    }

    public static void buildPickUpNotificationBooking(Context context, long j, String str, String str2) {
        String monthDayAndHourMinute = I18NUtils.getMonthDayAndHourMinute(j);
        NotificationUtils.getInstance(context).showNotificationNoSound(HighlightUtil.highlight(context, context.getString(R.string.car_noti_title_pick_up_booking)), HighlightUtil.highlight(context, context.getString(R.string.car_noti_content_pick_up_booking, new Object[]{monthDayAndHourMinute})));
    }

    public static void buildWaitForArrivalAfter30(Context context, long j, String str, String str2) {
        String monthDayAndHourMinute = I18NUtils.getMonthDayAndHourMinute(j);
        NotificationUtils.getInstance(context).showNotification(HighlightUtil.highlight(context, context.getString(R.string.car_noti_title_driver_arrival_after30)), HighlightUtil.highlight(context, context.getString(R.string.car_noti_content_driver_arrival_after30, new Object[]{monthDayAndHourMinute, str, str2})));
    }

    public static void pickUpEtaNotify(Context context, int i, int i2) {
        String string = context.getString(R.string.car_noti_title_pick_up);
        String formatDistance = I18NUtils.formatDistance((double) i, 1);
        if (i2 <= 0) {
            i2 = 1;
        }
        NotificationUtils.getInstance(context).showNotification(HighlightUtil.highlight(context, string), HighlightUtil.highlight(context, context.getString(R.string.car_noti_wait_arrival_eta, new Object[]{formatDistance, String.valueOf(i2)})), true, false);
    }

    public static void driverArrivedNotification(Context context, String str, String str2, DTSDKOrderDetail.DTSDKPushInfo dTSDKPushInfo) {
        String string = context.getString(R.string.car_noti_title_driver_arrived);
        String string2 = context.getString(R.string.car_noti_content_driver_arrived, new Object[]{str, str2});
        if (dTSDKPushInfo != null && dTSDKPushInfo.isServiceControl == 1 && dTSDKPushInfo.passengerLateTime > 0) {
            string2 = context.getString(R.string.car_noti_content_driver_arrived_control, new Object[]{str, str2, I18NUtils.getHourMinute(dTSDKPushInfo.passengerLateTime)});
        }
        if (m7700a()) {
            NotificationUtils.getInstance(context).showNotification(HighlightUtil.highlight(context, string), HighlightUtil.highlight(context, string2));
        }
    }

    public static void buildPassengerLateNotify(Context context) {
        NotificationUtils.getInstance(context).showNotification(HighlightUtil.highlight(context, context.getString(R.string.car_noti_title_driver_arrived)), HighlightUtil.highlight(context, context.getString(R.string.car_noti_content_passenger_late)));
    }

    public static void buildInServiceNotifyParams(Context context, String str, String str2, DTSDKCurrency dTSDKCurrency) {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            str3 = ResourcesHelper.getString(context, R.string.car_noti_onservice_to_endaddress, str);
        } else {
            str3 = context.getString(R.string.car_noti_title_onservice);
        }
        NotificationUtils.getInstance(context).showNotification(HighlightUtil.highlight(context, str3), HighlightUtil.highlight(context, m7697a(context, str2, dTSDKCurrency)), true, true);
    }

    public static void buildInServiceNotifyParamsWithOutContent(Context context, String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            str2 = ResourcesHelper.getString(context, R.string.car_noti_onservice_to_endaddress, str);
        } else {
            str2 = context.getString(R.string.car_noti_title_onservice);
        }
        NotificationUtils.getInstance(context).showNotification(HighlightUtil.highlight(context, str2), (CharSequence) null, true, true);
    }

    /* renamed from: a */
    private static String m7697a(Context context, String str, DTSDKCurrency dTSDKCurrency) {
        if (TextUtil.isEmpty(str) || dTSDKCurrency == null) {
            return ResourcesHelper.getString(context, R.string.car_noti_onservice_oncount_price);
        }
        return ResourcesHelper.getString(context, R.string.car_noti_onservice_oning_price, I18NUtils.getCurrency((double) NumberUtil.strToFloat(str).floatValue(), true));
    }

    public static void buildPayNotify(Context context) {
        LoggerFactory.getLogger("CarNotifyManager").info("lmf buildPayNotify ", new Object[0]);
        NotificationUtils.getInstance(context).showNotification(ResourcesHelper.getString(context, R.string.car_noti_default_title, NationTypeUtil.getNationComponentData().getBrand()), new String(ResourcesHelper.getString(context, R.string.car_noti_endservice_pay_title)));
    }

    /* renamed from: a */
    private static void m7699a(Context context, String str, boolean z) {
        String str2;
        String str3;
        if (GlobalApolloUtil.isNewEvaluate()) {
            str3 = ResourcesHelper.getString(context, R.string.car_noti_title_pay_success_new_evaluate);
            if (GlobalApolloUtil.isNewEvaluatePushContent()) {
                str2 = ResourcesHelper.getString(context, R.string.car_noti_content_pay_success_new_evaluate_new);
            } else {
                str2 = ResourcesHelper.getString(context, R.string.car_noti_content_pay_success_new_evaluate);
            }
        } else {
            String string = ResourcesHelper.getString(context, R.string.car_noti_title_pay_success_online);
            String string2 = context.getString(R.string.car_noti_content_pay_success_online, new Object[]{str, NationTypeUtil.getNationComponentData().getBrand()});
            if (z) {
                str2 = string2 + " " + context.getString(R.string.car_noti_content_end_service_online_enterprise);
            } else {
                str2 = string2;
            }
            str3 = string;
        }
        NotificationUtils.getInstance(context).showNotification(str3, HighlightUtil.highlight(context, str2), false, true);
    }

    public static void buildPaySuccessNotify(BusinessContext businessContext, Context context, String str, String str2, String str3, String str4, boolean z) {
        Context context2 = context;
        boolean z2 = z;
        double doubleValue = NumberUtil.strToDouble(str3).doubleValue();
        double doubleValue2 = NumberUtil.strToDouble(str).doubleValue();
        if (doubleValue2 > 0.0d) {
            BusinessContext businessContext2 = businessContext;
            String feeDisplay = PriceUtils.getFeeDisplay(businessContext2, doubleValue, str4, false, PriceUtils.TYPE_ORDER_COUPON_FEE);
            String feeDisplay2 = PriceUtils.getFeeDisplay(businessContext2, doubleValue2, str2, false, PriceUtils.TYPE_ORDER_ACTUAL_PAY_MONEY);
            if (doubleValue <= 0.0d) {
                m7699a(context2, feeDisplay2, z2);
                return;
            }
            String string = ResourcesHelper.getString(context2, R.string.car_noti_title_pay_success_online);
            String string2 = context2.getString(R.string.car_noti_content_pay_success_online_deduction, new Object[]{feeDisplay2, feeDisplay, NationTypeUtil.getNationComponentData().getBrand()});
            if (z2) {
                string2 = string2 + " " + context2.getString(R.string.car_noti_content_end_service_online_enterprise);
            }
            NotificationUtils.getInstance(context).showNotification(string, HighlightUtil.highlight(context2, string2), false, true);
        }
    }

    public void buildPayFailNotify(Context context, String str, String str2) {
        NotificationUtils.getInstance(context).showNotification(str, str2, false);
    }

    public static void hideNotify(Context context) {
        NotificationUtils.getInstance(context).hideNotification();
    }

    public static void driverCancelTripNotification(Context context) {
        String string = context.getString(R.string.car_noti_title_driver_cancel_trip);
        String string2 = context.getString(R.string.car_noti_content_driver_cancel_trip);
        if (m7700a()) {
            NotificationUtils.getInstance(context).showNotification(string, string2);
        }
    }

    public static void autoPayFailNotification(Context context) {
        NotificationUtils.getInstance(context).showNotification(context.getString(R.string.car_noti_title_auto_pay_fail), context.getString(R.string.car_noti_content_auto_pay_fail));
    }

    /* renamed from: a */
    private static void m7698a(Context context, String str) {
        NotificationUtils.getInstance(context).showNotification(HighlightUtil.highlight(context, context.getString(R.string.car_noti_title_end_service_cash)), HighlightUtil.highlight(context, context.getString(R.string.car_noti_content_end_service_cash, new Object[]{str, NationTypeUtil.getNationComponentData().getBrand()})), false, true);
    }

    public static void endServiceWithCashNotification(BusinessContext businessContext, Context context, String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        Context context2 = context;
        double parseDouble = Double.parseDouble(str3);
        double parseDouble2 = Double.parseDouble(str);
        if (parseDouble2 > 0.0d) {
            BusinessContext businessContext2 = businessContext;
            String feeDisplay = PriceUtils.getFeeDisplay(businessContext2, parseDouble, str4, false, PriceUtils.TYPE_ORDER_COUPON_FEE);
            String feeDisplay2 = PriceUtils.getFeeDisplay(businessContext2, parseDouble2, str2, false, PriceUtils.TYPE_ORDER_ACTUAL_PAY_MONEY);
            if (parseDouble <= 0.0d) {
                m7698a(context2, feeDisplay2);
                return;
            }
            if (GlobalApolloUtil.isNewEvaluate()) {
                str6 = ResourcesHelper.getString(context2, R.string.car_noti_title_pay_success_new_evaluate);
                if (GlobalApolloUtil.isNewEvaluatePushContent()) {
                    str5 = ResourcesHelper.getString(context2, R.string.car_noti_content_pay_success_new_evaluate_new);
                } else {
                    str5 = ResourcesHelper.getString(context2, R.string.car_noti_content_pay_success_new_evaluate);
                }
            } else {
                String string = context2.getString(R.string.car_noti_title_end_service_cash);
                String str7 = string;
                str5 = context2.getString(R.string.car_noti_content_end_service_cash_deduction, new Object[]{feeDisplay, feeDisplay2, NationTypeUtil.getNationComponentData().getBrand()});
                str6 = str7;
            }
            NotificationUtils.getInstance(context).showNotification(HighlightUtil.highlight(context2, str6), HighlightUtil.highlight(context2, str5), false, true);
        }
    }
}
