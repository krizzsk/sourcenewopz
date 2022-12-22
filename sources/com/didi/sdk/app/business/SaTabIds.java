package com.didi.sdk.app.business;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/sdk/app/business/SaTabIds;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "TAB_HOME", "TAB_ACTIVITY", "TAB_USER", "publicservice_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: SaTabIds.kt */
public enum SaTabIds {
    TAB_HOME("tab_home"),
    TAB_ACTIVITY("tab_activity"),
    TAB_USER("tab_user");
    

    /* renamed from: id */
    private String f35224id;

    private SaTabIds(String str) {
        this.f35224id = str;
    }

    public final String getId() {
        return this.f35224id;
    }

    public final void setId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f35224id = str;
    }
}
