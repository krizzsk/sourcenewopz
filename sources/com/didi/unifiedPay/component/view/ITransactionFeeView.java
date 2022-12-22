package com.didi.unifiedPay.component.view;

import com.didi.unifiedPay.sdk.model.BasicBill;
import com.didi.unifiedPay.sdk.model.TransactionFee;

public interface ITransactionFeeView {
    void updateBillAmount(BasicBill basicBill);

    void updateTransactionFee(TransactionFee transactionFee);
}
