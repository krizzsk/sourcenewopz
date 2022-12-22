package com.didi.entrega.customer.base.binder.logic;

import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.entrega.customer.base.binder.ComponentLogicUnit;
import com.didi.entrega.customer.base.binder.logic.BinderLogic;

public abstract class CustomerLogicItemBinder<L extends BinderLogic, T, VH extends ItemViewHolder<T>> extends ItemBinder<T, VH> {

    /* renamed from: a */
    private L f19806a;

    public abstract L onCreateBinderLogic();

    public CustomerLogicItemBinder() {
        m14678a((ComponentLogicUnit) null);
    }

    public CustomerLogicItemBinder(ItemDecorator itemDecorator) {
        this(itemDecorator, (ComponentLogicUnit) null);
    }

    public CustomerLogicItemBinder(ComponentLogicUnit componentLogicUnit) {
        m14678a(componentLogicUnit);
    }

    public CustomerLogicItemBinder(ItemDecorator itemDecorator, ComponentLogicUnit componentLogicUnit) {
        super(itemDecorator);
        m14678a(componentLogicUnit);
    }

    public L getBinderLogic() {
        return this.f19806a;
    }

    /* renamed from: a */
    private void m14678a(ComponentLogicUnit componentLogicUnit) {
        L onCreateBinderLogic = onCreateBinderLogic();
        this.f19806a = onCreateBinderLogic;
        if (componentLogicUnit != null) {
            onCreateBinderLogic.attachLogicUnit(componentLogicUnit);
        }
    }
}
