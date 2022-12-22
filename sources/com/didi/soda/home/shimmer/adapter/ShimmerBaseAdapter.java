package com.didi.soda.home.shimmer.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.home.shimmer.ShimmerViewHolder;
import java.util.ArrayList;
import java.util.List;

public abstract class ShimmerBaseAdapter extends RecyclerView.Adapter<ShimmerViewHolder> {

    /* renamed from: a */
    private static final int f42734a = 9;

    /* renamed from: b */
    private List<List<View>> f42735b = new ArrayList();

    public int getItemCount() {
        return 9;
    }

    public void onBindViewHolder(ShimmerViewHolder shimmerViewHolder, int i) {
        mo107145a(shimmerViewHolder.getShimmerView());
    }

    public List<List<View>> getAnimationViewSet() {
        return this.f42735b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo107145a(List<View> list) {
        if (!CollectionsUtil.isEmpty(list)) {
            this.f42735b.add(list);
        }
    }
}
