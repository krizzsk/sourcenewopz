package jumio.core;

import com.jumio.core.credentials.C19967b;
import com.jumio.sdk.credentials.JumioCredentialCategory;
import com.jumio.sdk.document.JumioDocument;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.document.JumioDocumentVariant;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.core.o */
/* compiled from: CredentialDataModel.kt */
public final class C21371o extends C21365l {

    /* renamed from: g */
    public final ArrayList<String> f59660g;

    /* renamed from: h */
    public final ArrayList<JumioDocumentType> f59661h;

    /* renamed from: i */
    public final JumioDocumentVariant f59662i;

    /* renamed from: j */
    public String f59663j;

    /* renamed from: k */
    public JumioDocument f59664k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C21371o(String str, ArrayList<C19967b> arrayList, ArrayList<String> arrayList2, ArrayList<JumioDocumentType> arrayList3, JumioDocumentVariant jumioDocumentVariant) {
        super(str, JumioCredentialCategory.ID, arrayList);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(arrayList, "capabilities");
        this.f59660g = arrayList2;
        this.f59661h = arrayList3;
        this.f59662i = jumioDocumentVariant;
    }

    /* renamed from: a */
    public final void mo175851a(String str) {
        this.f59663j = str;
    }

    /* renamed from: h */
    public final ArrayList<String> mo175852h() {
        return this.f59660g;
    }

    /* renamed from: i */
    public final ArrayList<JumioDocumentType> mo175853i() {
        return this.f59661h;
    }

    /* renamed from: j */
    public final JumioDocumentVariant mo175854j() {
        return this.f59662i;
    }

    /* renamed from: k */
    public final String mo175855k() {
        return this.f59663j;
    }

    /* renamed from: l */
    public final JumioDocument mo175856l() {
        return this.f59664k;
    }

    /* renamed from: a */
    public final void mo175850a(JumioDocument jumioDocument) {
        this.f59664k = jumioDocument;
    }
}
