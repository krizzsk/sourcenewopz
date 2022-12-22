package com.didi.payment.wallet.open;

import com.didi.payment.wallet.global.impl.GlobalWalletApiImpl;

public class DidiWalletFactory {
    private DidiWalletFactory() {
        throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
    }

    public static IGlobalWalletApi createGlobalWalletApi() {
        return new GlobalWalletApiImpl();
    }
}
