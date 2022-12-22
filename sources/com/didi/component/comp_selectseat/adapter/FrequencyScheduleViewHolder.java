package com.didi.component.comp_selectseat.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.taxis99.R;

public class FrequencyScheduleViewHolder extends RecyclerView.ViewHolder {
    public RecyclerView mRv;

    public FrequencyScheduleViewHolder(View view) {
        super(view);
        this.mRv = (RecyclerView) view.findViewById(R.id.rv_schedule);
    }
}
