package com.didi.component.comp_selectseat.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.comp_selectseat.model.ScheduleItemModel;
import com.taxis99.R;

public class ScheduleViewHolder extends RecyclerView.ViewHolder {
    public TextView mDropOff;
    public TextView mPickup;
    public ImageView mSelectedIcon;
    public ImageView mStartIcon;
    public TextView mTitle;

    public ScheduleViewHolder(View view, int i) {
        super(view);
        if (i == ScheduleItemModel.ITEM_TYPE_TITLE) {
            this.mTitle = (TextView) view.findViewById(R.id.tv_schedule_item_title);
            return;
        }
        this.mStartIcon = (ImageView) view.findViewById(R.id.iv_start);
        this.mDropOff = (TextView) view.findViewById(R.id.tv_dropoff);
        this.mSelectedIcon = (ImageView) view.findViewById(R.id.iv_shift_select);
        this.mPickup = (TextView) view.findViewById(R.id.tv_pickup);
    }
}
