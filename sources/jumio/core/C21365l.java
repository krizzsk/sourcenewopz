package jumio.core;

import com.jumio.commons.PersistWith;
import com.jumio.core.credentials.C19967b;
import com.jumio.core.model.StaticModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.sdk.credentials.JumioCredentialCategory;
import com.jumio.sdk.enums.JumioScanSide;
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.jvm.internal.Intrinsics;

@PersistWith("CredentialsDataModel")
/* renamed from: jumio.core.l */
/* compiled from: CredentialDataModel.kt */
public class C21365l implements StaticModel {

    /* renamed from: a */
    public final String f59641a;

    /* renamed from: b */
    public final JumioCredentialCategory f59642b;

    /* renamed from: c */
    public final ArrayList<C19967b> f59643c;

    /* renamed from: d */
    public final SortedMap<JumioScanSide, ScanPartModel> f59644d = new TreeMap();

    /* renamed from: e */
    public ScanPartModel f59645e;

    /* renamed from: f */
    public JumioScanSide f59646f;

    public C21365l(String str, JumioCredentialCategory jumioCredentialCategory, ArrayList<C19967b> arrayList) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(jumioCredentialCategory, "category");
        Intrinsics.checkNotNullParameter(arrayList, "capabilities");
        this.f59641a = str;
        this.f59642b = jumioCredentialCategory;
        this.f59643c = arrayList;
    }

    /* renamed from: a */
    public final void mo175830a(ScanPartModel scanPartModel) {
        this.f59645e = scanPartModel;
    }

    /* renamed from: b */
    public final ScanPartModel mo175832b() {
        return this.f59645e;
    }

    /* renamed from: c */
    public final ArrayList<C19967b> mo175833c() {
        return this.f59643c;
    }

    /* renamed from: d */
    public final JumioCredentialCategory mo175834d() {
        return this.f59642b;
    }

    /* renamed from: e */
    public final String mo175835e() {
        return this.f59641a;
    }

    /* renamed from: f */
    public final SortedMap<JumioScanSide, ScanPartModel> mo175836f() {
        return this.f59644d;
    }

    /* renamed from: g */
    public final boolean mo175837g() {
        boolean z = this.f59644d.size() != 0;
        for (Map.Entry next : this.f59644d.entrySet()) {
            JumioScanSide jumioScanSide = (JumioScanSide) next.getKey();
            if (!((ScanPartModel) next.getValue()).getImageData().getImage().getHasPath()) {
                return false;
            }
        }
        return z;
    }

    /* renamed from: a */
    public final JumioScanSide mo175829a() {
        return this.f59646f;
    }

    /* renamed from: a */
    public final void mo175831a(JumioScanSide jumioScanSide) {
        this.f59646f = jumioScanSide;
    }
}
