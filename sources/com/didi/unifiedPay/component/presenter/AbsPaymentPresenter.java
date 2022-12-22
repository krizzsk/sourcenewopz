package com.didi.unifiedPay.component.presenter;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.global.DidiGlobalPayPalData;
import com.didi.sdk.global.IDidiGlobalPayApi;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.unifiedPay.component.model.DDCreditParam;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.component.model.PayState;
import com.didi.unifiedPay.component.view.IView;
import com.didi.unifiedPay.sdk.internal.PayCallback;
import com.didi.unifiedPay.sdk.internal.PayError;
import com.didi.unifiedPay.sdk.internal.PayServiceCallback;
import com.didi.unifiedPay.sdk.internal.ThreeDSAdyenCallBack;
import com.didi.unifiedPay.sdk.internal.api.IUnifiedPayApi;
import com.didi.unifiedPay.sdk.model.PasswordModel;
import com.didi.unifiedPay.sdk.model.PayInfo;
import com.didi.unifiedPay.sdk.model.PayParamObject;
import com.didi.unifiedPay.sdk.model.PrepayInfo;
import com.didi.unifiedPay.sdk.model.PushMessage;
import com.didi.unifiedPay.sdk.model.SignObj;
import com.didi.unifiedPay.sdk.net.Error;
import com.didi.unifiedPay.util.LogUtil;
import com.didi.unifiedPay.util.UniPayParamUtil;
import global.didi.pay.model.LoadingState;
import global.didi.pay.threeds.model.Adyen3DSModel;
import global.didi.pay.threeds.model.Cybs3DSModel;

