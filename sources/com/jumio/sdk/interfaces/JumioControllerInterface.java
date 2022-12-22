package com.jumio.sdk.interfaces;

import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.jumio.sdk.error.JumioError;
import com.jumio.sdk.result.JumioResult;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH&¨\u0006\u0010"}, mo175978d2 = {"Lcom/jumio/sdk/interfaces/JumioControllerInterface;", "", "Ljava/util/ArrayList;", "Lcom/jumio/sdk/credentials/JumioCredentialInfo;", "Lkotlin/collections/ArrayList;", "credentials", "", "policyUrl", "", "onInitialized", "Lcom/jumio/sdk/error/JumioError;", "error", "onError", "Lcom/jumio/sdk/result/JumioResult;", "result", "onFinished", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioControllerInterface.kt */
public interface JumioControllerInterface {
    void onError(JumioError jumioError);

    void onFinished(JumioResult jumioResult);

    void onInitialized(ArrayList<JumioCredentialInfo> arrayList, String str);
}
