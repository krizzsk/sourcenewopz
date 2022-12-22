package com.didi.component.payway;

import android.view.ViewGroup;
import com.didi.component.ComponentBinder;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.common.config.GlobalComponentConfig;
import com.didi.component.core.ComponentParams;
import com.didi.component.payway.presenter.AbsPayWayPresenter;
import com.didi.component.payway.presenter.PayWayPresenter;
import com.didi.component.payway.view.IPayWayView;
import com.didi.component.payway.view.PayWayView;
import com.didiglobal.passenger.brz.component.BrzPayWayPresenter;
import com.didiglobal.passenger.mex.component.MexPayWayPresenter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.runtime.reflect.Factory;

@ComponentRegister(product = "ride", type = "payway")
public class PayWayComponent extends BaseComponent<IPayWayView, AbsPayWayPresenter> {
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_0;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("PayWayComponent.java", PayWayComponent.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("4", "onCreatePresenter", "com.didi.component.payway.PayWayComponent", "com.didi.component.core.ComponentParams", "params", "", "com.didi.component.payway.presenter.AbsPayWayPresenter"), 30);
    }

    /* access modifiers changed from: protected */
    public AbsPayWayPresenter onCreatePresenter(ComponentParams componentParams) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_0, (Object) this, (Object) this, (Object) componentParams);
        return (AbsPayWayPresenter) onCreatePresenter_aroundBody1$advice(this, componentParams, makeJP, ComponentBinder.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    /* access modifiers changed from: protected */
    public IPayWayView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new PayWayView(componentParams, viewGroup);
    }

    private static final /* synthetic */ AbsPayWayPresenter onCreatePresenter_aroundBody0(PayWayComponent payWayComponent, ComponentParams componentParams, JoinPoint joinPoint) {
        return new PayWayPresenter(componentParams);
    }

    private static final /* synthetic */ Object onCreatePresenter_aroundBody1$advice(PayWayComponent payWayComponent, ComponentParams componentParams, JoinPoint joinPoint, ComponentBinder componentBinder, ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        if (args == null) {
            return null;
        }
        ComponentParams componentParams2 = (ComponentParams) args[0];
        if (GlobalComponentConfig.BRAZIL_COMMON.equals(componentParams2.psid) && componentParams2.versionCode >= 0 && componentParams2.versionCode <= 10 && 1030 == componentParams2.scene) {
            return new BrzPayWayPresenter(componentParams2);
        }
        if (GlobalComponentConfig.MEXICO_COMMON.equals(componentParams2.psid) && componentParams2.versionCode >= 0 && componentParams2.versionCode <= 10 && 1030 == componentParams2.scene) {
            return new MexPayWayPresenter(componentParams2);
        }
        try {
            return onCreatePresenter_aroundBody0(payWayComponent, componentParams, proceedingJoinPoint);
        } catch (Throwable unused) {
            return null;
        }
    }
}
