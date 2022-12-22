package com.didi.app.nova.support.view.recyclerview.data;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.util.DiffUtilCallback;
import com.didi.app.nova.support.view.recyclerview.util.PayloadProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ChildDataListManager<T> extends BaseDataManager<T> {

    /* renamed from: a */
    final PayloadProvider<T> f8608a;

    public ChildDataListManager(NovaRecyclerAdapter novaRecyclerAdapter) {
        this(novaRecyclerAdapter, new ArrayList());
    }

    public ChildDataListManager(NovaRecyclerAdapter novaRecyclerAdapter, List<T> list) {
        this(novaRecyclerAdapter, list, new PayloadProvider<T>() {
            public Object getChangePayload(T t, T t2) {
                return null;
            }

            public boolean areContentsTheSame(T t, T t2) {
                return t.equals(t2);
            }
        });
    }

    public ChildDataListManager(NovaRecyclerAdapter novaRecyclerAdapter, List<T> list, PayloadProvider<T> payloadProvider) {
        super(novaRecyclerAdapter);
        for (T t : list) {
            if (t == null) {
                throw new IllegalStateException("item should not be null ");
            }
        }
        this.f8608a = payloadProvider;
        this.mDataList.addAll(list);
    }

    public void add(T t) {
        if (t != null) {
            this.mDataList.add(t);
            onInserted(this.mDataList.size() - 1, 1);
            return;
        }
        throw new IllegalStateException("item should not be null ");
    }

    public void add(int i, T t) {
        if (t != null) {
            this.mDataList.add(i, t);
            onInserted(i, 1);
            return;
        }
        throw new IllegalStateException("item should not be null ");
    }

    public void addAll(Collection<? extends T> collection) {
        addAll(this.mDataList.size(), collection);
    }

    public void addAll(int i, Collection<? extends T> collection) {
        for (Object obj : collection) {
            if (obj == null) {
                throw new IllegalStateException("item should not be null ");
            }
        }
        this.mDataList.addAll(i, collection);
        onInserted(i, collection.size());
    }

    public int indexOf(T t) {
        return this.mDataList.indexOf(t);
    }

    public void set(int i, T t) {
        if (t != null) {
            this.mDataList.set(i, t);
            onChanged(i, 1, (Object) null);
            return;
        }
        throw new IllegalStateException("item should not be null ");
    }

    public void set(List<T> list) {
        for (T t : list) {
            if (t == null) {
                throw new IllegalStateException("item should not be null ");
            }
        }
        if (this.mDataList.isEmpty()) {
            this.mDataList.addAll(list);
            onInserted(0, list.size());
            return;
        }
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtilCallback<T>(this.mDataList, list) {
            public boolean areContentsTheSame(T t, T t2) {
                return ChildDataListManager.this.f8608a.areContentsTheSame(t, t2);
            }

            public Object getChangePayload(T t, T t2) {
                return ChildDataListManager.this.f8608a.getChangePayload(t, t2);
            }
        });
        this.mDataList = new ArrayList(list);
        calculateDiff.dispatchUpdatesTo((ListUpdateCallback) this);
    }

    public void remove(int i) {
        if (i < size()) {
            this.mDataList.remove(i);
            onRemoved(i, 1);
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public void clear() {
        int size = size();
        if (size > 0) {
            this.mDataList.clear();
            onRemoved(0, size);
        }
    }
}
