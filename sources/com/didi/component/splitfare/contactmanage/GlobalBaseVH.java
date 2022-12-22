package com.didi.component.splitfare.contactmanage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class GlobalBaseVH extends RecyclerView.ViewHolder {
    public abstract void setData(GlobalContactsModel globalContactsModel);

    public GlobalBaseVH(View view) {
        super(view);
    }
}
