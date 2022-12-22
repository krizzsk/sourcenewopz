package com.didi.app.nova.support.view.recyclerview.util;

import androidx.recyclerview.widget.DiffUtil;
import java.util.List;

public abstract class DiffUtilCallback<M> extends DiffUtil.Callback {
    private final List<M> newList;
    private final List<M> oldList;

    public abstract boolean areContentsTheSame(M m, M m2);

    public abstract Object getChangePayload(M m, M m2);

    protected DiffUtilCallback(List<M> list, List<M> list2) {
        this.oldList = list;
        this.newList = list2;
    }

    public int getOldListSize() {
        return this.oldList.size();
    }

    public int getNewListSize() {
        return this.newList.size();
    }

    public boolean areItemsTheSame(int i, int i2) {
        return this.oldList.get(i).equals(this.newList.get(i2));
    }

    public boolean areContentsTheSame(int i, int i2) {
        return areContentsTheSame(this.oldList.get(i), this.newList.get(i2));
    }

    public Object getChangePayload(int i, int i2) {
        Object changePayload = getChangePayload(this.oldList.get(i), this.newList.get(i2));
        return changePayload != null ? changePayload : super.getChangePayload(i, i2);
    }
}
