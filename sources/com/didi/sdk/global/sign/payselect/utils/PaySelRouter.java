package com.didi.sdk.global.sign.payselect.utils;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.payment.creditcard.open.DidiGlobalDeleteCardData;
import com.didi.payment.creditcard.open.DidiGlobalVerifyCardData;
import com.didi.payment.wallet.global.proxy.PayPalProxy;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.view.activity.WalletMainListActivity;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.enterprise.activity.EnterprisePaymentActivity;
import com.didi.sdk.global.paypal.activity.PayPalRouter;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J,\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/sdk/global/sign/payselect/utils/PaySelRouter;", "", "()V", "jumpTo99TopupAmountPage", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "jumpToCreditCardActivity", "info", "Lcom/didi/sdk/global/sign/model/local/PaySelItemData;", "payMethodListParam", "Lcom/didi/sdk/global/DidiGlobalPayMethodListData$PayMethodListParam;", "extOmegaAttrs", "", "jumpToEnterprisePage", "jumpToPayPalPage", "jumpToTopupChanelPage", "jumpToWalletHomePage", "payment_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PaySelRouter.kt */
public final class PaySelRouter {
    public static final PaySelRouter INSTANCE = new PaySelRouter();

    private PaySelRouter() {
    }

    public final void jumpToPayPalPage(FragmentActivity fragmentActivity, PaySelItemData paySelItemData) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        if (paySelItemData != null) {
            if (paySelItemData.status == 1) {
                PayPalRouter.launchPayPalDetailActivity(fragmentActivity, 4);
            } else {
                PayPalRouter.launchAddPayPalActivity((Activity) fragmentActivity, 3, true);
            }
        }
    }

    public final void jumpToCreditCardActivity(FragmentActivity fragmentActivity, PaySelItemData paySelItemData, DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam, String str) {
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        if (paySelItemData != null) {
            DidiGlobalAddCardData.AddCardParam addCardParam = null;
            String str5 = "1";
            if (paySelItemData.expired == 1) {
                DidiGlobalAddCardData.AddCardParam addCardParam2 = new DidiGlobalAddCardData.AddCardParam();
                if (payMethodListParam != null) {
                    addCardParam = payMethodListParam.addCardParam;
                }
                if (addCardParam != null) {
                    addCardParam2.bindType = payMethodListParam.addCardParam.bindType;
                    addCardParam2.isSignAfterOrder = payMethodListParam.addCardParam.isSignAfterOrder;
                    addCardParam2.productLine = payMethodListParam.addCardParam.productLine;
                    addCardParam2.orderId = payMethodListParam.addCardParam.orderId;
                    addCardParam2.cardNo = paySelItemData.title;
                }
                if (!(payMethodListParam == null || (str4 = payMethodListParam.resourceId) == null)) {
                    str5 = str4;
                }
                addCardParam2.resourceId = str5;
                DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity((Activity) fragmentActivity, 1, addCardParam2);
            } else if (paySelItemData.status == 2) {
                DidiGlobalVerifyCardData.VerifyCardParam verifyCardParam = new DidiGlobalVerifyCardData.VerifyCardParam();
                verifyCardParam.cardIndex = paySelItemData.cardIndex;
                verifyCardParam.cardNo = paySelItemData.title;
                DidiCreditCardFactory.createGlobalCreditCardApi().startVerifyBalanceActivity(fragmentActivity, 6, verifyCardParam);
            } else if (paySelItemData.status == 1) {
                DidiGlobalDeleteCardData.DeleteCardParam deleteCardParam = new DidiGlobalDeleteCardData.DeleteCardParam();
                deleteCardParam.cardIndex = paySelItemData.cardIndex;
                deleteCardParam.cardNo = paySelItemData.title;
                deleteCardParam.expiryDate = paySelItemData.expiryDate;
                if (!(payMethodListParam == null || (str3 = payMethodListParam.resourceId) == null)) {
                    str5 = str3;
                }
                deleteCardParam.resourceId = str5;
                DidiCreditCardFactory.createGlobalCreditCardApi().startCreditCardDetailActivity(fragmentActivity, 2, deleteCardParam);
            } else if (paySelItemData.status == 0) {
                DidiGlobalAddCardData.AddCardParam addCardParam3 = new DidiGlobalAddCardData.AddCardParam();
                if (payMethodListParam != null) {
                    addCardParam = payMethodListParam.addCardParam;
                }
                if (addCardParam != null) {
                    addCardParam3.bindType = payMethodListParam.addCardParam.bindType;
                    addCardParam3.isSignAfterOrder = payMethodListParam.addCardParam.isSignAfterOrder;
                    addCardParam3.productLine = payMethodListParam.addCardParam.productLine;
                    addCardParam3.orderId = payMethodListParam.addCardParam.orderId;
                    addCardParam3.discountContent = PaySelUtilsKt.findDiscountStr(payMethodListParam, "activity_msg");
                    addCardParam3.extOmegaAttrs = str;
                }
                if (!(payMethodListParam == null || (str2 = payMethodListParam.resourceId) == null)) {
                    str5 = str2;
                }
                addCardParam3.resourceId = str5;
                DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity((Activity) fragmentActivity, 1, addCardParam3);
            }
        }
    }

    public final void jumpToEnterprisePage(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        EnterprisePaymentActivity.launch((Activity) fragmentActivity, 5);
    }

    public final void jumpToTopupChanelPage(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        WalletRouter.gotoTopUpChannelPage(fragmentActivity, 10);
    }

    public final void jumpTo99TopupAmountPage(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        WalletRouter.gotoTopupOnlinePay(fragmentActivity, 8);
    }

    public final void jumpToWalletHomePage(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        PayPalProxy.setProxy(new PaySelRouter$jumpToWalletHomePage$1());
        Intent intent = new Intent();
        intent.setClass(fragmentActivity, WalletMainListActivity.class);
        fragmentActivity.startActivityForResult(intent, 9);
    }
}
