package com.jumio.defaultui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.jumio.core.data.country.Country;
import com.jumio.defaultui.view.CountrySelectionAdapter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B3\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u0018\u0012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00060\u001b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b \u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u001c\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J+\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00060\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, mo175978d2 = {"Lcom/jumio/defaultui/view/CountrySelectionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/jumio/defaultui/view/CountrySelectionAdapter$CountryViewHolder;", "holder", "", "currentCountryCode", "", "checkIfSelected", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "position", "onBindViewHolder", "getItemCount", "filterText", "", "Lcom/jumio/core/data/country/Country;", "countryList", "updateViewWithFiltering", "filterCountries$jumio_defaultui_release", "(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;", "filterCountries", "", "countries", "Ljava/util/List;", "Lkotlin/Function1;", "onItemClick", "Lkotlin/jvm/functions/Function1;", "selectedCountry", "Ljava/lang/String;", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "CountryViewHolder", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: CountrySelectionAdapter.kt */
public final class CountrySelectionAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    /* access modifiers changed from: private */
    public final List<Country> countries;
    /* access modifiers changed from: private */
    public final Function1<Country, Unit> onItemClick;
    private final String selectedCountry;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, mo175978d2 = {"Lcom/jumio/defaultui/view/CountrySelectionAdapter$CountryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "tvCountry", "Landroid/widget/TextView;", "getTvCountry", "()Landroid/widget/TextView;", "Landroid/widget/LinearLayout;", "background", "Landroid/widget/LinearLayout;", "getBackground", "()Landroid/widget/LinearLayout;", "Landroid/view/View;", "itemView", "Lkotlin/Function1;", "", "", "onItemClicked", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: CountrySelectionAdapter.kt */
    public static final class CountryViewHolder extends RecyclerView.ViewHolder {
        private final LinearLayout background;
        private final TextView tvCountry;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CountryViewHolder(View view, Function1<? super Integer, Unit> function1) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(function1, "onItemClicked");
            view.setOnClickListener(new View.OnClickListener(this) {
                public final /* synthetic */ CountrySelectionAdapter.CountryViewHolder f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    CountrySelectionAdapter.CountryViewHolder.m47565_init_$lambda0(Function1.this, this.f$1, view);
                }
            });
            View findViewById = view.findViewById(R.id.tv_country);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_country)");
            this.tvCountry = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.holder_bg);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.holder_bg)");
            this.background = (LinearLayout) findViewById2;
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-0  reason: not valid java name */
        public static final void m47565_init_$lambda0(Function1 function1, CountryViewHolder countryViewHolder, View view) {
            Intrinsics.checkNotNullParameter(function1, "$onItemClicked");
            Intrinsics.checkNotNullParameter(countryViewHolder, "this$0");
            function1.invoke(Integer.valueOf(countryViewHolder.getAbsoluteAdapterPosition()));
        }

        public final LinearLayout getBackground() {
            return this.background;
        }

        public final TextView getTvCountry() {
            return this.tvCountry;
        }
    }

    /* renamed from: com.jumio.defaultui.view.CountrySelectionAdapter$a */
    /* compiled from: CountrySelectionAdapter.kt */
    public static final class C20067a extends Lambda implements Function1<Integer, Unit> {

        /* renamed from: a */
        public final /* synthetic */ CountrySelectionAdapter f55032a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C20067a(CountrySelectionAdapter countrySelectionAdapter) {
            super(1);
            this.f55032a = countrySelectionAdapter;
        }

        /* renamed from: a */
        public final void mo163272a(int i) {
            this.f55032a.onItemClick.invoke(this.f55032a.countries.get(i));
        }

        public /* synthetic */ Object invoke(Object obj) {
            mo163272a(((Number) obj).intValue());
            return Unit.INSTANCE;
        }
    }

    public CountrySelectionAdapter(List<Country> list, Function1<? super Country, Unit> function1, String str) {
        Intrinsics.checkNotNullParameter(list, "countries");
        Intrinsics.checkNotNullParameter(function1, "onItemClick");
        this.countries = list;
        this.onItemClick = function1;
        this.selectedCountry = str;
    }

    private final void checkIfSelected(CountryViewHolder countryViewHolder, String str) {
        countryViewHolder.getBackground().setSelected(Intrinsics.areEqual((Object) str, (Object) this.selectedCountry));
    }

    public final List<Country> filterCountries$jumio_defaultui_release(String str, List<Country> list) {
        Intrinsics.checkNotNullParameter(str, "filterText");
        Intrinsics.checkNotNullParameter(list, "countryList");
        if (StringsKt.trim(str).toString().length() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Country next : list) {
            if (StringsKt.contains((CharSequence) next.getName(), (CharSequence) str, true)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public int getItemCount() {
        return this.countries.size();
    }

    public final void updateViewWithFiltering(String str, List<Country> list) {
        Intrinsics.checkNotNullParameter(str, "filterText");
        Intrinsics.checkNotNullParameter(list, "countryList");
        this.countries.clear();
        this.countries.addAll(filterCountries$jumio_defaultui_release(str, list));
        notifyDataSetChanged();
    }

    public void onBindViewHolder(CountryViewHolder countryViewHolder, int i) {
        Intrinsics.checkNotNullParameter(countryViewHolder, "holder");
        Country country = this.countries.get(i);
        countryViewHolder.getTvCountry().setText(country.getName());
        checkIfSelected(countryViewHolder, country.getIsoCode());
    }

    public CountryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_country_selection_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new CountryViewHolder(inflate, new C20067a(this));
    }
}
