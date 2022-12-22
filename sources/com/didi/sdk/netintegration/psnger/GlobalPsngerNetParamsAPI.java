package com.didi.sdk.netintegration.psnger;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.netintegration.basecore.NetParamsAPI;
import com.didi.security.wireless.adapter.SignInterceptor;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didichuxing.foundation.util.Converter;
import com.didichuxing.foundation.util.TypeResolver;
import didihttp.DidiHttpClient;
import didihttp.Interceptor;
import didihttp.Response;
import didihttpdns.model.DnsParam;
import didihttpdns.security.InterceptorGetter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Iterator;

public abstract class GlobalPsngerNetParamsAPI implements NetParamsAPI {
    public abstract int getCityID(Context context);

    public DnsParam getDnsParam() {
        return null;
    }

    public abstract int getFlowTag();

    public abstract String getTerminalTag();

    public abstract boolean getTransEnable(Context context);

    public abstract String getUid();

    public InterceptorGetter getSignInterceptorGetter() {
        return new SignInterceptorGetter();
    }

    private static class SignInterceptorGetter implements InterceptorGetter {
        final ServiceLoader<Converter> mConverters;
        final Interceptor mEmptyInterceptor;
        final Type mRpcInterceptorType;

        private SignInterceptorGetter() {
            this.mConverters = ServiceLoader.load(Converter.class);
            this.mRpcInterceptorType = TypeResolver.getSuperclassTypeParameter((Object) new Converter<RpcInterceptor<HttpRpcRequest, HttpRpcResponse>, Interceptor>() {
                public Interceptor convert(RpcInterceptor<HttpRpcRequest, HttpRpcResponse> rpcInterceptor, Object... objArr) {
                    return null;
                }
            });
            this.mEmptyInterceptor = new Interceptor() {
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    SystemUtils.log(3, "InterceptorTest", "convert failed", (Throwable) null, "com.didi.sdk.netintegration.psnger.GlobalPsngerNetParamsAPI$SignInterceptorGetter$2", 66);
                    return chain.proceed(chain.request());
                }
            };
        }

        public Interceptor get(DidiHttpClient didiHttpClient) {
            Iterator<Converter> it = this.mConverters.iterator();
            while (it.hasNext()) {
                Converter next = it.next();
                SystemUtils.log(3, "InterceptorTest", next.toString(), (Throwable) null, "com.didi.sdk.netintegration.psnger.GlobalPsngerNetParamsAPI$SignInterceptorGetter", 74);
                if (this.mRpcInterceptorType.equals(next.getOriginType()) && Interceptor.class.equals(next.getTargetType())) {
                    SystemUtils.log(3, "InterceptorTest", "convert success", (Throwable) null, "com.didi.sdk.netintegration.psnger.GlobalPsngerNetParamsAPI$SignInterceptorGetter", 76);
                    return (Interceptor) next.convert(new SignInterceptor(), didiHttpClient);
                }
            }
            return this.mEmptyInterceptor;
        }
    }
}
