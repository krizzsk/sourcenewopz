package com.didi.component.service.cancelreason.newcr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.component.service.cancelreason.CancelReasonBaseVH;
import com.didi.travel.psnger.model.response.CancelReasonInfo;
import com.taxis99.R;

public class NewCancelReasonTitleVH extends CancelReasonBaseVH<CancelReasonInfo> {
    public TextView tv_cancel_reason_title = ((TextView) this.itemView.findViewById(R.id.tv_cancel_reason_title));

    public NewCancelReasonTitleVH(View view) {
        super(LayoutInflater.from(view.getContext()).inflate(R.layout.new_vh_cancel_reason_title, (ViewGroup) view, false));
    }

    public void setData(CancelReasonInfo cancelReasonInfo) {
        if (cancelReasonInfo != null && cancelReasonInfo.title != null) {
            this.tv_cancel_reason_title.setText(cancelReasonInfo.title);
        }
    }
}
