package com.didi.soda.customer.foundation.rpc.entity.topgun;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeModuleEntity;", "Ljava/io/Serializable;", "()V", "mFilterList", "Lcom/google/gson/JsonElement;", "getMFilterList", "()Lcom/google/gson/JsonElement;", "setMFilterList", "(Lcom/google/gson/JsonElement;)V", "mHasMore", "", "getMHasMore", "()Ljava/lang/Boolean;", "setMHasMore", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mJsonComponentList", "", "Lcom/google/gson/JsonObject;", "getMJsonComponentList", "()Ljava/util/List;", "setMJsonComponentList", "(Ljava/util/List;)V", "mType", "", "getMType", "()I", "setMType", "(I)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeModuleEntity.kt */
public final class HomeModuleEntity implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long serialVersionUID = 6898602172775420468L;
    @SerializedName("filterList")
    private JsonElement mFilterList;
    @SerializedName("hasMore")
    private Boolean mHasMore = false;
    @SerializedName("compList")
    private List<JsonObject> mJsonComponentList;
    @SerializedName("type")
    private int mType;

    public final int getMType() {
        return this.mType;
    }

    public final void setMType(int i) {
        this.mType = i;
    }

    public final List<JsonObject> getMJsonComponentList() {
        return this.mJsonComponentList;
    }

    public final void setMJsonComponentList(List<JsonObject> list) {
        this.mJsonComponentList = list;
    }

    public final JsonElement getMFilterList() {
        return this.mFilterList;
    }

    public final void setMFilterList(JsonElement jsonElement) {
        this.mFilterList = jsonElement;
    }

    public final Boolean getMHasMore() {
        return this.mHasMore;
    }

    public final void setMHasMore(Boolean bool) {
        this.mHasMore = bool;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeModuleEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeModuleEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
