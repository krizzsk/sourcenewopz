package com.didi.payment.transfer.common.model;

import com.didi.payment.transfer.channels.presenter.TransAccountStatusResp;
import java.util.HashMap;
import java.util.Map;

public class OmegaAccountState {
    public static final int ACCOUNT_TYPE_99PAY_PAYEE = 3;
    public static final int ACCOUNT_TYPE_99PAY_PAYER = 1;
    public static final int ACCOUNT_TYPE_99TAXI_PAYEE = 2;

    /* renamed from: a */
    private static OmegaAccountState f31322a = new OmegaAccountState();

    /* renamed from: b */
    private Map<Integer, Integer> f31323b = new HashMap();

    public static OmegaAccountState getInstance() {
        return f31322a;
    }

    @Deprecated
    public void bindAccount(TransAccountStatusResp.AccountStatus accountStatus) {
        this.f31323b.put(1, Integer.valueOf(accountStatus.status));
    }

    public void clearPayerInfo() {
        this.f31323b.remove(1);
    }

    public void bindPayeeData(int i, int i2) {
        this.f31323b.put(3, Integer.valueOf(i));
        this.f31323b.put(3, Integer.valueOf(i2));
    }

    public void clearPayeeInfo() {
        this.f31323b.remove(3);
    }

    public int getAccountStateByType(int i) {
        if (this.f31323b.containsKey(Integer.valueOf(i))) {
            return this.f31323b.get(Integer.valueOf(i)).intValue();
        }
        return -1;
    }
}
