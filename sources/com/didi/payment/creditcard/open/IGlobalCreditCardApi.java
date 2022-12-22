package com.didi.payment.creditcard.open;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.payment.creditcard.open.DidiGlobalCheckCardData;
import com.didi.payment.creditcard.open.DidiGlobalDeleteCardData;
import com.didi.payment.creditcard.open.DidiGlobalVerifyCardData;
import com.didichuxing.foundation.rpc.RpcService;

public interface IGlobalCreditCardApi {

    public interface PrepareAddCardCallback {
        void onIntentPrepared(Intent intent);
    }

    void checkCardNo(Context context, DidiGlobalCheckCardData.CheckCardParam checkCardParam, RpcService.Callback<DidiGlobalCheckCardData.CheckCardResult> callback);

    void prepareAddCardActivityIntent(Activity activity, DidiGlobalAddCardData.AddCardParam addCardParam, PrepareAddCardCallback prepareAddCardCallback);

    void startAddCreditCardActivity(Activity activity, int i, DidiGlobalAddCardData.AddCardParam addCardParam);

    void startAddCreditCardActivity(Fragment fragment, int i, DidiGlobalAddCardData.AddCardParam addCardParam);

    void startCreditCardDetailActivity(FragmentActivity fragmentActivity, int i, DidiGlobalDeleteCardData.DeleteCardParam deleteCardParam);

    void startVerifyBalanceActivity(Fragment fragment, int i, DidiGlobalVerifyCardData.VerifyCardParam verifyCardParam);

    void startVerifyBalanceActivity(FragmentActivity fragmentActivity, int i, DidiGlobalVerifyCardData.VerifyCardParam verifyCardParam);
}
