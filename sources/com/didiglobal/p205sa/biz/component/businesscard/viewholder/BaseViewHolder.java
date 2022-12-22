package com.didiglobal.p205sa.biz.component.businesscard.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: com.didiglobal.sa.biz.component.businesscard.viewholder.BaseViewHolder */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    public abstract void setData(T t);

    public BaseViewHolder(View view) {
        super(view);
    }
}
