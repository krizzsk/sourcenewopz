package com.didi.payment.creditcard.global;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.creditcard.base.encryption.SHA256;
import com.didi.payment.creditcard.global.activity.GlobalCreditCardActivityRouter;
import com.didi.payment.creditcard.global.model.CancelCardParam;
import com.didi.payment.creditcard.global.model.CreditCardModel;
import com.didi.payment.creditcard.global.model.SignCardParam;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.payment.creditcard.open.DidiGlobalCheckCardData;
import com.didi.payment.creditcard.open.DidiGlobalDeleteCardData;
import com.didi.payment.creditcard.open.DidiGlobalVerifyCardData;
import com.didi.payment.creditcard.open.IGlobalCreditCardApi;
import com.didichuxing.foundation.rpc.RpcService;

public class GlobalCreditCardImpl implements IGlobalCreditCardApi {
    public void startAddCreditCardActivity(Activity activity, int i, DidiGlobalAddCardData.AddCardParam addCardParam) {
        if (activity != null && addCardParam != null) {
            GlobalCreditCardActivityRouter.launchAddCardActivity(activity, i, cloneSignCardParam(addCardParam), addCardParam.isShowLoading);
        }
    }

    public void startAddCreditCardActivity(Fragment fragment, int i, DidiGlobalAddCardData.AddCardParam addCardParam) {
        if (fragment != null && addCardParam != null) {
            GlobalCreditCardActivityRouter.launchAddCardActivity(fragment, i, cloneSignCardParam(addCardParam), addCardParam.isShowLoading);
        }
    }

    public SignCardParam cloneSignCardParam(DidiGlobalAddCardData.AddCardParam addCardParam) {
        SignCardParam signCardParam = new SignCardParam();
        signCardParam.bindType = addCardParam.bindType;
        signCardParam.orderId = addCardParam.orderId;
        signCardParam.productLine = addCardParam.productLine;
        signCardParam.isSignAfterOrder = addCardParam.isSignAfterOrder;
        signCardParam.cardNo = addCardParam.cardNo;
        signCardParam.cardIndex = addCardParam.cardIndex;
        signCardParam.resourceId = addCardParam.resourceId;
        signCardParam.discountContent = addCardParam.discountContent;
        signCardParam.extOmegaAttrs = addCardParam.extOmegaAttrs;
        return signCardParam;
    }

    public void startCreditCardDetailActivity(FragmentActivity fragmentActivity, int i, DidiGlobalDeleteCardData.DeleteCardParam deleteCardParam) {
        if (fragmentActivity != null && deleteCardParam != null) {
            CancelCardParam cancelCardParam = new CancelCardParam();
            cancelCardParam.cardIndex = deleteCardParam.cardIndex;
            cancelCardParam.cardNo = deleteCardParam.cardNo;
            cancelCardParam.expiryDate = deleteCardParam.expiryDate;
            cancelCardParam.expired = deleteCardParam.expired;
            cancelCardParam.resourceId = deleteCardParam.resourceId;
            GlobalCreditCardActivityRouter.launchCreditCardDetailActivity(fragmentActivity, i, cancelCardParam);
        }
    }

    public void startVerifyBalanceActivity(FragmentActivity fragmentActivity, int i, DidiGlobalVerifyCardData.VerifyCardParam verifyCardParam) {
        if (fragmentActivity != null && verifyCardParam != null && !TextUtils.isEmpty(verifyCardParam.cardIndex)) {
            GlobalCreditCardActivityRouter.launchCreditCardVerificationActivity(fragmentActivity, i, verifyCardParam);
        }
    }

    public void startVerifyBalanceActivity(Fragment fragment, int i, DidiGlobalVerifyCardData.VerifyCardParam verifyCardParam) {
        if (fragment != null && verifyCardParam != null && !TextUtils.isEmpty(verifyCardParam.cardIndex)) {
            GlobalCreditCardActivityRouter.launchCreditCardVerificationActivity(fragment, i, verifyCardParam);
        }
    }

    public void checkCardNo(Context context, DidiGlobalCheckCardData.CheckCardParam checkCardParam, RpcService.Callback<DidiGlobalCheckCardData.CheckCardResult> callback) {
        if (checkCardParam != null) {
            new CreditCardModel(context).checkCardNo(checkCardParam.cardIndex, checkCardParam.businessId, checkCardParam.cardNo != null ? SHA256.encrypt(checkCardParam.cardNo) : "", callback);
        }
    }

    public void prepareAddCardActivityIntent(Activity activity, DidiGlobalAddCardData.AddCardParam addCardParam, final IGlobalCreditCardApi.PrepareAddCardCallback prepareAddCardCallback) {
        if (activity != null && addCardParam != null) {
            SignCardParam signCardParam = new SignCardParam();
            signCardParam.bindType = addCardParam.bindType;
            signCardParam.orderId = addCardParam.orderId;
            signCardParam.productLine = addCardParam.productLine;
            signCardParam.isSignAfterOrder = addCardParam.isSignAfterOrder;
            signCardParam.cardNo = addCardParam.cardNo;
            signCardParam.cardIndex = addCardParam.cardIndex;
            signCardParam.resourceId = addCardParam.resourceId;
            signCardParam.appId = addCardParam.appId;
            signCardParam.productId = addCardParam.productId;
            GlobalCreditCardActivityRouter.prepareAddCardActivityIntent(activity, signCardParam, addCardParam.isShowLoading, new GlobalCreditCardActivityRouter.PrepareAddCardCallback() {
                public void onIntentPrepared(Intent intent) {
                    IGlobalCreditCardApi.PrepareAddCardCallback prepareAddCardCallback = prepareAddCardCallback;
                    if (prepareAddCardCallback != null) {
                        prepareAddCardCallback.onIntentPrepared(intent);
                    }
                }
            });
        }
    }
}
