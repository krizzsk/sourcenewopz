package com.didi.component.indriver;

import android.content.Context;
import com.didi.component.core.IPresenter;
import com.didi.component.indriver.IIndriverView;
import com.didi.component.indriver.model.DriverData;

public abstract class AbsIndriverPresenter<V extends IIndriverView> extends IPresenter<V> {
    public abstract void engineCommit(boolean z, boolean z2);

    public abstract void expandView(boolean z);

    public abstract void removeItem(DriverData driverData);

    public AbsIndriverPresenter(Context context) {
        super(context);
    }
}
