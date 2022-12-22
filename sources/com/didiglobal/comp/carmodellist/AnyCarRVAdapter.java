package com.didiglobal.comp.carmodellist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didiglobal.comp.carmodellist.common.AnyCarSelectListener;
import com.taxis99.R;

public class AnyCarRVAdapter extends BaseAdapter<AnyCarEstimateItemModel, AnyCarVH> {

    /* renamed from: a */
    private final Context f49760a;

    /* renamed from: b */
    private AnyCarSelectListener f49761b;

    public AnyCarRVAdapter(Context context) {
        this.f49760a = context;
    }

    public void setSelectListener(AnyCarSelectListener anyCarSelectListener) {
        this.f49761b = anyCarSelectListener;
    }

    public AnyCarVH onCreateViewHolder(ViewGroup viewGroup, int i) {
        AnyCarVH anyCarVH = new AnyCarVH(LayoutInflater.from(this.f49760a).inflate(R.layout.anycar_model_estimate_item_layout, viewGroup, false));
        anyCarVH.setSelectListener(this.f49761b);
        return anyCarVH;
    }
}
