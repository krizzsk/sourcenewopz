package com.didi.payment.transfer.fillphone;

import com.didi.payment.transfer.common.IPageView;
import com.didi.payment.transfer.fillamount.IConfirmTransferInfo;

public interface IPhonePageView extends IPageView {
    void toConfirmTransAmount(IConfirmTransferInfo iConfirmTransferInfo);
}
