package com.jumio.defaultui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jumio.commons.log.Log;
import com.jumio.core.data.country.Country;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.credentials.JumioIDCredential;
import com.jumio.sdk.document.JumioDocument;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p001a.C0010a;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b%\u0010&J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006("}, mo175978d2 = {"Lcom/jumio/defaultui/view/CountrySelectionFragment;", "Lcom/jumio/defaultui/view/BaseFragment;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "Lcom/jumio/core/data/country/Country;", "countryList", "", "initAdapter", "decorateRecyclerView", "Landroidx/appcompat/widget/SearchView;", "searchView", "initSearchView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "createLayout", "La/a;", "jumioViewModel$delegate", "Lkotlin/Lazy;", "getJumioViewModel", "()La/a;", "jumioViewModel", "Lcom/jumio/defaultui/view/CountrySelectionAdapter;", "countySelectionAdapter", "Lcom/jumio/defaultui/view/CountrySelectionAdapter;", "getCountySelectionAdapter", "()Lcom/jumio/defaultui/view/CountrySelectionAdapter;", "setCountySelectionAdapter", "(Lcom/jumio/defaultui/view/CountrySelectionAdapter;)V", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "<init>", "()V", "Companion", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: CountrySelectionFragment.kt */
public final class CountrySelectionFragment extends BaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static String TAG = CountrySelectionFragment.class.getSimpleName();
    public CountrySelectionAdapter countySelectionAdapter;
    private final Lazy jumioViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, C21490Reflection.getOrCreateKotlinClass(C0010a.class), new C20069x68f9a1dc(this), new C20070x68f9a1dd(this));
    public RecyclerView recyclerView;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ=\u0010\n\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00070\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0001¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\n \u0006*\u0004\u0018\u00010\u000b0\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, mo175978d2 = {"Lcom/jumio/defaultui/view/CountrySelectionFragment$Companion;", "", "Lcom/jumio/sdk/credentials/JumioIDCredential;", "jumioIDCredential", "", "Lcom/jumio/core/data/country/Country;", "kotlin.jvm.PlatformType", "", "getCountryList$jumio_defaultui_release", "(Lcom/jumio/sdk/credentials/JumioIDCredential;)Ljava/util/List;", "getCountryList", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: CountrySelectionFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<Country> getCountryList$jumio_defaultui_release(JumioIDCredential jumioIDCredential) {
            Map<String, List<JumioDocument>> countries;
            Set<String> keySet;
            List list = null;
            if (!(jumioIDCredential == null || (countries = jumioIDCredential.getCountries()) == null || (keySet = countries.keySet()) == null)) {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(keySet, 10));
                for (String country : keySet) {
                    arrayList.add(new Country(country, false, 2, (DefaultConstructorMarker) null));
                }
                list = CollectionsKt.sorted(arrayList);
            }
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            return Collections.unmodifiableList(list);
        }
    }

    /* renamed from: com.jumio.defaultui.view.CountrySelectionFragment$a */
    /* compiled from: CountrySelectionFragment.kt */
    public static final class C20068a extends Lambda implements Function1<Country, Unit> {

        /* renamed from: a */
        public final /* synthetic */ CountrySelectionFragment f55033a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C20068a(CountrySelectionFragment countrySelectionFragment) {
            super(1);
            this.f55033a = countrySelectionFragment;
        }

        /* renamed from: a */
        public final void mo163278a(Country country) {
            Intrinsics.checkNotNullParameter(country, "country");
            this.f55033a.getJumioViewModel().mo37c(country.getIsoCode());
            String access$getTAG$cp = CountrySelectionFragment.TAG;
            Log.m39456d(access$getTAG$cp, "country " + this.f55033a.getJumioViewModel() + ".selectedCountry selected");
            this.f55033a.dismissKeyboard();
            JumioFragmentCallback callback = this.f55033a.getCallback();
            if (callback != null) {
                callback.countrySelected();
            }
        }

        public /* synthetic */ Object invoke(Object obj) {
            mo163278a((Country) obj);
            return Unit.INSTANCE;
        }
    }

    private final void decorateRecyclerView(RecyclerView recyclerView2) {
        new FastScrollerDecorator(recyclerView2);
    }

    /* access modifiers changed from: private */
    public final C0010a getJumioViewModel() {
        return (C0010a) this.jumioViewModel$delegate.getValue();
    }

    private final void initAdapter(RecyclerView recyclerView2, List<Country> list) {
        if (!list.isEmpty()) {
            setCountySelectionAdapter(new CountrySelectionAdapter(CollectionsKt.toMutableList(list), new C20068a(this), getJumioViewModel().mo51n()));
            recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
            recyclerView2.setAdapter(getCountySelectionAdapter());
        }
    }

    private final void initSearchView(SearchView searchView, List<Country> list) {
        searchView.setOnQueryTextListener(new CountrySelectionFragment$initSearchView$1(this, list));
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CountrySelectionFragment.m47566initSearchView$lambda1(SearchView.this, view, z);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: initSearchView$lambda-1  reason: not valid java name */
    public static final void m47566initSearchView$lambda1(SearchView searchView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(searchView, "$searchView");
        searchView.setSelected(z);
        searchView.setIconified(!z);
    }

    public View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_country_selection, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.rv_country_list);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.rv_country_list)");
        setRecyclerView((RecyclerView) findViewById);
        SearchView searchView = (SearchView) inflate.findViewById(R.id.sv_country_selection_search);
        Companion companion = Companion;
        JumioCredential g = getJumioViewModel().mo44g();
        List<Country> countryList$jumio_defaultui_release = companion.getCountryList$jumio_defaultui_release(g instanceof JumioIDCredential ? (JumioIDCredential) g : null);
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(countryList$jumio_defaultui_release, "countryList");
        initAdapter(recyclerView2, countryList$jumio_defaultui_release);
        Intrinsics.checkNotNullExpressionValue(searchView, "searchView");
        initSearchView(searchView, countryList$jumio_defaultui_release);
        decorateRecyclerView(getRecyclerView());
        return inflate;
    }

    public final CountrySelectionAdapter getCountySelectionAdapter() {
        CountrySelectionAdapter countrySelectionAdapter = this.countySelectionAdapter;
        if (countrySelectionAdapter != null) {
            return countrySelectionAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("countySelectionAdapter");
        return null;
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            return recyclerView2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    public final void setCountySelectionAdapter(CountrySelectionAdapter countrySelectionAdapter) {
        Intrinsics.checkNotNullParameter(countrySelectionAdapter, "<set-?>");
        this.countySelectionAdapter = countrySelectionAdapter;
    }

    public final void setRecyclerView(RecyclerView recyclerView2) {
        Intrinsics.checkNotNullParameter(recyclerView2, "<set-?>");
        this.recyclerView = recyclerView2;
    }
}
