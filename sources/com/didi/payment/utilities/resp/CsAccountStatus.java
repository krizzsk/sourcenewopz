package com.didi.payment.utilities.resp;

import com.didi.payment.commonsdk.net.WBaseResp;
import java.io.Serializable;

public class CsAccountStatus extends WBaseResp {
    public Data data;

    public static class Data implements Serializable {
        public int status;
    }
}
