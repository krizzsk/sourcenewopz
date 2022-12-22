package com.didi.component.homedestination.abs;

import com.didi.component.business.model.HomeCardModel;
import com.didi.component.common.model.HomeCouponPerception;
import com.didi.component.core.IView;
import com.didi.component.homedestination.abs.AbsHomeDestinationPresenter;
import java.util.List;

public interface AbsHomeDestinationView<T extends AbsHomeDestinationPresenter> extends IView<T> {
    void clearRecData();

    void hideCouponPerception();

    void hideRecList();

    boolean isRecListShown();

    boolean isVisibility();

    void setRecData(List<HomeCardModel> list);

    void setVisibility(int i);

    void setVisibility(int i, Runnable runnable);

    void showCouponPerception(HomeCouponPerception homeCouponPerception);

    void showRecList();
}
