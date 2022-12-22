package com.didiglobal.comp.carmodellist.optionarea.rideoption;

import android.view.View;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;

public abstract class AbsAnycarRideOptionPresenter {
    public abstract void bindData(AnyCarEstimateItemModel anyCarEstimateItemModel);

    public abstract void onClickable(View view);
}
