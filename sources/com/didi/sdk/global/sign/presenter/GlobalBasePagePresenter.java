package com.didi.sdk.global.sign.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.payment.creditcard.open.DidiGlobalDeleteCardData;
import com.didi.payment.creditcard.open.DidiGlobalVerifyCardData;
import com.didi.payment.wallet.global.proxy.PayPalProxy;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.view.activity.WalletMainListActivity;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.DidiGlobalPayPalData;
import com.didi.sdk.global.DidiGlobalPayPayData;
import com.didi.sdk.global.enterprise.activity.EnterprisePaymentActivity;
import com.didi.sdk.global.paypal.activity.PayPalRouter;
import com.didi.sdk.global.sign.model.convert.SelectPageInfoConverter;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.sdk.global.sign.model.server.PayMethodPageResponse;
import com.didi.sdk.global.sign.model.server.PayMethodRpcModel;
import com.didi.sdk.global.sign.presenter.PayMethodSelectAdapter;
import com.didi.sdk.global.sign.view.IPayMethodListView;
import com.didi.sdk.global.sign.view.helper.GlobalPayOmegaUtils;
import com.didi.sdk.util.ToastHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class GlobalBasePagePresenter {
    protected PayMethodSelectAdapter mAdapter;
    protected FragmentActivity mFragmentActivity;
    protected boolean mHasRequestDataFromServer;
    protected IPayMethodListView<PaySelPageData> mView;

    public void onCreate(Bundle bundle) {
    }

    public void onDestroy() {
    }

    public abstract void onRequestSuccess(PaySelPageData paySelPageData);

    public abstract void onRequestSuccess(PayMethodPageResponse payMethodPageResponse);

    public void refreshDataFromServer(int i, String str) {
    }

    public GlobalBasePagePresenter(FragmentActivity fragmentActivity) {
        this.mFragmentActivity = fragmentActivity;
    }

    public void initPayMethodSelectAdapter(PayMethodSelectAdapter payMethodSelectAdapter) {
        if (payMethodSelectAdapter != null) {
            this.mAdapter = payMethodSelectAdapter;
        } else {
            this.mAdapter = new DefaultPaySelectAdapter();
        }
        this.mAdapter.setObserver(new PayMethodSelectAdapter.AdapterDataObserver() {
            public void onSuccess(DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam) {
                GlobalBasePagePresenter.this.onRequestSuccess(SelectPageInfoConverter.convert(payMethodListParam));
                GlobalBasePagePresenter.this.mView.dismissProgressDialog();
            }

            public void onFailed() {
                GlobalBasePagePresenter.this.mView.dismissProgressDialog();
                GlobalBasePagePresenter.this.mView.showEmptyView();
            }

            public void onFinished() {
                GlobalBasePagePresenter.this.mView.dismissProgressDialog();
            }
        });
    }

    public void setView(IPayMethodListView iPayMethodListView) {
        this.mView = iPayMethodListView;
    }

    public void requestDataFromServer(DidiGlobalPayMethodListData.Entrance entrance) {
        this.mView.showProgressDialog(this.mFragmentActivity.getString(R.string.one_payment_global_net_toast_loading));
        PayMethodSelectAdapter payMethodSelectAdapter = this.mAdapter;
        if (payMethodSelectAdapter != null) {
            payMethodSelectAdapter.refreshPayMethodList(entrance);
        }
    }

    public void jumpToCreditCardActivity(PaySelItemData paySelItemData, DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam) {
        if (paySelItemData != null) {
            String str = "1";
            if (paySelItemData.expired == 1) {
                DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
                if (!(payMethodListParam == null || payMethodListParam.addCardParam == null)) {
                    addCardParam.bindType = payMethodListParam.addCardParam.bindType;
                    addCardParam.isSignAfterOrder = payMethodListParam.addCardParam.isSignAfterOrder;
                    addCardParam.productLine = payMethodListParam.addCardParam.productLine;
                    addCardParam.orderId = payMethodListParam.addCardParam.orderId;
                    addCardParam.cardNo = paySelItemData.title;
                }
                if (payMethodListParam != null && !TextUtils.isEmpty(payMethodListParam.resourceId)) {
                    str = payMethodListParam.resourceId;
                }
                addCardParam.resourceId = str;
                DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity((Activity) this.mFragmentActivity, 1, addCardParam);
            } else if (paySelItemData.status == 2) {
                DidiGlobalVerifyCardData.VerifyCardParam verifyCardParam = new DidiGlobalVerifyCardData.VerifyCardParam();
                verifyCardParam.cardIndex = paySelItemData.cardIndex;
                verifyCardParam.cardNo = paySelItemData.title;
                DidiCreditCardFactory.createGlobalCreditCardApi().startVerifyBalanceActivity(this.mFragmentActivity, 6, verifyCardParam);
            } else if (paySelItemData.status == 1) {
                DidiGlobalDeleteCardData.DeleteCardParam deleteCardParam = new DidiGlobalDeleteCardData.DeleteCardParam();
                deleteCardParam.cardIndex = paySelItemData.cardIndex;
                deleteCardParam.cardNo = paySelItemData.title;
                deleteCardParam.expiryDate = paySelItemData.expiryDate;
                if (payMethodListParam != null && !TextUtils.isEmpty(payMethodListParam.resourceId)) {
                    str = payMethodListParam.resourceId;
                }
                deleteCardParam.resourceId = str;
                DidiCreditCardFactory.createGlobalCreditCardApi().startCreditCardDetailActivity(this.mFragmentActivity, 2, deleteCardParam);
            } else if (paySelItemData.status == 0) {
                DidiGlobalAddCardData.AddCardParam addCardParam2 = new DidiGlobalAddCardData.AddCardParam();
                if (!(payMethodListParam == null || payMethodListParam.addCardParam == null)) {
                    addCardParam2.bindType = payMethodListParam.addCardParam.bindType;
                    addCardParam2.isSignAfterOrder = payMethodListParam.addCardParam.isSignAfterOrder;
                    addCardParam2.productLine = payMethodListParam.addCardParam.productLine;
                    addCardParam2.orderId = payMethodListParam.addCardParam.orderId;
                }
                addCardParam2.discountContent = findDiscountStr(payMethodListParam, "activity_msg");
                if (payMethodListParam != null && !TextUtils.isEmpty(payMethodListParam.resourceId)) {
                    str = payMethodListParam.resourceId;
                }
                addCardParam2.resourceId = str;
                DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity((Activity) this.mFragmentActivity, 1, addCardParam2);
            }
        }
    }

    public void jumpToPayPalPage(PaySelItemData paySelItemData) {
        if (paySelItemData != null) {
            if (paySelItemData.status == 1) {
                PayPalRouter.launchPayPalDetailActivity(this.mFragmentActivity, 4);
            } else {
                PayPalRouter.launchAddPayPalActivity((Activity) this.mFragmentActivity, 3, true);
            }
        }
    }

    public void jumpToPayPalV2Page() {
        DidiGlobalPayPalData.AddPayPalParam addPayPalParam = new DidiGlobalPayPalData.AddPayPalParam();
        addPayPalParam.bindType = 8;
        DidiGlobalPayApiFactory.createDidiPay().startAddNewPayPalActivity((Activity) this.mFragmentActivity, addPayPalParam, (DidiGlobalPayPalData.PayPalCallback) new DidiGlobalPayPalData.PayPalCallback() {
            public void onResult(int i, String str) {
                if (i == 0) {
                    GlobalPayOmegaUtils.trackPayMethodBindPaypalV2Success();
                    GlobalBasePagePresenter.this.refreshDataFromServer(183, "");
                }
            }
        });
    }

    public void jumpToEnterprisePage() {
        EnterprisePaymentActivity.launch((Activity) this.mFragmentActivity, 5);
    }

    public void jumpToPayPayPage() {
        DidiGlobalPayPayData.AddPayPayParam addPayPayParam = new DidiGlobalPayPayData.AddPayPayParam();
        addPayPayParam.bindType = 8;
        DidiGlobalPayApiFactory.createDidiPay().startAddPayPayActivity((Activity) this.mFragmentActivity, addPayPayParam, (DidiGlobalPayPayData.PayPayCallback) new DidiGlobalPayPayData.PayPayCallback() {
            public void onResult(int i, String str) {
                if (i == 0) {
                    ToastHelper.showLongInfo((Context) GlobalBasePagePresenter.this.mFragmentActivity, GlobalBasePagePresenter.this.mFragmentActivity.getString(R.string.one_payment_global_paylist_add_paypay_success), (int) R.drawable.global_ic_toast_success);
                    GlobalBasePagePresenter.this.refreshDataFromServer(182, "");
                }
            }
        });
    }

    public void jumpTo99TopupAmountPage() {
        WalletRouter.gotoTopupOnlinePay(this.mFragmentActivity, 8);
    }

    public void jumpToWalletHomePage() {
        PayPalProxy.setProxy(new PayPalProxy.IPayPalProxy() {
            public void startPayPalActivity(Activity activity, int i) {
                PayPalRouter.launchAddPayPalActivity(activity, i, true);
            }

            public void startPayPalDetailActivity(Activity activity, int i) {
                PayPalRouter.launchPayPalDetailActivity(activity, i);
            }
        });
        Intent intent = new Intent();
        intent.setClass(this.mFragmentActivity, WalletMainListActivity.class);
        this.mFragmentActivity.startActivityForResult(intent, 9);
    }

    public void jumpToTopupChanelPage() {
        WalletRouter.gotoTopUpChannelPage(this.mFragmentActivity, 10);
    }

    public boolean hasRequestDataFromServer() {
        return this.mHasRequestDataFromServer;
    }

    class DefaultPaySelectAdapter extends PayMethodSelectAdapter {
        protected PayMethodRpcModel mModel;

        public DefaultPaySelectAdapter() {
            this.mModel = new PayMethodRpcModel(GlobalBasePagePresenter.this.mFragmentActivity);
        }

        public void refreshPayMethodList(DidiGlobalPayMethodListData.Entrance entrance) {
            this.mModel.requestPayMethodList(new RpcService.Callback<PayMethodPageResponse>() {
                public void onSuccess(PayMethodPageResponse payMethodPageResponse) {
                    GlobalBasePagePresenter.this.onRequestSuccess(payMethodPageResponse);
                    DefaultPaySelectAdapter.this.notifyRefreshFinished();
                }

                public void onFailure(IOException iOException) {
                    DefaultPaySelectAdapter.this.notifyRefreshFailed();
                }
            });
        }
    }

    public String findDiscountStr(DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam, String str) {
        if (payMethodListParam == null || payMethodListParam.list == null) {
            return "";
        }
        for (DidiGlobalPayMethodListData.PayMethodInfo next : payMethodListParam.list) {
            if (next.channelId == 150) {
                String str2 = next.toAddCardInfo;
                if (TextUtils.isEmpty(str2)) {
                    continue;
                } else {
                    try {
                        return new JSONObject(str2).optString(str);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "";
    }
}
