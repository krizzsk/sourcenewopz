package com.jumio.sdk.result;

import com.jumio.sdk.credentials.JumioCredentialCategory;
import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.jumio.sdk.error.JumioError;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001By\b\u0000\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u001c\b\u0002\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0019\u0012(\b\u0002\u0010'\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010%j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u0001`&\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0019\u0010\u0016\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R-\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006*"}, mo175978d2 = {"Lcom/jumio/sdk/result/JumioResult;", "Ljava/io/Serializable;", "Lcom/jumio/sdk/credentials/JumioCredentialInfo;", "credentialInfo", "Lcom/jumio/sdk/result/JumioIDResult;", "getIDResult", "Lcom/jumio/sdk/result/JumioFaceResult;", "getFaceResult", "Lcom/jumio/sdk/result/JumioCredentialResult;", "getResult", "", "a", "Ljava/lang/String;", "getWorkflowExecutionId", "()Ljava/lang/String;", "workflowExecutionId", "b", "getAccountId", "accountId", "", "c", "Z", "isSuccess", "()Z", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "getCredentialInfos", "()Ljava/util/ArrayList;", "credentialInfos", "Lcom/jumio/sdk/error/JumioError;", "f", "Lcom/jumio/sdk/error/JumioError;", "getError", "()Lcom/jumio/sdk/error/JumioError;", "error", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "resultMap", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/ArrayList;Ljava/util/HashMap;Lcom/jumio/sdk/error/JumioError;)V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioResult.kt */
public final class JumioResult implements Serializable {

    /* renamed from: a */
    public final String f55119a;

    /* renamed from: b */
    public final String f55120b;

    /* renamed from: c */
    public final boolean f55121c;

    /* renamed from: d */
    public final ArrayList<JumioCredentialInfo> f55122d;

    /* renamed from: e */
    public final HashMap<String, JumioCredentialResult> f55123e;

    /* renamed from: f */
    public final JumioError f55124f;

    public JumioResult(String str, String str2, boolean z, ArrayList<JumioCredentialInfo> arrayList, HashMap<String, JumioCredentialResult> hashMap, JumioError jumioError) {
        this.f55119a = str;
        this.f55120b = str2;
        this.f55121c = z;
        this.f55122d = arrayList;
        this.f55123e = hashMap;
        this.f55124f = jumioError;
    }

    public final String getAccountId() {
        return this.f55120b;
    }

    public final ArrayList<JumioCredentialInfo> getCredentialInfos() {
        return this.f55122d;
    }

    public final JumioError getError() {
        return this.f55124f;
    }

    public final JumioFaceResult getFaceResult(JumioCredentialInfo jumioCredentialInfo) {
        Intrinsics.checkNotNullParameter(jumioCredentialInfo, "credentialInfo");
        if (jumioCredentialInfo.getCategory() != JumioCredentialCategory.FACE) {
            return null;
        }
        return (JumioFaceResult) getResult(jumioCredentialInfo);
    }

    public final JumioIDResult getIDResult(JumioCredentialInfo jumioCredentialInfo) {
        Intrinsics.checkNotNullParameter(jumioCredentialInfo, "credentialInfo");
        if (jumioCredentialInfo.getCategory() != JumioCredentialCategory.ID) {
            return null;
        }
        return (JumioIDResult) getResult(jumioCredentialInfo);
    }

    public final JumioCredentialResult getResult(JumioCredentialInfo jumioCredentialInfo) {
        Intrinsics.checkNotNullParameter(jumioCredentialInfo, "credentialInfo");
        HashMap<String, JumioCredentialResult> hashMap = this.f55123e;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(jumioCredentialInfo.getId());
    }

    public final String getWorkflowExecutionId() {
        return this.f55119a;
    }

    public final boolean isSuccess() {
        return this.f55121c;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JumioResult(String str, String str2, boolean z, ArrayList arrayList, HashMap hashMap, JumioError jumioError, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z, (i & 8) != 0 ? null : arrayList, (i & 16) != 0 ? null : hashMap, (i & 32) != 0 ? null : jumioError);
    }
}
