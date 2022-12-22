package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.commonsdk.net.WBaseResp;
import java.io.Serializable;

public class WalletAccountStatus extends WBaseResp {
    public Data data;

    public static class Data implements Serializable {
        public int status;
    }
}
