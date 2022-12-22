package com.adyen.checkout.components.p058ui.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import com.didi.autotracker.AutoTrackHelper;

/* renamed from: com.adyen.checkout.components.ui.adapter.ClickableListRecyclerAdapter */
public abstract class ClickableListRecyclerAdapter<ViewHolderT extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<ViewHolderT> {

    /* renamed from: a */
    static final String f896a = LogUtil.getTag();

    /* renamed from: b */
    OnItemCLickedListener f897b;

    /* renamed from: com.adyen.checkout.components.ui.adapter.ClickableListRecyclerAdapter$OnItemCLickedListener */
    public interface OnItemCLickedListener {
        void onItemClicked(int i);
    }

    public void onBindViewHolder(final ViewHolderT viewholdert, int i) {
        viewholdert.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Logger.m1076d(ClickableListRecyclerAdapter.f896a, "click");
                if (ClickableListRecyclerAdapter.this.f897b != null) {
                    ClickableListRecyclerAdapter.this.f897b.onItemClicked(viewholdert.getAdapterPosition());
                }
            }
        });
    }

    public void setItemCLickListener(OnItemCLickedListener onItemCLickedListener) {
        this.f897b = onItemCLickedListener;
    }
}
