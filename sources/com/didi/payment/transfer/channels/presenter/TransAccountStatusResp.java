package com.didi.payment.transfer.channels.presenter;

import com.didi.payment.transfer.common.model.ConfirmInfo;
import com.didi.payment.transfer.common.model.FuncButton;
import com.didi.payment.transfer.net.TransBaseResp;

public class TransAccountStatusResp extends TransBaseResp {
    public static final int ACCOUNT_STATUS_REGISTED = 1;
    public static final int ACCOUNT_STATUS_REJECT = 3;
    public static final int ACCOUNT_STATUS_UNREGISTE = 0;
    public static final int ACCOUNT_STATUS_WAITTOVERIFY = 2;
    public AccountStatus data;

    public static class AccountStatus {
        public FuncButton gotItButton;
        public FuncButton registerButton;
        public ConfirmInfo registerNotice;
        public int status;
    }
}
