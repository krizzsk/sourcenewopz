package com.didi.entrega.customer.foundation.storage;

import com.didi.entrega.customer.foundation.rpc.entity.ServerConfigEntity;

public class ServerConfigStorage extends CustomerStorage<ServerConfigEntity> {
    public ServerConfigEntity getData() {
        ServerConfigEntity serverConfigEntity = (ServerConfigEntity) super.getData();
        if (serverConfigEntity != null) {
            return serverConfigEntity;
        }
        ServerConfigEntity serverConfigEntity2 = new ServerConfigEntity();
        setData(serverConfigEntity2);
        return serverConfigEntity2;
    }
}
