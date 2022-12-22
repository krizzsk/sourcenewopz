package com.jumio.core.data.country;

import com.jumio.core.data.document.DocumentType;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.document.JumioDocumentVariant;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u000fH&J\u0011\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H¦\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H&J\b\u0010\u0017\u001a\u00020\u0007H&R\u0016\u0010\u0018\u001a\u00020\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, mo175978d2 = {"Lcom/jumio/core/data/country/CountryDoctypeDatabase;", "", "Lcom/jumio/core/data/country/Country;", "country", "Ljava/util/ArrayList;", "Lcom/jumio/core/data/document/DocumentType;", "DEPRECATEDDocumentTypes", "", "add", "getDocumentTypesFor", "Lcom/jumio/sdk/document/JumioDocumentType;", "documentTypes", "Lcom/jumio/sdk/document/JumioDocumentVariant;", "documentVariant", "getCountriesFor", "", "iso3", "getCountryForIso3", "iso2", "getCountryForIso2", "", "contains", "countries", "clear", "isEmpty", "()Z", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: CountryDoctypeDatabase.kt */
public interface CountryDoctypeDatabase {
    void add(Country country, ArrayList<DocumentType> arrayList);

    void clear();

    boolean contains(Country country);

    ArrayList<Country> countries();

    ArrayList<Country> getCountriesFor(ArrayList<JumioDocumentType> arrayList, JumioDocumentVariant jumioDocumentVariant);

    Country getCountryForIso2(String str);

    Country getCountryForIso3(String str);

    ArrayList<DocumentType> getDocumentTypesFor(Country country);

    boolean isEmpty();
}
