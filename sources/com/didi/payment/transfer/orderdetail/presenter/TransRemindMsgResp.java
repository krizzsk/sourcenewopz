package com.didi.payment.transfer.orderdetail.presenter;

import com.didi.payment.transfer.net.TransBaseResp;
import com.didi.sdk.util.TextUtil;

public class TransRemindMsgResp extends TransBaseResp {
    public SimpleMsgData data;

    public class SimpleMsgData {
        public String msg;

        /* renamed from: ok */
        public boolean f31479ok;
        public String successNotice;

        public SimpleMsgData() {
        }

        public String getTipMsg() {
            return !TextUtil.isEmpty(this.msg) ? this.msg : this.successNotice;
        }
    }
}
