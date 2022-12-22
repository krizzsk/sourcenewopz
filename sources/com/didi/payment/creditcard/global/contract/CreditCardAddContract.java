package com.didi.payment.creditcard.global.contract;

import com.didi.payment.creditcard.global.contract.CreditCardBaseContract;
import com.didi.payment.creditcard.global.model.SignCardParam;
import com.didi.payment.creditcard.global.model.bean.OCRVerifyInfo;
import com.didi.payment.creditcard.global.model.bean.SignResult;
import global.didi.pay.threeds.network.model.ThreedsCybsDataResponse;

public interface CreditCardAddContract {

    public interface IPresenter {
        boolean checkPublicKey(SignCardParam signCardParam);

        void commit(int i, String str, String str2, String str3, int i2, int i3, boolean z, String str4, SignCardParam signCardParam, String str5, ThreedsCybsDataResponse threedsCybsDataResponse, String str6);

        void commit(int i, String str, String str2, String str3, int i2, int i3, boolean z, String str4, SignCardParam signCardParam, String str5, String str6);

        void ocrVerify(String str, String str2, String str3, int i, boolean z, String str4, String str5, SignCardParam signCardParam, String str6);

        void onDestory();

        void pollSignResult();

        void requestPublicKey(SignCardParam signCardParam);
    }

    public interface IView extends CreditCardBaseContract.IView {
        String getSignH5ErrMsg();

        void onCybs3DSSuccess(ThreedsCybsDataResponse threedsCybsDataResponse);

        void onOcrVerifyFailure(OCRVerifyInfo oCRVerifyInfo);

        void onOcrVerifySuccess();

        void onSignFail(SignResult signResult);

        void onSignSuccess(String str);

        void onSignSuccess(String str, String str2);

        void openCreditCardSignPage(String str, String str2, String str3);

        void showBindFailureDialog(SignResult signResult);

        void showCardUpdateConfirmDialog();

        void showOcrConfirmDialog();

        void showSignFailureGuideDialog(String str, String str2, String str3, String str4);
    }
}
