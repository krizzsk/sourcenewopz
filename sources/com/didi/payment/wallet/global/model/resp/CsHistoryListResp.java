package com.didi.payment.wallet.global.model.resp;

import com.didi.payment.commonsdk.net.WBaseResp;
import java.io.Serializable;
import java.util.List;

public class CsHistoryListResp extends WBaseResp {
    public DataModel data;

    public static class DataModel implements Serializable {
        public int nextIndex = -1;
        public List<CsHistoryItem> orders;
    }
}
