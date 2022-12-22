package com.didi.app.nova.support.view.recyclerview.view;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;

/* renamed from: com.didi.app.nova.support.view.recyclerview.view.a */
/* compiled from: ItemBinderTouchCallback */
class C3792a extends ItemTouchHelper.Callback {

    /* renamed from: a */
    private final NovaRecyclerAdapter f8627a;

    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    public boolean isLongPressDragEnabled() {
        return false;
    }

    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
    }

    C3792a(NovaRecyclerAdapter novaRecyclerAdapter) {
        this.f8627a = novaRecyclerAdapter;
    }

    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof ItemViewHolder) {
            return makeMovementFlags(((ItemViewHolder) viewHolder).getDragDirections(), 0);
        }
        return -1;
    }

    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        if (viewHolder.getItemViewType() != viewHolder2.getItemViewType()) {
            return false;
        }
        this.f8627a.moveData(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
        return true;
    }
}
