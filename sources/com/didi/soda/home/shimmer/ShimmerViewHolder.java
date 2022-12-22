package com.didi.soda.home.shimmer;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public abstract class ShimmerViewHolder extends RecyclerView.ViewHolder {
    private List<View> mShimmerViews = new ArrayList();

    public ShimmerViewHolder(View view) {
        super(view);
    }

    public List<View> getShimmerView() {
        return this.mShimmerViews;
    }

    /* access modifiers changed from: protected */
    public void addShimmerView(View view) {
        if (view != null) {
            this.mShimmerViews.add(view);
        }
    }
}
