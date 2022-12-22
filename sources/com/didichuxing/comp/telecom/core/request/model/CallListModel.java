package com.didichuxing.comp.telecom.core.request.model;

import com.didichuxing.comp.telecom.core.voip.VoipCallModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/request/model/CallListModel;", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;", "()V", "callList", "Lcom/didichuxing/comp/telecom/core/request/model/CallList;", "getCallList", "()Lcom/didichuxing/comp/telecom/core/request/model/CallList;", "setCallList", "(Lcom/didichuxing/comp/telecom/core/request/model/CallList;)V", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: CallListResponse.kt */
public final class CallListModel extends VoipCallModel {
    @SerializedName("call_list")
    private CallList callList;

    public final CallList getCallList() {
        return this.callList;
    }

    public final void setCallList(CallList callList2) {
        this.callList = callList2;
    }
}
