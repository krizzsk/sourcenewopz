package com.didi.sdk.global;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.sdk.global.DidiGlobalCardExpireInterceptData;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.DidiGlobalPayPalData;
import com.didi.sdk.global.DidiGlobalPayPayData;
import com.didi.sdk.global.sign.presenter.PayMethodSelectAdapter;

public interface IDidiGlobalPayApi {
    void startAddCreditCardActivity(Activity activity, int i, DidiGlobalAddCardData.AddCardParam addCardParam);

    void startAddCreditCardActivity(Fragment fragment, int i, DidiGlobalAddCardData.AddCardParam addCardParam);

    void startAddNewPayPalActivity(Activity activity, DidiGlobalPayPalData.AddPayPalParam addPayPalParam, DidiGlobalPayPalData.PayPalCallback payPalCallback);

    void startAddNewPayPalActivity(Fragment fragment, DidiGlobalPayPalData.AddPayPalParam addPayPalParam, DidiGlobalPayPalData.PayPalCallback payPalCallback);

    void startAddPayPayActivity(Activity activity, DidiGlobalPayPayData.AddPayPayParam addPayPayParam, DidiGlobalPayPayData.PayPayCallback payPayCallback);

    void startAddPayPayActivity(Fragment fragment, DidiGlobalPayPayData.AddPayPayParam addPayPayParam, DidiGlobalPayPayData.PayPayCallback payPayCallback);

    void startCardExpireIntercept(Activity activity, DidiGlobalCardExpireInterceptData.CardExpireInterceptParam cardExpireInterceptParam, DidiGlobalCardExpireInterceptData.CardExpireInterceptCallback cardExpireInterceptCallback);

    void startCardExpireIntercept(Fragment fragment, DidiGlobalCardExpireInterceptData.CardExpireInterceptParam cardExpireInterceptParam, DidiGlobalCardExpireInterceptData.CardExpireInterceptCallback cardExpireInterceptCallback);

    @Deprecated
    void startEnterprisePaymentActivity(Activity activity, int i);

    @Deprecated
    void startEnterprisePaymentActivity(Fragment fragment, int i);

    void startPayMethodListActivity(Activity activity, int i, DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam);

    void startPayMethodListActivity(Fragment fragment, int i, DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam);

    void startPayMethodListActivity(Fragment fragment, int i, DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam, PayMethodSelectAdapter payMethodSelectAdapter);

    void startPayPalActivity(Activity activity, int i, DidiGlobalPayPalData.AddPayPalParam addPayPalParam);

    void startPayPalActivity(Fragment fragment, int i, DidiGlobalPayPalData.AddPayPalParam addPayPalParam);

    void startUtilitiesEntranceActivity(Activity activity);

    void verifyPayPal(Context context, String str, DidiGlobalPayPalData.PayPalVerifyCallback payPalVerifyCallback);
}
