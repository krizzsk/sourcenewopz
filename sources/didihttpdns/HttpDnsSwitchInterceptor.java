package didihttpdns;

import didihttp.Dns;
import didihttp.Interceptor;
import didihttp.Request;
import didihttp.Response;
import didihttp.StatisticalContext;
import didihttp.internal.http.RealInterceptorChain;
import didihttp.internal.trace.Tree;
import didinet.Logger;
import didinet.NetEngine;
import didinet.OmegaAPI;
import java.io.IOException;
import java.util.HashMap;

public class HttpDnsSwitchInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        StatisticalContext statisticalContext = (StatisticalContext) realInterceptorChain.getExtraData();
        String host = request.url().host();
        if (HttpDnsManager.getInstance().fullLookup(host) == null) {
            return chain.proceed(request);
        }
        statisticalContext.setCustomDns(HttpDns.getInstance());
        String httpUrl = request.url().toString();
        try {
            Logger.m40928d("HttpDnsManager", "[interceptor] request " + httpUrl + " will use custom dns");
            return chain.proceed(request);
        } catch (IOException e) {
            if (HttpDnsApolloConfig.getConfig().mo170412i()) {
                OmegaAPI omegaAPI = NetEngine.getInstance().getOmegaAPI();
                HashMap hashMap = new HashMap();
                hashMap.put("host", host);
                hashMap.put("reason", 9);
                omegaAPI.trackEvent("not_use_httpdns_detail", "", hashMap);
                Logger.m40928d("HttpDnsManager", "[interceptor] request " + httpUrl + " use custom dns failed, roll back to system dns");
                statisticalContext.setCustomDns((Dns) null);
                statisticalContext.addRetryHDnsCount();
                Tree tree = realInterceptorChain.tree();
                if (tree != null) {
                    tree.popTo(this);
                }
                return chain.proceed(request);
            }
            throw e;
        }
    }
}
