package com.didi.component.service.cancelreason.newcr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.component.service.cancelreason.AbsCancelReasonContentVH;
import com.taxis99.R;

public class NewCancelReasonContentVH extends AbsCancelReasonContentVH {
    public NewCancelReasonContentVH(View view) {
        super(LayoutInflater.from(view.getContext()).inflate(R.layout.new_vh_cancel_reason_content, (ViewGroup) view, false));
        this.tv_cancel_reason_content = (TextView) this.itemView.findViewById(R.id.tv_cancel_reason_content);
    }
}
