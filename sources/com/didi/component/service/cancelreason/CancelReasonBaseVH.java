package com.didi.component.service.cancelreason;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class CancelReasonBaseVH<T> extends RecyclerView.ViewHolder {
    public abstract void setData(T t);

    public CancelReasonBaseVH(View view) {
        super(view);
    }
}
