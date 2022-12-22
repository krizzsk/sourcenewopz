package com.didi.component.travelGroupInfo;

import android.content.Context;
import com.didi.component.core.IPresenter;
import com.didi.component.core.IViewContainer;

public abstract class AbsTravelGroupInfoPresenterV2 extends IPresenter<ITravelGroupInfoViewV2> {
    public abstract void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator);

    public AbsTravelGroupInfoPresenterV2(Context context) {
        super(context);
    }
}
