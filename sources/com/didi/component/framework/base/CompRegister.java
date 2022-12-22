package com.didi.component.framework.base;

import com.didi.app.delegate.CompRegisterDelegate;
import com.didi.component.core.IPresenter;
import com.didi.component.framework.template.confirm.ConfirmTemplateFragment;
import com.didi.component.framework.template.home.HomeTemplateFragment;
import com.didi.component.framework.template.trip.TripTemplateFragment;
import com.didi.component.framework.template.updatepickup.UpdatePickUpTemplateFragment;
import com.didi.component.home_exception.HomeExceptionComponent;
import com.didi.component_processor.annonation.ModuleMap;

final class CompRegister {
    CompRegister() {
    }

    static {
        loadStatic();
        registerAll();
    }

    private static void loadStatic() {
        IPresenter.templateMapping.put(1001, HomeTemplateFragment.class);
        IPresenter.templateMapping.put(1030, ConfirmTemplateFragment.class);
        IPresenter.templateMapping.put(1035, UpdatePickUpTemplateFragment.class);
        IPresenter.templateMapping.put(1040, TripTemplateFragment.class);
    }

    private static void registerAll() {
        CompRegisterDelegate.registerByProduct("ride");
        ModuleMap.addStandard("eevee_enable_location", HomeExceptionComponent.class);
    }
}
