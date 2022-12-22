package com.didi.entrega.customer.foundation.rpc;

import android.os.Handler;
import android.os.Looper;
import com.didi.entrega.customer.debug.CustomerToolBoxUtil;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcResult;
import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.Rpc;
import com.didichuxing.foundation.rpc.RpcClient;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class CustomerRpcManagerProxy {

    /* renamed from: a */
    private static CustomerRpcService f19952a;

    private CustomerRpcManagerProxy() {
    }

    public static CustomerRpcService get() {
        if (f19952a == null) {
            if (CustomerToolBoxUtil.shouldMockApi()) {
                f19952a = (CustomerRpcService) Proxy.newProxyInstance(CustomerRpcService.class.getClassLoader(), new Class[]{CustomerRpcService.class}, new CustomerRpcManagerInvocationHandler(new C8076a()));
            } else {
                f19952a = new C8076a();
            }
        }
        return f19952a;
    }

    public static void clear() {
        f19952a = null;
    }

    static class CustomerRpcManagerInvocationHandler implements InvocationHandler {
        private static final int DELAY = 800;
        private Handler mHandler = new Handler(Looper.getMainLooper());
        private C8076a mTarget;

        CustomerRpcManagerInvocationHandler(C8076a aVar) {
            this.mTarget = aVar;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            SFRpcResult localMockData = CustomerToolBoxUtil.getLocalMockData(method);
            if (localMockData == null) {
                return method.invoke(this.mTarget, objArr);
            }
            for (Object obj2 : objArr) {
                if (obj2 instanceof CustomerRpcCallback) {
                    this.mHandler.postDelayed(new Runnable(localMockData) {
                        public final /* synthetic */ SFRpcResult f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            CustomerRpcCallback.this.onSuccess(this.f$1);
                        }
                    }, 800);
                }
            }
            return new MockHttpRpc();
        }
    }

    static class MockHttpRpc implements HttpRpc {
        public void cancel() {
        }

        public Object enqueue(HttpRpc.Callback callback) {
            return null;
        }

        public Object enqueue(Rpc.Callback<HttpRpcRequest, HttpRpcResponse> callback) {
            return null;
        }

        public HttpRpcResponse execute() throws IOException {
            return null;
        }

        public RpcClient<HttpRpcRequest, HttpRpcResponse> getClient() {
            return null;
        }

        public HttpRpcRequest getRequest() {
            return null;
        }

        public Object getTag() {
            return null;
        }

        MockHttpRpc() {
        }
    }
}
