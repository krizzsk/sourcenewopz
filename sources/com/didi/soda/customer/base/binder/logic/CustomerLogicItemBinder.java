package com.didi.soda.customer.base.binder.logic;

import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.base.binder.logic.BinderLogic;

public abstract class CustomerLogicItemBinder<L extends BinderLogic, T, VH extends ItemViewHolder<T>> extends ItemBinder<T, VH> {
    private L mBinderLogic;

    public abstract L onCreateBinderLogic();

    public CustomerLogicItemBinder() {
        initBinderLogic((ComponentLogicUnit) null);
    }

    public CustomerLogicItemBinder(ItemDecorator itemDecorator) {
        this(itemDecorator, (ComponentLogicUnit) null);
    }

    public CustomerLogicItemBinder(ComponentLogicUnit componentLogicUnit) {
        initBinderLogic(componentLogicUnit);
    }

    public CustomerLogicItemBinder(ItemDecorator itemDecorator, ComponentLogicUnit componentLogicUnit) {
        super(itemDecorator);
        initBinderLogic(componentLogicUnit);
    }

    public L getBinderLogic() {
        return this.mBinderLogic;
    }

    private void initBinderLogic(ComponentLogicUnit componentLogicUnit) {
        L onCreateBinderLogic = onCreateBinderLogic();
        this.mBinderLogic = onCreateBinderLogic;
        if (componentLogicUnit != null) {
            onCreateBinderLogic.attachLogicUnit(componentLogicUnit);
        }
    }
}
