package com.didi.component.comp_anycarlist;

import android.content.Context;
import com.didi.component.core.IPresenter;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;

public abstract class AbsAnyCarListPresenter extends IPresenter<IAnyCarListView> {
    public abstract void bubbleSelected(AnyCarEstimateItemModel anyCarEstimateItemModel);

    public AbsAnyCarListPresenter(Context context) {
        super(context);
    }
}
