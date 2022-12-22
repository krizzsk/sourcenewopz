package com.didi.foundation.sdk.net.interceptor;

import android.text.TextUtils;
import com.didi.foundation.sdk.log.LogService;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

@ServiceProvider({RpcInterceptor.class})
public class RpcBlockInterceptor implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {

    /* renamed from: a */
    private static final HashMap<String, Long> f21274a = new HashMap<>();

    /* renamed from: b */
    private static final int f21275b = 596;

    /* renamed from: c */
    private RpcBlockInterface f21276c;

    /* renamed from: d */
    private Logger f21277d = LogService.getLogger((Class<?>) RpcBlockInterceptor.class);

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcResponse httpRpcResponse;
        if (m15640a(rpcChain.getRequest())) {
            this.f21277d.debug("intercept isBlock", new Object[0]);
            RpcBlockEntity rpcBlockEntity = new RpcBlockEntity();
            rpcBlockEntity.errno = 596;
            rpcBlockEntity.errmsg = m15638a().getErrorMsg();
            httpRpcResponse = rpcChain.getRequest().getRpcClient().newResponseBuilder().setRequest(rpcChain.getRequest()).setProtocol(rpcChain.getRequest().getProtocol()).setEntity((HttpEntity) HttpBody.newInstance(rpcChain.getRequest().getEntity().getContentType(), new Gson().toJson((Object) rpcBlockEntity))).build();
        } else {
            this.f21277d.debug("intercept is not Block", new Object[0]);
            httpRpcResponse = rpcChain.proceed(rpcChain.getRequest());
            m15639a(httpRpcResponse, rpcChain.getRequest());
        }
        if (httpRpcResponse != null && httpRpcResponse.getStatus() == 596) {
            m15638a().tracker596Error(m15642b(rpcChain.getRequest()));
        }
        return httpRpcResponse;
    }

    /* renamed from: a */
    private boolean m15640a(HttpRpcRequest httpRpcRequest) {
        RpcBlockInterface a = m15638a();
        if (a == null || !a.toggle()) {
            this.f21277d.debug("isBlock toggle = false", new Object[0]);
            return false;
        }
        String b = m15642b(httpRpcRequest);
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        if (!f21274a.containsKey(b) || ((double) (System.currentTimeMillis() - f21274a.get(b).longValue())) >= (((double) a.getLimitTime()) + (Math.random() * ((double) a.getLimitRandomTime()))) * 1000.0d) {
            f21274a.remove(b);
            return false;
        }
        a.trackerBlock(b);
        Logger logger = this.f21277d;
        logger.debug("isBlock url = " + b + ", toggle.getLimitTime() = " + a.getLimitTime(), new Object[0]);
        return true;
    }

    /* renamed from: a */
    private void m15639a(HttpRpcResponse httpRpcResponse, HttpRpcRequest httpRpcRequest) {
        if (httpRpcResponse != null && httpRpcResponse.getEntity() != null && httpRpcRequest != null && m15638a() != null) {
            int status = httpRpcResponse.getStatus();
            String b = m15642b(httpRpcRequest);
            if (!TextUtils.isEmpty(b)) {
                Logger logger = this.f21277d;
                logger.debug("putBlockUrl status = " + status + ", url = " + b, new Object[0]);
                if (status == 596 && !f21274a.containsKey(b) && !m15641a(m15638a().getBlackList(), b)) {
                    f21274a.put(b, Long.valueOf(System.currentTimeMillis()));
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m15641a(ArrayList<String> arrayList, String str) {
        if (!CollectionUtil.isEmpty((Collection<?>) arrayList) && !TextUtils.isEmpty(str)) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                if (str.contains(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    private String m15642b(HttpRpcRequest httpRpcRequest) {
        String url = httpRpcRequest.getUrl();
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        String[] split = url.split("\\?");
        if (split.length > 0) {
            return split[0];
        }
        return null;
    }

    /* renamed from: a */
    private RpcBlockInterface m15638a() {
        if (this.f21276c == null) {
            this.f21276c = (RpcBlockInterface) ServiceLoader.load(RpcBlockInterface.class).get();
        }
        return this.f21276c;
    }
}
