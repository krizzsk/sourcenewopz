package com.jumio.core.models;

import com.jumio.core.model.StaticModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\u0010"}, mo175978d2 = {"Lcom/jumio/core/models/DataDogModel;", "Lcom/jumio/core/model/StaticModel;", "", "a", "Ljava/lang/String;", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "clientId", "b", "getAppId", "setAppId", "appId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: DataDogModel.kt */
public final class DataDogModel implements StaticModel {

    /* renamed from: a */
    public String f54813a;

    /* renamed from: b */
    public String f54814b;

    public DataDogModel() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public DataDogModel(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "clientId");
        Intrinsics.checkNotNullParameter(str2, "appId");
        this.f54813a = str;
        this.f54814b = str2;
    }

    public final String getAppId() {
        return this.f54814b;
    }

    public final String getClientId() {
        return this.f54813a;
    }

    public final void setAppId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f54814b = str;
    }

    public final void setClientId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f54813a = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataDogModel(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}
