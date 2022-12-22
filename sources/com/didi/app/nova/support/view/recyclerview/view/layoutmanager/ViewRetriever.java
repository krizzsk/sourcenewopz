package com.didi.app.nova.support.view.recyclerview.view.layoutmanager;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;

interface ViewRetriever {
    RecyclerView.ViewHolder getViewHolderForPosition(int i);

    public static final class RecyclerViewRetriever implements ViewRetriever {
        private RecyclerView.ViewHolder currentViewHolder;
        private int currentViewType = -1;
        private final NovaRecyclerView recyclerView;

        RecyclerViewRetriever(RecyclerView recyclerView2) {
            this.recyclerView = (NovaRecyclerView) recyclerView2;
        }

        public RecyclerView.ViewHolder getViewHolderForPosition(int i) {
            int itemViewType = this.recyclerView.getAdapter().getItemViewType(i);
            if (this.currentViewType != itemViewType) {
                this.currentViewType = itemViewType;
                this.currentViewHolder = this.recyclerView.getAdapter().createViewHolder((ViewGroup) this.recyclerView.getParent(), this.currentViewType);
            }
            return this.currentViewHolder;
        }
    }
}
