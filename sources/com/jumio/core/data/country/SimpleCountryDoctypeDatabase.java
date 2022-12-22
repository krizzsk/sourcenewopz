package com.jumio.core.data.country;

import com.jumio.core.data.document.DocumentType;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.document.JumioDocumentVariant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0011\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016R\u0016\u0010\u0019\u001a\u00020\u00158V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, mo175978d2 = {"Lcom/jumio/core/data/country/SimpleCountryDoctypeDatabase;", "Lcom/jumio/core/data/country/CountryDoctypeDatabase;", "Ljava/io/Serializable;", "Lcom/jumio/core/data/country/Country;", "country", "Ljava/util/ArrayList;", "Lcom/jumio/core/data/document/DocumentType;", "DEPRECATEDDocumentTypes", "", "add", "getDocumentTypesFor", "Lcom/jumio/sdk/document/JumioDocumentType;", "documentTypes", "Lcom/jumio/sdk/document/JumioDocumentVariant;", "documentVariant", "getCountriesFor", "", "iso3", "getCountryForIso3", "iso2", "getCountryForIso2", "", "contains", "countries", "clear", "isEmpty", "()Z", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: SimpleCountryDoctypeDatabase.kt */
public final class SimpleCountryDoctypeDatabase implements CountryDoctypeDatabase, Serializable {

    /* renamed from: a */
    public final HashMap<Country, ArrayList<DocumentType>> f54671a = new LinkedHashMap();

    public void add(Country country, ArrayList<DocumentType> arrayList) {
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(arrayList, "DEPRECATEDDocumentTypes");
        this.f54671a.put(country, arrayList);
    }

    public void clear() {
        this.f54671a.clear();
    }

    public boolean contains(Country country) {
        Intrinsics.checkNotNullParameter(country, "country");
        HashMap<Country, ArrayList<DocumentType>> hashMap = this.f54671a;
        Country countryForIso3 = getCountryForIso3(country.getIsoCode());
        if (hashMap != null) {
            return hashMap.containsKey(countryForIso3);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    public ArrayList<Country> countries() {
        return new ArrayList<>(this.f54671a.keySet());
    }

    public ArrayList<Country> getCountriesFor(ArrayList<JumioDocumentType> arrayList, JumioDocumentVariant jumioDocumentVariant) {
        HashMap<Country, ArrayList<DocumentType>> hashMap = this.f54671a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : hashMap.entrySet()) {
            Country country = (Country) next.getKey();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = ((ArrayList) next.getValue()).iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next2 = it.next();
                DocumentType documentType = (DocumentType) next2;
                if (((arrayList == null || !arrayList.contains(documentType.getIdType())) && arrayList != null) || ((jumioDocumentVariant == null || !documentType.hasVariant(jumioDocumentVariant)) && jumioDocumentVariant != null)) {
                    z = false;
                }
                if (z) {
                    arrayList2.add(next2);
                }
            }
            if (!arrayList2.isEmpty()) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        return new ArrayList<>(linkedHashMap.keySet());
    }

    public Country getCountryForIso2(String str) {
        Intrinsics.checkNotNullParameter(str, "iso2");
        String iSO3Country = new Locale("", str).getISO3Country();
        Intrinsics.checkNotNullExpressionValue(iSO3Country, "Locale(\"\", iso2).isO3Country");
        return getCountryForIso3(iSO3Country);
    }

    public Country getCountryForIso3(String str) {
        Intrinsics.checkNotNullParameter(str, "iso3");
        for (Country next : this.f54671a.keySet()) {
            if (Intrinsics.areEqual((Object) next.getIsoCode(), (Object) str)) {
                return next;
            }
        }
        return null;
    }

    public ArrayList<DocumentType> getDocumentTypesFor(Country country) {
        Intrinsics.checkNotNullParameter(country, "country");
        ArrayList<DocumentType> arrayList = this.f54671a.get(getCountryForIso3(country.getIsoCode()));
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public boolean isEmpty() {
        return this.f54671a.isEmpty();
    }
}
