package rui.widget.popup.base;

import rui.widget.popup.PopupView;
import rui.widget.popup.base.BasePopupModel;

public interface IPopupFactory<M extends BasePopupModel> {
    void create(PopupView popupView, M m);
}
