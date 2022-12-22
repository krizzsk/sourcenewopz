package com.jumio.defaultui.view;

import androidx.appcompat.widget.SearchView;
import com.jumio.core.data.country.Country;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\b"}, mo175978d2 = {"com/jumio/defaultui/view/CountrySelectionFragment$initSearchView$1", "Landroidx/appcompat/widget/SearchView$OnQueryTextListener;", "", "s", "", "onQueryTextSubmit", "text", "onQueryTextChange", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: CountrySelectionFragment.kt */
public final class CountrySelectionFragment$initSearchView$1 implements SearchView.OnQueryTextListener {
    public final /* synthetic */ List<Country> $countryList;
    public final /* synthetic */ CountrySelectionFragment this$0;

    public CountrySelectionFragment$initSearchView$1(CountrySelectionFragment countrySelectionFragment, List<Country> list) {
        this.this$0 = countrySelectionFragment;
        this.$countryList = list;
    }

    public boolean onQueryTextChange(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.this$0.getCountySelectionAdapter().updateViewWithFiltering(str, this.$countryList);
        return true;
    }

    public boolean onQueryTextSubmit(String str) {
        return false;
    }
}
