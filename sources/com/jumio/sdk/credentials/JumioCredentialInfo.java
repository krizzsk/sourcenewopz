package com.jumio.sdk.credentials;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, mo175978d2 = {"Lcom/jumio/sdk/credentials/JumioCredentialInfo;", "Ljava/io/Serializable;", "Lcom/jumio/sdk/credentials/JumioCredentialCategory;", "a", "Lcom/jumio/sdk/credentials/JumioCredentialCategory;", "getCategory", "()Lcom/jumio/sdk/credentials/JumioCredentialCategory;", "category", "", "b", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "<init>", "(Lcom/jumio/sdk/credentials/JumioCredentialCategory;Ljava/lang/String;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioCredentialInfo.kt */
public final class JumioCredentialInfo implements Serializable {

    /* renamed from: a */
    public final JumioCredentialCategory f55080a;

    /* renamed from: b */
    public final String f55081b;

    public JumioCredentialInfo(JumioCredentialCategory jumioCredentialCategory, String str) {
        Intrinsics.checkNotNullParameter(jumioCredentialCategory, "category");
        Intrinsics.checkNotNullParameter(str, "id");
        this.f55080a = jumioCredentialCategory;
        this.f55081b = str;
    }

    public final JumioCredentialCategory getCategory() {
        return this.f55080a;
    }

    public final String getId() {
        return this.f55081b;
    }
}
