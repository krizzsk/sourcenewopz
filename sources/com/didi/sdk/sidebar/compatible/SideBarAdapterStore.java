package com.didi.sdk.sidebar.compatible;

import android.content.Context;
import android.os.Message;
import com.didi.sdk.common.DDRpcServiceHelper;
import com.didi.sdk.store.BaseStore;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;

public class SideBarAdapterStore extends BaseStore {
    protected RpcServiceFactory factory;

    public SideBarAdapterStore() {
        super("framework-SideBarAdapterStore");
        this.factory = null;
        this.factory = DDRpcServiceHelper.getRpcServiceFactory();
    }

    public void dispatch(String str, Message message) {
        dispatchEvent(MsgAndEventUtil.msgToDefaultEvent(str, message));
    }

    public <T extends RpcService> T getService(Context context, Class<T> cls, String str) {
        if (this.factory == null) {
            this.factory = new RpcServiceFactory(context);
        }
        return this.factory.newRpcService(cls, str);
    }
}
