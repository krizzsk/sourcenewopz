package com.didiglobal.comp.carmodellist.optionarea.xml;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.component.business.util.UiUtils;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didiglobal.comp.carmodellist.BaseVH;

public class XMLVH extends BaseVH<AnyCarEstimateItemModel> {
    public void bindData(AnyCarEstimateItemModel anyCarEstimateItemModel) {
    }

    public XMLVH(ViewGroup viewGroup) {
        super(new FrameLayout(viewGroup.getContext()));
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, UiUtils.dip2px(viewGroup.getContext(), 36.0f)));
        this.itemView.setPadding(UiUtils.dip2px(viewGroup.getContext(), 9.0f), 0, 0, 0);
    }
}
