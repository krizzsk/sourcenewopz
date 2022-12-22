package com.didi.component.splitfare.contactmanage;

import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.taxis99.R;

public class GlobalContactInfoBaseVH extends GlobalBaseVH {
    protected TextView mContactName = ((TextView) this.itemView.findViewById(R.id.g_contact_name));
    protected TextView mContactPhoneNum = ((TextView) this.itemView.findViewById(R.id.g_contact_phone_num));
    protected CheckBox mContactSelectBtn = ((CheckBox) this.itemView.findViewById(R.id.g_contact_select_btn));
    protected GlobalContactsModel mData;
    protected ImageView mHeader = ((ImageView) this.itemView.findViewById(R.id.g_contact_head_img));

    public GlobalContactInfoBaseVH(View view) {
        super(view);
    }

    public void setData(GlobalContactsModel globalContactsModel) {
        if (globalContactsModel != null) {
            this.mData = globalContactsModel;
            if (TextUtils.isEmpty(globalContactsModel.name)) {
                this.mContactPhoneNum.setVisibility(8);
                this.mContactName.setText(globalContactsModel.phone);
                return;
            }
            this.mContactName.setText(globalContactsModel.name);
            this.mContactPhoneNum.setVisibility(0);
            this.mContactPhoneNum.setText(globalContactsModel.phone);
        }
    }
}
