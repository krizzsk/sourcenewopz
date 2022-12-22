package com.didiglobal.comp.carmodellist;

import androidx.recyclerview.widget.RecyclerView;
import com.didiglobal.comp.carmodellist.BaseVH;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T, Holder extends BaseVH<T>> extends RecyclerView.Adapter<Holder> {

    /* renamed from: a */
    private List<T> f49775a = new ArrayList();

    public void onBindViewHolder(Holder holder, int i) {
        holder.bindData(this.f49775a.get(i));
    }

    public int getItemCount() {
        return this.f49775a.size();
    }

    public void setData(List<T> list) {
        this.f49775a = list;
        notifyDataSetChanged();
    }
}