public abstract class AbsPaymentPresenter<T extends IView> extends AbsBasePresenter<T> {
    public static final String ACTION_PAY_PUSH_MESSAGE = "ACTION_PAY_PUSH_MESSAGE";
    public static final String EXTRA_PAY_PUSH_MESSAGE = "EXTRA_PAY_PUSH_MESSAGE";
    public static final String PAY_PARAM = "pay_param";
    protected static final int SYC_PAY_STATUS_INTERVAL = 3000;
    private static final String TAG = "AbsPaymentPresenter";
    protected Bundle mBundle;
    /* access modifiers changed from: protected */
    public Context mContext;
    protected PayState mCurrentState;
    protected Fragment mFragment;
    protected FragmentManager mFragmentManager;
    /* access modifiers changed from: protected */
    public PayCallback mPayCallback = new PayCallback() {
        public void onNewPixCode(String str) {
            AbsPaymentPresenter.this.onPixCode(str);
        }

        public void onPaySuccess(int i, String str) {
            LogUtil.m31684d(AbsPaymentPresenter.TAG, "PayCallback paySuccessTraceEvent = " + i);
            AbsPaymentPresenter.this.onPaySuccessed(i, str);
        }

        public void onAdyenThreeDSActionHandle(Adyen3DSModel adyen3DSModel) {
            AbsPaymentPresenter.this.onAdyenThreeDSAction(adyen3DSModel);
        }

        public void onCybsThreeDSActionHandle(Cybs3DSModel cybs3DSModel) {
            AbsPaymentPresenter.this.onCybsThreeDSAction(cybs3DSModel);
        }

        public void onPasswordHandle(PasswordModel passwordModel) {
            AbsPaymentPresenter.this.onPasswordModel(passwordModel);
        }

        public void onPrePayFail(int i, String str) {
            LogUtil.m31684d(AbsPaymentPresenter.TAG, "PayCallback onPrePayFail = " + i);
            AbsPaymentPresenter.this.onPrePayFailed(i, str);
        }

        public void onPrePaySuccess(PrepayInfo prepayInfo) {
            LogUtil.m31684d(AbsPaymentPresenter.TAG, "PayCallback onPrePaySuccess");
            AbsPaymentPresenter.this.onPrePaySuccessed(prepayInfo);
        }

        public void onPayFail(PayError payError, String str) {
            LogUtil.m31684d(AbsPaymentPresenter.TAG, "onPayFail msg" + str);
            AbsPaymentPresenter.this.onPayFailed(payError, str);
        }

        public void onStartPrepayRequest() {
            LogUtil.m31684d(AbsPaymentPresenter.TAG, "PayCallback onStartPrepayRequest");
        }

        public void onQueryPayResult(boolean z, LoadingState loadingState, int i) {
            LogUtil.m31684d(AbsPaymentPresenter.TAG, "PayCallback onQueryPayResult");
            AbsPaymentPresenter.this.onQueryResult(z, loadingState, i);
        }

        public void onStartPayRequest(int i, String str) {
            LogUtil.m31684d(AbsPaymentPresenter.TAG, "PayCallback onStartPayRequest payType = " + i);
            AbsPaymentPresenter.this.onStartPay();
        }

        public void startBindVisaCard(int i) {
            LogUtil.m31684d(AbsPaymentPresenter.TAG, "PayCallback startBindVisaCard requestCode = " + i);
            AbsPaymentPresenter.this.bindVisa(i);
        }

        public void gotoSignPay(int i, int i2, SignObj signObj) {
            LogUtil.m31684d(AbsPaymentPresenter.TAG, "PayCallback gotoSignPay requestCode = " + i);
            if (i2 == 161) {
                AbsPaymentPresenter.this.goSignDDCredit(i, signObj.signUrl);
            }
        }

        public void startBindPayPal(int i, int i2) {
            LogUtil.m31684d(AbsPaymentPresenter.TAG, "PayCallback startBindPayPal requestCode = " + i2);
            if (i == 152) {
                DidiGlobalPayPalData.AddPayPalParam addPayPalParam = new DidiGlobalPayPalData.AddPayPalParam();
                addPayPalParam.bindType = 4;
                if (AbsPaymentPresenter.this.mFragment != null) {
                    DidiGlobalPayApiFactory.createDidiPay().startPayPalActivity(AbsPaymentPresenter.this.mFragment, i2, addPayPalParam);
                } else {
                    DidiGlobalPayApiFactory.createDidiPay().startPayPalActivity((Activity) AbsPaymentPresenter.this.mContext, i2, addPayPalParam);
                }
            } else if (i == 183) {
                DidiGlobalPayPalData.AddPayPalParam addPayPalParam2 = new DidiGlobalPayPalData.AddPayPalParam();
                addPayPalParam2.bindType = 4;
                if (AbsPaymentPresenter.this.mFragment != null) {
                    DidiGlobalPayApiFactory.createDidiPay().startAddNewPayPalActivity(AbsPaymentPresenter.this.mFragment, addPayPalParam2, (DidiGlobalPayPalData.PayPalCallback) new DidiGlobalPayPalData.PayPalCallback() {
                        public void onResult(int i, String str) {
                            AbsPaymentPresenter.this.refreshOrderBillAndAutoPay(183);
                        }
                    });
                } else {
                    DidiGlobalPayApiFactory.createDidiPay().startAddNewPayPalActivity((Activity) AbsPaymentPresenter.this.mContext, addPayPalParam2, (DidiGlobalPayPalData.PayPalCallback) new DidiGlobalPayPalData.PayPalCallback() {
                        public void onResult(int i, String str) {
                            AbsPaymentPresenter.this.refreshOrderBillAndAutoPay(183);
                        }
                    });
                }
            }
        }

        public void startQueryPayStatus() {
            LogUtil.m31684d(AbsPaymentPresenter.TAG, "PayCallback startQueryPayResult");
        }

        public void startActivityForResult(Intent intent, int i) {
            LogUtil.m31684d(AbsPaymentPresenter.TAG, "PayCallback callStartActivityForResult =" + i);
            startActivityForResult(intent, i);
        }
    };
    protected PayParam mPayParam;
    protected PayServiceCallback<PayInfo> mPayinfoCallback = new PayServiceCallback<PayInfo>() {
        public void onSuccess(PayInfo payInfo) {
            LogUtil.m31684d(AbsPaymentPresenter.TAG, "PayServiceCallback onSuccess");
            AbsPaymentPresenter.this.requestPayInfoResult(true, payInfo, "", 0);
            if (payInfo != null && !TextUtils.isEmpty(payInfo.toast_message)) {
                ToastHelper.showLongInfo(AbsPaymentPresenter.this.mContext, payInfo.toast_message);
            }
        }

        public void onFail(Error error) {
            LogUtil.m31684d(AbsPaymentPresenter.TAG, "PayServiceCallback onFail");
            AbsPaymentPresenter.this.requestPayInfoResult(false, (PayInfo) null, error.msg, error.code);
        }
    };
    private AbsPaymentPresenter<T>.PushReceiver mPushReceiver;
    private int mPushStatusCode = -1;
    protected ThreeDSAdyenCallBack mThreeDSAdyenCallBack = new ThreeDSAdyenCallBack() {
        public void onAdyenThreeDSActionHandle(Adyen3DSModel adyen3DSModel) {
            AbsPaymentPresenter.this.onAdyenThreeDSAction(adyen3DSModel);
        }
    };
    /* access modifiers changed from: protected */
    public IUnifiedPayApi mUnifiedPaySystem;

