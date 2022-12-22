package com.didi.universal.pay.biz.manager.listener;

import android.content.Intent;
import com.didi.universal.pay.biz.model.PayStatusModel;
import com.didi.universal.pay.biz.model.PollState;
import com.didi.universal.pay.biz.model.UniversalViewModel;
import com.didi.universal.pay.biz.p172ui.IUniversalPayView;
import com.didi.universal.pay.sdk.method.model.PayBillDetail;
import com.didi.universal.pay.sdk.method.model.PayInfo;
import com.didi.universal.pay.sdk.model.UniversalPayParams;
import com.didi.universal.pay.sdk.net.model.Error;

public interface IUniversalPayBizManager {

    public enum Action {
        GET_PAY_INFO,
        PREPAY,
        PAY,
        POLL,
        CLOSED,
        GET_PAY_STATUS
    }

    public interface BillCallback {
        void fail();

        void success(PayBillDetail payBillDetail);
    }

    public interface Result {
        void fail(Action action, PayStatusModel payStatusModel, Error error);

        void onBizFail(Action action, PayStatusModel payStatusModel);

        void onPaySuccess();

        void onRequestPayInfoSuccess(UniversalViewModel universalViewModel);

        void onThirdPayComplete(int i);

        void onThirdPayStart(int i);

        void startActivity(Intent intent);

        void startActivityForResult(Intent intent, int i);
    }

    void addCallBack(Result result);

    void changePayInfo(int i);

    void doGetPayInfo();

    void doOmegaEvent(String str);

    void doOmegaEvent(String str, int i);

    void doOmegaEvent(String str, boolean z);

    void doPay(IUniversalPayView.Action action);

    void doPoll(IUniversalPayView.Action action);

    void doPoll(IUniversalPayView.Action action, PollState pollState);

    void doQuit(boolean z);

    void getBillDetail(BillCallback billCallback);

    PayInfo getPayInfoCache();

    UniversalPayParams getPayParams();

    void onActivityResult(int i, int i2, Intent intent);

    void setCouponID(String str);

    void setEnterprisePayType(int i);

    void setMonthlyCardIDandDeduction(String str, int i);

    void setPayMethod(int i, String str);
}
