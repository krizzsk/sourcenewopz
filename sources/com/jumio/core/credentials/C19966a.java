package com.jumio.core.credentials;

import com.jumio.core.data.ScanMode;
import com.jumio.core.data.country.Country;
import com.jumio.core.data.document.DocumentPart;
import com.jumio.core.data.document.DocumentType;
import com.jumio.core.data.document.DocumentVariant;
import com.jumio.core.models.IDScanPartModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.models.SelectionModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.sdk.document.JumioDocument;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.document.JumioDocumentVariant;
import com.jumio.sdk.enums.JumioScanSide;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import jumio.core.C21371o;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.jumio.core.credentials.a */
/* compiled from: CountrySelection.kt */
public final class C19966a implements Serializable {

    /* renamed from: a */
    public final SettingsModel f54654a;

    /* renamed from: b */
    public final C21371o f54655b;

    /* renamed from: c */
    public ArrayList<Country> f54656c;

    /* renamed from: d */
    public ArrayList<JumioDocumentType> f54657d;

    /* renamed from: e */
    public JumioDocumentVariant f54658e;

    /* renamed from: f */
    public Country f54659f;

    /* renamed from: g */
    public DocumentType f54660g;

    /* renamed from: h */
    public DocumentVariant f54661h;

    public C19966a(SettingsModel settingsModel, C21371o oVar) {
        JumioDocument l;
        Intrinsics.checkNotNullParameter(settingsModel, "settingsModel");
        Intrinsics.checkNotNullParameter(oVar, "credentialsDataModel");
        this.f54654a = settingsModel;
        this.f54655b = oVar;
        this.f54657d = oVar.mo175853i();
        this.f54658e = oVar.mo175854j();
        ArrayList<Country> a = settingsModel.getCountryModel().mo162832a(this.f54657d, this.f54658e);
        ArrayList<String> h = oVar.mo175852h();
        if (h != null && (h.isEmpty() ^ true)) {
            ArrayList<Country> arrayList = new ArrayList<>();
            for (T next : a) {
                if (this.f54655b.mo175852h().contains(((Country) next).getIsoCode())) {
                    arrayList.add(next);
                }
            }
            a = arrayList;
        }
        this.f54656c = a;
        if (a == null || a.isEmpty()) {
            this.f54657d = null;
            this.f54658e = null;
            this.f54656c = this.f54654a.getCountryModel().mo162832a((ArrayList<JumioDocumentType>) null, (JumioDocumentVariant) null);
        }
        ArrayList<Country> arrayList2 = this.f54656c;
        if (arrayList2 != null) {
            CollectionsKt.sort(arrayList2);
        }
        Map<String, List<JumioDocument>> a2 = mo162603a();
        Country a3 = (a2.size() != 1 || !mo162608b((String) CollectionsKt.first(a2.keySet()))) ? null : mo162601a((String) CollectionsKt.first(a2.keySet()));
        this.f54659f = a3;
        this.f54660g = null;
        this.f54661h = null;
        if (a3 != null) {
            ArrayList<DocumentType> a4 = this.f54654a.getCountryModel().mo162831a(a3, this.f54657d, this.f54658e);
            if (a4.size() == 1) {
                this.f54660g = a4.get(0);
            }
            DocumentType documentType = this.f54660g;
            if (documentType != null) {
                JumioDocumentVariant jumioDocumentVariant = this.f54658e;
                if (jumioDocumentVariant != null) {
                    Intrinsics.checkNotNull(jumioDocumentVariant);
                    if (documentType.hasVariant(jumioDocumentVariant)) {
                        JumioDocumentVariant jumioDocumentVariant2 = this.f54658e;
                        Intrinsics.checkNotNull(jumioDocumentVariant2);
                        this.f54661h = documentType.getVariant(jumioDocumentVariant2);
                    }
                }
                if (documentType.getVariants().size() == 1) {
                    this.f54661h = documentType.getVariants().get(0);
                }
            }
        }
        String k = this.f54655b.mo175855k();
        if (k != null && (l = this.f54655b.mo175856l()) != null) {
            mo162607b(k, l);
        }
    }

