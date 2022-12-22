package com.didi.global.fintech.cashier.fastpay.contract;

import com.didi.global.fintech.cashier.fastpay.dialog.FastPayLimitItemData;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayInfoResponse;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J&\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H&J\b\u0010\u000e\u001a\u00020\u0004H&J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H&J\"\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tH&J\b\u0010\u0014\u001a\u00020\u0004H&J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPaySettingPresenter;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayBasePresenter;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayInfoResponse;", "onPayLimitBack", "", "amount", "", "onPayLimitClick", "items", "", "Lcom/didi/global/fintech/cashier/fastpay/dialog/FastPayLimitItemData;", "selectIndex", "", "confirm", "onPayOrderBack", "onPayOrderClick", "title", "onQuizBack", "question", "answers", "onStatusBtnClick", "onTermUrlClick", "url", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IFastPayPresenters.kt */
public interface IFastPaySettingPresenter extends IFastPayBasePresenter<FastPayInfoResponse> {
    void onPayLimitBack(String str);

    void onPayLimitClick(List<FastPayLimitItemData> list, int i, String str);

    void onPayOrderBack();

    void onPayOrderClick(String str);

    void onQuizBack(String str, List<String> list);

    void onStatusBtnClick();

    void onTermUrlClick(String str);
}
