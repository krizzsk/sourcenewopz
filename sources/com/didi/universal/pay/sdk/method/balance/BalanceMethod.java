package com.didi.universal.pay.sdk.method.balance;

import android.content.Context;
import com.didi.universal.pay.sdk.method.change.ChangePayMethod;

public class BalanceMethod extends ChangePayMethod {
    public int getChannelID() {
        return 126;
    }

    public BalanceMethod(Context context) {
        super(context);
    }
}
