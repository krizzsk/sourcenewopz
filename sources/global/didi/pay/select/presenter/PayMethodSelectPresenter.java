package global.didi.pay.select.presenter;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.Request;
import com.didi.global.fintech.cashier.core.consts.RouterConstKt;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.payment.creditcard.open.DidiGlobalVerifyCardData;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.global.DidiGlobalPayPalData;
import com.didi.sdk.global.DidiGlobalPayPayData;
import com.didi.sdk.util.TextUtil;
import com.didi.unifiedPay.component.manager.PayMethodManager;
import com.didi.unifiedPay.util.DeviceUtil;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.taxis99.R;
import global.didi.pay.select.model.PayMethodItemInfo;
import global.didi.pay.select.model.PayMethodPageInfo;
import global.didi.pay.select.model.RequestPayEvent;
import global.didi.pay.select.view.base.IPayMethodListView;
import org.greenrobot.eventbus.EventBus;

public class PayMethodSelectPresenter {
    private String mCardIndex;
    private FragmentActivity mFragmentActivity;
    private String mInstallmentAddcard;
    private PayMethodItemInfo mPayMethodItemInfo;
    private PayMethodPageInfo mPayMethodPageInfo;
    private IPayMethodListView<PayMethodPageInfo> mView;

    public int getOmegaSource() {
        return 4;
    }

    public PayMethodSelectPresenter(FragmentActivity fragmentActivity) {
        this.mFragmentActivity = fragmentActivity;
    }

    public void initData(PayMethodPageInfo payMethodPageInfo, String str) {
        this.mView.dismissProgressDialog();
        if (payMethodPageInfo == null) {
            this.mView.showEmptyView();
            return;
        }
        this.mPayMethodPageInfo = payMethodPageInfo;
        if (str != null) {
            this.mInstallmentAddcard = str;
        }
        this.mView.showFrozenContent(this.mPayMethodPageInfo.headInfo);
        this.mView.updateContentView(this.mPayMethodPageInfo, this.mInstallmentAddcard);
        if (isAddCardSelected()) {
            EventBus.getDefault().post(this.mPayMethodItemInfo);
        }
    }

    private boolean isAddCardSelected() {
        if (TextUtils.isEmpty(this.mCardIndex)) {
            return false;
        }
        for (PayMethodItemInfo next : this.mPayMethodPageInfo.payMethodList) {
            if (next.channelId == 150 && this.mCardIndex.equals(next.cardIndex) && next.isSelected && next.isEnabled && next.status == 1) {
                this.mPayMethodItemInfo = next;
                return true;
            }
        }
        return false;
    }

    public void setView(IPayMethodListView iPayMethodListView) {
        this.mView = iPayMethodListView;
    }

    public void requestDataFromServer() {
        this.mView.showProgressDialog(this.mFragmentActivity.getResources().getString(R.string.g_payment_loading));
        this.mCardIndex = null;
        RequestPayEvent requestPayEvent = new RequestPayEvent();
        requestPayEvent.type = RequestPayEvent.RequestType.GetPayInfo;
        EventBus.getDefault().post(requestPayEvent);
    }

    public void requestDataFromServer(int i, String str, int i2) {
        this.mView.showProgressDialog(this.mFragmentActivity.getResources().getString(R.string.g_payment_loading));
        if (i2 == 1) {
            this.mCardIndex = str;
        } else {
            this.mCardIndex = null;
        }
        RequestPayEvent requestPayEvent = new RequestPayEvent();
        requestPayEvent.type = RequestPayEvent.RequestType.ChangePayInfo;
        requestPayEvent.channnel = i;
        requestPayEvent.sub_channel = str;
        EventBus.getDefault().post(requestPayEvent);
    }

