package com.didi.entrega.customer.foundation.rpc;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.app.ScopeContextProvider;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import java.util.HashMap;
import java.util.Map;

public abstract class RpcErrorConsumer implements ScopeContextProvider {
    private Map<String, Object> mExtra;

    public static class Empty extends RpcErrorConsumer {
        public boolean consumeRpcError(SFRpcException sFRpcException) {
            return true;
        }

        public boolean consumeRpcErrorWhenScopeContextDestroyed(SFRpcException sFRpcException) {
            return true;
        }

        public ScopeContext provideScopeContext() {
            return null;
        }
    }

    public abstract boolean consumeRpcError(SFRpcException sFRpcException);

    public abstract boolean consumeRpcErrorWhenScopeContextDestroyed(SFRpcException sFRpcException);

    public boolean doConsumeRpcError(SFRpcException sFRpcException) {
        if (isScopeContextDestroyed()) {
            return consumeRpcErrorWhenScopeContextDestroyed(sFRpcException);
        }
        return consumeRpcError(sFRpcException);
    }

    public <T> T getExtraData(String str) {
        Map<String, Object> map = this.mExtra;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public void putExtraData(String str, Object obj) {
        if (this.mExtra == null) {
            this.mExtra = new HashMap();
        }
        this.mExtra.put(str, obj);
    }

    private boolean isScopeContextDestroyed() {
        ScopeContext provideScopeContext = provideScopeContext();
        return provideScopeContext == null || provideScopeContext.getLiveHandler().isDestroyed();
    }
}
