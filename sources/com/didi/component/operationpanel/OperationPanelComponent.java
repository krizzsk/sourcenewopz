package com.didi.component.operationpanel;

import android.view.ViewGroup;
import com.didi.component.ComponentBinder;
import com.didi.component.business.xpanel.sdk.component.SelfControlComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.common.config.GlobalComponentConfig;
import com.didi.component.core.ComponentParams;
import com.didi.component.operationpanel.impl.newui.presenter.GlobalOnTripOperationPanelPresenterV2;
import com.didi.component.operationpanel.impl.newui.view.OperationPanelViewV2;
import com.didiglobal.passenger.aus.component.newui.AusOnTripOperationPanelPresenterV2;
import com.didiglobal.passenger.brz.component.newui.BrzOnTripOperationPanelPresenterV2;
import com.didiglobal.passenger.mex.component.newui.MexOnTripOperationPanelPresenterV2;
import com.didiglobal.passenger.rus.component.newui.RusOnTripOperationPanelPresenterV2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.runtime.reflect.Factory;

@ComponentRegister(product = "ride", type = "operation_panel")
public class OperationPanelComponent extends SelfControlComponent<IOperationPanelView, AbsOperationPanelPresenter, C6388a> {
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_0;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("OperationPanelComponent.java", OperationPanelComponent.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("4", "onCreatePresenter", "com.didi.component.operationpanel.OperationPanelComponent", "com.didi.component.core.ComponentParams", "params", "", "com.didi.component.operationpanel.AbsOperationPanelPresenter"), 31);
    }

    /* access modifiers changed from: protected */
    public AbsOperationPanelPresenter onCreatePresenter(ComponentParams componentParams) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_0, (Object) this, (Object) this, (Object) componentParams);
        return (AbsOperationPanelPresenter) onCreatePresenter_aroundBody1$advice(this, componentParams, makeJP, ComponentBinder.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    /* access modifiers changed from: protected */
    public IOperationPanelView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new OperationPanelViewV2(componentParams.bizCtx.getContext(), viewGroup);
    }

    private static final /* synthetic */ AbsOperationPanelPresenter onCreatePresenter_aroundBody0(OperationPanelComponent operationPanelComponent, ComponentParams componentParams, JoinPoint joinPoint) {
        if (componentParams.pageID == 1040) {
            return new GlobalOnTripOperationPanelPresenterV2(componentParams);
        }
        return null;
    }

    private static final /* synthetic */ Object onCreatePresenter_aroundBody1$advice(OperationPanelComponent operationPanelComponent, ComponentParams componentParams, JoinPoint joinPoint, ComponentBinder componentBinder, ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        if (args == null) {
            return null;
        }
        ComponentParams componentParams2 = (ComponentParams) args[0];
        if (GlobalComponentConfig.AUS_COMMON.equals(componentParams2.psid) && componentParams2.versionCode >= 2 && componentParams2.versionCode <= 10 && 1040 == componentParams2.scene) {
            return new AusOnTripOperationPanelPresenterV2(componentParams2);
        }
        if (GlobalComponentConfig.BRAZIL_COMMON.equals(componentParams2.psid) && componentParams2.versionCode >= 2 && componentParams2.versionCode <= 10 && 1040 == componentParams2.scene) {
            return new BrzOnTripOperationPanelPresenterV2(componentParams2);
        }
        if (GlobalComponentConfig.MEXICO_COMMON.equals(componentParams2.psid) && componentParams2.versionCode >= 2 && componentParams2.versionCode <= 10 && 1040 == componentParams2.scene) {
            return new MexOnTripOperationPanelPresenterV2(componentParams2);
        }
        if (GlobalComponentConfig.RUSSIA_COMMON.equals(componentParams2.psid) && componentParams2.versionCode >= 2 && componentParams2.versionCode <= 10 && 1040 == componentParams2.scene) {
            return new RusOnTripOperationPanelPresenterV2(componentParams2);
        }
        try {
            return onCreatePresenter_aroundBody0(operationPanelComponent, componentParams, proceedingJoinPoint);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public C6388a createInflateController() {
        return new C6388a();
    }
}
