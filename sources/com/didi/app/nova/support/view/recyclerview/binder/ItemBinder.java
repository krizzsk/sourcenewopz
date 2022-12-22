package com.didi.app.nova.support.view.recyclerview.binder;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecoratorOver;
import com.didi.app.nova.support.view.recyclerview.listener.ItemDragListener;
import java.util.ArrayList;
import java.util.List;

public abstract class ItemBinder<T, VH extends ItemViewHolder<T>> {
    private List<ItemDecorator> mItemDecorators;
    private ItemDragListener mItemDragListener;

    public abstract void bind(VH vh, T t);

    public abstract Class<T> bindDataType();

    public abstract VH create(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public boolean extraCanBindCondition(T t) {
        return true;
    }

    public int getColumnCount() {
        return 1;
    }

    public void onRecycled(VH vh) {
    }

    public ItemBinder() {
    }

    public ItemBinder(ItemDecorator itemDecorator) {
        addDecorator(itemDecorator);
    }

    public final void bindViewHolder(VH vh, T t, int i) {
        vh.setItem(t);
        vh.setPositionInManager(i);
        bind(vh, t);
    }

    public final boolean canBindData(Object obj) {
        return bindDataType().equals(obj.getClass()) && extraCanBindCondition(obj);
    }

    public final void addDecorator(ItemDecorator itemDecorator) {
        addDecorator(itemDecorator, -1);
    }

    public final void addDecorator(ItemDecorator itemDecorator, int i) {
        if (this.mItemDecorators == null) {
            this.mItemDecorators = new ArrayList();
        }
        if (i < 0 || this.mItemDecorators.size() <= i) {
            this.mItemDecorators.add(itemDecorator);
        } else {
            this.mItemDecorators.add(i, itemDecorator);
        }
    }

    public final void setItemDragListener(ItemDragListener itemDragListener) {
        this.mItemDragListener = itemDragListener;
    }

    public final void startDrag(ItemViewHolder itemViewHolder) {
        ItemDragListener itemDragListener = this.mItemDragListener;
        if (itemDragListener != null) {
            itemDragListener.startDrag(itemViewHolder);
        }
    }

    public boolean isItemDecorationEnabled() {
        return this.mItemDecorators != null;
    }

    public void getItemOffsets(Rect rect, int i, int i2) {
        List<ItemDecorator> list = this.mItemDecorators;
        if (list != null) {
            for (ItemDecorator itemOffsets : list) {
                itemOffsets.getItemOffsets(rect, i, i2);
            }
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, int i, int i2) {
        List<ItemDecorator> list = this.mItemDecorators;
        if (list != null) {
            for (ItemDecorator onDraw : list) {
                onDraw.onDraw(canvas, recyclerView, view, i, i2);
            }
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, int i, int i2) {
        List<ItemDecorator> list = this.mItemDecorators;
        if (list != null) {
            for (ItemDecorator next : list) {
                if (next instanceof ItemDecoratorOver) {
                    ((ItemDecoratorOver) next).onDrawOver(canvas, recyclerView, view, i, i2);
                }
            }
        }
    }
}
