package com.didi.component.business.merchant;

import com.didi.component.business.event.BaseDeepLinkEvent;
import global.didi.pay.merchant.processor.model.MerchantSDKRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/component/business/merchant/MerchantActivityDeepLinkEvent;", "Lcom/didi/component/business/event/BaseDeepLinkEvent;", "request", "Lglobal/didi/pay/merchant/processor/model/MerchantSDKRequest;", "(Lglobal/didi/pay/merchant/processor/model/MerchantSDKRequest;)V", "getRequest", "()Lglobal/didi/pay/merchant/processor/model/MerchantSDKRequest;", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MerchantActivityDeepLinkEvent.kt */
public final class MerchantActivityDeepLinkEvent extends BaseDeepLinkEvent {
    private final MerchantSDKRequest request;

    public MerchantActivityDeepLinkEvent(MerchantSDKRequest merchantSDKRequest) {
        Intrinsics.checkNotNullParameter(merchantSDKRequest, "request");
        this.request = merchantSDKRequest;
    }

    public final MerchantSDKRequest getRequest() {
        return this.request;
    }
}
