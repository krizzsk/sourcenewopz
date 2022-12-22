package com.didi.component.service.cancelreason.newcr;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.component.service.cancelreason.CancelReasonBaseVH;
import com.didi.component.service.cancelreason.model.CRListModel;
import com.taxis99.R;

public class NewCancelReasonSubTitleVH extends CancelReasonBaseVH<CRListModel> {

    /* renamed from: a */
    private TextView f15772a = ((TextView) this.itemView.findViewById(R.id.tv_cancel_reason_sub_title));

    /* renamed from: b */
    private ImageView f15773b = ((ImageView) this.itemView.findViewById(R.id.img_cancel_reason_sub_title_icon));

    public NewCancelReasonSubTitleVH(View view) {
        super(LayoutInflater.from(view.getContext()).inflate(R.layout.new_vh_cancel_reason_sub_title, (ViewGroup) view, false));
    }

    public void setData(CRListModel cRListModel) {
        if (cRListModel != null && cRListModel.text != null) {
            this.f15772a.setText(cRListModel.text);
            if (!TextUtils.isEmpty(cRListModel.icon)) {
                Context context = this.f15773b.getContext();
                ((RequestBuilder) Glide.with(context).load(cRListModel.icon).placeholder(context.getResources().getDrawable(R.drawable.cancel_reason_icon))).into(this.f15773b);
            }
        }
    }
}
