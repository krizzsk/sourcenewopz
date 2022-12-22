package com.didi.soda.customer.foundation.rpc.entity.topgun;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.TagEntity;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CategoryNotifyEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "tip", "Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;", "getTip", "()Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;", "setTip", "(Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CategoryNotifyEntity.kt */
public final class CategoryNotifyEntity implements IEntity {
    @SerializedName("tip")
    private TagEntity tip;

    public final TagEntity getTip() {
        return this.tip;
    }

    public final void setTip(TagEntity tagEntity) {
        this.tip = tagEntity;
    }
}
