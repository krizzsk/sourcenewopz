package com.didi.payment.transfer.newaccount;

import com.didi.payment.transfer.common.IPageView;
import com.didi.payment.transfer.newaccount.TransBankAccountTypeResp;
import com.didi.payment.transfer.newaccount.presenter.ITransNewAccountPresenter;

public interface INewAccountPageView extends IPageView<ITransNewAccountPresenter> {
    void gotoFullBankList();

    void onGetAccountTypeList(TransBankAccountTypeResp.DataBean dataBean);

    void showSuggestBankDialog();
}
