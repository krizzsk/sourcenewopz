package com.didi.unifylogin.flutter.request;

import com.didi.unifylogin.base.net.pojo.response.JudgeResponse;
import com.didi.unifylogin.domain.GlobalDomainCache;
import com.didi.unifylogin.flutter.Result;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.domainservice.model.PiiDomainSuffixModel;
import com.didiglobal.domainservice.model.SuffixType;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/unifylogin/flutter/request/FGetCompassJudge$request$1", "Lcom/didichuxing/foundation/rpc/RpcService$CallbackV2;", "Lcom/didi/unifylogin/base/net/pojo/response/JudgeResponse;", "onFailure", "", "request", "Lcom/didichuxing/foundation/rpc/RpcRequest;", "exception", "Ljava/io/IOException;", "onSuccess", "proxy", "Lcom/didichuxing/foundation/rpc/RpcResponseProxy;", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: FGetCompassJudge.kt */
public final class FGetCompassJudge$request$1 implements RpcService.CallbackV2<JudgeResponse> {
    final /* synthetic */ FGetCompassJudge this$0;

    FGetCompassJudge$request$1(FGetCompassJudge fGetCompassJudge) {
        this.this$0 = fGetCompassJudge;
    }

    public void onSuccess(RpcResponseProxy<JudgeResponse> rpcResponseProxy) {
        JudgeResponse.JudgeData judgeData = null;
        JudgeResponse content = rpcResponseProxy != null ? rpcResponseProxy.getContent() : null;
        if (content != null) {
            judgeData = content.data;
        }
        if (judgeData != null) {
            JudgeResponse.PiiDataItem piiDataItem = content.data.pii_info;
            GlobalDomainCache instance = GlobalDomainCache.getInstance(this.this$0.getContext());
            if (piiDataItem == null) {
                instance.removeDomainSuffixModel(this.this$0.getContext(), SuffixType.PII);
            } else if (!piiDataItem.illegal()) {
                PiiDomainSuffixModel piiDomainSuffixModel = new PiiDomainSuffixModel();
                piiDomainSuffixModel.setUris(piiDataItem.uri);
                piiDomainSuffixModel.setTimeout(piiDataItem.timeout);
                piiDomainSuffixModel.setSuffix(piiDataItem.idc_suffix);
                instance.setDomainSuffixModel(this.this$0.getContext(), piiDomainSuffixModel);
            } else {
                Map hashMap = new HashMap();
                String str = piiDataItem.idc_suffix;
                Intrinsics.checkExpressionValueIsNotNull(str, "piiDataItem.idc_suffix");
                hashMap.put("idc_suffix", str);
                hashMap.put("timeout", Integer.valueOf(piiDataItem.timeout));
                List<String> list = piiDataItem.uri;
                Intrinsics.checkExpressionValueIsNotNull(list, "piiDataItem.uri");
                hashMap.put(ShareConstants.MEDIA_URI, list);
                OmegaSDKAdapter.trackEvent("tech_compass_pii_info_error", (Map<String, Object>) hashMap);
            }
        }
        this.this$0.resultSuccess(Result.from(content));
    }

    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
        this.this$0.resultSuccess(Result.error());
    }
}