    /* access modifiers changed from: protected */
    public abstract int getBid();

    /* access modifiers changed from: protected */
    public abstract String getOrderId();

    /* access modifiers changed from: protected */
    public void gotoDDCreditSignActivity(DDCreditParam dDCreditParam, int i) {
    }

    /* access modifiers changed from: protected */
    public abstract void initPayApi();

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* access modifiers changed from: protected */
    public abstract void onAdyenThreeDSAction(Adyen3DSModel adyen3DSModel);

    /* access modifiers changed from: protected */
    public abstract void onCybsThreeDSAction(Cybs3DSModel cybs3DSModel);

    /* access modifiers changed from: protected */
    public abstract void onPasswordModel(PasswordModel passwordModel);

    /* access modifiers changed from: protected */
    public abstract void onPayFailed(PayError payError, String str);

    /* access modifiers changed from: protected */
    public abstract void onPaySuccessed(int i, String str);

    /* access modifiers changed from: protected */
    public abstract void onPixCode(String str);

    /* access modifiers changed from: protected */
    public abstract void onPrePayFailed(int i, String str);

    /* access modifiers changed from: protected */
    public void onPrePaySuccessed(PrepayInfo prepayInfo) {
    }

    /* access modifiers changed from: protected */
    public abstract void onQueryResult(boolean z, LoadingState loadingState, int i);

    /* access modifiers changed from: protected */
    public abstract void onStartPay();

    /* access modifiers changed from: protected */
    public void refreshOrderBillAndAutoPay(int i) {
    }

    /* access modifiers changed from: protected */
    public abstract void requestPayInfoResult(boolean z, PayInfo payInfo, String str, int i);

    /* access modifiers changed from: protected */
    public int transRequestCode(int i) {
        return i;
    }

    public AbsPaymentPresenter(Context context, FragmentManager fragmentManager) {
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
    }

    public void setFragment(Fragment fragment) {
        this.mFragment = fragment;
    }

    public void onAdd(Bundle bundle) {
        this.mBundle = bundle;
        this.mCurrentState = PayState.Normal;
        initPayApi();
        registerLocalReceiver();
    }

    public void onRemove() {
        super.onRemove();
        IUnifiedPayApi iUnifiedPayApi = this.mUnifiedPaySystem;
        if (iUnifiedPayApi != null) {
            iUnifiedPayApi.onDestroy();
        }
        unRegisterLocalReceiver();
    }

    /* access modifiers changed from: protected */
    public void onDataClean() {
        PayInfoManager.getInstance(UniPayParamUtil.getLang()).clearData();
    }

    /* access modifiers changed from: protected */
    public void doPay(PayParamObject payParamObject) {
        this.mUnifiedPaySystem.doPay((FragmentActivity) this.mContext, payParamObject, this.mPayCallback);
    }

    /* access modifiers changed from: protected */
    public void getPayInfo() {
        IUnifiedPayApi iUnifiedPayApi = this.mUnifiedPaySystem;
        if (iUnifiedPayApi != null) {
            iUnifiedPayApi.getPayInfo(this.mPayinfoCallback, 20);
        }
    }

