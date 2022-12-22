package com.didi.component.mapflow.view;

import com.didi.component.core.IView;
import com.didi.component.mapflow.presenter.AbsMapFlowDelegatePresenter;
import com.didi.component.mapflow.view.widget.MapOverlayViewGroup;
import com.didi.map.global.flow.MapFlowView;

public interface IMapFlowDelegateView extends IView<AbsMapFlowDelegatePresenter> {
    void addBottomMask(int i);

    void dismissMapOverlayView();

    void dismissPopup();

    MapFlowView getMapFlowView();

    void removeBottomMask();

    void showMapOverlayView(MapOverlayViewGroup.OverlayViewsBuilder overlayViewsBuilder);

    void showPopup(String str, int i, int i2);
}
