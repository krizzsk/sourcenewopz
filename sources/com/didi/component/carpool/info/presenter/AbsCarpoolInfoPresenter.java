package com.didi.component.carpool.info.presenter;

import android.content.Context;
import com.didi.component.carpool.info.view.ICarpoolInfoView;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;

public abstract class AbsCarpoolInfoPresenter extends IPresenter<ICarpoolInfoView> {
    public abstract void onEditClick();

    public AbsCarpoolInfoPresenter(Context context) {
        super(context);
    }

    public AbsCarpoolInfoPresenter(ComponentParams componentParams) {
        super(componentParams);
    }
}
