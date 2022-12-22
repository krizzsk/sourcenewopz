package com.didi.component.service.cancelreason;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.component.service.cancelreason.model.CRListModel;
import com.taxis99.R;

public class CancelReasonSubTitleVH extends CancelReasonBaseVH<CRListModel> {
    public TextView tv_cancel_reason_sub_title = ((TextView) this.itemView.findViewById(R.id.tv_cancel_reason_sub_title));

    public CancelReasonSubTitleVH(View view) {
        super(LayoutInflater.from(view.getContext()).inflate(R.layout.vh_cancel_reason_sub_title, (ViewGroup) view, false));
    }

    public void setData(CRListModel cRListModel) {
        if (cRListModel != null && cRListModel.text != null) {
            this.tv_cancel_reason_sub_title.setText(cRListModel.text);
        }
    }
}