    /* access modifiers changed from: protected */
    public void changePayChannel(int i, String str) {
        this.mUnifiedPaySystem.changePayChannel(i, str);
    }

    /* access modifiers changed from: protected */
    public void changePayWithBalance(String str, String str2) {
        this.mUnifiedPaySystem.changePayWithBalance(str, str2);
    }

    /* access modifiers changed from: protected */
    public void changePayInfo(int i) {
        this.mUnifiedPaySystem.changePayInfo(i, this.mPayinfoCallback);
    }

    /* access modifiers changed from: protected */
    public void changeEnterprisePayType(int i) {
        IUnifiedPayApi iUnifiedPayApi;
        if ((i == 21 || i == 20 || i == 0) && (iUnifiedPayApi = this.mUnifiedPaySystem) != null) {
            iUnifiedPayApi.changeEnterprisePayType(i);
        }
    }

    /* access modifiers changed from: protected */
    public void changeCoupon(String str) {
        IUnifiedPayApi iUnifiedPayApi = this.mUnifiedPaySystem;
        if (iUnifiedPayApi != null) {
            iUnifiedPayApi.changeCoupon(str);
        }
    }

    /* access modifiers changed from: protected */
    public void doLoopRequest() {
        IUnifiedPayApi iUnifiedPayApi = this.mUnifiedPaySystem;
        if (iUnifiedPayApi != null) {
            iUnifiedPayApi.startSyncPayResult(15, 3000);
        }
    }

    /* access modifiers changed from: private */
    public void handlePushReceiver(int i, PushMessage pushMessage) {
        if (this.mPushStatusCode != i) {
            this.mPushStatusCode = i;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        onPayFailed(new PayError(0), pushMessage.msg);
                        return;
                    } else if (i != 4) {
                        return;
                    }
                }
                onPaySuccessed(3, "");
                return;
            }
            getPayInfo();
        }
    }

    /* access modifiers changed from: protected */
    public void bindVisa(int i) {
        IDidiGlobalPayApi createDidiPay = DidiGlobalPayApiFactory.createDidiPay();
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 1;
        addCardParam.productLine = "" + getBid();
        addCardParam.orderId = getOrderId();
        addCardParam.isSignAfterOrder = true;
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            createDidiPay.startAddCreditCardActivity(fragment, transRequestCode(i), addCardParam);
        } else {
            createDidiPay.startAddCreditCardActivity((Activity) this.mContext, transRequestCode(i), addCardParam);
        }
    }

    /* access modifiers changed from: protected */
    public void goSignDDCredit(int i, String str) {
        if (!TextUtil.isEmpty(str)) {
            DDCreditParam dDCreditParam = new DDCreditParam();
            dDCreditParam.url = str;
            gotoDDCreditSignActivity(dDCreditParam, i);
        }
    }

    private void registerLocalReceiver() {
        this.mPushReceiver = new PushReceiver();
        LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this.mPushReceiver, new IntentFilter(ACTION_PAY_PUSH_MESSAGE));
    }

    private void unRegisterLocalReceiver() {
        Context context = this.mContext;
        if (context != null && this.mPushReceiver != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.mPushReceiver);
        }
    }

    private class PushReceiver extends BroadcastReceiver {
        private PushReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            PushMessage pushMessage;
            if (intent != null && (pushMessage = (PushMessage) intent.getParcelableExtra(AbsPaymentPresenter.EXTRA_PAY_PUSH_MESSAGE)) != null) {
                if (TextUtil.isEmpty(AbsPaymentPresenter.this.getOrderId()) || AbsPaymentPresenter.this.getOrderId().equals(pushMessage.oid)) {
                    LogUtil.m31685fi(AbsPaymentPresenter.TAG, "PushReceiver code:" + pushMessage.code + " msg:" + pushMessage.msg + " data:" + pushMessage.data + " oid:" + pushMessage.oid + " productId:" + pushMessage.productId);
                    AbsPaymentPresenter.this.handlePushReceiver(pushMessage.code, pushMessage);
                }
            }
        }
    }
}
