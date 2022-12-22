package com.didi.safetoolkit.business.areaCode;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.safetoolkit.business.contacts.viewhoder.SfContactInfoBaseVH;
import com.taxis99.R;

public class SfContactInfoBaseVH4Guide extends SfContactInfoBaseVH {
    public SfContactInfoBaseVH4Guide(View view) {
        super(LayoutInflater.from(view.getContext()).inflate(R.layout.sf_contacts_info_layout, (ViewGroup) view, false));
        this.itemView.setPadding(0, this.itemView.getPaddingTop(), this.itemView.getPaddingRight(), this.itemView.getPaddingBottom());
        this.itemView.findViewById(R.id.sf_contact_select_btn).setVisibility(8);
    }
}
