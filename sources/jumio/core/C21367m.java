package jumio.core;

import com.jumio.core.credentials.C19967b;
import com.jumio.sdk.credentials.JumioCredentialCategory;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.core.m */
/* compiled from: CredentialDataModel.kt */
public final class C21367m extends C21365l {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C21367m(String str, ArrayList<C19967b> arrayList) {
        super(str, JumioCredentialCategory.DOCUMENT, arrayList);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(arrayList, "capabilities");
    }
}
