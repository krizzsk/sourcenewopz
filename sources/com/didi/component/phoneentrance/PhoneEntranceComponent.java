package com.didi.component.phoneentrance;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.didi.component.ComponentBinder;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.common.config.GlobalComponentConfig;
import com.didi.component.core.ComponentParams;
import com.didi.component.phoneentrance.impl.PhoneEntrancePresenter;
import com.didi.component.phoneentrance.impl.PhoneEntranceV2View;
import com.didiglobal.passenger.aus.component.AusPhoneEntrancePresenter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.runtime.reflect.Factory;

@ComponentRegister(product = "ride", type = "phone_entrance")
public class PhoneEntranceComponent extends BaseComponent<IPhoneEntranceView, AbsPhoneEntrancePresenter> {
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_0;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("PhoneEntranceComponent.java", PhoneEntranceComponent.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("4", "onCreatePresenter", "com.didi.component.phoneentrance.PhoneEntranceComponent", "com.didi.component.core.ComponentParams", "params", "", "com.didi.component.phoneentrance.AbsPhoneEntrancePresenter"), 36);
    }

    /* access modifiers changed from: protected */
    public AbsPhoneEntrancePresenter onCreatePresenter(ComponentParams componentParams) {
        JoinPoint makeJP = Factory.makeJP(ajc$tjp_0, (Object) this, (Object) this, (Object) componentParams);
        return (AbsPhoneEntrancePresenter) onCreatePresenter_aroundBody1$advice(this, componentParams, makeJP, ComponentBinder.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    /* access modifiers changed from: protected */
    public IPhoneEntranceView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        String str = (String) componentParams.getExtra("source");
        if (TextUtils.isEmpty(str)) {
            str = "small";
        }
        return new PhoneEntranceV2View(componentParams.bizCtx.getContext(), viewGroup, !"small".equals(str));
    }

    private static final /* synthetic */ AbsPhoneEntrancePresenter onCreatePresenter_aroundBody0(PhoneEntranceComponent phoneEntranceComponent, ComponentParams componentParams, JoinPoint joinPoint) {
        return new PhoneEntrancePresenter(componentParams);
    }

    /* access modifiers changed from: protected */
    public void bind(ComponentParams componentParams, IPhoneEntranceView iPhoneEntranceView, AbsPhoneEntrancePresenter absPhoneEntrancePresenter) {
        super.bind(componentParams, iPhoneEntranceView, absPhoneEntrancePresenter);
        iPhoneEntranceView.setOnPhoneEntranceClickListener(absPhoneEntrancePresenter);
    }

    private static final /* synthetic */ Object onCreatePresenter_aroundBody1$advice(PhoneEntranceComponent phoneEntranceComponent, ComponentParams componentParams, JoinPoint joinPoint, ComponentBinder componentBinder, ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        if (args == null) {
            return null;
        }
        ComponentParams componentParams2 = (ComponentParams) args[0];
        if (GlobalComponentConfig.AUS_COMMON.equals(componentParams2.psid) && componentParams2.versionCode >= 0 && componentParams2.versionCode <= 10) {
            if (1010 == componentParams2.scene) {
                return new AusPhoneEntrancePresenter(componentParams2);
            }
            if (1015 == componentParams2.scene) {
                return new AusPhoneEntrancePresenter(componentParams2);
            }
            if (10402 == componentParams2.scene) {
                return new AusPhoneEntrancePresenter(componentParams2);
            }
            if (10403 == componentParams2.scene) {
                return new AusPhoneEntrancePresenter(componentParams2);
            }
        }
        try {
            return onCreatePresenter_aroundBody0(phoneEntranceComponent, componentParams, proceedingJoinPoint);
        } catch (Throwable unused) {
            return null;
        }
    }
}
