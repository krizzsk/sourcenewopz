package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.base.service.IWalletService;
import com.didi.payment.commonsdk.net.WBaseResp;

public class WalletCreateAccountResp extends WBaseResp {
    public DataBean data;

    public static class DataBean {
        public IWalletService.AccountInfo accountStatus;
    }
}
