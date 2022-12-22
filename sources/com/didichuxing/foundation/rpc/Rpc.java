package com.didichuxing.foundation.rpc;

import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponse;
import java.io.IOException;

public interface Rpc<Request extends RpcRequest, Response extends RpcResponse> {

    public interface Callback<Request, Response> {
        void onFailure(Request request, IOException iOException);

        void onSuccess(Response response);
    }

    void cancel();

    Object enqueue(Callback<Request, Response> callback);

    Response execute() throws IOException;

    RpcClient<Request, Response> getClient();

    RpcRequest getRequest();

    Object getTag();
}
