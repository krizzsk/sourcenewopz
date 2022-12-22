package com.didi.component.mapflow;

import android.view.ViewGroup;
import com.didi.carpool.onservice.CarPoolOnServiceMapFlowDelegatePresenter;
import com.didi.component.ComponentBinder;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.mapflow.newpresenter.ConfirmMapFlowDelegateNewPresenter;
import com.didi.component.mapflow.newpresenter.ConfirmMapFlowDelegateUpdateAddressNewPresenter;
import com.didi.component.mapflow.newpresenter.OnServiceMapFlowDelegateNewPresenter;
import com.didi.component.mapflow.presenter.AbsMapFlowDelegatePresenter;
import com.didi.component.mapflow.presenter.EndMapFlowDelegatePresenter;
import com.didi.component.mapflow.presenter.HomeMapFlowDelegatePresenter;
import com.didi.component.mapflow.presenter.LockScreenMapFlowDelegatePresenter;
import com.didi.component.mapflow.presenter.WaitRspMapFlowDelegateNewPresenter;
import com.didi.component.mapflow.view.IMapFlowDelegateView;
import com.didi.component.mapflow.view.MapFlowDelegateView;
import com.didi.map.global.flow.MapFlowView;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.runtime.reflect.Factory;

@ComponentRegister(product = "ride", type = "map_flow")
public class MapFlowComponent extends BaseComponent<IMapFlowDelegateView, AbsMapFlowDelegatePresenter> {
    public static final String SUG_PAGE_CONTAINER_ID = "containerId";
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_0;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("MapFlowComponent.java", MapFlowComponent.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("4", "onCreatePresenter", "com.didi.component.mapflow.MapFlowComponent", "com.didi.component.core.ComponentParams", "params", "", "com.didi.component.mapflow.presenter.AbsMapFlowDelegatePresenter"), 48);
    }

    /* access modifiers changed from: protected */
    public AbsMapFlowDelegatePresenter onCreatePresenter(ComponentParams componentParams) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_0, (Object) this, (Object) this, (Object) componentParams);
        return (AbsMapFlowDelegatePresenter) onCreatePresenter_aroundBody1$advice(this, componentParams, makeJP, ComponentBinder.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    /* access modifiers changed from: protected */
    public IMapFlowDelegateView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        MapFlowView mapFlowView;
        if (componentParams.pageID == 1045) {
            mapFlowView = componentParams.bizCtx.getLockScreenMapFlowView();
        } else {
            mapFlowView = componentParams.bizCtx.getMapFlowView();
        }
        return new MapFlowDelegateView(componentParams.bizCtx.getContext(), mapFlowView);
    }

    /* access modifiers changed from: private */
    public AbsMapFlowDelegatePresenter createPresenter(ComponentParams componentParams) {
        int i = componentParams.pageID;
        if (i == 1001) {
            return new HomeMapFlowDelegatePresenter(componentParams);
        }
        if (i == 1030) {
            return new ConfirmMapFlowDelegateNewPresenter(componentParams);
        }
        if (i == 1035) {
            return new ConfirmMapFlowDelegateUpdateAddressNewPresenter(componentParams);
        }
        if (i == 1040) {
            int i2 = componentParams.scene;
            if (i2 == 10401) {
                return new WaitRspMapFlowDelegateNewPresenter(componentParams);
            }
            if (i2 != 10402) {
                return new EndMapFlowDelegatePresenter(componentParams);
            }
            return new OnServiceMapFlowDelegateNewPresenter(componentParams);
        } else if (i == 1045) {
            return new LockScreenMapFlowDelegatePresenter(componentParams);
        } else {
            return new EndMapFlowDelegatePresenter(componentParams);
        }
    }

    private static final /* synthetic */ Object onCreatePresenter_aroundBody1$advice(MapFlowComponent mapFlowComponent, ComponentParams componentParams, JoinPoint joinPoint, ComponentBinder componentBinder, ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        if (args == null) {
            return null;
        }
        ComponentParams componentParams2 = (ComponentParams) args[0];
        if (4 == componentParams2.comboType && componentParams2.versionCode >= 0 && componentParams2.versionCode <= 100) {
            if (1010 == componentParams2.scene) {
                return new CarPoolOnServiceMapFlowDelegatePresenter(componentParams2);
            }
            if (10402 == componentParams2.scene) {
                return new CarPoolOnServiceMapFlowDelegatePresenter(componentParams2);
            }
        }
        try {
            return mapFlowComponent.createPresenter(componentParams);
        } catch (Throwable unused) {
            return null;
        }
    }
}
