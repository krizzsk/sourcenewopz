package com.didi.soda.customer.base.binder.logic;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;

public abstract class BinderLogic<LogicRepo extends Repo> {
    private ComponentLogicUnit mLogicUnit;

    public abstract Class<LogicRepo> bindLogicRepoType();

    public final LogicRepo getLogicRepo() {
        ComponentLogicUnit componentLogicUnit = this.mLogicUnit;
        if (componentLogicUnit != null) {
            return componentLogicUnit.getLogic(bindLogicRepoType());
        }
        throw new IllegalStateException("If you call getLogicRepo in BinderLogic, mLogicUnit cannot be null!");
    }

    public void attachLogicUnit(ComponentLogicUnit componentLogicUnit) {
        this.mLogicUnit = componentLogicUnit;
    }
}
