package com.didi.soda.pay;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.payment.paymethod.open.callback.SignCallback;
import com.didi.payment.paymethod.open.param.SignParam;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.customer.app.constant.AppConst;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.PayMethodListInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.AppsFlyerTrackHelper;
import com.didi.soda.customer.foundation.tracker.FirebaseAnalyticsHelper;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.repo.CustomerActivityResultRepo;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.manager.base.ICustomerBillManager;
import com.didi.soda.pay.Contract;
import com.didi.soda.pay.model.PayMethodInfoModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PayMethodPresenter extends Contract.AbsPayMethodPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public PayChannelEntity f43630a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f43631b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f43632c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f43633d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<PayMethodInfoModel> f43634e = new ArrayList();

    /* renamed from: f */
    private boolean f43635f = false;

    public void onClose() {
        PayOmegaHelper.closePay(getScopeContext(), m30928b());
    }

    public void onClickCashPay(PayMethodInfoModel payMethodInfoModel) {
        PayChannelEntity payChannelEntity = new PayChannelEntity();
        payChannelEntity.channelId = Integer.parseInt(payMethodInfoModel.mChannelId);
        payChannelEntity.cardOrg = payMethodInfoModel.mIconUrl;
        payChannelEntity.channelName = payMethodInfoModel.mChannelName;
        payChannelEntity.combinedChannelList = payMethodInfoModel.mCombinedChannelList;
        this.f43630a = payChannelEntity;
        m30925a();
        trackSelectCard(payChannelEntity);
        onPayMethodSelect(payChannelEntity);
    }

    public void onClickCardPay(PayMethodInfoModel payMethodInfoModel, PayMethodInfoModel.CardInfoModel cardInfoModel) {
        if (cardInfoModel.mDataType == 2) {
            m30927a(payMethodInfoModel.mSaveString);
        } else if (cardInfoModel.needExValidate == 1) {
            ValidateCardHelper.Companion.validateCard(cardInfoModel.cardSuffix, cardInfoModel.cardIndex, 101);
        } else {
            PayChannelEntity payChannelEntity = new PayChannelEntity();
            payChannelEntity.channelId = Integer.parseInt(payMethodInfoModel.mChannelId);
            payChannelEntity.cardSuffix = cardInfoModel.cardSuffix;
            payChannelEntity.alias = cardInfoModel.alias;
            payChannelEntity.cardIndex = cardInfoModel.cardIndex;
            payChannelEntity.cardOrg = cardInfoModel.cardOrg;
            payChannelEntity.cardName = cardInfoModel.cardName;
            payChannelEntity.cardType = cardInfoModel.cardType;
            this.f43630a = payChannelEntity;
            m30925a();
            trackSelectCard(payChannelEntity);
            onPayMethodSelect(payChannelEntity);
        }
    }

    public void onClickDidiCashPay(PayMethodInfoModel payMethodInfoModel) {
        PayChannelEntity payChannelEntity = new PayChannelEntity();
        payChannelEntity.channelId = Integer.parseInt(payMethodInfoModel.mChannelId);
        payChannelEntity.cardOrg = payMethodInfoModel.mIconUrl;
        payChannelEntity.channelName = payMethodInfoModel.mChannelName;
        this.f43630a = payChannelEntity;
        m30925a();
        trackSelectCard(payChannelEntity);
        onPayMethodSelect(payChannelEntity);
    }

    public void onClickPayPay(PayMethodInfoModel payMethodInfoModel) {
        if (payMethodInfoModel.mIsSigned == 1) {
            BillOmegaHelper.Companion.clickPayPay(this.f43632c, this.f43631b);
            PayChannelEntity payChannelEntity = new PayChannelEntity();
            payChannelEntity.channelId = Integer.parseInt(payMethodInfoModel.mChannelId);
            payChannelEntity.balance = payMethodInfoModel.mBalance;
            payChannelEntity.cardOrg = payMethodInfoModel.mIconUrl;
            this.f43630a = payChannelEntity;
            m30925a();
            trackSelectCard(payChannelEntity);
            onPayMethodSelect(payChannelEntity);
            return;
        }
        BillOmegaHelper.Companion.clickAddPayPay(this.f43632c, this.f43631b);
        SignParam signParam = new SignParam();
        signParam.channelId = Integer.parseInt(payMethodInfoModel.mChannelId);
        signParam.bindType = 14;
        BindCardHelper.bindPayPay(getScopeContext(), signParam, new SignCallback() {
            public void onPullStart() {
            }

            public void onResult(int i, String str, String str2) {
                if (i == 1 || i == 0) {
                    PayMethodPresenter.this.m30931c();
                    return;
                }
                if (!TextUtils.isEmpty(str)) {
                    ToastUtil.showCustomerErrorToast(PayMethodPresenter.this.getScopeContext(), str);
                }
                PayOmegaHelper.bindPayPayFail(i, str);
            }
        });
    }

    public void onClick99Pay(PayMethodInfoModel payMethodInfoModel, int i) {
        if (i == 0) {
            PayChannelEntity payChannelEntity = new PayChannelEntity();
            payChannelEntity.channelId = Integer.parseInt(payMethodInfoModel.mChannelId);
            payChannelEntity.balance = payMethodInfoModel.mBalance;
            payChannelEntity.cardOrg = payMethodInfoModel.mIconUrl;
            this.f43630a = payChannelEntity;
            m30925a();
            trackSelectCard(payChannelEntity);
            onPayMethodSelect(payChannelEntity);
        } else if (i == 1) {
            if (payMethodInfoModel.mIsBindCard == 1) {
                WalletRouter.gotoTopupOnlinePay((FragmentActivity) getContext(), 8);
            } else {
                WalletRouter.gotoTopUpChannelPage(getContext(), 10);
            }
            this.f43635f = true;
            BillOmegaHelper.Companion.clickTopup(this.f43632c, this.f43631b);
        } else if (i == 2) {
            DidiGlobalPayApiFactory.createDidiPay().startPayMethodListActivity((Activity) getContext(), 1, new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_SIDEBAR));
            this.f43635f = true;
        }
    }

    public void trackSelectCard(PayChannelEntity payChannelEntity) {
        if (payChannelEntity != null) {
            BillOmegaHelper.Companion.selectCard(this.f43632c, this.f43631b, Integer.valueOf(payChannelEntity.channelId), payChannelEntity.cardSuffix);
        } else {
            BillOmegaHelper.Companion.selectCard(this.f43632c, this.f43631b, -1, "");
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        this.f43630a = (PayChannelEntity) getScopeContext().getBundle().getSerializable(Const.BundleKey.SELECT_PAYMENT_METHOD);
        this.f43631b = getScopeContext().getBundle().getString("current_shop_id");
        this.f43632c = getScopeContext().getBundle().getString("cart_id");
        this.f43633d = getScopeContext().getBundle().getString(Const.BundleKey.BIND_CARD_SCENE, (String) null);
        m30931c();
        ((CustomerActivityResultRepo) RepoFactory.getRepo(CustomerActivityResultRepo.class)).subscribeResult(getScopeContext(), new Action1<CustomerActivityResultRepo.ActivityResult>() {
            public void call(CustomerActivityResultRepo.ActivityResult activityResult) {
                if (activityResult == null) {
                    return;
                }
                if (activityResult.requestCode == 101) {
                    PayMethodPresenter.this.m30931c();
                } else if (activityResult.requestCode == 1) {
                    PayOmegaHelper.bindCardResult(activityResult, "bill");
                    if (activityResult.resultCode == -1) {
                        String str = null;
                        if (activityResult.data != null) {
                            str = activityResult.data.getStringExtra("card_index");
                        }
                        PayChannelEntity payChannelEntity = new PayChannelEntity();
                        payChannelEntity.cardIndex = str;
                        payChannelEntity.channelId = 150;
                        if (PayMethodPresenter.this.getScopeContext().getBundle().getInt("pay_scene", 0) == 0) {
                            ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(payChannelEntity);
                        }
                        PayMethodPresenter.this.getScopeContext().getNavigator().finish(PayMethodPresenter.this.m30923a(payChannelEntity));
                    } else if (activityResult.resultCode == 0) {
                        PayMethodPresenter.this.getScopeContext().getNavigator().finish();
                    }
                }
            }
        }, 101, 1);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f43635f) {
            this.f43635f = false;
            m30931c();
        }
    }

    /* renamed from: a */
    private void m30925a() {
        PayChannelEntity payChannelEntity = this.f43630a;
        if (payChannelEntity != null) {
            for (PayMethodInfoModel next : this.f43634e) {
                boolean isSameChannel = payChannelEntity.isSameChannel(next);
                next.mIsSelected = isSameChannel;
                if (next.mCardInfoList != null) {
                    Iterator<PayMethodInfoModel.CardInfoModel> it = next.mCardInfoList.iterator();
                    while (it.hasNext()) {
                        PayMethodInfoModel.CardInfoModel next2 = it.next();
                        next2.mIsSelected = isSameChannel && TextUtils.equals(payChannelEntity.cardIndex, next2.cardIndex);
                    }
                }
            }
            ((Contract.AbsPayMethodView) getLogicView()).updateView(this.f43634e);
        }
    }

    public void onPayMethodSelect(PayChannelEntity payChannelEntity) {
        if (getScopeContext().getBundle().getInt("pay_scene", 0) == 0) {
            ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(payChannelEntity);
            getScopeContext().getNavigator().finish(m30923a(payChannelEntity));
            return;
        }
        getScopeContext().getNavigator().finish(m30923a(payChannelEntity));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Bundle m30923a(PayChannelEntity payChannelEntity) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.BundleKey.SELECT_PAYMENT_METHOD, payChannelEntity);
        bundle.putString("current_shop_id", this.f43631b);
        return bundle;
    }

    /* renamed from: a */
    private void m30927a(String str) {
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 14;
        addCardParam.isShowLoading = true;
        addCardParam.isSignAfterOrder = true;
        addCardParam.productLine = AppConst.BUSINESS_ID;
        addCardParam.resourceId = this.f43633d;
        BindCardHelper.bindCard(addCardParam, 1);
        BillOmegaHelper.Companion.addCard(this.f43632c, this.f43631b, str, this.f43633d);
        AppsFlyerTrackHelper.trackAddPayment(getContext());
        FirebaseAnalyticsHelper.trackAddPayment(getContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m30928b() {
        return PayMethodInfoModel.findCardNum(this.f43634e);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m30931c() {
        if (getScopeContext() != null) {
            DialogUtil.showLoadingDialog(getScopeContext(), false);
            int i = getScopeContext().getBundle().getInt("pay_scene", 0);
            int i2 = getScopeContext().getBundle().getInt("pay_method_price");
            String string = getScopeContext().getBundle().getString("cart_id");
            AddressEntity delieveryAddress = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress();
            CustomerRpcManagerProxy.get().getPayInfo(String.valueOf(i2), i, AddressUtil.checkAddressValid(delieveryAddress) ? delieveryAddress.aid : "", string, new CustomerRpcCallback<PayMethodListInfoEntity>() {
                public void onRpcFailure(SFRpcException sFRpcException) {
                    super.onRpcFailure(sFRpcException);
                    DialogUtil.hideLoadingDialog();
                    PayOmegaHelper.openPayView(PayMethodPresenter.this.getScopeContext(), 0, 0, false);
                    ErrorTracker.create(ErrorConst.ErrorName.TECH_C_SERVICE_API_GET_PAY_INFO_ERROR).addModuleName("bill").addErrorType(String.valueOf(sFRpcException.getCode())).addErrorMsg(!TextUtils.isEmpty(sFRpcException.getOriginalMessage()) ? sFRpcException.getOriginalMessage() : "").build().trackError();
                }

                public void onRpcSuccess(PayMethodListInfoEntity payMethodListInfoEntity, long j) {
                    DialogUtil.hideLoadingDialog();
                    if (payMethodListInfoEntity != null) {
                        PayMethodPresenter.this.f43634e.clear();
                        PayMethodPresenter.this.f43634e.addAll(PayMethodInfoModel.convert(PayMethodPresenter.this.getContext(), payMethodListInfoEntity, PayMethodPresenter.this.f43630a));
                        ((Contract.AbsPayMethodView) PayMethodPresenter.this.getLogicView()).updateView(PayMethodPresenter.this.f43634e);
                        PayOmegaHelper.openPayView(PayMethodPresenter.this.getScopeContext(), PayMethodPresenter.this.m30928b(), PayMethodInfoModel.find99PayStatus(PayMethodPresenter.this.f43634e), PayMethodInfoModel.isDidiCashEnable(PayMethodPresenter.this.f43634e));
                        BillOmegaHelper.Companion.trackPayMethodSW(PayMethodPresenter.this.f43632c, PayMethodPresenter.this.f43633d, payMethodListInfoEntity);
                        Boolean findPayPaySignStatus = PayMethodInfoModel.findPayPaySignStatus(PayMethodPresenter.this.f43634e);
                        if (findPayPaySignStatus != null) {
                            BillOmegaHelper.Companion.trackPayPaySW(PayMethodPresenter.this.f43632c, PayMethodPresenter.this.f43631b, findPayPaySignStatus.booleanValue());
                        }
                    }
                }
            });
        }
    }
}