    public void jumpToCreditCardActivity(PayMethodItemInfo payMethodItemInfo) {
        if (payMethodItemInfo != null) {
            if (payMethodItemInfo.status == 2) {
                DidiGlobalVerifyCardData.VerifyCardParam verifyCardParam = new DidiGlobalVerifyCardData.VerifyCardParam();
                verifyCardParam.cardIndex = payMethodItemInfo.cardIndex;
                verifyCardParam.cardNo = payMethodItemInfo.title;
                DidiCreditCardFactory.createGlobalCreditCardApi().startVerifyBalanceActivity(this.mFragmentActivity, 6, verifyCardParam);
            } else if (payMethodItemInfo.status != 1) {
                if (payMethodItemInfo.status == 3) {
                    DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
                    addCardParam.bindType = 4;
                    addCardParam.isSignAfterOrder = true;
                    addCardParam.productLine = this.mPayMethodPageInfo.productLine;
                    addCardParam.orderId = this.mPayMethodPageInfo.orderId;
                    addCardParam.appId = this.mPayMethodPageInfo.appId;
                    addCardParam.resourceId = "8";
                    addCardParam.productId = this.mPayMethodPageInfo.productId;
                    addCardParam.cardNo = payMethodItemInfo.title;
                    DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity((Activity) this.mFragmentActivity, 1, addCardParam);
                } else if (payMethodItemInfo.status == 0) {
                    DidiGlobalAddCardData.AddCardParam addCardParam2 = new DidiGlobalAddCardData.AddCardParam();
                    addCardParam2.bindType = 4;
                    addCardParam2.isSignAfterOrder = true;
                    addCardParam2.appId = this.mPayMethodPageInfo.appId;
                    addCardParam2.resourceId = "8";
                    addCardParam2.productId = this.mPayMethodPageInfo.productId;
                    addCardParam2.productLine = this.mPayMethodPageInfo.productLine;
                    addCardParam2.orderId = this.mPayMethodPageInfo.orderId;
                    DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity((Activity) this.mFragmentActivity, 1, addCardParam2);
                }
            }
        }
    }

    public void jumpToAddCreditCardActivity() {
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 4;
        addCardParam.isSignAfterOrder = true;
        addCardParam.productLine = this.mPayMethodPageInfo.productLine;
        addCardParam.appId = this.mPayMethodPageInfo.appId;
        addCardParam.resourceId = "8";
        addCardParam.productId = this.mPayMethodPageInfo.productId;
        addCardParam.orderId = this.mPayMethodPageInfo.orderId;
        if (TextUtils.equals(DeviceUtil.getPackageName(this.mFragmentActivity), "com.pay99.wallet")) {
            ((Request) DRouter.build(RouterConstKt.WALLET_BIND_CARD_URI).putExtra(Extend.START_ACTIVITY_REQUEST_CODE, 1)).start(this.mFragmentActivity);
        } else {
            DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity((Activity) this.mFragmentActivity, 1, addCardParam);
        }
    }

    public void jumpToPayPalPage(PayMethodItemInfo payMethodItemInfo) {
        if (payMethodItemInfo != null) {
            DidiGlobalPayPalData.AddPayPalParam addPayPalParam = new DidiGlobalPayPalData.AddPayPalParam();
            addPayPalParam.bindType = 4;
            DidiGlobalPayApiFactory.createDidiPay().startPayPalActivity((Activity) this.mFragmentActivity, 3, addPayPalParam);
        }
    }

    public void jumpToNewPayPalPage(PayMethodItemInfo payMethodItemInfo) {
        if (payMethodItemInfo != null) {
            DidiGlobalPayPalData.AddPayPalParam addPayPalParam = new DidiGlobalPayPalData.AddPayPalParam();
            addPayPalParam.bindType = 4;
            DidiGlobalPayApiFactory.createDidiPay().startAddNewPayPalActivity((Activity) this.mFragmentActivity, addPayPalParam, (DidiGlobalPayPalData.PayPalCallback) new DidiGlobalPayPalData.PayPalCallback() {
                public void onResult(int i, String str) {
                    if (i == 0) {
                        PayMethodSelectPresenter.this.requestDataFromServer(183, "", -1);
                    }
                }
            });
        }
    }

    public void jumpToPayPayPage(PayMethodItemInfo payMethodItemInfo) {
        if (payMethodItemInfo != null) {
            DidiGlobalPayPayData.AddPayPayParam addPayPayParam = new DidiGlobalPayPayData.AddPayPayParam();
            addPayPayParam.bindType = 4;
            DidiGlobalPayApiFactory.createDidiPay().startAddPayPayActivity((Activity) this.mFragmentActivity, addPayPayParam, (DidiGlobalPayPayData.PayPayCallback) new DidiGlobalPayPayData.PayPayCallback() {
                public void onResult(int i, String str) {
                    if (i == 0) {
                        PayMethodSelectPresenter.this.requestDataFromServer(182, "", -1);
                    }
                }
            });
        }
    }

