package com.didi.soda.customer.foundation.storage;

import com.didi.soda.customer.foundation.storage.model.FeedBackStrategyConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/storage/FeedBackStrategyStore;", "Lcom/didi/soda/customer/foundation/storage/CustomerStorage;", "Lcom/didi/soda/customer/foundation/storage/model/FeedBackStrategyConfig;", "()V", "getData", "key", "", "setData", "", "k", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FeedBackStrategyStore.kt */
public final class FeedBackStrategyStore extends CustomerStorage<FeedBackStrategyConfig> {
    public void setData(FeedBackStrategyConfig feedBackStrategyConfig) {
        Intrinsics.checkNotNullParameter(feedBackStrategyConfig, "k");
        super.setData(feedBackStrategyConfig.getSceneId(), feedBackStrategyConfig);
    }

    public FeedBackStrategyConfig getData(String str) {
        if (str == null) {
            return null;
        }
        return (FeedBackStrategyConfig) super.getData(str);
    }
}
