package rui.widget.popup.base;

import rui.widget.popup.base.IPopupFactory;

public class BasePopupModel<T extends IPopupFactory> {
    protected T factory;

    public T getFactory() {
        return this.factory;
    }
}
