package com.didi.entrega.home.shimmer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.entrega.home.shimmer.ShimmerViewHolder;
import com.taxis99.R;

public class ShimmerHomeFullAdapter extends ShimmerBaseAdapter {

    /* renamed from: a */
    private static final int f20735a = 0;

    /* renamed from: b */
    private static final int f20736b = 1;

    /* renamed from: c */
    private static final int f20737c = 2;

    /* renamed from: d */
    private static final int f20738d = 3;

    /* renamed from: e */
    private static final int f20739e = 4;

    public int getItemCount() {
        return 5;
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        return i == 3 ? 3 : 4;
    }

    public ShimmerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i == 0) {
            return new TitleViewHolder(from.inflate(R.layout.entrega_item_home_shimmer_title, viewGroup, false));
        }
        if (i == 1) {
            return new NameViewHolder(from.inflate(R.layout.entrega_item_home_shimmer_name, viewGroup, false));
        }
        if (i == 2) {
            return new DesViewHolder(from.inflate(R.layout.entrega_item_home_shimmer_des, viewGroup, false));
        }
        if (i == 3) {
            return new EnterViewHolder(from.inflate(R.layout.entrega_item_home_shimmer_enter, viewGroup, false));
        }
        return new CouponViewHolder(from.inflate(R.layout.entrega_item_home_shimmer_banner, viewGroup, false));
    }

    static class TitleViewHolder extends ShimmerViewHolder {
        TitleViewHolder(View view) {
            super(view);
            View findViewById = view.findViewById(R.id.entrega_view_shimmer_city);
            View findViewById2 = view.findViewById(R.id.entrega_view_shimmer_order_list);
            addShimmerView(findViewById);
            addShimmerView(findViewById2);
        }
    }

    static class NameViewHolder extends ShimmerViewHolder {
        NameViewHolder(View view) {
            super(view);
            View findViewById = view.findViewById(R.id.entrega_view_shimmer_name1);
            View findViewById2 = view.findViewById(R.id.entrega_view_shimmer_name2);
            View findViewById3 = view.findViewById(R.id.entrega_view_shimmer_name3);
            addShimmerView(findViewById);
            addShimmerView(findViewById2);
            addShimmerView(findViewById3);
        }
    }

    static class DesViewHolder extends ShimmerViewHolder {
        DesViewHolder(View view) {
            super(view);
            View findViewById = view.findViewById(R.id.entrega_view_shimmer_des1);
            View findViewById2 = view.findViewById(R.id.entrega_view_shimmer_des2);
            addShimmerView(findViewById);
            addShimmerView(findViewById2);
        }
    }

    static class EnterViewHolder extends ShimmerViewHolder {
        EnterViewHolder(View view) {
            super(view);
            addShimmerView(view.findViewById(R.id.entrega_view_shimmer_enter1));
        }
    }

    static class CouponViewHolder extends ShimmerViewHolder {
        CouponViewHolder(View view) {
            super(view);
            addShimmerView(view.findViewById(R.id.entrega_view_shimmer_banner));
        }
    }
}
