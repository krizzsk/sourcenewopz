package com.didi.payment.creditcard.global.presenter;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.creditcard.global.contract.CreditCardDetailContract;
import com.didi.payment.creditcard.global.model.CreditCardModel;
import com.didi.payment.creditcard.global.model.bean.SignCancelCheckResult;
import com.didi.payment.creditcard.global.model.bean.SignCancelResult;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import org.greenrobot.eventbus.EventBus;

public class GlobalCreditCardDetailPresenter implements CreditCardDetailContract.IPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CreditCardDetailContract.IView f30419a;

    /* renamed from: b */
    private CreditCardModel f30420b;

    public GlobalCreditCardDetailPresenter(CreditCardDetailContract.IView iView) {
        this.f30419a = iView;
        this.f30420b = new CreditCardModel(iView.getContext());
    }

    public void removeCard(int i, String str) {
        CreditCardDetailContract.IView iView = this.f30419a;
        iView.showLoadingDialog(iView.getContext().getString(R.string.one_payment_creditcard_global_net_loading));
        this.f30420b.cancelSign(i, str, new RpcService.Callback<SignCancelResult>() {
            public void onSuccess(SignCancelResult signCancelResult) {
                GlobalCreditCardDetailPresenter.this.f30419a.dismissLoadingDialog();
                if (signCancelResult != null) {
                    String str = TextUtils.isEmpty(signCancelResult.hingMsg) ? signCancelResult.errMsg : signCancelResult.hingMsg;
                    if (signCancelResult.errNo == 0) {
                        GlobalCreditCardDetailPresenter.this.f30419a.showToastCompleted(str);
                        GlobalCreditCardDetailPresenter.this.f30419a.onCancelSignSuccess();
                        EventBus.getDefault().post(new WalletRefreshDataEvent());
                    } else if (signCancelResult.errNo == 10601 || signCancelResult.errNo == 1020 || signCancelResult.errNo == 10403) {
                        GlobalCreditCardDetailPresenter.this.f30419a.showToast(str);
                    } else {
                        GlobalCreditCardDetailPresenter.this.f30419a.showToast(str);
                    }
                }
            }

            public void onFailure(IOException iOException) {
                GlobalCreditCardDetailPresenter.this.f30419a.dismissLoadingDialog();
                GlobalCreditCardDetailPresenter.this.f30419a.showToast(GlobalCreditCardDetailPresenter.this.f30419a.getContext().getString(R.string.one_payment_creditcard_global_net_connerror));
            }
        });
    }

    public void checkCard(int i, String str) {
        CreditCardDetailContract.IView iView = this.f30419a;
        iView.showMaskLoadingDialog(iView.getContext().getString(R.string.one_payment_creditcard_global_net_loading));
        this.f30420b.cancelSignCheck(i, str, new RpcService.Callback<SignCancelCheckResult>() {
            public void onSuccess(SignCancelCheckResult signCancelCheckResult) {
                GlobalCreditCardDetailPresenter.this.f30419a.dismissLoadingDialog();
                if (signCancelCheckResult != null) {
                    if (signCancelCheckResult.errNo == 10602) {
                        GlobalCreditCardDetailPresenter.this.f30419a.showPayTipDialog(signCancelCheckResult.dialogContent, signCancelCheckResult.dialogFaqTip, signCancelCheckResult.dialogFaqUrl, signCancelCheckResult.outTradeId, signCancelCheckResult.encodeOid, signCancelCheckResult.productId);
                    } else if (signCancelCheckResult.errNo == 10601) {
                        GlobalCreditCardDetailPresenter.this.f30419a.showInvalidCancelDialog(signCancelCheckResult.dialogContent);
                    } else {
                        GlobalCreditCardDetailPresenter.this.f30419a.showCancelSignConfirmDialog();
                    }
                }
            }

            public void onFailure(IOException iOException) {
                GlobalCreditCardDetailPresenter.this.f30419a.dismissLoadingDialog();
                GlobalCreditCardDetailPresenter.this.f30419a.showToast(GlobalCreditCardDetailPresenter.this.f30419a.getContext().getString(R.string.one_payment_creditcard_global_net_connerror));
            }
        });
    }

    public void updateCard(FragmentActivity fragmentActivity, String str, String str2) {
        m21378a(fragmentActivity, 6, str, str2);
    }

    /* renamed from: a */
    private void m21378a(FragmentActivity fragmentActivity, int i, String str, String str2) {
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 1;
        addCardParam.cardNo = str;
        addCardParam.resourceId = str2;
        DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity((Activity) fragmentActivity, i, addCardParam);
    }
}
