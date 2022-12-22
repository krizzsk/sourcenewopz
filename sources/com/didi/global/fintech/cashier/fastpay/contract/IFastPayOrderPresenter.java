package com.didi.global.fintech.cashier.fastpay.contract;

import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayOrderResponse;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\bH&¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayOrderPresenter;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayBasePresenter;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayOrderResponse;", "onAddCardClick", "", "onConfirmBtnClick", "showLastMethodToast", "toast", "", "updateTitle", "title", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IFastPayPresenters.kt */
public interface IFastPayOrderPresenter extends IFastPayBasePresenter<FastPayOrderResponse> {
    void onAddCardClick();

    void onConfirmBtnClick();

    void showLastMethodToast(String str);

    void updateTitle(String str);
}