    /* renamed from: a */
    public final Map<String, List<JumioDocument>> mo162603a() {
        HashMap hashMap = new HashMap();
        ArrayList<Country> arrayList = this.f54656c;
        if (!(arrayList == null || arrayList == null)) {
            for (Country country : arrayList) {
                ArrayList arrayList2 = new ArrayList();
                for (DocumentType documentType : mo162602a(country)) {
                    for (DocumentVariant documentVariant : documentType.getVariants()) {
                        if ((this.f54658e != null && documentVariant.getVariant() == this.f54658e) || this.f54658e == null) {
                            arrayList2.add(new JumioDocument(documentType.getIdType(), documentVariant.getVariant()));
                        }
                    }
                }
                String isoCode = country.getIsoCode();
                List unmodifiableList = Collections.unmodifiableList(arrayList2);
                Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(documentList)");
                hashMap.put(isoCode, unmodifiableList);
            }
        }
        Map<String, List<JumioDocument>> unmodifiableMap = Collections.unmodifiableMap(hashMap);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap(countryMap)");
        return unmodifiableMap;
    }

    /* renamed from: b */
    public final SelectionModel mo162606b() {
        if (!mo162610d()) {
            return null;
        }
        Country country = this.f54659f;
        Intrinsics.checkNotNull(country);
        DocumentType documentType = this.f54660g;
        Intrinsics.checkNotNull(documentType);
        DocumentVariant documentVariant = this.f54661h;
        Intrinsics.checkNotNull(documentVariant);
        return new SelectionModel(country, documentType, documentVariant);
    }

    /* renamed from: c */
    public final String mo162609c() {
        if (mo162608b(this.f54654a.getCountryForIp())) {
            return this.f54654a.getCountryForIp();
        }
        return null;
    }

    /* renamed from: d */
    public final boolean mo162610d() {
        return (this.f54659f == null || this.f54660g == null || this.f54661h == null) ? false : true;
    }

    /* renamed from: b */
    public final void mo162607b(String str, JumioDocument jumioDocument) throws IllegalArgumentException {
        boolean z;
        T t;
        boolean z2;
        Intrinsics.checkNotNullParameter(str, "isoCode");
        Intrinsics.checkNotNullParameter(jumioDocument, "document");
        Country a = mo162601a(str);
        if (a != null) {
            this.f54659f = a;
            Iterator<T> it = mo162602a(a).iterator();
            while (true) {
                z = false;
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (((DocumentType) t).getIdType() == jumioDocument.getType()) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            DocumentType documentType = (DocumentType) t;
            this.f54660g = documentType;
            if (documentType != null) {
                if (documentType != null && documentType.hasVariant(jumioDocument.getVariant())) {
                    z = true;
                }
                if (z) {
                    DocumentType documentType2 = this.f54660g;
                    if (documentType2 != null) {
                        this.f54661h = documentType2.getVariant(jumioDocument.getVariant());
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Unsupported document variant".toString());
            }
            throw new IllegalArgumentException("Unsupported document type".toString());
        }
        throw new IllegalArgumentException("Unsupported country code".toString());
    }

    /* renamed from: b */
    public final boolean mo162608b(String str) {
        return mo162601a(str) != null;
    }

    /* renamed from: a */
    public final boolean mo162605a(String str, JumioDocument jumioDocument) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(str, "isoCode");
        Intrinsics.checkNotNullParameter(jumioDocument, "document");
        Country a = mo162601a(str);
        if (a == null) {
            return false;
        }
        Iterator<T> it = mo162602a(a).iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((DocumentType) t).getIdType() == jumioDocument.getType()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        DocumentType documentType = (DocumentType) t;
        if (documentType == null) {
            return false;
        }
        return documentType.hasVariant(jumioDocument.getVariant());
    }

    /* renamed from: a */
    public final void mo162604a(SortedMap<JumioScanSide, ScanPartModel> sortedMap) {
        DocumentVariant documentVariant;
        Intrinsics.checkNotNullParameter(sortedMap, "scanData");
        sortedMap.clear();
        SelectionModel b = mo162606b();
        if (b != null && (documentVariant = this.f54661h) != null) {
            for (DocumentPart documentPart : documentVariant.getParts()) {
                JumioScanSide side = documentPart.getSide();
                JumioScanSide side2 = documentPart.getSide();
                ScanMode scanMode = documentPart.getExtraction().get(0);
                Intrinsics.checkNotNullExpressionValue(scanMode, "documentPart.extraction[0]");
                sortedMap.put(side, new IDScanPartModel(side2, scanMode, documentVariant.getFormat(), b));
            }
        }
    }

    /* renamed from: a */
    public final Country mo162601a(String str) {
        ArrayList<Country> arrayList;
        T t = null;
        if (str == null || (arrayList = this.f54656c) == null) {
            return null;
        }
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (Intrinsics.areEqual((Object) ((Country) next).getIsoCode(), (Object) str)) {
                t = next;
                break;
            }
        }
        return (Country) t;
    }

    /* renamed from: a */
    public final ArrayList<DocumentType> mo162602a(Country country) {
        return this.f54654a.getCountryModel().mo162831a(country, this.f54657d, this.f54658e);
    }
}
