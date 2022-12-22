package didinet;

import didihttp.Interceptor;
import didihttp.Request;
import didihttp.Response;
import didinet.NetEngine;
import java.io.IOException;

public class ParamInterceptor implements Interceptor {

    /* renamed from: a */
    private static final String f57128a = "CityId";

    /* renamed from: b */
    private static final String f57129b = "Flowtag";

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        NetEngine.ExternalParamGetter paramGetter = NetEngine.getInstance().getParamGetter();
        if (paramGetter != null) {
            Request.Builder newBuilder = request.newBuilder();
            NetEngine.ExternalParam onGetExternalParam = paramGetter.onGetExternalParam();
            if (onGetExternalParam != null) {
                if (onGetExternalParam.hasCityId()) {
                    newBuilder.removeHeader(f57128a);
                    newBuilder.addHeader(f57128a, String.valueOf(onGetExternalParam.getCityId()));
                }
                if (onGetExternalParam.hasFlowTag()) {
                    newBuilder.removeHeader(f57129b);
                    newBuilder.addHeader(f57129b, String.valueOf(onGetExternalParam.getFlowTag()));
                }
                return chain.proceed(newBuilder.build());
            }
        }
        return chain.proceed(request);
    }
}
