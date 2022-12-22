package com.didi.entrega.home.manager;

import com.didi.entrega.customer.app.ServerConfigManager;

public class RpcLazyLoader {

    /* renamed from: a */
    private static RpcLazyLoader f20710a = new RpcLazyLoader();
    public boolean mIsInit = false;

    public static RpcLazyLoader getLoader() {
        return f20710a;
    }

    public void lazyRpc() {
        if (!this.mIsInit) {
            this.mIsInit = true;
            ServerConfigManager.getInstance().initConfig((ServerConfigManager.OnInitConfigCallback) null);
        }
    }
}
