package com.didi.payment.transfer.fillphone;

import com.didi.payment.transfer.accounts.presenter.NNPayAccount;
import com.didi.payment.transfer.common.IPageView;
import com.didi.payment.transfer.common.model.ConfirmInfo;
import java.util.List;

public interface IPhoneCfmView extends IPageView {
    void gotoEditAmountPage(NNPayAccount nNPayAccount);

    void onCountryCodeLoaded(List<String> list);

    void onHistoryTransAccountLoaded(List<NNPayAccount> list);

    void onMultiTaskFinish(String str);

    void showConfirmTransferDialog(ConfirmInfo confirmInfo, NNPayAccount nNPayAccount);
}
