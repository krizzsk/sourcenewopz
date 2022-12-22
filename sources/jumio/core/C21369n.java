package jumio.core;

import com.jumio.core.credentials.C19967b;
import com.jumio.core.enums.C19968a;
import com.jumio.sdk.credentials.JumioCredentialCategory;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.core.n */
/* compiled from: CredentialDataModel.kt */
public final class C21369n extends C21365l {

    /* renamed from: g */
    public final ArrayList<C19968a> f59652g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C21369n(String str, ArrayList<C19967b> arrayList, ArrayList<C19968a> arrayList2) {
        super(str, JumioCredentialCategory.FACE, arrayList);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(arrayList, "capabilities");
        this.f59652g = arrayList2;
    }

    /* renamed from: h */
    public final ArrayList<C19968a> mo175845h() {
        return this.f59652g;
    }
}
