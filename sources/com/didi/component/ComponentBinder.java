package com.didi.component;

import com.didi.carpool.countrydiff.brz.BrzCarPoolOnServicePresenter;
import com.didi.carpool.countrydiff.mex.MexCarPoolOnServicePresenter;
import com.didi.carpool.onservice.CarPoolOnServiceMapFlowDelegatePresenter;
import com.didi.carpool.onservice.CarPoolOnServicePresenter;
import com.didi.carpool.onservice.CarPoolOnServiceSafeToolkitPresenter;
import com.didi.carpool.waitrsp.CarPoolWaitRspServicePresenter;
import com.didi.component.common.config.GlobalComponentConfig;
import com.didi.component.core.ComponentParams;
import com.didiglobal.passenger.aus.component.AusEndServicePresenter;
import com.didiglobal.passenger.aus.component.AusPhoneEntrancePresenter;
import com.didiglobal.passenger.aus.component.AusWaitRspServicePresenter;
import com.didiglobal.passenger.aus.component.newui.AusOnTripOperationPanelPresenterV2;
import com.didiglobal.passenger.brz.component.BrzConfirmServicePresenter;
import com.didiglobal.passenger.brz.component.BrzGroupFormPresenter;
import com.didiglobal.passenger.brz.component.BrzOnServicePresenter;
import com.didiglobal.passenger.brz.component.BrzPayWayPresenter;
import com.didiglobal.passenger.brz.component.newui.BrzOnTripOperationPanelPresenterV2;
import com.didiglobal.passenger.mex.component.MexConfirmServicePresenter;
import com.didiglobal.passenger.mex.component.MexGroupFormPresenter;
import com.didiglobal.passenger.mex.component.MexOnServicePresenter;
import com.didiglobal.passenger.mex.component.MexPayWayPresenter;
import com.didiglobal.passenger.mex.component.newui.MexOnTripOperationPanelPresenterV2;
import com.didiglobal.passenger.rus.component.newui.RusOnTripOperationPanelPresenterV2;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ComponentBinder {

    /* renamed from: a */
    private static /* synthetic */ Throwable f10970a;
    public static /* synthetic */ ComponentBinder ajc$perSingletonInstance;

    static {
        try {
            ajc$perSingletonInstance = new ComponentBinder();
        } catch (Throwable th) {
            f10970a = th;
        }
    }

    public static ComponentBinder aspectOf() {
        ComponentBinder componentBinder = ajc$perSingletonInstance;
        if (componentBinder != null) {
            return componentBinder;
        }
        throw new NoAspectBoundException("com.didi.component.ComponentBinder", f10970a);
    }

    public static boolean hasAspect() {
        return ajc$perSingletonInstance != null;
    }

    @Around("execution(* com.didi.component.operationpanel.OperationPanelComponent.onCreatePresenter(..))")
    public Object OperationPanelComponent_onCreatePresenter(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        if (args == null) {
            return null;
        }
        ComponentParams componentParams = (ComponentParams) args[0];
        if (GlobalComponentConfig.AUS_COMMON.equals(componentParams.psid) && componentParams.versionCode >= 2 && componentParams.versionCode <= 10 && 1040 == componentParams.scene) {
            return new AusOnTripOperationPanelPresenterV2(componentParams);
        }
        if (GlobalComponentConfig.BRAZIL_COMMON.equals(componentParams.psid) && componentParams.versionCode >= 2 && componentParams.versionCode <= 10 && 1040 == componentParams.scene) {
            return new BrzOnTripOperationPanelPresenterV2(componentParams);
        }
        if (GlobalComponentConfig.MEXICO_COMMON.equals(componentParams.psid) && componentParams.versionCode >= 2 && componentParams.versionCode <= 10 && 1040 == componentParams.scene) {
            return new MexOnTripOperationPanelPresenterV2(componentParams);
        }
        if (GlobalComponentConfig.RUSSIA_COMMON.equals(componentParams.psid) && componentParams.versionCode >= 2 && componentParams.versionCode <= 10 && 1040 == componentParams.scene) {
            return new RusOnTripOperationPanelPresenterV2(componentParams);
        }
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Around("execution(* com.didi.component.service.ServiceComponent.onCreatePresenter(..))")
    public Object ServiceComponent_onCreatePresenter(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        if (args == null) {
            return null;
        }
        ComponentParams componentParams = (ComponentParams) args[0];
        if (4 == componentParams.comboType && GlobalComponentConfig.BRAZIL_COMMON.equals(componentParams.psid) && componentParams.versionCode >= 0 && componentParams.versionCode <= 10) {
            if (1010 == componentParams.scene) {
                return new BrzCarPoolOnServicePresenter(componentParams);
            }
            if (10402 == componentParams.scene) {
                return new BrzCarPoolOnServicePresenter(componentParams);
            }
        }
        if (4 == componentParams.comboType && GlobalComponentConfig.MEXICO_COMMON.equals(componentParams.psid) && componentParams.versionCode >= 0 && componentParams.versionCode <= 10) {
            if (1010 == componentParams.scene) {
                return new MexCarPoolOnServicePresenter(componentParams);
            }
            if (10402 == componentParams.scene) {
                return new MexCarPoolOnServicePresenter(componentParams);
            }
        }
        if (4 == componentParams.comboType && componentParams.versionCode >= 0 && componentParams.versionCode <= 100) {
            if (1010 == componentParams.scene) {
                return new CarPoolOnServicePresenter(componentParams);
            }
            if (10402 == componentParams.scene) {
                return new CarPoolOnServicePresenter(componentParams);
            }
        }
        if (4 == componentParams.comboType && componentParams.versionCode >= 0 && componentParams.versionCode <= 10) {
            if (1005 == componentParams.scene) {
                return new CarPoolWaitRspServicePresenter(componentParams);
            }
            if (10401 == componentParams.scene) {
                return new CarPoolWaitRspServicePresenter(componentParams);
            }
        }
        if (GlobalComponentConfig.AUS_COMMON.equals(componentParams.psid) && componentParams.versionCode >= 0 && componentParams.versionCode <= 10) {
            if (1015 == componentParams.scene) {
                return new AusEndServicePresenter(componentParams);
            }
            if (10403 == componentParams.scene) {
                return new AusEndServicePresenter(componentParams);
            }
        }
        if (GlobalComponentConfig.AUS_COMMON.equals(componentParams.psid) && componentParams.versionCode >= 0 && componentParams.versionCode <= 10) {
            if (1005 == componentParams.scene) {
                return new AusWaitRspServicePresenter(componentParams);
            }
            if (10401 == componentParams.scene) {
                return new AusWaitRspServicePresenter(componentParams);
            }
        }
        if (GlobalComponentConfig.BRAZIL_COMMON.equals(componentParams.psid) && componentParams.versionCode >= 0 && componentParams.versionCode <= 10 && 1030 == componentParams.scene) {
            return new BrzConfirmServicePresenter(componentParams);
        }
        if (GlobalComponentConfig.BRAZIL_COMMON.equals(componentParams.psid) && componentParams.versionCode >= 0 && componentParams.versionCode <= 10) {
            if (1010 == componentParams.scene) {
                return new BrzOnServicePresenter(componentParams);
            }
            if (10402 == componentParams.scene) {
                return new BrzOnServicePresenter(componentParams);
            }
        }
        if (GlobalComponentConfig.MEXICO_COMMON.equals(componentParams.psid) && componentParams.versionCode >= 0 && componentParams.versionCode <= 10 && 1030 == componentParams.scene) {
            return new MexConfirmServicePresenter(componentParams);
        }
        if (GlobalComponentConfig.MEXICO_COMMON.equals(componentParams.psid) && componentParams.versionCode >= 0 && componentParams.versionCode <= 10) {
            if (1010 == componentParams.scene) {
                return new MexOnServicePresenter(componentParams);
            }
            if (10402 == componentParams.scene) {
                return new MexOnServicePresenter(componentParams);
            }
        }
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Around("execution(* com.didi.component.mapflow.MapFlowComponent.onCreatePresenter(..))")
    public Object MapFlowComponent_onCreatePresenter(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        if (args == null) {
            return null;
        }
        ComponentParams componentParams = (ComponentParams) args[0];
        if (4 == componentParams.comboType && componentParams.versionCode >= 0 && componentParams.versionCode <= 100) {
            if (1010 == componentParams.scene) {
                return new CarPoolOnServiceMapFlowDelegatePresenter(componentParams);
            }
            if (10402 == componentParams.scene) {
                return new CarPoolOnServiceMapFlowDelegatePresenter(componentParams);
            }
        }
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Around("execution(* com.didi.component.phoneentrance.PhoneEntranceComponent.onCreatePresenter(..))")
    public Object PhoneEntranceComponent_onCreatePresenter(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        if (args == null) {
            return null;
        }
        ComponentParams componentParams = (ComponentParams) args[0];
        if (GlobalComponentConfig.AUS_COMMON.equals(componentParams.psid) && componentParams.versionCode >= 0 && componentParams.versionCode <= 10) {
            if (1010 == componentParams.scene) {
                return new AusPhoneEntrancePresenter(componentParams);
            }
            if (1015 == componentParams.scene) {
                return new AusPhoneEntrancePresenter(componentParams);
            }
            if (10402 == componentParams.scene) {
                return new AusPhoneEntrancePresenter(componentParams);
            }
            if (10403 == componentParams.scene) {
                return new AusPhoneEntrancePresenter(componentParams);
            }
        }
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Around("execution(* com.didi.component.payway.PayWayComponent.onCreatePresenter(..))")
    public Object PayWayComponent_onCreatePresenter(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        if (args == null) {
            return null;
        }
        ComponentParams componentParams = (ComponentParams) args[0];
        if (GlobalComponentConfig.BRAZIL_COMMON.equals(componentParams.psid) && componentParams.versionCode >= 0 && componentParams.versionCode <= 10 && 1030 == componentParams.scene) {
            return new BrzPayWayPresenter(componentParams);
        }
        if (GlobalComponentConfig.MEXICO_COMMON.equals(componentParams.psid) && componentParams.versionCode >= 0 && componentParams.versionCode <= 10 && 1030 == componentParams.scene) {
            return new MexPayWayPresenter(componentParams);
        }
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Around("execution(* com.didi.component.groupform.GroupFormComponent.onCreatePresenter(..))")
    public Object GroupFormComponent_onCreatePresenter(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        if (args == null) {
            return null;
        }
        ComponentParams componentParams = (ComponentParams) args[0];
        if (GlobalComponentConfig.BRAZIL_COMMON.equals(componentParams.psid) && componentParams.versionCode >= 0 && componentParams.versionCode <= 10 && 1030 == componentParams.scene) {
            return new BrzGroupFormPresenter(componentParams);
        }
        if (GlobalComponentConfig.MEXICO_COMMON.equals(componentParams.psid) && componentParams.versionCode >= 0 && componentParams.versionCode <= 10 && 1030 == componentParams.scene) {
            return new MexGroupFormPresenter(componentParams);
        }
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Around("execution(* com.didi.component.safetoolkit.GlobalSafeTookKitComponent.onCreatePresenter(..))")
    public Object GlobalSafeTookKitComponent_onCreatePresenter(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        if (args == null) {
            return null;
        }
        ComponentParams componentParams = (ComponentParams) args[0];
        if (4 == componentParams.comboType && componentParams.versionCode >= 0 && componentParams.versionCode <= 10) {
            if (1010 == componentParams.scene) {
                return new CarPoolOnServiceSafeToolkitPresenter(componentParams);
            }
            if (10402 == componentParams.scene) {
                return new CarPoolOnServiceSafeToolkitPresenter(componentParams);
            }
        }
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable unused) {
            return null;
        }
    }
}
