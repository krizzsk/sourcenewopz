package com.didi.component.common.contacts;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class GCommonBaseVH extends RecyclerView.ViewHolder {
    public abstract void setData(GCommonContactsModel gCommonContactsModel);

    public GCommonBaseVH(View view) {
        super(view);
    }
}
