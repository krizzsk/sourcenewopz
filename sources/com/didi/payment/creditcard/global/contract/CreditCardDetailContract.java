package com.didi.payment.creditcard.global.contract;

import androidx.fragment.app.FragmentActivity;
import com.didi.payment.creditcard.global.contract.CreditCardBaseContract;

public interface CreditCardDetailContract {

    public interface IPresenter {
        void checkCard(int i, String str);

        void removeCard(int i, String str);

        void updateCard(FragmentActivity fragmentActivity, String str, String str2);
    }

    public interface IView extends CreditCardBaseContract.IView {
        void onCancelSignSuccess();

        void showCancelSignConfirmDialog();

        void showInvalidCancelDialog(String str);

        void showPayTipDialog(String str, String str2, String str3, String str4, String str5, String str6);
    }
}
