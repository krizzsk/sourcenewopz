package com.didi.soda.customer.foundation.rpc.entity;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/ShopHeaderEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "mJsonComponentList", "", "Lcom/google/gson/JsonObject;", "getMJsonComponentList", "()Ljava/util/List;", "setMJsonComponentList", "(Ljava/util/List;)V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ShopHeaderEntity.kt */
public final class ShopHeaderEntity implements IEntity {
    @SerializedName("compList")
    private List<JsonObject> mJsonComponentList;
    private final long serialVersionUID = 8743568563907116239L;

    public final List<JsonObject> getMJsonComponentList() {
        return this.mJsonComponentList;
    }

    public final void setMJsonComponentList(List<JsonObject> list) {
        this.mJsonComponentList = list;
    }
}
