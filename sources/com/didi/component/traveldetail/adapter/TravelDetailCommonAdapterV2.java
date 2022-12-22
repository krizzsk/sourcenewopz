package com.didi.component.traveldetail.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.traveldetail.model.TravelDetailItemV2;
import com.didi.component.traveldetail.viewholder.CommonPointViewHolderV2;
import java.util.ArrayList;
import java.util.List;

public class TravelDetailCommonAdapterV2 extends RecyclerView.Adapter<CommonPointViewHolderV2> {

    /* renamed from: a */
    private List<TravelDetailItemV2> f16154a = new ArrayList();

    public void setTravelDetailList(List<TravelDetailItemV2> list) {
        this.f16154a = list;
        notifyDataSetChanged();
    }

    public CommonPointViewHolderV2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CommonPointViewHolderV2(viewGroup);
    }

    public void onBindViewHolder(CommonPointViewHolderV2 commonPointViewHolderV2, int i) {
        commonPointViewHolderV2.bindData(this.f16154a.get(i));
    }

    public int getItemCount() {
        List<TravelDetailItemV2> list = this.f16154a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