    public void jumpToNineNinePayPage(PayMethodItemInfo payMethodItemInfo, String str) {
        if (payMethodItemInfo != null) {
            if (payMethodItemInfo.depositStatus == 2) {
                OmegaSDK.putGlobalKV(TransGlobalOmegaKey.KEY_WALLET_PAGEID, "cashier");
                if (TextUtils.equals(DeviceUtil.getPackageName(this.mFragmentActivity), "com.pay99.wallet")) {
                    ((Request) DRouter.build(RouterConstKt.WALLET_BALANCE_TOP_UP).putExtra(Extend.START_ACTIVITY_REQUEST_CODE, 8)).start(this.mFragmentActivity);
                } else if (WalletApolloUtil.getTopUpIsNew()) {
                    ((Request) DRouter.build("GuaranaOneTravel://one/ddw_top_up?source=" + str).putExtra(Extend.START_ACTIVITY_REQUEST_CODE, 8)).start(this.mFragmentActivity);
                } else {
                    WalletRouter.gotoTopupOnlinePay(this.mFragmentActivity, 8);
                }
            } else if (payMethodItemInfo.depositStatus == 3) {
                OmegaSDK.putGlobalKV(TransGlobalOmegaKey.KEY_WALLET_PAGEID, "cashier");
                if (TextUtils.equals(DeviceUtil.getPackageName(this.mFragmentActivity), "com.pay99.wallet")) {
                    ((Request) DRouter.build(RouterConstKt.WALLET_BALANCE_SIGN_UP).putExtra(Extend.START_ACTIVITY_REQUEST_CODE, 10)).start(this.mFragmentActivity);
                } else {
                    WalletRouter.gotoTopUpChannelPage(this.mFragmentActivity, 10);
                }
            }
        }
    }

    public String getOmegaAppid() {
        PayMethodPageInfo payMethodPageInfo = this.mPayMethodPageInfo;
        if (payMethodPageInfo == null) {
            return "";
        }
        return payMethodPageInfo.appId;
    }

    public String getOmegaProductid() {
        PayMethodPageInfo payMethodPageInfo = this.mPayMethodPageInfo;
        if (payMethodPageInfo == null) {
            return "";
        }
        return payMethodPageInfo.productId;
    }

    public int getOmegaCardCount() {
        PayMethodPageInfo payMethodPageInfo = this.mPayMethodPageInfo;
        int i = 0;
        if (payMethodPageInfo == null || payMethodPageInfo.payMethodList == null || this.mPayMethodPageInfo.payMethodList.size() == 0) {
            return 0;
        }
        for (PayMethodItemInfo payMethodItemInfo : this.mPayMethodPageInfo.payMethodList) {
            if (payMethodItemInfo.channelId == 150) {
                i++;
            }
        }
        return i >= 1 ? i - 1 : i;
    }

    public int getOmegaClickType(PayMethodItemInfo payMethodItemInfo) {
        if (payMethodItemInfo == null) {
            return 1;
        }
        if (payMethodItemInfo.channelId == 150) {
            return payMethodItemInfo.status == 1 ? 2 : 3;
        }
        if (payMethodItemInfo.channelId == 121) {
            return 3;
        }
        return (payMethodItemInfo.channelId == 120 || payMethodItemInfo.status == 1) ? 2 : 3;
    }

    public String getOmegaDefaultPayment() {
        PayMethodPageInfo payMethodPageInfo = this.mPayMethodPageInfo;
        String str = "";
        if (!(payMethodPageInfo == null || payMethodPageInfo.payMethodList == null || this.mPayMethodPageInfo.payMethodList.size() == 0)) {
            for (PayMethodItemInfo next : this.mPayMethodPageInfo.payMethodList) {
                if (next != null && next.isSelected) {
                    if (TextUtil.isEmpty(str)) {
                        str = str + next.channelId;
                    } else {
                        str = str + "," + next.channelId;
                    }
                }
            }
        }
        return str;
    }

    public String getOmegaDefaultPaymentName() {
        PayMethodPageInfo payMethodPageInfo = this.mPayMethodPageInfo;
        if (payMethodPageInfo == null || payMethodPageInfo.payMethodList == null || this.mPayMethodPageInfo.payMethodList.size() == 0) {
            return "";
        }
        for (PayMethodItemInfo next : this.mPayMethodPageInfo.payMethodList) {
            if (next != null && next.isSelected) {
                return PayMethodManager.getPayMethodFromType(next.channelId);
            }
        }
        return "";
    }

    public boolean getOmegaHas99Balance() {
        PayMethodPageInfo payMethodPageInfo = this.mPayMethodPageInfo;
        if (!(payMethodPageInfo == null || payMethodPageInfo.payMethodList == null || this.mPayMethodPageInfo.payMethodList.size() == 0)) {
            for (PayMethodItemInfo next : this.mPayMethodPageInfo.payMethodList) {
                if (next != null && next.channelId == 190 && next.depositStatus == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public PayMethodItemInfo getSelectItem() {
        PayMethodPageInfo payMethodPageInfo = this.mPayMethodPageInfo;
        if (!(payMethodPageInfo == null || payMethodPageInfo.payMethodList == null || this.mPayMethodPageInfo.payMethodList.size() == 0)) {
            for (PayMethodItemInfo next : this.mPayMethodPageInfo.payMethodList) {
                if (next != null && next.isSelected) {
                    return next;
                }
            }
        }
        return null;
    }
}
