package com.didi.component.traveldetail;

import android.content.Context;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;

public abstract class AbsTravelDetailPresenterV2 extends IPresenter<ITravelDetailViewV2> {
    public abstract void onEditClick();

    public AbsTravelDetailPresenterV2(Context context) {
        super(context);
    }

    public AbsTravelDetailPresenterV2(ComponentParams componentParams) {
        super(componentParams);
    }
}
