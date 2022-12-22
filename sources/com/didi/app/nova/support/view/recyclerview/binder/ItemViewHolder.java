package com.didi.app.nova.support.view.recyclerview.binder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder<T> extends RecyclerView.ViewHolder {
    private T mItem;
    private int mPositionInManager;

    public int getDragDirections() {
        return 0;
    }

    public int getMaxMoveX() {
        return -1;
    }

    public int getMaxMoveY() {
        return -1;
    }

    public int getMoveDirections() {
        return 0;
    }

    public void onMove(int i, float f, int i2, float f2) {
    }

    public void onMoveFinished() {
    }

    public ItemViewHolder(View view) {
        super(view);
    }

    public T getItem() {
        return this.mItem;
    }

    public void setItem(T t) {
        this.mItem = t;
    }

    public int getPositionInManager() {
        return this.mPositionInManager;
    }

    public void setPositionInManager(int i) {
        this.mPositionInManager = i;
    }

    /* access modifiers changed from: protected */
    public <S> S findViewById(int i) {
        return this.itemView.findViewById(i);
    }

    public boolean isMovable() {
        return getMoveDirections() != 0;
    }
}
