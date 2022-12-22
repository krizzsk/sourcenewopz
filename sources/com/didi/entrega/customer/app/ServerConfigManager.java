package com.didi.entrega.customer.app;

import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.RpcErrorConsumer;
import com.didi.entrega.customer.foundation.rpc.entity.ServerConfigEntity;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.storage.ServerConfigStorage;
import com.didi.entrega.customer.foundation.util.SingletonFactory;

public final class ServerConfigManager {

    public interface OnInitConfigCallback {
        void onRequestCompleted(ServerConfigEntity serverConfigEntity);
    }

    public void initTabIn() {
    }

    private ServerConfigManager() {
    }

    public static ServerConfigManager getInstance() {
        return Holder.INSTANCE;
    }

    public void initConfig(final OnInitConfigCallback onInitConfigCallback) {
        CustomerRpcManagerProxy.get().getServerConfig(new CustomerRpcCallback<ServerConfigEntity>(new RpcErrorConsumer.Empty()) {
            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                OnInitConfigCallback onInitConfigCallback = onInitConfigCallback;
                if (onInitConfigCallback != null) {
                    onInitConfigCallback.onRequestCompleted((ServerConfigEntity) null);
                }
            }

            public void onRpcSuccess(ServerConfigEntity serverConfigEntity, long j) {
                if (serverConfigEntity != null) {
                    ((ServerConfigStorage) SingletonFactory.get(ServerConfigStorage.class)).setData(serverConfigEntity);
                }
                OnInitConfigCallback onInitConfigCallback = onInitConfigCallback;
                if (onInitConfigCallback != null) {
                    onInitConfigCallback.onRequestCompleted(serverConfigEntity);
                }
            }
        });
    }

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final ServerConfigManager INSTANCE = new ServerConfigManager();

        private Holder() {
        }
    }
}
