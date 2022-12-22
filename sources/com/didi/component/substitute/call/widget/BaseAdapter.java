package com.didi.component.substitute.call.widget;

import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.substitute.call.widget.BaseVH;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/component/substitute/call/widget/BaseAdapter;", "T", "Holder", "Lcom/didi/component/substitute/call/widget/BaseVH;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "()V", "mData", "", "getData", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "(Lcom/didi/component/substitute/call/widget/BaseVH;I)V", "setData", "data", "comp-substitute-call_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BaseAdapter.kt */
public abstract class BaseAdapter<T, Holder extends BaseVH<T>> extends RecyclerView.Adapter<Holder> {

    /* renamed from: a */
    private List<T> f16101a = new ArrayList();

    public void onBindViewHolder(Holder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bindData(this.f16101a.get(i));
    }

    public int getItemCount() {
        return this.f16101a.size();
    }

    public final void setData(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.f16101a = list;
        notifyDataSetChanged();
    }

    public final List<T> getData() {
        return this.f16101a;
    }
}
