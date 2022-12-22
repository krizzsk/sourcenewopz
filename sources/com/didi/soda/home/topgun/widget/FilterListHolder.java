package com.didi.soda.home.topgun.widget;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.home.topgun.model.FilterModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/FilterListHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "resId", "", "(Landroid/view/ViewGroup;I)V", "bindData", "", "filterModel", "Lcom/didi/soda/home/topgun/model/FilterModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeFilterLayout.kt */
public abstract class FilterListHolder extends RecyclerView.ViewHolder {
    public abstract void bindData(FilterModel filterModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilterListHolder(ViewGroup viewGroup, int i) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false));
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }
}
