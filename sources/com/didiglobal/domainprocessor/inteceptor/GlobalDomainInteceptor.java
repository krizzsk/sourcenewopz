package com.didiglobal.domainprocessor.inteceptor;

import android.text.TextUtils;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.domainprocessor.DomainProcessor;
import com.didiglobal.domainservice.DomainServiceManager;
import com.didiglobal.domainservice.IDomainFilter;
import com.didiglobal.domainservice.model.AbsDomainSuffixModel;
import com.didiglobal.domainservice.model.PiiDomainSuffixModel;
import com.didiglobal.domainservice.model.SuffixType;
import com.didiglobal.domainservice.utils.DomainUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ServiceProvider({RpcInterceptor.class})
public class GlobalDomainInteceptor implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {

    /* renamed from: a */
    private List<IDomainFilter> f50024a;

    /* renamed from: b */
    private DomainServiceManager f50025b = DomainServiceManager.getInstance();

    /* renamed from: c */
    private HttpRpcClient f50026c = null;

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        if (!DomainUtil.isSupportDomainSwitch(DomainProcessor.getInstance().getApplication())) {
            return rpcChain.proceed(request);
        }
        String url = request.getUrl();
        if (isPiiUri(url)) {
            String rebuildPiiUrl = rebuildPiiUrl(url);
            this.f50026c = request.getRpcClient().newBuilder().build();
            m36025a(request);
            try {
                HttpRpcResponse proceed = rpcChain.proceed(request.newBuilder().setUrl(rebuildPiiUrl).build());
                if (proceed.isSuccessful()) {
                    m36026b(request);
                    return proceed;
                }
                omegaUpload(rebuildPiiUrl, proceed.getStatus());
                m36026b(request);
            } catch (IOException e) {
                e.printStackTrace();
                omegaUpload(rebuildPiiUrl, -1);
            } catch (Throwable th) {
                m36026b(request);
                throw th;
            }
        }
        if (DomainUtil.isSupportDomainSwitchForIdc(DomainProcessor.getInstance().getApplication())) {
            url = rebuildIdcUrl(url);
        }
        return rpcChain.proceed(request.newBuilder().setUrl(url).build());
    }

    public void omegaUpload(String str, int i) {
        PiiDomainSuffixModel piiDomainSuffixModel = (PiiDomainSuffixModel) getDomainSuffixModel(SuffixType.PII);
        HashMap hashMap = new HashMap();
        hashMap.put("idc_suffix", piiDomainSuffixModel.getSuffixWithHead());
        hashMap.put("timeout", Integer.valueOf(piiDomainSuffixModel.getTimeout()));
        hashMap.put(ShareConstants.MEDIA_URI, str);
        hashMap.put("response_code", Integer.valueOf(i));
        OmegaSDKAdapter.trackEvent("tech_compass_pii_downgrade", (Map<String, Object>) hashMap);
    }

    public boolean isPiiUri(String str) {
        PiiDomainSuffixModel piiDomainSuffixModel;
        if (!TextUtils.isEmpty(str) && (piiDomainSuffixModel = (PiiDomainSuffixModel) getDomainSuffixModel(SuffixType.PII)) != null && !piiDomainSuffixModel.illegal() && piiDomainSuffixModel.getTimeout() != 0 && piiDomainSuffixModel.containUri(str)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m36025a(HttpRpcRequest httpRpcRequest) {
        HttpRpcClient rpcClient = httpRpcRequest.getRpcClient();
        PiiDomainSuffixModel piiDomainSuffixModel = (PiiDomainSuffixModel) getDomainSuffixModel(SuffixType.PII);
        rpcClient.setConnectTimeout(((long) piiDomainSuffixModel.getTimeout()) * 1000);
        rpcClient.setReadTimeout(((long) piiDomainSuffixModel.getTimeout()) * 1000);
        rpcClient.setWriteTimeout(((long) piiDomainSuffixModel.getTimeout()) * 1000);
        rpcClient.setInnerRetry(false);
    }

    /* renamed from: b */
    private void m36026b(HttpRpcRequest httpRpcRequest) {
        if (this.f50026c != null && httpRpcRequest != null) {
            HttpRpcClient rpcClient = httpRpcRequest.getRpcClient();
            rpcClient.setConnectTimeout(this.f50026c.getConnectTimeout());
            rpcClient.setReadTimeout(this.f50026c.getConnectTimeout());
            rpcClient.setWriteTimeout(this.f50026c.getConnectTimeout());
            rpcClient.setInnerRetry(this.f50026c.getInnerRetry());
        }
    }

    public AbsDomainSuffixModel getDomainSuffixModel(String str) {
        return this.f50025b.getDomainSuffixModel(DomainProcessor.getInstance().getApplication(), str);
    }

    public String rebuildPiiUrl(String str) {
        return DomainUtil.rebuildUrl(str, getDomainSuffixModel(SuffixType.PII).getSuffix(), false);
    }

    public String rebuildIdcUrl(String str) {
        AbsDomainSuffixModel domainSuffixModel = getDomainSuffixModel(SuffixType.IDC);
        if (CollectionUtil.isEmpty((Collection<?>) this.f50024a)) {
            this.f50024a = DomainServiceManager.getInstance().getDomainFilterInList();
        }
        return DomainUtil.rebuildUrl(str, domainSuffixModel.getSuffix(), this.f50024a);
    }
}
