package com.didi.soda.customer.service;

import com.didi.soda.customer.foundation.storage.model.InstantConfig;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/customer/service/CustomerInstantService;", "Lcom/didi/soda/customer/service/IInstantService;", "()V", "clearInstantConfig", "", "getInstantConfig", "Lcom/didi/soda/customer/foundation/storage/model/InstantConfig;", "getInstantStr", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerInstantService.kt */
public final class CustomerInstantService implements IInstantService {
    public void clearInstantConfig() {
    }

    public String getInstantStr() {
        return "";
    }

    public InstantConfig getInstantConfig() {
        return new InstantConfig();
    }
}
