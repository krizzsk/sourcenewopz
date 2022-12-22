package com.didi.component.service.cancelreason;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class CancelReasonContentVH extends AbsCancelReasonContentVH {
    public CancelReasonContentVH(View view) {
        super(LayoutInflater.from(view.getContext()).inflate(R.layout.vh_cancel_reason_content, (ViewGroup) view, false));
        this.tv_cancel_reason_content = (TextView) this.itemView.findViewById(R.id.tv_cancel_reason_content);
    }
}
