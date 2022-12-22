package com.didichuxing.comp.telecom.core.request.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/request/model/CallList;", "Ljava/io/Serializable;", "()V", "items", "", "Lcom/didichuxing/comp/telecom/core/request/model/CallMethodItem;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: CallListResponse.kt */
public final class CallList implements Serializable {
    @SerializedName("items")
    private List<CallMethodItem> items;

    public final List<CallMethodItem> getItems() {
        return this.items;
    }

    public final void setItems(List<CallMethodItem> list) {
        this.items = list;
    }
}
