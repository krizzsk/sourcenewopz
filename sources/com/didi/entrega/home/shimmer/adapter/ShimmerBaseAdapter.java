package com.didi.entrega.home.shimmer.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.entrega.customer.foundation.util.CollectionsUtil;
import com.didi.entrega.home.shimmer.ShimmerViewHolder;
import java.util.ArrayList;
import java.util.List;

public abstract class ShimmerBaseAdapter extends RecyclerView.Adapter<ShimmerViewHolder> {

    /* renamed from: a */
    private static final int f20733a = 9;

    /* renamed from: b */
    private final List<List<View>> f20734b = new ArrayList();

    public int getItemCount() {
        return 9;
    }

    public void onBindViewHolder(ShimmerViewHolder shimmerViewHolder, int i) {
        mo61861a(shimmerViewHolder.getShimmerView());
    }

    public List<List<View>> getAnimationViewSet() {
        return this.f20734b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo61861a(List<View> list) {
        if (!CollectionsUtil.isEmpty(list)) {
            this.f20734b.add(list);
        }
    }
}
