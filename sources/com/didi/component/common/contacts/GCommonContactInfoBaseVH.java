package com.didi.component.common.contacts;

import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.taxis99.R;

public class GCommonContactInfoBaseVH extends GCommonBaseVH {
    protected TextView mContactName = ((TextView) this.itemView.findViewById(R.id.g_contact_name));
    protected TextView mContactPhoneNum = ((TextView) this.itemView.findViewById(R.id.g_contact_phone_num));
    protected CheckBox mContactSelectBtn = ((CheckBox) this.itemView.findViewById(R.id.g_contact_select_btn));
    protected GCommonContactsModel mData;

    public GCommonContactInfoBaseVH(View view) {
        super(view);
    }

    public void setData(GCommonContactsModel gCommonContactsModel) {
        if (gCommonContactsModel != null) {
            this.mData = gCommonContactsModel;
            if (TextUtils.isEmpty(gCommonContactsModel.name)) {
                this.mContactPhoneNum.setVisibility(8);
                this.mContactName.setText(gCommonContactsModel.phone);
                return;
            }
            this.mContactName.setText(gCommonContactsModel.name);
            this.mContactPhoneNum.setVisibility(0);
            this.mContactPhoneNum.setText(gCommonContactsModel.phone);
        }
    }
}
