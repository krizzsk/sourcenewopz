package com.didi.component.service.activity.risk;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class RiskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    /* renamed from: a */
    ImageView f15684a;

    /* renamed from: b */
    TextView f15685b;

    /* renamed from: c */
    TextView f15686c;

    /* renamed from: d */
    private OnClickListener f15687d;

    public interface OnClickListener {
        void onClick(View view, RiskViewHolder riskViewHolder, int i);
    }

    public RiskViewHolder(View view) {
        super(view);
        this.f15684a = (ImageView) view.findViewById(R.id.risk_user_icon);
        this.f15685b = (TextView) view.findViewById(R.id.risk_user_title);
        this.f15686c = (TextView) view.findViewById(R.id.risk_user_error_label);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        OnClickListener onClickListener = this.f15687d;
        if (onClickListener != null) {
            onClickListener.onClick(view, this, getAdapterPosition());
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f15687d = onClickListener;
        this.itemView.setOnClickListener(this);
    }
}
