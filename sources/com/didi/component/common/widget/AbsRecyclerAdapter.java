package com.didi.component.common.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.common.util.GLog;
import com.didi.component.common.widget.AbsViewBinder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbsRecyclerAdapter<T extends AbsViewBinder, V> extends RecyclerView.Adapter<T> {
    private LayoutInflater mInflater;
    protected List<V> mList;

    /* access modifiers changed from: protected */
    public abstract View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, int i);

    /* access modifiers changed from: protected */
    public abstract T createViewHolder(View view);

    public AbsRecyclerAdapter(Context context) {
        if (context == null) {
            GLog.m7967e("Context should not be null");
            return;
        }
        this.mList = new ArrayList();
        this.mInflater = LayoutInflater.from(context);
    }

    public T onCreateViewHolder(ViewGroup viewGroup, int i) {
        return createViewHolder(createView(this.mInflater, viewGroup, i));
    }

    public final void onBindViewHolder(T t, int i) {
        V v = this.mList.get(i);
        t.setData(v);
        t.bind(v);
    }

    public int getItemCount() {
        return this.mList.size();
    }

    public final void append(V v) {
        if (v != null) {
            this.mList.add(v);
            notifyDataSetChanged();
        }
    }

    public void append(V v, int i) {
        if (v != null) {
            if (i < 0) {
                i = 0;
            } else if (i > this.mList.size()) {
                i = this.mList.size();
            }
            this.mList.add(i, v);
            notifyDataSetChanged();
        }
    }

    public final void append(Collection<V> collection) {
        if (collection != null && collection.size() != 0) {
            this.mList.addAll(collection);
            notifyDataSetChanged();
        }
    }

    public final void clear() {
        if (!this.mList.isEmpty()) {
            this.mList.clear();
            notifyDataSetChanged();
        }
    }

    public final void remove(V v) {
        if (v != null && this.mList.contains(v)) {
            this.mList.remove(v);
            notifyDataSetChanged();
        }
    }

    public final void remove(Collection<V> collection) {
        if (collection != null && collection.size() != 0 && this.mList.removeAll(collection)) {
            notifyDataSetChanged();
        }
    }

    public void update(V v) {
        int indexOf;
        if (v != null && (indexOf = this.mList.indexOf(v)) != -1) {
            this.mList.set(indexOf, v);
            notifyDataSetChanged();
        }
    }

    public void update(Collection<V> collection) {
        List<V> list = this.mList;
        if (list != null && list.size() > 0) {
            this.mList.clear();
        }
        if (collection != null && collection.size() > 0) {
            this.mList.addAll(collection);
        }
        notifyDataSetChanged();
    }

    public List<V> getData() {
        return new ArrayList(this.mList);
    }

    public void refresh() {
        notifyDataSetChanged();
    }
}
