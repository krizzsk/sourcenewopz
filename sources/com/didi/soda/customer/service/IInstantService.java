package com.didi.soda.customer.service;

import com.didi.soda.customer.foundation.storage.model.InstantConfig;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/customer/service/IInstantService;", "Lcom/didi/soda/customer/service/IService;", "clearInstantConfig", "", "getInstantConfig", "Lcom/didi/soda/customer/foundation/storage/model/InstantConfig;", "getInstantStr", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IInstantService.kt */
public interface IInstantService extends IService {
    void clearInstantConfig();

    InstantConfig getInstantConfig();

    String getInstantStr();
}
