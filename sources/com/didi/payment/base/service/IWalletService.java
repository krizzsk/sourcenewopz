package com.didi.payment.base.service;

import android.app.Activity;
import java.io.Serializable;
import java.util.List;

public interface IWalletService {

    public static class AccountInfo implements Serializable {
        public String comment;
        public List<WalletFunction> entries;
        public boolean isAllowFullKyc;
        public String subTitle;
        public String title;
    }

    public static class WalletFunction implements Serializable {
        public String desc;
        public String iconUrl;
    }

    void gotoAccountPage(Activity activity, int i, AccountInfo accountInfo);
}
