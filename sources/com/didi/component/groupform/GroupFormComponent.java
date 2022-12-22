package com.didi.component.groupform;

import android.view.ViewGroup;
import com.didi.component.ComponentBinder;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.common.config.GlobalComponentConfig;
import com.didi.component.core.ComponentParams;
import com.didi.component.groupform.presenter.AbsGroupFormPresenter;
import com.didi.component.groupform.presenter.GroupFormPresenter;
import com.didi.component.groupform.view.GroupFormViewNewUI;
import com.didi.component.groupform.view.IGroupFormView;
import com.didiglobal.passenger.brz.component.BrzGroupFormPresenter;
import com.didiglobal.passenger.mex.component.MexGroupFormPresenter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.runtime.reflect.Factory;

@ComponentRegister(product = "ride", type = "group_form_container")
public class GroupFormComponent extends BaseComponent<IGroupFormView, AbsGroupFormPresenter> {
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_0;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("GroupFormComponent.java", GroupFormComponent.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("4", "onCreatePresenter", "com.didi.component.groupform.GroupFormComponent", "com.didi.component.core.ComponentParams", "params", "", "com.didi.component.groupform.presenter.AbsGroupFormPresenter"), 26);
    }

    /* access modifiers changed from: protected */
    public AbsGroupFormPresenter onCreatePresenter(ComponentParams componentParams) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_0, (Object) this, (Object) this, (Object) componentParams);
        return (AbsGroupFormPresenter) onCreatePresenter_aroundBody1$advice(this, componentParams, makeJP, ComponentBinder.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    private static final /* synthetic */ AbsGroupFormPresenter onCreatePresenter_aroundBody0(GroupFormComponent groupFormComponent, ComponentParams componentParams, JoinPoint joinPoint) {
        return new GroupFormPresenter(componentParams);
    }

    /* access modifiers changed from: protected */
    public IGroupFormView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new GroupFormViewNewUI(componentParams.bizCtx.getContext(), viewGroup);
    }

    private static final /* synthetic */ Object onCreatePresenter_aroundBody1$advice(GroupFormComponent groupFormComponent, ComponentParams componentParams, JoinPoint joinPoint, ComponentBinder componentBinder, ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        if (args == null) {
            return null;
        }
        ComponentParams componentParams2 = (ComponentParams) args[0];
        if (GlobalComponentConfig.BRAZIL_COMMON.equals(componentParams2.psid) && componentParams2.versionCode >= 0 && componentParams2.versionCode <= 10 && 1030 == componentParams2.scene) {
            return new BrzGroupFormPresenter(componentParams2);
        }
        if (GlobalComponentConfig.MEXICO_COMMON.equals(componentParams2.psid) && componentParams2.versionCode >= 0 && componentParams2.versionCode <= 10 && 1030 == componentParams2.scene) {
            return new MexGroupFormPresenter(componentParams2);
        }
        try {
            return onCreatePresenter_aroundBody0(groupFormComponent, componentParams, proceedingJoinPoint);
        } catch (Throwable unused) {
            return null;
        }
    }
}
