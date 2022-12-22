package com.didi.payment.base.adapter;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.adapter.BaseViewHolder;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {
    protected final SparseArray<OnItemClickListener<T>> events = new SparseArray<>();
    protected final List<T> list = new ArrayList();

    public interface OnItemClickListener<T> {
        void onClick(T t, int i);
    }

    /* access modifiers changed from: protected */
    public abstract void onBindItem(VH vh, T t, int i);

    public void addItem(T t) {
        this.list.add(t);
        notifyDataSetChanged();
    }

    public void addItems(Collection<T> collection) {
        this.list.addAll(collection);
        notifyDataSetChanged();
    }

    public void setItems(Collection<T> collection) {
        this.list.clear();
        this.list.addAll(collection);
        notifyDataSetChanged();
    }

    public void removeItem(T t) {
        if (this.list.remove(t)) {
            notifyDataSetChanged();
        }
    }

    public void addClickListener(OnItemClickListener<T> onItemClickListener) {
        this.events.put(-1, onItemClickListener);
    }

    public void addClickListener(int i, OnItemClickListener<T> onItemClickListener) {
        this.events.put(i, onItemClickListener);
    }

    public T getItemAt(int i) {
        if (i < 0 || i >= this.list.size()) {
            return null;
        }
        return this.list.get(i);
    }

    public void onBindViewHolder(VH vh, final int i) {
        final Object itemAt = getItemAt(i);
        for (int i2 = 0; i2 < this.events.size(); i2++) {
            int keyAt = this.events.keyAt(i2);
            final OnItemClickListener onItemClickListener = this.events.get(keyAt);
            if (keyAt > 0) {
                View findViewById = vh.findViewById(keyAt);
                if (findViewById != null) {
                    findViewById.setOnClickListener(new DoubleCheckOnClickListener() {
                        public void doClick(View view) {
                            onItemClickListener.onClick(itemAt, i);
                        }
                    });
                }
            } else {
                vh.itemView.setOnClickListener(new DoubleCheckOnClickListener() {
                    public void doClick(View view) {
                        onItemClickListener.onClick(itemAt, i);
                    }
                });
            }
        }
        onBindItem(vh, itemAt, i);
    }

    public int getItemCount() {
        return this.list.size();
    }
}
