package com.didiglobal.comp.carmodellist;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseVH<T> extends RecyclerView.ViewHolder {
    public abstract void bindData(T t);

    public BaseVH(View view) {
        super(view);
    }
}
