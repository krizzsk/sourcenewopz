package com.didi.app.nova.support.view.recyclerview.data;

import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;

public final class ChildDataItemManager<T> extends BaseDataManager<T> {
    public ChildDataItemManager(NovaRecyclerAdapter novaRecyclerAdapter) {
        super(novaRecyclerAdapter);
    }

    public ChildDataItemManager(NovaRecyclerAdapter novaRecyclerAdapter, T t) {
        super(novaRecyclerAdapter);
        if (t != null) {
            this.mDataList.add(t);
            return;
        }
        throw new IllegalStateException("item should not be null ");
    }

    public void setItem(T t) {
        if (t == null) {
            throw new IllegalStateException("item should not be null ");
        } else if (this.mDataList.size() == 0) {
            this.mDataList.add(t);
            onInserted(0, 1);
        } else {
            this.mDataList.set(0, t);
            onChanged(0, 1, (Object) null);
        }
    }

    public void removeItem() {
        if (this.mDataList.size() > 0) {
            this.mDataList.clear();
            onRemoved(0, 1);
        }
    }
}
