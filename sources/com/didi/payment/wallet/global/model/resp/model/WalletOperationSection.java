package com.didi.payment.wallet.global.model.resp.model;

import java.io.Serializable;
import java.util.List;

public class WalletOperationSection implements Serializable {
    public List<WalletOperationItem> panelList;
    public String title;
}
