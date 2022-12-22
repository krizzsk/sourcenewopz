package com.jumio.core.models;

import android.content.Context;
import android.content.res.Configuration;
import com.jumio.core.data.country.Country;
import com.jumio.core.data.country.CountryDoctypeDatabase;
import com.jumio.core.data.country.SimpleCountryDoctypeDatabase;
import com.jumio.core.data.document.DocumentType;
import com.jumio.core.model.StaticModel;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.document.JumioDocumentVariant;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CountryDocumentModel.kt */
public final class CountryDocumentModel implements StaticModel {

    /* renamed from: b */
    public static final Companion f54811b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    public CountryDoctypeDatabase f54812a = new SimpleCountryDoctypeDatabase();

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, mo175978d2 = {"Lcom/jumio/core/models/CountryDocumentModel$Companion;", "", "Landroid/content/Context;", "context", "", "isDeviceLanguageLocalizable", "", "GERMAN_ISO3", "Ljava/lang/String;", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: CountryDocumentModel.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isDeviceLanguageLocalizable(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Configuration configuration = new Configuration(context.getResources().getConfiguration());
                String string = context.getResources().getString(R.string.jumio_idtype_pp);
                Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…R.string.jumio_idtype_pp)");
                configuration.setLocale(Locale.ENGLISH);
                String string2 = context.createConfigurationContext(configuration).getResources().getString(R.string.jumio_idtype_pp);
                Intrinsics.checkNotNullExpressionValue(string2, "context.createConfigurat…R.string.jumio_idtype_pp)");
                return true ^ StringsKt.equals(string2, string, true);
            } catch (Exception unused) {
                return true;
            }
        }
    }

    /* renamed from: a */
    public final void mo162834a(Country country, ArrayList<DocumentType> arrayList) {
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(arrayList, "documentTypes");
        this.f54812a.add(country, arrayList);
    }

    /* renamed from: b */
    public final boolean mo162835b() {
        return this.f54812a.isEmpty();
    }

    /* renamed from: a */
    public final ArrayList<DocumentType> mo162831a(Country country, List<? extends JumioDocumentType> list, JumioDocumentVariant jumioDocumentVariant) {
        Intrinsics.checkNotNullParameter(country, "country");
        ArrayList<DocumentType> arrayList = new ArrayList<>();
        Iterator<DocumentType> it = this.f54812a.getDocumentTypesFor(country).iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            DocumentType next = it.next();
            boolean z2 = false;
            if ((list == null || !(!list.isEmpty()) || !list.contains(next.getIdType())) && list != null && !list.isEmpty()) {
                z = false;
            }
            if (next.getVariants().size() == 0) {
                z = false;
            }
            if (jumioDocumentVariant == null || next.hasVariant(jumioDocumentVariant)) {
                z2 = z;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 1) {
            CollectionsKt.sort(arrayList);
        }
        return arrayList;
    }

    /* renamed from: a */
    public final ArrayList<Country> mo162832a(ArrayList<JumioDocumentType> arrayList, JumioDocumentVariant jumioDocumentVariant) {
        return this.f54812a.getCountriesFor(arrayList, jumioDocumentVariant);
    }

    /* renamed from: a */
    public final void mo162833a() {
        this.f54812a.clear();
    }
}
