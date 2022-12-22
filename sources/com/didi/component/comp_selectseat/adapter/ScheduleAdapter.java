package com.didi.component.comp_selectseat.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.util.GLog;
import com.didi.component.comp_selectseat.model.ScheduleItemModel;
import com.didi.component.comp_selectseat.model.ShiftBean;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleViewHolder> {

    /* renamed from: a */
    private static final String f12380a = "ScheduleAdapter";

    /* renamed from: b */
    private final Context f12381b;

    /* renamed from: c */
    private final List<ScheduleItemModel> f12382c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final FrequencySelectClickListener f12383d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final List<Boolean> f12384e = new ArrayList();

    public ScheduleAdapter(Context context, FrequencySelectClickListener frequencySelectClickListener) {
        this.f12381b = context;
        this.f12383d = frequencySelectClickListener;
    }

    public int getItemViewType(int i) {
        return this.f12382c.get(i).getViewType();
    }

    public ScheduleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ScheduleViewHolder(LayoutInflater.from(this.f12381b).inflate(i == ScheduleItemModel.ITEM_TYPE_TITLE ? R.layout.schedule_title_layout : R.layout.schedule_shift_layout, viewGroup, false), i);
    }

    public void onBindViewHolder(ScheduleViewHolder scheduleViewHolder, final int i) {
        ScheduleItemModel scheduleItemModel = this.f12382c.get(i);
        if (scheduleItemModel == null) {
            m8411a("getShiftsBean is null");
        } else if (scheduleItemModel.getViewType() != ScheduleItemModel.ITEM_TYPE_TITLE) {
            if (this.f12384e.get(i).booleanValue()) {
                scheduleViewHolder.mSelectedIcon.setImageResource(R.drawable.icon_minibus_selected);
            } else {
                scheduleViewHolder.mSelectedIcon.setImageResource(R.drawable.icon_minibus_unselected);
            }
            if (scheduleItemModel.getShiftsBean() != null) {
                final ShiftBean shiftsBean = scheduleItemModel.getShiftsBean();
                if (shiftsBean.pickup == null || TextUtils.isEmpty(shiftsBean.pickup.getContent())) {
                    m8411a("pickup is null");
                } else {
                    shiftsBean.pickup.bindTextView(scheduleViewHolder.mPickup);
                }
                if (shiftsBean.dropoff == null || TextUtils.isEmpty(shiftsBean.dropoff.getContent())) {
                    m8411a("dropoff is null");
                } else {
                    shiftsBean.dropoff.bindTextView(scheduleViewHolder.mDropOff);
                }
                if (shiftsBean.show_travel_mark == 0) {
                    scheduleViewHolder.mStartIcon.setVisibility(8);
                } else {
                    scheduleViewHolder.mStartIcon.setVisibility(0);
                }
                scheduleViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (((Boolean) ScheduleAdapter.this.f12384e.get(i)).booleanValue()) {
                            ScheduleAdapter.this.m8409a(i, false);
                            ScheduleAdapter.this.f12383d.onFrequencySelectClick(false, shiftsBean, i);
                            return;
                        }
                        ScheduleAdapter.this.m8409a(i, true);
                        ScheduleAdapter.this.f12383d.onFrequencySelectClick(true, shiftsBean, i);
                    }
                });
                return;
            }
            m8411a("etTitleBean() is null or content is null");
        } else if (scheduleItemModel.getTitleBean() == null || TextUtils.isEmpty(scheduleItemModel.getTitleBean().getContent())) {
            m8411a("etTitleBean() is null or content is null");
        } else {
            scheduleItemModel.getTitleBean().bindTextView(scheduleViewHolder.mTitle);
        }
    }

    /* renamed from: a */
    private void m8411a(String str) {
        GLog.m7968e(f12380a, str);
    }

    public int getItemCount() {
        return this.f12382c.size();
    }

    public void setDate(List<ScheduleItemModel> list) {
        this.f12382c.clear();
        this.f12382c.addAll(list);
        m8409a(0, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8409a(int i, boolean z) {
        this.f12384e.clear();
        for (int i2 = 0; i2 < this.f12382c.size(); i2++) {
            this.f12384e.add(false);
        }
        if (z) {
            this.f12384e.set(i, true);
        }
        notifyDataSetChanged();
    }
}
