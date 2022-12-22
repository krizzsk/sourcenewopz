package com.didi.payment.transfer.fillamount;

import com.didi.payment.transfer.common.IPageView;
import com.didi.payment.transfer.fillamount.IConfirmTransferInfo;
import com.didi.payment.transfer.fillamount.TransCreateOrderResp;
import com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp;
import com.didi.payment.wallet.password.PasswordDataVo;

public interface ICfmAmountPageView extends IPageView {
    String getInputValue(IConfirmTransferInfo.ValueType valueType);

    void onFetchLimit(GetNightlyLimitResp.NightlyLimitVo nightlyLimitVo);

    void onSecondConfirmInfo();

    void onServiceFeeGot(TransServiceFeeResp transServiceFeeResp);

    void openCashier(TransCreateOrderResp.DataBean dataBean, int i);

    void payPwdInfo(PasswordDataVo passwordDataVo);

    void toOrderDetailPage(String str);
}
