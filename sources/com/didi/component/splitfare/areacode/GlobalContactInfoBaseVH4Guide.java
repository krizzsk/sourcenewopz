package com.didi.component.splitfare.areacode;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.didi.component.splitfare.contactmanage.GlobalContactInfoBaseVH;
import com.taxis99.R;

public class GlobalContactInfoBaseVH4Guide extends GlobalContactInfoBaseVH {
    public GlobalContactInfoBaseVH4Guide(ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g_contacts_info_layout, viewGroup, false));
        this.itemView.setPadding(0, this.itemView.getPaddingTop(), this.itemView.getPaddingRight(), this.itemView.getPaddingBottom());
        this.itemView.findViewById(R.id.g_contact_select_btn).setVisibility(8);
    }
}
