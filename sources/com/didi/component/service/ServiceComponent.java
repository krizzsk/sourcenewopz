package com.didi.component.service;

import android.view.ViewGroup;
import com.didi.carpool.countrydiff.brz.BrzCarPoolOnServicePresenter;
import com.didi.carpool.countrydiff.mex.MexCarPoolOnServicePresenter;
import com.didi.carpool.onservice.CarPoolOnServicePresenter;
import com.didi.carpool.waitrsp.CarPoolWaitRspServicePresenter;
import com.didi.component.ComponentBinder;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.common.config.GlobalComponentConfig;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IView;
import com.didiglobal.passenger.aus.component.AusEndServicePresenter;
import com.didiglobal.passenger.aus.component.AusWaitRspServicePresenter;
import com.didiglobal.passenger.brz.component.BrzConfirmServicePresenter;
import com.didiglobal.passenger.brz.component.BrzOnServicePresenter;
import com.didiglobal.passenger.mex.component.MexConfirmServicePresenter;
import com.didiglobal.passenger.mex.component.MexOnServicePresenter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.runtime.reflect.Factory;

@ComponentRegister(product = "ride", type = "service")
public class ServiceComponent extends BaseComponent<IView, AbsServicePresenter> {
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_0;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("ServiceComponent.java", ServiceComponent.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("4", "onCreatePresenter", "com.didi.component.service.ServiceComponent", "com.didi.component.core.ComponentParams", "params", "", "com.didi.component.service.AbsServicePresenter"), 29);
    }

    /* access modifiers changed from: protected */
    public AbsServicePresenter onCreatePresenter(ComponentParams componentParams) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_0, (Object) this, (Object) this, (Object) componentParams);
        return (AbsServicePresenter) onCreatePresenter_aroundBody1$advice(this, componentParams, makeJP, ComponentBinder.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    /* access modifiers changed from: protected */
    public IView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return null;
    }

    /* access modifiers changed from: private */
    public AbsServicePresenter createPresenterForPage(ComponentParams componentParams) {
        int i = componentParams.pageID;
        if (i == 1001) {
            return createPresenterForHome(componentParams);
        }
        if (i == 1030) {
            return createPresenterForConfirm(componentParams);
        }
        if (i == 1035) {
            return createPresenterForUpdatePickUp(componentParams);
        }
        if (i != 1040) {
            return null;
        }
        return createPresenterForTrip(componentParams);
    }

    private AbsServicePresenter createPresenterForHome(ComponentParams componentParams) {
        return new HomeServiceNewPresenter(componentParams);
    }

    private AbsServicePresenter createPresenterForConfirm(ComponentParams componentParams) {
        return new ConfirmServicePresenter(componentParams);
    }

    private AbsServicePresenter createPresenterForWaitRsp(ComponentParams componentParams) {
        return new WaitRspServicePresenter(componentParams);
    }

    private AbsServicePresenter createPresenterForOnService(ComponentParams componentParams) {
        return new OnServicePresenter(componentParams);
    }

    private AbsServicePresenter createPresenterForEndService(ComponentParams componentParams) {
        return new EndServicePresenter(componentParams);
    }

    private AbsServicePresenter createPresenterForUpdatePickUp(ComponentParams componentParams) {
        return new UpdatePickUpServicePresenter(componentParams);
    }

    private AbsServicePresenter createPresenterForTrip(ComponentParams componentParams) {
        int i = componentParams.scene;
        if (i == 10402) {
            return createPresenterForOnService(componentParams);
        }
        if (i != 10403) {
            return createPresenterForWaitRsp(componentParams);
        }
        return createPresenterForEndService(componentParams);
    }

    private static final /* synthetic */ Object onCreatePresenter_aroundBody1$advice(ServiceComponent serviceComponent, ComponentParams componentParams, JoinPoint joinPoint, ComponentBinder componentBinder, ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        if (args == null) {
            return null;
        }
        ComponentParams componentParams2 = (ComponentParams) args[0];
        if (4 == componentParams2.comboType && GlobalComponentConfig.BRAZIL_COMMON.equals(componentParams2.psid) && componentParams2.versionCode >= 0 && componentParams2.versionCode <= 10) {
            if (1010 == componentParams2.scene) {
                return new BrzCarPoolOnServicePresenter(componentParams2);
            }
            if (10402 == componentParams2.scene) {
                return new BrzCarPoolOnServicePresenter(componentParams2);
            }
        }
        if (4 == componentParams2.comboType && GlobalComponentConfig.MEXICO_COMMON.equals(componentParams2.psid) && componentParams2.versionCode >= 0 && componentParams2.versionCode <= 10) {
            if (1010 == componentParams2.scene) {
                return new MexCarPoolOnServicePresenter(componentParams2);
            }
            if (10402 == componentParams2.scene) {
                return new MexCarPoolOnServicePresenter(componentParams2);
            }
        }
        if (4 == componentParams2.comboType && componentParams2.versionCode >= 0 && componentParams2.versionCode <= 100) {
            if (1010 == componentParams2.scene) {
                return new CarPoolOnServicePresenter(componentParams2);
            }
            if (10402 == componentParams2.scene) {
                return new CarPoolOnServicePresenter(componentParams2);
            }
        }
        if (4 == componentParams2.comboType && componentParams2.versionCode >= 0 && componentParams2.versionCode <= 10) {
            if (1005 == componentParams2.scene) {
                return new CarPoolWaitRspServicePresenter(componentParams2);
            }
            if (10401 == componentParams2.scene) {
                return new CarPoolWaitRspServicePresenter(componentParams2);
            }
        }
        if (GlobalComponentConfig.AUS_COMMON.equals(componentParams2.psid) && componentParams2.versionCode >= 0 && componentParams2.versionCode <= 10) {
            if (1015 == componentParams2.scene) {
                return new AusEndServicePresenter(componentParams2);
            }
            if (10403 == componentParams2.scene) {
                return new AusEndServicePresenter(componentParams2);
            }
        }
        if (GlobalComponentConfig.AUS_COMMON.equals(componentParams2.psid) && componentParams2.versionCode >= 0 && componentParams2.versionCode <= 10) {
            if (1005 == componentParams2.scene) {
                return new AusWaitRspServicePresenter(componentParams2);
            }
            if (10401 == componentParams2.scene) {
                return new AusWaitRspServicePresenter(componentParams2);
            }
        }
        if (GlobalComponentConfig.BRAZIL_COMMON.equals(componentParams2.psid) && componentParams2.versionCode >= 0 && componentParams2.versionCode <= 10 && 1030 == componentParams2.scene) {
            return new BrzConfirmServicePresenter(componentParams2);
        }
        if (GlobalComponentConfig.BRAZIL_COMMON.equals(componentParams2.psid) && componentParams2.versionCode >= 0 && componentParams2.versionCode <= 10) {
            if (1010 == componentParams2.scene) {
                return new BrzOnServicePresenter(componentParams2);
            }
            if (10402 == componentParams2.scene) {
                return new BrzOnServicePresenter(componentParams2);
            }
        }
        if (GlobalComponentConfig.MEXICO_COMMON.equals(componentParams2.psid) && componentParams2.versionCode >= 0 && componentParams2.versionCode <= 10 && 1030 == componentParams2.scene) {
            return new MexConfirmServicePresenter(componentParams2);
        }
        if (GlobalComponentConfig.MEXICO_COMMON.equals(componentParams2.psid) && componentParams2.versionCode >= 0 && componentParams2.versionCode <= 10) {
            if (1010 == componentParams2.scene) {
                return new MexOnServicePresenter(componentParams2);
            }
            if (10402 == componentParams2.scene) {
                return new MexOnServicePresenter(componentParams2);
            }
        }
        try {
            return serviceComponent.createPresenterForPage(componentParams);
        } catch (Throwable unused) {
            return null;
        }
    }
}
