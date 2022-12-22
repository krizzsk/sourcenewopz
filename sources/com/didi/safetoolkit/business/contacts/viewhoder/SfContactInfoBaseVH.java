package com.didi.safetoolkit.business.contacts.viewhoder;

import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.safetoolkit.model.SfContactsModel;
import com.taxis99.R;

public class SfContactInfoBaseVH extends SfBaseVH {
    protected SfContactsModel mData;
    protected TextView sfContactName = ((TextView) this.itemView.findViewById(R.id.sf_contact_name));
    protected TextView sfContactPhoneNum = ((TextView) this.itemView.findViewById(R.id.sf_contact_phone_num));
    protected CheckBox sfContactSelectBtn = ((CheckBox) this.itemView.findViewById(R.id.sf_contact_select_btn));
    protected ImageView sfHeader = ((ImageView) this.itemView.findViewById(R.id.sf_contact_head_img));

    public SfContactInfoBaseVH(View view) {
        super(view);
    }

    public void setData(SfContactsModel sfContactsModel) {
        if (sfContactsModel != null) {
            this.mData = sfContactsModel;
            if (TextUtils.isEmpty(sfContactsModel.name)) {
                this.sfContactPhoneNum.setVisibility(8);
                this.sfContactName.setText(sfContactsModel.phone);
                return;
            }
            this.sfContactName.setText(sfContactsModel.name);
            this.sfContactPhoneNum.setVisibility(0);
            if (!TextUtils.isEmpty(sfContactsModel.phone_mask)) {
                this.sfContactPhoneNum.setText(sfContactsModel.phone_mask);
            } else {
                this.sfContactPhoneNum.setText(sfContactsModel.phone);
            }
        }
    }
}
