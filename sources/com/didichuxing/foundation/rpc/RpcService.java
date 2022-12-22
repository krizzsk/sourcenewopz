package com.didichuxing.foundation.rpc;

import java.io.IOException;

public interface RpcService {

    public interface Callback<T> {
        void onFailure(IOException iOException);

        void onSuccess(T t);
    }

    public interface CallbackV2<T> {
        void onFailure(RpcRequest rpcRequest, IOException iOException);

        void onSuccess(RpcResponseProxy<T> rpcResponseProxy);
    }
}
